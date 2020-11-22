package com.pgyersdk.f;

import android.os.AsyncTask;
import android.os.Build.VERSION;

public class a
{
  public static void a(AsyncTask<Void, ?, ?> paramAsyncTask)
  {
    if (Build.VERSION.SDK_INT <= 12)
    {
      paramAsyncTask.execute(new Void[0]);
      return;
    }
    paramAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */