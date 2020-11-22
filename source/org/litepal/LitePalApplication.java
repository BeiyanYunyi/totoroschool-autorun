package org.litepal;

import android.app.Application;
import android.content.Context;
import org.litepal.exceptions.GlobalException;

public class LitePalApplication
  extends Application
{
  public static Context sContext;
  
  public LitePalApplication()
  {
    sContext = this;
  }
  
  public static Context getContext()
  {
    if (sContext != null) {
      return sContext;
    }
    throw new GlobalException("Application context is null. Maybe you neither configured your application name with \"org.litepal.LitePalApplication\" in your AndroidManifest.xml, nor called LitePal.initialize(Context) method.");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\LitePalApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */