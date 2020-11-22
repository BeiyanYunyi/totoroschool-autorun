package com.totoro.school.frament.sport;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.OnMarkerClickListener;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.bumptech.glide.h;
import com.bumptech.glide.load.resource.bitmap.d;
import com.totoro.school.activity.run.TaskRunActivity;
import com.totoro.school.e.f;
import com.totoro.school.entity.GeoFenceEntity;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.entity.run.routePoint.RoutePointModel;
import com.totoro.school.entity.run.routePoint.RoutePointReturnModel;
import com.totoro.school.utils.i;
import com.totoro.school.utils.n;
import com.totoro.school.view.dialog.OneButtonDialog;
import com.totoro.school.view.dialog.OneButtonDialog.a;
import com.totoro.school.view.dialog.RunInfoDialog;
import com.totoro.school.view.dialog.RunInfoDialog.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SunshineRunFragment
  extends Fragment
  implements AMapLocationListener, com.totoro.school.utilpub.network.c
{
  private static final String a = "SunshineRunFragment";
  private f b;
  private AMap c;
  @BindView(2131296330)
  TextView collegeName;
  @BindView(2131296341)
  TextView currentDate;
  private AMapLocationClient d;
  private List<RoutePointModel> e;
  private RoutePointModel f;
  @BindView(2131296397)
  TextView freeRun;
  private AMapLocation g;
  private RoutePointReturnModel h;
  @BindView(2131296404)
  ImageView headImage;
  private ArrayList<GeoFenceEntity> i = new ArrayList();
  private LoginReturnModel j;
  private boolean k = false;
  private Polyline l;
  private boolean m = true;
  @BindView(2131296466)
  MapView mMapView;
  @BindView(2131296621)
  TextView startRun;
  @BindView(2131296628)
  TextView stuName;
  @BindView(2131296640)
  TextView taskRun;
  @BindView(2131296658)
  TextView tipsInfo;
  @BindView(2131296729)
  TextView weekAndLunar;
  
  private void a(AMap paramAMap, ArrayList<GeoFenceEntity> paramArrayList)
  {
    if (paramAMap == null) {
      return;
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      int n = 0;
      while (n < paramArrayList.size())
      {
        GeoFenceEntity localGeoFenceEntity = (GeoFenceEntity)paramArrayList.get(n);
        Object localObject = new LatLng(localGeoFenceEntity.getLatitude(), localGeoFenceEntity.getLongitude());
        paramAMap.addMarker(new MarkerOptions().position((LatLng)localObject).icon(BitmapDescriptorFactory.fromView(a(localGeoFenceEntity.getId(), localGeoFenceEntity.getName()))));
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMarkers");
        localStringBuilder.append(localGeoFenceEntity.getLatitude());
        localStringBuilder.append("--");
        localStringBuilder.append(localGeoFenceEntity.getLongitude());
        Log.i((String)localObject, localStringBuilder.toString());
        n += 1;
      }
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new RunInfoDialog(getActivity(), 2131755512, "", paramString1, paramString2, paramString3, "", new RunInfoDialog.a()
    {
      public void a(String paramAnonymousString)
      {
        if ("confirm_btn".equals(paramAnonymousString))
        {
          paramAnonymousString = new Intent(SunshineRunFragment.this.getActivity(), TaskRunActivity.class);
          paramAnonymousString.putExtra("routePointReturnModel", SunshineRunFragment.c(SunshineRunFragment.this));
          paramAnonymousString.putExtra("routePointModel", SunshineRunFragment.d(SunshineRunFragment.this));
          paramAnonymousString.putExtra("isTask", SunshineRunFragment.e(SunshineRunFragment.this));
          SunshineRunFragment.this.startActivity(paramAnonymousString);
        }
      }
    });
    paramString2 = paramString1.getWindow();
    paramString3 = paramString2.getAttributes();
    paramString2.setGravity(17);
    paramString2.setAttributes(paramString3);
    paramString1.setCanceledOnTouchOutside(true);
    paramString1.setCancelable(true);
    paramString1.show();
  }
  
  private void b(String paramString)
  {
    paramString = new OneButtonDialog(getActivity(), 2131755512, "", paramString, "", new OneButtonDialog.a()
    {
      public void a(String paramAnonymousString) {}
    });
    Window localWindow = paramString.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localWindow.setGravity(17);
    localWindow.setAttributes(localLayoutParams);
    paramString.setCanceledOnTouchOutside(true);
    paramString.setCancelable(true);
    paramString.show();
  }
  
  private void c()
  {
    this.stuName.setText(this.j.getStuName());
    this.collegeName.setText(this.j.getSchoolName());
    this.currentDate.setText(com.totoro.school.utils.c.a("yyyy-MM-dd"));
    TextView localTextView = this.weekAndLunar;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.totoro.school.utils.c.a());
    localStringBuilder.append(",");
    localStringBuilder.append(com.totoro.school.utils.c.b());
    localTextView.setText(localStringBuilder.toString());
    com.bumptech.glide.e.a(getActivity()).a(Integer.valueOf(2131558452)).d().a(new d[] { new com.totoro.school.utils.glide.a(getActivity()) }).a(2131558452).a(this.headImage);
  }
  
  private void d()
  {
    this.c = this.mMapView.getMap();
    LatLng localLatLng = com.totoro.school.utilpub.a.a.a().b();
    this.c.moveCamera(CameraUpdateFactory.newLatLngZoom(localLatLng, 17.0F));
    this.c.getUiSettings().setZoomControlsEnabled(false);
    this.c.getUiSettings().setMyLocationButtonEnabled(true);
    b();
    this.c.setOnMarkerClickListener(new AMap.OnMarkerClickListener()
    {
      public boolean onMarkerClick(Marker paramAnonymousMarker)
      {
        paramAnonymousMarker = paramAnonymousMarker.getPosition();
        Iterator localIterator = SunshineRunFragment.a(SunshineRunFragment.this).iterator();
        while (localIterator.hasNext())
        {
          RoutePointModel localRoutePointModel = (RoutePointModel)localIterator.next();
          if ((Double.parseDouble(localRoutePointModel.getX()) == paramAnonymousMarker.longitude) && (Double.parseDouble(localRoutePointModel.getY()) == paramAnonymousMarker.latitude))
          {
            SunshineRunFragment.a(SunshineRunFragment.this, localRoutePointModel);
            SunshineRunFragment.b(SunshineRunFragment.this);
          }
        }
        return false;
      }
    });
    f();
  }
  
  private void e()
  {
    if (this.l != null) {
      this.l.remove();
    }
    String[] arrayOfString1 = this.f.getRoute().split(";");
    ArrayList localArrayList = new ArrayList();
    int i1 = arrayOfString1.length;
    int n = 0;
    while (n < i1)
    {
      String[] arrayOfString2 = arrayOfString1[n].split(",");
      localArrayList.add(new LatLng(Double.parseDouble(arrayOfString2[1]), Double.parseDouble(arrayOfString2[0])));
      n += 1;
    }
    this.l = this.c.addPolyline(new PolylineOptions().addAll(localArrayList).width(18.0F).color(getResources().getColor(2131099700)));
  }
  
  private void f()
  {
    if (this.j != null) {
      this.b.a(this.j.getSchoolID(), this.j.getCampusName(), this.j.getSnCode(), com.totoro.school.utils.b.b(getContext()));
    }
  }
  
  private boolean g()
  {
    if (this.g == null) {
      return false;
    }
    float[] arrayOfFloat = new float[1];
    arrayOfFloat[0] = 0.0F;
    Location.distanceBetween(Double.parseDouble(this.f.getY()), Double.parseDouble(this.f.getX()), this.g.getLatitude(), this.g.getLongitude(), arrayOfFloat);
    return (arrayOfFloat.length > 0) && (arrayOfFloat[0] / 1000.0F <= Double.parseDouble(this.h.getP_mile()));
  }
  
  public View a(String paramString1, String paramString2)
  {
    View localView = View.inflate(getContext(), 2131492973, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131296542);
    TextView localTextView2 = (TextView)localView.findViewById(2131296543);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    return localView;
  }
  
  public void a(String paramString, Object paramObject)
  {
    int n = paramString.hashCode();
    int i1 = -1;
    if ((n == 1279170979) && (paramString.equals("route_point_list"))) {
      n = 0;
    } else {
      n = -1;
    }
    if (n != 0) {
      return;
    }
    this.h = ((RoutePointReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, RoutePointReturnModel.class));
    if (this.h != null)
    {
      paramString = this.h.getCode();
      n = paramString.hashCode();
      if (n != 1715960)
      {
        switch (n)
        {
        default: 
          n = i1;
          break;
        case 1507424: 
          n = i1;
          if (!paramString.equals("1001")) {
            break;
          }
          n = 2;
          break;
        case 1507423: 
          n = i1;
          if (!paramString.equals("1000")) {
            break;
          }
          n = 1;
          break;
        }
      }
      else
      {
        n = i1;
        if (paramString.equals("8000")) {
          n = 0;
        }
      }
      switch (n)
      {
      default: 
        
      case 0: 
        com.totoro.school.utils.c.a(com.totoro.school.utils.c.a("yyyy/MM/dd"), this.h.getBegdate(), this.h.getEnddate());
        if (com.totoro.school.utils.c.a(this.h.getStartTime(), this.h.getEndTime()))
        {
          paramString = getContext();
          paramObject = new StringBuilder();
          ((StringBuilder)paramObject).append(com.totoro.school.utils.c.a("yyyy-MM-dd"));
          ((StringBuilder)paramObject).append("_runed");
          if (((Boolean)n.b(paramString, ((StringBuilder)paramObject).toString(), Boolean.valueOf(false))).booleanValue())
          {
            this.startRun.setBackground(getActivity().getResources().getDrawable(2131558421));
            this.startRun.setText(getActivity().getResources().getString(2131689620));
            this.tipsInfo.setVisibility(0);
            this.tipsInfo.setText(getActivity().getResources().getString(2131689732));
            this.startRun.setClickable(false);
          }
          else
          {
            this.startRun.setBackground(getActivity().getResources().getDrawable(2131558420));
            this.startRun.setText(getActivity().getResources().getString(2131689706));
            this.tipsInfo.setVisibility(0);
            this.tipsInfo.setText(getActivity().getResources().getString(2131689734));
            this.startRun.setClickable(true);
            this.k = false;
          }
        }
        else
        {
          this.startRun.setBackground(getActivity().getResources().getDrawable(2131558421));
          this.startRun.setText(getActivity().getResources().getString(2131689628));
          this.tipsInfo.setVisibility(0);
          this.tipsInfo.setText(getActivity().getResources().getString(2131689733));
          this.startRun.setClickable(false);
          this.k = true;
        }
        this.e = ((List)new com.google.gson.e().a(this.h.getTaskPointList().replace("\\/", ""), new com.google.gson.c.a() {}.b()));
        if ((this.e != null) && (this.e.size() > 0))
        {
          this.i.clear();
          paramString = this.e.iterator();
          while (paramString.hasNext())
          {
            paramObject = (RoutePointModel)paramString.next();
            GeoFenceEntity localGeoFenceEntity = new GeoFenceEntity();
            if ((((RoutePointModel)paramObject).getY() != null) && (((RoutePointModel)paramObject).getX() != null) && (((RoutePointModel)paramObject).getRoute() != null))
            {
              localGeoFenceEntity.setLatitude(Double.parseDouble(((RoutePointModel)paramObject).getY()));
              localGeoFenceEntity.setLongitude(Double.parseDouble(((RoutePointModel)paramObject).getX()));
              localGeoFenceEntity.setName(((RoutePointModel)paramObject).getRoutename());
              localGeoFenceEntity.setId(((RoutePointModel)paramObject).getDispno());
              this.i.add(localGeoFenceEntity);
            }
          }
          a(this.c, this.i);
        }
        break;
      }
    }
  }
  
  public void a(String paramString, Throwable paramThrowable) {}
  
  public void a_(String paramString) {}
  
  public void b()
  {
    if (this.d == null)
    {
      this.d = new AMapLocationClient(getContext());
      this.d.setLocationListener(this);
    }
    MyLocationStyle localMyLocationStyle = new MyLocationStyle();
    AMapLocationClientOption localAMapLocationClientOption = new AMapLocationClientOption();
    localAMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
    localAMapLocationClientOption.setInterval(5000L);
    localMyLocationStyle.myLocationType(5);
    this.c.setMyLocationStyle(localMyLocationStyle);
    this.c.setMyLocationEnabled(true);
    localAMapLocationClientOption.setNeedAddress(true);
    localAMapLocationClientOption.setMockEnable(false);
    this.d.setLocationOption(localAMapLocationClientOption);
    this.d.startLocation();
  }
  
  public void d_() {}
  
  @OnClick({2131296397})
  public void freeRun(View paramView)
  {
    this.freeRun.setTextColor(getActivity().getResources().getColor(2131099731));
    this.taskRun.setTextColor(-16777216);
    this.tipsInfo.setVisibility(4);
    this.m = false;
    this.startRun.setClickable(true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131492953, paramViewGroup, false);
    ButterKnife.bind(this, paramLayoutInflater);
    this.b = new f(this);
    this.j = i.a();
    c();
    this.mMapView.onCreate(paramBundle);
    d();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mMapView.onDestroy();
  }
  
  public void onLocationChanged(AMapLocation paramAMapLocation)
  {
    if ((paramAMapLocation != null) && (paramAMapLocation.getErrorCode() == 0))
    {
      if ((paramAMapLocation.getLatitude() == 0.0D) && (paramAMapLocation.getLongitude() == 0.0D)) {
        return;
      }
      this.g = paramAMapLocation;
      Object localObject = this.f;
      if (this.f != null)
      {
        localObject = new float[1];
        localObject[0] = 0.0F;
        Location.distanceBetween(Double.parseDouble(this.f.getY()), Double.parseDouble(this.f.getX()), paramAMapLocation.getLatitude(), paramAMapLocation.getLongitude(), (float[])localObject);
        if ((localObject.length <= 0) || (localObject[0] / 1000.0F > Double.parseDouble(this.h.getP_mile()))) {
          break label237;
        }
      }
      else
      {
        localObject = this.e.iterator();
        RoutePointModel localRoutePointModel;
        float[] arrayOfFloat;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localRoutePointModel = (RoutePointModel)((Iterator)localObject).next();
          arrayOfFloat = new float[1];
          arrayOfFloat[0] = 0.0F;
          Location.distanceBetween(Double.parseDouble(localRoutePointModel.getY()), Double.parseDouble(localRoutePointModel.getX()), paramAMapLocation.getLatitude(), paramAMapLocation.getLongitude(), arrayOfFloat);
        } while ((arrayOfFloat.length <= 0) || (arrayOfFloat[0] / 1000.0F > Double.parseDouble(this.h.getP_mile())));
        if (this.f == null)
        {
          this.f = localRoutePointModel;
          e();
        }
      }
      int n = 1;
      break label239;
      label237:
      n = 0;
      label239:
      if (this.k) {
        return;
      }
      if (this.m)
      {
        paramAMapLocation = getContext();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(com.totoro.school.utils.c.a("yyyy-MM-dd"));
        ((StringBuilder)localObject).append("_runed");
        if (!((Boolean)n.b(paramAMapLocation, ((StringBuilder)localObject).toString(), Boolean.valueOf(false))).booleanValue())
        {
          if (n != 0)
          {
            this.startRun.setText(getActivity().getResources().getString(2131689706));
            this.tipsInfo.setText(getActivity().getResources().getString(2131689734));
            this.tipsInfo.setVisibility(0);
            this.startRun.setClickable(true);
            return;
          }
          this.startRun.setText(getActivity().getResources().getString(2131689706));
          this.tipsInfo.setText(getActivity().getResources().getString(2131689621));
          this.tipsInfo.setVisibility(0);
          this.startRun.setClickable(false);
        }
      }
      else
      {
        this.startRun.setText(getActivity().getResources().getString(2131689706));
        this.tipsInfo.setVisibility(4);
        this.startRun.setClickable(true);
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.mMapView.onPause();
    if (this.d != null)
    {
      this.d.stopLocation();
      this.d = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.mMapView.onResume();
    if (this.d == null) {
      b();
    }
    if (this.m)
    {
      Context localContext = getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(com.totoro.school.utils.c.a("yyyy-MM-dd"));
      localStringBuilder.append("_runed");
      if (((Boolean)n.b(localContext, localStringBuilder.toString(), Boolean.valueOf(false))).booleanValue())
      {
        this.startRun.setBackground(getActivity().getResources().getDrawable(2131558421));
        this.startRun.setText(getActivity().getResources().getString(2131689620));
        this.tipsInfo.setText(getActivity().getResources().getString(2131689732));
        this.tipsInfo.setVisibility(0);
        this.startRun.setClickable(false);
      }
    }
    else
    {
      this.startRun.setText(getActivity().getResources().getString(2131689706));
      this.tipsInfo.setVisibility(4);
      this.startRun.setClickable(true);
    }
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mMapView.onSaveInstanceState(paramBundle);
  }
  
  @OnClick({2131296621})
  public void startRun(View paramView)
  {
    if (this.m)
    {
      if (this.h != null)
      {
        if (this.f != null)
        {
          if (g())
          {
            a(this.h.getMile(), this.h.getBeg_t(), this.h.getEnd_t(), getResources().getString(2131689726));
            return;
          }
          b("您距离选择的走跑点过远，请靠近后再开始走跑！");
          return;
        }
        b("请先选择任务点再开始跑步！");
      }
    }
    else
    {
      paramView = new Intent(getActivity(), TaskRunActivity.class);
      paramView.putExtra("isTask", this.m);
      startActivity(paramView);
    }
  }
  
  @OnClick({2131296641})
  public void taskRun(View paramView)
  {
    this.taskRun.setTextColor(getActivity().getResources().getColor(2131099731));
    this.freeRun.setTextColor(-16777216);
    if ((this.h != null) && (this.h.getStartTime() != null) && (this.h.getEndTime() != null)) {
      if (com.totoro.school.utils.c.a(this.h.getStartTime(), this.h.getEndTime()))
      {
        paramView = getContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(com.totoro.school.utils.c.a("yyyy-MM-dd"));
        localStringBuilder.append("_runed");
        if (((Boolean)n.b(paramView, localStringBuilder.toString(), Boolean.valueOf(false))).booleanValue())
        {
          this.startRun.setBackground(getActivity().getResources().getDrawable(2131558421));
          this.startRun.setText(getActivity().getResources().getString(2131689620));
          this.tipsInfo.setVisibility(0);
          this.tipsInfo.setText(getActivity().getResources().getString(2131689732));
          this.startRun.setClickable(false);
        }
        else
        {
          this.startRun.setBackground(getActivity().getResources().getDrawable(2131558420));
          this.startRun.setText(getActivity().getResources().getString(2131689706));
          this.tipsInfo.setVisibility(0);
          this.tipsInfo.setText(getActivity().getResources().getString(2131689734));
          this.startRun.setClickable(true);
          this.k = false;
        }
      }
      else
      {
        this.startRun.setBackground(getActivity().getResources().getDrawable(2131558421));
        this.startRun.setText(getActivity().getResources().getString(2131689628));
        this.tipsInfo.setVisibility(0);
        this.tipsInfo.setText(getActivity().getResources().getString(2131689733));
        this.startRun.setClickable(false);
        this.k = true;
      }
    }
    this.m = true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\sport\SunshineRunFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */