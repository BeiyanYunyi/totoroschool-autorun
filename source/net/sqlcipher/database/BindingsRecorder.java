package net.sqlcipher.database;

import android.util.SparseArray;
import androidx.a.a.c;

class BindingsRecorder
  implements c
{
  private SparseArray<Object> bindings = new SparseArray();
  
  public void bindBlob(int paramInt, byte[] paramArrayOfByte)
  {
    this.bindings.put(paramInt, paramArrayOfByte);
  }
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    this.bindings.put(paramInt, Double.valueOf(paramDouble));
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    this.bindings.put(paramInt, Long.valueOf(paramLong));
  }
  
  public void bindNull(int paramInt)
  {
    this.bindings.put(paramInt, null);
  }
  
  public void bindString(int paramInt, String paramString)
  {
    this.bindings.put(paramInt, paramString);
  }
  
  public void clearBindings()
  {
    this.bindings.clear();
  }
  
  public void close()
  {
    clearBindings();
  }
  
  String[] getBindings()
  {
    String[] arrayOfString = new String[this.bindings.size()];
    int i = 0;
    while (i < this.bindings.size())
    {
      int j = this.bindings.keyAt(i);
      if (this.bindings.get(j) != null) {
        arrayOfString[i] = this.bindings.get(j).toString();
      } else {
        arrayOfString[i] = "";
      }
      i += 1;
    }
    return arrayOfString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\database\BindingsRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */