package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class SnapHelper
  extends RecyclerView.OnFlingListener
{
  static final float MILLISECONDS_PER_INCH = 100.0F;
  private Scroller mGravityScroller;
  RecyclerView mRecyclerView;
  private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener()
  {
    boolean mScrolled = false;
    
    public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
      if ((paramAnonymousInt == 0) && (this.mScrolled))
      {
        this.mScrolled = false;
        SnapHelper.this.snapToTargetExistingView();
      }
    }
    
    public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
        this.mScrolled = true;
      }
    }
  };
  
  private void destroyCallbacks()
  {
    this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
    this.mRecyclerView.setOnFlingListener(null);
  }
  
  private void setupCallbacks()
    throws IllegalStateException
  {
    if (this.mRecyclerView.getOnFlingListener() == null)
    {
      this.mRecyclerView.addOnScrollListener(this.mScrollListener);
      this.mRecyclerView.setOnFlingListener(this);
      return;
    }
    throw new IllegalStateException("An instance of OnFlingListener already set.");
  }
  
  private boolean snapFromFling(@NonNull RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
      return false;
    }
    RecyclerView.SmoothScroller localSmoothScroller = createScroller(paramLayoutManager);
    if (localSmoothScroller == null) {
      return false;
    }
    paramInt1 = findTargetSnapPosition(paramLayoutManager, paramInt1, paramInt2);
    if (paramInt1 == -1) {
      return false;
    }
    localSmoothScroller.setTargetPosition(paramInt1);
    paramLayoutManager.startSmoothScroll(localSmoothScroller);
    return true;
  }
  
  public void attachToRecyclerView(@Nullable RecyclerView paramRecyclerView)
    throws IllegalStateException
  {
    if (this.mRecyclerView == paramRecyclerView) {
      return;
    }
    if (this.mRecyclerView != null) {
      destroyCallbacks();
    }
    this.mRecyclerView = paramRecyclerView;
    if (this.mRecyclerView != null)
    {
      setupCallbacks();
      this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
      snapToTargetExistingView();
    }
  }
  
  @Nullable
  public abstract int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView);
  
  public int[] calculateScrollDistance(int paramInt1, int paramInt2)
  {
    this.mGravityScroller.fling(0, 0, paramInt1, paramInt2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
    return new int[] { this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY() };
  }
  
  @Nullable
  protected RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager paramLayoutManager)
  {
    return createSnapScroller(paramLayoutManager);
  }
  
  @Deprecated
  @Nullable
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
      
      protected void onTargetFound(View paramAnonymousView, RecyclerView.State paramAnonymousState, RecyclerView.SmoothScroller.Action paramAnonymousAction)
      {
        if (SnapHelper.this.mRecyclerView == null) {
          return;
        }
        paramAnonymousView = SnapHelper.this.calculateDistanceToFinalSnap(SnapHelper.this.mRecyclerView.getLayoutManager(), paramAnonymousView);
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
  public abstract View findSnapView(RecyclerView.LayoutManager paramLayoutManager);
  
  public abstract int findTargetSnapPosition(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2);
  
  public boolean onFling(int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mRecyclerView.getLayoutManager();
    boolean bool2 = false;
    if (localLayoutManager == null) {
      return false;
    }
    if (this.mRecyclerView.getAdapter() == null) {
      return false;
    }
    int i = this.mRecyclerView.getMinFlingVelocity();
    boolean bool1;
    if (Math.abs(paramInt2) <= i)
    {
      bool1 = bool2;
      if (Math.abs(paramInt1) <= i) {}
    }
    else
    {
      bool1 = bool2;
      if (snapFromFling(localLayoutManager, paramInt1, paramInt2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  void snapToTargetExistingView()
  {
    if (this.mRecyclerView == null) {
      return;
    }
    Object localObject = this.mRecyclerView.getLayoutManager();
    if (localObject == null) {
      return;
    }
    View localView = findSnapView((RecyclerView.LayoutManager)localObject);
    if (localView == null) {
      return;
    }
    localObject = calculateDistanceToFinalSnap((RecyclerView.LayoutManager)localObject, localView);
    if ((localObject[0] != 0) || (localObject[1] != 0)) {
      this.mRecyclerView.smoothScrollBy(localObject[0], localObject[1]);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\SnapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */