package com.totoro.school.view.calendar.base;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseView
  extends View
  implements View.OnClickListener, View.OnLongClickListener
{
  boolean A = true;
  int B = -1;
  d g;
  protected Paint h = new Paint();
  protected Paint i = new Paint();
  protected Paint j = new Paint();
  protected Paint k = new Paint();
  protected Paint l = new Paint();
  protected Paint m = new Paint();
  protected Paint n = new Paint();
  protected Paint o = new Paint();
  protected Paint p = new Paint();
  protected Paint q = new Paint();
  protected Paint r = new Paint();
  protected Paint s = new Paint();
  CalendarLayout t;
  List<b> u;
  protected int v;
  protected int w;
  protected float x;
  float y;
  float z;
  
  public BaseView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.h.setAntiAlias(true);
    this.h.setTextAlign(Paint.Align.CENTER);
    this.h.setColor(-15658735);
    this.h.setFakeBoldText(true);
    this.h.setTextSize(c.a(paramContext, 14.0F));
    this.i.setAntiAlias(true);
    this.i.setTextAlign(Paint.Align.CENTER);
    this.i.setColor(-1973791);
    this.i.setFakeBoldText(true);
    this.i.setTextSize(c.a(paramContext, 14.0F));
    this.j.setAntiAlias(true);
    this.j.setTextAlign(Paint.Align.CENTER);
    this.k.setAntiAlias(true);
    this.k.setTextAlign(Paint.Align.CENTER);
    this.l.setAntiAlias(true);
    this.l.setTextAlign(Paint.Align.CENTER);
    this.m.setAntiAlias(true);
    this.m.setTextAlign(Paint.Align.CENTER);
    this.p.setAntiAlias(true);
    this.p.setStyle(Paint.Style.FILL);
    this.p.setTextAlign(Paint.Align.CENTER);
    this.p.setColor(-1223853);
    this.p.setFakeBoldText(true);
    this.p.setTextSize(c.a(paramContext, 14.0F));
    this.q.setAntiAlias(true);
    this.q.setStyle(Paint.Style.FILL);
    this.q.setTextAlign(Paint.Align.CENTER);
    this.q.setColor(-1223853);
    this.q.setFakeBoldText(true);
    this.q.setTextSize(c.a(paramContext, 14.0F));
    this.n.setAntiAlias(true);
    this.n.setStyle(Paint.Style.FILL);
    this.n.setStrokeWidth(2.0F);
    this.n.setColor(-1052689);
    this.r.setAntiAlias(true);
    this.r.setTextAlign(Paint.Align.CENTER);
    this.r.setColor(-65536);
    this.r.setFakeBoldText(true);
    this.r.setTextSize(c.a(paramContext, 14.0F));
    this.s.setAntiAlias(true);
    this.s.setTextAlign(Paint.Align.CENTER);
    this.s.setColor(-65536);
    this.s.setFakeBoldText(true);
    this.s.setTextSize(c.a(paramContext, 14.0F));
    this.o.setAntiAlias(true);
    this.o.setStyle(Paint.Style.FILL);
    this.o.setStrokeWidth(2.0F);
    setOnClickListener(this);
    setOnLongClickListener(this);
  }
  
  protected final boolean b(b paramb)
  {
    return (this.g.d != null) && (this.g.d.a(paramb));
  }
  
  void c()
  {
    this.v = this.g.C();
    Paint.FontMetrics localFontMetrics = this.h.getFontMetrics();
    this.x = (this.v / 2 - localFontMetrics.descent + (localFontMetrics.bottom - localFontMetrics.top) / 2.0F);
  }
  
  protected final boolean c(b paramb)
  {
    return (this.g != null) && (c.a(paramb, this.g));
  }
  
  protected void d() {}
  
  protected abstract void e();
  
  final void f()
  {
    if (this.g == null) {
      return;
    }
    this.r.setColor(this.g.b());
    this.s.setColor(this.g.c());
    this.h.setColor(this.g.h());
    this.i.setColor(this.g.g());
    this.j.setColor(this.g.k());
    this.k.setColor(this.g.j());
    this.q.setColor(this.g.i());
    this.l.setColor(this.g.l());
    this.m.setColor(this.g.f());
    this.n.setColor(this.g.m());
    this.p.setColor(this.g.e());
    this.h.setTextSize(this.g.A());
    this.i.setTextSize(this.g.A());
    this.r.setTextSize(this.g.A());
    this.p.setTextSize(this.g.A());
    this.q.setTextSize(this.g.A());
    this.j.setTextSize(this.g.B());
    this.k.setTextSize(this.g.B());
    this.s.setTextSize(this.g.B());
    this.l.setTextSize(this.g.B());
    this.m.setTextSize(this.g.B());
    this.o.setStyle(Paint.Style.FILL);
    this.o.setColor(this.g.n());
  }
  
  final void g()
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.setScheme("");
      localb.setSchemeColor(0);
      localb.setSchemes(null);
    }
  }
  
  final void h()
  {
    if (this.g.c != null)
    {
      if (this.g.c.size() == 0) {
        return;
      }
      Iterator localIterator = this.u.iterator();
      while (localIterator.hasNext())
      {
        b localb1 = (b)localIterator.next();
        if (this.g.c.containsKey(localb1.toString()))
        {
          b localb2 = (b)this.g.c.get(localb1.toString());
          if (localb2 != null)
          {
            String str;
            if (TextUtils.isEmpty(localb2.getScheme())) {
              str = this.g.a();
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
  
  final void i()
  {
    if ((this.g.c != null) && (this.g.c.size() != 0))
    {
      h();
      invalidate();
      return;
    }
    g();
    invalidate();
  }
  
  protected void j() {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getPointerCount();
    boolean bool = false;
    if (i1 > 1) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      break;
    case 2: 
      if (this.A)
      {
        if (Math.abs(paramMotionEvent.getY() - this.z) <= 50.0F) {
          bool = true;
        }
        this.A = bool;
      }
      break;
    case 1: 
      this.y = paramMotionEvent.getX();
      this.z = paramMotionEvent.getY();
      break;
    case 0: 
      this.y = paramMotionEvent.getX();
      this.z = paramMotionEvent.getY();
      this.A = true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  final void setup(d paramd)
  {
    this.g = paramd;
    f();
    c();
    j();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\BaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */