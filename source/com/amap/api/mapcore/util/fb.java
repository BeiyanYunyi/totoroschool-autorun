package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class fb
  extends ScrollView
{
  public static final String a = "fb";
  int b = 1;
  private Context c;
  private LinearLayout d;
  private int e = 0;
  private List<String> f;
  private int g = -1;
  private int h;
  private Bitmap i = null;
  private int j = Color.parseColor("#eeffffff");
  private int k = Color.parseColor("#44383838");
  private int l = 4;
  private int m = 1;
  private int n;
  private int o;
  private Runnable p;
  private int q = 50;
  private a r;
  
  public fb(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int a(View paramView)
  {
    b(paramView);
    return paramView.getMeasuredHeight();
  }
  
  private void a(int paramInt)
  {
    if (this.e == 0) {
      return;
    }
    int i1 = paramInt / this.e + this.m;
    int i2 = paramInt % this.e;
    int i3 = paramInt / this.e;
    if (i2 == 0)
    {
      paramInt = this.m + i3;
    }
    else
    {
      paramInt = i1;
      if (i2 > this.e / 2) {
        paramInt = i3 + this.m + 1;
      }
    }
    i2 = this.d.getChildCount();
    i1 = 0;
    while (i1 < i2)
    {
      TextView localTextView = (TextView)this.d.getChildAt(i1);
      if (localTextView == null) {
        return;
      }
      if (paramInt == i1) {
        localTextView.setTextColor(Color.parseColor("#0288ce"));
      } else {
        localTextView.setTextColor(Color.parseColor("#bbbbbb"));
      }
      i1 += 1;
    }
  }
  
  private void a(Context paramContext)
  {
    this.c = paramContext;
    setVerticalScrollBarEnabled(false);
    try
    {
      if (this.i == null)
      {
        InputStream localInputStream = dr.a(paramContext).open("map_indoor_select.png");
        this.i = BitmapFactory.decodeStream(localInputStream);
        localInputStream.close();
      }
      this.d = new LinearLayout(paramContext);
      this.d.setOrientation(1);
      addView(this.d);
      this.p = new Runnable()
      {
        public void run()
        {
          final int i = fb.this.getScrollY();
          if (fb.a(fb.this) - i == 0)
          {
            if (fb.b(fb.this) == 0) {
              return;
            }
            i = fb.a(fb.this) % fb.b(fb.this);
            final int j = fb.a(fb.this) / fb.b(fb.this);
            if (i == 0)
            {
              fb.this.b = (j + fb.c(fb.this));
              fb.d(fb.this);
              return;
            }
            if (i > fb.b(fb.this) / 2)
            {
              fb.this.post(new Runnable()
              {
                public void run()
                {
                  fb.this.smoothScrollTo(0, fb.a(fb.this) - i + fb.b(fb.this));
                  fb.this.b = (j + fb.c(fb.this) + 1);
                  fb.d(fb.this);
                }
              });
              return;
            }
            fb.this.post(new Runnable()
            {
              public void run()
              {
                fb.this.smoothScrollTo(0, fb.a(fb.this) - i);
                fb.this.b = (j + fb.c(fb.this));
                fb.d(fb.this);
              }
            });
            return;
          }
          fb.a(fb.this, fb.this.getScrollY());
          fb.this.postDelayed(fb.e(fb.this), fb.f(fb.this));
        }
      };
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  private TextView b(String paramString)
  {
    TextView localTextView = new TextView(this.c);
    localTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    localTextView.setSingleLine(true);
    localTextView.setTextSize(2, 16.0F);
    localTextView.setText(paramString);
    localTextView.setGravity(17);
    localTextView.getPaint().setFakeBoldText(true);
    int i1 = a(this.c, 8.0F);
    int i2 = a(this.c, 6.0F);
    localTextView.setPadding(i1, i2, i1, i2);
    if (this.e == 0)
    {
      this.e = a(localTextView);
      this.d.setLayoutParams(new FrameLayout.LayoutParams(-2, this.e * this.n));
      setLayoutParams(new LinearLayout.LayoutParams(-2, this.e * this.n));
    }
    return localTextView;
  }
  
  public static void b(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
  }
  
  private void e()
  {
    if (this.f != null)
    {
      if (this.f.size() == 0) {
        return;
      }
      this.d.removeAllViews();
      this.n = (this.m * 2 + 1);
      int i1 = this.f.size() - 1;
      while (i1 >= 0)
      {
        this.d.addView(b((String)this.f.get(i1)));
        i1 -= 1;
      }
      a(0);
      return;
    }
  }
  
  private int[] f()
  {
    return new int[] { this.e * this.m, this.e * (this.m + 1) };
  }
  
  private void g()
  {
    if (this.r != null) {}
    try
    {
      this.r.a(c());
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void a()
  {
    this.o = getScrollY();
    postDelayed(this.p, this.q);
  }
  
  public void a(a parama)
  {
    this.r = parama;
  }
  
  public void a(String paramString)
  {
    if (this.f != null)
    {
      if (this.f.size() == 0) {
        return;
      }
      final int i1 = this.f.indexOf(paramString);
      i1 = this.f.size() - this.m - 1 - i1;
      this.b = (this.m + i1);
      post(new Runnable()
      {
        public void run()
        {
          fb.this.smoothScrollTo(0, i1 * fb.b(fb.this));
        }
      });
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    setVisibility(i1);
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (this.f == null) {
      this.f = new ArrayList();
    }
    this.f.clear();
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      this.f.add(paramArrayOfString[i1]);
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.m)
    {
      this.f.add(0, "");
      this.f.add("");
      i1 += 1;
    }
    e();
  }
  
  public void b()
  {
    if ((this.i != null) && (!this.i.isRecycled()))
    {
      this.i.recycle();
      this.i = null;
    }
    if (this.r != null) {
      this.r = null;
    }
  }
  
  public int c()
  {
    if (this.f != null)
    {
      if (this.f.size() == 0) {
        return 0;
      }
      int i1 = this.f.size();
      int i2 = this.b;
      int i3 = this.m;
      return Math.min(this.f.size() - this.m * 2, Math.max(0, i1 - 1 - i2 - i3));
    }
    return 0;
  }
  
  public boolean d()
  {
    return getVisibility() == 0;
  }
  
  public void fling(int paramInt)
  {
    super.fling(paramInt / 3);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt2);
    if (paramInt2 > paramInt4)
    {
      this.g = 1;
      return;
    }
    this.g = 0;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = paramInt1;
    try
    {
      setBackgroundDrawable(null);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      a();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.h == 0) {
      try
      {
        paramDrawable = (WindowManager)this.c.getSystemService("window");
        if (paramDrawable != null) {
          this.h = paramDrawable.getDefaultDisplay().getWidth();
        }
      }
      catch (Throwable paramDrawable)
      {
        paramDrawable.printStackTrace();
      }
    }
    super.setBackgroundDrawable(new Drawable()
    {
      private void a(Canvas paramAnonymousCanvas)
      {
        paramAnonymousCanvas.drawColor(fb.g(fb.this));
      }
      
      private void b(Canvas paramAnonymousCanvas)
      {
        Paint localPaint = new Paint();
        Rect localRect1 = new Rect();
        Rect localRect2 = new Rect();
        localRect1.left = 0;
        localRect1.top = 0;
        localRect1.right = (fb.h(fb.this).getWidth() + 0);
        localRect1.bottom = (fb.h(fb.this).getHeight() + 0);
        localRect2.left = 0;
        localRect2.top = fb.i(fb.this)[0];
        localRect2.right = (fb.j(fb.this) + 0);
        localRect2.bottom = fb.i(fb.this)[1];
        paramAnonymousCanvas.drawBitmap(fb.h(fb.this), localRect1, localRect2, localPaint);
      }
      
      private void c(Canvas paramAnonymousCanvas)
      {
        Paint localPaint = new Paint();
        Rect localRect = paramAnonymousCanvas.getClipBounds();
        localPaint.setColor(fb.k(fb.this));
        localPaint.setStyle(Paint.Style.STROKE);
        localPaint.setStrokeWidth(fb.l(fb.this));
        paramAnonymousCanvas.drawRect(localRect, localPaint);
      }
      
      public void draw(Canvas paramAnonymousCanvas)
      {
        try
        {
          a(paramAnonymousCanvas);
          b(paramAnonymousCanvas);
          c(paramAnonymousCanvas);
          return;
        }
        catch (Throwable paramAnonymousCanvas) {}
      }
      
      public int getOpacity()
      {
        return 0;
      }
      
      public void setAlpha(int paramAnonymousInt) {}
      
      public void setColorFilter(ColorFilter paramAnonymousColorFilter) {}
    });
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */