package android.support.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.FIELD})
public @interface HalfFloat {}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\annotation\HalfFloat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */