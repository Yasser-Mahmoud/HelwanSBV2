package com.google.android.youtube.player.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;

public final class o
  extends r<l>
  implements b
{
  private final String b;
  private final String c;
  private final String d;
  private boolean e;
  
  public o(Context paramContext, String paramString1, String paramString2, String paramString3, t.a parama, t.b paramb)
  {
    super(paramContext, parama, paramb);
    this.b = ((String)ac.a(paramString1, "developerKey cannot be null"));
    this.c = ac.a(paramString2, "callingPackage cannot be null or empty");
    this.d = ac.a(paramString3, "callingAppVersion cannot be null or empty");
  }
  
  protected final String b()
  {
    return "com.google.android.youtube.player.internal.IYouTubeService";
  }
  
  protected final String c()
  {
    return "com.google.android.youtube.api.service.START";
  }
  
  private final void k()
  {
    i();
    if (this.e) {
      throw new IllegalStateException("Connection client has been released");
    }
  }
  
  protected final void a(i parami, r<l>.d paramr)
    throws RemoteException
  {
    parami.a(paramr, 1000, this.c, this.d, this.b, null);
  }
  
  public final k a(j paramj)
  {
    k();
    try
    {
      return ((l)j()).a(paramj);
    }
    catch (RemoteException paramj)
    {
      throw new IllegalStateException(paramj);
    }
  }
  
  public final IBinder a()
  {
    k();
    try
    {
      return ((l)j()).a();
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (f())
    {
      try
      {
        ((l)j()).a(paramBoolean);
      }
      catch (RemoteException localRemoteException) {}
      this.e = true;
    }
  }
  
  public final void d()
  {
    if (!this.e) {
      a(true);
    }
    super.d();
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.o
 * JD-Core Version:    0.7.0.1
 */