package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

public class fo
  extends fu
{
  private boolean h = false;
  private boolean i = true;
  
  public fo(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext, paramString1, paramString2, paramString3);
  }
  
  private void a(File paramFile1, File paramFile2)
  {
    for (;;)
    {
      int j;
      int k;
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(paramFile1);
        localFileInputStream.read(new byte[32]);
        paramFile2 = new RandomAccessFile(paramFile2, "rw");
        byte[] arrayOfByte1 = new byte['Ѐ'];
        j = 0;
        k = localFileInputStream.read(arrayOfByte1);
        if (k > 0)
        {
          if (k == 1024)
          {
            paramFile2.seek(j);
            paramFile2.write(arrayOfByte1);
          }
          else
          {
            byte[] arrayOfByte2 = new byte[k];
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, k);
            paramFile2.seek(j);
            paramFile2.write(arrayOfByte2);
          }
        }
        else
        {
          localFileInputStream.close();
          paramFile2.close();
          paramFile1.delete();
          return;
        }
      }
      catch (Throwable paramFile1)
      {
        paramFile1.printStackTrace();
        return;
      }
      j += k;
    }
  }
  
  public void a()
  {
    if ((this.a != null) && (!TextUtils.isEmpty(this.a.getURL())) && (this.a.getURL().endsWith("png")))
    {
      if (!this.a.getURL().contains(fw.a(this.f))) {
        return;
      }
      if (fw.b(this.f)) {
        return;
      }
      if ((!this.h) && (fw.a(this.f, this.i))) {
        return;
      }
      if (g) {
        return;
      }
      if (new File(this.d).exists()) {
        return;
      }
      start();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void onFinish()
  {
    try
    {
      if (this.b != null) {
        this.b.close();
      }
      Object localObject = fs.a(this.c);
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(this.e)))
      {
        localObject = new File(this.d);
        if (((File)localObject).exists())
        {
          b();
          return;
        }
        localFile = new File(this.c);
        if (!localFile.exists()) {
          return;
        }
        a(localFile, (File)localObject);
        b();
        return;
      }
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      b();
      File localFile = new File(this.d);
      if (localFile.exists()) {
        localFile.delete();
      }
      gg.a(localThrowable, "sdl", "ofs");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */