package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.design.R.dimen;
import android.support.design.R.drawable;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.widget.TooltipCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationItemView
  extends FrameLayout
  implements MenuView.ItemView
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  public static final int INVALID_ITEM_POSITION = -1;
  private final int defaultMargin;
  private ImageView icon;
  private ColorStateList iconTint;
  private boolean isShifting;
  private MenuItemImpl itemData;
  private int itemPosition = -1;
  private int labelVisibilityMode;
  private final TextView largeLabel;
  private float scaleDownFactor;
  private float scaleUpFactor;
  private float shiftAmount;
  private final TextView smallLabel;
  
  public BottomNavigationItemView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationItemView(@NonNull Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BottomNavigationItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = getResources();
    LayoutInflater.from(paramContext).inflate(R.layout.design_bottom_navigation_item, this, true);
    setBackgroundResource(R.drawable.design_bottom_navigation_item_background);
    this.defaultMargin = paramAttributeSet.getDimensionPixelSize(R.dimen.design_bottom_navigation_margin);
    this.icon = ((ImageView)findViewById(R.id.icon));
    this.smallLabel = ((TextView)findViewById(R.id.smallLabel));
    this.largeLabel = ((TextView)findViewById(R.id.largeLabel));
    ViewCompat.setImportantForAccessibility(this.smallLabel, 2);
    ViewCompat.setImportantForAccessibility(this.largeLabel, 2);
    setFocusable(true);
    calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
  }
  
  private void calculateTextScaleFactors(float paramFloat1, float paramFloat2)
  {
    this.shiftAmount = (paramFloat1 - paramFloat2);
    this.scaleUpFactor = (paramFloat2 * 1.0F / paramFloat1);
    this.scaleDownFactor = (paramFloat1 * 1.0F / paramFloat2);
  }
  
  private void setViewLayoutParams(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin = paramInt1;
    localLayoutParams.gravity = paramInt2;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void setViewValues(@NonNull View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    paramView.setScaleX(paramFloat1);
    paramView.setScaleY(paramFloat2);
    paramView.setVisibility(paramInt);
  }
  
  public MenuItemImpl getItemData()
  {
    return this.itemData;
  }
  
  public int getItemPosition()
  {
    return this.itemPosition;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.itemData = paramMenuItemImpl;
    setCheckable(paramMenuItemImpl.isCheckable());
    setChecked(paramMenuItemImpl.isChecked());
    setEnabled(paramMenuItemImpl.isEnabled());
    setIcon(paramMenuItemImpl.getIcon());
    setTitle(paramMenuItemImpl.getTitle());
    setId(paramMenuItemImpl.getItemId());
    if (!TextUtils.isEmpty(paramMenuItemImpl.getContentDescription())) {
      setContentDescription(paramMenuItemImpl.getContentDescription());
    }
    TooltipCompat.setTooltipText(this, paramMenuItemImpl.getTooltipText());
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if ((this.itemData != null) && (this.itemData.isCheckable()) && (this.itemData.isChecked())) {
      mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.largeLabel.setPivotX(this.largeLabel.getWidth() / 2);
    this.largeLabel.setPivotY(this.largeLabel.getBaseline());
    this.smallLabel.setPivotX(this.smallLabel.getWidth() / 2);
    this.smallLabel.setPivotY(this.smallLabel.getBaseline());
    switch (this.labelVisibilityMode)
    {
    default: 
      break;
    case 2: 
      setViewLayoutParams(this.icon, this.defaultMargin, 17);
      this.largeLabel.setVisibility(8);
      this.smallLabel.setVisibility(8);
      break;
    case 1: 
      if (paramBoolean)
      {
        setViewLayoutParams(this.icon, (int)(this.defaultMargin + this.shiftAmount), 49);
        setViewValues(this.largeLabel, 1.0F, 1.0F, 0);
        setViewValues(this.smallLabel, this.scaleUpFactor, this.scaleUpFactor, 4);
      }
      else
      {
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        setViewValues(this.largeLabel, this.scaleDownFactor, this.scaleDownFactor, 4);
        setViewValues(this.smallLabel, 1.0F, 1.0F, 0);
      }
      break;
    case 0: 
      if (paramBoolean)
      {
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        setViewValues(this.largeLabel, 1.0F, 1.0F, 0);
      }
      else
      {
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        setViewValues(this.largeLabel, 0.5F, 0.5F, 4);
      }
      this.smallLabel.setVisibility(4);
      break;
    case -1: 
      if (this.isShifting)
      {
        if (paramBoolean)
        {
          setViewLayoutParams(this.icon, this.defaultMargin, 49);
          setViewValues(this.largeLabel, 1.0F, 1.0F, 0);
        }
        else
        {
          setViewLayoutParams(this.icon, this.defaultMargin, 17);
          setViewValues(this.largeLabel, 0.5F, 0.5F, 4);
        }
        this.smallLabel.setVisibility(4);
      }
      else if (paramBoolean)
      {
        setViewLayoutParams(this.icon, (int)(this.defaultMargin + this.shiftAmount), 49);
        setViewValues(this.largeLabel, 1.0F, 1.0F, 0);
        setViewValues(this.smallLabel, this.scaleUpFactor, this.scaleUpFactor, 4);
      }
      else
      {
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        setViewValues(this.largeLabel, this.scaleDownFactor, this.scaleDownFactor, 4);
        setViewValues(this.smallLabel, 1.0F, 1.0F, 0);
      }
      break;
    }
    refreshDrawableState();
    setSelected(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.smallLabel.setEnabled(paramBoolean);
    this.largeLabel.setEnabled(paramBoolean);
    this.icon.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
      return;
    }
    ViewCompat.setPointerIcon(this, null);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getConstantState();
      if (localObject != null) {
        paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
      }
      localObject = DrawableCompat.wrap(paramDrawable).mutate();
      DrawableCompat.setTintList((Drawable)localObject, this.iconTint);
    }
    this.icon.setImageDrawable((Drawable)localObject);
  }
  
  public void setIconSize(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.icon.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.icon.setLayoutParams(localLayoutParams);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.iconTint = paramColorStateList;
    if (this.itemData != null) {
      setIcon(this.itemData.getIcon());
    }
  }
  
  public void setItemBackground(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt == 0) {
      localDrawable = null;
    } else {
      localDrawable = ContextCompat.getDrawable(getContext(), paramInt);
    }
    setItemBackground(localDrawable);
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    ViewCompat.setBackground(this, paramDrawable);
  }
  
  public void setItemPosition(int paramInt)
  {
    this.itemPosition = paramInt;
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.labelVisibilityMode != paramInt)
    {
      this.labelVisibilityMode = paramInt;
      if (this.itemData != null) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0) {
        setChecked(this.itemData.isChecked());
      }
    }
  }
  
  public void setShifting(boolean paramBoolean)
  {
    if (this.isShifting != paramBoolean)
    {
      this.isShifting = paramBoolean;
      int i;
      if (this.itemData != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        setChecked(this.itemData.isChecked());
      }
    }
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTextAppearanceActive(@StyleRes int paramInt)
  {
    TextViewCompat.setTextAppearance(this.largeLabel, paramInt);
    calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
  }
  
  public void setTextAppearanceInactive(@StyleRes int paramInt)
  {
    TextViewCompat.setTextAppearance(this.smallLabel, paramInt);
    calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
  }
  
  public void setTextColor(@Nullable ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      this.smallLabel.setTextColor(paramColorStateList);
      this.largeLabel.setTextColor(paramColorStateList);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.smallLabel.setText(paramCharSequence);
    this.largeLabel.setText(paramCharSequence);
    if ((this.itemData == null) || (TextUtils.isEmpty(this.itemData.getContentDescription()))) {
      setContentDescription(paramCharSequence);
    }
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\internal\BottomNavigationItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */