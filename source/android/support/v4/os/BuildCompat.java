package android.support.v4.os;

import android.os.Build.VERSION;

public class BuildCompat
{
  @Deprecated
  public static boolean isAtLeastN()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  @Deprecated
  public static boolean isAtLeastNMR1()
  {
    return Build.VERSION.SDK_INT >= 25;
  }
  
  @Deprecated
  public static boolean isAtLeastO()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  @Deprecated
  public static boolean isAtLeastOMR1()
  {
    return Build.VERSION.SDK_INT >= 27;
  }
  
  @Deprecated
  public static boolean isAtLeastP()
  {
    return Build.VERSION.SDK_INT >= 28;
  }
  
  public static boolean isAtLeastQ()
  {
    return (Build.VERSION.CODENAME.length() == 1) && (Build.VERSION.CODENAME.charAt(0) >= 'Q') && (Build.VERSION.CODENAME.charAt(0) <= 'Z');
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\os\BuildCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */