package com.totoro.school.frament.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.b;
import com.bumptech.glide.e;
import com.bumptech.glide.load.resource.bitmap.d;
import com.totoro.school.R.id;
import com.totoro.school.activity.common.PDFActivity;
import com.totoro.school.activity.mine.AboutAppActivity;
import com.totoro.school.activity.mine.AccountManageActivity;
import com.totoro.school.activity.mine.AppealSportRecordListActivity;
import com.totoro.school.activity.mine.PersonalDataActivity;
import com.totoro.school.activity.run.SportRecordListActivity;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.utils.i;
import java.util.HashMap;

public final class MineFragment
  extends Fragment
{
  private LoginReturnModel a;
  private boolean b = true;
  private HashMap c;
  
  private final void b()
  {
    TextView localTextView = (TextView)a(R.id.stu_name);
    d.c.b.h.a(localTextView, "stu_name");
    Object localObject1 = this.a;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((LoginReturnModel)localObject1).getStuName();
    } else {
      localObject1 = null;
    }
    localTextView.setText((CharSequence)localObject1);
    localTextView = (TextView)a(R.id.stu_no);
    d.c.b.h.a(localTextView, "stu_no");
    LoginReturnModel localLoginReturnModel = this.a;
    localObject1 = localObject2;
    if (localLoginReturnModel != null) {
      localObject1 = localLoginReturnModel.getSnCode();
    }
    localTextView.setText((CharSequence)localObject1);
    e.a(getActivity()).a(Integer.valueOf(2131558452)).d().a(new d[] { (d)new com.totoro.school.utils.glide.a((Context)getActivity()) }).a(2131558452).a((ImageView)a(R.id.head_image));
  }
  
  private final void c()
  {
    ((CardView)a(R.id.user_layout)).setOnClickListener((View.OnClickListener)new a(this));
    ((RelativeLayout)a(R.id.personal_data)).setOnClickListener((View.OnClickListener)new b(this));
    ((RelativeLayout)a(R.id.sports_detail)).setOnClickListener((View.OnClickListener)new c(this));
    ((RelativeLayout)a(R.id.appeal_btn)).setOnClickListener((View.OnClickListener)new d(this));
    ((RelativeLayout)a(R.id.my_venues)).setOnClickListener((View.OnClickListener)e.a);
    ((RelativeLayout)a(R.id.instructions)).setOnClickListener((View.OnClickListener)new f(this));
    ((RelativeLayout)a(R.id.about_app)).setOnClickListener((View.OnClickListener)new g(this));
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
      localView1 = getView();
      if (localView1 == null) {
        return null;
      }
      localView1 = localView1.findViewById(paramInt);
      this.c.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.clear();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    d.c.b.h.b(paramLayoutInflater, "inflater");
    return paramLayoutInflater.inflate(2131492945, paramViewGroup, false);
  }
  
  public void onResume()
  {
    if (this.b)
    {
      this.a = i.a();
      b();
      c();
    }
    super.onResume();
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(MineFragment paramMineFragment) {}
    
    public final void onClick(View paramView)
    {
      paramView = new Intent((Context)this.a.getActivity(), AccountManageActivity.class);
      FragmentActivity localFragmentActivity = this.a.getActivity();
      if (localFragmentActivity != null) {
        localFragmentActivity.startActivity(paramView);
      }
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(MineFragment paramMineFragment) {}
    
    public final void onClick(View paramView)
    {
      paramView = new Intent((Context)this.a.getActivity(), PersonalDataActivity.class);
      FragmentActivity localFragmentActivity = this.a.getActivity();
      if (localFragmentActivity != null) {
        localFragmentActivity.startActivity(paramView);
      }
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(MineFragment paramMineFragment) {}
    
    public final void onClick(View paramView)
    {
      paramView = new Intent((Context)this.a.getActivity(), SportRecordListActivity.class);
      FragmentActivity localFragmentActivity = this.a.getActivity();
      if (localFragmentActivity != null) {
        localFragmentActivity.startActivity(paramView);
      }
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(MineFragment paramMineFragment) {}
    
    public final void onClick(View paramView)
    {
      paramView = new Intent((Context)this.a.getActivity(), AppealSportRecordListActivity.class);
      FragmentActivity localFragmentActivity = this.a.getActivity();
      if (localFragmentActivity != null) {
        localFragmentActivity.startActivity(paramView);
      }
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    public static final e a = new e();
    
    public final void onClick(View paramView) {}
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(MineFragment paramMineFragment) {}
    
    public final void onClick(View paramView)
    {
      paramView = new Intent(this.a.getContext(), PDFActivity.class);
      paramView.putExtra("title", "龙猫校园app使用操作手册");
      paramView.putExtra("fileName", "龙猫校园app使用操作手册.pdf");
      paramView.putExtra("url", "http://news.xtotoro.com:8093/modelName/usermannul.pdf");
      this.a.startActivity(paramView);
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(MineFragment paramMineFragment) {}
    
    public final void onClick(View paramView)
    {
      paramView = new Intent((Context)this.a.getActivity(), AboutAppActivity.class);
      this.a.startActivity(paramView);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\main\MineFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */