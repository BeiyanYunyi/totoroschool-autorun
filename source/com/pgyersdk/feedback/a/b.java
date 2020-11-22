package com.pgyersdk.feedback.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

@SuppressLint({"AppCompatCustomView"})
public class b
  extends ImageView
{
  private Paint a = null;
  private Bitmap b = null;
  private Bitmap c = null;
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  private boolean h = true;
  private boolean i = false;
  private int j = -65536;
  private float k = 4.0F;
  
  public b(Context paramContext)
  {
    super(paramContext);
    setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    if (this.i) {
      paramBitmap = new Canvas(this.b);
    } else {
      paramBitmap = new Canvas(this.c);
    }
    this.a = new Paint();
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setAntiAlias(true);
    this.a.setColor(this.j);
    this.a.setStrokeWidth(this.k);
    if (this.h)
    {
      Path localPath = new Path();
      localPath.moveTo(this.f, this.g);
      localPath.quadTo(this.f, this.g, this.d, this.e);
      paramBitmap.drawPath(localPath, this.a);
      this.f = this.d;
      this.g = this.e;
    }
    if (this.i) {
      return this.b;
    }
    return this.c;
  }
  
  public void a()
  {
    this.i = true;
    Bitmap localBitmap = this.c;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.c = null;
    }
    this.c = Bitmap.createBitmap(this.b);
    invalidate();
  }
  
  public void b()
  {
    Bitmap localBitmap = this.b;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.b = null;
    }
    localBitmap = this.c;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.c = null;
    }
  }
  
  public Bitmap c()
  {
    if (this.i) {
      return this.b;
    }
    return this.c;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Bitmap localBitmap = this.c;
    if (localBitmap == null) {
      return;
    }
    paramCanvas.drawBitmap(a(localBitmap), 0.0F, 0.0F, null);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.f = paramMotionEvent.getX();
      this.g = paramMotionEvent.getY();
      this.h = false;
      this.i = false;
      invalidate();
      return true;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      this.h = true;
      this.d = paramMotionEvent.getX();
      this.e = paramMotionEvent.getY();
      invalidate();
      return true;
    }
    if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    this.h = false;
    return true;
  }
  
  public void setColor(String paramString)
  {
    this.j = Color.parseColor(paramString);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    if (paramBitmap == null) {
      return;
    }
    this.b = Bitmap.createBitmap(paramBitmap).copy(Bitmap.Config.ARGB_8888, true);
    this.c = Bitmap.createBitmap(this.b);
    setDrawingCacheEnabled(true);
  }
  
  public void setstyle(float paramFloat)
  {
    this.k = paramFloat;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */