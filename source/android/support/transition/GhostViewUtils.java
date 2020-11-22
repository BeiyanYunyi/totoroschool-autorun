package android.support.transition;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

class GhostViewUtils
{
  static GhostViewImpl addGhost(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return GhostViewApi21.addGhost(paramView, paramViewGroup, paramMatrix);
    }
    return GhostViewApi14.addGhost(paramView, paramViewGroup);
  }
  
  static void removeGhost(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      GhostViewApi21.removeGhost(paramView);
      return;
    }
    GhostViewApi14.removeGhost(paramView);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\GhostViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */