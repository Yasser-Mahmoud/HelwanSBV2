package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.youtube.player.YouTubeThumbnailView;

public final class p
  extends a
{
  private final Handler a;
  private b b;
  private k c;
  private boolean d;
  private boolean e;
  
  public p(b paramb, YouTubeThumbnailView paramYouTubeThumbnailView)
  {
    super(paramYouTubeThumbnailView);
    this.b = ((b)ac.a(paramb, "connectionClient cannot be null"));
    this.c = paramb.a(new a((byte)0));
    this.a = new Handler(Looper.getMainLooper());
  }
  
  protected final boolean a()
  {
    return (super.a()) && (this.c != null);
  }
  
  public final void a(String paramString)
  {
    try
    {
      this.c.a(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    try
    {
      this.c.a(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  public final void b()
  {
    try
    {
      this.c.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public final void c()
  {
    try
    {
      this.c.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public final void d()
  {
    try
    {
      this.c.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public final boolean e()
  {
    return this.e;
  }
  
  public final boolean f()
  {
    return this.d;
  }
  
  public final void g()
  {
    try
    {
      this.c.d();
    }
    catch (RemoteException localRemoteException) {}
    this.b.d();
    this.c = null;
    this.b = null;
  }
  
  private final class a
    extends j.a
  {
    private a() {}
    
    public final void a(final Bitmap paramBitmap, final String paramString, final boolean paramBoolean1, final boolean paramBoolean2)
    {
      p.a(p.this).post(new Runnable()
      {
        public final void run()
        {
          p.a(p.this, paramBoolean1);
          p.b(p.this, paramBoolean2);
          p.this.a(paramBitmap, paramString);
        }
      });
    }
    
    public final void a(final String paramString, final boolean paramBoolean1, final boolean paramBoolean2)
    {
      p.a(p.this).post(new Runnable()
      {
        public final void run()
        {
          p.a(p.this, paramBoolean1);
          p.b(p.this, paramBoolean2);
          p.this.b(paramString);
        }
      });
    }
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.p
 * JD-Core Version:    0.7.0.1
 */