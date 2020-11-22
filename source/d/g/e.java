package d.g;

import d.c.b.h;
import d.d.c;

public final class e
{
  private final String a;
  private final c b;
  
  public e(String paramString, c paramc)
  {
    this.a = paramString;
    this.b = paramc;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((h.a(this.a, ((e)paramObject).a)) && (h.a(this.b, ((e)paramObject).b))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MatchGroup(value=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", range=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */