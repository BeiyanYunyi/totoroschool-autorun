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
import com.totoro.school.entity.common.verificationcode.VerificationCodeReturnModel;
import com.totoro.school.entity.login.password.forget.ForgetPasswordRequestModel;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.utilpub.network.c;
import com.totoro.school.view.dialog.OneButtonDialog;
import com.totoro.school.view.dialog.OneButtonDialog.a;
import d.c.b.h;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public final class GetVerificationCodeActivity
  extends BaseActivity
{
  private com.totoro.school.e.b a;
  private ForgetPasswordRequestModel b;
  private String c;
  private boolean d;
  private Timer e;
  private int f;
  private final int g = 1000;
  private HashMap h;
  
  private final void b()
  {
    Object localObject1 = this.b;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((ForgetPasswordRequestModel)localObject1).getPhoneNumber();
    } else {
      localObject1 = null;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.d = true;
      e();
      localObject1 = (TextView)a(R.id.send_vcode);
      h.a(localObject1, "send_vcode");
      ((TextView)localObject1).setClickable(false);
      com.totoro.school.e.b localb = this.a;
      if (localb != null)
      {
        ForgetPasswordRequestModel localForgetPasswordRequestModel = this.b;
        localObject1 = localObject2;
        if (localForgetPasswordRequestModel != null) {
          localObject1 = localForgetPasswordRequestModel.getPhoneNumber();
        }
        localb.a((String)localObject1);
      }
    }
  }
  
  private final void c()
  {
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new b(this));
    ((TextView)a(R.id.send_vcode)).setOnClickListener((View.OnClickListener)new c(this));
    ((TextView)a(R.id.tv_confirm)).setOnClickListener((View.OnClickListener)new d(this));
    ((TextView)a(R.id.tv_unable_receive)).setOnClickListener((View.OnClickListener)new e(this));
  }
  
  private final boolean c(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = getString(2131689555);
      h.a(paramString, "getString(R.string.enter_verification_code)");
      d(paramString);
      return false;
    }
    if ((h.a(paramString, this.c) ^ true))
    {
      paramString = getString(2131689741);
      h.a(paramString, "getString(R.string.verification_code_not_correct)");
      d(paramString);
      return false;
    }
    return true;
  }
  
  private final void d()
  {
    Serializable localSerializable = getIntent().getSerializableExtra("forgetPwdModel");
    if (localSerializable != null)
    {
      this.b = ((ForgetPasswordRequestModel)localSerializable);
      return;
    }
    throw new d.b("null cannot be cast to non-null type com.totoro.school.entity.login.password.forget.ForgetPasswordRequestModel");
  }
  
  private final void d(String paramString)
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
  
  private final void e()
  {
    this.e = new Timer();
    this.f = 60;
    Timer localTimer = this.e;
    if (localTimer != null) {
      localTimer.schedule((TimerTask)new a(this), 0L, 1000L);
    }
  }
  
  public View a(int paramInt)
  {
    if (this.h == null) {
      this.h = new HashMap();
    }
    View localView2 = (View)this.h.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.h.put(Integer.valueOf(paramInt), localView1);
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.g)
    {
      if (paramInt2 != -1) {
        return;
      }
      if (paramIntent != null) {
        paramIntent = Boolean.valueOf(paramIntent.getBooleanExtra("isChange", false));
      } else {
        paramIntent = null;
      }
      if (paramIntent == null) {
        h.a();
      }
      if (paramIntent.booleanValue())
      {
        paramIntent = new Intent();
        paramIntent.putExtra("isChange", true);
        setResult(-1, paramIntent);
        finish();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492901);
    ButterKnife.bind((Activity)this);
    this.a = new com.totoro.school.e.b((c)this);
    d();
    b();
    c();
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
      a(GetVerificationCodeActivity.a parama) {}
      
      public final void run()
      {
        Object localObject = this.a.a;
        GetVerificationCodeActivity.a((GetVerificationCodeActivity)localObject, GetVerificationCodeActivity.d((GetVerificationCodeActivity)localObject) - 1);
        if (GetVerificationCodeActivity.d(this.a.a) < 0)
        {
          localObject = GetVerificationCodeActivity.e(this.a.a);
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
        localStringBuilder.append(GetVerificationCodeActivity.d(this.a.a));
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
    b(GetVerificationCodeActivity paramGetVerificationCodeActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(GetVerificationCodeActivity paramGetVerificationCodeActivity) {}
    
    public final void onClick(View paramView)
    {
      GetVerificationCodeActivity.a(this.a);
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(GetVerificationCodeActivity paramGetVerificationCodeActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = (EditText)this.a.a(R.id.et_verification_code);
      h.a(paramView, "et_verification_code");
      paramView = paramView.getText().toString();
      if (GetVerificationCodeActivity.a(this.a, paramView))
      {
        ForgetPasswordRequestModel localForgetPasswordRequestModel = GetVerificationCodeActivity.b(this.a);
        if (localForgetPasswordRequestModel != null) {
          localForgetPasswordRequestModel.setvCode(paramView);
        }
        paramView = new Intent((Context)this.a, ChangePasswordActivity.class);
        paramView.putExtra("forgetPwdModel", (Serializable)GetVerificationCodeActivity.b(this.a));
        this.a.startActivityForResult(paramView, GetVerificationCodeActivity.c(this.a));
      }
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(GetVerificationCodeActivity paramGetVerificationCodeActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = new Intent((Context)this.a, InfoAuthActivity.class);
      paramView.putExtra("forgetPwdModel", (Serializable)GetVerificationCodeActivity.b(this.a));
      this.a.startActivity(paramView);
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\login\GetVerificationCodeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */