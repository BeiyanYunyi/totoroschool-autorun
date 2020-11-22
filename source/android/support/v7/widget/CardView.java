package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.v7.cardview.R.attr;
import android.support.v7.cardview.R.color;
import android.support.v7.cardview.R.style;
import android.support.v7.cardview.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView
  extends FrameLayout
{
  private static final int[] COLOR_BACKGROUND_ATTR = { 16842801 };
  private static final CardViewImpl IMPL;
  private final CardViewDelegate mCardViewDelegate = new CardViewDelegate()
  {
    private Drawable mCardBackground;
    
    public Drawable getCardBackground()
    {
      return this.mCardBackground;
    }
    
    public View getCardView()
    {
      return CardView.this;
    }
    
    public boolean getPreventCornerOverlap()
    {
      return CardView.this.getPreventCornerOverlap();
    }
    
    public boolean getUseCompatPadding()
    {
      return CardView.this.getUseCompatPadding();
    }
    
    public void setCardBackground(Drawable paramAnonymousDrawable)
    {
      this.mCardBackground = paramAnonymousDrawable;
      CardView.this.setBackgroundDrawable(paramAnonymousDrawable);
    }
    
    public void setMinWidthHeightInternal(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt1 > CardView.this.mUserSetMinWidth) {
        CardView.this.setMinimumWidth(paramAnonymousInt1);
      }
      if (paramAnonymousInt2 > CardView.this.mUserSetMinHeight) {
        CardView.this.setMinimumHeight(paramAnonymousInt2);
      }
    }
    
    public void setShadowPadding(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      CardView.this.mShadowBounds.set(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
      CardView.this.setPadding(paramAnonymousInt1 + CardView.this.mContentPadding.left, paramAnonymousInt2 + CardView.this.mContentPadding.top, paramAnonymousInt3 + CardView.this.mContentPadding.right, paramAnonymousInt4 + CardView.this.mContentPadding.bottom);
    }
  };
  private boolean mCompatPadding;
  final Rect mContentPadding = new Rect();
  private boolean mPreventCornerOverlap;
  final Rect mShadowBounds = new Rect();
  int mUserSetMinHeight;
  int mUserSetMinWidth;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new CardViewApi21Impl();
    } else if (Build.VERSION.SDK_INT >= 17) {
      IMPL = new CardViewApi17Impl();
    } else {
      IMPL = new CardViewBaseImpl();
    }
    IMPL.initStatic();
  }
  
  public CardView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CardView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.cardViewStyle);
  }
  
  public CardView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CardView, paramInt, R.style.CardView);
    if (localTypedArray.hasValue(R.styleable.CardView_cardBackgroundColor)) {}
    for (paramAttributeSet = localTypedArray.getColorStateList(R.styleable.CardView_cardBackgroundColor);; paramAttributeSet = ColorStateList.valueOf(paramInt))
    {
      break;
      paramAttributeSet = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
      paramInt = paramAttributeSet.getColor(0, 0);
      paramAttributeSet.recycle();
      paramAttributeSet = new float[3];
      Color.colorToHSV(paramInt, paramAttributeSet);
      if (paramAttributeSet[2] > 0.5F) {
        paramInt = getResources().getColor(R.color.cardview_light_background);
      } else {
        paramInt = getResources().getColor(R.color.cardview_dark_background);
      }
    }
    float f3 = localTypedArray.getDimension(R.styleable.CardView_cardCornerRadius, 0.0F);
    float f2 = localTypedArray.getDimension(R.styleable.CardView_cardElevation, 0.0F);
    float f1 = localTypedArray.getDimension(R.styleable.CardView_cardMaxElevation, 0.0F);
    this.mCompatPadding = localTypedArray.getBoolean(R.styleable.CardView_cardUseCompatPadding, false);
    this.mPreventCornerOverlap = localTypedArray.getBoolean(R.styleable.CardView_cardPreventCornerOverlap, true);
    paramInt = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPadding, 0);
    this.mContentPadding.left = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingLeft, paramInt);
    this.mContentPadding.top = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingTop, paramInt);
    this.mContentPadding.right = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingRight, paramInt);
    this.mContentPadding.bottom = localTypedArray.getDimensionPixelSize(R.styleable.CardView_contentPaddingBottom, paramInt);
    if (f2 > f1) {
      f1 = f2;
    }
    this.mUserSetMinWidth = localTypedArray.getDimensionPixelSize(R.styleable.CardView_android_minWidth, 0);
    this.mUserSetMinHeight = localTypedArray.getDimensionPixelSize(R.styleable.CardView_android_minHeight, 0);
    localTypedArray.recycle();
    IMPL.initialize(this.mCardViewDelegate, paramContext, paramAttributeSet, f3, f2, f1);
  }
  
  @NonNull
  public ColorStateList getCardBackgroundColor()
  {
    return IMPL.getBackgroundColor(this.mCardViewDelegate);
  }
  
  public float getCardElevation()
  {
    return IMPL.getElevation(this.mCardViewDelegate);
  }
  
  @Px
  public int getContentPaddingBottom()
  {
    return this.mContentPadding.bottom;
  }
  
  @Px
  public int getContentPaddingLeft()
  {
    return this.mContentPadding.left;
  }
  
  @Px
  public int getContentPaddingRight()
  {
    return this.mContentPadding.right;
  }
  
  @Px
  public int getContentPaddingTop()
  {
    return this.mContentPadding.top;
  }
  
  public float getMaxCardElevation()
  {
    return IMPL.getMaxElevation(this.mCardViewDelegate);
  }
  
  public boolean getPreventCornerOverlap()
  {
    return this.mPreventCornerOverlap;
  }
  
  public float getRadius()
  {
    return IMPL.getRadius(this.mCardViewDelegate);
  }
  
  public boolean getUseCompatPadding()
  {
    return this.mCompatPadding;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!(IMPL instanceof CardViewApi21Impl))
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      if ((i == Integer.MIN_VALUE) || (i == 1073741824)) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(IMPL.getMinWidth(this.mCardViewDelegate)), View.MeasureSpec.getSize(paramInt1)), i);
      }
      i = View.MeasureSpec.getMode(paramInt2);
      if ((i == Integer.MIN_VALUE) || (i == 1073741824)) {
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(IMPL.getMinHeight(this.mCardViewDelegate)), View.MeasureSpec.getSize(paramInt2)), i);
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCardBackgroundColor(@ColorInt int paramInt)
  {
    IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(@Nullable ColorStateList paramColorStateList)
  {
    IMPL.setBackgroundColor(this.mCardViewDelegate, paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat)
  {
    IMPL.setElevation(this.mCardViewDelegate, paramFloat);
  }
  
  public void setContentPadding(@Px int paramInt1, @Px int paramInt2, @Px int paramInt3, @Px int paramInt4)
  {
    this.mContentPadding.set(paramInt1, paramInt2, paramInt3, paramInt4);
    IMPL.updatePadding(this.mCardViewDelegate);
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    IMPL.setMaxElevation(this.mCardViewDelegate, paramFloat);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    this.mUserSetMinHeight = paramInt;
    super.setMinimumHeight(paramInt);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    this.mUserSetMinWidth = paramInt;
    super.setMinimumWidth(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    if (paramBoolean != this.mPreventCornerOverlap)
    {
      this.mPreventCornerOverlap = paramBoolean;
      IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
    }
  }
  
  public void setRadius(float paramFloat)
  {
    IMPL.setRadius(this.mCardViewDelegate, paramFloat);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.mCompatPadding != paramBoolean)
    {
      this.mCompatPadding = paramBoolean;
      IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\CardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */