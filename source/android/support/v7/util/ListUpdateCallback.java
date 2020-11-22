package android.support.v7.util;

import android.support.annotation.Nullable;

public abstract interface ListUpdateCallback
{
  public abstract void onChanged(int paramInt1, int paramInt2, @Nullable Object paramObject);
  
  public abstract void onInserted(int paramInt1, int paramInt2);
  
  public abstract void onMoved(int paramInt1, int paramInt2);
  
  public abstract void onRemoved(int paramInt1, int paramInt2);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\util\ListUpdateCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */