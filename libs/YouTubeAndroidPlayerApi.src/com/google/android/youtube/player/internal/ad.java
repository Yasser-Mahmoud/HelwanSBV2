package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public final class ad
  extends ab
{
  public final b a(Context paramContext, String paramString, t.a parama, t.b paramb)
  {
    return new o(paramContext, paramString, paramContext.getPackageName(), z.d(paramContext), parama, paramb);
  }
  
  public final d a(Activity paramActivity, b paramb)
    throws w.a
  {
    return w.a(paramActivity, paramb.a());
  }
  
  public final YouTubeThumbnailLoader a(b paramb, YouTubeThumbnailView paramYouTubeThumbnailView)
  {
    return new p(paramb, paramYouTubeThumbnailView);
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.ad
 * JD-Core Version:    0.7.0.1
 */