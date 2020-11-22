package com.totoro.school.activity.run;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.totoro.school.R.id;
import com.totoro.school.adapter.run.SportRecordAdapter;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.entity.run.reg.RunRegRequestModel;
import com.totoro.school.recyclerView.SpacesItemDecoration;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.utils.i;
import d.c.b.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.litepal.FluentQuery;
import org.litepal.LitePal;

public final class SportRecordListActivity
  extends BaseActivity
{
  private LoginReturnModel a;
  private SportRecordAdapter b;
  private List<RunRegRequestModel> c = (List)new ArrayList();
  private HashMap d;
  
  private final void b()
  {
    TextView localTextView = (TextView)a(R.id.title_text);
    h.a(localTextView, "title_text");
    localTextView.setText((CharSequence)getResources().getString(2131689698));
  }
  
  private final void c()
  {
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new a(this));
  }
  
  private final void d()
  {
    ((RecyclerView)a(R.id.sport_record_recycler_view)).addItemDecoration((RecyclerView.ItemDecoration)new SpacesItemDecoration(5));
    Object localObject = new LinearLayoutManager(getBaseContext());
    RecyclerView localRecyclerView = (RecyclerView)a(R.id.sport_record_recycler_view);
    h.a(localRecyclerView, "sport_record_recycler_view");
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.b = new SportRecordAdapter(this.c, (Activity)this);
    localObject = (RecyclerView)a(R.id.sport_record_recycler_view);
    h.a(localObject, "sport_record_recycler_view");
    ((RecyclerView)localObject).setAdapter((RecyclerView.Adapter)this.b);
  }
  
  private final void e()
  {
    Object localObject1 = this.c;
    if (localObject1 != null) {
      ((List)localObject1).clear();
    }
    localObject1 = LitePal.order("begdate desc,userendtime desc").find(RunRegRequestModel.class);
    h.a(localObject1, "LitePal.order(\"begdate d…RequestModel::class.java)");
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      Object localObject2 = (RecyclerView)a(R.id.sport_record_recycler_view);
      h.a(localObject2, "sport_record_recycler_view");
      ((RecyclerView)localObject2).setVisibility(0);
      localObject2 = (LinearLayout)a(R.id.no_data_view);
      h.a(localObject2, "no_data_view");
      ((LinearLayout)localObject2).setVisibility(8);
      localObject2 = this.c;
      if (localObject2 != null) {
        ((List)localObject2).addAll((Collection)localObject1);
      }
      localObject1 = this.b;
      if (localObject1 != null) {
        ((SportRecordAdapter)localObject1).notifyDataSetChanged();
      }
    }
    else
    {
      localObject1 = (LinearLayout)a(R.id.no_data_view);
      h.a(localObject1, "no_data_view");
      ((LinearLayout)localObject1).setVisibility(0);
      localObject1 = (RecyclerView)a(R.id.sport_record_recycler_view);
      h.a(localObject1, "sport_record_recycler_view");
      ((RecyclerView)localObject1).setVisibility(8);
    }
  }
  
  public View a(int paramInt)
  {
    if (this.d == null) {
      this.d = new HashMap();
    }
    View localView2 = (View)this.d.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.d.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a(String paramString, Object paramObject)
  {
    h.b(paramString, "path");
    h.b(paramObject, "o");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492916);
    this.a = i.a();
    b();
    c();
    d();
  }
  
  protected void onResume()
  {
    super.onResume();
    e();
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(SportRecordListActivity paramSportRecordListActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\run\SportRecordListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */