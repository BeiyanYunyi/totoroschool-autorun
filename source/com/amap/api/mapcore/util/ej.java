package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ej
  extends BaseExpandableListAdapter
  implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener
{
  List<OfflineMapProvince> a = new ArrayList();
  private boolean[] b;
  private Context c;
  private eo d;
  private List<OfflineMapProvince> e = new ArrayList();
  private eq f;
  private OfflineMapManager g;
  
  public ej(Context paramContext, eq parameq, OfflineMapManager paramOfflineMapManager, List<OfflineMapProvince> paramList)
  {
    this.c = paramContext;
    this.f = parameq;
    this.g = paramOfflineMapManager;
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.e.clear();
      this.e.addAll(paramList);
      paramContext = this.e.iterator();
      while (paramContext.hasNext())
      {
        parameq = (OfflineMapProvince)paramContext.next();
        if ((parameq != null) && (parameq.getDownloadedCityList().size() > 0)) {
          this.a.add(parameq);
        }
      }
    }
    this.b = new boolean[this.a.size()];
  }
  
  public void a()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      OfflineMapProvince localOfflineMapProvince = (OfflineMapProvince)localIterator.next();
      if ((localOfflineMapProvince.getDownloadedCityList().size() > 0) && (!this.a.contains(localOfflineMapProvince))) {
        this.a.add(localOfflineMapProvince);
      }
    }
    this.b = new boolean[this.a.size()];
    notifyDataSetChanged();
  }
  
  public void b()
  {
    for (;;)
    {
      int i;
      try
      {
        i = this.a.size();
        if (i > 0)
        {
          OfflineMapProvince localOfflineMapProvince = (OfflineMapProvince)this.a.get(i - 1);
          if (localOfflineMapProvince.getDownloadedCityList().size() == 0) {
            this.a.remove(localOfflineMapProvince);
          }
        }
        else
        {
          this.b = new boolean[this.a.size()];
          notifyDataSetChanged();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      i -= 1;
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return ((OfflineMapProvince)this.a.get(paramInt1)).getDownloadedCityList().get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = (a)paramView.getTag();
    }
    else
    {
      paramViewGroup = new a();
      this.d = new eo(this.c, this.g);
      this.d.a(2);
      paramView = this.d.a();
      paramViewGroup.a = this.d;
      paramView.setTag(paramViewGroup);
    }
    final Object localObject = (OfflineMapProvince)this.a.get(paramInt1);
    if (paramInt2 < ((OfflineMapProvince)localObject).getDownloadedCityList().size())
    {
      localObject = (OfflineMapCity)((OfflineMapProvince)localObject).getDownloadedCityList().get(paramInt2);
      paramViewGroup.a.a((OfflineMapCity)localObject);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ej.a(ej.this).a(localObject);
        }
      });
    }
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    return ((OfflineMapProvince)this.a.get(paramInt)).getDownloadedCityList().size();
  }
  
  public Object getGroup(int paramInt)
  {
    return ((OfflineMapProvince)this.a.get(paramInt)).getProvinceName();
  }
  
  public int getGroupCount()
  {
    return this.a.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = (RelativeLayout)es.a(this.c, 2130903043, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(2131165201);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131165202);
    paramView.setText(((OfflineMapProvince)this.a.get(paramInt)).getProvinceName());
    if (this.b[paramInt] != 0)
    {
      localImageView.setImageDrawable(es.a().getDrawable(2130837509));
      return paramViewGroup;
    }
    localImageView.setImageDrawable(es.a().getDrawable(2130837510));
    return paramViewGroup;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void onGroupCollapse(int paramInt)
  {
    this.b[paramInt] = false;
  }
  
  public void onGroupExpand(int paramInt)
  {
    this.b[paramInt] = true;
  }
  
  public final class a
  {
    public eo a;
    
    public a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */