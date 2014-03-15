package com.google.android.youtube.player.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeInitializationResult;
import java.util.ArrayList;

public abstract class r<T extends IInterface>
  implements t
{
  private final Context b;
  final Handler a;
  private T c;
  private ArrayList<t.a> d;
  private final ArrayList<t.a> e = new ArrayList();
  private boolean f = false;
  private ArrayList<t.b> g;
  private boolean h = false;
  private final ArrayList<r<T>.b<?>> i = new ArrayList();
  private ServiceConnection j;
  private boolean k = false;
  
  protected r(Context paramContext, t.a parama, t.b paramb)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
      throw new IllegalStateException("Clients must be created on the UI thread.");
    }
    this.b = ((Context)ac.a(paramContext));
    this.d = new ArrayList();
    this.d.add(ac.a(parama));
    this.g = new ArrayList();
    this.g.add(ac.a(paramb));
    this.a = new a();
  }
  
  protected abstract String c();
  
  protected abstract String b();
  
  protected abstract T a(IBinder paramIBinder);
  
  private static YouTubeInitializationResult b(String paramString)
  {
    try
    {
      return YouTubeInitializationResult.valueOf(paramString);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      return YouTubeInitializationResult.UNKNOWN_ERROR;
    }
    catch (NullPointerException localNullPointerException) {}
    return YouTubeInitializationResult.UNKNOWN_ERROR;
  }
  
  public final void e()
  {
    this.k = true;
    if ((localObject = YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(this.b)) != YouTubeInitializationResult.SUCCESS)
    {
      this.a.sendMessage(this.a.obtainMessage(3, localObject));
      return;
    }
    Object localObject = new Intent(c());
    if (this.j != null)
    {
      Log.e("YouTubeClient", "Calling connect() while still connected, missing disconnect().");
      this.c = null;
      this.b.unbindService(this.j);
    }
    this.j = new e();
    if (!this.b.bindService((Intent)localObject, this.j, 129)) {
      this.a.sendMessage(this.a.obtainMessage(3, YouTubeInitializationResult.ERROR_CONNECTING_TO_SERVICE));
    }
  }
  
  public final boolean f()
  {
    return this.c != null;
  }
  
  public void d()
  {
    h();
    this.k = false;
    synchronized (this.i)
    {
      int m = this.i.size();
      for (int n = 0; n < m; n++) {
        ((b)this.i.get(n)).b();
      }
      this.i.clear();
    }
    this.c = null;
    if (this.j != null)
    {
      this.b.unbindService(this.j);
      this.j = null;
    }
  }
  
  protected final void b(IBinder paramIBinder)
  {
    try
    {
      paramIBinder = i.a.a(paramIBinder);
      a(paramIBinder, new d());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("YouTubeClient", "service died");
    }
  }
  
  protected abstract void a(i parami, r<T>.d paramr)
    throws RemoteException;
  
  protected final void g()
  {
    synchronized (this.d)
    {
      ac.a(!this.f);
      this.a.removeMessages(4);
      this.f = true;
      ac.a(this.e.size() == 0);
      ArrayList localArrayList = this.d;
      int m = 0;
      int n = localArrayList.size();
      while ((m < n) && (this.k) && (f()))
      {
        this.e.size();
        if (!this.e.contains(localArrayList.get(m))) {
          ((t.a)localArrayList.get(m)).a();
        }
        m++;
      }
      this.e.clear();
      this.f = false;
      return;
    }
  }
  
  protected final void h()
  {
    this.a.removeMessages(4);
    synchronized (this.d)
    {
      this.f = true;
      ArrayList localArrayList = this.d;
      int m = 0;
      int n = localArrayList.size();
      while ((m < n) && (this.k))
      {
        if (this.d.contains(localArrayList.get(m))) {
          ((t.a)localArrayList.get(m)).b();
        }
        m++;
      }
      this.f = false;
      return;
    }
  }
  
  protected final void a(YouTubeInitializationResult paramYouTubeInitializationResult)
  {
    this.a.removeMessages(4);
    synchronized (this.g)
    {
      this.h = true;
      ArrayList localArrayList = this.g;
      int m = 0;
      int n = localArrayList.size();
      while (m < n)
      {
        if (!this.k) {
          return;
        }
        if (this.g.contains(localArrayList.get(m))) {
          ((t.b)localArrayList.get(m)).a(paramYouTubeInitializationResult);
        }
        m++;
      }
      this.h = false;
      return;
    }
  }
  
  protected final void i()
  {
    if (!f()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  protected final T j()
  {
    i();
    return this.c;
  }
  
  protected final class d
    extends c.a
  {
    protected d() {}
    
    public final void a(String paramString, IBinder paramIBinder)
    {
      r.this.a.sendMessage(r.this.a.obtainMessage(1, new r.c(r.this, paramString, paramIBinder)));
    }
  }
  
  protected final class c
    extends r<T>.b<Boolean>
  {
    public final YouTubeInitializationResult b;
    public final IBinder c;
    
    public c(String paramString, IBinder paramIBinder)
    {
      super(Boolean.valueOf(true));
      this.b = r.a(paramString);
      this.c = paramIBinder;
    }
  }
  
  protected abstract class b<TListener>
  {
    private TListener b;
    
    public b()
    {
      Object localObject1;
      this.b = localObject1;
      synchronized (r.c(r.this))
      {
        r.c(r.this).add(this);
        return;
      }
    }
    
    protected abstract void a(TListener paramTListener);
    
    public final void a()
    {
      synchronized (this)
      {
        Object localObject1 = this.b;
      }
      a(localObject2);
    }
    
    public final void b()
    {
      synchronized (this)
      {
        this.b = null;
        return;
      }
    }
  }
  
  final class a
    extends Handler
  {
    a() {}
    
    public final void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 3)
      {
        r.this.a((YouTubeInitializationResult)paramMessage.obj);
        return;
      }
      if (paramMessage.what == 4) {
        synchronized (r.a(r.this))
        {
          if ((r.b(r.this)) && (r.this.f()) && (r.a(r.this).contains(paramMessage.obj))) {
            ((t.a)paramMessage.obj).a();
          }
          return;
        }
      }
      if ((paramMessage.what == 2) && (!r.this.f())) {
        return;
      }
      if ((paramMessage.what == 2) || (paramMessage.what == 1))
      {
        ((r.b)paramMessage.obj).a();
        return;
      }
    }
  }
  
  final class e
    implements ServiceConnection
  {
    e() {}
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      r.this.b(paramIBinder);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      r.a(r.this, null);
      r.this.h();
    }
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.r
 * JD-Core Version:    0.7.0.1
 */