package com.autonavi.base.ae.gmap.style;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StyleItem
{
  public int mainKey;
  private Map<Integer, StyleElement> styleElements = new HashMap();
  private int styleTypeId;
  public int[] subKey;
  
  public StyleItem(int paramInt)
  {
    this.styleTypeId = paramInt;
  }
  
  public StyleElement get(int paramInt)
  {
    return (StyleElement)this.styleElements.get(Integer.valueOf(paramInt));
  }
  
  public StyleElement[] getStyleElements()
  {
    if ((this.styleElements != null) && (this.styleElements.size() > 0))
    {
      StyleElement[] arrayOfStyleElement = new StyleElement[this.styleElements.size()];
      return (StyleElement[])this.styleElements.values().toArray(arrayOfStyleElement);
    }
    return null;
  }
  
  public boolean isValid()
  {
    return (this.styleElements.size() > 0) && (this.styleTypeId >= 0);
  }
  
  public void put(int paramInt, StyleElement paramStyleElement)
  {
    this.styleElements.put(Integer.valueOf(paramInt), paramStyleElement);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("styleTypeId:");
    localStringBuilder.append(this.styleTypeId);
    localStringBuilder.append("\n");
    localStringBuilder.append("styleElements.size :");
    localStringBuilder.append(this.styleElements.size());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\ae\gmap\style\StyleItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */