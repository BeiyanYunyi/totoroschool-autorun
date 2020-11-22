package com.amap.api.maps.model;

public abstract interface TileProvider
{
  public static final Tile NO_TILE = Tile.obtain(-1, -1, null);
  
  public abstract Tile getTile(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int getTileHeight();
  
  public abstract int getTileWidth();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\TileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */