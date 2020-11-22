package com.totoro.school.activity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.l;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.totoro.school.c.a;
import com.totoro.school.e.d;
import com.totoro.school.entity.BaseResultEntity;
import com.totoro.school.entity.HeaderModel;
import com.totoro.school.frament.main.FindFragment;
import com.totoro.school.frament.main.MineFragment;
import com.totoro.school.frament.main.ScoreFragment;
import com.totoro.school.frament.main.SportsFragment;
import com.totoro.school.utilpub.network.BaseActivity;

public class MainActivity
  extends BaseActivity
{
  public static a a;
  private static String d = "android.permission.ACCESS_BACKGROUND_LOCATION";
  protected String[] b = { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE", "android.permission.CAMERA" };
  private d c;
  @BindView(2131296336)
  FrameLayout content;
  private SportsFragment e;
  private ScoreFragment f;
  private FindFragment g;
  private MineFragment h;
  private FragmentTransaction i;
  @BindView(2131296421)
  ImageView ivFound;
  @BindView(2131296422)
  ImageView ivMe;
  @BindView(2131296423)
  ImageView ivRecord;
  @BindView(2131296424)
  ImageView ivRun;
  private int j = 0;
  @BindView(2131296452)
  LinearLayout llFound;
  @BindView(2131296454)
  LinearLayout llMe;
  @BindView(2131296455)
  LinearLayout llRecord;
  @BindView(2131296456)
  LinearLayout llRun;
  @BindView(2131296690)
  TextView tvFound;
  @BindView(2131296679)
  TextView tvMe;
  @BindView(2131296700)
  TextView tvRecord;
  @BindView(2131296703)
  TextView tvRun;
  
  private void a(int paramInt)
  {
    this.j = paramInt;
    this.i = getSupportFragmentManager().beginTransaction();
    c();
    d();
    switch (paramInt)
    {
    default: 
      break;
    case 3: 
      if (this.h == null)
      {
        this.h = new MineFragment();
        this.i.add(2131296336, this.h);
      }
      this.ivMe.setImageResource(2131558417);
      this.tvMe.setTextColor(ContextCompat.getColor(getApplicationContext(), 2131099731));
      this.i.show(this.h);
      break;
    case 2: 
      if (this.g == null)
      {
        this.g = new FindFragment();
        this.i.add(2131296336, this.g);
      }
      this.ivRecord.setImageResource(2131558413);
      this.tvRecord.setTextColor(ContextCompat.getColor(getApplicationContext(), 2131099731));
      this.i.show(this.g);
      break;
    case 1: 
      if (this.f == null)
      {
        this.f = new ScoreFragment();
        this.i.add(2131296336, this.f);
      }
      this.ivFound.setImageResource(2131558415);
      this.tvFound.setTextColor(ContextCompat.getColor(getApplicationContext(), 2131099731));
      this.i.show(this.f);
      break;
    case 0: 
      if (this.e == null)
      {
        this.e = new SportsFragment();
        this.i.add(2131296336, this.e);
      }
      this.ivRun.setImageResource(2131558411);
      this.tvRun.setTextColor(ContextCompat.getColor(getApplicationContext(), 2131099731));
      this.i.show(this.e);
    }
    this.i.commit();
  }
  
  private String[] b()
  {
    if ((Build.VERSION.SDK_INT > 28) && (getApplicationContext().getApplicationInfo().targetSdkVersion > 28)) {
      this.b = new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE", "android.permission.CAMERA", d };
    }
    return this.b;
  }
  
  private void c()
  {
    this.ivRun.setImageResource(2131558412);
    this.ivFound.setImageResource(2131558416);
    this.ivRecord.setImageResource(2131558414);
    this.ivMe.setImageResource(2131558418);
    this.tvRun.setTextColor(ContextCompat.getColor(getApplicationContext(), 2131099732));
    this.tvFound.setTextColor(ContextCompat.getColor(getApplicationContext(), 2131099732));
    this.tvRecord.setTextColor(ContextCompat.getColor(getApplicationContext(), 2131099732));
    this.tvMe.setTextColor(ContextCompat.getColor(getApplicationContext(), 2131099732));
  }
  
  private void d()
  {
    if (this.e != null) {
      this.i.hide(this.e);
    }
    if (this.f != null) {
      this.i.hide(this.f);
    }
    if (this.g != null) {
      this.i.hide(this.g);
    }
    if (this.h != null) {
      this.i.hide(this.h);
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if (paramString.equals("run_data_upload_request"))
    {
      paramString = (BaseResultEntity)com.totoro.school.utilpub.network.a.b.a(paramObject, BaseResultEntity.class);
      if (paramString.getHeader().getMsg().equals("新增采集数据成功"))
      {
        Log.i("okhttp", "baseResultEntity--msgsuccess");
        return;
      }
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("baseResultEntity--msgfail:");
      ((StringBuilder)paramObject).append(paramString.getHeader().getMsg());
      Log.i("okhttp", ((StringBuilder)paramObject).toString());
    }
  }
  
  @OnClick({2131296456, 2131296452, 2131296455, 2131296454})
  public void changeTab(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131296453: 
    default: 
      return;
    case 2131296456: 
      a(0);
      return;
    case 2131296455: 
      a(2);
      return;
    case 2131296454: 
      a(3);
      return;
    }
    a(1);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492907);
    ButterKnife.bind(this);
    a(0);
    new com.tbruyelle.rxpermissions2.b(this).b(b()).subscribe(new -..Lambda.MainActivity.0iqiOCTmGDBAga1f04RunTrV0o4(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.j == 2) && (a != null) && (a.a())) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */