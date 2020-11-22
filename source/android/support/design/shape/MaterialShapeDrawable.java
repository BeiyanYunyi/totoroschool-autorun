package android.support.design.shape;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.design.internal.Experimental;
import android.support.v4.graphics.drawable.TintAwareDrawable;

@Experimental("The shapes API is currently experimental and subject to change")
public class MaterialShapeDrawable
  extends Drawable
  implements TintAwareDrawable
{
  private int alpha;
  private final ShapePath[] cornerPaths = new ShapePath[4];
  private final Matrix[] cornerTransforms = new Matrix[4];
  private final Matrix[] edgeTransforms = new Matrix[4];
  private float interpolation;
  private final Matrix matrix = new Matrix();
  private final Paint paint = new Paint();
  private Paint.Style paintStyle;
  private final Path path = new Path();
  private final PointF pointF = new PointF();
  private float scale;
  private final float[] scratch = new float[2];
  private final float[] scratch2 = new float[2];
  private final Region scratchRegion = new Region();
  private int shadowColor;
  private int shadowElevation;
  private boolean shadowEnabled;
  private int shadowRadius;
  private final ShapePath shapePath = new ShapePath();
  @Nullable
  private ShapePathModel shapedViewModel = null;
  private float strokeWidth;
  @Nullable
  private PorterDuffColorFilter tintFilter;
  private ColorStateList tintList;
  private PorterDuff.Mode tintMode;
  private final Region transparentRegion = new Region();
  private boolean useTintColorForShadow;
  
  public MaterialShapeDrawable()
  {
    this(null);
  }
  
  public MaterialShapeDrawable(@Nullable ShapePathModel paramShapePathModel)
  {
    int i = 0;
    this.shadowEnabled = false;
    this.useTintColorForShadow = false;
    this.interpolation = 1.0F;
    this.shadowColor = -16777216;
    this.shadowElevation = 5;
    this.shadowRadius = 10;
    this.alpha = 255;
    this.scale = 1.0F;
    this.strokeWidth = 0.0F;
    this.paintStyle = Paint.Style.FILL_AND_STROKE;
    this.tintMode = PorterDuff.Mode.SRC_IN;
    this.tintList = null;
    this.shapedViewModel = paramShapePathModel;
    while (i < 4)
    {
      this.cornerTransforms[i] = new Matrix();
      this.edgeTransforms[i] = new Matrix();
      this.cornerPaths[i] = new ShapePath();
      i += 1;
    }
  }
  
  private float angleOfCorner(int paramInt1, int paramInt2, int paramInt3)
  {
    getCoordinatesOfCorner((paramInt1 - 1 + 4) % 4, paramInt2, paramInt3, this.pointF);
    float f1 = this.pointF.x;
    float f2 = this.pointF.y;
    getCoordinatesOfCorner((paramInt1 + 1) % 4, paramInt2, paramInt3, this.pointF);
    float f3 = this.pointF.x;
    float f4 = this.pointF.y;
    getCoordinatesOfCorner(paramInt1, paramInt2, paramInt3, this.pointF);
    float f5 = this.pointF.x;
    float f6 = this.pointF.y;
    f2 = (float)Math.atan2(f2 - f6, f1 - f5) - (float)Math.atan2(f4 - f6, f3 - f5);
    f1 = f2;
    if (f2 < 0.0F)
    {
      double d = f2;
      Double.isNaN(d);
      f1 = (float)(d + 6.283185307179586D);
    }
    return f1;
  }
  
  private float angleOfEdge(int paramInt1, int paramInt2, int paramInt3)
  {
    getCoordinatesOfCorner(paramInt1, paramInt2, paramInt3, this.pointF);
    float f1 = this.pointF.x;
    float f2 = this.pointF.y;
    getCoordinatesOfCorner((paramInt1 + 1) % 4, paramInt2, paramInt3, this.pointF);
    float f3 = this.pointF.x;
    return (float)Math.atan2(this.pointF.y - f2, f3 - f1);
  }
  
  private void appendCornerPath(int paramInt, Path paramPath)
  {
    this.scratch[0] = this.cornerPaths[paramInt].startX;
    this.scratch[1] = this.cornerPaths[paramInt].startY;
    this.cornerTransforms[paramInt].mapPoints(this.scratch);
    if (paramInt == 0) {
      paramPath.moveTo(this.scratch[0], this.scratch[1]);
    } else {
      paramPath.lineTo(this.scratch[0], this.scratch[1]);
    }
    this.cornerPaths[paramInt].applyToPath(this.cornerTransforms[paramInt], paramPath);
  }
  
  private void appendEdgePath(int paramInt, Path paramPath)
  {
    int i = (paramInt + 1) % 4;
    this.scratch[0] = this.cornerPaths[paramInt].endX;
    this.scratch[1] = this.cornerPaths[paramInt].endY;
    this.cornerTransforms[paramInt].mapPoints(this.scratch);
    this.scratch2[0] = this.cornerPaths[i].startX;
    this.scratch2[1] = this.cornerPaths[i].startY;
    this.cornerTransforms[i].mapPoints(this.scratch2);
    float f = (float)Math.hypot(this.scratch[0] - this.scratch2[0], this.scratch[1] - this.scratch2[1]);
    this.shapePath.reset(0.0F, 0.0F);
    getEdgeTreatmentForIndex(paramInt).getEdgePath(f, this.interpolation, this.shapePath);
    this.shapePath.applyToPath(this.edgeTransforms[paramInt], paramPath);
  }
  
  private void getCoordinatesOfCorner(int paramInt1, int paramInt2, int paramInt3, PointF paramPointF)
  {
    switch (paramInt1)
    {
    default: 
      paramPointF.set(0.0F, 0.0F);
      return;
    case 3: 
      paramPointF.set(0.0F, paramInt3);
      return;
    case 2: 
      paramPointF.set(paramInt2, paramInt3);
      return;
    }
    paramPointF.set(paramInt2, 0.0F);
  }
  
  private CornerTreatment getCornerTreatmentForIndex(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.shapedViewModel.getTopLeftCorner();
    case 3: 
      return this.shapedViewModel.getBottomLeftCorner();
    case 2: 
      return this.shapedViewModel.getBottomRightCorner();
    }
    return this.shapedViewModel.getTopRightCorner();
  }
  
  private EdgeTreatment getEdgeTreatmentForIndex(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.shapedViewModel.getTopEdge();
    case 3: 
      return this.shapedViewModel.getLeftEdge();
    case 2: 
      return this.shapedViewModel.getBottomEdge();
    }
    return this.shapedViewModel.getRightEdge();
  }
  
  private void getPath(int paramInt1, int paramInt2, Path paramPath)
  {
    getPathForSize(paramInt1, paramInt2, paramPath);
    if (this.scale == 1.0F) {
      return;
    }
    this.matrix.reset();
    this.matrix.setScale(this.scale, this.scale, paramInt1 / 2, paramInt2 / 2);
    paramPath.transform(this.matrix);
  }
  
  private static int modulateAlpha(int paramInt1, int paramInt2)
  {
    return paramInt1 * (paramInt2 + (paramInt2 >>> 7)) >>> 8;
  }
  
  private void setCornerPathAndTransform(int paramInt1, int paramInt2, int paramInt3)
  {
    getCoordinatesOfCorner(paramInt1, paramInt2, paramInt3, this.pointF);
    float f = angleOfCorner(paramInt1, paramInt2, paramInt3);
    getCornerTreatmentForIndex(paramInt1).getCornerPath(f, this.interpolation, this.cornerPaths[paramInt1]);
    f = angleOfEdge((paramInt1 - 1 + 4) % 4, paramInt2, paramInt3);
    this.cornerTransforms[paramInt1].reset();
    this.cornerTransforms[paramInt1].setTranslate(this.pointF.x, this.pointF.y);
    this.cornerTransforms[paramInt1].preRotate((float)Math.toDegrees(f + 1.5707964F));
  }
  
  private void setEdgeTransform(int paramInt1, int paramInt2, int paramInt3)
  {
    this.scratch[0] = this.cornerPaths[paramInt1].endX;
    this.scratch[1] = this.cornerPaths[paramInt1].endY;
    this.cornerTransforms[paramInt1].mapPoints(this.scratch);
    float f = angleOfEdge(paramInt1, paramInt2, paramInt3);
    this.edgeTransforms[paramInt1].reset();
    this.edgeTransforms[paramInt1].setTranslate(this.scratch[0], this.scratch[1]);
    this.edgeTransforms[paramInt1].preRotate((float)Math.toDegrees(f));
  }
  
  private void updateTintFilter()
  {
    if ((this.tintList != null) && (this.tintMode != null))
    {
      int i = this.tintList.getColorForState(getState(), 0);
      this.tintFilter = new PorterDuffColorFilter(i, this.tintMode);
      if (this.useTintColorForShadow) {
        this.shadowColor = i;
      }
      return;
    }
    this.tintFilter = null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.paint.setColorFilter(this.tintFilter);
    int i = this.paint.getAlpha();
    this.paint.setAlpha(modulateAlpha(i, this.alpha));
    this.paint.setStrokeWidth(this.strokeWidth);
    this.paint.setStyle(this.paintStyle);
    if ((this.shadowElevation > 0) && (this.shadowEnabled)) {
      this.paint.setShadowLayer(this.shadowRadius, 0.0F, this.shadowElevation, this.shadowColor);
    }
    if (this.shapedViewModel != null)
    {
      getPath(paramCanvas.getWidth(), paramCanvas.getHeight(), this.path);
      paramCanvas.drawPath(this.path, this.paint);
    }
    else
    {
      paramCanvas.drawRect(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), this.paint);
    }
    this.paint.setAlpha(i);
  }
  
  public float getInterpolation()
  {
    return this.interpolation;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public Paint.Style getPaintStyle()
  {
    return this.paintStyle;
  }
  
  public void getPathForSize(int paramInt1, int paramInt2, Path paramPath)
  {
    paramPath.rewind();
    if (this.shapedViewModel == null) {
      return;
    }
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 4) {
        break;
      }
      setCornerPathAndTransform(i, paramInt1, paramInt2);
      setEdgeTransform(i, paramInt1, paramInt2);
      i += 1;
    }
    while (j < 4)
    {
      appendCornerPath(j, paramPath);
      appendEdgePath(j, paramPath);
      j += 1;
    }
    paramPath.close();
  }
  
  public float getScale()
  {
    return this.scale;
  }
  
  public int getShadowElevation()
  {
    return this.shadowElevation;
  }
  
  public int getShadowRadius()
  {
    return this.shadowRadius;
  }
  
  @Nullable
  public ShapePathModel getShapedViewModel()
  {
    return this.shapedViewModel;
  }
  
  public float getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  public ColorStateList getTintList()
  {
    return this.tintList;
  }
  
  public Region getTransparentRegion()
  {
    Rect localRect = getBounds();
    this.transparentRegion.set(localRect);
    getPath(localRect.width(), localRect.height(), this.path);
    this.scratchRegion.setPath(this.path, this.transparentRegion);
    this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
    return this.transparentRegion;
  }
  
  public boolean isPointInTransparentRegion(int paramInt1, int paramInt2)
  {
    return getTransparentRegion().contains(paramInt1, paramInt2);
  }
  
  public boolean isShadowEnabled()
  {
    return this.shadowEnabled;
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt)
  {
    this.alpha = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setInterpolation(float paramFloat)
  {
    this.interpolation = paramFloat;
    invalidateSelf();
  }
  
  public void setPaintStyle(Paint.Style paramStyle)
  {
    this.paintStyle = paramStyle;
    invalidateSelf();
  }
  
  public void setScale(float paramFloat)
  {
    this.scale = paramFloat;
    invalidateSelf();
  }
  
  public void setShadowColor(int paramInt)
  {
    this.shadowColor = paramInt;
    this.useTintColorForShadow = false;
    invalidateSelf();
  }
  
  public void setShadowElevation(int paramInt)
  {
    this.shadowElevation = paramInt;
    invalidateSelf();
  }
  
  public void setShadowEnabled(boolean paramBoolean)
  {
    this.shadowEnabled = paramBoolean;
    invalidateSelf();
  }
  
  public void setShadowRadius(int paramInt)
  {
    this.shadowRadius = paramInt;
    invalidateSelf();
  }
  
  public void setShapedViewModel(ShapePathModel paramShapePathModel)
  {
    this.shapedViewModel = paramShapePathModel;
    invalidateSelf();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.strokeWidth = paramFloat;
    invalidateSelf();
  }
  
  public void setTint(@ColorInt int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.tintList = paramColorStateList;
    updateTintFilter();
    invalidateSelf();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.tintMode = paramMode;
    updateTintFilter();
    invalidateSelf();
  }
  
  public void setUseTintColorForShadow(boolean paramBoolean)
  {
    this.useTintColorForShadow = paramBoolean;
    invalidateSelf();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\shape\MaterialShapeDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */