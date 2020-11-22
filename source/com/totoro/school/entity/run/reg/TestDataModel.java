package com.totoro.school.entity.run.reg;

import java.io.Serializable;

public class TestDataModel
  implements Serializable
{
  private String averageSpeed;
  private String currentSpeed;
  private String currentSteps;
  private String mileage;
  private String time;
  private String usedTime;
  
  public TestDataModel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.usedTime = paramString1;
    this.currentSpeed = paramString2;
    this.averageSpeed = paramString3;
    this.currentSteps = paramString4;
    this.mileage = paramString5;
    this.time = paramString6;
  }
  
  public String getAverageSpeed()
  {
    return this.averageSpeed;
  }
  
  public String getCurrentSpeed()
  {
    return this.currentSpeed;
  }
  
  public String getCurrentSteps()
  {
    return this.currentSteps;
  }
  
  public String getMileage()
  {
    return this.mileage;
  }
  
  public String getTime()
  {
    return this.time;
  }
  
  public String getUsedTime()
  {
    return this.usedTime;
  }
  
  public void setAverageSpeed(String paramString)
  {
    this.averageSpeed = paramString;
  }
  
  public void setCurrentSpeed(String paramString)
  {
    this.currentSpeed = paramString;
  }
  
  public void setCurrentSteps(String paramString)
  {
    this.currentSteps = paramString;
  }
  
  public void setMileage(String paramString)
  {
    this.mileage = paramString;
  }
  
  public void setTime(String paramString)
  {
    this.time = paramString;
  }
  
  public void setUsedTime(String paramString)
  {
    this.usedTime = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\run\reg\TestDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */