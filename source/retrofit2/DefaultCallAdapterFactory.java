package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

final class DefaultCallAdapterFactory
  extends CallAdapter.Factory
{
  static final CallAdapter.Factory INSTANCE = new DefaultCallAdapterFactory();
  
  @Nullable
  public CallAdapter<?, ?> get(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    if (getRawType(paramType) != Call.class) {
      return null;
    }
    new CallAdapter()
    {
      public Call<Object> adapt(Call<Object> paramAnonymousCall)
      {
        return paramAnonymousCall;
      }
      
      public Type responseType()
      {
        return this.val$responseType;
      }
    };
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\DefaultCallAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */