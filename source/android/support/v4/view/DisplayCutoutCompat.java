package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.DisplayCutout;
import java.util.List;

public final class DisplayCutoutCompat
{
  private final Object mDisplayCutout;
  
  public DisplayCutoutCompat(Rect paramRect, List<Rect> paramList)
  {
    this(paramRect);
  }
  
  private DisplayCutoutCompat(Object paramObject)
  {
    this.mDisplayCutout = paramObject;
  }
  
  static DisplayCutoutCompat wrap(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new DisplayCutoutCompat(paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (DisplayCutoutCompat)paramObject;
      if (this.mDisplayCutout == null) {
        return ((DisplayCutoutCompat)paramObject).mDisplayCutout == null;
      }
      return this.mDisplayCutout.equals(((DisplayCutoutCompat)paramObject).mDisplayCutout);
    }
    return false;
  }
  
  public List<Rect> getBoundingRects()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getBoundingRects();
    }
    return null;
  }
  
  public int getSafeInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetBottom();
    }
    return 0;
  }
  
  public int getSafeInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetLeft();
    }
    return 0;
  }
  
  public int getSafeInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetRight();
    }
    return 0;
  }
  
  public int getSafeInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetTop();
    }
    return 0;
  }
  
  public int hashCode()
  {
    if (this.mDisplayCutout == null) {
      return 0;
    }
    return this.mDisplayCutout.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DisplayCutoutCompat{");
    localStringBuilder.append(this.mDisplayCutout);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\view\DisplayCutoutCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */