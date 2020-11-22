package com.amap.api.maps.model;

import android.graphics.Typeface;
import com.autonavi.amap.mapcore.interfaces.IText;

public final class Text
{
  public static final int ALIGN_BOTTOM = 16;
  public static final int ALIGN_CENTER_HORIZONTAL = 4;
  public static final int ALIGN_CENTER_VERTICAL = 32;
  public static final int ALIGN_LEFT = 1;
  public static final int ALIGN_RIGHT = 2;
  public static final int ALIGN_TOP = 8;
  private IText textDelegate;
  
  public Text(IText paramIText)
  {
    this.textDelegate = paramIText;
  }
  
  public void destroy()
  {
    try
    {
      if (this.textDelegate != null)
      {
        this.textDelegate.destroy(true);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    try
    {
      if (!(paramObject instanceof Text)) {
        return false;
      }
      boolean bool = this.textDelegate.equalsRemote(((Text)paramObject).textDelegate);
      return bool;
    }
    catch (Throwable paramObject)
    {
      ((Throwable)paramObject).printStackTrace();
    }
    return false;
  }
  
  public int getAlignX()
  {
    try
    {
      int i = this.textDelegate.getAlignX();
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public int getAlignY()
  {
    try
    {
      int i = this.textDelegate.getAlignY();
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public int getBackgroundColor()
  {
    try
    {
      int i = this.textDelegate.getBackgroundColor();
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public int getFontColor()
  {
    try
    {
      int i = this.textDelegate.getFontColor();
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public int getFontSize()
  {
    try
    {
      int i = this.textDelegate.getFontSize();
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  public String getId()
  {
    try
    {
      String str = this.textDelegate.getId();
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public Object getObject()
  {
    return this.textDelegate.getObject();
  }
  
  public LatLng getPosition()
  {
    try
    {
      LatLng localLatLng = this.textDelegate.getPosition();
      return localLatLng;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public float getRotate()
  {
    return this.textDelegate.getRotateAngle();
  }
  
  public String getText()
  {
    try
    {
      String str = this.textDelegate.getText();
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public Typeface getTypeface()
  {
    try
    {
      Typeface localTypeface = this.textDelegate.getTypeface();
      return localTypeface;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public float getZIndex()
  {
    return this.textDelegate.getZIndex();
  }
  
  public int hashCode()
  {
    return this.textDelegate.hashCodeRemote();
  }
  
  public boolean isVisible()
  {
    try
    {
      boolean bool = this.textDelegate.isVisible();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public void remove()
  {
    try
    {
      this.textDelegate.remove();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setAlign(int paramInt1, int paramInt2)
  {
    try
    {
      this.textDelegate.setAlign(paramInt1, paramInt2);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    try
    {
      this.textDelegate.setBackgroundColor(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setFontColor(int paramInt)
  {
    try
    {
      this.textDelegate.setFontColor(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setFontSize(int paramInt)
  {
    try
    {
      this.textDelegate.setFontSize(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setObject(Object paramObject)
  {
    this.textDelegate.setObject(paramObject);
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    try
    {
      this.textDelegate.setPosition(paramLatLng);
      return;
    }
    catch (Throwable paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
  }
  
  public void setRotate(float paramFloat)
  {
    try
    {
      this.textDelegate.setRotateAngle(paramFloat);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setText(String paramString)
  {
    try
    {
      this.textDelegate.setText(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    try
    {
      this.textDelegate.setTypeface(paramTypeface);
      return;
    }
    catch (Throwable paramTypeface)
    {
      paramTypeface.printStackTrace();
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    try
    {
      this.textDelegate.setVisible(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setZIndex(float paramFloat)
  {
    this.textDelegate.setZIndex(paramFloat);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\Text.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */