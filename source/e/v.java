package e;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class v
{
  private static final Pattern a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  private static final Pattern b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  private final String c;
  private final String d;
  private final String e;
  @Nullable
  private final String f;
  
  private v(String paramString1, String paramString2, String paramString3, @Nullable String paramString4)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
  }
  
  public static v a(String paramString)
  {
    Object localObject1 = a.matcher(paramString);
    if (((Matcher)localObject1).lookingAt())
    {
      String str1 = ((Matcher)localObject1).group(1).toLowerCase(Locale.US);
      String str2 = ((Matcher)localObject1).group(2).toLowerCase(Locale.US);
      Object localObject2 = null;
      Matcher localMatcher = b.matcher(paramString);
      int i = ((Matcher)localObject1).end();
      while (i < paramString.length())
      {
        localMatcher.region(i, paramString.length());
        if (localMatcher.lookingAt())
        {
          Object localObject3 = localMatcher.group(1);
          localObject1 = localObject2;
          if (localObject3 != null) {
            if (!((String)localObject3).equalsIgnoreCase("charset"))
            {
              localObject1 = localObject2;
            }
            else
            {
              localObject3 = localMatcher.group(2);
              if (localObject3 != null)
              {
                localObject1 = localObject3;
                if (((String)localObject3).startsWith("'"))
                {
                  localObject1 = localObject3;
                  if (((String)localObject3).endsWith("'"))
                  {
                    localObject1 = localObject3;
                    if (((String)localObject3).length() > 2) {
                      localObject1 = ((String)localObject3).substring(1, ((String)localObject3).length() - 1);
                    }
                  }
                }
              }
              else
              {
                localObject1 = localMatcher.group(3);
              }
              if ((localObject2 != null) && (!((String)localObject1).equalsIgnoreCase((String)localObject2)))
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("Multiple charsets defined: \"");
                ((StringBuilder)localObject3).append((String)localObject2);
                ((StringBuilder)localObject3).append("\" and: \"");
                ((StringBuilder)localObject3).append((String)localObject1);
                ((StringBuilder)localObject3).append("\" for: \"");
                ((StringBuilder)localObject3).append(paramString);
                ((StringBuilder)localObject3).append('"');
                throw new IllegalArgumentException(((StringBuilder)localObject3).toString());
              }
            }
          }
          i = localMatcher.end();
          localObject2 = localObject1;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Parameter is not formatted correctly: \"");
          ((StringBuilder)localObject1).append(paramString.substring(i));
          ((StringBuilder)localObject1).append("\" for: \"");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append('"');
          throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
        }
      }
      return new v(paramString, str1, str2, (String)localObject2);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("No subtype found for: \"");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append('"');
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  @Nullable
  public static v b(String paramString)
  {
    try
    {
      paramString = a(paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public String a()
  {
    return this.d;
  }
  
  @Nullable
  public Charset a(@Nullable Charset paramCharset)
  {
    Charset localCharset = paramCharset;
    try
    {
      if (this.f != null) {
        localCharset = Charset.forName(this.f);
      }
      return localCharset;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return paramCharset;
  }
  
  @Nullable
  public Charset b()
  {
    return a(null);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof v)) && (((v)paramObject).c.equals(this.c));
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public String toString()
  {
    return this.c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */