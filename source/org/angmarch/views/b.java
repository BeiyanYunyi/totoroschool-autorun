package org.angmarch.views;

import android.content.Context;
import android.widget.ListAdapter;

public class b
  extends c
{
  private final ListAdapter b;
  
  b(Context paramContext, ListAdapter paramListAdapter, int paramInt1, int paramInt2, e parame)
  {
    super(paramContext, paramInt1, paramInt2, parame);
    this.b = paramListAdapter;
  }
  
  public Object a(int paramInt)
  {
    return this.b.getItem(paramInt);
  }
  
  public int getCount()
  {
    return this.b.getCount() - 1;
  }
  
  public Object getItem(int paramInt)
  {
    ListAdapter localListAdapter = this.b;
    int i = paramInt;
    if (paramInt >= this.a) {
      i = paramInt + 1;
    }
    return localListAdapter.getItem(i);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\angmarch\views\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */