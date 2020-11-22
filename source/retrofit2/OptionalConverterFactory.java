package retrofit2;

import e.ad;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@IgnoreJRERequirement
final class OptionalConverterFactory
  extends Converter.Factory
{
  static final Converter.Factory INSTANCE = new OptionalConverterFactory();
  
  @Nullable
  public Converter<ad, ?> responseBodyConverter(Type paramType, Annotation[] paramArrayOfAnnotation, Retrofit paramRetrofit)
  {
    if (getRawType(paramType) != Optional.class) {
      return null;
    }
    return new OptionalConverter(paramRetrofit.responseBodyConverter(getParameterUpperBound(0, (ParameterizedType)paramType), paramArrayOfAnnotation));
  }
  
  @IgnoreJRERequirement
  static final class OptionalConverter<T>
    implements Converter<ad, Optional<T>>
  {
    final Converter<ad, T> delegate;
    
    OptionalConverter(Converter<ad, T> paramConverter)
    {
      this.delegate = paramConverter;
    }
    
    public Optional<T> convert(ad paramad)
      throws IOException
    {
      return Optional.ofNullable(this.delegate.convert(paramad));
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\OptionalConverterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */