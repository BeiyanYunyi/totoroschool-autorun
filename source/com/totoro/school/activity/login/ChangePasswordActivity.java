package com.totoro.school.activity.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.totoro.school.R.id;
import com.totoro.school.entity.login.password.change.ChangePasswordReturnModel;
import com.totoro.school.entity.login.password.forget.ForgetPasswordRequestModel;
import com.totoro.school.entity.login.password.forget.ForgetPasswordReturnModel;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.view.dialog.OneButtonDialog;
import com.totoro.school.view.dialog.OneButtonDialog.a;
import d.c.b.h;
import java.util.HashMap;

public final class ChangePasswordActivity
  extends BaseActivity
{
  private com.totoro.school.e.c a;
  private ForgetPasswordRequestModel b;
  private boolean c;
  private HashMap d;
  
  private final boolean a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty((CharSequence)paramString1)) && (!TextUtils.isEmpty((CharSequence)paramString2)))
    {
      if ((h.a(paramString2, paramString1) ^ true))
      {
        paramString1 = getString(2131689631);
        h.a(paramString1, "getString(R.string.passwords_are_inconsistent)");
        c(paramString1);
        return false;
      }
      return true;
    }
    paramString1 = getString(2131689650);
    h.a(paramString1, "getString(R.string.please_enter_password)");
    c(paramString1);
    return false;
  }
  
  private final void b()
  {
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new a(this));
    ((TextView)a(R.id.tv_confirm_revision)).setOnClickListener((View.OnClickListener)new b(this));
  }
  
  private final void c(String paramString)
  {
    paramString = new OneButtonDialog((Context)this, 2131755512, "", paramString, "", (OneButtonDialog.a)new c(this));
    Window localWindow = paramString.getWindow();
    if (localWindow == null) {
      h.a();
    }
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localWindow.setGravity(17);
    localWindow.setAttributes(localLayoutParams);
    paramString.setCanceledOnTouchOutside(true);
    paramString.setCancelable(true);
    paramString.show();
  }
  
  public View a(int paramInt)
  {
    if (this.d == null) {
      this.d = new HashMap();
    }
    View localView2 = (View)this.d.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.d.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a(String paramString, Object paramObject)
  {
    h.b(paramString, "path");
    h.b(paramObject, "o");
    super.a(paramString, paramObject);
    int i = paramString.hashCode();
    if (i != -1699888216)
    {
      if (i != 931431019) {
        return;
      }
      if (paramString.equals("changePassword"))
      {
        paramString = (ChangePasswordReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, ChangePasswordReturnModel.class);
        if (paramString != null)
        {
          paramString = paramString.getCode();
          if (paramString == null) {
            return;
          }
          if (paramString.hashCode() != 1715960) {
            return;
          }
          if (paramString.equals("8000"))
          {
            this.c = true;
            paramString = getString(2131689629);
            h.a(paramString, "getString(R.string.password_change_success)");
            c(paramString);
          }
        }
      }
    }
    else if (paramString.equals("forgetPassword"))
    {
      paramString = (ForgetPasswordReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, ForgetPasswordReturnModel.class);
      if (paramString != null)
      {
        paramString = paramString.getCode();
        if (paramString == null) {
          return;
        }
        if (paramString.hashCode() != 1715960) {
          return;
        }
        if (paramString.equals("8000"))
        {
          this.c = true;
          paramString = getString(2131689629);
          h.a(paramString, "getString(R.string.password_change_success)");
          c(paramString);
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492897);
    ButterKnife.bind((Activity)this);
    this.a = new com.totoro.school.e.c((com.totoro.school.utilpub.network.c)this);
    paramBundle = getIntent().getSerializableExtra("forgetPwdModel");
    if (paramBundle != null)
    {
      this.b = ((ForgetPasswordRequestModel)paramBundle);
      b();
      return;
    }
    throw new d.b("null cannot be cast to non-null type com.totoro.school.entity.login.password.forget.ForgetPasswordRequestModel");
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(ChangePasswordActivity paramChangePasswordActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(ChangePasswordActivity paramChangePasswordActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = ChangePasswordActivity.a(this.a);
      if (paramView != null) {
        paramView.getPhoneNumber();
      }
      paramView = ChangePasswordActivity.a(this.a);
      if (paramView != null) {
        paramView.getSnCode();
      }
      paramView = (EditText)this.a.a(R.id.et_password_one);
      String str = null;
      if (paramView != null) {
        paramView = paramView.getText();
      } else {
        paramView = null;
      }
      Object localObject1 = String.valueOf(paramView);
      paramView = (EditText)this.a.a(R.id.et_password_two);
      if (paramView != null) {
        paramView = paramView.getText();
      } else {
        paramView = null;
      }
      paramView = String.valueOf(paramView);
      if (ChangePasswordActivity.a(this.a, (String)localObject1, paramView))
      {
        localObject1 = ChangePasswordActivity.a(this.a);
        if (localObject1 != null) {
          ((ForgetPasswordRequestModel)localObject1).setPassword(paramView);
        }
        com.totoro.school.e.c localc = ChangePasswordActivity.b(this.a);
        if (localc != null)
        {
          paramView = ChangePasswordActivity.a(this.a);
          if (paramView != null) {
            paramView = paramView.getSnCode();
          } else {
            paramView = null;
          }
          localObject1 = ChangePasswordActivity.a(this.a);
          if (localObject1 != null) {
            localObject1 = ((ForgetPasswordRequestModel)localObject1).getPhoneNumber();
          } else {
            localObject1 = null;
          }
          Object localObject2 = ChangePasswordActivity.a(this.a);
          if (localObject2 != null) {
            localObject2 = ((ForgetPasswordRequestModel)localObject2).getvCode();
          } else {
            localObject2 = null;
          }
          ForgetPasswordRequestModel localForgetPasswordRequestModel = ChangePasswordActivity.a(this.a);
          if (localForgetPasswordRequestModel != null) {
            str = localForgetPasswordRequestModel.getPassword();
          }
          localc.a(paramView, (String)localObject1, (String)localObject2, str);
        }
      }
    }
  }
  
  static final class c
    implements OneButtonDialog.a
  {
    c(ChangePasswordActivity paramChangePasswordActivity) {}
    
    public final void a(String paramString)
    {
      if ((h.a("confirm_btn", paramString)) && (ChangePasswordActivity.c(this.a)))
      {
        paramString = new Intent();
        paramString.putExtra("isChange", true);
        this.a.setResult(-1, paramString);
        this.a.finish();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\login\ChangePasswordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */