package com.bumptech.glide.load.b.b;

import android.content.Context;
import java.io.File;

public final class f
  extends d
{
  public f(Context paramContext)
  {
    this(paramContext, "image_manager_disk_cache", 262144000);
  }
  
  public f(Context paramContext, final String paramString, int paramInt)
  {
    super(new d.a()
    {
      public File a()
      {
        File localFile = f.this.getCacheDir();
        if (localFile == null) {
          return null;
        }
        if (paramString != null) {
          return new File(localFile, paramString);
        }
        return localFile;
      }
    }, paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */