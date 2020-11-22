package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;

public class em
  extends en
  implements View.OnClickListener
{
  private OfflineMapManager a;
  private View b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private int g;
  private String h;
  
  public em(Context paramContext, OfflineMapManager paramOfflineMapManager)
  {
    super(paramContext);
    this.a = paramOfflineMapManager;
  }
  
  protected void a()
  {
    this.b = es.a(getContext(), 2130903041, null);
    setContentView(this.b);
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        em.this.dismiss();
      }
    });
    this.c = ((TextView)this.b.findViewById(2131165191));
    this.d = ((TextView)this.b.findViewById(2131165192));
    this.d.setText("暂停下载");
    this.e = ((TextView)this.b.findViewById(2131165193));
    this.f = ((TextView)this.b.findViewById(2131165194));
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.c.setText(paramString);
    if (paramInt == 0)
    {
      this.d.setText("暂停下载");
      this.d.setVisibility(0);
      this.e.setText("取消下载");
    }
    if (paramInt == 2)
    {
      this.d.setVisibility(8);
      this.e.setText("取消下载");
    }
    else if ((paramInt != -1) && (paramInt != 101) && (paramInt != 102) && (paramInt != 103))
    {
      if (paramInt == 3)
      {
        this.d.setVisibility(0);
        this.d.setText("继续下载");
        this.e.setText("取消下载");
      }
      else if (paramInt == 4)
      {
        this.e.setText("删除");
        this.d.setVisibility(8);
      }
    }
    else
    {
      this.d.setText("继续下载");
      this.d.setVisibility(0);
    }
    this.g = paramInt;
    this.h = paramString;
  }
  
  public void onClick(View paramView)
  {
    try
    {
      int i = paramView.getId();
      if (i == 2131165192)
      {
        if (this.g == 0)
        {
          this.d.setText("继续下载");
          this.a.pause();
        }
        else if ((this.g == 3) || (this.g == -1) || (this.g == 101) || (this.g == 102) || (this.g == 103))
        {
          this.d.setText("暂停下载");
          this.a.downloadByCityName(this.h);
        }
        dismiss();
        return;
      }
      if (i == 2131165193)
      {
        if (!TextUtils.isEmpty(this.h))
        {
          this.a.remove(this.h);
          dismiss();
        }
      }
      else if (i == 2131165194)
      {
        dismiss();
        return;
      }
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */