package butterknife;

import android.support.annotation.UiThread;

public abstract interface Unbinder
{
  public static final Unbinder EMPTY = new Unbinder()
  {
    public void unbind() {}
  };
  
  @UiThread
  public abstract void unbind();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\butterknife\Unbinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */