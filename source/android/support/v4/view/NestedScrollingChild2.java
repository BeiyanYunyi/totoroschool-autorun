package android.support.v4.view;

import android.support.annotation.Nullable;

public abstract interface NestedScrollingChild2
  extends NestedScrollingChild
{
  public abstract boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, @Nullable int[] paramArrayOfInt1, @Nullable int[] paramArrayOfInt2, int paramInt3);
  
  public abstract boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable int[] paramArrayOfInt, int paramInt5);
  
  public abstract boolean hasNestedScrollingParent(int paramInt);
  
  public abstract boolean startNestedScroll(int paramInt1, int paramInt2);
  
  public abstract void stopNestedScroll(int paramInt);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\view\NestedScrollingChild2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */