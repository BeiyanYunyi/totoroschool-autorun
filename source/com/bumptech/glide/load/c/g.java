package com.bumptech.glide.load.c;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

public class g
{
  private final InputStream a;
  private final ParcelFileDescriptor b;
  
  public g(InputStream paramInputStream, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.a = paramInputStream;
    this.b = paramParcelFileDescriptor;
  }
  
  public InputStream a()
  {
    return this.a;
  }
  
  public ParcelFileDescriptor b()
  {
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */