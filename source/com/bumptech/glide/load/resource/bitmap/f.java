package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.h.h;
import com.bumptech.glide.load.b.a.c;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

public abstract class f
  implements a<InputStream>
{
  public static final f a = new f()
  {
    protected int a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      return Math.min(paramAnonymousInt2 / paramAnonymousInt4, paramAnonymousInt1 / paramAnonymousInt3);
    }
    
    public String a()
    {
      return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
    }
  };
  public static final f b = new f()
  {
    protected int a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      paramAnonymousInt3 = (int)Math.ceil(Math.max(paramAnonymousInt2 / paramAnonymousInt4, paramAnonymousInt1 / paramAnonymousInt3));
      paramAnonymousInt2 = Integer.highestOneBit(paramAnonymousInt3);
      paramAnonymousInt1 = 1;
      paramAnonymousInt2 = Math.max(1, paramAnonymousInt2);
      if (paramAnonymousInt2 >= paramAnonymousInt3) {
        paramAnonymousInt1 = 0;
      }
      return paramAnonymousInt2 << paramAnonymousInt1;
    }
    
    public String a()
    {
      return "AT_MOST.com.bumptech.glide.load.data.bitmap";
    }
  };
  public static final f c = new f()
  {
    protected int a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      return 0;
    }
    
    public String a()
    {
      return "NONE.com.bumptech.glide.load.data.bitmap";
    }
  };
  private static final Set<ImageHeaderParser.ImageType> d = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);
  private static final Queue<BitmapFactory.Options> e = h.a(0);
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt5;
    if (paramInt5 == Integer.MIN_VALUE) {
      i = paramInt3;
    }
    paramInt5 = paramInt4;
    if (paramInt4 == Integer.MIN_VALUE) {
      paramInt5 = paramInt2;
    }
    if ((paramInt1 != 90) && (paramInt1 != 270)) {
      paramInt1 = a(paramInt2, paramInt3, paramInt5, i);
    } else {
      paramInt1 = a(paramInt3, paramInt2, paramInt5, i);
    }
    if (paramInt1 == 0) {
      paramInt1 = 0;
    } else {
      paramInt1 = Integer.highestOneBit(paramInt1);
    }
    return Math.max(1, paramInt1);
  }
  
  /* Error */
  private static android.graphics.Bitmap.Config a(InputStream paramInputStream, com.bumptech.glide.load.a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: getstatic 91	com/bumptech/glide/load/a:ALWAYS_ARGB_8888	Lcom/bumptech/glide/load/a;
    //   4: if_acmpeq +195 -> 199
    //   7: aload_1
    //   8: getstatic 94	com/bumptech/glide/load/a:PREFER_ARGB_8888	Lcom/bumptech/glide/load/a;
    //   11: if_acmpeq +188 -> 199
    //   14: getstatic 100	android/os/Build$VERSION:SDK_INT	I
    //   17: bipush 16
    //   19: if_icmpne +6 -> 25
    //   22: goto +177 -> 199
    //   25: iconst_0
    //   26: istore_3
    //   27: aload_0
    //   28: sipush 1024
    //   31: invokevirtual 106	java/io/InputStream:mark	(I)V
    //   34: new 108	com/bumptech/glide/load/resource/bitmap/ImageHeaderParser
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 111	com/bumptech/glide/load/resource/bitmap/ImageHeaderParser:<init>	(Ljava/io/InputStream;)V
    //   42: invokevirtual 114	com/bumptech/glide/load/resource/bitmap/ImageHeaderParser:a	()Z
    //   45: istore_2
    //   46: aload_0
    //   47: invokevirtual 117	java/io/InputStream:reset	()V
    //   50: goto +22 -> 72
    //   53: astore_0
    //   54: ldc 119
    //   56: iconst_5
    //   57: invokestatic 125	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   60: ifeq +12 -> 72
    //   63: ldc 119
    //   65: ldc 127
    //   67: aload_0
    //   68: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   71: pop
    //   72: goto +87 -> 159
    //   75: astore_1
    //   76: goto +95 -> 171
    //   79: astore 4
    //   81: ldc 119
    //   83: iconst_5
    //   84: invokestatic 125	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   87: ifeq +40 -> 127
    //   90: new 133	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   97: astore 5
    //   99: aload 5
    //   101: ldc -120
    //   103: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 5
    //   109: aload_1
    //   110: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: ldc 119
    //   116: aload 5
    //   118: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aload 4
    //   123: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   126: pop
    //   127: aload_0
    //   128: invokevirtual 117	java/io/InputStream:reset	()V
    //   131: iload_3
    //   132: istore_2
    //   133: goto +26 -> 159
    //   136: astore_0
    //   137: iload_3
    //   138: istore_2
    //   139: ldc 119
    //   141: iconst_5
    //   142: invokestatic 125	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   145: ifeq +14 -> 159
    //   148: ldc 119
    //   150: ldc 127
    //   152: aload_0
    //   153: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   156: pop
    //   157: iload_3
    //   158: istore_2
    //   159: iload_2
    //   160: ifeq +7 -> 167
    //   163: getstatic 153	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   166: areturn
    //   167: getstatic 156	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   170: areturn
    //   171: aload_0
    //   172: invokevirtual 117	java/io/InputStream:reset	()V
    //   175: goto +22 -> 197
    //   178: astore_0
    //   179: ldc 119
    //   181: iconst_5
    //   182: invokestatic 125	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   185: ifeq +12 -> 197
    //   188: ldc 119
    //   190: ldc 127
    //   192: aload_0
    //   193: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   196: pop
    //   197: aload_1
    //   198: athrow
    //   199: getstatic 153	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   202: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramInputStream	InputStream
    //   0	203	1	parama	com.bumptech.glide.load.a
    //   45	115	2	bool1	boolean
    //   26	132	3	bool2	boolean
    //   79	43	4	localIOException	IOException
    //   97	20	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   46	50	53	java/io/IOException
    //   34	46	75	finally
    //   81	127	75	finally
    //   34	46	79	java/io/IOException
    //   127	131	136	java/io/IOException
    //   171	175	178	java/io/IOException
  }
  
  private Bitmap a(com.bumptech.glide.h.f paramf, n paramn, BitmapFactory.Options paramOptions, c paramc, int paramInt1, int paramInt2, int paramInt3, com.bumptech.glide.load.a parama)
  {
    parama = a(paramf, parama);
    paramOptions.inSampleSize = paramInt3;
    paramOptions.inPreferredConfig = parama;
    if (((paramOptions.inSampleSize == 1) || (19 <= Build.VERSION.SDK_INT)) && (a(paramf)))
    {
      double d2 = paramInt1;
      double d1 = paramInt3;
      Double.isNaN(d2);
      Double.isNaN(d1);
      paramInt1 = (int)Math.ceil(d2 / d1);
      d2 = paramInt2;
      Double.isNaN(d2);
      Double.isNaN(d1);
      a(paramOptions, paramc.b(paramInt1, (int)Math.ceil(d2 / d1), parama));
    }
    return b(paramf, paramn, paramOptions);
  }
  
  private static void a(BitmapFactory.Options paramOptions)
  {
    b(paramOptions);
    synchronized (e)
    {
      e.offer(paramOptions);
      return;
    }
  }
  
  @TargetApi(11)
  private static void a(BitmapFactory.Options paramOptions, Bitmap paramBitmap)
  {
    if (11 <= Build.VERSION.SDK_INT) {
      paramOptions.inBitmap = paramBitmap;
    }
  }
  
  /* Error */
  private static boolean a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: bipush 19
    //   2: getstatic 100	android/os/Build$VERSION:SDK_INT	I
    //   5: if_icmpgt +5 -> 10
    //   8: iconst_1
    //   9: ireturn
    //   10: aload_0
    //   11: sipush 1024
    //   14: invokevirtual 106	java/io/InputStream:mark	(I)V
    //   17: new 108	com/bumptech/glide/load/resource/bitmap/ImageHeaderParser
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 111	com/bumptech/glide/load/resource/bitmap/ImageHeaderParser:<init>	(Ljava/io/InputStream;)V
    //   25: invokevirtual 211	com/bumptech/glide/load/resource/bitmap/ImageHeaderParser:b	()Lcom/bumptech/glide/load/resource/bitmap/ImageHeaderParser$ImageType;
    //   28: astore_2
    //   29: getstatic 45	com/bumptech/glide/load/resource/bitmap/f:d	Ljava/util/Set;
    //   32: aload_2
    //   33: invokeinterface 216 2 0
    //   38: istore_1
    //   39: aload_0
    //   40: invokevirtual 117	java/io/InputStream:reset	()V
    //   43: iload_1
    //   44: ireturn
    //   45: astore_0
    //   46: ldc 119
    //   48: iconst_5
    //   49: invokestatic 125	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   52: ifeq +12 -> 64
    //   55: ldc 119
    //   57: ldc 127
    //   59: aload_0
    //   60: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   63: pop
    //   64: iload_1
    //   65: ireturn
    //   66: astore_2
    //   67: goto +50 -> 117
    //   70: astore_2
    //   71: ldc 119
    //   73: iconst_5
    //   74: invokestatic 125	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   77: ifeq +12 -> 89
    //   80: ldc 119
    //   82: ldc -38
    //   84: aload_2
    //   85: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   88: pop
    //   89: aload_0
    //   90: invokevirtual 117	java/io/InputStream:reset	()V
    //   93: goto +22 -> 115
    //   96: astore_0
    //   97: ldc 119
    //   99: iconst_5
    //   100: invokestatic 125	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   103: ifeq +12 -> 115
    //   106: ldc 119
    //   108: ldc 127
    //   110: aload_0
    //   111: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   114: pop
    //   115: iconst_0
    //   116: ireturn
    //   117: aload_0
    //   118: invokevirtual 117	java/io/InputStream:reset	()V
    //   121: goto +22 -> 143
    //   124: astore_0
    //   125: ldc 119
    //   127: iconst_5
    //   128: invokestatic 125	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   131: ifeq +12 -> 143
    //   134: ldc 119
    //   136: ldc 127
    //   138: aload_0
    //   139: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   142: pop
    //   143: aload_2
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramInputStream	InputStream
    //   38	27	1	bool	boolean
    //   28	5	2	localImageType	ImageHeaderParser.ImageType
    //   66	1	2	localObject	Object
    //   70	74	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   39	43	45	java/io/IOException
    //   17	39	66	finally
    //   71	89	66	finally
    //   17	39	70	java/io/IOException
    //   89	93	96	java/io/IOException
    //   117	121	124	java/io/IOException
  }
  
  private static Bitmap b(com.bumptech.glide.h.f paramf, n paramn, BitmapFactory.Options paramOptions)
  {
    if (paramOptions.inJustDecodeBounds) {
      paramf.mark(5242880);
    } else {
      paramn.a();
    }
    paramn = BitmapFactory.decodeStream(paramf, null, paramOptions);
    try
    {
      if (paramOptions.inJustDecodeBounds)
      {
        paramf.reset();
        return paramn;
      }
    }
    catch (IOException paramf)
    {
      if (Log.isLoggable("Downsampler", 6))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exception loading inDecodeBounds=");
        localStringBuilder.append(paramOptions.inJustDecodeBounds);
        localStringBuilder.append(" sample=");
        localStringBuilder.append(paramOptions.inSampleSize);
        Log.e("Downsampler", localStringBuilder.toString(), paramf);
      }
    }
    return paramn;
  }
  
  /* Error */
  @TargetApi(11)
  private static BitmapFactory.Options b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 52	com/bumptech/glide/load/resource/bitmap/f:e	Ljava/util/Queue;
    //   6: astore_0
    //   7: aload_0
    //   8: monitorenter
    //   9: getstatic 52	com/bumptech/glide/load/resource/bitmap/f:e	Ljava/util/Queue;
    //   12: invokeinterface 254 1 0
    //   17: checkcast 161	android/graphics/BitmapFactory$Options
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: astore_0
    //   25: aload_1
    //   26: ifnonnull +15 -> 41
    //   29: new 161	android/graphics/BitmapFactory$Options
    //   32: dup
    //   33: invokespecial 255	android/graphics/BitmapFactory$Options:<init>	()V
    //   36: astore_0
    //   37: aload_0
    //   38: invokestatic 194	com/bumptech/glide/load/resource/bitmap/f:b	(Landroid/graphics/BitmapFactory$Options;)V
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: areturn
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   51	5	0	localObject2	Object
    //   20	6	1	localOptions	BitmapFactory.Options
    //   46	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	23	46	finally
    //   47	49	46	finally
    //   3	9	51	finally
    //   29	41	51	finally
    //   49	51	51	finally
  }
  
  @TargetApi(11)
  private static void b(BitmapFactory.Options paramOptions)
  {
    paramOptions.inTempStorage = null;
    paramOptions.inDither = false;
    paramOptions.inScaled = false;
    paramOptions.inSampleSize = 1;
    paramOptions.inPreferredConfig = null;
    paramOptions.inJustDecodeBounds = false;
    paramOptions.outWidth = 0;
    paramOptions.outHeight = 0;
    paramOptions.outMimeType = null;
    if (11 <= Build.VERSION.SDK_INT)
    {
      paramOptions.inBitmap = null;
      paramOptions.inMutable = true;
    }
  }
  
  protected abstract int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  /* Error */
  public Bitmap a(InputStream paramInputStream, c paramc, int paramInt1, int paramInt2, com.bumptech.glide.load.a parama)
  {
    // Byte code:
    //   0: invokestatic 284	com/bumptech/glide/h/a:a	()Lcom/bumptech/glide/h/a;
    //   3: astore 9
    //   5: aload 9
    //   7: invokevirtual 287	com/bumptech/glide/h/a:b	()[B
    //   10: astore 10
    //   12: aload 9
    //   14: invokevirtual 287	com/bumptech/glide/h/a:b	()[B
    //   17: astore 11
    //   19: invokestatic 289	com/bumptech/glide/load/resource/bitmap/f:b	()Landroid/graphics/BitmapFactory$Options;
    //   22: astore 12
    //   24: new 228	com/bumptech/glide/load/resource/bitmap/n
    //   27: dup
    //   28: aload_1
    //   29: aload 11
    //   31: invokespecial 292	com/bumptech/glide/load/resource/bitmap/n:<init>	(Ljava/io/InputStream;[B)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokestatic 297	com/bumptech/glide/h/c:a	(Ljava/io/InputStream;)Lcom/bumptech/glide/h/c;
    //   39: astore 13
    //   41: new 225	com/bumptech/glide/h/f
    //   44: dup
    //   45: aload 13
    //   47: invokespecial 298	com/bumptech/glide/h/f:<init>	(Ljava/io/InputStream;)V
    //   50: astore 14
    //   52: aload 13
    //   54: ldc -33
    //   56: invokevirtual 299	com/bumptech/glide/h/c:mark	(I)V
    //   59: new 108	com/bumptech/glide/load/resource/bitmap/ImageHeaderParser
    //   62: dup
    //   63: aload 13
    //   65: invokespecial 111	com/bumptech/glide/load/resource/bitmap/ImageHeaderParser:<init>	(Ljava/io/InputStream;)V
    //   68: invokevirtual 302	com/bumptech/glide/load/resource/bitmap/ImageHeaderParser:c	()I
    //   71: istore 6
    //   73: aload 13
    //   75: invokevirtual 303	com/bumptech/glide/h/c:reset	()V
    //   78: goto +24 -> 102
    //   81: astore 15
    //   83: ldc 119
    //   85: iconst_5
    //   86: invokestatic 125	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   89: ifeq +13 -> 102
    //   92: ldc 119
    //   94: ldc 127
    //   96: aload 15
    //   98: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   101: pop
    //   102: goto +61 -> 163
    //   105: astore_1
    //   106: goto +220 -> 326
    //   109: astore 15
    //   111: ldc 119
    //   113: iconst_5
    //   114: invokestatic 125	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   117: ifeq +14 -> 131
    //   120: ldc 119
    //   122: ldc_w 305
    //   125: aload 15
    //   127: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   130: pop
    //   131: aload 13
    //   133: invokevirtual 303	com/bumptech/glide/h/c:reset	()V
    //   136: goto +248 -> 384
    //   139: astore 15
    //   141: ldc 119
    //   143: iconst_5
    //   144: invokestatic 125	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   147: ifeq +237 -> 384
    //   150: ldc 119
    //   152: ldc 127
    //   154: aload 15
    //   156: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   159: pop
    //   160: goto +224 -> 384
    //   163: aload 12
    //   165: aload 10
    //   167: putfield 259	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   170: aload_0
    //   171: aload 14
    //   173: aload_1
    //   174: aload 12
    //   176: invokevirtual 308	com/bumptech/glide/load/resource/bitmap/f:a	(Lcom/bumptech/glide/h/f;Lcom/bumptech/glide/load/resource/bitmap/n;Landroid/graphics/BitmapFactory$Options;)[I
    //   179: astore 15
    //   181: aload 15
    //   183: iconst_0
    //   184: iaload
    //   185: istore 7
    //   187: aload 15
    //   189: iconst_1
    //   190: iaload
    //   191: istore 8
    //   193: aload_0
    //   194: aload 14
    //   196: aload_1
    //   197: aload 12
    //   199: aload_2
    //   200: iload 7
    //   202: iload 8
    //   204: aload_0
    //   205: iload 6
    //   207: invokestatic 312	com/bumptech/glide/load/resource/bitmap/q:a	(I)I
    //   210: iload 7
    //   212: iload 8
    //   214: iload_3
    //   215: iload 4
    //   217: invokespecial 314	com/bumptech/glide/load/resource/bitmap/f:a	(IIIII)I
    //   220: aload 5
    //   222: invokespecial 316	com/bumptech/glide/load/resource/bitmap/f:a	(Lcom/bumptech/glide/h/f;Lcom/bumptech/glide/load/resource/bitmap/n;Landroid/graphics/BitmapFactory$Options;Lcom/bumptech/glide/load/b/a/c;IIILcom/bumptech/glide/load/a;)Landroid/graphics/Bitmap;
    //   225: astore 14
    //   227: aload 13
    //   229: invokevirtual 319	com/bumptech/glide/h/c:a	()Ljava/io/IOException;
    //   232: astore_1
    //   233: aload_1
    //   234: ifnonnull +83 -> 317
    //   237: aconst_null
    //   238: astore_1
    //   239: aload 14
    //   241: ifnull +48 -> 289
    //   244: aload 14
    //   246: aload_2
    //   247: iload 6
    //   249: invokestatic 322	com/bumptech/glide/load/resource/bitmap/q:a	(Landroid/graphics/Bitmap;Lcom/bumptech/glide/load/b/a/c;I)Landroid/graphics/Bitmap;
    //   252: astore 5
    //   254: aload 5
    //   256: astore_1
    //   257: aload 14
    //   259: aload 5
    //   261: invokevirtual 325	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   264: ifne +25 -> 289
    //   267: aload 5
    //   269: astore_1
    //   270: aload_2
    //   271: aload 14
    //   273: invokeinterface 328 2 0
    //   278: ifne +11 -> 289
    //   281: aload 14
    //   283: invokevirtual 333	android/graphics/Bitmap:recycle	()V
    //   286: aload 5
    //   288: astore_1
    //   289: aload 9
    //   291: aload 10
    //   293: invokevirtual 336	com/bumptech/glide/h/a:a	([B)Z
    //   296: pop
    //   297: aload 9
    //   299: aload 11
    //   301: invokevirtual 336	com/bumptech/glide/h/a:a	([B)Z
    //   304: pop
    //   305: aload 13
    //   307: invokevirtual 338	com/bumptech/glide/h/c:b	()V
    //   310: aload 12
    //   312: invokestatic 340	com/bumptech/glide/load/resource/bitmap/f:a	(Landroid/graphics/BitmapFactory$Options;)V
    //   315: aload_1
    //   316: areturn
    //   317: new 342	java/lang/RuntimeException
    //   320: dup
    //   321: aload_1
    //   322: invokespecial 345	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   325: athrow
    //   326: aload 13
    //   328: invokevirtual 303	com/bumptech/glide/h/c:reset	()V
    //   331: goto +22 -> 353
    //   334: astore_2
    //   335: ldc 119
    //   337: iconst_5
    //   338: invokestatic 125	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   341: ifeq +12 -> 353
    //   344: ldc 119
    //   346: ldc 127
    //   348: aload_2
    //   349: invokestatic 131	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   352: pop
    //   353: aload_1
    //   354: athrow
    //   355: astore_1
    //   356: aload 9
    //   358: aload 10
    //   360: invokevirtual 336	com/bumptech/glide/h/a:a	([B)Z
    //   363: pop
    //   364: aload 9
    //   366: aload 11
    //   368: invokevirtual 336	com/bumptech/glide/h/a:a	([B)Z
    //   371: pop
    //   372: aload 13
    //   374: invokevirtual 338	com/bumptech/glide/h/c:b	()V
    //   377: aload 12
    //   379: invokestatic 340	com/bumptech/glide/load/resource/bitmap/f:a	(Landroid/graphics/BitmapFactory$Options;)V
    //   382: aload_1
    //   383: athrow
    //   384: iconst_0
    //   385: istore 6
    //   387: goto -224 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	this	f
    //   0	390	1	paramInputStream	InputStream
    //   0	390	2	paramc	c
    //   0	390	3	paramInt1	int
    //   0	390	4	paramInt2	int
    //   0	390	5	parama	com.bumptech.glide.load.a
    //   71	315	6	i	int
    //   185	26	7	j	int
    //   191	22	8	k	int
    //   3	362	9	locala	com.bumptech.glide.h.a
    //   10	349	10	arrayOfByte1	byte[]
    //   17	350	11	arrayOfByte2	byte[]
    //   22	356	12	localOptions	BitmapFactory.Options
    //   39	334	13	localc	com.bumptech.glide.h.c
    //   50	232	14	localObject	Object
    //   81	16	15	localIOException1	IOException
    //   109	17	15	localIOException2	IOException
    //   139	16	15	localIOException3	IOException
    //   179	9	15	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   73	78	81	java/io/IOException
    //   59	73	105	finally
    //   111	131	105	finally
    //   59	73	109	java/io/IOException
    //   131	136	139	java/io/IOException
    //   326	331	334	java/io/IOException
    //   52	59	355	finally
    //   73	78	355	finally
    //   83	102	355	finally
    //   131	136	355	finally
    //   141	160	355	finally
    //   163	181	355	finally
    //   193	233	355	finally
    //   244	254	355	finally
    //   257	267	355	finally
    //   270	286	355	finally
    //   317	326	355	finally
    //   326	331	355	finally
    //   335	353	355	finally
    //   353	355	355	finally
  }
  
  public int[] a(com.bumptech.glide.h.f paramf, n paramn, BitmapFactory.Options paramOptions)
  {
    paramOptions.inJustDecodeBounds = true;
    b(paramf, paramn, paramOptions);
    paramOptions.inJustDecodeBounds = false;
    return new int[] { paramOptions.outWidth, paramOptions.outHeight };
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */