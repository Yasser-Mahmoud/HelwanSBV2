package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface g
  extends IInterface
{
  public abstract void a()
    throws RemoteException;
  
  public abstract void a(String paramString)
    throws RemoteException;
  
  public abstract void b()
    throws RemoteException;
  
  public abstract void c()
    throws RemoteException;
  
  public abstract void d()
    throws RemoteException;
  
  public abstract void b(String paramString)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements g
  {
    public a()
    {
      attachInterface(this, "com.google.android.youtube.player.internal.IPlayerStateChangeListener");
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      case 1598968902: 
        paramParcel2.writeString("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
        a();
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
        paramInt1 = paramParcel1.readString();
        a(paramInt1);
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
        b();
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
        c();
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
        d();
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
        paramInt1 = paramParcel1.readString();
        b(paramInt1);
        paramParcel2.writeNoException();
        return true;
      }
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    
    private static class a
      implements g
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
      
      public final void a()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
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
      
      public final void a(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
          localParcel1.writeString(paramString);
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
      
      public final void b()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
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
      
      public final void c()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
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
      
      public final void d()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
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
      
      public final void b(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
          localParcel1.writeString(paramString);
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
    }
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.g
 * JD-Core Version:    0.7.0.1
 */