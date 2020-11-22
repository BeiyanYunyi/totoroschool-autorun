package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ListMenuItemView
  extends LinearLayout
  implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster
{
  private static final String TAG = "ListMenuItemView";
  private Drawable mBackground;
  private CheckBox mCheckBox;
  private LinearLayout mContent;
  private boolean mForceShowIcon;
  private ImageView mGroupDivider;
  private boolean mHasListDivider;
  private ImageView mIconView;
  private LayoutInflater mInflater;
  private MenuItemImpl mItemData;
  private int mMenuType;
  private boolean mPreserveIconSpacing;
  private RadioButton mRadioButton;
  private TextView mShortcutView;
  private Drawable mSubMenuArrow;
  private ImageView mSubMenuArrowView;
  private int mTextAppearance;
  private Context mTextAppearanceContext;
  private TextView mTitleView;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.listMenuViewStyle);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.MenuView, paramInt, 0);
    this.mBackground = paramAttributeSet.getDrawable(R.styleable.MenuView_android_itemBackground);
    this.mTextAppearance = paramAttributeSet.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
    this.mPreserveIconSpacing = paramAttributeSet.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
    this.mTextAppearanceContext = paramContext;
    this.mSubMenuArrow = paramAttributeSet.getDrawable(R.styleable.MenuView_subMenuArrow);
    paramContext = paramContext.getTheme();
    paramInt = R.attr.dropDownListViewStyle;
    paramContext = paramContext.obtainStyledAttributes(null, new int[] { 16843049 }, paramInt, 0);
    this.mHasListDivider = paramContext.hasValue(0);
    paramAttributeSet.recycle();
    paramContext.recycle();
  }
  
  private void addContentView(View paramView)
  {
    addContentView(paramView, -1);
  }
  
  private void addContentView(View paramView, int paramInt)
  {
    if (this.mContent != null)
    {
      this.mContent.addView(paramView, paramInt);
      return;
    }
    addView(paramView, paramInt);
  }
  
  private LayoutInflater getInflater()
  {
    if (this.mInflater == null) {
      this.mInflater = LayoutInflater.from(getContext());
    }
    return this.mInflater;
  }
  
  private void insertCheckBox()
  {
    this.mCheckBox = ((CheckBox)getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false));
    addContentView(this.mCheckBox);
  }
  
  private void insertIconView()
  {
    this.mIconView = ((ImageView)getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false));
    addContentView(this.mIconView, 0);
  }
  
  private void insertRadioButton()
  {
    this.mRadioButton = ((RadioButton)getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false));
    addContentView(this.mRadioButton);
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    if (this.mSubMenuArrowView != null)
    {
      ImageView localImageView = this.mSubMenuArrowView;
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
  
  public void adjustListItemSelectionBounds(Rect paramRect)
  {
    if ((this.mGroupDivider != null) && (this.mGroupDivider.getVisibility() == 0))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mGroupDivider.getLayoutParams();
      paramRect.top += this.mGroupDivider.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    }
  }
  
  public MenuItemImpl getItemData()
  {
    return this.mItemData;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    this.mItemData = paramMenuItemImpl;
    this.mMenuType = paramInt;
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    setTitle(paramMenuItemImpl.getTitleForItemView(this));
    setCheckable(paramMenuItemImpl.isCheckable());
    setShortcut(paramMenuItemImpl.shouldShowShortcut(), paramMenuItemImpl.getShortcut());
    setIcon(paramMenuItemImpl.getIcon());
    setEnabled(paramMenuItemImpl.isEnabled());
    setSubMenuArrowVisible(paramMenuItemImpl.hasSubMenu());
    setContentDescription(paramMenuItemImpl.getContentDescription());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ViewCompat.setBackground(this, this.mBackground);
    this.mTitleView = ((TextView)findViewById(R.id.title));
    if (this.mTextAppearance != -1) {
      this.mTitleView.setTextAppearance(this.mTextAppearanceContext, this.mTextAppearance);
    }
    this.mShortcutView = ((TextView)findViewById(R.id.shortcut));
    this.mSubMenuArrowView = ((ImageView)findViewById(R.id.submenuarrow));
    if (this.mSubMenuArrowView != null) {
      this.mSubMenuArrowView.setImageDrawable(this.mSubMenuArrow);
    }
    this.mGroupDivider = ((ImageView)findViewById(R.id.group_divider));
    this.mContent = ((LinearLayout)findViewById(R.id.content));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.mIconView != null) && (this.mPreserveIconSpacing))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.mIconView.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.mRadioButton == null) && (this.mCheckBox == null)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.mItemData.isExclusiveCheckable())
    {
      if (this.mRadioButton == null) {
        insertRadioButton();
      }
      localObject1 = this.mRadioButton;
      localObject2 = this.mCheckBox;
    }
    else
    {
      if (this.mCheckBox == null) {
        insertCheckBox();
      }
      localObject1 = this.mCheckBox;
      localObject2 = this.mRadioButton;
    }
    if (paramBoolean)
    {
      ((CompoundButton)localObject1).setChecked(this.mItemData.isChecked());
      if (((CompoundButton)localObject1).getVisibility() != 0) {
        ((CompoundButton)localObject1).setVisibility(0);
      }
      if ((localObject2 != null) && (((CompoundButton)localObject2).getVisibility() != 8)) {
        ((CompoundButton)localObject2).setVisibility(8);
      }
    }
    else
    {
      if (this.mCheckBox != null) {
        this.mCheckBox.setVisibility(8);
      }
      if (this.mRadioButton != null) {
        this.mRadioButton.setVisibility(8);
      }
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject;
    if (this.mItemData.isExclusiveCheckable())
    {
      if (this.mRadioButton == null) {
        insertRadioButton();
      }
      localObject = this.mRadioButton;
    }
    else
    {
      if (this.mCheckBox == null) {
        insertCheckBox();
      }
      localObject = this.mCheckBox;
    }
    ((CompoundButton)localObject).setChecked(paramBoolean);
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.mForceShowIcon = paramBoolean;
    this.mPreserveIconSpacing = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    if (this.mGroupDivider != null)
    {
      ImageView localImageView = this.mGroupDivider;
      int i;
      if ((!this.mHasListDivider) && (paramBoolean)) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i;
    if ((!this.mItemData.shouldShowIcon()) && (!this.mForceShowIcon)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (!this.mPreserveIconSpacing)) {
      return;
    }
    if ((this.mIconView == null) && (paramDrawable == null) && (!this.mPreserveIconSpacing)) {
      return;
    }
    if (this.mIconView == null) {
      insertIconView();
    }
    if ((paramDrawable == null) && (!this.mPreserveIconSpacing))
    {
      this.mIconView.setVisibility(8);
      return;
    }
    ImageView localImageView = this.mIconView;
    if (i == 0) {
      paramDrawable = null;
    }
    localImageView.setImageDrawable(paramDrawable);
    if (this.mIconView.getVisibility() != 0) {
      this.mIconView.setVisibility(0);
    }
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar)
  {
    if ((paramBoolean) && (this.mItemData.shouldShowShortcut())) {
      paramChar = '\000';
    } else {
      paramChar = '\b';
    }
    if (paramChar == 0) {
      this.mShortcutView.setText(this.mItemData.getShortcutLabel());
    }
    if (this.mShortcutView.getVisibility() != paramChar) {
      this.mShortcutView.setVisibility(paramChar);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.mTitleView.setText(paramCharSequence);
      if (this.mTitleView.getVisibility() != 0) {
        this.mTitleView.setVisibility(0);
      }
    }
    else if (this.mTitleView.getVisibility() != 8)
    {
      this.mTitleView.setVisibility(8);
    }
  }
  
  public boolean showsIcon()
  {
    return this.mForceShowIcon;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\view\menu\ListMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */