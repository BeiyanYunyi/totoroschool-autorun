package com.autonavi.base.amap.mapcore;

import android.graphics.Rect;
import com.autonavi.amap.mapcore.IPoint;

public class Rectangle
{
  private int beyond180Mode = 0;
  public float bottom;
  public FPoint[] clipMapRect = null;
  public IPoint[] clipRect = null;
  public float left;
  public Rect rect = new Rect();
  public float right;
  public float top;
  
  public Rectangle() {}
  
  public Rectangle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFloat1 < paramFloat2)
    {
      if (paramFloat4 <= paramFloat3) {
        return;
      }
      this.left = paramFloat1;
      this.right = paramFloat2;
      this.top = paramFloat4;
      this.bottom = paramFloat3;
      return;
    }
  }
  
  public Rectangle(Rect paramRect, int paramInt1, int paramInt2)
  {
    this.rect = paramRect;
    if (paramRect != null)
    {
      updateRect(paramRect, paramInt1, paramInt2);
      updateClipRect();
      updateClipMapRect(paramRect.centerX(), paramRect.centerY());
    }
  }
  
  private void updateClipMapRect(int paramInt1, int paramInt2)
  {
    if (this.clipMapRect == null)
    {
      this.clipMapRect = new FPoint[4];
      this.clipMapRect[0] = FPoint.obtain(0.0F, 0.0F);
      this.clipMapRect[1] = FPoint.obtain(0.0F, 0.0F);
      this.clipMapRect[2] = FPoint.obtain(0.0F, 0.0F);
      this.clipMapRect[3] = FPoint.obtain(0.0F, 0.0F);
    }
    if (this.rect != null)
    {
      this.clipMapRect[0].x = (this.rect.left - paramInt1);
      this.clipMapRect[0].y = (this.rect.top - paramInt2);
      this.clipMapRect[1].x = (this.rect.right - paramInt1);
      this.clipMapRect[1].y = (this.rect.top - paramInt2);
      this.clipMapRect[2].x = (this.rect.right - paramInt1);
      this.clipMapRect[2].y = (this.rect.bottom - paramInt2);
      this.clipMapRect[3].x = (this.rect.left - paramInt1);
      this.clipMapRect[3].y = (this.rect.bottom - paramInt2);
    }
  }
  
  private void updateClipRect()
  {
    if (this.clipRect == null)
    {
      this.clipRect = new IPoint[4];
      this.clipRect[0] = IPoint.obtain(0, 0);
      this.clipRect[1] = IPoint.obtain(0, 0);
      this.clipRect[2] = IPoint.obtain(0, 0);
      this.clipRect[3] = IPoint.obtain(0, 0);
    }
    if (this.rect != null)
    {
      this.clipRect[0].x = this.rect.left;
      this.clipRect[0].y = this.rect.top;
      this.clipRect[1].x = this.rect.right;
      this.clipRect[1].y = this.rect.top;
      this.clipRect[2].x = this.rect.right;
      this.clipRect[2].y = this.rect.bottom;
      this.clipRect[3].x = this.rect.left;
      this.clipRect[3].y = this.rect.bottom;
    }
  }
  
  public boolean contains(int paramInt1, int paramInt2)
  {
    if (this.rect != null)
    {
      if (this.rect.contains(paramInt1, paramInt2)) {
        return true;
      }
      if (this.beyond180Mode != 0)
      {
        if (this.rect.contains(paramInt1 - 268435456, paramInt2)) {
          return true;
        }
        if (this.rect.contains(paramInt1 + 268435456, paramInt2)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean contains(Rect paramRect)
  {
    if (paramRect == null) {
      return false;
    }
    return this.rect.contains(paramRect);
  }
  
  public boolean contains(IPoint paramIPoint)
  {
    if (paramIPoint == null) {
      return false;
    }
    return contains(paramIPoint.x, paramIPoint.y);
  }
  
  public int getBeyond180Mode()
  {
    return this.beyond180Mode;
  }
  
  public FPoint[] getClipMapRect()
  {
    return this.clipMapRect;
  }
  
  public IPoint[] getClipRect()
  {
    return this.clipRect;
  }
  
  public Rect getRect()
  {
    return this.rect;
  }
  
  public boolean isOverlap(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.rect == null) {
      return false;
    }
    return (this.rect.left + this.rect.width() > paramInt1) && (paramInt1 + paramInt3 > this.rect.left) && (this.rect.top + this.rect.height() > paramInt2) && (paramInt2 + paramInt4 > this.rect.top);
  }
  
  public boolean isOverlap(Rect paramRect)
  {
    if (this.rect != null)
    {
      if (paramRect == null) {
        return false;
      }
      return (this.rect.left + this.rect.width() > paramRect.left) && (paramRect.left + paramRect.width() > this.rect.left) && (this.rect.top + this.rect.height() > paramRect.top) && (paramRect.top + paramRect.height() > this.rect.top);
    }
    return false;
  }
  
  public void updateRect(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (paramRect != null)
    {
      this.rect = paramRect;
      this.rect.inset(-paramRect.width() / 8, -paramRect.height() / 8);
      if (this.rect.left / 100000.0F * (this.rect.right / 100000.0F) < 0.0F) {
        this.beyond180Mode = -1;
      } else if (this.rect.right > 268435456) {
        this.beyond180Mode = 1;
      } else {
        this.beyond180Mode = 0;
      }
      updateClipRect();
      updateClipMapRect(paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\Rectangle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */