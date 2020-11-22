package android.support.v4.util;

import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.Objects;

public class ObjectsCompat
{
  public static boolean equals(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return Objects.equals(paramObject1, paramObject2);
    }
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static int hash(@Nullable Object... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return Objects.hash(paramVarArgs);
    }
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static int hashCode(@Nullable Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.hashCode();
    }
    return 0;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\util\ObjectsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */