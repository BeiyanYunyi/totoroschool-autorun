package c.a.b;

import c.a.ao;
import java.io.IOException;
import java.io.Reader;

class bn
{
  private static final char[] a = a("\b\000\003\025\025\000\001\025\001\024\001\021\001\026\001\b\002\000\001\022\001\005\001\006\001!\001\037\001\004\001 \001\007\001\033\001\034\t\002\001\003\001\000\001$\001#\001\"\001\036\001\000\001\016\002\001\001\030\001\f\001\r\002\001\001\031\002\001\001\017\001\035\001\027\003\001\001\n\001\020\001\t\001\013\001\032\004\001\004\000\001\023\001\000\032\001ﾅ\000");
  private static final int[] b = d();
  private static final int[] c = e();
  private static final int[] d = f();
  private static final String[] e = { "Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large" };
  private static final int[] f = g();
  private Reader g;
  private int h;
  private int i = 0;
  private char[] j = new char['䀀'];
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private boolean r = true;
  private boolean s;
  private boolean t;
  private t u;
  private ao v;
  
  bn(Reader paramReader)
  {
    this.g = paramReader;
  }
  
  private static int a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    int i3 = paramString.length();
    int i1 = 0;
    if (i1 < i3)
    {
      int i4 = i1 + 1;
      i1 = paramString.charAt(i1);
      int i5 = paramString.charAt(i4);
      for (int i2 = paramInt;; i2 = paramInt)
      {
        paramInt = i2 + 1;
        paramArrayOfInt[i2] = i5;
        i1 -= 1;
        if (i1 <= 0)
        {
          i1 = i4 + 1;
          break;
        }
      }
    }
    return paramInt;
  }
  
  private static char[] a(String paramString)
  {
    char[] arrayOfChar = new char[65536];
    int i3 = 0;
    int i2 = 0;
    if (i3 < 100)
    {
      int i5 = i3 + 1;
      i3 = paramString.charAt(i3);
      int i1 = paramString.charAt(i5);
      for (int i4 = i2;; i4 = i2)
      {
        i2 = i4 + 1;
        arrayOfChar[i4] = i1;
        i3 -= 1;
        if (i3 <= 0)
        {
          i3 = i5 + 1;
          break;
        }
      }
    }
    return arrayOfChar;
  }
  
  private static int b(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    int i3 = paramString.length();
    int i2 = 0;
    int i1 = paramInt;
    for (paramInt = i2; paramInt < i3; paramInt = i2 + 1)
    {
      i2 = paramInt + 1;
      paramArrayOfInt[i1] = (paramString.charAt(paramInt) << '\020' | paramString.charAt(i2));
      i1 += 1;
    }
    return i1;
  }
  
  private void b(int paramInt)
  {
    try
    {
      str = e[paramInt];
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      String str;
      for (;;) {}
    }
    str = e[0];
    throw new Error(str);
  }
  
  private static int c(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    int i3 = paramString.length();
    int i1 = 0;
    if (i1 < i3)
    {
      int i4 = i1 + 1;
      i1 = paramString.charAt(i1);
      int i5 = paramString.charAt(i4);
      for (int i2 = paramInt;; i2 = paramInt)
      {
        paramInt = i2 + 1;
        paramArrayOfInt[i2] = (i5 - 1);
        i1 -= 1;
        if (i1 <= 0)
        {
          i1 = i4 + 1;
          break;
        }
      }
    }
    return paramInt;
  }
  
  private static int d(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    int i3 = paramString.length();
    int i1 = 0;
    if (i1 < i3)
    {
      int i4 = i1 + 1;
      i1 = paramString.charAt(i1);
      int i5 = paramString.charAt(i4);
      for (int i2 = paramInt;; i2 = paramInt)
      {
        paramInt = i2 + 1;
        paramArrayOfInt[i2] = i5;
        i1 -= 1;
        if (i1 <= 0)
        {
          i1 = i4 + 1;
          break;
        }
      }
    }
    return paramInt;
  }
  
  private static int[] d()
  {
    int[] arrayOfInt = new int[94];
    a("\001\000\001\001\001\002\001\003\001\004\001\005\001\006\001\007\001\000\002\002\001\b\001\000\001\t\001\000\001\n\001\013\001\f\001\r\001\016\001\017\001\020\001\001\001\021\001\002\001\022\001\000\001\023\001\000\001\002\003\000\002\002\005\000\001\024\001\025\001\026\001\002\001\000\001\027\001\000\001\022\002\000\001\030\001\000\002\002\b\000\001\027\001\000\001\031\001\000\001\032\b\000\001\033\002\000\001\031\002\000\001\034\004\000\001\035\003\000\001\035\001\000\001\036\001\000", 0, arrayOfInt);
    return arrayOfInt;
  }
  
  private static int[] e()
  {
    int[] arrayOfInt = new int[94];
    b("\000\000\000%\000J\000o\000\000\000\000\000¹\000Þ\000ă\000\000Ĩ\000\000ō\000\000\000\000\000Ų\000\000Ɨ\000Ƽ\000\000ǡ\000Ȇ\000ȫ\000\000ɐ\000ɵ\000ʚ\000ʿ\000ˤ\000̉\000̮\000͓\000͸\000Ν\000ς\000ϧ\000\000\000\000Ќ\000б\000і\000ѻ\000Ҡ\000Ӆ\000Ӫ\000ʿ\000ԏ\000Դ\000ՙ\000վ\000֣\000׈\000׭\000ؒ\000ط\000ٜ\000ځ\000\000ڦ\000ۋ\000ۋ\000Ќ\000۰\000ܕ\000ܺ\000ݟ\000ބ\000ީ\000ߎ\000߳\000࠘\000࠘\000࠽\000ࡢ\000ࢇ\000ࢬ\000\000࣑\000ࣶ\000छ\000ी\000॥\000ঊ\000য\000৔\000\000৹\000ਞ\000ਞ", 0, arrayOfInt);
    return arrayOfInt;
  }
  
  private static int[] f()
  {
    int[] arrayOfInt = new int['੃'];
    c("\001\000\001\003\001\004\001\005\001\006\001\007\001\b\001\000\001\t\001\n\003\003\001\013\003\003\001\f\001\r\002\000\001\016\001\017\004\003\001\020\001\004\001\003\001\000\001\021\001\022\001\023\001\024\001\025\001\026\021\027\001\030\023\027\001\000\001\031\001\032\001\033\001\000\001\034\002\000\001\035\b\031\002\000\001\036\001\037\002\000\004\031\001\000\001\032\001\031\t\000\001\004\004\000\001 \024\000\001\004.\000\001!\007\000\b!\006\000\004!\002\000\001!\b\000\001\031\001\032\001\033\001\000\001\034\002\000\001\035\001\031\001\"\006\031\002\000\001\036\001\037\002\000\004\031\001\000\001\032\001\031\b\000\001\031\001\032\001\033\001\000\001\034\002\000\001\035\005\031\001#\002\031\002\000\001\036\001\037\002\000\004\031\001\000\001\032\001\031\007\000\022\r\001$\022\r\n\000\001%\f\000\001&\001'\001\000\001(-\000\001)#\000\001*\001+\001\000\021\027\001\000\023\027\001\000\001,\001\032\001\033\001\000\001\034\002\000\001\035\b,\002\000\001\036\001\037\002\000\004,\001\000\001\032\001,\b\000\001\036\001\032\001-\005\000\b\036\002\000\001\036\003\000\004\036\001\000\001\032\001\036\b\000\001.\006\000\001/\b.\006\000\004.\002\000\001.\t\000\0010\031\000\0010\t\000\002\036\006\000\b\036\002\000\001\036\003\000\004\036\001\000\002\036\b\000\0011\006\000\0012\b1\006\000\0041\002\000\0011\t\000\0013\031\000\0013\t\000\0014\0010\001\033\004\000\001\035\b4\006\000\0044\001\000\0010\0014\b\000\001,\001\032\001\033\001\000\001\034\002\000\001\035\002,\0015\005,\002\000\001\036\001\037\002\000\004,\001\000\001\032\001,\b\000\001,\001\032\001\033\001\000\001\034\002\000\001\035\006,\0016\001,\002\000\001\036\001\037\002\000\004,\001\000\001\032\001,\033\000\0017\034\000\0018#\000\0019\002\000\001:/\000\001;\031\000\001<\027\000\001,\001\036\002\000\001\034\003\000\b,\002\000\001\036\001\037\002\000\004,\001\000\001\036\001,\b\000\001=\006\000\001>\b=\006\000\004=\002\000\001=\b\000\001?\007\000\b?\006\000\004?\002\000\001?\b\000\001.\007\000\b.\006\000\004.\002\000\001.\t\000\0010\001-\030\000\0010\t\000\001@\001A\005\000\001B\b@\006\000\004@\001\000\001A\001@\b\000\0011\007\000\b1\006\000\0041\002\000\0011\t\000\0010\001\033\004\000\001\035\023\000\0010\t\000\001,\001\036\002\000\001\034\003\000\003,\001C\004,\002\000\001\036\001\037\002\000\004,\001\000\001\036\001,\b\000\001,\001\036\002\000\001\034\003\000\007,\0015\002\000\001\036\001\037\002\000\004,\001\000\001\036\001,\b\000\001D\006\000\001E\bD\006\000\004D\002\000\001D\024\000\001F&\000\001G\r\000\001F$\000\001H!\000\001I\031\000\001J\026\000\001K\001L\005\000\001M\bK\006\000\004K\001\000\001L\001K\b\000\001=\007\000\b=\006\000\004=\002\000\001=\t\000\001A\005\000\001B\023\000\001A\n\000\001A\031\000\001A\t\000\001N\001O\001P\004\000\001Q\bN\006\000\004N\001\000\001O\001N\b\000\001D\007\000\bD\006\000\004D\002\000\001D\033\000\001R\037\000\001F!\000\001S3\000\001T\024\000\001U\033\000\001L\005\000\001M\023\000\001L\n\000\001L\031\000\001L\n\000\001O\001P\004\000\001Q\023\000\001O\n\000\001O\001V\030\000\001O\t\000\001W\006\000\001X\bW\006\000\004W\002\000\001W\t\000\001O\031\000\001O&\000\001R\"\000\001F\024\000\001F\031\000\001Y\006\000\001Z\bY\006\000\004Y\002\000\001Y\b\000\001[\007\000\b[\006\000\004[\002\000\001[\b\000\001W\007\000\bW\006\000\004W\002\000\001W\b\000\001\\\001]\005\000\001^\b\\\006\000\004\\\001\000\001]\001\\\b\000\001Y\007\000\bY\006\000\004Y\002\000\001Y\t\000\001]\005\000\001^\023\000\001]\n\000\001]\031\000\001]\b\000", 0, arrayOfInt);
    return arrayOfInt;
  }
  
  private static int[] g()
  {
    int[] arrayOfInt = new int[94];
    d("\001\000\003\001\004\t\001\000\002\001\001\t\001\000\001\t\001\000\004\t\001\001\001\t\002\001\001\t\002\001\001\000\001\t\001\000\001\001\003\000\002\001\005\000\003\t\001\001\001\000\001\001\001\000\001\001\002\000\001\001\001\000\002\001\b\000\001\t\001\000\001\001\001\000\001\001\b\000\001\001\002\000\001\001\002\000\001\t\004\000\001\001\003\000\001\t\001\000\001\001\001\000", 0, arrayOfInt);
    return arrayOfInt;
  }
  
  private boolean h()
    throws IOException
  {
    if (this.n > 0)
    {
      System.arraycopy(this.j, this.n, this.j, 0, this.o - this.n);
      this.o -= this.n;
      this.m -= this.n;
      this.k -= this.n;
      this.l -= this.n;
      this.n = 0;
    }
    if (this.m >= this.j.length)
    {
      char[] arrayOfChar = new char[this.m * 2];
      System.arraycopy(this.j, 0, arrayOfChar, 0, this.j.length);
      this.j = arrayOfChar;
    }
    int i1 = this.g.read(this.j, this.o, this.j.length - this.o);
    if (i1 < 0) {
      return true;
    }
    this.o += i1;
    return false;
  }
  
  int a()
  {
    return this.q;
  }
  
  public final void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  void a(ao paramao)
  {
    this.v = paramao;
  }
  
  void a(t paramt)
  {
    this.u = paramt;
  }
  
  public final String b()
  {
    return new String(this.j, this.n, this.k - this.n);
  }
  
  public as c()
    throws IOException, v
  {
    int i1 = this.o;
    Object localObject1 = this.j;
    char[] arrayOfChar = a;
    int[] arrayOfInt1 = d;
    int[] arrayOfInt2 = c;
    int[] arrayOfInt3 = f;
    int i2 = this.k;
    this.q += i2 - this.n;
    int i4 = this.n;
    for (int i6 = 0; i4 < i2; i6 = i3)
    {
      i3 = localObject1[i4];
      if (i3 != 133) {
        switch (i3)
        {
        default: 
          switch (i3)
          {
          }
          break;
        }
      }
      for (;;)
      {
        i3 = 0;
        break;
        this.p += 1;
        i3 = 1;
        break;
        if (i6 == 0)
        {
          this.p += 1;
          i3 = i6;
          break;
          this.p += 1;
        }
      }
      i4 += 1;
    }
    int i5 = i1;
    Object localObject2 = localObject1;
    int i3 = i2;
    boolean bool;
    if (i6 != 0)
    {
      if (i2 < i1)
      {
        if (localObject1[i2] == '\n') {
          i3 = 1;
        } else {
          i3 = 0;
        }
        i4 = i3;
        i3 = i2;
      }
      else
      {
        if (this.s) {}
        do
        {
          for (;;)
          {
            i4 = 0;
            i3 = i2;
            break label333;
            bool = h();
            i4 = this.o;
            i3 = this.k;
            localObject2 = this.j;
            if (!bool) {
              break;
            }
            i1 = i4;
            i2 = i3;
            localObject1 = localObject2;
          }
          i1 = i4;
          i2 = i3;
          localObject1 = localObject2;
        } while (localObject2[i3] != '\n');
        i2 = 1;
        localObject1 = localObject2;
        i1 = i4;
        i4 = i2;
      }
      label333:
      if (i4 != 0) {
        this.p -= 1;
      }
      localObject2 = localObject1;
      i5 = i1;
    }
    this.n = i3;
    this.m = i3;
    this.h = this.i;
    i2 = i3;
    i4 = -1;
    i1 = i3;
    localObject1 = localObject2;
    i3 = i5;
    label552:
    label1184:
    label1186:
    for (;;)
    {
      if (i1 < i3)
      {
        i5 = localObject1[i1];
        i1 += 1;
      }
      else
      {
        if (this.s)
        {
          i5 = -1;
          i1 = i3;
          break label552;
        }
        this.m = i1;
        this.k = i2;
        bool = h();
        i1 = this.m;
        i2 = this.k;
        localObject1 = this.j;
        i3 = this.o;
        if (bool)
        {
          i1 = i3;
          i5 = -1;
          break label552;
        }
        i5 = localObject1[i1];
        i1 += 1;
      }
      i6 = arrayOfInt1[(arrayOfInt2[this.h] + arrayOfChar[i5])];
      if (i6 == -1)
      {
        i1 = i3;
      }
      else
      {
        this.h = i6;
        i6 = arrayOfInt3[this.h];
        if ((i6 & 0x1) != 1) {
          break label1186;
        }
        i4 = this.h;
        if ((i6 & 0x8) != 8) {
          break label1184;
        }
        i2 = i1;
        i1 = i3;
      }
      this.k = i2;
      if (i4 >= 0) {
        i4 = b[i4];
      }
      switch (i4)
      {
      default: 
        if ((i5 == -1) && (this.n == this.m))
        {
          this.s = true;
          return null;
        }
      case 30: 
        return new c(b(), this.u);
      case 29: 
        return new n(b(), this.u);
      case 28: 
        return new s(b());
      case 27: 
        return new b(b());
      case 26: 
        return new g(b());
      case 25: 
        return new j(b(), this.u);
      case 24: 
        return new q(b());
      case 23: 
        return new m(b());
      case 22: 
        return new ac();
      case 21: 
        return new al();
      case 20: 
        return new z();
      case 19: 
        return new bb(b());
      case 18: 
        return new i(b());
      case 17: 
        a(0);
        if (this.t) {
          return new be("");
        }
        break;
      case 16: 
        return new ad();
      case 15: 
        return new r();
      case 14: 
        return new aa();
      case 13: 
        return new ai();
      case 12: 
        return new ag();
      case 11: 
        return new av();
      case 10: 
        return new p();
      case 8: 
        this.t = true;
        a(1);
        break;
      case 7: 
        return new l();
      case 6: 
        return new an();
      case 5: 
        return new d();
      case 4: 
        return new ax();
      case 3: 
        return new ab(b());
      case 2: 
        return new ak(b(), this.v);
      case 1: 
        this.t = false;
        return new be(b());
        b(1);
      }
      break;
      i2 = i1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */