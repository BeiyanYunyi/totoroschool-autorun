package android.support.design.widget;

import android.graphics.Outline;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;

@RequiresApi(21)
@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class CircularBorderDrawableLollipop
  extends CircularBorderDrawable
{
  public void getOutline(Outline paramOutline)
  {
    copyBounds(this.rect);
    paramOutline.setOval(this.rect);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\CircularBorderDrawableLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */