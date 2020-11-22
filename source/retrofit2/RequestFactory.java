package retrofit2;

import e.aa;
import e.aa.a;
import e.s;
import e.s.a;
import e.t;
import e.v;
import e.w.b;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Url;

final class RequestFactory
{
  private final t baseUrl;
  @Nullable
  private final v contentType;
  private final boolean hasBody;
  @Nullable
  private final s headers;
  final String httpMethod;
  private final boolean isFormEncoded;
  private final boolean isMultipart;
  private final Method method;
  private final ParameterHandler<?>[] parameterHandlers;
  @Nullable
  private final String relativeUrl;
  
  RequestFactory(Builder paramBuilder)
  {
    this.method = paramBuilder.method;
    this.baseUrl = paramBuilder.retrofit.baseUrl;
    this.httpMethod = paramBuilder.httpMethod;
    this.relativeUrl = paramBuilder.relativeUrl;
    this.headers = paramBuilder.headers;
    this.contentType = paramBuilder.contentType;
    this.hasBody = paramBuilder.hasBody;
    this.isFormEncoded = paramBuilder.isFormEncoded;
    this.isMultipart = paramBuilder.isMultipart;
    this.parameterHandlers = paramBuilder.parameterHandlers;
  }
  
  static RequestFactory parseAnnotations(Retrofit paramRetrofit, Method paramMethod)
  {
    return new Builder(paramRetrofit, paramMethod).build();
  }
  
  aa create(Object[] paramArrayOfObject)
    throws IOException
  {
    ParameterHandler[] arrayOfParameterHandler = this.parameterHandlers;
    int j = paramArrayOfObject.length;
    if (j == arrayOfParameterHandler.length)
    {
      RequestBuilder localRequestBuilder = new RequestBuilder(this.httpMethod, this.baseUrl, this.relativeUrl, this.headers, this.contentType, this.hasBody, this.isFormEncoded, this.isMultipart);
      ArrayList localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramArrayOfObject[i]);
        arrayOfParameterHandler[i].apply(localRequestBuilder, paramArrayOfObject[i]);
        i += 1;
      }
      return localRequestBuilder.get().a(Invocation.class, new Invocation(this.method, localArrayList)).a();
    }
    paramArrayOfObject = new StringBuilder();
    paramArrayOfObject.append("Argument count (");
    paramArrayOfObject.append(j);
    paramArrayOfObject.append(") doesn't match expected count (");
    paramArrayOfObject.append(arrayOfParameterHandler.length);
    paramArrayOfObject.append(")");
    throw new IllegalArgumentException(paramArrayOfObject.toString());
  }
  
  static final class Builder
  {
    private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
    private static final Pattern PARAM_NAME_REGEX = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
    private static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    @Nullable
    v contentType;
    boolean gotBody;
    boolean gotField;
    boolean gotPart;
    boolean gotPath;
    boolean gotQuery;
    boolean gotQueryMap;
    boolean gotQueryName;
    boolean gotUrl;
    boolean hasBody;
    @Nullable
    s headers;
    @Nullable
    String httpMethod;
    boolean isFormEncoded;
    boolean isMultipart;
    final Method method;
    final Annotation[] methodAnnotations;
    final Annotation[][] parameterAnnotationsArray;
    @Nullable
    ParameterHandler<?>[] parameterHandlers;
    final Type[] parameterTypes;
    @Nullable
    String relativeUrl;
    @Nullable
    Set<String> relativeUrlParamNames;
    final Retrofit retrofit;
    
    Builder(Retrofit paramRetrofit, Method paramMethod)
    {
      this.retrofit = paramRetrofit;
      this.method = paramMethod;
      this.methodAnnotations = paramMethod.getAnnotations();
      this.parameterTypes = paramMethod.getGenericParameterTypes();
      this.parameterAnnotationsArray = paramMethod.getParameterAnnotations();
    }
    
    private static Class<?> boxIfPrimitive(Class<?> paramClass)
    {
      if (Boolean.TYPE == paramClass) {
        return Boolean.class;
      }
      if (Byte.TYPE == paramClass) {
        return Byte.class;
      }
      if (Character.TYPE == paramClass) {
        return Character.class;
      }
      if (Double.TYPE == paramClass) {
        return Double.class;
      }
      if (Float.TYPE == paramClass) {
        return Float.class;
      }
      if (Integer.TYPE == paramClass) {
        return Integer.class;
      }
      if (Long.TYPE == paramClass) {
        return Long.class;
      }
      if (Short.TYPE == paramClass) {
        return Short.class;
      }
      return paramClass;
    }
    
    private s parseHeaders(String[] paramArrayOfString)
    {
      s.a locala = new s.a();
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = paramArrayOfString[i];
        int k = str2.indexOf(':');
        if ((k != -1) && (k != 0) && (k != str2.length() - 1))
        {
          String str1 = str2.substring(0, k);
          str2 = str2.substring(k + 1).trim();
          if ("Content-Type".equalsIgnoreCase(str1)) {
            try
            {
              this.contentType = v.a(str2);
            }
            catch (IllegalArgumentException paramArrayOfString)
            {
              throw Utils.methodError(this.method, paramArrayOfString, "Malformed content type: %s", new Object[] { str2 });
            }
          } else {
            locala.a(str1, str2);
          }
          i += 1;
        }
        else
        {
          throw Utils.methodError(this.method, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[] { str2 });
        }
      }
      return locala.a();
    }
    
    private void parseHttpMethodAndPath(String paramString1, String paramString2, boolean paramBoolean)
    {
      if (this.httpMethod == null)
      {
        this.httpMethod = paramString1;
        this.hasBody = paramBoolean;
        if (paramString2.isEmpty()) {
          return;
        }
        int i = paramString2.indexOf('?');
        if ((i != -1) && (i < paramString2.length() - 1))
        {
          paramString1 = paramString2.substring(i + 1);
          if (PARAM_URL_REGEX.matcher(paramString1).find()) {
            throw Utils.methodError(this.method, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[] { paramString1 });
          }
        }
        this.relativeUrl = paramString2;
        this.relativeUrlParamNames = parsePathParameters(paramString2);
        return;
      }
      throw Utils.methodError(this.method, "Only one HTTP method is allowed. Found: %s and %s.", new Object[] { this.httpMethod, paramString1 });
    }
    
    private void parseMethodAnnotation(Annotation paramAnnotation)
    {
      if ((paramAnnotation instanceof DELETE))
      {
        parseHttpMethodAndPath("DELETE", ((DELETE)paramAnnotation).value(), false);
        return;
      }
      if ((paramAnnotation instanceof GET))
      {
        parseHttpMethodAndPath("GET", ((GET)paramAnnotation).value(), false);
        return;
      }
      if ((paramAnnotation instanceof HEAD))
      {
        parseHttpMethodAndPath("HEAD", ((HEAD)paramAnnotation).value(), false);
        return;
      }
      if ((paramAnnotation instanceof PATCH))
      {
        parseHttpMethodAndPath("PATCH", ((PATCH)paramAnnotation).value(), true);
        return;
      }
      if ((paramAnnotation instanceof POST))
      {
        parseHttpMethodAndPath("POST", ((POST)paramAnnotation).value(), true);
        return;
      }
      if ((paramAnnotation instanceof PUT))
      {
        parseHttpMethodAndPath("PUT", ((PUT)paramAnnotation).value(), true);
        return;
      }
      if ((paramAnnotation instanceof OPTIONS))
      {
        parseHttpMethodAndPath("OPTIONS", ((OPTIONS)paramAnnotation).value(), false);
        return;
      }
      if ((paramAnnotation instanceof HTTP))
      {
        paramAnnotation = (HTTP)paramAnnotation;
        parseHttpMethodAndPath(paramAnnotation.method(), paramAnnotation.path(), paramAnnotation.hasBody());
        return;
      }
      if ((paramAnnotation instanceof Headers))
      {
        paramAnnotation = ((Headers)paramAnnotation).value();
        if (paramAnnotation.length != 0)
        {
          this.headers = parseHeaders(paramAnnotation);
          return;
        }
        throw Utils.methodError(this.method, "@Headers annotation is empty.", new Object[0]);
      }
      if ((paramAnnotation instanceof Multipart))
      {
        if (!this.isFormEncoded)
        {
          this.isMultipart = true;
          return;
        }
        throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
      }
      if ((paramAnnotation instanceof FormUrlEncoded))
      {
        if (!this.isMultipart)
        {
          this.isFormEncoded = true;
          return;
        }
        throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
      }
    }
    
    private ParameterHandler<?> parseParameter(int paramInt, Type paramType, @Nullable Annotation[] paramArrayOfAnnotation)
    {
      Object localObject = null;
      if (paramArrayOfAnnotation != null)
      {
        int j = paramArrayOfAnnotation.length;
        localObject = null;
        int i = 0;
        while (i < j)
        {
          ParameterHandler localParameterHandler = parseParameterAnnotation(paramInt, paramType, paramArrayOfAnnotation, paramArrayOfAnnotation[i]);
          if (localParameterHandler != null)
          {
            if (localObject == null) {
              localObject = localParameterHandler;
            }
          }
          else
          {
            i += 1;
            continue;
          }
          throw Utils.parameterError(this.method, paramInt, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
        }
      }
      if (localObject != null) {
        return (ParameterHandler<?>)localObject;
      }
      throw Utils.parameterError(this.method, paramInt, "No Retrofit annotation found.", new Object[0]);
    }
    
    @Nullable
    private ParameterHandler<?> parseParameterAnnotation(int paramInt, Type paramType, Annotation[] paramArrayOfAnnotation, Annotation paramAnnotation)
    {
      if ((paramAnnotation instanceof Url))
      {
        validateResolvableType(paramInt, paramType);
        if (!this.gotUrl)
        {
          if (!this.gotPath)
          {
            if (!this.gotQuery)
            {
              if (!this.gotQueryName)
              {
                if (!this.gotQueryMap)
                {
                  if (this.relativeUrl == null)
                  {
                    this.gotUrl = true;
                    if ((paramType != t.class) && (paramType != String.class) && (paramType != URI.class) && ((!(paramType instanceof Class)) || (!"android.net.Uri".equals(((Class)paramType).getName())))) {
                      throw Utils.parameterError(this.method, paramInt, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                    }
                    return new ParameterHandler.RelativeUrl();
                  }
                  throw Utils.parameterError(this.method, paramInt, "@Url cannot be used with @%s URL", new Object[] { this.httpMethod });
                }
                throw Utils.parameterError(this.method, paramInt, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
              }
              throw Utils.parameterError(this.method, paramInt, "A @Url parameter must not come after a @QueryName.", new Object[0]);
            }
            throw Utils.parameterError(this.method, paramInt, "A @Url parameter must not come after a @Query.", new Object[0]);
          }
          throw Utils.parameterError(this.method, paramInt, "@Path parameters may not be used with @Url.", new Object[0]);
        }
        throw Utils.parameterError(this.method, paramInt, "Multiple @Url method annotations found.", new Object[0]);
      }
      Object localObject;
      if ((paramAnnotation instanceof Path))
      {
        validateResolvableType(paramInt, paramType);
        if (!this.gotQuery)
        {
          if (!this.gotQueryName)
          {
            if (!this.gotQueryMap)
            {
              if (!this.gotUrl)
              {
                if (this.relativeUrl != null)
                {
                  this.gotPath = true;
                  paramAnnotation = (Path)paramAnnotation;
                  localObject = paramAnnotation.value();
                  validatePathName(paramInt, (String)localObject);
                  return new ParameterHandler.Path((String)localObject, this.retrofit.stringConverter(paramType, paramArrayOfAnnotation), paramAnnotation.encoded());
                }
                throw Utils.parameterError(this.method, paramInt, "@Path can only be used with relative url on @%s", new Object[] { this.httpMethod });
              }
              throw Utils.parameterError(this.method, paramInt, "@Path parameters may not be used with @Url.", new Object[0]);
            }
            throw Utils.parameterError(this.method, paramInt, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
          }
          throw Utils.parameterError(this.method, paramInt, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        }
        throw Utils.parameterError(this.method, paramInt, "A @Path parameter must not come after a @Query.", new Object[0]);
      }
      boolean bool;
      if ((paramAnnotation instanceof Query))
      {
        validateResolvableType(paramInt, paramType);
        localObject = (Query)paramAnnotation;
        paramAnnotation = ((Query)localObject).value();
        bool = ((Query)localObject).encoded();
        localObject = Utils.getRawType(paramType);
        this.gotQuery = true;
        if (Iterable.class.isAssignableFrom((Class)localObject))
        {
          if ((paramType instanceof ParameterizedType))
          {
            paramType = Utils.getParameterUpperBound(0, (ParameterizedType)paramType);
            return new ParameterHandler.Query(paramAnnotation, this.retrofit.stringConverter(paramType, paramArrayOfAnnotation), bool).iterable();
          }
          paramType = this.method;
          paramArrayOfAnnotation = new StringBuilder();
          paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
          paramArrayOfAnnotation.append(" must include generic type (e.g., ");
          paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
          paramArrayOfAnnotation.append("<String>)");
          throw Utils.parameterError(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
        }
        if (((Class)localObject).isArray())
        {
          paramType = boxIfPrimitive(((Class)localObject).getComponentType());
          return new ParameterHandler.Query(paramAnnotation, this.retrofit.stringConverter(paramType, paramArrayOfAnnotation), bool).array();
        }
        return new ParameterHandler.Query(paramAnnotation, this.retrofit.stringConverter(paramType, paramArrayOfAnnotation), bool);
      }
      if ((paramAnnotation instanceof QueryName))
      {
        validateResolvableType(paramInt, paramType);
        bool = ((QueryName)paramAnnotation).encoded();
        paramAnnotation = Utils.getRawType(paramType);
        this.gotQueryName = true;
        if (Iterable.class.isAssignableFrom(paramAnnotation))
        {
          if ((paramType instanceof ParameterizedType))
          {
            paramType = Utils.getParameterUpperBound(0, (ParameterizedType)paramType);
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(paramType, paramArrayOfAnnotation), bool).iterable();
          }
          paramType = this.method;
          paramArrayOfAnnotation = new StringBuilder();
          paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
          paramArrayOfAnnotation.append(" must include generic type (e.g., ");
          paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
          paramArrayOfAnnotation.append("<String>)");
          throw Utils.parameterError(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
        }
        if (paramAnnotation.isArray())
        {
          paramType = boxIfPrimitive(paramAnnotation.getComponentType());
          return new ParameterHandler.QueryName(this.retrofit.stringConverter(paramType, paramArrayOfAnnotation), bool).array();
        }
        return new ParameterHandler.QueryName(this.retrofit.stringConverter(paramType, paramArrayOfAnnotation), bool);
      }
      if ((paramAnnotation instanceof QueryMap))
      {
        validateResolvableType(paramInt, paramType);
        localObject = Utils.getRawType(paramType);
        this.gotQueryMap = true;
        if (Map.class.isAssignableFrom((Class)localObject))
        {
          paramType = Utils.getSupertype(paramType, (Class)localObject, Map.class);
          if ((paramType instanceof ParameterizedType))
          {
            localObject = (ParameterizedType)paramType;
            paramType = Utils.getParameterUpperBound(0, (ParameterizedType)localObject);
            if (String.class == paramType)
            {
              paramType = Utils.getParameterUpperBound(1, (ParameterizedType)localObject);
              return new ParameterHandler.QueryMap(this.retrofit.stringConverter(paramType, paramArrayOfAnnotation), ((QueryMap)paramAnnotation).encoded());
            }
            paramArrayOfAnnotation = this.method;
            paramAnnotation = new StringBuilder();
            paramAnnotation.append("@QueryMap keys must be of type String: ");
            paramAnnotation.append(paramType);
            throw Utils.parameterError(paramArrayOfAnnotation, paramInt, paramAnnotation.toString(), new Object[0]);
          }
          throw Utils.parameterError(this.method, paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        }
        throw Utils.parameterError(this.method, paramInt, "@QueryMap parameter type must be Map.", new Object[0]);
      }
      if ((paramAnnotation instanceof Header))
      {
        validateResolvableType(paramInt, paramType);
        paramAnnotation = ((Header)paramAnnotation).value();
        localObject = Utils.getRawType(paramType);
        if (Iterable.class.isAssignableFrom((Class)localObject))
        {
          if ((paramType instanceof ParameterizedType))
          {
            paramType = Utils.getParameterUpperBound(0, (ParameterizedType)paramType);
            return new ParameterHandler.Header(paramAnnotation, this.retrofit.stringConverter(paramType, paramArrayOfAnnotation)).iterable();
          }
          paramType = this.method;
          paramArrayOfAnnotation = new StringBuilder();
          paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
          paramArrayOfAnnotation.append(" must include generic type (e.g., ");
          paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
          paramArrayOfAnnotation.append("<String>)");
          throw Utils.parameterError(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
        }
        if (((Class)localObject).isArray())
        {
          paramType = boxIfPrimitive(((Class)localObject).getComponentType());
          return new ParameterHandler.Header(paramAnnotation, this.retrofit.stringConverter(paramType, paramArrayOfAnnotation)).array();
        }
        return new ParameterHandler.Header(paramAnnotation, this.retrofit.stringConverter(paramType, paramArrayOfAnnotation));
      }
      if ((paramAnnotation instanceof HeaderMap))
      {
        validateResolvableType(paramInt, paramType);
        paramAnnotation = Utils.getRawType(paramType);
        if (Map.class.isAssignableFrom(paramAnnotation))
        {
          paramType = Utils.getSupertype(paramType, paramAnnotation, Map.class);
          if ((paramType instanceof ParameterizedType))
          {
            paramAnnotation = (ParameterizedType)paramType;
            paramType = Utils.getParameterUpperBound(0, paramAnnotation);
            if (String.class == paramType)
            {
              paramType = Utils.getParameterUpperBound(1, paramAnnotation);
              return new ParameterHandler.HeaderMap(this.retrofit.stringConverter(paramType, paramArrayOfAnnotation));
            }
            paramArrayOfAnnotation = this.method;
            paramAnnotation = new StringBuilder();
            paramAnnotation.append("@HeaderMap keys must be of type String: ");
            paramAnnotation.append(paramType);
            throw Utils.parameterError(paramArrayOfAnnotation, paramInt, paramAnnotation.toString(), new Object[0]);
          }
          throw Utils.parameterError(this.method, paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        }
        throw Utils.parameterError(this.method, paramInt, "@HeaderMap parameter type must be Map.", new Object[0]);
      }
      if ((paramAnnotation instanceof Field))
      {
        validateResolvableType(paramInt, paramType);
        if (this.isFormEncoded)
        {
          localObject = (Field)paramAnnotation;
          paramAnnotation = ((Field)localObject).value();
          bool = ((Field)localObject).encoded();
          this.gotField = true;
          localObject = Utils.getRawType(paramType);
          if (Iterable.class.isAssignableFrom((Class)localObject))
          {
            if ((paramType instanceof ParameterizedType))
            {
              paramType = Utils.getParameterUpperBound(0, (ParameterizedType)paramType);
              return new ParameterHandler.Field(paramAnnotation, this.retrofit.stringConverter(paramType, paramArrayOfAnnotation), bool).iterable();
            }
            paramType = this.method;
            paramArrayOfAnnotation = new StringBuilder();
            paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
            paramArrayOfAnnotation.append(" must include generic type (e.g., ");
            paramArrayOfAnnotation.append(((Class)localObject).getSimpleName());
            paramArrayOfAnnotation.append("<String>)");
            throw Utils.parameterError(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
          }
          if (((Class)localObject).isArray())
          {
            paramType = boxIfPrimitive(((Class)localObject).getComponentType());
            return new ParameterHandler.Field(paramAnnotation, this.retrofit.stringConverter(paramType, paramArrayOfAnnotation), bool).array();
          }
          return new ParameterHandler.Field(paramAnnotation, this.retrofit.stringConverter(paramType, paramArrayOfAnnotation), bool);
        }
        throw Utils.parameterError(this.method, paramInt, "@Field parameters can only be used with form encoding.", new Object[0]);
      }
      if ((paramAnnotation instanceof FieldMap))
      {
        validateResolvableType(paramInt, paramType);
        if (this.isFormEncoded)
        {
          localObject = Utils.getRawType(paramType);
          if (Map.class.isAssignableFrom((Class)localObject))
          {
            paramType = Utils.getSupertype(paramType, (Class)localObject, Map.class);
            if ((paramType instanceof ParameterizedType))
            {
              localObject = (ParameterizedType)paramType;
              paramType = Utils.getParameterUpperBound(0, (ParameterizedType)localObject);
              if (String.class == paramType)
              {
                paramType = Utils.getParameterUpperBound(1, (ParameterizedType)localObject);
                paramType = this.retrofit.stringConverter(paramType, paramArrayOfAnnotation);
                this.gotField = true;
                return new ParameterHandler.FieldMap(paramType, ((FieldMap)paramAnnotation).encoded());
              }
              paramArrayOfAnnotation = this.method;
              paramAnnotation = new StringBuilder();
              paramAnnotation.append("@FieldMap keys must be of type String: ");
              paramAnnotation.append(paramType);
              throw Utils.parameterError(paramArrayOfAnnotation, paramInt, paramAnnotation.toString(), new Object[0]);
            }
            throw Utils.parameterError(this.method, paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
          }
          throw Utils.parameterError(this.method, paramInt, "@FieldMap parameter type must be Map.", new Object[0]);
        }
        throw Utils.parameterError(this.method, paramInt, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
      }
      if ((paramAnnotation instanceof Part))
      {
        validateResolvableType(paramInt, paramType);
        if (this.isMultipart)
        {
          localObject = (Part)paramAnnotation;
          this.gotPart = true;
          String str = ((Part)localObject).value();
          paramAnnotation = Utils.getRawType(paramType);
          if (str.isEmpty())
          {
            if (Iterable.class.isAssignableFrom(paramAnnotation))
            {
              if ((paramType instanceof ParameterizedType))
              {
                if (w.b.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType)paramType)))) {
                  return ParameterHandler.RawPart.INSTANCE.iterable();
                }
                throw Utils.parameterError(this.method, paramInt, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
              }
              paramType = this.method;
              paramArrayOfAnnotation = new StringBuilder();
              paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
              paramArrayOfAnnotation.append(" must include generic type (e.g., ");
              paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
              paramArrayOfAnnotation.append("<String>)");
              throw Utils.parameterError(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
            }
            if (paramAnnotation.isArray())
            {
              if (w.b.class.isAssignableFrom(paramAnnotation.getComponentType())) {
                return ParameterHandler.RawPart.INSTANCE.array();
              }
              throw Utils.parameterError(this.method, paramInt, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
            }
            if (w.b.class.isAssignableFrom(paramAnnotation)) {
              return ParameterHandler.RawPart.INSTANCE;
            }
            throw Utils.parameterError(this.method, paramInt, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("form-data; name=\"");
          localStringBuilder.append(str);
          localStringBuilder.append("\"");
          localObject = s.a(new String[] { "Content-Disposition", localStringBuilder.toString(), "Content-Transfer-Encoding", ((Part)localObject).encoding() });
          if (Iterable.class.isAssignableFrom(paramAnnotation))
          {
            if ((paramType instanceof ParameterizedType))
            {
              paramType = Utils.getParameterUpperBound(0, (ParameterizedType)paramType);
              if (!w.b.class.isAssignableFrom(Utils.getRawType(paramType))) {
                return new ParameterHandler.Part((s)localObject, this.retrofit.requestBodyConverter(paramType, paramArrayOfAnnotation, this.methodAnnotations)).iterable();
              }
              throw Utils.parameterError(this.method, paramInt, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
            }
            paramType = this.method;
            paramArrayOfAnnotation = new StringBuilder();
            paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
            paramArrayOfAnnotation.append(" must include generic type (e.g., ");
            paramArrayOfAnnotation.append(paramAnnotation.getSimpleName());
            paramArrayOfAnnotation.append("<String>)");
            throw Utils.parameterError(paramType, paramInt, paramArrayOfAnnotation.toString(), new Object[0]);
          }
          if (paramAnnotation.isArray())
          {
            paramType = boxIfPrimitive(paramAnnotation.getComponentType());
            if (!w.b.class.isAssignableFrom(paramType)) {
              return new ParameterHandler.Part((s)localObject, this.retrofit.requestBodyConverter(paramType, paramArrayOfAnnotation, this.methodAnnotations)).array();
            }
            throw Utils.parameterError(this.method, paramInt, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
          }
          if (!w.b.class.isAssignableFrom(paramAnnotation)) {
            return new ParameterHandler.Part((s)localObject, this.retrofit.requestBodyConverter(paramType, paramArrayOfAnnotation, this.methodAnnotations));
          }
          throw Utils.parameterError(this.method, paramInt, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
        }
        throw Utils.parameterError(this.method, paramInt, "@Part parameters can only be used with multipart encoding.", new Object[0]);
      }
      if ((paramAnnotation instanceof PartMap))
      {
        validateResolvableType(paramInt, paramType);
        if (this.isMultipart)
        {
          this.gotPart = true;
          localObject = Utils.getRawType(paramType);
          if (Map.class.isAssignableFrom((Class)localObject))
          {
            paramType = Utils.getSupertype(paramType, (Class)localObject, Map.class);
            if ((paramType instanceof ParameterizedType))
            {
              localObject = (ParameterizedType)paramType;
              paramType = Utils.getParameterUpperBound(0, (ParameterizedType)localObject);
              if (String.class == paramType)
              {
                paramType = Utils.getParameterUpperBound(1, (ParameterizedType)localObject);
                if (!w.b.class.isAssignableFrom(Utils.getRawType(paramType))) {
                  return new ParameterHandler.PartMap(this.retrofit.requestBodyConverter(paramType, paramArrayOfAnnotation, this.methodAnnotations), ((PartMap)paramAnnotation).encoding());
                }
                throw Utils.parameterError(this.method, paramInt, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
              }
              paramArrayOfAnnotation = this.method;
              paramAnnotation = new StringBuilder();
              paramAnnotation.append("@PartMap keys must be of type String: ");
              paramAnnotation.append(paramType);
              throw Utils.parameterError(paramArrayOfAnnotation, paramInt, paramAnnotation.toString(), new Object[0]);
            }
            throw Utils.parameterError(this.method, paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
          }
          throw Utils.parameterError(this.method, paramInt, "@PartMap parameter type must be Map.", new Object[0]);
        }
        throw Utils.parameterError(this.method, paramInt, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
      }
      if ((paramAnnotation instanceof Body))
      {
        validateResolvableType(paramInt, paramType);
        if ((!this.isFormEncoded) && (!this.isMultipart))
        {
          if (!this.gotBody) {
            try
            {
              paramArrayOfAnnotation = this.retrofit.requestBodyConverter(paramType, paramArrayOfAnnotation, this.methodAnnotations);
              this.gotBody = true;
              return new ParameterHandler.Body(paramArrayOfAnnotation);
            }
            catch (RuntimeException paramArrayOfAnnotation)
            {
              throw Utils.parameterError(this.method, paramArrayOfAnnotation, paramInt, "Unable to create @Body converter for %s", new Object[] { paramType });
            }
          }
          throw Utils.parameterError(this.method, paramInt, "Multiple @Body method annotations found.", new Object[0]);
        }
        throw Utils.parameterError(this.method, paramInt, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
      }
      return null;
    }
    
    static Set<String> parsePathParameters(String paramString)
    {
      paramString = PARAM_URL_REGEX.matcher(paramString);
      LinkedHashSet localLinkedHashSet = new LinkedHashSet();
      while (paramString.find()) {
        localLinkedHashSet.add(paramString.group(1));
      }
      return localLinkedHashSet;
    }
    
    private void validatePathName(int paramInt, String paramString)
    {
      if (PARAM_NAME_REGEX.matcher(paramString).matches())
      {
        if (this.relativeUrlParamNames.contains(paramString)) {
          return;
        }
        throw Utils.parameterError(this.method, paramInt, "URL \"%s\" does not contain \"{%s}\".", new Object[] { this.relativeUrl, paramString });
      }
      throw Utils.parameterError(this.method, paramInt, "@Path parameter name must match %s. Found: %s", new Object[] { PARAM_URL_REGEX.pattern(), paramString });
    }
    
    private void validateResolvableType(int paramInt, Type paramType)
    {
      if (!Utils.hasUnresolvableType(paramType)) {
        return;
      }
      throw Utils.parameterError(this.method, paramInt, "Parameter type must not include a type variable or wildcard: %s", new Object[] { paramType });
    }
    
    RequestFactory build()
    {
      Annotation[] arrayOfAnnotation = this.methodAnnotations;
      int j = arrayOfAnnotation.length;
      int i = 0;
      while (i < j)
      {
        parseMethodAnnotation(arrayOfAnnotation[i]);
        i += 1;
      }
      if (this.httpMethod != null)
      {
        if (!this.hasBody) {
          if (!this.isMultipart)
          {
            if (this.isFormEncoded) {
              throw Utils.methodError(this.method, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
          }
          else {
            throw Utils.methodError(this.method, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
          }
        }
        j = this.parameterAnnotationsArray.length;
        this.parameterHandlers = new ParameterHandler[j];
        i = 0;
        while (i < j)
        {
          this.parameterHandlers[i] = parseParameter(i, this.parameterTypes[i], this.parameterAnnotationsArray[i]);
          i += 1;
        }
        if ((this.relativeUrl == null) && (!this.gotUrl)) {
          throw Utils.methodError(this.method, "Missing either @%s URL or @Url parameter.", new Object[] { this.httpMethod });
        }
        if ((!this.isFormEncoded) && (!this.isMultipart) && (!this.hasBody) && (this.gotBody)) {
          throw Utils.methodError(this.method, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        }
        if ((this.isFormEncoded) && (!this.gotField)) {
          throw Utils.methodError(this.method, "Form-encoded method must contain at least one @Field.", new Object[0]);
        }
        if ((this.isMultipart) && (!this.gotPart)) {
          throw Utils.methodError(this.method, "Multipart method must contain at least one @Part.", new Object[0]);
        }
        return new RequestFactory(this);
      }
      throw Utils.methodError(this.method, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\RequestFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */