package com.totoro.school.view.dialog;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.content.FileProvider;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.totoro.school.utils.f;
import com.totoro.school.utils.k;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class DownLoadNewAppSer
  extends Service
{
  private boolean a;
  private Context b = this;
  private NotificationManager c;
  private Notification d;
  private a e = new a();
  private Handler f = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      int i = paramAnonymousMessage.what;
      if (i != 10000) {}
      switch (i)
      {
      default: 
        
      case 2: 
        DownLoadNewAppSer.b(DownLoadNewAppSer.this);
        DownloadProgressDialog.a().c();
        DownLoadNewAppSer.this.stopSelf();
        Toast.makeText(DownLoadNewAppSer.c(DownLoadNewAppSer.this), "下载完成!", 0).show();
        paramAnonymousMessage = new Intent("android.intent.action.VIEW");
        paramAnonymousMessage.setFlags(268435456);
        paramAnonymousMessage.addFlags(1);
        Object localObject = f.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(DownLoadNewAppSer.this.getString(2131689524));
        localStringBuilder.append(".apk");
        localObject = new File((String)localObject, localStringBuilder.toString());
        if (Build.VERSION.SDK_INT >= 24) {
          paramAnonymousMessage.setDataAndType(FileProvider.getUriForFile(DownLoadNewAppSer.c(DownLoadNewAppSer.this), "com.totoro.school.fileProvider", (File)localObject), "application/vnd.android.package-archive");
        } else {
          paramAnonymousMessage.setDataAndType(Uri.fromFile((File)localObject), "application/vnd.android.package-archive");
        }
        DownLoadNewAppSer.this.startActivity(paramAnonymousMessage);
        return;
      case 1: 
        DownLoadNewAppSer.a(DownLoadNewAppSer.this, paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
        DownloadProgressDialog.a().a(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
        return;
      case 0: 
        DownLoadNewAppSer.a(DownLoadNewAppSer.this);
        return;
        if (DownLoadNewAppSer.d(DownLoadNewAppSer.this) != null) {
          DownLoadNewAppSer.d(DownLoadNewAppSer.this).interrupt();
        }
        DownLoadNewAppSer.this.stopSelf();
      }
    }
  };
  private String g;
  
  private void a()
  {
    this.c = ((NotificationManager)getSystemService("notification"));
    this.d = new Notification(2131558431, "正在下载", System.currentTimeMillis());
    this.d.flags = 2;
    Object localObject = new RemoteViews(this.b.getPackageName(), 2131492999);
    this.d.contentView = ((RemoteViews)localObject);
    localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    localObject = PendingIntent.getActivity(this, 2131689524, (Intent)localObject, 134217728);
    this.d.contentIntent = ((PendingIntent)localObject);
    this.c.notify(2131689524, this.d);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    RemoteViews localRemoteViews = this.d.contentView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("KB");
    localRemoteViews.setTextViewText(2131296366, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("KB");
    localRemoteViews.setTextViewText(2131296365, localStringBuilder.toString());
    localRemoteViews.setProgressBar(2131296363, 100, paramInt1 * 100 / paramInt2, false);
    this.c.notify(2131689524, this.d);
  }
  
  private void b()
  {
    this.d.flags = 16;
    this.d.contentView = null;
    Object localObject1 = new Intent("android.intent.action.VIEW");
    ((Intent)localObject1).setFlags(268435456);
    ((Intent)localObject1).addFlags(1);
    Object localObject2 = f.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131689524));
    localStringBuilder.append(".apk");
    localObject2 = new File((String)localObject2, localStringBuilder.toString());
    if (Build.VERSION.SDK_INT >= 24) {
      ((Intent)localObject1).setDataAndType(FileProvider.getUriForFile(this.b, "com.totoro.school.fileProvider", (File)localObject2), "application/vnd.android.package-archive");
    } else {
      ((Intent)localObject1).setDataAndType(Uri.fromFile((File)localObject2), "application/vnd.android.package-archive");
    }
    localObject1 = PendingIntent.getActivity(this, 2131689524, (Intent)localObject1, 134217728);
    localObject2 = new Notification.Builder(this);
    ((Notification.Builder)localObject2).setContentTitle("下载完成");
    ((Notification.Builder)localObject2).setContentText("文件已下载完毕");
    ((Notification.Builder)localObject2).setSmallIcon(2131558431);
    ((Notification.Builder)localObject2).setContentIntent((PendingIntent)localObject1);
    this.d = ((Notification.Builder)localObject2).getNotification();
    this.c.notify(2131689524, this.d);
  }
  
  private void c()
  {
    Message localMessage = this.f.obtainMessage();
    localMessage.what = 0;
    localMessage.arg1 = 0;
    this.f.sendMessage(localMessage);
    Object localObject1 = new DefaultHttpClient();
    Object localObject3 = ((HttpClient)localObject1).getParams();
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject3, 60000);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject3, 60000);
    ConnManagerParams.setTimeout((HttpParams)localObject3, 60000L);
    localObject3 = new HttpGet(this.g);
    for (;;)
    {
      try
      {
        localObject1 = ((HttpClient)localObject1).execute((HttpUriRequest)localObject3).getEntity();
        long l4 = ((HttpEntity)localObject1).getContentLength();
        InputStream localInputStream = ((HttpEntity)localObject1).getContent();
        localObject1 = null;
        if (localInputStream != null)
        {
          localObject1 = f.a;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(getString(2131689524));
          ((StringBuilder)localObject3).append(".apk");
          localObject3 = new FileOutputStream(new File((String)localObject1, ((StringBuilder)localObject3).toString()));
          byte[] arrayOfByte = new byte['ࠀ'];
          long l1 = System.currentTimeMillis();
          int i = 0;
          localObject1 = localMessage;
          int j = localInputStream.read(arrayOfByte);
          if (j != -1)
          {
            if (!k.a(this.b))
            {
              ((Message)localObject1).what = 10000;
              this.f.sendMessage((Message)localObject1);
              return;
            }
            long l3 = System.currentTimeMillis();
            ((FileOutputStream)localObject3).write(arrayOfByte, 0, j);
            j = i + j;
            i = j;
            if (this.a == true) {
              continue;
            }
            long l2 = l1;
            if (l3 - l1 > 1000L)
            {
              localObject1 = this.f.obtainMessage();
              ((Message)localObject1).what = 1;
              ((Message)localObject1).arg1 = (j / 1024);
              ((Message)localObject1).arg2 = ((int)(l4 / 1024L));
              this.f.sendMessage((Message)localObject1);
              l2 = l3;
            }
            this.a = false;
            i = j;
            l1 = l2;
            continue;
          }
        }
        else
        {
          ((FileOutputStream)localObject1).flush();
          if (localObject1 != null) {
            ((FileOutputStream)localObject1).close();
          }
          if (this.a != true)
          {
            localObject1 = this.f.obtainMessage();
            ((Message)localObject1).what = 2;
            this.f.sendMessage((Message)localObject1);
            this.a = false;
          }
          try
          {
            Thread.sleep(10L);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
            return;
          }
        }
        Object localObject2 = localObject3;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        localClientProtocolException.printStackTrace();
        return;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.g = paramIntent.getStringExtra("url");
    this.e.start();
    return 2;
  }
  
  public class a
    extends Thread
  {
    public a() {}
    
    public void run()
    {
      super.run();
      DownLoadNewAppSer.e(DownLoadNewAppSer.this);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\dialog\DownLoadNewAppSer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */