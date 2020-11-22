package com.github.barteksc.pdfviewer.scroll;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.R.drawable;
import com.github.barteksc.pdfviewer.util.Util;

public class DefaultScrollHandle
  extends RelativeLayout
  implements ScrollHandle
{
  private static final int DEFAULT_TEXT_SIZE = 16;
  private static final int HANDLE_LONG = 65;
  private static final int HANDLE_SHORT = 40;
  protected Context context;
  private float currentPos;
  private Handler handler = new Handler();
  private Runnable hidePageScrollerRunnable = new Runnable()
  {
    public void run()
    {
      DefaultScrollHandle.this.hide();
    }
  };
  private boolean inverted;
  private PDFView pdfView;
  private float relativeHandlerMiddle = 0.0F;
  protected TextView textView;
  
  public DefaultScrollHandle(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public DefaultScrollHandle(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.context = paramContext;
    this.inverted = paramBoolean;
    this.textView = new TextView(paramContext);
    setVisibility(4);
    setTextColor(-16777216);
    setTextSize(16);
  }
  
  private void calculateMiddle()
  {
    float f1;
    float f2;
    float f3;
    if (this.pdfView.isSwipeVertical())
    {
      f1 = getY();
      f2 = getHeight();
      f3 = this.pdfView.getHeight();
    }
    else
    {
      f1 = getX();
      f2 = getWidth();
      f3 = this.pdfView.getWidth();
    }
    this.relativeHandlerMiddle = ((f1 + this.relativeHandlerMiddle) / f3 * f2);
  }
  
  private boolean isPDFViewReady()
  {
    return (this.pdfView != null) && (this.pdfView.getPageCount() > 0) && (!this.pdfView.documentFitsView());
  }
  
  private void setPosition(float paramFloat)
  {
    if (!Float.isInfinite(paramFloat))
    {
      if (Float.isNaN(paramFloat)) {
        return;
      }
      float f1;
      if (this.pdfView.isSwipeVertical()) {
        f1 = this.pdfView.getHeight();
      } else {
        f1 = this.pdfView.getWidth();
      }
      float f2 = paramFloat - this.relativeHandlerMiddle;
      if (f2 < 0.0F)
      {
        paramFloat = 0.0F;
      }
      else
      {
        paramFloat = f2;
        if (f2 > f1 - Util.getDP(this.context, 40)) {
          paramFloat = f1 - Util.getDP(this.context, 40);
        }
      }
      if (this.pdfView.isSwipeVertical()) {
        setY(paramFloat);
      } else {
        setX(paramFloat);
      }
      calculateMiddle();
      invalidate();
      return;
    }
  }
  
  public void destroyLayout()
  {
    this.pdfView.removeView(this);
  }
  
  public void hide()
  {
    setVisibility(4);
  }
  
  public void hideDelayed()
  {
    this.handler.postDelayed(this.hidePageScrollerRunnable, 1000L);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isPDFViewReady()) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    case 4: 
    default: 
      return super.onTouchEvent(paramMotionEvent);
    case 1: 
    case 3: 
    case 6: 
      hideDelayed();
      return true;
    case 0: 
    case 5: 
      this.pdfView.stopFling();
      this.handler.removeCallbacks(this.hidePageScrollerRunnable);
      if (this.pdfView.isSwipeVertical()) {
        this.currentPos = (paramMotionEvent.getRawY() - getY());
      } else {
        this.currentPos = (paramMotionEvent.getRawX() - getX());
      }
      break;
    }
    if (this.pdfView.isSwipeVertical())
    {
      setPosition(paramMotionEvent.getRawY() - this.currentPos + this.relativeHandlerMiddle);
      this.pdfView.setPositionOffset(this.relativeHandlerMiddle / getHeight(), false);
      return true;
    }
    setPosition(paramMotionEvent.getRawX() - this.currentPos + this.relativeHandlerMiddle);
    this.pdfView.setPositionOffset(this.relativeHandlerMiddle / getWidth(), false);
    return true;
  }
  
  public void setPageNum(int paramInt)
  {
    String str = String.valueOf(paramInt);
    if (!this.textView.getText().equals(str)) {
      this.textView.setText(str);
    }
  }
  
  public void setScroll(float paramFloat)
  {
    if (!shown()) {
      show();
    } else {
      this.handler.removeCallbacks(this.hidePageScrollerRunnable);
    }
    int i;
    if (this.pdfView.isSwipeVertical()) {
      i = this.pdfView.getHeight();
    } else {
      i = this.pdfView.getWidth();
    }
    setPosition(i * paramFloat);
  }
  
  public void setTextColor(int paramInt)
  {
    this.textView.setTextColor(paramInt);
  }
  
  public void setTextSize(int paramInt)
  {
    this.textView.setTextSize(1, paramInt);
  }
  
  public void setupLayout(PDFView paramPDFView)
  {
    boolean bool = paramPDFView.isSwipeVertical();
    int j = 40;
    int k = 65;
    int i;
    if (bool)
    {
      if (this.inverted) {
        i = 9;
      }
      for (localObject = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_left);; localObject = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_right))
      {
        j = 65;
        k = 40;
        break;
        i = 11;
      }
    }
    if (this.inverted)
    {
      i = 10;
      localObject = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_top);
    }
    else
    {
      i = 12;
      localObject = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_bottom);
    }
    if (Build.VERSION.SDK_INT < 16) {
      setBackgroundDrawable((Drawable)localObject);
    } else {
      setBackground((Drawable)localObject);
    }
    Object localObject = new RelativeLayout.LayoutParams(Util.getDP(this.context, j), Util.getDP(this.context, k));
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    addView(this.textView, localLayoutParams);
    ((RelativeLayout.LayoutParams)localObject).addRule(i);
    paramPDFView.addView(this, (ViewGroup.LayoutParams)localObject);
    this.pdfView = paramPDFView;
  }
  
  public void show()
  {
    setVisibility(0);
  }
  
  public boolean shown()
  {
    return getVisibility() == 0;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\scroll\DefaultScrollHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */