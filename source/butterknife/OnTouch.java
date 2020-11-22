package butterknife;

import android.support.annotation.IdRes;
import butterknife.internal.ListenerClass;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(method={@butterknife.internal.ListenerMethod(defaultReturn="false", name="onTouch", parameters={"android.view.View", "android.view.MotionEvent"}, returnType="boolean")}, setter="setOnTouchListener", targetType="android.view.View", type="android.view.View.OnTouchListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnTouch
{
  @IdRes
  int[] value() default {-1};
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\butterknife\OnTouch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */