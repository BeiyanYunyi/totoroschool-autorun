package retrofit2;

import e.ab;
import e.ad;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

public abstract interface Converter<F, T>
{
  @Nullable
  public abstract T convert(F paramF)
    throws IOException;
  
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
    public Converter<?, ab> requestBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, Retrofit paramRetrofit)
    {
      return null;
    }
    
    @Nullable
    public Converter<ad, ?> responseBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
    {
      return null;
    }
    
    @Nullable
    public Converter<?, String> stringConverter(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\Converter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */