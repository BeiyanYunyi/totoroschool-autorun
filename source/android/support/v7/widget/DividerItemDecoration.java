package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

public class DividerItemDecoration
  extends RecyclerView.ItemDecoration
{
  private static final int[] ATTRS = { 16843284 };
  public static final int HORIZONTAL = 0;
  private static final String TAG = "DividerItem";
  public static final int VERTICAL = 1;
  private final Rect mBounds = new Rect();
  private Drawable mDivider;
  private int mOrientation;
  
  public DividerItemDecoration(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(ATTRS);
    this.mDivider = paramContext.getDrawable(0);
    if (this.mDivider == null) {
      Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
    }
    paramContext.recycle();
    setOrientation(paramInt);
  }
  
  private void drawHorizontal(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    paramCanvas.save();
    boolean bool = paramRecyclerView.getClipToPadding();
    int k = 0;
    int i;
    int j;
    if (bool)
    {
      i = paramRecyclerView.getPaddingTop();
      j = paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom();
      paramCanvas.clipRect(paramRecyclerView.getPaddingLeft(), i, paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight(), j);
    }
    else
    {
      j = paramRecyclerView.getHeight();
      i = 0;
    }
    int m = paramRecyclerView.getChildCount();
    while (k < m)
    {
      View localView = paramRecyclerView.getChildAt(k);
      paramRecyclerView.getLayoutManager().getDecoratedBoundsWithMargins(localView, this.mBounds);
      int n = this.mBounds.right + Math.round(localView.getTranslationX());
      int i1 = this.mDivider.getIntrinsicWidth();
      this.mDivider.setBounds(n - i1, i, n, j);
      this.mDivider.draw(paramCanvas);
      k += 1;
    }
    paramCanvas.restore();
  }
  
  private void drawVertical(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    paramCanvas.save();
    boolean bool = paramRecyclerView.getClipToPadding();
    int k = 0;
    int i;
    int j;
    if (bool)
    {
      i = paramRecyclerView.getPaddingLeft();
      j = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
      paramCanvas.clipRect(i, paramRecyclerView.getPaddingTop(), j, paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
    }
    else
    {
      j = paramRecyclerView.getWidth();
      i = 0;
    }
    int m = paramRecyclerView.getChildCount();
    while (k < m)
    {
      View localView = paramRecyclerView.getChildAt(k);
      paramRecyclerView.getDecoratedBoundsWithMargins(localView, this.mBounds);
      int n = this.mBounds.bottom + Math.round(localView.getTranslationY());
      int i1 = this.mDivider.getIntrinsicHeight();
      this.mDivider.setBounds(i, n - i1, j, n);
      this.mDivider.draw(paramCanvas);
      k += 1;
    }
    paramCanvas.restore();
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (this.mDivider == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    if (this.mOrientation == 1)
    {
      paramRect.set(0, 0, 0, this.mDivider.getIntrinsicHeight());
      return;
    }
    paramRect.set(0, 0, this.mDivider.getIntrinsicWidth(), 0);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (paramRecyclerView.getLayoutManager() != null)
    {
      if (this.mDivider == null) {
        return;
      }
      if (this.mOrientation == 1)
      {
        drawVertical(paramCanvas, paramRecyclerView);
        return;
      }
      drawHorizontal(paramCanvas, paramRecyclerView);
      return;
    }
  }
  
  public void setDrawable(@NonNull Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.mDivider = paramDrawable;
      return;
    }
    throw new IllegalArgumentException("Drawable cannot be null.");
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }
    this.mOrientation = paramInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\DividerItemDecoration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */