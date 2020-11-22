package com.totoro.school.adapter.main;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bumptech.glide.b;
import com.bumptech.glide.h;
import com.bumptech.glide.load.resource.bitmap.d;
import com.totoro.school.entity.find.HomeActivityListModel;
import java.util.List;

public class NewRecommendNewsAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public int a = 10;
  private Context b;
  private List<HomeActivityListModel> c;
  private LayoutInflater d;
  private b e;
  
  public NewRecommendNewsAdapter(Context paramContext, List<HomeActivityListModel> paramList)
  {
    this.b = paramContext;
    this.c = paramList;
    this.d = LayoutInflater.from(paramContext);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
    notifyDataSetChanged();
  }
  
  protected void a(final RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.e != null)
    {
      paramViewHolder.itemView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          int i = paramViewHolder.getPosition();
          NewRecommendNewsAdapter.a(NewRecommendNewsAdapter.this).a(paramViewHolder.itemView, i);
        }
      });
      paramViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          int i = paramViewHolder.getPosition();
          NewRecommendNewsAdapter.a(NewRecommendNewsAdapter.this).b(paramViewHolder.itemView, i);
          return true;
        }
      });
    }
  }
  
  public int getItemCount()
  {
    return this.c.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt + 1 == getItemCount()) {
      return 3;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof a))
    {
      paramViewHolder = (a)paramViewHolder;
      com.bumptech.glide.e.b(this.b).a(((HomeActivityListModel)this.c.get(paramInt)).getActivityImgUrl()).a(paramViewHolder.a);
      paramViewHolder.b.setText(((HomeActivityListModel)this.c.get(paramInt)).getActivityTittle());
      paramViewHolder.c.setText(((HomeActivityListModel)this.c.get(paramInt)).getActivityTime());
      a(paramViewHolder);
      return;
    }
    boolean bool = paramViewHolder instanceof d;
    int i = 0;
    if (bool)
    {
      paramViewHolder = (d)paramViewHolder;
      com.bumptech.glide.e.b(this.b).a(((HomeActivityListModel)this.c.get(paramInt)).getActivityImgUrl()).a(new d[] { new com.bumptech.glide.load.resource.bitmap.e(this.b), new com.totoro.school.recyclerView.a(this.b, 5) }).a(paramViewHolder.a);
      paramViewHolder.b.setText(((HomeActivityListModel)this.c.get(paramInt)).getActivityTittle());
      paramViewHolder.c.setText(((HomeActivityListModel)this.c.get(paramInt)).getActivityTime());
      if (((HomeActivityListModel)this.c.get(paramInt)).getActivityType() != null)
      {
        String str = ((HomeActivityListModel)this.c.get(paramInt)).getActivityType();
        switch (str.hashCode())
        {
        default: 
          break;
        case 52: 
          if (str.equals("4")) {
            paramInt = 3;
          }
          break;
        case 51: 
          if (str.equals("3")) {
            paramInt = 2;
          }
          break;
        case 50: 
          if (str.equals("2")) {
            paramInt = 1;
          }
          break;
        case 49: 
          if (str.equals("1")) {
            paramInt = i;
          }
          break;
        }
        paramInt = -1;
        switch (paramInt)
        {
        default: 
          break;
        case 3: 
          paramViewHolder.d.setBackground(this.b.getResources().getDrawable(2131558402));
          paramViewHolder.e.setText(this.b.getResources().getString(2131689521));
          break;
        case 2: 
          paramViewHolder.d.setBackground(this.b.getResources().getDrawable(2131558406));
          paramViewHolder.e.setText(this.b.getResources().getString(2131689523));
          com.bumptech.glide.e.b(this.b).a(Integer.valueOf(2131558453)).a(paramViewHolder.a);
          break;
        case 1: 
          paramViewHolder.d.setBackground(this.b.getResources().getDrawable(2131558455));
          paramViewHolder.e.setText(this.b.getResources().getString(2131689612));
        }
      }
      a(paramViewHolder);
      return;
    }
    if ((paramViewHolder instanceof c))
    {
      paramViewHolder = (c)paramViewHolder;
      paramViewHolder.a.setText(((HomeActivityListModel)this.c.get(paramInt)).getActivityTittle());
      paramViewHolder.b.setText(((HomeActivityListModel)this.c.get(paramInt)).getActivityType());
      a(paramViewHolder);
      return;
    }
    if ((paramViewHolder instanceof FooterViewHolder))
    {
      paramViewHolder = (FooterViewHolder)paramViewHolder;
      switch (this.a)
      {
      default: 
        return;
      case 12: 
        paramViewHolder.b.setText("暂无更多");
        paramViewHolder.a.setVisibility(8);
        return;
      case 11: 
        paramViewHolder.a.setVisibility(0);
        paramViewHolder.b.setText("正加载更多...");
        return;
      }
      paramViewHolder.a.setVisibility(0);
      paramViewHolder.b.setText("上拉加载更多...");
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new a(this.d.inflate(2131492954, paramViewGroup, false));
    }
    if (paramInt == 1) {
      return new d(this.d.inflate(2131492956, paramViewGroup, false));
    }
    if (paramInt == 2) {
      return new c(this.d.inflate(2131492955, paramViewGroup, false));
    }
    if (paramInt == 3) {
      return new FooterViewHolder(this.d.inflate(2131492970, paramViewGroup, false));
    }
    return null;
  }
  
  public void setOnItemClickListener(b paramb)
  {
    this.e = paramb;
  }
  
  public class FooterViewHolder
    extends RecyclerView.ViewHolder
  {
    ProgressBar a;
    TextView b;
    LinearLayout c;
    
    public FooterViewHolder(View paramView)
    {
      super();
      this.a = ((ProgressBar)paramView.findViewById(2131296508));
      this.b = ((TextView)paramView.findViewById(2131296677));
      this.c = ((LinearLayout)paramView.findViewById(2131296459));
    }
  }
  
  static class a
    extends RecyclerView.ViewHolder
  {
    ImageView a;
    TextView b;
    TextView c;
    
    public a(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131296420));
      this.b = ((TextView)paramView.findViewById(2131296688));
      this.c = ((TextView)paramView.findViewById(2131296687));
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt);
    
    public abstract void b(View paramView, int paramInt);
  }
  
  static class c
    extends RecyclerView.ViewHolder
  {
    TextView a;
    TextView b;
    
    public c(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131296697));
      this.b = ((TextView)paramView.findViewById(2131296696));
    }
  }
  
  static class d
    extends RecyclerView.ViewHolder
  {
    ImageView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    
    public d(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(2131296426));
      this.b = ((TextView)paramView.findViewById(2131296284));
      this.c = ((TextView)paramView.findViewById(2131296340));
      this.d = ((TextView)paramView.findViewById(2131296331));
      this.e = ((TextView)paramView.findViewById(2131296529));
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\adapter\main\NewRecommendNewsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */