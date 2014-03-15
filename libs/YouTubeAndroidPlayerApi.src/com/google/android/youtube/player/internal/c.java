package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface c
  extends IInterface
{
  public abstract void a(String paramString, IBinder paramIBinder)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements c
  {
    public a()
    {
      attachInterface(this, "com.google.android.youtube.player.internal.IConnectionCallbacks");
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
        paramParcel2.writeString("com.google.android.youtube.player.internal.IConnectionCallbacks");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IConnectionCallbacks");
        paramInt1 = paramParcel1.readString();
        paramParcel1 = paramParcel1.readStrongBinder();
        a(paramInt1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    
    private static class a
      implements c
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
      
      public final void a(String paramString, IBinder paramIBinder)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IConnectionCallbacks");
          localParcel1.writeString(paramString);
          localParcel1.writeStrongBinder(paramIBinder);
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
    }
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.c
 * JD-Core Version:    0.7.0.1
 */