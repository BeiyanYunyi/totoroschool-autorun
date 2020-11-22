package com.totoro.school.view.calendar.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

abstract class a<T>
  extends RecyclerView.Adapter
{
  LayoutInflater a;
  Context b;
  private List<T> c;
  private b d;
  private a e;
  
  a(Context paramContext)
  {
    this.b = paramContext;
    this.c = new ArrayList();
    this.a = LayoutInflater.from(paramContext);
    this.e = new a()
    {
      public void a(int paramAnonymousInt, long paramAnonymousLong)
      {
        if (a.a(a.this) != null) {
          a.a(a.this).a(paramAnonymousInt, paramAnonymousLong);
        }
      }
    };
  }
  
  abstract RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt);
  
  final T a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.c.size())) {
      return (T)this.c.get(paramInt);
    }
    return null;
  }
  
  final List<T> a()
  {
    return this.c;
  }
  
  abstract void a(RecyclerView.ViewHolder paramViewHolder, T paramT, int paramInt);
  
  final void a(T paramT)
  {
    if (paramT != null)
    {
      this.c.add(paramT);
      notifyItemChanged(this.c.size());
    }
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    a(paramViewHolder, this.c.get(paramInt), paramInt);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = a(paramViewGroup, paramInt);
    if (paramViewGroup != null)
    {
      paramViewGroup.itemView.setTag(paramViewGroup);
      paramViewGroup.itemView.setOnClickListener(this.e);
    }
    return paramViewGroup;
  }
  
  void setOnItemClickListener(b paramb)
  {
    this.d = paramb;
  }
  
  static abstract class a
    implements View.OnClickListener
  {
    public abstract void a(int paramInt, long paramLong);
    
    public void onClick(View paramView)
    {
      paramView = (RecyclerView.ViewHolder)paramView.getTag();
      a(paramView.getAdapterPosition(), paramView.getItemId());
    }
  }
  
  static abstract interface b
  {
    public abstract void a(int paramInt, long paramLong);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */