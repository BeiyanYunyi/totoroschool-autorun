package d.g;

import d.a.a;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class i
  implements h
{
  private final f a;
  private final Matcher b;
  private final CharSequence c;
  
  public i(Matcher paramMatcher, CharSequence paramCharSequence)
  {
    this.b = paramMatcher;
    this.c = paramCharSequence;
    this.a = ((f)new a(this));
  }
  
  private final MatchResult c()
  {
    return (MatchResult)this.b;
  }
  
  public d.d.c a()
  {
    return k.a(c());
  }
  
  public h b()
  {
    int j = c().end();
    if (c().end() == c().start()) {
      i = 1;
    } else {
      i = 0;
    }
    int i = j + i;
    if (i <= this.c.length())
    {
      Matcher localMatcher = this.b.pattern().matcher(this.c);
      d.c.b.h.a(localMatcher, "matcher.pattern().matcher(input)");
      return k.a(localMatcher, i, this.c);
    }
    return null;
  }
  
  public static final class a
    extends a<e>
    implements g
  {
    public int a()
    {
      return i.a(this.a).groupCount() + 1;
    }
    
    public e a(int paramInt)
    {
      d.d.c localc = k.a(i.a(this.a), paramInt);
      if (localc.f().intValue() >= 0)
      {
        String str = i.a(this.a).group(paramInt);
        d.c.b.h.a(str, "matchResult.group(index)");
        return new e(str, localc);
      }
      return null;
    }
    
    public boolean a(e parame)
    {
      return super.contains(parame);
    }
    
    public final boolean contains(Object paramObject)
    {
      boolean bool;
      if (paramObject != null) {
        bool = paramObject instanceof e;
      } else {
        bool = true;
      }
      if (bool) {
        return a((e)paramObject);
      }
      return false;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public Iterator<e> iterator()
    {
      return d.f.c.a(d.a.b.d((Iterable)d.a.b.a(this)), (d.c.a.b)new a(this)).a();
    }
    
    static final class a
      extends d.c.b.i
      implements d.c.a.b<Integer, e>
    {
      a(i.a parama)
      {
        super();
      }
      
      public final e invoke(int paramInt)
      {
        return this.this$0.a(paramInt);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\g\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */