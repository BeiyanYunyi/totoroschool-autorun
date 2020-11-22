package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.RestrictTo;
import android.support.design.R.dimen;
import android.support.design.R.id;
import android.support.design.R.styleable;
import android.support.design.snackbar.ContentViewCallback;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout
  extends LinearLayout
  implements ContentViewCallback
{
  private Button actionView;
  private int maxInlineActionWidth;
  private int maxWidth;
  private TextView messageView;
  
  public SnackbarContentLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SnackbarContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
    this.maxWidth = paramContext.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
    this.maxInlineActionWidth = paramContext.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
    paramContext.recycle();
  }
  
  private static void updateTopBottomPadding(View paramView, int paramInt1, int paramInt2)
  {
    if (ViewCompat.isPaddingRelative(paramView))
    {
      ViewCompat.setPaddingRelative(paramView, ViewCompat.getPaddingStart(paramView), paramInt1, ViewCompat.getPaddingEnd(paramView), paramInt2);
      return;
    }
    paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
  }
  
  private boolean updateViewsWithinLayout(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (paramInt1 != getOrientation())
    {
      setOrientation(paramInt1);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if ((this.messageView.getPaddingTop() != paramInt2) || (this.messageView.getPaddingBottom() != paramInt3))
    {
      updateTopBottomPadding(this.messageView, paramInt2, paramInt3);
      bool = true;
    }
    return bool;
  }
  
  public void animateContentIn(int paramInt1, int paramInt2)
  {
    this.messageView.setAlpha(0.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.messageView.animate().alpha(1.0F);
    long l1 = paramInt2;
    localViewPropertyAnimator = localViewPropertyAnimator.setDuration(l1);
    long l2 = paramInt1;
    localViewPropertyAnimator.setStartDelay(l2).start();
    if (this.actionView.getVisibility() == 0)
    {
      this.actionView.setAlpha(0.0F);
      this.actionView.animate().alpha(1.0F).setDuration(l1).setStartDelay(l2).start();
    }
  }
  
  public void animateContentOut(int paramInt1, int paramInt2)
  {
    this.messageView.setAlpha(1.0F);
    ViewPropertyAnimator localViewPropertyAnimator = this.messageView.animate().alpha(0.0F);
    long l1 = paramInt2;
    localViewPropertyAnimator = localViewPropertyAnimator.setDuration(l1);
    long l2 = paramInt1;
    localViewPropertyAnimator.setStartDelay(l2).start();
    if (this.actionView.getVisibility() == 0)
    {
      this.actionView.setAlpha(1.0F);
      this.actionView.animate().alpha(0.0F).setDuration(l1).setStartDelay(l2).start();
    }
  }
  
  public Button getActionView()
  {
    return this.actionView;
  }
  
  public TextView getMessageView()
  {
    return this.messageView;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.messageView = ((TextView)findViewById(R.id.snackbar_text));
    this.actionView = ((Button)findViewById(R.id.snackbar_action));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = paramInt1;
    if (this.maxWidth > 0)
    {
      i = paramInt1;
      if (getMeasuredWidth() > this.maxWidth)
      {
        i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
        super.onMeasure(i, paramInt2);
      }
    }
    int k = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
    int m = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
    paramInt1 = this.messageView.getLayout().getLineCount();
    int j = 1;
    if (paramInt1 > 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramInt1 != 0) && (this.maxInlineActionWidth > 0) && (this.actionView.getMeasuredWidth() > this.maxInlineActionWidth))
    {
      if (updateViewsWithinLayout(1, k, k - m))
      {
        paramInt1 = j;
        break label171;
      }
    }
    else
    {
      if (paramInt1 != 0) {
        paramInt1 = k;
      } else {
        paramInt1 = m;
      }
      if (updateViewsWithinLayout(0, paramInt1, paramInt1))
      {
        paramInt1 = j;
        break label171;
      }
    }
    paramInt1 = 0;
    label171:
    if (paramInt1 != 0) {
      super.onMeasure(i, paramInt2);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\SnackbarContentLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */