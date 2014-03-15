package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;

public final class z
{
  private static final Uri a = Uri.parse("http://play.google.com/store/apps/details");
  
  public static String a(Context paramContext)
  {
    Object localObject = new Intent("com.google.android.youtube.api.service.START");
    if (((localObject = (paramContext = paramContext.getPackageManager()).resolveService((Intent)localObject, 0)) != null) && (((ResolveInfo)localObject).serviceInfo != null) && (((ResolveInfo)localObject).serviceInfo.packageName != null)) {
      return ((ResolveInfo)localObject).serviceInfo.packageName;
    }
    if (paramContext.hasSystemFeature("com.google.android.tv")) {
      return "com.google.android.youtube.googletv";
    }
    return "com.google.android.youtube";
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication(paramString);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      return true;
    }
    String str = paramString;
    if (paramString.equals("com.google.android.youtube.googletvdev")) {
      str = "com.google.android.youtube.googletv";
    }
    if ((paramString = paramContext.getIdentifier("youtube_api_version_code", "integer", str)) == 0) {
      return true;
    }
    return 1000 > paramContext.getInteger(paramString);
  }
  
  public static Context b(Context paramContext)
  {
    try
    {
      return paramContext.createPackageContext(a(paramContext), 3);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return null;
  }
  
  public static int c(Context paramContext)
  {
    return a(paramContext, b(paramContext));
  }
  
  public static int a(Context paramContext1, Context paramContext2)
  {
    int i = 0;
    if (paramContext2 != null) {
      i = paramContext2.getResources().getIdentifier("clientTheme", "style", a(paramContext1));
    }
    if (i == 0) {
      if (Build.VERSION.SDK_INT >= 14) {
        i = 16974120;
      } else if (Build.VERSION.SDK_INT >= 11) {
        i = 16973931;
      } else {
        i = 16973829;
      }
    }
    return i;
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      paramContext = null;
      return paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new IllegalStateException("Cannot retrieve calling Context's PackageInfo", paramContext);
    }
  }
  
  public static Intent a(String paramString)
  {
    paramString = Uri.fromParts("package", paramString, null);
    Intent localIntent;
    (localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS")).setData(paramString);
    return localIntent;
  }
  
  public static Intent b(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    paramString = a.buildUpon().appendQueryParameter("id", paramString).build();
    localIntent.setData(paramString);
    localIntent.setPackage("com.android.vending");
    localIntent.addFlags(524288);
    return localIntent;
  }
  
  public static boolean a(PackageManager paramPackageManager)
  {
    return paramPackageManager.hasSystemFeature("com.google.android.tv");
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.z
 * JD-Core Version:    0.7.0.1
 */