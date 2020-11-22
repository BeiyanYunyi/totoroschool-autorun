package com.pgyersdk.feedback;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.pgyersdk.b.e;
import com.pgyersdk.f.g;
import java.io.File;

public class FeedbackActivity
  extends Activity
{
  private static boolean a = false;
  private d b;
  private String c;
  
  private void a()
  {
    this.b.g.b();
    this.b.n.destroyDrawingCache();
    this.b.n = null;
    this.b = null;
    e.a(new File(this.c));
    PgyerFeedbackManager.getInstance().b().c();
  }
  
  private void a(boolean paramBoolean)
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    if (paramBoolean) {
      localLayoutParams.flags |= 0x4000000;
    } else {
      localLayoutParams.flags &= 0xFBFFFFFF;
    }
    localWindow.setAttributes(localLayoutParams);
  }
  
  public static void setBarBackgroundColor(String paramString)
  {
    d.c = paramString;
    d.b = paramString;
  }
  
  public static void setBarButtonPressedColor(String paramString)
  {
    com.pgyersdk.feedback.a.a.a = paramString;
  }
  
  public static void setBarImmersive(Boolean paramBoolean)
  {
    a = paramBoolean.booleanValue();
  }
  
  public static void setColorPickerBackgroundColor(String paramString)
  {
    d.d = paramString;
  }
  
  public void finish()
  {
    super.finish();
    a();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    g.a(this);
    super.onCreate(paramBundle);
    if (a)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        a(true);
      }
      paramBundle = new com.pgyersdk.e.a.b(this);
      paramBundle.a(true);
      paramBundle.a(Color.parseColor(d.b));
    }
    this.c = getIntent().getStringExtra("imgFile");
    this.b = new d(this, this.c);
    setContentView(this.b);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\FeedbackActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */