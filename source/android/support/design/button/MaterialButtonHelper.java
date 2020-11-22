package android.support.design.button;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.design.R.styleable;
import android.support.design.internal.ViewUtils;
import android.support.design.resources.MaterialResources;
import android.support.design.ripple.RippleUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class MaterialButtonHelper
{
  private static final float CORNER_RADIUS_ADJUSTMENT = 1.0E-5F;
  private static final int DEFAULT_BACKGROUND_COLOR = -1;
  private static final boolean IS_LOLLIPOP;
  @Nullable
  private GradientDrawable backgroundDrawableLollipop;
  private boolean backgroundOverwritten = false;
  @Nullable
  private ColorStateList backgroundTint;
  @Nullable
  private PorterDuff.Mode backgroundTintMode;
  private final Rect bounds = new Rect();
  private final Paint buttonStrokePaint = new Paint(1);
  @Nullable
  private GradientDrawable colorableBackgroundDrawableCompat;
  private int cornerRadius;
  private int insetBottom;
  private int insetLeft;
  private int insetRight;
  private int insetTop;
  @Nullable
  private GradientDrawable maskDrawableLollipop;
  private final MaterialButton materialButton;
  private final RectF rectF = new RectF();
  @Nullable
  private ColorStateList rippleColor;
  @Nullable
  private GradientDrawable rippleDrawableCompat;
  @Nullable
  private ColorStateList strokeColor;
  @Nullable
  private GradientDrawable strokeDrawableLollipop;
  private int strokeWidth;
  @Nullable
  private Drawable tintableBackgroundDrawableCompat;
  @Nullable
  private Drawable tintableRippleDrawableCompat;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    IS_LOLLIPOP = bool;
  }
  
  public MaterialButtonHelper(MaterialButton paramMaterialButton)
  {
    this.materialButton = paramMaterialButton;
  }
  
  private Drawable createBackgroundCompat()
  {
    this.colorableBackgroundDrawableCompat = new GradientDrawable();
    this.colorableBackgroundDrawableCompat.setCornerRadius(this.cornerRadius + 1.0E-5F);
    this.colorableBackgroundDrawableCompat.setColor(-1);
    this.tintableBackgroundDrawableCompat = DrawableCompat.wrap(this.colorableBackgroundDrawableCompat);
    DrawableCompat.setTintList(this.tintableBackgroundDrawableCompat, this.backgroundTint);
    if (this.backgroundTintMode != null) {
      DrawableCompat.setTintMode(this.tintableBackgroundDrawableCompat, this.backgroundTintMode);
    }
    this.rippleDrawableCompat = new GradientDrawable();
    this.rippleDrawableCompat.setCornerRadius(this.cornerRadius + 1.0E-5F);
    this.rippleDrawableCompat.setColor(-1);
    this.tintableRippleDrawableCompat = DrawableCompat.wrap(this.rippleDrawableCompat);
    DrawableCompat.setTintList(this.tintableRippleDrawableCompat, this.rippleColor);
    return wrapDrawableWithInset(new LayerDrawable(new Drawable[] { this.tintableBackgroundDrawableCompat, this.tintableRippleDrawableCompat }));
  }
  
  @TargetApi(21)
  private Drawable createBackgroundLollipop()
  {
    this.backgroundDrawableLollipop = new GradientDrawable();
    this.backgroundDrawableLollipop.setCornerRadius(this.cornerRadius + 1.0E-5F);
    this.backgroundDrawableLollipop.setColor(-1);
    updateTintAndTintModeLollipop();
    this.strokeDrawableLollipop = new GradientDrawable();
    this.strokeDrawableLollipop.setCornerRadius(this.cornerRadius + 1.0E-5F);
    this.strokeDrawableLollipop.setColor(0);
    this.strokeDrawableLollipop.setStroke(this.strokeWidth, this.strokeColor);
    InsetDrawable localInsetDrawable = wrapDrawableWithInset(new LayerDrawable(new Drawable[] { this.backgroundDrawableLollipop, this.strokeDrawableLollipop }));
    this.maskDrawableLollipop = new GradientDrawable();
    this.maskDrawableLollipop.setCornerRadius(this.cornerRadius + 1.0E-5F);
    this.maskDrawableLollipop.setColor(-1);
    return new MaterialButtonBackgroundDrawable(RippleUtils.convertToRippleDrawableColor(this.rippleColor), localInsetDrawable, this.maskDrawableLollipop);
  }
  
  @Nullable
  private GradientDrawable unwrapBackgroundDrawable()
  {
    if ((IS_LOLLIPOP) && (this.materialButton.getBackground() != null)) {
      return (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)this.materialButton.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }
    return null;
  }
  
  @Nullable
  private GradientDrawable unwrapStrokeDrawable()
  {
    if ((IS_LOLLIPOP) && (this.materialButton.getBackground() != null)) {
      return (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)this.materialButton.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }
    return null;
  }
  
  private void updateStroke()
  {
    if ((IS_LOLLIPOP) && (this.strokeDrawableLollipop != null))
    {
      this.materialButton.setInternalBackground(createBackgroundLollipop());
      return;
    }
    if (!IS_LOLLIPOP) {
      this.materialButton.invalidate();
    }
  }
  
  private void updateTintAndTintModeLollipop()
  {
    if (this.backgroundDrawableLollipop != null)
    {
      DrawableCompat.setTintList(this.backgroundDrawableLollipop, this.backgroundTint);
      if (this.backgroundTintMode != null) {
        DrawableCompat.setTintMode(this.backgroundDrawableLollipop, this.backgroundTintMode);
      }
    }
  }
  
  private InsetDrawable wrapDrawableWithInset(Drawable paramDrawable)
  {
    return new InsetDrawable(paramDrawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
  }
  
  void drawStroke(@Nullable Canvas paramCanvas)
  {
    if ((paramCanvas != null) && (this.strokeColor != null) && (this.strokeWidth > 0))
    {
      this.bounds.set(this.materialButton.getBackground().getBounds());
      this.rectF.set(this.bounds.left + this.strokeWidth / 2.0F + this.insetLeft, this.bounds.top + this.strokeWidth / 2.0F + this.insetTop, this.bounds.right - this.strokeWidth / 2.0F - this.insetRight, this.bounds.bottom - this.strokeWidth / 2.0F - this.insetBottom);
      float f = this.cornerRadius - this.strokeWidth / 2.0F;
      paramCanvas.drawRoundRect(this.rectF, f, f, this.buttonStrokePaint);
    }
  }
  
  int getCornerRadius()
  {
    return this.cornerRadius;
  }
  
  @Nullable
  ColorStateList getRippleColor()
  {
    return this.rippleColor;
  }
  
  @Nullable
  ColorStateList getStrokeColor()
  {
    return this.strokeColor;
  }
  
  int getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  ColorStateList getSupportBackgroundTintList()
  {
    return this.backgroundTint;
  }
  
  PorterDuff.Mode getSupportBackgroundTintMode()
  {
    return this.backgroundTintMode;
  }
  
  boolean isBackgroundOverwritten()
  {
    return this.backgroundOverwritten;
  }
  
  public void loadFromAttributes(TypedArray paramTypedArray)
  {
    int j = R.styleable.MaterialButton_android_insetLeft;
    int i = 0;
    this.insetLeft = paramTypedArray.getDimensionPixelOffset(j, 0);
    this.insetRight = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
    this.insetTop = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
    this.insetBottom = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
    this.cornerRadius = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, 0);
    this.strokeWidth = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
    this.backgroundTintMode = ViewUtils.parseTintMode(paramTypedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
    this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), paramTypedArray, R.styleable.MaterialButton_backgroundTint);
    this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), paramTypedArray, R.styleable.MaterialButton_strokeColor);
    this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), paramTypedArray, R.styleable.MaterialButton_rippleColor);
    this.buttonStrokePaint.setStyle(Paint.Style.STROKE);
    this.buttonStrokePaint.setStrokeWidth(this.strokeWidth);
    paramTypedArray = this.buttonStrokePaint;
    if (this.strokeColor != null) {
      i = this.strokeColor.getColorForState(this.materialButton.getDrawableState(), 0);
    }
    paramTypedArray.setColor(i);
    i = ViewCompat.getPaddingStart(this.materialButton);
    j = this.materialButton.getPaddingTop();
    int k = ViewCompat.getPaddingEnd(this.materialButton);
    int m = this.materialButton.getPaddingBottom();
    MaterialButton localMaterialButton = this.materialButton;
    if (IS_LOLLIPOP) {
      paramTypedArray = createBackgroundLollipop();
    } else {
      paramTypedArray = createBackgroundCompat();
    }
    localMaterialButton.setInternalBackground(paramTypedArray);
    ViewCompat.setPaddingRelative(this.materialButton, i + this.insetLeft, j + this.insetTop, k + this.insetRight, m + this.insetBottom);
  }
  
  void setBackgroundColor(int paramInt)
  {
    if ((IS_LOLLIPOP) && (this.backgroundDrawableLollipop != null))
    {
      this.backgroundDrawableLollipop.setColor(paramInt);
      return;
    }
    if ((!IS_LOLLIPOP) && (this.colorableBackgroundDrawableCompat != null)) {
      this.colorableBackgroundDrawableCompat.setColor(paramInt);
    }
  }
  
  void setBackgroundOverwritten()
  {
    this.backgroundOverwritten = true;
    this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
    this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
  }
  
  void setCornerRadius(int paramInt)
  {
    if (this.cornerRadius != paramInt)
    {
      this.cornerRadius = paramInt;
      GradientDrawable localGradientDrawable;
      float f;
      if ((IS_LOLLIPOP) && (this.backgroundDrawableLollipop != null) && (this.strokeDrawableLollipop != null) && (this.maskDrawableLollipop != null))
      {
        if (Build.VERSION.SDK_INT == 21)
        {
          localGradientDrawable = unwrapBackgroundDrawable();
          f = paramInt + 1.0E-5F;
          localGradientDrawable.setCornerRadius(f);
          unwrapStrokeDrawable().setCornerRadius(f);
        }
        localGradientDrawable = this.backgroundDrawableLollipop;
        f = paramInt + 1.0E-5F;
        localGradientDrawable.setCornerRadius(f);
        this.strokeDrawableLollipop.setCornerRadius(f);
        this.maskDrawableLollipop.setCornerRadius(f);
        return;
      }
      if ((!IS_LOLLIPOP) && (this.colorableBackgroundDrawableCompat != null) && (this.rippleDrawableCompat != null))
      {
        localGradientDrawable = this.colorableBackgroundDrawableCompat;
        f = paramInt + 1.0E-5F;
        localGradientDrawable.setCornerRadius(f);
        this.rippleDrawableCompat.setCornerRadius(f);
        this.materialButton.invalidate();
      }
    }
  }
  
  void setRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.rippleColor != paramColorStateList)
    {
      this.rippleColor = paramColorStateList;
      if ((IS_LOLLIPOP) && ((this.materialButton.getBackground() instanceof RippleDrawable)))
      {
        ((RippleDrawable)this.materialButton.getBackground()).setColor(paramColorStateList);
        return;
      }
      if ((!IS_LOLLIPOP) && (this.tintableRippleDrawableCompat != null)) {
        DrawableCompat.setTintList(this.tintableRippleDrawableCompat, paramColorStateList);
      }
    }
  }
  
  void setStrokeColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.strokeColor != paramColorStateList)
    {
      this.strokeColor = paramColorStateList;
      Paint localPaint = this.buttonStrokePaint;
      int i = 0;
      if (paramColorStateList != null) {
        i = paramColorStateList.getColorForState(this.materialButton.getDrawableState(), 0);
      }
      localPaint.setColor(i);
      updateStroke();
    }
  }
  
  void setStrokeWidth(int paramInt)
  {
    if (this.strokeWidth != paramInt)
    {
      this.strokeWidth = paramInt;
      this.buttonStrokePaint.setStrokeWidth(paramInt);
      updateStroke();
    }
  }
  
  void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.backgroundTint != paramColorStateList)
    {
      this.backgroundTint = paramColorStateList;
      if (IS_LOLLIPOP)
      {
        updateTintAndTintModeLollipop();
        return;
      }
      if (this.tintableBackgroundDrawableCompat != null) {
        DrawableCompat.setTintList(this.tintableBackgroundDrawableCompat, this.backgroundTint);
      }
    }
  }
  
  void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.backgroundTintMode != paramMode)
    {
      this.backgroundTintMode = paramMode;
      if (IS_LOLLIPOP)
      {
        updateTintAndTintModeLollipop();
        return;
      }
      if ((this.tintableBackgroundDrawableCompat != null) && (this.backgroundTintMode != null)) {
        DrawableCompat.setTintMode(this.tintableBackgroundDrawableCompat, this.backgroundTintMode);
      }
    }
  }
  
  void updateMaskBounds(int paramInt1, int paramInt2)
  {
    if (this.maskDrawableLollipop != null) {
      this.maskDrawableLollipop.setBounds(this.insetLeft, this.insetTop, paramInt2 - this.insetRight, paramInt1 - this.insetBottom);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\button\MaterialButtonHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */