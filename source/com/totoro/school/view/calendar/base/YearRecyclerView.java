package com.totoro.school.view.calendar.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public final class YearRecyclerView
  extends RecyclerView
{
  private d a;
  private j b;
  private a c;
  
  public YearRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public YearRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = new j(paramContext);
    setLayoutManager(new GridLayoutManager(paramContext, 3));
    setAdapter(this.b);
    this.b.setOnItemClickListener(new a.b()
    {
      public void a(int paramAnonymousInt, long paramAnonymousLong)
      {
        if ((YearRecyclerView.a(YearRecyclerView.this) != null) && (YearRecyclerView.b(YearRecyclerView.this) != null))
        {
          g localg = (g)YearRecyclerView.c(YearRecyclerView.this).a(paramAnonymousInt);
          if (localg == null) {
            return;
          }
          if (!c.a(localg.getYear(), localg.getMonth(), YearRecyclerView.b(YearRecyclerView.this).y(), YearRecyclerView.b(YearRecyclerView.this).D(), YearRecyclerView.b(YearRecyclerView.this).z(), YearRecyclerView.b(YearRecyclerView.this).E())) {
            return;
          }
          YearRecyclerView.a(YearRecyclerView.this).a(localg.getYear(), localg.getMonth());
          if (YearRecyclerView.b(YearRecyclerView.this).n != null) {
            YearRecyclerView.b(YearRecyclerView.this).n.a(true);
          }
        }
      }
    });
  }
  
  final void a()
  {
    Iterator localIterator = this.b.a().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      localg.setDiff(c.a(localg.getYear(), localg.getMonth(), this.a.X()));
    }
  }
  
  final void a(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = 1;
    while (i <= 12)
    {
      localCalendar.set(paramInt, i - 1, 1);
      int j = c.a(paramInt, i);
      g localg = new g();
      localg.setDiff(c.a(paramInt, i, this.a.X()));
      localg.setCount(j);
      localg.setMonth(i);
      localg.setYear(paramInt);
      this.b.a(localg);
      i += 1;
    }
  }
  
  void b()
  {
    if (getAdapter() == null) {
      return;
    }
    getAdapter().notifyDataSetChanged();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    this.b.a(paramInt1 / 3, paramInt2 / 4);
  }
  
  final void setOnMonthSelectedListener(a parama)
  {
    this.c = parama;
  }
  
  final void setup(d paramd)
  {
    this.a = paramd;
    this.b.a(paramd);
  }
  
  static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\YearRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */