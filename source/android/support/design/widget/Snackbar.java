package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StringRes;
import android.support.design.R.attr;
import android.support.design.R.layout;
import android.support.design.snackbar.ContentViewCallback;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Snackbar
  extends BaseTransientBottomBar<Snackbar>
{
  public static final int LENGTH_INDEFINITE = -2;
  public static final int LENGTH_LONG = 0;
  public static final int LENGTH_SHORT = -1;
  private static final int[] SNACKBAR_BUTTON_STYLE_ATTR = { R.attr.snackbarButtonStyle };
  private final AccessibilityManager accessibilityManager;
  @Nullable
  private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
  private boolean hasAction;
  
  private Snackbar(ViewGroup paramViewGroup, View paramView, ContentViewCallback paramContentViewCallback)
  {
    super(paramViewGroup, paramView, paramContentViewCallback);
    this.accessibilityManager = ((AccessibilityManager)paramViewGroup.getContext().getSystemService("accessibility"));
  }
  
  private static ViewGroup findSuitableParent(View paramView)
  {
    Object localObject2 = null;
    View localView = paramView;
    Object localObject1;
    do
    {
      if ((localView instanceof CoordinatorLayout)) {
        return (ViewGroup)localView;
      }
      localObject1 = localObject2;
      if ((localView instanceof FrameLayout))
      {
        if (localView.getId() == 16908290) {
          return (ViewGroup)localView;
        }
        localObject1 = (ViewGroup)localView;
      }
      paramView = localView;
      if (localView != null)
      {
        paramView = localView.getParent();
        if ((paramView instanceof View)) {
          paramView = (View)paramView;
        } else {
          paramView = null;
        }
      }
      localObject2 = localObject1;
      localView = paramView;
    } while (paramView != null);
    return (ViewGroup)localObject1;
  }
  
  protected static boolean hasSnackbarButtonStyleAttr(Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
    boolean bool = false;
    int i = paramContext.getResourceId(0, -1);
    paramContext.recycle();
    if (i != -1) {
      bool = true;
    }
    return bool;
  }
  
  @NonNull
  public static Snackbar make(@NonNull View paramView, @StringRes int paramInt1, int paramInt2)
  {
    return make(paramView, paramView.getResources().getText(paramInt1), paramInt2);
  }
  
  @NonNull
  public static Snackbar make(@NonNull View paramView, @NonNull CharSequence paramCharSequence, int paramInt)
  {
    paramView = findSuitableParent(paramView);
    if (paramView != null)
    {
      Object localObject = LayoutInflater.from(paramView.getContext());
      int i;
      if (hasSnackbarButtonStyleAttr(paramView.getContext())) {
        i = R.layout.mtrl_layout_snackbar_include;
      } else {
        i = R.layout.design_layout_snackbar_include;
      }
      localObject = (SnackbarContentLayout)((LayoutInflater)localObject).inflate(i, paramView, false);
      paramView = new Snackbar(paramView, (View)localObject, (ContentViewCallback)localObject);
      paramView.setText(paramCharSequence);
      paramView.setDuration(paramInt);
      return paramView;
    }
    throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
  }
  
  public void dismiss()
  {
    super.dismiss();
  }
  
  public int getDuration()
  {
    if ((this.hasAction) && (this.accessibilityManager.isTouchExplorationEnabled())) {
      return -2;
    }
    return super.getDuration();
  }
  
  public boolean isShown()
  {
    return super.isShown();
  }
  
  @NonNull
  public Snackbar setAction(@StringRes int paramInt, View.OnClickListener paramOnClickListener)
  {
    return setAction(getContext().getText(paramInt), paramOnClickListener);
  }
  
  @NonNull
  public Snackbar setAction(CharSequence paramCharSequence, final View.OnClickListener paramOnClickListener)
  {
    Button localButton = ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView();
    if ((!TextUtils.isEmpty(paramCharSequence)) && (paramOnClickListener != null))
    {
      this.hasAction = true;
      localButton.setVisibility(0);
      localButton.setText(paramCharSequence);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramOnClickListener.onClick(paramAnonymousView);
          Snackbar.this.dispatchDismiss(1);
        }
      });
      return this;
    }
    localButton.setVisibility(8);
    localButton.setOnClickListener(null);
    this.hasAction = false;
    return this;
  }
  
  @NonNull
  public Snackbar setActionTextColor(@ColorInt int paramInt)
  {
    ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView().setTextColor(paramInt);
    return this;
  }
  
  @NonNull
  public Snackbar setActionTextColor(ColorStateList paramColorStateList)
  {
    ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView().setTextColor(paramColorStateList);
    return this;
  }
  
  @Deprecated
  @NonNull
  public Snackbar setCallback(Callback paramCallback)
  {
    if (this.callback != null) {
      removeCallback(this.callback);
    }
    if (paramCallback != null) {
      addCallback(paramCallback);
    }
    this.callback = paramCallback;
    return this;
  }
  
  @NonNull
  public Snackbar setText(@StringRes int paramInt)
  {
    return setText(getContext().getText(paramInt));
  }
  
  @NonNull
  public Snackbar setText(@NonNull CharSequence paramCharSequence)
  {
    ((SnackbarContentLayout)this.view.getChildAt(0)).getMessageView().setText(paramCharSequence);
    return this;
  }
  
  public void show()
  {
    super.show();
  }
  
  public static class Callback
    extends BaseTransientBottomBar.BaseCallback<Snackbar>
  {
    public static final int DISMISS_EVENT_ACTION = 1;
    public static final int DISMISS_EVENT_CONSECUTIVE = 4;
    public static final int DISMISS_EVENT_MANUAL = 3;
    public static final int DISMISS_EVENT_SWIPE = 0;
    public static final int DISMISS_EVENT_TIMEOUT = 2;
    
    public void onDismissed(Snackbar paramSnackbar, int paramInt) {}
    
    public void onShown(Snackbar paramSnackbar) {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @IntRange(from=1L)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface Duration {}
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static final class SnackbarLayout
    extends BaseTransientBottomBar.SnackbarBaseLayout
  {
    public SnackbarLayout(Context paramContext)
    {
      super();
    }
    
    public SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      paramInt2 = getChildCount();
      int i = getMeasuredWidth();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        View localView = getChildAt(paramInt1);
        if (localView.getLayoutParams().width == -1) {
          localView.measure(View.MeasureSpec.makeMeasureSpec(i - j - k, 1073741824), View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824));
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\Snackbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */