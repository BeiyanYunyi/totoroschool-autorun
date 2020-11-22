package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class da
  implements TileProvider
{
  Random a = new Random();
  private final int b;
  private final int c;
  private MapConfig d;
  
  public da(int paramInt1, int paramInt2, MapConfig paramMapConfig)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramMapConfig;
  }
  
  private byte[] a(int paramInt1, int paramInt2, int paramInt3, String paramString)
    throws IOException
  {
    try
    {
      paramString = new a(paramInt1, paramInt2, paramInt3, paramString).makeHttpRequest();
      return paramString;
    }
    catch (Throwable paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (this.d == null) {
        break label66;
      }
      localObject = this.d.getMapLanguage();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject;
        continue;
        label66:
        String str = "zh_cn";
      }
    }
    localObject = a(paramInt1, paramInt2, paramInt3, (String)localObject);
    if (localObject == null) {
      return NO_TILE;
    }
    localObject = Tile.obtain(this.b, this.c, (byte[])localObject);
    return (Tile)localObject;
    return NO_TILE;
  }
  
  public int getTileHeight()
  {
    return this.c;
  }
  
  public int getTileWidth()
  {
    return this.b;
  }
  
  class a
    extends cw
  {
    private int e;
    private int f;
    private int g;
    private String h;
    private String i = "";
    
    public a(int paramInt1, int paramInt2, int paramInt3, String paramString)
    {
      this.e = paramInt1;
      this.f = paramInt2;
      this.g = paramInt3;
      this.h = paramString;
      this.i = d();
      setProxy(ft.a(lq.a));
      setConnectionTimeout(5000);
      setSoTimeout(50000);
    }
    
    private String a()
    {
      Object localObject = new StringBuffer();
      ((StringBuffer)localObject).append("key=");
      ((StringBuffer)localObject).append(fk.f(lq.a));
      ((StringBuffer)localObject).append("&channel=amapapi");
      if ((!dq.a(this.e, this.f, this.g)) && (this.g >= 7))
      {
        if (MapsInitializer.isLoadWorldGridMap())
        {
          ((StringBuffer)localObject).append("&x=");
          ((StringBuffer)localObject).append(this.e);
          ((StringBuffer)localObject).append("&y=");
          ((StringBuffer)localObject).append(this.f);
          ((StringBuffer)localObject).append("&z=");
          ((StringBuffer)localObject).append(this.g);
          ((StringBuffer)localObject).append("&ds=0");
          ((StringBuffer)localObject).append("&dpitype=webrd");
          ((StringBuffer)localObject).append("&lang=");
          ((StringBuffer)localObject).append(this.h);
          ((StringBuffer)localObject).append("&scale=2");
        }
      }
      else
      {
        ((StringBuffer)localObject).append("&z=");
        ((StringBuffer)localObject).append(this.g);
        ((StringBuffer)localObject).append("&x=");
        ((StringBuffer)localObject).append(this.e);
        ((StringBuffer)localObject).append("&y=");
        ((StringBuffer)localObject).append(this.f);
        ((StringBuffer)localObject).append("&lang=en&size=1&scale=1&style=7");
      }
      String str = ((StringBuffer)localObject).toString();
      localObject = a(str);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(str);
      str = fn.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("&ts=");
      localStringBuilder.append(str);
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("&scode=");
      localStringBuilder.append(fn.a(lq.a, str, (String)localObject));
      localStringBuffer.append(localStringBuilder.toString());
      return localStringBuffer.toString();
    }
    
    private String a(String paramString)
    {
      Object localObject = paramString.split("&");
      Arrays.sort((Object[])localObject);
      StringBuffer localStringBuffer = new StringBuffer();
      int k = localObject.length;
      int j = 0;
      while (j < k)
      {
        localStringBuffer.append(b(localObject[j]));
        localStringBuffer.append("&");
        j += 1;
      }
      localObject = localStringBuffer.toString();
      if (((String)localObject).length() > 1) {
        return (String)((String)localObject).subSequence(0, ((String)localObject).length() - 1);
      }
      return paramString;
    }
    
    private String b(String paramString)
    {
      if (paramString == null) {
        return paramString;
      }
      try
      {
        paramString = URLDecoder.decode(paramString, "utf-8");
        return paramString;
      }
      catch (Exception paramString)
      {
        gk.c(paramString, "AbstractProtocalHandler", "strReEncoderException");
      }
      catch (UnsupportedEncodingException paramString)
      {
        gk.c(paramString, "AbstractProtocalHandler", "strReEncoder");
      }
      return "";
    }
    
    private String d()
    {
      if ((!dq.a(this.e, this.f, this.g)) && (this.g >= 7))
      {
        if (MapsInitializer.isLoadWorldGridMap()) {
          return "http://restapi.amap.com/v4/gridmap?";
        }
        return null;
      }
      int j = da.this.a.nextInt(100000);
      return String.format(Locale.US, "http://wprd0%d.is.autonavi.com/appmaptile?", new Object[] { Integer.valueOf(j % 4 + 1) });
    }
    
    public Map<String, String> getParams()
    {
      return null;
    }
    
    public Map<String, String> getRequestHead()
    {
      Hashtable localHashtable = new Hashtable(16);
      localHashtable.put("User-Agent", lk.c);
      localHashtable.put("Accept-Encoding", "gzip");
      localHashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[] { "7.1.0", "3dmap" }));
      localHashtable.put("x-INFO", fn.a(lq.a));
      localHashtable.put("key", fk.f(lq.a));
      localHashtable.put("logversion", "2.1");
      return localHashtable;
    }
    
    public String getURL()
    {
      if (TextUtils.isEmpty(this.i)) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.i);
      localStringBuilder.append(a());
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */