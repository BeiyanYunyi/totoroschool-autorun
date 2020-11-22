package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class ez
  extends View
{
  public static final int a = Color.argb(255, 235, 235, 235);
  public static final int b = Color.argb(255, 21, 21, 21);
  private Paint c = new Paint();
  
  public ez(Context paramContext)
  {
    super(paramContext);
    this.c.setAntiAlias(true);
    this.c.setColor(a);
  }
  
  public void a(int paramInt)
  {
    if (this.c != null) {
      this.c.setColor(paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setVisibility(0);
      return;
    }
    setVisibility(8);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.c);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */