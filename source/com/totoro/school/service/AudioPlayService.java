package com.totoro.school.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AudioPlayService
  extends Service
  implements MediaPlayer.OnCompletionListener
{
  private MediaPlayer a = null;
  private int b = 0;
  private List<String> c = new ArrayList();
  private List<AssetFileDescriptor> d = new ArrayList();
  private boolean e = true;
  
  public void a(int paramInt)
  {
    try
    {
      if (this.a != null)
      {
        this.a.reset();
        if (this.e)
        {
          AssetFileDescriptor localAssetFileDescriptor = (AssetFileDescriptor)this.d.get(paramInt);
          this.a.setDataSource(localAssetFileDescriptor.getFileDescriptor(), localAssetFileDescriptor.getStartOffset(), localAssetFileDescriptor.getLength());
        }
        else
        {
          this.a.setDataSource((String)this.c.get(paramInt));
        }
        this.a.prepare();
        this.a.start();
        return;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void a(List<String> paramList)
  {
    this.c = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b(List<AssetFileDescriptor> paramList)
  {
    this.d = paramList;
  }
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return new a(null);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.e)
    {
      if ((this.d != null) && (this.d.size() > 0))
      {
        if (this.b < this.d.size() - 1)
        {
          this.b += 1;
          a(this.b);
          return;
        }
        this.b = 0;
      }
    }
    else if ((this.c != null) && (this.c.size() > 0))
    {
      if (this.b < this.c.size() - 1)
      {
        this.b += 1;
        a(this.b);
        return;
      }
      this.b = 0;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.a != null)
    {
      this.a.reset();
      this.a.release();
      this.a = null;
    }
    this.a = new MediaPlayer();
    this.a.setOnCompletionListener(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null)
    {
      this.a.stop();
      this.a.release();
      this.a = null;
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    return super.onUnbind(paramIntent);
  }
  
  public void unbindService(ServiceConnection paramServiceConnection)
  {
    super.unbindService(paramServiceConnection);
  }
  
  private class a
    extends Binder
    implements a
  {
    private a() {}
    
    public void a(List<String> paramList, List<AssetFileDescriptor> paramList1, boolean paramBoolean)
    {
      AudioPlayService.this.a(paramBoolean);
      if (paramBoolean) {
        AudioPlayService.this.b(paramList1);
      } else {
        AudioPlayService.this.a(paramList);
      }
      AudioPlayService.this.a(0);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\service\AudioPlayService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */