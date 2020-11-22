package com.totoro.school.activity.mine;

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
import com.totoro.school.activity.login.LoginActivity;
import com.totoro.school.entity.common.verificationcode.VerificationCodeReturnModel;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.entity.mine.changephone.ChangePhoneRequestModel;
import com.totoro.school.entity.mine.changephone.ChangePhoneReturnModel;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.utils.i;
import com.totoro.school.utils.n;
import com.totoro.school.view.dialog.OneButtonDialog;
import com.totoro.school.view.dialog.OneButtonDialog.a;
import d.c.b.h;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public final class ChangePhoneActivity
  extends BaseActivity
{
  private com.totoro.school.e.c a;
  private com.totoro.school.e.b b;
  private LoginReturnModel c;
  private boolean d;
  private boolean e;
  private Timer f;
  private int g;
  private String h = "";
  private HashMap i;
  
  private final void b()
  {
    Object localObject = (TextView)a(R.id.title_text);
    h.a(localObject, "title_text");
    ((TextView)localObject).setText((CharSequence)getString(2131689533));
    TextView localTextView = (TextView)a(R.id.old_phone);
    h.a(localTextView, "old_phone");
    localObject = this.c;
    if (localObject != null) {
      localObject = ((LoginReturnModel)localObject).getPhoneNumber();
    } else {
      localObject = null;
    }
    localTextView.setText((CharSequence)localObject);
    localObject = (TextView)a(R.id.confirm_btn);
    h.a(localObject, "confirm_btn");
    ((TextView)localObject).setClickable(false);
  }
  
  private final void c()
  {
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new b(this));
    ((TextView)a(R.id.confirm_btn)).setOnClickListener((View.OnClickListener)new c(this));
    ((TextView)a(R.id.send_vcode)).setOnClickListener((View.OnClickListener)new d(this));
  }
  
  private final void c(String paramString)
  {
    paramString = new OneButtonDialog((Context)this, 2131755512, "", paramString, "", (OneButtonDialog.a)new e(this));
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
  
  private final boolean d()
  {
    if (!this.e)
    {
      localObject = getString(2131689653);
      h.a(localObject, "getString(R.string.please_send_verification_code)");
      c((String)localObject);
      return false;
    }
    Object localObject = this.h;
    EditText localEditText = (EditText)a(R.id.verification_code);
    h.a(localEditText, "verification_code");
    if ((h.a(localObject, localEditText.getText().toString()) ^ true))
    {
      localObject = getString(2131689741);
      h.a(localObject, "getString(R.string.verification_code_not_correct)");
      c((String)localObject);
      return false;
    }
    localObject = (EditText)a(R.id.new_phone);
    h.a(localObject, "new_phone");
    int j;
    if (((CharSequence)((EditText)localObject).getText().toString()).length() == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      localObject = getString(2131689616);
      h.a(localObject, "getString(R.string.new_phone_hint)");
      c((String)localObject);
      return false;
    }
    localObject = (EditText)a(R.id.confirm_new_phone);
    h.a(localObject, "confirm_new_phone");
    if (((CharSequence)((EditText)localObject).getText().toString()).length() == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      localObject = getString(2131689543);
      h.a(localObject, "getString(R.string.confirm_new_phone_hint)");
      c((String)localObject);
      return false;
    }
    localObject = (EditText)a(R.id.new_phone);
    h.a(localObject, "new_phone");
    localObject = ((EditText)localObject).getText().toString();
    localEditText = (EditText)a(R.id.confirm_new_phone);
    h.a(localEditText, "confirm_new_phone");
    if ((h.a(localObject, localEditText.getText().toString()) ^ true))
    {
      localObject = getString(2131689647);
      h.a(localObject, "getString(R.string.phone_are_inconsistent)");
      c((String)localObject);
      return false;
    }
    return true;
  }
  
  private final void e()
  {
    ChangePhoneRequestModel localChangePhoneRequestModel = new ChangePhoneRequestModel();
    Object localObject1 = this.c;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((LoginReturnModel)localObject1).getSchoolID();
    } else {
      localObject1 = null;
    }
    localChangePhoneRequestModel.setSchoolName((String)localObject1);
    LoginReturnModel localLoginReturnModel = this.c;
    localObject1 = localObject2;
    if (localLoginReturnModel != null) {
      localObject1 = localLoginReturnModel.getSnCode();
    }
    localChangePhoneRequestModel.setSnCode((String)localObject1);
    localObject1 = (TextView)a(R.id.old_phone);
    h.a(localObject1, "old_phone");
    localChangePhoneRequestModel.setOldphoneNumber(((TextView)localObject1).getText().toString());
    localObject1 = (EditText)a(R.id.new_phone);
    h.a(localObject1, "new_phone");
    localChangePhoneRequestModel.setNewphoneNumber(((EditText)localObject1).getText().toString());
    localChangePhoneRequestModel.setvCode(this.h);
    localObject1 = this.a;
    if (localObject1 != null) {
      ((com.totoro.school.e.c)localObject1).a(localChangePhoneRequestModel);
    }
  }
  
  private final void f()
  {
    this.f = new Timer();
    this.g = 60;
    Timer localTimer = this.f;
    if (localTimer != null) {
      localTimer.schedule((TimerTask)new a(this), 0L, 1000L);
    }
  }
  
  public View a(int paramInt)
  {
    if (this.i == null) {
      this.i = new HashMap();
    }
    View localView2 = (View)this.i.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.i.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a(String paramString, Object paramObject)
  {
    h.b(paramString, "path");
    h.b(paramObject, "o");
    super.a(paramString, paramObject);
    int j = paramString.hashCode();
    if (j != 247279647)
    {
      if (j != 1005041896) {
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
          j = ((String)paramObject).hashCode();
          if (j != 1715960)
          {
            switch (j)
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
          if (((String)paramObject).equals("8000"))
          {
            paramString = paramString.getVcode();
            h.a(paramString, "returnModel.vcode");
            this.h = paramString;
          }
        }
      }
    }
    else if (paramString.equals("change_phone"))
    {
      paramString = (ChangePhoneReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, ChangePhoneReturnModel.class);
      if (paramString != null)
      {
        paramString = paramString.getCode();
        if ((paramString != null) && (paramString.hashCode() == 1715960) && (paramString.equals("8000")))
        {
          this.d = true;
          paramString = getString(2131689535);
          h.a(paramString, "getString(R.string.change_phone_success)");
          c(paramString);
          return;
        }
        paramString = getString(2131689534);
        h.a(paramString, "getString(R.string.change_phone_failed)");
        c(paramString);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492898);
    paramBundle = (com.totoro.school.utilpub.network.c)this;
    this.a = new com.totoro.school.e.c(paramBundle);
    this.b = new com.totoro.school.e.b(paramBundle);
    this.c = i.a();
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
      a(ChangePhoneActivity.a parama) {}
      
      public final void run()
      {
        Object localObject = this.a.a;
        ChangePhoneActivity.a((ChangePhoneActivity)localObject, ChangePhoneActivity.f((ChangePhoneActivity)localObject) - 1);
        if (ChangePhoneActivity.f(this.a.a) < 0)
        {
          localObject = ChangePhoneActivity.g(this.a.a);
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
        localStringBuilder.append(ChangePhoneActivity.f(this.a.a));
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
    b(ChangePhoneActivity paramChangePhoneActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(ChangePhoneActivity paramChangePhoneActivity) {}
    
    public final void onClick(View paramView)
    {
      if (ChangePhoneActivity.a(this.a)) {
        ChangePhoneActivity.b(this.a);
      }
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(ChangePhoneActivity paramChangePhoneActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = (TextView)this.a.a(R.id.old_phone);
      h.a(paramView, "old_phone");
      if (!TextUtils.isEmpty((CharSequence)paramView.getText().toString()))
      {
        ChangePhoneActivity.a(this.a, true);
        ChangePhoneActivity.c(this.a);
        paramView = (TextView)this.a.a(R.id.send_vcode);
        h.a(paramView, "send_vcode");
        paramView.setClickable(false);
        ((TextView)this.a.a(R.id.confirm_btn)).setBackgroundResource(2131230864);
        paramView = ChangePhoneActivity.d(this.a);
        if (paramView != null)
        {
          TextView localTextView = (TextView)this.a.a(R.id.old_phone);
          h.a(localTextView, "old_phone");
          paramView.a(localTextView.getText().toString());
        }
      }
    }
  }
  
  static final class e
    implements OneButtonDialog.a
  {
    e(ChangePhoneActivity paramChangePhoneActivity) {}
    
    public final void a(String paramString)
    {
      if ((h.a("confirm_btn", paramString)) && (ChangePhoneActivity.e(this.a)))
      {
        System.gc();
        n.a(this.a.getApplicationContext(), "autoLogin", Boolean.valueOf(false));
        paramString = new Intent((Context)this.a, LoginActivity.class);
        paramString.setFlags(268468224);
        this.a.startActivity(paramString);
        this.a.finish();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\mine\ChangePhoneActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */