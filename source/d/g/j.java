package d.g;

import d.c.a.a;
import d.c.b.g;
import d.c.b.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j
  implements Serializable
{
  public static final a Companion = new a(null);
  private Set<? extends l> _options;
  private final Pattern nativePattern;
  
  public j(String paramString)
  {
    this(paramString);
  }
  
  public j(String paramString, l paraml)
  {
    this(paramString);
  }
  
  public j(String paramString, Set<? extends l> paramSet)
  {
    this(paramString);
  }
  
  public j(Pattern paramPattern)
  {
    this.nativePattern = paramPattern;
  }
  
  private final Object writeReplace()
  {
    String str = this.nativePattern.pattern();
    d.c.b.h.a(str, "nativePattern.pattern()");
    return new b(str, this.nativePattern.flags());
  }
  
  public final boolean containsMatchIn(CharSequence paramCharSequence)
  {
    d.c.b.h.b(paramCharSequence, "input");
    return this.nativePattern.matcher(paramCharSequence).find();
  }
  
  public final h find(CharSequence paramCharSequence, int paramInt)
  {
    d.c.b.h.b(paramCharSequence, "input");
    Matcher localMatcher = this.nativePattern.matcher(paramCharSequence);
    d.c.b.h.a(localMatcher, "nativePattern.matcher(input)");
    return k.a(localMatcher, paramInt, paramCharSequence);
  }
  
  public final d.f.b<h> findAll(final CharSequence paramCharSequence, final int paramInt)
  {
    d.c.b.h.b(paramCharSequence, "input");
    return d.f.c.a((a)new c(this, paramCharSequence, paramInt), (d.c.a.b)d.INSTANCE);
  }
  
  public final Set<l> getOptions()
  {
    Object localObject = this._options;
    if (localObject != null) {
      return (Set<l>)localObject;
    }
    int i = this.nativePattern.flags();
    localObject = EnumSet.allOf(l.class);
    d.a.b.a((Iterable)localObject, (d.c.a.b)new k.a(i));
    localObject = Collections.unmodifiableSet((Set)localObject);
    d.c.b.h.a(localObject, "Collections.unmodifiable…mask == it.value }\n    })");
    this._options = ((Set)localObject);
    return (Set<l>)localObject;
  }
  
  public final String getPattern()
  {
    String str = this.nativePattern.pattern();
    d.c.b.h.a(str, "nativePattern.pattern()");
    return str;
  }
  
  public final h matchEntire(CharSequence paramCharSequence)
  {
    d.c.b.h.b(paramCharSequence, "input");
    Matcher localMatcher = this.nativePattern.matcher(paramCharSequence);
    d.c.b.h.a(localMatcher, "nativePattern.matcher(input)");
    return k.a(localMatcher, paramCharSequence);
  }
  
  public final boolean matches(CharSequence paramCharSequence)
  {
    d.c.b.h.b(paramCharSequence, "input");
    return this.nativePattern.matcher(paramCharSequence).matches();
  }
  
  public final String replace(CharSequence paramCharSequence, d.c.a.b<? super h, ? extends CharSequence> paramb)
  {
    d.c.b.h.b(paramCharSequence, "input");
    d.c.b.h.b(paramb, "transform");
    int i = 0;
    Object localObject = find$default(this, paramCharSequence, 0, 2, null);
    if (localObject != null)
    {
      int k = paramCharSequence.length();
      StringBuilder localStringBuilder = new StringBuilder(k);
      int j;
      h localh;
      do
      {
        if (localObject == null) {
          d.c.b.h.a();
        }
        localStringBuilder.append(paramCharSequence, i, ((h)localObject).a().f().intValue());
        localStringBuilder.append((CharSequence)paramb.invoke(localObject));
        j = ((h)localObject).a().g().intValue() + 1;
        localh = ((h)localObject).b();
        if (j >= k) {
          break;
        }
        i = j;
        localObject = localh;
      } while (localh != null);
      if (j < k) {
        localStringBuilder.append(paramCharSequence, j, k);
      }
      paramCharSequence = localStringBuilder.toString();
      d.c.b.h.a(paramCharSequence, "sb.toString()");
      return paramCharSequence;
    }
    return paramCharSequence.toString();
  }
  
  public final String replace(CharSequence paramCharSequence, String paramString)
  {
    d.c.b.h.b(paramCharSequence, "input");
    d.c.b.h.b(paramString, "replacement");
    paramCharSequence = this.nativePattern.matcher(paramCharSequence).replaceAll(paramString);
    d.c.b.h.a(paramCharSequence, "nativePattern.matcher(in…).replaceAll(replacement)");
    return paramCharSequence;
  }
  
  public final String replaceFirst(CharSequence paramCharSequence, String paramString)
  {
    d.c.b.h.b(paramCharSequence, "input");
    d.c.b.h.b(paramString, "replacement");
    paramCharSequence = this.nativePattern.matcher(paramCharSequence).replaceFirst(paramString);
    d.c.b.h.a(paramCharSequence, "nativePattern.matcher(in…replaceFirst(replacement)");
    return paramCharSequence;
  }
  
  public final List<String> split(CharSequence paramCharSequence, int paramInt)
  {
    d.c.b.h.b(paramCharSequence, "input");
    int j = 0;
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Matcher localMatcher = this.nativePattern.matcher(paramCharSequence);
      if ((localMatcher.find()) && (paramInt != 1))
      {
        i = 10;
        if (paramInt > 0) {
          i = d.d.d.d(paramInt, 10);
        }
        ArrayList localArrayList = new ArrayList(i);
        int k = paramInt - 1;
        paramInt = j;
        do
        {
          localArrayList.add(paramCharSequence.subSequence(paramInt, localMatcher.start()).toString());
          i = localMatcher.end();
          if ((k >= 0) && (localArrayList.size() == k)) {
            break;
          }
          paramInt = i;
        } while (localMatcher.find());
        localArrayList.add(paramCharSequence.subSequence(i, paramCharSequence.length()).toString());
        return (List)localArrayList;
      }
      return d.a.b.a(paramCharSequence.toString());
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Limit must be non-negative, but was ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append('.');
    throw ((Throwable)new IllegalArgumentException(paramCharSequence.toString().toString()));
  }
  
  public final Pattern toPattern()
  {
    return this.nativePattern;
  }
  
  public String toString()
  {
    String str = this.nativePattern.toString();
    d.c.b.h.a(str, "nativePattern.toString()");
    return str;
  }
  
  public static final class a
  {
    private final int a(int paramInt)
    {
      int i = paramInt;
      if ((paramInt & 0x2) != 0) {
        i = paramInt | 0x40;
      }
      return i;
    }
  }
  
  private static final class b
    implements Serializable
  {
    public static final a Companion = new a(null);
    private static final long serialVersionUID = 0L;
    private final int flags;
    private final String pattern;
    
    public b(String paramString, int paramInt)
    {
      this.pattern = paramString;
      this.flags = paramInt;
    }
    
    private final Object readResolve()
    {
      Pattern localPattern = Pattern.compile(this.pattern, this.flags);
      d.c.b.h.a(localPattern, "Pattern.compile(pattern, flags)");
      return new j(localPattern);
    }
    
    public final int getFlags()
    {
      return this.flags;
    }
    
    public final String getPattern()
    {
      return this.pattern;
    }
    
    public static final class a {}
  }
  
  static final class c
    extends i
    implements a<h>
  {
    c(j paramj, CharSequence paramCharSequence, int paramInt)
    {
      super();
    }
    
    public final h invoke()
    {
      return this.this$0.find(paramCharSequence, paramInt);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\g\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */