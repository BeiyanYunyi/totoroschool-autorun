package com.totoro.school.activity.run;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationClientOption.AMapLocationPurpose;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.OnMapClickListener;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.LocationSource.OnLocationChangedListener;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.PolylineOptions;
import com.bumptech.glide.h;
import com.totoro.school.activity.MainFragmentActivity;
import com.totoro.school.e.f;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.entity.run.reg.RunRegRequestModel;
import com.totoro.school.entity.run.reg.RunRegReturnModel;
import com.totoro.school.entity.run.reg.TestDataModel;
import com.totoro.school.entity.run.routePoint.RoutePointModel;
import com.totoro.school.entity.run.routePoint.RoutePointReturnModel;
import com.totoro.school.service.AudioPlayService;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.utils.c;
import com.totoro.school.utils.i;
import com.totoro.school.utils.j;
import com.totoro.school.utils.m;
import com.totoro.school.utils.n;
import com.totoro.school.utils.o;
import com.totoro.school.view.RingLoadButton;
import com.totoro.school.view.RingLoadButton.a;
import com.totoro.school.view.dialog.GpsWeakDialog;
import com.totoro.school.view.dialog.GpsWeakDialog.a;
import com.totoro.school.view.dialog.OneButtonDialog;
import com.totoro.school.view.dialog.OneButtonDialog.a;
import com.totoro.school.view.dialog.TwoButtonDialog;
import com.totoro.school.view.dialog.TwoButtonDialog.a;
import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TaskRunActivity
  extends BaseActivity
  implements AMapLocationListener, AMap.OnMapClickListener, LocationSource
{
  public static AMapLocationClient a;
  private static NotificationManager k;
  private static boolean l = false;
  private static boolean m = false;
  private static boolean n = false;
  private static boolean o = false;
  private DPoint A;
  private List<AssetFileDescriptor> B = new ArrayList();
  private a C;
  private double D = 0.0D;
  private int E = 0;
  private double F = 0.0D;
  private String G = "--";
  private long H = 0L;
  private double I = 0.0D;
  private List<PolylineOptions> J;
  private boolean K = true;
  private String L = "Y";
  private int M = 3;
  private boolean N = false;
  private boolean O = false;
  private boolean P = false;
  private Animation Q;
  private SensorManager R;
  private b S;
  private Sensor T;
  private Sensor U;
  private int V = 0;
  private int W = 0;
  private Sensor X;
  private Sensor Y;
  private String Z = "";
  private String aa = "";
  private String ab = "";
  private String ac = "";
  private String ad = "";
  private String ae = "";
  private String af = "";
  private boolean ag = true;
  private int ah = 0;
  private int ai = 0;
  private float aj = 10.0F;
  private String ak = "";
  private String al = "";
  private boolean am = true;
  private long an = 0L;
  private GpsWeakDialog ao;
  private Handler ap = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.arg1 == 0)
      {
        TaskRunActivity.a(TaskRunActivity.this);
        if (TaskRunActivity.b(TaskRunActivity.this) == 0)
        {
          TaskRunActivity.this.mTv_countdown.setText("GO");
          TaskRunActivity.a(TaskRunActivity.this, 2131623958);
          TaskRunActivity.c(TaskRunActivity.this).sendEmptyMessageDelayed(0, 1000L);
          TaskRunActivity.this.mTv_countdown.startAnimation(TaskRunActivity.d(TaskRunActivity.this));
          return;
        }
        if (TaskRunActivity.b(TaskRunActivity.this) == -1)
        {
          TaskRunActivity.this.mTv_countdown.setVisibility(8);
          TaskRunActivity.b(TaskRunActivity.this, 3);
          TaskRunActivity.this.mTv_countdown.setText("3");
          TaskRunActivity.this.usedTime.setBase(SystemClock.elapsedRealtime());
          TaskRunActivity.this.usedTime.setOnChronometerTickListener(new TaskRunActivity.c(TaskRunActivity.this));
          TaskRunActivity.this.usedTime.start();
          TaskRunActivity.a(TaskRunActivity.this, o.a("HH:mm"));
          TaskRunActivity.c(TaskRunActivity.this).removeMessages(0);
          TaskRunActivity.e(TaskRunActivity.this);
          TaskRunActivity.a(TaskRunActivity.this, true);
          return;
        }
        paramAnonymousMessage = TaskRunActivity.this.mTv_countdown;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(TaskRunActivity.b(TaskRunActivity.this));
        paramAnonymousMessage.setText(localStringBuilder.toString());
        if (TaskRunActivity.f(TaskRunActivity.this) != null) {
          if (TaskRunActivity.b(TaskRunActivity.this) == 2) {
            TaskRunActivity.a(TaskRunActivity.this, 2131623960);
          } else if (TaskRunActivity.b(TaskRunActivity.this) == 1) {
            TaskRunActivity.a(TaskRunActivity.this, 2131623957);
          }
        }
        TaskRunActivity.c(TaskRunActivity.this).sendEmptyMessageDelayed(0, 1000L);
        TaskRunActivity.this.mTv_countdown.startAnimation(TaskRunActivity.d(TaskRunActivity.this));
      }
    }
  };
  private PowerManager.WakeLock aq = null;
  private double ar = 9999.0D;
  private double as = 9999.0D;
  private double at = -1.0D;
  private double au = -1.0D;
  private int av = 0;
  private Map<Integer, String> aw = new HashMap();
  protected DPoint b;
  @BindView(2131296307)
  RelativeLayout bottomLayout;
  protected List<DPoint> c = new ArrayList();
  @BindView(2131296330)
  TextView collegeName;
  @BindView(2131296338)
  ImageView continueRun;
  @BindView(2131296341)
  TextView currentDate;
  @BindView(2131296342)
  ImageView currentPosition;
  protected List<TestDataModel> d = new ArrayList();
  public com.totoro.school.service.a e;
  float f = 0.0F;
  int g = 0;
  @BindView(2131296400)
  LinearLayout gpsLayout;
  @BindView(2131296401)
  TextView gpsSingle;
  float h = 0.0F;
  @BindView(2131296404)
  ImageView headImage;
  final SensorEventListener i = new SensorEventListener()
  {
    public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
    
    public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      if (TaskRunActivity.f()) {
        TaskRunActivity.a(TaskRunActivity.this, paramAnonymousSensorEvent);
      }
    }
  };
  private f j;
  @BindView(2131296428)
  TextView kcalValue;
  @BindView(2131296430)
  TextView kmValue;
  @BindView(2131296466)
  MapView mMapView;
  @BindView(2131296685)
  TextView mTv_countdown;
  private boolean p = false;
  private boolean q = true;
  private boolean r = false;
  @BindView(2131296548)
  RingLoadButton runBtn;
  @BindView(2131296549)
  RelativeLayout runLayout;
  private AMap s;
  @BindView(2131296608)
  TextView speedValue;
  @BindView(2131296625)
  ImageView stopRun;
  @BindView(2131296627)
  LinearLayout stuInfoView;
  @BindView(2131296628)
  TextView stuName;
  private LocationSource.OnLocationChangedListener t;
  @BindView(2131296664)
  TextView titleView;
  private LoginReturnModel u;
  @BindView(2131296715)
  Chronometer usedTime;
  private RoutePointModel v = new RoutePointModel();
  private RoutePointReturnModel w = new RoutePointReturnModel();
  @BindView(2131296729)
  TextView weekAndLunar;
  private RunRegRequestModel x = new RunRegRequestModel();
  private boolean y = true;
  private boolean z = false;
  
  private boolean A()
  {
    if (c.a(c.a("yyyy/MM/dd"), this.w.getBegdate(), this.w.getEnddate()))
    {
      if (c.a(this.w.getStartTime(), this.w.getEndTime()))
      {
        if (this.D < Double.parseDouble(this.w.getMile())) {
          return false;
        }
        if (this.F > Double.parseDouble(this.w.getMaxspeed())) {
          return false;
        }
        if (this.F < Double.parseDouble(this.w.getMinspeed())) {
          return false;
        }
        this.I = a(1.5D, 30.0D);
        return this.I < Double.parseDouble(this.w.getTrackfit());
      }
      return false;
    }
    return false;
  }
  
  private double a(double paramDouble1, double paramDouble2)
  {
    Object localObject1 = this.v.getRoute().split(";");
    double[][] arrayOfDouble = new double[localObject1.length][];
    int i1 = 0;
    Object localObject2;
    while (i1 < localObject1.length)
    {
      localObject2 = localObject1[i1].split(",");
      arrayOfDouble[i1] = { Double.parseDouble(localObject2[0]), Double.parseDouble(localObject2[1]) };
      i1 += 1;
    }
    localObject1 = new double[this.c.size()][];
    i1 = 0;
    while (i1 < this.c.size())
    {
      localObject2 = (DPoint)this.c.get(i1);
      localObject1[i1] = { ((DPoint)localObject2).getLongitude(), ((DPoint)localObject2).getLatitude() };
      i1 += 1;
    }
    return m.a((double[][])localObject1, arrayOfDouble, paramDouble1, paramDouble2);
  }
  
  private void a(int paramInt)
  {
    this.B.clear();
    b(paramInt);
    if (this.e != null) {
      this.e.a(null, this.B, true);
    }
  }
  
  private void a(SensorEvent paramSensorEvent)
  {
    Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String str = ((DateFormat)localObject).format(new Date());
    if (((String)this.aw.get(Integer.valueOf(paramSensorEvent.sensor.getType()))).isEmpty()) {
      this.aw.put(Integer.valueOf(paramSensorEvent.sensor.getType()), str);
    }
    try
    {
      Date localDate = ((DateFormat)localObject).parse((String)this.aw.get(Integer.valueOf(paramSensorEvent.sensor.getType())));
      long l1 = ((DateFormat)localObject).parse(str).getTime() - localDate.getTime();
      long l3 = l1 / 86400000L;
      long l2 = l1 / 3600000L;
      long l5 = l3 * 24L;
      l3 = l1 / 60000L;
      long l4 = l5 * 60L;
      l2 = (l2 - l5) * 60L;
      if (l1 / 1000L - l4 * 60L - l2 * 60L - (l3 - l4 - l2) * 60L == 5L)
      {
        this.aw.put(Integer.valueOf(paramSensorEvent.sensor.getType()), str);
        if ((paramSensorEvent != null) && (paramSensorEvent.values.length >= 3))
        {
          int i1 = paramSensorEvent.sensor.getType();
          if (i1 != 1)
          {
            if (i1 == 4)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(this.ac);
              ((StringBuilder)localObject).append(paramSensorEvent.values[0]);
              ((StringBuilder)localObject).append(",");
              this.ac = ((StringBuilder)localObject).toString();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(this.ad);
              ((StringBuilder)localObject).append(paramSensorEvent.values[1]);
              ((StringBuilder)localObject).append(",");
              this.ad = ((StringBuilder)localObject).toString();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(this.ae);
              ((StringBuilder)localObject).append(paramSensorEvent.values[2]);
              ((StringBuilder)localObject).append(",");
              this.ae = ((StringBuilder)localObject).toString();
            }
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.Z);
            ((StringBuilder)localObject).append(paramSensorEvent.values[0]);
            ((StringBuilder)localObject).append(",");
            this.Z = ((StringBuilder)localObject).toString();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.aa);
            ((StringBuilder)localObject).append(paramSensorEvent.values[1]);
            ((StringBuilder)localObject).append(",");
            this.aa = ((StringBuilder)localObject).toString();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.ab);
            ((StringBuilder)localObject).append(paramSensorEvent.values[2]);
            ((StringBuilder)localObject).append(",");
            this.ab = ((StringBuilder)localObject).toString();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("版本号:");
          ((StringBuilder)localObject).append(com.totoro.school.utils.b.b(getApplicationContext()));
          ((StringBuilder)localObject).append("\n");
          ((StringBuilder)localObject).append(paramSensorEvent.sensor.getName());
          ((StringBuilder)localObject).append("传感器获取时间点:");
          ((StringBuilder)localObject).append(c.a("yyyy/MM/dd HH:mm:ss"));
          ((StringBuilder)localObject).append("\n");
          ((StringBuilder)localObject).append("x:");
          ((StringBuilder)localObject).append(paramSensorEvent.values[0]);
          ((StringBuilder)localObject).append("\n");
          ((StringBuilder)localObject).append("y:");
          ((StringBuilder)localObject).append(paramSensorEvent.values[1]);
          ((StringBuilder)localObject).append("\n");
          ((StringBuilder)localObject).append("z:");
          ((StringBuilder)localObject).append(paramSensorEvent.values[2]);
          ((StringBuilder)localObject).append("\n");
          ((StringBuilder)localObject).append("--------------------------------------------------------");
          ((StringBuilder)localObject).toString();
          return;
        }
      }
    }
    catch (ParseException paramSensorEvent)
    {
      paramSensorEvent.printStackTrace();
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    this.x = new RunRegRequestModel();
    this.x.setTask(this.K);
    this.x.setSnCode(this.u.getSnCode());
    this.x.setSchoolName(this.u.getSchoolID());
    this.x.setPhoneNumber(this.u.getPhoneNumber());
    paramString1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    this.x.setCurrentTime(paramString1.format(new Date()));
    paramString1 = new SimpleDateFormat("yyyy-MM-dd");
    this.x.setBegdate(paramString1.format(new Date()));
    this.x.setEnddate(paramString1.format(new Date()));
    this.x.setBaseStation(com.totoro.school.utils.d.a(this));
    this.x.setMac(j.a(getApplicationContext()));
    this.x.setRoute(o());
    this.x.setFlag("Y");
    this.x.setWarnflag(paramString2);
    this.x.setWarntype(paramString3);
    this.x.setTaskid(this.v.getTaskid());
    this.x.setRouteid(this.v.getRouteid());
    paramString1 = this.x;
    paramString2 = new StringBuilder();
    paramString2.append("");
    paramString2.append(this.F);
    paramString1.setUserspeed(paramString2.toString());
    if (this.r)
    {
      if (this.T != null)
      {
        paramString1 = this.x;
        paramString2 = new StringBuilder();
        paramString2.append("");
        paramString2.append(this.ai - this.ah);
        paramString1.setUserstep(paramString2.toString());
      }
      else if (this.U != null)
      {
        paramString1 = this.x;
        paramString2 = new StringBuilder();
        paramString2.append("");
        paramString2.append(this.V);
        paramString1.setUserstep(paramString2.toString());
      }
    }
    else {
      this.x.setUserstep("0");
    }
    paramString1 = this.x;
    paramString2 = new StringBuilder();
    paramString2.append("");
    paramString2.append(this.I);
    paramString1.setUserfit(paramString2.toString());
    this.x.setUseroffset(String.valueOf(n()));
    this.x.setUserkm(this.kmValue.getText().toString());
    this.x.setUsertime(this.usedTime.getText().toString());
    this.x.setUserbegtime(this.ak);
    this.al = o.a("HH:mm");
    this.x.setUserendtime(this.al);
    paramString1 = this.x;
    paramString2 = new StringBuilder();
    paramString2.append("");
    paramString2.append(this.ah);
    paramString1.setUserstartstep(paramString2.toString());
    paramString1 = this.x;
    paramString2 = new StringBuilder();
    paramString2.append("");
    paramString2.append(this.ai);
    paramString1.setUserendstep(paramString2.toString());
    this.x.setUserstartkm("0");
    this.x.setUserendkm(this.kmValue.getText().toString());
    if (l)
    {
      this.x.setGsensorx(this.Z);
      this.x.setGsensory(this.aa);
      this.x.setGsensorz(this.ab);
      this.x.setGysensorx(this.ac);
      this.x.setGysensory(this.ad);
      this.x.setGysensorz(this.ae);
      this.x.setLuxsensor(this.af);
    }
    this.j.a(this.x, getBaseContext());
    this.z = true;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new TwoButtonDialog(this, 2131755512, paramString1, paramString2, paramString3, paramString4, new TwoButtonDialog.a()
    {
      public void a(String paramAnonymousString)
      {
        if ("left_btn".equals(paramAnonymousString))
        {
          if (!TaskRunActivity.p(TaskRunActivity.this))
          {
            TaskRunActivity.j(TaskRunActivity.this);
            TaskRunActivity.this.finish();
          }
        }
        else if ("right_btn".equals(paramAnonymousString))
        {
          if (TaskRunActivity.k(TaskRunActivity.this) > 0.01D) {
            TaskRunActivity.b(TaskRunActivity.this, "");
          }
          TaskRunActivity.j(TaskRunActivity.this);
          TaskRunActivity.this.finish();
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
  
  private void b(int paramInt)
  {
    if (this.B != null)
    {
      AssetFileDescriptor localAssetFileDescriptor = getResources().openRawResourceFd(paramInt);
      this.B.add(localAssetFileDescriptor);
    }
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    if (isFinishing()) {
      return;
    }
    paramString1 = new OneButtonDialog(this, 2131755512, paramString1, paramString2, paramString3, new OneButtonDialog.a()
    {
      public void a(String paramAnonymousString)
      {
        if (("confirm_btn".equals(paramAnonymousString)) && (TaskRunActivity.i(TaskRunActivity.this)))
        {
          paramAnonymousString = TaskRunActivity.this.getApplicationContext();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(c.a("yyyy-MM-dd"));
          localStringBuilder.append("_runed");
          n.a(paramAnonymousString, localStringBuilder.toString(), Boolean.valueOf(true));
          TaskRunActivity.b(TaskRunActivity.this, "Y");
          TaskRunActivity.j(TaskRunActivity.this);
          TaskRunActivity.this.finish();
        }
      }
    });
    paramString2 = paramString1.getWindow();
    paramString3 = paramString2.getAttributes();
    paramString2.setGravity(17);
    paramString2.setAttributes(paramString3);
    paramString1.setCanceledOnTouchOutside(false);
    paramString1.setCancelable(false);
    paramString1.show();
  }
  
  private void c(String paramString)
  {
    Object localObject1 = UUID.randomUUID().toString();
    this.x = new RunRegRequestModel();
    this.x.setUuid((String)localObject1);
    this.x.setTask(this.K);
    if (this.K) {
      this.x.setCanAppeal(A());
    }
    this.x.setSnCode(this.u.getSnCode());
    this.x.setPhoneNumber(this.u.getPhoneNumber());
    Object localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    this.x.setCurrentTime(((SimpleDateFormat)localObject2).format(new Date()));
    localObject2 = new SimpleDateFormat("yyyy/MM/dd");
    this.x.setBegdate(((SimpleDateFormat)localObject2).format(new Date()));
    this.x.setEnddate(((SimpleDateFormat)localObject2).format(new Date()));
    this.x.setBaseStation(com.totoro.school.utils.d.a(this));
    this.x.setMac(j.a(getApplicationContext()));
    this.x.setRoute(o());
    this.x.setFlag(paramString);
    if ("Y".equals(paramString)) {
      this.x.setQualified(true);
    } else {
      this.x.setQualified(false);
    }
    if (this.v != null)
    {
      this.x.setTaskid(this.v.getTaskid());
      this.x.setRouteid(this.v.getRouteid());
    }
    paramString = this.x;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.F);
    paramString.setUserspeed(((StringBuilder)localObject2).toString());
    if (this.r)
    {
      if (this.T != null)
      {
        paramString = this.x;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(this.ai - this.ah);
        paramString.setUserstep(((StringBuilder)localObject2).toString());
      }
      else if (this.U != null)
      {
        paramString = this.x;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(this.V);
        paramString.setUserstep(((StringBuilder)localObject2).toString());
      }
    }
    else {
      this.x.setUserstep("0");
    }
    paramString = this.x;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.I);
    paramString.setUserfit(((StringBuilder)localObject2).toString());
    this.x.setUserkm(this.kmValue.getText().toString());
    this.x.setUsertime(this.usedTime.getText().toString());
    this.x.setUserbegtime(this.ak);
    this.al = o.a("HH:mm");
    this.x.setUserendtime(this.al);
    paramString = this.x;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.ah);
    paramString.setUserstartstep(((StringBuilder)localObject2).toString());
    paramString = this.x;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.W);
    paramString.setUserendstep(((StringBuilder)localObject2).toString());
    this.x.setUserstartkm("0");
    this.x.setUserendkm(this.kmValue.getText().toString());
    this.x.save();
    if (this.v != null)
    {
      this.v.setUuid((String)localObject1);
      this.v.save();
    }
    if (l)
    {
      paramString = new ArrayList();
      localObject1 = new ArrayList();
      ((List)localObject1).add("用时");
      ((List)localObject1).add("瞬时速度");
      ((List)localObject1).add("平均配速");
      ((List)localObject1).add("当前总步数");
      ((List)localObject1).add("当前总公里数");
      ((List)localObject1).add("时间点");
      paramString.add(localObject1);
      localObject1 = this.d.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TestDataModel)((Iterator)localObject1).next();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(((TestDataModel)localObject2).getUsedTime());
        localArrayList.add(((TestDataModel)localObject2).getCurrentSpeed());
        localArrayList.add(((TestDataModel)localObject2).getAverageSpeed());
        localArrayList.add(((TestDataModel)localObject2).getCurrentSteps());
        localArrayList.add(((TestDataModel)localObject2).getMileage());
        localArrayList.add(((TestDataModel)localObject2).getTime());
        paramString.add(localArrayList);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(c.a("yyyy_MM_dd_HH:mm:ss"));
      ((StringBuilder)localObject1).append("Test.xls");
      com.totoro.school.utils.e.a(((StringBuilder)localObject1).toString(), paramString);
    }
  }
  
  private void h()
  {
    this.runBtn.setOnProgressTouchListener(new RingLoadButton.a()
    {
      public void a()
      {
        TaskRunActivity.g(TaskRunActivity.this);
        TaskRunActivity.h(TaskRunActivity.this);
      }
      
      public void a(RingLoadButton paramAnonymousRingLoadButton) {}
      
      public void b(RingLoadButton paramAnonymousRingLoadButton)
      {
        TaskRunActivity.this.runBtn.a();
      }
      
      public void c(RingLoadButton paramAnonymousRingLoadButton) {}
    });
  }
  
  private void i()
  {
    this.y = false;
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130771992);
    this.continueRun.setAnimation(localAnimation);
    this.stopRun.setAnimation(localAnimation);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        TaskRunActivity.this.continueRun.setVisibility(0);
        TaskRunActivity.this.stopRun.setVisibility(0);
        TaskRunActivity.this.continueRun.setClickable(true);
        TaskRunActivity.this.stopRun.setClickable(true);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        TaskRunActivity.this.continueRun.setVisibility(0);
        TaskRunActivity.this.stopRun.setVisibility(0);
      }
    });
    localAnimation = AnimationUtils.loadAnimation(this, 2130771982);
    this.runBtn.setAnimation(localAnimation);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        TaskRunActivity.this.runBtn.setVisibility(4);
        TaskRunActivity.this.runBtn.setClickable(false);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
  }
  
  private void j()
  {
    this.y = true;
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130771982);
    this.continueRun.setAnimation(localAnimation);
    this.stopRun.setAnimation(localAnimation);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        TaskRunActivity.this.continueRun.setVisibility(8);
        TaskRunActivity.this.stopRun.setVisibility(8);
        TaskRunActivity.this.continueRun.setClickable(false);
        TaskRunActivity.this.stopRun.setClickable(false);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    localAnimation = AnimationUtils.loadAnimation(this, 2130771992);
    this.runBtn.setAnimation(localAnimation);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        TaskRunActivity.this.runBtn.setVisibility(0);
        TaskRunActivity.this.runBtn.setClickable(true);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        TaskRunActivity.this.runBtn.setVisibility(0);
      }
    });
  }
  
  private void k()
  {
    this.stuName.setText(this.u.getStuName());
    this.collegeName.setText(this.u.getSchoolName());
    this.currentDate.setText(c.a("yyyy-MM-dd"));
    TextView localTextView = this.weekAndLunar;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c.a());
    localStringBuilder.append(",");
    localStringBuilder.append(c.b());
    localTextView.setText(localStringBuilder.toString());
    if (this.K)
    {
      this.stopRun.setBackgroundResource(2131558480);
      this.titleView.setText(getString(2131689713));
    }
    else
    {
      this.stopRun.setBackgroundResource(2131558479);
      this.titleView.setText(getString(2131689562));
    }
    com.bumptech.glide.e.b(getApplicationContext()).a(Integer.valueOf(2131558452)).d().a(new com.bumptech.glide.load.resource.bitmap.d[] { new com.totoro.school.utils.glide.a(getApplicationContext()) }).a(2131558452).a(this.headImage);
  }
  
  private void l()
  {
    this.v = ((RoutePointModel)getIntent().getSerializableExtra("routePointModel"));
    this.w = ((RoutePointReturnModel)getIntent().getSerializableExtra("routePointReturnModel"));
    this.K = getIntent().getBooleanExtra("isTask", false);
    if (this.w != null)
    {
      if ("Y".equals(this.w.getSensorFlag())) {
        l = true;
      } else {
        l = false;
      }
      if ("Y".equals(this.w.getSendFlag()))
      {
        this.P = true;
        return;
      }
      this.P = false;
    }
  }
  
  private void m()
  {
    this.Q = AnimationUtils.loadAnimation(this, 2130771983);
    this.mTv_countdown.startAnimation(this.Q);
    a(2131623959);
    this.ap.sendEmptyMessageDelayed(0, 1000L);
  }
  
  private double n()
  {
    double d1 = (this.ar * 1.0D + this.at * 1.0D) / 2.0D;
    return m.a((this.as * 1.0D + this.au * 1.0D) / 2.0D, d1, Double.parseDouble(this.v.getY()), Double.parseDouble(this.v.getX())) / 1000.0D;
  }
  
  private String o()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      DPoint localDPoint = (DPoint)localIterator.next();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(localDPoint.getLongitude());
      localStringBuilder2.append(",");
      localStringBuilder2.append(localDPoint.getLatitude());
      localStringBuilder2.append(";");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.substring(0, localStringBuilder1.length() - 1);
  }
  
  private void p()
  {
    this.s = this.mMapView.getMap();
    LatLng localLatLng = com.totoro.school.utilpub.a.a.a().b();
    this.s.moveCamera(CameraUpdateFactory.newLatLngZoom(localLatLng, 17.0F));
    this.s.getUiSettings().setZoomControlsEnabled(false);
    this.s.setOnMapClickListener(this);
    this.s.setLocationSource(this);
    a();
    if ((this.v != null) && (this.K)) {
      q();
    }
  }
  
  private void q()
  {
    String[] arrayOfString1 = this.v.getRoute().split(";");
    ArrayList localArrayList = new ArrayList();
    int i2 = arrayOfString1.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String[] arrayOfString2 = arrayOfString1[i1].split(",");
      localArrayList.add(new LatLng(Double.parseDouble(arrayOfString2[1]), Double.parseDouble(arrayOfString2[0])));
      i1 += 1;
    }
    this.s.addPolyline(new PolylineOptions().addAll(localArrayList).width(18.0F).color(getResources().getColor(2131099700)));
  }
  
  private void r()
  {
    this.y = true;
    this.runBtn.setBackground(getResources().getDrawable(2131558465));
    this.runBtn.setClickable(false);
    if (this.an != 0L) {
      this.usedTime.setBase(this.usedTime.getBase() + (SystemClock.elapsedRealtime() - this.an));
    } else {
      this.usedTime.setBase(SystemClock.elapsedRealtime());
    }
    this.usedTime.start();
  }
  
  private void s()
  {
    this.y = false;
    this.runBtn.setBackground(getResources().getDrawable(2131558473));
    this.runBtn.setClickable(true);
    this.usedTime.stop();
    this.an = SystemClock.elapsedRealtime();
  }
  
  private void t()
  {
    boolean bool = l;
    if (c.a(c.a("yyyy/MM/dd"), this.w.getBegdate(), this.w.getEnddate()))
    {
      if (c.a(this.w.getStartTime(), this.w.getEndTime()))
      {
        if (this.D < Double.parseDouble(this.w.getMile()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("阳光跑不符合要求：你当前的公里数小于学校规定的<font color='#FE0000'>最少");
          localStringBuilder.append(this.w.getMile());
          localStringBuilder.append("公里</font>");
          localStringBuilder.append(",成绩不合格，请继续跑步！");
          b("成绩不合格", Html.fromHtml(localStringBuilder.toString()).toString(), "我知道了");
          return;
        }
        if (this.F > Double.parseDouble(this.w.getMaxspeed()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("阳光跑不符合要求：你校规定阳光跑最高时速为");
          localStringBuilder.append(this.w.getMaxspeed());
          localStringBuilder.append("公里/时，你的成绩不合格");
          b("成绩不合格", localStringBuilder.toString(), "我知道了");
          return;
        }
        if (this.F < Double.parseDouble(this.w.getMinspeed()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("阳光跑不符合要求：你校规定阳光跑最低时速为");
          localStringBuilder.append(this.w.getMinspeed());
          localStringBuilder.append("公里/时，你的成绩不合格");
          b("成绩不合格", localStringBuilder.toString(), "我知道了");
          return;
        }
        this.I = a(1.5D, 30.0D);
        if (this.I >= Double.parseDouble(this.w.getTrackfit()))
        {
          if (this.r)
          {
            int i2 = (int)(this.D * 1000.0D / 0.75D);
            int i1;
            if (this.V > 0) {
              i1 = this.V;
            } else {
              i1 = this.ai - this.ah;
            }
            double d1 = i1;
            double d2 = i2;
            Double.isNaN(d2);
            if (d1 >= 0.6D * d2)
            {
              Double.isNaN(d2);
              if (d1 <= d2 * 1.3D)
              {
                a(this.L, "N", "");
                return;
              }
            }
            this.O = true;
            if (this.P)
            {
              a(this.L, "Y", "0");
              return;
            }
            b("成绩不合格", "阳光跑不符合要求：你本次阳光跑实际步数与公里数换算后的步数严重不匹配.", "我知道了");
            return;
          }
          a(this.L, "N", "");
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("阳光跑不符合要求：你校规定阳光跑轨迹拟合度至少");
        localStringBuilder.append(this.w.getTrackfit());
        localStringBuilder.append(",当前拟合度为");
        localStringBuilder.append(this.I);
        b("成绩不合格", localStringBuilder.toString(), "我知道了");
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("阳光跑不符合要求：你校规定阳光跑时间为");
      localStringBuilder.append(this.w.getStartTime());
      localStringBuilder.append("-");
      localStringBuilder.append(this.w.getEndTime());
      b("成绩不合格", localStringBuilder.toString(), "我知道了");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("阳光跑不符合要求：你校规定阳光跑日期为");
    localStringBuilder.append(this.w.getBegdate());
    localStringBuilder.append("-");
    localStringBuilder.append(this.w.getEnddate());
    b("成绩不合格", localStringBuilder.toString(), "我知道了");
  }
  
  private void u()
  {
    this.R.unregisterListener(this.S, this.U);
    this.R.unregisterListener(this.S, this.T);
    if (l)
    {
      this.R.unregisterListener(this.i, this.X);
      this.R.unregisterListener(this.i, this.Y);
    }
    a.unRegisterLocationListener(this);
    v();
  }
  
  private void v()
  {
    stopService(new Intent(this, MyService.class));
    if (k != null)
    {
      o = true;
      k.cancel(1);
      o = false;
    }
  }
  
  private void w()
  {
    if (m) {
      return;
    }
    if (com.totoro.school.utils.a.a(this))
    {
      if (this.ao == null)
      {
        this.ao = new GpsWeakDialog(this, 2131755512, "GPS信号", "", "我知道了", new GpsWeakDialog.a()
        {
          public void a(String paramAnonymousString)
          {
            "confirm_btn".equals(paramAnonymousString);
          }
        });
        Window localWindow = this.ao.getWindow();
        WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
        localWindow.setGravity(17);
        localWindow.setAttributes(localLayoutParams);
        this.ao.setCanceledOnTouchOutside(true);
        this.ao.setCancelable(true);
      }
      if (!this.ao.isShowing()) {
        this.ao.show();
      }
    }
  }
  
  private void x()
  {
    int i1 = (int)this.D;
    if (i1 > this.E)
    {
      this.E = i1;
      switch (this.E)
      {
      default: 
        return;
      case 20: 
        a(2131623948);
        return;
      case 19: 
        a(2131623946);
        return;
      case 18: 
        a(2131623945);
        return;
      case 17: 
        a(2131623944);
        return;
      case 16: 
        a(2131623943);
        return;
      case 15: 
        a(2131623942);
        return;
      case 14: 
        a(2131623941);
        return;
      case 13: 
        a(2131623940);
        return;
      case 12: 
        a(2131623939);
        return;
      case 11: 
        a(2131623938);
        return;
      case 10: 
        a(2131623937);
        return;
      case 9: 
        a(2131623956);
        return;
      case 8: 
        a(2131623955);
        return;
      case 7: 
        a(2131623954);
        return;
      case 6: 
        a(2131623953);
        return;
      case 5: 
        a(2131623952);
        return;
      case 4: 
        a(2131623951);
        return;
      case 3: 
        a(2131623950);
        return;
      case 2: 
        a(2131623949);
        return;
      }
      a(2131623947);
    }
  }
  
  private void y()
  {
    if (this.D == 0.0D)
    {
      this.kmValue.setText("0.00");
    }
    else
    {
      double d1 = new BigDecimal(this.D).setScale(2, 4).doubleValue();
      this.kmValue.setText(String.valueOf(d1));
    }
    this.speedValue.setText(this.G);
    TextView localTextView = this.kcalValue;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((int)(this.D * 67.34D));
    localStringBuilder.append("");
    localTextView.setText(localStringBuilder.toString());
  }
  
  private void z()
  {
    com.totoro.school.b.a.a.a(this, "定位轨迹服务的持续运行");
    com.totoro.school.b.a.a.a(this, MyService.class);
  }
  
  public void a()
  {
    if (a == null)
    {
      a = new AMapLocationClient(getApplicationContext());
      a.setLocationListener(this);
    }
    MyLocationStyle localMyLocationStyle = new MyLocationStyle();
    AMapLocationClientOption localAMapLocationClientOption = new AMapLocationClientOption();
    localAMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
    localAMapLocationClientOption.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.Sport);
    localAMapLocationClientOption.setInterval(5000L);
    localMyLocationStyle.interval(5000L);
    this.s.setMyLocationStyle(localMyLocationStyle);
    this.s.setMyLocationEnabled(true);
    localAMapLocationClientOption.setNeedAddress(true);
    localAMapLocationClientOption.setMockEnable(false);
    a.setLocationOption(localAMapLocationClientOption);
    a.startLocation();
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.z = false;
    int i1 = paramString.hashCode();
    int i2 = -1;
    if ((i1 == 1550345440) && (paramString.equals("run_reg"))) {
      i1 = 0;
    } else {
      i1 = -1;
    }
    if (i1 != 0) {
      return;
    }
    paramString = (RunRegReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, RunRegReturnModel.class);
    if (paramString != null)
    {
      paramString = paramString.getCode();
      i1 = paramString.hashCode();
      if (i1 != 1686169)
      {
        if (i1 != 1715960)
        {
          i1 = i2;
        }
        else
        {
          i1 = i2;
          if (paramString.equals("8000")) {
            i1 = 0;
          }
        }
      }
      else
      {
        i1 = i2;
        if (paramString.equals("7000")) {
          i1 = 1;
        }
      }
      switch (i1)
      {
      default: 
        b("提示", "服务器异常，请稍后重试！", "我知道了");
        this.N = false;
        return;
      case 1: 
        b("提示", "今天已成功提交走跑数据，无法再次提交！", "我知道了");
        return;
      }
      this.N = true;
      if (this.P)
      {
        if (this.O)
        {
          b("警告", "本次走跑可能存在作弊，请下次一定按照规定走跑", "我知道了");
          return;
        }
        b("成绩合格", "恭喜:你本次阳光跑成绩合格！", "我知道了");
        return;
      }
      b("成绩合格", "恭喜:你本次阳光跑成绩合格！", "我知道了");
    }
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    int i1 = 0;
    this.z = false;
    if ((paramString.hashCode() != 1550345440) || (!paramString.equals("run_reg"))) {
      i1 = -1;
    }
    if (i1 != 0) {
      return;
    }
    b("提示", "提交走跑数据失败，请重新提交！", "我知道了");
  }
  
  public void activate(LocationSource.OnLocationChangedListener paramOnLocationChangedListener)
  {
    this.t = paramOnLocationChangedListener;
  }
  
  public void b()
  {
    this.s.getUiSettings().setMyLocationButtonEnabled(false);
    LatLng localLatLng = new LatLng(((DPoint)this.c.get(0)).getLatitude(), ((DPoint)this.c.get(0)).getLongitude());
    MarkerOptions localMarkerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(2131558428));
    this.s.addMarker(localMarkerOptions).setPosition(localLatLng);
  }
  
  @OnClick({2131296298})
  public void back(View paramView)
  {
    a("提示", "本次阳光跑记录尚未上传，是否确定退出阳光跑页面？", "否", "是");
  }
  
  @OnClick({2131296338})
  public void continueRun(View paramView)
  {
    if (!this.y)
    {
      j();
      r();
    }
  }
  
  @OnClick({2131296342})
  public void currentPosition(View paramView)
  {
    if (this.A != null) {
      this.s.animateCamera(CameraUpdateFactory.changeLatLng(new LatLng(this.A.getLatitude(), this.A.getLongitude())));
    }
  }
  
  public void deactivate()
  {
    if (a != null)
    {
      a.stopLocation();
      a.onDestroy();
    }
    a = null;
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    setContentView(2131492917);
    ButterKnife.bind(this);
    this.j = new f(this);
    l();
    this.u = i.a();
    Intent localIntent = new Intent(this, AudioPlayService.class);
    this.C = new a();
    bindService(localIntent, this.C, 1);
    this.R = ((SensorManager)getSystemService("sensor"));
    this.T = this.R.getDefaultSensor(19);
    this.U = this.R.getDefaultSensor(18);
    boolean bool;
    if ((this.T == null) && (this.U == null)) {
      bool = false;
    } else {
      bool = true;
    }
    this.r = bool;
    if (l)
    {
      this.X = this.R.getDefaultSensor(1);
      this.Y = this.R.getDefaultSensor(4);
    }
    this.S = new b();
    k();
    this.mMapView.onCreate(paramBundle);
    p();
    h();
  }
  
  protected void onDestroy()
  {
    if (a != null)
    {
      a.stopLocation();
      a.onDestroy();
      a = null;
    }
    this.mMapView.onDestroy();
    try
    {
      unbindService(this.C);
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    a("提示", "本次阳光跑记录尚未上传，是否确定退出阳光跑页面？", "否", "是");
    return false;
  }
  
  public void onLocationChanged(AMapLocation paramAMapLocation)
  {
    if ((paramAMapLocation != null) && (paramAMapLocation.getErrorCode() == 0))
    {
      if ((paramAMapLocation.getLatitude() == 0.0D) && (paramAMapLocation.getLongitude() == 0.0D)) {
        return;
      }
      if (!this.y) {
        return;
      }
      if (this.r)
      {
        if (this.T != null)
        {
          i1 = this.ai - this.ah;
          break label85;
        }
        if (this.U != null)
        {
          i1 = this.V;
          break label85;
        }
      }
      int i1 = 0;
      label85:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("版本号:");
      ((StringBuilder)localObject).append(com.totoro.school.utils.b.b(getApplicationContext()));
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("定位时间点:");
      ((StringBuilder)localObject).append(c.a("yyyy/MM/dd HH:mm:ss"));
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("定位精度:");
      ((StringBuilder)localObject).append(paramAMapLocation.getAccuracy());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("室内外置信度:");
      ((StringBuilder)localObject).append(paramAMapLocation.getConScenario());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("卫星信号强度（1：强 2：弱 -1：未知）:");
      ((StringBuilder)localObject).append(paramAMapLocation.getGpsAccuracyStatus());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("定位结果来源（1：卫星定位 2：前次定位 4：缓存定位 5：Wifi定位 6：基站定位 8：离线定位 9：最后位置缓存）:");
      ((StringBuilder)localObject).append(paramAMapLocation.getLocationType());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("可信度（1：非常可信 2：可信度一般 3：可信度较低 4：非常不可信）:");
      ((StringBuilder)localObject).append(paramAMapLocation.getTrustedLevel());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("定位方式:");
      ((StringBuilder)localObject).append(paramAMapLocation.getProvider());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("海拔高度:");
      ((StringBuilder)localObject).append(paramAMapLocation.getAltitude());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("方向角:");
      ((StringBuilder)localObject).append(paramAMapLocation.getBearing());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("纬度:");
      ((StringBuilder)localObject).append(paramAMapLocation.getLatitude());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("经度:");
      ((StringBuilder)localObject).append(paramAMapLocation.getLongitude());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("瞬时速度:");
      ((StringBuilder)localObject).append(paramAMapLocation.getSpeed());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("平均配速:");
      ((StringBuilder)localObject).append(this.F);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("当前步数:");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("当前公里数:");
      ((StringBuilder)localObject).append(this.D);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append("用时:");
      ((StringBuilder)localObject).append(this.usedTime.getText());
      ((StringBuilder)localObject).append("--------------------------------------------------------");
      ((StringBuilder)localObject).toString();
      double d1;
      if (this.D == 0.0D) {
        d1 = 0.0D;
      } else {
        d1 = new BigDecimal(this.D).setScale(2, 4).doubleValue();
      }
      localObject = new TestDataModel(this.usedTime.getText().toString(), String.valueOf(paramAMapLocation.getSpeed()), this.G, String.valueOf(i1), String.valueOf(d1), c.a("yyyy/MM/dd HH:mm:ss"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.af);
      localStringBuilder.append(this.usedTime.getText().toString());
      localStringBuilder.append(",");
      localStringBuilder.append(String.valueOf(paramAMapLocation.getSpeed()));
      localStringBuilder.append(",");
      localStringBuilder.append(this.G);
      localStringBuilder.append(",");
      localStringBuilder.append(String.valueOf(i1));
      localStringBuilder.append(",");
      localStringBuilder.append(String.valueOf(d1));
      localStringBuilder.append(",");
      localStringBuilder.append(c.a("yyyy/MM/dd HH:mm:ss"));
      localStringBuilder.append(";");
      this.af = localStringBuilder.toString();
      this.d.add(localObject);
      switch (paramAMapLocation.getGpsAccuracyStatus())
      {
      }
      if ((paramAMapLocation.getAccuracy() >= 65.0F) && (this.p)) {
        w();
      }
      if (paramAMapLocation.getAccuracy() >= 65.0F)
      {
        this.gpsSingle.setText(getString(2131689724));
        this.gpsSingle.setTextColor(ContextCompat.getColor(getApplicationContext(), 2131099728));
      }
      else if (paramAMapLocation.getAccuracy() >= 25.0F)
      {
        this.gpsSingle.setText(getString(2131689722));
        this.gpsSingle.setTextColor(ContextCompat.getColor(getApplicationContext(), 2131099726));
      }
      else
      {
        this.gpsSingle.setText(getString(2131689723));
        this.gpsSingle.setTextColor(ContextCompat.getColor(getApplicationContext(), 2131099727));
      }
      if ((paramAMapLocation.getAccuracy() >= 50.0F) && (!this.am))
      {
        this.g += 1;
        return;
      }
      if (this.t != null) {
        this.t.onLocationChanged(paramAMapLocation);
      }
      this.b = new DPoint(paramAMapLocation.getLatitude(), paramAMapLocation.getLongitude());
      if (this.ar > paramAMapLocation.getLongitude()) {
        this.ar = paramAMapLocation.getLongitude();
      }
      if (this.as > paramAMapLocation.getLatitude()) {
        this.as = paramAMapLocation.getLatitude();
      }
      if (this.at < paramAMapLocation.getLongitude()) {
        this.at = paramAMapLocation.getLongitude();
      }
      if (this.au < paramAMapLocation.getLatitude()) {
        this.au = paramAMapLocation.getLatitude();
      }
      if (this.A != null)
      {
        localObject = new float[1];
        localObject[0] = 0.0F;
        Location.distanceBetween(this.A.getLatitude(), this.A.getLongitude(), this.b.getLatitude(), this.b.getLongitude(), (float[])localObject);
        if (localObject.length > 0)
        {
          d1 = localObject[0] / 1000.0F;
          if (this.K) {
            if (this.h > paramAMapLocation.getSpeed()) {
              float f1 = this.h;
            } else {
              paramAMapLocation.getSpeed();
            }
          }
          double d2 = this.D;
          Double.isNaN(d1);
          this.D = (d2 + d1);
          x();
          long l1 = System.currentTimeMillis() - this.H;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("intervalTime:");
          ((StringBuilder)localObject).append(l1);
          Log.e("test", ((StringBuilder)localObject).toString());
          if ((this.H != 0L) && (l1 > 60000L)) {
            b("提示", "点位间距时间过长，可能是由于未设置自启动或关闭省电模式等功能，请前往设置，否则将影响您的走跑", "我知道了");
          }
          this.H = System.currentTimeMillis();
          y();
        }
        else
        {
          this.D = 0.0D;
        }
      }
      if (this.am) {
        this.am = false;
      }
      this.g = 0;
      this.h = paramAMapLocation.getSpeed();
      this.c.add(this.b);
      this.A = this.b;
      if (this.c.size() == 1)
      {
        b();
        this.J = new ArrayList();
        return;
      }
      paramAMapLocation = new LatLng(((DPoint)this.c.get(this.c.size() - 1)).getLatitude(), ((DPoint)this.c.get(this.c.size() - 1)).getLongitude());
      paramAMapLocation = new PolylineOptions().color(getResources().getColor(2131099725)).width(18.0F).add(new LatLng(((DPoint)this.c.get(this.c.size() - 1 - 1)).getLatitude(), ((DPoint)this.c.get(this.c.size() - 1 - 1)).getLongitude())).geodesic(true).add(paramAMapLocation).zIndex(2.14748365E9F);
      this.s.addPolyline(paramAMapLocation);
      this.J.add(paramAMapLocation);
    }
  }
  
  public void onMapClick(LatLng paramLatLng)
  {
    if (this.q)
    {
      this.q = false;
      this.bottomLayout.setVisibility(8);
      this.runLayout.setVisibility(8);
      return;
    }
    this.q = true;
    this.bottomLayout.setVisibility(0);
    this.runLayout.setVisibility(0);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.mMapView.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mMapView.onResume();
    this.R.registerListener(this.S, this.U, 3);
    this.R.registerListener(this.S, this.T, 3);
    if (l)
    {
      this.aw.put(Integer.valueOf(1), "");
      this.R.registerListener(this.i, this.X, 3);
      this.aw.put(Integer.valueOf(4), "");
      this.R.registerListener(this.i, this.Y, 3);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mMapView.onSaveInstanceState(paramBundle);
  }
  
  @OnClick({2131296625})
  public void stopRun(View paramView)
  {
    if (!this.y)
    {
      if (this.K)
      {
        if (this.z) {
          return;
        }
        t();
        return;
      }
      if (this.D > 0.0D) {
        a("提示", "自由跑的运动记录不会上传到服务器，是否需要缓存在本地？", "否", "是");
      }
    }
  }
  
  public class MyReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if ("android.intent.action.SCREEN_ON".equals(paramContext))
      {
        TaskRunActivity.a(false);
        return;
      }
      if ("android.intent.action.SCREEN_OFF".equals(paramContext))
      {
        TaskRunActivity.a(true);
        return;
      }
      if ("android.intent.action.USER_PRESENT".equals(paramContext)) {
        TaskRunActivity.a(false);
      }
    }
  }
  
  public static class MyService
    extends Service
  {
    private String a = "com.totoro.school.keepserviceid";
    private String b = "servicename";
    
    private Notification a()
    {
      Object localObject = new Intent("android.intent.action.MAIN");
      ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
      ((Intent)localObject).setComponent(new ComponentName(this, MainFragmentActivity.class));
      ((Intent)localObject).setFlags(270532608);
      localObject = PendingIntent.getActivity(this, 0, (Intent)localObject, 0);
      localObject = new Notification.Builder(this).setSmallIcon(2131558407).setPriority(-1).setContentIntent((PendingIntent)localObject).setContentTitle(com.totoro.school.utils.b.a(getApplicationContext())).setContentText("正在实时定位你的当前位置");
      if (Build.VERSION.SDK_INT >= 26) {
        ((Notification.Builder)localObject).setChannelId(this.a);
      }
      return ((Notification.Builder)localObject).build();
    }
    
    @Nullable
    public IBinder onBind(Intent paramIntent)
    {
      return null;
    }
    
    public void onCreate()
    {
      super.onCreate();
      if ((!TaskRunActivity.c()) && (!TaskRunActivity.d()))
      {
        TaskRunActivity.a((NotificationManager)getSystemService("notification"));
        if (Build.VERSION.SDK_INT >= 26)
        {
          NotificationChannel localNotificationChannel = new NotificationChannel(this.a, this.b, 2);
          TaskRunActivity.e().createNotificationChannel(localNotificationChannel);
        }
        startForeground(1, a());
        TaskRunActivity.b(true);
      }
    }
    
    public void onDestroy()
    {
      super.onDestroy();
    }
    
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      TaskRunActivity.d();
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
  }
  
  public class a
    implements ServiceConnection
  {
    public a() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      TaskRunActivity.this.e = ((com.totoro.school.service.a)paramIBinder);
      TaskRunActivity.q(TaskRunActivity.this);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
  
  class b
    implements SensorEventListener
  {
    b() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (paramSensorEvent.sensor.getType() == 18)
      {
        if (paramSensorEvent.values[0] == 1.0F) {
          TaskRunActivity.l(TaskRunActivity.this);
        }
      }
      else if (paramSensorEvent.sensor.getType() == 19)
      {
        TaskRunActivity.c(TaskRunActivity.this, (int)paramSensorEvent.values[0]);
        if (TaskRunActivity.m(TaskRunActivity.this))
        {
          TaskRunActivity.d(TaskRunActivity.this, TaskRunActivity.n(TaskRunActivity.this));
          TaskRunActivity.b(TaskRunActivity.this, false);
        }
        TaskRunActivity.e(TaskRunActivity.this, TaskRunActivity.n(TaskRunActivity.this));
        paramSensorEvent = new StringBuilder();
        paramSensorEvent.append("步数获取时间点:");
        paramSensorEvent.append(c.a("yyyy/MM/dd HH:mm:ss"));
        paramSensorEvent.append("\n");
        paramSensorEvent.append("已走步数:");
        paramSensorEvent.append(TaskRunActivity.o(TaskRunActivity.this));
        paramSensorEvent.append("\n");
        paramSensorEvent.append("开机以来总步数:");
        paramSensorEvent.append(TaskRunActivity.n(TaskRunActivity.this));
        paramSensorEvent.append("\n");
        paramSensorEvent.append("--------------------------------------------------------");
        paramSensorEvent.toString();
      }
      String.format("设备检测到您当前走了%d步，自开机以来总数为%d步", new Object[] { Integer.valueOf(TaskRunActivity.o(TaskRunActivity.this)), Integer.valueOf(TaskRunActivity.n(TaskRunActivity.this)) });
    }
  }
  
  class c
    implements Chronometer.OnChronometerTickListener
  {
    c() {}
    
    @SuppressLint({"NewApi"})
    public void onChronometerTick(Chronometer paramChronometer)
    {
      long l = (SystemClock.elapsedRealtime() - paramChronometer.getBase()) / 1000L;
      TaskRunActivity.this.usedTime.setText(o.a(l));
      if (TaskRunActivity.k(TaskRunActivity.this) > 0.0D)
      {
        paramChronometer = TaskRunActivity.this;
        double d1 = TaskRunActivity.k(TaskRunActivity.this);
        float f = (float)l;
        double d2 = f / 3600.0F;
        Double.isNaN(d2);
        TaskRunActivity.a(paramChronometer, d1 / d2);
        d1 = f;
        d2 = TaskRunActivity.k(TaskRunActivity.this);
        Double.isNaN(d1);
        d1 /= d2;
        TaskRunActivity.c(TaskRunActivity.this, o.a(d1));
        if (TaskRunActivity.k(TaskRunActivity.this) == 0.0D)
        {
          TaskRunActivity.this.kmValue.setText("0.00");
          return;
        }
        d1 = new BigDecimal(TaskRunActivity.k(TaskRunActivity.this)).setScale(2, 4).doubleValue();
        TaskRunActivity.this.kmValue.setText(String.valueOf(d1));
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\run\TaskRunActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */