package com.google.zxing.client.result;

import java.util.Map;

public final class ExpandedProductParsedResult
  extends ParsedResult
{
  public static final String KILOGRAM = "KG";
  public static final String POUND = "LB";
  private final String bestBeforeDate;
  private final String expirationDate;
  private final String lotNumber;
  private final String packagingDate;
  private final String price;
  private final String priceCurrency;
  private final String priceIncrement;
  private final String productID;
  private final String productionDate;
  private final String rawText;
  private final String sscc;
  private final Map<String, String> uncommonAIs;
  private final String weight;
  private final String weightIncrement;
  private final String weightType;
  
  public ExpandedProductParsedResult(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, Map<String, String> paramMap)
  {
    super(ParsedResultType.PRODUCT);
    this.rawText = paramString1;
    this.productID = paramString2;
    this.sscc = paramString3;
    this.lotNumber = paramString4;
    this.productionDate = paramString5;
    this.packagingDate = paramString6;
    this.bestBeforeDate = paramString7;
    this.expirationDate = paramString8;
    this.weight = paramString9;
    this.weightType = paramString10;
    this.weightIncrement = paramString11;
    this.price = paramString12;
    this.priceIncrement = paramString13;
    this.priceCurrency = paramString14;
    this.uncommonAIs = paramMap;
  }
  
  private static boolean equalsOrNull(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  private static int hashNotNull(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return paramObject.hashCode();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ExpandedProductParsedResult;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (ExpandedProductParsedResult)paramObject;
    bool1 = bool2;
    if (equalsOrNull(this.productID, ((ExpandedProductParsedResult)paramObject).productID))
    {
      bool1 = bool2;
      if (equalsOrNull(this.sscc, ((ExpandedProductParsedResult)paramObject).sscc))
      {
        bool1 = bool2;
        if (equalsOrNull(this.lotNumber, ((ExpandedProductParsedResult)paramObject).lotNumber))
        {
          bool1 = bool2;
          if (equalsOrNull(this.productionDate, ((ExpandedProductParsedResult)paramObject).productionDate))
          {
            bool1 = bool2;
            if (equalsOrNull(this.bestBeforeDate, ((ExpandedProductParsedResult)paramObject).bestBeforeDate))
            {
              bool1 = bool2;
              if (equalsOrNull(this.expirationDate, ((ExpandedProductParsedResult)paramObject).expirationDate))
              {
                bool1 = bool2;
                if (equalsOrNull(this.weight, ((ExpandedProductParsedResult)paramObject).weight))
                {
                  bool1 = bool2;
                  if (equalsOrNull(this.weightType, ((ExpandedProductParsedResult)paramObject).weightType))
                  {
                    bool1 = bool2;
                    if (equalsOrNull(this.weightIncrement, ((ExpandedProductParsedResult)paramObject).weightIncrement))
                    {
                      bool1 = bool2;
                      if (equalsOrNull(this.price, ((ExpandedProductParsedResult)paramObject).price))
                      {
                        bool1 = bool2;
                        if (equalsOrNull(this.priceIncrement, ((ExpandedProductParsedResult)paramObject).priceIncrement))
                        {
                          bool1 = bool2;
                          if (equalsOrNull(this.priceCurrency, ((ExpandedProductParsedResult)paramObject).priceCurrency))
                          {
                            bool1 = bool2;
                            if (equalsOrNull(this.uncommonAIs, ((ExpandedProductParsedResult)paramObject).uncommonAIs)) {
                              bool1 = true;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String getBestBeforeDate()
  {
    return this.bestBeforeDate;
  }
  
  public String getDisplayResult()
  {
    return String.valueOf(this.rawText);
  }
  
  public String getExpirationDate()
  {
    return this.expirationDate;
  }
  
  public String getLotNumber()
  {
    return this.lotNumber;
  }
  
  public String getPackagingDate()
  {
    return this.packagingDate;
  }
  
  public String getPrice()
  {
    return this.price;
  }
  
  public String getPriceCurrency()
  {
    return this.priceCurrency;
  }
  
  public String getPriceIncrement()
  {
    return this.priceIncrement;
  }
  
  public String getProductID()
  {
    return this.productID;
  }
  
  public String getProductionDate()
  {
    return this.productionDate;
  }
  
  public String getRawText()
  {
    return this.rawText;
  }
  
  public String getSscc()
  {
    return this.sscc;
  }
  
  public Map<String, String> getUncommonAIs()
  {
    return this.uncommonAIs;
  }
  
  public String getWeight()
  {
    return this.weight;
  }
  
  public String getWeightIncrement()
  {
    return this.weightIncrement;
  }
  
  public String getWeightType()
  {
    return this.weightType;
  }
  
  public int hashCode()
  {
    return hashNotNull(this.productID) ^ 0x0 ^ hashNotNull(this.sscc) ^ hashNotNull(this.lotNumber) ^ hashNotNull(this.productionDate) ^ hashNotNull(this.bestBeforeDate) ^ hashNotNull(this.expirationDate) ^ hashNotNull(this.weight) ^ hashNotNull(this.weightType) ^ hashNotNull(this.weightIncrement) ^ hashNotNull(this.price) ^ hashNotNull(this.priceIncrement) ^ hashNotNull(this.priceCurrency) ^ hashNotNull(this.uncommonAIs);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\ExpandedProductParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */