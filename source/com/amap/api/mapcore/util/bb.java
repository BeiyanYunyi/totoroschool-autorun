package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class bb
{
  private b a;
  
  public bb(ax paramax, aw paramaw)
  {
    this.a = new b(paramax, paramaw);
  }
  
  private static int a(File paramFile, ZipInputStream paramZipInputStream, long paramLong1, long paramLong2, c paramc, a parama)
    throws Exception
  {
    paramFile = new BufferedOutputStream(new FileOutputStream(paramFile));
    byte[] arrayOfByte = new byte['Ѐ'];
    int i = 0;
    for (;;)
    {
      int j = paramZipInputStream.read(arrayOfByte, 0, 1024);
      if (j == -1) {
        break;
      }
      if ((parama != null) && (parama.a))
      {
        paramFile.close();
        return i;
      }
      paramFile.write(arrayOfByte, 0, j);
      j = i + j;
      i = j;
      if (paramLong2 > 0L)
      {
        i = j;
        if (paramc != null)
        {
          long l = (j + paramLong1) * 100L / paramLong2;
          if (parama != null)
          {
            i = j;
            if (parama.a) {}
          }
          else
          {
            paramc.a(l);
            i = j;
          }
        }
      }
    }
    paramFile.close();
    return i;
  }
  
  private static void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    aw localaw = paramb.d();
    if (localaw != null) {
      localaw.q();
    }
    Object localObject1 = paramb.a();
    Object localObject2 = paramb.b();
    c local1;
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localObject1 = new File((String)localObject1);
      if (!((File)localObject1).exists())
      {
        if (paramb.e().a)
        {
          if (localaw != null) {
            localaw.s();
          }
        }
        else if (localaw != null) {
          localaw.r();
        }
        return;
      }
      localObject2 = new File((String)localObject2);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      local1 = new c()
      {
        public void a()
        {
          if (this.a != null) {
            this.a.r();
          }
        }
        
        public void a(long paramAnonymousLong)
        {
          try
          {
            if (this.a != null) {
              this.a.a(paramAnonymousLong);
            }
            return;
          }
          catch (Exception localException) {}
        }
      };
    }
    try
    {
      if ((paramb.e().a) && (localaw != null)) {
        localaw.s();
      }
      a((File)localObject1, (File)localObject2, local1, paramb);
      if (paramb.e().a)
      {
        if (localaw == null) {
          break label221;
        }
        localaw.s();
        return;
      }
      if (localaw == null) {
        break label221;
      }
      localaw.b(paramb.c());
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    if (paramb.e().a)
    {
      if (localaw != null) {
        localaw.s();
      }
    }
    else if (localaw != null) {
      localaw.r();
    }
    label221:
    return;
    if (paramb.e().a)
    {
      if (localaw != null) {
        localaw.s();
      }
    }
    else if (localaw != null) {
      localaw.r();
    }
  }
  
  private static void a(File paramFile)
  {
    paramFile = paramFile.getParentFile();
    if (!paramFile.exists())
    {
      a(paramFile);
      paramFile.mkdir();
    }
  }
  
  private static void a(File paramFile1, File paramFile2, c paramc, b paramb)
    throws Exception
  {
    Object localObject = new StringBuffer();
    a locala = paramb.e();
    long l2 = 0L;
    long l1 = l2;
    if (paramc != null)
    {
      l1 = l2;
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(paramFile1);
        l1 = l2;
        CheckedInputStream localCheckedInputStream = new CheckedInputStream(localFileInputStream, new CRC32());
        l1 = l2;
        ZipInputStream localZipInputStream = new ZipInputStream(localCheckedInputStream);
        for (;;)
        {
          l1 = l2;
          ZipEntry localZipEntry = localZipInputStream.getNextEntry();
          if (localZipEntry == null) {
            break;
          }
          if (locala != null)
          {
            l1 = l2;
            if (locala.a)
            {
              l1 = l2;
              localZipInputStream.closeEntry();
              l1 = l2;
              localZipInputStream.close();
              l1 = l2;
              localCheckedInputStream.close();
              l1 = l2;
              localFileInputStream.close();
              break;
            }
          }
          l1 = l2;
          if (!localZipEntry.isDirectory())
          {
            l1 = l2;
            if (!a(localZipEntry.getName()))
            {
              l1 = l2;
              paramc.a();
              break;
            }
            l1 = l2;
            ((StringBuffer)localObject).append(localZipEntry.getName());
            l1 = l2;
            ((StringBuffer)localObject).append(";");
          }
          l1 = l2;
          l2 += localZipEntry.getSize();
          l1 = l2;
          localZipInputStream.closeEntry();
        }
        l1 = l2;
        paramb.a(((StringBuffer)localObject).toString());
        l1 = l2;
        localZipInputStream.close();
        l1 = l2;
        localCheckedInputStream.close();
        l1 = l2;
        localFileInputStream.close();
        l1 = l2;
      }
      catch (Exception paramb)
      {
        paramb.printStackTrace();
      }
    }
    paramFile1 = new FileInputStream(paramFile1);
    paramb = new CheckedInputStream(paramFile1, new CRC32());
    localObject = new ZipInputStream(paramb);
    a(paramFile2, (ZipInputStream)localObject, l1, paramc, locala);
    ((ZipInputStream)localObject).close();
    paramb.close();
    paramFile1.close();
  }
  
  private static void a(File paramFile, ZipInputStream paramZipInputStream, long paramLong, c paramc, a parama)
    throws Exception
  {
    int i = 0;
    for (;;)
    {
      ZipEntry localZipEntry = paramZipInputStream.getNextEntry();
      if (localZipEntry == null) {
        break;
      }
      if ((parama != null) && (parama.a))
      {
        paramZipInputStream.closeEntry();
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile.getPath());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(localZipEntry.getName());
      localObject = ((StringBuilder)localObject).toString();
      if (!a(localZipEntry.getName()))
      {
        if (paramc != null) {
          paramc.a();
        }
        return;
      }
      localObject = new File((String)localObject);
      a((File)localObject);
      if (localZipEntry.isDirectory()) {
        ((File)localObject).mkdirs();
      } else {
        i += a((File)localObject, paramZipInputStream, i, paramLong, paramc, parama);
      }
      paramZipInputStream.closeEntry();
    }
  }
  
  private static boolean a(String paramString)
  {
    return (!paramString.contains("..")) && (!paramString.contains("/")) && (!paramString.contains("\\")) && (!paramString.contains("%"));
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.f();
    }
  }
  
  public void b()
  {
    if (this.a != null) {
      a(this.a);
    }
  }
  
  public static class a
  {
    public boolean a = false;
  }
  
  private static class b
  {
    private String a;
    private String b;
    private aw c = null;
    private bb.a d = new bb.a();
    private String e;
    
    public b(ax paramax, aw paramaw)
    {
      this.a = paramax.B();
      this.b = paramax.C();
      this.c = paramaw;
    }
    
    public String a()
    {
      return this.a;
    }
    
    public void a(String paramString)
    {
      if (paramString.length() > 1) {
        this.e = paramString;
      }
    }
    
    public String b()
    {
      return this.b;
    }
    
    public String c()
    {
      return this.e;
    }
    
    public aw d()
    {
      return this.c;
    }
    
    public bb.a e()
    {
      return this.d;
    }
    
    public void f()
    {
      this.d.a = true;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void a(long paramLong);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */