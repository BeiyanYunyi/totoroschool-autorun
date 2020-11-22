package com.amap.api.mapcore.util;

import android.content.Context;
import android.opengl.GLES20;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.autonavi.amap.mapcore.interfaces.IglModel;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ll
{
  private long a = 0L;
  private Context b;
  private IAMapDelegate c;
  private List<bx> d = new ArrayList();
  private List<Integer> e = new ArrayList();
  
  public ll(Context paramContext, IAMapDelegate paramIAMapDelegate)
  {
    this.b = paramContext;
    this.c = paramIAMapDelegate;
  }
  
  public GL3DModel a(GL3DModelOptions arg1)
  {
    if (??? == null) {
      return null;
    }
    Object localObject1 = new bx(this, ???, this.c);
    ??? = new StringBuilder();
    ???.append("model_");
    long l = this.a;
    this.a = (1L + l);
    ???.append(l);
    ((bx)localObject1).a(???.toString());
    synchronized (this.d)
    {
      this.d.add(localObject1);
      localObject1 = new GL3DModel((IglModel)localObject1);
      return (GL3DModel)localObject1;
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      bx localbx = (bx)localIterator.next();
      if (localbx.isVisible()) {
        localbx.a();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.e.add(Integer.valueOf(paramInt));
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((this.d != null) && (this.d.size() > 0))
        {
          bx localbx = null;
          i = 0;
          if (i < this.d.size())
          {
            localbx = (bx)this.d.get(i);
            if (!paramString.equals(localbx.getId())) {
              break label90;
            }
          }
          if (localbx != null)
          {
            this.d.remove(localbx);
            localbx.destroy();
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label90:
      i += 1;
    }
  }
  
  public boolean a(bx parambx)
  {
    return this.d.contains(parambx);
  }
  
  public void b()
  {
    if (this.d != null) {
      this.d.clear();
    }
  }
  
  public void c()
  {
    if (this.d != null)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((bx)localIterator.next()).destroy();
      }
      this.d.clear();
    }
  }
  
  public void d()
  {
    if (this.e != null)
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext()) {
        GLES20.glDeleteTextures(1, new int[] { ((Integer)localIterator.next()).intValue() }, 0);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */