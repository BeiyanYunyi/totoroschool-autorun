package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public final class EnvironmentCompat
{
  public static final String MEDIA_UNKNOWN = "unknown";
  private static final String TAG = "EnvironmentCompat";
  
  public static String getStorageState(File paramFile)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return Environment.getStorageState(paramFile);
    }
    try
    {
      if (paramFile.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()))
      {
        paramFile = Environment.getExternalStorageState();
        return paramFile;
      }
    }
    catch (IOException paramFile)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to resolve canonical path: ");
      localStringBuilder.append(paramFile);
      Log.w("EnvironmentCompat", localStringBuilder.toString());
    }
    return "unknown";
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\os\EnvironmentCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */