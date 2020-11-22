package android.support.design.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.AnimatorRes;
import android.support.annotation.BoolRes;
import android.support.annotation.CallSuper;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.design.R.attr;
import android.support.design.R.string;
import android.support.design.R.style;
import android.support.design.animation.MotionSpec;
import android.support.design.internal.ViewUtils;
import android.support.design.resources.TextAppearance;
import android.support.design.ripple.RippleUtils;
import android.support.v4.content.res.ResourcesCompat.FontCallback;
import android.support.v4.text.BidiFormatter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView.BufferType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Chip
  extends AppCompatCheckBox
  implements ChipDrawable.Delegate
{
  private static final int CLOSE_ICON_VIRTUAL_ID = 0;
  private static final Rect EMPTY_BOUNDS = new Rect();
  private static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
  private static final int[] SELECTED_STATE = { 16842913 };
  private static final String TAG = "Chip";
  @Nullable
  private ChipDrawable chipDrawable;
  private boolean closeIconFocused;
  private boolean closeIconHovered;
  private boolean closeIconPressed;
  private boolean deferredCheckedValue;
  private int focusedVirtualView = Integer.MIN_VALUE;
  private final ResourcesCompat.FontCallback fontCallback = new ResourcesCompat.FontCallback()
  {
    public void onFontRetrievalFailed(int paramAnonymousInt) {}
    
    public void onFontRetrieved(@NonNull Typeface paramAnonymousTypeface)
    {
      Chip.this.setText(Chip.this.getText());
      Chip.this.requestLayout();
      Chip.this.invalidate();
    }
  };
  @Nullable
  private CompoundButton.OnCheckedChangeListener onCheckedChangeListenerInternal;
  @Nullable
  private View.OnClickListener onCloseIconClickListener;
  private final Rect rect = new Rect();
  private final RectF rectF = new RectF();
  @Nullable
  private RippleDrawable ripple;
  private final ChipTouchHelper touchHelper;
  
  public Chip(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.chipStyle);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    validateAttributes(paramAttributeSet);
    paramContext = ChipDrawable.createFromAttributes(paramContext, paramAttributeSet, paramInt, R.style.Widget_MaterialComponents_Chip_Action);
    setChipDrawable(paramContext);
    this.touchHelper = new ChipTouchHelper(this);
    ViewCompat.setAccessibilityDelegate(this, this.touchHelper);
    initOutlineProvider();
    setChecked(this.deferredCheckedValue);
    paramContext.setShouldDrawText(false);
    setText(paramContext.getText());
    setEllipsize(paramContext.getEllipsize());
    setIncludeFontPadding(false);
    if (getTextAppearance() != null) {
      updateTextPaintDrawState(getTextAppearance());
    }
    setSingleLine();
    setGravity(8388627);
    updatePaddingInternal();
  }
  
  private void applyChipDrawable(@NonNull ChipDrawable paramChipDrawable)
  {
    paramChipDrawable.setDelegate(this);
  }
  
  private float calculateTextOffsetFromStart(@NonNull ChipDrawable paramChipDrawable)
  {
    float f = getChipStartPadding() + paramChipDrawable.calculateChipIconWidth() + getTextStartPadding();
    if (ViewCompat.getLayoutDirection(this) == 0) {
      return f;
    }
    return -f;
  }
  
  private int[] createCloseIconDrawableState()
  {
    boolean bool = isEnabled();
    int k = 0;
    if (bool) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (this.closeIconFocused) {
      i = j + 1;
    }
    int j = i;
    if (this.closeIconHovered) {
      j = i + 1;
    }
    i = j;
    if (this.closeIconPressed) {
      i = j + 1;
    }
    j = i;
    if (isChecked()) {
      j = i + 1;
    }
    int[] arrayOfInt = new int[j];
    j = k;
    if (isEnabled())
    {
      arrayOfInt[0] = 16842910;
      j = 1;
    }
    i = j;
    if (this.closeIconFocused)
    {
      arrayOfInt[j] = 16842908;
      i = j + 1;
    }
    j = i;
    if (this.closeIconHovered)
    {
      arrayOfInt[i] = 16843623;
      j = i + 1;
    }
    i = j;
    if (this.closeIconPressed)
    {
      arrayOfInt[j] = 16842919;
      i = j + 1;
    }
    if (isChecked()) {
      arrayOfInt[i] = 16842913;
    }
    return arrayOfInt;
  }
  
  private void ensureFocus()
  {
    if (this.focusedVirtualView == Integer.MIN_VALUE) {
      setFocusedVirtualView(-1);
    }
  }
  
  private RectF getCloseIconTouchBounds()
  {
    this.rectF.setEmpty();
    if (hasCloseIcon()) {
      this.chipDrawable.getCloseIconTouchBounds(this.rectF);
    }
    return this.rectF;
  }
  
  private Rect getCloseIconTouchBoundsInt()
  {
    RectF localRectF = getCloseIconTouchBounds();
    this.rect.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
    return this.rect;
  }
  
  @Nullable
  private TextAppearance getTextAppearance()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getTextAppearance();
    }
    return null;
  }
  
  @SuppressLint({"PrivateApi"})
  private boolean handleAccessibilityExit(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 10) {
      try
      {
        paramMotionEvent = ExploreByTouchHelper.class.getDeclaredField("mHoveredVirtualViewId");
        paramMotionEvent.setAccessible(true);
        if (((Integer)paramMotionEvent.get(this.touchHelper)).intValue() != Integer.MIN_VALUE)
        {
          paramMotionEvent = ExploreByTouchHelper.class.getDeclaredMethod("updateHoveredVirtualView", new Class[] { Integer.TYPE });
          paramMotionEvent.setAccessible(true);
          paramMotionEvent.invoke(this.touchHelper, new Object[] { Integer.valueOf(Integer.MIN_VALUE) });
          return true;
        }
      }
      catch (NoSuchFieldException paramMotionEvent)
      {
        Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
        return false;
      }
      catch (InvocationTargetException paramMotionEvent)
      {
        Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
        return false;
      }
      catch (IllegalAccessException paramMotionEvent)
      {
        Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
        return false;
      }
      catch (NoSuchMethodException paramMotionEvent)
      {
        Log.e("Chip", "Unable to send Accessibility Exit event", paramMotionEvent);
      }
    }
    return false;
  }
  
  private boolean hasCloseIcon()
  {
    return (this.chipDrawable != null) && (this.chipDrawable.getCloseIcon() != null);
  }
  
  private void initOutlineProvider()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      setOutlineProvider(new ViewOutlineProvider()
      {
        @TargetApi(21)
        public void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
        {
          if (Chip.this.chipDrawable != null)
          {
            Chip.this.chipDrawable.getOutline(paramAnonymousOutline);
            return;
          }
          paramAnonymousOutline.setAlpha(0.0F);
        }
      });
    }
  }
  
  private boolean moveFocus(boolean paramBoolean)
  {
    ensureFocus();
    if (paramBoolean)
    {
      if (this.focusedVirtualView == -1)
      {
        setFocusedVirtualView(0);
        return true;
      }
    }
    else if (this.focusedVirtualView == 0)
    {
      setFocusedVirtualView(-1);
      return true;
    }
    return false;
  }
  
  private void setCloseIconFocused(boolean paramBoolean)
  {
    if (this.closeIconFocused != paramBoolean)
    {
      this.closeIconFocused = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setCloseIconHovered(boolean paramBoolean)
  {
    if (this.closeIconHovered != paramBoolean)
    {
      this.closeIconHovered = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setCloseIconPressed(boolean paramBoolean)
  {
    if (this.closeIconPressed != paramBoolean)
    {
      this.closeIconPressed = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setFocusedVirtualView(int paramInt)
  {
    if (this.focusedVirtualView != paramInt)
    {
      if (this.focusedVirtualView == 0) {
        setCloseIconFocused(false);
      }
      this.focusedVirtualView = paramInt;
      if (paramInt == 0) {
        setCloseIconFocused(true);
      }
    }
  }
  
  private void unapplyChipDrawable(@Nullable ChipDrawable paramChipDrawable)
  {
    if (paramChipDrawable != null) {
      paramChipDrawable.setDelegate(null);
    }
  }
  
  private void updatePaddingInternal()
  {
    if (!TextUtils.isEmpty(getText()))
    {
      if (this.chipDrawable == null) {
        return;
      }
      float f2 = this.chipDrawable.getChipStartPadding() + this.chipDrawable.getChipEndPadding() + this.chipDrawable.getTextStartPadding() + this.chipDrawable.getTextEndPadding();
      float f1;
      if ((!this.chipDrawable.isChipIconVisible()) || (this.chipDrawable.getChipIcon() == null))
      {
        f1 = f2;
        if (this.chipDrawable.getCheckedIcon() != null)
        {
          f1 = f2;
          if (this.chipDrawable.isCheckedIconVisible())
          {
            f1 = f2;
            if (!isChecked()) {}
          }
        }
      }
      else
      {
        f1 = f2 + (this.chipDrawable.getIconStartPadding() + this.chipDrawable.getIconEndPadding() + this.chipDrawable.getChipIconSize());
      }
      f2 = f1;
      if (this.chipDrawable.isCloseIconVisible())
      {
        f2 = f1;
        if (this.chipDrawable.getCloseIcon() != null) {
          f2 = f1 + (this.chipDrawable.getCloseIconStartPadding() + this.chipDrawable.getCloseIconEndPadding() + this.chipDrawable.getCloseIconSize());
        }
      }
      if (ViewCompat.getPaddingEnd(this) != f2) {
        ViewCompat.setPaddingRelative(this, ViewCompat.getPaddingStart(this), getPaddingTop(), (int)f2, getPaddingBottom());
      }
      return;
    }
  }
  
  private void updateTextPaintDrawState(TextAppearance paramTextAppearance)
  {
    TextPaint localTextPaint = getPaint();
    localTextPaint.drawableState = this.chipDrawable.getState();
    paramTextAppearance.updateDrawState(getContext(), localTextPaint, this.fontCallback);
  }
  
  private void validateAttributes(@Nullable AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") == null)
    {
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null)
      {
        if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null)
        {
          if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null)
          {
            if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null)
            {
              if ((paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true)) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1))
              {
                if (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                  Log.w("Chip", "Chip text must be vertically center and start aligned");
                }
                return;
              }
              throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
          }
          throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
      }
      throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }
    throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    return (handleAccessibilityExit(paramMotionEvent)) || (this.touchHelper.dispatchHoverEvent(paramMotionEvent)) || (super.dispatchHoverEvent(paramMotionEvent));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (this.touchHelper.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    boolean bool;
    if ((this.chipDrawable != null) && (this.chipDrawable.isCloseIconStateful())) {
      bool = this.chipDrawable.setCloseIconState(createCloseIconDrawableState());
    } else {
      bool = false;
    }
    if (bool) {
      invalidate();
    }
  }
  
  @Nullable
  public Drawable getCheckedIcon()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getCheckedIcon();
    }
    return null;
  }
  
  @Nullable
  public ColorStateList getChipBackgroundColor()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getChipBackgroundColor();
    }
    return null;
  }
  
  public float getChipCornerRadius()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getChipCornerRadius();
    }
    return 0.0F;
  }
  
  public Drawable getChipDrawable()
  {
    return this.chipDrawable;
  }
  
  public float getChipEndPadding()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getChipEndPadding();
    }
    return 0.0F;
  }
  
  @Nullable
  public Drawable getChipIcon()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getChipIcon();
    }
    return null;
  }
  
  public float getChipIconSize()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getChipIconSize();
    }
    return 0.0F;
  }
  
  @Nullable
  public ColorStateList getChipIconTint()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getChipIconTint();
    }
    return null;
  }
  
  public float getChipMinHeight()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getChipMinHeight();
    }
    return 0.0F;
  }
  
  public float getChipStartPadding()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getChipStartPadding();
    }
    return 0.0F;
  }
  
  @Nullable
  public ColorStateList getChipStrokeColor()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getChipStrokeColor();
    }
    return null;
  }
  
  public float getChipStrokeWidth()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getChipStrokeWidth();
    }
    return 0.0F;
  }
  
  @Deprecated
  public CharSequence getChipText()
  {
    return getText();
  }
  
  @Nullable
  public Drawable getCloseIcon()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getCloseIcon();
    }
    return null;
  }
  
  @Nullable
  public CharSequence getCloseIconContentDescription()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getCloseIconContentDescription();
    }
    return null;
  }
  
  public float getCloseIconEndPadding()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getCloseIconEndPadding();
    }
    return 0.0F;
  }
  
  public float getCloseIconSize()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getCloseIconSize();
    }
    return 0.0F;
  }
  
  public float getCloseIconStartPadding()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getCloseIconStartPadding();
    }
    return 0.0F;
  }
  
  @Nullable
  public ColorStateList getCloseIconTint()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getCloseIconTint();
    }
    return null;
  }
  
  public TextUtils.TruncateAt getEllipsize()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getEllipsize();
    }
    return null;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    if (this.focusedVirtualView == 0)
    {
      paramRect.set(getCloseIconTouchBoundsInt());
      return;
    }
    super.getFocusedRect(paramRect);
  }
  
  @Nullable
  public MotionSpec getHideMotionSpec()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getHideMotionSpec();
    }
    return null;
  }
  
  public float getIconEndPadding()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getIconEndPadding();
    }
    return 0.0F;
  }
  
  public float getIconStartPadding()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getIconStartPadding();
    }
    return 0.0F;
  }
  
  @Nullable
  public ColorStateList getRippleColor()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getRippleColor();
    }
    return null;
  }
  
  @Nullable
  public MotionSpec getShowMotionSpec()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getShowMotionSpec();
    }
    return null;
  }
  
  public CharSequence getText()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getText();
    }
    return "";
  }
  
  public float getTextEndPadding()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getTextEndPadding();
    }
    return 0.0F;
  }
  
  public float getTextStartPadding()
  {
    if (this.chipDrawable != null) {
      return this.chipDrawable.getTextStartPadding();
    }
    return 0.0F;
  }
  
  public boolean isCheckable()
  {
    return (this.chipDrawable != null) && (this.chipDrawable.isCheckable());
  }
  
  @Deprecated
  public boolean isCheckedIconEnabled()
  {
    return isCheckedIconVisible();
  }
  
  public boolean isCheckedIconVisible()
  {
    return (this.chipDrawable != null) && (this.chipDrawable.isCheckedIconVisible());
  }
  
  @Deprecated
  public boolean isChipIconEnabled()
  {
    return isChipIconVisible();
  }
  
  public boolean isChipIconVisible()
  {
    return (this.chipDrawable != null) && (this.chipDrawable.isChipIconVisible());
  }
  
  @Deprecated
  public boolean isCloseIconEnabled()
  {
    return isCloseIconVisible();
  }
  
  public boolean isCloseIconVisible()
  {
    return (this.chipDrawable != null) && (this.chipDrawable.isCloseIconVisible());
  }
  
  public void onChipDrawableSizeChange()
  {
    updatePaddingInternal();
    requestLayout();
    if (Build.VERSION.SDK_INT >= 21) {
      invalidateOutline();
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, SELECTED_STATE);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((!TextUtils.isEmpty(getText())) && (this.chipDrawable != null) && (!this.chipDrawable.shouldDrawText()))
    {
      int i = paramCanvas.save();
      paramCanvas.translate(calculateTextOffsetFromStart(this.chipDrawable), 0.0F);
      super.onDraw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (paramBoolean) {
      setFocusedVirtualView(-1);
    } else {
      setFocusedVirtualView(Integer.MIN_VALUE);
    }
    invalidate();
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    this.touchHelper.onFocusChanged(paramBoolean, paramInt, paramRect);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 7)
    {
      if (i == 10) {
        setCloseIconHovered(false);
      }
    }
    else {
      setCloseIconHovered(getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY()));
    }
    return super.onHoverEvent(paramMotionEvent);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    boolean bool2 = false;
    boolean bool1;
    if (i != 61)
    {
      if (i != 66) {
        switch (i)
        {
        default: 
          bool1 = bool2;
          break;
        case 22: 
          bool1 = bool2;
          if (!paramKeyEvent.hasNoModifiers()) {
            break;
          }
          bool1 = moveFocus(ViewUtils.isLayoutRtl(this) ^ true);
          break;
        case 21: 
          bool1 = bool2;
          if (!paramKeyEvent.hasNoModifiers()) {
            break;
          }
          bool1 = moveFocus(ViewUtils.isLayoutRtl(this));
          break;
        }
      } else {
        switch (this.focusedVirtualView)
        {
        default: 
          bool1 = bool2;
          break;
        case 0: 
          performCloseIconClick();
          return true;
        case -1: 
          performClick();
          return true;
        }
      }
    }
    else
    {
      if (paramKeyEvent.hasNoModifiers()) {
        i = 2;
      } else if (paramKeyEvent.hasModifiers(1)) {
        i = 1;
      } else {
        i = 0;
      }
      bool1 = bool2;
      if (i != 0)
      {
        ViewParent localViewParent = getParent();
        Object localObject = this;
        View localView;
        do
        {
          localView = ((View)localObject).focusSearch(i);
          if ((localView == null) || (localView == this)) {
            break;
          }
          localObject = localView;
        } while (localView.getParent() == localViewParent);
        bool1 = bool2;
        if (localView != null)
        {
          localView.requestFocus();
          return true;
        }
      }
    }
    if (bool1)
    {
      invalidate();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  @TargetApi(24)
  public PointerIcon onResolvePointerIcon(MotionEvent paramMotionEvent, int paramInt)
  {
    if ((getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY())) && (isEnabled())) {
      return PointerIcon.getSystemIcon(getContext(), 1002);
    }
    return null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool2 = getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY());
    boolean bool1 = false;
    switch (i)
    {
    default: 
      break;
    case 2: 
      if (!this.closeIconPressed) {
        break label121;
      }
      if (bool2) {
        break label116;
      }
      setCloseIconPressed(false);
      break;
    case 1: 
      if (this.closeIconPressed)
      {
        performCloseIconClick();
        i = 1;
      }
      break;
    case 3: 
      i = 0;
      setCloseIconPressed(false);
      break;
    }
    if (bool2)
    {
      setCloseIconPressed(true);
      label116:
      i = 1;
    }
    else
    {
      label121:
      i = 0;
    }
    if ((i != 0) || (super.onTouchEvent(paramMotionEvent))) {
      bool1 = true;
    }
    return bool1;
  }
  
  @CallSuper
  public boolean performCloseIconClick()
  {
    playSoundEffect(0);
    boolean bool;
    if (this.onCloseIconClickListener != null)
    {
      this.onCloseIconClickListener.onClick(this);
      bool = true;
    }
    else
    {
      bool = false;
    }
    this.touchHelper.sendEventForVirtualView(0, 1);
    return bool;
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    if ((paramDrawable != this.chipDrawable) && (paramDrawable != this.ripple)) {
      throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
    }
    super.setBackground(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    throw new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable != this.chipDrawable) && (paramDrawable != this.ripple)) {
      throw new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    throw new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
  }
  
  public void setBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    throw new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
  }
  
  public void setBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    throw new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCheckable(paramBoolean);
    }
  }
  
  public void setCheckableResource(@BoolRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCheckableResource(paramInt);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.chipDrawable == null)
    {
      this.deferredCheckedValue = paramBoolean;
      return;
    }
    if (this.chipDrawable.isCheckable())
    {
      boolean bool = isChecked();
      super.setChecked(paramBoolean);
      if ((bool != paramBoolean) && (this.onCheckedChangeListenerInternal != null)) {
        this.onCheckedChangeListenerInternal.onCheckedChanged(this, paramBoolean);
      }
    }
  }
  
  public void setCheckedIcon(@Nullable Drawable paramDrawable)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCheckedIcon(paramDrawable);
    }
  }
  
  @Deprecated
  public void setCheckedIconEnabled(boolean paramBoolean)
  {
    setCheckedIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setCheckedIconEnabledResource(@BoolRes int paramInt)
  {
    setCheckedIconVisible(paramInt);
  }
  
  public void setCheckedIconResource(@DrawableRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCheckedIconResource(paramInt);
    }
  }
  
  public void setCheckedIconVisible(@BoolRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCheckedIconVisible(paramInt);
    }
  }
  
  public void setCheckedIconVisible(boolean paramBoolean)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCheckedIconVisible(paramBoolean);
    }
  }
  
  public void setChipBackgroundColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipBackgroundColor(paramColorStateList);
    }
  }
  
  public void setChipBackgroundColorResource(@ColorRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipBackgroundColorResource(paramInt);
    }
  }
  
  public void setChipCornerRadius(float paramFloat)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipCornerRadius(paramFloat);
    }
  }
  
  public void setChipCornerRadiusResource(@DimenRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipCornerRadiusResource(paramInt);
    }
  }
  
  public void setChipDrawable(@NonNull ChipDrawable paramChipDrawable)
  {
    if (this.chipDrawable != paramChipDrawable)
    {
      unapplyChipDrawable(this.chipDrawable);
      this.chipDrawable = paramChipDrawable;
      applyChipDrawable(this.chipDrawable);
      if (RippleUtils.USE_FRAMEWORK_RIPPLE)
      {
        this.ripple = new RippleDrawable(RippleUtils.convertToRippleDrawableColor(this.chipDrawable.getRippleColor()), this.chipDrawable, null);
        this.chipDrawable.setUseCompatRipple(false);
        ViewCompat.setBackground(this, this.ripple);
        return;
      }
      this.chipDrawable.setUseCompatRipple(true);
      ViewCompat.setBackground(this, this.chipDrawable);
    }
  }
  
  public void setChipEndPadding(float paramFloat)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipEndPadding(paramFloat);
    }
  }
  
  public void setChipEndPaddingResource(@DimenRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipEndPaddingResource(paramInt);
    }
  }
  
  public void setChipIcon(@Nullable Drawable paramDrawable)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipIcon(paramDrawable);
    }
  }
  
  @Deprecated
  public void setChipIconEnabled(boolean paramBoolean)
  {
    setChipIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setChipIconEnabledResource(@BoolRes int paramInt)
  {
    setChipIconVisible(paramInt);
  }
  
  public void setChipIconResource(@DrawableRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipIconResource(paramInt);
    }
  }
  
  public void setChipIconSize(float paramFloat)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipIconSize(paramFloat);
    }
  }
  
  public void setChipIconSizeResource(@DimenRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipIconSizeResource(paramInt);
    }
  }
  
  public void setChipIconTint(@Nullable ColorStateList paramColorStateList)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipIconTint(paramColorStateList);
    }
  }
  
  public void setChipIconTintResource(@ColorRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipIconTintResource(paramInt);
    }
  }
  
  public void setChipIconVisible(@BoolRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipIconVisible(paramInt);
    }
  }
  
  public void setChipIconVisible(boolean paramBoolean)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipIconVisible(paramBoolean);
    }
  }
  
  public void setChipMinHeight(float paramFloat)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipMinHeight(paramFloat);
    }
  }
  
  public void setChipMinHeightResource(@DimenRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipMinHeightResource(paramInt);
    }
  }
  
  public void setChipStartPadding(float paramFloat)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipStartPadding(paramFloat);
    }
  }
  
  public void setChipStartPaddingResource(@DimenRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipStartPaddingResource(paramInt);
    }
  }
  
  public void setChipStrokeColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipStrokeColor(paramColorStateList);
    }
  }
  
  public void setChipStrokeColorResource(@ColorRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipStrokeColorResource(paramInt);
    }
  }
  
  public void setChipStrokeWidth(float paramFloat)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipStrokeWidth(paramFloat);
    }
  }
  
  public void setChipStrokeWidthResource(@DimenRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setChipStrokeWidthResource(paramInt);
    }
  }
  
  @Deprecated
  public void setChipText(@Nullable CharSequence paramCharSequence)
  {
    setText(paramCharSequence);
  }
  
  @Deprecated
  public void setChipTextResource(@StringRes int paramInt)
  {
    setText(getResources().getString(paramInt));
  }
  
  public void setCloseIcon(@Nullable Drawable paramDrawable)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCloseIcon(paramDrawable);
    }
  }
  
  public void setCloseIconContentDescription(@Nullable CharSequence paramCharSequence)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCloseIconContentDescription(paramCharSequence);
    }
  }
  
  @Deprecated
  public void setCloseIconEnabled(boolean paramBoolean)
  {
    setCloseIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setCloseIconEnabledResource(@BoolRes int paramInt)
  {
    setCloseIconVisible(paramInt);
  }
  
  public void setCloseIconEndPadding(float paramFloat)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCloseIconEndPadding(paramFloat);
    }
  }
  
  public void setCloseIconEndPaddingResource(@DimenRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCloseIconEndPaddingResource(paramInt);
    }
  }
  
  public void setCloseIconResource(@DrawableRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCloseIconResource(paramInt);
    }
  }
  
  public void setCloseIconSize(float paramFloat)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCloseIconSize(paramFloat);
    }
  }
  
  public void setCloseIconSizeResource(@DimenRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCloseIconSizeResource(paramInt);
    }
  }
  
  public void setCloseIconStartPadding(float paramFloat)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCloseIconStartPadding(paramFloat);
    }
  }
  
  public void setCloseIconStartPaddingResource(@DimenRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCloseIconStartPaddingResource(paramInt);
    }
  }
  
  public void setCloseIconTint(@Nullable ColorStateList paramColorStateList)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCloseIconTint(paramColorStateList);
    }
  }
  
  public void setCloseIconTintResource(@ColorRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCloseIconTintResource(paramInt);
    }
  }
  
  public void setCloseIconVisible(@BoolRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCloseIconVisible(paramInt);
    }
  }
  
  public void setCloseIconVisible(boolean paramBoolean)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setCloseIconVisible(paramBoolean);
    }
  }
  
  public void setCompoundDrawables(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelative(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == 0)
    {
      if (paramInt3 == 0)
      {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == 0)
    {
      if (paramInt3 == 0)
      {
        super.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    if (this.chipDrawable == null) {
      return;
    }
    if (paramTruncateAt != TextUtils.TruncateAt.MARQUEE)
    {
      super.setEllipsize(paramTruncateAt);
      if (this.chipDrawable != null) {
        this.chipDrawable.setEllipsize(paramTruncateAt);
      }
      return;
    }
    throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
  }
  
  public void setGravity(int paramInt)
  {
    if (paramInt != 8388627)
    {
      Log.w("Chip", "Chip text must be vertically center and start aligned");
      return;
    }
    super.setGravity(paramInt);
  }
  
  public void setHideMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setHideMotionSpec(paramMotionSpec);
    }
  }
  
  public void setHideMotionSpecResource(@AnimatorRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setHideMotionSpecResource(paramInt);
    }
  }
  
  public void setIconEndPadding(float paramFloat)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setIconEndPadding(paramFloat);
    }
  }
  
  public void setIconEndPaddingResource(@DimenRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setIconEndPaddingResource(paramInt);
    }
  }
  
  public void setIconStartPadding(float paramFloat)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setIconStartPadding(paramFloat);
    }
  }
  
  public void setIconStartPaddingResource(@DimenRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setIconStartPaddingResource(paramInt);
    }
  }
  
  public void setLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setMaxLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setMaxLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setMaxWidth(@Px int paramInt)
  {
    super.setMaxWidth(paramInt);
    if (this.chipDrawable != null) {
      this.chipDrawable.setMaxWidth(paramInt);
    }
  }
  
  public void setMinLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setMinLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.onCheckedChangeListenerInternal = paramOnCheckedChangeListener;
  }
  
  public void setOnCloseIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.onCloseIconClickListener = paramOnClickListener;
  }
  
  public void setRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setRippleColor(paramColorStateList);
    }
  }
  
  public void setRippleColorResource(@ColorRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setRippleColorResource(paramInt);
    }
  }
  
  public void setShowMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setShowMotionSpec(paramMotionSpec);
    }
  }
  
  public void setShowMotionSpecResource(@AnimatorRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setShowMotionSpecResource(paramInt);
    }
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.setSingleLine(paramBoolean);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (this.chipDrawable == null) {
      return;
    }
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    paramCharSequence = BidiFormatter.getInstance().unicodeWrap((CharSequence)localObject);
    if (this.chipDrawable.shouldDrawText()) {
      paramCharSequence = null;
    }
    super.setText(paramCharSequence, paramBufferType);
    if (this.chipDrawable != null) {
      this.chipDrawable.setText((CharSequence)localObject);
    }
  }
  
  public void setTextAppearance(int paramInt)
  {
    super.setTextAppearance(paramInt);
    if (this.chipDrawable != null) {
      this.chipDrawable.setTextAppearanceResource(paramInt);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().updateMeasureState(getContext(), getPaint(), this.fontCallback);
      updateTextPaintDrawState(getTextAppearance());
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.chipDrawable != null) {
      this.chipDrawable.setTextAppearanceResource(paramInt);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().updateMeasureState(paramContext, getPaint(), this.fontCallback);
      updateTextPaintDrawState(getTextAppearance());
    }
  }
  
  public void setTextAppearance(@Nullable TextAppearance paramTextAppearance)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setTextAppearance(paramTextAppearance);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().updateMeasureState(getContext(), getPaint(), this.fontCallback);
      updateTextPaintDrawState(paramTextAppearance);
    }
  }
  
  public void setTextAppearanceResource(@StyleRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setTextAppearanceResource(paramInt);
    }
    setTextAppearance(getContext(), paramInt);
  }
  
  public void setTextEndPadding(float paramFloat)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setTextEndPadding(paramFloat);
    }
  }
  
  public void setTextEndPaddingResource(@DimenRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setTextEndPaddingResource(paramInt);
    }
  }
  
  public void setTextStartPadding(float paramFloat)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setTextStartPadding(paramFloat);
    }
  }
  
  public void setTextStartPaddingResource(@DimenRes int paramInt)
  {
    if (this.chipDrawable != null) {
      this.chipDrawable.setTextStartPaddingResource(paramInt);
    }
  }
  
  private class ChipTouchHelper
    extends ExploreByTouchHelper
  {
    ChipTouchHelper(Chip paramChip)
    {
      super();
    }
    
    protected int getVirtualViewAt(float paramFloat1, float paramFloat2)
    {
      if ((Chip.this.hasCloseIcon()) && (Chip.this.getCloseIconTouchBounds().contains(paramFloat1, paramFloat2))) {
        return 0;
      }
      return -1;
    }
    
    protected void getVisibleVirtualViews(List<Integer> paramList)
    {
      if (Chip.this.hasCloseIcon()) {
        paramList.add(Integer.valueOf(0));
      }
    }
    
    protected boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if ((paramInt2 == 16) && (paramInt1 == 0)) {
        return Chip.this.performCloseIconClick();
      }
      return false;
    }
    
    protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      boolean bool;
      if ((Chip.this.chipDrawable != null) && (Chip.this.chipDrawable.isCheckable())) {
        bool = true;
      } else {
        bool = false;
      }
      paramAccessibilityNodeInfoCompat.setCheckable(bool);
      paramAccessibilityNodeInfoCompat.setClassName(Chip.class.getName());
      CharSequence localCharSequence = Chip.this.getText();
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramAccessibilityNodeInfoCompat.setText(localCharSequence);
        return;
      }
      paramAccessibilityNodeInfoCompat.setContentDescription(localCharSequence);
    }
    
    protected void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      if (Chip.this.hasCloseIcon())
      {
        Object localObject = Chip.this.getCloseIconContentDescription();
        if (localObject != null)
        {
          paramAccessibilityNodeInfoCompat.setContentDescription((CharSequence)localObject);
        }
        else
        {
          localObject = Chip.this.getText();
          Context localContext = Chip.this.getContext();
          paramInt = R.string.mtrl_chip_close_icon_content_description;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            localObject = "";
          }
          paramAccessibilityNodeInfoCompat.setContentDescription(localContext.getString(paramInt, new Object[] { localObject }).trim());
        }
        paramAccessibilityNodeInfoCompat.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
        paramAccessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        paramAccessibilityNodeInfoCompat.setEnabled(Chip.this.isEnabled());
        return;
      }
      paramAccessibilityNodeInfoCompat.setContentDescription("");
      paramAccessibilityNodeInfoCompat.setBoundsInParent(Chip.EMPTY_BOUNDS);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\chip\Chip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */