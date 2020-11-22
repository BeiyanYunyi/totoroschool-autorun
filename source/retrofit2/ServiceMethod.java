package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

abstract class ServiceMethod<T>
{
  static <T> ServiceMethod<T> parseAnnotations(Retrofit paramRetrofit, Method paramMethod)
  {
    RequestFactory localRequestFactory = RequestFactory.parseAnnotations(paramRetrofit, paramMethod);
    Type localType = paramMethod.getGenericReturnType();
    if (!Utils.hasUnresolvableType(localType))
    {
      if (localType != Void.TYPE) {
        return HttpServiceMethod.parseAnnotations(paramRetrofit, paramMethod, localRequestFactory);
      }
      throw Utils.methodError(paramMethod, "Service methods cannot return void.", new Object[0]);
    }
    throw Utils.methodError(paramMethod, "Method return type must not include a type variable or wildcard: %s", new Object[] { localType });
  }
  
  abstract T invoke(Object[] paramArrayOfObject);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\ServiceMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */