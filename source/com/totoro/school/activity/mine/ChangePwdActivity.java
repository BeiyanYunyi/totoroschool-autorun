package com.totoro.school.activity.mine;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.totoro.school.R.id;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.entity.login.password.change.ChangePasswordRequestModel;
import com.totoro.school.entity.login.password.change.ChangePasswordReturnModel;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.utilpub.network.a.b;
import com.totoro.school.utils.i;
import com.totoro.school.view.dialog.OneButtonDialog;
import com.totoro.school.view.dialog.OneButtonDialog.a;
import d.c.b.h;
import java.util.HashMap;

public final class ChangePwdActivity
  extends BaseActivity
{
  private com.totoro.school.e.c a;
  private LoginReturnModel b;
  private boolean c;
  private HashMap d;
  
  private final void b()
  {
    TextView localTextView = (TextView)a(R.id.title_text);
    h.a(localTextView, "title_text");
    localTextView.setText((CharSequence)getString(2131689532));
  }
  
  private final void c()
  {
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new a(this));
    ((TextView)a(R.id.confirm_btn)).setOnClickListener((View.OnClickListener)new b(this));
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
  
  private final boolean d()
  {
    Object localObject = (EditText)a(R.id.old_password);
    h.a(localObject, "old_password");
    int i;
    if (((CharSequence)((EditText)localObject).getText().toString()).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = getString(2131689626);
      h.a(localObject, "getString(R.string.old_password_hint)");
      c((String)localObject);
      return false;
    }
    localObject = (EditText)a(R.id.new_password);
    h.a(localObject, "new_password");
    if (((CharSequence)((EditText)localObject).getText().toString()).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = getString(2131689614);
      h.a(localObject, "getString(R.string.new_password_hint)");
      c((String)localObject);
      return false;
    }
    localObject = (EditText)a(R.id.confirm_password);
    h.a(localObject, "confirm_password");
    if (((CharSequence)((EditText)localObject).getText().toString()).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = getString(2131689545);
      h.a(localObject, "getString(R.string.confirm_password_hint)");
      c((String)localObject);
      return false;
    }
    localObject = (EditText)a(R.id.confirm_password);
    h.a(localObject, "confirm_password");
    localObject = ((EditText)localObject).getText().toString();
    EditText localEditText = (EditText)a(R.id.new_password);
    h.a(localEditText, "new_password");
    if ((h.a(localObject, localEditText.getText().toString()) ^ true))
    {
      localObject = getString(2131689631);
      h.a(localObject, "getString(R.string.passwords_are_inconsistent)");
      c((String)localObject);
      return false;
    }
    return true;
  }
  
  private final void e()
  {
    ChangePasswordRequestModel localChangePasswordRequestModel = new ChangePasswordRequestModel();
    Object localObject1 = this.b;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((LoginReturnModel)localObject1).getSchoolID();
    } else {
      localObject1 = null;
    }
    localChangePasswordRequestModel.setSchoolName((String)localObject1);
    localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = ((LoginReturnModel)localObject1).getSnCode();
    } else {
      localObject1 = null;
    }
    localChangePasswordRequestModel.setSnCode((String)localObject1);
    LoginReturnModel localLoginReturnModel = this.b;
    localObject1 = localObject2;
    if (localLoginReturnModel != null) {
      localObject1 = localLoginReturnModel.getPhoneNumber();
    }
    localChangePasswordRequestModel.setPhoneNumber((String)localObject1);
    localObject1 = (EditText)a(R.id.old_password);
    h.a(localObject1, "old_password");
    localChangePasswordRequestModel.setOldPwd(((EditText)localObject1).getText().toString());
    localObject1 = (EditText)a(R.id.new_password);
    h.a(localObject1, "new_password");
    localChangePasswordRequestModel.setNewPwd(((EditText)localObject1).getText().toString());
    localChangePasswordRequestModel.setFlag("0");
    localObject1 = this.a;
    if (localObject1 != null) {
      ((com.totoro.school.e.c)localObject1).a(localChangePasswordRequestModel);
    }
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
    if (paramString.hashCode() != 931431019) {
      return;
    }
    if (paramString.equals("changePassword"))
    {
      paramString = (ChangePasswordReturnModel)b.a(paramObject, ChangePasswordReturnModel.class);
      if (paramString != null)
      {
        paramString = paramString.getCode();
        if ((paramString != null) && (paramString.hashCode() == 1715960) && (paramString.equals("8000")))
        {
          this.c = true;
          c("密码修改成功");
          return;
        }
        c("密码修改失败");
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492899);
    this.a = new com.totoro.school.e.c((com.totoro.school.utilpub.network.c)this);
    this.b = i.a();
    b();
    c();
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(ChangePwdActivity paramChangePwdActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(ChangePwdActivity paramChangePwdActivity) {}
    
    public final void onClick(View paramView)
    {
      if (ChangePwdActivity.a(this.a)) {
        ChangePwdActivity.b(this.a);
      }
    }
  }
  
  static final class c
    implements OneButtonDialog.a
  {
    c(ChangePwdActivity paramChangePwdActivity) {}
    
    public final void a(String paramString)
    {
      if ((h.a("confirm_btn", paramString)) && (ChangePwdActivity.c(this.a))) {
        this.a.finish();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\mine\ChangePwdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */