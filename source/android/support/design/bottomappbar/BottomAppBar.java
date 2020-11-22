package android.support.design.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.Dimension;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.design.R.attr;
import android.support.design.R.dimen;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.animation.AnimationUtils;
import android.support.design.behavior.HideBottomViewOnScrollBehavior;
import android.support.design.internal.ThemeEnforcement;
import android.support.design.resources.MaterialResources;
import android.support.design.shape.MaterialShapeDrawable;
import android.support.design.shape.ShapePathModel;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.AttachedBehavior;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BottomAppBar
  extends Toolbar
  implements CoordinatorLayout.AttachedBehavior
{
  private static final long ANIMATION_DURATION = 300L;
  public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
  public static final int FAB_ALIGNMENT_MODE_END = 1;
  @Nullable
  private Animator attachAnimator;
  private int fabAlignmentMode;
  AnimatorListenerAdapter fabAnimationListener = new AnimatorListenerAdapter()
  {
    public void onAnimationStart(Animator paramAnonymousAnimator)
    {
      BottomAppBar.this.maybeAnimateAttachChange(BottomAppBar.this.fabAttached);
      BottomAppBar.this.maybeAnimateMenuView(BottomAppBar.this.fabAlignmentMode, BottomAppBar.this.fabAttached);
    }
  };
  private boolean fabAttached = true;
  private final int fabOffsetEndMode;
  private boolean hideOnScroll;
  private final MaterialShapeDrawable materialShapeDrawable;
  @Nullable
  private Animator menuAnimator;
  @Nullable
  private Animator modeAnimator;
  private final BottomAppBarTopEdgeTreatment topEdgeTreatment;
  
  public BottomAppBar(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public BottomAppBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.bottomAppBarStyle);
  }
  
  public BottomAppBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.BottomAppBar, paramInt, R.style.Widget_MaterialComponents_BottomAppBar, new int[0]);
    paramContext = MaterialResources.getColorStateList(paramContext, paramAttributeSet, R.styleable.BottomAppBar_backgroundTint);
    float f1 = paramAttributeSet.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
    float f2 = paramAttributeSet.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
    float f3 = paramAttributeSet.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
    this.fabAlignmentMode = paramAttributeSet.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
    this.hideOnScroll = paramAttributeSet.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
    paramAttributeSet.recycle();
    this.fabOffsetEndMode = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
    this.topEdgeTreatment = new BottomAppBarTopEdgeTreatment(f1, f2, f3);
    paramAttributeSet = new ShapePathModel();
    paramAttributeSet.setTopEdge(this.topEdgeTreatment);
    this.materialShapeDrawable = new MaterialShapeDrawable(paramAttributeSet);
    this.materialShapeDrawable.setShadowEnabled(true);
    this.materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
    DrawableCompat.setTintList(this.materialShapeDrawable, paramContext);
    ViewCompat.setBackground(this, this.materialShapeDrawable);
  }
  
  private void addFabAnimationListeners(@NonNull FloatingActionButton paramFloatingActionButton)
  {
    removeFabAnimationListeners(paramFloatingActionButton);
    paramFloatingActionButton.addOnHideAnimationListener(this.fabAnimationListener);
    paramFloatingActionButton.addOnShowAnimationListener(this.fabAnimationListener);
  }
  
  private void cancelAnimations()
  {
    if (this.attachAnimator != null) {
      this.attachAnimator.cancel();
    }
    if (this.menuAnimator != null) {
      this.menuAnimator.cancel();
    }
    if (this.modeAnimator != null) {
      this.modeAnimator.cancel();
    }
  }
  
  private void createCradleShapeAnimation(boolean paramBoolean, List<Animator> paramList)
  {
    if (paramBoolean) {
      this.topEdgeTreatment.setHorizontalOffset(getFabTranslationX());
    }
    float f2 = this.materialShapeDrawable.getInterpolation();
    float f1;
    if (paramBoolean) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f2, f1 });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        BottomAppBar.this.materialShapeDrawable.setInterpolation(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
      }
    });
    localValueAnimator.setDuration(300L);
    paramList.add(localValueAnimator);
  }
  
  private void createCradleTranslationAnimation(int paramInt, List<Animator> paramList)
  {
    if (!this.fabAttached) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { this.topEdgeTreatment.getHorizontalOffset(), getFabTranslationX(paramInt) });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        BottomAppBar.this.topEdgeTreatment.setHorizontalOffset(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        BottomAppBar.this.materialShapeDrawable.invalidateSelf();
      }
    });
    localValueAnimator.setDuration(300L);
    paramList.add(localValueAnimator);
  }
  
  private void createFabTranslationXAnimation(int paramInt, List<Animator> paramList)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(findDependentFab(), "translationX", new float[] { getFabTranslationX(paramInt) });
    localObjectAnimator.setDuration(300L);
    paramList.add(localObjectAnimator);
  }
  
  private void createFabTranslationYAnimation(boolean paramBoolean, List<Animator> paramList)
  {
    Object localObject = findDependentFab();
    if (localObject == null) {
      return;
    }
    localObject = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { getFabTranslationY(paramBoolean) });
    ((ObjectAnimator)localObject).setDuration(300L);
    paramList.add(localObject);
  }
  
  private void createMenuViewTranslationAnimation(final int paramInt, final boolean paramBoolean, List<Animator> paramList)
  {
    final Object localObject = getActionMenuView();
    if (localObject == null) {
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 1.0F });
    if (((!this.fabAttached) && ((!paramBoolean) || (!isVisibleFab()))) || ((this.fabAlignmentMode != 1) && (paramInt != 1)))
    {
      if (((ActionMenuView)localObject).getAlpha() < 1.0F) {
        paramList.add(localObjectAnimator1);
      }
    }
    else
    {
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F });
      localObjectAnimator2.addListener(new AnimatorListenerAdapter()
      {
        public boolean cancelled;
        
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          this.cancelled = true;
        }
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (!this.cancelled) {
            BottomAppBar.this.translateActionMenuView(localObject, paramInt, paramBoolean);
          }
        }
      });
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).setDuration(150L);
      ((AnimatorSet)localObject).playSequentially(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
      paramList.add(localObject);
    }
  }
  
  @Nullable
  private FloatingActionButton findDependentFab()
  {
    if (!(getParent() instanceof CoordinatorLayout)) {
      return null;
    }
    Iterator localIterator = ((CoordinatorLayout)getParent()).getDependents(this).iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if ((localView instanceof FloatingActionButton)) {
        return (FloatingActionButton)localView;
      }
    }
    return null;
  }
  
  @Nullable
  private ActionMenuView getActionMenuView()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView instanceof ActionMenuView)) {
        return (ActionMenuView)localView;
      }
      i += 1;
    }
    return null;
  }
  
  private float getFabTranslationX()
  {
    return getFabTranslationX(this.fabAlignmentMode);
  }
  
  private int getFabTranslationX(int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    int j = 0;
    int k = 1;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramInt == 1)
    {
      j = getMeasuredWidth() / 2;
      int m = this.fabOffsetEndMode;
      paramInt = k;
      if (i != 0) {
        paramInt = -1;
      }
      j = (j - m) * paramInt;
    }
    return j;
  }
  
  private float getFabTranslationY()
  {
    return getFabTranslationY(this.fabAttached);
  }
  
  private float getFabTranslationY(boolean paramBoolean)
  {
    FloatingActionButton localFloatingActionButton = findDependentFab();
    if (localFloatingActionButton == null) {
      return 0.0F;
    }
    Rect localRect = new Rect();
    localFloatingActionButton.getContentRect(localRect);
    float f2 = localRect.height();
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = localFloatingActionButton.getMeasuredHeight();
    }
    f2 = localFloatingActionButton.getHeight() - localRect.bottom;
    float f5 = localFloatingActionButton.getHeight() - localRect.height();
    float f3 = -getCradleVerticalOffset();
    float f4 = f1 / 2.0F;
    f1 = f5 - localFloatingActionButton.getPaddingBottom();
    f5 = -getMeasuredHeight();
    if (paramBoolean) {
      f1 = f3 + f4 + f2;
    }
    return f5 + f1;
  }
  
  private boolean isAnimationRunning()
  {
    return ((this.attachAnimator != null) && (this.attachAnimator.isRunning())) || ((this.menuAnimator != null) && (this.menuAnimator.isRunning())) || ((this.modeAnimator != null) && (this.modeAnimator.isRunning()));
  }
  
  private boolean isVisibleFab()
  {
    FloatingActionButton localFloatingActionButton = findDependentFab();
    return (localFloatingActionButton != null) && (localFloatingActionButton.isOrWillBeShown());
  }
  
  private void maybeAnimateAttachChange(boolean paramBoolean)
  {
    if (!ViewCompat.isLaidOut(this)) {
      return;
    }
    if (this.attachAnimator != null) {
      this.attachAnimator.cancel();
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    if ((paramBoolean) && (isVisibleFab())) {
      bool = true;
    } else {
      bool = false;
    }
    createCradleShapeAnimation(bool, localArrayList);
    createFabTranslationYAnimation(paramBoolean, localArrayList);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(localArrayList);
    this.attachAnimator = localAnimatorSet;
    this.attachAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        BottomAppBar.access$502(BottomAppBar.this, null);
      }
    });
    this.attachAnimator.start();
  }
  
  private void maybeAnimateMenuView(int paramInt, boolean paramBoolean)
  {
    if (!ViewCompat.isLaidOut(this)) {
      return;
    }
    if (this.menuAnimator != null) {
      this.menuAnimator.cancel();
    }
    ArrayList localArrayList = new ArrayList();
    if (!isVisibleFab())
    {
      paramInt = 0;
      paramBoolean = false;
    }
    createMenuViewTranslationAnimation(paramInt, paramBoolean, localArrayList);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(localArrayList);
    this.menuAnimator = localAnimatorSet;
    this.menuAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        BottomAppBar.access$302(BottomAppBar.this, null);
      }
    });
    this.menuAnimator.start();
  }
  
  private void maybeAnimateModeChange(int paramInt)
  {
    if (this.fabAlignmentMode != paramInt)
    {
      if (!ViewCompat.isLaidOut(this)) {
        return;
      }
      if (this.modeAnimator != null) {
        this.modeAnimator.cancel();
      }
      ArrayList localArrayList = new ArrayList();
      createCradleTranslationAnimation(paramInt, localArrayList);
      createFabTranslationXAnimation(paramInt, localArrayList);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(localArrayList);
      this.modeAnimator = localAnimatorSet;
      this.modeAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          BottomAppBar.access$002(BottomAppBar.this, null);
        }
      });
      this.modeAnimator.start();
      return;
    }
  }
  
  private void removeFabAnimationListeners(@NonNull FloatingActionButton paramFloatingActionButton)
  {
    paramFloatingActionButton.removeOnHideAnimationListener(this.fabAnimationListener);
    paramFloatingActionButton.removeOnShowAnimationListener(this.fabAnimationListener);
  }
  
  private void setCutoutState()
  {
    this.topEdgeTreatment.setHorizontalOffset(getFabTranslationX());
    Object localObject = findDependentFab();
    MaterialShapeDrawable localMaterialShapeDrawable = this.materialShapeDrawable;
    float f;
    if ((this.fabAttached) && (isVisibleFab())) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    localMaterialShapeDrawable.setInterpolation(f);
    if (localObject != null)
    {
      ((FloatingActionButton)localObject).setTranslationY(getFabTranslationY());
      ((FloatingActionButton)localObject).setTranslationX(getFabTranslationX());
    }
    localObject = getActionMenuView();
    if (localObject != null)
    {
      ((ActionMenuView)localObject).setAlpha(1.0F);
      if (!isVisibleFab())
      {
        translateActionMenuView((ActionMenuView)localObject, 0, false);
        return;
      }
      translateActionMenuView((ActionMenuView)localObject, this.fabAlignmentMode, this.fabAttached);
    }
  }
  
  private void translateActionMenuView(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean)
  {
    int i;
    if (ViewCompat.getLayoutDirection(this) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int k = 0;
    int m;
    for (int j = 0; k < getChildCount(); j = m)
    {
      View localView = getChildAt(k);
      int n;
      if (((localView.getLayoutParams() instanceof Toolbar.LayoutParams)) && ((((Toolbar.LayoutParams)localView.getLayoutParams()).gravity & 0x800007) == 8388611)) {
        n = 1;
      } else {
        n = 0;
      }
      m = j;
      if (n != 0)
      {
        if (i != 0) {
          m = localView.getLeft();
        } else {
          m = localView.getRight();
        }
        m = Math.max(j, m);
      }
      k += 1;
    }
    if (i != 0) {
      i = paramActionMenuView.getRight();
    } else {
      i = paramActionMenuView.getLeft();
    }
    float f;
    if ((paramInt == 1) && (paramBoolean)) {
      f = j - i;
    } else {
      f = 0.0F;
    }
    paramActionMenuView.setTranslationX(f);
  }
  
  @Nullable
  public ColorStateList getBackgroundTint()
  {
    return this.materialShapeDrawable.getTintList();
  }
  
  @NonNull
  public CoordinatorLayout.Behavior<BottomAppBar> getBehavior()
  {
    return new Behavior();
  }
  
  @Dimension
  public float getCradleVerticalOffset()
  {
    return this.topEdgeTreatment.getCradleVerticalOffset();
  }
  
  public int getFabAlignmentMode()
  {
    return this.fabAlignmentMode;
  }
  
  public float getFabCradleMargin()
  {
    return this.topEdgeTreatment.getFabCradleMargin();
  }
  
  @Dimension
  public float getFabCradleRoundedCornerRadius()
  {
    return this.topEdgeTreatment.getFabCradleRoundedCornerRadius();
  }
  
  public boolean getHideOnScroll()
  {
    return this.hideOnScroll;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    cancelAnimations();
    setCutoutState();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.fabAlignmentMode = paramParcelable.fabAlignmentMode;
    this.fabAttached = paramParcelable.fabAttached;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.fabAlignmentMode = this.fabAlignmentMode;
    localSavedState.fabAttached = this.fabAttached;
    return localSavedState;
  }
  
  public void replaceMenu(@MenuRes int paramInt)
  {
    getMenu().clear();
    inflateMenu(paramInt);
  }
  
  public void setBackgroundTint(@Nullable ColorStateList paramColorStateList)
  {
    DrawableCompat.setTintList(this.materialShapeDrawable, paramColorStateList);
  }
  
  public void setCradleVerticalOffset(@Dimension float paramFloat)
  {
    if (paramFloat != getCradleVerticalOffset())
    {
      this.topEdgeTreatment.setCradleVerticalOffset(paramFloat);
      this.materialShapeDrawable.invalidateSelf();
    }
  }
  
  public void setFabAlignmentMode(int paramInt)
  {
    maybeAnimateModeChange(paramInt);
    maybeAnimateMenuView(paramInt, this.fabAttached);
    this.fabAlignmentMode = paramInt;
  }
  
  public void setFabCradleMargin(@Dimension float paramFloat)
  {
    if (paramFloat != getFabCradleMargin())
    {
      this.topEdgeTreatment.setFabCradleMargin(paramFloat);
      this.materialShapeDrawable.invalidateSelf();
    }
  }
  
  public void setFabCradleRoundedCornerRadius(@Dimension float paramFloat)
  {
    if (paramFloat != getFabCradleRoundedCornerRadius())
    {
      this.topEdgeTreatment.setFabCradleRoundedCornerRadius(paramFloat);
      this.materialShapeDrawable.invalidateSelf();
    }
  }
  
  void setFabDiameter(@Px int paramInt)
  {
    float f = paramInt;
    if (f != this.topEdgeTreatment.getFabDiameter())
    {
      this.topEdgeTreatment.setFabDiameter(f);
      this.materialShapeDrawable.invalidateSelf();
    }
  }
  
  public void setHideOnScroll(boolean paramBoolean)
  {
    this.hideOnScroll = paramBoolean;
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {}
  
  public void setTitle(CharSequence paramCharSequence) {}
  
  public static class Behavior
    extends HideBottomViewOnScrollBehavior<BottomAppBar>
  {
    private final Rect fabContentRect = new Rect();
    
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private boolean updateFabPositionAndVisibility(FloatingActionButton paramFloatingActionButton, BottomAppBar paramBottomAppBar)
    {
      ((CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams()).anchorGravity = 17;
      paramBottomAppBar.addFabAnimationListeners(paramFloatingActionButton);
      return true;
    }
    
    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, BottomAppBar paramBottomAppBar, int paramInt)
    {
      FloatingActionButton localFloatingActionButton = paramBottomAppBar.findDependentFab();
      if (localFloatingActionButton != null)
      {
        updateFabPositionAndVisibility(localFloatingActionButton, paramBottomAppBar);
        localFloatingActionButton.getMeasuredContentRect(this.fabContentRect);
        paramBottomAppBar.setFabDiameter(this.fabContentRect.height());
      }
      if (!paramBottomAppBar.isAnimationRunning()) {
        paramBottomAppBar.setCutoutState();
      }
      paramCoordinatorLayout.onLayoutChild(paramBottomAppBar, paramInt);
      return super.onLayoutChild(paramCoordinatorLayout, paramBottomAppBar, paramInt);
    }
    
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull BottomAppBar paramBottomAppBar, @NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
    {
      return (paramBottomAppBar.getHideOnScroll()) && (super.onStartNestedScroll(paramCoordinatorLayout, paramBottomAppBar, paramView1, paramView2, paramInt1, paramInt2));
    }
    
    protected void slideDown(BottomAppBar paramBottomAppBar)
    {
      super.slideDown(paramBottomAppBar);
      paramBottomAppBar = paramBottomAppBar.findDependentFab();
      if (paramBottomAppBar != null)
      {
        paramBottomAppBar.getContentRect(this.fabContentRect);
        float f = paramBottomAppBar.getMeasuredHeight() - this.fabContentRect.height();
        paramBottomAppBar.clearAnimation();
        paramBottomAppBar.animate().translationY(-paramBottomAppBar.getPaddingBottom() + f).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setDuration(175L);
      }
    }
    
    protected void slideUp(BottomAppBar paramBottomAppBar)
    {
      super.slideUp(paramBottomAppBar);
      FloatingActionButton localFloatingActionButton = paramBottomAppBar.findDependentFab();
      if (localFloatingActionButton != null)
      {
        localFloatingActionButton.clearAnimation();
        localFloatingActionButton.animate().translationY(paramBottomAppBar.getFabTranslationY()).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setDuration(225L);
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FabAlignmentMode {}
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public BottomAppBar.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new BottomAppBar.SavedState(paramAnonymousParcel, null);
      }
      
      public BottomAppBar.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new BottomAppBar.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public BottomAppBar.SavedState[] newArray(int paramAnonymousInt)
      {
        return new BottomAppBar.SavedState[paramAnonymousInt];
      }
    };
    int fabAlignmentMode;
    boolean fabAttached;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.fabAlignmentMode = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.fabAttached = bool;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\bottomappbar\BottomAppBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */