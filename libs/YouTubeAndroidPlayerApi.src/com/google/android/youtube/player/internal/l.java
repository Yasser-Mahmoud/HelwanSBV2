package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface l
  extends IInterface
{
  public abstract IBinder a()
    throws RemoteException;
  
  public abstract k a(j paramj)
    throws RemoteException;
  
  public abstract void a(boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements l
  {
    public static l a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface;
      if (((localIInterface = paramIBinder.queryLocalInterface("com.google.android.youtube.player.internal.IYouTubeService")) != null) && ((localIInterface instanceof l))) {
        return (l)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      case 1598968902: 
        paramParcel2.writeString("com.google.android.youtube.player.internal.IYouTubeService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
        paramInt1 = a();
        paramParcel2.writeNoException();
        paramParcel2.writeStrongBinder(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
        paramInt1 = ((paramParcel1 = paramInt1.queryLocalInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient")) != null) && ((paramParcel1 instanceof j)) ? (j)paramParcel1 : (paramInt1 = paramParcel1.readStrongBinder()) == null ? null : new j.a.a(paramInt1);
        paramInt1 = a(paramInt1);
        paramParcel2.writeNoException();
        paramParcel2.writeStrongBinder(paramInt1 != null ? paramInt1.asBinder() : null);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
        paramInt1 = 0 != paramParcel1.readInt() ? 1 : 0;
        a(paramInt1);
        paramParcel2.writeNoException();
        return true;
      }
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    
    private static class a
      implements l
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
      
      public final IBinder a()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IBinder localIBinder1 = localParcel2.readStrongBinder();
          localParcel2.recycle();
          localParcel1.recycle();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return localIBinder2;
      }
      
      public final k a(j paramj)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
          localParcel1.writeStrongBinder(paramj != null ? paramj.asBinder() : null);
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramj = k.a.a(localParcel2.readStrongBinder());
          localParcel2.recycle();
          localParcel1.recycle();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        return paramj;
      }
      
      public final void a(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
          localParcel1.writeInt(paramBoolean ? 1 : 0);
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
    }
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.l
 * JD-Core Version:    0.7.0.1
 */