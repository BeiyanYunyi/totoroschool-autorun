package com.totoro.school.zxing.b;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import com.totoro.school.activity.morning.MorningExercisesActivity;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

final class i
  extends Thread
{
  private final MorningExercisesActivity a;
  private final Hashtable<DecodeHintType, Object> b;
  private Handler c;
  private final CountDownLatch d;
  
  i(MorningExercisesActivity paramMorningExercisesActivity, Vector<BarcodeFormat> paramVector, String paramString, ResultPointCallback paramResultPointCallback)
  {
    this.a = paramMorningExercisesActivity;
    this.d = new CountDownLatch(1);
    this.b = new Hashtable(3);
    if (paramVector != null)
    {
      paramMorningExercisesActivity = paramVector;
      if (!paramVector.isEmpty()) {}
    }
    else
    {
      paramMorningExercisesActivity = new Vector();
      paramMorningExercisesActivity.addAll(b.b);
      paramMorningExercisesActivity.addAll(b.c);
      paramMorningExercisesActivity.addAll(b.d);
    }
    this.b.put(DecodeHintType.POSSIBLE_FORMATS, paramMorningExercisesActivity);
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
    this.c = new h(this.a, this.b);
    this.d.countDown();
    Looper.loop();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */