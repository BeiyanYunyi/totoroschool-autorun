package c.a.b;

import java.util.HashMap;

class bh
{
  public static final bh A = new bh(8);
  public static final bh B = new bh(9);
  public static final bh C = new bh(10);
  public static final bh D = new bh(11);
  public static final bh E = new bh(12);
  public static final bh F = new bh(13);
  public static final bh G = new bh(14);
  public static final bh H = new bh(16);
  public static final bh I = new bh(17);
  public static final bh J = new bh(65, 33, 97);
  public static final bh K = new bh(66, 34, 98);
  public static final bh L = new bh(25);
  public static final bh M = new bh(41, 73, 105);
  public static final bh N = new bh(65535);
  private static HashMap O = new HashMap(20);
  public static final bh b = new bh(68, 36, 100);
  public static final bh c = new bh(90, 58, 122);
  public static final bh d = new bh(22);
  public static final bh e = new bh(23);
  public static final bh f = new bh(28);
  public static final bh g = new bh(29);
  public static final bh h = new bh(30);
  public static final bh i = new bh(31);
  public static final bh j = new bh(42, 74, 106);
  public static final bh k = new bh(44, 76, 108);
  public static final bh l = new bh(45, 77, 109);
  public static final bh m = new bh(38, 70, 102);
  public static final bh n = new bh(37, 101, 69);
  public static final bh o = new bh(35, 67, 99);
  public static final bh p = new bh(57, 89);
  public static final bh q = new bh(59, 91);
  public static final bh r = new bh(18);
  public static final bh s = new bh(19);
  public static final bh t = new bh(20);
  public static final bh u = new bh(21);
  public static final bh v = new bh(3);
  public static final bh w = new bh(4);
  public static final bh x = new bh(5);
  public static final bh y = new bh(6);
  public static final bh z = new bh(7);
  public final int[] a;
  
  private bh(int paramInt)
  {
    this.a = new int[] { paramInt };
    O.put(new Integer(paramInt), this);
  }
  
  private bh(int paramInt1, int paramInt2)
  {
    this.a = new int[] { paramInt1, paramInt2 };
    O.put(new Integer(paramInt1), this);
    O.put(new Integer(paramInt2), this);
  }
  
  private bh(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = new int[] { paramInt1, paramInt2, paramInt3 };
    O.put(new Integer(paramInt1), this);
    O.put(new Integer(paramInt2), this);
    O.put(new Integer(paramInt3), this);
  }
  
  public static bh a(int paramInt)
  {
    bh localbh = (bh)O.get(new Integer(paramInt));
    if (localbh != null) {
      return localbh;
    }
    return N;
  }
  
  public byte a()
  {
    return (byte)this.a[0];
  }
  
  public byte b()
  {
    return (byte)this.a[0];
  }
  
  public byte c()
  {
    int i1;
    if (this.a.length > 0) {
      i1 = this.a[1];
    } else {
      i1 = this.a[0];
    }
    return (byte)i1;
  }
  
  public byte d()
  {
    int i1;
    if (this.a.length > 0) {
      i1 = this.a[1];
    } else {
      i1 = this.a[0];
    }
    return (byte)i1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */