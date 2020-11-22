package retrofit2;

import e.ab;
import e.s;
import e.w.b;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

abstract class ParameterHandler<T>
{
  abstract void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
    throws IOException;
  
  final ParameterHandler<Object> array()
  {
    new ParameterHandler()
    {
      void apply(RequestBuilder paramAnonymousRequestBuilder, @Nullable Object paramAnonymousObject)
        throws IOException
      {
        if (paramAnonymousObject == null) {
          return;
        }
        int i = 0;
        int j = Array.getLength(paramAnonymousObject);
        while (i < j)
        {
          ParameterHandler.this.apply(paramAnonymousRequestBuilder, Array.get(paramAnonymousObject, i));
          i += 1;
        }
      }
    };
  }
  
  final ParameterHandler<Iterable<T>> iterable()
  {
    new ParameterHandler()
    {
      void apply(RequestBuilder paramAnonymousRequestBuilder, @Nullable Iterable<T> paramAnonymousIterable)
        throws IOException
      {
        if (paramAnonymousIterable == null) {
          return;
        }
        paramAnonymousIterable = paramAnonymousIterable.iterator();
        while (paramAnonymousIterable.hasNext())
        {
          Object localObject = paramAnonymousIterable.next();
          ParameterHandler.this.apply(paramAnonymousRequestBuilder, localObject);
        }
      }
    };
  }
  
  static final class Body<T>
    extends ParameterHandler<T>
  {
    private final Converter<T, ab> converter;
    
    Body(Converter<T, ab> paramConverter)
    {
      this.converter = paramConverter;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
    {
      if (paramT != null) {
        try
        {
          localObject = (ab)this.converter.convert(paramT);
          paramRequestBuilder.setBody((ab)localObject);
          return;
        }
        catch (IOException paramRequestBuilder)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unable to convert ");
          ((StringBuilder)localObject).append(paramT);
          ((StringBuilder)localObject).append(" to RequestBody");
          throw new RuntimeException(((StringBuilder)localObject).toString(), paramRequestBuilder);
        }
      }
      throw new IllegalArgumentException("Body parameter value must not be null.");
    }
  }
  
  static final class Field<T>
    extends ParameterHandler<T>
  {
    private final boolean encoded;
    private final String name;
    private final Converter<T, String> valueConverter;
    
    Field(String paramString, Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.name = ((String)Utils.checkNotNull(paramString, "name == null"));
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null) {
        return;
      }
      paramT = (String)this.valueConverter.convert(paramT);
      if (paramT == null) {
        return;
      }
      paramRequestBuilder.addFormField(this.name, paramT, this.encoded);
    }
  }
  
  static final class FieldMap<T>
    extends ParameterHandler<Map<String, T>>
  {
    private final boolean encoded;
    private final Converter<T, String> valueConverter;
    
    FieldMap(Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap != null)
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          paramMap = (String)((Map.Entry)localObject).getKey();
          if (paramMap != null)
          {
            localObject = ((Map.Entry)localObject).getValue();
            if (localObject != null)
            {
              String str = (String)this.valueConverter.convert(localObject);
              if (str != null)
              {
                paramRequestBuilder.addFormField(paramMap, str, this.encoded);
              }
              else
              {
                paramRequestBuilder = new StringBuilder();
                paramRequestBuilder.append("Field map value '");
                paramRequestBuilder.append(localObject);
                paramRequestBuilder.append("' converted to null by ");
                paramRequestBuilder.append(this.valueConverter.getClass().getName());
                paramRequestBuilder.append(" for key '");
                paramRequestBuilder.append(paramMap);
                paramRequestBuilder.append("'.");
                throw new IllegalArgumentException(paramRequestBuilder.toString());
              }
            }
            else
            {
              paramRequestBuilder = new StringBuilder();
              paramRequestBuilder.append("Field map contained null value for key '");
              paramRequestBuilder.append(paramMap);
              paramRequestBuilder.append("'.");
              throw new IllegalArgumentException(paramRequestBuilder.toString());
            }
          }
          else
          {
            throw new IllegalArgumentException("Field map contained null key.");
          }
        }
        return;
      }
      throw new IllegalArgumentException("Field map was null.");
    }
  }
  
  static final class Header<T>
    extends ParameterHandler<T>
  {
    private final String name;
    private final Converter<T, String> valueConverter;
    
    Header(String paramString, Converter<T, String> paramConverter)
    {
      this.name = ((String)Utils.checkNotNull(paramString, "name == null"));
      this.valueConverter = paramConverter;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null) {
        return;
      }
      paramT = (String)this.valueConverter.convert(paramT);
      if (paramT == null) {
        return;
      }
      paramRequestBuilder.addHeader(this.name, paramT);
    }
  }
  
  static final class HeaderMap<T>
    extends ParameterHandler<Map<String, T>>
  {
    private final Converter<T, String> valueConverter;
    
    HeaderMap(Converter<T, String> paramConverter)
    {
      this.valueConverter = paramConverter;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap != null)
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          paramMap = (String)((Map.Entry)localObject).getKey();
          if (paramMap != null)
          {
            localObject = ((Map.Entry)localObject).getValue();
            if (localObject != null)
            {
              paramRequestBuilder.addHeader(paramMap, (String)this.valueConverter.convert(localObject));
            }
            else
            {
              paramRequestBuilder = new StringBuilder();
              paramRequestBuilder.append("Header map contained null value for key '");
              paramRequestBuilder.append(paramMap);
              paramRequestBuilder.append("'.");
              throw new IllegalArgumentException(paramRequestBuilder.toString());
            }
          }
          else
          {
            throw new IllegalArgumentException("Header map contained null key.");
          }
        }
        return;
      }
      throw new IllegalArgumentException("Header map was null.");
    }
  }
  
  static final class Part<T>
    extends ParameterHandler<T>
  {
    private final Converter<T, ab> converter;
    private final s headers;
    
    Part(s params, Converter<T, ab> paramConverter)
    {
      this.headers = params;
      this.converter = paramConverter;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
    {
      if (paramT == null) {
        return;
      }
      try
      {
        localObject = (ab)this.converter.convert(paramT);
        paramRequestBuilder.addPart(this.headers, (ab)localObject);
        return;
      }
      catch (IOException paramRequestBuilder)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unable to convert ");
        ((StringBuilder)localObject).append(paramT);
        ((StringBuilder)localObject).append(" to RequestBody");
        throw new RuntimeException(((StringBuilder)localObject).toString(), paramRequestBuilder);
      }
    }
  }
  
  static final class PartMap<T>
    extends ParameterHandler<Map<String, T>>
  {
    private final String transferEncoding;
    private final Converter<T, ab> valueConverter;
    
    PartMap(Converter<T, ab> paramConverter, String paramString)
    {
      this.valueConverter = paramConverter;
      this.transferEncoding = paramString;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap != null)
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          paramMap = (String)((Map.Entry)localObject).getKey();
          if (paramMap != null)
          {
            localObject = ((Map.Entry)localObject).getValue();
            if (localObject != null)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("form-data; name=\"");
              localStringBuilder.append(paramMap);
              localStringBuilder.append("\"");
              paramRequestBuilder.addPart(s.a(new String[] { "Content-Disposition", localStringBuilder.toString(), "Content-Transfer-Encoding", this.transferEncoding }), (ab)this.valueConverter.convert(localObject));
            }
            else
            {
              paramRequestBuilder = new StringBuilder();
              paramRequestBuilder.append("Part map contained null value for key '");
              paramRequestBuilder.append(paramMap);
              paramRequestBuilder.append("'.");
              throw new IllegalArgumentException(paramRequestBuilder.toString());
            }
          }
          else
          {
            throw new IllegalArgumentException("Part map contained null key.");
          }
        }
        return;
      }
      throw new IllegalArgumentException("Part map was null.");
    }
  }
  
  static final class Path<T>
    extends ParameterHandler<T>
  {
    private final boolean encoded;
    private final String name;
    private final Converter<T, String> valueConverter;
    
    Path(String paramString, Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.name = ((String)Utils.checkNotNull(paramString, "name == null"));
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
      throws IOException
    {
      if (paramT != null)
      {
        paramRequestBuilder.addPathParam(this.name, (String)this.valueConverter.convert(paramT), this.encoded);
        return;
      }
      paramRequestBuilder = new StringBuilder();
      paramRequestBuilder.append("Path parameter \"");
      paramRequestBuilder.append(this.name);
      paramRequestBuilder.append("\" value must not be null.");
      throw new IllegalArgumentException(paramRequestBuilder.toString());
    }
  }
  
  static final class Query<T>
    extends ParameterHandler<T>
  {
    private final boolean encoded;
    private final String name;
    private final Converter<T, String> valueConverter;
    
    Query(String paramString, Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.name = ((String)Utils.checkNotNull(paramString, "name == null"));
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null) {
        return;
      }
      paramT = (String)this.valueConverter.convert(paramT);
      if (paramT == null) {
        return;
      }
      paramRequestBuilder.addQueryParam(this.name, paramT, this.encoded);
    }
  }
  
  static final class QueryMap<T>
    extends ParameterHandler<Map<String, T>>
  {
    private final boolean encoded;
    private final Converter<T, String> valueConverter;
    
    QueryMap(Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.valueConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap != null)
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          paramMap = (String)((Map.Entry)localObject).getKey();
          if (paramMap != null)
          {
            localObject = ((Map.Entry)localObject).getValue();
            if (localObject != null)
            {
              String str = (String)this.valueConverter.convert(localObject);
              if (str != null)
              {
                paramRequestBuilder.addQueryParam(paramMap, str, this.encoded);
              }
              else
              {
                paramRequestBuilder = new StringBuilder();
                paramRequestBuilder.append("Query map value '");
                paramRequestBuilder.append(localObject);
                paramRequestBuilder.append("' converted to null by ");
                paramRequestBuilder.append(this.valueConverter.getClass().getName());
                paramRequestBuilder.append(" for key '");
                paramRequestBuilder.append(paramMap);
                paramRequestBuilder.append("'.");
                throw new IllegalArgumentException(paramRequestBuilder.toString());
              }
            }
            else
            {
              paramRequestBuilder = new StringBuilder();
              paramRequestBuilder.append("Query map contained null value for key '");
              paramRequestBuilder.append(paramMap);
              paramRequestBuilder.append("'.");
              throw new IllegalArgumentException(paramRequestBuilder.toString());
            }
          }
          else
          {
            throw new IllegalArgumentException("Query map contained null key.");
          }
        }
        return;
      }
      throw new IllegalArgumentException("Query map was null.");
    }
  }
  
  static final class QueryName<T>
    extends ParameterHandler<T>
  {
    private final boolean encoded;
    private final Converter<T, String> nameConverter;
    
    QueryName(Converter<T, String> paramConverter, boolean paramBoolean)
    {
      this.nameConverter = paramConverter;
      this.encoded = paramBoolean;
    }
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null) {
        return;
      }
      paramRequestBuilder.addQueryParam((String)this.nameConverter.convert(paramT), null, this.encoded);
    }
  }
  
  static final class RawPart
    extends ParameterHandler<w.b>
  {
    static final RawPart INSTANCE = new RawPart();
    
    void apply(RequestBuilder paramRequestBuilder, @Nullable w.b paramb)
    {
      if (paramb != null) {
        paramRequestBuilder.addPart(paramb);
      }
    }
  }
  
  static final class RelativeUrl
    extends ParameterHandler<Object>
  {
    void apply(RequestBuilder paramRequestBuilder, @Nullable Object paramObject)
    {
      Utils.checkNotNull(paramObject, "@Url parameter is null.");
      paramRequestBuilder.setRelativeUrl(paramObject);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\ParameterHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */