package com.totoro.school.zxing.b;

import com.google.zxing.BarcodeFormat;
import java.util.Vector;
import java.util.regex.Pattern;

final class b
{
  static final Vector<BarcodeFormat> a;
  static final Vector<BarcodeFormat> b;
  static final Vector<BarcodeFormat> c;
  static final Vector<BarcodeFormat> d;
  private static final Pattern e = Pattern.compile(",");
  
  static
  {
    a = new Vector(5);
    a.add(BarcodeFormat.UPC_A);
    a.add(BarcodeFormat.UPC_E);
    a.add(BarcodeFormat.EAN_13);
    a.add(BarcodeFormat.EAN_8);
    b = new Vector(a.size() + 4);
    b.addAll(a);
    b.add(BarcodeFormat.CODE_39);
    b.add(BarcodeFormat.CODE_93);
    b.add(BarcodeFormat.CODE_128);
    b.add(BarcodeFormat.ITF);
    c = new Vector(1);
    c.add(BarcodeFormat.QR_CODE);
    d = new Vector(1);
    d.add(BarcodeFormat.DATA_MATRIX);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */