package com.amap.api.mapcore.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.LatLng;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fe
{
  private static volatile fe b;
  private Map<String, a> a = null;
  
  public static fe a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new fe();
        }
      }
      finally {}
    }
    return b;
  }
  
  public a a(String paramString)
  {
    try
    {
      if (this.a != null)
      {
        paramString = (a)this.a.get(paramString);
        return paramString;
      }
      return null;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(Handler paramHandler, int paramInt, String paramString)
  {
    Message localMessage = paramHandler.obtainMessage();
    localMessage.obj = paramString;
    localMessage.what = 102;
    paramString = new Bundle();
    paramString.putInt("lineID", paramInt);
    localMessage.setData(paramString);
    paramHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (this.a != null) {
        this.a.put(paramString, new a(paramInt1, paramInt2, paramInt3, new HashMap(16)));
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, int paramInt, List<LatLng> paramList)
  {
    try
    {
      if (this.a != null) {
        ((a)this.a.get(paramString)).a().put(Integer.valueOf(paramInt), paramList);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  class a
  {
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private HashMap<Integer, List<LatLng>> g;
    private List<LatLng> h = new ArrayList();
    
    public a(int paramInt1, int paramInt2, HashMap<Integer, List<LatLng>> paramHashMap)
    {
      this.b = paramInt2;
      HashMap localHashMap;
      this.g = localHashMap;
      this.c = paramInt1;
      this.e = paramHashMap;
    }
    
    private void a(Handler paramHandler, List<LatLng> paramList)
    {
      Message localMessage = paramHandler.obtainMessage();
      localMessage.obj = paramList;
      localMessage.what = 100;
      localMessage.arg1 = this.d;
      paramList = new Bundle();
      paramList.putInt("lineID", this.c);
      localMessage.setData(paramList);
      paramHandler.sendMessage(localMessage);
      this.d += 1;
      this.f += 1;
    }
    
    private void b(Handler paramHandler)
    {
      if (this.f > 0)
      {
        int i = ew.a(this.h);
        Message localMessage = paramHandler.obtainMessage();
        localMessage.obj = this.h;
        localMessage.what = 101;
        localMessage.arg1 = i;
        localMessage.arg2 = this.e;
        Bundle localBundle = new Bundle();
        localBundle.putInt("lineID", this.c);
        localMessage.setData(localBundle);
        paramHandler.sendMessage(localMessage);
        return;
      }
      fe.this.a(paramHandler, this.c, "轨迹点太少或距离太近,轨迹纠偏失败");
    }
    
    public HashMap<Integer, List<LatLng>> a()
    {
      return this.g;
    }
    
    public void a(Handler paramHandler)
    {
      int i = this.d;
      while (i <= this.b)
      {
        List localList = (List)this.g.get(Integer.valueOf(i));
        if (localList == null) {
          break;
        }
        this.h.addAll(localList);
        a(paramHandler, localList);
        i += 1;
      }
      if (this.d == this.b + 1) {
        b(paramHandler);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\fe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */