package com.pgyersdk.feedback.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.ImageButton;
import java.util.Timer;
import java.util.TimerTask;

class j
  implements MediaPlayer.OnCompletionListener
{
  j(m paramm) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.a.x.cancel();
    this.a.y.cancel();
    this.a.j.a(3);
    m.d(this.a).setEnabled(true);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */