package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import android.view.Gravity;
import com.bumptech.glide.load.resource.a.b;

public class j
  extends b
{
  private final Rect a = new Rect();
  private int b;
  private int c;
  private boolean d;
  private boolean e;
  private a f;
  
  public j(Resources paramResources, Bitmap paramBitmap)
  {
    this(paramResources, new a(paramBitmap));
  }
  
  j(Resources paramResources, a parama)
  {
    if (parama != null)
    {
      this.f = parama;
      int i;
      if (paramResources != null)
      {
        int j = paramResources.getDisplayMetrics().densityDpi;
        i = j;
        if (j == 0) {
          i = 160;
        }
        parama.b = i;
      }
      else
      {
        i = parama.b;
      }
      this.b = parama.a.getScaledWidth(i);
      this.c = parama.a.getScaledHeight(i);
      return;
    }
    throw new NullPointerException("BitmapState must not be null");
  }
  
  public void a(int paramInt) {}
  
  public boolean a()
  {
    return false;
  }
  
  public Bitmap b()
  {
    return this.f.a;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.d)
    {
      Gravity.apply(119, this.b, this.c, getBounds(), this.a);
      this.d = false;
    }
    paramCanvas.drawBitmap(this.f.a, null, this.a, this.f.c);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.f;
  }
  
  public int getIntrinsicHeight()
  {
    return this.c;
  }
  
  public int getIntrinsicWidth()
  {
    return this.b;
  }
  
  public int getOpacity()
  {
    Bitmap localBitmap = this.f.a;
    if ((localBitmap != null) && (!localBitmap.hasAlpha()) && (this.f.c.getAlpha() >= 255)) {
      return -1;
    }
    return -3;
  }
  
  public boolean isRunning()
  {
    return false;
  }
  
  public Drawable mutate()
  {
    if ((!this.e) && (super.mutate() == this))
    {
      this.f = new a(this.f);
      this.e = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.d = true;
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.f.c.getAlpha() != paramInt)
    {
      this.f.a(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.f.a(paramColorFilter);
    invalidateSelf();
  }
  
  public void start() {}
  
  public void stop() {}
  
  static class a
    extends Drawable.ConstantState
  {
    private static final Paint d = new Paint(6);
    final Bitmap a;
    int b;
    Paint c = d;
    
    public a(Bitmap paramBitmap)
    {
      this.a = paramBitmap;
    }
    
    a(a parama)
    {
      this(parama.a);
      this.b = parama.b;
    }
    
    void a()
    {
      if (d == this.c) {
        this.c = new Paint(6);
      }
    }
    
    void a(int paramInt)
    {
      a();
      this.c.setAlpha(paramInt);
    }
    
    void a(ColorFilter paramColorFilter)
    {
      a();
      this.c.setColorFilter(paramColorFilter);
    }
    
    public int getChangingConfigurations()
    {
      return 0;
    }
    
    public Drawable newDrawable()
    {
      return new j(null, this);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new j(paramResources, this);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */