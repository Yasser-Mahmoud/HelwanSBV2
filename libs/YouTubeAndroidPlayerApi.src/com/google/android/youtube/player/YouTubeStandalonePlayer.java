package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.google.android.youtube.player.internal.z;

public final class YouTubeStandalonePlayer
{
  public static Intent createVideoIntent(Activity paramActivity, String paramString1, String paramString2)
  {
    return createVideoIntent(paramActivity, paramString1, paramString2, 0, false, false);
  }
  
  public static Intent createVideoIntent(Activity paramActivity, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(new Intent("com.google.android.youtube.api.StandalonePlayerActivity.START").putExtra("video_id", paramString2), paramActivity, paramString1, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public static Intent createPlaylistIntent(Activity paramActivity, String paramString1, String paramString2)
  {
    return createPlaylistIntent(paramActivity, paramString1, paramString2, 0, 0, false, false);
  }
  
  public static Intent createPlaylistIntent(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(new Intent("com.google.android.youtube.api.StandalonePlayerActivity.START").putExtra("playlist_id", paramString2).putExtra("current_index", paramInt1), paramActivity, paramString1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  private static Intent a(Intent paramIntent, Activity paramActivity, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramIntent.putExtra("developer_key", paramString).putExtra("app_package", paramActivity.getPackageName()).putExtra("app_version", z.d(paramActivity)).putExtra("autoplay", paramBoolean1).putExtra("lightbox_mode", paramBoolean2).putExtra("start_time_millis", paramInt).putExtra("window_has_status_bar", (paramActivity.getWindow().getAttributes().flags & 0x400) == 0);
    return paramIntent;
  }
  
  public static YouTubeInitializationResult getReturnedInitializationResult(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras().getString("initialization_result");
    try
    {
      return YouTubeInitializationResult.valueOf(paramIntent);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      return YouTubeInitializationResult.UNKNOWN_ERROR;
    }
    catch (NullPointerException localNullPointerException) {}
    return YouTubeInitializationResult.UNKNOWN_ERROR;
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.YouTubeStandalonePlayer
 * JD-Core Version:    0.7.0.1
 */