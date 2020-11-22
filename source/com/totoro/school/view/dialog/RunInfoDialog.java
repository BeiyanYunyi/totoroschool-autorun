package com.totoro.school.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.totoro.school.utils.MetricsUtil;

public class RunInfoDialog
  extends AlertDialog
  implements View.OnClickListener
{
  private Context a;
  private String b;
  private String c;
  @BindView(2131296332)
  TextView confirmBtn;
  private String d;
  private String e;
  private String f;
  private a g;
  @BindView(2131296471)
  TextView mileageView;
  @BindView(2131296541)
  View rootView;
  @BindView(2131296664)
  TextView titleView;
  @BindView(2131296714)
  TextView useTimeView;
  
  public RunInfoDialog(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, a parama)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = parama;
    MetricsUtil.a(paramContext);
  }
  
  private void a()
  {
    MetricsUtil.a(this.rootView, 900);
    if (!TextUtils.isEmpty(this.b)) {
      this.titleView.setText(this.b);
    }
    TextView localTextView;
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(this.c))
    {
      localTextView = this.mileageView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("里程：");
      localStringBuilder.append(this.c);
      localStringBuilder.append("公里");
      localTextView.setText(localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.e)))
    {
      localTextView = this.useTimeView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("时间：");
      localStringBuilder.append(this.d);
      localStringBuilder.append("-");
      localStringBuilder.append(this.e);
      localStringBuilder.append("分钟");
      localTextView.setText(localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(this.f)) {
      this.confirmBtn.setText(this.f);
    }
    this.confirmBtn.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131296332) {
      return;
    }
    dismiss();
    this.g.a("confirm_btn");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492941);
    ButterKnife.bind(this);
    a();
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\dialog\RunInfoDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */