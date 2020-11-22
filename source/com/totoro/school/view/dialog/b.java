package com.totoro.school.view.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.a;
import com.bumptech.glide.e;
import com.bumptech.glide.h;
import com.totoro.school.entity.update.UpdateAppBodyModel;
import com.totoro.school.utils.MetricsUtil;

public class b
  extends AlertDialog
  implements View.OnClickListener
{
  private Activity a;
  private TextView b;
  private ImageView c;
  private Button d;
  private Button e;
  private UpdateAppBodyModel f;
  private a g;
  
  public b(Activity paramActivity, int paramInt, a parama, UpdateAppBodyModel paramUpdateAppBodyModel)
  {
    super(paramActivity, paramInt);
    this.a = paramActivity;
    this.f = paramUpdateAppBodyModel;
    this.g = parama;
    MetricsUtil.a(paramActivity);
  }
  
  private void a()
  {
    this.b = ((TextView)findViewById(2131296718));
    this.c = ((ImageView)findViewById(2131296412));
    TextView localTextView = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V");
    localStringBuilder.append(this.f.getVersion());
    localTextView.setText(localStringBuilder.toString());
    if (!this.f.getPicPath().isEmpty())
    {
      e.a(this.a).a(this.f.getPicPath()).a(400, 600).a(this.c);
      this.c.setVisibility(0);
    }
    else
    {
      this.c.setVisibility(8);
    }
    this.d = ((Button)findViewById(2131296309));
    this.e = ((Button)findViewById(2131296308));
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296309: 
      this.g.a("btnUp");
      dismiss();
      return;
    }
    dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492943);
    a();
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\dialog\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */