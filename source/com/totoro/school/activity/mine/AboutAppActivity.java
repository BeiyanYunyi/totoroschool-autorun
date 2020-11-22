package com.totoro.school.activity.mine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.totoro.school.R.id;
import com.totoro.school.activity.common.HTMLActivity;
import com.totoro.school.utils.b;
import d.c.b.h;
import java.util.HashMap;

public final class AboutAppActivity
  extends Activity
{
  public static final a a = new a(null);
  private HashMap b;
  
  private final void a()
  {
    TextView localTextView = (TextView)a(R.id.about_code);
    h.a(localTextView, "about_code");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.a(getBaseContext()));
    localStringBuilder.append("学生版 ");
    localStringBuilder.append(b.b(getBaseContext()));
    localStringBuilder.append("版");
    localTextView.setText((CharSequence)localStringBuilder.toString());
    localTextView = (TextView)a(R.id.title_text);
    h.a(localTextView, "title_text");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("关于");
    localStringBuilder.append(b.a(getBaseContext()));
    localTextView.setText((CharSequence)localStringBuilder.toString());
  }
  
  private final void b()
  {
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new b(this));
    ((LinearLayout)a(R.id.phone_layout)).setOnClickListener((View.OnClickListener)new c(this));
    ((TextView)a(R.id.privacy_agreement)).setOnClickListener((View.OnClickListener)new d(this));
  }
  
  private final void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tel:");
    TextView localTextView = (TextView)a(R.id.phone_number);
    h.a(localTextView, "phone_number");
    localStringBuilder.append(localTextView.getText().toString());
    startActivity(new Intent("android.intent.action.CALL", Uri.parse(localStringBuilder.toString())));
  }
  
  public View a(int paramInt)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    View localView2 = (View)this.b.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.b.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492892);
    a();
    b();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    h.b(paramArrayOfString, "permissions");
    h.b(paramArrayOfInt, "grantResults");
    if (paramInt != 1001)
    {
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      c();
      return;
    }
    Toast.makeText((Context)this, (CharSequence)getString(2131689560), 0).show();
  }
  
  public static final class a {}
  
  static final class b
    implements View.OnClickListener
  {
    b(AboutAppActivity paramAboutAppActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(AboutAppActivity paramAboutAppActivity) {}
    
    public final void onClick(View paramView)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (ContextCompat.checkSelfPermission(this.a.getApplicationContext(), "android.permission.CALL_PHONE") != 0)
        {
          ActivityCompat.requestPermissions((Activity)this.a, new String[] { "android.permission.CALL_PHONE" }, 1001);
          return;
        }
        AboutAppActivity.a(this.a);
        return;
      }
      AboutAppActivity.a(this.a);
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(AboutAppActivity paramAboutAppActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = new Intent((Context)this.a, HTMLActivity.class);
      paramView.putExtra("title", "隐私服务协议");
      paramView.putExtra("url", "https://www.xtotoro.com/apps/agreement.html");
      paramView.putExtra("canComment", true);
      this.a.startActivity(paramView);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\mine\AboutAppActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */