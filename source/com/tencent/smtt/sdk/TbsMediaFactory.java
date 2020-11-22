package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;

public class TbsMediaFactory
{
  private Context a = null;
  private bh b = null;
  private DexLoader c = null;
  
  public TbsMediaFactory(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    a();
  }
  
  private void a()
  {
    if (this.a == null)
    {
      Log.e("TbsVideo", "TbsVideo needs context !!");
      return;
    }
    if (this.b == null)
    {
      o.a(true).b(this.a, false, false);
      this.b = o.a(true).b();
      if (this.b != null) {
        this.c = this.b.b();
      }
    }
    if ((this.b != null) && (this.c != null)) {
      return;
    }
    throw new RuntimeException("tbs core dex(s) load failure !!!");
  }
  
  public TbsMediaPlayer createPlayer()
  {
    if ((this.b != null) && (this.c != null)) {
      return new TbsMediaPlayer(new az(this.c, this.a));
    }
    throw new RuntimeException("tbs core dex(s) did not loaded !!!");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\TbsMediaFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */