package com.amap.api.mapcore.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class av
{
  private float a(long paramLong1, long paramLong2)
  {
    return (float)paramLong1 / (float)paramLong2 * 100.0F;
  }
  
  public long a(File paramFile1, File paramFile2, long paramLong1, long paramLong2, a parama)
  {
    if (paramLong1 == 0L)
    {
      if (parama != null) {
        parama.a("", "", -1);
      }
      return 0L;
    }
    String str1 = paramFile1.getAbsolutePath();
    String str2 = paramFile2.getAbsolutePath();
    label430:
    label453:
    for (;;)
    {
      try
      {
        boolean bool = paramFile1.isDirectory();
        int i = 0;
        long l;
        if (bool)
        {
          if ((!paramFile2.exists()) && (!paramFile2.mkdirs()))
          {
            paramFile1 = new StringBuilder();
            paramFile1.append("Cannot create dir ");
            paramFile1.append(paramFile2.getAbsolutePath());
            throw new IOException(paramFile1.toString());
          }
          localObject = paramFile1.list();
          if (localObject != null)
          {
            l = paramLong1;
            try
            {
              if (i >= localObject.length) {
                continue;
              }
              l = a(new File(paramFile1, localObject[i]), new File(new File(paramFile2, paramFile1.getName()), localObject[i]), paramLong1, paramLong2, parama);
              i += 1;
              paramLong1 = l;
            }
            catch (Exception paramFile1)
            {
              break label430;
            }
          }
          l = paramLong1;
          return l;
        }
        Object localObject = paramFile2.getParentFile();
        if ((localObject != null) && (!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
        {
          paramFile1 = new StringBuilder();
          paramFile1.append("Cannot create dir ");
          paramFile1.append(((File)localObject).getAbsolutePath());
          throw new IOException(paramFile1.toString());
        }
        if ((parama != null) && (paramLong1 <= 0L)) {
          parama.a(str1, str2);
        }
        paramFile1 = new FileInputStream(paramFile1);
        paramFile2 = new FileOutputStream(paramFile2);
        localObject = new byte['Ѐ'];
        try
        {
          i = paramFile1.read((byte[])localObject);
          if (i > 0)
          {
            paramFile2.write((byte[])localObject, 0, i);
            paramLong1 += i;
            if (parama == null) {
              break label453;
            }
            l = paramLong1;
          }
          try
          {
            parama.a(str1, str2, a(paramLong1, paramLong2));
          }
          catch (Exception paramFile1)
          {
            paramLong1 = l;
            continue;
          }
          l = paramLong1;
          paramFile1.close();
          l = paramLong1;
          paramFile2.flush();
          l = paramLong1;
          paramFile2.close();
          if ((parama != null) && (paramLong1 >= paramLong2 - 1L))
          {
            l = paramLong1;
            parama.b(str1, str2);
          }
          return paramLong1;
        }
        catch (Exception paramFile1) {}
      }
      catch (Exception paramFile1) {}
      paramFile1.printStackTrace();
      if (parama != null) {
        parama.a(str1, str2, -1);
      }
      return paramLong1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2);
    
    public abstract void a(String paramString1, String paramString2, float paramFloat);
    
    public abstract void a(String paramString1, String paramString2, int paramInt);
    
    public abstract void b(String paramString1, String paramString2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */