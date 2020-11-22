package e;

import e.a.c;
import e.a.c.d;
import e.a.i.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class l
{
  private static final Pattern a = Pattern.compile("(\\d{2,4})[^\\d]*");
  private static final Pattern b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
  private static final Pattern c = Pattern.compile("(\\d{1,2})[^\\d]*");
  private static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
  private final String e;
  private final String f;
  private final long g;
  private final String h;
  private final String i;
  private final boolean j;
  private final boolean k;
  private final boolean l;
  private final boolean m;
  
  private l(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramLong;
    this.h = paramString3;
    this.i = paramString4;
    this.j = paramBoolean1;
    this.k = paramBoolean2;
    this.m = paramBoolean3;
    this.l = paramBoolean4;
  }
  
  private static int a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    while (paramInt1 < paramInt2)
    {
      int n = paramString.charAt(paramInt1);
      if (((n >= 32) || (n == 9)) && (n < 127) && ((n < 48) || (n > 57)) && ((n < 97) || (n > 122)) && ((n < 65) || (n > 90)) && (n != 58)) {
        n = 0;
      } else {
        n = 1;
      }
      if (n == (paramBoolean ^ true)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  private static long a(String paramString)
  {
    try
    {
      long l1 = Long.parseLong(paramString);
      if (l1 <= 0L) {
        return Long.MIN_VALUE;
      }
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (paramString.matches("-?\\d+"))
      {
        if (paramString.startsWith("-")) {
          return Long.MIN_VALUE;
        }
        return Long.MAX_VALUE;
      }
      throw localNumberFormatException;
    }
  }
  
  private static long a(String paramString, int paramInt1, int paramInt2)
  {
    int i5 = a(paramString, paramInt1, paramInt2, false);
    Matcher localMatcher = d.matcher(paramString);
    int i4 = -1;
    paramInt1 = -1;
    int i1 = -1;
    int n = -1;
    int i3 = -1;
    int i2 = -1;
    while (i5 < paramInt2)
    {
      int i11 = a(paramString, i5 + 1, paramInt2, true);
      localMatcher.region(i5, i11);
      int i9;
      int i10;
      int i6;
      int i7;
      int i8;
      if ((i4 == -1) && (localMatcher.usePattern(d).matches()))
      {
        i5 = Integer.parseInt(localMatcher.group(1));
        i9 = Integer.parseInt(localMatcher.group(2));
        i10 = Integer.parseInt(localMatcher.group(3));
        i6 = paramInt1;
        i7 = i1;
        i8 = n;
      }
      else if ((i1 == -1) && (localMatcher.usePattern(c).matches()))
      {
        i7 = Integer.parseInt(localMatcher.group(1));
        i5 = i4;
        i6 = paramInt1;
        i8 = n;
        i9 = i3;
        i10 = i2;
      }
      else if ((n == -1) && (localMatcher.usePattern(b).matches()))
      {
        String str = localMatcher.group(1).toLowerCase(Locale.US);
        i8 = b.pattern().indexOf(str) / 4;
        i5 = i4;
        i6 = paramInt1;
        i7 = i1;
        i9 = i3;
        i10 = i2;
      }
      else
      {
        i5 = i4;
        i6 = paramInt1;
        i7 = i1;
        i8 = n;
        i9 = i3;
        i10 = i2;
        if (paramInt1 == -1)
        {
          i5 = i4;
          i6 = paramInt1;
          i7 = i1;
          i8 = n;
          i9 = i3;
          i10 = i2;
          if (localMatcher.usePattern(a).matches())
          {
            i6 = Integer.parseInt(localMatcher.group(1));
            i10 = i2;
            i9 = i3;
            i8 = n;
            i7 = i1;
            i5 = i4;
          }
        }
      }
      i11 = a(paramString, i11 + 1, paramInt2, false);
      i4 = i5;
      paramInt1 = i6;
      i1 = i7;
      n = i8;
      i3 = i9;
      i2 = i10;
      i5 = i11;
    }
    paramInt2 = paramInt1;
    if (paramInt1 >= 70)
    {
      paramInt2 = paramInt1;
      if (paramInt1 <= 99) {
        paramInt2 = paramInt1 + 1900;
      }
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 <= 69) {
        paramInt1 = paramInt2 + 2000;
      }
    }
    if (paramInt1 >= 1601)
    {
      if (n != -1)
      {
        if ((i1 >= 1) && (i1 <= 31))
        {
          if ((i4 >= 0) && (i4 <= 23))
          {
            if ((i3 >= 0) && (i3 <= 59))
            {
              if ((i2 >= 0) && (i2 <= 59))
              {
                paramString = new GregorianCalendar(c.g);
                paramString.setLenient(false);
                paramString.set(1, paramInt1);
                paramString.set(2, n - 1);
                paramString.set(5, i1);
                paramString.set(11, i4);
                paramString.set(12, i3);
                paramString.set(13, i2);
                paramString.set(14, 0);
                return paramString.getTimeInMillis();
              }
              throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
          }
          throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
      }
      throw new IllegalArgumentException();
    }
    throw new IllegalArgumentException();
  }
  
  @Nullable
  static l a(long paramLong, t paramt, String paramString)
  {
    int i1 = paramString.length();
    int n = c.a(paramString, 0, i1, ';');
    int i2 = c.a(paramString, 0, n, '=');
    if (i2 == n) {
      return null;
    }
    String str1 = c.c(paramString, 0, i2);
    if ((!str1.isEmpty()) && (c.b(str1) == -1))
    {
      String str2 = c.c(paramString, i2 + 1, n);
      if (c.b(str2) != -1) {
        return null;
      }
      n += 1;
      localObject2 = null;
      localObject1 = localObject2;
      l2 = -1L;
      l1 = 253402300799999L;
      bool3 = false;
      boolean bool4 = false;
      bool2 = true;
      for (bool1 = false; n < i1; bool1 = bool7)
      {
        i2 = c.a(paramString, n, i1, ';');
        int i3 = c.a(paramString, n, i2, '=');
        String str3 = c.c(paramString, n, i3);
        if (i3 < i2) {
          localObject3 = c.c(paramString, i3 + 1, i2);
        } else {
          localObject3 = "";
        }
        if (str3.equalsIgnoreCase("expires")) {}
        for (;;)
        {
          try
          {
            l3 = a((String)localObject3, 0, ((String)localObject3).length());
            l1 = l3;
            bool7 = true;
            localObject3 = localObject2;
            l3 = l2;
            bool5 = bool3;
            bool6 = bool2;
            localObject5 = localObject1;
            l4 = l1;
          }
          catch (IllegalArgumentException|NumberFormatException localIllegalArgumentException)
          {
            Object localObject4 = localObject2;
            long l3 = l2;
            boolean bool5 = bool3;
            boolean bool6 = bool2;
            Object localObject5 = localObject1;
            long l4 = l1;
            boolean bool7 = bool1;
            continue;
          }
          if (str3.equalsIgnoreCase("max-age"))
          {
            l3 = a((String)localObject3);
            l2 = l3;
          }
          else if (str3.equalsIgnoreCase("domain"))
          {
            localObject3 = b((String)localObject3);
            bool6 = false;
            l3 = l2;
            bool5 = bool3;
            localObject5 = localObject1;
            l4 = l1;
            bool7 = bool1;
          }
          else if (str3.equalsIgnoreCase("path"))
          {
            localObject5 = localObject3;
            localObject3 = localObject2;
            l3 = l2;
            bool5 = bool3;
            bool6 = bool2;
            l4 = l1;
            bool7 = bool1;
          }
          else if (str3.equalsIgnoreCase("secure"))
          {
            bool5 = true;
            localObject3 = localObject2;
            l3 = l2;
            bool6 = bool2;
            localObject5 = localObject1;
            l4 = l1;
            bool7 = bool1;
          }
          else
          {
            localObject3 = localObject2;
            l3 = l2;
            bool5 = bool3;
            bool6 = bool2;
            localObject5 = localObject1;
            l4 = l1;
            bool7 = bool1;
            if (str3.equalsIgnoreCase("httponly"))
            {
              bool4 = true;
              bool7 = bool1;
              l4 = l1;
              localObject5 = localObject1;
              bool6 = bool2;
              bool5 = bool3;
              l3 = l2;
              localObject3 = localObject2;
            }
          }
        }
        n = i2 + 1;
        localObject2 = localObject3;
        l2 = l3;
        bool3 = bool5;
        bool2 = bool6;
        localObject1 = localObject5;
        l1 = l4;
      }
      l3 = Long.MIN_VALUE;
      if (l2 == Long.MIN_VALUE) {
        paramLong = l3;
      }
      for (;;)
      {
        break;
        if (l2 != -1L)
        {
          if (l2 <= 9223372036854775L) {
            l1 = l2 * 1000L;
          } else {
            l1 = Long.MAX_VALUE;
          }
          l1 = paramLong + l1;
          if (l1 >= paramLong)
          {
            paramLong = l1;
            if (l1 <= 253402300799999L) {
              break;
            }
          }
          else
          {
            paramLong = 253402300799999L;
          }
        }
        else
        {
          paramLong = l1;
        }
      }
      Object localObject3 = paramt.f();
      if (localObject2 == null)
      {
        paramString = (String)localObject3;
      }
      else
      {
        if (!a((String)localObject3, (String)localObject2)) {
          return null;
        }
        paramString = (String)localObject2;
      }
      if ((((String)localObject3).length() != paramString.length()) && (a.a().a(paramString) == null)) {
        return null;
      }
      if ((localObject1 != null) && (((String)localObject1).startsWith("/")))
      {
        paramt = (t)localObject1;
      }
      else
      {
        paramt = paramt.h();
        n = paramt.lastIndexOf('/');
        if (n != 0) {
          paramt = paramt.substring(0, n);
        } else {
          paramt = "/";
        }
      }
      return new l(str1, str2, paramLong, paramString, paramt, bool3, bool4, bool2, bool1);
    }
    return null;
  }
  
  @Nullable
  public static l a(t paramt, String paramString)
  {
    return a(System.currentTimeMillis(), paramt, paramString);
  }
  
  public static List<l> a(t paramt, s params)
  {
    List localList = params.b("Set-Cookie");
    int i1 = localList.size();
    params = null;
    int n = 0;
    while (n < i1)
    {
      l locall = a(paramt, (String)localList.get(n));
      if (locall != null)
      {
        Object localObject = params;
        if (params == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(locall);
        params = (s)localObject;
      }
      n += 1;
    }
    if (params != null) {
      return Collections.unmodifiableList(params);
    }
    return Collections.emptyList();
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (paramString1.equals(paramString2)) {
      return true;
    }
    return (paramString1.endsWith(paramString2)) && (paramString1.charAt(paramString1.length() - paramString2.length() - 1) == '.') && (!c.c(paramString1));
  }
  
  private static String b(String paramString)
  {
    if (!paramString.endsWith("."))
    {
      String str = paramString;
      if (paramString.startsWith(".")) {
        str = paramString.substring(1);
      }
      paramString = c.a(str);
      if (paramString != null) {
        return paramString;
      }
      throw new IllegalArgumentException();
    }
    throw new IllegalArgumentException();
  }
  
  public String a()
  {
    return this.e;
  }
  
  String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e);
    localStringBuilder.append('=');
    localStringBuilder.append(this.f);
    if (this.l) {
      if (this.g == Long.MIN_VALUE)
      {
        localStringBuilder.append("; max-age=0");
      }
      else
      {
        localStringBuilder.append("; expires=");
        localStringBuilder.append(d.a(new Date(this.g)));
      }
    }
    if (!this.m)
    {
      localStringBuilder.append("; domain=");
      if (paramBoolean) {
        localStringBuilder.append(".");
      }
      localStringBuilder.append(this.h);
    }
    localStringBuilder.append("; path=");
    localStringBuilder.append(this.i);
    if (this.j) {
      localStringBuilder.append("; secure");
    }
    if (this.k) {
      localStringBuilder.append("; httponly");
    }
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    return this.f;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool1 = paramObject instanceof l;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (l)paramObject;
    bool1 = bool2;
    if (((l)paramObject).e.equals(this.e))
    {
      bool1 = bool2;
      if (((l)paramObject).f.equals(this.f))
      {
        bool1 = bool2;
        if (((l)paramObject).h.equals(this.h))
        {
          bool1 = bool2;
          if (((l)paramObject).i.equals(this.i))
          {
            bool1 = bool2;
            if (((l)paramObject).g == this.g)
            {
              bool1 = bool2;
              if (((l)paramObject).j == this.j)
              {
                bool1 = bool2;
                if (((l)paramObject).k == this.k)
                {
                  bool1 = bool2;
                  if (((l)paramObject).l == this.l)
                  {
                    bool1 = bool2;
                    if (((l)paramObject).m == this.m) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return ((((((((527 + this.e.hashCode()) * 31 + this.f.hashCode()) * 31 + this.h.hashCode()) * 31 + this.i.hashCode()) * 31 + (int)(this.g ^ this.g >>> 32)) * 31 + (this.j ^ true)) * 31 + (this.k ^ true)) * 31 + (this.l ^ true)) * 31 + (this.m ^ true);
  }
  
  public String toString()
  {
    return a(false);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */