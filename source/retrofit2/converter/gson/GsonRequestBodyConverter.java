package retrofit2.converter.gson;

import com.google.gson.e;
import com.google.gson.stream.JsonWriter;
import com.google.gson.t;
import e.ab;
import e.v;
import f.c;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import retrofit2.Converter;

final class GsonRequestBodyConverter<T>
  implements Converter<T, ab>
{
  private static final v MEDIA_TYPE = v.a("application/json; charset=UTF-8");
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private final t<T> adapter;
  private final e gson;
  
  GsonRequestBodyConverter(e parame, t<T> paramt)
  {
    this.gson = parame;
    this.adapter = paramt;
  }
  
  public ab convert(T paramT)
    throws IOException
  {
    c localc = new c();
    Object localObject = new OutputStreamWriter(localc.c(), UTF_8);
    localObject = this.gson.a((Writer)localObject);
    this.adapter.a((JsonWriter)localObject, paramT);
    ((JsonWriter)localObject).close();
    return ab.create(MEDIA_TYPE, localc.n());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\converter\gson\GsonRequestBodyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */