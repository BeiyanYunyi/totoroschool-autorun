package com.autonavi.base.amap.api.mapcore;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.mapcore.util.ck;
import com.amap.api.mapcore.util.cl;
import com.amap.api.mapcore.util.lu;
import com.amap.api.maps.AMap.CancelableCallback;
import com.amap.api.maps.AMap.OnCameraChangeListener;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public abstract interface IAMapDelegate
  extends IAMap
{
  public abstract void addGestureMapMessage(int paramInt, AbstractGestureMapMessage paramAbstractGestureMapMessage);
  
  public abstract void addOverlayTexture(int paramInt, GLTextureProperty paramGLTextureProperty);
  
  public abstract void addTextureItem(lu paramlu);
  
  public abstract void animateCamera(AbstractCameraUpdateMessage paramAbstractCameraUpdateMessage)
    throws RemoteException;
  
  public abstract void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage paramAbstractCameraUpdateMessage, long paramLong, AMap.CancelableCallback paramCancelableCallback);
  
  public abstract boolean canShowIndoorSwitch();
  
  public abstract void changeGLOverlayIndex();
  
  public abstract void changeLogoIconStyle(String paramString, boolean paramBoolean, int paramInt);
  
  public abstract void changeMapLogo(int paramInt, boolean paramBoolean);
  
  public abstract void changeSize(int paramInt1, int paramInt2);
  
  public abstract void changeSurface(int paramInt1, GL10 paramGL10, int paramInt2, int paramInt3);
  
  public abstract int checkMarkerInRect(IMarkerAction paramIMarkerAction, Rect paramRect);
  
  public abstract float checkZoomLevel(float paramFloat)
    throws RemoteException;
  
  public abstract void clearTileCache();
  
  public abstract String createId(String paramString);
  
  public abstract void createSurface(int paramInt, GL10 paramGL10, EGLConfig paramEGLConfig);
  
  public abstract void geo2Latlng(int paramInt1, int paramInt2, DPoint paramDPoint);
  
  public abstract void geo2Map(int paramInt1, int paramInt2, FPoint paramFPoint);
  
  public abstract int getBaseOverlayTextureID();
  
  public abstract float getCameraDegree(int paramInt);
  
  public abstract CameraPosition getCameraPositionPrj(boolean paramBoolean);
  
  public abstract Context getContext();
  
  public abstract int getDottedLineTextureID(int paramInt);
  
  public abstract int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo paramEAMapPlatformGestureInfo);
  
  public abstract float[] getFinalMatrix();
  
  public abstract GLMapEngine getGLMapEngine();
  
  public abstract View getGLMapView();
  
  public abstract ck getGLShader(int paramInt);
  
  public abstract cl getGLShaderManager();
  
  public abstract void getGeoCenter(int paramInt, IPoint paramIPoint);
  
  public abstract void getLatLng2Map(double paramDouble1, double paramDouble2, FPoint paramFPoint);
  
  public abstract void getLatLng2Pixel(double paramDouble1, double paramDouble2, IPoint paramIPoint);
  
  public abstract int getLineTextureID();
  
  public abstract float getLogoMarginRate(int paramInt);
  
  public abstract int getLogoPosition();
  
  public abstract float getMapAngle(int paramInt);
  
  public abstract LatLngBounds getMapBounds(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract MapConfig getMapConfig();
  
  public abstract GLMapState getMapProjection();
  
  public abstract FPoint[] getMapRect();
  
  public abstract float getMapZoomScale();
  
  public abstract int getMaskLayerType();
  
  public abstract AMap.OnCameraChangeListener getOnCameraChangeListener()
    throws RemoteException;
  
  public abstract void getPixel2Geo(int paramInt1, int paramInt2, IPoint paramIPoint);
  
  public abstract void getPixel2LatLng(int paramInt1, int paramInt2, DPoint paramDPoint);
  
  public abstract float getPreciseLevel(int paramInt);
  
  public abstract IProjectionDelegate getProjection()
    throws RemoteException;
  
  public abstract Rect getRect();
  
  public abstract lu getTextureItem(BitmapDescriptor paramBitmapDescriptor);
  
  public abstract lu getTextureItem(BitmapDescriptor paramBitmapDescriptor, boolean paramBoolean);
  
  public abstract IUiSettingsDelegate getUiSettings();
  
  public abstract float getUnitLengthByZoom(int paramInt);
  
  public abstract Point getWaterMarkerPositon();
  
  public abstract float getZoomLevel();
  
  public abstract void hideInfoWindow();
  
  public abstract boolean isInfoWindowShown(IMarkerDelegate paramIMarkerDelegate)
    throws RemoteException;
  
  public abstract boolean isLockMapAngle(int paramInt);
  
  public abstract boolean isLockMapCameraDegree(int paramInt);
  
  public abstract boolean isUseAnchor();
  
  public abstract void latlon2Geo(double paramDouble1, double paramDouble2, IPoint paramIPoint);
  
  public abstract void map2Geo(float paramFloat1, float paramFloat2, IPoint paramIPoint);
  
  public abstract void moveCamera(AbstractCameraUpdateMessage paramAbstractCameraUpdateMessage)
    throws RemoteException;
  
  public abstract boolean onDoubleTap(int paramInt, MotionEvent paramMotionEvent);
  
  public abstract void onLongPress(int paramInt, MotionEvent paramMotionEvent);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract boolean onSingleTapConfirmed(int paramInt, MotionEvent paramMotionEvent);
  
  public abstract void pixel2Map(int paramInt1, int paramInt2, PointF paramPointF);
  
  public abstract void post(Runnable paramRunnable);
  
  public abstract void redrawInfoWindow();
  
  public abstract void refreshLogo();
  
  public abstract void reloadMapCustomStyle();
  
  public abstract void removeEngineGLOverlay(BaseMapOverlay paramBaseMapOverlay);
  
  public abstract boolean removeGLModel(String paramString);
  
  public abstract boolean removeGLOverlay(String paramString)
    throws RemoteException;
  
  public abstract boolean removeMarker(String paramString);
  
  public abstract void removeTextureItem(String paramString);
  
  public abstract void resetRenderTimeLongLong();
  
  public abstract void setCustomMapStyle(boolean paramBoolean, byte[] paramArrayOfByte);
  
  public abstract void setGestureStatus(int paramInt1, int paramInt2);
  
  public abstract void setHideLogoEnble(boolean paramBoolean);
  
  public abstract void setLogoBottomMargin(int paramInt);
  
  public abstract void setLogoLeftMargin(int paramInt);
  
  public abstract void setLogoMarginRate(int paramInt, float paramFloat);
  
  public abstract void setLogoPosition(int paramInt);
  
  public abstract void setMapCustomEnable(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void setMapWidgetListener(AMapWidgetListener paramAMapWidgetListener);
  
  public abstract void setZoomPosition(int paramInt);
  
  public abstract void showCompassEnabled(boolean paramBoolean);
  
  public abstract void showIndoorSwitchControlsEnabled(boolean paramBoolean);
  
  public abstract void showInfoWindow(BaseOverlayImp paramBaseOverlayImp)
    throws RemoteException;
  
  public abstract void showLogoEnabled(boolean paramBoolean);
  
  public abstract void showMyLocationButtonEnabled(boolean paramBoolean);
  
  public abstract void showMyLocationOverlay(Location paramLocation)
    throws RemoteException;
  
  public abstract void showScaleEnabled(boolean paramBoolean);
  
  public abstract void showZoomControlsEnabled(boolean paramBoolean);
  
  public abstract float toMapLenWithWin(int paramInt);
  
  public abstract void zoomOut(int paramInt);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\api\mapcore\IAMapDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */