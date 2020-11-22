package com.amap.api.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider
  implements TileProvider
{
  private final int height;
  private final int width;
  
  public UrlTileProvider(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  private static long a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['က'];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return l;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = getTileUrl(paramInt1, paramInt2, paramInt3);
    if (localObject == null) {
      return NO_TILE;
    }
    try
    {
      localObject = Tile.obtain(this.width, this.height, a(((URL)localObject).openStream()));
      return (Tile)localObject;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return NO_TILE;
  }
  
  public int getTileHeight()
  {
    return this.height;
  }
  
  public abstract URL getTileUrl(int paramInt1, int paramInt2, int paramInt3);
  
  public int getTileWidth()
  {
    return this.width;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\UrlTileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */