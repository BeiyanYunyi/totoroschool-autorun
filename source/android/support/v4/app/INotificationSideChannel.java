package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface INotificationSideChannel
  extends IInterface
{
  public abstract void cancel(String paramString1, int paramInt, String paramString2)
    throws RemoteException;
  
  public abstract void cancelAll(String paramString)
    throws RemoteException;
  
  public abstract void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements INotificationSideChannel
  {
    private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
    static final int TRANSACTION_cancel = 2;
    static final int TRANSACTION_cancelAll = 3;
    static final int TRANSACTION_notify = 1;
    
    public Stub()
    {
      attachInterface(this, "android.support.v4.app.INotificationSideChannel");
    }
    
    public static INotificationSideChannel asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
      if ((localIInterface != null) && ((localIInterface instanceof INotificationSideChannel))) {
        return (INotificationSideChannel)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      if (paramInt1 != 1598968902)
      {
        switch (paramInt1)
        {
        default: 
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        case 3: 
          paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
          cancelAll(paramParcel1.readString());
          return true;
        case 2: 
          paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
          cancel(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
          return true;
        }
        paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
        paramParcel2 = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        String str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          paramParcel1 = (Notification)Notification.CREATOR.createFromParcel(paramParcel1);
        } else {
          paramParcel1 = null;
        }
        notify(paramParcel2, paramInt1, str, paramParcel1);
        return true;
      }
      paramParcel2.writeString("android.support.v4.app.INotificationSideChannel");
      return true;
    }
    
    private static class Proxy
      implements INotificationSideChannel
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void cancel(String paramString1, int paramInt, String paramString2)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
          localParcel.writeString(paramString1);
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString2);
          this.mRemote.transact(2, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void cancelAll(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
          localParcel.writeString(paramString);
          this.mRemote.transact(3, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "android.support.v4.app.INotificationSideChannel";
      }
      
      public void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
          localParcel.writeString(paramString1);
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString2);
          if (paramNotification != null)
          {
            localParcel.writeInt(1);
            paramNotification.writeToParcel(localParcel, 0);
          }
          else
          {
            localParcel.writeInt(0);
          }
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\app\INotificationSideChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */