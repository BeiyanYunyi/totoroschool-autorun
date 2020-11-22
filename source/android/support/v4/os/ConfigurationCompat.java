package android.support.v4.os;

import android.content.res.Configuration;
import android.os.Build.VERSION;
import java.util.Locale;

public final class ConfigurationCompat
{
  public static LocaleListCompat getLocales(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return LocaleListCompat.wrap(paramConfiguration.getLocales());
    }
    return LocaleListCompat.create(new Locale[] { paramConfiguration.locale });
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\os\ConfigurationCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */