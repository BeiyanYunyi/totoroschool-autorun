package com.totoro.school.zxing;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.TextView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.utils.MetricsUtil;
import com.totoro.school.zxing.a.c;
import com.totoro.school.zxing.b.a;
import com.totoro.school.zxing.b.f;
import com.totoro.school.zxing.view.ViewfinderView;
import java.io.IOException;
import java.util.Vector;

public final class CaptureActivity
  extends BaseActivity
  implements SurfaceHolder.Callback
{
  private a a;
  private ViewfinderView b;
  private boolean c;
  private Vector<BarcodeFormat> d;
  private String e;
  private f f;
  private MediaPlayer g;
  private boolean h;
  private boolean i;
  private SurfaceView j;
  private int k;
  private TextView l;
  private String m;
  private String n;
  private final MediaPlayer.OnCompletionListener o = new MediaPlayer.OnCompletionListener()
  {
    public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      paramAnonymousMediaPlayer.seekTo(0);
    }
  };
  
  private void a(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      c.a().a(paramSurfaceHolder);
      if (this.a == null) {
        this.a = new a(this, this.d, this.e);
      }
      return;
    }
    catch (IOException paramSurfaceHolder) {}catch (RuntimeException paramSurfaceHolder) {}
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("title");
    this.k = localIntent.getIntExtra("type", 0);
    if (str != null)
    {
      this.l.setText(str);
      return;
    }
    this.l.setText("二维码签到");
  }
  
  private void f()
  {
    AssetFileDescriptor localAssetFileDescriptor;
    if ((this.h) && (this.g == null))
    {
      setVolumeControlStream(3);
      this.g = new MediaPlayer();
      this.g.setAudioStreamType(3);
      this.g.setOnCompletionListener(this.o);
      localAssetFileDescriptor = getResources().openRawResourceFd(2131623936);
    }
    try
    {
      this.g.setDataSource(localAssetFileDescriptor.getFileDescriptor(), localAssetFileDescriptor.getStartOffset(), localAssetFileDescriptor.getLength());
      localAssetFileDescriptor.close();
      this.g.setVolume(0.1F, 0.1F);
      this.g.prepare();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    this.g = null;
  }
  
  private void h()
  {
    if ((this.h) && (this.g != null)) {
      this.g.start();
    }
    boolean bool = this.i;
  }
  
  public void a(Result paramResult, Bitmap paramBitmap)
  {
    this.f.a();
    h();
    this.n = paramResult.getText();
    this.m = this.n;
    if ("".equals(this.n)) {
      return;
    }
    if (this.k == 99)
    {
      paramResult = new Intent();
      paramResult.putExtra("result", this.n);
      setResult(-1, paramResult);
      finish();
      return;
    }
    if (this.n.contains("http"))
    {
      paramResult = new Intent();
      paramResult.setAction("android.intent.action.VIEW");
      paramResult.setData(Uri.parse(this.n));
      startActivity(paramResult);
      return;
    }
    if (this.n.contains("#")) {
      ((LocationManager)getSystemService("location")).isProviderEnabled("gps");
    }
  }
  
  public ViewfinderView b()
  {
    return this.b;
  }
  
  public Handler c()
  {
    return this.a;
  }
  
  public void d()
  {
    this.b.a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492896);
    MetricsUtil.a(this);
    c.a(getApplication());
    this.j = ((SurfaceView)findViewById(2131296515));
    this.b = ((ViewfinderView)findViewById(2131296723));
    this.b.setScanType(0);
    e();
    this.c = false;
    this.f = new f(this);
  }
  
  protected void onDestroy()
  {
    this.f.b();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.k == 99)
      {
        paramKeyEvent = new Intent();
        paramKeyEvent.putExtra("result", "");
        setResult(0, paramKeyEvent);
        finish();
      }
      else
      {
        finish();
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.a != null)
    {
      this.a.a();
      this.a = null;
    }
    c.a().b();
  }
  
  protected void onResume()
  {
    super.onResume();
    SurfaceHolder localSurfaceHolder = this.j.getHolder();
    if (this.c)
    {
      a(localSurfaceHolder);
    }
    else
    {
      localSurfaceHolder.addCallback(this);
      localSurfaceHolder.setType(3);
    }
    this.d = null;
    this.e = null;
    this.h = true;
    if (((AudioManager)getSystemService("audio")).getRingerMode() != 2) {
      this.h = false;
    }
    f();
    this.i = true;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (!this.c)
    {
      this.c = true;
      a(paramSurfaceHolder);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.c = false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\CaptureActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */