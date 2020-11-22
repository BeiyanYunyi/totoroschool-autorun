package android.support.v7.widget;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public class TooltipCompat
{
  public static void setTooltipText(@NonNull View paramView, @Nullable CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramView.setTooltipText(paramCharSequence);
      return;
    }
    TooltipCompatHandler.setTooltipText(paramView, paramCharSequence);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\TooltipCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */