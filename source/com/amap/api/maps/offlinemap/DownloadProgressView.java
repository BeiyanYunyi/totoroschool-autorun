package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.mapcore.util.a.a;

public class DownloadProgressView
  extends View
{
  private String a;
  private int b = -65536;
  private int c = -65536;
  private float d = 0.0F;
  private float e = 0.6F;
  private TextPaint f;
  private TextPaint g;
  private float h;
  private float i;
  
  public DownloadProgressView(Context paramContext)
  {
    super(paramContext);
    a(null, 0);
  }
  
  public DownloadProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, 0);
  }
  
  public DownloadProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    this.f.setTextSize(this.d);
    this.f.setColor(this.b);
    this.g.setColor(this.c);
    this.h = this.f.measureText(this.a);
    this.i = this.f.getFontMetrics().bottom;
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.a.a, paramInt, 0);
    this.a = paramAttributeSet.getString(0);
    this.b = paramAttributeSet.getColor(3, this.b);
    this.d = paramAttributeSet.getDimension(1, this.d);
    this.c = paramAttributeSet.getColor(2, this.c);
    paramAttributeSet.recycle();
    this.f = new TextPaint();
    this.f.setFlags(1);
    this.f.setTextAlign(Paint.Align.RIGHT);
    this.g = new TextPaint();
    this.g.setStyle(Paint.Style.FILL);
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getPaddingLeft();
    int n = getPaddingTop();
    int k = getPaddingRight();
    int i1 = getPaddingBottom();
    int m = getWidth();
    n = getHeight() - n - i1;
    double d1 = n * 0.8F;
    float f1 = m - j - k;
    double d2 = this.e * f1;
    Double.isNaN(d1);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf((int)(this.e * 100.0F)));
    ((StringBuilder)localObject).append("%");
    localObject = ((StringBuilder)localObject).toString();
    paramCanvas.drawRect(new Rect(0, (int)d1, (int)(f1 * this.e), n), this.g);
    paramCanvas.drawText((String)localObject, (int)d2, (int)(d1 - 3.0D), this.f);
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt <= 100)
    {
      if (paramInt < 0) {
        return;
      }
      this.e = (paramInt / 100.0F);
      invalidate();
      return;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\offlinemap\DownloadProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */