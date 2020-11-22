package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.q;

public class e
  extends q<ParcelFileDescriptor>
  implements b<Uri>
{
  public e(Context paramContext, l<com.bumptech.glide.load.c.d, ParcelFileDescriptor> paraml)
  {
    super(paramContext, paraml);
  }
  
  protected com.bumptech.glide.load.a.c<ParcelFileDescriptor> a(Context paramContext, Uri paramUri)
  {
    return new com.bumptech.glide.load.a.e(paramContext, paramUri);
  }
  
  protected com.bumptech.glide.load.a.c<ParcelFileDescriptor> a(Context paramContext, String paramString)
  {
    return new com.bumptech.glide.load.a.d(paramContext.getApplicationContext().getAssets(), paramString);
  }
  
  public static class a
    implements m<Uri, ParcelFileDescriptor>
  {
    public l<Uri, ParcelFileDescriptor> a(Context paramContext, com.bumptech.glide.load.c.c paramc)
    {
      return new e(paramContext, paramc.a(com.bumptech.glide.load.c.d.class, ParcelFileDescriptor.class));
    }
    
    public void a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */