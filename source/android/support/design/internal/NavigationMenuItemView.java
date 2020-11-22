package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.RestrictTo;
import android.support.design.R.dimen;
import android.support.design.R.drawable;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.support.v7.widget.TooltipCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuItemView
  extends ForegroundLinearLayout
  implements MenuView.ItemView
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private final AccessibilityDelegateCompat accessibilityDelegate = new AccessibilityDelegateCompat()
  {
    public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
      paramAnonymousAccessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.checkable);
    }
  };
  private FrameLayout actionArea;
  boolean checkable;
  private Drawable emptyDrawable;
  private boolean hasIconTintList;
  private final int iconSize;
  private ColorStateList iconTintList;
  private MenuItemImpl itemData;
  private boolean needsEmptyIcon;
  private final CheckedTextView textView;
  
  public NavigationMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(R.layout.design_navigation_menu_item, this, true);
    this.iconSize = paramContext.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size);
    this.textView = ((CheckedTextView)findViewById(R.id.design_menu_item_text));
    this.textView.setDuplicateParentStateEnabled(true);
    ViewCompat.setAccessibilityDelegate(this.textView, this.accessibilityDelegate);
  }
  
  private void adjustAppearance()
  {
    LinearLayoutCompat.LayoutParams localLayoutParams;
    if (shouldExpandActionArea())
    {
      this.textView.setVisibility(8);
      if (this.actionArea != null)
      {
        localLayoutParams = (LinearLayoutCompat.LayoutParams)this.actionArea.getLayoutParams();
        localLayoutParams.width = -1;
        this.actionArea.setLayoutParams(localLayoutParams);
      }
    }
    else
    {
      this.textView.setVisibility(0);
      if (this.actionArea != null)
      {
        localLayoutParams = (LinearLayoutCompat.LayoutParams)this.actionArea.getLayoutParams();
        localLayoutParams.width = -2;
        this.actionArea.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private StateListDrawable createDefaultBackground()
  {
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, localTypedValue, true))
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(CHECKED_STATE_SET, new ColorDrawable(localTypedValue.data));
      localStateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
      return localStateListDrawable;
    }
    return null;
  }
  
  private void setActionView(View paramView)
  {
    if (paramView != null)
    {
      if (this.actionArea == null) {
        this.actionArea = ((FrameLayout)((ViewStub)findViewById(R.id.design_menu_item_action_area_stub)).inflate());
      }
      this.actionArea.removeAllViews();
      this.actionArea.addView(paramView);
    }
  }
  
  private boolean shouldExpandActionArea()
  {
    return (this.itemData.getTitle() == null) && (this.itemData.getIcon() == null) && (this.itemData.getActionView() != null);
  }
  
  public MenuItemImpl getItemData()
  {
    return this.itemData;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.itemData = paramMenuItemImpl;
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    if (getBackground() == null) {
      ViewCompat.setBackground(this, createDefaultBackground());
    }
    setCheckable(paramMenuItemImpl.isCheckable());
    setChecked(paramMenuItemImpl.isChecked());
    setEnabled(paramMenuItemImpl.isEnabled());
    setTitle(paramMenuItemImpl.getTitle());
    setIcon(paramMenuItemImpl.getIcon());
    setActionView(paramMenuItemImpl.getActionView());
    setContentDescription(paramMenuItemImpl.getContentDescription());
    TooltipCompat.setTooltipText(this, paramMenuItemImpl.getTooltipText());
    adjustAppearance();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
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
  
  public void recycle()
  {
    if (this.actionArea != null) {
      this.actionArea.removeAllViews();
    }
    this.textView.setCompoundDrawables(null, null, null, null);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (this.checkable != paramBoolean)
    {
      this.checkable = paramBoolean;
      this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.textView.setChecked(paramBoolean);
  }
  
  public void setHorizontalPadding(int paramInt)
  {
    setPadding(paramInt, 0, paramInt, 0);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      Object localObject = paramDrawable;
      if (this.hasIconTintList)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject != null) {
          paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
        }
        localObject = DrawableCompat.wrap(paramDrawable).mutate();
        DrawableCompat.setTintList((Drawable)localObject, this.iconTintList);
      }
      ((Drawable)localObject).setBounds(0, 0, this.iconSize, this.iconSize);
      paramDrawable = (Drawable)localObject;
    }
    else if (this.needsEmptyIcon)
    {
      if (this.emptyDrawable == null)
      {
        this.emptyDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.navigation_empty_icon, getContext().getTheme());
        if (this.emptyDrawable != null) {
          this.emptyDrawable.setBounds(0, 0, this.iconSize, this.iconSize);
        }
      }
      paramDrawable = this.emptyDrawable;
    }
    TextViewCompat.setCompoundDrawablesRelative(this.textView, paramDrawable, null, null, null);
  }
  
  public void setIconPadding(int paramInt)
  {
    this.textView.setCompoundDrawablePadding(paramInt);
  }
  
  void setIconTintList(ColorStateList paramColorStateList)
  {
    this.iconTintList = paramColorStateList;
    boolean bool;
    if (this.iconTintList != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.hasIconTintList = bool;
    if (this.itemData != null) {
      setIcon(this.itemData.getIcon());
    }
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.needsEmptyIcon = paramBoolean;
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTextAppearance(int paramInt)
  {
    TextViewCompat.setTextAppearance(this.textView, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.textView.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.textView.setText(paramCharSequence);
  }
  
  public boolean showsIcon()
  {
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\internal\NavigationMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */