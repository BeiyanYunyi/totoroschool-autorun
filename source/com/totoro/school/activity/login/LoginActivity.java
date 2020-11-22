package com.totoro.school.activity.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.totoro.school.activity.MainFragmentActivity;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.utils.i;
import com.totoro.school.utils.n;
import com.totoro.school.view.dialog.OneButtonDialog;
import com.totoro.school.view.dialog.OneButtonDialog.a;
import java.util.Arrays;
import java.util.LinkedList;

public class LoginActivity
  extends BaseActivity
{
  com.totoro.school.e.c a;
  @BindView(2131296290)
  TextView appName;
  private LinkedList b = new LinkedList(Arrays.asList(new String[] { "手机号", "学号" }));
  private String c = "2";
  @BindView(2131296296)
  CheckBox cbAutoLogin;
  @BindView(2131296698)
  EditText tvPassword;
  @BindView(2131296709)
  EditText tvUsername;
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new OneButtonDialog(this, 2131755512, paramString1, paramString2, paramString3, new OneButtonDialog.a()
    {
      public void a(String paramAnonymousString)
      {
        "confirm_btn".equals(paramAnonymousString);
      }
    });
    paramString2 = paramString1.getWindow();
    paramString3 = paramString2.getAttributes();
    paramString2.setGravity(17);
    paramString2.setAttributes(paramString3);
    paramString1.setCanceledOnTouchOutside(true);
    paramString1.setCancelable(true);
    paramString1.show();
  }
  
  private void b()
  {
    this.appName.setText(com.totoro.school.utils.b.a(getApplicationContext()));
  }
  
  private boolean c()
  {
    Object localObject = getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.totoro.school.utils.c.a("yyyy-MM-dd"));
    localStringBuilder.append("_runed");
    if (((Boolean)n.b((Context)localObject, localStringBuilder.toString(), Boolean.valueOf(false))).booleanValue())
    {
      localObject = i.a();
      if (localObject == null) {
        return false;
      }
      return !((LoginReturnModel)localObject).getPhoneNumber().equals(this.tvUsername.getText().toString());
    }
    return false;
  }
  
  private void d()
  {
    if (this.cbAutoLogin.isChecked()) {
      n.a(getApplicationContext(), "autoLogin", Boolean.valueOf(true));
    } else {
      n.a(getApplicationContext(), "autoLogin", Boolean.valueOf(false));
    }
    n.a(getApplicationContext(), "loginId", this.tvUsername.getText().toString());
    n.a(getApplicationContext(), "password", this.tvPassword.getText().toString());
    n.a(getApplicationContext(), "loginWay", this.c);
  }
  
  private void e()
  {
    boolean bool = ((Boolean)n.b(getApplicationContext(), "autoLogin", Boolean.valueOf(false))).booleanValue();
    this.cbAutoLogin.setChecked(bool);
    String str1 = (String)n.b(getApplicationContext(), "loginId", "");
    String str2 = (String)n.b(getApplicationContext(), "password", "");
    if (!n.b(getApplicationContext(), "loginWay", "").toString().isEmpty()) {
      this.c = ((String)n.b(getApplicationContext(), "loginWay", ""));
    }
    this.tvUsername.setText(str1);
    this.tvPassword.setText(str2);
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (bool)) {
      this.a.a(str1, str2, this.c, getBaseContext());
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if (paramString.equals("login_request"))
    {
      paramString = (LoginReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, LoginReturnModel.class);
      if (paramString != null)
      {
        paramObject = paramString.getCode();
        int i = -1;
        int j = ((String)paramObject).hashCode();
        if (j != 1477632)
        {
          if (j != 1507431) {
            switch (j)
            {
            default: 
              break;
            case 1507427: 
              if (!((String)paramObject).equals("1004")) {
                break;
              }
              i = 5;
              break;
            case 1507426: 
              if (!((String)paramObject).equals("1003")) {
                break;
              }
              i = 4;
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
              i = 1;
              break;
            }
          } else if (((String)paramObject).equals("1008")) {
            i = 6;
          }
        }
        else if (((String)paramObject).equals("0000")) {
          i = 0;
        }
        switch (i)
        {
        default: 
          
        case 6: 
          a("", getString(2131689595), "");
          return;
        case 4: 
          a("", getString(2131689611), "");
          return;
        case 2: 
          a("", getString(2131689648), "");
          return;
        case 1: 
          a("", getString(2131689710), "");
          return;
        case 0: 
          if (paramString.getSnCode() == null)
          {
            a("", getString(2131689709), "");
            return;
          }
          d();
          paramString.save();
          startActivity(new Intent(this, MainFragmentActivity.class));
          finish();
        }
      }
    }
  }
  
  @OnClick({2131296296})
  public void automaticLogon(View paramView) {}
  
  @OnClick({2131296702})
  public void certification(View paramView)
  {
    startActivity(new Intent(this, AuthenticationActivity.class));
  }
  
  @OnClick({2131296689})
  public void forgetPassword(View paramView)
  {
    startActivity(new Intent(this, ForgetPasswordActivity.class));
  }
  
  @OnClick({2131296694})
  public void loginImmediately(View paramView)
  {
    paramView = this.tvUsername.getText().toString();
    if (TextUtils.isEmpty(paramView)) {
      return;
    }
    String str = this.tvPassword.getText().toString();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (c())
    {
      paramView = i.a();
      paramView = String.format(getString(2131689657), new Object[] { paramView.getStuName(), paramView.getStuName() });
      a(getString(2131689656), paramView, getString(2131689726));
      return;
    }
    this.a.a(paramView, str, this.c, getBaseContext());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492906);
    ButterKnife.bind(this);
    b();
    this.a = new com.totoro.school.e.c(this);
    e();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\login\LoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */