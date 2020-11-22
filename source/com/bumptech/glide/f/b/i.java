package com.bumptech.glide.f.b;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.load.resource.a.b;

public class i
  extends b
{
  private b a;
  private a b;
  private boolean c;
  
  i(a parama, b paramb, Resources paramResources)
  {
    this.b = parama;
    if (paramb == null)
    {
      if (paramResources != null)
      {
        this.a = ((b)a.a(parama).newDrawable(paramResources));
        return;
      }
      this.a = ((b)a.a(parama).newDrawable());
      return;
    }
    this.a = paramb;
  }
  
  public i(b paramb, int paramInt)
  {
    this(new a(paramb.getConstantState(), paramInt), paramb, null);
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public boolean a()
  {
    return this.a.a();
  }
  
  public void clearColorFilter()
  {
    this.a.clearColorFilter();
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.a.draw(paramCanvas);
  }
  
  @TargetApi(19)
  public int getAlpha()
  {
    return this.a.getAlpha();
  }
  
  @TargetApi(11)
  public Drawable.Callback getCallback()
  {
    return this.a.getCallback();
  }
  
  public int getChangingConfigurations()
  {
    return this.a.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.b;
  }
  
  public Drawable getCurrent()
  {
    return this.a.getCurrent();
  }
  
  public int getIntrinsicHeight()
  {
    return a.b(this.b);
  }
  
  public int getIntrinsicWidth()
  {
    return a.b(this.b);
  }
  
  public int getMinimumHeight()
  {
    return this.a.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.a.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return this.a.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect)
  {
    return this.a.getPadding(paramRect);
  }
  
  public void invalidateSelf()
  {
    super.invalidateSelf();
    this.a.invalidateSelf();
  }
  
  public boolean isRunning()
  {
    return this.a.isRunning();
  }
  
  public Drawable mutate()
  {
    if ((!this.c) && (super.mutate() == this))
    {
      this.a = ((b)this.a.mutate());
      this.b = new a(this.b);
      this.c = true;
    }
    return this;
  }
  
  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    super.scheduleSelf(paramRunnable, paramLong);
    this.a.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setBounds(Rect paramRect)
  {
    super.setBounds(paramRect);
    this.a.setBounds(paramRect);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    this.a.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    this.a.setColorFilter(paramInt, paramMode);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.a.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.a.setFilterBitmap(paramBoolean);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.a.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start()
  {
    this.a.start();
  }
  
  public void stop()
  {
    this.a.stop();
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    super.unscheduleSelf(paramRunnable);
    this.a.unscheduleSelf(paramRunnable);
  }
  
  static class a
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState a;
    private final int b;
    
    a(Drawable.ConstantState paramConstantState, int paramInt)
    {
      this.a = paramConstantState;
      this.b = paramInt;
    }
    
    a(a parama)
    {
      this(parama.a, parama.b);
    }
    
    public int getChangingConfigurations()
    {
      return 0;
    }
    
    public Drawable newDrawable()
    {
      return newDrawable(null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new i(this, null, paramResources);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\f\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */