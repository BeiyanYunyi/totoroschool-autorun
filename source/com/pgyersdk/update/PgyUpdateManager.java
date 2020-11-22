package com.pgyersdk.update;

import android.os.AsyncTask;
import com.pgyersdk.PgyerProvider;
import com.pgyersdk.f.c;
import com.pgyersdk.f.l;
import com.pgyersdk.f.m;
import java.io.File;

public class PgyUpdateManager
{
  static PgyUpdateManager a;
  private static UpdateManagerListener b;
  private static DownloadFileListener c;
  static a d;
  private boolean e = false;
  private boolean f = true;
  
  private PgyUpdateManager(UpdateManagerListener paramUpdateManagerListener, DownloadFileListener paramDownloadFileListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    b = paramUpdateManagerListener;
    c = paramDownloadFileListener;
    this.e = paramBoolean1;
    this.f = paramBoolean2;
    a(paramBoolean3);
    a();
  }
  
  private void a()
  {
    a locala = d;
    if (locala != null) {
      locala.cancel(true);
    }
    if (m.b())
    {
      d = new a(b);
      com.pgyersdk.f.a.a(d);
      return;
    }
    b.checkUpdateFailed(new IllegalArgumentException("net work unavailable"));
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (l.e()))
    {
      File localFile = new File(c.a().c(PgyerProvider.a));
      c.a().a(localFile);
    }
  }
  
  public static void downLoadApk(String paramString)
  {
    if (!l.e()) {
      return;
    }
    if (m.b())
    {
      com.pgyersdk.f.a.a(new b(paramString, c));
      return;
    }
    c.downloadFailed();
  }
  
  public static void installApk(File paramFile)
  {
    e.a(paramFile);
  }
  
  @Deprecated
  public static void register()
  {
    if (!l.a()) {
      return;
    }
    new Builder().setForced(false).setUserCanRetry(true).register();
  }
  
  @Deprecated
  public static void register(UpdateManagerListener paramUpdateManagerListener)
  {
    if (!l.a()) {
      return;
    }
    new Builder().setUpdateManagerListener(paramUpdateManagerListener).register();
  }
  
  public static void unRegister()
  {
    if (a != null)
    {
      Object localObject = b;
      if ((localObject != null) && ((localObject instanceof i))) {
        ((i)localObject).b();
      }
      b = null;
      localObject = c;
      if ((localObject != null) && ((localObject instanceof e))) {
        ((e)localObject).a();
      }
      c = null;
      localObject = d;
      if (localObject != null)
      {
        ((AsyncTask)localObject).cancel(true);
        d = null;
      }
    }
  }
  
  public static class Builder
  {
    boolean deleteHistroyApk = true;
    DownloadFileListener downloadFileListener;
    boolean isForced = false;
    UpdateManagerListener updateManagerListener;
    boolean userCanRetry = true;
    
    public PgyUpdateManager register()
    {
      if (!l.a()) {
        return null;
      }
      if (this.updateManagerListener == null) {
        this.updateManagerListener = new i(this.isForced);
      }
      if (this.downloadFileListener == null) {
        this.downloadFileListener = new e(this.userCanRetry);
      }
      PgyUpdateManager.a = new PgyUpdateManager(this.updateManagerListener, this.downloadFileListener, this.isForced, this.userCanRetry, this.deleteHistroyApk, null);
      return PgyUpdateManager.a;
    }
    
    public Builder setDeleteHistroyApk(boolean paramBoolean)
    {
      this.deleteHistroyApk = paramBoolean;
      return this;
    }
    
    public Builder setDownloadFileListener(DownloadFileListener paramDownloadFileListener)
    {
      this.downloadFileListener = paramDownloadFileListener;
      return this;
    }
    
    public Builder setForced(boolean paramBoolean)
    {
      this.isForced = paramBoolean;
      return this;
    }
    
    public Builder setUpdateManagerListener(UpdateManagerListener paramUpdateManagerListener)
    {
      this.updateManagerListener = paramUpdateManagerListener;
      return this;
    }
    
    public Builder setUserCanRetry(boolean paramBoolean)
    {
      this.userCanRetry = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\update\PgyUpdateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */