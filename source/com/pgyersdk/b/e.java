package com.pgyersdk.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.pgyersdk.f.c;
import com.pgyersdk.f.f;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class e
{
  public static void a(Bitmap paramBitmap, Context paramContext, a parama)
  {
    paramContext = new File(c.a().d(paramContext));
    try
    {
      paramContext = File.createTempFile("feedback_", ".jpg", paramContext);
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      paramContext = null;
    }
    Object localObject;
    if (paramContext != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveScreeenShot image path:");
      ((StringBuilder)localObject).append(paramContext.toString());
      f.d("PgyerSDK", ((StringBuilder)localObject).toString());
    }
    else
    {
      f.d("PgyerSDK", "saveScreeenShot image path: NULL");
    }
    try
    {
      localObject = new BufferedOutputStream(new FileOutputStream(paramContext));
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
      ((BufferedOutputStream)localObject).flush();
      ((BufferedOutputStream)localObject).close();
      paramBitmap = Uri.fromFile(paramContext);
      if (paramContext != null)
      {
        parama.a(paramBitmap);
        return;
      }
      parama.a(new Throwable("ScreenShot Uri equal null"));
      return;
    }
    catch (IOException paramBitmap)
    {
      parama.a(paramBitmap);
    }
  }
  
  public static void a(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        int i = 0;
        while (i < arrayOfFile.length)
        {
          a(arrayOfFile[i]);
          i += 1;
        }
      }
      paramFile.delete();
    }
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = new File(paramString);
    int i;
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.listFiles();
      i = 0;
    }
    while (i < paramString.length)
    {
      a(paramString[i]);
      i += 1;
      continue;
      if (paramString.exists()) {
        a(paramString);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(Uri paramUri);
    
    public abstract void a(Throwable paramThrowable);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */