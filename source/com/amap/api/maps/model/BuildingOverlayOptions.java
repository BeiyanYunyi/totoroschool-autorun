package com.amap.api.maps.model;

import android.graphics.Point;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import java.util.ArrayList;
import java.util.List;

public class BuildingOverlayOptions
  extends BaseOptions
{
  private int buildingHeight = -1;
  private int buildingHeightScale = 1;
  private List<LatLng> buildingLatlngs = new ArrayList();
  private int[] buildingLatlngsPoints;
  private int buildingSideColor = -7829368;
  private int buildingTopColor = -7829368;
  private boolean isVisible = true;
  private float zindex;
  
  public int getBuildingHeight()
  {
    return this.buildingHeight;
  }
  
  public int getBuildingHeightScale()
  {
    return this.buildingHeightScale;
  }
  
  public List<LatLng> getBuildingLatlngs()
  {
    return this.buildingLatlngs;
  }
  
  public int getBuildingSideColor()
  {
    return this.buildingSideColor;
  }
  
  public int getBuildingTopColor()
  {
    return this.buildingTopColor;
  }
  
  public int[] getPoints()
  {
    Object localObject1 = this.buildingLatlngs;
    int i = 0;
    if ((localObject1 != null) && (this.buildingLatlngs.size() > 0))
    {
      localObject1 = new int[this.buildingLatlngs.size() * 2];
      int j = 0;
      while (i < this.buildingLatlngs.size())
      {
        Object localObject2 = (LatLng)this.buildingLatlngs.get(i);
        localObject2 = VirtualEarthProjection.latLongToPixels(((LatLng)localObject2).latitude, ((LatLng)localObject2).longitude, 20);
        int k = j + 1;
        localObject1[j] = ((Point)localObject2).x;
        j = k + 1;
        localObject1[k] = ((Point)localObject2).y;
        i += 1;
      }
      return (int[])localObject1;
    }
    return new int[0];
  }
  
  public float getZIndex()
  {
    return this.zindex;
  }
  
  public boolean isVisible()
  {
    return this.isVisible;
  }
  
  public BuildingOverlayOptions setBuildingHeight(int paramInt)
  {
    this.buildingHeight = paramInt;
    return this;
  }
  
  public BuildingOverlayOptions setBuildingHeightScale(int paramInt)
  {
    this.buildingHeightScale = paramInt;
    return this;
  }
  
  public BuildingOverlayOptions setBuildingLatlngs(List<LatLng> paramList)
  {
    this.buildingLatlngs = paramList;
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.buildingLatlngsPoints = new int[paramList.size() * 2];
      int i = 0;
      int k;
      for (int j = 0; i < paramList.size(); j = k + 1)
      {
        Object localObject = (LatLng)paramList.get(i);
        localObject = VirtualEarthProjection.latLongToPixels(((LatLng)localObject).latitude, ((LatLng)localObject).longitude, 20);
        int[] arrayOfInt = this.buildingLatlngsPoints;
        k = j + 1;
        arrayOfInt[j] = ((Point)localObject).x;
        this.buildingLatlngsPoints[k] = ((Point)localObject).y;
        i += 1;
      }
    }
    return this;
  }
  
  public BuildingOverlayOptions setBuildingSideColor(int paramInt)
  {
    this.buildingSideColor = paramInt;
    return this;
  }
  
  public BuildingOverlayOptions setBuildingTopColor(int paramInt)
  {
    this.buildingTopColor = paramInt;
    return this;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
  }
  
  public void setZIndex(float paramFloat)
  {
    this.zindex = paramFloat;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\BuildingOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */