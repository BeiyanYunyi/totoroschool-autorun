package android.support.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;

@SuppressLint({"ViewConstructor"})
class GhostViewApi14
  extends View
  implements GhostViewImpl
{
  Matrix mCurrentMatrix;
  private int mDeltaX;
  private int mDeltaY;
  private final Matrix mMatrix = new Matrix();
  private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener()
  {
    public boolean onPreDraw()
    {
      GhostViewApi14.this.mCurrentMatrix = GhostViewApi14.this.mView.getMatrix();
      ViewCompat.postInvalidateOnAnimation(GhostViewApi14.this);
      if ((GhostViewApi14.this.mStartParent != null) && (GhostViewApi14.this.mStartView != null))
      {
        GhostViewApi14.this.mStartParent.endViewTransition(GhostViewApi14.this.mStartView);
        ViewCompat.postInvalidateOnAnimation(GhostViewApi14.this.mStartParent);
        GhostViewApi14.this.mStartParent = null;
        GhostViewApi14.this.mStartView = null;
      }
      return true;
    }
  };
  int mReferences;
  ViewGroup mStartParent;
  View mStartView;
  final View mView;
  
  GhostViewApi14(View paramView)
  {
    super(paramView.getContext());
    this.mView = paramView;
    setLayerType(2, null);
  }
  
  static GhostViewImpl addGhost(View paramView, ViewGroup paramViewGroup)
  {
    GhostViewApi14 localGhostViewApi142 = getGhostView(paramView);
    GhostViewApi14 localGhostViewApi141 = localGhostViewApi142;
    if (localGhostViewApi142 == null)
    {
      paramViewGroup = findFrameLayout(paramViewGroup);
      if (paramViewGroup == null) {
        return null;
      }
      localGhostViewApi141 = new GhostViewApi14(paramView);
      paramViewGroup.addView(localGhostViewApi141);
    }
    localGhostViewApi141.mReferences += 1;
    return localGhostViewApi141;
  }
  
  private static FrameLayout findFrameLayout(ViewGroup paramViewGroup)
  {
    while (!(paramViewGroup instanceof FrameLayout))
    {
      paramViewGroup = paramViewGroup.getParent();
      if (!(paramViewGroup instanceof ViewGroup)) {
        return null;
      }
      paramViewGroup = (ViewGroup)paramViewGroup;
    }
    return (FrameLayout)paramViewGroup;
  }
  
  static GhostViewApi14 getGhostView(@NonNull View paramView)
  {
    return (GhostViewApi14)paramView.getTag(R.id.ghost_view);
  }
  
  static void removeGhost(View paramView)
  {
    paramView = getGhostView(paramView);
    if (paramView != null)
    {
      paramView.mReferences -= 1;
      if (paramView.mReferences <= 0)
      {
        Object localObject = paramView.getParent();
        if ((localObject instanceof ViewGroup))
        {
          localObject = (ViewGroup)localObject;
          ((ViewGroup)localObject).endViewTransition(paramView);
          ((ViewGroup)localObject).removeView(paramView);
        }
      }
    }
  }
  
  private static void setGhostView(@NonNull View paramView, GhostViewApi14 paramGhostViewApi14)
  {
    paramView.setTag(R.id.ghost_view, paramGhostViewApi14);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setGhostView(this.mView, this);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    getLocationOnScreen(arrayOfInt1);
    this.mView.getLocationOnScreen(arrayOfInt2);
    arrayOfInt2[0] = ((int)(arrayOfInt2[0] - this.mView.getTranslationX()));
    arrayOfInt2[1] = ((int)(arrayOfInt2[1] - this.mView.getTranslationY()));
    this.mDeltaX = (arrayOfInt2[0] - arrayOfInt1[0]);
    this.mDeltaY = (arrayOfInt2[1] - arrayOfInt1[1]);
    this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
    this.mView.setVisibility(4);
  }
  
  protected void onDetachedFromWindow()
  {
    this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
    this.mView.setVisibility(0);
    setGhostView(this.mView, null);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.mMatrix.set(this.mCurrentMatrix);
    this.mMatrix.postTranslate(this.mDeltaX, this.mDeltaY);
    paramCanvas.setMatrix(this.mMatrix);
    this.mView.draw(paramCanvas);
  }
  
  public void reserveEndViewTransition(ViewGroup paramViewGroup, View paramView)
  {
    this.mStartParent = paramViewGroup;
    this.mStartView = paramView;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    View localView = this.mView;
    if (paramInt == 0) {
      paramInt = 4;
    } else {
      paramInt = 0;
    }
    localView.setVisibility(paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\GhostViewApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */