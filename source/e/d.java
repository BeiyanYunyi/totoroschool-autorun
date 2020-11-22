package e;

import e.a.c.e;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class d
{
  public static final d a = new a().a().c();
  public static final d b = new a().b().a(Integer.MAX_VALUE, TimeUnit.SECONDS).c();
  @Nullable
  String c;
  private final boolean d;
  private final boolean e;
  private final int f;
  private final int g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  private final int k;
  private final int l;
  private final boolean m;
  private final boolean n;
  private final boolean o;
  
  d(a parama)
  {
    this.d = parama.a;
    this.e = parama.b;
    this.f = parama.c;
    this.g = -1;
    this.h = false;
    this.i = false;
    this.j = false;
    this.k = parama.d;
    this.l = parama.e;
    this.m = parama.f;
    this.n = parama.g;
    this.o = parama.h;
  }
  
  private d(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, @Nullable String paramString)
  {
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramBoolean3;
    this.i = paramBoolean4;
    this.j = paramBoolean5;
    this.k = paramInt3;
    this.l = paramInt4;
    this.m = paramBoolean6;
    this.n = paramBoolean7;
    this.o = paramBoolean8;
    this.c = paramString;
  }
  
  public static d a(s params)
  {
    int i13 = params.a();
    int i7 = 0;
    int i2 = 1;
    Object localObject1 = null;
    boolean bool8 = false;
    boolean bool7 = false;
    int i6 = -1;
    int i5 = -1;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    int i4 = -1;
    int i3 = -1;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool16;
    for (boolean bool2 = false; i7 < i13; bool2 = bool16)
    {
      String str2 = params.a(i7);
      String str1 = params.b(i7);
      if (str2.equalsIgnoreCase("Cache-Control")) {
        if (localObject1 == null) {}
      }
      int i12;
      Object localObject2;
      boolean bool9;
      boolean bool10;
      int i1;
      int i8;
      boolean bool11;
      boolean bool12;
      boolean bool13;
      int i9;
      int i10;
      boolean bool14;
      boolean bool15;
      for (;;)
      {
        i2 = 0;
        break;
        localObject1 = str1;
        break;
        i12 = i2;
        localObject2 = localObject1;
        bool9 = bool8;
        bool10 = bool7;
        i1 = i6;
        i8 = i5;
        bool11 = bool6;
        bool12 = bool5;
        bool13 = bool4;
        i9 = i4;
        i10 = i3;
        bool14 = bool3;
        bool15 = bool1;
        bool16 = bool2;
        if (!str2.equalsIgnoreCase("Pragma")) {
          break label1161;
        }
      }
      int i11 = 0;
      for (;;)
      {
        i12 = i2;
        localObject2 = localObject1;
        bool9 = bool8;
        bool10 = bool7;
        i1 = i6;
        i8 = i5;
        bool11 = bool6;
        bool12 = bool5;
        bool13 = bool4;
        i9 = i4;
        i10 = i3;
        bool14 = bool3;
        bool15 = bool1;
        bool16 = bool2;
        if (i11 >= str1.length()) {
          break;
        }
        i1 = e.a(str1, i11, "=,;");
        str2 = str1.substring(i11, i1).trim();
        if ((i1 != str1.length()) && (str1.charAt(i1) != ',') && (str1.charAt(i1) != ';'))
        {
          i8 = e.a(str1, i1 + 1);
          if ((i8 < str1.length()) && (str1.charAt(i8) == '"'))
          {
            i1 = i8 + 1;
            i8 = e.a(str1, i1, "\"");
            localObject2 = str1.substring(i1, i8);
            i1 = i8 + 1;
          }
          else
          {
            i1 = e.a(str1, i8, ",;");
            localObject2 = str1.substring(i8, i1).trim();
          }
        }
        else
        {
          i1 += 1;
          localObject2 = null;
        }
        if ("no-cache".equalsIgnoreCase(str2))
        {
          bool9 = true;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i12 = i3;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("no-store".equalsIgnoreCase(str2))
        {
          bool10 = true;
          bool9 = bool8;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i12 = i3;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("max-age".equalsIgnoreCase(str2))
        {
          i8 = e.b((String)localObject2, -1);
          bool9 = bool8;
          bool10 = bool7;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i12 = i3;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("s-maxage".equalsIgnoreCase(str2))
        {
          i9 = e.b((String)localObject2, -1);
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i12 = i3;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("private".equalsIgnoreCase(str2))
        {
          bool11 = true;
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i12 = i3;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("public".equalsIgnoreCase(str2))
        {
          bool12 = true;
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool13 = bool4;
          i10 = i4;
          i12 = i3;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("must-revalidate".equalsIgnoreCase(str2))
        {
          bool13 = true;
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          i10 = i4;
          i12 = i3;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("max-stale".equalsIgnoreCase(str2))
        {
          i10 = e.b((String)localObject2, Integer.MAX_VALUE);
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i12 = i3;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("min-fresh".equalsIgnoreCase(str2))
        {
          i12 = e.b((String)localObject2, -1);
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          bool14 = bool3;
          bool15 = bool1;
        }
        else if ("only-if-cached".equalsIgnoreCase(str2))
        {
          bool14 = true;
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i12 = i3;
          bool15 = bool1;
        }
        else if ("no-transform".equalsIgnoreCase(str2))
        {
          bool15 = true;
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i12 = i3;
          bool14 = bool3;
        }
        else
        {
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i12 = i3;
          bool14 = bool3;
          bool15 = bool1;
          if ("immutable".equalsIgnoreCase(str2))
          {
            bool2 = true;
            bool15 = bool1;
            bool14 = bool3;
            i12 = i3;
            i10 = i4;
            bool13 = bool4;
            bool12 = bool5;
            bool11 = bool6;
            i9 = i5;
            i8 = i6;
            bool10 = bool7;
            bool9 = bool8;
          }
        }
        i11 = i1;
        bool8 = bool9;
        bool7 = bool10;
        i6 = i8;
        i5 = i9;
        bool6 = bool11;
        bool5 = bool12;
        bool4 = bool13;
        i4 = i10;
        i3 = i12;
        bool3 = bool14;
        bool1 = bool15;
      }
      label1161:
      i7 += 1;
      i2 = i12;
      localObject1 = localObject2;
      bool8 = bool9;
      bool7 = bool10;
      i6 = i1;
      i5 = i8;
      bool6 = bool11;
      bool5 = bool12;
      bool4 = bool13;
      i4 = i9;
      i3 = i10;
      bool3 = bool14;
      bool1 = bool15;
    }
    if (i2 == 0) {
      localObject1 = null;
    }
    return new d(bool8, bool7, i6, i5, bool6, bool5, bool4, i4, i3, bool3, bool1, bool2, (String)localObject1);
  }
  
  private String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.d) {
      localStringBuilder.append("no-cache, ");
    }
    if (this.e) {
      localStringBuilder.append("no-store, ");
    }
    if (this.f != -1)
    {
      localStringBuilder.append("max-age=");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", ");
    }
    if (this.g != -1)
    {
      localStringBuilder.append("s-maxage=");
      localStringBuilder.append(this.g);
      localStringBuilder.append(", ");
    }
    if (this.h) {
      localStringBuilder.append("private, ");
    }
    if (this.i) {
      localStringBuilder.append("public, ");
    }
    if (this.j) {
      localStringBuilder.append("must-revalidate, ");
    }
    if (this.k != -1)
    {
      localStringBuilder.append("max-stale=");
      localStringBuilder.append(this.k);
      localStringBuilder.append(", ");
    }
    if (this.l != -1)
    {
      localStringBuilder.append("min-fresh=");
      localStringBuilder.append(this.l);
      localStringBuilder.append(", ");
    }
    if (this.m) {
      localStringBuilder.append("only-if-cached, ");
    }
    if (this.n) {
      localStringBuilder.append("no-transform, ");
    }
    if (this.o) {
      localStringBuilder.append("immutable, ");
    }
    if (localStringBuilder.length() == 0) {
      return "";
    }
    localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public boolean d()
  {
    return this.h;
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public boolean f()
  {
    return this.j;
  }
  
  public int g()
  {
    return this.k;
  }
  
  public int h()
  {
    return this.l;
  }
  
  public boolean i()
  {
    return this.m;
  }
  
  public String toString()
  {
    String str = this.c;
    if (str != null) {
      return str;
    }
    str = j();
    this.c = str;
    return str;
  }
  
  public static final class a
  {
    boolean a;
    boolean b;
    int c = -1;
    int d = -1;
    int e = -1;
    boolean f;
    boolean g;
    boolean h;
    
    public a a()
    {
      this.a = true;
      return this;
    }
    
    public a a(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt >= 0)
      {
        long l = paramTimeUnit.toSeconds(paramInt);
        if (l > 2147483647L) {
          paramInt = Integer.MAX_VALUE;
        } else {
          paramInt = (int)l;
        }
        this.d = paramInt;
        return this;
      }
      paramTimeUnit = new StringBuilder();
      paramTimeUnit.append("maxStale < 0: ");
      paramTimeUnit.append(paramInt);
      throw new IllegalArgumentException(paramTimeUnit.toString());
    }
    
    public a b()
    {
      this.f = true;
      return this;
    }
    
    public d c()
    {
      return new d(this);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */