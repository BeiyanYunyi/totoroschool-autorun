package android.support.design.chip;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.BoolRes;
import android.support.annotation.DimenRes;
import android.support.annotation.Dimension;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.R.attr;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.internal.FlowLayout;
import android.support.design.internal.ThemeEnforcement;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ChipGroup
  extends FlowLayout
{
  @IdRes
  private int checkedId = -1;
  private final CheckedStateTracker checkedStateTracker = new CheckedStateTracker(null);
  @Dimension
  private int chipSpacingHorizontal;
  @Dimension
  private int chipSpacingVertical;
  @Nullable
  private OnCheckedChangeListener onCheckedChangeListener;
  private PassThroughHierarchyChangeListener passThroughListener = new PassThroughHierarchyChangeListener(null);
  private boolean protectFromCheckedChange = false;
  private boolean singleSelection;
  
  public ChipGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.chipGroupStyle);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.ChipGroup, paramInt, R.style.Widget_MaterialComponents_ChipGroup, new int[0]);
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacing, 0);
    setChipSpacingHorizontal(paramContext.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingHorizontal, paramInt));
    setChipSpacingVertical(paramContext.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingVertical, paramInt));
    setSingleLine(paramContext.getBoolean(R.styleable.ChipGroup_singleLine, false));
    setSingleSelection(paramContext.getBoolean(R.styleable.ChipGroup_singleSelection, false));
    paramInt = paramContext.getResourceId(R.styleable.ChipGroup_checkedChip, -1);
    if (paramInt != -1) {
      this.checkedId = paramInt;
    }
    paramContext.recycle();
    super.setOnHierarchyChangeListener(this.passThroughListener);
  }
  
  private void setCheckedId(int paramInt)
  {
    this.checkedId = paramInt;
    if ((this.onCheckedChangeListener != null) && (this.singleSelection)) {
      this.onCheckedChangeListener.onCheckedChanged(this, paramInt);
    }
  }
  
  private void setCheckedStateForView(@IdRes int paramInt, boolean paramBoolean)
  {
    View localView = findViewById(paramInt);
    if ((localView instanceof Chip))
    {
      this.protectFromCheckedChange = true;
      ((Chip)localView).setChecked(paramBoolean);
      this.protectFromCheckedChange = false;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof Chip))
    {
      Chip localChip = (Chip)paramView;
      if (localChip.isChecked())
      {
        if ((this.checkedId != -1) && (this.singleSelection)) {
          setCheckedStateForView(this.checkedId, false);
        }
        setCheckedId(localChip.getId());
      }
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void check(@IdRes int paramInt)
  {
    if (paramInt == this.checkedId) {
      return;
    }
    if ((this.checkedId != -1) && (this.singleSelection)) {
      setCheckedStateForView(this.checkedId, false);
    }
    if (paramInt != -1) {
      setCheckedStateForView(paramInt, true);
    }
    setCheckedId(paramInt);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public void clearCheck()
  {
    this.protectFromCheckedChange = true;
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView instanceof Chip)) {
        ((Chip)localView).setChecked(false);
      }
      i += 1;
    }
    this.protectFromCheckedChange = false;
    setCheckedId(-1);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  @IdRes
  public int getCheckedChipId()
  {
    if (this.singleSelection) {
      return this.checkedId;
    }
    return -1;
  }
  
  @Dimension
  public int getChipSpacingHorizontal()
  {
    return this.chipSpacingHorizontal;
  }
  
  @Dimension
  public int getChipSpacingVertical()
  {
    return this.chipSpacingVertical;
  }
  
  public boolean isSingleSelection()
  {
    return this.singleSelection;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (this.checkedId != -1)
    {
      setCheckedStateForView(this.checkedId, true);
      setCheckedId(this.checkedId);
    }
  }
  
  public void setChipSpacing(@Dimension int paramInt)
  {
    setChipSpacingHorizontal(paramInt);
    setChipSpacingVertical(paramInt);
  }
  
  public void setChipSpacingHorizontal(@Dimension int paramInt)
  {
    if (this.chipSpacingHorizontal != paramInt)
    {
      this.chipSpacingHorizontal = paramInt;
      setItemSpacing(paramInt);
      requestLayout();
    }
  }
  
  public void setChipSpacingHorizontalResource(@DimenRes int paramInt)
  {
    setChipSpacingHorizontal(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setChipSpacingResource(@DimenRes int paramInt)
  {
    setChipSpacing(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setChipSpacingVertical(@Dimension int paramInt)
  {
    if (this.chipSpacingVertical != paramInt)
    {
      this.chipSpacingVertical = paramInt;
      setLineSpacing(paramInt);
      requestLayout();
    }
  }
  
  public void setChipSpacingVerticalResource(@DimenRes int paramInt)
  {
    setChipSpacingVertical(getResources().getDimensionPixelOffset(paramInt));
  }
  
  @Deprecated
  public void setDividerDrawableHorizontal(Drawable paramDrawable)
  {
    throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setDividerDrawableVertical(@Nullable Drawable paramDrawable)
  {
    throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setFlexWrap(int paramInt)
  {
    throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
  }
  
  public void setOnCheckedChangeListener(OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.onCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    PassThroughHierarchyChangeListener.access$202(this.passThroughListener, paramOnHierarchyChangeListener);
  }
  
  @Deprecated
  public void setShowDividerHorizontal(int paramInt)
  {
    throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setShowDividerVertical(int paramInt)
  {
    throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  public void setSingleLine(@BoolRes int paramInt)
  {
    setSingleLine(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(@BoolRes int paramInt)
  {
    setSingleSelection(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(boolean paramBoolean)
  {
    if (this.singleSelection != paramBoolean)
    {
      this.singleSelection = paramBoolean;
      clearCheck();
    }
  }
  
  private class CheckedStateTracker
    implements CompoundButton.OnCheckedChangeListener
  {
    private CheckedStateTracker() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (ChipGroup.this.protectFromCheckedChange) {
        return;
      }
      int i = paramCompoundButton.getId();
      if (paramBoolean)
      {
        if ((ChipGroup.this.checkedId != -1) && (ChipGroup.this.checkedId != i) && (ChipGroup.this.singleSelection)) {
          ChipGroup.this.setCheckedStateForView(ChipGroup.this.checkedId, false);
        }
        ChipGroup.this.setCheckedId(i);
        return;
      }
      if (ChipGroup.this.checkedId == i) {
        ChipGroup.this.setCheckedId(-1);
      }
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
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
  
  public static abstract interface OnCheckedChangeListener
  {
    public abstract void onCheckedChanged(ChipGroup paramChipGroup, @IdRes int paramInt);
  }
  
  private class PassThroughHierarchyChangeListener
    implements ViewGroup.OnHierarchyChangeListener
  {
    private ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
    
    private PassThroughHierarchyChangeListener() {}
    
    public void onChildViewAdded(View paramView1, View paramView2)
    {
      if ((paramView1 == ChipGroup.this) && ((paramView2 instanceof Chip)))
      {
        if (paramView2.getId() == -1)
        {
          int i;
          if (Build.VERSION.SDK_INT >= 17) {
            i = View.generateViewId();
          } else {
            i = paramView2.hashCode();
          }
          paramView2.setId(i);
        }
        ((Chip)paramView2).setOnCheckedChangeListenerInternal(ChipGroup.this.checkedStateTracker);
      }
      if (this.onHierarchyChangeListener != null) {
        this.onHierarchyChangeListener.onChildViewAdded(paramView1, paramView2);
      }
    }
    
    public void onChildViewRemoved(View paramView1, View paramView2)
    {
      if ((paramView1 == ChipGroup.this) && ((paramView2 instanceof Chip))) {
        ((Chip)paramView2).setOnCheckedChangeListenerInternal(null);
      }
      if (this.onHierarchyChangeListener != null) {
        this.onHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\chip\ChipGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */