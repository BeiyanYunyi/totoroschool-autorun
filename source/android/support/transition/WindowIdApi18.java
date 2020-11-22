package android.support.transition;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.WindowId;

@RequiresApi(18)
class WindowIdApi18
  implements WindowIdImpl
{
  private final WindowId mWindowId;
  
  WindowIdApi18(@NonNull View paramView)
  {
    this.mWindowId = paramView.getWindowId();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof WindowIdApi18)) && (((WindowIdApi18)paramObject).mWindowId.equals(this.mWindowId));
  }
  
  public int hashCode()
  {
    return this.mWindowId.hashCode();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\WindowIdApi18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */