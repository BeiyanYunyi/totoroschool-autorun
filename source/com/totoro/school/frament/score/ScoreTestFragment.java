package com.totoro.school.frament.score;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.e;
import com.totoro.school.adapter.score.ScoreTestAdapter;
import com.totoro.school.e.g;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.entity.score.test.ScoreTestModel;
import com.totoro.school.entity.score.test.ScoreTestRequestModel;
import com.totoro.school.entity.score.test.ScoreTestReturnModel;
import com.totoro.school.entity.score.year.SchoolYearModel;
import com.totoro.school.entity.score.year.SchoolYearRequestModel;
import com.totoro.school.entity.score.year.SchoolYearReturnModel;
import com.totoro.school.recyclerView.SpacesItemDecoration;
import com.totoro.school.utilpub.network.a.b;
import com.totoro.school.utilpub.network.c;
import com.totoro.school.utils.i;
import com.totoro.school.view.wheelview.WheelView;
import com.totoro.school.view.wheelview.WheelView.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ScoreTestFragment
  extends Fragment
  implements c
{
  private g a;
  private ScoreTestAdapter b;
  private LinkedList c = new LinkedList(Arrays.asList(new String[] { "2019-2020第一学期", "2019-2020第二学期" }));
  @BindView(2131296319)
  TextView centerNumber;
  @BindView(2131296320)
  TextView centerText;
  private List<SchoolYearModel> d = new ArrayList();
  private List<ScoreTestModel> e = new ArrayList();
  private int f = 0;
  private SchoolYearModel g;
  private LoginReturnModel h;
  @BindView(2131296439)
  TextView leftNumber;
  @BindView(2131296440)
  TextView leftText;
  @BindView(2131296488)
  LinearLayout noDataView;
  @BindView(2131296536)
  TextView rightNumber;
  @BindView(2131296538)
  TextView rightText;
  @BindView(2131296560)
  LinearLayout scoreLayout;
  @BindView(2131296566)
  RecyclerView testRecyclerView;
  @BindView(2131296734)
  RelativeLayout yearLayout;
  @BindView(2131296735)
  TextView yearName;
  
  private void b()
  {
    if (this.h != null)
    {
      SchoolYearRequestModel localSchoolYearRequestModel = new SchoolYearRequestModel();
      localSchoolYearRequestModel.setSchoolCode(this.h.getSchoolID());
      localSchoolYearRequestModel.setReqNum("0");
      this.a.a(localSchoolYearRequestModel);
    }
  }
  
  private void b(String paramString)
  {
    if (this.h != null)
    {
      ScoreTestRequestModel localScoreTestRequestModel = new ScoreTestRequestModel();
      localScoreTestRequestModel.setSchoolName(this.h.getSchoolID());
      localScoreTestRequestModel.setSnCode(this.h.getSnCode());
      localScoreTestRequestModel.setAcademicYear(paramString);
      this.a.a(localScoreTestRequestModel);
    }
  }
  
  private void c()
  {
    this.leftText.setText(getActivity().getString(2131689685));
    this.centerText.setText(getActivity().getString(2131689688));
    this.rightText.setText(getActivity().getString(2131689684));
  }
  
  private void d()
  {
    this.yearLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ScoreTestFragment.a(ScoreTestFragment.this);
      }
    });
  }
  
  private void e()
  {
    this.testRecyclerView.addItemDecoration(new SpacesItemDecoration(5));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext());
    this.testRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.b = new ScoreTestAdapter(this.e, getActivity());
    this.testRecyclerView.setAdapter(this.b);
  }
  
  private void f()
  {
    final com.totoro.school.view.dialog.a locala = new com.totoro.school.view.dialog.a(getContext(), 2131755009);
    View localView = LayoutInflater.from(getContext()).inflate(2131493001, null);
    Object localObject = (TextView)localView.findViewById(2131296332);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((SchoolYearModel)localIterator.next()).getYearname());
    }
    ((TextView)localObject).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ScoreTestFragment.this.yearName.setText(ScoreTestFragment.b(ScoreTestFragment.this).getYearname());
        ScoreTestFragment.a(ScoreTestFragment.this, ScoreTestFragment.b(ScoreTestFragment.this).getYearid());
        if (locala.isShowing()) {
          locala.dismiss();
        }
      }
    });
    localObject = (WheelView)localView.findViewById(2131296730);
    ((WheelView)localObject).a(localArrayList, this.f);
    ((WheelView)localObject).setOnItemSelectedListener(new WheelView.b()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        ScoreTestFragment.a(ScoreTestFragment.this, (SchoolYearModel)ScoreTestFragment.c(ScoreTestFragment.this).get(paramAnonymousInt));
        ScoreTestFragment.a(ScoreTestFragment.this, paramAnonymousInt);
      }
    });
    locala.setContentView(localView);
    locala.setCancelable(false);
    locala.show();
  }
  
  public void a(String paramString, Object paramObject)
  {
    int i = paramString.hashCode();
    int j = 1;
    int k = -1;
    if (i != -1594263247)
    {
      if ((i == 1421484156) && (paramString.equals("query_test_score")))
      {
        i = 1;
        break label60;
      }
    }
    else if (paramString.equals("query_school_year"))
    {
      i = 0;
      break label60;
    }
    i = -1;
    switch (i)
    {
    default: 
      
    case 1: 
      paramString = (ScoreTestReturnModel)b.a(paramObject, ScoreTestReturnModel.class);
      if (paramString != null)
      {
        paramObject = paramString.getCode();
        i = ((String)paramObject).hashCode();
        if (i != 1715960)
        {
          switch (i)
          {
          default: 
            break;
          case 1507425: 
            if (!((String)paramObject).equals("1002")) {
              break;
            }
            i = 3;
            break;
          case 1507424: 
            if (!((String)paramObject).equals("1001")) {
              break;
            }
            i = 2;
            break;
          case 1507423: 
            if (!((String)paramObject).equals("1000")) {
              break;
            }
            i = j;
            break;
          }
        }
        else if (((String)paramObject).equals("8000"))
        {
          i = 0;
          break label210;
        }
        i = -1;
        switch (i)
        {
        default: 
          return;
        case 1: 
        case 2: 
        case 3: 
          paramString = this.leftNumber;
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("0");
          ((StringBuilder)paramObject).append(getActivity().getString(2131689687));
          paramString.setText(((StringBuilder)paramObject).toString());
          paramString = this.centerNumber;
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("0");
          ((StringBuilder)paramObject).append(getActivity().getString(2131689687));
          paramString.setText(((StringBuilder)paramObject).toString());
          paramString = this.rightNumber;
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append("0");
          ((StringBuilder)paramObject).append(getActivity().getString(2131689687));
          paramString.setText(((StringBuilder)paramObject).toString());
          this.e.clear();
          this.b.notifyDataSetChanged();
          this.noDataView.setVisibility(0);
          this.scoreLayout.setVisibility(8);
          return;
        }
        i = Integer.parseInt(paramString.getNumberOfRequests());
        j = Integer.parseInt(paramString.getQfTimes());
        paramObject = this.leftNumber;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.getQfTimes());
        localStringBuilder.append(getActivity().getString(2131689687));
        ((TextView)paramObject).setText(localStringBuilder.toString());
        paramObject = this.centerNumber;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(i - j);
        localStringBuilder.append(getActivity().getString(2131689687));
        ((TextView)paramObject).setText(localStringBuilder.toString());
        paramObject = this.rightNumber;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.getNumberOfRequests());
        localStringBuilder.append(getActivity().getString(2131689687));
        ((TextView)paramObject).setText(localStringBuilder.toString());
        if ((paramString.getScoreList() != null) && (paramString.getScoreList().length() > 0))
        {
          this.e.clear();
          paramString = (List)new e().a(paramString.getScoreList(), new com.google.gson.c.a() {}.b());
          this.e.addAll(paramString);
          this.b.notifyDataSetChanged();
        }
        if ((this.e != null) && (this.e.size() > 0))
        {
          this.noDataView.setVisibility(8);
          this.scoreLayout.setVisibility(0);
          return;
        }
        this.noDataView.setVisibility(0);
        this.scoreLayout.setVisibility(8);
        return;
      }
      break;
    case 0: 
      label60:
      label210:
      paramString = (SchoolYearReturnModel)b.a(paramObject, SchoolYearReturnModel.class);
      if (paramString != null)
      {
        paramObject = paramString.getCode();
        if (((String)paramObject).hashCode() != 1715960)
        {
          i = k;
        }
        else
        {
          i = k;
          if (((String)paramObject).equals("8000")) {
            i = 0;
          }
        }
        if (i != 0) {
          return;
        }
        if ((paramString.getYearlist() != null) && (paramString.getYearlist().length() > 0))
        {
          this.d.clear();
          this.d = ((List)new e().a(paramString.getYearlist(), new com.google.gson.c.a() {}.b()));
          this.c.clear();
          i = 0;
          while (i < this.d.size())
          {
            this.c.add(i, ((SchoolYearModel)this.d.get(i)).getYearname());
            if ("Y".equals(((SchoolYearModel)this.d.get(i)).getFlag()))
            {
              this.g = ((SchoolYearModel)this.d.get(i));
              this.f = i;
              this.yearName.setText(this.g.getYearname());
              b(((SchoolYearModel)this.d.get(i)).getYearid());
            }
            i += 1;
          }
          if ((this.c.size() > 0) && (this.g == null))
          {
            this.g = ((SchoolYearModel)this.d.get(0));
            this.yearName.setText(this.g.getYearname());
            b(this.g.getYearid());
          }
        }
      }
      break;
    }
  }
  
  public void a(String paramString, Throwable paramThrowable) {}
  
  public void a_(String paramString) {}
  
  public void d_() {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131492951, paramViewGroup, false);
    ButterKnife.bind(this, paramLayoutInflater);
    this.h = i.a();
    this.a = new g(this);
    b();
    c();
    d();
    e();
    return paramLayoutInflater;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\score\ScoreTestFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */