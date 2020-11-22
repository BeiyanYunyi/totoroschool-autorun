package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

public class dh
{
  private static boolean a = false;
  private static volatile dh d;
  private Hashtable<String, String> b = new Hashtable();
  private WeakReference<Context> c = null;
  
  public static dh a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new dh();
        }
      }
      finally {}
    }
    return d;
  }
  
  public static void a(int paramInt)
  {
    if (a)
    {
      boolean bool;
      if (paramInt >= 1000) {
        bool = false;
      } else {
        bool = true;
      }
      a(bool);
    }
  }
  
  private void a(String paramString)
  {
    if ((paramString != null) && (this.b != null)) {
      synchronized (this.b)
      {
        String str = fs.b(paramString);
        if ((this.b != null) && (!this.b.contains(str))) {
          this.b.put(str, paramString);
        }
        if (d()) {
          c();
        }
        return;
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static void b()
  {
    if (d != null)
    {
      if ((d.b != null) && (d.b.size() > 0)) {
        synchronized (d.b)
        {
          d.c();
          if (d.c != null) {
            d.c.clear();
          }
        }
      }
      d = null;
    }
    a(false);
  }
  
  private void c()
  {
    if (!a)
    {
      this.b.clear();
      return;
    }
    if (this.b != null)
    {
      Object localObject = new StringBuffer();
      int i = 0;
      int k = this.b.size();
      if (k > 0)
      {
        ((StringBuffer)localObject).append("[");
        Iterator localIterator = this.b.values().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          int j = i + 1;
          ((StringBuffer)localObject).append(str);
          i = j;
          if (j < k)
          {
            ((StringBuffer)localObject).append(",");
            i = j;
          }
        }
        ((StringBuffer)localObject).append("]");
        localObject = ((StringBuffer)localObject).toString();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.c != null) && (this.c.get() != null)) {
          ij.a((String)localObject, (Context)this.c.get());
        }
      }
      this.b.clear();
    }
  }
  
  private boolean d()
  {
    Hashtable localHashtable = this.b;
    boolean bool = false;
    if (localHashtable != null)
    {
      if (this.b.size() > 20) {
        bool = true;
      }
      return bool;
    }
    return false;
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null) {
      this.c = new WeakReference(paramContext);
    }
  }
  
  public void a(LatLng paramLatLng, String paramString1, String paramString2)
  {
    if (!a)
    {
      this.b.clear();
      return;
    }
    if ((paramLatLng != null) && (!TextUtils.isEmpty(paramString1)))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("{");
      localStringBuffer.append("\"lon\":");
      localStringBuffer.append(paramLatLng.longitude);
      localStringBuffer.append(",");
      localStringBuffer.append("\"lat\":");
      localStringBuffer.append(paramLatLng.latitude);
      localStringBuffer.append(",");
      localStringBuffer.append("\"title\":");
      localStringBuffer.append("\"");
      localStringBuffer.append(paramString1);
      localStringBuffer.append("\"");
      localStringBuffer.append(",");
      paramLatLng = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramLatLng = "";
      }
      localStringBuffer.append("\"snippet\":");
      localStringBuffer.append("\"");
      localStringBuffer.append(paramLatLng);
      localStringBuffer.append("\"");
      localStringBuffer.append("}");
      a(localStringBuffer.toString());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */