package com.autonavi.amap.mapcore.interfaces;

import android.graphics.Typeface;
import android.os.RemoteException;

public abstract interface IText
  extends IOverlayImage
{
  public abstract int getAlignX()
    throws RemoteException;
  
  public abstract int getAlignY()
    throws RemoteException;
  
  public abstract int getBackgroundColor()
    throws RemoteException;
  
  public abstract int getFontColor()
    throws RemoteException;
  
  public abstract int getFontSize()
    throws RemoteException;
  
  public abstract String getText()
    throws RemoteException;
  
  public abstract Typeface getTypeface()
    throws RemoteException;
  
  public abstract void setAlign(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void setBackgroundColor(int paramInt)
    throws RemoteException;
  
  public abstract void setFontColor(int paramInt)
    throws RemoteException;
  
  public abstract void setFontSize(int paramInt)
    throws RemoteException;
  
  public abstract void setText(String paramString)
    throws RemoteException;
  
  public abstract void setTypeface(Typeface paramTypeface)
    throws RemoteException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\amap\mapcore\interfaces\IText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */