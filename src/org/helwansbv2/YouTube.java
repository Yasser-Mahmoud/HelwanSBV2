package org.helwansbv2;


import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.examples.youtubeapidemo.ui.FlippingView;
import com.examples.youtubeapidemo.ui.ImageWallView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class YouTube extends Fragment implements 
  FlippingView.Listener,
  YouTubePlayer.OnInitializedListener,
  YouTubeThumbnailView.OnInitializedListener {
	
	//private final Context mContext = getActivity().getBaseContext();
	
	private static final int RECOVERY_DIALOG_REQUEST = 1;

	  /** The player view cannot be smaller than 110 pixels high. */
	  private static final float PLAYER_VIEW_MINIMUM_HEIGHT_DP = 110;
	  private static final int MAX_NUMBER_OF_ROWS_WANTED = 4;

	  // Example playlist from which videos are displayed on the video wall
	  private static final String PLAYLIST_ID = "PLt59mSqdplNjCo7_LFFOTyJCf7NSxIGmA";

	  private static final int INTER_IMAGE_PADDING_DP = 5;

	  // YouTube thumbnails have a 16 / 9 aspect ratio
	  private static final double THUMBNAIL_ASPECT_RATIO = 16 / 9d;

	  private static final int INITIAL_FLIP_DURATION_MILLIS = 100;
	  private static final int FLIP_DURATION_MILLIS = 500;
	  private static final int FLIP_PERIOD_MILLIS = 2000;

	  private ImageWallView imageWallView;
	  private Handler flipDelayHandler;

	  private FlippingView flippingView;
	  private YouTubeThumbnailView thumbnailView;
	  private YouTubeThumbnailLoader thumbnailLoader;

	  private YouTubePlayerSupportFragment playerFragment;
	  private View playerView;
	  private YouTubePlayer player;

	  private Dialog errorDialog;

	  private int flippingCol;
	  private int flippingRow;
	  private int videoCol;
	  private int videoRow;

	  private boolean nextThumbnailLoaded;
	  private boolean activityResumed;
	  private State state;

	  private enum State {
	    UNINITIALIZED,
	    LOADING_THUMBNAILS,
	    VIDEO_FLIPPED_OUT,
	    VIDEO_LOADING,
	    VIDEO_CUED,
	    VIDEO_PLAYING,
	    VIDEO_ENDED,
	    VIDEO_BEING_FLIPPED_OUT,
	  }
	  
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    state = State.UNINITIALIZED;

	   

	  }

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		 ViewGroup viewFrame = new FrameLayout(getActivity().getBaseContext());

		    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
		    int maxAllowedNumberOfRows = (int) Math.floor(
		        (displayMetrics.heightPixels / displayMetrics.density) / PLAYER_VIEW_MINIMUM_HEIGHT_DP);
		    int numberOfRows = Math.min(maxAllowedNumberOfRows, MAX_NUMBER_OF_ROWS_WANTED);
		    int interImagePaddingPx = (int) displayMetrics.density * INTER_IMAGE_PADDING_DP;
		    int imageHeight = (displayMetrics.heightPixels / numberOfRows) - interImagePaddingPx;
		    int imageWidth = (int) (imageHeight * THUMBNAIL_ASPECT_RATIO);

		    imageWallView = new ImageWallView(getActivity().getBaseContext(), imageWidth, imageHeight, interImagePaddingPx);
		    viewFrame.addView(imageWallView, MATCH_PARENT, MATCH_PARENT);

		    thumbnailView = new YouTubeThumbnailView(getActivity().getBaseContext());
		    thumbnailView.initialize("AIzaSyDRao6R4Uh4nmjKaUqnno47-5czK1GZiDw", this);

		    flippingView = new FlippingView(getActivity().getBaseContext(), this, imageWidth, imageHeight);
		    flippingView.setFlipDuration(INITIAL_FLIP_DURATION_MILLIS);
		    viewFrame.addView(flippingView, imageWidth, imageHeight);

		    playerView = new FrameLayout(getActivity().getBaseContext());
		    playerView.setId(R.id.player_view);
		    playerView.setVisibility(View.INVISIBLE);
		    viewFrame.addView(playerView, imageWidth, imageHeight);

		    playerFragment = YouTubePlayerSupportFragment.newInstance();
		    playerFragment.initialize("AIzaSyDRao6R4Uh4nmjKaUqnno47-5czK1GZiDw", this);
		    getFragmentManager().beginTransaction().add(R.id.player_view, playerFragment).commit();

		    flipDelayHandler = new FlipDelayHandler();
 
        //View rootView = inflater.inflate(R.id.player_view, container, false);
         
        return viewFrame;
    }
	
	 @Override
	  public void onInitializationSuccess(YouTubeThumbnailView thumbnailView,
	      YouTubeThumbnailLoader thumbnailLoader) {
	    this.thumbnailLoader = thumbnailLoader;
	    thumbnailLoader.setOnThumbnailLoadedListener(new ThumbnailListener());
	    maybeStartDemo();
	  }
	 
	 @Override
	  public void onInitializationFailure(
	      YouTubeThumbnailView thumbnailView, YouTubeInitializationResult errorReason) {
	    if (errorReason.isUserRecoverableError()) {
	      if (errorDialog == null || !errorDialog.isShowing()) {
	        errorDialog = errorReason.getErrorDialog(getActivity(), RECOVERY_DIALOG_REQUEST);
	        errorDialog.show();
	      }
	    } else {
	      String errorMessage =
	          String.format(getString(R.string.error_thumbnail_view), errorReason.toString());
	      Toast.makeText(getActivity().getBaseContext(), errorMessage, Toast.LENGTH_LONG).show();
	    }
	  }
	 
	 @Override
	  public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
	      boolean wasResumed) {
	    YouTube.this.player = player;
	    player.setPlayerStyle(PlayerStyle.CHROMELESS);
	    player.setPlayerStateChangeListener(new VideoListener());
	    maybeStartDemo();
	  }
	 
	 @Override
	  public void onInitializationFailure(
	      YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
	    if (errorReason.isUserRecoverableError()) {
	      if (errorDialog == null || !errorDialog.isShowing()) {
	        errorDialog = errorReason.getErrorDialog(getActivity(), RECOVERY_DIALOG_REQUEST);
	        errorDialog.show();
	      }
	    } else {
	      String errorMessage = String.format(getString(R.string.error_player), errorReason.toString());
	      Toast.makeText(getActivity().getBaseContext(), errorMessage, Toast.LENGTH_LONG).show();
	    }
	  }
	 
	 @Override
	 public void onResume() {
	    super.onResume();
	    activityResumed = true;
	    if (thumbnailLoader != null && player != null) {
	      if (state.equals(State.UNINITIALIZED)) {
	        maybeStartDemo();
	      } else if (state.equals(State.LOADING_THUMBNAILS)) {
	        loadNextThumbnail();
	      } else {
	        if (state.equals(State.VIDEO_PLAYING)) {
	          player.play();
	        }
	        flipDelayHandler.sendEmptyMessageDelayed(0, FLIP_DURATION_MILLIS);
	      }
	    }
	  }
	 
	 @Override
	  public void onPause() {
	    flipDelayHandler.removeCallbacksAndMessages(null);
	    activityResumed = false;
	    super.onPause();
	  }

	  @Override
	  public void onDestroy() {
	    if (thumbnailLoader != null) {
	      thumbnailLoader.release();
	    }
	    super.onDestroy();
	  }
	 
	 private void maybeStartDemo() {
		    if (activityResumed && player != null && thumbnailLoader != null
		        && state.equals(State.UNINITIALIZED)) {
		      thumbnailLoader.setPlaylist(PLAYLIST_ID); // loading the first thumbnail will kick off demo
		      state = State.LOADING_THUMBNAILS;
		    }
		  }
	
	/**
	   * A handler that periodically flips an element on the video wall.
	   */
	  private final class FlipDelayHandler extends Handler {

	    @Override
	    public void handleMessage(Message msg) {
	      flipNext();
	      sendEmptyMessageDelayed(0, FLIP_PERIOD_MILLIS);
	    }

	  }
	  
	  private void flipNext() {
		    if (!nextThumbnailLoaded || state.equals(State.VIDEO_LOADING)) {
		      return;
		    }

		    if (state.equals(State.VIDEO_ENDED)) {
		      flippingCol = videoCol;
		      flippingRow = videoRow;
		      state = State.VIDEO_BEING_FLIPPED_OUT;
		    } else {
		      Pair<Integer, Integer> nextTarget = imageWallView.getNextLoadTarget();
		      flippingCol = nextTarget.first;
		      flippingRow = nextTarget.second;
		    }

		    flippingView.setX(imageWallView.getXPosition(flippingCol, flippingRow));
		    flippingView.setY(imageWallView.getYPosition(flippingCol, flippingRow));
		    flippingView.setFlipInDrawable(thumbnailView.getDrawable());
		    flippingView.setFlipOutDrawable(imageWallView.getImageDrawable(flippingCol, flippingRow));
		    imageWallView.setImageDrawable(flippingCol, flippingRow, thumbnailView.getDrawable());
		    imageWallView.hideImage(flippingCol, flippingRow);
		    flippingView.setVisibility(View.VISIBLE);
		    flippingView.flip();
		  }

	  @Override
	  public void onFlipped(FlippingView view) {
	    imageWallView.showImage(flippingCol, flippingRow);
	    flippingView.setVisibility(View.INVISIBLE);

	    if (activityResumed) {
	      loadNextThumbnail();

	      if (state.equals(State.VIDEO_BEING_FLIPPED_OUT)) {
	        state = State.VIDEO_FLIPPED_OUT;
	      } else if (state.equals(State.VIDEO_CUED)) {
	        videoCol = flippingCol;
	        videoRow = flippingRow;
	        playerView.setX(imageWallView.getXPosition(flippingCol, flippingRow));
	        playerView.setY(imageWallView.getYPosition(flippingCol, flippingRow));
	        imageWallView.hideImage(flippingCol, flippingRow);
	        playerView.setVisibility(View.VISIBLE);
	        player.play();
	        state = State.VIDEO_PLAYING;
	      } else if (state.equals(State.LOADING_THUMBNAILS) && imageWallView.allImagesLoaded()) {
	        state = State.VIDEO_FLIPPED_OUT; // trigger flip in of an initial video
	        flippingView.setFlipDuration(FLIP_DURATION_MILLIS);
	        flipDelayHandler.sendEmptyMessage(0);
	      }
	    }
	  }
	  
	  private void loadNextThumbnail() {
		    nextThumbnailLoaded = false;
		    if (thumbnailLoader.hasNext()) {
		      thumbnailLoader.next();
		    } else {
		      thumbnailLoader.first();
		    }
		  }
	  
	  /**
	   * An internal listener which listens to thumbnail loading events from the
	   * {@link YouTubeThumbnailView}.
	   */
	  private final class ThumbnailListener implements
	      YouTubeThumbnailLoader.OnThumbnailLoadedListener {

	    @Override
	    public void onThumbnailLoaded(YouTubeThumbnailView thumbnail, String videoId) {
	      nextThumbnailLoaded = true;

	      if (activityResumed) {
	        if (state.equals(State.LOADING_THUMBNAILS)) {
	          flipNext();
	        } else if (state.equals(State.VIDEO_FLIPPED_OUT)) {
	          // load player with the video of the next thumbnail being flipped in
	          state = State.VIDEO_LOADING;
	          player.cueVideo(videoId);
	        }
	      }
	    }

	    @Override
	    public void onThumbnailError(YouTubeThumbnailView thumbnail,
	        YouTubeThumbnailLoader.ErrorReason reason) {
	      loadNextThumbnail();
	    }

	  }
	  
	  private final class VideoListener implements YouTubePlayer.PlayerStateChangeListener {

		    @Override
		    public void onLoaded(String videoId) {
		      state = State.VIDEO_CUED;
		    }

		    @Override
		    public void onVideoEnded() {
		      state = State.VIDEO_ENDED;
		      imageWallView.showImage(videoCol, videoRow);
		      playerView.setVisibility(View.INVISIBLE);
		    }

		    @Override
		    public void onError(YouTubePlayer.ErrorReason errorReason) {
		      if (errorReason == YouTubePlayer.ErrorReason.UNEXPECTED_SERVICE_DISCONNECTION) {
		        // player has encountered an unrecoverable error - stop the demo
		        flipDelayHandler.removeCallbacksAndMessages(null);
		        state = State.UNINITIALIZED;
		        thumbnailLoader.release();
		        thumbnailLoader = null;
		        player = null;
		      } else {
		        state = State.VIDEO_ENDED;
		      }
		    }
		    
		 // ignored callbacks

		    @Override
		    public void onVideoStarted() { }

		    @Override
		    public void onAdStarted() { }

		    @Override
		    public void onLoading() { }

		  }
}
