package com.totoro.school.activity.login;

import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.totoro.school.utilpub.network.BaseActivity;

public class ThirdPartyLoginActivity
  extends BaseActivity
{
  @OnClick({2131296298})
  public void back(View paramView)
  {
    finish();
  }
  
  @OnClick({2131296692})
  public void homePage(View paramView) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492918);
    ButterKnife.bind(this);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\login\ThirdPartyLoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */