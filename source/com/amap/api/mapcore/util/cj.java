package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.ITileOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import java.lang.ref.WeakReference;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cj
  implements ITileOverlayDelegate
{
  private static int h;
  cl.f a;
  private c b;
  private TileProvider c;
  private Float d;
  private boolean e;
  private boolean f = false;
  private IAMapDelegate g;
  private int i = 256;
  private int j = 256;
  private int k = -1;
  private dy l;
  private List<a> m = new ArrayList();
  private boolean n = false;
  private b o = null;
  private String p = null;
  private FloatBuffer q = null;
  
  public cj(TileOverlayOptions paramTileOverlayOptions, c paramc, boolean paramBoolean)
  {
    this.b = paramc;
    this.c = paramTileOverlayOptions.getTileProvider();
    this.i = this.c.getTileWidth();
    this.j = this.c.getTileHeight();
    this.q = dx.a(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    this.d = Float.valueOf(paramTileOverlayOptions.getZIndex());
    this.e = paramTileOverlayOptions.isVisible();
    this.f = paramBoolean;
    if (this.f) {
      this.p = "TileOverlay0";
    } else {
      this.p = getId();
    }
    this.g = this.b.a();
    this.k = Integer.parseInt(this.p.substring("TileOverlay".length()));
    if (paramBoolean) {}
    try
    {
      paramc = new eb.a(this.b.f(), this.p, paramc.a().getMapConfig().getMapLanguage());
      break label278;
      paramc = new eb.a(this.b.f(), this.p);
      label278:
      paramc.a(paramTileOverlayOptions.getMemoryCacheEnabled());
      if (this.f) {
        paramc.i = false;
      }
      paramc.b(paramTileOverlayOptions.getDiskCacheEnabled());
      paramc.a(paramTileOverlayOptions.getMemCacheSize());
      paramc.a(paramTileOverlayOptions.getDiskCacheSize());
      paramTileOverlayOptions = paramTileOverlayOptions.getDiskCacheDir();
      if ((paramTileOverlayOptions != null) && (!"".equals(paramTileOverlayOptions))) {
        paramc.a(paramTileOverlayOptions);
      }
      this.l = new dy(this.b.f(), this.i, this.j);
      this.l.a(this.c);
      this.l.a(paramc);
      this.l.a(new ea.c()
      {
        public void a()
        {
          cj.a(cj.this).resetRenderTimeLongLong();
        }
      });
      return;
    }
    catch (Throwable paramTileOverlayOptions)
    {
      for (;;) {}
    }
    paramTileOverlayOptions.printStackTrace();
  }
  
  private void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    if ((paramFloatBuffer1 != null) && (paramFloatBuffer2 != null))
    {
      if (paramInt == 0) {
        return;
      }
      if ((this.a == null) || (this.a.c())) {
        c();
      }
      this.a.a();
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      GLES20.glBlendColor(1.0F, 1.0F, 1.0F, 1.0F);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glEnableVertexAttribArray(this.a.b);
      GLES20.glVertexAttribPointer(this.a.b, 3, 5126, false, 12, paramFloatBuffer1);
      GLES20.glEnableVertexAttribArray(this.a.c);
      GLES20.glVertexAttribPointer(this.a.c, 2, 5126, false, 8, paramFloatBuffer2);
      GLES20.glUniformMatrix4fv(this.a.a, 1, false, this.b.h(), 0);
      GLES20.glDrawArrays(6, 0, 4);
      GLES20.glDisableVertexAttribArray(this.a.b);
      GLES20.glDisableVertexAttribArray(this.a.c);
      GLES20.glBindTexture(3553, 0);
      GLES20.glUseProgram(0);
      GLES20.glDisable(3042);
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.o = new b(paramBoolean, this.g, this.i, this.j, this.k, this.m, this.f, this.b, this.l);
    this.o.c(new Void[0]);
  }
  
  private boolean a(a parama)
  {
    float f1 = parama.c;
    int i1 = this.i;
    int i5 = this.j;
    int i2 = parama.e.x;
    int i4 = parama.e.y;
    int i3 = 1 << 20 - (int)f1;
    i5 *= i3;
    i4 += i5;
    MapConfig localMapConfig = this.g.getMapConfig();
    float[] arrayOfFloat = new float[12];
    f1 = i2;
    arrayOfFloat[0] = (f1 - (float)localMapConfig.getSX());
    float f2 = i4;
    arrayOfFloat[1] = (f2 - (float)localMapConfig.getSY());
    arrayOfFloat[2] = 0.0F;
    float f3 = i2 + i3 * i1;
    arrayOfFloat[3] = (f3 - (float)localMapConfig.getSX());
    arrayOfFloat[4] = (f2 - (float)localMapConfig.getSY());
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = (f3 - (float)localMapConfig.getSX());
    f2 = i4 - i5;
    arrayOfFloat[7] = (f2 - (float)localMapConfig.getSY());
    arrayOfFloat[8] = 0.0F;
    arrayOfFloat[9] = (f1 - (float)localMapConfig.getSX());
    arrayOfFloat[10] = (f2 - (float)localMapConfig.getSY());
    arrayOfFloat[11] = 0.0F;
    if (parama.h == null)
    {
      parama.h = dx.a(arrayOfFloat);
      return true;
    }
    parama.h = dx.a(arrayOfFloat, parama.h);
    return true;
  }
  
  private static String b(String paramString)
  {
    h += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(h);
    return localStringBuilder.toString();
  }
  
  private static ArrayList<a> b(IAMapDelegate paramIAMapDelegate, int paramInt1, int paramInt2, int paramInt3, int paramInt4, c paramc, dy paramdy)
  {
    Object localObject2 = paramIAMapDelegate.getMapProjection();
    Rect localRect = paramIAMapDelegate.getMapConfig().getGeoRectangle().getRect();
    Object localObject1 = IPoint.obtain();
    IPoint localIPoint = IPoint.obtain();
    ((IPoint)localObject1).x = localRect.left;
    ((IPoint)localObject1).y = localRect.top;
    int i2 = Math.min(Integer.MAX_VALUE, ((IPoint)localObject1).x);
    int i3 = Math.max(0, ((IPoint)localObject1).x);
    int i4 = Math.min(Integer.MAX_VALUE, ((IPoint)localObject1).y);
    int i1 = Math.max(0, ((IPoint)localObject1).y);
    ((IPoint)localObject1).x = localRect.right;
    ((IPoint)localObject1).y = localRect.top;
    i2 = Math.min(i2, ((IPoint)localObject1).x);
    i3 = Math.max(i3, ((IPoint)localObject1).x);
    i4 = Math.min(i4, ((IPoint)localObject1).y);
    i1 = Math.max(i1, ((IPoint)localObject1).y);
    ((IPoint)localObject1).x = localRect.left;
    ((IPoint)localObject1).y = localRect.bottom;
    i2 = Math.min(i2, ((IPoint)localObject1).x);
    i3 = Math.max(i3, ((IPoint)localObject1).x);
    i4 = Math.min(i4, ((IPoint)localObject1).y);
    int i5 = Math.max(i1, ((IPoint)localObject1).y);
    ((IPoint)localObject1).x = localRect.right;
    ((IPoint)localObject1).y = localRect.bottom;
    i2 = Math.min(i2, ((IPoint)localObject1).x);
    int i10 = Math.max(i3, ((IPoint)localObject1).x);
    i1 = Math.min(i4, ((IPoint)localObject1).y);
    i3 = Math.max(i5, ((IPoint)localObject1).y);
    int i11 = 20 - paramInt1;
    i5 = 1 << i11;
    int i12 = i2 - i5 * paramInt2;
    ((GLMapState)localObject2).getMapGeoCenter(localIPoint);
    i4 = (localIPoint.x >> i11) / paramInt2;
    int i13 = (localIPoint.y >> i11) / paramInt3;
    i2 = i1 - i5 * paramInt3;
    localObject2 = new a(i4, i13, paramInt1, paramInt4, paramIAMapDelegate, paramc, paramdy);
    ((a)localObject2).e = IPoint.obtain((i4 << i11) * paramInt2, (i13 << i11) * paramInt3);
    ((IPoint)localObject1).recycle();
    localIPoint.recycle();
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(localObject2);
    int i6 = 1;
    for (;;)
    {
      int i7 = i4 - i6;
      int i8 = i7;
      i1 = 0;
      int i14;
      for (;;)
      {
        i5 = i4 + i6;
        if (i8 > i5) {
          break;
        }
        i14 = i13 + i6;
        i9 = (i8 << i11) * paramInt2;
        localIPoint = new IPoint(i9, (i14 << i11) * paramInt3);
        if ((localIPoint.x < i10) && (localIPoint.x > i12)) {
          if (localIPoint.y < i3)
          {
            if (localIPoint.y > i2)
            {
              i5 = i1;
              if (i1 == 0) {
                i5 = 1;
              }
              i1 = i5;
              localObject2 = new a(i8, i14, paramInt1, paramInt4, paramIAMapDelegate, paramc, paramdy);
              ((a)localObject2).e = localIPoint;
              ((ArrayList)localObject1).add(localObject2);
            }
          }
          else {}
        }
        i5 = i2;
        i14 = i13 - i6;
        localIPoint = new IPoint(i9, (i14 << i11) * paramInt3);
        i2 = i1;
        if (localIPoint.x < i10)
        {
          i2 = i1;
          if (localIPoint.x > i12)
          {
            i2 = i1;
            if (localIPoint.y < i3)
            {
              i2 = i1;
              if (localIPoint.y > i5)
              {
                i2 = i1;
                if (i1 == 0) {
                  i2 = 1;
                }
                localObject2 = new a(i8, i14, paramInt1, paramInt4, paramIAMapDelegate, paramc, paramdy);
                ((a)localObject2).e = localIPoint;
                ((ArrayList)localObject1).add(localObject2);
              }
            }
          }
        }
        i8 += 1;
        i1 = i2;
        i2 = i5;
      }
      int i9 = i13 + i6 - 1;
      i8 = i5;
      while (i9 > i13 - i6)
      {
        i14 = (i9 << i11) * paramInt3;
        localIPoint = new IPoint((i8 << i11) * paramInt2, i14);
        if ((localIPoint.x < i10) && (localIPoint.x > i12) && (localIPoint.y < i3) && (localIPoint.y > i2))
        {
          i5 = i1;
          if (i1 == 0) {
            i5 = 1;
          }
          i1 = i5;
          localObject2 = new a(i8, i9, paramInt1, paramInt4, paramIAMapDelegate, paramc, paramdy);
          ((a)localObject2).e = localIPoint;
          ((ArrayList)localObject1).add(localObject2);
        }
        localIPoint = new IPoint((i7 << i11) * paramInt2, i14);
        i5 = i1;
        if (localIPoint.x < i10)
        {
          i5 = i1;
          if (localIPoint.x > i12)
          {
            i5 = i1;
            if (localIPoint.y < i3)
            {
              i5 = i1;
              if (localIPoint.y > i2)
              {
                i5 = i1;
                if (i1 == 0) {
                  i5 = 1;
                }
                localObject2 = new a(i7, i9, paramInt1, paramInt4, paramIAMapDelegate, paramc, paramdy);
                ((a)localObject2).e = localIPoint;
                ((ArrayList)localObject1).add(localObject2);
              }
            }
          }
        }
        i1 = i5;
        i9 -= 1;
      }
      if (i1 == 0) {
        return (ArrayList<a>)localObject1;
      }
      i6 += 1;
    }
  }
  
  private void b()
  {
    if ((this.o != null) && (this.o.a() == cx.e.b)) {
      this.o.a(true);
    }
  }
  
  private static boolean b(IAMapDelegate paramIAMapDelegate, List<a> paramList1, int paramInt, boolean paramBoolean1, List<a> paramList2, boolean paramBoolean2, c paramc, dy paramdy)
  {
    int i2 = 0;
    if (paramList1 == null) {
      return false;
    }
    if (paramList2 == null) {
      return false;
    }
    for (;;)
    {
      try
      {
        Iterator localIterator1 = paramList2.iterator();
        boolean bool = localIterator1.hasNext();
        i1 = 1;
        if (bool)
        {
          a locala1 = (a)localIterator1.next();
          Iterator localIterator2 = paramList1.iterator();
          if (localIterator2.hasNext())
          {
            a locala2 = (a)localIterator2.next();
            if ((!locala1.equals(locala2)) || (!locala1.g)) {
              continue;
            }
            locala2.g = locala1.g;
            locala2.f = locala1.f;
            if (i1 != 0) {
              continue;
            }
            locala1.b();
          }
        }
        else
        {
          paramList2.clear();
          if (paramInt <= (int)paramIAMapDelegate.getMaxZoomLevel())
          {
            if (paramInt < (int)paramIAMapDelegate.getMinZoomLevel()) {
              return false;
            }
            i1 = paramList1.size();
            paramInt = i2;
            if (i1 <= 0) {
              return false;
            }
            if (paramInt < i1)
            {
              paramIAMapDelegate = (a)paramList1.get(paramInt);
              if ((paramIAMapDelegate != null) && ((!paramBoolean2) || (paramc.a().getMapConfig().getMapLanguage().equals("zh_cn") ? (!MapsInitializer.isLoadWorldGridMap()) || (paramIAMapDelegate.c < 7) || (dq.a(paramIAMapDelegate.a, paramIAMapDelegate.b, paramIAMapDelegate.c)) : (MapsInitializer.isLoadWorldGridMap()) || (paramIAMapDelegate.c < 7) || (dq.a(paramIAMapDelegate.a, paramIAMapDelegate.b, paramIAMapDelegate.c)))))
              {
                paramList2.add(paramIAMapDelegate);
                if ((!paramIAMapDelegate.g) && (paramdy != null)) {
                  paramdy.a(paramBoolean1, paramIAMapDelegate);
                }
              }
              paramInt += 1;
              continue;
            }
            return true;
          }
          return false;
        }
      }
      finally {}
      int i1 = 0;
    }
  }
  
  private void c()
  {
    if ((this.b != null) && (this.b.a() != null)) {
      this.a = ((cl.f)this.b.a().getGLShader(0));
    }
  }
  
  public void a()
  {
    if (this.m != null) {
      synchronized (this.m)
      {
        this.m.clear();
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    b();
    a();
    if (this.l != null)
    {
      this.l.b(true);
      this.l.a(paramString);
      this.l.b(false);
    }
    a(true);
  }
  
  public void clearTileCache()
  {
    if (this.l != null) {
      this.l.f();
    }
  }
  
  public void destroy(boolean paramBoolean)
  {
    b();
    synchronized (this.m)
    {
      int i2 = this.m.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((a)this.m.get(i1)).b();
        i1 += 1;
      }
      this.m.clear();
      if (this.l != null)
      {
        this.l.d(paramBoolean);
        this.l.b(true);
        this.l.a(null);
      }
      return;
    }
  }
  
  public void drawTiles()
  {
    if (this.m != null) {}
    for (;;)
    {
      int i1;
      synchronized (this.m)
      {
        if (this.m.size() == 0) {
          return;
        }
        int i2 = this.m.size();
        i1 = 0;
        if (i1 < i2)
        {
          a locala = (a)this.m.get(i1);
          boolean bool = locala.g;
          if (!bool) {
            try
            {
              IPoint localIPoint = locala.e;
              if ((locala.i != null) && (!locala.i.isRecycled()) && (localIPoint != null))
              {
                locala.f = dx.a(locala.i);
                if (locala.f != 0) {
                  locala.g = true;
                }
                locala.i = null;
              }
            }
            catch (Throwable localThrowable)
            {
              gk.c(localThrowable, "TileOverlayDelegateImp", "drawTiles");
            }
          }
          if (!locala.g) {
            break label203;
          }
          a(locala);
          a(locala.f, locala.h, this.q);
          break label203;
        }
        return;
      }
      return;
      label203:
      i1 += 1;
    }
  }
  
  public boolean equalsRemote(ITileOverlay paramITileOverlay)
  {
    return (equals(paramITileOverlay)) || (paramITileOverlay.getId().equals(getId()));
  }
  
  public String getId()
  {
    if (this.p == null) {
      this.p = b("TileOverlay");
    }
    return this.p;
  }
  
  public float getZIndex()
  {
    return this.d.floatValue();
  }
  
  public int hashCodeRemote()
  {
    return super.hashCode();
  }
  
  public boolean isVisible()
  {
    return this.e;
  }
  
  public void onFling(boolean paramBoolean)
  {
    if (this.n != paramBoolean)
    {
      this.n = paramBoolean;
      if (this.l != null) {
        this.l.b(paramBoolean);
      }
    }
  }
  
  public void onPause()
  {
    b();
    synchronized (this.m)
    {
      int i2 = this.m.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((a)this.m.get(i1)).b();
        i1 += 1;
      }
      this.m.clear();
      return;
    }
  }
  
  public void onResume()
  {
    if (this.l != null) {
      this.l.a(false);
    }
  }
  
  public void reLoadTexture()
  {
    if (this.m != null) {
      synchronized (this.m)
      {
        if (this.m.size() == 0) {
          return;
        }
        Iterator localIterator = this.m.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          locala.g = false;
          locala.f = 0;
        }
        return;
      }
    }
  }
  
  public void refresh(boolean paramBoolean)
  {
    if (this.n) {
      return;
    }
    b();
    a(paramBoolean);
  }
  
  public void remove()
  {
    this.b.b(this);
    this.g.setRunLowFrame(false);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.g.setRunLowFrame(false);
    if (paramBoolean) {
      refresh(true);
    }
  }
  
  public void setZIndex(float paramFloat)
  {
    this.d = Float.valueOf(paramFloat);
    this.b.d();
  }
  
  public static class a
    implements Cloneable
  {
    public int a;
    public int b;
    public int c;
    public int d;
    public IPoint e;
    public int f = 0;
    public boolean g = false;
    public FloatBuffer h = null;
    public Bitmap i = null;
    public ea.a j = null;
    public int k = 0;
    private IAMapDelegate l;
    private c m;
    private dy n;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, IAMapDelegate paramIAMapDelegate, c paramc, dy paramdy)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.l = paramIAMapDelegate;
      this.m = paramc;
      this.n = paramdy;
    }
    
    public a(a parama)
    {
      this.a = parama.a;
      this.b = parama.b;
      this.c = parama.c;
      this.d = parama.d;
      this.e = parama.e;
      this.h = parama.h;
      this.k = 0;
      this.m = parama.m;
      this.l = parama.l;
      this.n = parama.n;
    }
    
    public a a()
    {
      try
      {
        a locala = (a)super.clone();
        locala.a = this.a;
        locala.b = this.b;
        locala.c = this.c;
        locala.d = this.d;
        locala.e = ((IPoint)this.e.clone());
        locala.h = this.h.asReadOnlyBuffer();
        this.k = 0;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        localCloneNotSupportedException.printStackTrace();
      }
      return new a(this);
    }
    
    public void a(Bitmap paramBitmap)
    {
      if (paramBitmap != null) {}
      try
      {
        boolean bool = paramBitmap.isRecycled();
        if (!bool)
        {
          try
          {
            this.j = null;
            this.i = paramBitmap;
            this.l.setRunLowFrame(false);
          }
          catch (Throwable paramBitmap)
          {
            gk.c(paramBitmap, "TileOverlayDelegateImp", "setBitmap");
            paramBitmap.printStackTrace();
            if (this.k >= 3) {
              break label122;
            }
          }
          this.k += 1;
          if (this.n != null) {
            this.n.a(true, this);
          }
        }
        else if (this.k < 3)
        {
          this.k += 1;
          if (this.n != null) {
            this.n.a(true, this);
          }
        }
        label122:
        return;
      }
      finally
      {
        for (;;) {}
      }
      throw paramBitmap;
    }
    
    public void b()
    {
      try
      {
        ea.a(this);
        if (this.g) {
          this.m.a(this.f);
        }
        this.g = false;
        this.f = 0;
        if ((this.i != null) && (!this.i.isRecycled())) {
          this.i.recycle();
        }
        this.i = null;
        if (this.h != null) {
          this.h.clear();
        }
        this.h = null;
        this.j = null;
        this.k = 0;
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      return (this.a == ((a)paramObject).a) && (this.b == ((a)paramObject).b) && (this.c == ((a)paramObject).c) && (this.d == ((a)paramObject).d);
    }
    
    public int hashCode()
    {
      return this.a * 7 + this.b * 11 + this.c * 13 + this.d;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("-");
      localStringBuilder.append(this.b);
      localStringBuilder.append("-");
      localStringBuilder.append(this.c);
      localStringBuilder.append("-");
      localStringBuilder.append(this.d);
      return localStringBuilder.toString();
    }
  }
  
  private static class b
    extends cx<Void, Void, List<cj.a>>
  {
    private int d;
    private boolean e;
    private int f = 256;
    private int g = 256;
    private int h = 0;
    private WeakReference<IAMapDelegate> i;
    private List<cj.a> j;
    private boolean k;
    private WeakReference<c> l;
    private WeakReference<dy> m;
    
    public b(boolean paramBoolean1, IAMapDelegate paramIAMapDelegate, int paramInt1, int paramInt2, int paramInt3, List<cj.a> paramList, boolean paramBoolean2, c paramc, dy paramdy)
    {
      this.e = paramBoolean1;
      this.i = new WeakReference(paramIAMapDelegate);
      this.f = paramInt1;
      this.g = paramInt2;
      this.h = paramInt3;
      this.j = paramList;
      this.k = paramBoolean2;
      this.l = new WeakReference(paramc);
      this.m = new WeakReference(paramdy);
    }
    
    protected List<cj.a> a(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = (IAMapDelegate)this.i.get();
        if (paramVarArgs == null) {
          return null;
        }
        int n = paramVarArgs.getMapWidth();
        int i1 = paramVarArgs.getMapHeight();
        this.d = ((int)paramVarArgs.getZoomLevel());
        if (n > 0)
        {
          if (i1 <= 0) {
            return null;
          }
          paramVarArgs = cj.a(paramVarArgs, this.d, this.f, this.g, this.h, (c)this.l.get(), (dy)this.m.get());
          return paramVarArgs;
        }
        return null;
      }
      catch (Throwable paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void a(List<cj.a> paramList)
    {
      if (paramList == null) {
        return;
      }
      try
      {
        if (paramList.size() <= 0) {
          return;
        }
        cj.a((IAMapDelegate)this.i.get(), paramList, this.d, this.e, this.j, this.k, (c)this.l.get(), (dy)this.m.get());
        paramList.clear();
        return;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */