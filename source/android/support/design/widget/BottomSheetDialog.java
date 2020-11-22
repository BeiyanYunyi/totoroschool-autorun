package android.support.design.widget;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.design.R.attr;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.design.R.style;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AppCompatDialog;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;

public class BottomSheetDialog
  extends AppCompatDialog
{
  private BottomSheetBehavior<FrameLayout> behavior;
  private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback()
  {
    public void onSlide(@NonNull View paramAnonymousView, float paramAnonymousFloat) {}
    
    public void onStateChanged(@NonNull View paramAnonymousView, int paramAnonymousInt)
    {
      if (paramAnonymousInt == 5) {
        BottomSheetDialog.this.cancel();
      }
    }
  };
  boolean cancelable = true;
  private boolean canceledOnTouchOutside = true;
  private boolean canceledOnTouchOutsideSet;
  
  public BottomSheetDialog(@NonNull Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public BottomSheetDialog(@NonNull Context paramContext, @StyleRes int paramInt)
  {
    super(paramContext, getThemeResId(paramContext, paramInt));
    supportRequestWindowFeature(1);
  }
  
  protected BottomSheetDialog(@NonNull Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
    supportRequestWindowFeature(1);
    this.cancelable = paramBoolean;
  }
  
  private static int getThemeResId(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      TypedValue localTypedValue = new TypedValue();
      if (paramContext.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, localTypedValue, true)) {
        return localTypedValue.resourceId;
      }
      i = R.style.Theme_Design_Light_BottomSheetDialog;
    }
    return i;
  }
  
  private View wrapInBottomSheet(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    FrameLayout localFrameLayout = (FrameLayout)View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)localFrameLayout.findViewById(R.id.coordinator);
    View localView = paramView;
    if (paramInt != 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = getLayoutInflater().inflate(paramInt, localCoordinatorLayout, false);
      }
    }
    paramView = (FrameLayout)localCoordinatorLayout.findViewById(R.id.design_bottom_sheet);
    this.behavior = BottomSheetBehavior.from(paramView);
    this.behavior.setBottomSheetCallback(this.bottomSheetCallback);
    this.behavior.setHideable(this.cancelable);
    if (paramLayoutParams == null) {
      paramView.addView(localView);
    } else {
      paramView.addView(localView, paramLayoutParams);
    }
    localCoordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((BottomSheetDialog.this.cancelable) && (BottomSheetDialog.this.isShowing()) && (BottomSheetDialog.this.shouldWindowCloseOnTouchOutside())) {
          BottomSheetDialog.this.cancel();
        }
      }
    });
    ViewCompat.setAccessibilityDelegate(paramView, new AccessibilityDelegateCompat()
    {
      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
        if (BottomSheetDialog.this.cancelable)
        {
          paramAnonymousAccessibilityNodeInfoCompat.addAction(1048576);
          paramAnonymousAccessibilityNodeInfoCompat.setDismissable(true);
          return;
        }
        paramAnonymousAccessibilityNodeInfoCompat.setDismissable(false);
      }
      
      public boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        if ((paramAnonymousInt == 1048576) && (BottomSheetDialog.this.cancelable))
        {
          BottomSheetDialog.this.cancel();
          return true;
        }
        return super.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
      }
    });
    paramView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    return localFrameLayout;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle.clearFlags(67108864);
        paramBundle.addFlags(Integer.MIN_VALUE);
      }
      paramBundle.setLayout(-1, -1);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if ((this.behavior != null) && (this.behavior.getState() == 5)) {
      this.behavior.setState(4);
    }
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    if (this.cancelable != paramBoolean)
    {
      this.cancelable = paramBoolean;
      if (this.behavior != null) {
        this.behavior.setHideable(paramBoolean);
      }
    }
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    super.setCanceledOnTouchOutside(paramBoolean);
    if ((paramBoolean) && (!this.cancelable)) {
      this.cancelable = true;
    }
    this.canceledOnTouchOutside = paramBoolean;
    this.canceledOnTouchOutsideSet = true;
  }
  
  public void setContentView(@LayoutRes int paramInt)
  {
    super.setContentView(wrapInBottomSheet(paramInt, null, null));
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(wrapInBottomSheet(0, paramView, null));
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(wrapInBottomSheet(0, paramView, paramLayoutParams));
  }
  
  boolean shouldWindowCloseOnTouchOutside()
  {
    if (!this.canceledOnTouchOutsideSet)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(new int[] { 16843611 });
      this.canceledOnTouchOutside = localTypedArray.getBoolean(0, true);
      localTypedArray.recycle();
      this.canceledOnTouchOutsideSet = true;
    }
    return this.canceledOnTouchOutside;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\BottomSheetDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */