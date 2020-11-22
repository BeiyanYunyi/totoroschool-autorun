package com.totoro.school.frament.sport;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.amap.api.location.DPoint;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.bumptech.glide.h;
import com.bumptech.glide.load.resource.bitmap.d;
import com.totoro.school.activity.morning.MorningExercisesActivity;
import com.totoro.school.entity.GeoFenceEntity;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.entity.morning.helpCode.HelpCodeRequestModel;
import com.totoro.school.entity.morning.helpCode.HelpCodeReturnModel;
import com.totoro.school.entity.morning.qrCode.QrCodeRequestModel;
import com.totoro.school.entity.morning.qrCode.QrCodeReturnModel;
import com.totoro.school.entity.morning.taskPoint.TaskPointModel;
import com.totoro.school.entity.morning.taskPoint.TaskPointRequestModel;
import com.totoro.school.entity.morning.taskPoint.TaskPointReturnModel;
import com.totoro.school.utils.i;
import com.totoro.school.utils.n;
import com.totoro.school.view.calendar.base.CalendarLayout;
import com.totoro.school.view.calendar.base.CalendarView;
import com.totoro.school.view.calendar.base.CalendarView.e;
import com.totoro.school.view.dialog.OneButtonDialog;
import com.totoro.school.view.dialog.OneButtonDialog.a;
import com.totoro.school.view.dialog.QrCodeDialog;
import com.totoro.school.view.dialog.QrCodeDialog.a;
import com.totoro.school.view.dialog.TwoButtonDialog;
import com.totoro.school.view.dialog.TwoButtonDialog.a;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MorningFragment
  extends Fragment
  implements com.totoro.school.utilpub.network.c, CalendarView.e
{
  private static final String a = "MorningFragment";
  private com.totoro.school.e.e b;
  private AMap c;
  @BindView(2131296330)
  TextView collegeName;
  @BindView(2131296341)
  TextView currentDate;
  private ArrayList<GeoFenceEntity> d = new ArrayList();
  private int e;
  private int f;
  private int g;
  private LoginReturnModel h;
  @BindView(2131296404)
  ImageView headImage;
  @BindView(2131296405)
  ImageView helpBtn;
  private String i;
  private List<TaskPointModel> j = new ArrayList();
  private boolean k = false;
  @BindView(2131296312)
  CalendarLayout mCalendarLayout;
  @BindView(2131296313)
  CalendarView mCalendarView;
  @BindView(2131296466)
  MapView mMapView;
  @BindView(2131296596)
  LinearLayout shrinkBtn;
  @BindView(2131296599)
  ImageView signBtn;
  @BindView(2131296628)
  TextView stuName;
  @BindView(2131296729)
  TextView weekAndLunar;
  
  private void a(AMap paramAMap)
  {
    MyLocationStyle localMyLocationStyle = new MyLocationStyle();
    localMyLocationStyle.interval(5000L);
    localMyLocationStyle.strokeColor(Color.argb(0, 0, 0, 0));
    localMyLocationStyle.strokeWidth(0.0F);
    localMyLocationStyle.radiusFillColor(Color.argb(0, 0, 0, 0));
    paramAMap.setMyLocationStyle(localMyLocationStyle);
    paramAMap.setMyLocationEnabled(true);
    com.totoro.school.d.a.a().b();
  }
  
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
      int m = 0;
      while (m < paramArrayList.size())
      {
        GeoFenceEntity localGeoFenceEntity = (GeoFenceEntity)paramArrayList.get(m);
        Object localObject = new LatLng(localGeoFenceEntity.getLatitude(), localGeoFenceEntity.getLongitude());
        localObject = new MarkerOptions().position((LatLng)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        m += 1;
        localStringBuilder.append(m);
        paramAMap.addMarker(((MarkerOptions)localObject).icon(BitmapDescriptorFactory.fromView(a(localStringBuilder.toString(), localGeoFenceEntity.getName()))));
        localObject = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMarkers");
        localStringBuilder.append(localGeoFenceEntity.getLatitude());
        localStringBuilder.append("--");
        localStringBuilder.append(localGeoFenceEntity.getLongitude());
        Log.i((String)localObject, localStringBuilder.toString());
      }
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Context localContext = getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.totoro.school.utils.c.a("yyyy-MM-dd"));
    localStringBuilder.append("_signed");
    if (((Boolean)n.b(localContext, localStringBuilder.toString(), Boolean.valueOf(false))).booleanValue())
    {
      this.signBtn.setBackground(getActivity().getResources().getDrawable(2131558478));
      this.signBtn.setClickable(false);
      return;
    }
    boolean bool1 = com.totoro.school.utils.c.a(com.totoro.school.utils.c.a("yyyy/MM/dd"), paramString1, paramString2);
    boolean bool2 = com.totoro.school.utils.c.a(paramString3, paramString4);
    if ((bool1) && (bool2))
    {
      this.signBtn.setBackground(getActivity().getResources().getDrawable(2131558476));
      this.signBtn.setClickable(true);
      return;
    }
    this.signBtn.setBackground(getActivity().getResources().getDrawable(2131558458));
    this.signBtn.setClickable(false);
  }
  
  private boolean a(DPoint paramDPoint)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      TaskPointModel localTaskPointModel = (TaskPointModel)localIterator.next();
      if (com.totoro.school.d.a.a().a(paramDPoint, new DPoint(Double.parseDouble(localTaskPointModel.getY()), Double.parseDouble(localTaskPointModel.getX()))) <= Float.parseFloat(localTaskPointModel.getP_mile())) {
        return true;
      }
    }
    return false;
  }
  
  private QrCodeDialog b(String paramString)
  {
    paramString = new QrCodeDialog(getContext(), 2131755512, paramString, getString(2131689569), "关闭", new QrCodeDialog.a()
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
    return paramString;
  }
  
  private void b()
  {
    this.stuName.setText(this.h.getStuName());
    this.collegeName.setText(this.h.getSchoolName());
    this.currentDate.setText(com.totoro.school.utils.c.a("yyyy-MM-dd"));
    TextView localTextView = this.weekAndLunar;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.totoro.school.utils.c.a());
    localStringBuilder.append(",");
    localStringBuilder.append(com.totoro.school.utils.c.b());
    localTextView.setText(localStringBuilder.toString());
    com.bumptech.glide.e.a(getActivity()).a(Integer.valueOf(2131558452)).d().a(new d[] { new com.totoro.school.utils.glide.a(getActivity()) }).a(2131558452).a(this.headImage);
  }
  
  private void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new TwoButtonDialog(getContext(), 2131755512, paramString1, paramString2, paramString3, paramString4, new TwoButtonDialog.a()
    {
      public void a(String paramAnonymousString)
      {
        if ("left_btn".equals(paramAnonymousString))
        {
          MorningFragment.this.helpBtn.setBackground(MorningFragment.this.getActivity().getResources().getDrawable(2131558429));
          MorningFragment.this.helpBtn.setVisibility(0);
          MorningFragment.this.helpBtn.setClickable(false);
          return;
        }
        if ("right_btn".equals(paramAnonymousString)) {
          MorningFragment.a(MorningFragment.this);
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
  
  private void c()
  {
    this.c = this.mMapView.getMap();
    LatLng localLatLng = com.totoro.school.utilpub.a.a.a().b();
    this.c.moveCamera(CameraUpdateFactory.newLatLngZoom(localLatLng, 17.0F));
    this.c.getUiSettings().setZoomControlsEnabled(false);
    this.c.getUiSettings().setMyLocationButtonEnabled(true);
    a(this.c);
    e();
  }
  
  private void c(String paramString)
  {
    paramString = new OneButtonDialog(getContext(), 2131755512, "", paramString, "", new OneButtonDialog.a()
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
  
  private boolean d()
  {
    if (this.j != null)
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        TaskPointModel localTaskPointModel = (TaskPointModel)localIterator.next();
        boolean bool = com.totoro.school.utils.c.a(com.totoro.school.utils.c.a("yyyy/MM/dd"), localTaskPointModel.getBegdate().substring(0, 11).replace("-", "/"), localTaskPointModel.getEnddate().substring(0, 11).replace("-", "/"));
        com.totoro.school.utils.c.a(localTaskPointModel.getStarttime(), localTaskPointModel.getEndtime());
        if ((bool) && (bool)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void e()
  {
    if (this.h != null)
    {
      TaskPointRequestModel localTaskPointRequestModel = new TaskPointRequestModel();
      localTaskPointRequestModel.setSchoolName(this.h.getSchoolID());
      localTaskPointRequestModel.setCampusName(this.h.getCampusName());
      localTaskPointRequestModel.setScCode(this.h.getSnCode());
      localTaskPointRequestModel.setCurrentTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
      this.b.a(localTaskPointRequestModel);
    }
  }
  
  private void f()
  {
    if (this.h != null)
    {
      QrCodeRequestModel localQrCodeRequestModel = new QrCodeRequestModel();
      localQrCodeRequestModel.setSchoolName(this.h.getSchoolID());
      localQrCodeRequestModel.setCampusName(this.h.getCampusName());
      this.b.a(localQrCodeRequestModel);
    }
  }
  
  private void g()
  {
    if (this.h != null)
    {
      HelpCodeRequestModel localHelpCodeRequestModel = new HelpCodeRequestModel();
      localHelpCodeRequestModel.setSnCode(this.h.getSnCode());
      localHelpCodeRequestModel.setPhoneNumber(this.h.getPhoneNumber());
      localHelpCodeRequestModel.setSchoolName(this.h.getSchoolID());
      localHelpCodeRequestModel.setCampusName(this.h.getCampusName());
      localHelpCodeRequestModel.setCurrentTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
      DPoint localDPoint = com.totoro.school.d.a.a().c();
      if (localDPoint != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(localDPoint.getLongitude());
        localHelpCodeRequestModel.setX(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(localDPoint.getLatitude());
        localHelpCodeRequestModel.setY(localStringBuilder.toString());
        this.b.a(localHelpCodeRequestModel);
        return;
      }
      c("GPS尚未定位到当前位置，请稍微再试");
      return;
    }
  }
  
  public View a(String paramString1, String paramString2)
  {
    View localView = View.inflate(getContext(), 2131492974, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131296542);
    TextView localTextView2 = (TextView)localView.findViewById(2131296543);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    return localView;
  }
  
  public void a(com.totoro.school.view.calendar.base.b paramb) {}
  
  public void a(com.totoro.school.view.calendar.base.b paramb, boolean paramBoolean)
  {
    this.e = paramb.getYear();
    this.f = paramb.getMonth();
    this.g = paramb.getDay();
  }
  
  public void a(final String paramString, final Object paramObject)
  {
    int m = paramString.hashCode();
    int n = -1;
    if (m != 563217739)
    {
      if (m != 887486695)
      {
        if ((m == 2037623373) && (paramString.equals("help_qr_code")))
        {
          m = 2;
          break label79;
        }
      }
      else if (paramString.equals("task_point_list"))
      {
        m = 1;
        break label79;
      }
    }
    else if (paramString.equals("qr_code"))
    {
      m = 0;
      break label79;
    }
    m = -1;
    label79:
    GeoFenceEntity localGeoFenceEntity;
    switch (m)
    {
    default: 
      
    case 2: 
      paramString = (HelpCodeReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, HelpCodeReturnModel.class);
      if (paramString != null)
      {
        paramObject = paramString.getCode();
        m = ((String)paramObject).hashCode();
        if (m != 1507424)
        {
          if (m != 1507426)
          {
            if (m != 1715960)
            {
              m = n;
            }
            else
            {
              m = n;
              if (((String)paramObject).equals("8000")) {
                m = 1;
              }
            }
          }
          else
          {
            m = n;
            if (((String)paramObject).equals("1003")) {
              m = 2;
            }
          }
        }
        else
        {
          m = n;
          if (((String)paramObject).equals("1001")) {
            m = 0;
          }
        }
        switch (m)
        {
        default: 
          return;
        case 2: 
          c("乐于助人时间已过");
          return;
        case 1: 
          paramString = b(paramString.getQrcode());
          paramObject = new Timer();
          ((Timer)paramObject).schedule(new TimerTask()
          {
            public void run()
            {
              if (paramString.isShowing()) {
                paramString.dismiss();
              }
              MorningFragment.this.getActivity().runOnUiThread(new Runnable()
              {
                public void run()
                {
                  MorningFragment.this.helpBtn.setBackground(MorningFragment.this.getActivity().getResources().getDrawable(2131558429));
                  MorningFragment.this.helpBtn.setVisibility(0);
                  MorningFragment.this.helpBtn.setClickable(false);
                }
              });
              paramObject.cancel();
            }
          }, 10000L);
          return;
        }
        c("乐于助人二维码未生成");
        return;
      }
      break;
    case 1: 
      paramString = (TaskPointReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, TaskPointReturnModel.class);
      if (paramString != null)
      {
        paramObject = paramString.getCode();
        m = ((String)paramObject).hashCode();
        if (m != 1715960)
        {
          switch (m)
          {
          default: 
            m = n;
            break;
          case 1507424: 
            m = n;
            if (!((String)paramObject).equals("1001")) {
              break;
            }
            m = 2;
            break;
          case 1507423: 
            m = n;
            if (!((String)paramObject).equals("1000")) {
              break;
            }
            m = 1;
            break;
          }
        }
        else
        {
          m = n;
          if (((String)paramObject).equals("8000")) {
            m = 0;
          }
        }
        switch (m)
        {
        default: 
          
        case 0: 
          this.j = ((List)new com.google.gson.e().a(paramString.getTaskPointList().replace("\\/", ""), new com.google.gson.c.a() {}.b()));
          if ((this.j != null) && (this.j.size() > 0))
          {
            this.d.clear();
            paramString = this.j.iterator();
            while (paramString.hasNext())
            {
              paramObject = (TaskPointModel)paramString.next();
              localGeoFenceEntity = new GeoFenceEntity();
              localGeoFenceEntity.setLatitude(Double.parseDouble(((TaskPointModel)paramObject).getY()));
              localGeoFenceEntity.setLongitude(Double.parseDouble(((TaskPointModel)paramObject).getX()));
              localGeoFenceEntity.setName(((TaskPointModel)paramObject).getPadname());
              localGeoFenceEntity.setId(((TaskPointModel)paramObject).getPadid());
              this.d.add(localGeoFenceEntity);
            }
            a(this.c, this.d);
            return;
          }
          break;
        }
      }
      break;
    case 0: 
      paramString = (QrCodeReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, QrCodeReturnModel.class);
      if (paramString != null)
      {
        paramObject = paramString.getCode();
        if ((((String)paramObject).hashCode() == 1715960) && (((String)paramObject).equals("8000"))) {
          n = 0;
        }
        if (n != 0)
        {
          this.signBtn.setBackground(getActivity().getResources().getDrawable(2131558457));
          this.signBtn.setClickable(false);
          return;
        }
        paramString = paramString.getQrcode().split(",");
        String str1;
        String str2;
        Object localObject;
        if (paramString.length == 9)
        {
          paramObject = paramString[0];
          this.i = paramString[1];
          paramObject = paramString[2];
          localGeoFenceEntity = paramString[3];
          str1 = paramString[4];
          str2 = paramString[5];
          localObject = paramString[6];
          localObject = paramString[7];
          paramString = paramString[8];
          a((String)paramObject, localGeoFenceEntity, str1, str2);
          return;
        }
        if (paramString.length == 10)
        {
          paramObject = paramString[0];
          this.i = paramString[1];
          paramObject = paramString[2];
          localGeoFenceEntity = paramString[3];
          str1 = paramString[4];
          str2 = paramString[5];
          localObject = paramString[6];
          localObject = paramString[7];
          localObject = paramString[8];
          paramString = paramString[9];
          a((String)paramObject, localGeoFenceEntity, str1, str2);
          return;
        }
        this.signBtn.setBackground(getActivity().getResources().getDrawable(2131558457));
        this.signBtn.setClickable(false);
      }
      break;
    }
  }
  
  public void a(String paramString, Throwable paramThrowable) {}
  
  public void a_(String paramString) {}
  
  public void d_() {}
  
  @OnClick({2131296405})
  public void helpClick()
  {
    b("乐于助人提示", "你已签到成功，是否愿意帮助签到未成功的同学进行签到", "不愿意", "愿意");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131492946, paramViewGroup, false);
    ButterKnife.bind(this, paramLayoutInflater);
    this.mCalendarView.setOnCalendarSelectListener(this);
    this.b = new com.totoro.school.e.e(this);
    this.h = i.a();
    f();
    b();
    this.mMapView.onCreate(paramBundle);
    c();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.totoro.school.d.a.a().d();
    this.mMapView.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.mMapView.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.mMapView.onResume();
    Context localContext = getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.totoro.school.utils.c.a("yyyy-MM-dd"));
    localStringBuilder.append("_signed");
    if (((Boolean)n.b(localContext, localStringBuilder.toString(), Boolean.valueOf(false))).booleanValue())
    {
      this.signBtn.setBackground(getActivity().getResources().getDrawable(2131558478));
      this.signBtn.setClickable(false);
      if (this.k)
      {
        this.helpBtn.setBackground(getActivity().getResources().getDrawable(2131558429));
        this.helpBtn.setVisibility(0);
        this.helpBtn.setClickable(false);
      }
      else
      {
        this.helpBtn.setBackground(getActivity().getResources().getDrawable(2131558430));
        this.helpBtn.setVisibility(0);
        this.helpBtn.setClickable(true);
      }
    }
    else
    {
      if (d())
      {
        this.signBtn.setClickable(true);
      }
      else
      {
        this.signBtn.setClickable(false);
        this.signBtn.setBackground(getActivity().getResources().getDrawable(2131558458));
      }
      this.helpBtn.setVisibility(8);
    }
    a(this.c);
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mMapView.onSaveInstanceState(paramBundle);
  }
  
  @OnClick({2131296596})
  public void shrinkClick(View paramView)
  {
    if (this.mCalendarLayout.c())
    {
      this.mCalendarLayout.e();
      return;
    }
    this.mCalendarLayout.d();
  }
  
  @OnClick({2131296599})
  public void signClick()
  {
    Object localObject = com.totoro.school.d.a.a().c();
    if (localObject != null)
    {
      if (a((DPoint)localObject))
      {
        localObject = new Intent(getActivity(), MorningExercisesActivity.class);
        ((Intent)localObject).putExtra("qrCodes", this.i);
        ((Intent)localObject).putExtra("taskPointList", (Serializable)this.j);
        startActivity((Intent)localObject);
        return;
      }
      c("你距离学校规定的签到点距离过远，请靠近后重试！");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\sport\MorningFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */