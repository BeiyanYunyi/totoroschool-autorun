package com.pgyersdk.feedback;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import com.pgyersdk.PgyerProvider;

class m
  implements n.a
{
  @SuppressLint({"StaticFieldLeak"})
  private static n a;
  private static k.a b;
  private int c;
  private MediaPlayer d = null;
  
  m(int paramInt)
  {
    this.c = paramInt;
    c();
  }
  
  private void c()
  {
    b = new l(this);
  }
  
  private void d()
  {
    MediaPlayer localMediaPlayer = this.d;
    if (localMediaPlayer != null) {
      localMediaPlayer.release();
    }
  }
  
  private void e()
  {
    this.d = MediaPlayer.create(PgyerProvider.a, Uri.parse("file:///system/media/audio/ui/camera_click.ogg"));
    synchronized (this.d)
    {
      this.d.setVolume(10.0F, 10.0F);
      this.d.start();
      return;
    }
  }
  
  private void f()
  {
    n localn = a;
    if (localn != null) {
      localn.b();
    }
  }
  
  public void a()
  {
    PgyerFeedbackManager.getInstance().b().a(b);
    PgyerFeedbackManager.getInstance().b().e();
  }
  
  public void b()
  {
    if (a != null) {
      f();
    }
    a = new n(PgyerProvider.a);
    n.a = this.c;
    a.a(this);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */