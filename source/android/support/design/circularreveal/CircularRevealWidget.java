package android.support.design.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.design.widget.MathUtils;
import android.util.Property;

public abstract interface CircularRevealWidget
  extends CircularRevealHelper.Delegate
{
  public abstract void buildCircularRevealCache();
  
  public abstract void destroyCircularRevealCache();
  
  public abstract void draw(Canvas paramCanvas);
  
  @Nullable
  public abstract Drawable getCircularRevealOverlayDrawable();
  
  @ColorInt
  public abstract int getCircularRevealScrimColor();
  
  @Nullable
  public abstract RevealInfo getRevealInfo();
  
  public abstract boolean isOpaque();
  
  public abstract void setCircularRevealOverlayDrawable(@Nullable Drawable paramDrawable);
  
  public abstract void setCircularRevealScrimColor(@ColorInt int paramInt);
  
  public abstract void setRevealInfo(@Nullable RevealInfo paramRevealInfo);
  
  public static class CircularRevealEvaluator
    implements TypeEvaluator<CircularRevealWidget.RevealInfo>
  {
    public static final TypeEvaluator<CircularRevealWidget.RevealInfo> CIRCULAR_REVEAL = new CircularRevealEvaluator();
    private final CircularRevealWidget.RevealInfo revealInfo = new CircularRevealWidget.RevealInfo(null);
    
    public CircularRevealWidget.RevealInfo evaluate(float paramFloat, CircularRevealWidget.RevealInfo paramRevealInfo1, CircularRevealWidget.RevealInfo paramRevealInfo2)
    {
      this.revealInfo.set(MathUtils.lerp(paramRevealInfo1.centerX, paramRevealInfo2.centerX, paramFloat), MathUtils.lerp(paramRevealInfo1.centerY, paramRevealInfo2.centerY, paramFloat), MathUtils.lerp(paramRevealInfo1.radius, paramRevealInfo2.radius, paramFloat));
      return this.revealInfo;
    }
  }
  
  public static class CircularRevealProperty
    extends Property<CircularRevealWidget, CircularRevealWidget.RevealInfo>
  {
    public static final Property<CircularRevealWidget, CircularRevealWidget.RevealInfo> CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");
    
    private CircularRevealProperty(String paramString)
    {
      super(paramString);
    }
    
    public CircularRevealWidget.RevealInfo get(CircularRevealWidget paramCircularRevealWidget)
    {
      return paramCircularRevealWidget.getRevealInfo();
    }
    
    public void set(CircularRevealWidget paramCircularRevealWidget, CircularRevealWidget.RevealInfo paramRevealInfo)
    {
      paramCircularRevealWidget.setRevealInfo(paramRevealInfo);
    }
  }
  
  public static class CircularRevealScrimColorProperty
    extends Property<CircularRevealWidget, Integer>
  {
    public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");
    
    private CircularRevealScrimColorProperty(String paramString)
    {
      super(paramString);
    }
    
    public Integer get(CircularRevealWidget paramCircularRevealWidget)
    {
      return Integer.valueOf(paramCircularRevealWidget.getCircularRevealScrimColor());
    }
    
    public void set(CircularRevealWidget paramCircularRevealWidget, Integer paramInteger)
    {
      paramCircularRevealWidget.setCircularRevealScrimColor(paramInteger.intValue());
    }
  }
  
  public static class RevealInfo
  {
    public static final float INVALID_RADIUS = Float.MAX_VALUE;
    public float centerX;
    public float centerY;
    public float radius;
    
    private RevealInfo() {}
    
    public RevealInfo(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.centerX = paramFloat1;
      this.centerY = paramFloat2;
      this.radius = paramFloat3;
    }
    
    public RevealInfo(RevealInfo paramRevealInfo)
    {
      this(paramRevealInfo.centerX, paramRevealInfo.centerY, paramRevealInfo.radius);
    }
    
    public boolean isInvalid()
    {
      return this.radius == Float.MAX_VALUE;
    }
    
    public void set(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.centerX = paramFloat1;
      this.centerY = paramFloat2;
      this.radius = paramFloat3;
    }
    
    public void set(RevealInfo paramRevealInfo)
    {
      set(paramRevealInfo.centerX, paramRevealInfo.centerY, paramRevealInfo.radius);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\circularreveal\CircularRevealWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */