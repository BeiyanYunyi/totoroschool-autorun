package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.MyTrafficStyle;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

public class ad
  implements cn.a
{
  private IAMapDelegate a;
  private CustomMapStyleOptions b;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private int g = 1;
  private Context h;
  private byte[] i = null;
  private byte[] j = null;
  private byte[] k = null;
  private byte[] l = null;
  private byte[] m = null;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private cn s;
  private cn t;
  private byte[] u = null;
  private byte[] v = null;
  private boolean w = false;
  private MyTrafficStyle x = new MyTrafficStyle();
  
  public ad(IAMapDelegate paramIAMapDelegate, Context paramContext)
  {
    this.a = paramIAMapDelegate;
    this.h = paramContext;
    this.n = false;
    this.o = false;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i1;
    if (!TextUtils.isEmpty(paramString)) {
      i1 = cu.a(paramString);
    } else {
      i1 = Integer.MIN_VALUE;
    }
    if ((this.a != null) && (this.a.getGLMapEngine() != null))
    {
      if (this.k == null)
      {
        paramString = this.h;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("map_assets");
        localStringBuilder.append(File.separator);
        localStringBuilder.append("bktile.data");
        this.k = FileUtil.readFileContentsFromAssets(paramString, localStringBuilder.toString());
      }
      if (this.k != null)
      {
        int i2;
        if (!paramBoolean) {
          i2 = 0;
        }
        do
        {
          paramBoolean = false;
          i1 = i2;
          break;
          i2 = i1;
        } while (i1 != Integer.MIN_VALUE);
        paramBoolean = true;
        paramString = dx.a((byte[])this.k.clone(), 0, i1, paramBoolean);
        this.a.getGLMapEngine().setBackgroundTexture(this.g, paramString);
      }
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      try
      {
        paramArrayOfByte = new GZIPInputStream(paramArrayOfByte);
        byte[] arrayOfByte = new byte['Ā'];
        for (;;)
        {
          int i1 = paramArrayOfByte.read(arrayOfByte);
          if (i1 < 0) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte, 0, i1);
        }
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = cu.a(paramArrayOfByte);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.a() != null)) {
        try
        {
          JSONObject localJSONObject1 = new JSONObject(paramArrayOfByte.a());
          JSONObject localJSONObject2 = localJSONObject1.optJSONObject("bg");
          paramArrayOfByte = null;
          boolean bool = true;
          if (localJSONObject2 != null)
          {
            bool = localJSONObject2.optBoolean("visible", true);
            paramArrayOfByte = localJSONObject2.optString("lineColor", null);
          }
          a(paramArrayOfByte, bool);
          paramArrayOfByte = localJSONObject1.optJSONObject("traffic");
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte = paramArrayOfByte.optJSONObject("multiFillColors");
            if (paramArrayOfByte != null)
            {
              int i1 = cu.a(paramArrayOfByte.optString("smooth"));
              int i2 = cu.a(paramArrayOfByte.optString("slow"));
              int i3 = cu.a(paramArrayOfByte.optString("congested"));
              int i4 = cu.a(paramArrayOfByte.optString("seriousCongested"));
              this.x.setSmoothColor(i1);
              this.x.setSlowColor(i2);
              this.x.setCongestedColor(i3);
              this.x.setSeriousCongestedColor(i4);
              if ((this.a != null) && (this.a.getGLMapEngine() != null)) {
                this.a.getGLMapEngine().setTrafficStyle(this.g, this.x.getSmoothColor(), this.x.getSlowColor(), this.x.getCongestedColor(), this.x.getSeriousCongestedColor(), true);
              }
            }
          }
          return;
        }
        catch (Throwable paramArrayOfByte)
        {
          gk.c(paramArrayOfByte, "AMapCustomStyleManager", "setExtraStyle");
        }
      }
    }
  }
  
  private boolean c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return true;
    }
    try
    {
      if (paramArrayOfByte.length < 8) {
        return false;
      }
      int i1 = paramArrayOfByte[7];
      int i2 = paramArrayOfByte[6];
      int i3 = paramArrayOfByte[5];
      int i4 = paramArrayOfByte[4];
      if ((i4 & 0xFF | i1 << 24 & 0xFF000000 | i2 << 16 & 0xFF0000 | i3 << 8 & 0xFF00) != 2000) {
        return false;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      gk.c(paramArrayOfByte, "AMapCustomStyleManager", "checkData");
    }
    return true;
  }
  
  private void f()
  {
    if ((this.a != null) && (this.a.getGLMapEngine() != null) && (this.k != null)) {
      this.a.getGLMapEngine().setBackgroundTexture(this.g, this.k);
    }
    if ((this.a != null) && (this.a.getGLMapEngine() != null)) {
      this.a.getGLMapEngine().setTrafficStyle(this.g, 0, 0, 0, 0, false);
    }
    this.r = false;
  }
  
  private void g()
  {
    if (this.j == null)
    {
      localObject = this.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("map_assets");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("style_1_16_1562032355.data");
      this.j = a(FileUtil.readFileContentsFromAssets((Context)localObject, localStringBuilder.toString()));
    }
    Object localObject = this.i;
    this.a.getGLMapEngine().setCustomStyleData(this.g, this.j, this.i);
    this.q = false;
  }
  
  private void h()
  {
    if (this.p)
    {
      if (this.l == null)
      {
        Context localContext = this.h;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("map_assets");
        localStringBuilder.append(File.separator);
        localStringBuilder.append("icons-for_custom_5_14.data");
        this.l = FileUtil.readFileContentsFromAssets(localContext, localStringBuilder.toString());
      }
      this.p = false;
      this.a.getGLMapEngine().setCustomStyleTexture(this.g, this.l);
    }
  }
  
  private void i()
  {
    if (this.b != null)
    {
      this.b.setStyleId(null);
      this.b.setStyleDataPath(null);
      this.b.setStyleData(null);
      this.b.setStyleTexturePath(null);
      this.b.setStyleTextureData(null);
      this.b.setStyleExtraData(null);
      this.b.setStyleExtraPath(null);
    }
  }
  
  public void a()
  {
    if (this.b == null) {
      return;
    }
    if (this.o) {
      return;
    }
    try
    {
      Object localObject1 = this.a.getMapConfig();
      if (localObject1 == null) {
        return;
      }
      try
      {
        if ((((MapConfig)localObject1).isHideLogoEnable()) && (this.a != null) && (this.a.getUiSettings() != null)) {
          if (this.a.getUiSettings().isLogoEnable())
          {
            if (this.b.isEnable())
            {
              if (this.q) {
                this.a.getUiSettings().setLogoEnable(false);
              }
            }
            else {
              this.a.getUiSettings().setLogoEnable(true);
            }
          }
          else if (!this.q) {
            this.a.getUiSettings().setLogoEnable(true);
          }
        }
        if (this.c) {
          if (this.b.isEnable())
          {
            this.a.getGLMapEngine().setNativeMapModeAndStyle(this.g, 0, 0, 0, false, false, null);
            ((MapConfig)localObject1).setCustomStyleEnable(true);
            this.c = false;
          }
          else
          {
            this.a.getGLMapEngine().setNativeMapModeAndStyle(this.g, ((MapConfig)localObject1).getMapStyleMode(), ((MapConfig)localObject1).getMapStyleTime(), ((MapConfig)localObject1).getMapStyleState(), false, false, null);
            this.q = false;
            if (((MapConfig)localObject1).isCustomStyleEnable())
            {
              if ((((MapConfig)localObject1).getMapStyleMode() == 0) && (((MapConfig)localObject1).getMapStyleTime() == 0) && (((MapConfig)localObject1).getMapStyleState() == 0)) {
                g();
              }
              h();
              if (this.r) {
                f();
              }
              ((MapConfig)localObject1).setCustomStyleEnable(false);
            }
            this.c = false;
            return;
          }
        }
        Object localObject3;
        if (this.e)
        {
          localObject3 = this.b.getStyleTexturePath();
          if ((this.b.getStyleTextureData() == null) && (!TextUtils.isEmpty((CharSequence)localObject3)))
          {
            localObject3 = FileUtil.readFileContents((String)localObject3);
            this.b.setStyleTextureData((byte[])localObject3);
          }
          if (this.b.getStyleTextureData() != null)
          {
            this.w = true;
            if (((MapConfig)localObject1).isProFunctionAuthEnable())
            {
              this.p = true;
              this.a.getGLMapEngine().setCustomStyleTexture(this.g, this.b.getStyleTextureData());
              ((MapConfig)localObject1).setUseProFunction(true);
            }
            else
            {
              h();
            }
          }
          else
          {
            h();
            this.w = false;
          }
          this.e = false;
        }
        if (this.d)
        {
          localObject1 = this.b.getStyleDataPath();
          if ((this.b.getStyleData() == null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            localObject1 = FileUtil.readFileContents((String)localObject1);
            this.b.setStyleData((byte[])localObject1);
          }
          if ((this.b.getStyleData() == null) && (this.u == null))
          {
            if (this.q)
            {
              this.c = true;
              this.b.setEnable(false);
            }
          }
          else
          {
            if (this.m == null)
            {
              localObject1 = this.h;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("map_assets");
              ((StringBuilder)localObject3).append(File.separator);
              ((StringBuilder)localObject3).append("style-for_custom_0_16_1561381751.data");
              this.m = a(FileUtil.readFileContentsFromAssets((Context)localObject1, ((StringBuilder)localObject3).toString()));
            }
            if (this.u != null) {
              localObject1 = this.u;
            } else {
              localObject1 = this.b.getStyleData();
            }
            if (!c((byte[])localObject1))
            {
              cz.a();
            }
            else
            {
              this.a.getGLMapEngine().setCustomStyleData(this.g, (byte[])localObject1, this.m);
              this.q = true;
              if (this.a != null) {
                this.a.resetRenderTime();
              }
            }
          }
          this.d = false;
        }
        if (this.f)
        {
          localObject1 = this.b.getStyleExtraPath();
          if ((this.b.getStyleExtraData() == null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            localObject1 = FileUtil.readFileContents((String)localObject1);
            this.b.setStyleExtraData((byte[])localObject1);
          }
          if ((this.b.getStyleExtraData() != null) || (this.v != null))
          {
            if (this.v != null) {
              localObject1 = this.v;
            } else {
              localObject1 = this.b.getStyleExtraData();
            }
            if (localObject1 != null)
            {
              b((byte[])localObject1);
              this.r = true;
            }
          }
          this.f = false;
        }
        return;
      }
      finally {}
      return;
    }
    catch (Throwable localThrowable)
    {
      gk.c(localThrowable, "AMapCustomStyleManager", "updateStyle");
    }
  }
  
  public void a(CustomMapStyleOptions paramCustomMapStyleOptions)
  {
    if (this.b == null) {
      return;
    }
    if (paramCustomMapStyleOptions == null) {
      return;
    }
    try
    {
      if (!this.n)
      {
        this.n = true;
        if (this.b.isEnable()) {
          this.c = true;
        }
      }
      if (this.b.isEnable() != paramCustomMapStyleOptions.isEnable())
      {
        this.b.setEnable(paramCustomMapStyleOptions.isEnable());
        this.c = true;
        dv.b(this.h, paramCustomMapStyleOptions.isEnable());
      }
      if (this.b.isEnable())
      {
        if (!TextUtils.equals(this.b.getStyleId(), paramCustomMapStyleOptions.getStyleId()))
        {
          this.b.setStyleId(paramCustomMapStyleOptions.getStyleId());
          String str = this.b.getStyleId();
          if ((!TextUtils.isEmpty(str)) && (this.a != null) && (this.a.getMapConfig() != null) && (this.a.getMapConfig().isProFunctionAuthEnable()))
          {
            if (this.s == null) {
              this.s = new cn(this.h, this, 1);
            }
            this.s.a(str);
            this.s.b();
            if (this.t == null) {
              this.t = new cn(this.h, this, 0);
            }
            this.t.a(str);
            this.t.b();
          }
        }
        if (!TextUtils.equals(this.b.getStyleDataPath(), paramCustomMapStyleOptions.getStyleDataPath()))
        {
          this.b.setStyleDataPath(paramCustomMapStyleOptions.getStyleDataPath());
          this.d = true;
        }
        if (this.b.getStyleData() != paramCustomMapStyleOptions.getStyleData())
        {
          this.b.setStyleData(paramCustomMapStyleOptions.getStyleData());
          this.d = true;
        }
        if (!TextUtils.equals(this.b.getStyleTexturePath(), paramCustomMapStyleOptions.getStyleTexturePath()))
        {
          this.b.setStyleTexturePath(paramCustomMapStyleOptions.getStyleTexturePath());
          this.e = true;
        }
        if (this.b.getStyleTextureData() != paramCustomMapStyleOptions.getStyleTextureData())
        {
          this.b.setStyleTextureData(paramCustomMapStyleOptions.getStyleTextureData());
          this.e = true;
        }
        if (!TextUtils.equals(this.b.getStyleExtraPath(), paramCustomMapStyleOptions.getStyleExtraPath()))
        {
          this.b.setStyleExtraPath(paramCustomMapStyleOptions.getStyleExtraPath());
          this.f = true;
        }
        if (this.b.getStyleExtraData() != paramCustomMapStyleOptions.getStyleExtraData())
        {
          this.b.setStyleExtraData(paramCustomMapStyleOptions.getStyleExtraData());
          this.f = true;
        }
        dv.a(this.h, true);
      }
      else
      {
        i();
        dv.a(this.h, false);
      }
      return;
    }
    finally {}
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.b != null) {
      try
      {
        if (this.a != null)
        {
          MapConfig localMapConfig = this.a.getMapConfig();
          if ((localMapConfig != null) && (localMapConfig.isProFunctionAuthEnable()))
          {
            localMapConfig.setUseProFunction(true);
            if (paramInt == 1)
            {
              this.u = paramArrayOfByte;
              this.d = true;
            }
            else if (paramInt == 0)
            {
              this.v = paramArrayOfByte;
              this.f = true;
            }
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public void b()
  {
    if (this.b == null) {
      return;
    }
    try
    {
      if ((this.a != null) && (this.a.getMapConfig() != null) && (!this.a.getMapConfig().isProFunctionAuthEnable()))
      {
        this.b.setStyleId(null);
        this.u = null;
        this.v = null;
      }
      this.e = true;
      this.d = true;
      if (this.r) {
        this.f = true;
      }
      this.c = true;
      return;
    }
    finally {}
  }
  
  public void c()
  {
    if (this.b == null) {
      this.b = new CustomMapStyleOptions();
    }
  }
  
  public boolean d()
  {
    return this.b != null;
  }
  
  public void e()
  {
    try
    {
      if (this.b != null)
      {
        this.b.setEnable(false);
        i();
        this.c = true;
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */