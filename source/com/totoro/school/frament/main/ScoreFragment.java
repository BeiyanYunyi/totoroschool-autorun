package com.totoro.school.frament.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.totoro.school.adapter.tab.ScorePagerAdapter;
import com.totoro.school.frament.a.a;
import java.util.ArrayList;
import java.util.List;

public class ScoreFragment
  extends Fragment
{
  ScorePagerAdapter a;
  private String[] b = { "阳光跑", "早操签到", "体测成绩" };
  private List<Fragment> c;
  @BindView(2131296565)
  TabLayout mTabLayout;
  @BindView(2131296568)
  ViewPager mViewPager;
  
  private void a()
  {
    this.a = new ScorePagerAdapter(getActivity().getSupportFragmentManager());
    this.c = new ArrayList();
    int i = 0;
    while (i < this.b.length)
    {
      this.c.add(a.a(i));
      i += 1;
    }
    this.a.a(this.b);
    this.a.a(this.c);
    this.mViewPager.setAdapter(this.a);
    this.mTabLayout.setupWithViewPager(this.mViewPager);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131492948, paramViewGroup, false);
    ButterKnife.bind(this, paramLayoutInflater);
    a();
    return paramLayoutInflater;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\main\ScoreFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */