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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.totoro.school.R.id;
import com.totoro.school.activity.common.PDFActivity;
import com.totoro.school.entity.common.verificationcode.VerificationCodeReturnModel;
import com.totoro.school.entity.login.register.RegisterRequestModel;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.utilpub.network.c;
import com.totoro.school.view.dialog.OneButtonDialog;
import com.totoro.school.view.dialog.OneButtonDialog.a;
import d.c.b.h;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public final class RegisterActivity
  extends BaseActivity
{
  private com.totoro.school.e.b a;
  private RegisterRequestModel b;
  private String c;
  private boolean d;
  private Timer e;
  private int f;
  private HashMap g;
  
  private final boolean a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty((CharSequence)paramString1)) && (paramString1.length() == 11))
    {
      if (TextUtils.isEmpty((CharSequence)paramString2))
      {
        paramString1 = getString(2131689555);
        h.a(paramString1, "getString(R.string.enter_verification_code)");
        c(paramString1);
        return false;
      }
      if ((h.a(paramString2, this.c) ^ true))
      {
        paramString1 = getString(2131689741);
        h.a(paramString1, "getString(R.string.verification_code_not_correct)");
        c(paramString1);
        return false;
      }
      return true;
    }
    paramString1 = getString(2131689651);
    h.a(paramString1, "getString(R.string.please_enter_phone_number)");
    c(paramString1);
    return false;
  }
  
  private final void b()
  {
    this.e = new Timer();
    this.f = 60;
    Timer localTimer = this.e;
    if (localTimer != null) {
      localTimer.schedule((TimerTask)new a(this), 0L, 1000L);
    }
  }
  
  private final void c(String paramString)
  {
    paramString = new OneButtonDialog((Context)this, 2131755512, "", paramString, "", (OneButtonDialog.a)f.a);
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
    if (this.g == null) {
      this.g = new HashMap();
    }
    View localView2 = (View)this.g.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.g.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a(String paramString, Object paramObject)
  {
    h.b(paramString, "path");
    h.b(paramObject, "o");
    super.a(paramString, paramObject);
    if (paramString.hashCode() != 1005041896) {
      return;
    }
    if (paramString.equals("get_verification_code"))
    {
      paramString = (VerificationCodeReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, VerificationCodeReturnModel.class);
      if (paramString != null)
      {
        paramObject = paramString.getCode();
        if (paramObject == null) {
          return;
        }
        int i = ((String)paramObject).hashCode();
        if (i != 1715960)
        {
          switch (i)
          {
          default: 
            return;
          }
          for (paramString = "1003";; paramString = "1002")
          {
            ((String)paramObject).equals(paramString);
            return;
          }
        }
        if (((String)paramObject).equals("8000")) {
          this.c = paramString.getVcode();
        }
      }
    }
  }
  
  public final void c_()
  {
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new b(this));
    ((TextView)a(R.id.tv_register)).setOnClickListener((View.OnClickListener)new c(this));
    ((TextView)a(R.id.clause_btn)).setOnClickListener((View.OnClickListener)new d(this));
    ((TextView)a(R.id.send_vcode)).setOnClickListener((View.OnClickListener)new e(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492911);
    this.a = new com.totoro.school.e.b((c)this);
    paramBundle = getIntent().getSerializableExtra("registerModel");
    if (paramBundle != null)
    {
      this.b = ((RegisterRequestModel)paramBundle);
      c_();
      return;
    }
    throw new d.b("null cannot be cast to non-null type com.totoro.school.entity.login.register.RegisterRequestModel");
  }
  
  public static final class a
    extends TimerTask
  {
    public void run()
    {
      this.a.runOnUiThread((Runnable)new a(this));
    }
    
    static final class a
      implements Runnable
    {
      a(RegisterActivity.a parama) {}
      
      public final void run()
      {
        Object localObject = this.a.a;
        RegisterActivity.a((RegisterActivity)localObject, RegisterActivity.d((RegisterActivity)localObject) - 1);
        if (RegisterActivity.d(this.a.a) < 0)
        {
          localObject = RegisterActivity.e(this.a.a);
          if (localObject != null) {
            ((Timer)localObject).cancel();
          }
          localObject = (TextView)this.a.a.a(R.id.send_vcode);
          h.a(localObject, "send_vcode");
          ((TextView)localObject).setClickable(true);
          localObject = (TextView)this.a.a.a(R.id.send_vcode);
          h.a(localObject, "send_vcode");
          ((TextView)localObject).setText((CharSequence)this.a.a.getString(2131689565));
          ((TextView)this.a.a.a(R.id.send_vcode)).setBackgroundResource(2131558483);
          return;
        }
        localObject = (TextView)this.a.a.a(R.id.send_vcode);
        h.a(localObject, "send_vcode");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(RegisterActivity.d(this.a.a));
        ((TextView)localObject).setText((CharSequence)localStringBuilder.toString());
        localObject = (TextView)this.a.a.a(R.id.send_vcode);
        h.a(localObject, "send_vcode");
        ((TextView)localObject).setClickable(false);
        ((TextView)this.a.a.a(R.id.send_vcode)).setBackgroundResource(2131558482);
      }
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(RegisterActivity paramRegisterActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(RegisterActivity paramRegisterActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = (EditText)this.a.a(R.id.et_phone_number);
      h.a(paramView, "et_phone_number");
      paramView = paramView.getText().toString();
      Object localObject = (EditText)this.a.a(R.id.et_verification_code);
      h.a(localObject, "et_verification_code");
      localObject = ((EditText)localObject).getText().toString();
      if (RegisterActivity.a(this.a, paramView, (String)localObject))
      {
        RegisterRequestModel localRegisterRequestModel = RegisterActivity.a(this.a);
        if (localRegisterRequestModel != null) {
          localRegisterRequestModel.setPhoneNumber(paramView);
        }
        paramView = RegisterActivity.a(this.a);
        if (paramView != null) {
          paramView.setVerificationCode((String)localObject);
        }
        paramView = new Intent((Context)this.a, RegisterInfoActivity.class);
        paramView.putExtra("registerModel", (Serializable)RegisterActivity.a(this.a));
        this.a.startActivity(paramView);
      }
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(RegisterActivity paramRegisterActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = new Intent((Context)this.a, PDFActivity.class);
      paramView.putExtra("title", "服务条款");
      paramView.putExtra("fileName", "服务条款.pdf");
      paramView.putExtra("url", "http://news.xtotoro.com:8093/modelName/agreements.pdf");
      this.a.startActivity(paramView);
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(RegisterActivity paramRegisterActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = (EditText)this.a.a(R.id.et_phone_number);
      h.a(paramView, "et_phone_number");
      paramView = paramView.getText().toString();
      if ((TextUtils.isEmpty((CharSequence)paramView)) && (paramView.length() != 11))
      {
        paramView = this.a;
        localObject = this.a.getString(2131689651);
        h.a(localObject, "getString(R.string.please_enter_phone_number)");
        RegisterActivity.a(paramView, (String)localObject);
        return;
      }
      RegisterActivity.a(this.a, true);
      RegisterActivity.b(this.a);
      Object localObject = (TextView)this.a.a(R.id.send_vcode);
      h.a(localObject, "send_vcode");
      ((TextView)localObject).setClickable(false);
      localObject = RegisterActivity.c(this.a);
      if (localObject != null) {
        ((com.totoro.school.e.b)localObject).a(paramView);
      }
    }
  }
  
  static final class f
    implements OneButtonDialog.a
  {
    public static final f a = new f();
    
    public final void a(String paramString)
    {
      h.a("confirm_btn", paramString);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\login\RegisterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */