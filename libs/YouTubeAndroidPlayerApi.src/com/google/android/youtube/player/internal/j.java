package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface j
  extends IInterface
{
  public abstract void a(Bitmap paramBitmap, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public abstract void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements j
  {
    public a()
    {
      attachInterface(this, "com.google.android.youtube.player.internal.IThumbnailLoaderClient");
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool;
      switch (paramInt1)
      {
      case 1598968902: 
        paramParcel2.writeString("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
        if (0 != paramParcel1.readInt()) {
          paramInt1 = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1);
        } else {
          paramInt1 = null;
        }
        paramInt2 = paramParcel1.readString();
        bool = 0 != paramParcel1.readInt();
        paramParcel1 = 0 != paramParcel1.readInt() ? 1 : 0;
        a(paramInt1, paramInt2, bool, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
        paramInt1 = paramParcel1.readString();
        paramInt2 = 0 != paramParcel1.readInt() ? 1 : 0;
        bool = 0 != paramParcel1.readInt();
        a(paramInt1, paramInt2, bool);
        paramParcel2.writeNoException();
        return true;
      }
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    
    private static class a
      implements j
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
      
      public final void a(Bitmap paramBitmap, String paramString, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
          if (paramBitmap != null)
          {
            localParcel1.writeInt(1);
            paramBitmap.writeToParcel(localParcel1, 0);
          }
          else
          {
            localParcel1.writeInt(0);
          }
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramBoolean1 ? 1 : 0);
          localParcel1.writeInt(paramBoolean2 ? 1 : 0);
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
      
      public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramBoolean1 ? 1 : 0);
          localParcel1.writeInt(paramBoolean2 ? 1 : 0);
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
    }
  }
}


/* Location:           E:\Android\Workspace\HelwanSBV2\libs\YouTubeAndroidPlayerApi.jar
 * Qualified Name:     com.google.android.youtube.player.internal.j
 * JD-Core Version:    0.7.0.1
 */