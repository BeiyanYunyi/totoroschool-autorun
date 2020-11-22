package com.totoro.school.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.load.resource.bitmap.d;
import com.totoro.school.R.id;
import com.totoro.school.activity.login.LoginActivity;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.entity.mine.personal.PersonalDataModel;
import com.totoro.school.entity.mine.personal.PersonalDataRequestModel;
import com.totoro.school.entity.mine.personal.PersonalDataReturnModel;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.utils.i;
import com.totoro.school.utils.n;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public final class PersonalDataActivity
  extends BaseActivity
{
  private com.totoro.school.e.c a;
  private LoginReturnModel b;
  private HashMap c;
  
  private final void b()
  {
    TextView localTextView = (TextView)a(R.id.title_text);
    d.c.b.h.a(localTextView, "title_text");
    localTextView.setText((CharSequence)getString(2131689605));
    com.bumptech.glide.e.a((FragmentActivity)this).a(Integer.valueOf(2131558452)).d().a(new d[] { (d)new com.totoro.school.utils.glide.a(getApplicationContext()) }).a(2131558452).a((ImageView)a(R.id.head_image));
  }
  
  private final void c()
  {
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new b(this));
    ((TextView)a(R.id.exit_btn)).setOnClickListener((View.OnClickListener)new c(this));
  }
  
  private final void d()
  {
    Object localObject1 = this.b;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((LoginReturnModel)localObject1).getSchoolID();
    } else {
      localObject1 = null;
    }
    LoginReturnModel localLoginReturnModel = this.b;
    if (localLoginReturnModel != null) {
      localObject2 = localLoginReturnModel.getSnCode();
    }
    localObject1 = new PersonalDataRequestModel((String)localObject1, (String)localObject2);
    localObject2 = this.a;
    if (localObject2 != null) {
      ((com.totoro.school.e.c)localObject2).a((PersonalDataRequestModel)localObject1);
    }
  }
  
  public View a(int paramInt)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    View localView2 = (View)this.c.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.c.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.hashCode() != -51535198) {
      return;
    }
    if (paramString.equals("get_stu_info"))
    {
      paramString = (PersonalDataReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, PersonalDataReturnModel.class);
      if (paramString != null)
      {
        paramObject = paramString.getCode();
        if (paramObject == null) {
          return;
        }
        if (((String)paramObject).hashCode() != 1715960) {
          return;
        }
        if (((String)paramObject).equals("8000"))
        {
          paramObject = paramString.getStudentlist();
          d.c.b.h.a(paramObject, "returnModel.studentlist");
          int i;
          if (((CharSequence)paramObject).length() > 0) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            paramString = (List)new com.google.gson.e().a(paramString.getStudentlist(), new a().b());
            d.c.b.h.a(paramString, "dataList");
            if ((((Collection)paramString).isEmpty() ^ true))
            {
              PersonalDataModel localPersonalDataModel = (PersonalDataModel)paramString.get(0);
              TextView localTextView = (TextView)a(R.id.stu_name);
              d.c.b.h.a(localTextView, "stu_name");
              paramObject = null;
              if (localPersonalDataModel != null) {
                paramString = localPersonalDataModel.getStuName();
              } else {
                paramString = null;
              }
              localTextView.setText((CharSequence)paramString);
              localTextView = (TextView)a(R.id.sex);
              d.c.b.h.a(localTextView, "sex");
              if (localPersonalDataModel != null) {
                paramString = localPersonalDataModel.getSex();
              } else {
                paramString = null;
              }
              localTextView.setText((CharSequence)paramString);
              localTextView = (TextView)a(R.id.birthday);
              d.c.b.h.a(localTextView, "birthday");
              if (localPersonalDataModel != null) {
                paramString = localPersonalDataModel.getBirthdate();
              } else {
                paramString = null;
              }
              localTextView.setText((CharSequence)paramString);
              localTextView = (TextView)a(R.id.id_number);
              d.c.b.h.a(localTextView, "id_number");
              if (localPersonalDataModel != null) {
                paramString = localPersonalDataModel.getCardid();
              } else {
                paramString = null;
              }
              localTextView.setText((CharSequence)paramString);
              localTextView = (TextView)a(R.id.school_name);
              d.c.b.h.a(localTextView, "school_name");
              paramString = this.b;
              if (paramString != null) {
                paramString = paramString.getSchoolName();
              } else {
                paramString = null;
              }
              localTextView.setText((CharSequence)paramString);
              localTextView = (TextView)a(R.id.college_name);
              d.c.b.h.a(localTextView, "college_name");
              if (localPersonalDataModel != null) {
                paramString = localPersonalDataModel.getCollegesName();
              } else {
                paramString = null;
              }
              localTextView.setText((CharSequence)paramString);
              localTextView = (TextView)a(R.id.administrative_class);
              d.c.b.h.a(localTextView, "administrative_class");
              if (localPersonalDataModel != null) {
                paramString = localPersonalDataModel.getClassName();
              } else {
                paramString = null;
              }
              localTextView.setText((CharSequence)paramString);
              localTextView = (TextView)a(R.id.teaching_class);
              d.c.b.h.a(localTextView, "teaching_class");
              paramString = (String)paramObject;
              if (localPersonalDataModel != null) {
                paramString = localPersonalDataModel.getCurclass();
              }
              localTextView.setText((CharSequence)paramString);
            }
          }
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492910);
    this.b = i.a();
    this.a = new com.totoro.school.e.c((com.totoro.school.utilpub.network.c)this);
    b();
    c();
    d();
  }
  
  public static final class a
    extends com.google.gson.c.a<List<? extends PersonalDataModel>>
  {}
  
  static final class b
    implements View.OnClickListener
  {
    b(PersonalDataActivity paramPersonalDataActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(PersonalDataActivity paramPersonalDataActivity) {}
    
    public final void onClick(View paramView)
    {
      System.gc();
      n.a(this.a.getApplicationContext(), "autoLogin", Boolean.valueOf(false));
      paramView = new Intent((Context)this.a, LoginActivity.class);
      paramView.setFlags(268468224);
      this.a.startActivity(paramView);
      this.a.finish();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\mine\PersonalDataActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */