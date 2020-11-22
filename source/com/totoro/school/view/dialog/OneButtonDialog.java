package com.totoro.school.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.totoro.school.utils.MetricsUtil;

public class OneButtonDialog
  extends AlertDialog
  implements View.OnClickListener
{
  private Context a;
  private String b;
  private String c;
  @BindView(2131296332)
  TextView confirmBtn;
  @BindView(2131296336)
  TextView contentView;
  private String d;
  private a e;
  @BindView(2131296541)
  View rootView;
  @BindView(2131296664)
  TextView titleView;
  
  public OneButtonDialog(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, a parama)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = parama;
    MetricsUtil.a(paramContext);
  }
  
  private void a()
  {
    MetricsUtil.a(this.rootView, 900);
    if (!TextUtils.isEmpty(this.b)) {
      this.titleView.setText(this.b);
    }
    if (!TextUtils.isEmpty(this.c))
    {
      this.c = this.c.replace("\n", "<br/>");
      this.contentView.setText(Html.fromHtml(this.c));
    }
    if (!TextUtils.isEmpty(this.d)) {
      this.confirmBtn.setText(this.d);
    }
    this.confirmBtn.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131296332) {
      return;
    }
    dismiss();
    this.e.a("confirm_btn");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492939);
    ButterKnife.bind(this);
    a();
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\dialog\OneButtonDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */