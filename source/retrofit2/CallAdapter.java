package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

public abstract interface CallAdapter<R, T>
{
  public abstract T adapt(Call<R> paramCall);
  
  public abstract Type responseType();
  
  public static abstract class Factory
  {
    protected static Type getParameterUpperBound(int paramInt, ParameterizedType paramParameterizedType)
    {
      return Utils.getParameterUpperBound(paramInt, paramParameterizedType);
    }
    
    protected static Class<?> getRawType(Type paramType)
    {
      return Utils.getRawType(paramType);
    }
    
    @Nullable
    public abstract CallAdapter<?, ?> get(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\CallAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */