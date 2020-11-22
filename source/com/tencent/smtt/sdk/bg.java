package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.smtt.export.external.DexLoader;

class bg
  extends FrameLayout
  implements MediaPlayer.OnErrorListener
{
  private Object a;
  private bi b;
  private VideoView c;
  private Context d = null;
  private String e;
  
  public bg(Context paramContext)
  {
    super(paramContext.getApplicationContext());
    this.d = paramContext;
  }
  
  private void b(Bundle paramBundle, Object paramObject)
  {
    a();
    boolean bool;
    if (b())
    {
      paramBundle.putInt("callMode", paramBundle.getInt("callMode"));
      bool = this.b.a(this.a, paramBundle, this, paramObject);
    }
    else
    {
      bool = false;
    }
    if (!bool)
    {
      if (this.c != null) {
        this.c.stopPlayback();
      }
      if (this.c == null) {
        this.c = new VideoView(getContext());
      }
      this.e = paramBundle.getString("videoUrl");
      this.c.setVideoURI(Uri.parse(this.e));
      this.c.setOnErrorListener(this);
      paramBundle = new Intent("com.tencent.smtt.tbs.video.PLAY");
      paramBundle.addFlags(268435456);
      paramObject = getContext().getApplicationContext();
      paramBundle.setPackage(((Context)paramObject).getPackageName());
      ((Context)paramObject).startActivity(paramBundle);
    }
  }
  
  void a()
  {
    setBackgroundColor(-16777216);
    if (this.b == null)
    {
      o.a(true).b(getContext().getApplicationContext(), false, false);
      bh localbh = o.a(true).b();
      DexLoader localDexLoader = null;
      if (localbh != null) {
        localDexLoader = localbh.b();
      }
      if ((localDexLoader != null) && (QbSdk.canLoadVideo(getContext()))) {
        this.b = new bi(localDexLoader);
      }
    }
    if ((this.b != null) && (this.a == null)) {
      this.a = this.b.a(getContext().getApplicationContext());
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (b()) {
      return;
    }
    if (this.c != null)
    {
      if (this.c.getParent() == null)
      {
        Window localWindow = paramActivity.getWindow();
        FrameLayout localFrameLayout = (FrameLayout)localWindow.getDecorView();
        localWindow.addFlags(1024);
        localWindow.addFlags(128);
        localFrameLayout.setBackgroundColor(-16777216);
        paramActivity = new MediaController(paramActivity);
        paramActivity.setMediaPlayer(this.c);
        this.c.setMediaController(paramActivity);
        paramActivity = new FrameLayout.LayoutParams(-1, -1);
        paramActivity.gravity = 17;
        localFrameLayout.addView(this.c, paramActivity);
      }
      if (Build.VERSION.SDK_INT >= 8) {
        this.c.start();
      }
    }
  }
  
  void a(Activity paramActivity, int paramInt)
  {
    if ((paramInt == 3) && (!b()) && (this.c != null)) {
      this.c.pause();
    }
    if (paramInt == 4)
    {
      this.d = null;
      if ((!b()) && (this.c != null))
      {
        this.c.stopPlayback();
        this.c = null;
      }
    }
    if ((paramInt == 2) && (!b()))
    {
      this.d = paramActivity;
      a(paramActivity);
    }
    if (b()) {
      this.b.a(this.a, paramActivity, paramInt);
    }
  }
  
  void a(Bundle paramBundle, Object paramObject)
  {
    b(paramBundle, paramObject);
  }
  
  public boolean b()
  {
    return (this.b != null) && (this.a != null);
  }
  
  public void c()
  {
    if (b()) {
      this.b.a(this.a);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.d instanceof Activity))
      {
        paramMediaPlayer = (Activity)this.d;
        if (!paramMediaPlayer.isFinishing()) {
          paramMediaPlayer.finish();
        }
      }
      paramMediaPlayer = getContext();
      if (paramMediaPlayer != null)
      {
        Toast.makeText(paramMediaPlayer, "播放失败，请选择其它播放器播放", 1).show();
        paramMediaPlayer = paramMediaPlayer.getApplicationContext();
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.addFlags(268435456);
        localIntent.setDataAndType(Uri.parse(this.e), "video/*");
        paramMediaPlayer.startActivity(localIntent);
      }
      return true;
    }
    catch (Throwable paramMediaPlayer)
    {
      for (;;) {}
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */