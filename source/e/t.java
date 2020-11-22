package e;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public final class t
{
  private static final char[] d = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  final String a;
  final String b;
  final int c;
  private final String e;
  private final String f;
  private final List<String> g;
  @Nullable
  private final List<String> h;
  @Nullable
  private final String i;
  private final String j;
  
  t(a parama)
  {
    this.a = parama.a;
    this.e = a(parama.b, false);
    this.f = a(parama.c, false);
    this.b = parama.d;
    this.c = parama.a();
    this.g = a(parama.f, false);
    Object localObject1 = parama.g;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = a(parama.g, true);
    } else {
      localObject1 = null;
    }
    this.h = ((List)localObject1);
    localObject1 = localObject2;
    if (parama.h != null) {
      localObject1 = a(parama.h, false);
    }
    this.i = ((String)localObject1);
    this.j = parama.toString();
  }
  
  public static int a(String paramString)
  {
    if (paramString.equals("http")) {
      return 80;
    }
    if (paramString.equals("https")) {
      return 443;
    }
    return -1;
  }
  
  static String a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
  {
    int k = paramInt1;
    while (k < paramInt2)
    {
      int m = paramString1.codePointAt(k);
      if ((m >= 32) && (m != 127) && ((m < 128) || (!paramBoolean4)) && (paramString2.indexOf(m) == -1) && ((m != 37) || ((paramBoolean1) && ((!paramBoolean2) || (a(paramString1, k, paramInt2))))) && ((m != 43) || (!paramBoolean3)))
      {
        k += Character.charCount(m);
      }
      else
      {
        f.c localc = new f.c();
        localc.a(paramString1, paramInt1, k);
        a(localc, paramString1, k, paramInt2, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramCharset);
        return localc.o();
      }
    }
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k = paramInt1;
    while (k < paramInt2)
    {
      int m = paramString.charAt(k);
      if ((m != 37) && ((m != 43) || (!paramBoolean)))
      {
        k += 1;
      }
      else
      {
        f.c localc = new f.c();
        localc.a(paramString, paramInt1, k);
        a(localc, paramString, k, paramInt2, paramBoolean);
        return localc.o();
      }
    }
    return paramString.substring(paramInt1, paramInt2);
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    return a(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, null);
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
  {
    return a(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramCharset);
  }
  
  static String a(String paramString, boolean paramBoolean)
  {
    return a(paramString, 0, paramString.length(), paramBoolean);
  }
  
  private List<String> a(List<String> paramList, boolean paramBoolean)
  {
    int m = paramList.size();
    ArrayList localArrayList = new ArrayList(m);
    int k = 0;
    while (k < m)
    {
      String str = (String)paramList.get(k);
      if (str != null) {
        str = a(str, paramBoolean);
      } else {
        str = null;
      }
      localArrayList.add(str);
      k += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  static void a(f.c paramc, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
  {
    Object localObject3;
    for (Object localObject1 = null; paramInt1 < paramInt2; localObject1 = localObject3)
    {
      int k = paramString1.codePointAt(paramInt1);
      if (paramBoolean1)
      {
        localObject3 = localObject1;
        if (k == 9) {
          break label318;
        }
        localObject3 = localObject1;
        if (k == 10) {
          break label318;
        }
        localObject3 = localObject1;
        if (k == 12) {
          break label318;
        }
        if (k == 13)
        {
          localObject3 = localObject1;
          break label318;
        }
      }
      Object localObject2;
      if ((k == 43) && (paramBoolean3))
      {
        if (paramBoolean1) {
          localObject2 = "+";
        } else {
          localObject2 = "%2B";
        }
        paramc.a((String)localObject2);
        localObject3 = localObject1;
      }
      else if ((k >= 32) && (k != 127) && ((k < 128) || (!paramBoolean4)) && (paramString2.indexOf(k) == -1) && ((k != 37) || ((paramBoolean1) && ((!paramBoolean2) || (a(paramString1, paramInt1, paramInt2))))))
      {
        paramc.a(k);
        localObject3 = localObject1;
      }
      else
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new f.c();
        }
        if ((paramCharset != null) && (!paramCharset.equals(e.a.c.e))) {
          ((f.c)localObject2).a(paramString1, paramInt1, Character.charCount(k) + paramInt1, paramCharset);
        } else {
          ((f.c)localObject2).a(k);
        }
        for (;;)
        {
          localObject3 = localObject2;
          if (((f.c)localObject2).e()) {
            break;
          }
          int m = ((f.c)localObject2).h() & 0xFF;
          paramc.b(37);
          paramc.b(d[(m >> 4 & 0xF)]);
          paramc.b(d[(m & 0xF)]);
        }
      }
      label318:
      paramInt1 += Character.charCount(k);
    }
  }
  
  static void a(f.c paramc, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    while (paramInt1 < paramInt2)
    {
      int m = paramString.codePointAt(paramInt1);
      if (m == 37)
      {
        int k = paramInt1 + 2;
        if (k < paramInt2)
        {
          int n = e.a.c.a(paramString.charAt(paramInt1 + 1));
          int i1 = e.a.c.a(paramString.charAt(k));
          if ((n == -1) || (i1 == -1)) {
            break label105;
          }
          paramc.b((n << 4) + i1);
          paramInt1 = k;
          break label112;
        }
      }
      if ((m == 43) && (paramBoolean)) {
        paramc.b(32);
      } else {
        label105:
        paramc.a(m);
      }
      label112:
      paramInt1 += Character.charCount(m);
    }
  }
  
  static void a(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int m = paramList.size();
    int k = 0;
    while (k < m)
    {
      paramStringBuilder.append('/');
      paramStringBuilder.append((String)paramList.get(k));
      k += 1;
    }
  }
  
  static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    int k = paramInt1 + 2;
    return (k < paramInt2) && (paramString.charAt(paramInt1) == '%') && (e.a.c.a(paramString.charAt(paramInt1 + 1)) != -1) && (e.a.c.a(paramString.charAt(k)) != -1);
  }
  
  static List<String> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int m;
    for (int k = 0; k <= paramString.length(); k = m + 1)
    {
      int n = paramString.indexOf('&', k);
      m = n;
      if (n == -1) {
        m = paramString.length();
      }
      n = paramString.indexOf('=', k);
      if ((n != -1) && (n <= m))
      {
        localArrayList.add(paramString.substring(k, n));
        localArrayList.add(paramString.substring(n + 1, m));
      }
      else
      {
        localArrayList.add(paramString.substring(k, m));
        localArrayList.add(null);
      }
    }
    return localArrayList;
  }
  
  static void b(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int m = paramList.size();
    int k = 0;
    while (k < m)
    {
      String str1 = (String)paramList.get(k);
      String str2 = (String)paramList.get(k + 1);
      if (k > 0) {
        paramStringBuilder.append('&');
      }
      paramStringBuilder.append(str1);
      if (str2 != null)
      {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      }
      k += 2;
    }
  }
  
  public static t e(String paramString)
  {
    return new a().a(null, paramString).c();
  }
  
  public URI a()
  {
    Object localObject = o().b().toString();
    try
    {
      URI localURI = new URI((String)localObject);
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException) {}
    try
    {
      localObject = URI.create(((String)localObject).replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
      return (URI)localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    throw new RuntimeException(localURISyntaxException);
  }
  
  public String b()
  {
    return this.a;
  }
  
  @Nullable
  public t c(String paramString)
  {
    paramString = d(paramString);
    if (paramString != null) {
      return paramString.c();
    }
    return null;
  }
  
  public boolean c()
  {
    return this.a.equals("https");
  }
  
  @Nullable
  public a d(String paramString)
  {
    try
    {
      paramString = new a().a(this, paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public String d()
  {
    if (this.e.isEmpty()) {
      return "";
    }
    int k = this.a.length() + 3;
    int m = e.a.c.a(this.j, k, this.j.length(), ":@");
    return this.j.substring(k, m);
  }
  
  public String e()
  {
    if (this.f.isEmpty()) {
      return "";
    }
    int k = this.j.indexOf(':', this.a.length() + 3);
    int m = this.j.indexOf('@');
    return this.j.substring(k + 1, m);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof t)) && (((t)paramObject).j.equals(this.j));
  }
  
  public String f()
  {
    return this.b;
  }
  
  public int g()
  {
    return this.c;
  }
  
  public String h()
  {
    int k = this.j.indexOf('/', this.a.length() + 3);
    int m = e.a.c.a(this.j, k, this.j.length(), "?#");
    return this.j.substring(k, m);
  }
  
  public int hashCode()
  {
    return this.j.hashCode();
  }
  
  public List<String> i()
  {
    int k = this.j.indexOf('/', this.a.length() + 3);
    int m = e.a.c.a(this.j, k, this.j.length(), "?#");
    ArrayList localArrayList = new ArrayList();
    while (k < m)
    {
      int n = k + 1;
      k = e.a.c.a(this.j, n, m, '/');
      localArrayList.add(this.j.substring(n, k));
    }
    return localArrayList;
  }
  
  public List<String> j()
  {
    return this.g;
  }
  
  @Nullable
  public String k()
  {
    if (this.h == null) {
      return null;
    }
    int k = this.j.indexOf('?') + 1;
    int m = e.a.c.a(this.j, k, this.j.length(), '#');
    return this.j.substring(k, m);
  }
  
  @Nullable
  public String l()
  {
    if (this.h == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder, this.h);
    return localStringBuilder.toString();
  }
  
  @Nullable
  public String m()
  {
    if (this.i == null) {
      return null;
    }
    int k = this.j.indexOf('#');
    return this.j.substring(k + 1);
  }
  
  public String n()
  {
    return d("/...").b("").c("").c().toString();
  }
  
  public a o()
  {
    a locala = new a();
    locala.a = this.a;
    locala.b = d();
    locala.c = e();
    locala.d = this.b;
    int k;
    if (this.c != a(this.a)) {
      k = this.c;
    } else {
      k = -1;
    }
    locala.e = k;
    locala.f.clear();
    locala.f.addAll(i());
    locala.e(k());
    locala.h = m();
    return locala;
  }
  
  public String toString()
  {
    return this.j;
  }
  
  public static final class a
  {
    @Nullable
    String a;
    String b = "";
    String c = "";
    @Nullable
    String d;
    int e = -1;
    final List<String> f = new ArrayList();
    @Nullable
    List<String> g;
    @Nullable
    String h;
    
    public a()
    {
      this.f.add("");
    }
    
    private void a(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt1 == paramInt2) {
        return;
      }
      int i = paramString.charAt(paramInt1);
      if ((i != 47) && (i != 92))
      {
        this.f.set(this.f.size() - 1, "");
      }
      else
      {
        this.f.clear();
        this.f.add("");
        paramInt1 += 1;
      }
      while (paramInt1 < paramInt2)
      {
        i = e.a.c.a(paramString, paramInt1, paramInt2, "/\\");
        boolean bool;
        if (i < paramInt2) {
          bool = true;
        } else {
          bool = false;
        }
        a(paramString, paramInt1, i, bool, true);
        paramInt1 = i;
        if (bool) {
          paramInt1 = i + 1;
        }
      }
    }
    
    private void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      paramString = t.a(paramString, paramInt1, paramInt2, " \"<>^`{}|/\\?#", paramBoolean2, false, false, true, null);
      if (f(paramString)) {
        return;
      }
      if (g(paramString))
      {
        d();
        return;
      }
      if (((String)this.f.get(this.f.size() - 1)).isEmpty()) {
        this.f.set(this.f.size() - 1, paramString);
      } else {
        this.f.add(paramString);
      }
      if (paramBoolean1) {
        this.f.add("");
      }
    }
    
    private static int b(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt2 - paramInt1 < 2) {
        return -1;
      }
      int j = paramString.charAt(paramInt1);
      int i;
      if (j >= 97)
      {
        i = paramInt1;
        if (j <= 122) {}
      }
      else
      {
        if (j < 65) {
          break label157;
        }
        i = paramInt1;
        if (j > 90) {
          return -1;
        }
      }
      for (;;)
      {
        paramInt1 = i + 1;
        if (paramInt1 >= paramInt2) {
          break label155;
        }
        j = paramString.charAt(paramInt1);
        if (j >= 97)
        {
          i = paramInt1;
          if (j <= 122) {}
        }
        else if (j >= 65)
        {
          i = paramInt1;
          if (j <= 90) {}
        }
        else if (j >= 48)
        {
          i = paramInt1;
          if (j <= 57) {}
        }
        else
        {
          i = paramInt1;
          if (j != 43)
          {
            i = paramInt1;
            if (j != 45)
            {
              if (j != 46) {
                break;
              }
              i = paramInt1;
            }
          }
        }
      }
      if (j == 58) {
        return paramInt1;
      }
      return -1;
      label155:
      return -1;
      label157:
      return -1;
    }
    
    private static int c(String paramString, int paramInt1, int paramInt2)
    {
      int i = 0;
      while (paramInt1 < paramInt2)
      {
        int j = paramString.charAt(paramInt1);
        if ((j != 92) && (j != 47)) {
          break;
        }
        i += 1;
        paramInt1 += 1;
      }
      return i;
    }
    
    private static int d(String paramString, int paramInt1, int paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        int j = paramString.charAt(paramInt1);
        if (j != 58)
        {
          int i = paramInt1;
          if (j != 91)
          {
            i = paramInt1;
          }
          else
          {
            do
            {
              paramInt1 = i + 1;
              i = paramInt1;
              if (paramInt1 >= paramInt2) {
                break;
              }
              i = paramInt1;
            } while (paramString.charAt(paramInt1) != ']');
            i = paramInt1;
          }
          paramInt1 = i + 1;
        }
        else
        {
          return paramInt1;
        }
      }
      return paramInt2;
    }
    
    private void d()
    {
      if ((((String)this.f.remove(this.f.size() - 1)).isEmpty()) && (!this.f.isEmpty()))
      {
        this.f.set(this.f.size() - 1, "");
        return;
      }
      this.f.add("");
    }
    
    private static String e(String paramString, int paramInt1, int paramInt2)
    {
      return e.a.c.a(t.a(paramString, paramInt1, paramInt2, false));
    }
    
    private static int f(String paramString, int paramInt1, int paramInt2)
    {
      try
      {
        paramInt1 = Integer.parseInt(t.a(paramString, paramInt1, paramInt2, "", false, false, false, true, null));
        if ((paramInt1 > 0) && (paramInt1 <= 65535)) {
          return paramInt1;
        }
        return -1;
      }
      catch (NumberFormatException paramString) {}
      return -1;
    }
    
    private boolean f(String paramString)
    {
      return (paramString.equals(".")) || (paramString.equalsIgnoreCase("%2e"));
    }
    
    private boolean g(String paramString)
    {
      return (paramString.equals("..")) || (paramString.equalsIgnoreCase("%2e.")) || (paramString.equalsIgnoreCase(".%2e")) || (paramString.equalsIgnoreCase("%2e%2e"));
    }
    
    int a()
    {
      if (this.e != -1) {
        return this.e;
      }
      return t.a(this.a);
    }
    
    public a a(int paramInt)
    {
      if ((paramInt > 0) && (paramInt <= 65535))
      {
        this.e = paramInt;
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unexpected port: ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    a a(@Nullable t paramt, String paramString)
    {
      int i = e.a.c.a(paramString, 0, paramString.length());
      int i1 = e.a.c.b(paramString, i, paramString.length());
      int j = b(paramString, i, i1);
      if (j != -1)
      {
        if (paramString.regionMatches(true, i, "https:", 0, 6))
        {
          this.a = "https";
          i += "https:".length();
        }
        else if (paramString.regionMatches(true, i, "http:", 0, 5))
        {
          this.a = "http";
          i += "http:".length();
        }
        else
        {
          paramt = new StringBuilder();
          paramt.append("Expected URL scheme 'http' or 'https' but was '");
          paramt.append(paramString.substring(0, j));
          paramt.append("'");
          throw new IllegalArgumentException(paramt.toString());
        }
      }
      else
      {
        if (paramt == null) {
          break label860;
        }
        this.a = paramt.a;
      }
      j = c(paramString, i, i1);
      int m;
      if ((j < 2) && (paramt != null) && (paramt.a.equals(this.a)))
      {
        this.b = paramt.d();
        this.c = paramt.e();
        this.d = paramt.b;
        this.e = paramt.c;
        this.f.clear();
        this.f.addAll(paramt.i());
        if (i != i1)
        {
          j = i;
          if (paramString.charAt(i) != '#') {}
        }
        else
        {
          e(paramt.k());
          j = i;
        }
      }
      else
      {
        m = i + j;
        i = 0;
        j = 0;
        for (;;)
        {
          k = e.a.c.a(paramString, m, i1, "@/\\?#");
          int n;
          if (k != i1) {
            n = paramString.charAt(k);
          } else {
            n = -1;
          }
          if ((n == -1) || (n == 35) || (n == 47) || (n == 92)) {
            break;
          }
          switch (n)
          {
          default: 
            break;
          case 64: 
            if (i == 0)
            {
              int i2 = e.a.c.a(paramString, m, k, ':');
              n = k;
              String str = t.a(paramString, m, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
              paramt = str;
              if (j != 0)
              {
                paramt = new StringBuilder();
                paramt.append(this.b);
                paramt.append("%40");
                paramt.append(str);
                paramt = paramt.toString();
              }
              this.b = paramt;
              if (i2 != n)
              {
                this.c = t.a(paramString, i2 + 1, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                i = 1;
              }
              j = 1;
            }
            else
            {
              paramt = new StringBuilder();
              paramt.append(this.c);
              paramt.append("%40");
              paramt.append(t.a(paramString, m, k, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
              this.c = paramt.toString();
            }
            m = k + 1;
          }
        }
        i = d(paramString, m, k);
        j = i + 1;
        if (j < k)
        {
          this.d = e(paramString, m, i);
          this.e = f(paramString, j, k);
          if (this.e == -1)
          {
            paramt = new StringBuilder();
            paramt.append("Invalid URL port: \"");
            paramt.append(paramString.substring(j, k));
            paramt.append('"');
            throw new IllegalArgumentException(paramt.toString());
          }
        }
        else
        {
          this.d = e(paramString, m, i);
          this.e = t.a(this.a);
        }
        if (this.d == null) {
          break label814;
        }
        j = k;
      }
      int k = e.a.c.a(paramString, j, i1, "?#");
      a(paramString, j, k);
      i = k;
      if (k < i1)
      {
        i = k;
        if (paramString.charAt(k) == '?')
        {
          i = e.a.c.a(paramString, k, i1, '#');
          this.g = t.b(t.a(paramString, k + 1, i, " \"'<>#", true, false, true, true, null));
        }
      }
      if ((i < i1) && (paramString.charAt(i) == '#')) {
        this.h = t.a(paramString, 1 + i, i1, "", true, false, false, false, null);
      }
      return this;
      label814:
      paramt = new StringBuilder();
      paramt.append("Invalid URL host: \"");
      paramt.append(paramString.substring(m, i));
      paramt.append('"');
      throw new IllegalArgumentException(paramt.toString());
      label860:
      throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
    }
    
    public a a(String paramString)
    {
      if (paramString != null)
      {
        if (paramString.equalsIgnoreCase("http"))
        {
          this.a = "http";
          return this;
        }
        if (paramString.equalsIgnoreCase("https"))
        {
          this.a = "https";
          return this;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unexpected scheme: ");
        localStringBuilder.append(paramString);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      throw new NullPointerException("scheme == null");
    }
    
    public a a(String paramString1, @Nullable String paramString2)
    {
      if (paramString1 != null)
      {
        if (this.g == null) {
          this.g = new ArrayList();
        }
        this.g.add(t.a(paramString1, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
        List localList = this.g;
        if (paramString2 != null) {
          paramString1 = t.a(paramString2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true);
        } else {
          paramString1 = null;
        }
        localList.add(paramString1);
        return this;
      }
      throw new NullPointerException("name == null");
    }
    
    a b()
    {
      int k = this.f.size();
      int j = 0;
      int i = 0;
      String str;
      while (i < k)
      {
        str = (String)this.f.get(i);
        this.f.set(i, t.a(str, "[]", true, true, false, true));
        i += 1;
      }
      if (this.g != null)
      {
        k = this.g.size();
        i = j;
        while (i < k)
        {
          str = (String)this.g.get(i);
          if (str != null) {
            this.g.set(i, t.a(str, "\\^`{|}", true, true, true, true));
          }
          i += 1;
        }
      }
      if (this.h != null) {
        this.h = t.a(this.h, " \"#<>\\^`{|}", true, true, false, false);
      }
      return this;
    }
    
    public a b(String paramString)
    {
      if (paramString != null)
      {
        this.b = t.a(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return this;
      }
      throw new NullPointerException("username == null");
    }
    
    public a b(String paramString1, @Nullable String paramString2)
    {
      if (paramString1 != null)
      {
        if (this.g == null) {
          this.g = new ArrayList();
        }
        this.g.add(t.a(paramString1, " \"'<>#&=", true, false, true, true));
        List localList = this.g;
        if (paramString2 != null) {
          paramString1 = t.a(paramString2, " \"'<>#&=", true, false, true, true);
        } else {
          paramString1 = null;
        }
        localList.add(paramString1);
        return this;
      }
      throw new NullPointerException("encodedName == null");
    }
    
    public a c(String paramString)
    {
      if (paramString != null)
      {
        this.c = t.a(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return this;
      }
      throw new NullPointerException("password == null");
    }
    
    public t c()
    {
      if (this.a != null)
      {
        if (this.d != null) {
          return new t(this);
        }
        throw new IllegalStateException("host == null");
      }
      throw new IllegalStateException("scheme == null");
    }
    
    public a d(String paramString)
    {
      if (paramString != null)
      {
        Object localObject = e(paramString, 0, paramString.length());
        if (localObject != null)
        {
          this.d = ((String)localObject);
          return this;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unexpected host: ");
        ((StringBuilder)localObject).append(paramString);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      throw new NullPointerException("host == null");
    }
    
    public a e(@Nullable String paramString)
    {
      if (paramString != null) {
        paramString = t.b(t.a(paramString, " \"'<>#", true, false, true, true));
      } else {
        paramString = null;
      }
      this.g = paramString;
      return this;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.a != null)
      {
        localStringBuilder.append(this.a);
        localStringBuilder.append("://");
      }
      else
      {
        localStringBuilder.append("//");
      }
      if ((!this.b.isEmpty()) || (!this.c.isEmpty()))
      {
        localStringBuilder.append(this.b);
        if (!this.c.isEmpty())
        {
          localStringBuilder.append(':');
          localStringBuilder.append(this.c);
        }
        localStringBuilder.append('@');
      }
      if (this.d != null) {
        if (this.d.indexOf(':') != -1)
        {
          localStringBuilder.append('[');
          localStringBuilder.append(this.d);
          localStringBuilder.append(']');
        }
        else
        {
          localStringBuilder.append(this.d);
        }
      }
      if ((this.e != -1) || (this.a != null))
      {
        int i = a();
        if ((this.a == null) || (i != t.a(this.a)))
        {
          localStringBuilder.append(':');
          localStringBuilder.append(i);
        }
      }
      t.a(localStringBuilder, this.f);
      if (this.g != null)
      {
        localStringBuilder.append('?');
        t.b(localStringBuilder, this.g);
      }
      if (this.h != null)
      {
        localStringBuilder.append('#');
        localStringBuilder.append(this.h);
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */