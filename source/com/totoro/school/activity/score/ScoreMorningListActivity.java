package com.totoro.school.activity.score;

import android.app.Activity;
import android.content.Intent;
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
import com.google.gson.c.a;
import com.google.gson.e;
import com.totoro.school.R.id;
import com.totoro.school.adapter.score.ScoreMorningDetailAdapter;
import com.totoro.school.e.g;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.entity.score.morning.ScoreMorningBaseModel;
import com.totoro.school.entity.score.morning.ScoreMorningDetailModel;
import com.totoro.school.entity.score.morning.ScoreMorningRequestModel;
import com.totoro.school.entity.score.morning.ScoreMorningReturnModel;
import com.totoro.school.recyclerView.SpacesItemDecoration;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.utilpub.network.a.b;
import com.totoro.school.utilpub.network.c;
import com.totoro.school.utils.i;
import d.c.b.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public final class ScoreMorningListActivity
  extends BaseActivity
{
  private LoginReturnModel a;
  private g b;
  private ScoreMorningDetailAdapter c;
  private final ArrayList<ScoreMorningDetailModel> d = new ArrayList();
  private HashMap e;
  
  private final void b()
  {
    TextView localTextView = (TextView)a(R.id.title_text);
    h.a(localTextView, "title_text");
    localTextView.setText((CharSequence)getResources().getString(2131689663));
  }
  
  private final void c()
  {
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new c(this));
  }
  
  private final void d()
  {
    ((RecyclerView)a(R.id.score_morning_detail_recycler_view)).addItemDecoration((RecyclerView.ItemDecoration)new SpacesItemDecoration(5));
    Object localObject = new LinearLayoutManager(getBaseContext());
    RecyclerView localRecyclerView = (RecyclerView)a(R.id.score_morning_detail_recycler_view);
    h.a(localRecyclerView, "score_morning_detail_recycler_view");
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.c = new ScoreMorningDetailAdapter((List)this.d, (Activity)this);
    localObject = (RecyclerView)a(R.id.score_morning_detail_recycler_view);
    h.a(localObject, "score_morning_detail_recycler_view");
    ((RecyclerView)localObject).setAdapter((RecyclerView.Adapter)this.c);
  }
  
  private final void e()
  {
    if (this.a != null)
    {
      ScoreMorningRequestModel localScoreMorningRequestModel = new ScoreMorningRequestModel();
      Object localObject1 = this.a;
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((LoginReturnModel)localObject1).getSchoolID();
      } else {
        localObject1 = null;
      }
      localScoreMorningRequestModel.setSchoolName((String)localObject1);
      LoginReturnModel localLoginReturnModel = this.a;
      localObject1 = localObject2;
      if (localLoginReturnModel != null) {
        localObject1 = localLoginReturnModel.getSnCode();
      }
      localScoreMorningRequestModel.setSnCode((String)localObject1);
      localScoreMorningRequestModel.setAcademicYear(getIntent().getStringExtra("academicYear"));
      localScoreMorningRequestModel.setAcademicMonth(getIntent().getStringExtra("academicMonth"));
      localScoreMorningRequestModel.setFlag("Q");
      localObject1 = this.b;
      if (localObject1 != null) {
        ((g)localObject1).a(localScoreMorningRequestModel);
      }
    }
  }
  
  public View a(int paramInt)
  {
    if (this.e == null) {
      this.e = new HashMap();
    }
    View localView2 = (View)this.e.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.e.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a(String paramString, Object paramObject)
  {
    h.b(paramString, "path");
    h.b(paramObject, "o");
    if (paramString.hashCode() != -1138171104) {
      return;
    }
    if (paramString.equals("query_morning_score"))
    {
      paramString = (ScoreMorningReturnModel)b.a(paramObject, ScoreMorningReturnModel.class);
      if (paramString != null)
      {
        paramObject = paramString.getCode();
        if (paramObject == null) {
          return;
        }
        if (((String)paramObject).hashCode() != 1715960) {
          return;
        }
        if (((String)paramObject).equals("8000"))
        {
          paramObject = paramString.getMorQueryList();
          int j = 0;
          int i;
          if (paramObject != null)
          {
            paramObject = paramString.getMorQueryList();
            h.a(paramObject, "scoreMorningReturnModel.morQueryList");
            if (((CharSequence)paramObject).length() > 0) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0)
            {
              paramObject = (List)new e().a(paramString.getMorQueryList(), new a().b());
              if ((paramObject != null) && ((((Collection)paramObject).isEmpty() ^ true)))
              {
                paramObject = (ScoreMorningBaseModel)((List)paramObject).get(0);
                Integer.parseInt(((ScoreMorningBaseModel)paramObject).getNumberOfRequests());
                Integer.parseInt(((ScoreMorningBaseModel)paramObject).getQfTimes());
                TextView localTextView = (TextView)a(R.id.signedNumber);
                h.a(localTextView, "signedNumber");
                localTextView.setText((CharSequence)((ScoreMorningBaseModel)paramObject).getQfTimes());
              }
            }
          }
          if (paramString.getMonthTimeList() != null)
          {
            paramObject = paramString.getMonthTimeList();
            h.a(paramObject, "scoreMorningReturnModel.monthTimeList");
            i = j;
            if (((CharSequence)paramObject).length() > 0) {
              i = 1;
            }
            if (i != 0)
            {
              this.d.clear();
              paramString = (List)new e().a(paramString.getMonthTimeList(), new b().b());
              this.d.addAll((Collection)paramString);
              paramString = this.c;
              if (paramString != null) {
                paramString.notifyDataSetChanged();
              }
            }
          }
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492913);
    this.b = new g((c)this);
    this.a = i.a();
    b();
    c();
    d();
    e();
  }
  
  public static final class a
    extends a<List<? extends ScoreMorningBaseModel>>
  {}
  
  public static final class b
    extends a<List<? extends ScoreMorningDetailModel>>
  {}
  
  static final class c
    implements View.OnClickListener
  {
    c(ScoreMorningListActivity paramScoreMorningListActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\score\ScoreMorningListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */