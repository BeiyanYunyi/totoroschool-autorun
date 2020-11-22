package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.e;
import java.io.IOException;

public class h
  implements e<ParcelFileDescriptor, Bitmap>
{
  private final r a;
  private final com.bumptech.glide.load.b.a.c b;
  private a c;
  
  public h(com.bumptech.glide.load.b.a.c paramc, a parama)
  {
    this(new r(), paramc, parama);
  }
  
  public h(r paramr, com.bumptech.glide.load.b.a.c paramc, a parama)
  {
    this.a = paramr;
    this.b = paramc;
    this.c = parama;
  }
  
  public k<Bitmap> a(ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2)
    throws IOException
  {
    return c.a(this.a.a(paramParcelFileDescriptor, this.b, paramInt1, paramInt2, this.c), this.b);
  }
  
  public String a()
  {
    return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */