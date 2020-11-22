package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

public class TbsVideoCacheTask
{
  public static final String KEY_VIDEO_CACHE_PARAM_FILENAME = "filename";
  public static final String KEY_VIDEO_CACHE_PARAM_FOLDERPATH = "folderPath";
  public static final String KEY_VIDEO_CACHE_PARAM_HEADER = "header";
  public static final String KEY_VIDEO_CACHE_PARAM_URL = "url";
  Context a = null;
  TbsVideoCacheListener b = null;
  private boolean c = false;
  private bc d = null;
  private String e;
  private String f;
  private Object g = null;
  
  public TbsVideoCacheTask(Context paramContext, Bundle paramBundle, TbsVideoCacheListener paramTbsVideoCacheListener)
  {
    this.a = paramContext;
    this.b = paramTbsVideoCacheListener;
    if (paramBundle != null)
    {
      this.e = paramBundle.getString("taskId");
      this.f = paramBundle.getString("url");
    }
    a(paramBundle);
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject;
    if (this.d == null)
    {
      o.a(true).b(this.a, false, false);
      localObject = o.a(true).b();
      if (localObject != null)
      {
        localObject = ((bh)localObject).b();
      }
      else
      {
        this.b.onVideoDownloadError(this, -1, "init engine error!", null);
        localObject = null;
      }
      if (localObject != null) {
        this.d = new bc((DexLoader)localObject);
      } else {
        this.b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
      }
    }
    if (this.d != null)
    {
      this.g = this.d.a(this.a, this, paramBundle);
      if (this.g == null) {
        localObject = this.b;
      }
    }
    else
    {
      for (paramBundle = "init task error!";; paramBundle = "init error!")
      {
        ((TbsVideoCacheListener)localObject).onVideoDownloadError(this, -1, paramBundle, null);
        return;
        if (this.b == null) {
          break;
        }
        localObject = this.b;
      }
    }
  }
  
  public long getContentLength()
  {
    if ((this.d != null) && (this.g != null)) {
      return this.d.d();
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
    }
    return 0L;
  }
  
  public int getDownloadedSize()
  {
    if ((this.d != null) && (this.g != null)) {
      return this.d.e();
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
    }
    return 0;
  }
  
  public int getProgress()
  {
    if ((this.d != null) && (this.g != null)) {
      return this.d.f();
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
    }
    return 0;
  }
  
  public String getTaskID()
  {
    return this.e;
  }
  
  public String getTaskUrl()
  {
    return this.f;
  }
  
  public void pauseTask()
  {
    if ((this.d != null) && (this.g != null))
    {
      this.d.a();
      return;
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
    }
  }
  
  public void removeTask(boolean paramBoolean)
  {
    if ((this.d != null) && (this.g != null))
    {
      this.d.a(paramBoolean);
      return;
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
    }
  }
  
  public void resumeTask()
  {
    if ((this.d != null) && (this.g != null))
    {
      this.d.b();
      return;
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
    }
  }
  
  public void stopTask()
  {
    if ((this.d != null) && (this.g != null))
    {
      this.d.c();
      return;
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\TbsVideoCacheTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */