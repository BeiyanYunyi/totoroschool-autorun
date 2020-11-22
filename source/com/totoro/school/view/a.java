package com.totoro.school.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

public class a
{
  private static final char[] a = { 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102, 103, 104, 106, 107, 109, 110, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };
  private static a b;
  private int c = 100;
  private int d = 40;
  private int e = 10;
  private int f = 15;
  private int g = 15;
  private int h = 20;
  private int i = 4;
  private int j = 5;
  private int k = 25;
  private String l;
  private int m;
  private int n;
  private Random o = new Random();
  
  private int a(int paramInt)
  {
    return Color.rgb(this.o.nextInt(256) / paramInt, this.o.nextInt(256) / paramInt, this.o.nextInt(256) / paramInt);
  }
  
  public static a a()
  {
    if (b == null) {
      b = new a();
    }
    return b;
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint)
  {
    int i1 = e();
    int i2 = this.o.nextInt(this.c);
    int i3 = this.o.nextInt(this.d);
    int i4 = this.o.nextInt(this.c);
    int i5 = this.o.nextInt(this.d);
    paramPaint.setStrokeWidth(this.o.nextInt(4));
    paramPaint.setColor(i1);
    paramCanvas.drawLine(i2, i3, i4, i5, paramPaint);
  }
  
  private void a(Paint paramPaint)
  {
    paramPaint.setColor(e());
    paramPaint.setFakeBoldText(this.o.nextBoolean());
    float f1 = this.o.nextInt(11) / 10;
    if (!this.o.nextBoolean()) {
      f1 = -f1;
    }
    paramPaint.setTextSkewX(f1);
  }
  
  private String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while (i1 < this.i)
    {
      localStringBuilder.append(a[this.o.nextInt(a.length)]);
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private int e()
  {
    return a(1);
  }
  
  private void f()
  {
    this.m += this.e + this.o.nextInt(this.f);
    this.n = (this.g + this.o.nextInt(this.h));
  }
  
  public Bitmap b()
  {
    int i3 = 0;
    this.m = 0;
    Bitmap localBitmap = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.l = d();
    localCanvas.drawColor(e());
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextSize(this.k);
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= this.l.length()) {
        break;
      }
      a(localPaint);
      f();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.l.charAt(i1));
      localStringBuilder.append("");
      localCanvas.drawText(localStringBuilder.toString(), this.m, this.n, localPaint);
      i1 += 1;
    }
    while (i2 < this.j)
    {
      a(localCanvas, localPaint);
      i2 += 1;
    }
    localCanvas.save();
    localCanvas.restore();
    return localBitmap;
  }
  
  public String c()
  {
    return this.l;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */