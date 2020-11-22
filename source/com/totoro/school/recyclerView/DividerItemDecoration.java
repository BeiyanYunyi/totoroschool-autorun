package com.totoro.school.recyclerView;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public class DividerItemDecoration
  extends RecyclerView.ItemDecoration
{
  private static final int[] a = { 16843284 };
  private Drawable b;
  
  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getPaddingLeft();
    int k = paramRecyclerView.getWidth();
    int m = paramRecyclerView.getPaddingRight();
    int n = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < n)
    {
      View localView = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      int i1 = localView.getBottom() + localLayoutParams.bottomMargin;
      int i2 = this.b.getIntrinsicHeight();
      this.b.setBounds(j, i1, k - m, i2 + i1);
      this.b.draw(paramCanvas);
      i += 1;
    }
  }
  
  public void b(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getPaddingTop();
    int k = paramRecyclerView.getHeight();
    int m = paramRecyclerView.getPaddingBottom();
    int n = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < n)
    {
      View localView = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      int i1 = localView.getRight() + localLayoutParams.rightMargin;
      int i2 = this.b.getIntrinsicHeight();
      this.b.setBounds(i1, j, i2 + i1, k - m);
      this.b.draw(paramCanvas);
      i += 1;
    }
  }
  
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    paramRect.set(0, 0, 0, this.b.getIntrinsicHeight());
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    a(paramCanvas, paramRecyclerView);
    b(paramCanvas, paramRecyclerView);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\recyclerView\DividerItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */