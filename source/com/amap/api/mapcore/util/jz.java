package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build.VERSION;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class jz
{
  private hl a;
  private String b;
  private String c;
  
  public jz(hl paramhl, String paramString1, String paramString2)
  {
    this.a = paramhl;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  private static void b(Context paramContext, fv paramfv)
  {
    new ka().a(paramContext, paramfv);
  }
  
  public boolean a(Context paramContext, fv paramfv)
  {
    Object localObject = this.a;
    String str = this.b;
    if (localObject == null) {}
    do
    {
      bool = false;
      break;
      if ((!((hl)localObject).h()) && (!jr.a(paramfv))) {
        b(paramContext, paramfv);
      }
    } while ((!((hl)localObject).j()) || (!((hl)localObject).a(paramContext)) || (!((hl)localObject).h()) || (!((hl)localObject).i()));
    boolean bool = ((hl)localObject).f().equals(fs.a(str));
    if (!bool) {
      return false;
    }
    if (jr.a(paramfv)) {
      return false;
    }
    hn.a().a(paramContext);
    if (hn.a().a(this.a.c().i(), this.a.c().j(), this.a.c().k()))
    {
      b(paramContext, paramfv);
      return false;
    }
    if (!hl.a(paramContext, this.a, paramfv))
    {
      b(paramContext, paramfv);
      return false;
    }
    if (!hl.b(paramContext, this.a, paramfv))
    {
      b(paramContext, paramfv);
      return false;
    }
    ho.b(this.c);
    ho.d(this.c);
    paramfv = new ArrayList();
    paramfv.add(new File(this.b));
    localObject = new File(this.c);
    paramContext.getApplicationContext();
    paramContext = (PathClassLoader)paramContext.getClassLoader();
    try
    {
      if (!paramfv.isEmpty()) {
        if (Build.VERSION.SDK_INT >= 23) {
          c.a(paramContext, paramfv, (File)localObject);
        } else if (Build.VERSION.SDK_INT >= 19) {
          b.a(paramContext, paramfv, (File)localObject);
        } else if (Build.VERSION.SDK_INT >= 14) {
          a.a(paramContext, paramfv, (File)localObject);
        }
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      ho.a(paramContext, "di");
    }
    return false;
  }
  
  static final class a {}
  
  static final class b
  {
    private static Object[] b(Object paramObject, ArrayList<File> paramArrayList, File paramFile, ArrayList<IOException> paramArrayList1)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
      for (;;)
      {
        try
        {
          localMethod = ho.a(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class });
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Method localMethod;
          continue;
        }
        try
        {
          localMethod = ho.a(paramObject, "makeDexElements", new Class[] { List.class, File.class, List.class });
          return (Object[])localMethod.invoke(paramObject, new Object[] { paramArrayList, paramFile, paramArrayList1 });
        }
        catch (NoSuchMethodException paramObject)
        {
          throw ((Throwable)paramObject);
        }
      }
    }
  }
  
  static final class c
  {
    private static Object[] a(Object paramObject, ArrayList<File> paramArrayList, File paramFile, ArrayList<IOException> paramArrayList1)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
      for (;;)
      {
        try
        {
          localMethod = ho.a(paramObject, "makePathElements", new Class[] { List.class, File.class, List.class });
        }
        catch (NoSuchMethodException localNoSuchMethodException1)
        {
          Method localMethod;
          continue;
        }
        try
        {
          localMethod = ho.a(paramObject, "makePathElements", new Class[] { ArrayList.class, File.class, ArrayList.class });
          return (Object[])localMethod.invoke(paramObject, new Object[] { paramArrayList, paramFile, paramArrayList1 });
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          continue;
        }
        try
        {
          paramObject = jz.b.a(paramObject, paramArrayList, paramFile, paramArrayList1);
          return (Object[])paramObject;
        }
        catch (NoSuchMethodException paramObject)
        {
          throw ((Throwable)paramObject);
        }
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\jz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */