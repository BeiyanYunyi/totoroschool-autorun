package com.bumptech.glide.load.a;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

public class d
  extends a<ParcelFileDescriptor>
{
  public d(AssetManager paramAssetManager, String paramString)
  {
    super(paramAssetManager, paramString);
  }
  
  protected void a(ParcelFileDescriptor paramParcelFileDescriptor)
    throws IOException
  {
    paramParcelFileDescriptor.close();
  }
  
  protected ParcelFileDescriptor b(AssetManager paramAssetManager, String paramString)
    throws IOException
  {
    return paramAssetManager.openFd(paramString).getParcelFileDescriptor();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */