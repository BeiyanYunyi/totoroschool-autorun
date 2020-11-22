package android.support.design.widget;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class CheckableImageButton
  extends AppCompatImageButton
  implements Checkable
{
  private static final int[] DRAWABLE_STATE_CHECKED = { 16842912 };
  private boolean checked;
  
  public CheckableImageButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.imageButtonStyle);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat()
    {
      public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        paramAnonymousAccessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
      }
      
      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
        paramAnonymousAccessibilityNodeInfoCompat.setCheckable(true);
        paramAnonymousAccessibilityNodeInfoCompat.setChecked(CheckableImageButton.this.isChecked());
      }
    });
  }
  
  public boolean isChecked()
  {
    return this.checked;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (this.checked) {
      return mergeDrawableStates(super.onCreateDrawableState(paramInt + DRAWABLE_STATE_CHECKED.length), DRAWABLE_STATE_CHECKED);
    }
    return super.onCreateDrawableState(paramInt);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.checked != paramBoolean)
    {
      this.checked = paramBoolean;
      refreshDrawableState();
      sendAccessibilityEvent(2048);
    }
  }
  
  public void toggle()
  {
    setChecked(this.checked ^ true);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\CheckableImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */