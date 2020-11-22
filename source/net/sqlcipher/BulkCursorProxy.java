package net.sqlcipher;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

final class BulkCursorProxy
  implements IBulkCursor
{
  private Bundle mExtras;
  private IBinder mRemote;
  
  public BulkCursorProxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
    this.mExtras = null;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public void close()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    this.mRemote.transact(12, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    localParcel1.recycle();
    localParcel2.recycle();
  }
  
  public int count()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    boolean bool = this.mRemote.transact(2, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    int i;
    if (!bool) {
      i = -1;
    } else {
      i = localParcel2.readInt();
    }
    localParcel1.recycle();
    localParcel2.recycle();
    return i;
  }
  
  public void deactivate()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    this.mRemote.transact(6, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    localParcel1.recycle();
    localParcel2.recycle();
  }
  
  public boolean deleteRow(int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeInt(paramInt);
    IBinder localIBinder = this.mRemote;
    boolean bool = false;
    localIBinder.transact(5, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    if (localParcel2.readInt() == 1) {
      bool = true;
    }
    localParcel1.recycle();
    localParcel2.recycle();
    return bool;
  }
  
  public String[] getColumnNames()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    Object localObject = this.mRemote;
    int i = 0;
    ((IBinder)localObject).transact(3, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    int j = localParcel2.readInt();
    localObject = new String[j];
    while (i < j)
    {
      localObject[i] = localParcel2.readString();
      i += 1;
    }
    localParcel1.recycle();
    localParcel2.recycle();
    return (String[])localObject;
  }
  
  public Bundle getExtras()
    throws RemoteException
  {
    if (this.mExtras == null)
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      this.mRemote.transact(10, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      this.mExtras = localParcel2.readBundle(getClass().getClassLoader());
      localParcel1.recycle();
      localParcel2.recycle();
    }
    return this.mExtras;
  }
  
  public boolean getWantsAllOnMoveCalls()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    IBinder localIBinder = this.mRemote;
    boolean bool = false;
    localIBinder.transact(9, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    int i = localParcel2.readInt();
    localParcel1.recycle();
    localParcel2.recycle();
    if (i != 0) {
      bool = true;
    }
    return bool;
  }
  
  public CursorWindow getWindow(int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeInt(paramInt);
    this.mRemote.transact(1, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    CursorWindow localCursorWindow;
    if (localParcel2.readInt() == 1) {
      localCursorWindow = CursorWindow.newFromParcel(localParcel2);
    } else {
      localCursorWindow = null;
    }
    localParcel1.recycle();
    localParcel2.recycle();
    return localCursorWindow;
  }
  
  public void onMove(int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeInt(paramInt);
    this.mRemote.transact(8, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    localParcel1.recycle();
    localParcel2.recycle();
  }
  
  public int requery(IContentObserver paramIContentObserver, CursorWindow paramCursorWindow)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeStrongInterface(paramIContentObserver);
    paramCursorWindow.writeToParcel(localParcel1, 0);
    boolean bool = this.mRemote.transact(7, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    int i;
    if (!bool)
    {
      i = -1;
    }
    else
    {
      i = localParcel2.readInt();
      this.mExtras = localParcel2.readBundle(getClass().getClassLoader());
    }
    localParcel1.recycle();
    localParcel2.recycle();
    return i;
  }
  
  public Bundle respond(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeBundle(paramBundle);
    this.mRemote.transact(11, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    paramBundle = localParcel2.readBundle(getClass().getClassLoader());
    localParcel1.recycle();
    localParcel2.recycle();
    return paramBundle;
  }
  
  public boolean updateRows(Map paramMap)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    localParcel1.writeInterfaceToken("android.content.IBulkCursor");
    localParcel1.writeMap(paramMap);
    paramMap = this.mRemote;
    boolean bool = false;
    paramMap.transact(4, localParcel1, localParcel2, 0);
    DatabaseUtils.readExceptionFromParcel(localParcel2);
    if (localParcel2.readInt() == 1) {
      bool = true;
    }
    localParcel1.recycle();
    localParcel2.recycle();
    return bool;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\BulkCursorProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */