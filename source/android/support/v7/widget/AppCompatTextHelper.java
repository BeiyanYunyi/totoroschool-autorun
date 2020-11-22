package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.ResourcesCompat.FontCallback;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class AppCompatTextHelper
{
  private static final int MONOSPACE = 3;
  private static final int SANS = 1;
  private static final int SERIF = 2;
  private boolean mAsyncFontPending;
  @NonNull
  private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
  private TintInfo mDrawableBottomTint;
  private TintInfo mDrawableEndTint;
  private TintInfo mDrawableLeftTint;
  private TintInfo mDrawableRightTint;
  private TintInfo mDrawableStartTint;
  private TintInfo mDrawableTopTint;
  private Typeface mFontTypeface;
  private int mStyle = 0;
  private final TextView mView;
  
  AppCompatTextHelper(TextView paramTextView)
  {
    this.mView = paramTextView;
    this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
  }
  
  private void applyCompoundDrawableTint(Drawable paramDrawable, TintInfo paramTintInfo)
  {
    if ((paramDrawable != null) && (paramTintInfo != null)) {
      AppCompatDrawableManager.tintDrawable(paramDrawable, paramTintInfo, this.mView.getDrawableState());
    }
  }
  
  private static TintInfo createTintInfo(Context paramContext, AppCompatDrawableManager paramAppCompatDrawableManager, int paramInt)
  {
    paramContext = paramAppCompatDrawableManager.getTintList(paramContext, paramInt);
    if (paramContext != null)
    {
      paramAppCompatDrawableManager = new TintInfo();
      paramAppCompatDrawableManager.mHasTintList = true;
      paramAppCompatDrawableManager.mTintList = paramContext;
      return paramAppCompatDrawableManager;
    }
    return null;
  }
  
  private void setTextSizeInternal(int paramInt, float paramFloat)
  {
    this.mAutoSizeTextHelper.setTextSizeInternal(paramInt, paramFloat);
  }
  
  private void updateTypefaceAndStyle(Context paramContext, TintTypedArray paramTintTypedArray)
  {
    this.mStyle = paramTintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
    boolean bool2 = paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_fontFamily);
    bool1 = true;
    if ((!bool2) && (!paramTintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)))
    {
      if (paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_typeface))
      {
        this.mAsyncFontPending = false;
        switch (paramTintTypedArray.getInt(R.styleable.TextAppearance_android_typeface, 1))
        {
        default: 
          return;
        case 3: 
          this.mFontTypeface = Typeface.MONOSPACE;
          return;
        case 2: 
          this.mFontTypeface = Typeface.SERIF;
          return;
        }
        this.mFontTypeface = Typeface.SANS_SERIF;
      }
      return;
    }
    this.mFontTypeface = null;
    int i;
    if (paramTintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
      i = R.styleable.TextAppearance_fontFamily;
    } else {
      i = R.styleable.TextAppearance_android_fontFamily;
    }
    if (!paramContext.isRestricted()) {
      paramContext = new ResourcesCompat.FontCallback()
      {
        public void onFontRetrievalFailed(int paramAnonymousInt) {}
        
        public void onFontRetrieved(@NonNull Typeface paramAnonymousTypeface)
        {
          AppCompatTextHelper.this.onAsyncTypefaceReceived(this.val$textViewWeak, paramAnonymousTypeface);
        }
      };
    }
    try
    {
      this.mFontTypeface = paramTintTypedArray.getFont(i, this.mStyle, paramContext);
      if (this.mFontTypeface != null) {
        break label241;
      }
    }
    catch (UnsupportedOperationException|Resources.NotFoundException paramContext)
    {
      for (;;)
      {
        continue;
        bool1 = false;
      }
    }
    this.mAsyncFontPending = bool1;
    if (this.mFontTypeface == null)
    {
      paramContext = paramTintTypedArray.getString(i);
      if (paramContext != null) {
        this.mFontTypeface = Typeface.create(paramContext, this.mStyle);
      }
    }
  }
  
  void applyCompoundDrawablesTints()
  {
    Drawable[] arrayOfDrawable;
    if ((this.mDrawableLeftTint != null) || (this.mDrawableTopTint != null) || (this.mDrawableRightTint != null) || (this.mDrawableBottomTint != null))
    {
      arrayOfDrawable = this.mView.getCompoundDrawables();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableLeftTint);
      applyCompoundDrawableTint(arrayOfDrawable[1], this.mDrawableTopTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableRightTint);
      applyCompoundDrawableTint(arrayOfDrawable[3], this.mDrawableBottomTint);
    }
    if ((Build.VERSION.SDK_INT >= 17) && ((this.mDrawableStartTint != null) || (this.mDrawableEndTint != null)))
    {
      arrayOfDrawable = this.mView.getCompoundDrawablesRelative();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableStartTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableEndTint);
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  void autoSizeText()
  {
    this.mAutoSizeTextHelper.autoSizeText();
  }
  
  int getAutoSizeMaxTextSize()
  {
    return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
  }
  
  int getAutoSizeMinTextSize()
  {
    return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
  }
  
  int getAutoSizeStepGranularity()
  {
    return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
  }
  
  int[] getAutoSizeTextAvailableSizes()
  {
    return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
  }
  
  int getAutoSizeTextType()
  {
    return this.mAutoSizeTextHelper.getAutoSizeTextType();
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  boolean isAutoSizeEnabled()
  {
    return this.mAutoSizeTextHelper.isAutoSizeEnabled();
  }
  
  @SuppressLint({"NewApi"})
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = this.mView.getContext();
    Object localObject1 = AppCompatDrawableManager.get();
    Object localObject2 = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.AppCompatTextHelper, paramInt, 0);
    int i = ((TintTypedArray)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
    if (((TintTypedArray)localObject2).hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
      this.mDrawableLeftTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject1, ((TintTypedArray)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
    }
    if (((TintTypedArray)localObject2).hasValue(R.styleable.AppCompatTextHelper_android_drawableTop)) {
      this.mDrawableTopTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject1, ((TintTypedArray)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
    }
    if (((TintTypedArray)localObject2).hasValue(R.styleable.AppCompatTextHelper_android_drawableRight)) {
      this.mDrawableRightTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject1, ((TintTypedArray)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
    }
    if (((TintTypedArray)localObject2).hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
      this.mDrawableBottomTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject1, ((TintTypedArray)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (((TintTypedArray)localObject2).hasValue(R.styleable.AppCompatTextHelper_android_drawableStart)) {
        this.mDrawableStartTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject1, ((TintTypedArray)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
      }
      if (((TintTypedArray)localObject2).hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
        this.mDrawableEndTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject1, ((TintTypedArray)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
      }
    }
    ((TintTypedArray)localObject2).recycle();
    boolean bool2 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
    int j = 1;
    localObject2 = null;
    Object localObject3 = null;
    ColorStateList localColorStateList1 = null;
    boolean bool1;
    if (i != -1)
    {
      localObject3 = TintTypedArray.obtainStyledAttributes(localContext, i, R.styleable.TextAppearance);
      if ((!bool2) && (((TintTypedArray)localObject3).hasValue(R.styleable.TextAppearance_textAllCaps)))
      {
        bool1 = ((TintTypedArray)localObject3).getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        i = 1;
      }
      else
      {
        i = 0;
        bool1 = false;
      }
      updateTypefaceAndStyle(localContext, (TintTypedArray)localObject3);
      if (Build.VERSION.SDK_INT < 23)
      {
        if (((TintTypedArray)localObject3).hasValue(R.styleable.TextAppearance_android_textColor)) {
          localObject2 = ((TintTypedArray)localObject3).getColorStateList(R.styleable.TextAppearance_android_textColor);
        } else {
          localObject2 = null;
        }
        if (((TintTypedArray)localObject3).hasValue(R.styleable.TextAppearance_android_textColorHint)) {
          localObject1 = ((TintTypedArray)localObject3).getColorStateList(R.styleable.TextAppearance_android_textColorHint);
        } else {
          localObject1 = null;
        }
        if (((TintTypedArray)localObject3).hasValue(R.styleable.TextAppearance_android_textColorLink)) {
          localColorStateList1 = ((TintTypedArray)localObject3).getColorStateList(R.styleable.TextAppearance_android_textColorLink);
        }
      }
      else
      {
        localColorStateList1 = null;
        localObject1 = localColorStateList1;
      }
      ((TintTypedArray)localObject3).recycle();
    }
    else
    {
      localColorStateList1 = null;
      localObject1 = localColorStateList1;
      i = 0;
      bool1 = false;
      localObject2 = localObject3;
    }
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.TextAppearance, paramInt, 0);
    if ((!bool2) && (localTintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps)))
    {
      bool1 = localTintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
      i = j;
    }
    Object localObject4 = localObject2;
    ColorStateList localColorStateList2 = localColorStateList1;
    localObject3 = localObject1;
    if (Build.VERSION.SDK_INT < 23)
    {
      if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)) {
        localObject2 = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
      }
      if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorHint)) {
        localObject1 = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
      }
      localObject4 = localObject2;
      localColorStateList2 = localColorStateList1;
      localObject3 = localObject1;
      if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorLink))
      {
        localColorStateList2 = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
        localObject3 = localObject1;
        localObject4 = localObject2;
      }
    }
    if ((Build.VERSION.SDK_INT >= 28) && (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textSize)) && (localTintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0)) {
      this.mView.setTextSize(0, 0.0F);
    }
    updateTypefaceAndStyle(localContext, localTintTypedArray);
    localTintTypedArray.recycle();
    if (localObject4 != null) {
      this.mView.setTextColor((ColorStateList)localObject4);
    }
    if (localObject3 != null) {
      this.mView.setHintTextColor((ColorStateList)localObject3);
    }
    if (localColorStateList2 != null) {
      this.mView.setLinkTextColor(localColorStateList2);
    }
    if ((!bool2) && (i != 0)) {
      setAllCaps(bool1);
    }
    if (this.mFontTypeface != null) {
      this.mView.setTypeface(this.mFontTypeface, this.mStyle);
    }
    this.mAutoSizeTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
    if ((AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) && (this.mAutoSizeTextHelper.getAutoSizeTextType() != 0))
    {
      localObject1 = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
      if (localObject1.length > 0) {
        if (this.mView.getAutoSizeStepGranularity() != -1.0F) {
          this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
        } else {
          this.mView.setAutoSizeTextTypeUniformWithPresetSizes((int[])localObject1, 0);
        }
      }
    }
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.AppCompatTextView);
    paramInt = paramAttributeSet.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
    i = paramAttributeSet.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
    j = paramAttributeSet.getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, -1);
    paramAttributeSet.recycle();
    if (paramInt != -1) {
      TextViewCompat.setFirstBaselineToTopHeight(this.mView, paramInt);
    }
    if (i != -1) {
      TextViewCompat.setLastBaselineToBottomHeight(this.mView, i);
    }
    if (j != -1) {
      TextViewCompat.setLineHeight(this.mView, j);
    }
  }
  
  void onAsyncTypefaceReceived(WeakReference<TextView> paramWeakReference, Typeface paramTypeface)
  {
    if (this.mAsyncFontPending)
    {
      this.mFontTypeface = paramTypeface;
      paramWeakReference = (TextView)paramWeakReference.get();
      if (paramWeakReference != null) {
        paramWeakReference.setTypeface(paramTypeface, this.mStyle);
      }
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
      autoSizeText();
    }
  }
  
  void onSetTextAppearance(Context paramContext, int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    if (localTintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps)) {
      setAllCaps(localTintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
    }
    if ((Build.VERSION.SDK_INT < 23) && (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)))
    {
      ColorStateList localColorStateList = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
      if (localColorStateList != null) {
        this.mView.setTextColor(localColorStateList);
      }
    }
    if ((localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textSize)) && (localTintTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) == 0)) {
      this.mView.setTextSize(0, 0.0F);
    }
    updateTypefaceAndStyle(paramContext, localTintTypedArray);
    localTintTypedArray.recycle();
    if (this.mFontTypeface != null) {
      this.mView.setTypeface(this.mFontTypeface, this.mStyle);
    }
  }
  
  void setAllCaps(boolean paramBoolean)
  {
    this.mView.setAllCaps(paramBoolean);
  }
  
  void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  void setTextSize(int paramInt, float paramFloat)
  {
    if ((!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) && (!isAutoSizeEnabled())) {
      setTextSizeInternal(paramInt, paramFloat);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\AppCompatTextHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */