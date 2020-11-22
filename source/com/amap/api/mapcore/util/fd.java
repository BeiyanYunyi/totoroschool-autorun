package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

public class fd
  extends ViewGroup
  implements IInfoWindowAction
{
  eg a;
  v b;
  private IAMapDelegate c;
  private Context d;
  private fg e;
  private fc f;
  private fa g;
  private ff h;
  private ez i;
  private fb j;
  private eh k;
  private View l;
  private BaseOverlayImp m;
  private Drawable n = null;
  private boolean o;
  private View p;
  private boolean q;
  private boolean r;
  
  public fd(Context paramContext, IAMapDelegate paramIAMapDelegate)
  {
    super(paramContext);
    int i1 = 1;
    this.o = true;
    this.r = true;
    for (;;)
    {
      try
      {
        this.c = paramIAMapDelegate;
        this.d = paramContext;
        this.a = new eg();
        this.i = new ez(paramContext);
        paramIAMapDelegate = new ViewGroup.LayoutParams(-1, -1);
        if (this.c.getGLMapView() == null) {
          break label124;
        }
        addView(this.c.getGLMapView(), 0, paramIAMapDelegate);
        addView(this.i, i1, paramIAMapDelegate);
        if (!this.r)
        {
          a(paramContext);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
      return;
      label124:
      i1 = 0;
    }
  }
  
  /* Error */
  private View a(BaseOverlayImp paramBaseOverlayImp)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 109
    //   4: istore_2
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: iload_2
    //   12: ifeq +204 -> 216
    //   15: new 111	com/amap/api/maps/model/Marker
    //   18: dup
    //   19: aload_1
    //   20: checkcast 109	com/amap/api/mapcore/util/ca
    //   23: invokespecial 114	com/amap/api/maps/model/Marker:<init>	(Lcom/autonavi/amap/mapcore/interfaces/IMarker;)V
    //   26: astore 5
    //   28: aload_0
    //   29: getfield 60	com/amap/api/mapcore/util/fd:n	Landroid/graphics/drawable/Drawable;
    //   32: ifnonnull +32 -> 64
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 68	com/amap/api/mapcore/util/fd:d	Landroid/content/Context;
    //   40: ldc 116
    //   42: invokestatic 121	com/amap/api/mapcore/util/dm:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   45: putfield 60	com/amap/api/mapcore/util/fd:n	Landroid/graphics/drawable/Drawable;
    //   48: goto +16 -> 64
    //   51: astore_1
    //   52: aload_1
    //   53: ldc 123
    //   55: ldc 125
    //   57: invokestatic 130	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_1
    //   61: invokevirtual 100	java/lang/Throwable:printStackTrace	()V
    //   64: aload 4
    //   66: astore_3
    //   67: aload_0
    //   68: getfield 132	com/amap/api/mapcore/util/fd:q	Z
    //   71: ifeq +52 -> 123
    //   74: aload 4
    //   76: astore_3
    //   77: aload_0
    //   78: getfield 134	com/amap/api/mapcore/util/fd:b	Lcom/amap/api/mapcore/util/v;
    //   81: aload 5
    //   83: invokevirtual 139	com/amap/api/mapcore/util/v:a	(Lcom/amap/api/maps/model/BasePointOverlay;)Landroid/view/View;
    //   86: astore_1
    //   87: aload_1
    //   88: astore_3
    //   89: aload_1
    //   90: ifnonnull +16 -> 106
    //   93: aload_0
    //   94: getfield 134	com/amap/api/mapcore/util/fd:b	Lcom/amap/api/mapcore/util/v;
    //   97: aload 5
    //   99: invokevirtual 141	com/amap/api/mapcore/util/v:b	(Lcom/amap/api/maps/model/BasePointOverlay;)Landroid/view/View;
    //   102: astore_3
    //   103: goto +3 -> 106
    //   106: aload_3
    //   107: astore_1
    //   108: aload_0
    //   109: aload_3
    //   110: putfield 143	com/amap/api/mapcore/util/fd:p	Landroid/view/View;
    //   113: aload_3
    //   114: astore_1
    //   115: aload_0
    //   116: iconst_0
    //   117: putfield 132	com/amap/api/mapcore/util/fd:q	Z
    //   120: goto +13 -> 133
    //   123: aload 4
    //   125: astore_3
    //   126: aload_0
    //   127: getfield 143	com/amap/api/mapcore/util/fd:p	Landroid/view/View;
    //   130: astore_1
    //   131: aload_1
    //   132: astore_3
    //   133: aload_3
    //   134: ifnonnull +34 -> 168
    //   137: aload_3
    //   138: astore_1
    //   139: aload_0
    //   140: getfield 134	com/amap/api/mapcore/util/fd:b	Lcom/amap/api/mapcore/util/v;
    //   143: invokevirtual 146	com/amap/api/mapcore/util/v:a	()Z
    //   146: ifne +5 -> 151
    //   149: aconst_null
    //   150: areturn
    //   151: aload_3
    //   152: astore_1
    //   153: aload_0
    //   154: getfield 134	com/amap/api/mapcore/util/fd:b	Lcom/amap/api/mapcore/util/v;
    //   157: aload 5
    //   159: invokevirtual 139	com/amap/api/mapcore/util/v:a	(Lcom/amap/api/maps/model/BasePointOverlay;)Landroid/view/View;
    //   162: astore_3
    //   163: aload_3
    //   164: astore_1
    //   165: goto +5 -> 170
    //   168: aload_3
    //   169: astore_1
    //   170: aload_1
    //   171: astore 4
    //   173: aload_1
    //   174: ifnull +237 -> 411
    //   177: aload_1
    //   178: astore_3
    //   179: aload_1
    //   180: astore 4
    //   182: aload_1
    //   183: invokevirtual 152	android/view/View:getBackground	()Landroid/graphics/drawable/Drawable;
    //   186: ifnonnull +225 -> 411
    //   189: aload_1
    //   190: astore_3
    //   191: aload_1
    //   192: aload_0
    //   193: getfield 60	com/amap/api/mapcore/util/fd:n	Landroid/graphics/drawable/Drawable;
    //   196: invokevirtual 156	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   199: aload_1
    //   200: areturn
    //   201: astore_1
    //   202: aload_1
    //   203: ldc 123
    //   205: ldc -98
    //   207: invokestatic 130	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_1
    //   211: invokevirtual 100	java/lang/Throwable:printStackTrace	()V
    //   214: aload_3
    //   215: areturn
    //   216: aload_0
    //   217: getfield 60	com/amap/api/mapcore/util/fd:n	Landroid/graphics/drawable/Drawable;
    //   220: ifnonnull +32 -> 252
    //   223: aload_0
    //   224: aload_0
    //   225: getfield 68	com/amap/api/mapcore/util/fd:d	Landroid/content/Context;
    //   228: ldc 116
    //   230: invokestatic 121	com/amap/api/mapcore/util/dm:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   233: putfield 60	com/amap/api/mapcore/util/fd:n	Landroid/graphics/drawable/Drawable;
    //   236: goto +16 -> 252
    //   239: astore_3
    //   240: aload_3
    //   241: ldc 123
    //   243: ldc 125
    //   245: invokestatic 130	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload_3
    //   249: invokevirtual 100	java/lang/Throwable:printStackTrace	()V
    //   252: aload 5
    //   254: astore_3
    //   255: new 160	com/amap/api/maps/model/GL3DModel
    //   258: dup
    //   259: aload_1
    //   260: checkcast 162	com/amap/api/mapcore/util/bx
    //   263: invokespecial 165	com/amap/api/maps/model/GL3DModel:<init>	(Lcom/autonavi/amap/mapcore/interfaces/IglModel;)V
    //   266: astore 4
    //   268: aload 5
    //   270: astore_3
    //   271: aload_0
    //   272: getfield 132	com/amap/api/mapcore/util/fd:q	Z
    //   275: ifeq +52 -> 327
    //   278: aload 5
    //   280: astore_3
    //   281: aload_0
    //   282: getfield 134	com/amap/api/mapcore/util/fd:b	Lcom/amap/api/mapcore/util/v;
    //   285: aload 4
    //   287: invokevirtual 139	com/amap/api/mapcore/util/v:a	(Lcom/amap/api/maps/model/BasePointOverlay;)Landroid/view/View;
    //   290: astore_1
    //   291: aload_1
    //   292: astore_3
    //   293: aload_1
    //   294: ifnonnull +16 -> 310
    //   297: aload_0
    //   298: getfield 134	com/amap/api/mapcore/util/fd:b	Lcom/amap/api/mapcore/util/v;
    //   301: aload 4
    //   303: invokevirtual 141	com/amap/api/mapcore/util/v:b	(Lcom/amap/api/maps/model/BasePointOverlay;)Landroid/view/View;
    //   306: astore_3
    //   307: goto +3 -> 310
    //   310: aload_3
    //   311: astore_1
    //   312: aload_0
    //   313: aload_3
    //   314: putfield 143	com/amap/api/mapcore/util/fd:p	Landroid/view/View;
    //   317: aload_3
    //   318: astore_1
    //   319: aload_0
    //   320: iconst_0
    //   321: putfield 132	com/amap/api/mapcore/util/fd:q	Z
    //   324: goto +13 -> 337
    //   327: aload 5
    //   329: astore_3
    //   330: aload_0
    //   331: getfield 143	com/amap/api/mapcore/util/fd:p	Landroid/view/View;
    //   334: astore_1
    //   335: aload_1
    //   336: astore_3
    //   337: aload_3
    //   338: ifnonnull +34 -> 372
    //   341: aload_3
    //   342: astore_1
    //   343: aload_0
    //   344: getfield 134	com/amap/api/mapcore/util/fd:b	Lcom/amap/api/mapcore/util/v;
    //   347: invokevirtual 146	com/amap/api/mapcore/util/v:a	()Z
    //   350: ifne +5 -> 355
    //   353: aconst_null
    //   354: areturn
    //   355: aload_3
    //   356: astore_1
    //   357: aload_0
    //   358: getfield 134	com/amap/api/mapcore/util/fd:b	Lcom/amap/api/mapcore/util/v;
    //   361: aload 4
    //   363: invokevirtual 139	com/amap/api/mapcore/util/v:a	(Lcom/amap/api/maps/model/BasePointOverlay;)Landroid/view/View;
    //   366: astore_3
    //   367: aload_3
    //   368: astore_1
    //   369: goto +5 -> 374
    //   372: aload_3
    //   373: astore_1
    //   374: aload_1
    //   375: astore_3
    //   376: aload_1
    //   377: invokevirtual 152	android/view/View:getBackground	()Landroid/graphics/drawable/Drawable;
    //   380: ifnonnull +13 -> 393
    //   383: aload_1
    //   384: astore_3
    //   385: aload_1
    //   386: aload_0
    //   387: getfield 60	com/amap/api/mapcore/util/fd:n	Landroid/graphics/drawable/Drawable;
    //   390: invokevirtual 156	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   393: aload_1
    //   394: areturn
    //   395: astore_1
    //   396: aload_1
    //   397: ldc 123
    //   399: ldc -98
    //   401: invokestatic 130	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   404: aload_1
    //   405: invokevirtual 100	java/lang/Throwable:printStackTrace	()V
    //   408: aload_3
    //   409: astore 4
    //   411: aload 4
    //   413: areturn
    //   414: astore 4
    //   416: aload_1
    //   417: astore_3
    //   418: aload 4
    //   420: astore_1
    //   421: goto -219 -> 202
    //   424: astore 4
    //   426: aload_1
    //   427: astore_3
    //   428: aload 4
    //   430: astore_1
    //   431: goto -35 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	fd
    //   0	434	1	paramBaseOverlayImp	BaseOverlayImp
    //   4	8	2	bool	boolean
    //   66	149	3	localObject1	Object
    //   239	10	3	localThrowable1	Throwable
    //   254	174	3	localObject2	Object
    //   9	403	4	localObject3	Object
    //   414	5	4	localThrowable2	Throwable
    //   424	5	4	localThrowable3	Throwable
    //   6	322	5	localMarker	com.amap.api.maps.model.Marker
    // Exception table:
    //   from	to	target	type
    //   28	48	51	java/lang/Throwable
    //   67	74	201	java/lang/Throwable
    //   77	87	201	java/lang/Throwable
    //   126	131	201	java/lang/Throwable
    //   182	189	201	java/lang/Throwable
    //   191	199	201	java/lang/Throwable
    //   216	236	239	java/lang/Throwable
    //   255	268	395	java/lang/Throwable
    //   271	278	395	java/lang/Throwable
    //   281	291	395	java/lang/Throwable
    //   330	335	395	java/lang/Throwable
    //   376	383	395	java/lang/Throwable
    //   385	393	395	java/lang/Throwable
    //   93	103	414	java/lang/Throwable
    //   108	113	414	java/lang/Throwable
    //   115	120	414	java/lang/Throwable
    //   139	149	414	java/lang/Throwable
    //   153	163	414	java/lang/Throwable
    //   297	307	424	java/lang/Throwable
    //   312	317	424	java/lang/Throwable
    //   319	324	424	java/lang/Throwable
    //   343	353	424	java/lang/Throwable
    //   357	367	424	java/lang/Throwable
  }
  
  private void a(Context paramContext)
  {
    this.e = new fg(paramContext, this.c);
    this.h = new ff(paramContext, this.c);
    this.j = new fb(paramContext);
    this.k = new eh(paramContext, this.c);
    this.f = new fc(paramContext, this.c);
    this.g = new fa(paramContext, this.c);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    addView(this.e, paramContext);
    addView(this.h, paramContext);
    paramContext = new ViewGroup.LayoutParams(-2, -2);
    addView(this.j, paramContext);
    paramContext = new a(-2, -2, new FPoint(0.0F, 0.0F), 0, 0, 83);
    addView(this.k, paramContext);
    paramContext = new a(-2, -2, FPoint.obtain(0.0F, 0.0F), 0, 0, 83);
    addView(this.f, paramContext);
    paramContext = new a(-2, -2, FPoint.obtain(0.0F, 0.0F), 0, 0, 51);
    addView(this.g, paramContext);
    this.g.setVisibility(8);
    paramContext = new AMapWidgetListener()
    {
      public void invalidateCompassView()
      {
        if (fd.b(fd.this) == null) {
          return;
        }
        fd.b(fd.this).post(new Runnable()
        {
          public void run()
          {
            fd.b(fd.this).b();
          }
        });
      }
      
      public void invalidateScaleView()
      {
        if (fd.a(fd.this) == null) {
          return;
        }
        fd.a(fd.this).post(new Runnable()
        {
          public void run()
          {
            fd.a(fd.this).b();
          }
        });
      }
      
      public void invalidateZoomController(final float paramAnonymousFloat)
      {
        if (fd.c(fd.this) == null) {
          return;
        }
        fd.c(fd.this).post(new Runnable()
        {
          public void run()
          {
            fd.c(fd.this).a(paramAnonymousFloat);
          }
        });
      }
      
      public void setFrontViewVisibility(boolean paramAnonymousBoolean) {}
    };
    this.c.setMapWidgetListener(paramContext);
    try
    {
      if (!this.c.getUiSettings().isMyLocationButtonEnabled())
      {
        this.f.setVisibility(8);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      gk.c(paramContext, "AMapDelegateImpGLSurfaceView", "locationView gone");
      paramContext.printStackTrace();
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
    throws RemoteException
  {
    if (paramView == null) {
      return;
    }
    if (this.l != null)
    {
      if (paramView == this.l) {
        return;
      }
      this.l.clearFocus();
      removeView(this.l);
    }
    this.l = paramView;
    paramView = this.l.getLayoutParams();
    this.l.setDrawingCacheEnabled(true);
    this.l.setDrawingCacheQuality(0);
    this.m.getRect();
    int i1;
    int i2;
    if (paramView != null)
    {
      i1 = paramView.width;
      i2 = paramView.height;
    }
    else
    {
      i1 = -2;
      i2 = -2;
    }
    paramView = new a(i1, i2, this.m.getMapPosition(), paramInt1, paramInt2, 81);
    addView(this.l, paramView);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i2 = paramInt5 & 0x7;
    int i1 = paramInt5 & 0x70;
    if (i2 == 5)
    {
      paramInt5 = paramInt3 - paramInt1;
    }
    else
    {
      paramInt5 = paramInt3;
      if (i2 == 1) {
        paramInt5 = paramInt3 - paramInt1 / 2;
      }
    }
    if (i1 == 80)
    {
      paramInt3 = paramInt4 - paramInt2;
    }
    else if (i1 == 17)
    {
      paramInt3 = paramInt4 - paramInt2 / 2;
    }
    else
    {
      paramInt3 = paramInt4;
      if (i1 == 16) {
        paramInt3 = paramInt4 / 2 - paramInt2 / 2;
      }
    }
    paramView.layout(paramInt5, paramInt3, paramInt5 + paramInt1, paramInt3 + paramInt2);
    if ((paramView instanceof IGLSurfaceView)) {
      this.c.changeSize(paramInt1, paramInt2);
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if ((paramView instanceof ListView))
    {
      View localView = (View)paramView.getParent();
      if (localView != null)
      {
        paramArrayOfInt[0] = localView.getWidth();
        paramArrayOfInt[1] = localView.getHeight();
      }
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      paramView.measure(0, 0);
    }
    if (paramInt1 == -2) {
      paramArrayOfInt[0] = paramView.getMeasuredWidth();
    } else if (paramInt1 == -1) {
      paramArrayOfInt[0] = getMeasuredWidth();
    } else {
      paramArrayOfInt[0] = paramInt1;
    }
    if (paramInt2 == -2)
    {
      paramArrayOfInt[1] = paramView.getMeasuredHeight();
      return;
    }
    if (paramInt2 == -1)
    {
      paramArrayOfInt[1] = getMeasuredHeight();
      return;
    }
    paramArrayOfInt[1] = paramInt2;
  }
  
  private void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    int[] arrayOfInt = new int[2];
    a(paramView, paramLayoutParams.width, paramLayoutParams.height, arrayOfInt);
    if ((paramView instanceof fb))
    {
      a(paramView, arrayOfInt[0], arrayOfInt[1], 20, this.c.getWaterMarkerPositon().y - 80 - arrayOfInt[1], 51);
      return;
    }
    a(paramView, arrayOfInt[0], arrayOfInt[1], 0, 0, 51);
  }
  
  private void a(View paramView, a parama)
  {
    int[] arrayOfInt = new int[2];
    a(paramView, parama.width, parama.height, arrayOfInt);
    if ((paramView instanceof eh))
    {
      a(paramView, arrayOfInt[0], arrayOfInt[1], getWidth() - arrayOfInt[0], getHeight(), parama.d);
      return;
    }
    if ((paramView instanceof fc))
    {
      a(paramView, arrayOfInt[0], arrayOfInt[1], getWidth() - arrayOfInt[0], arrayOfInt[1], parama.d);
      return;
    }
    if ((paramView instanceof fa))
    {
      a(paramView, arrayOfInt[0], arrayOfInt[1], 0, 0, parama.d);
      return;
    }
    if (parama.a != null)
    {
      IPoint localIPoint = IPoint.obtain();
      MapConfig localMapConfig = this.c.getMapConfig();
      GLMapState localGLMapState = this.c.getMapProjection();
      if ((localMapConfig != null) && (localGLMapState != null))
      {
        FPoint localFPoint = FPoint.obtain();
        localGLMapState.p20ToScreenPoint((int)localMapConfig.getSX() + (int)parama.a.x, (int)localMapConfig.getSY() + (int)parama.a.y, localFPoint);
        localIPoint.x = ((int)localFPoint.x);
        localIPoint.y = ((int)localFPoint.y);
        localFPoint.recycle();
      }
      localIPoint.x += parama.b;
      localIPoint.y += parama.c;
      a(paramView, arrayOfInt[0], arrayOfInt[1], localIPoint.x, localIPoint.y, parama.d);
      localIPoint.recycle();
    }
  }
  
  private void m()
  {
    if (this.h == null)
    {
      this.a.a(this, new Object[0]);
      return;
    }
    if ((this.h != null) && (this.h.getVisibility() == 0)) {
      this.h.postInvalidate();
    }
  }
  
  public float a(int paramInt)
  {
    if (this.e != null)
    {
      m();
      return this.e.d(paramInt);
    }
    return 0.0F;
  }
  
  public Point a()
  {
    if (this.e == null) {
      return null;
    }
    return this.e.c();
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((this.l != null) && (this.m != null))
    {
      Bitmap localBitmap = this.l.getDrawingCache(true);
      if (localBitmap != null)
      {
        int i1 = this.l.getLeft();
        int i2 = this.l.getTop();
        paramCanvas.drawBitmap(localBitmap, i1, i2, new Paint());
      }
    }
  }
  
  public void a(fb.a parama)
  {
    if (this.j == null)
    {
      this.a.a(this, new Object[] { parama });
      return;
    }
    this.j.a(parama);
    Log.d("MapOverlayViewGroup", "setOnIndoorFloorSwitchListener");
  }
  
  public void a(CameraPosition paramCameraPosition)
  {
    if (this.e == null)
    {
      this.a.a(this, new Object[] { paramCameraPosition });
      return;
    }
    if (!this.c.getUiSettings().isLogoEnable()) {
      return;
    }
    if ((MapsInitializer.isLoadWorldGridMap()) && (paramCameraPosition.zoom >= 7.0F) && (!dq.a(paramCameraPosition.target.latitude, paramCameraPosition.target.longitude)))
    {
      this.e.setVisibility(8);
      return;
    }
    if (this.c.getMaskLayerType() == -1) {
      this.e.setVisibility(0);
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    if (this.j == null)
    {
      this.a.a(this, new Object[] { paramBoolean });
      return;
    }
    if (this.j != null)
    {
      if (!paramBoolean.booleanValue()) {
        return;
      }
      if (this.c.canShowIndoorSwitch()) {
        this.j.a(true);
      }
    }
  }
  
  public void a(Float paramFloat)
  {
    if (this.k == null)
    {
      this.a.a(this, new Object[] { paramFloat });
      return;
    }
    if (this.k != null) {
      this.k.a(paramFloat.floatValue());
    }
  }
  
  public void a(Integer paramInteger)
  {
    if (this.k == null)
    {
      this.a.a(this, new Object[] { paramInteger });
      return;
    }
    if (this.k != null) {
      this.k.a(paramInteger.intValue());
    }
  }
  
  public void a(Integer paramInteger, Float paramFloat)
  {
    if (this.e != null)
    {
      this.a.a(this, new Object[] { paramInteger, paramFloat });
      return;
    }
    if (this.e != null)
    {
      this.e.a(paramInteger.intValue(), paramFloat.floatValue());
      m();
    }
  }
  
  public void a(String paramString, Boolean paramBoolean, Integer paramInteger)
  {
    if (this.e == null)
    {
      this.a.a(this, new Object[] { paramString, paramBoolean, paramInteger });
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.e.a(paramString, paramInteger.intValue());
    this.e.b(paramBoolean.booleanValue());
  }
  
  public void b(Boolean paramBoolean)
  {
    if (this.k == null)
    {
      this.a.a(this, new Object[] { paramBoolean });
      return;
    }
    this.k.a(paramBoolean.booleanValue());
  }
  
  public void b(Integer paramInteger)
  {
    if (this.e == null)
    {
      this.a.a(this, new Object[] { paramInteger });
      return;
    }
    if (this.e != null)
    {
      this.e.a(paramInteger.intValue());
      this.e.postInvalidate();
      m();
    }
  }
  
  public boolean b()
  {
    if (this.e != null) {
      return this.e.e();
    }
    return false;
  }
  
  public void c()
  {
    if (this.e == null)
    {
      this.a.a(this, new Object[0]);
      return;
    }
    if (this.e != null) {
      this.e.d();
    }
  }
  
  public void c(Boolean paramBoolean)
  {
    if (this.f == null)
    {
      this.a.a(this, new Object[] { paramBoolean });
      return;
    }
    if (paramBoolean.booleanValue())
    {
      this.f.setVisibility(0);
      return;
    }
    this.f.setVisibility(8);
  }
  
  public void c(Integer paramInteger)
  {
    if (this.e == null)
    {
      this.a.a(this, new Object[] { paramInteger });
      return;
    }
    if (this.e != null)
    {
      this.e.b(paramInteger.intValue());
      m();
    }
  }
  
  public ez d()
  {
    return this.i;
  }
  
  public void d(Boolean paramBoolean)
  {
    if (this.g == null)
    {
      this.a.a(this, new Object[] { paramBoolean });
      return;
    }
    this.g.a(paramBoolean.booleanValue());
  }
  
  public void d(Integer paramInteger)
  {
    if (this.e == null)
    {
      this.a.a(this, new Object[] { paramInteger });
      return;
    }
    if (this.e != null)
    {
      this.e.c(paramInteger.intValue());
      m();
    }
  }
  
  public fb e()
  {
    return this.j;
  }
  
  public void e(Boolean paramBoolean)
  {
    if (this.h == null)
    {
      this.a.a(this, new Object[] { paramBoolean });
      return;
    }
    this.h.a(paramBoolean.booleanValue());
  }
  
  public fc f()
  {
    return this.f;
  }
  
  public void f(Boolean paramBoolean)
  {
    fg localfg = this.e;
    int i1 = 0;
    if (localfg == null)
    {
      this.a.a(this, new Object[] { paramBoolean });
      return;
    }
    localfg = this.e;
    if (!paramBoolean.booleanValue()) {
      i1 = 8;
    }
    localfg.setVisibility(i1);
  }
  
  public fg g()
  {
    return this.e;
  }
  
  public void g(Boolean paramBoolean)
  {
    if (this.e == null)
    {
      this.a.a(this, new Object[] { paramBoolean });
      return;
    }
    if ((this.e != null) && (paramBoolean.booleanValue()))
    {
      this.e.a(true);
      return;
    }
    if (this.e != null) {
      this.e.a(false);
    }
  }
  
  public void h()
  {
    if (this.k != null) {
      this.k.a();
    }
    if (this.h != null) {
      this.h.a();
    }
    if (this.e != null) {
      this.e.a();
    }
    if (this.f != null) {
      this.f.a();
    }
    if (this.g != null) {
      this.g.a();
    }
    if (this.j != null) {
      this.j.b();
    }
  }
  
  public void h(Boolean paramBoolean)
  {
    if (this.f == null)
    {
      this.a.a(this, new Object[] { paramBoolean });
      return;
    }
    this.f.a(paramBoolean.booleanValue());
  }
  
  public void hideInfoWindow()
  {
    if ((this.c != null) && (this.c.getMainHandler() != null))
    {
      this.c.getMainHandler().post(new Runnable()
      {
        public void run()
        {
          if (fd.d(fd.this) != null)
          {
            fd.d(fd.this).clearFocus();
            fd.this.removeView(fd.d(fd.this));
            dx.a(fd.d(fd.this).getBackground());
            dx.a(fd.e(fd.this));
            fd.a(fd.this, null);
          }
        }
      });
      if (this.m != null) {
        this.m.setInfoWindowShown(false);
      }
      this.m = null;
    }
  }
  
  public void i()
  {
    hideInfoWindow();
    dx.a(this.n);
    h();
    removeAllViews();
    this.p = null;
  }
  
  public void i(Boolean paramBoolean)
  {
    if (this.j == null)
    {
      this.a.a(this, new Object[] { paramBoolean });
      return;
    }
    this.j.a(paramBoolean.booleanValue());
  }
  
  public boolean isInfoWindowShown()
  {
    return false;
  }
  
  public void j() {}
  
  public void j(Boolean paramBoolean)
  {
    if (this.e == null)
    {
      this.a.a(this, new Object[] { paramBoolean });
      return;
    }
    paramBoolean.booleanValue();
    this.e.setVisibility(4);
  }
  
  public void k()
  {
    if (this.g == null)
    {
      this.a.a(this, new Object[0]);
      return;
    }
    this.g.b();
  }
  
  public void l()
  {
    if ((this.r) && (this.d != null))
    {
      a(this.d);
      if (this.a != null) {
        this.a.a();
      }
    }
  }
  
  public boolean onInfoWindowTap(MotionEvent paramMotionEvent)
  {
    if (this.l != null)
    {
      if (this.m == null) {
        return false;
      }
      return dx.a(new Rect(this.l.getLeft(), this.l.getTop(), this.l.getRight(), this.l.getBottom()), (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return false;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (;;)
    {
      try
      {
        paramInt2 = getChildCount();
        paramInt1 = 0;
        if (paramInt1 < paramInt2)
        {
          View localView = getChildAt(paramInt1);
          if (localView == null) {
            break label92;
          }
          if ((localView.getLayoutParams() instanceof a))
          {
            a(localView, (a)localView.getLayoutParams());
            break label92;
          }
          a(localView, localView.getLayoutParams());
          break label92;
        }
        if (this.e != null)
        {
          this.e.d();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      return;
      label92:
      paramInt1 += 1;
    }
  }
  
  public void redrawInfoWindow()
  {
    try
    {
      if ((this.m != null) && (this.m.checkInBounds()))
      {
        if (!this.o) {
          return;
        }
        int i1 = this.m.getRealInfoWindowOffsetX() + this.m.getInfoWindowOffsetX();
        int i2 = this.m.getRealInfoWindowOffsetY() + this.m.getInfoWindowOffsetY() + 2;
        Object localObject = a(this.m);
        if (localObject == null) {
          return;
        }
        a((View)localObject, i1, i2);
        if (this.l != null)
        {
          localObject = (a)this.l.getLayoutParams();
          if (localObject != null)
          {
            ((a)localObject).a = this.m.getMapPosition();
            ((a)localObject).b = i1;
            ((a)localObject).c = i2;
          }
          onLayout(false, 0, 0, 0, 0);
          if (this.b.a()) {
            this.b.a(this.m.getTitle(), this.m.getSnippet());
          }
          if (this.l.getVisibility() == 8) {
            this.l.setVisibility(0);
          }
        }
      }
      else if ((this.l != null) && (this.l.getVisibility() == 0))
      {
        this.l.setVisibility(8);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "MapOverlayViewGroup", "redrawInfoWindow");
      localThrowable.printStackTrace();
    }
  }
  
  public void setInfoWindowAdapterManager(v paramv)
  {
    this.b = paramv;
  }
  
  public void showInfoWindow(BaseOverlayImp paramBaseOverlayImp)
  {
    if (paramBaseOverlayImp == null) {
      return;
    }
    try
    {
      if ((this.b != null) && (this.b.a()) && (paramBaseOverlayImp.getTitle() == null) && (paramBaseOverlayImp.getSnippet() == null)) {
        return;
      }
      if (!paramBaseOverlayImp.isInfoWindowEnable()) {
        return;
      }
      if ((this.m != null) && (!this.m.getId().equals(paramBaseOverlayImp.getId()))) {
        hideInfoWindow();
      }
      if (this.b != null)
      {
        this.m = paramBaseOverlayImp;
        paramBaseOverlayImp.setInfoWindowShown(true);
        this.q = true;
      }
      return;
    }
    catch (Throwable paramBaseOverlayImp) {}
  }
  
  public static class a
    extends ViewGroup.LayoutParams
  {
    public FPoint a = null;
    public int b = 0;
    public int c = 0;
    public int d = 51;
    
    public a(int paramInt1, int paramInt2, FPoint paramFPoint, int paramInt3, int paramInt4, int paramInt5)
    {
      super(paramInt2);
      this.a = paramFPoint;
      this.b = paramInt3;
      this.c = paramInt4;
      this.d = paramInt5;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */