package com.totoro.school.view.calendar.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.totoro.school.R.styleable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class d
{
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private boolean I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private int R;
  private int S;
  private int T;
  private int U;
  private int V;
  private int W;
  private int X;
  private int Y;
  private int Z;
  boolean a;
  private boolean aA;
  private boolean aB;
  private boolean aC;
  private int aD;
  private int aE;
  private int aF;
  private int aa;
  private int ab;
  private int ac;
  private int ad;
  private int ae;
  private String af;
  private Class<?> ag;
  private String ah;
  private Class<?> ai;
  private String aj;
  private Class<?> ak;
  private String al;
  private Class<?> am;
  private String an;
  private int ao;
  private int ap;
  private int aq;
  private int ar;
  private int as;
  private int at;
  private int au;
  private int av;
  private int aw;
  private boolean ax;
  private int ay;
  private b az;
  int b;
  Map<String, b> c;
  CalendarView.a d;
  CalendarView.e e;
  CalendarView.d f;
  CalendarView.c g;
  CalendarView.b h;
  CalendarView.f i;
  CalendarView.j j;
  CalendarView.g k;
  CalendarView.i l;
  CalendarView.h m;
  CalendarView.k n;
  b o;
  b p;
  Map<String, b> q = new HashMap();
  b r;
  b s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  d(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CalendarView);
    e.a(paramContext);
    this.J = ((int)paramAttributeSet.getDimension(2, 0.0F));
    this.A = paramAttributeSet.getColor(27, -1);
    this.B = paramAttributeSet.getColor(24, -1973791);
    this.ad = paramAttributeSet.getColor(28, 1355796431);
    this.af = paramAttributeSet.getString(18);
    this.aj = paramAttributeSet.getString(43);
    this.ah = paramAttributeSet.getString(41);
    this.al = paramAttributeSet.getString(35);
    this.ac = paramAttributeSet.getDimensionPixelSize(40, c.a(paramContext, 12.0F));
    this.ay = ((int)paramAttributeSet.getDimension(34, c.a(paramContext, 40.0F)));
    this.ab = ((int)paramAttributeSet.getDimension(37, c.a(paramContext, 0.0F)));
    this.an = paramAttributeSet.getString(26);
    if (TextUtils.isEmpty(this.an)) {
      this.an = "记";
    }
    this.aA = paramAttributeSet.getBoolean(20, true);
    this.aB = paramAttributeSet.getBoolean(42, true);
    this.aC = paramAttributeSet.getBoolean(55, true);
    this.t = paramAttributeSet.getInt(19, 0);
    this.v = paramAttributeSet.getInt(21, 0);
    this.u = paramAttributeSet.getInt(38, 1);
    this.w = paramAttributeSet.getInt(29, 0);
    this.aD = paramAttributeSet.getInt(9, Integer.MAX_VALUE);
    this.aE = paramAttributeSet.getInt(14, -1);
    this.aF = paramAttributeSet.getInt(10, -1);
    a(this.aE, this.aF);
    this.aa = paramAttributeSet.getColor(33, -1);
    this.Y = paramAttributeSet.getColor(36, 0);
    this.Z = paramAttributeSet.getColor(44, -1);
    this.z = paramAttributeSet.getColor(39, -13421773);
    this.x = paramAttributeSet.getColor(4, -65536);
    this.y = paramAttributeSet.getColor(3, -65536);
    this.ae = paramAttributeSet.getColor(32, 1355796431);
    this.E = paramAttributeSet.getColor(31, -15658735);
    this.F = paramAttributeSet.getColor(30, -15658735);
    this.D = paramAttributeSet.getColor(6, -15658735);
    this.C = paramAttributeSet.getColor(23, -1973791);
    this.G = paramAttributeSet.getColor(5, -1973791);
    this.H = paramAttributeSet.getColor(22, -1973791);
    this.ao = paramAttributeSet.getInt(15, 1971);
    this.ap = paramAttributeSet.getInt(11, 2055);
    this.aq = paramAttributeSet.getInt(17, 1);
    this.ar = paramAttributeSet.getInt(13, 12);
    this.as = paramAttributeSet.getInt(16, 1);
    this.at = paramAttributeSet.getInt(12, -1);
    this.au = paramAttributeSet.getDimensionPixelSize(7, c.a(paramContext, 16.0F));
    this.av = paramAttributeSet.getDimensionPixelSize(8, c.a(paramContext, 10.0F));
    this.aw = ((int)paramAttributeSet.getDimension(0, c.a(paramContext, 56.0F)));
    this.ax = paramAttributeSet.getBoolean(1, false);
    this.K = paramAttributeSet.getDimensionPixelSize(52, c.a(paramContext, 18.0F));
    this.L = paramAttributeSet.getDimensionPixelSize(47, c.a(paramContext, 7.0F));
    this.S = paramAttributeSet.getColor(51, -15658735);
    this.T = paramAttributeSet.getColor(46, -15658735);
    this.U = paramAttributeSet.getColor(54, this.ad);
    this.X = paramAttributeSet.getColor(58, -13421773);
    this.W = paramAttributeSet.getColor(45, this.x);
    this.V = paramAttributeSet.getColor(56, -13421773);
    this.M = paramAttributeSet.getDimensionPixelSize(59, c.a(paramContext, 8.0F));
    this.N = paramAttributeSet.getDimensionPixelSize(48, c.a(paramContext, 32.0F));
    this.O = paramAttributeSet.getDimensionPixelSize(57, c.a(paramContext, 0.0F));
    this.P = ((int)paramAttributeSet.getDimension(53, c.a(paramContext, 6.0F)));
    this.Q = ((int)paramAttributeSet.getDimension(50, c.a(paramContext, 4.0F)));
    this.R = ((int)paramAttributeSet.getDimension(49, c.a(paramContext, 4.0F)));
    if (this.ao <= 1900) {
      this.ao = 1900;
    }
    if (this.ap >= 2099) {
      this.ap = 2099;
    }
    paramAttributeSet.recycle();
    aq();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ao = paramInt1;
    this.aq = paramInt2;
    this.ap = paramInt3;
    this.ar = paramInt4;
    if (this.ap < this.az.getYear()) {
      this.ap = this.az.getYear();
    }
    if (this.at == -1) {
      this.at = c.a(this.ap, this.ar);
    }
    this.b = ((this.az.getYear() - this.ao) * 12 + this.az.getMonth() - this.aq);
  }
  
  private void aq()
  {
    this.az = new b();
    Object localObject = new Date();
    this.az.setYear(c.a("yyyy", (Date)localObject));
    this.az.setMonth(c.a("MM", (Date)localObject));
    this.az.setDay(c.a("dd", (Date)localObject));
    this.az.setCurrentDay(true);
    e.a(this.az);
    a(this.ao, this.aq, this.ap, this.ar);
    try
    {
      if (TextUtils.isEmpty(this.al))
      {
        localObject = WeekBar.class;
        this.am = WeekBar.class;
      }
      else
      {
        localObject = Class.forName(this.al);
      }
      this.am = ((Class)localObject);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      Class localClass1;
      if (TextUtils.isEmpty(this.aj))
      {
        localClass1 = DefaultYearView.class;
        this.ak = DefaultYearView.class;
      }
      else
      {
        localClass1 = Class.forName(this.aj);
      }
      this.ak = localClass1;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    try
    {
      Class localClass2;
      if (TextUtils.isEmpty(this.af)) {
        localClass2 = DefaultMonthView.class;
      } else {
        localClass2 = Class.forName(this.af);
      }
      this.ag = localClass2;
    }
    catch (Exception localException3)
    {
      localException3.printStackTrace();
    }
    try
    {
      Class localClass3;
      if (TextUtils.isEmpty(this.ah)) {
        localClass3 = DefaultWeekView.class;
      } else {
        localClass3 = Class.forName(this.ah);
      }
      this.ai = localClass3;
      return;
    }
    catch (Exception localException4)
    {
      localException4.printStackTrace();
    }
  }
  
  int A()
  {
    return this.au;
  }
  
  int B()
  {
    return this.av;
  }
  
  int C()
  {
    return this.aw;
  }
  
  int D()
  {
    return this.aq;
  }
  
  int E()
  {
    return this.ar;
  }
  
  int F()
  {
    return this.K;
  }
  
  int G()
  {
    return this.S;
  }
  
  int H()
  {
    return this.M;
  }
  
  int I()
  {
    return this.X;
  }
  
  int J()
  {
    return this.V;
  }
  
  int K()
  {
    return this.W;
  }
  
  int L()
  {
    return this.P;
  }
  
  int M()
  {
    return this.Q;
  }
  
  int N()
  {
    return this.R;
  }
  
  int O()
  {
    return this.O;
  }
  
  int P()
  {
    return this.N;
  }
  
  int Q()
  {
    return this.T;
  }
  
  int R()
  {
    return this.L;
  }
  
  int S()
  {
    return this.U;
  }
  
  int T()
  {
    return this.v;
  }
  
  boolean U()
  {
    return this.aA;
  }
  
  boolean V()
  {
    return this.aB;
  }
  
  boolean W()
  {
    return this.aC;
  }
  
  int X()
  {
    return this.u;
  }
  
  int Y()
  {
    return this.t;
  }
  
  int Z()
  {
    return this.ac;
  }
  
  String a()
  {
    return this.an;
  }
  
  void a(int paramInt)
  {
    this.aw = paramInt;
  }
  
  final void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > paramInt2) && (paramInt2 > 0))
    {
      this.aF = paramInt1;
      this.aE = paramInt1;
      return;
    }
    if (paramInt1 <= 0) {
      this.aE = -1;
    } else {
      this.aE = paramInt1;
    }
    if (paramInt2 <= 0)
    {
      this.aF = -1;
      return;
    }
    this.aF = paramInt2;
  }
  
  final void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    if (this.c != null)
    {
      if (this.c.size() == 0) {
        return;
      }
      String str = paramb.toString();
      if (this.c.containsKey(str)) {
        paramb.mergeScheme((b)this.c.get(str), a());
      }
      return;
    }
  }
  
  void a(Class<?> paramClass)
  {
    this.ag = paramClass;
  }
  
  final void a(List<b> paramList)
  {
    if (this.c != null)
    {
      if (this.c.size() == 0) {
        return;
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        b localb1 = (b)localIterator.next();
        if (this.c.containsKey(localb1.toString()))
        {
          b localb2 = (b)this.c.get(localb1.toString());
          if (localb2 != null)
          {
            if (TextUtils.isEmpty(localb2.getScheme())) {
              paramList = a();
            } else {
              paramList = localb2.getScheme();
            }
            localb1.setScheme(paramList);
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
  
  void a(boolean paramBoolean)
  {
    this.aA = paramBoolean;
  }
  
  int aa()
  {
    return this.w;
  }
  
  int ab()
  {
    return this.aE;
  }
  
  int ac()
  {
    return this.aF;
  }
  
  int ad()
  {
    return this.aD;
  }
  
  b ae()
  {
    return this.az;
  }
  
  int af()
  {
    return this.J;
  }
  
  boolean ag()
  {
    return this.I;
  }
  
  void ah()
  {
    this.o.clearScheme();
  }
  
  int ai()
  {
    return this.as;
  }
  
  int aj()
  {
    return this.at;
  }
  
  boolean ak()
  {
    return this.ax;
  }
  
  final void al()
  {
    if ((this.c != null) && (this.c.size() > 0))
    {
      Object localObject = this.o.toString();
      if (this.c.containsKey(localObject))
      {
        localObject = (b)this.c.get(localObject);
        this.o.mergeScheme((b)localObject, a());
      }
    }
    else
    {
      ah();
    }
  }
  
  b am()
  {
    b localb = new b();
    localb.setYear(this.az.getYear());
    localb.setWeek(this.az.getWeek());
    localb.setMonth(this.az.getMonth());
    localb.setDay(this.az.getDay());
    localb.setCurrentDay(true);
    e.a(localb);
    return localb;
  }
  
  final b an()
  {
    b localb = new b();
    localb.setYear(this.ao);
    localb.setMonth(this.aq);
    localb.setDay(this.as);
    localb.setCurrentDay(localb.equals(this.az));
    e.a(localb);
    return localb;
  }
  
  final b ao()
  {
    b localb = new b();
    localb.setYear(this.ap);
    localb.setMonth(this.ar);
    localb.setDay(this.at);
    localb.setCurrentDay(localb.equals(this.az));
    e.a(localb);
    return localb;
  }
  
  final List<b> ap()
  {
    if (this.w != 2) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (this.r != null)
    {
      if (this.s == null) {
        return localArrayList;
      }
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(this.r.getYear(), this.r.getMonth() - 1, this.r.getDay());
      long l1 = localCalendar.getTimeInMillis();
      localCalendar.set(this.s.getYear(), this.s.getMonth() - 1, this.s.getDay());
      long l2 = localCalendar.getTimeInMillis();
      while (l1 <= l2)
      {
        localCalendar.setTimeInMillis(l1);
        b localb = new b();
        localb.setYear(localCalendar.get(1));
        localb.setMonth(localCalendar.get(2) + 1);
        localb.setDay(localCalendar.get(5));
        e.a(localb);
        a(localb);
        if ((this.d == null) || (!this.d.a(localb))) {
          localArrayList.add(localb);
        }
        l1 += 86400000L;
      }
      a(localArrayList);
      return localArrayList;
    }
    return localArrayList;
  }
  
  int b()
  {
    return this.x;
  }
  
  void b(int paramInt)
  {
    this.v = paramInt;
  }
  
  void b(Class<?> paramClass)
  {
    this.am = paramClass;
  }
  
  void b(boolean paramBoolean)
  {
    this.aB = paramBoolean;
  }
  
  int c()
  {
    return this.y;
  }
  
  void c(int paramInt)
  {
    this.u = paramInt;
  }
  
  void c(Class<?> paramClass)
  {
    this.ai = paramClass;
  }
  
  void c(boolean paramBoolean)
  {
    this.aC = paramBoolean;
  }
  
  int d()
  {
    return this.z;
  }
  
  void d(int paramInt)
  {
    this.aD = paramInt;
  }
  
  int e()
  {
    return this.A;
  }
  
  int f()
  {
    return this.B;
  }
  
  int g()
  {
    return this.C;
  }
  
  int h()
  {
    return this.D;
  }
  
  int i()
  {
    return this.E;
  }
  
  int j()
  {
    return this.F;
  }
  
  int k()
  {
    return this.G;
  }
  
  int l()
  {
    return this.H;
  }
  
  int m()
  {
    return this.ad;
  }
  
  int n()
  {
    return this.ae;
  }
  
  int o()
  {
    return this.aa;
  }
  
  int p()
  {
    return this.Z;
  }
  
  int q()
  {
    return this.Y;
  }
  
  int r()
  {
    return this.ab;
  }
  
  Class<?> s()
  {
    return this.ag;
  }
  
  Class<?> t()
  {
    return this.ai;
  }
  
  Class<?> u()
  {
    return this.am;
  }
  
  Class<?> v()
  {
    return this.ak;
  }
  
  String w()
  {
    return this.aj;
  }
  
  int x()
  {
    return this.ay;
  }
  
  int y()
  {
    return this.ao;
  }
  
  int z()
  {
    return this.ap;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */