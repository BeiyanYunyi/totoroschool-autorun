package com.totoro.school.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.gson.e;
import com.totoro.school.entity.common.campus.CampusListModel;
import com.totoro.school.entity.common.campus.GetCampusListReturnModel;
import com.totoro.school.entity.common.school.GetSchoolListReturnModel;
import com.totoro.school.entity.common.school.SchoolListModel;
import com.totoro.school.entity.login.authentication.AuthReturnModel;
import com.totoro.school.entity.login.register.RegisterRequestModel;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.view.dialog.OneButtonDialog;
import com.totoro.school.view.dialog.OneButtonDialog.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.angmarch.views.NiceSpinner;

public class AuthenticationActivity
  extends BaseActivity
{
  private com.totoro.school.e.b a;
  private com.totoro.school.e.a b;
  private String c;
  @BindView(2131296314)
  NiceSpinner campusSpinner;
  private String d;
  private RegisterRequestModel e = new RegisterRequestModel();
  private LinkedList f = new LinkedList();
  private LinkedList g = new LinkedList();
  @BindView(2131296559)
  NiceSpinner schoolSpinner;
  @BindView(2131296693)
  EditText tvIdNumber;
  @BindView(2131296705)
  EditText tvSnCode;
  @BindView(2131296706)
  EditText tvStuName;
  
  private void a(final GetCampusListReturnModel paramGetCampusListReturnModel)
  {
    if ((paramGetCampusListReturnModel != null) && (paramGetCampusListReturnModel.getCampuslist() != null) && (paramGetCampusListReturnModel.getCampuslist().length() > 0))
    {
      paramGetCampusListReturnModel = (List)new e().a(paramGetCampusListReturnModel.getCampuslist(), new com.google.gson.c.a() {}.b());
      this.g.clear();
      Iterator localIterator = paramGetCampusListReturnModel.iterator();
      while (localIterator.hasNext())
      {
        CampusListModel localCampusListModel = (CampusListModel)localIterator.next();
        this.g.add(localCampusListModel.getName());
      }
      this.campusSpinner.a(this.g);
      this.campusSpinner.addOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AuthenticationActivity.b(AuthenticationActivity.this, ((CampusListModel)paramGetCampusListReturnModel.get(paramAnonymousInt)).getId());
        }
      });
      if ((paramGetCampusListReturnModel != null) && (paramGetCampusListReturnModel.size() > 0)) {
        this.d = ((CampusListModel)paramGetCampusListReturnModel.get(0)).getId();
      }
    }
    else
    {
      this.g.clear();
      this.g.add("");
      this.campusSpinner.a(this.g);
      this.d = "";
    }
  }
  
  private void a(final GetSchoolListReturnModel paramGetSchoolListReturnModel)
  {
    if ((paramGetSchoolListReturnModel != null) && (paramGetSchoolListReturnModel.getSchoollist() != null) && (paramGetSchoolListReturnModel.getSchoollist().length() > 0))
    {
      paramGetSchoolListReturnModel = (List)new e().a(paramGetSchoolListReturnModel.getSchoollist(), new com.google.gson.c.a() {}.b());
      this.f.clear();
      Iterator localIterator = paramGetSchoolListReturnModel.iterator();
      while (localIterator.hasNext())
      {
        SchoolListModel localSchoolListModel = (SchoolListModel)localIterator.next();
        this.f.add(localSchoolListModel.getName());
      }
      this.schoolSpinner.a(this.f);
      this.schoolSpinner.addOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AuthenticationActivity.a(AuthenticationActivity.this, ((SchoolListModel)paramGetSchoolListReturnModel.get(paramAnonymousInt)).getId());
          AuthenticationActivity.b(AuthenticationActivity.this).b(AuthenticationActivity.a(AuthenticationActivity.this));
        }
      });
      if ((paramGetSchoolListReturnModel != null) && (paramGetSchoolListReturnModel.size() > 0))
      {
        this.c = ((SchoolListModel)paramGetSchoolListReturnModel.get(0)).getId();
        this.a.b(((SchoolListModel)paramGetSchoolListReturnModel.get(0)).getId());
      }
    }
  }
  
  private void c(String paramString)
  {
    paramString = new OneButtonDialog(this, 2131755512, "", paramString, "", new OneButtonDialog.a()
    {
      public void a(String paramAnonymousString) {}
    });
    Window localWindow = paramString.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localWindow.setGravity(17);
    localWindow.setAttributes(localLayoutParams);
    paramString.setCanceledOnTouchOutside(true);
    paramString.setCancelable(true);
    paramString.show();
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    int i = paramString.hashCode();
    int j = 2;
    if (i != -2127383776)
    {
      if (i != -521974635)
      {
        if ((i == -237767535) && (paramString.equals("auth_request_data")))
        {
          i = 2;
          break label79;
        }
      }
      else if (paramString.equals("get_campus_list"))
      {
        i = 1;
        break label79;
      }
    }
    else if (paramString.equals("get_school_list"))
    {
      i = 0;
      break label79;
    }
    i = -1;
    switch (i)
    {
    default: 
      
    case 2: 
      paramString = (AuthReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, AuthReturnModel.class);
      if (paramString != null)
      {
        paramString = paramString.getCode();
        i = paramString.hashCode();
        if (i != 1715960)
        {
          switch (i)
          {
          default: 
            break;
          case 1507425: 
            if (!paramString.equals("1002")) {
              break;
            }
            i = 3;
            break;
          case 1507424: 
            if (!paramString.equals("1001")) {
              break;
            }
            i = j;
            break;
          case 1507423: 
            if (!paramString.equals("1000")) {
              break;
            }
            i = 1;
            break;
          }
        }
        else if (paramString.equals("8000"))
        {
          i = 0;
          break label230;
        }
        i = -1;
        switch (i)
        {
        default: 
          return;
        case 3: 
          c(getString(2131689711));
          return;
        case 2: 
          c(getString(2131689708));
          return;
        case 1: 
          c(getString(2131689709));
          return;
        }
        paramString = new Intent(this, RegisterActivity.class);
        paramString.putExtra("registerModel", this.e);
        startActivity(paramString);
        return;
      }
      break;
    case 1: 
      a((GetCampusListReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, GetCampusListReturnModel.class));
      return;
    case 0: 
      label79:
      label230:
      a((GetSchoolListReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, GetSchoolListReturnModel.class));
    }
  }
  
  @OnClick({2131296680})
  public void auth(View paramView)
  {
    paramView = this.tvSnCode.getText().toString();
    String str1 = this.tvIdNumber.getText().toString();
    String str2 = this.tvStuName.getText().toString();
    if ((!TextUtils.isEmpty(paramView)) && (!TextUtils.isEmpty(str2)))
    {
      this.b.a(paramView, str2, str1, this.c, this.d);
      this.e.setSnCode(paramView);
      this.e.setStuName(str2);
      this.e.setIdNumber(str1);
      this.e.setSchoolName(this.c);
      this.e.setSchoolarea(this.d);
    }
  }
  
  @OnClick({2131296298})
  public void back(View paramView)
  {
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492895);
    ButterKnife.bind(this);
    this.a = new com.totoro.school.e.b(this);
    this.b = new com.totoro.school.e.a(this);
    this.a.a("", "", "");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\login\AuthenticationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */