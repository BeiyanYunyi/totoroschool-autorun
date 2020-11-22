package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;

public abstract class bd<T, V>
{
  protected T a;
  protected int b = 3;
  protected Context c;
  
  public bd(Context paramContext, T paramT)
  {
    a(paramContext, paramT);
  }
  
  private void a(Context paramContext, T paramT)
  {
    this.c = paramContext;
    this.a = paramT;
  }
  
  protected abstract String a();
  
  protected abstract JSONObject a(fl.a parama);
  
  protected abstract V b(JSONObject paramJSONObject)
    throws AMapException;
  
  protected abstract Map<String, String> b();
  
  public V c()
    throws AMapException
  {
    if (this.a != null) {
      return (V)d();
    }
    return null;
  }
  
  protected V d()
    throws AMapException
  {
    int i = 0;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    while (i < this.b)
    {
      Object localObject4;
      try
      {
        localObject4 = fl.a(this.c, dx.e(), a(), b());
        try
        {
          localObject2 = b(a((fl.a)localObject4));
          try
          {
            j = this.b;
            i = j;
            localObject1 = localObject2;
            localObject2 = localObject4;
          }
          catch (Throwable localThrowable2)
          {
            localObject1 = localObject2;
            localObject2 = localThrowable2;
          }
          Throwable localThrowable3 = localThrowable1;
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable4)
      {
        localObject4 = localThrowable1;
      }
      gk.c(localThrowable4, "AbstractProtocalHandler", "getDataMayThrow AMapException");
      localThrowable4.printStackTrace();
      int j = i + 1;
      i = j;
      Object localObject3 = localObject4;
      if (j >= this.b)
      {
        if ((localObject4 != null) && (((fl.a)localObject4).a != null)) {
          throw new AMapException(((fl.a)localObject4).a);
        }
        localObject1 = null;
        i = j;
        localObject3 = localObject4;
      }
    }
    return (V)localObject1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */