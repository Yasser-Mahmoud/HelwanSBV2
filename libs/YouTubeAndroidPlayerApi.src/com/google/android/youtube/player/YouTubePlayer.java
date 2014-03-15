package com.google.android.youtube.player;

import java.util.List;

public abstract interface YouTubePlayer
{
  public static final int FULLSCREEN_FLAG_CONTROL_ORIENTATION = 1;
  public static final int FULLSCREEN_FLAG_CONTROL_SYSTEM_UI = 2;
  public static final int FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE = 4;
  public static final int FULLSCREEN_FLAG_CUSTOM_LAYOUT = 8;
  
  public abstract void release();
  
  public abstract void cueVideo(String paramString);
  
  public abstract void cueVideo(String paramString, int paramInt);
  
  public abstract void loadVideo(String paramString);
  
  public abstract void loadVideo(String paramString, int paramInt);
  
  public abstract void cuePlaylist(String paramString);
  
  public abstract void cuePlaylist(String paramString, int paramInt1, int paramInt2);
  
  public abstract void loadPlaylist(String paramString);
  
  public abstract void loadPlaylist(String paramString, int paramInt1, int paramInt2);
  
  public abstract void cueVideos(List<String> paramList);
  
  public abstract void cueVideos(List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract void loadVideos(List<String> paramList);
  
  public abstract void loadVideos(List<String> paramList, int paramInt1, int paramInt2);
  
  public abstract void play();
  
  public abstract void pause();
  
  public abstract boolean isPlaying();
  
  public abstract boolean hasNext();
  
  public abstract boolean hasPrevious();
  
  public abstract void next();
  
  public abstract void previous();
  
  public abstract int getCurrentTimeMillis();
  
  public abstract int getDurationMillis();
  
  public abstract void seekToMillis(int paramInt);
  
  public abstract void seekRelativeMillis(int paramInt);
  
  public abstract void setFullscreen(boolean paramBoolean);
  
  public abstract void setOnFullscreenListener(OnFullscreenListener paramOnFullscreenListener);
  
  public abstract void setFullscreenControlFlags(int paramInt);
  
  public abstract int getFullscreenControlFlags();
  
  public abstract void addFullscreenControlFlag(int paramInt);
  
  public abstract void setPlayerStyle(PlayerStyle paramPlayerStyle);
  
  public abstract void setShowFullscreenButton(boolean paramBoolean);
  
  public abstract void setManageAudioFocus(boolean paramBoolean);
  
  public abstract void setPlaylistEventListener(PlaylistEventListener paramPlaylistEventListener);
  
  public abstract void setPlayerStateChangeListener(PlayerStateChangeListener paramPlayerStateChangeListener);
  
  public abstract void setPlaybackEventListener(PlaybackEventListener paramPlaybackEventListener);
  
  public static enum ErrorReason
  {
    private ErrorReason() {}
  }
  
  public static enum PlayerStyle
  {
    private PlayerStyle() {}
  }
  
  public static abstract interface OnFullscreenListener
  {
    public abstract void onFullscreen(boolean paramBoolean);
  }
  
  public static abstract interface PlaybackEventListener
  {
    public abstract void onPlaying();
    
    public abstract void onPaused();
    
    public abstract void onStopped();
    
    public abstract void onBuffering(boolean paramBoolean);
    
    public abstract void onSeekTo(int paramInt);
  }
  
  public static abstract interface PlayerStateChangeListener
  {
    public abstract void onLoading();
    
    public abstract void onLoaded(String paramString);
    
    public abstract void onAdStarted();
    
    public abstract void onVideoStarted();
    
    public abstract void onVideoEnded();
    
    public abstract void onError(YouTubePlayer.ErrorReason paramErrorReason);
  }
  
  public static abstract interface PlaylistEventListener
  {
    public abstract void onPrevious();
    
    public abstract void onNext();
    
    public abstract void onPlaylistEnded();
  }
  
  public static abstract interface OnInitializedListener
  {
    public abstract void onInitializationSuccess(YouTubePlayer.Provider paramProvider, YouTubePlayer paramYouTubePlayer, boolean paramBoolean);
    
    public abstract void onInitializationFailure(YouTubePlayer.Provider paramProvider, YouTubeInitializationResult paramYouTubeInitializationResult);
  }
  
  public static abstract interface Provider
  {
    public abstract void initialize(String paramString, YouTubePlayer.OnInitializedListener paramOnInitializedListener);
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.YouTubePlayer
 * JD-Core Version:    0.7.0.1
 */