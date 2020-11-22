package android.support.design.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class CanvasCompat
{
  public static int saveLayerAlpha(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    if (Build.VERSION.SDK_INT > 21) {
      return paramCanvas.saveLayerAlpha(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt);
    }
    return paramCanvas.saveLayerAlpha(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, 31);
  }
  
  public static int saveLayerAlpha(Canvas paramCanvas, RectF paramRectF, int paramInt)
  {
    if (Build.VERSION.SDK_INT > 21) {
      return paramCanvas.saveLayerAlpha(paramRectF, paramInt);
    }
    return paramCanvas.saveLayerAlpha(paramRectF, paramInt, 31);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\canvas\CanvasCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */