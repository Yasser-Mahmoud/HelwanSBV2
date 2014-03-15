package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface i
  extends IInterface
{
  public abstract void a(c paramc, int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements i
  {
    public static i a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface;
      if (((localIInterface = paramIBinder.queryLocalInterface("com.google.android.youtube.player.internal.IServiceBroker")) != null) && ((localIInterface instanceof i))) {
        return (i)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      case 1598968902: 
        paramParcel2.writeString("com.google.android.youtube.player.internal.IServiceBroker");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IServiceBroker");
        paramInt1 = ((paramInt2 = paramInt1.queryLocalInterface("com.google.android.youtube.player.internal.IConnectionCallbacks")) != null) && ((paramInt2 instanceof c)) ? (c)paramInt2 : (paramInt1 = paramParcel1.readStrongBinder()) == null ? null : new c.a.a(paramInt1);
        paramInt2 = paramParcel1.readInt();
        String str1 = paramParcel1.readString();
        String str2 = paramParcel1.readString();
        String str3 = paramParcel1.readString();
        if (0 != paramParcel1.readInt()) {
          paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        } else {
          paramParcel1 = null;
        }
        a(paramInt1, paramInt2, str1, str2, str3, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    
    private static class a
      implements i
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
      
      public final void a(c paramc, int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IServiceBroker");
          localParcel1.writeStrongBinder(paramc != null ? paramc.asBinder() : null);
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeString(paramString3);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          else
          {
            localParcel1.writeInt(0);
          }
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
 * Qualified Name:     com.google.android.youtube.player.internal.i
 * JD-Core Version:    0.7.0.1
 */