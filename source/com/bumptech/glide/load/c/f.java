package com.bumptech.glide.load.c;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.a.c;
import java.io.InputStream;

public class f<A>
  implements l<A, g>
{
  private final l<A, InputStream> a;
  private final l<A, ParcelFileDescriptor> b;
  
  public f(l<A, InputStream> paraml, l<A, ParcelFileDescriptor> paraml1)
  {
    if ((paraml == null) && (paraml1 == null)) {
      throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
    }
    this.a = paraml;
    this.b = paraml1;
  }
  
  public c<g> a(A paramA, int paramInt1, int paramInt2)
  {
    c localc;
    if (this.a != null) {
      localc = this.a.a(paramA, paramInt1, paramInt2);
    } else {
      localc = null;
    }
    if (this.b != null) {
      paramA = this.b.a(paramA, paramInt1, paramInt2);
    } else {
      paramA = null;
    }
    if ((localc == null) && (paramA == null)) {
      return null;
    }
    return new a(localc, paramA);
  }
  
  static class a
    implements c<g>
  {
    private final c<InputStream> a;
    private final c<ParcelFileDescriptor> b;
    
    public a(c<InputStream> paramc, c<ParcelFileDescriptor> paramc1)
    {
      this.a = paramc;
      this.b = paramc1;
    }
    
    public void a()
    {
      if (this.a != null) {
        this.a.a();
      }
      if (this.b != null) {
        this.b.a();
      }
    }
    
    public g b(com.bumptech.glide.g paramg)
      throws Exception
    {
      InputStream localInputStream2;
      if (this.a != null) {
        try
        {
          InputStream localInputStream1 = (InputStream)this.a.a(paramg);
        }
        catch (Exception localException)
        {
          if (Log.isLoggable("IVML", 2)) {
            Log.v("IVML", "Exception fetching input stream, trying ParcelFileDescriptor", localException);
          }
          if (this.b == null) {
            throw localException;
          }
        }
      } else {
        localInputStream2 = null;
      }
      if (this.b != null) {
        try
        {
          paramg = (ParcelFileDescriptor)this.b.a(paramg);
        }
        catch (Exception paramg)
        {
          if (Log.isLoggable("IVML", 2)) {
            Log.v("IVML", "Exception fetching ParcelFileDescriptor", paramg);
          }
          if (localInputStream2 == null) {
            throw paramg;
          }
        }
      } else {
        paramg = null;
      }
      return new g(localInputStream2, paramg);
    }
    
    public String b()
    {
      if (this.a != null) {
        return this.a.b();
      }
      return this.b.b();
    }
    
    public void c()
    {
      if (this.a != null) {
        this.a.c();
      }
      if (this.b != null) {
        this.b.c();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */