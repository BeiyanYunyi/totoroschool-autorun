package com.totoro.school.activity.login;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.totoro.school.R.id;
import com.totoro.school.entity.login.password.forget.ForgetPasswordRequestModel;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.view.a;
import com.totoro.school.view.dialog.OneButtonDialog;
import com.totoro.school.view.dialog.OneButtonDialog.a;
import d.b;
import d.c.b.h;
import java.io.Serializable;
import java.util.HashMap;

public final class ForgetPasswordActivity
  extends BaseActivity
{
  public static final a a = new a(null);
  private String b;
  private final ForgetPasswordRequestModel c = new ForgetPasswordRequestModel();
  private HashMap d;
  
  private final boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty((CharSequence)paramString1))
    {
      paramString1 = getString(2131689553);
      h.a(paramString1, "getString(R.string.enter_phone_number)");
      c(paramString1);
      return false;
    }
    if (TextUtils.isEmpty((CharSequence)paramString2))
    {
      paramString1 = getString(2131689554);
      h.a(paramString1, "getString(R.string.enter_sn_code)");
      c(paramString1);
      return false;
    }
    if (TextUtils.isEmpty((CharSequence)paramString3))
    {
      paramString1 = getString(2131689555);
      h.a(paramString1, "getString(R.string.enter_verification_code)");
      c(paramString1);
      return false;
    }
    if ((h.a(paramString3, this.b) ^ true))
    {
      paramString1 = getString(2131689741);
      h.a(paramString1, "getString(R.string.verification_code_not_correct)");
      c(paramString1);
      return false;
    }
    return true;
  }
  
  private final void b()
  {
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new b(this));
    ((ImageView)a(R.id.iv_show_code)).setOnClickListener((View.OnClickListener)new c(this));
    ((TextView)a(R.id.tv_confirm)).setOnClickListener((View.OnClickListener)new d(this));
  }
  
  private final void c()
  {
    Object localObject = (ImageView)a(R.id.iv_show_code);
    if (localObject != null) {
      ((ImageView)localObject).setImageBitmap(a.a().b());
    }
    localObject = a.a();
    h.a(localObject, "VerificationCodeView.getInstance()");
    localObject = ((a)localObject).c();
    h.a(localObject, "VerificationCodeView.getInstance().code");
    if (localObject != null)
    {
      localObject = ((String)localObject).toLowerCase();
      h.a(localObject, "(this as java.lang.String).toLowerCase()");
      this.b = ((String)localObject);
      return;
    }
    throw new b("null cannot be cast to non-null type java.lang.String");
  }
  
  private final void c(String paramString)
  {
    paramString = new OneButtonDialog((Context)this, 2131755512, "", paramString, "", (OneButtonDialog.a)e.a);
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 1000) {
      return;
    }
    if (paramInt2 != -1) {
      return;
    }
    if (paramIntent == null) {
      h.a();
    }
    if (paramIntent.getBooleanExtra("isChange", false)) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492900);
    c();
    b();
  }
  
  public static final class a {}
  
  static final class b
    implements View.OnClickListener
  {
    b(ForgetPasswordActivity paramForgetPasswordActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(ForgetPasswordActivity paramForgetPasswordActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = (ImageView)this.a.a(R.id.iv_show_code);
      if (paramView != null) {
        paramView.setImageBitmap(a.a().b());
      }
      paramView = this.a;
      Object localObject = a.a();
      h.a(localObject, "VerificationCodeView.getInstance()");
      localObject = ((a)localObject).c();
      h.a(localObject, "VerificationCodeView.getInstance().code");
      if (localObject != null)
      {
        localObject = ((String)localObject).toLowerCase();
        h.a(localObject, "(this as java.lang.String).toLowerCase()");
        ForgetPasswordActivity.a(paramView, (String)localObject);
        return;
      }
      throw new b("null cannot be cast to non-null type java.lang.String");
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(ForgetPasswordActivity paramForgetPasswordActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = (EditText)this.a.a(R.id.et_phone_number);
      Object localObject = null;
      if (paramView != null) {
        paramView = paramView.getText();
      } else {
        paramView = null;
      }
      String str1 = String.valueOf(paramView);
      paramView = (EditText)this.a.a(R.id.et_sn_code);
      if (paramView != null) {
        paramView = paramView.getText();
      } else {
        paramView = null;
      }
      String str2 = String.valueOf(paramView);
      EditText localEditText = (EditText)this.a.a(R.id.et_verification_code);
      paramView = (View)localObject;
      if (localEditText != null) {
        paramView = localEditText.getText();
      }
      paramView = String.valueOf(paramView);
      if (ForgetPasswordActivity.a(this.a, str1, str2, paramView))
      {
        ForgetPasswordActivity.a(this.a).setPhoneNumber(str1);
        ForgetPasswordActivity.a(this.a).setSnCode(str2);
        paramView = new Intent((Context)this.a, GetVerificationCodeActivity.class);
        paramView.putExtra("forgetPwdModel", (Serializable)ForgetPasswordActivity.a(this.a));
        this.a.startActivityForResult(paramView, 1000);
      }
    }
  }
  
  static final class e
    implements OneButtonDialog.a
  {
    public static final e a = new e();
    
    public final void a(String paramString)
    {
      h.a("confirm_btn", paramString);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\login\ForgetPasswordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */