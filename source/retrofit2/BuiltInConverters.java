package retrofit2;

import d.c;
import e.ab;
import e.ad;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.http.Streaming;

final class BuiltInConverters
  extends Converter.Factory
{
  private boolean checkForKotlinUnit = true;
  
  @Nullable
  public Converter<?, ab> requestBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, Retrofit paramRetrofit)
  {
    if (ab.class.isAssignableFrom(Utils.getRawType(paramType))) {
      return RequestBodyConverter.INSTANCE;
    }
    return null;
  }
  
  @Nullable
  public Converter<ad, ?> responseBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    if (paramType == ad.class)
    {
      if (Utils.isAnnotationPresent(paramArrayOfAnnotation, Streaming.class)) {
        return StreamingResponseBodyConverter.INSTANCE;
      }
      return BufferingResponseBodyConverter.INSTANCE;
    }
    if (paramType == Void.class) {
      return VoidResponseBodyConverter.INSTANCE;
    }
    if ((this.checkForKotlinUnit) && (paramType == c.class)) {}
    try
    {
      paramType = UnitResponseBodyConverter.INSTANCE;
      return paramType;
    }
    catch (NoClassDefFoundError paramType)
    {
      for (;;) {}
    }
    this.checkForKotlinUnit = false;
    return null;
  }
  
  static final class BufferingResponseBodyConverter
    implements Converter<ad, ad>
  {
    static final BufferingResponseBodyConverter INSTANCE = new BufferingResponseBodyConverter();
    
    public ad convert(ad paramad)
      throws IOException
    {
      try
      {
        ad localad = Utils.buffer(paramad);
        return localad;
      }
      finally
      {
        paramad.close();
      }
    }
  }
  
  static final class RequestBodyConverter
    implements Converter<ab, ab>
  {
    static final RequestBodyConverter INSTANCE = new RequestBodyConverter();
    
    public ab convert(ab paramab)
    {
      return paramab;
    }
  }
  
  static final class StreamingResponseBodyConverter
    implements Converter<ad, ad>
  {
    static final StreamingResponseBodyConverter INSTANCE = new StreamingResponseBodyConverter();
    
    public ad convert(ad paramad)
    {
      return paramad;
    }
  }
  
  static final class ToStringConverter
    implements Converter<Object, String>
  {
    static final ToStringConverter INSTANCE = new ToStringConverter();
    
    public String convert(Object paramObject)
    {
      return paramObject.toString();
    }
  }
  
  static final class UnitResponseBodyConverter
    implements Converter<ad, c>
  {
    static final UnitResponseBodyConverter INSTANCE = new UnitResponseBodyConverter();
    
    public c convert(ad paramad)
    {
      paramad.close();
      return c.a;
    }
  }
  
  static final class VoidResponseBodyConverter
    implements Converter<ad, Void>
  {
    static final VoidResponseBodyConverter INSTANCE = new VoidResponseBodyConverter();
    
    public Void convert(ad paramad)
    {
      paramad.close();
      return null;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\BuiltInConverters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */