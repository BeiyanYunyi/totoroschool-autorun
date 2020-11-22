package com.totoro.school.view.calendar.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;

final class j
  extends a<g>
{
  private d c;
  private int d;
  private int e;
  
  j(Context paramContext)
  {
    super(paramContext);
  }
  
  RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (TextUtils.isEmpty(this.c.w())) {
      paramViewGroup = new DefaultYearView(this.b);
    } else {
      try
      {
        paramViewGroup = (YearView)this.c.v().getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.b });
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        paramViewGroup = new DefaultYearView(this.b);
      }
    }
    paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
    return new a(paramViewGroup, this.c);
  }
  
  final void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  void a(RecyclerView.ViewHolder paramViewHolder, g paramg, int paramInt)
  {
    paramViewHolder = ((a)paramViewHolder).a;
    paramViewHolder.a(paramg.getYear(), paramg.getMonth());
    paramViewHolder.b(this.d, this.e);
  }
  
  final void a(d paramd)
  {
    this.c = paramd;
  }
  
  private static class a
    extends RecyclerView.ViewHolder
  {
    YearView a;
    
    a(View paramView, d paramd)
    {
      super();
      this.a = ((YearView)paramView);
      this.a.setup(paramd);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */