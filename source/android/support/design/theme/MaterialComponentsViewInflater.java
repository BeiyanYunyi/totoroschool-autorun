package android.support.design.theme;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatViewInflater;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

@Keep
public class MaterialComponentsViewInflater
  extends AppCompatViewInflater
{
  @NonNull
  protected AppCompatButton createButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new MaterialButton(paramContext, paramAttributeSet);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\theme\MaterialComponentsViewInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */