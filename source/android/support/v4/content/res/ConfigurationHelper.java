package android.support.v4.content.res;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

public final class ConfigurationHelper
{
  public static int getDensityDpi(@NonNull Resources paramResources)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return paramResources.getConfiguration().densityDpi;
    }
    return paramResources.getDisplayMetrics().densityDpi;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\content\res\ConfigurationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */