package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.io.File;

public class fg
  extends View
{
  private Bitmap a;
  private Bitmap b;
  private Bitmap c;
  private Bitmap d;
  private Bitmap e;
  private Bitmap f;
  private Paint g;
  private boolean h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private boolean q;
  private boolean r;
  private Context s;
  private float t;
  private float u;
  private boolean v;
  
  /* Error */
  public fg(Context paramContext, com.autonavi.base.amap.api.mapcore.IAMapDelegate paramIAMapDelegate)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 41	android/view/View:<init>	(Landroid/content/Context;)V
    //   5: aload_0
    //   6: new 43	android/graphics/Paint
    //   9: dup
    //   10: invokespecial 46	android/graphics/Paint:<init>	()V
    //   13: putfield 48	com/amap/api/mapcore/util/fg:g	Landroid/graphics/Paint;
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 50	com/amap/api/mapcore/util/fg:h	Z
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 52	com/amap/api/mapcore/util/fg:i	I
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 54	com/amap/api/mapcore/util/fg:j	I
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 56	com/amap/api/mapcore/util/fg:k	I
    //   36: aload_0
    //   37: bipush 10
    //   39: putfield 58	com/amap/api/mapcore/util/fg:l	I
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 60	com/amap/api/mapcore/util/fg:m	I
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 62	com/amap/api/mapcore/util/fg:n	I
    //   52: aload_0
    //   53: bipush 10
    //   55: putfield 64	com/amap/api/mapcore/util/fg:o	I
    //   58: aload_0
    //   59: bipush 8
    //   61: putfield 66	com/amap/api/mapcore/util/fg:p	I
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield 68	com/amap/api/mapcore/util/fg:q	Z
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield 70	com/amap/api/mapcore/util/fg:r	Z
    //   74: aload_0
    //   75: fconst_0
    //   76: putfield 72	com/amap/api/mapcore/util/fg:t	F
    //   79: aload_0
    //   80: fconst_0
    //   81: putfield 74	com/amap/api/mapcore/util/fg:u	F
    //   84: aload_0
    //   85: iconst_1
    //   86: putfield 76	com/amap/api/mapcore/util/fg:v	Z
    //   89: aconst_null
    //   90: astore 4
    //   92: aload_0
    //   93: aload_1
    //   94: invokevirtual 82	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   97: putfield 84	com/amap/api/mapcore/util/fg:s	Landroid/content/Context;
    //   100: aload_1
    //   101: invokestatic 89	com/amap/api/mapcore/util/dr:a	(Landroid/content/Context;)Landroid/content/res/AssetManager;
    //   104: ldc 91
    //   106: invokevirtual 97	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   109: astore_3
    //   110: aload_0
    //   111: aload_3
    //   112: invokestatic 103	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   115: putfield 105	com/amap/api/mapcore/util/fg:e	Landroid/graphics/Bitmap;
    //   118: aload_0
    //   119: aload_0
    //   120: getfield 105	com/amap/api/mapcore/util/fg:e	Landroid/graphics/Bitmap;
    //   123: getstatic 109	com/amap/api/mapcore/util/lk:a	F
    //   126: invokestatic 114	com/amap/api/mapcore/util/dx:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   129: putfield 116	com/amap/api/mapcore/util/fg:a	Landroid/graphics/Bitmap;
    //   132: aload_3
    //   133: invokevirtual 121	java/io/InputStream:close	()V
    //   136: aload_1
    //   137: invokestatic 89	com/amap/api/mapcore/util/dr:a	(Landroid/content/Context;)Landroid/content/res/AssetManager;
    //   140: ldc 123
    //   142: invokevirtual 97	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   145: astore_2
    //   146: aload_0
    //   147: aload_2
    //   148: invokestatic 103	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   151: putfield 125	com/amap/api/mapcore/util/fg:f	Landroid/graphics/Bitmap;
    //   154: aload_0
    //   155: aload_0
    //   156: getfield 125	com/amap/api/mapcore/util/fg:f	Landroid/graphics/Bitmap;
    //   159: getstatic 109	com/amap/api/mapcore/util/lk:a	F
    //   162: invokestatic 114	com/amap/api/mapcore/util/dx:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   165: putfield 127	com/amap/api/mapcore/util/fg:b	Landroid/graphics/Bitmap;
    //   168: aload_2
    //   169: invokevirtual 121	java/io/InputStream:close	()V
    //   172: aload_0
    //   173: aload_0
    //   174: getfield 127	com/amap/api/mapcore/util/fg:b	Landroid/graphics/Bitmap;
    //   177: invokevirtual 133	android/graphics/Bitmap:getWidth	()I
    //   180: putfield 54	com/amap/api/mapcore/util/fg:j	I
    //   183: aload_0
    //   184: aload_0
    //   185: getfield 127	com/amap/api/mapcore/util/fg:b	Landroid/graphics/Bitmap;
    //   188: invokevirtual 136	android/graphics/Bitmap:getHeight	()I
    //   191: putfield 52	com/amap/api/mapcore/util/fg:i	I
    //   194: aload_0
    //   195: getfield 48	com/amap/api/mapcore/util/fg:g	Landroid/graphics/Paint;
    //   198: iconst_1
    //   199: invokevirtual 140	android/graphics/Paint:setAntiAlias	(Z)V
    //   202: aload_0
    //   203: getfield 48	com/amap/api/mapcore/util/fg:g	Landroid/graphics/Paint;
    //   206: ldc -115
    //   208: invokevirtual 145	android/graphics/Paint:setColor	(I)V
    //   211: aload_0
    //   212: getfield 48	com/amap/api/mapcore/util/fg:g	Landroid/graphics/Paint;
    //   215: getstatic 151	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   218: invokevirtual 155	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   221: new 157	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   228: astore 4
    //   230: aload 4
    //   232: aload_1
    //   233: invokevirtual 162	android/content/Context:getFilesDir	()Ljava/io/File;
    //   236: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 4
    //   242: ldc -88
    //   244: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 4
    //   250: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: putstatic 181	com/autonavi/amap/mapcore/AMapEngineUtils:LOGO_CUSTOM_ICON_DAY_NAME	Ljava/lang/String;
    //   256: new 157	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   263: astore 4
    //   265: aload 4
    //   267: aload_1
    //   268: invokevirtual 162	android/content/Context:getFilesDir	()Ljava/io/File;
    //   271: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 4
    //   277: ldc -73
    //   279: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 4
    //   285: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: putstatic 186	com/autonavi/amap/mapcore/AMapEngineUtils:LOGO_CUSTOM_ICON_NIGHT_NAME	Ljava/lang/String;
    //   291: invokestatic 191	com/amap/api/mapcore/util/dw:a	()Lcom/amap/api/mapcore/util/dw;
    //   294: new 6	com/amap/api/mapcore/util/fg$1
    //   297: dup
    //   298: aload_0
    //   299: invokespecial 194	com/amap/api/mapcore/util/fg$1:<init>	(Lcom/amap/api/mapcore/util/fg;)V
    //   302: invokevirtual 197	com/amap/api/mapcore/util/dw:a	(Ljava/lang/Runnable;)V
    //   305: aload_3
    //   306: ifnull +15 -> 321
    //   309: aload_3
    //   310: invokevirtual 121	java/io/InputStream:close	()V
    //   313: goto +8 -> 321
    //   316: astore_1
    //   317: aload_1
    //   318: invokevirtual 200	java/lang/Throwable:printStackTrace	()V
    //   321: aload_2
    //   322: ifnull +96 -> 418
    //   325: aload_2
    //   326: invokevirtual 121	java/io/InputStream:close	()V
    //   329: return
    //   330: astore 4
    //   332: aload_2
    //   333: astore_1
    //   334: aload 4
    //   336: astore_2
    //   337: goto +83 -> 420
    //   340: astore 4
    //   342: aload_2
    //   343: astore_1
    //   344: aload 4
    //   346: astore_2
    //   347: goto +12 -> 359
    //   350: astore_2
    //   351: aconst_null
    //   352: astore_1
    //   353: goto +67 -> 420
    //   356: astore_2
    //   357: aconst_null
    //   358: astore_1
    //   359: goto +17 -> 376
    //   362: astore_2
    //   363: aconst_null
    //   364: astore_3
    //   365: aload_3
    //   366: astore_1
    //   367: goto +53 -> 420
    //   370: astore_2
    //   371: aconst_null
    //   372: astore_1
    //   373: aload 4
    //   375: astore_3
    //   376: aload_2
    //   377: ldc -54
    //   379: ldc -52
    //   381: invokestatic 209	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   384: aload_2
    //   385: invokevirtual 200	java/lang/Throwable:printStackTrace	()V
    //   388: aload_3
    //   389: ifnull +15 -> 404
    //   392: aload_3
    //   393: invokevirtual 121	java/io/InputStream:close	()V
    //   396: goto +8 -> 404
    //   399: astore_2
    //   400: aload_2
    //   401: invokevirtual 200	java/lang/Throwable:printStackTrace	()V
    //   404: aload_1
    //   405: ifnull +13 -> 418
    //   408: aload_1
    //   409: invokevirtual 121	java/io/InputStream:close	()V
    //   412: return
    //   413: astore_1
    //   414: aload_1
    //   415: invokevirtual 200	java/lang/Throwable:printStackTrace	()V
    //   418: return
    //   419: astore_2
    //   420: aload_3
    //   421: ifnull +15 -> 436
    //   424: aload_3
    //   425: invokevirtual 121	java/io/InputStream:close	()V
    //   428: goto +8 -> 436
    //   431: astore_3
    //   432: aload_3
    //   433: invokevirtual 200	java/lang/Throwable:printStackTrace	()V
    //   436: aload_1
    //   437: ifnull +15 -> 452
    //   440: aload_1
    //   441: invokevirtual 121	java/io/InputStream:close	()V
    //   444: goto +8 -> 452
    //   447: astore_1
    //   448: aload_1
    //   449: invokevirtual 200	java/lang/Throwable:printStackTrace	()V
    //   452: aload_2
    //   453: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	fg
    //   0	454	1	paramContext	Context
    //   0	454	2	paramIAMapDelegate	com.autonavi.base.amap.api.mapcore.IAMapDelegate
    //   109	316	3	localObject1	Object
    //   431	2	3	localThrowable1	Throwable
    //   90	194	4	localStringBuilder	StringBuilder
    //   330	5	4	localObject2	Object
    //   340	34	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   309	313	316	java/lang/Throwable
    //   146	305	330	finally
    //   146	305	340	java/lang/Throwable
    //   110	146	350	finally
    //   110	146	356	java/lang/Throwable
    //   92	110	362	finally
    //   92	110	370	java/lang/Throwable
    //   392	396	399	java/lang/Throwable
    //   325	329	413	java/lang/Throwable
    //   408	412	413	java/lang/Throwable
    //   376	388	419	finally
    //   424	428	431	java/lang/Throwable
    //   440	444	447	java/lang/Throwable
  }
  
  private void f()
  {
    switch (this.n)
    {
    default: 
      break;
    case 2: 
      g();
      break;
    case 0: 
      h();
    }
    this.l = this.o;
    this.m = (getHeight() - this.p - this.i);
    if (this.l < 0) {
      this.l = 0;
    }
    if (this.m < 0) {
      this.m = 0;
    }
  }
  
  private void g()
  {
    if (this.v) {
      this.o = ((int)(getWidth() * this.t));
    } else {
      this.o = ((int)(getWidth() * this.t - this.j));
    }
    this.p = ((int)(getHeight() * this.u));
  }
  
  private void h()
  {
    if (this.k == 1) {
      this.o = ((getWidth() - this.j) / 2);
    } else if (this.k == 2) {
      this.o = (getWidth() - this.j - 10);
    } else {
      this.o = 10;
    }
    this.p = 8;
  }
  
  public void a()
  {
    try
    {
      if (this.a != null) {
        this.a.recycle();
      }
      if (this.b != null) {
        this.b.recycle();
      }
      this.a = null;
      this.b = null;
      if (this.e != null)
      {
        this.e.recycle();
        this.e = null;
      }
      if (this.f != null)
      {
        this.f.recycle();
        this.f = null;
      }
      if (this.c != null) {
        this.c.recycle();
      }
      this.c = null;
      if (this.d != null) {
        this.d.recycle();
      }
      this.d = null;
      this.g = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "WaterMarkerView", "destory");
      localThrowable.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    this.n = 0;
    this.k = paramInt;
    d();
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.n = 2;
    paramFloat = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    switch (paramInt)
    {
    default: 
      break;
    case 2: 
      this.u = (1.0F - paramFloat);
      break;
    case 1: 
      this.t = (1.0F - paramFloat);
      this.v = false;
      break;
    case 0: 
      this.t = paramFloat;
      this.v = true;
    }
    d();
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      if (!new File(paramString).exists()) {
        return;
      }
      Bitmap localBitmap;
      if (paramInt == 0)
      {
        localBitmap = this.c;
        this.e = BitmapFactory.decodeFile(paramString);
        this.c = dx.a(this.e, lk.a);
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
      }
      else if (paramInt == 1)
      {
        localBitmap = this.d;
        this.e = BitmapFactory.decodeFile(paramString);
        this.d = dx.a(this.e, lk.a);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          localBitmap.recycle();
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      gk.c(paramString, "WaterMarkerView", "create");
      paramString.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.h = paramBoolean;
      if (paramBoolean)
      {
        this.g.setColor(-1);
        return;
      }
      this.g.setColor(-16777216);
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "WaterMarkerView", "changeBitmap");
      localThrowable.printStackTrace();
    }
  }
  
  public Bitmap b()
  {
    if (this.h)
    {
      if ((this.r) && (this.d != null)) {
        return this.d;
      }
      return this.b;
    }
    if ((this.r) && (this.c != null)) {
      return this.c;
    }
    return this.a;
  }
  
  public void b(int paramInt)
  {
    this.n = 1;
    this.p = paramInt;
    d();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.r != paramBoolean)
    {
      this.r = paramBoolean;
      if (paramBoolean)
      {
        if (this.h)
        {
          if (this.d != null)
          {
            this.j = this.d.getWidth();
            this.i = this.d.getHeight();
          }
        }
        else if (this.c != null)
        {
          this.j = this.c.getWidth();
          this.i = this.c.getHeight();
        }
      }
      else
      {
        this.j = this.a.getWidth();
        this.i = this.a.getHeight();
      }
    }
  }
  
  public Point c()
  {
    return new Point(this.l, this.m - 2);
  }
  
  public void c(int paramInt)
  {
    this.n = 1;
    this.o = paramInt;
    d();
  }
  
  public float d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0.0F;
    case 2: 
      return 1.0F - this.u;
    case 1: 
      return 1.0F - this.t;
    }
    return this.t;
  }
  
  public void d()
  {
    if (getWidth() != 0)
    {
      if (getHeight() == 0) {
        return;
      }
      f();
      postInvalidate();
      return;
    }
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    try
    {
      if (getWidth() != 0)
      {
        if (getHeight() == 0) {
          return;
        }
        if (this.b == null) {
          return;
        }
        if (!this.q)
        {
          f();
          this.q = true;
        }
        paramCanvas.drawBitmap(b(), this.l, this.m, this.g);
        return;
      }
      return;
    }
    catch (Throwable paramCanvas)
    {
      gk.c(paramCanvas, "WaterMarkerView", "onDraw");
      paramCanvas.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */