package com.totoro.school.view.wheelview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.totoro.school.R.styleable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WheelView
  extends View
{
  int A;
  int B;
  int C;
  int D;
  int E;
  int F;
  long G = 0L;
  private float H = 1.0F;
  private int I = 0;
  private int J = 0;
  private float K;
  private float L;
  private int M;
  private int N;
  private int O = 354;
  private GestureDetector P;
  private ScheduledFuture<?> Q;
  private int R;
  private int S = 0;
  private float T;
  private Rect U = new Rect();
  public int a = -1;
  public float b;
  public float c;
  Context d;
  Handler e;
  b f;
  ScheduledExecutorService g = Executors.newSingleThreadScheduledExecutor();
  Paint h;
  Paint i;
  Paint j;
  List<String> k;
  int l = 7;
  float m = 18.0F;
  float n = 13.0F;
  int o = -4473925;
  int p = -11711155;
  int q = -1644826;
  boolean r = false;
  float s;
  int t;
  int u;
  int v;
  int w;
  int x;
  int y = 0;
  int z = -1;
  
  public WheelView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt)
  {
    if (paramInt < 3) {
      return 3;
    }
    if (paramInt % 2 == 0) {
      return paramInt + 1;
    }
    return paramInt;
  }
  
  private int a(String paramString, Paint paramPaint, Rect paramRect)
  {
    paramPaint.getTextBounds(paramString, 0, paramString.length(), paramRect);
    paramRect.width();
    int i1 = (int)((int)paramPaint.measureText(paramString) * this.H);
    if (this.O == 894) {
      return this.t / 2 - i1 / 2 + (this.D - this.t);
    }
    if (this.O == 234) {
      return this.t / 2 - i1 / 2;
    }
    return (this.D - i1) / 2;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    if (this.k == null) {
      return;
    }
    e();
    this.E = ((int)(this.c * (this.l - 1)));
    double d1 = this.E * 2;
    Double.isNaN(d1);
    this.C = ((int)(d1 / 3.141592653589793D));
    this.C = ((int)(this.c + this.b * (this.l - 1) + this.s * 2.0F));
    d1 = this.E;
    Double.isNaN(d1);
    this.F = ((int)(d1 / 3.141592653589793D));
    this.D = this.t;
    if (paramInt1 == 1073741824) {
      this.D = paramInt2;
    }
    this.w = ((int)(this.b * (this.l - 1) / 2.0F));
    this.x = ((int)(this.b * (this.l - 1) / 2.0F + this.c));
    if (this.z == -1) {
      if (this.r) {
        this.z = ((this.k.size() + 1) / 2);
      } else {
        this.z = 0;
      }
    }
    this.K = ((this.k.size() - 1 - this.z) * this.b);
    this.L = (-this.z * this.b);
    this.A = this.z;
  }
  
  private void a(Context paramContext)
  {
    this.d = paramContext;
    this.e = new c(this);
    this.P = new GestureDetector(paramContext, new f(this));
    this.P.setIsLongpressEnabled(false);
    d();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WheelView);
    this.q = paramAttributeSet.getColor(2, this.q);
    this.l = a(paramAttributeSet.getInt(1, this.l));
    this.r = paramAttributeSet.getBoolean(0, this.r);
    this.p = paramAttributeSet.getColor(4, this.p);
    this.o = paramAttributeSet.getColor(5, this.o);
    this.m = paramAttributeSet.getDimension(6, a.a(paramContext, 18.0F));
    this.n = paramAttributeSet.getDimension(7, a.a(paramContext, 13.0F));
    this.s = paramAttributeSet.getDimension(3, a.a(paramContext, 6.0F));
    this.O = paramAttributeSet.getInt(8, this.O);
    paramAttributeSet.recycle();
    a(paramContext);
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    if (this.y >= 0)
    {
      if (paramInt1 <= (this.l - 1) / 2 + 1) {
        return (int)(this.b * paramInt1 - this.b - paramInt2);
      }
      if (paramInt1 == (this.l - 1) / 2 + 2) {
        return (int)(this.b * (this.l - 1) / 2.0F + this.c - paramInt2 * this.c / this.b);
      }
      return (int)(this.b * paramInt1 - this.b - paramInt2 + (this.c - this.b));
    }
    if (paramInt1 < (this.l - 1) / 2 + 1) {
      return (int)(this.b * paramInt1 - this.b - paramInt2);
    }
    if (paramInt1 == (this.l - 1) / 2 + 1) {
      return (int)(this.b * ((this.l - 1) / 2 + 1) - this.b - paramInt2 * this.c / this.b);
    }
    return (int)(this.b * paramInt1 - this.b - paramInt2 + (this.c - this.b));
  }
  
  private void d()
  {
    this.h = new Paint();
    this.h.setColor(this.o);
    this.h.setAntiAlias(true);
    this.h.setTypeface(Typeface.MONOSPACE);
    this.h.setTextSize(this.n);
    this.i = new Paint();
    this.i.setColor(this.p);
    this.i.setAntiAlias(true);
    this.i.setTypeface(Typeface.MONOSPACE);
    this.i.setTextSize(this.m);
    this.j = new Paint();
    this.j.setColor(this.q);
    this.j.setAntiAlias(true);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
  }
  
  private void e()
  {
    int i1 = 0;
    while (i1 < this.k.size())
    {
      localObject = (String)this.k.get(i1);
      this.i.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.U);
      int i2 = (int)this.i.measureText((String)localObject);
      if (i2 > this.t) {
        this.t = ((int)(i2 * this.H));
      }
      i1 += 1;
    }
    this.i.getTextBounds("星期", 0, 2, this.U);
    this.u = this.U.height();
    this.h.getTextBounds("星期", 0, 2, this.U);
    this.v = this.U.height();
    this.b = (this.v + this.s * 2.0F);
    this.c = (this.u + this.s * 2.0F);
    Object localObject = this.h.getFontMetricsInt();
    this.M = ((int)((this.b - ((Paint.FontMetricsInt)localObject).bottom + ((Paint.FontMetricsInt)localObject).top) / 2.0F - ((Paint.FontMetricsInt)localObject).top));
    localObject = this.i.getFontMetricsInt();
    this.N = ((int)((this.c - ((Paint.FontMetricsInt)localObject).bottom + ((Paint.FontMetricsInt)localObject).top) / 2.0F - ((Paint.FontMetricsInt)localObject).top));
  }
  
  private final void setInitPosition(int paramInt)
  {
    if (paramInt < 0) {
      this.z = 0;
    } else {
      this.z = paramInt;
    }
    this.a = paramInt;
    this.R = paramInt;
  }
  
  private final void setItems(List<String> paramList)
  {
    a();
    if (paramList == null) {
      this.k = Arrays.asList(new String[] { "--" });
    } else {
      this.k = paramList;
    }
    a(this.I, this.J);
    invalidate();
  }
  
  public void a()
  {
    this.y = 0;
  }
  
  protected final void a(float paramFloat)
  {
    b();
    this.Q = this.g.scheduleWithFixedDelay(new b(this, paramFloat), 0L, 15, TimeUnit.MILLISECONDS);
    Log.i("wangpeiming", "scrollBy: ");
  }
  
  void a(a parama)
  {
    b();
    if ((parama == a.FLING) || (parama == a.DAGGLE))
    {
      this.S = ((int)((this.y % this.b + this.b) % this.b));
      if (this.S > this.b / 2.0F) {
        this.S = ((int)(this.b - this.S));
      } else {
        this.S = (-this.S);
      }
    }
    this.Q = this.g.scheduleWithFixedDelay(new e(this, this.S), 0L, 10L, TimeUnit.MILLISECONDS);
    Log.i("wangpeiming", "smoothScroll: ");
  }
  
  public final void a(List<String> paramList, int paramInt)
  {
    setInitPosition(paramInt);
    setItems(paramList);
  }
  
  public void b()
  {
    if ((this.Q != null) && (!this.Q.isCancelled()))
    {
      this.Q.cancel(true);
      this.Q = null;
    }
  }
  
  protected final void c()
  {
    if (this.f != null) {
      postDelayed(new d(this), 200L);
    }
  }
  
  public List<String> getItems()
  {
    return this.k;
  }
  
  public b getOnItemSelectedListener()
  {
    return this.f;
  }
  
  public final String getSelectedItem()
  {
    if ((this.R < this.k.size()) && (this.R >= 0)) {
      return (String)this.k.get(this.R);
    }
    return "";
  }
  
  public final int getSelectedPosition()
  {
    return this.R;
  }
  
  public int getSize()
  {
    return this.k.size();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.k != null)
    {
      if (this.k.size() == 0) {
        return;
      }
      paramCanvas.translate(0.0F, this.s);
      paramCanvas.clipRect(0.0F, 0.0F, this.D, this.C - this.s * 2.0F);
      paramCanvas.save();
      this.B = ((int)(this.y / this.b));
      this.A = (this.z + this.B % this.k.size());
      if (!this.r)
      {
        if (this.A < 0) {
          this.A = 0;
        }
        if (this.A > this.k.size() - 1) {
          this.A = (this.k.size() - 1);
        }
      }
      else
      {
        if (this.A < 0) {
          this.A = (this.k.size() + this.A);
        }
        if (this.A > this.k.size() - 1) {
          this.A -= this.k.size();
        }
      }
      int i6 = (int)(this.y % this.b);
      paramCanvas.drawLine(0.0F, this.w, this.D, this.w, this.j);
      paramCanvas.drawLine(0.0F, this.x, this.D, this.x, this.j);
      int i3 = b(0, i6);
      int i1 = b(1, i6);
      int i2 = 0;
      for (;;)
      {
        int i4 = i1;
        if (i2 >= this.l + 2) {
          break;
        }
        i1 = this.A - (this.l / 2 - i2) - 1;
        String str;
        if (this.r)
        {
          int i5 = i1 % this.k.size();
          i1 = i5;
          if (i5 < 0) {
            i1 = i5 + this.k.size();
          }
          str = (String)this.k.get(i1);
        }
        else if (i1 < 0)
        {
          str = "";
        }
        else if (i1 > this.k.size() - 1)
        {
          str = "";
        }
        else
        {
          str = (String)this.k.get(i1);
        }
        paramCanvas.save();
        paramCanvas.translate(0.0F, i3);
        if ((i3 < this.w) && (i4 > this.w))
        {
          paramCanvas.save();
          paramCanvas.clipRect(0, 0, this.D, this.w - i3);
          paramCanvas.drawText(str, a(str, this.h, this.U), this.M, this.h);
          paramCanvas.restore();
          paramCanvas.save();
          paramCanvas.clipRect(0, this.w - i3, this.D, (int)this.c);
          paramCanvas.drawText(str, a(str, this.i, this.U), this.N, this.i);
          paramCanvas.restore();
        }
        else if ((i3 < this.x) && (i4 > this.x))
        {
          paramCanvas.save();
          paramCanvas.clipRect(0, 0, this.D, this.x - i3);
          paramCanvas.drawText(str, a(str, this.i, this.U), this.N, this.i);
          paramCanvas.restore();
          paramCanvas.save();
          paramCanvas.clipRect(0, this.x - i3, this.D, (int)this.c);
          paramCanvas.drawText(str, a(str, this.h, this.U), this.M + (i4 - i3) - this.b, this.h);
          paramCanvas.restore();
        }
        else if ((i3 >= this.w) && (i4 <= this.x))
        {
          paramCanvas.clipRect(0, 0, this.D, (int)this.c);
          paramCanvas.drawText(str, a(str, this.i, this.U), this.N, this.i);
        }
        else
        {
          paramCanvas.clipRect(0, 0, this.D, (int)this.b);
          paramCanvas.drawText(str, a(str, this.h, this.U), this.M, this.h);
        }
        if (((i3 >= this.w) && (i3 < (this.w + this.x) / 2)) || ((i4 > (this.w + this.x) / 2) && (i4 <= this.x))) {
          this.R = i1;
        }
        paramCanvas.restore();
        i2 += 1;
        i1 = b(i2 + 1, i6);
        i3 = i4;
      }
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.I = paramInt1;
    this.J = paramInt2;
    a(paramInt1, paramInt2);
    setMeasuredDimension(this.D, this.C);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.P.onTouchEvent(paramMotionEvent);
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      float f1;
      float f2;
      if (i1 != 2)
      {
        if (!bool)
        {
          f1 = paramMotionEvent.getY();
          double d1 = Math.acos((this.F - f1) / this.F);
          double d2 = this.F;
          Double.isNaN(d2);
          double d3 = this.c / 2.0F;
          Double.isNaN(d3);
          double d4 = this.c;
          Double.isNaN(d4);
          i1 = (int)((d1 * d2 + d3) / d4);
          f2 = (this.y % this.b + this.b) % this.b;
          this.S = ((int)((i1 - this.l / 2) * this.c - f2));
          if (f1 <= this.w)
          {
            i1 = (int)(f1 / this.b);
          }
          else if (f1 >= this.x)
          {
            int i2 = (int)((int)(f1 - this.c) / this.b + 1.0F);
            i1 = i2;
            if (i2 > this.l - 1) {
              i1 = this.l - 1;
            }
          }
          else
          {
            i1 = this.l / 2;
          }
          this.S = ((int)((i1 - this.l / 2) * this.b - f2));
          if (!this.r)
          {
            if (this.y + this.S > this.K) {
              this.S = ((int)(this.K - this.y));
            }
            if (this.y + this.S < this.L) {
              this.S = ((int)(this.L - this.y));
            }
          }
          if (System.currentTimeMillis() - this.G > 120L) {
            a(a.DAGGLE);
          } else {
            a(a.CLICK);
          }
        }
      }
      else
      {
        f1 = this.T;
        f2 = paramMotionEvent.getRawY();
        this.T = paramMotionEvent.getRawY();
        this.y = ((int)(this.y + (f1 - f2)));
        if (!this.r) {
          if (this.y < this.L) {
            this.y = ((int)this.L);
          } else if (this.y > this.K) {
            this.y = ((int)this.K);
          }
        }
      }
    }
    else
    {
      this.G = System.currentTimeMillis();
      b();
      this.T = paramMotionEvent.getRawY();
    }
    invalidate();
    return true;
  }
  
  public final void setIsLoop(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public final void setOnItemSelectedListener(b paramb)
  {
    this.f = paramb;
  }
  
  public void setWheelGravity(int paramInt)
  {
    this.O = paramInt;
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, String paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\wheelview\WheelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */