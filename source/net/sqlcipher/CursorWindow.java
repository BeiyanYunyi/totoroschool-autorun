package net.sqlcipher;

import android.database.CharArrayBuffer;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CursorWindow
  extends android.database.CursorWindow
  implements Parcelable
{
  public static final Parcelable.Creator<CursorWindow> CREATOR = new Parcelable.Creator()
  {
    public CursorWindow createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CursorWindow(paramAnonymousParcel, 0);
    }
    
    public CursorWindow[] newArray(int paramAnonymousInt)
    {
      return new CursorWindow[paramAnonymousInt];
    }
  };
  private static CursorWindowAllocation allocation = new DefaultCursorWindowAllocation();
  private int mRequiredPos;
  private int mStartPos;
  private long nWindow;
  
  public CursorWindow(Parcel paramParcel, int paramInt)
  {
    super(true);
    IBinder localIBinder = paramParcel.readStrongBinder();
    this.mStartPos = paramParcel.readInt();
    native_init(localIBinder);
  }
  
  public CursorWindow(boolean paramBoolean)
  {
    super(paramBoolean);
    this.mStartPos = 0;
    if (allocation == null) {
      allocation = new DefaultCursorWindowAllocation();
    }
    native_init(paramBoolean, allocation.getInitialAllocationSize(), allocation.getGrowthPaddingSize(), allocation.getMaxAllocationSize());
  }
  
  private native boolean allocRow_native();
  
  private native void close_native();
  
  private native char[] copyStringToBuffer_native(int paramInt1, int paramInt2, int paramInt3, CharArrayBuffer paramCharArrayBuffer);
  
  private native void freeLastRow_native();
  
  private native byte[] getBlob_native(int paramInt1, int paramInt2);
  
  public static CursorWindowAllocation getCursorWindowAllocation()
  {
    return allocation;
  }
  
  private native double getDouble_native(int paramInt1, int paramInt2);
  
  private native long getLong_native(int paramInt1, int paramInt2);
  
  private native int getNumRows_native();
  
  private native String getString_native(int paramInt1, int paramInt2);
  
  private native int getType_native(int paramInt1, int paramInt2);
  
  private native boolean isBlob_native(int paramInt1, int paramInt2);
  
  private native boolean isFloat_native(int paramInt1, int paramInt2);
  
  private native boolean isInteger_native(int paramInt1, int paramInt2);
  
  private native boolean isNull_native(int paramInt1, int paramInt2);
  
  private native boolean isString_native(int paramInt1, int paramInt2);
  
  private native void native_clear();
  
  private native IBinder native_getBinder();
  
  private native void native_init(IBinder paramIBinder);
  
  private native void native_init(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3);
  
  public static CursorWindow newFromParcel(Parcel paramParcel)
  {
    return (CursorWindow)CREATOR.createFromParcel(paramParcel);
  }
  
  private native boolean putBlob_native(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native boolean putDouble_native(double paramDouble, int paramInt1, int paramInt2);
  
  private native boolean putLong_native(long paramLong, int paramInt1, int paramInt2);
  
  private native boolean putNull_native(int paramInt1, int paramInt2);
  
  private native boolean putString_native(String paramString, int paramInt1, int paramInt2);
  
  public static void setCursorWindowAllocation(CursorWindowAllocation paramCursorWindowAllocation)
  {
    allocation = paramCursorWindowAllocation;
  }
  
  private native boolean setNumColumns_native(int paramInt);
  
  public boolean allocRow()
  {
    acquireReference();
    try
    {
      boolean bool = allocRow_native();
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void clear()
  {
    acquireReference();
    try
    {
      this.mStartPos = 0;
      native_clear();
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void close()
  {
    releaseReference();
  }
  
  public void copyStringToBuffer(int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    if (paramCharArrayBuffer != null)
    {
      if (paramCharArrayBuffer.data == null) {
        paramCharArrayBuffer.data = new char[64];
      }
      acquireReference();
      try
      {
        char[] arrayOfChar = copyStringToBuffer_native(paramInt1 - this.mStartPos, paramInt2, paramCharArrayBuffer.data.length, paramCharArrayBuffer);
        if (arrayOfChar != null) {
          paramCharArrayBuffer.data = arrayOfChar;
        }
        return;
      }
      finally
      {
        releaseReference();
      }
    }
    throw new IllegalArgumentException("CharArrayBuffer should not be null");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void finalize()
  {
    if (this.nWindow == 0L) {
      return;
    }
    close_native();
  }
  
  public void freeLastRow()
  {
    acquireReference();
    try
    {
      freeLastRow_native();
      return;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public byte[] getBlob(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      byte[] arrayOfByte = getBlob_native(paramInt1 - this.mStartPos, paramInt2);
      return arrayOfByte;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public double getDouble(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      double d = getDouble_native(paramInt1 - this.mStartPos, paramInt2);
      return d;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public float getFloat(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      double d = getDouble_native(paramInt1 - this.mStartPos, paramInt2);
      float f = (float)d;
      return f;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public int getInt(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      long l = getLong_native(paramInt1 - this.mStartPos, paramInt2);
      paramInt1 = (int)l;
      return paramInt1;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public long getLong(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      long l = getLong_native(paramInt1 - this.mStartPos, paramInt2);
      return l;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public int getNumRows()
  {
    acquireReference();
    try
    {
      int i = getNumRows_native();
      return i;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public int getRequiredPosition()
  {
    return this.mRequiredPos;
  }
  
  public short getShort(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      long l = getLong_native(paramInt1 - this.mStartPos, paramInt2);
      short s = (short)(int)l;
      return s;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public int getStartPosition()
  {
    return this.mStartPos;
  }
  
  public String getString(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      String str = getString_native(paramInt1 - this.mStartPos, paramInt2);
      return str;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public int getType(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      paramInt1 = getType_native(paramInt1 - this.mStartPos, paramInt2);
      return paramInt1;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean isBlob(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = isBlob_native(paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean isFloat(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = isFloat_native(paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean isLong(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = isInteger_native(paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean isNull(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = isNull_native(paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean isString(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = isString_native(paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  protected void onAllReferencesReleased()
  {
    close_native();
    super.onAllReferencesReleased();
  }
  
  public boolean putBlob(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = putBlob_native(paramArrayOfByte, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean putDouble(double paramDouble, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = putDouble_native(paramDouble, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean putLong(long paramLong, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = putLong_native(paramLong, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean putNull(int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = putNull_native(paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean putString(String paramString, int paramInt1, int paramInt2)
  {
    acquireReference();
    try
    {
      boolean bool = putString_native(paramString, paramInt1 - this.mStartPos, paramInt2);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public boolean setNumColumns(int paramInt)
  {
    acquireReference();
    try
    {
      boolean bool = setNumColumns_native(paramInt);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void setRequiredPosition(int paramInt)
  {
    this.mRequiredPos = paramInt;
  }
  
  public void setStartPosition(int paramInt)
  {
    this.mStartPos = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(native_getBinder());
    paramParcel.writeInt(this.mStartPos);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\CursorWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */