package android.support.design.widget;

import android.graphics.drawable.Drawable;

public abstract interface ShadowViewDelegate
{
  public abstract float getRadius();
  
  public abstract boolean isCompatPaddingEnabled();
  
  public abstract void setBackgroundDrawable(Drawable paramDrawable);
  
  public abstract void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\ShadowViewDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */