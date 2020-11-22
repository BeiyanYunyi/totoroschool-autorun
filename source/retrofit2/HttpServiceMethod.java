package retrofit2;

import e.ac;
import e.ad;
import e.e.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

final class HttpServiceMethod<ResponseT, ReturnT>
  extends ServiceMethod<ReturnT>
{
  private final CallAdapter<ResponseT, ReturnT> callAdapter;
  private final e.a callFactory;
  private final RequestFactory requestFactory;
  private final Converter<ad, ResponseT> responseConverter;
  
  private HttpServiceMethod(RequestFactory paramRequestFactory, e.a parama, CallAdapter<ResponseT, ReturnT> paramCallAdapter, Converter<ad, ResponseT> paramConverter)
  {
    this.requestFactory = paramRequestFactory;
    this.callFactory = parama;
    this.callAdapter = paramCallAdapter;
    this.responseConverter = paramConverter;
  }
  
  private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit paramRetrofit, Method paramMethod)
  {
    Type localType = paramMethod.getGenericReturnType();
    Annotation[] arrayOfAnnotation = paramMethod.getAnnotations();
    try
    {
      paramRetrofit = paramRetrofit.callAdapter(localType, arrayOfAnnotation);
      return paramRetrofit;
    }
    catch (RuntimeException paramRetrofit)
    {
      throw Utils.methodError(paramMethod, paramRetrofit, "Unable to create call adapter for %s", new Object[] { localType });
    }
  }
  
  private static <ResponseT> Converter<ad, ResponseT> createResponseConverter(Retrofit paramRetrofit, Method paramMethod, Type paramType)
  {
    Annotation[] arrayOfAnnotation = paramMethod.getAnnotations();
    try
    {
      paramRetrofit = paramRetrofit.responseBodyConverter(paramType, arrayOfAnnotation);
      return paramRetrofit;
    }
    catch (RuntimeException paramRetrofit)
    {
      throw Utils.methodError(paramMethod, paramRetrofit, "Unable to create converter for %s", new Object[] { paramType });
    }
  }
  
  static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit paramRetrofit, Method paramMethod, RequestFactory paramRequestFactory)
  {
    CallAdapter localCallAdapter = createCallAdapter(paramRetrofit, paramMethod);
    Type localType = localCallAdapter.responseType();
    if ((localType != Response.class) && (localType != ac.class))
    {
      if ((paramRequestFactory.httpMethod.equals("HEAD")) && (!Void.class.equals(localType))) {
        throw Utils.methodError(paramMethod, "HEAD method must use Void as response type.", new Object[0]);
      }
      paramMethod = createResponseConverter(paramRetrofit, paramMethod, localType);
      return new HttpServiceMethod(paramRequestFactory, paramRetrofit.callFactory, localCallAdapter, paramMethod);
    }
    paramRetrofit = new StringBuilder();
    paramRetrofit.append("'");
    paramRetrofit.append(Utils.getRawType(localType).getName());
    paramRetrofit.append("' is not a valid response body type. Did you mean ResponseBody?");
    throw Utils.methodError(paramMethod, paramRetrofit.toString(), new Object[0]);
  }
  
  ReturnT invoke(Object[] paramArrayOfObject)
  {
    return (ReturnT)this.callAdapter.adapt(new OkHttpCall(this.requestFactory, paramArrayOfObject, this.callFactory, this.responseConverter));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\HttpServiceMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */