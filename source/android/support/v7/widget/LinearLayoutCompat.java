package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat
  extends ViewGroup
{
  public static final int HORIZONTAL = 0;
  private static final int INDEX_BOTTOM = 2;
  private static final int INDEX_CENTER_VERTICAL = 0;
  private static final int INDEX_FILL = 3;
  private static final int INDEX_TOP = 1;
  public static final int SHOW_DIVIDER_BEGINNING = 1;
  public static final int SHOW_DIVIDER_END = 4;
  public static final int SHOW_DIVIDER_MIDDLE = 2;
  public static final int SHOW_DIVIDER_NONE = 0;
  public static final int VERTICAL = 1;
  private static final int VERTICAL_GRAVITY_COUNT = 4;
  private boolean mBaselineAligned = true;
  private int mBaselineAlignedChildIndex = -1;
  private int mBaselineChildTop = 0;
  private Drawable mDivider;
  private int mDividerHeight;
  private int mDividerPadding;
  private int mDividerWidth;
  private int mGravity = 8388659;
  private int[] mMaxAscent;
  private int[] mMaxDescent;
  private int mOrientation;
  private int mShowDividers;
  private int mTotalLength;
  private boolean mUseLargestChild;
  private float mWeightSum;
  
  public LinearLayoutCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.LinearLayoutCompat, paramInt, 0);
    paramInt = paramContext.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
    if (paramInt >= 0) {
      setOrientation(paramInt);
    }
    paramInt = paramContext.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    boolean bool = paramContext.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool) {
      setBaselineAligned(bool);
    }
    this.mWeightSum = paramContext.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0F);
    this.mBaselineAlignedChildIndex = paramContext.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    this.mUseLargestChild = paramContext.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
    setDividerDrawable(paramContext.getDrawable(R.styleable.LinearLayoutCompat_divider));
    this.mShowDividers = paramContext.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
    this.mDividerPadding = paramContext.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
    paramContext.recycle();
  }
  
  private void forceUniformHeight(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    int i = 0;
    while (i < paramInt1)
    {
      View localView = getVirtualChildAt(i);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.height == -1)
        {
          int k = localLayoutParams.width;
          localLayoutParams.width = localView.getMeasuredWidth();
          measureChildWithMargins(localView, paramInt2, 0, j, 0);
          localLayoutParams.width = k;
        }
      }
      i += 1;
    }
  }
  
  private void forceUniformWidth(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    int i = 0;
    while (i < paramInt1)
    {
      View localView = getVirtualChildAt(i);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.width == -1)
        {
          int k = localLayoutParams.height;
          localLayoutParams.height = localView.getMeasuredHeight();
          measureChildWithMargins(localView, j, 0, paramInt2, 0);
          localLayoutParams.height = k;
        }
      }
      i += 1;
    }
  }
  
  private void setChildFrame(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  void drawDividersHorizontal(Canvas paramCanvas)
  {
    int k = getVirtualChildCount();
    boolean bool = ViewUtils.isLayoutRtl(this);
    int i = 0;
    View localView;
    LayoutParams localLayoutParams;
    while (i < k)
    {
      localView = getVirtualChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (hasDividerBeforeChildAt(i)))
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int j;
        if (bool) {
          j = localView.getRight() + localLayoutParams.rightMargin;
        } else {
          j = localView.getLeft() - localLayoutParams.leftMargin - this.mDividerWidth;
        }
        drawVerticalDivider(paramCanvas, j);
      }
      i += 1;
    }
    if (hasDividerBeforeChildAt(k))
    {
      localView = getVirtualChildAt(k - 1);
      if (localView == null)
      {
        if (bool) {
          i = getPaddingLeft();
        } else {
          i = getWidth() - getPaddingRight() - this.mDividerWidth;
        }
      }
      else
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (bool) {
          i = localView.getLeft() - localLayoutParams.leftMargin - this.mDividerWidth;
        } else {
          i = localView.getRight() + localLayoutParams.rightMargin;
        }
      }
      drawVerticalDivider(paramCanvas, i);
    }
  }
  
  void drawDividersVertical(Canvas paramCanvas)
  {
    int j = getVirtualChildCount();
    int i = 0;
    View localView;
    LayoutParams localLayoutParams;
    while (i < j)
    {
      localView = getVirtualChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (hasDividerBeforeChildAt(i)))
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        drawHorizontalDivider(paramCanvas, localView.getTop() - localLayoutParams.topMargin - this.mDividerHeight);
      }
      i += 1;
    }
    if (hasDividerBeforeChildAt(j))
    {
      localView = getVirtualChildAt(j - 1);
      if (localView == null)
      {
        i = getHeight() - getPaddingBottom() - this.mDividerHeight;
      }
      else
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i = localView.getBottom() + localLayoutParams.bottomMargin;
      }
      drawHorizontalDivider(paramCanvas, i);
    }
  }
  
  void drawHorizontalDivider(Canvas paramCanvas, int paramInt)
  {
    this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, paramInt, getWidth() - getPaddingRight() - this.mDividerPadding, this.mDividerHeight + paramInt);
    this.mDivider.draw(paramCanvas);
  }
  
  void drawVerticalDivider(Canvas paramCanvas, int paramInt)
  {
    this.mDivider.setBounds(paramInt, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + paramInt, getHeight() - getPaddingBottom() - this.mDividerPadding);
    this.mDivider.draw(paramCanvas);
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    if (this.mOrientation == 0) {
      return new LayoutParams(-2, -2);
    }
    if (this.mOrientation == 1) {
      return new LayoutParams(-1, -2);
    }
    return null;
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getBaseline()
  {
    if (this.mBaselineAlignedChildIndex < 0) {
      return super.getBaseline();
    }
    if (getChildCount() > this.mBaselineAlignedChildIndex)
    {
      View localView = getChildAt(this.mBaselineAlignedChildIndex);
      int k = localView.getBaseline();
      if (k == -1)
      {
        if (this.mBaselineAlignedChildIndex == 0) {
          return -1;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
      }
      int j = this.mBaselineChildTop;
      int i = j;
      if (this.mOrientation == 1)
      {
        int m = this.mGravity & 0x70;
        i = j;
        if (m != 48) {
          if (m != 16)
          {
            if (m != 80) {
              i = j;
            } else {
              i = getBottom() - getTop() - getPaddingBottom() - this.mTotalLength;
            }
          }
          else {
            i = j + (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - this.mTotalLength) / 2;
          }
        }
      }
      return i + ((LayoutParams)localView.getLayoutParams()).topMargin + k;
    }
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
  }
  
  public int getBaselineAlignedChildIndex()
  {
    return this.mBaselineAlignedChildIndex;
  }
  
  int getChildrenSkipCount(View paramView, int paramInt)
  {
    return 0;
  }
  
  public Drawable getDividerDrawable()
  {
    return this.mDivider;
  }
  
  public int getDividerPadding()
  {
    return this.mDividerPadding;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public int getDividerWidth()
  {
    return this.mDividerWidth;
  }
  
  public int getGravity()
  {
    return this.mGravity;
  }
  
  int getLocationOffset(View paramView)
  {
    return 0;
  }
  
  int getNextLocationOffset(View paramView)
  {
    return 0;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getShowDividers()
  {
    return this.mShowDividers;
  }
  
  View getVirtualChildAt(int paramInt)
  {
    return getChildAt(paramInt);
  }
  
  int getVirtualChildCount()
  {
    return getChildCount();
  }
  
  public float getWeightSum()
  {
    return this.mWeightSum;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  protected boolean hasDividerBeforeChildAt(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 0)
    {
      if ((this.mShowDividers & 0x1) != 0) {
        bool1 = true;
      }
      return bool1;
    }
    if (paramInt == getChildCount())
    {
      bool1 = bool2;
      if ((this.mShowDividers & 0x4) != 0) {
        bool1 = true;
      }
      return bool1;
    }
    if ((this.mShowDividers & 0x2) != 0)
    {
      paramInt -= 1;
      while (paramInt >= 0)
      {
        if (getChildAt(paramInt).getVisibility() != 8) {
          return true;
        }
        paramInt -= 1;
      }
      return false;
    }
    return false;
  }
  
  public boolean isBaselineAligned()
  {
    return this.mBaselineAligned;
  }
  
  public boolean isMeasureWithLargestChildEnabled()
  {
    return this.mUseLargestChild;
  }
  
  void layoutHorizontal(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = ViewUtils.isLayoutRtl(this);
    int i1 = getPaddingTop();
    int i3 = paramInt4 - paramInt2;
    int i4 = getPaddingBottom();
    int i5 = getPaddingBottom();
    int m = getVirtualChildCount();
    paramInt4 = this.mGravity;
    paramInt2 = this.mGravity & 0x70;
    boolean bool2 = this.mBaselineAligned;
    int[] arrayOfInt1 = this.mMaxAscent;
    int[] arrayOfInt2 = this.mMaxDescent;
    paramInt4 = GravityCompat.getAbsoluteGravity(paramInt4 & 0x800007, ViewCompat.getLayoutDirection(this));
    if (paramInt4 != 1)
    {
      if (paramInt4 != 5) {
        paramInt1 = getPaddingLeft();
      } else {
        paramInt1 = getPaddingLeft() + paramInt3 - paramInt1 - this.mTotalLength;
      }
    }
    else
    {
      paramInt4 = getPaddingLeft();
      paramInt1 = (paramInt3 - paramInt1 - this.mTotalLength) / 2 + paramInt4;
    }
    int j;
    int k;
    if (bool1)
    {
      j = m - 1;
      k = -1;
    }
    else
    {
      j = 0;
      k = 1;
    }
    paramInt4 = 0;
    paramInt3 = i1;
    while (paramInt4 < m)
    {
      int i7 = j + k * paramInt4;
      View localView = getVirtualChildAt(i7);
      if (localView == null) {
        paramInt1 += measureNullChild(i7);
      }
      for (;;)
      {
        break;
        if (localView.getVisibility() != 8)
        {
          int i6 = localView.getMeasuredWidth();
          int i8 = localView.getMeasuredHeight();
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if ((bool2) && (localLayoutParams.height != -1)) {
            n = localView.getBaseline();
          } else {
            n = -1;
          }
          int i2 = localLayoutParams.gravity;
          int i = i2;
          if (i2 < 0) {
            i = paramInt2;
          }
          i &= 0x70;
          if (i != 16)
          {
            if (i != 48)
            {
              if (i != 80) {
                i = paramInt3;
              }
              for (;;)
              {
                break;
                i2 = i3 - i4 - i8 - localLayoutParams.bottomMargin;
                i = i2;
                if (n != -1)
                {
                  i = localView.getMeasuredHeight();
                  i = i2 - (arrayOfInt2[2] - (i - n));
                }
              }
            }
            i = localLayoutParams.topMargin + paramInt3;
            if (n != -1) {
              i += arrayOfInt1[1] - n;
            }
          }
          else
          {
            i = (i3 - i1 - i5 - i8) / 2 + paramInt3 + localLayoutParams.topMargin - localLayoutParams.bottomMargin;
          }
          int n = paramInt1;
          if (hasDividerBeforeChildAt(i7)) {
            n = paramInt1 + this.mDividerWidth;
          }
          paramInt1 = localLayoutParams.leftMargin + n;
          setChildFrame(localView, paramInt1 + getLocationOffset(localView), i, i6, i8);
          i = localLayoutParams.rightMargin;
          n = getNextLocationOffset(localView);
          paramInt4 += getChildrenSkipCount(localView, i7);
          paramInt1 += i6 + i + n;
          break;
        }
      }
      paramInt4 += 1;
    }
  }
  
  void layoutVertical(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = paramInt3 - paramInt1;
    int k = getPaddingRight();
    int m = getPaddingRight();
    int n = getVirtualChildCount();
    paramInt1 = this.mGravity & 0x70;
    int i1 = this.mGravity;
    if (paramInt1 != 16)
    {
      if (paramInt1 != 80) {
        paramInt1 = getPaddingTop();
      } else {
        paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - this.mTotalLength;
      }
    }
    else
    {
      paramInt1 = getPaddingTop();
      paramInt1 = (paramInt4 - paramInt2 - this.mTotalLength) / 2 + paramInt1;
    }
    paramInt2 = 0;
    while (paramInt2 < n)
    {
      View localView = getVirtualChildAt(paramInt2);
      if (localView == null)
      {
        paramInt3 = paramInt1 + measureNullChild(paramInt2);
        paramInt4 = paramInt2;
      }
      for (;;)
      {
        break;
        paramInt3 = paramInt1;
        paramInt4 = paramInt2;
        if (localView.getVisibility() != 8)
        {
          int i3 = localView.getMeasuredWidth();
          int i2 = localView.getMeasuredHeight();
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          paramInt4 = localLayoutParams.gravity;
          paramInt3 = paramInt4;
          if (paramInt4 < 0) {
            paramInt3 = i1 & 0x800007;
          }
          paramInt3 = GravityCompat.getAbsoluteGravity(paramInt3, ViewCompat.getLayoutDirection(this)) & 0x7;
          if (paramInt3 != 1) {
            if (paramInt3 != 5) {
              paramInt3 = localLayoutParams.leftMargin + i;
            }
          }
          for (;;)
          {
            break;
            paramInt3 = j - k - i3 - localLayoutParams.rightMargin;
            continue;
            paramInt3 = (j - i - m - i3) / 2 + i + localLayoutParams.leftMargin - localLayoutParams.rightMargin;
          }
          paramInt4 = paramInt1;
          if (hasDividerBeforeChildAt(paramInt2)) {
            paramInt4 = paramInt1 + this.mDividerHeight;
          }
          paramInt1 = paramInt4 + localLayoutParams.topMargin;
          setChildFrame(localView, paramInt3, paramInt1 + getLocationOffset(localView), i3, i2);
          paramInt3 = localLayoutParams.bottomMargin;
          i3 = getNextLocationOffset(localView);
          paramInt4 = paramInt2 + getChildrenSkipCount(localView, paramInt2);
          paramInt3 = paramInt1 + (i2 + paramInt3 + i3);
        }
      }
      paramInt2 = paramInt4 + 1;
      paramInt1 = paramInt3;
    }
  }
  
  void measureChildBeforeLayout(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    measureChildWithMargins(paramView, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  void measureHorizontal(int paramInt1, int paramInt2)
  {
    this.mTotalLength = 0;
    int i7 = getVirtualChildCount();
    int i12 = View.MeasureSpec.getMode(paramInt1);
    int i11 = View.MeasureSpec.getMode(paramInt2);
    if ((this.mMaxAscent == null) || (this.mMaxDescent == null))
    {
      this.mMaxAscent = new int[4];
      this.mMaxDescent = new int[4];
    }
    int[] arrayOfInt = this.mMaxAscent;
    Object localObject = this.mMaxDescent;
    arrayOfInt[3] = -1;
    arrayOfInt[2] = -1;
    arrayOfInt[1] = -1;
    arrayOfInt[0] = -1;
    localObject[3] = -1;
    localObject[2] = -1;
    localObject[1] = -1;
    localObject[0] = -1;
    boolean bool1 = this.mBaselineAligned;
    boolean bool2 = this.mUseLargestChild;
    int i6;
    if (i12 == 1073741824) {
      i6 = 1;
    } else {
      i6 = 0;
    }
    float f1 = 0.0F;
    int m = 0;
    int k = 0;
    int i4 = 0;
    int i3 = 0;
    int j = 0;
    int i2 = 0;
    int n = 0;
    int i = 1;
    int i1 = 0;
    View localView;
    LayoutParams localLayoutParams;
    while (m < i7)
    {
      localView = getVirtualChildAt(m);
      if (localView == null) {
        this.mTotalLength += measureNullChild(m);
      }
      for (;;)
      {
        break;
        if (localView.getVisibility() == 8)
        {
          m += getChildrenSkipCount(localView, m);
        }
        else
        {
          if (hasDividerBeforeChildAt(m)) {
            this.mTotalLength += this.mDividerWidth;
          }
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          f1 += localLayoutParams.weight;
          if ((i12 == 1073741824) && (localLayoutParams.width == 0) && (localLayoutParams.weight > 0.0F))
          {
            if (i6 != 0)
            {
              this.mTotalLength += localLayoutParams.leftMargin + localLayoutParams.rightMargin;
            }
            else
            {
              i5 = this.mTotalLength;
              this.mTotalLength = Math.max(i5, localLayoutParams.leftMargin + i5 + localLayoutParams.rightMargin);
            }
            if (bool1)
            {
              i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
              localView.measure(i5, i5);
              i5 = k;
            }
            else
            {
              i3 = 1;
              break label568;
            }
          }
          else
          {
            if ((localLayoutParams.width == 0) && (localLayoutParams.weight > 0.0F))
            {
              localLayoutParams.width = -2;
              i5 = 0;
            }
            else
            {
              i5 = Integer.MIN_VALUE;
            }
            if (f1 == 0.0F) {
              i8 = this.mTotalLength;
            } else {
              i8 = 0;
            }
            measureChildBeforeLayout(localView, m, paramInt1, i8, paramInt2, 0);
            if (i5 != Integer.MIN_VALUE) {
              localLayoutParams.width = i5;
            }
            i8 = localView.getMeasuredWidth();
            if (i6 != 0)
            {
              this.mTotalLength += localLayoutParams.leftMargin + i8 + localLayoutParams.rightMargin + getNextLocationOffset(localView);
            }
            else
            {
              i5 = this.mTotalLength;
              this.mTotalLength = Math.max(i5, i5 + i8 + localLayoutParams.leftMargin + localLayoutParams.rightMargin + getNextLocationOffset(localView));
            }
            i5 = k;
            if (bool2) {
              i5 = Math.max(i8, k);
            }
          }
          k = i5;
          label568:
          i9 = m;
          if ((i11 != 1073741824) && (localLayoutParams.height == -1))
          {
            m = 1;
            i1 = 1;
          }
          else
          {
            m = 0;
          }
          i5 = localLayoutParams.topMargin + localLayoutParams.bottomMargin;
          i8 = localView.getMeasuredHeight() + i5;
          int i10 = View.combineMeasuredStates(n, localView.getMeasuredState());
          if (bool1)
          {
            int i13 = localView.getBaseline();
            if (i13 != -1)
            {
              if (localLayoutParams.gravity < 0) {
                n = this.mGravity;
              } else {
                n = localLayoutParams.gravity;
              }
              n = ((n & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
              arrayOfInt[n] = Math.max(arrayOfInt[n], i13);
              localObject[n] = Math.max(localObject[n], i8 - i13);
            }
          }
          i4 = Math.max(i4, i8);
          if ((i != 0) && (localLayoutParams.height == -1)) {
            i = 1;
          } else {
            i = 0;
          }
          if (localLayoutParams.weight > 0.0F) {
            if (m == 0) {
              for (;;)
              {
                i5 = i8;
              }
            }
          }
          for (m = Math.max(i2, i5);; m = i2)
          {
            break;
            if (m != 0) {
              i8 = i5;
            }
            j = Math.max(j, i8);
          }
          i2 = getChildrenSkipCount(localView, i9);
          n = i10;
          i5 = i2 + i9;
          i2 = m;
          m = i5;
        }
      }
      m += 1;
    }
    m = i4;
    if ((this.mTotalLength > 0) && (hasDividerBeforeChildAt(i7))) {
      this.mTotalLength += this.mDividerWidth;
    }
    if ((arrayOfInt[1] == -1) && (arrayOfInt[0] == -1) && (arrayOfInt[2] == -1) && (arrayOfInt[3] == -1)) {
      break label985;
    }
    m = Math.max(m, Math.max(arrayOfInt[3], Math.max(arrayOfInt[0], Math.max(arrayOfInt[1], arrayOfInt[2]))) + Math.max(localObject[3], Math.max(localObject[0], Math.max(localObject[1], localObject[2]))));
    label985:
    i4 = n;
    int i5 = m;
    if (bool2) {
      if (i12 != Integer.MIN_VALUE)
      {
        i5 = m;
        if (i12 != 0) {}
      }
      else
      {
        this.mTotalLength = 0;
        n = 0;
        for (;;)
        {
          i5 = m;
          if (n >= i7) {
            break;
          }
          localView = getVirtualChildAt(n);
          if (localView == null)
          {
            this.mTotalLength += measureNullChild(n);
          }
          else
          {
            if (localView.getVisibility() != 8) {
              break label1091;
            }
            n += getChildrenSkipCount(localView, n);
          }
          for (;;)
          {
            break;
            label1091:
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if (i6 != 0)
            {
              this.mTotalLength += localLayoutParams.leftMargin + k + localLayoutParams.rightMargin + getNextLocationOffset(localView);
            }
            else
            {
              i5 = this.mTotalLength;
              this.mTotalLength = Math.max(i5, i5 + k + localLayoutParams.leftMargin + localLayoutParams.rightMargin + getNextLocationOffset(localView));
            }
          }
          n += 1;
        }
      }
    }
    this.mTotalLength += getPaddingLeft() + getPaddingRight();
    int i9 = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumWidth()), paramInt1, 0);
    int i8 = (0xFFFFFF & i9) - this.mTotalLength;
    if ((i3 == 0) && ((i8 == 0) || (f1 <= 0.0F)))
    {
      m = Math.max(j, i2);
      if ((bool2) && (i12 != 1073741824))
      {
        j = 0;
        while (j < i7)
        {
          localObject = getVirtualChildAt(j);
          if ((localObject != null) && (((View)localObject).getVisibility() != 8) && (((LayoutParams)((View)localObject).getLayoutParams()).weight > 0.0F)) {
            ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(k, 1073741824), View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredHeight(), 1073741824));
          }
          j += 1;
        }
      }
      k = i7;
      j = m;
      m = i;
      i = i5;
    }
    else
    {
      if (this.mWeightSum > 0.0F) {
        f1 = this.mWeightSum;
      }
      arrayOfInt[3] = -1;
      arrayOfInt[2] = -1;
      arrayOfInt[1] = -1;
      arrayOfInt[0] = -1;
      localObject[3] = -1;
      localObject[2] = -1;
      localObject[1] = -1;
      localObject[0] = -1;
      this.mTotalLength = 0;
      i2 = -1;
      i3 = 0;
      m = i;
      k = i7;
      n = j;
      i = i4;
      j = i8;
      i4 = i3;
      while (i4 < k)
      {
        localView = getVirtualChildAt(i4);
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          float f2 = localLayoutParams.weight;
          if (f2 > 0.0F)
          {
            i5 = (int)(j * f2 / f1);
            i8 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height);
            if ((localLayoutParams.width == 0) && (i12 == 1073741824))
            {
              if (i5 > 0) {
                i3 = i5;
              } else {
                i3 = 0;
              }
              localView.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i8);
            }
            else
            {
              i7 = localView.getMeasuredWidth() + i5;
              i3 = i7;
              if (i7 < 0) {
                i3 = 0;
              }
              localView.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i8);
            }
            i = View.combineMeasuredStates(i, localView.getMeasuredState() & 0xFF000000);
            f1 -= f2;
            j -= i5;
          }
          if (i6 != 0) {}
          for (this.mTotalLength += localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin + getNextLocationOffset(localView);; this.mTotalLength = Math.max(i3, localView.getMeasuredWidth() + i3 + localLayoutParams.leftMargin + localLayoutParams.rightMargin + getNextLocationOffset(localView)))
          {
            break;
            i3 = this.mTotalLength;
          }
          if ((i11 != 1073741824) && (localLayoutParams.height == -1)) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          i8 = localLayoutParams.topMargin + localLayoutParams.bottomMargin;
          i7 = localView.getMeasuredHeight() + i8;
          i5 = Math.max(i2, i7);
          if (i3 != 0) {
            i2 = i8;
          } else {
            i2 = i7;
          }
          i2 = Math.max(n, i2);
          if ((m != 0) && (localLayoutParams.height == -1)) {
            m = 1;
          } else {
            m = 0;
          }
          if (bool1)
          {
            i3 = localView.getBaseline();
            if (i3 != -1)
            {
              if (localLayoutParams.gravity < 0) {
                n = this.mGravity;
              } else {
                n = localLayoutParams.gravity;
              }
              n = ((n & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
              arrayOfInt[n] = Math.max(arrayOfInt[n], i3);
              localObject[n] = Math.max(localObject[n], i7 - i3);
            }
          }
          n = i2;
          i2 = i5;
        }
        i4 += 1;
      }
      this.mTotalLength += getPaddingLeft() + getPaddingRight();
      if ((arrayOfInt[1] == -1) && (arrayOfInt[0] == -1) && (arrayOfInt[2] == -1) && (arrayOfInt[3] == -1)) {
        j = i2;
      } else {
        j = Math.max(i2, Math.max(arrayOfInt[3], Math.max(arrayOfInt[0], Math.max(arrayOfInt[1], arrayOfInt[2]))) + Math.max(localObject[3], Math.max(localObject[0], Math.max(localObject[1], localObject[2]))));
      }
      i2 = j;
      i4 = i;
      j = n;
      i = i2;
    }
    n = i;
    if (m == 0)
    {
      n = i;
      if (i11 != 1073741824) {
        n = j;
      }
    }
    setMeasuredDimension(i9 | i4 & 0xFF000000, View.resolveSizeAndState(Math.max(n + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), paramInt2, i4 << 16));
    if (i1 != 0) {
      forceUniformHeight(k, paramInt1);
    }
  }
  
  int measureNullChild(int paramInt)
  {
    return 0;
  }
  
  void measureVertical(int paramInt1, int paramInt2)
  {
    this.mTotalLength = 0;
    int i4 = getVirtualChildCount();
    int i12 = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int i13 = this.mBaselineAlignedChildIndex;
    boolean bool = this.mUseLargestChild;
    float f1 = 0.0F;
    int i = 0;
    int i6 = 0;
    int i1 = 0;
    int j = 0;
    int n = 0;
    int i2 = 0;
    int i5 = 0;
    int m = 1;
    int i3 = 0;
    View localView;
    LayoutParams localLayoutParams;
    int i7;
    int i9;
    while (i2 < i4)
    {
      localView = getVirtualChildAt(i2);
      if (localView == null)
      {
        this.mTotalLength += measureNullChild(i2);
      }
      else if (localView.getVisibility() == 8)
      {
        i2 += getChildrenSkipCount(localView, i2);
      }
      else
      {
        if (hasDividerBeforeChildAt(i2)) {
          this.mTotalLength += this.mDividerHeight;
        }
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        f1 += localLayoutParams.weight;
        if ((k == 1073741824) && (localLayoutParams.height == 0) && (localLayoutParams.weight > 0.0F))
        {
          i5 = this.mTotalLength;
          this.mTotalLength = Math.max(i5, localLayoutParams.topMargin + i5 + localLayoutParams.bottomMargin);
          i5 = 1;
        }
        else
        {
          if ((localLayoutParams.height == 0) && (localLayoutParams.weight > 0.0F))
          {
            localLayoutParams.height = -2;
            i7 = 0;
          }
          else
          {
            i7 = Integer.MIN_VALUE;
          }
          if (f1 == 0.0F) {
            i8 = this.mTotalLength;
          } else {
            i8 = 0;
          }
          measureChildBeforeLayout(localView, i2, paramInt1, 0, paramInt2, i8);
          if (i7 != Integer.MIN_VALUE) {
            localLayoutParams.height = i7;
          }
          i7 = localView.getMeasuredHeight();
          i8 = this.mTotalLength;
          this.mTotalLength = Math.max(i8, i8 + i7 + localLayoutParams.topMargin + localLayoutParams.bottomMargin + getNextLocationOffset(localView));
          if (bool) {
            i1 = Math.max(i7, i1);
          }
        }
        i9 = i2;
        if ((i13 >= 0) && (i13 == i9 + 1)) {
          this.mBaselineChildTop = this.mTotalLength;
        }
        if ((i9 < i13) && (localLayoutParams.weight > 0.0F)) {
          throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
        }
        if ((i12 != 1073741824) && (localLayoutParams.width == -1))
        {
          i2 = 1;
          i3 = 1;
        }
        else
        {
          i2 = 0;
        }
        i7 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
        i8 = localView.getMeasuredWidth() + i7;
        int i10 = Math.max(i6, i8);
        int i11 = View.combineMeasuredStates(i, localView.getMeasuredState());
        if ((m != 0) && (localLayoutParams.width == -1)) {
          i = 1;
        } else {
          i = 0;
        }
        if (localLayoutParams.weight > 0.0F)
        {
          if (i2 == 0) {
            i7 = i8;
          }
          m = Math.max(j, i7);
          j = n;
        }
        else
        {
          if (i2 == 0) {
            for (;;)
            {
              i7 = i8;
            }
          }
          n = Math.max(n, i7);
          m = j;
          j = n;
        }
        i2 = getChildrenSkipCount(localView, i9);
        n = i;
        i6 = m;
        i = i11;
        i2 += i9;
        i7 = i10;
        m = n;
        n = j;
        j = i6;
        i6 = i7;
      }
      i2 += 1;
    }
    if ((this.mTotalLength > 0) && (hasDividerBeforeChildAt(i4))) {
      this.mTotalLength += this.mDividerHeight;
    }
    if (bool)
    {
      i2 = k;
      if ((i2 == Integer.MIN_VALUE) || (i2 == 0))
      {
        this.mTotalLength = 0;
        i2 = 0;
        while (i2 < i4)
        {
          localView = getVirtualChildAt(i2);
          if (localView == null)
          {
            this.mTotalLength += measureNullChild(i2);
          }
          else if (localView.getVisibility() == 8)
          {
            i2 += getChildrenSkipCount(localView, i2);
          }
          else
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            i7 = this.mTotalLength;
            this.mTotalLength = Math.max(i7, i7 + i1 + localLayoutParams.topMargin + localLayoutParams.bottomMargin + getNextLocationOffset(localView));
          }
          i2 += 1;
        }
      }
    }
    i2 = k;
    this.mTotalLength += getPaddingTop() + getPaddingBottom();
    int i8 = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), paramInt2, 0);
    k = (0xFFFFFF & i8) - this.mTotalLength;
    if ((i5 == 0) && ((k == 0) || (f1 <= 0.0F)))
    {
      k = Math.max(n, j);
      if ((bool) && (i2 != 1073741824))
      {
        j = 0;
        while (j < i4)
        {
          localView = getVirtualChildAt(j);
          if ((localView != null) && (localView.getVisibility() != 8) && (((LayoutParams)localView.getLayoutParams()).weight > 0.0F)) {
            localView.measure(View.MeasureSpec.makeMeasureSpec(localView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i1, 1073741824));
          }
          j += 1;
        }
      }
      j = i;
      i = k;
    }
    else
    {
      if (this.mWeightSum > 0.0F) {
        f1 = this.mWeightSum;
      }
      this.mTotalLength = 0;
      i5 = 0;
      j = n;
      i1 = i2;
      i2 = i5;
      while (i2 < i4)
      {
        localView = getVirtualChildAt(i2);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          float f2 = localLayoutParams.weight;
          if (f2 > 0.0F)
          {
            i5 = (int)(k * f2 / f1);
            i9 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width);
            if ((localLayoutParams.height == 0) && (i1 == 1073741824))
            {
              if (i5 > 0) {
                n = i5;
              } else {
                n = 0;
              }
              localView.measure(i9, View.MeasureSpec.makeMeasureSpec(n, 1073741824));
            }
            else
            {
              i7 = localView.getMeasuredHeight() + i5;
              n = i7;
              if (i7 < 0) {
                n = 0;
              }
              localView.measure(i9, View.MeasureSpec.makeMeasureSpec(n, 1073741824));
            }
            i = View.combineMeasuredStates(i, localView.getMeasuredState() & 0xFF00);
            k -= i5;
            f1 -= f2;
          }
          i5 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
          i7 = localView.getMeasuredWidth() + i5;
          i6 = Math.max(i6, i7);
          if ((i12 != 1073741824) && (localLayoutParams.width == -1)) {
            n = 1;
          } else {
            n = 0;
          }
          if (n != 0) {
            n = i5;
          } else {
            n = i7;
          }
          n = Math.max(j, n);
          if ((m != 0) && (localLayoutParams.width == -1)) {
            j = 1;
          } else {
            j = 0;
          }
          m = this.mTotalLength;
          this.mTotalLength = Math.max(m, m + localView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin + getNextLocationOffset(localView));
          m = j;
          j = n;
        }
        i2 += 1;
      }
      this.mTotalLength += getPaddingTop() + getPaddingBottom();
      k = j;
      j = i;
      i = k;
    }
    if ((m != 0) || (i12 == 1073741824)) {
      i = i6;
    }
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), paramInt1, j), i8);
    if (i3 != 0) {
      forceUniformWidth(i4, paramInt2);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mDivider == null) {
      return;
    }
    if (this.mOrientation == 1)
    {
      drawDividersVertical(paramCanvas);
      return;
    }
    drawDividersHorizontal(paramCanvas);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mOrientation == 1)
    {
      layoutVertical(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    layoutHorizontal(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mOrientation == 1)
    {
      measureVertical(paramInt1, paramInt2);
      return;
    }
    measureHorizontal(paramInt1, paramInt2);
  }
  
  public void setBaselineAligned(boolean paramBoolean)
  {
    this.mBaselineAligned = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getChildCount()))
    {
      this.mBaselineAlignedChildIndex = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("base aligned child index out of range (0, ");
    localStringBuilder.append(getChildCount());
    localStringBuilder.append(")");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.mDivider) {
      return;
    }
    this.mDivider = paramDrawable;
    boolean bool = false;
    if (paramDrawable != null)
    {
      this.mDividerWidth = paramDrawable.getIntrinsicWidth();
      this.mDividerHeight = paramDrawable.getIntrinsicHeight();
    }
    else
    {
      this.mDividerWidth = 0;
      this.mDividerHeight = 0;
    }
    if (paramDrawable == null) {
      bool = true;
    }
    setWillNotDraw(bool);
    requestLayout();
  }
  
  public void setDividerPadding(int paramInt)
  {
    this.mDividerPadding = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
    {
      int i = paramInt;
      if ((0x800007 & paramInt) == 0) {
        i = paramInt | 0x800003;
      }
      paramInt = i;
      if ((i & 0x70) == 0) {
        paramInt = i | 0x30;
      }
      this.mGravity = paramInt;
      requestLayout();
    }
  }
  
  public void setHorizontalGravity(int paramInt)
  {
    paramInt &= 0x800007;
    if ((0x800007 & this.mGravity) != paramInt)
    {
      this.mGravity = (paramInt | this.mGravity & 0xFF7FFFF8);
      requestLayout();
    }
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    this.mUseLargestChild = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.mOrientation != paramInt)
    {
      this.mOrientation = paramInt;
      requestLayout();
    }
  }
  
  public void setShowDividers(int paramInt)
  {
    if (paramInt != this.mShowDividers) {
      requestLayout();
    }
    this.mShowDividers = paramInt;
  }
  
  public void setVerticalGravity(int paramInt)
  {
    paramInt &= 0x70;
    if ((this.mGravity & 0x70) != paramInt)
    {
      this.mGravity = (paramInt | this.mGravity & 0xFFFFFF8F);
      requestLayout();
    }
  }
  
  public void setWeightSum(float paramFloat)
  {
    this.mWeightSum = Math.max(0.0F, paramFloat);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface DividerMode {}
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int gravity = -1;
    public float weight;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.weight = 0.0F;
    }
    
    public LayoutParams(int paramInt1, int paramInt2, float paramFloat)
    {
      super(paramInt2);
      this.weight = paramFloat;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LinearLayoutCompat_Layout);
      this.weight = paramContext.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
      this.gravity = paramContext.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.weight = paramLayoutParams.weight;
      this.gravity = paramLayoutParams.gravity;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface OrientationMode {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\LinearLayoutCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */