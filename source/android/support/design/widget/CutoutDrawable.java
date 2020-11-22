package android.support.design.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;

class CutoutDrawable
  extends GradientDrawable
{
  private final RectF cutoutBounds;
  private final Paint cutoutPaint = new Paint(1);
  private int savedLayer;
  
  CutoutDrawable()
  {
    setPaintStyles();
    this.cutoutBounds = new RectF();
  }
  
  private void postDraw(@NonNull Canvas paramCanvas)
  {
    if (!useHardwareLayer(getCallback())) {
      paramCanvas.restoreToCount(this.savedLayer);
    }
  }
  
  private void preDraw(@NonNull Canvas paramCanvas)
  {
    Drawable.Callback localCallback = getCallback();
    if (useHardwareLayer(localCallback))
    {
      ((View)localCallback).setLayerType(2, null);
      return;
    }
    saveCanvasLayer(paramCanvas);
  }
  
  private void saveCanvasLayer(@NonNull Canvas paramCanvas)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.savedLayer = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
      return;
    }
    this.savedLayer = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
  }
  
  private void setPaintStyles()
  {
    this.cutoutPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.cutoutPaint.setColor(-1);
    this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
  }
  
  private boolean useHardwareLayer(Drawable.Callback paramCallback)
  {
    return paramCallback instanceof View;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    preDraw(paramCanvas);
    super.draw(paramCanvas);
    paramCanvas.drawRect(this.cutoutBounds, this.cutoutPaint);
    postDraw(paramCanvas);
  }
  
  boolean hasCutout()
  {
    return this.cutoutBounds.isEmpty() ^ true;
  }
  
  void removeCutout()
  {
    setCutout(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  void setCutout(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat1 != this.cutoutBounds.left) || (paramFloat2 != this.cutoutBounds.top) || (paramFloat3 != this.cutoutBounds.right) || (paramFloat4 != this.cutoutBounds.bottom))
    {
      this.cutoutBounds.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      invalidateSelf();
    }
  }
  
  void setCutout(RectF paramRectF)
  {
    setCutout(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\CutoutDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */