package com.pgyersdk.feedback.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.ImageButton;

class k
  implements MediaPlayer.OnPreparedListener
{
  k(m paramm) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    m.d(this.a).setEnabled(false);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */