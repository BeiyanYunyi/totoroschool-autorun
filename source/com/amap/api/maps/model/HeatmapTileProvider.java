package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.support.v4.util.LongSparseArray;
import android.util.Log;
import com.amap.api.mapcore.util.db;
import com.amap.api.maps.AMapException;
import com.autonavi.amap.mapcore.DPoint;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HeatmapTileProvider
  implements TileProvider
{
  public static final Gradient DEFAULT_GRADIENT = new Gradient(DEFAULT_GRADIENT_COLORS, DEFAULT_GRADIENT_START_POINTS);
  private static final int[] DEFAULT_GRADIENT_COLORS = { Color.rgb(102, 225, 0), Color.rgb(255, 0, 0) };
  private static final float[] DEFAULT_GRADIENT_START_POINTS = { 0.2F, 1.0F };
  private static final int DEFAULT_MAX_ZOOM = 11;
  private static final int DEFAULT_MIN_ZOOM = 5;
  public static final double DEFAULT_OPACITY = 0.6D;
  public static final int DEFAULT_RADIUS = 12;
  private static final int MAX_RADIUS = 50;
  private static final int MAX_ZOOM_LEVEL = 21;
  private static final int MIN_RADIUS = 10;
  private static final int SCREEN_SIZE = 1280;
  private static final int TILE_DIM = 256;
  private db mBounds;
  private int[] mColorMap;
  private Collection<WeightedLatLng> mData;
  private Gradient mGradient;
  private double[] mKernel;
  private double[] mMaxIntensity;
  private double mOpacity;
  private int mRadius;
  private a mTree;
  
  private HeatmapTileProvider(Builder paramBuilder)
  {
    this.mData = Builder.a(paramBuilder);
    this.mRadius = Builder.b(paramBuilder);
    this.mGradient = Builder.c(paramBuilder);
    if ((this.mGradient == null) || (!this.mGradient.isAvailable())) {
      this.mGradient = DEFAULT_GRADIENT;
    }
    this.mOpacity = Builder.d(paramBuilder);
    int i = this.mRadius;
    double d = this.mRadius;
    Double.isNaN(d);
    this.mKernel = a(i, d / 3.0D);
    a(this.mGradient);
    c(this.mData);
  }
  
  static double a(Collection<WeightedLatLng> paramCollection, db paramdb, int paramInt1, int paramInt2)
  {
    double d3 = paramdb.a;
    double d1 = paramdb.c;
    double d4 = paramdb.b;
    double d2 = paramdb.d;
    d1 -= d3;
    d2 -= d4;
    if (d1 <= d2) {
      d1 = d2;
    }
    d2 = paramInt2 / (paramInt1 * 2);
    Double.isNaN(d2);
    d2 = (int)(d2 + 0.5D);
    Double.isNaN(d2);
    double d5 = d2 / d1;
    paramdb = new LongSparseArray();
    Iterator localIterator = paramCollection.iterator();
    d2 = 0.0D;
    d1 = d3;
    paramCollection = paramdb;
    while (localIterator.hasNext())
    {
      WeightedLatLng localWeightedLatLng = (WeightedLatLng)localIterator.next();
      d3 = localWeightedLatLng.getPoint().x;
      double d6 = localWeightedLatLng.getPoint().y;
      paramInt1 = (int)((d3 - d1) * d5);
      paramInt2 = (int)((d6 - d4) * d5);
      long l = paramInt1;
      Object localObject = (LongSparseArray)paramCollection.get(l);
      paramdb = (db)localObject;
      if (localObject == null)
      {
        paramdb = new LongSparseArray();
        paramCollection.put(l, paramdb);
      }
      l = paramInt2;
      localObject = (Double)paramdb.get(l);
      if (localObject == null) {
        localObject = Double.valueOf(0.0D);
      }
      localObject = Double.valueOf(((Double)localObject).doubleValue() + localWeightedLatLng.intensity);
      paramdb.put(l, localObject);
      d3 = d2;
      if (((Double)localObject).doubleValue() > d2) {
        d3 = ((Double)localObject).doubleValue();
      }
      d2 = d3;
    }
    return d2;
  }
  
  static Bitmap a(double[][] paramArrayOfDouble, int[] paramArrayOfInt, double paramDouble)
  {
    int k = paramArrayOfInt[(paramArrayOfInt.length - 1)];
    double d = paramArrayOfInt.length - 1;
    Double.isNaN(d);
    paramDouble = d / paramDouble;
    int m = paramArrayOfDouble.length;
    int[] arrayOfInt = new int[m * m];
    int i = 0;
    while (i < m)
    {
      int j = 0;
      while (j < m)
      {
        d = paramArrayOfDouble[j][i];
        int n = i * m + j;
        int i1 = (int)(d * paramDouble);
        if (d != 0.0D)
        {
          if (i1 < paramArrayOfInt.length) {
            arrayOfInt[n] = paramArrayOfInt[i1];
          } else {
            arrayOfInt[n] = k;
          }
        }
        else {
          arrayOfInt[n] = 0;
        }
        j += 1;
      }
      i += 1;
    }
    paramArrayOfDouble = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
    paramArrayOfDouble.setPixels(arrayOfInt, 0, m, 0, 0, m, m);
    return paramArrayOfDouble;
  }
  
  static db a(Collection<WeightedLatLng> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    WeightedLatLng localWeightedLatLng = (WeightedLatLng)paramCollection.next();
    double d4 = localWeightedLatLng.getPoint().x;
    double d3 = localWeightedLatLng.getPoint().x;
    double d2 = localWeightedLatLng.getPoint().y;
    double d1 = localWeightedLatLng.getPoint().y;
    double d7 = d4;
    while (paramCollection.hasNext())
    {
      localWeightedLatLng = (WeightedLatLng)paramCollection.next();
      double d8 = localWeightedLatLng.getPoint().x;
      d4 = localWeightedLatLng.getPoint().y;
      double d5 = d7;
      if (d8 < d7) {
        d5 = d8;
      }
      double d6 = d3;
      if (d8 > d3) {
        d6 = d8;
      }
      d8 = d2;
      if (d4 < d2) {
        d8 = d4;
      }
      d7 = d5;
      d3 = d6;
      d2 = d8;
      if (d4 > d1)
      {
        d1 = d4;
        d7 = d5;
        d3 = d6;
        d2 = d8;
      }
    }
    return new db(d7, d3, d2, d1);
  }
  
  private static Tile a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return Tile.obtain(256, 256, localByteArrayOutputStream.toByteArray());
  }
  
  private void a(Gradient paramGradient)
  {
    this.mGradient = paramGradient;
    this.mColorMap = paramGradient.generateColorMap(this.mOpacity);
  }
  
  private double[] a(int paramInt)
  {
    double[] arrayOfDouble = new double[21];
    int i = 5;
    int j;
    for (;;)
    {
      j = 11;
      if (i >= 11) {
        break;
      }
      arrayOfDouble[i] = a(this.mData, this.mBounds, paramInt, (int)(Math.pow(2.0D, i) * 1280.0D));
      if (i == 5)
      {
        j = 0;
        while (j < i)
        {
          arrayOfDouble[j] = arrayOfDouble[i];
          j += 1;
        }
      }
      i += 1;
    }
    while (j < 21)
    {
      arrayOfDouble[j] = arrayOfDouble[10];
      j += 1;
    }
    return arrayOfDouble;
  }
  
  static double[] a(int paramInt, double paramDouble)
  {
    double[] arrayOfDouble = new double[paramInt * 2 + 1];
    int i = -paramInt;
    while (i <= paramInt)
    {
      double d = -i * i;
      Double.isNaN(d);
      arrayOfDouble[(i + paramInt)] = Math.exp(d / (2.0D * paramDouble * paramDouble));
      i += 1;
    }
    return arrayOfDouble;
  }
  
  static double[][] a(double[][] paramArrayOfDouble, double[] paramArrayOfDouble1)
  {
    double d = paramArrayOfDouble1.length;
    Double.isNaN(d);
    int i = (int)Math.floor(d / 2.0D);
    int i3 = paramArrayOfDouble.length;
    int i4 = i3 - i * 2;
    int k = i + i4 - 1;
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { i3, i3 });
    int m = 0;
    int n;
    int j;
    int i1;
    int i2;
    double[] arrayOfDouble1;
    while (m < i3)
    {
      n = 0;
      while (n < i3)
      {
        d = paramArrayOfDouble[m][n];
        if (d != 0.0D)
        {
          j = m + i;
          i1 = j;
          if (k < j) {
            i1 = k;
          }
          i2 = m - i;
          if (i > i2) {
            j = i;
          } else {
            j = i2;
          }
          while (j < i1 + 1)
          {
            arrayOfDouble1 = arrayOfDouble[j];
            arrayOfDouble1[n] += paramArrayOfDouble1[(j - i2)] * d;
            j += 1;
          }
        }
        n += 1;
      }
      m += 1;
    }
    paramArrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { i4, i4 });
    m = i;
    while (m < k + 1)
    {
      n = 0;
      while (n < i3)
      {
        d = arrayOfDouble[m][n];
        if (d != 0.0D)
        {
          j = n + i;
          i1 = j;
          if (k < j) {
            i1 = k;
          }
          i2 = n - i;
          if (i > i2) {
            j = i;
          } else {
            j = i2;
          }
          while (j < i1 + 1)
          {
            arrayOfDouble1 = paramArrayOfDouble[(m - i)];
            i4 = j - i;
            arrayOfDouble1[i4] += paramArrayOfDouble1[(j - i2)] * d;
            j += 1;
          }
        }
        n += 1;
      }
      m += 1;
    }
    return paramArrayOfDouble;
  }
  
  private void c(Collection<WeightedLatLng> paramCollection)
  {
    try
    {
      Object localObject = new ArrayList();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        WeightedLatLng localWeightedLatLng = (WeightedLatLng)paramCollection.next();
        if ((localWeightedLatLng.latLng.latitude < 85.0D) && (localWeightedLatLng.latLng.latitude > -85.0D)) {
          ((ArrayList)localObject).add(localWeightedLatLng);
        }
      }
      this.mData = ((Collection)localObject);
      this.mBounds = a(this.mData);
      this.mTree = new a(this.mBounds);
      paramCollection = this.mData.iterator();
      while (paramCollection.hasNext())
      {
        localObject = (WeightedLatLng)paramCollection.next();
        this.mTree.a((WeightedLatLng)localObject);
      }
      this.mMaxIntensity = a(this.mRadius);
      return;
    }
    catch (Throwable paramCollection)
    {
      paramCollection.printStackTrace();
    }
  }
  
  private static Collection<WeightedLatLng> d(Collection<LatLng> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(new WeightedLatLng((LatLng)paramCollection.next()));
    }
    return localArrayList;
  }
  
  public Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    double d2 = Math.pow(2.0D, paramInt3);
    double d1 = 1.0D;
    double d5 = 1.0D / d2;
    d2 = this.mRadius;
    Double.isNaN(d2);
    d2 = d2 * d5 / 256.0D;
    double d3 = this.mRadius * 2 + 256;
    Double.isNaN(d3);
    d3 = (2.0D * d2 + d5) / d3;
    double d4 = paramInt1;
    Double.isNaN(d4);
    d4 = d4 * d5 - d2;
    double d6 = paramInt1 + 1;
    Double.isNaN(d6);
    d6 = d6 * d5 + d2;
    double d7 = paramInt2;
    Double.isNaN(d7);
    d7 = d7 * d5 - d2;
    double d8 = paramInt2 + 1;
    Double.isNaN(d8);
    d5 = d8 * d5 + d2;
    Object localObject1 = new ArrayList();
    if (d4 < 0.0D)
    {
      localObject1 = new db(d4 + 1.0D, 1.0D, d7, d5);
      d1 = -1.0D;
      localObject1 = this.mTree.a((db)localObject1);
    }
    else if (d6 > 1.0D)
    {
      localObject1 = new db(0.0D, d6 - 1.0D, d7, d5);
      localObject1 = this.mTree.a((db)localObject1);
    }
    else
    {
      d1 = 0.0D;
    }
    Object localObject2 = new db(d4, d6, d7, d5);
    if (!((db)localObject2).a(new db(this.mBounds.a - d2, this.mBounds.c + d2, this.mBounds.b - d2, this.mBounds.d + d2))) {
      return TileProvider.NO_TILE;
    }
    localObject2 = this.mTree.a((db)localObject2);
    if (((Collection)localObject2).isEmpty()) {
      return TileProvider.NO_TILE;
    }
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { this.mRadius * 2 + 256, this.mRadius * 2 + 256 });
    localObject2 = ((Collection)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (WeightedLatLng)((Iterator)localObject2).next();
      Object localObject4 = ((WeightedLatLng)localObject3).getPoint();
      paramInt1 = (int)((((DPoint)localObject4).x - d4) / d3);
      paramInt2 = (int)((((DPoint)localObject4).y - d7) / d3);
      localObject4 = arrayOfDouble[paramInt1];
      localObject4[paramInt2] += ((WeightedLatLng)localObject3).intensity;
    }
    localObject1 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeightedLatLng)((Iterator)localObject1).next();
      localObject3 = ((WeightedLatLng)localObject2).getPoint();
      paramInt1 = (int)((((DPoint)localObject3).x + d1 - d4) / d3);
      paramInt2 = (int)((((DPoint)localObject3).y - d7) / d3);
      localObject3 = arrayOfDouble[paramInt1];
      localObject3[paramInt2] += ((WeightedLatLng)localObject2).intensity;
    }
    return a(a(a(arrayOfDouble, this.mKernel), this.mColorMap, this.mMaxIntensity[paramInt3]));
  }
  
  public int getTileHeight()
  {
    return 256;
  }
  
  public int getTileWidth()
  {
    return 256;
  }
  
  public static class Builder
  {
    private Collection<WeightedLatLng> data;
    private Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
    private double opacity = 0.6D;
    private int radius = 12;
    
    public HeatmapTileProvider build()
    {
      if ((this.data != null) && (this.data.size() != 0)) {
        try
        {
          HeatmapTileProvider localHeatmapTileProvider = new HeatmapTileProvider(this, null);
          return localHeatmapTileProvider;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          return null;
        }
      }
      try
      {
        throw new AMapException("No input points.");
      }
      catch (AMapException localAMapException)
      {
        Log.e("amap", localAMapException.getErrorMessage());
        localAMapException.printStackTrace();
      }
      return null;
    }
    
    public Builder data(Collection<LatLng> paramCollection)
    {
      return weightedData(HeatmapTileProvider.b(paramCollection));
    }
    
    public Builder gradient(Gradient paramGradient)
    {
      this.gradient = paramGradient;
      return this;
    }
    
    public Builder radius(int paramInt)
    {
      this.radius = Math.max(10, Math.min(paramInt, 50));
      return this;
    }
    
    public Builder transparency(double paramDouble)
    {
      this.opacity = Math.max(0.0D, Math.min(paramDouble, 1.0D));
      return this;
    }
    
    public Builder weightedData(Collection<WeightedLatLng> paramCollection)
    {
      this.data = paramCollection;
      return this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\HeatmapTileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */