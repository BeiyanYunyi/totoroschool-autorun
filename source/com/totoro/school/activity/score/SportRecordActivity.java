package com.totoro.school.activity.score;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.OnClick;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.PolylineOptions;
import com.totoro.school.R.id;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.entity.score.run.ScoreRunDetailModel;
import com.totoro.school.utilpub.a.a;
import com.totoro.school.utilpub.network.c;
import com.totoro.school.utils.i;
import com.totoro.school.utils.o;
import d.c.b.h;
import d.g.j;
import d.g.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public final class SportRecordActivity
  extends Activity
  implements AMapLocationListener, c
{
  private AMap a;
  private AMapLocationClient b;
  private LoginReturnModel c;
  private ScoreRunDetailModel d;
  private HashMap e;
  
  private final void b()
  {
    Object localObject1 = (TextView)a(R.id.title_text);
    h.a(localObject1, "title_text");
    ((TextView)localObject1).setText((CharSequence)getString(2131689698));
    localObject1 = this.c;
    Object localObject2 = null;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = (TextView)a(R.id.stu_name);
      h.a(localObject3, "stu_name");
      localObject1 = this.c;
      if (localObject1 != null) {
        localObject1 = ((LoginReturnModel)localObject1).getStuName();
      } else {
        localObject1 = null;
      }
      ((TextView)localObject3).setText((CharSequence)localObject1);
    }
    if (this.d != null)
    {
      localObject3 = (TextView)a(R.id.km_value);
      h.a(localObject3, "km_value");
      localObject1 = this.d;
      if (localObject1 != null) {
        localObject1 = Double.valueOf(((ScoreRunDetailModel)localObject1).getTotalKm());
      } else {
        localObject1 = null;
      }
      ((TextView)localObject3).setText((CharSequence)String.valueOf(localObject1));
      localObject3 = (TextView)a(R.id.sport_time);
      h.a(localObject3, "sport_time");
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = this.d;
      if (localObject1 != null) {
        localObject1 = ((ScoreRunDetailModel)localObject1).getUserbegtime();
      } else {
        localObject1 = null;
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("~");
      localObject1 = this.d;
      if (localObject1 != null) {
        localObject1 = ((ScoreRunDetailModel)localObject1).getUserendtime();
      } else {
        localObject1 = null;
      }
      localStringBuilder.append((String)localObject1);
      ((TextView)localObject3).setText((CharSequence)localStringBuilder.toString());
      localObject1 = (TextView)a(R.id.speed_value);
      h.a(localObject1, "speed_value");
      ((TextView)localObject1).setText((CharSequence)c());
      localObject3 = (Chronometer)a(R.id.used_time);
      h.a(localObject3, "used_time");
      localObject1 = this.d;
      if (localObject1 != null) {
        localObject1 = ((ScoreRunDetailModel)localObject1).getDurationTime();
      } else {
        localObject1 = null;
      }
      ((Chronometer)localObject3).setText((CharSequence)localObject1);
      localObject3 = this.d;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Float.valueOf((float)((ScoreRunDetailModel)localObject3).getTotalKm());
      }
      if (localObject1 == null) {
        h.a();
      }
      double d1 = ((Float)localObject1).floatValue();
      Double.isNaN(d1);
      int i = (int)(d1 * 67.34D);
      localObject1 = (TextView)a(R.id.kcal_value);
      h.a(localObject1, "kcal_value");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(i));
    }
  }
  
  private final String c()
  {
    Object localObject1 = this.d;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((ScoreRunDetailModel)localObject1).getDurationTime();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return "--";
    }
    localObject1 = this.d;
    if (localObject1 != null) {
      localObject1 = ((ScoreRunDetailModel)localObject1).getDurationTime();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      h.a();
    }
    if (m.a((CharSequence)localObject1, (CharSequence)":", false, 2, null))
    {
      localObject1 = this.d;
      if (localObject1 != null) {
        localObject1 = ((ScoreRunDetailModel)localObject1).getDurationTime();
      } else {
        localObject1 = null;
      }
      localObject1 = o.b((String)localObject1);
      h.a(localObject1, "longTime");
      double d1 = Float.parseFloat((String)localObject1);
      ScoreRunDetailModel localScoreRunDetailModel = this.d;
      localObject1 = localObject2;
      if (localScoreRunDetailModel != null) {
        localObject1 = Double.valueOf(localScoreRunDetailModel.getTotalKm());
      }
      if (localObject1 == null) {
        h.a();
      }
      double d2 = ((Double)localObject1).doubleValue();
      Double.isNaN(d1);
      localObject1 = o.a(d1 / d2);
      h.a(localObject1, "TimeUtil.getPace(pace)");
      return (String)localObject1;
    }
    return "--";
  }
  
  private final void d()
  {
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new a(this));
  }
  
  private final void e()
  {
    this.d = ((ScoreRunDetailModel)getIntent().getSerializableExtra("scoreRunDetailModel"));
  }
  
  private final void f()
  {
    Object localObject = (MapView)a(R.id.map);
    h.a(localObject, "map");
    this.a = ((MapView)localObject).getMap();
    localObject = a.a();
    h.a(localObject, "GlobalShared.getInstance()");
    localObject = ((a)localObject).b();
    AMap localAMap = this.a;
    if (localAMap != null) {
      localAMap.moveCamera(CameraUpdateFactory.newLatLngZoom((LatLng)localObject, 17.0F));
    }
    localObject = this.a;
    if (localObject != null)
    {
      localObject = ((AMap)localObject).getUiSettings();
      if (localObject != null) {
        ((UiSettings)localObject).setZoomControlsEnabled(false);
      }
    }
    h();
    g();
  }
  
  private final void g()
  {
    Object localObject1 = this.d;
    ArrayList localArrayList = null;
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = ((ScoreRunDetailModel)localObject1).getMotionRoute();
    } else {
      localObject2 = null;
    }
    localObject1 = localArrayList;
    int i;
    if (localObject2 != null)
    {
      localObject1 = (CharSequence)localObject2;
      localObject2 = new j(";").split((CharSequence)localObject1, 0);
      localObject1 = localArrayList;
      if (localObject2 != null)
      {
        if (!((List)localObject2).isEmpty())
        {
          localObject1 = ((List)localObject2).listIterator(((List)localObject2).size());
          while (((ListIterator)localObject1).hasPrevious())
          {
            if (((CharSequence)((ListIterator)localObject1).previous()).length() == 0) {
              i = 1;
            } else {
              i = 0;
            }
            if (i == 0)
            {
              localObject2 = d.a.b.a((Iterable)localObject2, ((ListIterator)localObject1).nextIndex() + 1);
              break label165;
            }
          }
        }
        localObject2 = d.a.b.a();
        label165:
        localObject1 = localArrayList;
        if (localObject2 != null)
        {
          localObject1 = ((Collection)localObject2).toArray(new String[0]);
          if (localObject1 != null) {
            localObject1 = (String[])localObject1;
          } else {
            throw new d.b("null cannot be cast to non-null type kotlin.Array<T>");
          }
        }
      }
    }
    localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      int m = localObject1.length;
      i = 0;
      int j = 1;
      while (i < m)
      {
        localObject2 = (CharSequence)localObject1[i];
        localObject2 = new j(",").split((CharSequence)localObject2, 0);
        Object localObject3;
        int k;
        if (!((List)localObject2).isEmpty())
        {
          localObject3 = ((List)localObject2).listIterator(((List)localObject2).size());
          while (((ListIterator)localObject3).hasPrevious())
          {
            if (((CharSequence)((ListIterator)localObject3).previous()).length() == 0) {
              k = 1;
            } else {
              k = 0;
            }
            if (k == 0)
            {
              localObject2 = d.a.b.a((Iterable)localObject2, ((ListIterator)localObject3).nextIndex() + 1);
              break label367;
            }
          }
        }
        localObject2 = d.a.b.a();
        label367:
        localObject2 = ((Collection)localObject2).toArray(new String[0]);
        if (localObject2 != null)
        {
          localObject2 = (String[])localObject2;
          localArrayList.add(new LatLng(Double.parseDouble(localObject2[1]), Double.parseDouble(localObject2[0])));
          k = j;
          if (j != 0)
          {
            localObject3 = this.a;
            if (localObject3 != null) {
              ((AMap)localObject3).animateCamera(CameraUpdateFactory.changeLatLng(new LatLng(Double.parseDouble(localObject2[1]), Double.parseDouble(localObject2[0]))));
            }
            k = 0;
          }
          i += 1;
          j = k;
        }
        else
        {
          throw new d.b("null cannot be cast to non-null type kotlin.Array<T>");
        }
      }
      localObject1 = this.a;
      if (localObject1 != null) {
        ((AMap)localObject1).addPolyline(new PolylineOptions().addAll((Iterable)localArrayList).width(20.0F).color(ContextCompat.getColor((Context)this, 2131099725)));
      }
    }
  }
  
  private final void h()
  {
    if (this.b == null)
    {
      this.b = new AMapLocationClient(getApplicationContext());
      localObject1 = this.b;
      if (localObject1 == null) {
        h.a();
      }
      ((AMapLocationClient)localObject1).setLocationListener((AMapLocationListener)this);
    }
    Object localObject2 = new MyLocationStyle();
    Object localObject1 = new AMapLocationClientOption();
    ((AMapLocationClientOption)localObject1).setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
    ((AMapLocationClientOption)localObject1).setInterval(5000L);
    ((MyLocationStyle)localObject2).myLocationIcon(BitmapDescriptorFactory.fromResource(2131558427));
    AMap localAMap = this.a;
    if (localAMap != null) {
      localAMap.setMyLocationStyle((MyLocationStyle)localObject2);
    }
    ((AMapLocationClientOption)localObject1).setNeedAddress(true);
    ((AMapLocationClientOption)localObject1).setMockEnable(false);
    localObject2 = this.b;
    if (localObject2 != null) {
      ((AMapLocationClient)localObject2).setLocationOption((AMapLocationClientOption)localObject1);
    }
    localObject1 = this.b;
    if (localObject1 != null) {
      ((AMapLocationClient)localObject1).startLocation();
    }
  }
  
  public View a(int paramInt)
  {
    if (this.e == null) {
      this.e = new HashMap();
    }
    View localView2 = (View)this.e.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.e.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a(String paramString, Object paramObject)
  {
    h.b(paramString, "path");
    h.b(paramObject, "o");
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    h.b(paramString, "path");
    h.b(paramThrowable, "e");
  }
  
  public void a_(String paramString)
  {
    h.b(paramString, "message");
  }
  
  @OnClick({2131296298})
  public final void back(View paramView)
  {
    h.b(paramView, "view");
    finish();
  }
  
  public void d_() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492915);
    e();
    this.c = i.a();
    b();
    d();
    ((MapView)a(R.id.map)).onCreate(paramBundle);
    f();
  }
  
  protected void onDestroy()
  {
    AMapLocationClient localAMapLocationClient = this.b;
    if (localAMapLocationClient == null) {
      h.a();
    }
    localAMapLocationClient.stopLocation();
    localAMapLocationClient = this.b;
    if (localAMapLocationClient == null) {
      h.a();
    }
    localAMapLocationClient.onDestroy();
    this.b = ((AMapLocationClient)null);
    ((MapView)a(R.id.map)).onDestroy();
    super.onDestroy();
  }
  
  public void onLocationChanged(AMapLocation paramAMapLocation)
  {
    h.b(paramAMapLocation, "aMapLocation");
    if ((paramAMapLocation.getErrorCode() == 0) && (paramAMapLocation.getLatitude() == 0.0D) && (paramAMapLocation.getLongitude() == 0.0D)) {}
  }
  
  protected void onPause()
  {
    super.onPause();
    ((MapView)a(R.id.map)).onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    ((MapView)a(R.id.map)).onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    h.b(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    ((MapView)a(R.id.map)).onSaveInstanceState(paramBundle);
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(SportRecordActivity paramSportRecordActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\score\SportRecordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */