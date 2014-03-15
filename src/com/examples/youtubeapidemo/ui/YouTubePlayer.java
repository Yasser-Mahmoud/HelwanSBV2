package com.examples.youtubeapidemo.ui;

import com.google.android.youtube.player.YouTubeInitializationResult;
import java.util.List;

public interface YouTubePlayer {

   int FULLSCREEN_FLAG_CONTROL_ORIENTATION = 1;
   int FULLSCREEN_FLAG_CONTROL_SYSTEM_UI = 2;
   int FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE = 4;
   int FULLSCREEN_FLAG_CUSTOM_LAYOUT = 8;


   void release();

   void cueVideo(String var1);

   void cueVideo(String var1, int var2);

   void loadVideo(String var1);

   void loadVideo(String var1, int var2);

   void cuePlaylist(String var1);

   void cuePlaylist(String var1, int var2, int var3);

   void loadPlaylist(String var1);

   void loadPlaylist(String var1, int var2, int var3);

   void cueVideos(List var1);

   void cueVideos(List var1, int var2, int var3);

   void loadVideos(List var1);

   void loadVideos(List var1, int var2, int var3);

   void play();

   void pause();

   boolean isPlaying();

   boolean hasNext();

   boolean hasPrevious();

   void next();

   void previous();

   int getCurrentTimeMillis();

   int getDurationMillis();

   void seekToMillis(int var1);

   void seekRelativeMillis(int var1);

   void setFullscreen(boolean var1);

   void setOnFullscreenListener(YouTubePlayer.OnFullscreenListener var1);

   void setFullscreenControlFlags(int var1);

   int getFullscreenControlFlags();

   void addFullscreenControlFlag(int var1);

   void setPlayerStyle(YouTubePlayer.PlayerStyle var1);

   void setShowFullscreenButton(boolean var1);

   void setManageAudioFocus(boolean var1);

   void setPlaylistEventListener(YouTubePlayer.PlaylistEventListener var1);

   void setPlayerStateChangeListener(YouTubePlayer.PlayerStateChangeListener var1);

   void setPlaybackEventListener(YouTubePlayer.PlaybackEventListener var1);

   public interface PlayerStateChangeListener {

      void onLoading();

      void onLoaded(String var1);

      void onAdStarted();

      void onVideoStarted();

      void onVideoEnded();

      void onError(YouTubePlayer.ErrorReason var1);
   }

   public interface Provider {

      void initialize(String var1, YouTubePlayer.OnInitializedListener var2);
   }

   public interface OnFullscreenListener {

      void onFullscreen(boolean var1);
   }

   public interface OnInitializedListener {

      void onInitializationSuccess(YouTubePlayer.Provider var1, YouTubePlayer var2, boolean var3);

      void onInitializationFailure(YouTubePlayer.Provider var1, YouTubeInitializationResult var2);
   }

   public static enum ErrorReason {

      EMBEDDING_DISABLED("EMBEDDING_DISABLED", 0),
      BLOCKED_FOR_APP("BLOCKED_FOR_APP", 1),
      NOT_PLAYABLE("NOT_PLAYABLE", 2),
      NETWORK_ERROR("NETWORK_ERROR", 3),
      UNAUTHORIZED_OVERLAY("UNAUTHORIZED_OVERLAY", 4),
      PLAYER_VIEW_TOO_SMALL("PLAYER_VIEW_TOO_SMALL", 5),
      EMPTY_PLAYLIST("EMPTY_PLAYLIST", 6),
      AUTOPLAY_DISABLED("AUTOPLAY_DISABLED", 7),
      USER_DECLINED_RESTRICTED_CONTENT("USER_DECLINED_RESTRICTED_CONTENT", 8),
      USER_DECLINED_HIGH_BANDWIDTH("USER_DECLINED_HIGH_BANDWIDTH", 9),
      UNEXPECTED_SERVICE_DISCONNECTION("UNEXPECTED_SERVICE_DISCONNECTION", 10),
      INTERNAL_ERROR("INTERNAL_ERROR", 11),
      UNKNOWN("UNKNOWN", 12);
      // $FF: synthetic field
      private static final YouTubePlayer.ErrorReason[] a = new YouTubePlayer.ErrorReason[]{EMBEDDING_DISABLED, BLOCKED_FOR_APP, NOT_PLAYABLE, NETWORK_ERROR, UNAUTHORIZED_OVERLAY, PLAYER_VIEW_TOO_SMALL, EMPTY_PLAYLIST, AUTOPLAY_DISABLED, USER_DECLINED_RESTRICTED_CONTENT, USER_DECLINED_HIGH_BANDWIDTH, UNEXPECTED_SERVICE_DISCONNECTION, INTERNAL_ERROR, UNKNOWN};


      private ErrorReason(String var1, int var2) {}

   }

   public interface PlaylistEventListener {

      void onPrevious();

      void onNext();

      void onPlaylistEnded();
   }

   public static enum PlayerStyle {

      DEFAULT("DEFAULT", 0),
      MINIMAL("MINIMAL", 1),
      CHROMELESS("CHROMELESS", 2);
      // $FF: synthetic field
      private static final YouTubePlayer.PlayerStyle[] a = new YouTubePlayer.PlayerStyle[]{DEFAULT, MINIMAL, CHROMELESS};


      private PlayerStyle(String var1, int var2) {}

   }

   public interface PlaybackEventListener {

      void onPlaying();

      void onPaused();

      void onStopped();

      void onBuffering(boolean var1);

      void onSeekTo(int var1);
   }
}
