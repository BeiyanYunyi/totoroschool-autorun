package android.support.multidex;

import android.app.Application;
import android.content.Context;

public class MultiDexApplication
  extends Application
{
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    MultiDex.install(this);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\multidex\MultiDexApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */