package e;

import f.d;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public final class q
  extends ab
{
  private static final v a = v.a("application/x-www-form-urlencoded");
  private final List<String> b;
  private final List<String> c;
  
  q(List<String> paramList1, List<String> paramList2)
  {
    this.b = e.a.c.a(paramList1);
    this.c = e.a.c.a(paramList2);
  }
  
  private long a(@Nullable d paramd, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramd = new f.c();
    } else {
      paramd = paramd.b();
    }
    int i = 0;
    int j = this.b.size();
    while (i < j)
    {
      if (i > 0) {
        paramd.b(38);
      }
      paramd.a((String)this.b.get(i));
      paramd.b(61);
      paramd.a((String)this.c.get(i));
      i += 1;
    }
    if (paramBoolean)
    {
      long l = paramd.a();
      paramd.s();
      return l;
    }
    return 0L;
  }
  
  public long contentLength()
  {
    return a(null, true);
  }
  
  public v contentType()
  {
    return a;
  }
  
  public void writeTo(d paramd)
    throws IOException
  {
    a(paramd, false);
  }
  
  public static final class a
  {
    private final List<String> a = new ArrayList();
    private final List<String> b = new ArrayList();
    private final Charset c;
    
    public a()
    {
      this(null);
    }
    
    public a(Charset paramCharset)
    {
      this.c = paramCharset;
    }
    
    public a a(String paramString1, String paramString2)
    {
      if (paramString1 != null)
      {
        if (paramString2 != null)
        {
          this.a.add(t.a(paramString1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
          this.b.add(t.a(paramString2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
          return this;
        }
        throw new NullPointerException("value == null");
      }
      throw new NullPointerException("name == null");
    }
    
    public q a()
    {
      return new q(this.a, this.b);
    }
    
    public a b(String paramString1, String paramString2)
    {
      if (paramString1 != null)
      {
        if (paramString2 != null)
        {
          this.a.add(t.a(paramString1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.c));
          this.b.add(t.a(paramString2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.c));
          return this;
        }
        throw new NullPointerException("value == null");
      }
      throw new NullPointerException("name == null");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */