package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public class h
  extends a<InputStream>
{
  public h(AssetManager paramAssetManager, String paramString)
  {
    super(paramAssetManager, paramString);
  }
  
  protected void a(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream.close();
  }
  
  protected InputStream b(AssetManager paramAssetManager, String paramString)
    throws IOException
  {
    return paramAssetManager.open(paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */