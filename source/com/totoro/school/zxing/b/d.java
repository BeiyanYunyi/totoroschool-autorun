package com.totoro.school.zxing.b;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import com.totoro.school.zxing.CaptureActivity;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

final class d
  extends Thread
{
  private final CaptureActivity a;
  private final Hashtable<DecodeHintType, Object> b;
  private Handler c;
  private final CountDownLatch d;
  
  d(CaptureActivity paramCaptureActivity, Vector<BarcodeFormat> paramVector, String paramString, ResultPointCallback paramResultPointCallback)
  {
    this.a = paramCaptureActivity;
    this.d = new CountDownLatch(1);
    this.b = new Hashtable(3);
    if (paramVector != null)
    {
      paramCaptureActivity = paramVector;
      if (!paramVector.isEmpty()) {}
    }
    else
    {
      paramCaptureActivity = new Vector();
      paramCaptureActivity.addAll(b.b);
      paramCaptureActivity.addAll(b.c);
      paramCaptureActivity.addAll(b.d);
    }
    this.b.put(DecodeHintType.POSSIBLE_FORMATS, paramCaptureActivity);
    if (paramString != null) {
      this.b.put(DecodeHintType.CHARACTER_SET, paramString);
    }
    this.b.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, paramResultPointCallback);
  }
  
  Handler a()
  {
    try
    {
      this.d.await();
      return this.c;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public void run()
  {
    Looper.prepare();
    this.c = new c(this.a, this.b);
    this.d.countDown();
    Looper.loop();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */