package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class TooltipCompatHandler
  implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener
{
  private static final long HOVER_HIDE_TIMEOUT_MS = 15000L;
  private static final long HOVER_HIDE_TIMEOUT_SHORT_MS = 3000L;
  private static final long LONG_CLICK_HIDE_TIMEOUT_MS = 2500L;
  private static final String TAG = "TooltipCompatHandler";
  private static TooltipCompatHandler sActiveHandler;
  private static TooltipCompatHandler sPendingHandler;
  private final View mAnchor;
  private int mAnchorX;
  private int mAnchorY;
  private boolean mFromTouch;
  private final Runnable mHideRunnable = new Runnable()
  {
    public void run()
    {
      TooltipCompatHandler.this.hide();
    }
  };
  private final int mHoverSlop;
  private TooltipPopup mPopup;
  private final Runnable mShowRunnable = new Runnable()
  {
    public void run()
    {
      TooltipCompatHandler.this.show(false);
    }
  };
  private final CharSequence mTooltipText;
  
  private TooltipCompatHandler(View paramView, CharSequence paramCharSequence)
  {
    this.mAnchor = paramView;
    this.mTooltipText = paramCharSequence;
    this.mHoverSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(this.mAnchor.getContext()));
    clearAnchorPos();
    this.mAnchor.setOnLongClickListener(this);
    this.mAnchor.setOnHoverListener(this);
  }
  
  private void cancelPendingShow()
  {
    this.mAnchor.removeCallbacks(this.mShowRunnable);
  }
  
  private void clearAnchorPos()
  {
    this.mAnchorX = Integer.MAX_VALUE;
    this.mAnchorY = Integer.MAX_VALUE;
  }
  
  private void scheduleShow()
  {
    this.mAnchor.postDelayed(this.mShowRunnable, ViewConfiguration.getLongPressTimeout());
  }
  
  private static void setPendingHandler(TooltipCompatHandler paramTooltipCompatHandler)
  {
    if (sPendingHandler != null) {
      sPendingHandler.cancelPendingShow();
    }
    sPendingHandler = paramTooltipCompatHandler;
    if (sPendingHandler != null) {
      sPendingHandler.scheduleShow();
    }
  }
  
  public static void setTooltipText(View paramView, CharSequence paramCharSequence)
  {
    if ((sPendingHandler != null) && (sPendingHandler.mAnchor == paramView)) {
      setPendingHandler(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if ((sActiveHandler != null) && (sActiveHandler.mAnchor == paramView)) {
        sActiveHandler.hide();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    }
    new TooltipCompatHandler(paramView, paramCharSequence);
  }
  
  private boolean updateAnchorPos(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((Math.abs(i - this.mAnchorX) <= this.mHoverSlop) && (Math.abs(j - this.mAnchorY) <= this.mHoverSlop)) {
      return false;
    }
    this.mAnchorX = i;
    this.mAnchorY = j;
    return true;
  }
  
  void hide()
  {
    if (sActiveHandler == this)
    {
      sActiveHandler = null;
      if (this.mPopup != null)
      {
        this.mPopup.hide();
        this.mPopup = null;
        clearAnchorPos();
        this.mAnchor.removeOnAttachStateChangeListener(this);
      }
      else
      {
        Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
      }
    }
    if (sPendingHandler == this) {
      setPendingHandler(null);
    }
    this.mAnchor.removeCallbacks(this.mHideRunnable);
  }
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.mPopup != null) && (this.mFromTouch)) {
      return false;
    }
    paramView = (AccessibilityManager)this.mAnchor.getContext().getSystemService("accessibility");
    if ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled())) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 7)
    {
      if (i != 10) {
        return false;
      }
      clearAnchorPos();
      hide();
      return false;
    }
    if ((this.mAnchor.isEnabled()) && (this.mPopup == null) && (updateAnchorPos(paramMotionEvent))) {
      setPendingHandler(this);
    }
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    this.mAnchorX = (paramView.getWidth() / 2);
    this.mAnchorY = (paramView.getHeight() / 2);
    show(true);
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    hide();
  }
  
  void show(boolean paramBoolean)
  {
    if (!ViewCompat.isAttachedToWindow(this.mAnchor)) {
      return;
    }
    setPendingHandler(null);
    if (sActiveHandler != null) {
      sActiveHandler.hide();
    }
    sActiveHandler = this;
    this.mFromTouch = paramBoolean;
    this.mPopup = new TooltipPopup(this.mAnchor.getContext());
    this.mPopup.show(this.mAnchor, this.mAnchorX, this.mAnchorY, this.mFromTouch, this.mTooltipText);
    this.mAnchor.addOnAttachStateChangeListener(this);
    long l;
    if (this.mFromTouch) {
      l = 2500L;
    } else if ((ViewCompat.getWindowSystemUiVisibility(this.mAnchor) & 0x1) == 1) {
      l = 3000L - ViewConfiguration.getLongPressTimeout();
    } else {
      l = 15000L - ViewConfiguration.getLongPressTimeout();
    }
    this.mAnchor.removeCallbacks(this.mHideRunnable);
    this.mAnchor.postDelayed(this.mHideRunnable, l);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\TooltipCompatHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */