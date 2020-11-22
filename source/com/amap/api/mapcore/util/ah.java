package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class ah
  extends Thread
{
  private Context a;
  private at b;
  
  public ah(Context paramContext)
  {
    this.a = paramContext;
    this.b = at.a(paramContext);
  }
  
  private ao a(File paramFile)
  {
    paramFile = dx.a(paramFile);
    ao localao = new ao();
    localao.b(paramFile);
    return localao;
  }
  
  private ao a(String paramString)
  {
    String str1 = paramString;
    if (paramString.equals("quanguo")) {
      str1 = "quanguogaiyaotu";
    }
    paramString = ae.a(this.a);
    if (paramString != null)
    {
      String str2 = paramString.f(str1);
      File[] arrayOfFile = new File(dx.c(this.a)).listFiles();
      if (arrayOfFile == null) {
        return null;
      }
      int k = arrayOfFile.length;
      paramString = null;
      int i = 0;
      while (i < k)
      {
        Object localObject = arrayOfFile[i];
        int j;
        if (((((File)localObject).getName().contains(str2)) || (((File)localObject).getName().contains(str1))) && (((File)localObject).getName().endsWith(".zip.tmp.dt"))) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0)
        {
          localObject = a((File)localObject);
          paramString = (String)localObject;
          if (localObject != null) {
            if (((ao)localObject).d() == null) {
              paramString = (String)localObject;
            } else {
              return (ao)localObject;
            }
          }
        }
        i += 1;
      }
      return paramString;
    }
    return null;
  }
  
  private void a()
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = this.b.a();
    a((ArrayList)localObject2, "vmap/");
    a((ArrayList)localObject2, "map/");
    b((ArrayList)localObject2, "map/");
    Object localObject3 = b();
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    while (localIterator.hasNext())
    {
      ao localao = (ao)localIterator.next();
      if ((localao != null) && (localao.d() != null))
      {
        int i;
        String str;
        if ((localao.l != 4) && (localao.l != 7))
        {
          int k = localao.l;
          int j = 0;
          i = 0;
          if ((k != 0) && (localao.l != 1))
          {
            if ((localao.l == 3) && (localao.h() != 0))
            {
              if ((((ArrayList)localObject3).contains(localao.f())) || (((ArrayList)localObject3).contains(localao.i()))) {
                i = 1;
              }
              j = i;
              if (i == 0)
              {
                str = bc.c(localao.g());
                j = i;
                if (str != null)
                {
                  k = ((ArrayList)localObject3).indexOf(str);
                  j = i;
                  if (k != -1)
                  {
                    ((ArrayList)localObject3).set(k, localao.i());
                    j = 1;
                  }
                }
              }
              if (j == 0) {
                this.b.b(localao);
              }
            }
          }
          else
          {
            if (!((ArrayList)localObject3).contains(localao.f()))
            {
              i = j;
              if (!((ArrayList)localObject3).contains(localao.i())) {}
            }
            else
            {
              i = 1;
            }
            j = i;
            if (i == 0)
            {
              str = bc.c(localao.g());
              j = i;
              if (str != null)
              {
                k = ((ArrayList)localObject3).indexOf(str);
                j = i;
                if (k != -1)
                {
                  ((ArrayList)localObject3).set(k, localao.i());
                  j = 1;
                }
              }
            }
            if (j == 0) {
              this.b.b(localao);
            }
          }
        }
        else
        {
          boolean bool2 = ((ArrayList)localObject2).contains(localao.i());
          boolean bool1 = bool2;
          if (!bool2)
          {
            str = bc.c(localao.g());
            bool1 = bool2;
            if (str != null)
            {
              i = ((ArrayList)localObject2).indexOf(str);
              bool1 = bool2;
              if (i != -1)
              {
                ((ArrayList)localObject2).set(i, localao.i());
                bool1 = true;
              }
            }
          }
          if (!bool1) {
            this.b.b(localao);
          }
        }
      }
    }
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (!a((String)localObject3, (ArrayList)localObject1))
      {
        localObject3 = a((String)localObject3);
        if (localObject3 != null) {
          this.b.a((ao)localObject3);
        }
      }
    }
    localObject1 = ae.a(this.a);
    if (localObject1 != null) {
      ((ae)localObject1).a(null);
    }
  }
  
  private void a(ArrayList<String> paramArrayList, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(dx.b(this.a));
    ((StringBuilder)localObject).append(paramString);
    paramString = new File(((StringBuilder)localObject).toString());
    if (!paramString.exists()) {
      return;
    }
    paramString = paramString.listFiles();
    if (paramString == null) {
      return;
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localObject = paramString[i];
      if (((File)localObject).getName().endsWith(".dat"))
      {
        localObject = ((File)localObject).getName();
        int k = ((String)localObject).lastIndexOf('.');
        if ((k > -1) && (k < ((String)localObject).length()))
        {
          localObject = ((String)localObject).substring(0, k);
          if (!paramArrayList.contains(localObject)) {
            paramArrayList.add(localObject);
          }
        }
      }
      i += 1;
    }
  }
  
  private boolean a(String paramString, ArrayList<ao> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (paramString.equals(((ao)paramArrayList.next()).i())) {
        return true;
      }
    }
    return false;
  }
  
  private ArrayList<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(dx.c(this.a));
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      return localArrayList;
    }
    localObject = ((File)localObject).listFiles();
    if (localObject == null) {
      return localArrayList;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String str = localObject[i];
      if (str.getName().endsWith(".zip"))
      {
        str = str.getName();
        int k = str.lastIndexOf('.');
        if ((k > -1) && (k < str.length())) {
          localArrayList.add(str.substring(0, k));
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void b(ArrayList<String> paramArrayList, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(dx.a(this.a));
    ((StringBuilder)localObject).append(paramString);
    paramString = new File(((StringBuilder)localObject).toString());
    if (!paramString.exists()) {
      return;
    }
    paramString = paramString.listFiles();
    if (paramString == null) {
      return;
    }
    int i1 = paramString.length;
    int i = 0;
    while (i < i1)
    {
      String[] arrayOfString = paramString[i];
      if (arrayOfString.isDirectory())
      {
        localObject = arrayOfString.getName();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          arrayOfString = arrayOfString.list();
          if (arrayOfString != null)
          {
            int j = arrayOfString.length;
            int n = 1;
            if ((j >= 1) && (!paramArrayList.contains(localObject)))
            {
              if (((String)localObject).equals("a0"))
              {
                k = arrayOfString.length;
                j = 0;
                while (j < k)
                {
                  if ("m1.ans".equals(arrayOfString[j]))
                  {
                    j = n;
                    break label275;
                  }
                  j += 1;
                }
              }
              int i2 = arrayOfString.length;
              j = 0;
              int m = 0;
              int k = 0;
              while (j < i2)
              {
                String str = arrayOfString[j];
                if ("m1.ans".equals(str)) {
                  m = 1;
                }
                if ("m3.ans".equals(str)) {
                  k = 1;
                }
                j += 1;
              }
              if ((m != 0) && (k != 0)) {
                j = n;
              } else {
                j = 0;
              }
              label275:
              if (j != 0) {
                paramArrayList.add(localObject);
              }
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public void run()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */