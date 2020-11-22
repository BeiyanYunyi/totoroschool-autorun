package retrofit2.converter.gson;

import com.google.gson.c.a;
import com.google.gson.e;
import e.ab;
import e.ad;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

public final class GsonConverterFactory
  extends Converter.Factory
{
  private final e gson;
  
  private GsonConverterFactory(e parame)
  {
    this.gson = parame;
  }
  
  public static GsonConverterFactory create()
  {
    return create(new e());
  }
  
  public static GsonConverterFactory create(e parame)
  {
    if (parame != null) {
      return new GsonConverterFactory(parame);
    }
    throw new NullPointerException("gson == null");
  }
  
  public Converter<?, ab> requestBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, Retrofit paramRetrofit)
  {
    paramType = this.gson.a(a.a(paramType));
    return new GsonRequestBodyConverter(this.gson, paramType);
  }
  
  public Converter<ad, ?> responseBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    paramType = this.gson.a(a.a(paramType));
    return new GsonResponseBodyConverter(this.gson, paramType);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\converter\gson\GsonConverterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */