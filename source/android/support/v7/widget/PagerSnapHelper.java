package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;

public class PagerSnapHelper
  extends SnapHelper
{
  private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
  @Nullable
  private OrientationHelper mHorizontalHelper;
  @Nullable
  private OrientationHelper mVerticalHelper;
  
  private int distanceToCenter(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    int j = paramOrientationHelper.getDecoratedStart(paramView);
    int k = paramOrientationHelper.getDecoratedMeasurement(paramView) / 2;
    int i;
    if (paramLayoutManager.getClipToPadding()) {
      i = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;
    } else {
      i = paramOrientationHelper.getEnd() / 2;
    }
    return j + k - i;
  }
  
  @Nullable
  private View findCenterView(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    int i1 = paramLayoutManager.getChildCount();
    Object localObject = null;
    if (i1 == 0) {
      return null;
    }
    int i;
    if (paramLayoutManager.getClipToPadding()) {
      i = paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2;
    } else {
      i = paramOrientationHelper.getEnd() / 2;
    }
    int k = Integer.MAX_VALUE;
    int j = 0;
    while (j < i1)
    {
      View localView = paramLayoutManager.getChildAt(j);
      int n = Math.abs(paramOrientationHelper.getDecoratedStart(localView) + paramOrientationHelper.getDecoratedMeasurement(localView) / 2 - i);
      int m = k;
      if (n < k)
      {
        localObject = localView;
        m = n;
      }
      j += 1;
      k = m;
    }
    return (View)localObject;
  }
  
  @Nullable
  private View findStartView(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    int n = paramLayoutManager.getChildCount();
    Object localObject = null;
    if (n == 0) {
      return null;
    }
    int j = Integer.MAX_VALUE;
    int i = 0;
    while (i < n)
    {
      View localView = paramLayoutManager.getChildAt(i);
      int m = paramOrientationHelper.getDecoratedStart(localView);
      int k = j;
      if (m < j)
      {
        localObject = localView;
        k = m;
      }
      i += 1;
      j = k;
    }
    return (View)localObject;
  }
  
  @NonNull
  private OrientationHelper getHorizontalHelper(@NonNull RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((this.mHorizontalHelper == null) || (this.mHorizontalHelper.mLayoutManager != paramLayoutManager)) {
      this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(paramLayoutManager);
    }
    return this.mHorizontalHelper;
  }
  
  @NonNull
  private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((this.mVerticalHelper == null) || (this.mVerticalHelper.mLayoutManager != paramLayoutManager)) {
      this.mVerticalHelper = OrientationHelper.createVerticalHelper(paramLayoutManager);
    }
    return this.mVerticalHelper;
  }
  
  @Nullable
  public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = distanceToCenter(paramLayoutManager, paramView, getHorizontalHelper(paramLayoutManager));
    } else {
      arrayOfInt[0] = 0;
    }
    if (paramLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = distanceToCenter(paramLayoutManager, paramView, getVerticalHelper(paramLayoutManager));
      return arrayOfInt;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
      return null;
    }
    new LinearSmoothScroller(this.mRecyclerView.getContext())
    {
      protected float calculateSpeedPerPixel(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      protected int calculateTimeForScrolling(int paramAnonymousInt)
      {
        return Math.min(100, super.calculateTimeForScrolling(paramAnonymousInt));
      }
      
      protected void onTargetFound(View paramAnonymousView, RecyclerView.State paramAnonymousState, RecyclerView.SmoothScroller.Action paramAnonymousAction)
      {
        paramAnonymousView = PagerSnapHelper.this.calculateDistanceToFinalSnap(PagerSnapHelper.this.mRecyclerView.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousAction.update(i, j, k, this.mDecelerateInterpolator);
        }
      }
    };
  }
  
  @Nullable
  public View findSnapView(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager.canScrollVertically()) {
      return findCenterView(paramLayoutManager, getVerticalHelper(paramLayoutManager));
    }
    if (paramLayoutManager.canScrollHorizontally()) {
      return findCenterView(paramLayoutManager, getHorizontalHelper(paramLayoutManager));
    }
    return null;
  }
  
  public int findTargetSnapPosition(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int k = paramLayoutManager.getItemCount();
    if (k == 0) {
      return -1;
    }
    View localView = null;
    if (paramLayoutManager.canScrollVertically()) {
      localView = findStartView(paramLayoutManager, getVerticalHelper(paramLayoutManager));
    } else if (paramLayoutManager.canScrollHorizontally()) {
      localView = findStartView(paramLayoutManager, getHorizontalHelper(paramLayoutManager));
    }
    if (localView == null) {
      return -1;
    }
    int i = paramLayoutManager.getPosition(localView);
    if (i == -1) {
      return -1;
    }
    boolean bool = paramLayoutManager.canScrollHorizontally();
    int j = 0;
    if (bool) {
      if (paramInt1 <= 0) {}
    }
    for (;;)
    {
      paramInt1 = 1;
      break;
      do
      {
        paramInt1 = 0;
        break;
      } while (paramInt2 <= 0);
    }
    paramInt2 = j;
    if ((paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider))
    {
      paramLayoutManager = ((RecyclerView.SmoothScroller.ScrollVectorProvider)paramLayoutManager).computeScrollVectorForPosition(k - 1);
      paramInt2 = j;
      if (paramLayoutManager != null) {
        if (paramLayoutManager.x >= 0.0F)
        {
          paramInt2 = j;
          if (paramLayoutManager.y >= 0.0F) {}
        }
        else
        {
          paramInt2 = 1;
        }
      }
    }
    if (paramInt2 != 0)
    {
      paramInt2 = i;
      if (paramInt1 != 0) {
        return i - 1;
      }
    }
    else
    {
      paramInt2 = i;
      if (paramInt1 != 0) {
        paramInt2 = i + 1;
      }
    }
    return paramInt2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\PagerSnapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */