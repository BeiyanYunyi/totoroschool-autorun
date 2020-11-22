package e.a.c;

import e.ad;
import e.v;
import f.e;
import javax.annotation.Nullable;

public final class h
  extends ad
{
  @Nullable
  private final String a;
  private final long b;
  private final e c;
  
  public h(@Nullable String paramString, long paramLong, e parame)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = parame;
  }
  
  public long contentLength()
  {
    return this.b;
  }
  
  public v contentType()
  {
    if (this.a != null) {
      return v.b(this.a);
    }
    return null;
  }
  
  public e source()
  {
    return this.c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */