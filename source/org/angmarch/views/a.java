package org.angmarch.views;

import android.content.Context;
import java.util.List;

public class a<T>
  extends c
{
  private final List<T> b;
  
  a(Context paramContext, List<T> paramList, int paramInt1, int paramInt2, e parame)
  {
    super(paramContext, paramInt1, paramInt2, parame);
    this.b = paramList;
  }
  
  public T a(int paramInt)
  {
    return (T)this.b.get(paramInt);
  }
  
  public int getCount()
  {
    return this.b.size() - 1;
  }
  
  public T getItem(int paramInt)
  {
    if (paramInt >= this.a) {
      return (T)this.b.get(paramInt + 1);
    }
    return (T)this.b.get(paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\angmarch\views\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */