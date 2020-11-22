package com.totoro.school.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.totoro.school.utils.MetricsUtil;
import com.totoro.school.utils.l;

public class QrCodeDialog
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
  @BindView(2131296524)
  ImageView qrCodeView;
  @BindView(2131296541)
  View rootView;
  
  public QrCodeDialog(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, a parama)
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
    if (!TextUtils.isEmpty(this.b))
    {
      Bitmap localBitmap = l.a(this.b, 450, 450, "UTF-8", 1, -16777216, -1);
      this.qrCodeView.setImageBitmap(localBitmap);
    }
    if (!TextUtils.isEmpty(this.c)) {
      this.contentView.setText(this.c);
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
    setContentView(2131492940);
    ButterKnife.bind(this);
    a();
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\dialog\QrCodeDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */