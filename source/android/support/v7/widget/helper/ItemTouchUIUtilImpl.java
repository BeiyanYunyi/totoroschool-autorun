package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R.id;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class ItemTouchUIUtilImpl
  implements ItemTouchUIUtil
{
  static final ItemTouchUIUtil INSTANCE = new ItemTouchUIUtilImpl();
  
  private static float findMaxElevation(RecyclerView paramRecyclerView, View paramView)
  {
    int j = paramRecyclerView.getChildCount();
    float f1 = 0.0F;
    int i = 0;
    while (i < j)
    {
      View localView = paramRecyclerView.getChildAt(i);
      float f2;
      if (localView == paramView)
      {
        f2 = f1;
      }
      else
      {
        float f3 = ViewCompat.getElevation(localView);
        f2 = f1;
        if (f3 > f1) {
          f2 = f3;
        }
      }
      i += 1;
      f1 = f2;
    }
    return f1;
  }
  
  public void clearView(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = paramView.getTag(R.id.item_touch_helper_previous_elevation);
      if ((localObject != null) && ((localObject instanceof Float))) {
        ViewCompat.setElevation(paramView, ((Float)localObject).floatValue());
      }
      paramView.setTag(R.id.item_touch_helper_previous_elevation, null);
    }
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramBoolean) && (paramView.getTag(R.id.item_touch_helper_previous_elevation) == null))
    {
      float f = ViewCompat.getElevation(paramView);
      ViewCompat.setElevation(paramView, findMaxElevation(paramRecyclerView, paramView) + 1.0F);
      paramView.setTag(R.id.item_touch_helper_previous_elevation, Float.valueOf(f));
    }
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean) {}
  
  public void onSelected(View paramView) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\helper\ItemTouchUIUtilImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */