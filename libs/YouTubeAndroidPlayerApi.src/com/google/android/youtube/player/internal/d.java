package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.view.KeyEvent;
import java.util.List;

public abstract interface d
  extends IInterface
{
  public abstract void a(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void b(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void a(String paramString, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void b(String paramString, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void a(List<String> paramList, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void b(List<String> paramList, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void a()
    throws RemoteException;
  
  public abstract void b()
    throws RemoteException;
  
  public abstract boolean c()
    throws RemoteException;
  
  public abstract boolean d()
    throws RemoteException;
  
  public abstract boolean e()
    throws RemoteException;
  
  public abstract void f()
    throws RemoteException;
  
  public abstract void g()
    throws RemoteException;
  
  public abstract int h()
    throws RemoteException;
  
  public abstract int i()
    throws RemoteException;
  
  public abstract void a(int paramInt)
    throws RemoteException;
  
  public abstract void b(int paramInt)
    throws RemoteException;
  
  public abstract void b(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void c(int paramInt)
    throws RemoteException;
  
  public abstract int j()
    throws RemoteException;
  
  public abstract void d(int paramInt)
    throws RemoteException;
  
  public abstract void a(String paramString)
    throws RemoteException;
  
  public abstract void c(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void d(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(e parame)
    throws RemoteException;
  
  public abstract void a(h paramh)
    throws RemoteException;
  
  public abstract void a(g paramg)
    throws RemoteException;
  
  public abstract void a(f paramf)
    throws RemoteException;
  
  public abstract void k()
    throws RemoteException;
  
  public abstract void l()
    throws RemoteException;
  
  public abstract void a(Configuration paramConfiguration)
    throws RemoteException;
  
  public abstract void m()
    throws RemoteException;
  
  public abstract void n()
    throws RemoteException;
  
  public abstract void o()
    throws RemoteException;
  
  public abstract void p()
    throws RemoteException;
  
  public abstract void e(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void q()
    throws RemoteException;
  
  public abstract Bundle r()
    throws RemoteException;
  
  public abstract boolean a(Bundle paramBundle)
    throws RemoteException;
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent)
    throws RemoteException;
  
  public abstract boolean b(int paramInt, KeyEvent paramKeyEvent)
    throws RemoteException;
  
  public abstract u s()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements d
  {
    public static d a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface;
      if (((localIInterface = paramIBinder.queryLocalInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer")) != null) && ((localIInterface instanceof d))) {
        return (d)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      case 1598968902: 
        paramParcel2.writeString("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = 0 != paramParcel1.readInt() ? 1 : 0;
        a(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = paramParcel1.readString();
        paramInt2 = paramParcel1.readInt();
        a(paramInt1, paramInt2);
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = paramParcel1.readString();
        paramInt2 = paramParcel1.readInt();
        b(paramInt1, paramInt2);
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = paramParcel1.readString();
        paramInt2 = paramParcel1.readInt();
        paramParcel1 = paramParcel1.readInt();
        a(paramInt1, paramInt2, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = paramParcel1.readString();
        paramInt2 = paramParcel1.readInt();
        paramParcel1 = paramParcel1.readInt();
        b(paramInt1, paramInt2, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = paramParcel1.createStringArrayList();
        paramInt2 = paramParcel1.readInt();
        paramParcel1 = paramParcel1.readInt();
        a(paramInt1, paramInt2, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = paramParcel1.createStringArrayList();
        paramInt2 = paramParcel1.readInt();
        paramParcel1 = paramParcel1.readInt();
        b(paramInt1, paramInt2, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        a();
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        b();
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = c();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1 != 0 ? 1 : 0);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = d();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1 != 0 ? 1 : 0);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = e();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1 != 0 ? 1 : 0);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        f();
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        g();
        paramParcel2.writeNoException();
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = h();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = i();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = paramParcel1.readInt();
        a(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = paramParcel1.readInt();
        b(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = 0 != paramParcel1.readInt() ? 1 : 0;
        b(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = paramParcel1.readInt();
        c(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = j();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = paramParcel1.readInt();
        d(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = paramParcel1.readString();
        a(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = 0 != paramParcel1.readInt() ? 1 : 0;
        c(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = 0 != paramParcel1.readInt() ? 1 : 0;
        d(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = ((paramParcel1 = paramInt1.queryLocalInterface("com.google.android.youtube.player.internal.IOnFullscreenListener")) != null) && ((paramParcel1 instanceof e)) ? (e)paramParcel1 : (paramInt1 = paramParcel1.readStrongBinder()) == null ? null : new e.a.a(paramInt1);
        a(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = ((paramParcel1 = paramInt1.queryLocalInterface("com.google.android.youtube.player.internal.IPlaylistEventListener")) != null) && ((paramParcel1 instanceof h)) ? (h)paramParcel1 : (paramInt1 = paramParcel1.readStrongBinder()) == null ? null : new h.a.a(paramInt1);
        a(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = ((paramParcel1 = paramInt1.queryLocalInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener")) != null) && ((paramParcel1 instanceof g)) ? (g)paramParcel1 : (paramInt1 = paramParcel1.readStrongBinder()) == null ? null : new g.a.a(paramInt1);
        a(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = ((paramParcel1 = paramInt1.queryLocalInterface("com.google.android.youtube.player.internal.IPlaybackEventListener")) != null) && ((paramParcel1 instanceof f)) ? (f)paramParcel1 : (paramInt1 = paramParcel1.readStrongBinder()) == null ? null : new f.a.a(paramInt1);
        a(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        k();
        paramParcel2.writeNoException();
        return true;
      case 31: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        l();
        paramParcel2.writeNoException();
        return true;
      case 32: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        if (0 != paramParcel1.readInt()) {
          paramInt1 = (Configuration)Configuration.CREATOR.createFromParcel(paramParcel1);
        } else {
          paramInt1 = null;
        }
        a(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 33: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        m();
        paramParcel2.writeNoException();
        return true;
      case 34: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        n();
        paramParcel2.writeNoException();
        return true;
      case 35: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        o();
        paramParcel2.writeNoException();
        return true;
      case 36: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        p();
        paramParcel2.writeNoException();
        return true;
      case 37: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = 0 != paramParcel1.readInt() ? 1 : 0;
        e(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 38: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        q();
        paramParcel2.writeNoException();
        return true;
      case 39: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = r();
        paramParcel2.writeNoException();
        if (paramInt1 != null)
        {
          paramParcel2.writeInt(1);
          paramInt1.writeToParcel(paramParcel2, 1);
        }
        else
        {
          paramParcel2.writeInt(0);
        }
        return true;
      case 40: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        if (0 != paramParcel1.readInt()) {
          paramInt1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        } else {
          paramInt1 = null;
        }
        paramInt2 = a(paramInt1);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt2 != 0 ? 1 : 0);
        return true;
      case 41: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = paramParcel1.readInt();
        if (0 != paramParcel1.readInt()) {
          paramInt2 = (KeyEvent)KeyEvent.CREATOR.createFromParcel(paramParcel1);
        } else {
          paramInt2 = null;
        }
        paramParcel1 = a(paramInt1, paramInt2);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramParcel1 != 0 ? 1 : 0);
        return true;
      case 42: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = paramParcel1.readInt();
        if (0 != paramParcel1.readInt()) {
          paramInt2 = (KeyEvent)KeyEvent.CREATOR.createFromParcel(paramParcel1);
        } else {
          paramInt2 = null;
        }
        paramParcel1 = b(paramInt1, paramInt2);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramParcel1 != 0 ? 1 : 0);
        return true;
      case 43: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        paramInt1 = s();
        paramParcel2.writeNoException();
        paramParcel2.writeStrongBinder(paramInt1 != null ? paramInt1.asBinder() : null);
        return true;
      }
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    
    private static class a
      implements d
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.a;
      }
      
      public final void a(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeInt(paramBoolean ? 1 : 0);
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void a(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void b(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.a.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void a(String paramString, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.a.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void b(String paramString, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.a.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void a(List<String> paramList, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeStringList(paramList);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.a.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void b(List<String> paramList, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeStringList(paramList);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.a.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void a()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void b()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final boolean c()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = 0 != localParcel2.readInt() ? 1 : 0;
          localParcel2.recycle();
          localParcel1.recycle();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return localObject;
      }
      
      public final boolean d()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = 0 != localParcel2.readInt() ? 1 : 0;
          localParcel2.recycle();
          localParcel1.recycle();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return localObject;
      }
      
      public final boolean e()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = 0 != localParcel2.readInt() ? 1 : 0;
          localParcel2.recycle();
          localParcel1.recycle();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return localObject;
      }
      
      public final void f()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void g()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final int h()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          localParcel2.recycle();
          localParcel1.recycle();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return localObject;
      }
      
      public final int i()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          localParcel2.recycle();
          localParcel1.recycle();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return localObject;
      }
      
      public final void a(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeInt(paramInt);
          this.a.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void b(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeInt(paramInt);
          this.a.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void b(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeInt(paramBoolean ? 1 : 0);
          this.a.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void c(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeInt(paramInt);
          this.a.transact(20, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final int j()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          localParcel2.recycle();
          localParcel1.recycle();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return localObject;
      }
      
      public final void d(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeInt(paramInt);
          this.a.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void a(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeString(paramString);
          this.a.transact(23, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void c(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeInt(paramBoolean ? 1 : 0);
          this.a.transact(24, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void d(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeInt(paramBoolean ? 1 : 0);
          this.a.transact(25, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void a(e parame)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeStrongBinder(parame != null ? parame.asBinder() : null);
          this.a.transact(26, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void a(h paramh)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeStrongBinder(paramh != null ? paramh.asBinder() : null);
          this.a.transact(27, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void a(g paramg)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeStrongBinder(paramg != null ? paramg.asBinder() : null);
          this.a.transact(28, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void a(f paramf)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeStrongBinder(paramf != null ? paramf.asBinder() : null);
          this.a.transact(29, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void k()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(30, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void l()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(31, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void a(Configuration paramConfiguration)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          if (paramConfiguration != null)
          {
            localParcel1.writeInt(1);
            paramConfiguration.writeToParcel(localParcel1, 0);
          }
          else
          {
            localParcel1.writeInt(0);
          }
          this.a.transact(32, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void m()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(33, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void n()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(34, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void o()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(35, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void p()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(36, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void e(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeInt(paramBoolean ? 1 : 0);
          this.a.transact(37, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final void q()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(38, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public final Bundle r()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(39, localParcel1, localParcel2, 0);
          localParcel2.readException();
          Bundle localBundle1;
          if (0 != localParcel2.readInt()) {
            localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
          } else {
            localBundle1 = null;
          }
          localParcel2.recycle();
          localParcel1.recycle();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return localBundle2;
      }
      
      public final boolean a(Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          else
          {
            localParcel1.writeInt(0);
          }
          this.a.transact(40, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramBundle = 0 != localParcel2.readInt() ? 1 : 0;
          localParcel2.recycle();
          localParcel1.recycle();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return paramBundle;
      }
      
      public final boolean a(int paramInt, KeyEvent paramKeyEvent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeInt(paramInt);
          if (paramKeyEvent != null)
          {
            localParcel1.writeInt(1);
            paramKeyEvent.writeToParcel(localParcel1, 0);
          }
          else
          {
            localParcel1.writeInt(0);
          }
          this.a.transact(41, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = 0 != localParcel2.readInt() ? 1 : 0;
          localParcel2.recycle();
          localParcel1.recycle();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return paramInt;
      }
      
      public final boolean b(int paramInt, KeyEvent paramKeyEvent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          localParcel1.writeInt(paramInt);
          if (paramKeyEvent != null)
          {
            localParcel1.writeInt(1);
            paramKeyEvent.writeToParcel(localParcel1, 0);
          }
          else
          {
            localParcel1.writeInt(0);
          }
          this.a.transact(42, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = 0 != localParcel2.readInt() ? 1 : 0;
          localParcel2.recycle();
          localParcel1.recycle();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return paramInt;
      }
      
      public final u s()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
          this.a.transact(43, localParcel1, localParcel2, 0);
          localParcel2.readException();
          u localu1 = u.a.a(localParcel2.readStrongBinder());
          localParcel2.recycle();
          localParcel1.recycle();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return localu2;
      }
    }
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.d
 * JD-Core Version:    0.7.0.1
 */