package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;

public class dy
  extends dz
{
  private TileProvider e = null;
  
  public dy(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null) {
        paramContext.isConnectedOrConnecting();
      }
    }
  }
  
  private Bitmap c(cj.a parama)
  {
    Object localObject = null;
    try
    {
      Tile localTile = this.e.getTile(parama.a, parama.b, parama.c);
      parama = (cj.a)localObject;
      if (localTile != null)
      {
        parama = (cj.a)localObject;
        if (localTile != TileProvider.NO_TILE) {
          parama = BitmapFactory.decodeByteArray(localTile.data, 0, localTile.data.length);
        }
      }
      return parama;
    }
    catch (Throwable parama) {}
    return null;
  }
  
  protected Bitmap a(Object paramObject)
  {
    return c((cj.a)paramObject);
  }
  
  public void a(TileProvider paramTileProvider)
  {
    this.e = paramTileProvider;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */