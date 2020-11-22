package com.totoro.school.recyclerView;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class SpacesItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  
  public SpacesItemDecoration(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.bottom = this.a;
    if (paramRecyclerView.getChildLayoutPosition(paramView) == 0)
    {
      paramRect.top = this.a;
      return;
    }
    paramRect.top = 0;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\recyclerView\SpacesItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */