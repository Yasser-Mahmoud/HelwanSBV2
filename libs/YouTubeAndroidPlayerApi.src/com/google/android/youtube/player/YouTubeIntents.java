package com.google.android.youtube.player;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.youtube.player.internal.z;
import java.util.List;

public final class YouTubeIntents
{
  public static boolean isYouTubeInstalled(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getApplicationInfo(a(paramContext), 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  public static String getInstalledYouTubeVersionName(Context paramContext)
  {
    try
    {
      return paramContext.getPackageManager().getPackageInfo(a(paramContext), 0).versionName;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return null;
  }
  
  public static int getInstalledYouTubeVersionCode(Context paramContext)
  {
    try
    {
      return paramContext.getPackageManager().getPackageInfo(a(paramContext), 0).versionCode;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return -1;
  }
  
  public static boolean canResolvePlayVideoIntent(Context paramContext)
  {
    Uri localUri = Uri.parse("http://www.youtube.com/watch?v=");
    return a(paramContext, localUri);
  }
  
  public static Intent createPlayVideoIntent(Context paramContext, String paramString)
  {
    return createPlayVideoIntentWithOptions(paramContext, paramString, false, false);
  }
  
  public final boolean canResolvePlayVideoIntentWithOptions(Context paramContext)
  {
    int i = getInstalledYouTubeVersionCode(paramContext);
    if ((i >= 3300 ? 1 : z.a(paramContext.getPackageManager()) ? 0 : i >= 2147483647 ? 1 : 0) != 0) {
      if (canResolvePlayVideoIntent(paramContext)) {
        return true;
      }
    }
    return false;
  }
  
  public static Intent createPlayVideoIntentWithOptions(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = Uri.parse("http://www.youtube.com/watch?v=" + paramString);
    return b(paramContext, paramString).putExtra("force_fullscreen", paramBoolean1).putExtra("finish_on_ended", paramBoolean2);
  }
  
  public static boolean canResolveSearchIntent(Context paramContext)
  {
    if ((z.a(paramContext.getPackageManager())) && (getInstalledYouTubeVersionCode(paramContext) < 2147483647)) {
      return false;
    }
    Intent localIntent = new Intent("android.intent.action.SEARCH").setPackage(a(paramContext));
    return a(paramContext, localIntent);
  }
  
  public static Intent createSearchIntent(Context paramContext, String paramString)
  {
    return new Intent("android.intent.action.SEARCH").setPackage(a(paramContext)).putExtra("query", paramString);
  }
  
  public static boolean canResolveOpenPlaylistIntent(Context paramContext)
  {
    Uri localUri = Uri.parse("http://www.youtube.com/playlist?list=");
    return a(paramContext, localUri);
  }
  
  public static Intent createOpenPlaylistIntent(Context paramContext, String paramString)
  {
    paramString = a(paramString);
    (paramContext = b(paramContext, paramString)).putExtra("authenticate", false);
    return paramContext;
  }
  
  public static boolean canResolvePlayPlaylistIntent(Context paramContext)
  {
    int i = getInstalledYouTubeVersionCode(paramContext);
    if ((i >= 4000 ? 1 : z.a(paramContext.getPackageManager()) ? 0 : i >= 2147483647 ? 1 : 0) != 0) {
      if (canResolveOpenPlaylistIntent(paramContext)) {
        return true;
      }
    }
    return false;
  }
  
  public static Intent createPlayPlaylistIntent(Context paramContext, String paramString)
  {
    paramString = a(paramString).buildUpon().appendQueryParameter("playnext", "1").build();
    (paramContext = b(paramContext, paramString)).putExtra("authenticate", false);
    return paramContext;
  }
  
  public static boolean canResolveUserIntent(Context paramContext)
  {
    Uri localUri = Uri.parse("http://www.youtube.com/user/");
    return a(paramContext, localUri);
  }
  
  public static Intent createUserIntent(Context paramContext, String paramString)
  {
    paramString = Uri.parse("http://www.youtube.com/user/" + paramString);
    return b(paramContext, paramString);
  }
  
  public static boolean canResolveUploadIntent(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.android.youtube.intent.action.UPLOAD").setPackage(a(paramContext)).setType("video/*");
    return a(paramContext, localIntent);
  }
  
  public static Intent createUploadIntent(Context paramContext, Uri paramUri)
    throws IllegalArgumentException
  {
    if (paramUri == null) {
      throw new IllegalArgumentException("videoUri parameter cannot be null.");
    }
    if (!paramUri.toString().startsWith("content://media/")) {
      throw new IllegalArgumentException("videoUri parameter must be a URI pointing to a valid video file. It must begin with \"content://media/\"");
    }
    return new Intent("com.google.android.youtube.intent.action.UPLOAD").setPackage(a(paramContext)).setDataAndType(paramUri, "video/*");
  }
  
  private static boolean a(Context paramContext, Uri paramUri)
  {
    paramUri = new Intent("android.intent.action.VIEW", paramUri).setPackage(a(paramContext));
    return a(paramContext, paramUri);
  }
  
  private static Intent b(Context paramContext, Uri paramUri)
  {
    return new Intent("android.intent.action.VIEW", paramUri).setPackage(a(paramContext));
  }
  
  private static boolean a(Context paramContext, Intent paramIntent)
  {
    return ((paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536)) != null) && (!paramContext.isEmpty());
  }
  
  private static String a(Context paramContext)
  {
    if (z.a(paramContext.getPackageManager())) {
      return "com.google.android.youtube.googletv";
    }
    return "com.google.android.youtube";
  }
  
  private static Uri a(String paramString)
  {
    return Uri.parse("http://www.youtube.com/playlist?list=" + paramString);
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.YouTubeIntents
 * JD-Core Version:    0.7.0.1
 */