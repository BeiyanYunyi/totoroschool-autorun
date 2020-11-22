package com.totoro.school.view.calendar.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class YearView
  extends View
{
  d a;
  protected Paint b = new Paint();
  protected Paint c = new Paint();
  protected Paint d = new Paint();
  protected Paint e = new Paint();
  protected Paint f = new Paint();
  protected Paint g = new Paint();
  protected Paint h = new Paint();
  protected Paint i = new Paint();
  protected Paint j = new Paint();
  protected Paint k = new Paint();
  protected Paint l = new Paint();
  protected Paint m = new Paint();
  protected Paint n = new Paint();
  protected Paint o = new Paint();
  List<b> p;
  protected int q;
  protected int r;
  protected float s;
  protected float t;
  protected float u;
  protected int v;
  protected int w;
  protected int x;
  protected int y;
  
  public YearView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public YearView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void a(Canvas paramCanvas)
  {
    a(paramCanvas, this.v, this.w, this.a.L(), this.a.M(), getWidth() - this.a.L() * 2, this.a.P() + this.a.M());
  }
  
  private void a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramInt2 * this.r + this.a.L();
    paramInt3 = paramInt1 * this.q + getMonthViewTop();
    boolean bool2 = paramb.equals(this.a.o);
    boolean bool3 = paramb.hasScheme();
    if (bool3)
    {
      boolean bool1 = false;
      if (bool2) {
        bool1 = a(paramCanvas, paramb, paramInt2, paramInt3, true);
      }
      if ((bool1) || (!bool2))
      {
        Paint localPaint = this.h;
        if (paramb.getSchemeColor() != 0) {
          paramInt1 = paramb.getSchemeColor();
        } else {
          paramInt1 = this.a.m();
        }
        localPaint.setColor(paramInt1);
        a(paramCanvas, paramb, paramInt2, paramInt3);
      }
    }
    else if (bool2)
    {
      a(paramCanvas, paramb, paramInt2, paramInt3, false);
    }
    a(paramCanvas, paramb, paramInt2, paramInt3, bool3, bool2);
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.a.O() <= 0) {
      return;
    }
    int i2 = this.a.X();
    int i1 = i2;
    if (i2 > 0) {
      i1 = i2 - 1;
    }
    int i4 = (getWidth() - this.a.L() * 2) / 7;
    i2 = 0;
    while (i2 < 7)
    {
      a(paramCanvas, i1, this.a.L() + i2 * i4, this.a.P() + this.a.M() + this.a.N(), i4, this.a.O());
      int i3 = i1 + 1;
      i1 = i3;
      if (i3 >= 7) {
        i1 = 0;
      }
      i2 += 1;
    }
  }
  
  private void c()
  {
    this.b.setAntiAlias(true);
    this.b.setTextAlign(Paint.Align.CENTER);
    this.b.setColor(-15658735);
    this.b.setFakeBoldText(true);
    this.c.setAntiAlias(true);
    this.c.setTextAlign(Paint.Align.CENTER);
    this.c.setColor(-1973791);
    this.c.setFakeBoldText(true);
    this.d.setAntiAlias(true);
    this.d.setTextAlign(Paint.Align.CENTER);
    this.e.setAntiAlias(true);
    this.e.setTextAlign(Paint.Align.CENTER);
    this.f.setAntiAlias(true);
    this.f.setTextAlign(Paint.Align.CENTER);
    this.n.setAntiAlias(true);
    this.n.setFakeBoldText(true);
    this.o.setAntiAlias(true);
    this.o.setFakeBoldText(true);
    this.o.setTextAlign(Paint.Align.CENTER);
    this.g.setAntiAlias(true);
    this.g.setTextAlign(Paint.Align.CENTER);
    this.j.setAntiAlias(true);
    this.j.setStyle(Paint.Style.FILL);
    this.j.setTextAlign(Paint.Align.CENTER);
    this.j.setColor(-1223853);
    this.j.setFakeBoldText(true);
    this.k.setAntiAlias(true);
    this.k.setStyle(Paint.Style.FILL);
    this.k.setTextAlign(Paint.Align.CENTER);
    this.k.setColor(-1223853);
    this.k.setFakeBoldText(true);
    this.h.setAntiAlias(true);
    this.h.setStyle(Paint.Style.FILL);
    this.h.setStrokeWidth(2.0F);
    this.h.setColor(-1052689);
    this.l.setAntiAlias(true);
    this.l.setTextAlign(Paint.Align.CENTER);
    this.l.setColor(-65536);
    this.l.setFakeBoldText(true);
    this.m.setAntiAlias(true);
    this.m.setTextAlign(Paint.Align.CENTER);
    this.m.setColor(-65536);
    this.m.setFakeBoldText(true);
    this.i.setAntiAlias(true);
    this.i.setStyle(Paint.Style.FILL);
    this.i.setStrokeWidth(2.0F);
  }
  
  private void c(Canvas paramCanvas)
  {
    int i1 = this.y;
    i1 = 0;
    int i2 = 0;
    while (i2 < this.y)
    {
      int i3 = 0;
      while (i3 < 7)
      {
        b localb = (b)this.p.get(i1);
        if (i1 > this.p.size() - this.x) {
          return;
        }
        if (!localb.isCurrentMonth())
        {
          i1 += 1;
        }
        else
        {
          a(paramCanvas, localb, i2, i3, i1);
          i1 += 1;
        }
        i3 += 1;
      }
      i2 += 1;
    }
  }
  
  private void d()
  {
    if (this.a.c != null)
    {
      if (this.a.c.size() == 0) {
        return;
      }
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        b localb1 = (b)localIterator.next();
        if (this.a.c.containsKey(localb1.toString()))
        {
          b localb2 = (b)this.a.c.get(localb1.toString());
          if (localb2 != null)
          {
            String str;
            if (TextUtils.isEmpty(localb2.getScheme())) {
              str = this.a.a();
            } else {
              str = localb2.getScheme();
            }
            localb1.setScheme(str);
            localb1.setSchemeColor(localb2.getSchemeColor());
            localb1.setSchemes(localb2.getSchemes());
          }
        }
        else
        {
          localb1.setScheme("");
          localb1.setSchemeColor(0);
          localb1.setSchemes(null);
        }
      }
      return;
    }
  }
  
  private int getMonthViewTop()
  {
    return this.a.M() + this.a.P() + this.a.N() + this.a.O();
  }
  
  final void a()
  {
    if (this.a == null) {
      return;
    }
    this.b.setTextSize(this.a.R());
    this.j.setTextSize(this.a.R());
    this.c.setTextSize(this.a.R());
    this.l.setTextSize(this.a.R());
    this.k.setTextSize(this.a.R());
    this.j.setColor(this.a.S());
    this.b.setColor(this.a.Q());
    this.c.setColor(this.a.Q());
    this.l.setColor(this.a.K());
    this.k.setColor(this.a.J());
    this.n.setTextSize(this.a.F());
    this.n.setColor(this.a.G());
    this.o.setColor(this.a.I());
    this.o.setTextSize(this.a.H());
  }
  
  final void a(int paramInt1, int paramInt2)
  {
    this.v = paramInt1;
    this.w = paramInt2;
    this.x = c.b(this.v, this.w, this.a.X());
    c.a(this.v, this.w, this.a.X());
    this.p = c.a(this.v, this.w, this.a.ae(), this.a.X());
    this.y = 6;
    d();
  }
  
  protected abstract void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  protected abstract void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  protected abstract void a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2);
  
  protected abstract void a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  
  protected abstract boolean a(Canvas paramCanvas, b paramb, int paramInt1, int paramInt2, boolean paramBoolean);
  
  protected void b() {}
  
  final void b(int paramInt1, int paramInt2)
  {
    Object localObject = new Rect();
    this.b.getTextBounds("1", 0, 1, (Rect)localObject);
    int i1 = ((Rect)localObject).height() * 12 + getMonthViewTop();
    if (paramInt2 < i1) {
      paramInt2 = i1;
    }
    getLayoutParams().width = paramInt1;
    getLayoutParams().height = paramInt2;
    this.q = ((paramInt2 - getMonthViewTop()) / 6);
    localObject = this.b.getFontMetrics();
    this.s = (this.q / 2 - ((Paint.FontMetrics)localObject).descent + (((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) / 2.0F);
    localObject = this.n.getFontMetrics();
    this.t = (this.a.P() / 2 - ((Paint.FontMetrics)localObject).descent + (((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) / 2.0F);
    localObject = this.o.getFontMetrics();
    this.u = (this.a.O() / 2 - ((Paint.FontMetrics)localObject).descent + (((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) / 2.0F);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.r = ((getWidth() - this.a.L() * 2) / 7);
    b();
    a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
  }
  
  final void setup(d paramd)
  {
    this.a = paramd;
    a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\YearView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */