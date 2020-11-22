package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
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
import java.util.List;

public class ek
  extends BaseExpandableListAdapter
  implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener
{
  private boolean[] a;
  private int b = -1;
  private List<OfflineMapProvince> c = null;
  private OfflineMapManager d;
  private Context e;
  
  public ek(List<OfflineMapProvince> paramList, OfflineMapManager paramOfflineMapManager, Context paramContext)
  {
    this.c = paramList;
    this.d = paramOfflineMapManager;
    this.e = paramContext;
    this.a = new boolean[paramList.size()];
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 0) && (paramInt != getGroupCount() - 1);
  }
  
  public void a()
  {
    this.b = -1;
    notifyDataSetChanged();
  }
  
  public void b()
  {
    this.b = 0;
    notifyDataSetChanged();
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return null;
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
      localObject = new eo(this.e, this.d);
      ((eo)localObject).a(1);
      paramView = ((eo)localObject).a();
      paramViewGroup.a = ((eo)localObject);
      paramView.setTag(paramViewGroup);
    }
    Object localObject = (OfflineMapCity)((OfflineMapProvince)this.c.get(paramInt1)).getCityList().get(paramInt2);
    paramViewGroup.a.a((OfflineMapCity)localObject);
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (a(paramInt)) {
      return ((OfflineMapProvince)this.c.get(paramInt)).getCityList().size();
    }
    return ((OfflineMapProvince)this.c.get(paramInt)).getCityList().size();
  }
  
  public Object getGroup(int paramInt)
  {
    return ((OfflineMapProvince)this.c.get(paramInt)).getProvinceName();
  }
  
  public int getGroupCount()
  {
    if (this.b == -1) {
      return this.c.size();
    }
    return this.b;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = (RelativeLayout)es.a(this.e, 2130903043, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(2131165201);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131165202);
    paramView.setText(((OfflineMapProvince)this.c.get(paramInt)).getProvinceName());
    if (this.a[paramInt] != 0)
    {
      localImageView.setImageDrawable(es.a().getDrawable(2130837509));
      return paramViewGroup;
    }
    localImageView.setImageDrawable(es.a().getDrawable(2130837510));
    return paramViewGroup;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void onGroupCollapse(int paramInt)
  {
    this.a[paramInt] = false;
  }
  
  public void onGroupExpand(int paramInt)
  {
    this.a[paramInt] = true;
  }
  
  public final class a
  {
    public eo a;
    
    public a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */