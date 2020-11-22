package com.pgyersdk.feedback;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;
import android.widget.Toast;
import com.pgyersdk.PgyerActivityManager;
import com.pgyersdk.PgyerProvider;
import com.pgyersdk.b.d;
import com.pgyersdk.b.e;
import com.pgyersdk.c.b;
import com.pgyersdk.f.a;
import com.pgyersdk.f.l;
import com.pgyersdk.feedback.a.r;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class k
{
  private static String a = "";
  private static File b;
  private static Handler c;
  private m d;
  private a e;
  private PgyerFeedbackManager.TYPE f;
  private String g;
  
  k(int paramInt, PgyerFeedbackManager.TYPE paramTYPE, String paramString)
  {
    this.d = new m(paramInt);
    this.f = paramTYPE;
    this.g = paramString;
    h();
  }
  
  k(PgyerFeedbackManager.TYPE paramTYPE, String paramString)
  {
    this.f = paramTYPE;
    this.g = paramString;
    h();
  }
  
  private void a(com.pgyersdk.feedback.a.m paramm)
  {
    com.pgyersdk.f.h.a("selfmail", paramm.d().getText().toString().trim());
    com.pgyersdk.f.h.a("feedback_des", paramm.c().getText().toString().trim());
  }
  
  private void g()
  {
    Object localObject = a;
    if (localObject != null) {
      e.a((String)localObject);
    }
    localObject = b;
    if (localObject != null) {
      e.a(((File)localObject).getAbsolutePath());
    }
    com.pgyersdk.f.h.a("feedback_des", "");
    com.pgyersdk.f.h.a("voicefile", "");
    com.pgyersdk.f.h.a("voiceTime", "");
  }
  
  private void h()
  {
    c = new j(this, Looper.getMainLooper());
  }
  
  private void i()
  {
    Intent localIntent = new Intent(PgyerProvider.a, FeedbackActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("imgFile", a);
    PgyerProvider.a.startActivity(localIntent);
  }
  
  private void j()
  {
    com.pgyersdk.feedback.a.m localm = new com.pgyersdk.feedback.a.m(PgyerActivityManager.getInstance().getCurrentActivity()).a(false).setCancelable(false);
    localm.setPositiveButton(b.a(1048), new g(this, localm));
    localm.setNegativeButton(b.a(1049), new h(this, localm));
    AlertDialog localAlertDialog = localm.create();
    localAlertDialog.setOnDismissListener(new i(this, localm));
    localAlertDialog.show();
  }
  
  private void k()
  {
    if (this.f == PgyerFeedbackManager.TYPE.DIALOG_TYPE)
    {
      j();
      return;
    }
    i();
  }
  
  private void l()
  {
    d.a(PgyerActivityManager.getInstance().getCurrentActivity(), new f(this));
  }
  
  public void a(a parama)
  {
    this.e = parama;
  }
  
  void a(String paramString1, String paramString2, String paramString3, File paramFile, Boolean paramBoolean)
  {
    if (!com.pgyersdk.f.m.b()) {
      return;
    }
    b = paramFile;
    a = paramString3;
    if (!l.b()) {
      return;
    }
    if (com.pgyersdk.f.k.a(paramString1))
    {
      Toast.makeText(PgyerProvider.a, b.a(1063), 0).show();
      return;
    }
    if (!com.pgyersdk.f.m.a(paramString1))
    {
      Toast.makeText(PgyerProvider.a, b.a(1046), 0).show();
      return;
    }
    paramString3 = new ArrayList();
    if (!com.pgyersdk.f.k.a(a))
    {
      if (this.f == PgyerFeedbackManager.TYPE.DIALOG_TYPE)
      {
        if (paramBoolean.booleanValue()) {
          paramString3.add(a);
        }
      }
      else {
        paramString3.add(a);
      }
      com.pgyersdk.f.h.a(PgyerProvider.a, "selfmail", paramString1);
      paramString1 = new r(PgyerActivityManager.getInstance().getCurrentActivity(), paramString1, "http://www.pgyer.com/apiv1/feedback/add", paramString2, paramString3, b, c, this.g);
      paramString1.a(true);
      a.a(paramString1);
    }
  }
  
  void c()
  {
    a locala = this.e;
    if (locala != null) {
      locala.b();
    }
  }
  
  void d()
  {
    a locala = this.e;
    if (locala != null) {
      locala.a();
    }
  }
  
  public void e()
  {
    if (PgyerActivityManager.getInstance().getCurrentActivity() == null) {
      return;
    }
    d();
    if (l.e())
    {
      l();
      return;
    }
    c();
  }
  
  public void f()
  {
    this.d.b();
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */