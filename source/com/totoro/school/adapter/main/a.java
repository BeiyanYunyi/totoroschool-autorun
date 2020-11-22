package com.totoro.school.adapter.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import java.util.List;

public class a
  implements RadioGroup.OnCheckedChangeListener
{
  private List<Fragment> a;
  private FragmentActivity b;
  private int c;
  private int d;
  private a e;
  
  public a(FragmentActivity paramFragmentActivity, List<Fragment> paramList, int paramInt, RadioGroup paramRadioGroup)
  {
    this.a = paramList;
    this.b = paramFragmentActivity;
    this.c = paramInt;
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().beginTransaction();
    if (((Fragment)paramList.get(0)).isAdded()) {
      ((Fragment)paramList.get(0)).onResume();
    } else {
      paramFragmentActivity.add(paramInt, (Fragment)paramList.get(0), "sports");
    }
    paramFragmentActivity.commit();
    paramRadioGroup.setOnCheckedChangeListener(this);
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    while (i < this.a.size())
    {
      Fragment localFragment = (Fragment)this.a.get(i);
      FragmentTransaction localFragmentTransaction = b(paramInt);
      if (paramInt == i) {
        localFragmentTransaction.show(localFragment);
      } else {
        localFragmentTransaction.hide(localFragment);
      }
      localFragmentTransaction.commit();
      i += 1;
    }
    this.d = paramInt;
  }
  
  private FragmentTransaction b(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.b.getSupportFragmentManager().beginTransaction();
    if (paramInt > this.d)
    {
      localFragmentTransaction.setCustomAnimations(2130771988, 2130771989);
      return localFragmentTransaction;
    }
    localFragmentTransaction.setCustomAnimations(2130771990, 2130771991);
    return localFragmentTransaction;
  }
  
  public Fragment a()
  {
    return (Fragment)this.a.get(this.d);
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i = 0;
    while (i < paramRadioGroup.getChildCount())
    {
      if (paramRadioGroup.getChildAt(i).getId() == paramInt)
      {
        String str = "";
        switch (i)
        {
        default: 
          break;
        case 3: 
          str = "mine";
          break;
        case 2: 
          str = "find";
          break;
        case 1: 
          str = "score";
          break;
        case 0: 
          str = "sports";
        }
        Fragment localFragment = (Fragment)this.a.get(i);
        FragmentTransaction localFragmentTransaction = b(i);
        a().onPause();
        if (localFragment.isAdded()) {
          localFragment.onResume();
        } else {
          localFragmentTransaction.add(this.c, localFragment, str);
        }
        a(i);
        localFragmentTransaction.commit();
        if (this.e != null) {
          this.e.a(paramRadioGroup, paramInt, i);
        }
      }
      i += 1;
    }
  }
  
  public void setOnRgsExtraCheckedChangedListener(a parama)
  {
    this.e = parama;
  }
  
  public static class a
  {
    public void a(RadioGroup paramRadioGroup, int paramInt1, int paramInt2) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\adapter\main\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */