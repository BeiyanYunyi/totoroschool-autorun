package com.totoro.school.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import b.a.l;
import com.tbruyelle.rxpermissions2.b;
import com.totoro.school.adapter.main.a.a;
import com.totoro.school.frament.main.MineFragment;
import com.totoro.school.frament.main.NewFindFragment;
import com.totoro.school.frament.main.ScoreFragment;
import com.totoro.school.frament.main.SportsFragment;
import java.util.ArrayList;
import java.util.List;

public class MainFragmentActivity
  extends FragmentActivity
{
  public static com.totoro.school.c.a a;
  private static String c = "android.permission.ACCESS_BACKGROUND_LOCATION";
  protected String[] b = { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE", "android.permission.CAMERA" };
  private List<Fragment> d = new ArrayList();
  private com.totoro.school.adapter.main.a e;
  private RadioGroup f;
  private RadioButton g;
  private int h;
  private int i = 0;
  
  private void b()
  {
    new b(this).b(d()).subscribe(new -..Lambda.MainFragmentActivity.HVLMlrwas0WMDZiZNVu8dBhJB6U(this));
  }
  
  private void c()
  {
    this.e = new com.totoro.school.adapter.main.a(this, this.d, 2131296636, this.f);
    this.e.setOnRgsExtraCheckedChangedListener(new a.a()
    {
      public void a(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        MainFragmentActivity.a(MainFragmentActivity.this, paramAnonymousInt1);
        MainFragmentActivity.b(MainFragmentActivity.this, paramAnonymousInt2);
      }
    });
  }
  
  private String[] d()
  {
    if ((Build.VERSION.SDK_INT > 28) && (getApplicationContext().getApplicationInfo().targetSdkVersion > 28)) {
      this.b = new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE", "android.permission.CAMERA", c };
    }
    return this.b;
  }
  
  public void a()
  {
    this.f.check(this.g.getId());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.e.a().onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (this.h == this.g.getId())
    {
      super.onBackPressed();
      return;
    }
    a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492972);
    if ((this.d != null) && (this.d.size() == 0))
    {
      this.d.add(new SportsFragment());
      this.d.add(new ScoreFragment());
      this.d.add(new NewFindFragment());
      this.d.add(new MineFragment());
    }
    this.f = ((RadioGroup)findViewById(2131296527));
    c();
    this.g = ((RadioButton)findViewById(2131296462));
    this.h = this.g.getId();
    b();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.i == 2) && (a != null) && (a.a())) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  @TargetApi(17)
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\MainFragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */