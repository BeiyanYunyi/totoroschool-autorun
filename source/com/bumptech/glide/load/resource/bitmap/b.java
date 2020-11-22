package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.bumptech.glide.h.d;
import com.bumptech.glide.h.h;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.f;
import java.io.OutputStream;

public class b
  implements f<Bitmap>
{
  private Bitmap.CompressFormat a;
  private int b;
  
  public b()
  {
    this(null, 90);
  }
  
  public b(Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    this.a = paramCompressFormat;
    this.b = paramInt;
  }
  
  private Bitmap.CompressFormat a(Bitmap paramBitmap)
  {
    if (this.a != null) {
      return this.a;
    }
    if (paramBitmap.hasAlpha()) {
      return Bitmap.CompressFormat.PNG;
    }
    return Bitmap.CompressFormat.JPEG;
  }
  
  public String a()
  {
    return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
  }
  
  public boolean a(k<Bitmap> paramk, OutputStream paramOutputStream)
  {
    paramk = (Bitmap)paramk.b();
    long l = d.a();
    Bitmap.CompressFormat localCompressFormat = a(paramk);
    paramk.compress(localCompressFormat, this.b, paramOutputStream);
    if (Log.isLoggable("BitmapEncoder", 2))
    {
      paramOutputStream = new StringBuilder();
      paramOutputStream.append("Compressed with type: ");
      paramOutputStream.append(localCompressFormat);
      paramOutputStream.append(" of size ");
      paramOutputStream.append(h.a(paramk));
      paramOutputStream.append(" in ");
      paramOutputStream.append(d.a(l));
      Log.v("BitmapEncoder", paramOutputStream.toString());
    }
    return true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */