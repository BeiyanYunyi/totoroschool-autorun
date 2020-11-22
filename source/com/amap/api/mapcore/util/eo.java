package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.maps.offlinemap.DownloadProgressView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;

public class eo
  implements View.OnClickListener
{
  private int a = 0;
  private Context b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private TextView f;
  private OfflineMapManager g;
  private OfflineMapCity h;
  private boolean i = false;
  private Handler j = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      int i = paramAnonymousMessage.arg1;
      int j = paramAnonymousMessage.arg2;
      try
      {
        eo.a(eo.this, i, j);
        return;
      }
      catch (Exception paramAnonymousMessage)
      {
        paramAnonymousMessage.printStackTrace();
      }
    }
  };
  private View k;
  private DownloadProgressView l;
  
  public eo(Context paramContext, OfflineMapManager paramOfflineMapManager)
  {
    this.b = paramContext;
    b();
    this.g = paramOfflineMapManager;
  }
  
  private void a(int paramInt1, int paramInt2)
    throws Exception
  {
    if ((this.a == 2) && (paramInt2 > 3) && (paramInt2 < 100))
    {
      this.l.setVisibility(0);
      this.l.setProgress(paramInt2);
    }
    else
    {
      this.l.setVisibility(8);
    }
    switch (paramInt1)
    {
    default: 
      switch (paramInt1)
      {
      default: 
        return;
      }
      e();
      return;
    case 7: 
      d();
      return;
    case 6: 
      c();
      return;
    case 4: 
      f();
      return;
    case 3: 
      c(paramInt2);
      return;
    case 2: 
      b(paramInt2);
      return;
    case 1: 
      d(paramInt2);
      return;
    case 0: 
      if (this.a == 1)
      {
        this.e.setVisibility(8);
        this.f.setText("下载中");
        this.f.setTextColor(Color.parseColor("#4287ff"));
        return;
      }
      e(paramInt2);
      return;
    case -1: 
      e();
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.h != null)
    {
      this.h.setState(paramInt1);
      this.h.setCompleteCode(paramInt2);
    }
    Message localMessage = new Message();
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    this.j.sendMessage(localMessage);
  }
  
  private void b()
  {
    this.k = es.a(this.b, 2130903042, null);
    this.l = ((DownloadProgressView)this.k.findViewById(2131165200));
    this.c = ((TextView)this.k.findViewById(2131165195));
    this.d = ((TextView)this.k.findViewById(2131165199));
    this.e = ((ImageView)this.k.findViewById(2131165198));
    this.f = ((TextView)this.k.findViewById(2131165197));
    this.e.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    if (this.a == 1)
    {
      this.e.setVisibility(8);
      this.f.setVisibility(0);
      this.f.setText("等待中");
      this.f.setTextColor(Color.parseColor("#4287ff"));
      return;
    }
    this.f.setVisibility(0);
    this.e.setVisibility(8);
    this.f.setTextColor(Color.parseColor("#4287ff"));
    this.f.setText("等待中");
  }
  
  private void c()
  {
    this.f.setVisibility(8);
    this.e.setVisibility(0);
    this.e.setImageResource(2130837506);
  }
  
  private void c(int paramInt)
  {
    this.f.setVisibility(0);
    this.e.setVisibility(8);
    this.f.setTextColor(-7829368);
    this.f.setText("暂停");
  }
  
  private void d()
  {
    this.f.setVisibility(0);
    this.e.setVisibility(0);
    this.e.setImageResource(2130837506);
    this.f.setText("已下载-有更新");
  }
  
  private void d(int paramInt)
  {
    if (this.a == 1) {
      return;
    }
    this.f.setVisibility(0);
    this.e.setVisibility(8);
    this.f.setText("解压中");
    this.f.setTextColor(Color.parseColor("#898989"));
  }
  
  private void e()
  {
    this.f.setVisibility(0);
    this.e.setVisibility(8);
    this.f.setTextColor(-65536);
    this.f.setText("下载出现异常");
  }
  
  private void e(int paramInt)
  {
    if (this.h == null) {
      return;
    }
    this.f.setVisibility(0);
    this.f.setText("下载中");
    this.e.setVisibility(8);
    this.f.setTextColor(Color.parseColor("#4287ff"));
  }
  
  private void f()
  {
    this.f.setVisibility(0);
    this.e.setVisibility(8);
    this.f.setText("已下载");
    this.f.setTextColor(Color.parseColor("#898989"));
  }
  
  private void g()
  {
    try
    {
      this.g.pause();
      this.g.restart();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private boolean h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/amap/api/mapcore/util/eo:g	Lcom/amap/api/maps/offlinemap/OfflineMapManager;
    //   6: aload_0
    //   7: getfield 111	com/amap/api/mapcore/util/eo:h	Lcom/amap/api/maps/offlinemap/OfflineMapCity;
    //   10: invokevirtual 200	com/amap/api/maps/offlinemap/OfflineMapCity:getCity	()Ljava/lang/String;
    //   13: invokevirtual 204	com/amap/api/maps/offlinemap/OfflineMapManager:downloadByCityName	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: iconst_1
    //   19: ireturn
    //   20: astore_1
    //   21: goto +27 -> 48
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 207	com/amap/api/maps/AMapException:printStackTrace	()V
    //   29: aload_0
    //   30: getfield 46	com/amap/api/mapcore/util/eo:b	Landroid/content/Context;
    //   33: aload_1
    //   34: invokevirtual 210	com/amap/api/maps/AMapException:getErrorMessage	()Ljava/lang/String;
    //   37: iconst_0
    //   38: invokestatic 216	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   41: invokevirtual 219	android/widget/Toast:show	()V
    //   44: aload_0
    //   45: monitorexit
    //   46: iconst_0
    //   47: ireturn
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	eo
    //   20	1	1	localObject	Object
    //   24	27	1	localAMapException	com.amap.api.maps.AMapException
    // Exception table:
    //   from	to	target	type
    //   2	16	20	finally
    //   25	44	20	finally
    //   2	16	24	com/amap/api/maps/AMapException
  }
  
  public View a()
  {
    return this.k;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(OfflineMapCity paramOfflineMapCity)
  {
    if (paramOfflineMapCity != null)
    {
      this.h = paramOfflineMapCity;
      this.c.setText(paramOfflineMapCity.getCity());
      double d1 = paramOfflineMapCity.getSize();
      Double.isNaN(d1);
      d1 = (int)(d1 / 1024.0D / 1024.0D * 100.0D);
      Double.isNaN(d1);
      d1 /= 100.0D;
      paramOfflineMapCity = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(d1));
      localStringBuilder.append(" M");
      paramOfflineMapCity.setText(localStringBuilder.toString());
      a(this.h.getState(), this.h.getcompleteCode(), this.i);
    }
  }
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        if (!dx.d(this.b))
        {
          Toast.makeText(this.b, "无网络连接", 0).show();
          return;
        }
        if (this.h == null) {
          break label109;
        }
        int m = this.h.getState();
        n = this.h.getcompleteCode();
        if (m == 4) {
          break label109;
        }
        switch (m)
        {
        case 0: 
          if (h())
          {
            b(n);
            return;
          }
          e();
          return;
        }
      }
      catch (Exception paramView)
      {
        int n;
        paramView.printStackTrace();
      }
      g();
      c(n);
      return;
      label109:
      return;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */