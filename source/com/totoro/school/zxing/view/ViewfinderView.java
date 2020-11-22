package com.totoro.school.zxing.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.zxing.ResultPoint;
import com.totoro.school.utils.MetricsUtil;
import com.totoro.school.zxing.a.c;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public final class ViewfinderView
  extends View
{
  private static float b;
  private int a;
  private Paint c;
  private int d;
  private int e;
  private Bitmap f;
  private final int g;
  private final int h;
  private final int i;
  private Collection<ResultPoint> j;
  private Collection<ResultPoint> k;
  private boolean l;
  private int m = 0;
  
  public ViewfinderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    MetricsUtil.a(paramContext);
    b = paramContext.getResources().getDisplayMetrics().density;
    this.a = ((int)(b * 25.0F));
    this.c = new Paint();
    paramContext = getResources();
    this.g = paramContext.getColor(2131099802);
    this.h = paramContext.getColor(2131099784);
    this.i = paramContext.getColor(2131099775);
    this.j = new HashSet(5);
  }
  
  public void a()
  {
    this.f = null;
    invalidate();
  }
  
  public void a(ResultPoint paramResultPoint)
  {
    this.j.add(paramResultPoint);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    Rect localRect = c.a().a(this.m);
    if (localRect == null) {
      return;
    }
    int n = localRect.top - (int)MetricsUtil.b(250);
    int i1 = localRect.bottom - (int)MetricsUtil.b(250);
    if (!this.l)
    {
      this.l = true;
      this.d = n;
      this.e = i1;
    }
    int i2 = paramCanvas.getWidth();
    int i3 = paramCanvas.getHeight();
    this.c.setColor(Color.parseColor("#646464"));
    this.c.setAlpha(78);
    float f3 = i2;
    float f1 = n;
    paramCanvas.drawRect(0.0F, 0.0F, f3, f1, this.c);
    float f4 = localRect.left;
    float f2 = i1;
    paramCanvas.drawRect(0.0F, f1, f4, f2, this.c);
    paramCanvas.drawRect(localRect.right, f1, f3, f2, this.c);
    paramCanvas.drawRect(0.0F, f2, f3, i3, this.c);
    if (this.f != null)
    {
      this.c.setAlpha(255);
      paramCanvas.drawBitmap(this.f, localRect.left, f1, this.c);
      return;
    }
    this.c.setColor(Color.parseColor("#6eba3c"));
    f3 = localRect.left;
    f4 = localRect.left + this.a;
    float f5 = n + 14;
    paramCanvas.drawRect(f3, f1, f4, f5, this.c);
    paramCanvas.drawRect(localRect.left, f1, localRect.left + 14, this.a + n, this.c);
    paramCanvas.drawRect(localRect.right - this.a, f1, localRect.right, f5, this.c);
    paramCanvas.drawRect(localRect.right - 14, f1, localRect.right, this.a + n, this.c);
    f3 = localRect.left;
    f4 = i1 - 14;
    paramCanvas.drawRect(f3, f4, localRect.left + this.a, f2, this.c);
    paramCanvas.drawRect(localRect.left, i1 - this.a, localRect.left + 14, f2, this.c);
    paramCanvas.drawRect(localRect.right - this.a, f4, localRect.right, f2, this.c);
    paramCanvas.drawRect(localRect.right - 14, i1 - this.a, localRect.right, f2, this.c);
    this.d += 5;
    if (this.d >= i1) {
      this.d = n;
    }
    Object localObject1 = new Rect();
    ((Rect)localObject1).left = (localRect.left + 14);
    ((Rect)localObject1).right = (localRect.right - 14);
    ((Rect)localObject1).top = this.d;
    ((Rect)localObject1).bottom = (this.d + 10);
    paramCanvas.drawBitmap(((BitmapDrawable)getResources().getDrawable(2131558460)).getBitmap(), null, (Rect)localObject1, this.c);
    Object localObject2 = this.j;
    localObject1 = this.k;
    if (((Collection)localObject2).isEmpty())
    {
      this.k = null;
    }
    else
    {
      this.j = new HashSet(5);
      this.k = ((Collection)localObject2);
      this.c.setAlpha(255);
      this.c.setColor(this.i);
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ResultPoint localResultPoint = (ResultPoint)((Iterator)localObject2).next();
        paramCanvas.drawCircle(localRect.left + localResultPoint.getX(), localResultPoint.getY() + f1, 6.0F, this.c);
      }
    }
    if (localObject1 != null)
    {
      this.c.setAlpha(127);
      this.c.setColor(this.i);
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResultPoint)((Iterator)localObject1).next();
        paramCanvas.drawCircle(localRect.left + ((ResultPoint)localObject2).getX(), ((ResultPoint)localObject2).getY() + f1, 3.0F, this.c);
      }
    }
    postInvalidateDelayed(10L, localRect.left, n, localRect.right, i1);
  }
  
  public void setScanType(int paramInt)
  {
    this.m = paramInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\view\ViewfinderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */