package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Locale;
import java.util.Map;

public final class m
{
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  public final String j;
  
  public m(Context paramContext)
  {
    if (((paramContext = paramContext.getResources()) != null) && (paramContext.getConfiguration() != null) && (paramContext.getConfiguration().locale != null)) {
      paramContext = paramContext.getConfiguration().locale;
    } else {
      paramContext = Locale.getDefault();
    }
    paramContext = x.a(paramContext);
    this.a = ((String)paramContext.get("error_initializing_player"));
    this.b = ((String)paramContext.get("get_youtube_app_title"));
    this.c = ((String)paramContext.get("get_youtube_app_text"));
    this.d = ((String)paramContext.get("get_youtube_app_action"));
    this.e = ((String)paramContext.get("enable_youtube_app_title"));
    this.f = ((String)paramContext.get("enable_youtube_app_text"));
    this.g = ((String)paramContext.get("enable_youtube_app_action"));
    this.h = ((String)paramContext.get("update_youtube_app_title"));
    this.i = ((String)paramContext.get("update_youtube_app_text"));
    this.j = ((String)paramContext.get("update_youtube_app_action"));
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.m
 * JD-Core Version:    0.7.0.1
 */