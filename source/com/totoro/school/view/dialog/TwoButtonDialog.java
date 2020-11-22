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

public class TwoButtonDialog
  extends AlertDialog
  implements View.OnClickListener
{
  private Context a;
  private String b;
  private String c;
  @BindView(2131296336)
  TextView contentView;
  private String d;
  private String e;
  private a f;
  @BindView(2131296437)
  TextView leftBtn;
  @BindView(2131296533)
  TextView rightBtn;
  @BindView(2131296541)
  View rootView;
  @BindView(2131296664)
  TextView titleView;
  
  public TwoButtonDialog(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, a parama)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = parama;
    MetricsUtil.a(paramContext);
  }
  
  private void a()
  {
    MetricsUtil.a(this.rootView, 900);
    if (!TextUtils.isEmpty(this.b)) {
      this.titleView.setText(this.b);
    }
    if (!TextUtils.isEmpty(this.c)) {
      this.contentView.setText(this.c);
    }
    if (!TextUtils.isEmpty(this.d)) {
      this.leftBtn.setText(this.d);
    }
    if (!TextUtils.isEmpty(this.e)) {
      this.rightBtn.setText(this.e);
    }
    this.leftBtn.setOnClickListener(this);
    this.rightBtn.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131296437)
    {
      if (i != 2131296533) {
        return;
      }
      dismiss();
      this.f.a("right_btn");
      return;
    }
    dismiss();
    this.f.a("left_btn");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492942);
    ButterKnife.bind(this);
    a();
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\dialog\TwoButtonDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */