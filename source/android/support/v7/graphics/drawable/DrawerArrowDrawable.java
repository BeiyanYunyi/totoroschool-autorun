package android.support.v7.graphics.drawable;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.style;
import android.support.v7.appcompat.R.styleable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DrawerArrowDrawable
  extends Drawable
{
  public static final int ARROW_DIRECTION_END = 3;
  public static final int ARROW_DIRECTION_LEFT = 0;
  public static final int ARROW_DIRECTION_RIGHT = 1;
  public static final int ARROW_DIRECTION_START = 2;
  private static final float ARROW_HEAD_ANGLE = (float)Math.toRadians(45.0D);
  private float mArrowHeadLength;
  private float mArrowShaftLength;
  private float mBarGap;
  private float mBarLength;
  private int mDirection = 2;
  private float mMaxCutForBarSize;
  private final Paint mPaint = new Paint();
  private final Path mPath = new Path();
  private float mProgress;
  private final int mSize;
  private boolean mSpin;
  private boolean mVerticalMirror = false;
  
  public DrawerArrowDrawable(Context paramContext)
  {
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeJoin(Paint.Join.MITER);
    this.mPaint.setStrokeCap(Paint.Cap.BUTT);
    this.mPaint.setAntiAlias(true);
    paramContext = paramContext.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
    setColor(paramContext.getColor(R.styleable.DrawerArrowToggle_color, 0));
    setBarThickness(paramContext.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0F));
    setSpinEnabled(paramContext.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
    setGapSize(Math.round(paramContext.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0F)));
    this.mSize = paramContext.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
    this.mBarLength = Math.round(paramContext.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0F));
    this.mArrowHeadLength = Math.round(paramContext.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0F));
    this.mArrowShaftLength = paramContext.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0F);
    paramContext.recycle();
  }
  
  private static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + (paramFloat2 - paramFloat1) * paramFloat3;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int m = this.mDirection;
    int k = 0;
    int j = 1;
    int i;
    if (m != 3) {
      i = k;
    }
    switch (m)
    {
    default: 
      i = k;
      if (DrawableCompat.getLayoutDirection(this) != 1) {
        break;
      }
    case 1: 
      do
      {
        i = 1;
        break;
        i = k;
      } while (DrawableCompat.getLayoutDirection(this) == 0);
    }
    float f1 = (float)Math.sqrt(this.mArrowHeadLength * this.mArrowHeadLength * 2.0F);
    float f5 = lerp(this.mBarLength, f1, this.mProgress);
    float f3 = lerp(this.mBarLength, this.mArrowShaftLength, this.mProgress);
    float f4 = Math.round(lerp(0.0F, this.mMaxCutForBarSize, this.mProgress));
    float f6 = lerp(0.0F, ARROW_HEAD_ANGLE, this.mProgress);
    if (i != 0) {
      f1 = 0.0F;
    } else {
      f1 = -180.0F;
    }
    if (i != 0) {
      f2 = 180.0F;
    } else {
      f2 = 0.0F;
    }
    f1 = lerp(f1, f2, this.mProgress);
    double d1 = f5;
    double d2 = f6;
    double d3 = Math.cos(d2);
    Double.isNaN(d1);
    float f2 = (float)Math.round(d3 * d1);
    d2 = Math.sin(d2);
    Double.isNaN(d1);
    f5 = (float)Math.round(d1 * d2);
    this.mPath.rewind();
    f6 = lerp(this.mBarGap + this.mPaint.getStrokeWidth(), -this.mMaxCutForBarSize, this.mProgress);
    float f7 = -f3 / 2.0F;
    this.mPath.moveTo(f7 + f4, 0.0F);
    this.mPath.rLineTo(f3 - f4 * 2.0F, 0.0F);
    this.mPath.moveTo(f7, f6);
    this.mPath.rLineTo(f2, f5);
    this.mPath.moveTo(f7, -f6);
    this.mPath.rLineTo(f2, -f5);
    this.mPath.close();
    paramCanvas.save();
    f2 = this.mPaint.getStrokeWidth();
    f3 = (int)(localRect.height() - 3.0F * f2 - this.mBarGap * 2.0F) / 4 * 2;
    f4 = this.mBarGap;
    paramCanvas.translate(localRect.centerX(), f3 + (f2 * 1.5F + f4));
    if (this.mSpin)
    {
      if ((this.mVerticalMirror ^ i)) {
        j = -1;
      }
      paramCanvas.rotate(f1 * j);
    }
    else if (i != 0)
    {
      paramCanvas.rotate(180.0F);
    }
    paramCanvas.drawPath(this.mPath, this.mPaint);
    paramCanvas.restore();
  }
  
  public float getArrowHeadLength()
  {
    return this.mArrowHeadLength;
  }
  
  public float getArrowShaftLength()
  {
    return this.mArrowShaftLength;
  }
  
  public float getBarLength()
  {
    return this.mBarLength;
  }
  
  public float getBarThickness()
  {
    return this.mPaint.getStrokeWidth();
  }
  
  @ColorInt
  public int getColor()
  {
    return this.mPaint.getColor();
  }
  
  public int getDirection()
  {
    return this.mDirection;
  }
  
  public float getGapSize()
  {
    return this.mBarGap;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mSize;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mSize;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public final Paint getPaint()
  {
    return this.mPaint;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getProgress()
  {
    return this.mProgress;
  }
  
  public boolean isSpinEnabled()
  {
    return this.mSpin;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setArrowHeadLength(float paramFloat)
  {
    if (this.mArrowHeadLength != paramFloat)
    {
      this.mArrowHeadLength = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setArrowShaftLength(float paramFloat)
  {
    if (this.mArrowShaftLength != paramFloat)
    {
      this.mArrowShaftLength = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setBarLength(float paramFloat)
  {
    if (this.mBarLength != paramFloat)
    {
      this.mBarLength = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setBarThickness(float paramFloat)
  {
    if (this.mPaint.getStrokeWidth() != paramFloat)
    {
      this.mPaint.setStrokeWidth(paramFloat);
      double d1 = paramFloat / 2.0F;
      double d2 = Math.cos(ARROW_HEAD_ANGLE);
      Double.isNaN(d1);
      this.mMaxCutForBarSize = ((float)(d1 * d2));
      invalidateSelf();
    }
  }
  
  public void setColor(@ColorInt int paramInt)
  {
    if (paramInt != this.mPaint.getColor())
    {
      this.mPaint.setColor(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDirection(int paramInt)
  {
    if (paramInt != this.mDirection)
    {
      this.mDirection = paramInt;
      invalidateSelf();
    }
  }
  
  public void setGapSize(float paramFloat)
  {
    if (paramFloat != this.mBarGap)
    {
      this.mBarGap = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.mProgress != paramFloat)
    {
      this.mProgress = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setSpinEnabled(boolean paramBoolean)
  {
    if (this.mSpin != paramBoolean)
    {
      this.mSpin = paramBoolean;
      invalidateSelf();
    }
  }
  
  public void setVerticalMirror(boolean paramBoolean)
  {
    if (this.mVerticalMirror != paramBoolean)
    {
      this.mVerticalMirror = paramBoolean;
      invalidateSelf();
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface ArrowDirection {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\graphics\drawable\DrawerArrowDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */