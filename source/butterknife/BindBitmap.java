package butterknife;

import android.support.annotation.DrawableRes;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface BindBitmap
{
  @DrawableRes
  int value();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\butterknife\BindBitmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */