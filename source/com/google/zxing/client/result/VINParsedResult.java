package com.google.zxing.client.result;

public final class VINParsedResult
  extends ParsedResult
{
  private final String countryCode;
  private final int modelYear;
  private final char plantCode;
  private final String sequentialNumber;
  private final String vehicleAttributes;
  private final String vehicleDescriptorSection;
  private final String vehicleIdentifierSection;
  private final String vin;
  private final String worldManufacturerID;
  
  public VINParsedResult(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, char paramChar, String paramString7)
  {
    super(ParsedResultType.VIN);
    this.vin = paramString1;
    this.worldManufacturerID = paramString2;
    this.vehicleDescriptorSection = paramString3;
    this.vehicleIdentifierSection = paramString4;
    this.countryCode = paramString5;
    this.vehicleAttributes = paramString6;
    this.modelYear = paramInt;
    this.plantCode = paramChar;
    this.sequentialNumber = paramString7;
  }
  
  public String getCountryCode()
  {
    return this.countryCode;
  }
  
  public String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append(this.worldManufacturerID);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.vehicleDescriptorSection);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.vehicleIdentifierSection);
    localStringBuilder.append('\n');
    if (this.countryCode != null)
    {
      localStringBuilder.append(this.countryCode);
      localStringBuilder.append(' ');
    }
    localStringBuilder.append(this.modelYear);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.plantCode);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.sequentialNumber);
    localStringBuilder.append('\n');
    return localStringBuilder.toString();
  }
  
  public int getModelYear()
  {
    return this.modelYear;
  }
  
  public char getPlantCode()
  {
    return this.plantCode;
  }
  
  public String getSequentialNumber()
  {
    return this.sequentialNumber;
  }
  
  public String getVIN()
  {
    return this.vin;
  }
  
  public String getVehicleAttributes()
  {
    return this.vehicleAttributes;
  }
  
  public String getVehicleDescriptorSection()
  {
    return this.vehicleDescriptorSection;
  }
  
  public String getVehicleIdentifierSection()
  {
    return this.vehicleIdentifierSection;
  }
  
  public String getWorldManufacturerID()
  {
    return this.worldManufacturerID;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\VINParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */