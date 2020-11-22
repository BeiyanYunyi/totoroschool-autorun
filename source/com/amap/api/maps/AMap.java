package com.amap.api.maps;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapLayer;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import java.util.ArrayList;
import java.util.List;

public final class AMap
{
  public static final String CHINESE = "zh_cn";
  public static final String ENGLISH = "en";
  public static final int LOCATION_TYPE_LOCATE = 1;
  public static final int LOCATION_TYPE_MAP_FOLLOW = 2;
  public static final int LOCATION_TYPE_MAP_ROTATE = 3;
  public static final int MAP_TYPE_BUS = 5;
  public static final int MAP_TYPE_NAVI = 4;
  public static final int MAP_TYPE_NIGHT = 3;
  public static final int MAP_TYPE_NORMAL = 1;
  public static final int MAP_TYPE_SATELLITE = 2;
  public static final int MASK_LAYER_NONE = -1;
  public static final int MASK_LAYER_UNDER_LINE = 1;
  public static final int MASK_LAYER_UNDER_MARKER = 0;
  private final IAMap a;
  private UiSettings b;
  private Projection c;
  private MyTrafficStyle d;
  
  protected AMap(IAMap paramIAMap)
  {
    this.a = paramIAMap;
  }
  
  @Deprecated
  public static String getVersion()
  {
    return "7.1.0";
  }
  
  public final Arc addArc(ArcOptions paramArcOptions)
  {
    try
    {
      paramArcOptions = this.a.addArc(paramArcOptions);
      return paramArcOptions;
    }
    catch (Throwable paramArcOptions)
    {
      paramArcOptions.printStackTrace();
    }
    return null;
  }
  
  public final BuildingOverlay addBuildingOverlay()
  {
    try
    {
      BuildingOverlay localBuildingOverlay = this.a.addBuildingOverlay();
      return localBuildingOverlay;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public final Circle addCircle(CircleOptions paramCircleOptions)
  {
    try
    {
      paramCircleOptions = this.a.addCircle(paramCircleOptions);
      return paramCircleOptions;
    }
    catch (Throwable paramCircleOptions)
    {
      paramCircleOptions.printStackTrace();
    }
    return null;
  }
  
  public CrossOverlay addCrossOverlay(CrossOverlayOptions paramCrossOverlayOptions)
  {
    try
    {
      paramCrossOverlayOptions = this.a.addCrossVector(paramCrossOverlayOptions);
      return paramCrossOverlayOptions;
    }
    catch (Throwable paramCrossOverlayOptions)
    {
      paramCrossOverlayOptions.printStackTrace();
    }
    return null;
  }
  
  public GL3DModel addGL3DModel(GL3DModelOptions paramGL3DModelOptions)
  {
    try
    {
      paramGL3DModelOptions = this.a.addGLModel(paramGL3DModelOptions);
      return paramGL3DModelOptions;
    }
    catch (Throwable paramGL3DModelOptions)
    {
      paramGL3DModelOptions.printStackTrace();
    }
    return null;
  }
  
  public final GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
  {
    try
    {
      paramGroundOverlayOptions = this.a.addGroundOverlay(paramGroundOverlayOptions);
      return paramGroundOverlayOptions;
    }
    catch (Throwable paramGroundOverlayOptions)
    {
      paramGroundOverlayOptions.printStackTrace();
    }
    return null;
  }
  
  public final HeatMapLayer addHeatMapLayer(HeatMapLayerOptions paramHeatMapLayerOptions)
  {
    try
    {
      paramHeatMapLayerOptions = this.a.addHeatMapLayer(paramHeatMapLayerOptions);
      return paramHeatMapLayerOptions;
    }
    catch (Throwable paramHeatMapLayerOptions)
    {
      paramHeatMapLayerOptions.printStackTrace();
    }
    return null;
  }
  
  public final Marker addMarker(MarkerOptions paramMarkerOptions)
  {
    try
    {
      paramMarkerOptions = this.a.addMarker(paramMarkerOptions);
      return paramMarkerOptions;
    }
    catch (Throwable paramMarkerOptions)
    {
      paramMarkerOptions.printStackTrace();
    }
    return null;
  }
  
  public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> paramArrayList, boolean paramBoolean)
  {
    try
    {
      paramArrayList = this.a.addMarkers(paramArrayList, paramBoolean);
      return paramArrayList;
    }
    catch (Throwable paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
    return null;
  }
  
  public MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions paramMultiPointOverlayOptions)
  {
    try
    {
      paramMultiPointOverlayOptions = this.a.addMultiPointOverlay(paramMultiPointOverlayOptions);
      return paramMultiPointOverlayOptions;
    }
    catch (Throwable paramMultiPointOverlayOptions)
    {
      paramMultiPointOverlayOptions.printStackTrace();
    }
    return null;
  }
  
  public final NavigateArrow addNavigateArrow(NavigateArrowOptions paramNavigateArrowOptions)
  {
    try
    {
      paramNavigateArrowOptions = this.a.addNavigateArrow(paramNavigateArrowOptions);
      return paramNavigateArrowOptions;
    }
    catch (Throwable paramNavigateArrowOptions)
    {
      paramNavigateArrowOptions.printStackTrace();
    }
    return null;
  }
  
  public ParticleOverlay addParticleOverlay(ParticleOverlayOptions paramParticleOverlayOptions)
  {
    try
    {
      paramParticleOverlayOptions = this.a.addParticleOverlay(paramParticleOverlayOptions);
      return paramParticleOverlayOptions;
    }
    catch (Throwable paramParticleOverlayOptions)
    {
      paramParticleOverlayOptions.printStackTrace();
    }
    return null;
  }
  
  public final Polygon addPolygon(PolygonOptions paramPolygonOptions)
  {
    try
    {
      paramPolygonOptions = this.a.addPolygon(paramPolygonOptions);
      return paramPolygonOptions;
    }
    catch (Throwable paramPolygonOptions)
    {
      paramPolygonOptions.printStackTrace();
    }
    return null;
  }
  
  public final Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    try
    {
      paramPolylineOptions = this.a.addPolyline(paramPolylineOptions);
      return paramPolylineOptions;
    }
    catch (Throwable paramPolylineOptions)
    {
      paramPolylineOptions.printStackTrace();
    }
    return null;
  }
  
  public RouteOverlay addRouteOverlay()
  {
    return this.a.addNaviRouteOverlay();
  }
  
  public final Text addText(TextOptions paramTextOptions)
  {
    try
    {
      paramTextOptions = this.a.addText(paramTextOptions);
      return paramTextOptions;
    }
    catch (Throwable paramTextOptions)
    {
      paramTextOptions.printStackTrace();
    }
    return null;
  }
  
  public final TileOverlay addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
  {
    try
    {
      paramTileOverlayOptions = this.a.addTileOverlay(paramTileOverlayOptions);
      return paramTileOverlayOptions;
    }
    catch (Throwable paramTileOverlayOptions)
    {
      paramTileOverlayOptions.printStackTrace();
    }
    return null;
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate)
  {
    try
    {
      this.a.animateCamera(paramCameraUpdate);
      return;
    }
    catch (Throwable paramCameraUpdate)
    {
      paramCameraUpdate.printStackTrace();
    }
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, CancelableCallback paramCancelableCallback)
  {
    if (paramLong <= 0L) {}
    try
    {
      Log.w("AMap", "durationMs must be positive");
      this.a.animateCameraWithDurationAndCallback(paramCameraUpdate, paramLong, paramCancelableCallback);
      return;
    }
    catch (Throwable paramCameraUpdate)
    {
      for (;;) {}
    }
    paramCameraUpdate.printStackTrace();
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate, CancelableCallback paramCancelableCallback)
  {
    try
    {
      this.a.animateCameraWithCallback(paramCameraUpdate, paramCancelableCallback);
      return;
    }
    catch (Throwable paramCameraUpdate)
    {
      paramCameraUpdate.printStackTrace();
    }
  }
  
  public Pair<Float, LatLng> calculateZoomToSpanLevel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return this.a.calculateZoomToSpanLevel(paramInt1, paramInt2, paramInt3, paramInt4, paramLatLng1, paramLatLng2);
  }
  
  public final void clear()
  {
    try
    {
      this.a.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final void clear(boolean paramBoolean)
  {
    try
    {
      this.a.clear(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final CameraPosition getCameraPosition()
  {
    try
    {
      CameraPosition localCameraPosition = this.a.getCameraPosition();
      return localCameraPosition;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public final InfoWindowAnimationManager getInfoWindowAnimationManager()
  {
    return this.a.getInfoWindowAnimationManager();
  }
  
  public String getMapContentApprovalNumber()
  {
    try
    {
      String str = this.a.getMapContentApprovalNumber();
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public void getMapPrintScreen(onMapPrintScreenListener paramonMapPrintScreenListener)
  {
    this.a.getMapPrintScreen(paramonMapPrintScreenListener);
  }
  
  public final List<Marker> getMapScreenMarkers()
  {
    try
    {
      List localList = this.a.getMapScreenMarkers();
      return localList;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public void getMapScreenShot(OnMapScreenShotListener paramOnMapScreenShotListener)
  {
    this.a.getMapScreenShot(paramOnMapScreenShotListener);
  }
  
  public final int getMapTextZIndex()
  {
    try
    {
      int i = this.a.getMapTextZIndex();
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public final int getMapType()
  {
    try
    {
      int i = this.a.getMapType();
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 1;
  }
  
  public final float getMaxZoomLevel()
  {
    return this.a.getMaxZoomLevel();
  }
  
  public final float getMinZoomLevel()
  {
    return this.a.getMinZoomLevel();
  }
  
  public final Location getMyLocation()
  {
    try
    {
      Location localLocation = this.a.getMyLocation();
      return localLocation;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public final MyLocationStyle getMyLocationStyle()
  {
    try
    {
      MyLocationStyle localMyLocationStyle = this.a.getMyLocationStyle();
      return localMyLocationStyle;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public MyTrafficStyle getMyTrafficStyle()
  {
    return this.d;
  }
  
  public void getP20MapCenter(IPoint paramIPoint)
  {
    IPoint localIPoint = paramIPoint;
    if (paramIPoint == null) {}
    try
    {
      localIPoint = new IPoint();
      localIPoint.x = this.a.getSX();
      localIPoint.y = this.a.getSY();
      return;
    }
    catch (Throwable paramIPoint)
    {
      for (;;) {}
    }
    paramIPoint.printStackTrace();
  }
  
  public final Projection getProjection()
  {
    try
    {
      if (this.c == null) {
        this.c = this.a.getAMapProjection();
      }
      Projection localProjection = this.c;
      return localProjection;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public float[] getProjectionMatrix()
  {
    return this.a.getProjectionMatrix();
  }
  
  public String getSatelliteImageApprovalNumber()
  {
    try
    {
      String str = this.a.getSatelliteImageApprovalNumber();
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public float getScalePerPixel()
  {
    try
    {
      float f = this.a.getScalePerPixel();
      return f;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0.0F;
  }
  
  public final UiSettings getUiSettings()
  {
    try
    {
      if (this.b == null) {
        this.b = this.a.getAMapUiSettings();
      }
      UiSettings localUiSettings = this.b;
      return localUiSettings;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public float[] getViewMatrix()
  {
    return this.a.getViewMatrix();
  }
  
  public float getZoomToSpanLevel(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return this.a.getZoomToSpanLevel(paramLatLng1, paramLatLng2);
  }
  
  public final boolean isMyLocationEnabled()
  {
    try
    {
      boolean bool = this.a.isMyLocationEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public boolean isTouchPoiEnable()
  {
    try
    {
      boolean bool = this.a.isTouchPoiEnable();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return true;
  }
  
  public final boolean isTrafficEnabled()
  {
    try
    {
      boolean bool = this.a.isTrafficEnabled();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public final void moveCamera(CameraUpdate paramCameraUpdate)
  {
    try
    {
      this.a.moveCamera(paramCameraUpdate);
      return;
    }
    catch (Throwable paramCameraUpdate)
    {
      paramCameraUpdate.printStackTrace();
    }
  }
  
  public void reloadMap()
  {
    this.a.reloadMap();
  }
  
  public void removecache()
  {
    try
    {
      this.a.removecache();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void removecache(OnCacheRemoveListener paramOnCacheRemoveListener)
  {
    try
    {
      this.a.removecache(paramOnCacheRemoveListener);
      return;
    }
    catch (Throwable paramOnCacheRemoveListener)
    {
      paramOnCacheRemoveListener.printStackTrace();
    }
  }
  
  public void resetMinMaxZoomPreference()
  {
    this.a.resetMinMaxZoomPreference();
  }
  
  public void runOnDrawFrame()
  {
    this.a.setRunLowFrame(false);
  }
  
  public void setAMapGestureListener(AMapGestureListener paramAMapGestureListener)
  {
    this.a.setAMapGestureListener(paramAMapGestureListener);
  }
  
  public final void setCommonInfoWindowAdapter(CommonInfoWindowAdapter paramCommonInfoWindowAdapter)
  {
    try
    {
      this.a.setInfoWindowAdapter(paramCommonInfoWindowAdapter);
      return;
    }
    catch (Throwable paramCommonInfoWindowAdapter)
    {
      paramCommonInfoWindowAdapter.printStackTrace();
    }
  }
  
  public void setCustomMapStyle(CustomMapStyleOptions paramCustomMapStyleOptions)
  {
    this.a.setCustomMapStyle(paramCustomMapStyleOptions);
  }
  
  public void setCustomMapStyleID(String paramString)
  {
    Log.e("amap", "该方法已无效，请到官网(lbs.amap.com)更新新版样式文件并使用setCustomMapStyleOptions");
  }
  
  public void setCustomMapStylePath(String paramString)
  {
    Log.e("amap", "该方法已无效，请到官网(lbs.amap.com)更新新版样式文件并使用setCustomMapStyleOptions");
  }
  
  public void setCustomRenderer(CustomRenderer paramCustomRenderer)
  {
    try
    {
      this.a.setCustomRenderer(paramCustomRenderer);
      return;
    }
    catch (Throwable paramCustomRenderer)
    {
      paramCustomRenderer.printStackTrace();
    }
  }
  
  public void setCustomTextureResourcePath(String paramString)
  {
    Log.e("amap", "该方法已无效，请到官网(lbs.amap.com)更新新版样式文件并使用setCustomMapStyleOptions");
  }
  
  public void setIndoorBuildingInfo(IndoorBuildingInfo paramIndoorBuildingInfo)
  {
    try
    {
      this.a.setIndoorBuildingInfo(paramIndoorBuildingInfo);
      return;
    }
    catch (Throwable paramIndoorBuildingInfo)
    {
      paramIndoorBuildingInfo.printStackTrace();
    }
  }
  
  public final void setInfoWindowAdapter(InfoWindowAdapter paramInfoWindowAdapter)
  {
    try
    {
      this.a.setInfoWindowAdapter(paramInfoWindowAdapter);
      return;
    }
    catch (Throwable paramInfoWindowAdapter)
    {
      paramInfoWindowAdapter.printStackTrace();
    }
  }
  
  public final void setLoadOfflineData(boolean paramBoolean)
  {
    try
    {
      this.a.setLoadOfflineData(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final void setLocationSource(LocationSource paramLocationSource)
  {
    try
    {
      this.a.setLocationSource(paramLocationSource);
      return;
    }
    catch (Throwable paramLocationSource)
    {
      paramLocationSource.printStackTrace();
    }
  }
  
  public void setMapCustomEnable(boolean paramBoolean)
  {
    Log.e("amap", "该方法已无效，请到官网(lbs.amap.com)更新新版样式文件并使用setCustomMapStyleOptions");
  }
  
  public void setMapLanguage(String paramString)
  {
    try
    {
      this.a.setMapLanguage(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setMapStatusLimits(LatLngBounds paramLatLngBounds)
  {
    try
    {
      this.a.setMapStatusLimits(paramLatLngBounds);
      moveCamera(CameraUpdateFactory.newLatLngBounds(paramLatLngBounds, 0));
      return;
    }
    catch (Throwable paramLatLngBounds)
    {
      paramLatLngBounds.printStackTrace();
    }
  }
  
  public final void setMapTextZIndex(int paramInt)
  {
    try
    {
      this.a.setMapTextZIndex(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final void setMapType(int paramInt)
  {
    try
    {
      this.a.setMapType(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setMaskLayerParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong)
  {
    this.a.setMaskLayerParams(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
  }
  
  public void setMaxZoomLevel(float paramFloat)
  {
    this.a.setMaxZoomLevel(paramFloat);
  }
  
  public void setMinZoomLevel(float paramFloat)
  {
    this.a.setMinZoomLevel(paramFloat);
  }
  
  public final void setMyLocationEnabled(boolean paramBoolean)
  {
    try
    {
      this.a.setMyLocationEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final void setMyLocationRotateAngle(float paramFloat)
  {
    try
    {
      this.a.setMyLocationRotateAngle(paramFloat);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final void setMyLocationStyle(MyLocationStyle paramMyLocationStyle)
  {
    try
    {
      this.a.setMyLocationStyle(paramMyLocationStyle);
      return;
    }
    catch (Throwable paramMyLocationStyle)
    {
      paramMyLocationStyle.printStackTrace();
    }
  }
  
  public final void setMyLocationType(int paramInt)
  {
    try
    {
      this.a.setMyLocationType(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setMyTrafficStyle(MyTrafficStyle paramMyTrafficStyle)
  {
    try
    {
      this.d = paramMyTrafficStyle;
      this.a.setMyTrafficStyle(paramMyTrafficStyle);
      return;
    }
    catch (Throwable paramMyTrafficStyle)
    {
      paramMyTrafficStyle.printStackTrace();
    }
  }
  
  public final void setOnCameraChangeListener(OnCameraChangeListener paramOnCameraChangeListener)
  {
    try
    {
      this.a.setOnCameraChangeListener(paramOnCameraChangeListener);
      return;
    }
    catch (Throwable paramOnCameraChangeListener)
    {
      paramOnCameraChangeListener.printStackTrace();
    }
  }
  
  public final void setOnIndoorBuildingActiveListener(OnIndoorBuildingActiveListener paramOnIndoorBuildingActiveListener)
  {
    try
    {
      this.a.setOnIndoorBuildingActiveListener(paramOnIndoorBuildingActiveListener);
      return;
    }
    catch (Throwable paramOnIndoorBuildingActiveListener)
    {
      paramOnIndoorBuildingActiveListener.printStackTrace();
    }
  }
  
  public final void setOnInfoWindowClickListener(OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    try
    {
      this.a.setOnInfoWindowClickListener(paramOnInfoWindowClickListener);
      return;
    }
    catch (Throwable paramOnInfoWindowClickListener)
    {
      paramOnInfoWindowClickListener.printStackTrace();
    }
  }
  
  public final void setOnMapClickListener(OnMapClickListener paramOnMapClickListener)
  {
    try
    {
      this.a.setOnMapClickListener(paramOnMapClickListener);
      return;
    }
    catch (Throwable paramOnMapClickListener)
    {
      paramOnMapClickListener.printStackTrace();
    }
  }
  
  public final void setOnMapLoadedListener(OnMapLoadedListener paramOnMapLoadedListener)
  {
    try
    {
      this.a.setOnMaploadedListener(paramOnMapLoadedListener);
      return;
    }
    catch (Throwable paramOnMapLoadedListener)
    {
      paramOnMapLoadedListener.printStackTrace();
    }
  }
  
  public final void setOnMapLongClickListener(OnMapLongClickListener paramOnMapLongClickListener)
  {
    try
    {
      this.a.setOnMapLongClickListener(paramOnMapLongClickListener);
      return;
    }
    catch (Throwable paramOnMapLongClickListener)
    {
      paramOnMapLongClickListener.printStackTrace();
    }
  }
  
  public final void setOnMapTouchListener(OnMapTouchListener paramOnMapTouchListener)
  {
    try
    {
      this.a.setOnMapTouchListener(paramOnMapTouchListener);
      return;
    }
    catch (Throwable paramOnMapTouchListener)
    {
      paramOnMapTouchListener.printStackTrace();
    }
  }
  
  public final void setOnMarkerClickListener(OnMarkerClickListener paramOnMarkerClickListener)
  {
    try
    {
      this.a.setOnMarkerClickListener(paramOnMarkerClickListener);
      return;
    }
    catch (Throwable paramOnMarkerClickListener)
    {
      paramOnMarkerClickListener.printStackTrace();
    }
  }
  
  public final void setOnMarkerDragListener(OnMarkerDragListener paramOnMarkerDragListener)
  {
    try
    {
      this.a.setOnMarkerDragListener(paramOnMarkerDragListener);
      return;
    }
    catch (Throwable paramOnMarkerDragListener)
    {
      paramOnMarkerDragListener.printStackTrace();
    }
  }
  
  public void setOnMultiPointClickListener(OnMultiPointClickListener paramOnMultiPointClickListener)
  {
    try
    {
      this.a.setOnMultiPointClickListener(paramOnMultiPointClickListener);
      return;
    }
    catch (Throwable paramOnMultiPointClickListener)
    {
      paramOnMultiPointClickListener.printStackTrace();
    }
  }
  
  public final void setOnMyLocationChangeListener(OnMyLocationChangeListener paramOnMyLocationChangeListener)
  {
    try
    {
      this.a.setOnMyLocationChangeListener(paramOnMyLocationChangeListener);
      return;
    }
    catch (Throwable paramOnMyLocationChangeListener)
    {
      paramOnMyLocationChangeListener.printStackTrace();
    }
  }
  
  public final void setOnPOIClickListener(OnPOIClickListener paramOnPOIClickListener)
  {
    try
    {
      this.a.setOnPOIClickListener(paramOnPOIClickListener);
      return;
    }
    catch (Throwable paramOnPOIClickListener)
    {
      paramOnPOIClickListener.printStackTrace();
    }
  }
  
  public final void setOnPolylineClickListener(OnPolylineClickListener paramOnPolylineClickListener)
  {
    try
    {
      this.a.setOnPolylineClickListener(paramOnPolylineClickListener);
      return;
    }
    catch (Throwable paramOnPolylineClickListener)
    {
      paramOnPolylineClickListener.printStackTrace();
    }
  }
  
  public void setPointToCenter(int paramInt1, int paramInt2)
  {
    try
    {
      this.a.setCenterToPixel(paramInt1, paramInt2);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setRenderFps(int paramInt)
  {
    this.a.setRenderFps(paramInt);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.a.setRenderMode(paramInt);
  }
  
  public void setRoadArrowEnable(boolean paramBoolean)
  {
    try
    {
      this.a.setRoadArrowEnable(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setTouchPoiEnable(boolean paramBoolean)
  {
    try
    {
      this.a.setTouchPoiEnable(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setTrafficEnabled(boolean paramBoolean)
  {
    try
    {
      this.a.setTrafficEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void showBuildings(boolean paramBoolean)
  {
    try
    {
      this.a.set3DBuildingEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void showIndoorMap(boolean paramBoolean)
  {
    try
    {
      this.a.setIndoorEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void showMapText(boolean paramBoolean)
  {
    try
    {
      this.a.setMapTextEnable(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public final void stopAnimation()
  {
    try
    {
      this.a.stopAnimation();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public static abstract interface CancelableCallback
  {
    public abstract void onCancel();
    
    public abstract void onFinish();
  }
  
  public static abstract interface CommonInfoWindowAdapter
  {
    public abstract InfoWindowParams getInfoWindowParams(BasePointOverlay paramBasePointOverlay);
  }
  
  public static abstract interface ImageInfoWindowAdapter
    extends AMap.InfoWindowAdapter
  {
    public abstract long getInfoWindowUpdateTime();
  }
  
  public static abstract interface InfoWindowAdapter
  {
    public abstract View getInfoContents(Marker paramMarker);
    
    public abstract View getInfoWindow(Marker paramMarker);
  }
  
  public static abstract interface MultiPositionInfoWindowAdapter
    extends AMap.InfoWindowAdapter
  {
    public abstract View getInfoWindowClick(Marker paramMarker);
    
    public abstract View getOverturnInfoWindow(Marker paramMarker);
    
    public abstract View getOverturnInfoWindowClick(Marker paramMarker);
  }
  
  public static abstract interface OnCacheRemoveListener
  {
    public abstract void onRemoveCacheFinish(boolean paramBoolean);
  }
  
  public static abstract interface OnCameraChangeListener
  {
    public abstract void onCameraChange(CameraPosition paramCameraPosition);
    
    public abstract void onCameraChangeFinish(CameraPosition paramCameraPosition);
  }
  
  public static abstract interface OnIndoorBuildingActiveListener
  {
    public abstract void OnIndoorBuilding(IndoorBuildingInfo paramIndoorBuildingInfo);
  }
  
  public static abstract interface OnInfoWindowClickListener
  {
    public abstract void onInfoWindowClick(Marker paramMarker);
  }
  
  public static abstract interface OnMapClickListener
  {
    public abstract void onMapClick(LatLng paramLatLng);
  }
  
  public static abstract interface OnMapLoadedListener
  {
    public abstract void onMapLoaded();
  }
  
  public static abstract interface OnMapLongClickListener
  {
    public abstract void onMapLongClick(LatLng paramLatLng);
  }
  
  public static abstract interface OnMapScreenShotListener
  {
    public abstract void onMapScreenShot(Bitmap paramBitmap);
    
    public abstract void onMapScreenShot(Bitmap paramBitmap, int paramInt);
  }
  
  public static abstract interface OnMapTouchListener
  {
    public abstract void onTouch(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface OnMarkerClickListener
  {
    public abstract boolean onMarkerClick(Marker paramMarker);
  }
  
  public static abstract interface OnMarkerDragListener
  {
    public abstract void onMarkerDrag(Marker paramMarker);
    
    public abstract void onMarkerDragEnd(Marker paramMarker);
    
    public abstract void onMarkerDragStart(Marker paramMarker);
  }
  
  public static abstract interface OnMultiPointClickListener
  {
    public abstract boolean onPointClick(MultiPointItem paramMultiPointItem);
  }
  
  public static abstract interface OnMyLocationChangeListener
  {
    public abstract void onMyLocationChange(Location paramLocation);
  }
  
  public static abstract interface OnPOIClickListener
  {
    public abstract void onPOIClick(Poi paramPoi);
  }
  
  public static abstract interface OnPolylineClickListener
  {
    public abstract void onPolylineClick(Polyline paramPolyline);
  }
  
  public static abstract interface onMapPrintScreenListener
  {
    public abstract void onMapPrint(Drawable paramDrawable);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\AMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */