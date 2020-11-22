package e;

import f.f;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class g
{
  public static final g a = new a().a();
  private final Set<b> b;
  @Nullable
  private final e.a.j.c c;
  
  g(Set<b> paramSet, @Nullable e.a.j.c paramc)
  {
    this.b = paramSet;
    this.c = paramc;
  }
  
  static f a(X509Certificate paramX509Certificate)
  {
    return f.of(paramX509Certificate.getPublicKey().getEncoded()).sha1();
  }
  
  public static String a(Certificate paramCertificate)
  {
    if ((paramCertificate instanceof X509Certificate))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sha256/");
      localStringBuilder.append(b((X509Certificate)paramCertificate).base64());
      return localStringBuilder.toString();
    }
    throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
  }
  
  static f b(X509Certificate paramX509Certificate)
  {
    return f.of(paramX509Certificate.getPublicKey().getEncoded()).sha256();
  }
  
  g a(@Nullable e.a.j.c paramc)
  {
    if (e.a.c.a(this.c, paramc)) {
      return this;
    }
    return new g(this.b, paramc);
  }
  
  List<b> a(String paramString)
  {
    Object localObject1 = Collections.emptyList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.a(paramString))
      {
        Object localObject2 = localObject1;
        if (((List)localObject1).isEmpty()) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).add(localb);
        localObject1 = localObject2;
      }
    }
    return (List<b>)localObject1;
  }
  
  public void a(String paramString, List<Certificate> paramList)
    throws SSLPeerUnverifiedException
  {
    List localList = a(paramString);
    if (localList.isEmpty()) {
      return;
    }
    Object localObject3 = paramList;
    if (this.c != null) {
      localObject3 = this.c.a(paramList, paramString);
    }
    int m = ((List)localObject3).size();
    int k = 0;
    int i = 0;
    Object localObject1;
    while (i < m)
    {
      X509Certificate localX509Certificate = (X509Certificate)((List)localObject3).get(i);
      int n = localList.size();
      localObject1 = null;
      paramList = (List<Certificate>)localObject1;
      j = 0;
      while (j < n)
      {
        b localb = (b)localList.get(j);
        Object localObject2;
        if (localb.c.equals("sha256/"))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = b(localX509Certificate);
          }
          localObject1 = localObject2;
          if (!localb.d.equals(localObject2)) {}
        }
        else
        {
          if (!localb.c.equals("sha1/")) {
            break label211;
          }
          localObject2 = paramList;
          if (paramList == null) {
            localObject2 = a(localX509Certificate);
          }
          paramList = (List<Certificate>)localObject2;
          if (localb.d.equals(localObject2)) {
            return;
          }
        }
        j += 1;
        continue;
        label211:
        paramString = new StringBuilder();
        paramString.append("unsupported hashAlgorithm: ");
        paramString.append(localb.c);
        throw new AssertionError(paramString.toString());
      }
      i += 1;
    }
    paramList = new StringBuilder();
    paramList.append("Certificate pinning failure!");
    paramList.append("\n  Peer certificate chain:");
    int j = ((List)localObject3).size();
    i = 0;
    while (i < j)
    {
      localObject1 = (X509Certificate)((List)localObject3).get(i);
      paramList.append("\n    ");
      paramList.append(a((Certificate)localObject1));
      paramList.append(": ");
      paramList.append(((X509Certificate)localObject1).getSubjectDN().getName());
      i += 1;
    }
    paramList.append("\n  Pinned certificates for ");
    paramList.append(paramString);
    paramList.append(":");
    j = localList.size();
    i = k;
    while (i < j)
    {
      paramString = (b)localList.get(i);
      paramList.append("\n    ");
      paramList.append(paramString);
      i += 1;
    }
    throw new SSLPeerUnverifiedException(paramList.toString());
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof g))
    {
      e.a.j.c localc = this.c;
      paramObject = (g)paramObject;
      if ((e.a.c.a(localc, ((g)paramObject).c)) && (this.b.equals(((g)paramObject).b))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    int i;
    if (this.c != null) {
      i = this.c.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + this.b.hashCode();
  }
  
  public static final class a
  {
    private final List<g.b> a = new ArrayList();
    
    public g a()
    {
      return new g(new LinkedHashSet(this.a), null);
    }
  }
  
  static final class b
  {
    final String a;
    final String b;
    final String c;
    final f d;
    
    boolean a(String paramString)
    {
      if (this.a.startsWith("*."))
      {
        int i = paramString.indexOf('.');
        return (paramString.length() - i - 1 == this.b.length()) && (paramString.regionMatches(false, i + 1, this.b, 0, this.b.length()));
      }
      return paramString.equals(this.b);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof b))
      {
        String str = this.a;
        paramObject = (b)paramObject;
        if ((str.equals(((b)paramObject).a)) && (this.c.equals(((b)paramObject).c)) && (this.d.equals(((b)paramObject).d))) {
          return true;
        }
      }
      return false;
    }
    
    public int hashCode()
    {
      return ((527 + this.a.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append(this.d.base64());
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */