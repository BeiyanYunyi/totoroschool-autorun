package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Trace;

public final class TraceCompat
{
  public static void beginSection(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.beginSection(paramString);
    }
  }
  
  public static void endSection()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.endSection();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\os\TraceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */