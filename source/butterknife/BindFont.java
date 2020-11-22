package butterknife;

import android.support.annotation.RestrictTo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface BindFont
{
  @TypefaceStyle
  int style() default 0;
  
  int value();
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public static @interface TypefaceStyle {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\butterknife\BindFont.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */