package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.c.c;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.p;

public class d
  extends p<ParcelFileDescriptor>
  implements b<String>
{
  public d(l<Uri, ParcelFileDescriptor> paraml)
  {
    super(paraml);
  }
  
  public static class a
    implements m<String, ParcelFileDescriptor>
  {
    public l<String, ParcelFileDescriptor> a(Context paramContext, c paramc)
    {
      return new d(paramc.a(Uri.class, ParcelFileDescriptor.class));
    }
    
    public void a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */