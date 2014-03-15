package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public abstract class ab
{
  private static final ab a = ;
  
  private static ab b()
  {
    try
    {
      Class localClass = Class.forName("com.google.android.youtube.api.locallylinked.LocallyLinkedFactory").asSubclass(ab.class);
      try
      {
        return (ab)localClass.newInstance();
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new IllegalStateException(localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new IllegalStateException(localIllegalAccessException);
      }
      return new ad();
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
  }
  
  public static ab a()
  {
    return a;
  }
  
  public abstract b a(Context paramContext, String paramString, t.a parama, t.b paramb);
  
  public abstract d a(Activity paramActivity, b paramb)
    throws w.a;
  
  public abstract YouTubeThumbnailLoader a(b paramb, YouTubeThumbnailView paramYouTubeThumbnailView);
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.ab
 * JD-Core Version:    0.7.0.1
 */