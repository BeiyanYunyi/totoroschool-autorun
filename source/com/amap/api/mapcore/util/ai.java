package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ai
{
  public ArrayList<OfflineMapProvince> a = new ArrayList();
  private at b;
  private Context c;
  
  public ai(Context paramContext, Handler paramHandler)
  {
    this.c = paramContext;
    this.b = at.a(paramContext);
  }
  
  private void a(ao paramao)
  {
    if ((this.b != null) && (paramao != null)) {
      this.b.a(paramao);
    }
  }
  
  private void a(az paramaz, OfflineMapCity paramOfflineMapCity)
  {
    int i = paramaz.c().b();
    if (paramaz.c().equals(paramaz.a))
    {
      b(paramaz.x());
    }
    else
    {
      if (paramaz.c().equals(paramaz.f))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveJSONObjectToFile  CITY ");
        localStringBuilder.append(paramaz.getCity());
        bc.a(localStringBuilder.toString());
        b(paramaz);
        paramaz.x().c();
      }
      if (a(paramaz.getcompleteCode(), paramaz.c().b())) {
        a(paramaz.x());
      }
    }
    paramOfflineMapCity.setState(i);
    paramOfflineMapCity.setCompleteCode(paramaz.getcompleteCode());
  }
  
  private void a(az paramaz, OfflineMapProvince paramOfflineMapProvince)
  {
    int i = paramaz.c().b();
    if (i == 6)
    {
      paramOfflineMapProvince.setState(i);
      paramOfflineMapProvince.setCompleteCode(0);
      b(new ao(paramOfflineMapProvince, this.c));
      try
      {
        bc.b(paramOfflineMapProvince.getProvinceCode(), this.c);
        return;
      }
      catch (Exception paramaz)
      {
        paramaz.printStackTrace();
        return;
      }
      catch (IOException paramaz)
      {
        paramaz.printStackTrace();
        return;
      }
    }
    if ((b(i)) && (a(paramOfflineMapProvince)))
    {
      if (paramaz.getPinyin().equals(paramOfflineMapProvince.getPinyin()))
      {
        paramOfflineMapProvince.setState(i);
        paramOfflineMapProvince.setCompleteCode(paramaz.getcompleteCode());
        paramOfflineMapProvince.setVersion(paramaz.getVersion());
        paramOfflineMapProvince.setUrl(paramaz.getUrl());
        paramOfflineMapProvince = new ao(paramOfflineMapProvince, this.c);
        paramOfflineMapProvince.a(paramaz.a());
        paramOfflineMapProvince.d(paramaz.getCode());
        paramaz = paramOfflineMapProvince;
      }
      else
      {
        paramOfflineMapProvince.setState(i);
        paramOfflineMapProvince.setCompleteCode(100);
        paramaz = new ao(paramOfflineMapProvince, this.c);
      }
      paramaz.c();
      a(paramaz);
      paramOfflineMapProvince = new StringBuilder();
      paramOfflineMapProvince.append("saveJSONObjectToFile  province ");
      paramOfflineMapProvince.append(paramaz.d());
      bc.a(paramOfflineMapProvince.toString());
    }
  }
  
  private void a(OfflineMapCity paramOfflineMapCity1, OfflineMapCity paramOfflineMapCity2)
  {
    paramOfflineMapCity1.setUrl(paramOfflineMapCity2.getUrl());
    paramOfflineMapCity1.setVersion(paramOfflineMapCity2.getVersion());
    paramOfflineMapCity1.setSize(paramOfflineMapCity2.getSize());
    paramOfflineMapCity1.setCode(paramOfflineMapCity2.getCode());
    paramOfflineMapCity1.setPinyin(paramOfflineMapCity2.getPinyin());
    paramOfflineMapCity1.setJianpin(paramOfflineMapCity2.getJianpin());
  }
  
  private void a(OfflineMapProvince paramOfflineMapProvince1, OfflineMapProvince paramOfflineMapProvince2)
  {
    paramOfflineMapProvince1.setUrl(paramOfflineMapProvince2.getUrl());
    paramOfflineMapProvince1.setVersion(paramOfflineMapProvince2.getVersion());
    paramOfflineMapProvince1.setSize(paramOfflineMapProvince2.getSize());
    paramOfflineMapProvince1.setPinyin(paramOfflineMapProvince2.getPinyin());
    paramOfflineMapProvince1.setJianpin(paramOfflineMapProvince2.getJianpin());
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt2 == 1)
    {
      bool1 = bool2;
      if (paramInt1 > 2)
      {
        if (paramInt1 >= 98) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private boolean a(OfflineMapProvince paramOfflineMapProvince)
  {
    if (paramOfflineMapProvince == null) {
      return false;
    }
    paramOfflineMapProvince = paramOfflineMapProvince.getCityList().iterator();
    while (paramOfflineMapProvince.hasNext()) {
      if (((OfflineMapCity)paramOfflineMapProvince.next()).getState() != 4) {
        return false;
      }
    }
    return true;
  }
  
  private void b(ao paramao)
  {
    if (this.b != null) {
      this.b.b(paramao);
    }
  }
  
  private void b(az paramaz)
  {
    File[] arrayOfFile = new File(dx.c(this.c)).listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      if ((localFile.isFile()) && (localFile.exists()) && (localFile.getName().contains(paramaz.getAdcode())) && (localFile.getName().endsWith(".zip.tmp.dt"))) {
        localFile.delete();
      }
      i += 1;
    }
  }
  
  private boolean b(int paramInt)
  {
    return paramInt == 4;
  }
  
  public OfflineMapCity a(String paramString)
  {
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return null;
      }
      synchronized (this.a)
      {
        OfflineMapCity localOfflineMapCity;
        do
        {
          Iterator localIterator1 = this.a.iterator();
          Iterator localIterator2;
          while (!localIterator2.hasNext())
          {
            if (!localIterator1.hasNext()) {
              break;
            }
            localIterator2 = ((OfflineMapProvince)localIterator1.next()).getCityList().iterator();
          }
          localOfflineMapCity = (OfflineMapCity)localIterator2.next();
        } while (!localOfflineMapCity.getCode().equals(paramString));
        return localOfflineMapCity;
        return null;
      }
    }
    return null;
  }
  
  public ArrayList<OfflineMapProvince> a()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList2.add((OfflineMapProvince)localIterator.next());
      }
      return localArrayList2;
    }
  }
  
  public void a(az paramaz)
  {
    String str = paramaz.getPinyin();
    synchronized (this.a)
    {
      Iterator localIterator1 = this.a.iterator();
      OfflineMapProvince localOfflineMapProvince;
      OfflineMapCity localOfflineMapCity;
      do
      {
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          do
          {
            if (!localIterator1.hasNext()) {
              break;
            }
            localOfflineMapProvince = (OfflineMapProvince)localIterator1.next();
          } while (localOfflineMapProvince == null);
          localIterator2 = localOfflineMapProvince.getCityList().iterator();
        }
        localOfflineMapCity = (OfflineMapCity)localIterator2.next();
      } while (!localOfflineMapCity.getPinyin().trim().equals(str.trim()));
      a(paramaz, localOfflineMapCity);
      a(paramaz, localOfflineMapProvince);
      return;
    }
  }
  
  public void a(List<OfflineMapProvince> paramList)
  {
    for (;;)
    {
      int i;
      int j;
      synchronized (this.a)
      {
        if (this.a.size() > 0)
        {
          i = 0;
          if (i < this.a.size())
          {
            Object localObject2 = (OfflineMapProvince)this.a.get(i);
            Object localObject3 = paramList.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label306;
            }
            localObject1 = (OfflineMapProvince)((Iterator)localObject3).next();
            if (((OfflineMapProvince)localObject2).getPinyin().equals(((OfflineMapProvince)localObject1).getPinyin())) {
              break label309;
            }
            if (((!((OfflineMapProvince)localObject2).getPinyin().equals("quanguogaiyaotu")) && (!((OfflineMapProvince)localObject2).getProvinceCode().equals("000001")) && (!((OfflineMapProvince)localObject2).getProvinceCode().equals("100000"))) || (!((OfflineMapProvince)localObject1).getPinyin().equals("quanguogaiyaotu"))) {
              continue;
            }
            break label309;
            a((OfflineMapProvince)localObject2, (OfflineMapProvince)localObject1);
            localObject2 = ((OfflineMapProvince)localObject2).getCityList();
            localObject3 = ((OfflineMapProvince)localObject1).getCityList();
            j = 0;
            if (j >= ((ArrayList)localObject2).size()) {
              break label332;
            }
            OfflineMapCity localOfflineMapCity = (OfflineMapCity)((ArrayList)localObject2).get(j);
            Iterator localIterator = ((ArrayList)localObject3).iterator();
            if (!localIterator.hasNext()) {
              break label317;
            }
            localObject1 = (OfflineMapCity)localIterator.next();
            if (!localOfflineMapCity.getPinyin().equals(((OfflineMapCity)localObject1).getPinyin())) {
              continue;
            }
            break label320;
            a(localOfflineMapCity, (OfflineMapCity)localObject1);
            break label325;
          }
        }
        else
        {
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            localObject1 = (OfflineMapProvince)paramList.next();
            this.a.add(localObject1);
            continue;
          }
        }
        return;
      }
      label306:
      Object localObject1 = null;
      label309:
      if (localObject1 == null)
      {
        break label332;
        label317:
        localObject1 = null;
        label320:
        if (localObject1 == null)
        {
          label325:
          j += 1;
          continue;
          label332:
          i += 1;
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 2)
      {
        bool1 = bool2;
        if (paramInt != 3)
        {
          bool1 = bool2;
          if (paramInt != 1)
          {
            bool1 = bool2;
            if (paramInt != 102)
            {
              bool1 = bool2;
              if (paramInt != 101)
              {
                bool1 = bool2;
                if (paramInt != 103)
                {
                  if (paramInt == -1) {
                    return true;
                  }
                  bool1 = false;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public OfflineMapCity b(String paramString)
  {
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return null;
      }
      synchronized (this.a)
      {
        OfflineMapCity localOfflineMapCity;
        do
        {
          Iterator localIterator1 = this.a.iterator();
          Iterator localIterator2;
          while (!localIterator2.hasNext())
          {
            if (!localIterator1.hasNext()) {
              break;
            }
            localIterator2 = ((OfflineMapProvince)localIterator1.next()).getCityList().iterator();
          }
          localOfflineMapCity = (OfflineMapCity)localIterator2.next();
        } while (!localOfflineMapCity.getCity().trim().equalsIgnoreCase(paramString.trim()));
        return localOfflineMapCity;
        return null;
      }
    }
    return null;
  }
  
  public ArrayList<OfflineMapCity> b()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.a)
    {
      Iterator localIterator1 = this.a.iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((OfflineMapProvince)localIterator1.next()).getCityList().iterator();
        while (localIterator2.hasNext()) {
          localArrayList2.add((OfflineMapCity)localIterator2.next());
        }
      }
      return localArrayList2;
    }
  }
  
  public OfflineMapProvince c(String paramString)
  {
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return null;
      }
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          OfflineMapProvince localOfflineMapProvince = (OfflineMapProvince)localIterator.next();
          if (localOfflineMapProvince.getProvinceName().trim().equalsIgnoreCase(paramString.trim())) {
            return localOfflineMapProvince;
          }
        }
        return null;
      }
    }
    return null;
  }
  
  public ArrayList<OfflineMapCity> c()
  {
    synchronized (this.a)
    {
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (OfflineMapProvince)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = ((OfflineMapProvince)localObject2).getCityList().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            OfflineMapCity localOfflineMapCity = (OfflineMapCity)((Iterator)localObject2).next();
            if ((localOfflineMapCity.getState() == 4) || (localOfflineMapCity.getState() == 7)) {
              localArrayList2.add(localOfflineMapCity);
            }
          }
        }
      }
      return localArrayList2;
    }
  }
  
  public ArrayList<OfflineMapProvince> d()
  {
    synchronized (this.a)
    {
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        OfflineMapProvince localOfflineMapProvince = (OfflineMapProvince)localIterator.next();
        if ((localOfflineMapProvince != null) && ((localOfflineMapProvince.getState() == 4) || (localOfflineMapProvince.getState() == 7))) {
          localArrayList2.add(localOfflineMapProvince);
        }
      }
      return localArrayList2;
    }
  }
  
  public ArrayList<OfflineMapCity> e()
  {
    synchronized (this.a)
    {
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (OfflineMapProvince)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = ((OfflineMapProvince)localObject2).getCityList().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            OfflineMapCity localOfflineMapCity = (OfflineMapCity)((Iterator)localObject2).next();
            if (a(localOfflineMapCity.getState())) {
              localArrayList2.add(localOfflineMapCity);
            }
          }
        }
      }
      return localArrayList2;
    }
  }
  
  public ArrayList<OfflineMapProvince> f()
  {
    synchronized (this.a)
    {
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        OfflineMapProvince localOfflineMapProvince = (OfflineMapProvince)localIterator.next();
        if ((localOfflineMapProvince != null) && (a(localOfflineMapProvince.getState()))) {
          localArrayList2.add(localOfflineMapProvince);
        }
      }
      return localArrayList2;
    }
  }
  
  public void g()
  {
    h();
    this.b = null;
    this.c = null;
  }
  
  public void h()
  {
    if (this.a != null) {
      synchronized (this.a)
      {
        this.a.clear();
        return;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */