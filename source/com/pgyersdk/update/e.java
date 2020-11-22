package com.pgyersdk.update;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import com.pgyersdk.PgyerActivityManager;
import com.pgyersdk.PgyerProvider;
import com.pgyersdk.c.b;
import java.io.File;

class e
  implements DownloadFileListener
{
  private ProgressDialog a;
  private Dialog b;
  private boolean c = true;
  private Activity d;
  private Activity e;
  
  public e(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  static void a(File paramFile)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(268435456);
    if (Build.VERSION.SDK_INT >= 24)
    {
      Context localContext = PgyerProvider.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PgyerProvider.a.getApplicationContext().getPackageName());
      localStringBuilder.append(".fileProvider");
      paramFile = FileProvider.getUriForFile(localContext, localStringBuilder.toString(), paramFile);
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.addFlags(1);
      localIntent.setDataAndType(paramFile, "application/vnd.android.package-archive");
    }
    else
    {
      localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.android.package-archive");
    }
    PgyerProvider.a.startActivity(localIntent);
  }
  
  private Dialog b()
  {
    this.e = PgyerActivityManager.getInstance().getCurrentActivity();
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.e);
    localBuilder.setTitle(b.a(256));
    localBuilder.setMessage(b.a(257));
    localBuilder.setNegativeButton(b.a(258), new c(this));
    localBuilder.setPositiveButton(b.a(259), new d(this));
    this.b = localBuilder.create();
    return this.b;
  }
  
  void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((ProgressDialog)localObject).isShowing())
      {
        localObject = this.d;
        if ((localObject != null) && (!((Activity)localObject).isFinishing())) {
          this.a.dismiss();
        }
      }
      this.a = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      if (((Dialog)localObject).isShowing())
      {
        localObject = this.e;
        if ((localObject != null) && (((Activity)localObject).isFinishing())) {
          this.b.dismiss();
        }
      }
      this.b = null;
    }
  }
  
  public void downloadFailed()
  {
    a();
    if (this.c) {
      b().show();
    }
  }
  
  public void downloadSuccessful(File paramFile)
  {
    a(paramFile);
    a();
  }
  
  public void onProgressUpdate(Integer... paramVarArgs)
  {
    this.d = PgyerActivityManager.getInstance().getCurrentActivity();
    try
    {
      if ((this.a == null) && (this.d != null))
      {
        this.a = new ProgressDialog(this.d);
        this.a.setProgressStyle(1);
        this.a.setMessage(b.a(260));
        this.a.setCancelable(false);
        this.a.show();
      }
      this.a.setProgress(paramVarArgs[0].intValue());
      return;
    }
    catch (Exception paramVarArgs)
    {
      for (;;) {}
    }
    a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\update\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */