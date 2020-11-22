package android.support.v7.text;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.annotation.RestrictTo;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AllCapsTransformationMethod
  implements TransformationMethod
{
  private Locale mLocale;
  
  public AllCapsTransformationMethod(Context paramContext)
  {
    this.mLocale = paramContext.getResources().getConfiguration().locale;
  }
  
  public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    if (paramCharSequence != null) {
      return paramCharSequence.toString().toUpperCase(this.mLocale);
    }
    return null;
  }
  
  public void onFocusChanged(View paramView, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, Rect paramRect) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\text\AllCapsTransformationMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */