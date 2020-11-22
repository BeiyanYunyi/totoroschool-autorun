package c.c;

public class e
{
  public static final e A = new e(30, "ocean blue", 0, 102, 204);
  public static final e B = new e(31, "ice blue", 204, 204, 255);
  public static final e C = new e(32, "dark blue", 0, 0, 128);
  public static final e D = new e(33, "pink", 255, 0, 255);
  public static final e E = new e(34, "yellow", 255, 255, 0);
  public static final e F = new e(35, "turqoise", 0, 255, 255);
  public static final e G = new e(36, "violet", 128, 0, 128);
  public static final e H = new e(37, "dark red", 128, 0, 0);
  public static final e I = new e(38, "teal", 0, 128, 128);
  public static final e J = new e(39, "blue", 0, 0, 255);
  public static final e K = new e(40, "sky blue", 0, 204, 255);
  public static final e L = new e(41, "light turquoise", 204, 255, 255);
  public static final e M = new e(42, "light green", 204, 255, 204);
  public static final e N = new e(43, "very light yellow", 255, 255, 153);
  public static final e O = new e(44, "pale blue", 153, 204, 255);
  public static final e P = new e(45, "rose", 255, 153, 204);
  public static final e Q = new e(46, "lavender", 204, 153, 255);
  public static final e R = new e(47, "tan", 255, 204, 153);
  public static final e S = new e(48, "light blue", 51, 102, 255);
  public static final e T = new e(49, "aqua", 51, 204, 204);
  public static final e U = new e(50, "lime", 153, 204, 0);
  public static final e V = new e(51, "gold", 255, 204, 0);
  public static final e W = new e(52, "light orange", 255, 153, 0);
  public static final e X = new e(53, "orange", 255, 102, 0);
  public static final e Y = new e(54, "blue grey", 102, 102, 204);
  public static final e Z = new e(55, "grey 40%", 150, 150, 150);
  public static final e a;
  public static final e aa = new e(56, "dark teal", 0, 51, 102);
  public static final e ab = new e(57, "sea green", 51, 153, 102);
  public static final e ac = new e(58, "dark green", 0, 51, 0);
  public static final e ad = new e(59, "olive green", 51, 51, 0);
  public static final e ae = new e(60, "brown", 153, 51, 0);
  public static final e af = new e(61, "plum", 153, 51, 102);
  public static final e ag = new e(62, "indigo", 51, 51, 153);
  public static final e ah = new e(63, "grey 80%", 51, 51, 51);
  public static final e ai = new e(64, "automatic", 255, 255, 255);
  public static final e aj = ah;
  public static final e ak = t;
  public static final e al = s;
  private static e[] ap = new e[0];
  public static final e b;
  public static final e c;
  public static final e d;
  public static final e e;
  public static final e f;
  public static final e g;
  public static final e h;
  public static final e i;
  public static final e j;
  public static final e k;
  public static final e l;
  public static final e m;
  public static final e n;
  public static final e o;
  public static final e p;
  public static final e q;
  public static final e r;
  public static final e s;
  public static final e t;
  public static final e u;
  public static final e v;
  public static final e w;
  public static final e x;
  public static final e y;
  public static final e z;
  private int am;
  private m an;
  private String ao;
  
  static
  {
    a = new e(32750, "unknown", 0, 0, 0);
    b = new e(32767, "black", 0, 0, 0);
    c = new e(9, "white", 255, 255, 255);
    d = new e(0, "default background", 255, 255, 255);
    e = new e(192, "default background", 255, 255, 255);
    f = new e(8, "black", 1, 0, 0);
    g = new e(10, "red", 255, 0, 0);
    h = new e(11, "bright green", 0, 255, 0);
    i = new e(12, "blue", 0, 0, 255);
    j = new e(13, "yellow", 255, 255, 0);
    k = new e(14, "pink", 255, 0, 255);
    l = new e(15, "turquoise", 0, 255, 255);
    m = new e(16, "dark red", 128, 0, 0);
    n = new e(17, "green", 0, 128, 0);
    o = new e(18, "dark blue", 0, 0, 128);
    p = new e(19, "dark yellow", 128, 128, 0);
    q = new e(20, "violet", 128, 128, 0);
    r = new e(21, "teal", 0, 128, 128);
    s = new e(22, "grey 25%", 192, 192, 192);
    t = new e(23, "grey 50%", 128, 128, 128);
    u = new e(24, "periwinkle%", 153, 153, 255);
    v = new e(25, "plum", 153, 51, 102);
    w = new e(26, "ivory", 255, 255, 204);
    x = new e(27, "light turquoise", 204, 255, 255);
    y = new e(28, "dark purple", 102, 0, 102);
    z = new e(29, "coral", 255, 128, 128);
  }
  
  protected e(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.am = paramInt1;
    this.ao = paramString;
    this.an = new m(paramInt2, paramInt3, paramInt4);
    paramString = ap;
    ap = new e[paramString.length + 1];
    System.arraycopy(paramString, 0, ap, 0, paramString.length);
    ap[paramString.length] = this;
  }
  
  public static e a(int paramInt)
  {
    int i1 = 0;
    while (i1 < ap.length)
    {
      if (ap[i1].a() == paramInt) {
        return ap[i1];
      }
      i1 += 1;
    }
    return a;
  }
  
  public int a()
  {
    return this.am;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */