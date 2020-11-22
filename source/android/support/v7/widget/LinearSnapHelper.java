package android.support.v7.widget;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public class LinearSnapHelper
  extends SnapHelper
{
  private static final float INVALID_DISTANCE = 1.0F;
  @Nullable
  private OrientationHelper mHorizontalHelper;
  @Nullable
  private OrientationHelper mVerticalHelper;
  
  private float computeDistancePerChild(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    int i2 = paramLayoutManager.getChildCount();
    if (i2 == 0) {
      return 1.0F;
    }
    int m = 0;
    Object localObject1 = null;
    int i = Integer.MAX_VALUE;
    Object localObject2 = null;
    int i1;
    int j;
    for (int k = Integer.MIN_VALUE; m < i2; k = i1)
    {
      View localView = paramLayoutManager.getChildAt(m);
      int n = paramLayoutManager.getPosition(localView);
      Object localObject3;
      if (n == -1)
      {
        localObject3 = localObject1;
        i1 = k;
      }
      else
      {
        j = i;
        if (n < i)
        {
          localObject1 = localView;
          j = n;
        }
        localObject3 = localObject1;
        i = j;
        i1 = k;
        if (n > k)
        {
          localObject2 = localView;
          i1 = n;
          i = j;
          localObject3 = localObject1;
        }
      }
      m += 1;
      localObject1 = localObject3;
    }
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        return 1.0F;
      }
      j = Math.min(paramOrientationHelper.getDecoratedStart((View)localObject1), paramOrientationHelper.getDecoratedStart((View)localObject2));
      j = Math.max(paramOrientationHelper.getDecoratedEnd((View)localObject1), paramOrientationHelper.getDecoratedEnd((View)localObject2)) - j;
      if (j == 0) {
        return 1.0F;
      }
      return j * 1.0F / (k - i + 1);
    }
    return 1.0F;
  }
  
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
  
  private int estimateNextPositionDiffForFling(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = calculateScrollDistance(paramInt1, paramInt2);
    float f = computeDistancePerChild(paramLayoutManager, paramOrientationHelper);
    if (f <= 0.0F) {
      return 0;
    }
    if (Math.abs(arrayOfInt[0]) > Math.abs(arrayOfInt[1])) {
      paramInt1 = arrayOfInt[0];
    } else {
      paramInt1 = arrayOfInt[1];
    }
    return Math.round(paramInt1 / f);
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
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
      return -1;
    }
    int k = paramLayoutManager.getItemCount();
    if (k == 0) {
      return -1;
    }
    Object localObject = findSnapView(paramLayoutManager);
    if (localObject == null) {
      return -1;
    }
    int m = paramLayoutManager.getPosition((View)localObject);
    if (m == -1) {
      return -1;
    }
    localObject = (RecyclerView.SmoothScroller.ScrollVectorProvider)paramLayoutManager;
    int i = k - 1;
    localObject = ((RecyclerView.SmoothScroller.ScrollVectorProvider)localObject).computeScrollVectorForPosition(i);
    if (localObject == null) {
      return -1;
    }
    int j;
    if (paramLayoutManager.canScrollHorizontally())
    {
      j = estimateNextPositionDiffForFling(paramLayoutManager, getHorizontalHelper(paramLayoutManager), paramInt1, 0);
      paramInt1 = j;
      if (((PointF)localObject).x < 0.0F) {
        paramInt1 = -j;
      }
    }
    else
    {
      paramInt1 = 0;
    }
    if (paramLayoutManager.canScrollVertically())
    {
      j = estimateNextPositionDiffForFling(paramLayoutManager, getVerticalHelper(paramLayoutManager), 0, paramInt2);
      paramInt2 = j;
      if (((PointF)localObject).y < 0.0F) {
        paramInt2 = -j;
      }
    }
    else
    {
      paramInt2 = 0;
    }
    if (paramLayoutManager.canScrollVertically()) {
      paramInt1 = paramInt2;
    }
    if (paramInt1 == 0) {
      return -1;
    }
    paramInt2 = m + paramInt1;
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    paramInt2 = paramInt1;
    if (paramInt1 >= k) {
      paramInt2 = i;
    }
    return paramInt2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\LinearSnapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */