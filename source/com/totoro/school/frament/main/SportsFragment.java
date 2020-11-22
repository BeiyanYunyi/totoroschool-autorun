package com.totoro.school.frament.main;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.totoro.school.adapter.tab.PagerAdapter;
import com.totoro.school.entity.HeaderModel;
import com.totoro.school.entity.update.UpdateAppBodyModel;
import com.totoro.school.entity.update.UpdateAppReturnModel;
import com.totoro.school.utilpub.network.c;
import com.totoro.school.utils.f;
import com.totoro.school.view.NoScrollViewPager;
import com.totoro.school.view.dialog.DownLoadNewAppSer;
import com.totoro.school.view.dialog.DownloadProgressDialog;
import com.totoro.school.view.dialog.b.a;
import java.util.ArrayList;
import java.util.List;

public class SportsFragment
  extends Fragment
  implements c
{
  PagerAdapter a;
  private com.totoro.school.e.b b;
  private String[] c = { "阳光跑", "早操签到" };
  private List<Fragment> d;
  private com.totoro.school.view.dialog.b e;
  private UpdateAppBodyModel f;
  private int g = 102;
  private b.a h = new b.a()
  {
    public void a(String paramAnonymousString)
    {
      if (("btnUp" == paramAnonymousString) && (f.a() / 1048576L > 20L))
      {
        if (Build.VERSION.SDK_INT < 23)
        {
          paramAnonymousString = new Intent(SportsFragment.this.getActivity(), DownLoadNewAppSer.class);
          paramAnonymousString.putExtra("url", SportsFragment.a(SportsFragment.this).getUrl());
          SportsFragment.this.getActivity().startService(paramAnonymousString);
          paramAnonymousString = new Intent(SportsFragment.this.getActivity(), DownloadProgressDialog.class);
          SportsFragment.this.getActivity().startActivity(paramAnonymousString);
          return;
        }
        if (ContextCompat.checkSelfPermission(SportsFragment.this.getActivity(), "android.permission.READ_EXTERNAL_STORAGE") != 0)
        {
          paramAnonymousString = SportsFragment.this.getActivity();
          int i = SportsFragment.b(SportsFragment.this);
          paramAnonymousString.requestPermissions(new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, i);
          return;
        }
        paramAnonymousString = new Intent(SportsFragment.this.getActivity(), DownLoadNewAppSer.class);
        paramAnonymousString.putExtra("url", SportsFragment.a(SportsFragment.this).getUrl());
        SportsFragment.this.getActivity().startService(paramAnonymousString);
        paramAnonymousString = new Intent(SportsFragment.this.getActivity(), DownloadProgressDialog.class);
        SportsFragment.this.getActivity().startActivity(paramAnonymousString);
      }
    }
  };
  @BindView(2131296642)
  TabLayout mTabLayout;
  @BindView(2131296720)
  NoScrollViewPager mViewPager;
  
  private int a(String paramString1, String paramString2)
  {
    if (paramString1.equals(paramString2)) {
      return 0;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int m = Math.min(paramString1.length, paramString2.length);
    int i = 0;
    int j = 0;
    int k;
    for (;;)
    {
      k = j;
      if (i >= m) {
        break;
      }
      j = Integer.parseInt(paramString1[i]) - Integer.parseInt(paramString2[i]);
      k = j;
      if (j != 0) {
        break;
      }
      i += 1;
    }
    if (k == 0)
    {
      j = i;
      for (;;)
      {
        k = i;
        if (j >= paramString1.length) {
          break;
        }
        if (Integer.parseInt(paramString1[j]) > 0) {
          return 1;
        }
        j += 1;
      }
      while (k < paramString2.length)
      {
        if (Integer.parseInt(paramString2[k]) > 0) {
          return -1;
        }
        k += 1;
      }
      return 0;
    }
    if (k > 0) {
      return 1;
    }
    return -1;
  }
  
  private void b()
  {
    this.a = new PagerAdapter(getActivity().getSupportFragmentManager());
    this.d = new ArrayList();
    int i = 0;
    while (i < this.c.length)
    {
      this.d.add(com.totoro.school.frament.a.b.a(i));
      i += 1;
    }
    this.a.a(this.c);
    this.a.a(this.d);
    this.mViewPager.setAdapter(this.a);
    this.mTabLayout.setupWithViewPager(this.mViewPager);
    this.mTabLayout.setTabMode(1);
  }
  
  public void a(String paramString, Object paramObject)
  {
    int i;
    if ((paramString.hashCode() == -295610965) && (paramString.equals("update_app"))) {
      i = 0;
    } else {
      i = -1;
    }
    if (i != 0) {
      return;
    }
    paramString = (UpdateAppReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, UpdateAppReturnModel.class);
    if (paramString != null)
    {
      paramObject = paramString.getHeader();
      if ((((HeaderModel)paramObject).getCode() != null) && ("0".equals(((HeaderModel)paramObject).getCode())))
      {
        this.f = paramString.getBody();
        if ((a(this.f.getVersion(), com.totoro.school.utils.b.b(getContext())) == 1) && (this.e == null))
        {
          this.e = new com.totoro.school.view.dialog.b(getActivity(), 1, this.h, this.f);
          this.e.setCancelable(false);
          this.e.setCanceledOnTouchOutside(false);
          this.e.show();
        }
      }
    }
  }
  
  public void a(String paramString, Throwable paramThrowable) {}
  
  public void a_(String paramString) {}
  
  public void d_() {}
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131492952, paramViewGroup, false);
    this.b = new com.totoro.school.e.b(this);
    ButterKnife.bind(this, paramLayoutInflater);
    b();
    this.b.a();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\main\SportsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */