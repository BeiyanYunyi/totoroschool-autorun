package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;

public final class Version
{
  private static final Version[] VERSIONS = ;
  private final int dataRegionSizeColumns;
  private final int dataRegionSizeRows;
  private final ECBlocks ecBlocks;
  private final int symbolSizeColumns;
  private final int symbolSizeRows;
  private final int totalCodewords;
  private final int versionNumber;
  
  private Version(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, ECBlocks paramECBlocks)
  {
    this.versionNumber = paramInt1;
    this.symbolSizeRows = paramInt2;
    this.symbolSizeColumns = paramInt3;
    this.dataRegionSizeRows = paramInt4;
    this.dataRegionSizeColumns = paramInt5;
    this.ecBlocks = paramECBlocks;
    paramInt3 = paramECBlocks.getECCodewords();
    paramECBlocks = paramECBlocks.getECBlocks();
    paramInt4 = paramECBlocks.length;
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < paramInt4)
    {
      Object localObject = paramECBlocks[paramInt1];
      paramInt2 += ((ECB)localObject).getCount() * (((ECB)localObject).getDataCodewords() + paramInt3);
      paramInt1 += 1;
    }
    this.totalCodewords = paramInt2;
  }
  
  private static Version[] buildVersions()
  {
    return new Version[] { new Version(1, 10, 10, 8, 8, new ECBlocks(5, new ECB(1, 3, null), null)), new Version(2, 12, 12, 10, 10, new ECBlocks(7, new ECB(1, 5, null), null)), new Version(3, 14, 14, 12, 12, new ECBlocks(10, new ECB(1, 8, null), null)), new Version(4, 16, 16, 14, 14, new ECBlocks(12, new ECB(1, 12, null), null)), new Version(5, 18, 18, 16, 16, new ECBlocks(14, new ECB(1, 18, null), null)), new Version(6, 20, 20, 18, 18, new ECBlocks(18, new ECB(1, 22, null), null)), new Version(7, 22, 22, 20, 20, new ECBlocks(20, new ECB(1, 30, null), null)), new Version(8, 24, 24, 22, 22, new ECBlocks(24, new ECB(1, 36, null), null)), new Version(9, 26, 26, 24, 24, new ECBlocks(28, new ECB(1, 44, null), null)), new Version(10, 32, 32, 14, 14, new ECBlocks(36, new ECB(1, 62, null), null)), new Version(11, 36, 36, 16, 16, new ECBlocks(42, new ECB(1, 86, null), null)), new Version(12, 40, 40, 18, 18, new ECBlocks(48, new ECB(1, 114, null), null)), new Version(13, 44, 44, 20, 20, new ECBlocks(56, new ECB(1, 144, null), null)), new Version(14, 48, 48, 22, 22, new ECBlocks(68, new ECB(1, 174, null), null)), new Version(15, 52, 52, 24, 24, new ECBlocks(42, new ECB(2, 102, null), null)), new Version(16, 64, 64, 14, 14, new ECBlocks(56, new ECB(2, 140, null), null)), new Version(17, 72, 72, 16, 16, new ECBlocks(36, new ECB(4, 92, null), null)), new Version(18, 80, 80, 18, 18, new ECBlocks(48, new ECB(4, 114, null), null)), new Version(19, 88, 88, 20, 20, new ECBlocks(56, new ECB(4, 144, null), null)), new Version(20, 96, 96, 22, 22, new ECBlocks(68, new ECB(4, 174, null), null)), new Version(21, 104, 104, 24, 24, new ECBlocks(56, new ECB(6, 136, null), null)), new Version(22, 120, 120, 18, 18, new ECBlocks(68, new ECB(6, 175, null), null)), new Version(23, 132, 132, 20, 20, new ECBlocks(62, new ECB(8, 163, null), null)), new Version(24, 144, 144, 22, 22, new ECBlocks(62, new ECB(8, 156, null), new ECB(2, 155, null), null)), new Version(25, 8, 18, 6, 16, new ECBlocks(7, new ECB(1, 5, null), null)), new Version(26, 8, 32, 6, 14, new ECBlocks(11, new ECB(1, 10, null), null)), new Version(27, 12, 26, 10, 24, new ECBlocks(14, new ECB(1, 16, null), null)), new Version(28, 12, 36, 10, 16, new ECBlocks(18, new ECB(1, 22, null), null)), new Version(29, 16, 36, 14, 16, new ECBlocks(24, new ECB(1, 32, null), null)), new Version(30, 16, 48, 14, 22, new ECBlocks(28, new ECB(1, 49, null), null)) };
  }
  
  public static Version getVersionForDimensions(int paramInt1, int paramInt2)
    throws FormatException
  {
    if (((paramInt1 & 0x1) == 0) && ((paramInt2 & 0x1) == 0))
    {
      Version[] arrayOfVersion = VERSIONS;
      int j = arrayOfVersion.length;
      int i = 0;
      while (i < j)
      {
        Version localVersion = arrayOfVersion[i];
        if ((localVersion.symbolSizeRows == paramInt1) && (localVersion.symbolSizeColumns == paramInt2)) {
          return localVersion;
        }
        i += 1;
      }
      throw FormatException.getFormatInstance();
    }
    throw FormatException.getFormatInstance();
  }
  
  public int getDataRegionSizeColumns()
  {
    return this.dataRegionSizeColumns;
  }
  
  public int getDataRegionSizeRows()
  {
    return this.dataRegionSizeRows;
  }
  
  ECBlocks getECBlocks()
  {
    return this.ecBlocks;
  }
  
  public int getSymbolSizeColumns()
  {
    return this.symbolSizeColumns;
  }
  
  public int getSymbolSizeRows()
  {
    return this.symbolSizeRows;
  }
  
  public int getTotalCodewords()
  {
    return this.totalCodewords;
  }
  
  public int getVersionNumber()
  {
    return this.versionNumber;
  }
  
  public String toString()
  {
    return String.valueOf(this.versionNumber);
  }
  
  static final class ECB
  {
    private final int count;
    private final int dataCodewords;
    
    private ECB(int paramInt1, int paramInt2)
    {
      this.count = paramInt1;
      this.dataCodewords = paramInt2;
    }
    
    int getCount()
    {
      return this.count;
    }
    
    int getDataCodewords()
    {
      return this.dataCodewords;
    }
  }
  
  static final class ECBlocks
  {
    private final Version.ECB[] ecBlocks;
    private final int ecCodewords;
    
    private ECBlocks(int paramInt, Version.ECB paramECB)
    {
      this.ecCodewords = paramInt;
      this.ecBlocks = new Version.ECB[] { paramECB };
    }
    
    private ECBlocks(int paramInt, Version.ECB paramECB1, Version.ECB paramECB2)
    {
      this.ecCodewords = paramInt;
      this.ecBlocks = new Version.ECB[] { paramECB1, paramECB2 };
    }
    
    Version.ECB[] getECBlocks()
    {
      return this.ecBlocks;
    }
    
    int getECCodewords()
    {
      return this.ecCodewords;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\datamatrix\decoder\Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */