package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class VideoActivity
  extends Activity
{
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    bd.a(this).a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.getWindow().setFormat(-3);
    paramBundle = super.getIntent();
    if (paramBundle != null) {
      paramBundle = paramBundle.getBundleExtra("extraData");
    } else {
      paramBundle = null;
    }
    if (paramBundle != null)
    {
      paramBundle.putInt("callMode", 1);
      bd.a(super.getApplicationContext()).a(null, paramBundle, null);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    bd.a(this).a(this, 4);
  }
  
  protected void onPause()
  {
    super.onPause();
    bd.a(this).a(this, 3);
  }
  
  protected void onResume()
  {
    super.onResume();
    bd.a(this).a(this, 2);
  }
  
  protected void onStop()
  {
    super.onStop();
    bd.a(this).a(this, 1);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\VideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */