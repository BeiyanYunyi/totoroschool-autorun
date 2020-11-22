package retrofit2.converter.gson;

import com.google.gson.e;
import com.google.gson.k;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.t;
import e.ad;
import java.io.IOException;
import retrofit2.Converter;

final class GsonResponseBodyConverter<T>
  implements Converter<ad, T>
{
  private final t<T> adapter;
  private final e gson;
  
  GsonResponseBodyConverter(e parame, t<T> paramt)
  {
    this.gson = parame;
    this.adapter = paramt;
  }
  
  public T convert(ad paramad)
    throws IOException
  {
    Object localObject3 = this.gson.a(paramad.charStream());
    try
    {
      Object localObject1 = this.adapter.b((JsonReader)localObject3);
      localObject3 = ((JsonReader)localObject3).peek();
      JsonToken localJsonToken = JsonToken.END_DOCUMENT;
      if (localObject3 == localJsonToken) {
        return (T)localObject1;
      }
      throw new k("JSON document was not fully consumed.");
    }
    finally
    {
      paramad.close();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\converter\gson\GsonResponseBodyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */