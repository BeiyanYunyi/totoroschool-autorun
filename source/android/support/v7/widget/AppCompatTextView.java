package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.annotation.RestrictTo;
import android.support.v4.text.PrecomputedTextCompat;
import android.support.v4.text.PrecomputedTextCompat.Params;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v4.widget.TextViewCompat;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView
  extends TextView
  implements TintableBackgroundView, AutoSizeableTextView
{
  private final AppCompatBackgroundHelper mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
  @Nullable
  private Future<PrecomputedTextCompat> mPrecomputedTextFuture;
  private final AppCompatTextHelper mTextHelper;
  
  public AppCompatTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    this.mBackgroundTintHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.mTextHelper = new AppCompatTextHelper(this);
    this.mTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.mTextHelper.applyCompoundDrawablesTints();
  }
  
  private void consumeTextFutureAndSetBlocking()
  {
    if (this.mPrecomputedTextFuture != null) {}
    try
    {
      Future localFuture = this.mPrecomputedTextFuture;
      this.mPrecomputedTextFuture = null;
      TextViewCompat.setPrecomputedText(this, (PrecomputedTextCompat)localFuture.get());
      return;
    }
    catch (InterruptedException|ExecutionException localInterruptedException) {}
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.applySupportBackgroundTint();
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.applyCompoundDrawablesTints();
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public int getAutoSizeMaxTextSize()
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      return super.getAutoSizeMaxTextSize();
    }
    if (this.mTextHelper != null) {
      return this.mTextHelper.getAutoSizeMaxTextSize();
    }
    return -1;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public int getAutoSizeMinTextSize()
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      return super.getAutoSizeMinTextSize();
    }
    if (this.mTextHelper != null) {
      return this.mTextHelper.getAutoSizeMinTextSize();
    }
    return -1;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public int getAutoSizeStepGranularity()
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      return super.getAutoSizeStepGranularity();
    }
    if (this.mTextHelper != null) {
      return this.mTextHelper.getAutoSizeStepGranularity();
    }
    return -1;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      return super.getAutoSizeTextAvailableSizes();
    }
    if (this.mTextHelper != null) {
      return this.mTextHelper.getAutoSizeTextAvailableSizes();
    }
    return new int[0];
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public int getAutoSizeTextType()
  {
    boolean bool = PLATFORM_SUPPORTS_AUTOSIZE;
    int i = 0;
    if (bool)
    {
      if (super.getAutoSizeTextType() == 1) {
        i = 1;
      }
      return i;
    }
    if (this.mTextHelper != null) {
      return this.mTextHelper.getAutoSizeTextType();
    }
    return 0;
  }
  
  public int getFirstBaselineToTopHeight()
  {
    return TextViewCompat.getFirstBaselineToTopHeight(this);
  }
  
  public int getLastBaselineToBottomHeight()
  {
    return TextViewCompat.getLastBaselineToBottomHeight(this);
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.mBackgroundTintHelper != null) {
      return this.mBackgroundTintHelper.getSupportBackgroundTintList();
    }
    return null;
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.mBackgroundTintHelper != null) {
      return this.mBackgroundTintHelper.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public CharSequence getText()
  {
    consumeTextFutureAndSetBlocking();
    return super.getText();
  }
  
  @NonNull
  public PrecomputedTextCompat.Params getTextMetricsParamsCompat()
  {
    return TextViewCompat.getTextMetricsParams(this);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mTextHelper != null) {
      this.mTextHelper.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    consumeTextFutureAndSetBlocking();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.mTextHelper != null) && (!PLATFORM_SUPPORTS_AUTOSIZE) && (this.mTextHelper.isAutoSizeEnabled())) {
      this.mTextHelper.autoSizeText();
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
    {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
    {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
    {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.onSetBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.onSetBackgroundResource(paramInt);
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, paramCallback));
  }
  
  public void setFirstBaselineToTopHeight(@IntRange(from=0L) @Px int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setFirstBaselineToTopHeight(paramInt);
      return;
    }
    TextViewCompat.setFirstBaselineToTopHeight(this, paramInt);
  }
  
  public void setLastBaselineToBottomHeight(@IntRange(from=0L) @Px int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setLastBaselineToBottomHeight(paramInt);
      return;
    }
    TextViewCompat.setLastBaselineToBottomHeight(this, paramInt);
  }
  
  public void setLineHeight(@IntRange(from=0L) @Px int paramInt)
  {
    TextViewCompat.setLineHeight(this, paramInt);
  }
  
  public void setPrecomputedText(@NonNull PrecomputedTextCompat paramPrecomputedTextCompat)
  {
    TextViewCompat.setPrecomputedText(this, paramPrecomputedTextCompat);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null) {
      this.mTextHelper.onSetTextAppearance(paramContext, paramInt);
    }
  }
  
  public void setTextFuture(@NonNull Future<PrecomputedTextCompat> paramFuture)
  {
    this.mPrecomputedTextFuture = paramFuture;
    requestLayout();
  }
  
  public void setTextMetricsParamsCompat(@NonNull PrecomputedTextCompat.Params paramParams)
  {
    TextViewCompat.setTextMetricsParams(this, paramParams);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
    {
      super.setTextSize(paramInt, paramFloat);
      return;
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.setTextSize(paramInt, paramFloat);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\AppCompatTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */