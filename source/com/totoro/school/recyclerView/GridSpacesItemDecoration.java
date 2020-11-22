package com.totoro.school.recyclerView;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class GridSpacesItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.left = this.a;
    paramRect.right = this.a;
    paramRect.bottom = this.a;
    paramRect.top = this.a;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\recyclerView\GridSpacesItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */