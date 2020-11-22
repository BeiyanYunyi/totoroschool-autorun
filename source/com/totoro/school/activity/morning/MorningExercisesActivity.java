package com.totoro.school.activity.morning;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.amap.api.location.DPoint;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.totoro.school.d.a;
import com.totoro.school.e.e;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.entity.morning.exercise.MorningExerciseRequestModel;
import com.totoro.school.entity.morning.exercise.MorningExerciseReturnModel;
import com.totoro.school.entity.morning.helpSign.HelpSignRequestModel;
import com.totoro.school.entity.morning.helpSign.HelpSignReturnModel;
import com.totoro.school.entity.morning.taskPoint.TaskPointModel;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.utilpub.network.a.b;
import com.totoro.school.utils.MetricsUtil;
import com.totoro.school.utils.d;
import com.totoro.school.utils.i;
import com.totoro.school.utils.j;
import com.totoro.school.utils.n;
import com.totoro.school.view.dialog.OneButtonDialog;
import com.totoro.school.view.dialog.OneButtonDialog.a;
import com.totoro.school.view.dialog.TwoButtonDialog;
import com.totoro.school.view.dialog.TwoButtonDialog.a;
import com.totoro.school.zxing.b.f;
import com.totoro.school.zxing.b.g;
import com.totoro.school.zxing.view.ViewfinderView;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class MorningExercisesActivity
  extends BaseActivity
  implements SurfaceHolder.Callback
{
  LoginReturnModel a;
  private e b;
  private g c;
  private boolean d;
  private Vector<BarcodeFormat> e;
  private String f;
  private f g;
  private MediaPlayer h;
  private boolean i;
  private boolean j;
  private String k;
  private List<TaskPointModel> l;
  private TaskPointModel m;
  private boolean n = false;
  private boolean o = false;
  private final MediaPlayer.OnCompletionListener p = new MediaPlayer.OnCompletionListener()
  {
    public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      paramAnonymousMediaPlayer.seekTo(0);
    }
  };
  @BindView(2131296515)
  SurfaceView surfaceView;
  @BindView(2131296664)
  TextView titleView;
  @BindView(2131296723)
  ViewfinderView viewfinderView;
  
  private void a(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      com.totoro.school.zxing.a.c.a().a(paramSurfaceHolder);
      if (this.c == null) {
        this.c = new g(this, this.e, this.f);
      }
      return;
    }
    catch (IOException paramSurfaceHolder) {}catch (RuntimeException paramSurfaceHolder) {}
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new TwoButtonDialog(getApplicationContext(), 2131755512, paramString1, paramString2, paramString3, paramString4, new TwoButtonDialog.a()
    {
      public void a(String paramAnonymousString)
      {
        if ((!"left_btn".equals(paramAnonymousString)) && ("right_btn".equals(paramAnonymousString))) {
          MorningExercisesActivity.a(MorningExercisesActivity.this, true);
        }
        MorningExercisesActivity.this.d();
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
  
  private void c(String paramString)
  {
    paramString = new OneButtonDialog(this, 2131755512, "", paramString, "", new OneButtonDialog.a()
    {
      public void a(String paramAnonymousString)
      {
        if ("confirm_btn".equals(paramAnonymousString))
        {
          if (MorningExercisesActivity.a(MorningExercisesActivity.this))
          {
            paramAnonymousString = MorningExercisesActivity.this.getApplicationContext();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(com.totoro.school.utils.c.a("yyyy-MM-dd"));
            localStringBuilder.append("_signed");
            n.a(paramAnonymousString, localStringBuilder.toString(), Boolean.valueOf(true));
            MorningExercisesActivity.this.finish();
            return;
          }
          MorningExercisesActivity.this.d();
        }
      }
    });
    Window localWindow = paramString.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localWindow.setGravity(17);
    localWindow.setAttributes(localLayoutParams);
    paramString.setCanceledOnTouchOutside(false);
    paramString.setCancelable(true);
    paramString.show();
  }
  
  private void e()
  {
    this.k = getIntent().getStringExtra("qrCodes");
    this.l = ((List)getIntent().getSerializableExtra("taskPointList"));
  }
  
  private void f()
  {
    AssetFileDescriptor localAssetFileDescriptor;
    if ((this.i) && (this.h == null))
    {
      setVolumeControlStream(3);
      this.h = new MediaPlayer();
      this.h.setAudioStreamType(3);
      this.h.setOnCompletionListener(this.p);
      localAssetFileDescriptor = getResources().openRawResourceFd(2131623936);
    }
    try
    {
      this.h.setDataSource(localAssetFileDescriptor.getFileDescriptor(), localAssetFileDescriptor.getStartOffset(), localAssetFileDescriptor.getLength());
      localAssetFileDescriptor.close();
      this.h.setVolume(0.1F, 0.1F);
      this.h.prepare();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    this.h = null;
  }
  
  private boolean h()
  {
    DPoint localDPoint1 = a.a().c();
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      TaskPointModel localTaskPointModel = (TaskPointModel)localIterator.next();
      double d1 = Double.parseDouble(localTaskPointModel.getP_mile());
      DPoint localDPoint2 = new DPoint();
      localDPoint2.setLatitude(Double.parseDouble(localTaskPointModel.getY()));
      localDPoint2.setLongitude(Double.parseDouble(localTaskPointModel.getX()));
      if (a.a().a(localDPoint1, localDPoint2) <= d1)
      {
        this.m = localTaskPointModel;
        return true;
      }
    }
    return false;
  }
  
  private void i()
  {
    if ((this.i) && (this.h != null)) {
      this.h.start();
    }
    if (this.j) {
      ((Vibrator)getSystemService("vibrator")).vibrate(200L);
    }
  }
  
  private void j()
  {
    this.titleView.setText(getResources().getString(2131689608));
  }
  
  public ViewfinderView a()
  {
    return this.viewfinderView;
  }
  
  public void a(Result paramResult, Bitmap paramBitmap)
  {
    this.g.a();
    i();
    paramResult = paramResult.getText();
    paramBitmap = a.a().c();
    Object localObject;
    if (this.o)
    {
      localObject = new HelpSignRequestModel();
      ((HelpSignRequestModel)localObject).setSnCode(this.a.getSnCode());
      ((HelpSignRequestModel)localObject).setPhoneNumber(this.a.getPhoneNumber());
      ((HelpSignRequestModel)localObject).setSchoolName(this.a.getSchoolID());
      ((HelpSignRequestModel)localObject).setCampusName(this.a.getCampusName());
      ((HelpSignRequestModel)localObject).setPhoneNumber(this.a.getPhoneNumber());
      ((HelpSignRequestModel)localObject).setX(String.valueOf(paramBitmap.getLongitude()));
      ((HelpSignRequestModel)localObject).setY(String.valueOf(paramBitmap.getLatitude()));
      ((HelpSignRequestModel)localObject).setQrCode(paramResult);
      this.b.a((HelpSignRequestModel)localObject);
      return;
    }
    if (a(paramResult))
    {
      if (h())
      {
        localObject = new MorningExerciseRequestModel();
        ((MorningExerciseRequestModel)localObject).setSnCode(this.a.getSnCode());
        ((MorningExerciseRequestModel)localObject).setPhoneNumber(this.a.getPhoneNumber());
        ((MorningExerciseRequestModel)localObject).setSchoolName(this.a.getSchoolID());
        ((MorningExerciseRequestModel)localObject).setQrCode(paramResult);
        ((MorningExerciseRequestModel)localObject).setBaseStation(d.a(this));
        ((MorningExerciseRequestModel)localObject).setMac(j.a(getApplicationContext()));
        ((MorningExerciseRequestModel)localObject).setLongitude(String.valueOf(paramBitmap.getLongitude()));
        ((MorningExerciseRequestModel)localObject).setLatitude(String.valueOf(paramBitmap.getLatitude()));
        ((MorningExerciseRequestModel)localObject).setFlag("1");
        ((MorningExerciseRequestModel)localObject).setTaskid(this.m.getTaskid());
        ((MorningExerciseRequestModel)localObject).setPadid(this.m.getPadid());
        ((MorningExerciseRequestModel)localObject).setCurrentTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        this.b.a((MorningExerciseRequestModel)localObject, getBaseContext());
        return;
      }
      a(getString(2131689571), getString(2131689622), getString(2131689539), getString(2131689540));
      return;
    }
    c(getString(2131689582));
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    int i1 = paramString.hashCode();
    int i2 = -1;
    if (i1 != -34375693)
    {
      if ((i1 == 1297360891) && (paramString.equals("help_sign")))
      {
        i1 = 1;
        break label63;
      }
    }
    else if (paramString.equals("morning_exercise"))
    {
      i1 = 0;
      break label63;
    }
    i1 = -1;
    switch (i1)
    {
    default: 
      
    case 1: 
      paramString = (HelpSignReturnModel)b.a(paramObject, HelpSignReturnModel.class);
      if (paramString != null)
      {
        paramString = paramString.getCode();
        if ((paramString.hashCode() == 1715960) && (paramString.equals("8000"))) {
          i2 = 0;
        }
        if (i2 != 0) {
          return;
        }
        this.n = true;
        c(getString(2131689609));
        return;
      }
      break;
    case 0: 
      label63:
      paramString = (MorningExerciseReturnModel)b.a(paramObject, MorningExerciseReturnModel.class);
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
          return;
        case 1: 
          this.n = false;
          c(getString(2131689522));
          return;
        }
        this.n = true;
        c(getString(2131689609));
      }
      break;
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.k.isEmpty()) {
      return false;
    }
    String[] arrayOfString = this.k.split("/");
    int i1 = 0;
    while (i1 < arrayOfString.length)
    {
      if (paramString.equals(arrayOfString[i1])) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public Handler b()
  {
    return this.c;
  }
  
  @OnClick({2131296298})
  public void back(View paramView)
  {
    finish();
  }
  
  public void c()
  {
    this.viewfinderView.a();
  }
  
  public void d()
  {
    if (this.c != null) {
      this.c.b();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492908);
    ButterKnife.bind(this);
    this.b = new e(this);
    this.a = i.a();
    e();
    MetricsUtil.a(this);
    com.totoro.school.zxing.a.c.a(getApplication());
    j();
    this.d = false;
    this.g = new f(this);
  }
  
  protected void onDestroy()
  {
    this.g.b();
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.c != null)
    {
      this.c.a();
      this.c = null;
    }
    com.totoro.school.zxing.a.c.a().b();
  }
  
  protected void onResume()
  {
    super.onResume();
    SurfaceHolder localSurfaceHolder = this.surfaceView.getHolder();
    if (this.d)
    {
      a(localSurfaceHolder);
    }
    else
    {
      localSurfaceHolder.addCallback(this);
      localSurfaceHolder.setType(3);
    }
    this.e = null;
    this.f = null;
    this.i = true;
    if (((AudioManager)getSystemService("audio")).getRingerMode() != 2) {
      this.i = false;
    }
    f();
    this.j = true;
    a.a().b();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (!this.d)
    {
      this.d = true;
      a(paramSurfaceHolder);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.d = false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\morning\MorningExercisesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */