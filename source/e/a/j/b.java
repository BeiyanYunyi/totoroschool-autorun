package e.a.j;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public final class b
  implements e
{
  private final Map<X500Principal, Set<X509Certificate>> a = new LinkedHashMap();
  
  public b(X509Certificate... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      X509Certificate localX509Certificate = paramVarArgs[i];
      X500Principal localX500Principal = localX509Certificate.getSubjectX500Principal();
      Set localSet = (Set)this.a.get(localX500Principal);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new LinkedHashSet(1);
        this.a.put(localX500Principal, localObject);
      }
      ((Set)localObject).add(localX509Certificate);
      i += 1;
    }
  }
  
  public X509Certificate a(X509Certificate paramX509Certificate)
  {
    Object localObject = paramX509Certificate.getIssuerX500Principal();
    localObject = (Set)this.a.get(localObject);
    if (localObject == null) {
      return null;
    }
    localObject = ((Set)localObject).iterator();
    for (;;)
    {
      X509Certificate localX509Certificate;
      PublicKey localPublicKey;
      if (((Iterator)localObject).hasNext())
      {
        localX509Certificate = (X509Certificate)((Iterator)localObject).next();
        localPublicKey = localX509Certificate.getPublicKey();
      }
      try
      {
        paramX509Certificate.verify(localPublicKey);
        return localX509Certificate;
      }
      catch (Exception localException) {}
      return null;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    return ((paramObject instanceof b)) && (((b)paramObject).a.equals(this.a));
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\j\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */