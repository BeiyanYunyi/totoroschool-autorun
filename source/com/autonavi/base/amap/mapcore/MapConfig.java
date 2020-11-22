package com.autonavi.base.amap.mapcore;

import android.opengl.Matrix;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import java.util.concurrent.atomic.AtomicInteger;

public class MapConfig
  implements IMapConfig, Cloneable
{
  public static final int DEFAULT_RATIO = 1;
  private static final int GEO_POINT_ZOOM = 20;
  public static final float MAX_ZOOM = 20.0F;
  public static final float MAX_ZOOM_INDOOR = 20.0F;
  public static final float MIN_ZOOM = 3.0F;
  public static final int MSG_ACTION_ONBASEPOICLICK = 20;
  public static final int MSG_ACTION_ONMAPCLICK = 19;
  public static final int MSG_AUTH_FAILURE = 2;
  public static final int MSG_CALLBACK_MAPLOADED = 16;
  public static final int MSG_CALLBACK_ONTOUCHEVENT = 14;
  public static final int MSG_CALLBACK_SCREENSHOT = 15;
  public static final int MSG_CAMERAUPDATE_CHANGE = 10;
  public static final int MSG_CAMERAUPDATE_FINISH = 11;
  public static final int MSG_COMPASSVIEW_CHANGESTATE = 13;
  public static final int MSG_INFOWINDOW_UPDATE = 18;
  public static final int MSG_TILEOVERLAY_REFRESH = 17;
  public static final int MSG_ZOOMVIEW_CHANGESTATE = 12;
  private static final int TILE_SIZE_POW = 8;
  private int anchorX = 0;
  private int anchorY = 0;
  private volatile double changeGridRatio = 1.0D;
  private volatile double changeRatio = 1.0D;
  private AtomicInteger changedCounter = new AtomicInteger(0);
  private int customBackgroundColor = -1;
  private String customTextureResourcePath;
  private Rectangle geoRectangle = new Rectangle();
  private int gridX = 0;
  private int gridY = 0;
  private boolean isBearingChanged = false;
  private boolean isBuildingEnable = true;
  private boolean isCenterChanged = false;
  private boolean isCustomStyleEnabled = false;
  private boolean isHideLogoEnable = true;
  private boolean isIndoorEnable = false;
  private boolean isMapTextEnable = true;
  private boolean isNeedUpdateMapRectNextFrame = false;
  private boolean isNeedUpdateZoomControllerState = false;
  private boolean isProFunctionAuthEnable = true;
  private boolean isSetLimitZoomLevel;
  private boolean isTiltChanged = false;
  private boolean isTouchPoiEnable = true;
  private boolean isTrafficEnabled = false;
  private boolean isUseProFunction = false;
  private boolean isWorldMapEnable = false;
  private boolean isZoomChanged = false;
  MapConfig lastMapconfig = null;
  private IPoint[] limitIPoints;
  private LatLngBounds limitLatLngBounds;
  private String mCustomStyleID;
  private String mCustomStylePath;
  private String mMapLanguage = "zh_cn";
  private int mMapStyleMode = 0;
  private int mMapStyleState = 0;
  private int mMapStyleTime = 0;
  private DPoint mapGeoCenter = new DPoint(this.sX, this.sY);
  private int mapHeight;
  private float mapPerPixelUnitLength;
  private FPoint[] mapRect = null;
  private int mapWidth;
  private float mapZoomScale = 1.0F;
  public float maxZoomLevel = 20.0F;
  public float minZoomLevel = 3.0F;
  float[] mvpMatrix = new float[16];
  float[] projectionMatrix = new float[16];
  private float sC = 0.0F;
  private float sR = 0.0F;
  private double sX = 2.21010267E8D;
  private double sY = 1.01697799E8D;
  private float sZ = 10.0F;
  private float skyHeight;
  int[] tilsIDs = new int[100];
  float[] viewMatrix = new float[16];
  
  public MapConfig(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.lastMapconfig = new MapConfig(false);
      this.lastMapconfig.setGridXY(0, 0);
      this.lastMapconfig.setSX(0.0D);
      this.lastMapconfig.setSY(0.0D);
      this.lastMapconfig.setSZ(0.0F);
      this.lastMapconfig.setSC(0.0F);
      this.lastMapconfig.setSR(0.0F);
    }
  }
  
  private void changeRatio()
  {
    double d1 = this.lastMapconfig.getSX();
    double d2 = this.lastMapconfig.getSY();
    float f2 = this.lastMapconfig.getSZ();
    float f1 = this.lastMapconfig.getSC();
    float f3 = this.lastMapconfig.getSR();
    this.changeRatio = (Math.abs(this.sX - d1) + Math.abs(this.sY - d2));
    d1 = this.changeRatio;
    d2 = 1.0D;
    if (d1 == 0.0D) {
      d1 = 1.0D;
    } else {
      d1 = this.changeRatio * 2.0D;
    }
    this.changeRatio = d1;
    double d3 = this.changeRatio;
    if (f2 == this.sZ) {
      d1 = 1.0D;
    } else {
      d1 = Math.abs(f2 - this.sZ);
    }
    this.changeRatio = (d3 * d1);
    float f4 = this.sC;
    f2 = 1.0F;
    if (f1 == f4) {
      f1 = 1.0F;
    } else {
      f1 = Math.abs(f1 - this.sC);
    }
    if (f3 != this.sR) {
      f2 = Math.abs(f3 - this.sR);
    }
    d1 = this.changeRatio;
    d3 = f1;
    Double.isNaN(d3);
    this.changeRatio = (d1 * d3);
    d1 = this.changeRatio;
    double d4 = f2;
    Double.isNaN(d4);
    this.changeRatio = (d1 * d4);
    this.changeGridRatio = (Math.abs(this.lastMapconfig.getGridX() - this.gridX) + (this.lastMapconfig.getGridY() - this.gridY));
    if (this.changeGridRatio == 0.0D) {
      d1 = d2;
    } else {
      d1 = this.changeGridRatio * 2.0D;
    }
    this.changeGridRatio = d1;
    d1 = this.changeGridRatio;
    Double.isNaN(d3);
    this.changeGridRatio = (d1 * d3);
    d1 = this.changeGridRatio;
    Double.isNaN(d4);
    this.changeGridRatio = (d1 * d4);
  }
  
  public int getAnchorX()
  {
    return this.anchorX;
  }
  
  public int getAnchorY()
  {
    return this.anchorY;
  }
  
  public double getChangeGridRatio()
  {
    return this.changeGridRatio;
  }
  
  public double getChangeRatio()
  {
    return this.changeRatio;
  }
  
  public int getChangedCounter()
  {
    return this.changedCounter.get();
  }
  
  public int[] getCurTileIds()
  {
    return this.tilsIDs;
  }
  
  public int getCustomBackgroundColor()
  {
    return this.customBackgroundColor;
  }
  
  public String getCustomStyleID()
  {
    return this.mCustomStyleID;
  }
  
  public String getCustomStylePath()
  {
    return this.mCustomStylePath;
  }
  
  public String getCustomTextureResourcePath()
  {
    return this.customTextureResourcePath;
  }
  
  public Rectangle getGeoRectangle()
  {
    return this.geoRectangle;
  }
  
  protected int getGridX()
  {
    return this.gridX;
  }
  
  protected int getGridY()
  {
    return this.gridY;
  }
  
  public IPoint[] getLimitIPoints()
  {
    return this.limitIPoints;
  }
  
  public LatLngBounds getLimitLatLngBounds()
  {
    return this.limitLatLngBounds;
  }
  
  public DPoint getMapGeoCenter()
  {
    return this.mapGeoCenter;
  }
  
  public int getMapHeight()
  {
    return this.mapHeight;
  }
  
  public String getMapLanguage()
  {
    return this.mMapLanguage;
  }
  
  public float getMapPerPixelUnitLength()
  {
    return this.mapPerPixelUnitLength;
  }
  
  public FPoint[] getMapRect()
  {
    return this.mapRect;
  }
  
  public int getMapStyleMode()
  {
    return this.mMapStyleMode;
  }
  
  public int getMapStyleState()
  {
    return this.mMapStyleState;
  }
  
  public int getMapStyleTime()
  {
    return this.mMapStyleTime;
  }
  
  public int getMapWidth()
  {
    return this.mapWidth;
  }
  
  public float getMapZoomScale()
  {
    return this.mapZoomScale;
  }
  
  public float getMaxZoomLevel()
  {
    return this.maxZoomLevel;
  }
  
  public float getMinZoomLevel()
  {
    return this.minZoomLevel;
  }
  
  public float[] getMvpMatrix()
  {
    return this.mvpMatrix;
  }
  
  public float[] getProjectionMatrix()
  {
    return this.projectionMatrix;
  }
  
  public float getSC()
  {
    return this.sC;
  }
  
  public float getSR()
  {
    return this.sR;
  }
  
  public double getSX()
  {
    return this.sX;
  }
  
  public double getSY()
  {
    return this.sY;
  }
  
  public float getSZ()
  {
    return this.sZ;
  }
  
  public float getSkyHeight()
  {
    return this.skyHeight;
  }
  
  public float[] getViewMatrix()
  {
    return this.viewMatrix;
  }
  
  public boolean isBearingChanged()
  {
    return this.isBearingChanged;
  }
  
  public boolean isBuildingEnable()
  {
    return this.isBuildingEnable;
  }
  
  public boolean isCustomStyleEnable()
  {
    return this.isCustomStyleEnabled;
  }
  
  public boolean isHideLogoEnable()
  {
    return this.isHideLogoEnable;
  }
  
  public boolean isIndoorEnable()
  {
    return this.isIndoorEnable;
  }
  
  public boolean isMapStateChange()
  {
    boolean bool2;
    if (this.lastMapconfig != null)
    {
      double d1 = this.lastMapconfig.getSX();
      double d2 = this.lastMapconfig.getSY();
      float f1 = this.lastMapconfig.getSZ();
      float f2 = this.lastMapconfig.getSC();
      float f3 = this.lastMapconfig.getSR();
      boolean bool1;
      if (d1 != this.sX) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.isCenterChanged = bool1;
      if (d2 != this.sY) {
        bool1 = true;
      } else {
        bool1 = this.isCenterChanged;
      }
      this.isCenterChanged = bool1;
      if (f1 != this.sZ) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.isZoomChanged = bool1;
      if (this.isZoomChanged) {
        if ((f1 > this.minZoomLevel) && (this.sZ > this.minZoomLevel) && (f1 < this.maxZoomLevel) && (this.sZ < this.maxZoomLevel)) {
          this.isNeedUpdateZoomControllerState = false;
        } else {
          this.isNeedUpdateZoomControllerState = true;
        }
      }
      if (f2 != this.sC) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.isTiltChanged = bool1;
      if (f3 != this.sR) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.isBearingChanged = bool1;
      if ((!this.isCenterChanged) && (!this.isZoomChanged) && (!this.isTiltChanged) && (!this.isBearingChanged) && (!this.isNeedUpdateMapRectNextFrame)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      bool2 = bool1;
      if (bool1)
      {
        this.isNeedUpdateMapRectNextFrame = false;
        this.changedCounter.incrementAndGet();
        int j = (int)this.sZ;
        int i = (int)this.sX;
        j = 20 - j + 8;
        setGridXY(i >> j, (int)this.sY >> j);
        changeRatio();
        bool2 = bool1;
      }
    }
    else
    {
      bool2 = false;
    }
    if ((this.sC >= 45) && (this.skyHeight == 0.0F)) {
      return true;
    }
    return bool2;
  }
  
  public boolean isMapTextEnable()
  {
    return this.isMapTextEnable;
  }
  
  public boolean isNeedUpdateZoomControllerState()
  {
    return this.isNeedUpdateZoomControllerState;
  }
  
  public boolean isProFunctionAuthEnable()
  {
    return this.isProFunctionAuthEnable;
  }
  
  public boolean isSetLimitZoomLevel()
  {
    return this.isSetLimitZoomLevel;
  }
  
  public boolean isTiltChanged()
  {
    return this.isTiltChanged;
  }
  
  public boolean isTouchPoiEnable()
  {
    return this.isTouchPoiEnable;
  }
  
  public boolean isTrafficEnabled()
  {
    return this.isTrafficEnabled;
  }
  
  public boolean isUseProFunction()
  {
    return this.isUseProFunction;
  }
  
  public boolean isWorldMapEnable()
  {
    return this.isWorldMapEnable;
  }
  
  public boolean isZoomChanged()
  {
    return this.isZoomChanged;
  }
  
  public void resetChangedCounter()
  {
    this.changedCounter.set(0);
  }
  
  public void resetMinMaxZoomPreference()
  {
    this.minZoomLevel = 3.0F;
    this.maxZoomLevel = 20.0F;
    this.isSetLimitZoomLevel = false;
  }
  
  public void setAnchorX(int paramInt)
  {
    this.anchorX = paramInt;
  }
  
  public void setAnchorY(int paramInt)
  {
    this.anchorY = paramInt;
  }
  
  public void setBuildingEnable(boolean paramBoolean)
  {
    this.isBuildingEnable = paramBoolean;
  }
  
  public void setCustomBackgroundColor(int paramInt)
  {
    this.customBackgroundColor = paramInt;
  }
  
  public void setCustomStyleEnable(boolean paramBoolean)
  {
    this.isCustomStyleEnabled = paramBoolean;
  }
  
  public void setCustomStyleID(String paramString)
  {
    this.mCustomStyleID = paramString;
  }
  
  public void setCustomStylePath(String paramString)
  {
    this.mCustomStylePath = paramString;
  }
  
  public void setCustomTextureResourcePath(String paramString)
  {
    this.customTextureResourcePath = paramString;
  }
  
  protected void setGridXY(int paramInt1, int paramInt2)
  {
    if (this.lastMapconfig != null) {
      this.lastMapconfig.setGridXY(this.gridX, this.gridY);
    }
    this.gridX = paramInt1;
    this.gridY = paramInt2;
  }
  
  public void setHideLogoEnble(boolean paramBoolean)
  {
    this.isHideLogoEnable = paramBoolean;
  }
  
  public void setIndoorEnable(boolean paramBoolean)
  {
    this.isIndoorEnable = paramBoolean;
  }
  
  public void setLimitIPoints(IPoint[] paramArrayOfIPoint)
  {
    this.limitIPoints = paramArrayOfIPoint;
  }
  
  public void setLimitLatLngBounds(LatLngBounds paramLatLngBounds)
  {
    this.limitLatLngBounds = paramLatLngBounds;
    if (paramLatLngBounds == null) {
      resetMinMaxZoomPreference();
    }
  }
  
  public void setMapHeight(int paramInt)
  {
    this.mapHeight = paramInt;
  }
  
  public void setMapLanguage(String paramString)
  {
    this.mMapLanguage = paramString;
  }
  
  public void setMapPerPixelUnitLength(float paramFloat)
  {
    this.mapPerPixelUnitLength = paramFloat;
  }
  
  public void setMapRect(FPoint[] paramArrayOfFPoint)
  {
    if (this.lastMapconfig != null) {
      this.lastMapconfig.setMapRect(paramArrayOfFPoint);
    }
    this.mapRect = paramArrayOfFPoint;
  }
  
  public void setMapStyleMode(int paramInt)
  {
    this.mMapStyleMode = paramInt;
  }
  
  public void setMapStyleState(int paramInt)
  {
    this.mMapStyleState = paramInt;
  }
  
  public void setMapStyleTime(int paramInt)
  {
    this.mMapStyleTime = paramInt;
  }
  
  public void setMapTextEnable(boolean paramBoolean)
  {
    this.isMapTextEnable = paramBoolean;
  }
  
  public void setMapWidth(int paramInt)
  {
    this.mapWidth = paramInt;
  }
  
  public void setMapZoomScale(float paramFloat)
  {
    this.mapZoomScale = paramFloat;
  }
  
  public void setMaxZoomLevel(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat > 20.0F) {
      f = 20.0F;
    }
    paramFloat = f;
    if (f < 3.0F) {
      paramFloat = 3.0F;
    }
    f = paramFloat;
    if (paramFloat < getMinZoomLevel()) {
      f = getMinZoomLevel();
    }
    this.isSetLimitZoomLevel = true;
    this.maxZoomLevel = f;
  }
  
  public void setMinZoomLevel(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 3.0F) {
      f = 3.0F;
    }
    paramFloat = f;
    if (f > 20.0F) {
      paramFloat = 20.0F;
    }
    f = paramFloat;
    if (paramFloat > getMaxZoomLevel()) {
      f = getMaxZoomLevel();
    }
    this.isSetLimitZoomLevel = true;
    this.minZoomLevel = f;
  }
  
  public void setProFunctionAuthEnable(boolean paramBoolean)
  {
    this.isProFunctionAuthEnable = paramBoolean;
  }
  
  public void setSC(float paramFloat)
  {
    if (this.lastMapconfig != null) {
      this.lastMapconfig.setSC(this.sC);
    }
    this.sC = paramFloat;
  }
  
  public void setSR(float paramFloat)
  {
    if (this.lastMapconfig != null) {
      this.lastMapconfig.setSR(this.sR);
    }
    this.sR = paramFloat;
  }
  
  public void setSX(double paramDouble)
  {
    if (this.lastMapconfig != null) {
      this.lastMapconfig.setSX(this.sX);
    }
    this.sX = paramDouble;
    this.mapGeoCenter.x = this.sX;
  }
  
  public void setSY(double paramDouble)
  {
    if (this.lastMapconfig != null) {
      this.lastMapconfig.setSY(this.sY);
    }
    this.sY = paramDouble;
    this.mapGeoCenter.x = this.sY;
  }
  
  public void setSZ(float paramFloat)
  {
    if (this.lastMapconfig != null) {
      this.lastMapconfig.setSZ(this.sZ);
    }
    this.sZ = paramFloat;
  }
  
  public void setSkyHeight(float paramFloat)
  {
    this.skyHeight = paramFloat;
  }
  
  public void setTouchPoiEnable(boolean paramBoolean)
  {
    this.isTouchPoiEnable = paramBoolean;
  }
  
  public void setTrafficEnabled(boolean paramBoolean)
  {
    this.isTrafficEnabled = paramBoolean;
  }
  
  public void setUseProFunction(boolean paramBoolean)
  {
    this.isUseProFunction = paramBoolean;
  }
  
  public void setWorldMapEnable(boolean paramBoolean)
  {
    this.isWorldMapEnable = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" sX: ");
    localStringBuilder.append(this.sX);
    localStringBuilder.append(" sY: ");
    localStringBuilder.append(this.sY);
    localStringBuilder.append(" sZ: ");
    localStringBuilder.append(this.sZ);
    localStringBuilder.append(" sC: ");
    localStringBuilder.append(this.sC);
    localStringBuilder.append(" sR: ");
    localStringBuilder.append(this.sR);
    localStringBuilder.append(" skyHeight: ");
    localStringBuilder.append(this.skyHeight);
    return localStringBuilder.toString();
  }
  
  public void updateFinalMatrix()
  {
    Matrix.multiplyMM(this.mvpMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
  }
  
  public void updateMapRectNextFrame(boolean paramBoolean)
  {
    this.isNeedUpdateMapRectNextFrame = paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\MapConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */