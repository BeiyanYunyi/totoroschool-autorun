package retrofit2;

import e.aa.a;
import e.ab;
import e.q.a;
import e.s;
import e.t;
import e.t.a;
import e.v;
import e.w;
import e.w.a;
import e.w.b;
import f.c;
import f.d;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

final class RequestBuilder
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
  private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
  private final t baseUrl;
  @Nullable
  private ab body;
  @Nullable
  private v contentType;
  @Nullable
  private q.a formBuilder;
  private final boolean hasBody;
  private final String method;
  @Nullable
  private w.a multipartBuilder;
  @Nullable
  private String relativeUrl;
  private final aa.a requestBuilder;
  @Nullable
  private t.a urlBuilder;
  
  RequestBuilder(String paramString1, t paramt, @Nullable String paramString2, @Nullable s params, @Nullable v paramv, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.method = paramString1;
    this.baseUrl = paramt;
    this.relativeUrl = paramString2;
    this.requestBuilder = new aa.a();
    this.contentType = paramv;
    this.hasBody = paramBoolean1;
    if (params != null) {
      this.requestBuilder.a(params);
    }
    if (paramBoolean2)
    {
      this.formBuilder = new q.a();
      return;
    }
    if (paramBoolean3)
    {
      this.multipartBuilder = new w.a();
      this.multipartBuilder.a(w.e);
    }
  }
  
  private static String canonicalizeForPath(String paramString, boolean paramBoolean)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      int k = paramString.codePointAt(i);
      if ((k >= 32) && (k < 127) && (" \"<>^`{}|\\?#".indexOf(k) == -1) && ((paramBoolean) || ((k != 47) && (k != 37))))
      {
        i += Character.charCount(k);
      }
      else
      {
        c localc = new c();
        localc.a(paramString, 0, i);
        canonicalizeForPath(localc, paramString, i, j, paramBoolean);
        return localc.o();
      }
    }
    return paramString;
  }
  
  private static void canonicalizeForPath(c paramc, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject3;
    for (Object localObject1 = null; paramInt1 < paramInt2; localObject1 = localObject3)
    {
      int i = paramString.codePointAt(paramInt1);
      if (paramBoolean)
      {
        localObject3 = localObject1;
        if (i == 9) {
          break label217;
        }
        localObject3 = localObject1;
        if (i == 10) {
          break label217;
        }
        localObject3 = localObject1;
        if (i == 12) {
          break label217;
        }
        if (i == 13)
        {
          localObject3 = localObject1;
          break label217;
        }
      }
      if ((i >= 32) && (i < 127) && (" \"<>^`{}|\\?#".indexOf(i) == -1) && ((paramBoolean) || ((i != 47) && (i != 37))))
      {
        paramc.a(i);
        localObject3 = localObject1;
      }
      else
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new c();
        }
        ((c)localObject2).a(i);
        for (;;)
        {
          localObject3 = localObject2;
          if (((c)localObject2).e()) {
            break;
          }
          int j = ((c)localObject2).h() & 0xFF;
          paramc.b(37);
          paramc.b(HEX_DIGITS[(j >> 4 & 0xF)]);
          paramc.b(HEX_DIGITS[(j & 0xF)]);
        }
      }
      label217:
      paramInt1 += Character.charCount(i);
    }
  }
  
  void addFormField(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.formBuilder.b(paramString1, paramString2);
      return;
    }
    this.formBuilder.a(paramString1, paramString2);
  }
  
  void addHeader(String paramString1, String paramString2)
  {
    if ("Content-Type".equalsIgnoreCase(paramString1)) {
      try
      {
        this.contentType = v.a(paramString2);
        return;
      }
      catch (IllegalArgumentException paramString1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Malformed content type: ");
        localStringBuilder.append(paramString2);
        throw new IllegalArgumentException(localStringBuilder.toString(), paramString1);
      }
    }
    this.requestBuilder.b(paramString1, paramString2);
  }
  
  void addPart(s params, ab paramab)
  {
    this.multipartBuilder.a(params, paramab);
  }
  
  void addPart(w.b paramb)
  {
    this.multipartBuilder.a(paramb);
  }
  
  void addPathParam(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.relativeUrl != null)
    {
      String str1 = canonicalizeForPath(paramString2, paramBoolean);
      String str2 = this.relativeUrl;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("}");
      paramString1 = str2.replace(localStringBuilder.toString(), str1);
      if (!PATH_TRAVERSAL.matcher(paramString1).matches())
      {
        this.relativeUrl = paramString1;
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("@Path parameters shouldn't perform path traversal ('.' or '..'): ");
      paramString1.append(paramString2);
      throw new IllegalArgumentException(paramString1.toString());
    }
    throw new AssertionError();
  }
  
  void addQueryParam(String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    if (this.relativeUrl != null)
    {
      this.urlBuilder = this.baseUrl.d(this.relativeUrl);
      if (this.urlBuilder != null)
      {
        this.relativeUrl = null;
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append("Malformed URL. Base: ");
        paramString1.append(this.baseUrl);
        paramString1.append(", Relative: ");
        paramString1.append(this.relativeUrl);
        throw new IllegalArgumentException(paramString1.toString());
      }
    }
    if (paramBoolean)
    {
      this.urlBuilder.b(paramString1, paramString2);
      return;
    }
    this.urlBuilder.a(paramString1, paramString2);
  }
  
  aa.a get()
  {
    Object localObject1 = this.urlBuilder;
    t localt;
    if (localObject1 != null)
    {
      localt = ((t.a)localObject1).c();
    }
    else
    {
      localt = this.baseUrl.c(this.relativeUrl);
      if (localt == null) {
        break label162;
      }
    }
    Object localObject2 = this.body;
    localObject1 = localObject2;
    if (localObject2 == null) {
      if (this.formBuilder != null)
      {
        localObject1 = this.formBuilder.a();
      }
      else if (this.multipartBuilder != null)
      {
        localObject1 = this.multipartBuilder.a();
      }
      else
      {
        localObject1 = localObject2;
        if (this.hasBody) {
          localObject1 = ab.create(null, new byte[0]);
        }
      }
    }
    v localv = this.contentType;
    localObject2 = localObject1;
    if (localv != null) {
      if (localObject1 != null)
      {
        localObject2 = new ContentTypeOverridingRequestBody((ab)localObject1, localv);
      }
      else
      {
        this.requestBuilder.b("Content-Type", localv.toString());
        localObject2 = localObject1;
      }
    }
    return this.requestBuilder.a(localt).a(this.method, (ab)localObject2);
    label162:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Malformed URL. Base: ");
    ((StringBuilder)localObject1).append(this.baseUrl);
    ((StringBuilder)localObject1).append(", Relative: ");
    ((StringBuilder)localObject1).append(this.relativeUrl);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  void setBody(ab paramab)
  {
    this.body = paramab;
  }
  
  void setRelativeUrl(Object paramObject)
  {
    this.relativeUrl = paramObject.toString();
  }
  
  private static class ContentTypeOverridingRequestBody
    extends ab
  {
    private final v contentType;
    private final ab delegate;
    
    ContentTypeOverridingRequestBody(ab paramab, v paramv)
    {
      this.delegate = paramab;
      this.contentType = paramv;
    }
    
    public long contentLength()
      throws IOException
    {
      return this.delegate.contentLength();
    }
    
    public v contentType()
    {
      return this.contentType;
    }
    
    public void writeTo(d paramd)
      throws IOException
    {
      this.delegate.writeTo(paramd);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\RequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */