package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.n;

public class c
  extends n<ParcelFileDescriptor>
  implements b<Integer>
{
  public c(Context paramContext, l<Uri, ParcelFileDescriptor> paraml)
  {
    super(paramContext, paraml);
  }
  
  public static class a
    implements m<Integer, ParcelFileDescriptor>
  {
    public l<Integer, ParcelFileDescriptor> a(Context paramContext, com.bumptech.glide.load.c.c paramc)
    {
      return new c(paramContext, paramc.a(Uri.class, ParcelFileDescriptor.class));
    }
    
    public void a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */