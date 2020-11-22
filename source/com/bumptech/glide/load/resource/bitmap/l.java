package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.e;
import java.io.IOException;
import java.io.InputStream;

public class l
  implements e<g, Bitmap>
{
  private final e<InputStream, Bitmap> a;
  private final e<ParcelFileDescriptor, Bitmap> b;
  
  public l(e<InputStream, Bitmap> parame, e<ParcelFileDescriptor, Bitmap> parame1)
  {
    this.a = parame;
    this.b = parame1;
  }
  
  public k<Bitmap> a(g paramg, int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject1 = paramg.a();
    Object localObject2;
    if (localObject1 != null) {
      try
      {
        localObject1 = this.a.a(localObject1, paramInt1, paramInt2);
      }
      catch (IOException localIOException)
      {
        if (Log.isLoggable("ImageVideoDecoder", 2)) {
          Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", localIOException);
        }
      }
    } else {
      localObject2 = null;
    }
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      paramg = paramg.b();
      localObject3 = localObject2;
      if (paramg != null) {
        localObject3 = this.b.a(paramg, paramInt1, paramInt2);
      }
    }
    return (k<Bitmap>)localObject3;
  }
  
  public String a()
  {
    return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */