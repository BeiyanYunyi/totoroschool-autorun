package e;

import f.d;
import f.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;

public final class w
  extends ab
{
  public static final v a = v.a("multipart/mixed");
  public static final v b = v.a("multipart/alternative");
  public static final v c = v.a("multipart/digest");
  public static final v d = v.a("multipart/parallel");
  public static final v e = v.a("multipart/form-data");
  private static final byte[] f = { 58, 32 };
  private static final byte[] g = { 13, 10 };
  private static final byte[] h = { 45, 45 };
  private final f i;
  private final v j;
  private final v k;
  private final List<b> l;
  private long m = -1L;
  
  w(f paramf, v paramv, List<b> paramList)
  {
    this.i = paramf;
    this.j = paramv;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramv);
    localStringBuilder.append("; boundary=");
    localStringBuilder.append(paramf.utf8());
    this.k = v.a(localStringBuilder.toString());
    this.l = e.a.c.a(paramList);
  }
  
  private long a(@Nullable d paramd, boolean paramBoolean)
    throws IOException
  {
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = new f.c();
      paramd = (d)localObject1;
    }
    else
    {
      localObject2 = null;
      localObject1 = paramd;
      paramd = (d)localObject2;
    }
    int i2 = this.l.size();
    long l1 = 0L;
    int n = 0;
    while (n < i2)
    {
      Object localObject3 = (b)this.l.get(n);
      localObject2 = ((b)localObject3).a;
      localObject3 = ((b)localObject3).b;
      ((d)localObject1).c(h);
      ((d)localObject1).b(this.i);
      ((d)localObject1).c(g);
      if (localObject2 != null)
      {
        int i3 = ((s)localObject2).a();
        int i1 = 0;
        while (i1 < i3)
        {
          ((d)localObject1).b(((s)localObject2).a(i1)).c(f).b(((s)localObject2).b(i1)).c(g);
          i1 += 1;
        }
      }
      localObject2 = ((ab)localObject3).contentType();
      if (localObject2 != null) {
        ((d)localObject1).b("Content-Type: ").b(((v)localObject2).toString()).c(g);
      }
      l2 = ((ab)localObject3).contentLength();
      if (l2 != -1L)
      {
        ((d)localObject1).b("Content-Length: ").m(l2).c(g);
      }
      else if (paramBoolean)
      {
        paramd.s();
        return -1L;
      }
      ((d)localObject1).c(g);
      if (paramBoolean) {
        l1 += l2;
      } else {
        ((ab)localObject3).writeTo((d)localObject1);
      }
      ((d)localObject1).c(g);
      n += 1;
    }
    ((d)localObject1).c(h);
    ((d)localObject1).b(this.i);
    ((d)localObject1).c(h);
    ((d)localObject1).c(g);
    long l2 = l1;
    if (paramBoolean)
    {
      l2 = l1 + paramd.a();
      paramd.s();
    }
    return l2;
  }
  
  static StringBuilder a(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"');
    int i1 = paramString.length();
    int n = 0;
    while (n < i1)
    {
      char c1 = paramString.charAt(n);
      if (c1 != '\n')
      {
        if (c1 != '\r')
        {
          if (c1 != '"') {
            paramStringBuilder.append(c1);
          } else {
            paramStringBuilder.append("%22");
          }
        }
        else {
          paramStringBuilder.append("%0D");
        }
      }
      else {
        paramStringBuilder.append("%0A");
      }
      n += 1;
    }
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  public long contentLength()
    throws IOException
  {
    long l1 = this.m;
    if (l1 != -1L) {
      return l1;
    }
    l1 = a(null, true);
    this.m = l1;
    return l1;
  }
  
  public v contentType()
  {
    return this.k;
  }
  
  public void writeTo(d paramd)
    throws IOException
  {
    a(paramd, false);
  }
  
  public static final class a
  {
    private final f a;
    private v b = w.a;
    private final List<w.b> c = new ArrayList();
    
    public a()
    {
      this(UUID.randomUUID().toString());
    }
    
    public a(String paramString)
    {
      this.a = f.encodeUtf8(paramString);
    }
    
    public a a(@Nullable s params, ab paramab)
    {
      return a(w.b.a(params, paramab));
    }
    
    public a a(v paramv)
    {
      if (paramv != null)
      {
        if (paramv.a().equals("multipart"))
        {
          this.b = paramv;
          return this;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("multipart != ");
        localStringBuilder.append(paramv);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      throw new NullPointerException("type == null");
    }
    
    public a a(w.b paramb)
    {
      if (paramb != null)
      {
        this.c.add(paramb);
        return this;
      }
      throw new NullPointerException("part == null");
    }
    
    public a a(String paramString1, String paramString2)
    {
      return a(w.b.a(paramString1, paramString2));
    }
    
    public a a(String paramString1, @Nullable String paramString2, ab paramab)
    {
      return a(w.b.a(paramString1, paramString2, paramab));
    }
    
    public w a()
    {
      if (!this.c.isEmpty()) {
        return new w(this.a, this.b, this.c);
      }
      throw new IllegalStateException("Multipart body must have at least one part.");
    }
  }
  
  public static final class b
  {
    @Nullable
    final s a;
    final ab b;
    
    private b(@Nullable s params, ab paramab)
    {
      this.a = params;
      this.b = paramab;
    }
    
    public static b a(@Nullable s params, ab paramab)
    {
      if (paramab != null)
      {
        if ((params != null) && (params.a("Content-Type") != null)) {
          throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
        if ((params != null) && (params.a("Content-Length") != null)) {
          throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
        return new b(params, paramab);
      }
      throw new NullPointerException("body == null");
    }
    
    public static b a(String paramString1, String paramString2)
    {
      return a(paramString1, null, ab.create(null, paramString2));
    }
    
    public static b a(String paramString1, @Nullable String paramString2, ab paramab)
    {
      if (paramString1 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("form-data; name=");
        w.a(localStringBuilder, paramString1);
        if (paramString2 != null)
        {
          localStringBuilder.append("; filename=");
          w.a(localStringBuilder, paramString2);
        }
        return a(s.a(new String[] { "Content-Disposition", localStringBuilder.toString() }), paramab);
      }
      throw new NullPointerException("name == null");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */