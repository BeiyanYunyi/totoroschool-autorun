package com.shockwave.pdfium;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PdfiumCore
{
  private static final String a = "com.shockwave.pdfium.PdfiumCore";
  private static final Class b = FileDescriptor.class;
  private static Field c = null;
  private static final Object e = new Object();
  private int d;
  
  static
  {
    try
    {
      System.loadLibrary("modpng");
      System.loadLibrary("modft2");
      System.loadLibrary("modpdfium");
      System.loadLibrary("jniPdfium");
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Native libraries failed to load - ");
      localStringBuilder.append(localUnsatisfiedLinkError);
      Log.e(str, localStringBuilder.toString());
    }
  }
  
  public PdfiumCore(Context paramContext)
  {
    this.d = paramContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  public static int a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      if (c == null)
      {
        c = b.getDeclaredField("descriptor");
        c.setAccessible(true);
      }
      int i = c.getInt(paramParcelFileDescriptor.getFileDescriptor());
      return i;
    }
    catch (IllegalAccessException paramParcelFileDescriptor)
    {
      paramParcelFileDescriptor.printStackTrace();
      return -1;
    }
    catch (NoSuchFieldException paramParcelFileDescriptor)
    {
      paramParcelFileDescriptor.printStackTrace();
    }
    return -1;
  }
  
  private void a(List<a.a> paramList, a parama, long paramLong)
  {
    Object localObject = new a.a();
    ((a.a)localObject).c = paramLong;
    ((a.a)localObject).a = nativeGetBookmarkTitle(paramLong);
    ((a.a)localObject).b = nativeGetBookmarkDestIndex(parama.a, paramLong);
    paramList.add(localObject);
    Long localLong = nativeGetFirstChildBookmark(parama.a, Long.valueOf(paramLong));
    if (localLong != null) {
      a(((a.a)localObject).a(), parama, localLong.longValue());
    }
    localObject = nativeGetSiblingBookmark(parama.a, paramLong);
    if (localObject != null) {
      a(paramList, parama, ((Long)localObject).longValue());
    }
  }
  
  private native void nativeCloseDocument(long paramLong);
  
  private native void nativeClosePage(long paramLong);
  
  private native long nativeGetBookmarkDestIndex(long paramLong1, long paramLong2);
  
  private native String nativeGetBookmarkTitle(long paramLong);
  
  private native String nativeGetDocumentMetaText(long paramLong, String paramString);
  
  private native Long nativeGetFirstChildBookmark(long paramLong, Long paramLong1);
  
  private native int nativeGetPageCount(long paramLong);
  
  private native int nativeGetPageHeightPixel(long paramLong, int paramInt);
  
  private native int nativeGetPageWidthPixel(long paramLong, int paramInt);
  
  private native Long nativeGetSiblingBookmark(long paramLong1, long paramLong2);
  
  private native long nativeLoadPage(long paramLong, int paramInt);
  
  private native long nativeOpenDocument(int paramInt, String paramString);
  
  private native long nativeOpenMemDocument(byte[] paramArrayOfByte, String paramString);
  
  private native void nativeRenderPageBitmap(long paramLong, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean);
  
  public int a(a parama)
  {
    synchronized (e)
    {
      int i = nativeGetPageCount(parama.a);
      return i;
    }
  }
  
  public long a(a parama, int paramInt)
  {
    synchronized (e)
    {
      long l = nativeLoadPage(parama.a, paramInt);
      parama.c.put(Integer.valueOf(paramInt), Long.valueOf(l));
      return l;
    }
  }
  
  public a a(ParcelFileDescriptor paramParcelFileDescriptor, String paramString)
    throws IOException
  {
    a locala = new a();
    locala.b = paramParcelFileDescriptor;
    synchronized (e)
    {
      locala.a = nativeOpenDocument(a(paramParcelFileDescriptor), paramString);
      return locala;
    }
  }
  
  public a a(byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    a locala = new a();
    synchronized (e)
    {
      locala.a = nativeOpenMemDocument(paramArrayOfByte, paramString);
      return locala;
    }
  }
  
  /* Error */
  public void a(a parama, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 68	com/shockwave/pdfium/PdfiumCore:e	Ljava/lang/Object;
    //   3: astore 11
    //   5: aload 11
    //   7: monitorenter
    //   8: aload_1
    //   9: getfield 202	com/shockwave/pdfium/a:c	Ljava/util/Map;
    //   12: iload_3
    //   13: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 237 2 0
    //   21: checkcast 152	java/lang/Long
    //   24: invokevirtual 167	java/lang/Long:longValue	()J
    //   27: lstore 9
    //   29: aload_0
    //   30: lload 9
    //   32: aload_2
    //   33: aload_0
    //   34: getfield 89	com/shockwave/pdfium/PdfiumCore:d	I
    //   37: iload 4
    //   39: iload 5
    //   41: iload 6
    //   43: iload 7
    //   45: iload 8
    //   47: invokespecial 239	com/shockwave/pdfium/PdfiumCore:nativeRenderPageBitmap	(JLandroid/graphics/Bitmap;IIIIIZ)V
    //   50: goto +45 -> 95
    //   53: astore_1
    //   54: goto +12 -> 66
    //   57: astore_1
    //   58: goto +24 -> 82
    //   61: astore_1
    //   62: goto +37 -> 99
    //   65: astore_1
    //   66: getstatic 36	com/shockwave/pdfium/PdfiumCore:a	Ljava/lang/String;
    //   69: ldc -15
    //   71: invokestatic 59	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   74: pop
    //   75: aload_1
    //   76: invokevirtual 242	java/lang/Exception:printStackTrace	()V
    //   79: goto +16 -> 95
    //   82: getstatic 36	com/shockwave/pdfium/PdfiumCore:a	Ljava/lang/String;
    //   85: ldc -12
    //   87: invokestatic 59	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   90: pop
    //   91: aload_1
    //   92: invokevirtual 245	java/lang/NullPointerException:printStackTrace	()V
    //   95: aload 11
    //   97: monitorexit
    //   98: return
    //   99: aload 11
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    //   104: astore_1
    //   105: goto -23 -> 82
    //   108: astore_1
    //   109: goto -10 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	PdfiumCore
    //   0	112	1	parama	a
    //   0	112	2	paramBitmap	Bitmap
    //   0	112	3	paramInt1	int
    //   0	112	4	paramInt2	int
    //   0	112	5	paramInt3	int
    //   0	112	6	paramInt4	int
    //   0	112	7	paramInt5	int
    //   0	112	8	paramBoolean	boolean
    //   27	4	9	l	long
    // Exception table:
    //   from	to	target	type
    //   29	50	53	java/lang/Exception
    //   29	50	57	java/lang/NullPointerException
    //   8	29	61	finally
    //   8	29	65	java/lang/Exception
    //   8	29	104	java/lang/NullPointerException
    //   29	50	108	finally
    //   66	79	108	finally
    //   82	95	108	finally
    //   95	98	108	finally
    //   99	102	108	finally
  }
  
  public int b(a parama, int paramInt)
  {
    synchronized (e)
    {
      parama = (Long)parama.c.get(Integer.valueOf(paramInt));
      if (parama != null)
      {
        paramInt = nativeGetPageWidthPixel(parama.longValue(), this.d);
        return paramInt;
      }
      return 0;
    }
  }
  
  public void b(a parama)
  {
    synchronized (e)
    {
      Object localObject2 = parama.c.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject2).next();
        nativeClosePage(((Long)parama.c.get(localInteger)).longValue());
      }
      parama.c.clear();
      nativeCloseDocument(parama.a);
      localObject2 = parama.b;
      if (localObject2 == null) {}
    }
    try
    {
      parama.b.close();
      parama.b = null;
      return;
      parama = finally;
      throw parama;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public int c(a parama, int paramInt)
  {
    synchronized (e)
    {
      parama = (Long)parama.c.get(Integer.valueOf(paramInt));
      if (parama != null)
      {
        paramInt = nativeGetPageHeightPixel(parama.longValue(), this.d);
        return paramInt;
      }
      return 0;
    }
  }
  
  public a.b c(a parama)
  {
    synchronized (e)
    {
      a.b localb = new a.b();
      localb.a = nativeGetDocumentMetaText(parama.a, "Title");
      localb.b = nativeGetDocumentMetaText(parama.a, "Author");
      localb.c = nativeGetDocumentMetaText(parama.a, "Subject");
      localb.d = nativeGetDocumentMetaText(parama.a, "Keywords");
      localb.e = nativeGetDocumentMetaText(parama.a, "Creator");
      localb.f = nativeGetDocumentMetaText(parama.a, "Producer");
      localb.g = nativeGetDocumentMetaText(parama.a, "CreationDate");
      localb.h = nativeGetDocumentMetaText(parama.a, "ModDate");
      return localb;
    }
  }
  
  public List<a.a> d(a parama)
  {
    synchronized (e)
    {
      ArrayList localArrayList = new ArrayList();
      Long localLong = nativeGetFirstChildBookmark(parama.a, null);
      if (localLong != null) {
        a(localArrayList, parama, localLong.longValue());
      }
      return localArrayList;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\shockwave\pdfium\PdfiumCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */