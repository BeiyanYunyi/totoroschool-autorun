package com.totoro.school.zxing.b;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.totoro.school.activity.morning.MorningExercisesActivity;
import com.totoro.school.zxing.a.c;
import com.totoro.school.zxing.view.a;
import java.util.Vector;

public final class g
  extends Handler
{
  private static final String a = "g";
  private final MorningExercisesActivity b;
  private final i c;
  private a d;
  
  public g(MorningExercisesActivity paramMorningExercisesActivity, Vector<BarcodeFormat> paramVector, String paramString)
  {
    this.b = paramMorningExercisesActivity;
    this.c = new i(paramMorningExercisesActivity, paramVector, paramString, new a(paramMorningExercisesActivity.a()));
    this.c.start();
    this.d = a.SUCCESS;
    c.a().c();
    b();
  }
  
  public void a()
  {
    this.d = a.DONE;
    c.a().d();
    Message.obtain(this.c.a(), 2131296525).sendToTarget();
    try
    {
      this.c.join();
      removeMessages(2131296347);
      removeMessages(2131296346);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public void b()
  {
    if (this.d == a.SUCCESS)
    {
      this.d = a.PREVIEW;
      c.a().a(this.c.a(), 2131296345);
      c.a().b(this, 2131296295);
      this.b.c();
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2131296531: 
      Log.d(a, "Got return scan result message");
      this.b.setResult(-1, (Intent)paramMessage.obj);
      this.b.finish();
      return;
    case 2131296530: 
      Log.d(a, "Got restart preview message");
      b();
      return;
    case 2131296435: 
      Log.d(a, "Got product query message");
      paramMessage = new Intent("android.intent.action.VIEW", Uri.parse((String)paramMessage.obj));
      paramMessage.addFlags(524288);
      this.b.startActivity(paramMessage);
      return;
    case 2131296347: 
      Log.d(a, "Got decode succeeded message");
      this.d = a.SUCCESS;
      Object localObject = paramMessage.getData();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = (Bitmap)((Bundle)localObject).getParcelable("barcode_bitmap");
      }
      this.b.a((Result)paramMessage.obj, (Bitmap)localObject);
      return;
    case 2131296346: 
      this.d = a.PREVIEW;
      c.a().a(this.c.a(), 2131296345);
      return;
    }
    if (this.d == a.PREVIEW) {
      c.a().b(this, 2131296295);
    }
  }
  
  private static enum a
  {
    private a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */