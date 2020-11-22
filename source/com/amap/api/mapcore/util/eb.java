package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.HashMap;

public class eb
{
  private static final Bitmap.CompressFormat a = Bitmap.CompressFormat.PNG;
  private hs b;
  private dj<String, Bitmap> c;
  private a d;
  private final Object e = new Object();
  private boolean f = true;
  private HashMap<String, WeakReference<Bitmap>> g;
  
  private eb(a parama)
  {
    b(parama);
  }
  
  public static int a(Bitmap paramBitmap)
  {
    if (dx.d()) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public static long a(File paramFile)
  {
    if (dx.b()) {
      return paramFile.getUsableSpace();
    }
    paramFile = new StatFs(paramFile.getPath());
    return paramFile.getBlockSize() * paramFile.getAvailableBlocks();
  }
  
  public static eb a(a parama)
  {
    return new eb(parama);
  }
  
  public static File a(Context paramContext)
  {
    try
    {
      if (dx.a()) {
        return paramContext.getExternalCacheDir();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/Android/data/");
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append("/cache/");
      paramContext = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
      localStringBuilder.append(paramContext);
      paramContext = new File(localStringBuilder.toString());
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static File a(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = a(paramContext);
    if ((("mounted".equals(Environment.getExternalStorageState())) || (!d())) && (localObject != null)) {
      paramContext = ((File)localObject).getPath();
    } else {
      paramContext = paramContext.getCacheDir().getPath();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramString2);
    }
    return new File(((StringBuilder)localObject).toString());
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void b(a parama)
  {
    this.d = parama;
    if (this.d.f)
    {
      if (ec.a()) {
        this.g = new HashMap(64);
      }
      this.c = new dj(this.d.a)
      {
        protected int a(String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          int j = eb.a(paramAnonymousBitmap);
          int i = j;
          if (j == 0) {
            i = 1;
          }
          return i;
        }
        
        protected void a(boolean paramAnonymousBoolean, String paramAnonymousString, Bitmap paramAnonymousBitmap1, Bitmap paramAnonymousBitmap2)
        {
          if ((dx.c()) && (eb.a(eb.this) != null) && (paramAnonymousBitmap1 != null) && (!paramAnonymousBitmap1.isRecycled())) {
            eb.a(eb.this).put(paramAnonymousString, new WeakReference(paramAnonymousBitmap1));
          }
        }
      };
    }
    if (parama.h) {
      a();
    }
  }
  
  private void b(File paramFile)
    throws IOException
  {
    Object localObject = paramFile.listFiles();
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramFile = localObject[i];
        if (paramFile.isDirectory()) {
          b(paramFile);
        }
        if (paramFile.delete())
        {
          i += 1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("failed to delete file: ");
          ((StringBuilder)localObject).append(paramFile);
          throw new IOException(((StringBuilder)localObject).toString());
        }
      }
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("not a readable directory: ");
    ((StringBuilder)localObject).append(paramFile);
    throw new IOException(((StringBuilder)localObject).toString());
  }
  
  public static String c(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes("utf-8"));
      localObject = a(((MessageDigest)localObject).digest());
      return (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return String.valueOf(paramString.hashCode());
  }
  
  public static boolean d()
  {
    if (dx.b()) {
      return Environment.isExternalStorageRemovable();
    }
    return true;
  }
  
  public Bitmap a(String paramString)
  {
    if ((dx.c()) && (this.g != null))
    {
      localObject1 = (WeakReference)this.g.get(paramString);
      if (localObject1 != null)
      {
        localObject2 = (Bitmap)((WeakReference)localObject1).get();
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((Bitmap)localObject2).isRecycled()) {}
        }
        else
        {
          localObject1 = null;
        }
        this.g.remove(paramString);
        break label66;
      }
    }
    Object localObject1 = null;
    label66:
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.c != null) {
        localObject2 = (Bitmap)this.c.a(paramString);
      }
    }
    if (localObject2 != null)
    {
      if (((Bitmap)localObject2).isRecycled()) {
        return null;
      }
      return (Bitmap)localObject2;
    }
    return null;
  }
  
  public void a()
  {
    synchronized (this.e)
    {
      File localFile;
      if ((this.b == null) || (this.b.d()))
      {
        localFile = this.d.c;
        boolean bool = this.d.g;
        if ((!bool) || (localFile == null)) {}
      }
      try
      {
        if (localFile.exists())
        {
          if (this.d.i)
          {
            b(localFile);
            localFile.mkdir();
          }
        }
        else {
          localFile.mkdirs();
        }
      }
      catch (Throwable localThrowable2)
      {
        long l1;
        long l2;
        for (;;) {}
      }
      l1 = a(localFile);
      l2 = this.d.b;
      if (l1 > l2) {}
      try
      {
        this.b = hs.a(localFile, 1, 1, this.d.b);
      }
      catch (Throwable localThrowable1)
      {
        for (;;) {}
      }
      this.d.c = null;
      this.f = false;
      this.e.notifyAll();
      return;
    }
  }
  
  /* Error */
  public void a(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +186 -> 187
    //   4: aload_2
    //   5: ifnull +182 -> 187
    //   8: aload_2
    //   9: invokevirtual 268	android/graphics/Bitmap:isRecycled	()Z
    //   12: ifeq +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: getfield 189	com/amap/api/mapcore/util/eb:c	Lcom/amap/api/mapcore/util/dj;
    //   20: ifnull +13 -> 33
    //   23: aload_0
    //   24: getfield 189	com/amap/api/mapcore/util/eb:c	Lcom/amap/api/mapcore/util/dj;
    //   27: aload_1
    //   28: aload_2
    //   29: invokevirtual 312	com/amap/api/mapcore/util/dj:a	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: pop
    //   33: aload_0
    //   34: getfield 40	com/amap/api/mapcore/util/eb:e	Ljava/lang/Object;
    //   37: astore 5
    //   39: aload 5
    //   41: monitorenter
    //   42: aload_0
    //   43: getfield 277	com/amap/api/mapcore/util/eb:b	Lcom/amap/api/mapcore/util/hs;
    //   46: ifnull +131 -> 177
    //   49: aload_1
    //   50: invokestatic 314	com/amap/api/mapcore/util/eb:c	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 6
    //   55: aconst_null
    //   56: astore_3
    //   57: aconst_null
    //   58: astore 4
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_0
    //   63: getfield 277	com/amap/api/mapcore/util/eb:b	Lcom/amap/api/mapcore/util/hs;
    //   66: aload 6
    //   68: invokevirtual 317	com/amap/api/mapcore/util/hs:a	(Ljava/lang/String;)Lcom/amap/api/mapcore/util/hs$b;
    //   71: astore 7
    //   73: aload 7
    //   75: ifnonnull +69 -> 144
    //   78: aload_0
    //   79: getfield 277	com/amap/api/mapcore/util/eb:b	Lcom/amap/api/mapcore/util/hs;
    //   82: aload 6
    //   84: invokevirtual 320	com/amap/api/mapcore/util/hs:b	(Ljava/lang/String;)Lcom/amap/api/mapcore/util/hs$a;
    //   87: astore 6
    //   89: aload 6
    //   91: ifnull +62 -> 153
    //   94: aload 6
    //   96: iconst_0
    //   97: invokevirtual 325	com/amap/api/mapcore/util/hs$a:a	(I)Ljava/io/OutputStream;
    //   100: astore_1
    //   101: aload_2
    //   102: aload_0
    //   103: getfield 172	com/amap/api/mapcore/util/eb:d	Lcom/amap/api/mapcore/util/eb$a;
    //   106: getfield 327	com/amap/api/mapcore/util/eb$a:d	Landroid/graphics/Bitmap$CompressFormat;
    //   109: aload_0
    //   110: getfield 172	com/amap/api/mapcore/util/eb:d	Lcom/amap/api/mapcore/util/eb$a;
    //   113: getfield 329	com/amap/api/mapcore/util/eb$a:e	I
    //   116: aload_1
    //   117: invokevirtual 333	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   120: pop
    //   121: aload 6
    //   123: invokevirtual 334	com/amap/api/mapcore/util/hs$a:a	()V
    //   126: aload_1
    //   127: invokevirtual 339	java/io/OutputStream:close	()V
    //   130: goto +23 -> 153
    //   133: astore_3
    //   134: aload_1
    //   135: astore_2
    //   136: aload_3
    //   137: astore_1
    //   138: goto +29 -> 167
    //   141: goto +66 -> 207
    //   144: aload 7
    //   146: iconst_0
    //   147: invokevirtual 344	com/amap/api/mapcore/util/hs$b:a	(I)Ljava/io/InputStream;
    //   150: invokevirtual 347	java/io/InputStream:close	()V
    //   153: aload_1
    //   154: ifnull +23 -> 177
    //   157: aload_1
    //   158: invokevirtual 339	java/io/OutputStream:close	()V
    //   161: goto +16 -> 177
    //   164: astore_1
    //   165: aload_3
    //   166: astore_2
    //   167: aload_2
    //   168: ifnull +7 -> 175
    //   171: aload_2
    //   172: invokevirtual 339	java/io/OutputStream:close	()V
    //   175: aload_1
    //   176: athrow
    //   177: aload 5
    //   179: monitorexit
    //   180: return
    //   181: astore_1
    //   182: aload 5
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    //   187: return
    //   188: astore_1
    //   189: aload 4
    //   191: astore_1
    //   192: goto +15 -> 207
    //   195: astore_2
    //   196: goto -55 -> 141
    //   199: astore_1
    //   200: goto -23 -> 177
    //   203: astore_2
    //   204: goto -29 -> 175
    //   207: aload_1
    //   208: ifnull -31 -> 177
    //   211: goto -54 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	eb
    //   0	214	1	paramString	String
    //   0	214	2	paramBitmap	Bitmap
    //   56	1	3	localObject1	Object
    //   133	33	3	localObject2	Object
    //   58	132	4	localObject3	Object
    //   37	146	5	localObject4	Object
    //   53	69	6	localObject5	Object
    //   71	74	7	localb	hs.b
    // Exception table:
    //   from	to	target	type
    //   101	130	133	finally
    //   62	73	164	finally
    //   78	89	164	finally
    //   94	101	164	finally
    //   144	153	164	finally
    //   42	55	181	finally
    //   157	161	181	finally
    //   171	175	181	finally
    //   175	177	181	finally
    //   177	180	181	finally
    //   182	185	181	finally
    //   62	73	188	java/lang/Throwable
    //   78	89	188	java/lang/Throwable
    //   94	101	188	java/lang/Throwable
    //   144	153	188	java/lang/Throwable
    //   101	130	195	java/lang/Throwable
    //   157	161	199	java/lang/Throwable
    //   171	175	203	java/lang/Throwable
  }
  
  public void a(boolean paramBoolean)
  {
    if ((dx.c()) && (this.g != null)) {
      this.g.clear();
    }
    if (this.c != null) {
      this.c.a();
    }
    synchronized (this.e)
    {
      hs localhs = this.b;
      if (localhs != null) {}
      try
      {
        if (!this.b.d())
        {
          if (paramBoolean) {
            this.b.f();
          } else {
            this.b.close();
          }
          this.b = null;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
      return;
    }
  }
  
  /* Error */
  public Bitmap b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 314	com/amap/api/mapcore/util/eb:c	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 40	com/amap/api/mapcore/util/eb:e	Ljava/lang/Object;
    //   10: astore 7
    //   12: aload 7
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 42	com/amap/api/mapcore/util/eb:f	Z
    //   19: istore_2
    //   20: iload_2
    //   21: ifeq +13 -> 34
    //   24: aload_0
    //   25: getfield 40	com/amap/api/mapcore/util/eb:e	Ljava/lang/Object;
    //   28: invokevirtual 358	java/lang/Object:wait	()V
    //   31: goto -16 -> 15
    //   34: aload_0
    //   35: getfield 277	com/amap/api/mapcore/util/eb:b	Lcom/amap/api/mapcore/util/hs;
    //   38: astore 8
    //   40: aconst_null
    //   41: astore 5
    //   43: aconst_null
    //   44: astore 6
    //   46: aconst_null
    //   47: astore_1
    //   48: aload 6
    //   50: astore_3
    //   51: aload 8
    //   53: ifnull +91 -> 144
    //   56: aload_0
    //   57: getfield 277	com/amap/api/mapcore/util/eb:b	Lcom/amap/api/mapcore/util/hs;
    //   60: aload 4
    //   62: invokevirtual 317	com/amap/api/mapcore/util/hs:a	(Ljava/lang/String;)Lcom/amap/api/mapcore/util/hs$b;
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull +44 -> 111
    //   70: aload_3
    //   71: iconst_0
    //   72: invokevirtual 344	com/amap/api/mapcore/util/hs$b:a	(I)Ljava/io/InputStream;
    //   75: astore_3
    //   76: aload_3
    //   77: astore 4
    //   79: aload_3
    //   80: ifnull +34 -> 114
    //   83: aload_3
    //   84: checkcast 360	java/io/FileInputStream
    //   87: invokevirtual 364	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   90: ldc_w 365
    //   93: ldc_w 365
    //   96: aload_0
    //   97: invokestatic 370	com/amap/api/mapcore/util/dz:a	(Ljava/io/FileDescriptor;IILcom/amap/api/mapcore/util/eb;)Landroid/graphics/Bitmap;
    //   100: astore_1
    //   101: aload_3
    //   102: astore 4
    //   104: goto +10 -> 114
    //   107: astore_1
    //   108: goto +26 -> 134
    //   111: aconst_null
    //   112: astore 4
    //   114: aload_1
    //   115: astore_3
    //   116: aload 4
    //   118: ifnull +26 -> 144
    //   121: aload_1
    //   122: astore_3
    //   123: aload 4
    //   125: invokevirtual 347	java/io/InputStream:close	()V
    //   128: goto +16 -> 144
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_3
    //   134: aload_3
    //   135: ifnull +7 -> 142
    //   138: aload_3
    //   139: invokevirtual 347	java/io/InputStream:close	()V
    //   142: aload_1
    //   143: athrow
    //   144: aload 7
    //   146: monitorexit
    //   147: aload_3
    //   148: areturn
    //   149: astore_1
    //   150: aload 7
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    //   155: astore_1
    //   156: goto -141 -> 15
    //   159: astore_1
    //   160: goto +17 -> 177
    //   163: astore_1
    //   164: aload_3
    //   165: astore_1
    //   166: goto +13 -> 179
    //   169: astore_1
    //   170: goto -26 -> 144
    //   173: astore_3
    //   174: goto -32 -> 142
    //   177: aconst_null
    //   178: astore_1
    //   179: aload 6
    //   181: astore_3
    //   182: aload_1
    //   183: ifnull -39 -> 144
    //   186: aload 5
    //   188: astore_3
    //   189: aload_1
    //   190: astore 4
    //   192: goto -69 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	eb
    //   0	195	1	paramString	String
    //   19	2	2	bool	boolean
    //   50	115	3	localObject1	Object
    //   173	1	3	localThrowable	Throwable
    //   181	8	3	localObject2	Object
    //   4	187	4	localObject3	Object
    //   41	146	5	localObject4	Object
    //   44	136	6	localObject5	Object
    //   10	141	7	localObject6	Object
    //   38	14	8	localhs	hs
    // Exception table:
    //   from	to	target	type
    //   83	101	107	finally
    //   56	66	131	finally
    //   70	76	131	finally
    //   15	20	149	finally
    //   24	31	149	finally
    //   34	40	149	finally
    //   123	128	149	finally
    //   138	142	149	finally
    //   142	144	149	finally
    //   144	147	149	finally
    //   150	153	149	finally
    //   24	31	155	java/lang/Throwable
    //   56	66	159	java/lang/Throwable
    //   70	76	159	java/lang/Throwable
    //   83	101	163	java/lang/Throwable
    //   123	128	169	java/lang/Throwable
    //   138	142	173	java/lang/Throwable
  }
  
  public void b()
  {
    if ((dx.c()) && (this.g != null)) {
      this.g.clear();
    }
    if (this.c != null) {
      this.c.a();
    }
    synchronized (this.e)
    {
      this.f = true;
      if (this.b != null)
      {
        boolean bool = this.b.d();
        if (bool) {}
      }
    }
    try
    {
      this.b.close();
      b(a(lq.a, this.d.j, null));
      this.b = null;
      a();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public void c()
  {
    synchronized (this.e)
    {
      hs localhs = this.b;
      if (localhs == null) {}
    }
    try
    {
      this.b.e();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public static class a
  {
    public int a = 5242880;
    public long b = 10485760L;
    public File c;
    public Bitmap.CompressFormat d = eb.e();
    public int e = 100;
    public boolean f = true;
    public boolean g = true;
    public boolean h = false;
    public boolean i = true;
    public String j = null;
    
    public a(Context paramContext, String paramString)
    {
      this.j = paramString;
      this.c = eb.a(paramContext, paramString, null);
    }
    
    public a(Context paramContext, String paramString1, String paramString2)
    {
      this.j = paramString1;
      this.c = eb.a(paramContext, paramString1, paramString2);
    }
    
    public void a(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void a(long paramLong)
    {
      if (paramLong <= 0L) {
        this.g = false;
      }
      this.b = paramLong;
    }
    
    public void a(String paramString)
    {
      this.c = new File(paramString);
    }
    
    public void a(boolean paramBoolean)
    {
      this.f = paramBoolean;
    }
    
    public void b(String paramString)
    {
      this.c = eb.a(lq.a, this.j, paramString);
    }
    
    public void b(boolean paramBoolean)
    {
      this.g = paramBoolean;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */