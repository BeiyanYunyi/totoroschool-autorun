package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View.OnTouchListener;
import android.widget.PopupMenu;

public final class PopupMenuCompat
{
  @Nullable
  public static View.OnTouchListener getDragToOpenListener(@NonNull Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((PopupMenu)paramObject).getDragToOpenListener();
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\widget\PopupMenuCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */