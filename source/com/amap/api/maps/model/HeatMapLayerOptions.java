package com.amap.api.maps.model;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HeatMapLayerOptions
{
  public static final Gradient DEFAULT_GRADIENT = new Gradient(DEFAULT_GRADIENT_COLORS, DEFAULT_GRADIENT_START_POINTS);
  private static final int[] DEFAULT_GRADIENT_COLORS = { Color.rgb(102, 225, 0), Color.rgb(255, 0, 0) };
  private static final float[] DEFAULT_GRADIENT_START_POINTS = { 0.2F, 1.0F };
  public static final double DEFAULT_OPACITY = 0.6D;
  public static final int DEFAULT_RADIUS = 12;
  public static final int TYPE_GRID = 1;
  public static final int TYPE_HEXAGON = 2;
  public static final int TYPE_NORMAL = 0;
  private boolean isVisible = true;
  private Collection<WeightedLatLng> mData;
  private float mGap = 0.0F;
  private Gradient mGradient = DEFAULT_GRADIENT;
  private float mOpacity = 1.0F;
  private float mSize = 2000.0F;
  private int mType = 2;
  private double maxIntensity = 0.0D;
  private float maxZoom = 20.0F;
  private float minZoom = 3.0F;
  private float zIndex = 0.0F;
  
  private static Collection<WeightedLatLng> a(Collection<LatLng> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(new WeightedLatLng((LatLng)paramCollection.next()));
    }
    return localArrayList;
  }
  
  public HeatMapLayerOptions data(Collection<LatLng> paramCollection)
  {
    return weightedData(a(paramCollection));
  }
  
  public HeatMapLayerOptions gap(float paramFloat)
  {
    this.mGap = paramFloat;
    return this;
  }
  
  public Collection<WeightedLatLng> getData()
  {
    return this.mData;
  }
  
  public float getGap()
  {
    return this.mGap;
  }
  
  public Gradient getGradient()
  {
    return this.mGradient;
  }
  
  public double getMaxIntensity()
  {
    return this.maxIntensity;
  }
  
  public float getMaxZoom()
  {
    return this.maxZoom;
  }
  
  public float getMinZoom()
  {
    return this.minZoom;
  }
  
  public float getOpacity()
  {
    return this.mOpacity;
  }
  
  public float getSize()
  {
    return this.mSize;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public float getZIndex()
  {
    return this.zIndex;
  }
  
  public HeatMapLayerOptions gradient(Gradient paramGradient)
  {
    this.mGradient = paramGradient;
    return this;
  }
  
  public boolean isVisible()
  {
    return this.isVisible;
  }
  
  public HeatMapLayerOptions maxIntensity(double paramDouble)
  {
    this.maxIntensity = paramDouble;
    return this;
  }
  
  public HeatMapLayerOptions maxZoom(float paramFloat)
  {
    this.maxZoom = paramFloat;
    return this;
  }
  
  public HeatMapLayerOptions minZoom(float paramFloat)
  {
    this.minZoom = paramFloat;
    return this;
  }
  
  public HeatMapLayerOptions opacity(float paramFloat)
  {
    this.mOpacity = Math.max(0.0F, Math.min(paramFloat, 1.0F));
    return this;
  }
  
  public HeatMapLayerOptions size(float paramFloat)
  {
    this.mSize = paramFloat;
    return this;
  }
  
  public HeatMapLayerOptions type(int paramInt)
  {
    this.mType = paramInt;
    return this;
  }
  
  public HeatMapLayerOptions visible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    return this;
  }
  
  public HeatMapLayerOptions weightedData(Collection<WeightedLatLng> paramCollection)
  {
    this.mData = paramCollection;
    return this;
  }
  
  public HeatMapLayerOptions zIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\HeatMapLayerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */