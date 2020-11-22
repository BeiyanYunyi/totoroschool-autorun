package com.autonavi.base.ae.gmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.amap.api.mapcore.util.dw;
import com.amap.api.mapcore.util.dx;
import com.amap.api.mapcore.util.gk;
import com.amap.api.maps.AMap.CancelableCallback;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFling;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr.MapAnimationListener;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.IAMapEngineCallback;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.maploader.AMapLoader;
import com.autonavi.base.amap.mapcore.maploader.AMapLoader.ADataRequestParam;
import com.autonavi.base.amap.mapcore.maploader.NetworkState;
import com.autonavi.base.amap.mapcore.maploader.NetworkState.NetworkChangeListener;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import com.autonavi.base.amap.mapcore.tools.TextTextureGenerator;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GLMapEngine
  implements IGLMapEngine, IAMapEngineCallback, NetworkState.NetworkChangeListener
{
  Hashtable<Long, AMapLoader> aMapLoaderHashtable = new Hashtable();
  GLOverlayBundle<BaseMapOverlay<?, ?>> bundle = null;
  private Context context;
  private GLMapState copyGLMapState = null;
  private boolean isEngineRenderComplete = false;
  boolean isGestureStep = false;
  boolean isMoveCameraStep = false;
  private List<AbstractCameraUpdateMessage> mAnimateStateMessageList = new Vector();
  private List<AbstractGestureMapMessage> mGestureEndMessageList = new Vector();
  private List<AbstractGestureMapMessage> mGestureMessageList = new Vector();
  private IAMapDelegate mGlMapView = null;
  private Lock mLock = new ReentrantLock();
  private IAMapListener mMapListener;
  private long mNativeMapengineInstance = 0L;
  private NetworkState mNetworkState = null;
  boolean mRequestDestroy = false;
  private AtomicInteger mRequestID = new AtomicInteger(1);
  private List<AbstractCameraUpdateMessage> mStateMessageList = new Vector();
  private TextTextureGenerator mTextTextureGenerator;
  private AdglMapAnimationMgr mapAnimationMgr = null;
  private int mapGestureCount = 0;
  private Object mutLock = new Object();
  GLMapState state;
  private String userAgent;
  
  public GLMapEngine(Context paramContext, IAMapDelegate paramIAMapDelegate)
  {
    if (paramContext == null) {
      return;
    }
    this.context = paramContext.getApplicationContext();
    this.mGlMapView = paramIAMapDelegate;
    this.mTextTextureGenerator = new TextTextureGenerator();
    this.mapAnimationMgr = new AdglMapAnimationMgr();
    this.mapAnimationMgr.setMapAnimationListener(new AdglMapAnimationMgr.MapAnimationListener()
    {
      public void onMapAnimationFinish(AMap.CancelableCallback paramAnonymousCancelableCallback)
      {
        GLMapEngine.this.doMapAnimationFinishCallback(paramAnonymousCancelableCallback);
      }
    });
    paramIAMapDelegate = new StringBuilder();
    paramIAMapDelegate.append(System.getProperty("http.agent"));
    paramIAMapDelegate.append(" amap/");
    paramIAMapDelegate.append(GlMapUtil.getAppVersionName(paramContext));
    this.userAgent = paramIAMapDelegate.toString();
  }
  
  private float adapterDpiScale(DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = getEMUI();
    float f2 = 1.0F;
    float f1 = f2;
    if (localObject != null)
    {
      f1 = f2;
      if (!((String)localObject).isEmpty()) {
        if (((String)localObject).indexOf("EmotionUI_8") == -1)
        {
          f1 = f2;
          if (((String)localObject).indexOf("EmotionUI_9") == -1) {}
        }
        else
        {
          f1 = f2;
          if (paramInt3 > 0)
          {
            try
            {
              localObject = DisplayMetrics.class.getDeclaredField("noncompatWidthPixels");
              ((Field)localObject).setAccessible(true);
              i = ((Field)localObject).getInt(paramDisplayMetrics);
            }
            catch (IllegalAccessException localIllegalAccessException1)
            {
              localIllegalAccessException1.printStackTrace();
            }
            catch (NoSuchFieldException localNoSuchFieldException1)
            {
              localNoSuchFieldException1.printStackTrace();
            }
            int i = 0;
            try
            {
              Field localField1 = DisplayMetrics.class.getDeclaredField("noncompatHeightPixels");
              localField1.setAccessible(true);
              j = localField1.getInt(paramDisplayMetrics);
            }
            catch (IllegalAccessException localIllegalAccessException2)
            {
              localIllegalAccessException2.printStackTrace();
            }
            catch (NoSuchFieldException localNoSuchFieldException2)
            {
              localNoSuchFieldException2.printStackTrace();
            }
            int j = 0;
            try
            {
              Field localField2 = DisplayMetrics.class.getDeclaredField("noncompatDensityDpi");
              localField2.setAccessible(true);
              k = localField2.getInt(paramDisplayMetrics);
            }
            catch (IllegalAccessException paramDisplayMetrics)
            {
              paramDisplayMetrics.printStackTrace();
            }
            catch (NoSuchFieldException paramDisplayMetrics)
            {
              paramDisplayMetrics.printStackTrace();
            }
            int k = 0;
            if ((k <= paramInt3) && (i <= paramInt1))
            {
              f1 = f2;
              if (j <= paramInt2) {}
            }
            else
            {
              f2 = k / paramInt3;
              f1 = f2;
              if (f2 > 2.0F) {
                f1 = 2.0F;
              }
              if (f1 < 1.0F) {
                return 1.0F;
              }
            }
          }
        }
      }
    }
    return f1;
  }
  
  public static void destroyOverlay(int paramInt, long paramLong)
  {
    try
    {
      nativeDestroyOverlay(paramInt, paramLong);
      return;
    }
    finally {}
  }
  
  private void doMapAnimationCancelCallback(final AMap.CancelableCallback paramCancelableCallback)
  {
    if (paramCancelableCallback == null) {
      return;
    }
    if (this.mGlMapView != null) {
      this.mGlMapView.getMainHandler().post(new Runnable()
      {
        public void run()
        {
          try
          {
            paramCancelableCallback.onCancel();
            return;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
      });
    }
  }
  
  private void doMapAnimationFinishCallback(final AMap.CancelableCallback paramCancelableCallback)
  {
    if (this.mMapListener != null) {
      this.mMapListener.afterAnimation();
    }
    if (paramCancelableCallback == null) {
      return;
    }
    if (this.mGlMapView != null) {
      this.mGlMapView.getMainHandler().post(new Runnable()
      {
        public void run()
        {
          try
          {
            paramCancelableCallback.onFinish();
            return;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
      });
    }
  }
  
  private void gestureBegin()
  {
    this.mapGestureCount += 1;
  }
  
  private void gestureEnd()
  {
    this.mapGestureCount -= 1;
    if (this.mapGestureCount == 0) {
      recycleMessage();
    }
  }
  
  private static String getEMUI()
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getDeclaredMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { "ro.build.version.emui" });
      return (String)localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private void initAnimation()
  {
    if (this.mStateMessageList.size() > 0) {
      return;
    }
    if (this.mAnimateStateMessageList.size() > 0)
    {
      AbstractCameraUpdateMessage localAbstractCameraUpdateMessage = (AbstractCameraUpdateMessage)this.mAnimateStateMessageList.remove(0);
      if (localAbstractCameraUpdateMessage != null) {
        localAbstractCameraUpdateMessage.generateMapAnimation(this);
      }
    }
  }
  
  private void initNetworkState()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected static native String nativeAddNativeOverlay(int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  private static native boolean nativeAddOverlayTexture(int paramInt1, long paramLong, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native void nativeCancelDownLoad(int paramInt, long paramLong1, long paramLong2);
  
  private static native void nativeCreateAMapEngineWithFrame(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private static native long nativeCreateAMapInstance(String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3);
  
  protected static native long nativeCreateOverlay(int paramInt1, long paramLong, int paramInt2);
  
  private static native void nativeDestroy(long paramLong);
  
  private static native void nativeDestroyCurrentState(long paramLong1, long paramLong2);
  
  protected static native void nativeDestroyOverlay(int paramInt, long paramLong);
  
  private static native void nativeFinishDownLoad(int paramInt, long paramLong1, long paramLong2);
  
  private static native void nativeGetCurTileIDs(int paramInt1, long paramLong, int[] paramArrayOfInt, int paramInt2);
  
  private static native long nativeGetCurrentMapState(int paramInt, long paramLong);
  
  private static native long nativeGetGlOverlayMgrPtr(int paramInt, long paramLong);
  
  public static native String nativeGetMapEngineVersion(int paramInt);
  
  private static native int[] nativeGetMapModeState(int paramInt, long paramLong, boolean paramBoolean);
  
  private static native boolean nativeGetSrvViewStateBoolValue(int paramInt1, long paramLong, int paramInt2);
  
  private static native void nativeInitAMapEngineCallback(long paramLong, Object paramObject);
  
  private static native void nativeInitParam(String paramString1, String paramString2, String paramString3, String paramString4);
  
  private static native boolean nativeIsEngineCreated(long paramLong, int paramInt);
  
  private static native void nativePopRenderState(int paramInt, long paramLong);
  
  private static native void nativePostRenderAMap(long paramLong, int paramInt);
  
  private static native void nativePushRendererState(int paramInt, long paramLong);
  
  private static native void nativeReceiveNetData(int paramInt1, long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt2);
  
  protected static native void nativeRemoveNativeAllOverlay(int paramInt, long paramLong);
  
  protected static native void nativeRemoveNativeOverlay(int paramInt, long paramLong, String paramString);
  
  private static native void nativeRenderAMap(long paramLong, int paramInt);
  
  private static native void nativeSelectMapPois(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte);
  
  private static native void nativeSetAllContentEnable(int paramInt, long paramLong, boolean paramBoolean);
  
  private static native void nativeSetBuildingEnable(int paramInt, long paramLong, boolean paramBoolean);
  
  private static native void nativeSetBuildingTextureEnable(int paramInt, long paramLong, boolean paramBoolean);
  
  private static native void nativeSetCustomStyleData(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private static native void nativeSetCustomStyleTexture(int paramInt, long paramLong, byte[] paramArrayOfByte);
  
  private static native void nativeSetHighlightSubwayEnable(int paramInt, long paramLong, boolean paramBoolean);
  
  private static native void nativeSetIndoorBuildingToBeActive(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2);
  
  private static native void nativeSetIndoorEnable(int paramInt, long paramLong, boolean paramBoolean);
  
  private static native void nativeSetLabelEnable(int paramInt, long paramLong, boolean paramBoolean);
  
  private static native boolean nativeSetMapModeAndStyle(int paramInt, long paramLong, int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2, StyleItem[] paramArrayOfStyleItem);
  
  private static native void nativeSetNetStatus(long paramLong, int paramInt);
  
  private static native void nativeSetOfflineDataEnable(int paramInt, long paramLong, boolean paramBoolean);
  
  private static native void nativeSetParameter(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  private static native void nativeSetProjectionCenter(int paramInt, long paramLong, float paramFloat1, float paramFloat2);
  
  private static native void nativeSetRenderListenerStatus(int paramInt, long paramLong);
  
  private static native void nativeSetRoadArrowEnable(int paramInt, long paramLong, boolean paramBoolean);
  
  private static native void nativeSetServiceViewRect(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  private static native void nativeSetSetBackgroundTexture(int paramInt, long paramLong, byte[] paramArrayOfByte);
  
  private static native void nativeSetSimple3DEnable(int paramInt, long paramLong, boolean paramBoolean);
  
  private static native void nativeSetSkyTexture(int paramInt, long paramLong, byte[] paramArrayOfByte);
  
  private static native void nativeSetSrvViewStateBoolValue(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean);
  
  private static native void nativeSetTrafficEnable(int paramInt, long paramLong, boolean paramBoolean);
  
  private static native void nativeSetTrafficTexture(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4);
  
  private static native void nativeSetTrafficTextureAllInOne(int paramInt, long paramLong, byte[] paramArrayOfByte);
  
  protected static native void nativeUpdateNativeArrowOverlay(int paramInt1, long paramLong, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean, int paramInt5, int paramInt6, int paramInt7);
  
  private static native void nativesetMapOpenLayer(int paramInt, long paramLong, byte[] paramArrayOfByte);
  
  private boolean processAnimations(GLMapState paramGLMapState)
  {
    try
    {
      if (this.mapAnimationMgr.getAnimationsCount() > 0)
      {
        paramGLMapState.recalculate();
        this.mapAnimationMgr.doAnimations(paramGLMapState);
        return true;
      }
    }
    catch (Throwable paramGLMapState)
    {
      paramGLMapState.printStackTrace();
    }
    return false;
  }
  
  private boolean processGestureMessage(GLMapState paramGLMapState)
  {
    if (this.mGestureMessageList.size() <= 0)
    {
      if (this.isGestureStep) {
        this.isGestureStep = false;
      }
      return false;
    }
    this.isGestureStep = true;
    if (paramGLMapState == null) {
      return false;
    }
    while (this.mGestureMessageList.size() > 0)
    {
      AbstractGestureMapMessage localAbstractGestureMapMessage = (AbstractGestureMapMessage)this.mGestureMessageList.remove(0);
      if (localAbstractGestureMapMessage == null) {
        break;
      }
      if (localAbstractGestureMapMessage.width == 0) {
        localAbstractGestureMapMessage.width = this.mGlMapView.getMapWidth();
      }
      if (localAbstractGestureMapMessage.height == 0) {
        localAbstractGestureMapMessage.height = this.mGlMapView.getMapHeight();
      }
      int i = localAbstractGestureMapMessage.getMapGestureState();
      if (i == 100) {
        gestureBegin();
      } else if (i == 101) {
        localAbstractGestureMapMessage.runCameraUpdate(paramGLMapState);
      } else if (i == 102) {
        gestureEnd();
      }
      this.mGestureEndMessageList.add(localAbstractGestureMapMessage);
    }
    if (this.mGestureEndMessageList.size() == 1) {
      recycleMessage();
    }
    return true;
  }
  
  private boolean processMessage()
  {
    for (;;)
    {
      try
      {
        localGLMapState = (GLMapState)getNewMapState(1);
        boolean bool2 = processGestureMessage(localGLMapState);
        if (this.mGestureMessageList.size() <= 0)
        {
          if (bool2) {
            break label110;
          }
          if (!processStateMapMessage(localGLMapState)) {
            break label105;
          }
          break label110;
        }
        bool1 = bool2;
        if (this.mStateMessageList.size() > 0)
        {
          this.mStateMessageList.clear();
          bool1 = bool2;
        }
        if (bool1) {
          break label120;
        }
        if (!processAnimations(localGLMapState)) {
          break label115;
        }
      }
      catch (Exception localException)
      {
        GLMapState localGLMapState;
        localException.printStackTrace();
        return false;
      }
      if (bool1) {
        setMapState(1, localGLMapState);
      }
      localGLMapState.recycle();
      return bool1;
      label105:
      boolean bool1 = false;
      continue;
      label110:
      bool1 = true;
      continue;
      label115:
      bool1 = false;
      continue;
      label120:
      bool1 = true;
    }
  }
  
  private boolean processStateMapMessage(GLMapState paramGLMapState)
  {
    if (this.mStateMessageList.size() <= 0)
    {
      if (this.isMoveCameraStep) {
        this.isMoveCameraStep = false;
      }
      return false;
    }
    this.isMoveCameraStep = true;
    if (paramGLMapState == null) {
      return false;
    }
    while (this.mStateMessageList.size() > 0)
    {
      AbstractCameraUpdateMessage localAbstractCameraUpdateMessage = (AbstractCameraUpdateMessage)this.mStateMessageList.remove(0);
      if (localAbstractCameraUpdateMessage == null) {
        break;
      }
      if (localAbstractCameraUpdateMessage.width == 0) {
        localAbstractCameraUpdateMessage.width = this.mGlMapView.getMapWidth();
      }
      if (localAbstractCameraUpdateMessage.height == 0) {
        localAbstractCameraUpdateMessage.height = this.mGlMapView.getMapHeight();
      }
      paramGLMapState.recalculate();
      localAbstractCameraUpdateMessage.runCameraUpdate(paramGLMapState);
    }
    return true;
  }
  
  private void recycleMessage()
  {
    while (this.mGestureEndMessageList.size() > 0)
    {
      AbstractGestureMapMessage localAbstractGestureMapMessage = (AbstractGestureMapMessage)this.mGestureEndMessageList.remove(0);
      if (localAbstractGestureMapMessage == null) {
        break;
      }
      if ((localAbstractGestureMapMessage instanceof MoveGestureMapMessage)) {
        ((MoveGestureMapMessage)localAbstractGestureMapMessage).recycle();
      } else if ((localAbstractGestureMapMessage instanceof HoverGestureMapMessage)) {
        ((HoverGestureMapMessage)localAbstractGestureMapMessage).recycle();
      } else if ((localAbstractGestureMapMessage instanceof RotateGestureMapMessage)) {
        ((RotateGestureMapMessage)localAbstractGestureMapMessage).recycle();
      } else if ((localAbstractGestureMapMessage instanceof ScaleGestureMapMessage)) {
        ((ScaleGestureMapMessage)localAbstractGestureMapMessage).recycle();
      }
    }
  }
  
  public void OnIndoorBuildingActivity(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.mGlMapView != null) {
      try
      {
        this.mGlMapView.onIndoorBuildingActivity(paramInt, paramArrayOfByte);
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void addGestureMessage(int paramInt1, AbstractGestureMapMessage paramAbstractGestureMapMessage, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if (paramAbstractGestureMapMessage == null) {
      return;
    }
    try
    {
      paramAbstractGestureMapMessage.isGestureScaleByMapCenter = paramBoolean;
      this.mGestureMessageList.add(paramAbstractGestureMapMessage);
      return;
    }
    finally
    {
      paramAbstractGestureMapMessage = finally;
      throw paramAbstractGestureMapMessage;
    }
  }
  
  public void addGroupAnimation(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, int paramInt6, AMap.CancelableCallback paramCancelableCallback)
  {
    AdglMapAnimGroup localAdglMapAnimGroup = new AdglMapAnimGroup(paramInt2);
    localAdglMapAnimGroup.setToCameraDegree(paramInt4, 0);
    localAdglMapAnimGroup.setToMapAngle(paramInt3, 0);
    localAdglMapAnimGroup.setToMapLevel(paramFloat, 0);
    localAdglMapAnimGroup.setToMapCenterGeo(paramInt5, paramInt6, 0);
    if ((this.mapAnimationMgr != null) && (localAdglMapAnimGroup.isValid())) {
      this.mapAnimationMgr.addAnimation(localAdglMapAnimGroup, paramCancelableCallback);
    }
  }
  
  public void addMessage(AbstractCameraUpdateMessage paramAbstractCameraUpdateMessage, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mAnimateStateMessageList != null)
      {
        this.mAnimateStateMessageList.clear();
        this.mAnimateStateMessageList.add(paramAbstractCameraUpdateMessage);
      }
    }
    else if (this.mStateMessageList != null) {
      this.mStateMessageList.add(paramAbstractCameraUpdateMessage);
    }
  }
  
  public String addNativeOverlay(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mNativeMapengineInstance != 0L)
    {
      String str = nativeAddNativeOverlay(paramInt1, this.mNativeMapengineInstance, paramInt2, paramInt3);
      if (TextUtils.isEmpty(str)) {
        return null;
      }
      return str;
    }
    return null;
  }
  
  public void addOverlayTexture(int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3)
  {
    GLTextureProperty localGLTextureProperty = new GLTextureProperty();
    localGLTextureProperty.mId = paramInt2;
    localGLTextureProperty.mAnchor = paramInt3;
    localGLTextureProperty.mBitmap = paramBitmap;
    localGLTextureProperty.mXRatio = 0.0F;
    localGLTextureProperty.mYRatio = 0.0F;
    localGLTextureProperty.isGenMimps = true;
    addOverlayTexture(paramInt1, localGLTextureProperty);
  }
  
  public void addOverlayTexture(int paramInt, GLTextureProperty paramGLTextureProperty)
  {
    if ((this.mNativeMapengineInstance != 0L) && (paramGLTextureProperty != null) && (paramGLTextureProperty.mBitmap != null) && (!paramGLTextureProperty.mBitmap.isRecycled())) {
      nativeAddOverlayTexture(paramInt, this.mNativeMapengineInstance, paramGLTextureProperty.mId, paramGLTextureProperty.mAnchor, paramGLTextureProperty.mXRatio, paramGLTextureProperty.mYRatio, paramGLTextureProperty.mBitmap, paramGLTextureProperty.isGenMimps, paramGLTextureProperty.isRepeat);
    }
  }
  
  public boolean canStopMapRender(int paramInt)
  {
    return this.isEngineRenderComplete;
  }
  
  public void cancelAllAMapDownload()
  {
    try
    {
      synchronized (this.aMapLoaderHashtable)
      {
        Iterator localIterator = this.aMapLoaderHashtable.entrySet().iterator();
        while (localIterator.hasNext())
        {
          AMapLoader localAMapLoader = (AMapLoader)((Map.Entry)localIterator.next()).getValue();
          localAMapLoader.doCancel();
          if (!localAMapLoader.isFinish) {
            try
            {
              if (!localAMapLoader.isFinish)
              {
                localAMapLoader.notify();
                localAMapLoader.isFinish = true;
              }
            }
            finally {}
          }
        }
        this.aMapLoaderHashtable.clear();
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void cancelRequireMapData(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof AMapLoader))) {
      ((AMapLoader)paramObject).doCancel();
    }
  }
  
  public void changeSurface(int paramInt1, int paramInt2) {}
  
  public void clearAllMessages(int paramInt) {}
  
  public void clearAnimations(int paramInt, boolean paramBoolean)
  {
    this.mapAnimationMgr.clearAnimations();
  }
  
  public void clearAnimations(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.mapAnimationMgr.clearAnimations();
  }
  
  public void createAMapEngineWithFrame(MapViewInitParam paramMapViewInitParam)
  {
    if (this.mNativeMapengineInstance != 0L) {
      try
      {
        nativeCreateAMapEngineWithFrame(this.mNativeMapengineInstance, paramMapViewInitParam.engineId, paramMapViewInitParam.x, paramMapViewInitParam.y, paramMapViewInitParam.width, paramMapViewInitParam.height, paramMapViewInitParam.screenWidth, paramMapViewInitParam.screenHeight, paramMapViewInitParam.screenScale, paramMapViewInitParam.textScale, paramMapViewInitParam.mapZoomScale);
        return;
      }
      finally {}
    }
  }
  
  public void createAMapInstance(InitParam paramInitParam)
  {
    if (paramInitParam == null) {
      return;
    }
    try
    {
      nativeInitParam(paramInitParam.mRootPath, paramInitParam.mConfigContent, paramInitParam.mOfflineDataPath, paramInitParam.mP3dCrossPath);
      paramInitParam = this.context.getResources().getDisplayMetrics();
      int i = paramInitParam.densityDpi;
      float f1 = paramInitParam.density;
      float f2 = adapterDpiScale(paramInitParam, paramInitParam.widthPixels, paramInitParam.heightPixels, paramInitParam.densityDpi);
      this.mNativeMapengineInstance = nativeCreateAMapInstance("", "http://mpsapi.amap.com/", "http://m5.amap.com/", i, f1, f2);
      nativeInitAMapEngineCallback(this.mNativeMapengineInstance, this);
      initNetworkState();
      return;
    }
    finally {}
  }
  
  public long createOverlay(int paramInt1, int paramInt2)
  {
    if (this.mNativeMapengineInstance != 0L) {
      return nativeCreateOverlay(paramInt1, this.mNativeMapengineInstance, paramInt2);
    }
    return 0L;
  }
  
  public void destroyAMapEngine()
  {
    try
    {
      this.mRequestDestroy = true;
      cancelAllAMapDownload();
      synchronized (this.mutLock)
      {
        if (this.mNativeMapengineInstance != 0L) {
          try
          {
            if (this.copyGLMapState != null) {
              this.copyGLMapState.recycle();
            }
            nativeDestroyCurrentState(this.mNativeMapengineInstance, this.state.getNativeInstance());
            nativeDestroy(this.mNativeMapengineInstance);
          }
          finally {}
        }
        this.mNativeMapengineInstance = 0L;
        this.mGlMapView = null;
        this.mStateMessageList.clear();
        this.mAnimateStateMessageList.clear();
        this.mGestureEndMessageList.clear();
        this.mGestureMessageList.clear();
        this.mMapListener = null;
        this.bundle = null;
        dw.b();
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void finishDownLoad(int paramInt, long paramLong)
  {
    try
    {
      boolean bool = this.aMapLoaderHashtable.containsKey(Long.valueOf(paramLong));
      if (!bool) {
        return;
      }
      if (this.mNativeMapengineInstance != 0L) {
        nativeFinishDownLoad(paramInt, this.mNativeMapengineInstance, paramLong);
      }
      this.aMapLoaderHashtable.remove(Long.valueOf(paramLong));
      return;
    }
    finally {}
  }
  
  public int generateRequestId()
  {
    return this.mRequestID.incrementAndGet();
  }
  
  public int getAnimateionsCount()
  {
    if (this.mNativeMapengineInstance != 0L) {
      return this.mapAnimationMgr.getAnimationsCount();
    }
    return 0;
  }
  
  /* Error */
  public GLMapState getCloneMapState()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 106	com/autonavi/base/ae/gmap/GLMapEngine:mLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 759 1 0
    //   11: aload_0
    //   12: getfield 78	com/autonavi/base/ae/gmap/GLMapEngine:mNativeMapengineInstance	J
    //   15: lconst_0
    //   16: lcmp
    //   17: ifeq +114 -> 131
    //   20: aload_0
    //   21: getfield 101	com/autonavi/base/ae/gmap/GLMapEngine:copyGLMapState	Lcom/autonavi/base/ae/gmap/GLMapState;
    //   24: ifnonnull +19 -> 43
    //   27: aload_0
    //   28: new 418	com/autonavi/base/ae/gmap/GLMapState
    //   31: dup
    //   32: iconst_1
    //   33: aload_0
    //   34: getfield 78	com/autonavi/base/ae/gmap/GLMapEngine:mNativeMapengineInstance	J
    //   37: invokespecial 761	com/autonavi/base/ae/gmap/GLMapState:<init>	(IJ)V
    //   40: putfield 101	com/autonavi/base/ae/gmap/GLMapEngine:copyGLMapState	Lcom/autonavi/base/ae/gmap/GLMapState;
    //   43: aload_0
    //   44: getfield 101	com/autonavi/base/ae/gmap/GLMapEngine:copyGLMapState	Lcom/autonavi/base/ae/gmap/GLMapState;
    //   47: aload_0
    //   48: getfield 80	com/autonavi/base/ae/gmap/GLMapEngine:mGlMapView	Lcom/autonavi/base/amap/api/mapcore/IAMapDelegate;
    //   51: invokeinterface 765 1 0
    //   56: invokevirtual 771	com/autonavi/base/amap/mapcore/MapConfig:getSZ	()F
    //   59: invokevirtual 775	com/autonavi/base/ae/gmap/GLMapState:setMapZoomer	(F)V
    //   62: aload_0
    //   63: getfield 101	com/autonavi/base/ae/gmap/GLMapEngine:copyGLMapState	Lcom/autonavi/base/ae/gmap/GLMapState;
    //   66: aload_0
    //   67: getfield 80	com/autonavi/base/ae/gmap/GLMapEngine:mGlMapView	Lcom/autonavi/base/amap/api/mapcore/IAMapDelegate;
    //   70: invokeinterface 765 1 0
    //   75: invokevirtual 778	com/autonavi/base/amap/mapcore/MapConfig:getSC	()F
    //   78: invokevirtual 781	com/autonavi/base/ae/gmap/GLMapState:setCameraDegree	(F)V
    //   81: aload_0
    //   82: getfield 101	com/autonavi/base/ae/gmap/GLMapEngine:copyGLMapState	Lcom/autonavi/base/ae/gmap/GLMapState;
    //   85: aload_0
    //   86: getfield 80	com/autonavi/base/ae/gmap/GLMapEngine:mGlMapView	Lcom/autonavi/base/amap/api/mapcore/IAMapDelegate;
    //   89: invokeinterface 765 1 0
    //   94: invokevirtual 784	com/autonavi/base/amap/mapcore/MapConfig:getSR	()F
    //   97: invokevirtual 787	com/autonavi/base/ae/gmap/GLMapState:setMapAngle	(F)V
    //   100: aload_0
    //   101: getfield 101	com/autonavi/base/ae/gmap/GLMapEngine:copyGLMapState	Lcom/autonavi/base/ae/gmap/GLMapState;
    //   104: aload_0
    //   105: getfield 80	com/autonavi/base/ae/gmap/GLMapEngine:mGlMapView	Lcom/autonavi/base/amap/api/mapcore/IAMapDelegate;
    //   108: invokeinterface 765 1 0
    //   113: invokevirtual 791	com/autonavi/base/amap/mapcore/MapConfig:getSX	()D
    //   116: aload_0
    //   117: getfield 80	com/autonavi/base/ae/gmap/GLMapEngine:mGlMapView	Lcom/autonavi/base/amap/api/mapcore/IAMapDelegate;
    //   120: invokeinterface 765 1 0
    //   125: invokevirtual 794	com/autonavi/base/amap/mapcore/MapConfig:getSY	()D
    //   128: invokevirtual 798	com/autonavi/base/ae/gmap/GLMapState:setMapGeoCenter	(DD)V
    //   131: aload_0
    //   132: getfield 106	com/autonavi/base/ae/gmap/GLMapEngine:mLock	Ljava/util/concurrent/locks/Lock;
    //   135: invokeinterface 801 1 0
    //   140: aload_0
    //   141: getfield 101	com/autonavi/base/ae/gmap/GLMapEngine:copyGLMapState	Lcom/autonavi/base/ae/gmap/GLMapState;
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: areturn
    //   149: astore_1
    //   150: aload_0
    //   151: getfield 106	com/autonavi/base/ae/gmap/GLMapEngine:mLock	Ljava/util/concurrent/locks/Lock;
    //   154: invokeinterface 801 1 0
    //   159: aload_1
    //   160: athrow
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	GLMapEngine
    //   144	4	1	localGLMapState	GLMapState
    //   149	11	1	localObject1	Object
    //   161	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	43	149	finally
    //   43	131	149	finally
    //   2	11	161	finally
    //   131	145	161	finally
    //   150	161	161	finally
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public void getCurTileIDs(int paramInt, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        paramArrayOfInt[i] = 0;
        i += 1;
      }
      nativeGetCurTileIDs(paramInt, this.mNativeMapengineInstance, paramArrayOfInt, paramArrayOfInt.length);
    }
  }
  
  public int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo paramEAMapPlatformGestureInfo)
  {
    long l = this.mNativeMapengineInstance;
    return 1;
  }
  
  public int getEngineIDWithType(int paramInt)
  {
    return 1;
  }
  
  public long getGlOverlayMgrPtr(int paramInt)
  {
    if (this.mNativeMapengineInstance != 0L) {
      return nativeGetGlOverlayMgrPtr(paramInt, this.mNativeMapengineInstance);
    }
    return 0L;
  }
  
  public boolean getIsProcessBuildingMark(int paramInt)
  {
    return false;
  }
  
  public byte[] getLabelBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLock.lock();
    try
    {
      byte[] arrayOfByte = new byte['ఀ'];
      if (this.mNativeMapengineInstance != 0L) {
        nativeSelectMapPois(paramInt1, this.mNativeMapengineInstance, paramInt2, paramInt3, paramInt4, arrayOfByte);
      }
      return arrayOfByte;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public boolean getMapDataTaskIsCancel(int paramInt, long paramLong)
  {
    return !this.aMapLoaderHashtable.containsKey(Long.valueOf(paramLong));
  }
  
  public int[] getMapModeState(int paramInt, boolean paramBoolean)
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativeGetMapModeState(paramInt, this.mNativeMapengineInstance, paramBoolean);
    }
    return null;
  }
  
  public GLMapState getMapState(int paramInt)
  {
    this.mLock.lock();
    try
    {
      if ((this.mNativeMapengineInstance != 0L) && (this.state == null))
      {
        long l = nativeGetCurrentMapState(paramInt, this.mNativeMapengineInstance);
        if (l != 0L) {
          this.state = new GLMapState(this.mNativeMapengineInstance, l);
        }
      }
      return this.state;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public long getMapStateInstance(int paramInt)
  {
    return 0L;
  }
  
  public long getNativeInstance()
  {
    return this.mNativeMapengineInstance;
  }
  
  public IGLMapState getNewMapState(int paramInt)
  {
    this.mLock.lock();
    try
    {
      if (this.mNativeMapengineInstance != 0L)
      {
        GLMapState localGLMapState = new GLMapState(paramInt, this.mNativeMapengineInstance);
        return localGLMapState;
      }
      return null;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public GLOverlayBundle getOverlayBundle(int paramInt)
  {
    return this.bundle;
  }
  
  public boolean getSrvViewStateBoolValue(int paramInt1, int paramInt2)
  {
    if (this.mNativeMapengineInstance != 0L) {
      return nativeGetSrvViewStateBoolValue(paramInt1, this.mNativeMapengineInstance, paramInt2);
    }
    return false;
  }
  
  public AbstractCameraUpdateMessage getStateMessage()
  {
    try
    {
      if ((this.mStateMessageList != null) && (this.mStateMessageList.size() != 0))
      {
        AbstractCameraUpdateMessage localAbstractCameraUpdateMessage = (AbstractCameraUpdateMessage)this.mStateMessageList.get(0);
        this.mStateMessageList.remove(localAbstractCameraUpdateMessage);
        return localAbstractCameraUpdateMessage;
      }
      return null;
    }
    finally {}
  }
  
  public int getStateMessageCount()
  {
    return this.mStateMessageList.size();
  }
  
  public String getUserAgent()
  {
    return this.userAgent;
  }
  
  public void initNativeTexture(int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
        Bitmap localBitmap = null;
        if (localObject1 != null)
        {
          localObject1 = ((BitmapDescriptor)localObject1).getBitmap();
          localObject3 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
          if (localObject3 == null) {
            break label103;
          }
          localObject3 = ((BitmapDescriptor)localObject3).getBitmap();
          BitmapDescriptor localBitmapDescriptor = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
          if (localBitmapDescriptor != null) {
            localBitmap = localBitmapDescriptor.getBitmap();
          }
          addOverlayTexture(paramInt, (Bitmap)localObject1, 111, 4);
          addOverlayTexture(paramInt, (Bitmap)localObject3, 222, 4);
          addOverlayTexture(paramInt, localBitmap, 333, 4);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      Object localObject2 = null;
      continue;
      label103:
      Object localObject3 = null;
    }
  }
  
  public void interruptAnimation()
  {
    if (isInMapAnimation(1)) {
      try
      {
        doMapAnimationCancelCallback(this.mapAnimationMgr.getCancelCallback());
        clearAnimations(1, false);
        return;
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, getClass().getName(), "CancelableCallback.onCancel");
        localThrowable.printStackTrace();
      }
    }
  }
  
  public boolean isEngineCreated(int paramInt)
  {
    if (this.mNativeMapengineInstance != 0L) {
      return nativeIsEngineCreated(this.mNativeMapengineInstance, paramInt);
    }
    return false;
  }
  
  public boolean isInMapAction(int paramInt)
  {
    return false;
  }
  
  public boolean isInMapAnimation(int paramInt)
  {
    return getAnimateionsCount() > 0;
  }
  
  public void netError(int paramInt1, long paramLong, int paramInt2)
  {
    try
    {
      boolean bool = this.aMapLoaderHashtable.containsKey(Long.valueOf(paramLong));
      if (!bool) {
        return;
      }
      if (this.mNativeMapengineInstance != 0L) {
        nativeCancelDownLoad(paramInt1, this.mNativeMapengineInstance, paramLong);
      }
      this.aMapLoaderHashtable.remove(Long.valueOf(paramLong));
      return;
    }
    finally {}
  }
  
  public void networkStateChanged(Context paramContext)
  {
    if (this.mRequestDestroy) {
      return;
    }
    if (this.mNativeMapengineInstance != 0L)
    {
      final boolean bool = NetworkState.isNetworkConnected(paramContext);
      this.mGlMapView.queueEvent(new Runnable()
      {
        public void run()
        {
          throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
      });
    }
  }
  
  public void onClearCache(int paramInt) {}
  
  public void onMapRender(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 13) {
      switch (paramInt2)
      {
      default: 
        return;
      }
    }
    try
    {
      if (this.mMapListener != null)
      {
        this.mMapListener.afterRendererOver(paramInt1, getMapState(paramInt1));
        return;
        if (this.mMapListener != null)
        {
          this.mMapListener.afterDrawLabel(paramInt1, getMapState(paramInt1));
          return;
          if (this.mMapListener != null)
          {
            this.mMapListener.beforeDrawLabel(paramInt1, getMapState(paramInt1));
            return;
            this.isEngineRenderComplete = true;
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void popRendererState()
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativePopRenderState(1, this.mNativeMapengineInstance);
    }
  }
  
  public void pushRendererState()
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativePushRendererState(1, this.mNativeMapengineInstance);
    }
  }
  
  public void putResourceData(int paramInt, byte[] paramArrayOfByte) {}
  
  public void receiveNetData(int paramInt1, long paramLong, byte[] paramArrayOfByte, int paramInt2)
  {
    try
    {
      boolean bool = this.mRequestDestroy;
      if (bool) {
        return;
      }
      bool = this.aMapLoaderHashtable.containsKey(Long.valueOf(paramLong));
      if (!bool) {
        return;
      }
      if (this.mNativeMapengineInstance != 0L) {
        nativeReceiveNetData(paramInt1, this.mNativeMapengineInstance, paramArrayOfByte, paramLong, paramInt2);
      }
      return;
    }
    finally {}
  }
  
  public void releaseNetworkState()
  {
    if (this.mNetworkState != null)
    {
      this.mNetworkState.registerNetChangeReceiver(this.context.getApplicationContext(), false);
      this.mNetworkState.setNetworkListener(null);
      this.mNetworkState = null;
    }
  }
  
  public void reloadMapResource(int paramInt1, String paramString, int paramInt2) {}
  
  public void removeNativeAllOverlay(int paramInt)
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativeRemoveNativeAllOverlay(paramInt, this.mNativeMapengineInstance);
    }
  }
  
  public void removeNativeOverlay(int paramInt, String paramString)
  {
    if ((this.mNativeMapengineInstance != 0L) && (paramString != null)) {
      nativeRemoveNativeOverlay(paramInt, this.mNativeMapengineInstance, paramString);
    }
  }
  
  public void renderAMap()
  {
    if (this.mNativeMapengineInstance != 0L)
    {
      boolean bool = processMessage();
      try
      {
        nativeRenderAMap(this.mNativeMapengineInstance, 1);
        nativePostRenderAMap(this.mNativeMapengineInstance, 1);
        initAnimation();
        if (bool) {
          startCheckEngineRenderComplete();
        }
        if (!this.isEngineRenderComplete)
        {
          nativeSetRenderListenerStatus(1, this.mNativeMapengineInstance);
          return;
        }
      }
      finally {}
    }
  }
  
  public byte[] requireCharBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.mTextTextureGenerator.getTextPixelBuffer(paramInt2, paramInt3);
  }
  
  public byte[] requireCharsWidths(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    return this.mTextTextureGenerator.getCharsWidths(paramArrayOfInt);
  }
  
  public void requireMapData(int paramInt, byte[] paramArrayOfByte) {}
  
  public int requireMapDataAsyn(int paramInt, final byte[] paramArrayOfByte)
  {
    if (this.mRequestDestroy) {
      return 0;
    }
    if (paramArrayOfByte != null)
    {
      AMapLoader.ADataRequestParam localADataRequestParam = new AMapLoader.ADataRequestParam();
      int i = GLConvertUtil.getInt(paramArrayOfByte, 0);
      localADataRequestParam.requestBaseUrl = GLConvertUtil.getString(paramArrayOfByte, 4, i);
      int j = i + 4;
      i = GLConvertUtil.getInt(paramArrayOfByte, j);
      j += 4;
      localADataRequestParam.requestUrl = GLConvertUtil.getString(paramArrayOfByte, j, i);
      i = j + i;
      localADataRequestParam.handler = GLConvertUtil.getLong(paramArrayOfByte, i);
      i += 8;
      localADataRequestParam.nRequestType = GLConvertUtil.getInt(paramArrayOfByte, i);
      j = i + 4;
      i = GLConvertUtil.getInt(paramArrayOfByte, j);
      j += 4;
      localADataRequestParam.enCodeString = GLConvertUtil.getSubBytes(paramArrayOfByte, j, i);
      localADataRequestParam.nCompress = GLConvertUtil.getInt(paramArrayOfByte, j + i);
      paramArrayOfByte = new AMapLoader(paramInt, this, localADataRequestParam);
      try
      {
        this.aMapLoaderHashtable.put(Long.valueOf(localADataRequestParam.handler), paramArrayOfByte);
        paramArrayOfByte.isFinish = false;
        try
        {
          dw.a().a(new Runnable()
          {
            /* Error */
            public void run()
            {
              // Byte code:
              //   0: aload_0
              //   1: getfield 19	com/autonavi/base/ae/gmap/GLMapEngine$1:this$0	Lcom/autonavi/base/ae/gmap/GLMapEngine;
              //   4: getfield 32	com/autonavi/base/ae/gmap/GLMapEngine:mRequestDestroy	Z
              //   7: istore_1
              //   8: iload_1
              //   9: ifeq +61 -> 70
              //   12: aload_0
              //   13: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   16: ifnull +53 -> 69
              //   19: aload_0
              //   20: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   23: getfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   26: ifne +43 -> 69
              //   29: aload_0
              //   30: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   33: astore_2
              //   34: aload_2
              //   35: monitorenter
              //   36: aload_0
              //   37: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   40: getfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   43: ifne +18 -> 61
              //   46: aload_0
              //   47: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   50: invokevirtual 40	java/lang/Object:notify	()V
              //   53: aload_0
              //   54: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   57: iconst_1
              //   58: putfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   61: aload_2
              //   62: monitorexit
              //   63: return
              //   64: astore_3
              //   65: aload_2
              //   66: monitorexit
              //   67: aload_3
              //   68: athrow
              //   69: return
              //   70: aload_0
              //   71: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   74: astore_2
              //   75: aload_2
              //   76: ifnonnull +61 -> 137
              //   79: aload_0
              //   80: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   83: ifnull +53 -> 136
              //   86: aload_0
              //   87: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   90: getfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   93: ifne +43 -> 136
              //   96: aload_0
              //   97: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   100: astore_2
              //   101: aload_2
              //   102: monitorenter
              //   103: aload_0
              //   104: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   107: getfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   110: ifne +18 -> 128
              //   113: aload_0
              //   114: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   117: invokevirtual 40	java/lang/Object:notify	()V
              //   120: aload_0
              //   121: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   124: iconst_1
              //   125: putfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   128: aload_2
              //   129: monitorexit
              //   130: return
              //   131: astore_3
              //   132: aload_2
              //   133: monitorexit
              //   134: aload_3
              //   135: athrow
              //   136: return
              //   137: aload_0
              //   138: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   141: invokevirtual 43	com/autonavi/base/amap/mapcore/maploader/AMapLoader:doRequest	()V
              //   144: aload_0
              //   145: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   148: ifnull +123 -> 271
              //   151: aload_0
              //   152: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   155: getfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   158: ifne +113 -> 271
              //   161: aload_0
              //   162: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   165: astore_2
              //   166: aload_2
              //   167: monitorenter
              //   168: aload_0
              //   169: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   172: getfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   175: ifne +18 -> 193
              //   178: aload_0
              //   179: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   182: invokevirtual 40	java/lang/Object:notify	()V
              //   185: aload_0
              //   186: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   189: iconst_1
              //   190: putfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   193: aload_2
              //   194: monitorexit
              //   195: return
              //   196: astore_3
              //   197: aload_2
              //   198: monitorexit
              //   199: aload_3
              //   200: athrow
              //   201: astore_3
              //   202: goto +70 -> 272
              //   205: astore_2
              //   206: aload_2
              //   207: ldc 45
              //   209: ldc 47
              //   211: invokestatic 53	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
              //   214: aload_0
              //   215: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   218: ifnull +53 -> 271
              //   221: aload_0
              //   222: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   225: getfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   228: ifne +43 -> 271
              //   231: aload_0
              //   232: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   235: astore_2
              //   236: aload_2
              //   237: monitorenter
              //   238: aload_0
              //   239: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   242: getfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   245: ifne +18 -> 263
              //   248: aload_0
              //   249: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   252: invokevirtual 40	java/lang/Object:notify	()V
              //   255: aload_0
              //   256: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   259: iconst_1
              //   260: putfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   263: aload_2
              //   264: monitorexit
              //   265: return
              //   266: astore_3
              //   267: aload_2
              //   268: monitorexit
              //   269: aload_3
              //   270: athrow
              //   271: return
              //   272: aload_0
              //   273: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   276: ifnull +55 -> 331
              //   279: aload_0
              //   280: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   283: getfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   286: ifne +45 -> 331
              //   289: aload_0
              //   290: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   293: astore_2
              //   294: aload_2
              //   295: monitorenter
              //   296: aload_0
              //   297: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   300: getfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   303: ifne +18 -> 321
              //   306: aload_0
              //   307: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   310: invokevirtual 40	java/lang/Object:notify	()V
              //   313: aload_0
              //   314: getfield 21	com/autonavi/base/ae/gmap/GLMapEngine$1:val$mapLoader	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader;
              //   317: iconst_1
              //   318: putfield 37	com/autonavi/base/amap/mapcore/maploader/AMapLoader:isFinish	Z
              //   321: aload_2
              //   322: monitorexit
              //   323: goto +8 -> 331
              //   326: astore_3
              //   327: aload_2
              //   328: monitorexit
              //   329: aload_3
              //   330: athrow
              //   331: aload_3
              //   332: athrow
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	333	0	this	1
              //   7	2	1	bool	boolean
              //   205	2	2	localThrowable	Throwable
              //   64	4	3	localObject1	Object
              //   131	4	3	localObject2	Object
              //   196	4	3	localObject3	Object
              //   201	1	3	localObject4	Object
              //   266	4	3	localObject5	Object
              //   326	6	3	localObject6	Object
              // Exception table:
              //   from	to	target	type
              //   36	61	64	finally
              //   61	63	64	finally
              //   65	67	64	finally
              //   103	128	131	finally
              //   128	130	131	finally
              //   132	134	131	finally
              //   168	193	196	finally
              //   193	195	196	finally
              //   197	199	196	finally
              //   0	8	201	finally
              //   70	75	201	finally
              //   137	144	201	finally
              //   206	214	201	finally
              //   0	8	205	java/lang/Throwable
              //   70	75	205	java/lang/Throwable
              //   137	144	205	java/lang/Throwable
              //   238	263	266	finally
              //   263	265	266	finally
              //   267	269	266	finally
              //   296	321	326	finally
              //   321	323	326	finally
              //   327	329	326	finally
            }
          });
          try
          {
            while (!paramArrayOfByte.isFinish) {
              paramArrayOfByte.wait();
            }
            return 0;
          }
          finally {}
          paramArrayOfByte = finally;
        }
        catch (Throwable paramArrayOfByte)
        {
          gk.c(paramArrayOfByte, "download Thread", "requireMapData");
          return 0;
        }
        return 0;
      }
      finally {}
    }
  }
  
  public void requireMapRender(int paramInt1, int paramInt2, int paramInt3) {}
  
  public byte[] requireMapResource(int paramInt, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("map_assets/");
    ((StringBuilder)localObject).append(paramString);
    String str = ((StringBuilder)localObject).toString();
    do
    {
      try
      {
        if (this.mGlMapView.getMapConfig().isCustomStyleEnable())
        {
          if (paramString.startsWith("icons_5"))
          {
            paramString = FileUtil.readFileContents(this.mGlMapView.getMapConfig().getCustomTextureResourcePath());
            continue;
          }
          if (paramString.startsWith("bktile"))
          {
            localObject = FileUtil.readFileContentsFromAssets(this.context, str);
            paramInt = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
            paramString = (String)localObject;
            if (paramInt == 0) {
              continue;
            }
            paramString = dx.a((byte[])localObject, paramInt);
            continue;
          }
        }
        else
        {
          paramString = FileUtil.readFileContentsFromAssets(this.context, str);
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        return null;
      }
      paramString = null;
    } while (paramString == null);
    return paramString;
  }
  
  public void setAllContentEnable(int paramInt, boolean paramBoolean)
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetAllContentEnable(paramInt, this.mNativeMapengineInstance, paramBoolean);
    }
  }
  
  public void setBackgroundTexture(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetSetBackgroundTexture(paramInt, this.mNativeMapengineInstance, paramArrayOfByte);
    }
  }
  
  public void setBuildingEnable(int paramInt, boolean paramBoolean)
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetBuildingEnable(paramInt, this.mNativeMapengineInstance, paramBoolean);
    }
  }
  
  public void setBuildingTextureEnable(int paramInt, boolean paramBoolean)
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetBuildingTextureEnable(paramInt, this.mNativeMapengineInstance, paramBoolean);
    }
  }
  
  public void setCustomStyleData(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      return;
    }
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetCustomStyleData(paramInt, this.mNativeMapengineInstance, paramArrayOfByte1, paramArrayOfByte2);
    }
  }
  
  public void setCustomStyleTexture(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetCustomStyleTexture(paramInt, this.mNativeMapengineInstance, paramArrayOfByte);
    }
  }
  
  public void setHighlightSubwayEnable(int paramInt, boolean paramBoolean)
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetHighlightSubwayEnable(paramInt, this.mNativeMapengineInstance, paramBoolean);
    }
  }
  
  public void setIndoorBuildingToBeActive(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (this.mNativeMapengineInstance != 0L) {
        nativeSetIndoorBuildingToBeActive(paramInt1, this.mNativeMapengineInstance, paramString1, paramInt2, paramString2);
      }
      return;
    }
  }
  
  public void setIndoorEnable(int paramInt, boolean paramBoolean)
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetIndoorEnable(paramInt, this.mNativeMapengineInstance, paramBoolean);
    }
  }
  
  public void setInternaltexture(int paramInt1, byte[] paramArrayOfByte, int paramInt2) {}
  
  public void setLabelEnable(int paramInt, boolean paramBoolean)
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetLabelEnable(paramInt, this.mNativeMapengineInstance, paramBoolean);
    }
  }
  
  public void setMapListener(IAMapListener paramIAMapListener)
  {
    this.mMapListener = paramIAMapListener;
  }
  
  public void setMapLoaderToTask(int paramInt, long paramLong, AMapLoader paramAMapLoader) {}
  
  public boolean setMapModeAndStyle(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, StyleItem[] paramArrayOfStyleItem)
  {
    if (this.mNativeMapengineInstance == 0L) {
      return false;
    }
    paramBoolean1 = setNativeMapModeAndStyle(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, paramArrayOfStyleItem);
    StringBuilder localStringBuilder;
    if ((paramArrayOfStyleItem != null) && (paramBoolean2))
    {
      paramInt2 = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
      if (paramInt2 != 0)
      {
        paramArrayOfStyleItem = this.context;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("map_assets");
        localStringBuilder.append(File.separator);
        localStringBuilder.append("bktile.data");
        setBackgroundTexture(paramInt1, dx.a(FileUtil.readFileContentsFromAssets(paramArrayOfStyleItem, localStringBuilder.toString()), paramInt2));
      }
      paramArrayOfStyleItem = this.mGlMapView.getMapConfig().getCustomTextureResourcePath();
      if ((this.mGlMapView.getMapConfig().isProFunctionAuthEnable()) && (!TextUtils.isEmpty(paramArrayOfStyleItem)))
      {
        this.mGlMapView.getMapConfig().setUseProFunction(true);
        setCustomStyleTexture(paramInt1, FileUtil.readFileContents(paramArrayOfStyleItem));
        return paramBoolean1;
      }
    }
    else if ((paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0))
    {
      paramArrayOfStyleItem = this.context;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("map_assets");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("bktile.data");
      setBackgroundTexture(paramInt1, FileUtil.readFileContentsFromAssets(paramArrayOfStyleItem, localStringBuilder.toString()));
      paramArrayOfStyleItem = this.context;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("map_assets");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("icons_5_16_1561028345.data");
      setCustomStyleTexture(paramInt1, FileUtil.readFileContentsFromAssets(paramArrayOfStyleItem, localStringBuilder.toString()));
    }
    return paramBoolean1;
  }
  
  public void setMapOpenLayer(String paramString)
  {
    if ((this.mNativeMapengineInstance != 0L) && (paramString != null)) {
      nativesetMapOpenLayer(1, this.mNativeMapengineInstance, paramString.getBytes());
    }
  }
  
  public void setMapState(int paramInt, GLMapState paramGLMapState)
  {
    setMapState(paramInt, paramGLMapState, true);
  }
  
  public void setMapState(int paramInt, GLMapState paramGLMapState, boolean paramBoolean)
  {
    if (this.mNativeMapengineInstance != 0L)
    {
      if ((paramBoolean) && (this.mGlMapView != null) && (this.mGlMapView.getMapConfig() != null)) {
        this.mGlMapView.checkMapState(paramGLMapState);
      }
      this.mLock.lock();
      try
      {
        paramGLMapState.setNativeMapengineState(paramInt, this.mNativeMapengineInstance);
        return;
      }
      finally
      {
        this.mLock.unlock();
      }
    }
  }
  
  public boolean setNativeMapModeAndStyle(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, StyleItem[] paramArrayOfStyleItem)
  {
    if (this.mNativeMapengineInstance == 0L) {
      return false;
    }
    return nativeSetMapModeAndStyle(paramInt1, this.mNativeMapengineInstance, new int[] { paramInt2, paramInt3, paramInt4, 0, 0 }, paramBoolean1, paramBoolean2, paramArrayOfStyleItem);
  }
  
  public void setOfflineDataEnable(int paramInt, boolean paramBoolean)
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetOfflineDataEnable(paramInt, this.mNativeMapengineInstance, paramBoolean);
    }
  }
  
  public void setOvelayBundle(int paramInt, GLOverlayBundle<BaseMapOverlay<?, ?>> paramGLOverlayBundle)
  {
    this.bundle = paramGLOverlayBundle;
  }
  
  public void setParamater(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mLock.lock();
    try
    {
      if (this.mNativeMapengineInstance != 0L) {
        nativeSetParameter(paramInt1, this.mNativeMapengineInstance, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      }
      return;
    }
    finally
    {
      this.mLock.unlock();
    }
  }
  
  public void setProjectionCenter(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetProjectionCenter(paramInt1, this.mNativeMapengineInstance, paramInt2, paramInt3);
    }
  }
  
  public void setRoadArrowEnable(int paramInt, boolean paramBoolean)
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetRoadArrowEnable(paramInt, this.mNativeMapengineInstance, paramBoolean);
    }
  }
  
  public void setServiceViewRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    nativeSetServiceViewRect(paramInt1, this.mNativeMapengineInstance, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public void setSimple3DEnable(int paramInt, boolean paramBoolean)
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetSimple3DEnable(paramInt, this.mNativeMapengineInstance, paramBoolean);
    }
  }
  
  public void setSkyTexture(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetSkyTexture(paramInt, this.mNativeMapengineInstance, paramArrayOfByte);
    }
  }
  
  public void setSrvViewStateBoolValue(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetSrvViewStateBoolValue(paramInt1, this.mNativeMapengineInstance, paramInt2, paramBoolean);
    }
  }
  
  public void setTrafficEnable(int paramInt, boolean paramBoolean)
  {
    if (this.mNativeMapengineInstance != 0L) {
      nativeSetTrafficEnable(paramInt, this.mNativeMapengineInstance, paramBoolean);
    }
  }
  
  public void setTrafficStyle(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    setTrafficStyle(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, true);
  }
  
  public void setTrafficStyle(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (this.mNativeMapengineInstance != 0L)
    {
      Object localObject = this.context;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("map_assets");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("tmc_allinone.data");
      localObject = FileUtil.readFileContentsFromAssets((Context)localObject, localStringBuilder.toString());
      if (paramBoolean)
      {
        localObject = dx.a((byte[])localObject, new int[] { paramInt4, paramInt5, paramInt3, paramInt2 });
        nativeSetTrafficTextureAllInOne(paramInt1, this.mNativeMapengineInstance, (byte[])localObject);
        return;
      }
      nativeSetTrafficTextureAllInOne(paramInt1, this.mNativeMapengineInstance, (byte[])localObject);
    }
  }
  
  public void startCheckEngineRenderComplete()
  {
    this.isEngineRenderComplete = false;
  }
  
  public void startMapSlidAnim(int paramInt, Point paramPoint, float paramFloat1, float paramFloat2)
  {
    if (paramPoint == null) {
      return;
    }
    float f5;
    float f6;
    float f4;
    try
    {
      clearAnimations(paramInt, true);
      paramPoint = getCloneMapState();
      paramPoint.reset();
      paramPoint.recalculate();
      f5 = Math.abs(paramFloat1);
      f6 = Math.abs(paramFloat2);
      if (f5 <= f6) {
        break label199;
      }
      f4 = f5;
    }
    catch (Throwable paramPoint)
    {
      Object localObject;
      label65:
      label88:
      paramPoint.printStackTrace();
      return;
    }
    float f1 = paramFloat2 * (localObject / f5);
    break label88;
    float f2 = paramFloat1 * (localObject / f6);
    if (paramFloat2 > 0.0F) {
      f1 = localObject;
    }
    for (;;)
    {
      paramInt = this.mGlMapView.getMapWidth() >> 1;
      int i = this.mGlMapView.getMapHeight() >> 1;
      if (this.mGlMapView.isUseAnchor())
      {
        paramInt = this.mGlMapView.getMapConfig().getAnchorX();
        i = this.mGlMapView.getMapConfig().getAnchorY();
      }
      AdglMapAnimFling localAdglMapAnimFling = new AdglMapAnimFling(500, paramInt, i);
      localAdglMapAnimFling.setPositionAndVelocity(f2, f1);
      localAdglMapAnimFling.commitAnimation(paramPoint);
      this.mapAnimationMgr.addAnimation(localAdglMapAnimFling, null);
      return;
      label199:
      f4 = f6;
      float f3 = '⻠';
      f2 = paramFloat1;
      f1 = paramFloat2;
      if (f4 > f3)
      {
        if (f5 <= f6) {
          break label65;
        }
        if (paramFloat1 > 0.0F)
        {
          f2 = f3;
          break;
        }
        f2 = '턠';
        break;
        f1 = '턠';
      }
    }
  }
  
  public void startPivotZoomRotateAnim(int paramInt1, Point paramPoint, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((paramFloat == -9999.0F) && (paramInt2 == 55537)) {}
  }
  
  public void updateNativeArrowOverlay(int paramInt1, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    if ((this.mNativeMapengineInstance != 0L) && (paramString != null)) {
      nativeUpdateNativeArrowOverlay(paramInt1, this.mNativeMapengineInstance, paramString, paramArrayOfInt1, paramArrayOfInt2, paramInt2, paramInt3, paramInt4, paramFloat, paramBoolean, paramInt5, paramInt6, paramInt7);
    }
  }
  
  public static class InitParam
  {
    public String mConfigContent;
    public String mConfigPath;
    public String mOfflineDataPath;
    public String mP3dCrossPath;
    public String mRootPath;
  }
  
  public static class MapViewInitParam
  {
    public int engineId;
    public int height;
    public float mapZoomScale;
    public int screenHeight;
    public float screenScale;
    public int screenWidth;
    public float textScale;
    public int width;
    public int x;
    public int y;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\GLMapEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */