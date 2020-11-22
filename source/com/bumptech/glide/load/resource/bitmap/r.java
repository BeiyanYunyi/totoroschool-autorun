package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.b.a.c;
import java.io.IOException;

public class r
  implements a<ParcelFileDescriptor>
{
  private static final a a = new a();
  private a b;
  private int c;
  
  public r()
  {
    this(a, -1);
  }
  
  r(a parama, int paramInt)
  {
    this.b = parama;
    this.c = paramInt;
  }
  
  public Bitmap a(ParcelFileDescriptor paramParcelFileDescriptor, c paramc, int paramInt1, int paramInt2, com.bumptech.glide.load.a parama)
    throws IOException
  {
    parama = this.b.a();
    parama.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
    if (this.c >= 0) {
      paramc = parama.getFrameAtTime(this.c);
    } else {
      paramc = parama.getFrameAtTime();
    }
    parama.release();
    paramParcelFileDescriptor.close();
    return paramc;
  }
  
  public String a()
  {
    return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
  }
  
  static class a
  {
    public MediaMetadataRetriever a()
    {
      return new MediaMetadataRetriever();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */