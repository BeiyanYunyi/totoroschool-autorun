package com.totoro.school.adapter.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import java.util.List;

public class ScorePagerAdapter
  extends FragmentStatePagerAdapter
{
  private String[] a;
  private List<Fragment> b = null;
  
  public ScorePagerAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public void a(List<Fragment> paramList)
  {
    this.b = paramList;
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.destroyItem(paramViewGroup, paramInt, paramObject);
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)this.b.get(paramInt);
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    return super.instantiateItem(paramViewGroup, paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\adapter\tab\ScorePagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */