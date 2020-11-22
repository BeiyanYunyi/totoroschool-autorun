package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.design.R.color;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.drawable.DrawableWrapper;

public class ShadowDrawableWrapper
  extends DrawableWrapper
{
  static final double COS_45 = Math.cos(Math.toRadians(45.0D));
  static final float SHADOW_BOTTOM_SCALE = 1.0F;
  static final float SHADOW_HORIZ_SCALE = 0.5F;
  static final float SHADOW_MULTIPLIER = 1.5F;
  static final float SHADOW_TOP_SCALE = 0.25F;
  private boolean addPaddingForCorners = true;
  final RectF contentBounds;
  float cornerRadius;
  final Paint cornerShadowPaint;
  Path cornerShadowPath;
  private boolean dirty = true;
  final Paint edgeShadowPaint;
  float maxShadowSize;
  private boolean printedShadowClipWarning = false;
  float rawMaxShadowSize;
  float rawShadowSize;
  private float rotation;
  private final int shadowEndColor;
  private final int shadowMiddleColor;
  float shadowSize;
  private final int shadowStartColor;
  
  public ShadowDrawableWrapper(Context paramContext, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramDrawable);
    this.shadowStartColor = ContextCompat.getColor(paramContext, R.color.design_fab_shadow_start_color);
    this.shadowMiddleColor = ContextCompat.getColor(paramContext, R.color.design_fab_shadow_mid_color);
    this.shadowEndColor = ContextCompat.getColor(paramContext, R.color.design_fab_shadow_end_color);
    this.cornerShadowPaint = new Paint(5);
    this.cornerShadowPaint.setStyle(Paint.Style.FILL);
    this.cornerRadius = Math.round(paramFloat1);
    this.contentBounds = new RectF();
    this.edgeShadowPaint = new Paint(this.cornerShadowPaint);
    this.edgeShadowPaint.setAntiAlias(false);
    setShadowSize(paramFloat2, paramFloat3);
  }
  
  private void buildComponents(Rect paramRect)
  {
    float f = this.rawMaxShadowSize * 1.5F;
    this.contentBounds.set(paramRect.left + this.rawMaxShadowSize, paramRect.top + f, paramRect.right - this.rawMaxShadowSize, paramRect.bottom - f);
    getWrappedDrawable().setBounds((int)this.contentBounds.left, (int)this.contentBounds.top, (int)this.contentBounds.right, (int)this.contentBounds.bottom);
    buildShadowCorners();
  }
  
  private void buildShadowCorners()
  {
    Object localObject = new RectF(-this.cornerRadius, -this.cornerRadius, this.cornerRadius, this.cornerRadius);
    RectF localRectF = new RectF((RectF)localObject);
    localRectF.inset(-this.shadowSize, -this.shadowSize);
    if (this.cornerShadowPath == null) {
      this.cornerShadowPath = new Path();
    } else {
      this.cornerShadowPath.reset();
    }
    this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
    this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0F);
    this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0F);
    this.cornerShadowPath.arcTo(localRectF, 180.0F, 90.0F, false);
    this.cornerShadowPath.arcTo((RectF)localObject, 270.0F, -90.0F, false);
    this.cornerShadowPath.close();
    float f1 = -localRectF.top;
    if (f1 > 0.0F)
    {
      f2 = this.cornerRadius / f1;
      float f3 = (1.0F - f2) / 2.0F;
      localPaint = this.cornerShadowPaint;
      i = this.shadowStartColor;
      j = this.shadowMiddleColor;
      k = this.shadowEndColor;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      localPaint.setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, i, j, k }, new float[] { 0.0F, f2, f3 + f2, 1.0F }, localTileMode));
    }
    Paint localPaint = this.edgeShadowPaint;
    f1 = ((RectF)localObject).top;
    float f2 = localRectF.top;
    int i = this.shadowStartColor;
    int j = this.shadowMiddleColor;
    int k = this.shadowEndColor;
    localObject = Shader.TileMode.CLAMP;
    localPaint.setShader(new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject));
    this.edgeShadowPaint.setAntiAlias(false);
  }
  
  public static float calculateHorizontalPadding(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      double d1 = paramFloat1;
      double d2 = COS_45;
      double d3 = paramFloat2;
      Double.isNaN(d3);
      Double.isNaN(d1);
      return (float)(d1 + (1.0D - d2) * d3);
    }
    return paramFloat1;
  }
  
  public static float calculateVerticalPadding(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      double d1 = paramFloat1 * 1.5F;
      double d2 = COS_45;
      double d3 = paramFloat2;
      Double.isNaN(d3);
      Double.isNaN(d1);
      return (float)(d1 + (1.0D - d2) * d3);
    }
    return paramFloat1 * 1.5F;
  }
  
  private void drawShadow(Canvas paramCanvas)
  {
    int k = paramCanvas.save();
    paramCanvas.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
    float f3 = -this.cornerRadius - this.shadowSize;
    float f4 = this.cornerRadius;
    float f1 = this.contentBounds.width();
    float f5 = f4 * 2.0F;
    if (f1 - f5 > 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (this.contentBounds.height() - f5 > 0.0F) {
      j = 1;
    } else {
      j = 0;
    }
    float f2 = this.rawShadowSize;
    float f8 = this.rawShadowSize;
    float f6 = this.rawShadowSize;
    float f9 = this.rawShadowSize;
    f1 = this.rawShadowSize;
    float f7 = this.rawShadowSize;
    f6 = f4 / (f6 - f9 * 0.5F + f4);
    f2 = f4 / (f2 - f8 * 0.25F + f4);
    f1 = f4 / (f1 - f7 * 1.0F + f4);
    int m = paramCanvas.save();
    paramCanvas.translate(this.contentBounds.left + f4, this.contentBounds.top + f4);
    paramCanvas.scale(f6, f2);
    paramCanvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
    if (i != 0)
    {
      paramCanvas.scale(1.0F / f6, 1.0F);
      paramCanvas.drawRect(0.0F, f3, this.contentBounds.width() - f5, -this.cornerRadius, this.edgeShadowPaint);
    }
    paramCanvas.restoreToCount(m);
    m = paramCanvas.save();
    paramCanvas.translate(this.contentBounds.right - f4, this.contentBounds.bottom - f4);
    paramCanvas.scale(f6, f1);
    paramCanvas.rotate(180.0F);
    paramCanvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
    if (i != 0)
    {
      paramCanvas.scale(1.0F / f6, 1.0F);
      paramCanvas.drawRect(0.0F, f3, this.contentBounds.width() - f5, -this.cornerRadius + this.shadowSize, this.edgeShadowPaint);
    }
    paramCanvas.restoreToCount(m);
    int i = paramCanvas.save();
    paramCanvas.translate(this.contentBounds.left + f4, this.contentBounds.bottom - f4);
    paramCanvas.scale(f6, f1);
    paramCanvas.rotate(270.0F);
    paramCanvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
    if (j != 0)
    {
      paramCanvas.scale(1.0F / f1, 1.0F);
      paramCanvas.drawRect(0.0F, f3, this.contentBounds.height() - f5, -this.cornerRadius, this.edgeShadowPaint);
    }
    paramCanvas.restoreToCount(i);
    i = paramCanvas.save();
    paramCanvas.translate(this.contentBounds.right - f4, this.contentBounds.top + f4);
    paramCanvas.scale(f6, f2);
    paramCanvas.rotate(90.0F);
    paramCanvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
    if (j != 0)
    {
      paramCanvas.scale(1.0F / f2, 1.0F);
      paramCanvas.drawRect(0.0F, f3, this.contentBounds.height() - f5, -this.cornerRadius, this.edgeShadowPaint);
    }
    paramCanvas.restoreToCount(i);
    paramCanvas.restoreToCount(k);
  }
  
  private static int toEven(float paramFloat)
  {
    int j = Math.round(paramFloat);
    int i = j;
    if (j % 2 == 1) {
      i = j - 1;
    }
    return i;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.dirty)
    {
      buildComponents(getBounds());
      this.dirty = false;
    }
    drawShadow(paramCanvas);
    super.draw(paramCanvas);
  }
  
  public float getCornerRadius()
  {
    return this.cornerRadius;
  }
  
  public float getMaxShadowSize()
  {
    return this.rawMaxShadowSize;
  }
  
  public float getMinHeight()
  {
    return Math.max(this.rawMaxShadowSize, this.cornerRadius + this.rawMaxShadowSize * 1.5F / 2.0F) * 2.0F + this.rawMaxShadowSize * 1.5F * 2.0F;
  }
  
  public float getMinWidth()
  {
    return Math.max(this.rawMaxShadowSize, this.cornerRadius + this.rawMaxShadowSize / 2.0F) * 2.0F + this.rawMaxShadowSize * 2.0F;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    int i = (int)Math.ceil(calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
    int j = (int)Math.ceil(calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  public float getShadowSize()
  {
    return this.rawShadowSize;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.dirty = true;
  }
  
  public void setAddPaddingForCorners(boolean paramBoolean)
  {
    this.addPaddingForCorners = paramBoolean;
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
    this.cornerShadowPaint.setAlpha(paramInt);
    this.edgeShadowPaint.setAlpha(paramInt);
  }
  
  public void setCornerRadius(float paramFloat)
  {
    paramFloat = Math.round(paramFloat);
    if (this.cornerRadius == paramFloat) {
      return;
    }
    this.cornerRadius = paramFloat;
    this.dirty = true;
    invalidateSelf();
  }
  
  public void setMaxShadowSize(float paramFloat)
  {
    setShadowSize(this.rawShadowSize, paramFloat);
  }
  
  public final void setRotation(float paramFloat)
  {
    if (this.rotation != paramFloat)
    {
      this.rotation = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setShadowSize(float paramFloat)
  {
    setShadowSize(paramFloat, this.rawMaxShadowSize);
  }
  
  public void setShadowSize(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 >= 0.0F) && (paramFloat2 >= 0.0F))
    {
      float f = toEven(paramFloat1);
      paramFloat2 = toEven(paramFloat2);
      paramFloat1 = f;
      if (f > paramFloat2)
      {
        if (!this.printedShadowClipWarning) {
          this.printedShadowClipWarning = true;
        }
        paramFloat1 = paramFloat2;
      }
      if ((this.rawShadowSize == paramFloat1) && (this.rawMaxShadowSize == paramFloat2)) {
        return;
      }
      this.rawShadowSize = paramFloat1;
      this.rawMaxShadowSize = paramFloat2;
      this.shadowSize = Math.round(paramFloat1 * 1.5F);
      this.maxShadowSize = paramFloat2;
      this.dirty = true;
      invalidateSelf();
      return;
    }
    throw new IllegalArgumentException("invalid shadow size");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\ShadowDrawableWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */