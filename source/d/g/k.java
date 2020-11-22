package d.g;

import d.c.a.b;
import d.d.c;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

public final class k
{
  private static final int b(Iterable<? extends d> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext()) {
      i |= ((d)paramIterable.next()).getValue();
    }
    return i;
  }
  
  private static final c b(MatchResult paramMatchResult)
  {
    return d.d.d.b(paramMatchResult.start(), paramMatchResult.end());
  }
  
  private static final c b(MatchResult paramMatchResult, int paramInt)
  {
    return d.d.d.b(paramMatchResult.start(paramInt), paramMatchResult.end(paramInt));
  }
  
  private static final h b(Matcher paramMatcher, int paramInt, CharSequence paramCharSequence)
  {
    if (!paramMatcher.find(paramInt)) {
      return null;
    }
    return (h)new i(paramMatcher, paramCharSequence);
  }
  
  private static final h b(Matcher paramMatcher, CharSequence paramCharSequence)
  {
    if (!paramMatcher.matches()) {
      return null;
    }
    return (h)new i(paramMatcher, paramCharSequence);
  }
  
  public static final class a
    extends d.c.b.i
    implements b<T, Boolean>
  {
    public a(int paramInt)
    {
      super();
    }
    
    public final boolean invoke(T paramT)
    {
      int i = this.$value$inlined;
      paramT = (d)paramT;
      return (i & paramT.getMask()) == paramT.getValue();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\g\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */