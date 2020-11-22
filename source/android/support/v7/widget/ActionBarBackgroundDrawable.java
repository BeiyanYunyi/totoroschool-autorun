package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

class ActionBarBackgroundDrawable
  extends Drawable
{
  final ActionBarContainer mContainer;
  
  public ActionBarBackgroundDrawable(ActionBarContainer paramActionBarContainer)
  {
    this.mContainer = paramActionBarContainer;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mContainer.mIsSplit)
    {
      if (this.mContainer.mSplitBackground != null) {
        this.mContainer.mSplitBackground.draw(paramCanvas);
      }
    }
    else
    {
      if (this.mContainer.mBackground != null) {
        this.mContainer.mBackground.draw(paramCanvas);
      }
      if ((this.mContainer.mStackedBackground != null) && (this.mContainer.mIsStacked)) {
        this.mContainer.mStackedBackground.draw(paramCanvas);
      }
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  @RequiresApi(21)
  public void getOutline(@NonNull Outline paramOutline)
  {
    if (this.mContainer.mIsSplit)
    {
      if (this.mContainer.mSplitBackground != null) {
        this.mContainer.mSplitBackground.getOutline(paramOutline);
      }
    }
    else if (this.mContainer.mBackground != null) {
      this.mContainer.mBackground.getOutline(paramOutline);
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\ActionBarBackgroundDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */