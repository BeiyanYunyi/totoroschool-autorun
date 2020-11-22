package com.amap.api.mapcore.util;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapActivity;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.ArrayList;
import java.util.List;

public class el
  extends BaseAdapter
{
  private List<OfflineMapCity> a = new ArrayList();
  private OfflineMapManager b;
  private Activity c;
  
  public el(List<OfflineMapProvince> paramList, OfflineMapManager paramOfflineMapManager, OfflineMapActivity paramOfflineMapActivity)
  {
    this.b = paramOfflineMapManager;
    this.c = paramOfflineMapActivity;
  }
  
  public void a(List<OfflineMapCity> paramList)
  {
    this.a = paramList;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    try
    {
      final OfflineMapCity localOfflineMapCity = (OfflineMapCity)this.a.get(paramInt);
      final a locala;
      if (paramView == null)
      {
        paramViewGroup = paramView;
        locala = new a();
        paramViewGroup = paramView;
        paramView = es.a(this.c, 2130903042, null);
        try
        {
          locala.a = ((TextView)paramView.findViewById(2131165195));
          locala.b = ((TextView)paramView.findViewById(2131165199));
          locala.c = ((TextView)paramView.findViewById(2131165197));
          locala.d = ((ImageView)paramView.findViewById(2131165198));
          paramView.setTag(locala);
        }
        catch (Exception paramViewGroup)
        {
          break label498;
        }
      }
      else
      {
        paramViewGroup = paramView;
        locala = (a)paramView.getTag();
      }
      paramViewGroup = paramView;
      locala.d.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          locala.d.setVisibility(8);
          locala.c.setVisibility(0);
          locala.c.setText("下载中");
          try
          {
            el.a(el.this).downloadByCityName(localOfflineMapCity.getCity());
            return;
          }
          catch (AMapException paramAnonymousView)
          {
            paramAnonymousView.printStackTrace();
          }
        }
      });
      paramViewGroup = paramView;
      locala.c.setVisibility(0);
      paramViewGroup = paramView;
      locala.a.setText(localOfflineMapCity.getCity());
      paramViewGroup = paramView;
      long l = localOfflineMapCity.getSize();
      double d = l;
      Double.isNaN(d);
      d = (int)(d / 1024.0D / 1024.0D * 100.0D);
      Double.isNaN(d);
      d /= 100.0D;
      paramViewGroup = paramView;
      TextView localTextView = locala.b;
      paramViewGroup = paramView;
      StringBuilder localStringBuilder = new StringBuilder();
      paramViewGroup = paramView;
      localStringBuilder.append(String.valueOf(d));
      paramViewGroup = paramView;
      localStringBuilder.append(" M");
      paramViewGroup = paramView;
      localTextView.setText(localStringBuilder.toString());
      paramViewGroup = paramView;
      paramInt = localOfflineMapCity.getState();
      if (paramInt != 6) {}
      switch (paramInt)
      {
      case 4: 
        paramViewGroup = paramView;
        locala.d.setVisibility(8);
        paramViewGroup = paramView;
        locala.c.setText("已下载");
        return paramView;
      case 3: 
        paramViewGroup = paramView;
        locala.d.setVisibility(8);
        paramViewGroup = paramView;
        locala.c.setText("暂停中");
        return paramView;
      case 2: 
        paramViewGroup = paramView;
        locala.d.setVisibility(8);
        paramViewGroup = paramView;
        locala.c.setText("等待下载");
        return paramView;
      case 0: 
      case 1: 
        paramViewGroup = paramView;
        locala.d.setVisibility(8);
        paramViewGroup = paramView;
        locala.c.setText("下载中");
        return paramView;
      case -1: 
        paramViewGroup = paramView;
        locala.d.setVisibility(8);
        paramViewGroup = paramView;
        locala.c.setText("下载失败");
        return paramView;
        paramViewGroup = paramView;
        locala.d.setVisibility(0);
        paramViewGroup = paramView;
        locala.c.setVisibility(8);
        return paramView;
      }
    }
    catch (Exception localException)
    {
      paramView = paramViewGroup;
      paramViewGroup = localException;
      label498:
      paramViewGroup.printStackTrace();
      return paramView;
    }
    switch (paramInt)
    {
    }
    return paramView;
  }
  
  public final class a
  {
    public TextView a;
    public TextView b;
    public TextView c;
    public ImageView d;
    
    public a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\el.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */