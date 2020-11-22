package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.c.c;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import java.io.File;

public class a
  extends com.bumptech.glide.load.c.b<ParcelFileDescriptor>
  implements b<File>
{
  public a(l<Uri, ParcelFileDescriptor> paraml)
  {
    super(paraml);
  }
  
  public static class a
    implements m<File, ParcelFileDescriptor>
  {
    public l<File, ParcelFileDescriptor> a(Context paramContext, c paramc)
    {
      return new a(paramc.a(Uri.class, ParcelFileDescriptor.class));
    }
    
    public void a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */