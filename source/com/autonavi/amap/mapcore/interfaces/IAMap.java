package com.autonavi.amap.mapcore.interfaces;

import android.location.Location;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps.AMap.CancelableCallback;
import com.amap.api.maps.AMap.CommonInfoWindowAdapter;
import com.amap.api.maps.AMap.InfoWindowAdapter;
import com.amap.api.maps.AMap.OnCacheRemoveListener;
import com.amap.api.maps.AMap.OnCameraChangeListener;
import com.amap.api.maps.AMap.OnIndoorBuildingActiveListener;
import com.amap.api.maps.AMap.OnInfoWindowClickListener;
import com.amap.api.maps.AMap.OnMapClickListener;
import com.amap.api.maps.AMap.OnMapLoadedListener;
import com.amap.api.maps.AMap.OnMapLongClickListener;
import com.amap.api.maps.AMap.OnMapScreenShotListener;
import com.amap.api.maps.AMap.OnMapTouchListener;
import com.amap.api.maps.AMap.OnMarkerClickListener;
import com.amap.api.maps.AMap.OnMarkerDragListener;
import com.amap.api.maps.AMap.OnMultiPointClickListener;
import com.amap.api.maps.AMap.OnMyLocationChangeListener;
import com.amap.api.maps.AMap.OnPOIClickListener;
import com.amap.api.maps.AMap.OnPolylineClickListener;
import com.amap.api.maps.AMap.onMapPrintScreenListener;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
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
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
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
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public abstract interface IAMap
{
  public abstract Arc addArc(ArcOptions paramArcOptions)
    throws RemoteException;
  
  public abstract BuildingOverlay addBuildingOverlay();
  
  public abstract Circle addCircle(CircleOptions paramCircleOptions)
    throws RemoteException;
  
  public abstract CrossOverlay addCrossVector(CrossOverlayOptions paramCrossOverlayOptions);
  
  public abstract GL3DModel addGLModel(GL3DModelOptions paramGL3DModelOptions);
  
  public abstract GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
    throws RemoteException;
  
  public abstract HeatMapLayer addHeatMapLayer(HeatMapLayerOptions paramHeatMapLayerOptions)
    throws RemoteException;
  
  public abstract Marker addMarker(MarkerOptions paramMarkerOptions)
    throws RemoteException;
  
  public abstract ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> paramArrayList, boolean paramBoolean)
    throws RemoteException;
  
  public abstract MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions paramMultiPointOverlayOptions)
    throws RemoteException;
  
  public abstract RouteOverlay addNaviRouteOverlay();
  
  public abstract NavigateArrow addNavigateArrow(NavigateArrowOptions paramNavigateArrowOptions)
    throws RemoteException;
  
  public abstract ParticleOverlay addParticleOverlay(ParticleOverlayOptions paramParticleOverlayOptions);
  
  public abstract Polygon addPolygon(PolygonOptions paramPolygonOptions)
    throws RemoteException;
  
  public abstract Polyline addPolyline(PolylineOptions paramPolylineOptions)
    throws RemoteException;
  
  public abstract Text addText(TextOptions paramTextOptions)
    throws RemoteException;
  
  public abstract TileOverlay addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
    throws RemoteException;
  
  public abstract void animateCamera(CameraUpdate paramCameraUpdate)
    throws RemoteException;
  
  public abstract void animateCameraWithCallback(CameraUpdate paramCameraUpdate, AMap.CancelableCallback paramCancelableCallback)
    throws RemoteException;
  
  public abstract void animateCameraWithDurationAndCallback(CameraUpdate paramCameraUpdate, long paramLong, AMap.CancelableCallback paramCancelableCallback)
    throws RemoteException;
  
  public abstract Pair<Float, LatLng> calculateZoomToSpanLevel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, LatLng paramLatLng1, LatLng paramLatLng2);
  
  public abstract boolean canStopMapRender();
  
  public abstract void changeSurface(GL10 paramGL10, int paramInt1, int paramInt2);
  
  public abstract void checkMapState(IGLMapState paramIGLMapState);
  
  public abstract void clear()
    throws RemoteException;
  
  public abstract void clear(boolean paramBoolean)
    throws RemoteException;
  
  public abstract long createGLOverlay(int paramInt);
  
  public abstract void createSurface(GL10 paramGL10, EGLConfig paramEGLConfig);
  
  public abstract void destroy();
  
  public abstract void destroySurface(int paramInt);
  
  public abstract void drawFrame(GL10 paramGL10);
  
  public abstract Projection getAMapProjection()
    throws RemoteException;
  
  public abstract UiSettings getAMapUiSettings()
    throws RemoteException;
  
  public abstract AMapCameraInfo getCamerInfo();
  
  public abstract float getCameraAngle();
  
  public abstract CameraPosition getCameraPosition()
    throws RemoteException;
  
  public abstract long getGlOverlayMgrPtr();
  
  public abstract InfoWindowAnimationManager getInfoWindowAnimationManager();
  
  public abstract void getLatLngRect(DPoint[] paramArrayOfDPoint);
  
  public abstract Handler getMainHandler();
  
  public abstract String getMapContentApprovalNumber();
  
  public abstract int getMapHeight();
  
  public abstract void getMapPrintScreen(AMap.onMapPrintScreenListener paramonMapPrintScreenListener);
  
  public abstract List<Marker> getMapScreenMarkers()
    throws RemoteException;
  
  public abstract void getMapScreenShot(AMap.OnMapScreenShotListener paramOnMapScreenShotListener);
  
  public abstract int getMapTextZIndex()
    throws RemoteException;
  
  public abstract int getMapType()
    throws RemoteException;
  
  public abstract int getMapWidth();
  
  public abstract float getMaxZoomLevel();
  
  public abstract float getMinZoomLevel();
  
  public abstract Location getMyLocation()
    throws RemoteException;
  
  public abstract MyLocationStyle getMyLocationStyle()
    throws RemoteException;
  
  public abstract float[] getProjectionMatrix();
  
  public abstract int getRenderMode();
  
  public abstract int getSX();
  
  public abstract int getSY();
  
  public abstract String getSatelliteImageApprovalNumber();
  
  public abstract float getScalePerPixel()
    throws RemoteException;
  
  public abstract float getSkyHeight();
  
  public abstract View getView()
    throws RemoteException;
  
  public abstract float[] getViewMatrix();
  
  public abstract float getZoomToSpanLevel(LatLng paramLatLng1, LatLng paramLatLng2);
  
  public abstract boolean isIndoorEnabled()
    throws RemoteException;
  
  public abstract boolean isMaploaded();
  
  public abstract boolean isMyLocationEnabled()
    throws RemoteException;
  
  public abstract boolean isTouchPoiEnable();
  
  public abstract boolean isTrafficEnabled()
    throws RemoteException;
  
  public abstract void moveCamera(CameraUpdate paramCameraUpdate)
    throws RemoteException;
  
  public abstract void onActivityPause();
  
  public abstract void onActivityResume();
  
  public abstract void onChangeFinish();
  
  public abstract void onFling();
  
  public abstract void onIndoorBuildingActivity(int paramInt, byte[] paramArrayOfByte);
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void queueEvent(Runnable paramRunnable);
  
  public abstract void reloadMap();
  
  public abstract void removecache()
    throws RemoteException;
  
  public abstract void removecache(AMap.OnCacheRemoveListener paramOnCacheRemoveListener)
    throws RemoteException;
  
  public abstract void renderSurface(GL10 paramGL10);
  
  public abstract void requestRender();
  
  public abstract void resetMinMaxZoomPreference();
  
  public abstract void resetRenderTime();
  
  public abstract void set3DBuildingEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setAMapGestureListener(AMapGestureListener paramAMapGestureListener);
  
  public abstract void setCenterToPixel(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void setCustomMapStyle(CustomMapStyleOptions paramCustomMapStyleOptions);
  
  public abstract void setCustomMapStyleID(String paramString);
  
  public abstract void setCustomMapStylePath(String paramString);
  
  public abstract void setCustomRenderer(CustomRenderer paramCustomRenderer)
    throws RemoteException;
  
  public abstract void setCustomTextureResourcePath(String paramString);
  
  public abstract void setIndoorBuildingInfo(IndoorBuildingInfo paramIndoorBuildingInfo)
    throws RemoteException;
  
  public abstract void setIndoorEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setInfoWindowAdapter(AMap.CommonInfoWindowAdapter paramCommonInfoWindowAdapter)
    throws RemoteException;
  
  public abstract void setInfoWindowAdapter(AMap.InfoWindowAdapter paramInfoWindowAdapter)
    throws RemoteException;
  
  public abstract void setLoadOfflineData(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setLocationSource(LocationSource paramLocationSource)
    throws RemoteException;
  
  public abstract void setMapCustomEnable(boolean paramBoolean);
  
  public abstract void setMapLanguage(String paramString);
  
  public abstract void setMapStatusLimits(LatLngBounds paramLatLngBounds);
  
  public abstract void setMapTextEnable(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setMapTextZIndex(int paramInt)
    throws RemoteException;
  
  public abstract void setMapType(int paramInt)
    throws RemoteException;
  
  public abstract void setMaskLayerParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
  
  public abstract void setMaxZoomLevel(float paramFloat);
  
  public abstract void setMinZoomLevel(float paramFloat);
  
  public abstract void setMyLocationEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setMyLocationRotateAngle(float paramFloat)
    throws RemoteException;
  
  public abstract void setMyLocationStyle(MyLocationStyle paramMyLocationStyle)
    throws RemoteException;
  
  public abstract void setMyLocationType(int paramInt)
    throws RemoteException;
  
  public abstract void setMyTrafficStyle(MyTrafficStyle paramMyTrafficStyle)
    throws RemoteException;
  
  public abstract void setOnCameraChangeListener(AMap.OnCameraChangeListener paramOnCameraChangeListener)
    throws RemoteException;
  
  public abstract void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener paramOnIndoorBuildingActiveListener)
    throws RemoteException;
  
  public abstract void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
    throws RemoteException;
  
  public abstract void setOnMapClickListener(AMap.OnMapClickListener paramOnMapClickListener)
    throws RemoteException;
  
  public abstract void setOnMapLongClickListener(AMap.OnMapLongClickListener paramOnMapLongClickListener)
    throws RemoteException;
  
  public abstract void setOnMapTouchListener(AMap.OnMapTouchListener paramOnMapTouchListener)
    throws RemoteException;
  
  public abstract void setOnMaploadedListener(AMap.OnMapLoadedListener paramOnMapLoadedListener)
    throws RemoteException;
  
  public abstract void setOnMarkerClickListener(AMap.OnMarkerClickListener paramOnMarkerClickListener)
    throws RemoteException;
  
  public abstract void setOnMarkerDragListener(AMap.OnMarkerDragListener paramOnMarkerDragListener)
    throws RemoteException;
  
  public abstract void setOnMultiPointClickListener(AMap.OnMultiPointClickListener paramOnMultiPointClickListener);
  
  public abstract void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener paramOnMyLocationChangeListener)
    throws RemoteException;
  
  public abstract void setOnPOIClickListener(AMap.OnPOIClickListener paramOnPOIClickListener)
    throws RemoteException;
  
  public abstract void setOnPolylineClickListener(AMap.OnPolylineClickListener paramOnPolylineClickListener)
    throws RemoteException;
  
  public abstract void setRenderFps(int paramInt);
  
  public abstract void setRenderMode(int paramInt);
  
  public abstract void setRoadArrowEnable(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setRunLowFrame(boolean paramBoolean);
  
  public abstract void setTouchPoiEnable(boolean paramBoolean);
  
  public abstract void setTrafficEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setVisibilityEx(int paramInt);
  
  public abstract void setZOrderOnTop(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setZoomScaleParam(float paramFloat);
  
  public abstract void stopAnimation()
    throws RemoteException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\IAMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */