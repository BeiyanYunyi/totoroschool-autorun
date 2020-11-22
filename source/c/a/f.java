package c.a;

import c.c.g;

final class f
  implements v, g
{
  public static f[] a = new f[50];
  private String b;
  private int c;
  
  static
  {
    a[0] = new f("", 0);
    a[1] = new f("0", 1);
    a[2] = new f("0.00", 2);
    a[3] = new f("#,##0", 3);
    a[4] = new f("#,##0.00", 4);
    a[5] = new f("($#,##0_);($#,##0)", 5);
    a[6] = new f("($#,##0_);[Red]($#,##0)", 6);
    a[7] = new f("($#,##0_);[Red]($#,##0)", 7);
    a[8] = new f("($#,##0.00_);[Red]($#,##0.00)", 8);
    a[9] = new f("0%", 9);
    a[10] = new f("0.00%", 10);
    a[11] = new f("0.00E+00", 11);
    a[12] = new f("# ?/?", 12);
    a[13] = new f("# ??/??", 13);
    a[14] = new f("dd/mm/yyyy", 14);
    a[15] = new f("d-mmm-yy", 15);
    a[16] = new f("d-mmm", 16);
    a[17] = new f("mmm-yy", 17);
    a[18] = new f("h:mm AM/PM", 18);
    a[19] = new f("h:mm:ss AM/PM", 19);
    a[20] = new f("h:mm", 20);
    a[21] = new f("h:mm:ss", 21);
    a[22] = new f("m/d/yy h:mm", 22);
    a[37] = new f("(#,##0_);(#,##0)", 37);
    a[38] = new f("(#,##0_);[Red](#,##0)", 38);
    a[39] = new f("(#,##0.00_);(#,##0.00)", 39);
    a[40] = new f("(#,##0.00_);[Red](#,##0.00)", 40);
    a[41] = new f("_(*#,##0_);_(*(#,##0);_(*\"-\"_);(@_)", 41);
    a[42] = new f("_($*#,##0_);_($*(#,##0);_($*\"-\"_);(@_)", 42);
    a[43] = new f("_(* #,##0.00_);_(* (#,##0.00);_(* \"-\"??_);(@_)", 43);
    a[44] = new f("_($* #,##0.00_);_($* (#,##0.00);_($* \"-\"??_);(@_)", 44);
    a[45] = new f("mm:ss", 45);
    a[46] = new f("[h]mm:ss", 46);
    a[47] = new f("mm:ss.0", 47);
    a[48] = new f("##0.0E+0", 48);
    a[49] = new f("@", 49);
  }
  
  private f(String paramString, int paramInt)
  {
    this.c = paramInt;
    this.b = paramString;
  }
  
  public void a(int paramInt) {}
  
  public boolean c()
  {
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof f)) {
      return false;
    }
    paramObject = (f)paramObject;
    return this.c == ((f)paramObject).c;
  }
  
  public int f_()
  {
    return this.c;
  }
  
  public boolean g_()
  {
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */