package android.support.design.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.design.animation.AnimationUtils;
import android.support.v4.math.MathUtils;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.TintTypedArray;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class CollapsingTextHelper
{
  private static final boolean DEBUG_DRAW = false;
  private static final Paint DEBUG_DRAW_PAINT;
  private static final boolean USE_SCALING_TEXTURE;
  private boolean boundsChanged;
  private final Rect collapsedBounds;
  private float collapsedDrawX;
  private float collapsedDrawY;
  private int collapsedShadowColor;
  private float collapsedShadowDx;
  private float collapsedShadowDy;
  private float collapsedShadowRadius;
  private ColorStateList collapsedTextColor;
  private int collapsedTextGravity = 16;
  private float collapsedTextSize = 15.0F;
  private Typeface collapsedTypeface;
  private final RectF currentBounds;
  private float currentDrawX;
  private float currentDrawY;
  private float currentTextSize;
  private Typeface currentTypeface;
  private boolean drawTitle;
  private final Rect expandedBounds;
  private float expandedDrawX;
  private float expandedDrawY;
  private float expandedFraction;
  private int expandedShadowColor;
  private float expandedShadowDx;
  private float expandedShadowDy;
  private float expandedShadowRadius;
  private ColorStateList expandedTextColor;
  private int expandedTextGravity = 16;
  private float expandedTextSize = 15.0F;
  private Bitmap expandedTitleTexture;
  private Typeface expandedTypeface;
  private boolean isRtl;
  private TimeInterpolator positionInterpolator;
  private float scale;
  private int[] state;
  private CharSequence text;
  private final TextPaint textPaint;
  private TimeInterpolator textSizeInterpolator;
  private CharSequence textToDraw;
  private float textureAscent;
  private float textureDescent;
  private Paint texturePaint;
  private final TextPaint tmpPaint;
  private boolean useTexture;
  private final View view;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 18) {
      bool = true;
    } else {
      bool = false;
    }
    USE_SCALING_TEXTURE = bool;
    DEBUG_DRAW_PAINT = null;
    if (DEBUG_DRAW_PAINT != null)
    {
      DEBUG_DRAW_PAINT.setAntiAlias(true);
      DEBUG_DRAW_PAINT.setColor(-65281);
    }
  }
  
  public CollapsingTextHelper(View paramView)
  {
    this.view = paramView;
    this.textPaint = new TextPaint(129);
    this.tmpPaint = new TextPaint(this.textPaint);
    this.collapsedBounds = new Rect();
    this.expandedBounds = new Rect();
    this.currentBounds = new RectF();
  }
  
  private static int blendColors(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = Color.alpha(paramInt1);
    float f3 = Color.alpha(paramInt2);
    float f4 = Color.red(paramInt1);
    float f5 = Color.red(paramInt2);
    float f6 = Color.green(paramInt1);
    float f7 = Color.green(paramInt2);
    float f8 = Color.blue(paramInt1);
    float f9 = Color.blue(paramInt2);
    return Color.argb((int)(f2 * f1 + f3 * paramFloat), (int)(f4 * f1 + f5 * paramFloat), (int)(f6 * f1 + f7 * paramFloat), (int)(f8 * f1 + f9 * paramFloat));
  }
  
  private void calculateBaseOffsets()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void calculateCurrentOffsets()
  {
    calculateOffsets(this.expandedFraction);
  }
  
  private boolean calculateIsRtl(CharSequence paramCharSequence)
  {
    int j = ViewCompat.getLayoutDirection(this.view);
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    TextDirectionHeuristicCompat localTextDirectionHeuristicCompat;
    if (i != 0) {
      localTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
    } else {
      localTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    }
    return localTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private void calculateOffsets(float paramFloat)
  {
    interpolateBounds(paramFloat);
    this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, paramFloat, this.positionInterpolator);
    this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, paramFloat, this.positionInterpolator);
    setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, paramFloat, this.textSizeInterpolator));
    if (this.collapsedTextColor != this.expandedTextColor) {
      this.textPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), paramFloat));
    } else {
      this.textPaint.setColor(getCurrentCollapsedTextColor());
    }
    this.textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, paramFloat, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, paramFloat, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, paramFloat, null), blendColors(this.expandedShadowColor, this.collapsedShadowColor, paramFloat));
    ViewCompat.postInvalidateOnAnimation(this.view);
  }
  
  private void calculateUsingTextSize(float paramFloat)
  {
    if (this.text == null) {
      return;
    }
    float f2 = this.collapsedBounds.width();
    float f3 = this.expandedBounds.width();
    boolean bool2 = isClose(paramFloat, this.collapsedTextSize);
    boolean bool1 = true;
    float f1;
    int i;
    if (bool2)
    {
      f1 = this.collapsedTextSize;
      this.scale = 1.0F;
      if (this.currentTypeface != this.collapsedTypeface)
      {
        this.currentTypeface = this.collapsedTypeface;
        i = 1;
      }
      else
      {
        i = 0;
      }
      paramFloat = f2;
    }
    else
    {
      f1 = this.expandedTextSize;
      if (this.currentTypeface != this.expandedTypeface)
      {
        this.currentTypeface = this.expandedTypeface;
        i = 1;
      }
      else
      {
        i = 0;
      }
      if (isClose(paramFloat, this.expandedTextSize)) {
        this.scale = 1.0F;
      } else {
        this.scale = (paramFloat / this.expandedTextSize);
      }
      paramFloat = this.collapsedTextSize / this.expandedTextSize;
      if (f3 * paramFloat > f2) {
        paramFloat = Math.min(f2 / paramFloat, f3);
      } else {
        paramFloat = f3;
      }
    }
    int j = i;
    if (paramFloat > 0.0F)
    {
      if ((this.currentTextSize == f1) && (!this.boundsChanged) && (i == 0)) {
        i = 0;
      } else {
        i = 1;
      }
      this.currentTextSize = f1;
      this.boundsChanged = false;
      j = i;
    }
    if ((this.textToDraw == null) || (j != 0))
    {
      this.textPaint.setTextSize(this.currentTextSize);
      this.textPaint.setTypeface(this.currentTypeface);
      Object localObject = this.textPaint;
      if (this.scale == 1.0F) {
        bool1 = false;
      }
      ((TextPaint)localObject).setLinearText(bool1);
      localObject = TextUtils.ellipsize(this.text, this.textPaint, paramFloat, TextUtils.TruncateAt.END);
      if (!TextUtils.equals((CharSequence)localObject, this.textToDraw))
      {
        this.textToDraw = ((CharSequence)localObject);
        this.isRtl = calculateIsRtl(this.textToDraw);
      }
    }
  }
  
  private void clearTexture()
  {
    if (this.expandedTitleTexture != null)
    {
      this.expandedTitleTexture.recycle();
      this.expandedTitleTexture = null;
    }
  }
  
  private void ensureExpandedTexture()
  {
    if ((this.expandedTitleTexture == null) && (!this.expandedBounds.isEmpty()))
    {
      if (TextUtils.isEmpty(this.textToDraw)) {
        return;
      }
      calculateOffsets(0.0F);
      this.textureAscent = this.textPaint.ascent();
      this.textureDescent = this.textPaint.descent();
      int i = Math.round(this.textPaint.measureText(this.textToDraw, 0, this.textToDraw.length()));
      int j = Math.round(this.textureDescent - this.textureAscent);
      if (i > 0)
      {
        if (j <= 0) {
          return;
        }
        this.expandedTitleTexture = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        new Canvas(this.expandedTitleTexture).drawText(this.textToDraw, 0, this.textToDraw.length(), 0.0F, j - this.textPaint.descent(), this.textPaint);
        if (this.texturePaint == null) {
          this.texturePaint = new Paint(3);
        }
        return;
      }
      return;
    }
  }
  
  @ColorInt
  private int getCurrentExpandedTextColor()
  {
    if (this.state != null) {
      return this.expandedTextColor.getColorForState(this.state, 0);
    }
    return this.expandedTextColor.getDefaultColor();
  }
  
  private void getTextPaintCollapsed(TextPaint paramTextPaint)
  {
    paramTextPaint.setTextSize(this.collapsedTextSize);
    paramTextPaint.setTypeface(this.collapsedTypeface);
  }
  
  private void interpolateBounds(float paramFloat)
  {
    this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, paramFloat, this.positionInterpolator);
    this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, paramFloat, this.positionInterpolator);
    this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, paramFloat, this.positionInterpolator);
    this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, paramFloat, this.positionInterpolator);
  }
  
  private static boolean isClose(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 0.001F;
  }
  
  private static float lerp(float paramFloat1, float paramFloat2, float paramFloat3, TimeInterpolator paramTimeInterpolator)
  {
    float f = paramFloat3;
    if (paramTimeInterpolator != null) {
      f = paramTimeInterpolator.getInterpolation(paramFloat3);
    }
    return AnimationUtils.lerp(paramFloat1, paramFloat2, f);
  }
  
  private Typeface readFontFamilyTypeface(int paramInt)
  {
    TypedArray localTypedArray = this.view.getContext().obtainStyledAttributes(paramInt, new int[] { 16843692 });
    try
    {
      Object localObject1 = localTypedArray.getString(0);
      if (localObject1 != null)
      {
        localObject1 = Typeface.create((String)localObject1, 0);
        return (Typeface)localObject1;
      }
      return null;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
  
  private static boolean rectEquals(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramRect.left == paramInt1) && (paramRect.top == paramInt2) && (paramRect.right == paramInt3) && (paramRect.bottom == paramInt4);
  }
  
  private void setInterpolatedTextSize(float paramFloat)
  {
    calculateUsingTextSize(paramFloat);
    boolean bool;
    if ((USE_SCALING_TEXTURE) && (this.scale != 1.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    this.useTexture = bool;
    if (this.useTexture) {
      ensureExpandedTexture();
    }
    ViewCompat.postInvalidateOnAnimation(this.view);
  }
  
  public float calculateCollapsedTextWidth()
  {
    if (this.text == null) {
      return 0.0F;
    }
    getTextPaintCollapsed(this.tmpPaint);
    return this.tmpPaint.measureText(this.text, 0, this.text.length());
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = paramCanvas.save();
    if ((this.textToDraw != null) && (this.drawTitle))
    {
      float f4 = this.currentDrawX;
      float f3 = this.currentDrawY;
      int i;
      if ((this.useTexture) && (this.expandedTitleTexture != null)) {
        i = 1;
      } else {
        i = 0;
      }
      float f1;
      if (i != 0)
      {
        f1 = this.textureAscent * this.scale;
        f2 = this.textureDescent;
        f2 = this.scale;
      }
      else
      {
        f1 = this.textPaint.ascent() * this.scale;
        this.textPaint.descent();
        f2 = this.scale;
      }
      float f2 = f3;
      if (i != 0) {
        f2 = f3 + f1;
      }
      if (this.scale != 1.0F) {
        paramCanvas.scale(this.scale, this.scale, f4, f2);
      }
      if (i != 0) {
        paramCanvas.drawBitmap(this.expandedTitleTexture, f4, f2, this.texturePaint);
      } else {
        paramCanvas.drawText(this.textToDraw, 0, this.textToDraw.length(), f4, f2, this.textPaint);
      }
    }
    paramCanvas.restoreToCount(j);
  }
  
  public void getCollapsedTextActualBounds(RectF paramRectF)
  {
    boolean bool = calculateIsRtl(this.text);
    float f;
    if (!bool) {
      f = this.collapsedBounds.left;
    } else {
      f = this.collapsedBounds.right - calculateCollapsedTextWidth();
    }
    paramRectF.left = f;
    paramRectF.top = this.collapsedBounds.top;
    if (!bool) {
      f = paramRectF.left + calculateCollapsedTextWidth();
    } else {
      f = this.collapsedBounds.right;
    }
    paramRectF.right = f;
    paramRectF.bottom = (this.collapsedBounds.top + getCollapsedTextHeight());
  }
  
  public ColorStateList getCollapsedTextColor()
  {
    return this.collapsedTextColor;
  }
  
  public int getCollapsedTextGravity()
  {
    return this.collapsedTextGravity;
  }
  
  public float getCollapsedTextHeight()
  {
    getTextPaintCollapsed(this.tmpPaint);
    return -this.tmpPaint.ascent();
  }
  
  public float getCollapsedTextSize()
  {
    return this.collapsedTextSize;
  }
  
  public Typeface getCollapsedTypeface()
  {
    if (this.collapsedTypeface != null) {
      return this.collapsedTypeface;
    }
    return Typeface.DEFAULT;
  }
  
  @ColorInt
  @VisibleForTesting
  public int getCurrentCollapsedTextColor()
  {
    if (this.state != null) {
      return this.collapsedTextColor.getColorForState(this.state, 0);
    }
    return this.collapsedTextColor.getDefaultColor();
  }
  
  public ColorStateList getExpandedTextColor()
  {
    return this.expandedTextColor;
  }
  
  public int getExpandedTextGravity()
  {
    return this.expandedTextGravity;
  }
  
  public float getExpandedTextSize()
  {
    return this.expandedTextSize;
  }
  
  public Typeface getExpandedTypeface()
  {
    if (this.expandedTypeface != null) {
      return this.expandedTypeface;
    }
    return Typeface.DEFAULT;
  }
  
  public float getExpansionFraction()
  {
    return this.expandedFraction;
  }
  
  public CharSequence getText()
  {
    return this.text;
  }
  
  public final boolean isStateful()
  {
    return ((this.collapsedTextColor != null) && (this.collapsedTextColor.isStateful())) || ((this.expandedTextColor != null) && (this.expandedTextColor.isStateful()));
  }
  
  void onBoundsChanged()
  {
    boolean bool;
    if ((this.collapsedBounds.width() > 0) && (this.collapsedBounds.height() > 0) && (this.expandedBounds.width() > 0) && (this.expandedBounds.height() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.drawTitle = bool;
  }
  
  public void recalculate()
  {
    if ((this.view.getHeight() > 0) && (this.view.getWidth() > 0))
    {
      calculateBaseOffsets();
      calculateCurrentOffsets();
    }
  }
  
  public void setCollapsedBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!rectEquals(this.collapsedBounds, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.collapsedBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.boundsChanged = true;
      onBoundsChanged();
    }
  }
  
  public void setCollapsedTextAppearance(int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(this.view.getContext(), paramInt, R.styleable.TextAppearance);
    if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)) {
      this.collapsedTextColor = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
    }
    if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textSize)) {
      this.collapsedTextSize = localTintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int)this.collapsedTextSize);
    }
    this.collapsedShadowColor = localTintTypedArray.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
    this.collapsedShadowDx = localTintTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0F);
    this.collapsedShadowDy = localTintTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0F);
    this.collapsedShadowRadius = localTintTypedArray.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0F);
    localTintTypedArray.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.collapsedTypeface = readFontFamilyTypeface(paramInt);
    }
    recalculate();
  }
  
  public void setCollapsedTextColor(ColorStateList paramColorStateList)
  {
    if (this.collapsedTextColor != paramColorStateList)
    {
      this.collapsedTextColor = paramColorStateList;
      recalculate();
    }
  }
  
  public void setCollapsedTextGravity(int paramInt)
  {
    if (this.collapsedTextGravity != paramInt)
    {
      this.collapsedTextGravity = paramInt;
      recalculate();
    }
  }
  
  public void setCollapsedTextSize(float paramFloat)
  {
    if (this.collapsedTextSize != paramFloat)
    {
      this.collapsedTextSize = paramFloat;
      recalculate();
    }
  }
  
  public void setCollapsedTypeface(Typeface paramTypeface)
  {
    if (this.collapsedTypeface != paramTypeface)
    {
      this.collapsedTypeface = paramTypeface;
      recalculate();
    }
  }
  
  public void setExpandedBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!rectEquals(this.expandedBounds, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.expandedBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.boundsChanged = true;
      onBoundsChanged();
    }
  }
  
  public void setExpandedTextAppearance(int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(this.view.getContext(), paramInt, R.styleable.TextAppearance);
    if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)) {
      this.expandedTextColor = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
    }
    if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textSize)) {
      this.expandedTextSize = localTintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int)this.expandedTextSize);
    }
    this.expandedShadowColor = localTintTypedArray.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
    this.expandedShadowDx = localTintTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0F);
    this.expandedShadowDy = localTintTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0F);
    this.expandedShadowRadius = localTintTypedArray.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0F);
    localTintTypedArray.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.expandedTypeface = readFontFamilyTypeface(paramInt);
    }
    recalculate();
  }
  
  public void setExpandedTextColor(ColorStateList paramColorStateList)
  {
    if (this.expandedTextColor != paramColorStateList)
    {
      this.expandedTextColor = paramColorStateList;
      recalculate();
    }
  }
  
  public void setExpandedTextGravity(int paramInt)
  {
    if (this.expandedTextGravity != paramInt)
    {
      this.expandedTextGravity = paramInt;
      recalculate();
    }
  }
  
  public void setExpandedTextSize(float paramFloat)
  {
    if (this.expandedTextSize != paramFloat)
    {
      this.expandedTextSize = paramFloat;
      recalculate();
    }
  }
  
  public void setExpandedTypeface(Typeface paramTypeface)
  {
    if (this.expandedTypeface != paramTypeface)
    {
      this.expandedTypeface = paramTypeface;
      recalculate();
    }
  }
  
  public void setExpansionFraction(float paramFloat)
  {
    paramFloat = MathUtils.clamp(paramFloat, 0.0F, 1.0F);
    if (paramFloat != this.expandedFraction)
    {
      this.expandedFraction = paramFloat;
      calculateCurrentOffsets();
    }
  }
  
  public void setPositionInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    this.positionInterpolator = paramTimeInterpolator;
    recalculate();
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    this.state = paramArrayOfInt;
    if (isStateful())
    {
      recalculate();
      return true;
    }
    return false;
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!paramCharSequence.equals(this.text)))
    {
      this.text = paramCharSequence;
      this.textToDraw = null;
      clearTexture();
      recalculate();
    }
  }
  
  public void setTextSizeInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    this.textSizeInterpolator = paramTimeInterpolator;
    recalculate();
  }
  
  public void setTypefaces(Typeface paramTypeface)
  {
    this.expandedTypeface = paramTypeface;
    this.collapsedTypeface = paramTypeface;
    recalculate();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\CollapsingTextHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */