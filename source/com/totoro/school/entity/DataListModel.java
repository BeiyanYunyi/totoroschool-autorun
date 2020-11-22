package com.totoro.school.entity;

import java.io.Serializable;

public class DataListModel
  implements Serializable
{
  private String TYPE_ACCELEROMETER;
  private String TYPE_GRAVITY;
  private String TYPE_GYROSCOPE;
  private String TYPE_LIGHT;
  private String TYPE_LINEAR_ACCELERATION;
  private String TYPE_MAGNETIC_FIELD;
  private String TYPE_ORIENTATION;
  private String TYPE_PRESSURE;
  private String TYPE_PROXIMITY;
  private String TYPE_STEP_COUNTER;
  private String TYPE_STEP_DETECTOR;
  private String TYPE_TEMPERATURE;
  private String collectionTime;
  private String data;
  private String deviceModel;
  private String macAddress;
  private String operator;
  private String phoneStatus;
  private String sensorName;
  private String situation;
  private String systemVersion;
  
  public DataListModel() {}
  
  public DataListModel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.collectionTime = paramString1;
    this.data = paramString2;
    this.deviceModel = paramString3;
    this.macAddress = paramString4;
    this.operator = paramString5;
    this.phoneStatus = paramString6;
    this.sensorName = paramString7;
    this.situation = paramString8;
    this.systemVersion = paramString9;
  }
  
  public String getCollectionTime()
  {
    return this.collectionTime;
  }
  
  public String getData()
  {
    return this.data;
  }
  
  public String getDeviceModel()
  {
    return this.deviceModel;
  }
  
  public String getMacAddress()
  {
    return this.macAddress;
  }
  
  public String getOperator()
  {
    return this.operator;
  }
  
  public String getPhoneStatus()
  {
    return this.phoneStatus;
  }
  
  public String getSensorName()
  {
    return this.sensorName;
  }
  
  public String getSituation()
  {
    return this.situation;
  }
  
  public String getSystemVersion()
  {
    return this.systemVersion;
  }
  
  public String getTYPE_ACCELEROMETER()
  {
    return this.TYPE_ACCELEROMETER;
  }
  
  public String getTYPE_GRAVITY()
  {
    return this.TYPE_GRAVITY;
  }
  
  public String getTYPE_GYROSCOPE()
  {
    return this.TYPE_GYROSCOPE;
  }
  
  public String getTYPE_LIGHT()
  {
    return this.TYPE_LIGHT;
  }
  
  public String getTYPE_LINEAR_ACCELERATION()
  {
    return this.TYPE_LINEAR_ACCELERATION;
  }
  
  public String getTYPE_MAGNETIC_FIELD()
  {
    return this.TYPE_MAGNETIC_FIELD;
  }
  
  public String getTYPE_ORIENTATION()
  {
    return this.TYPE_ORIENTATION;
  }
  
  public String getTYPE_PRESSURE()
  {
    return this.TYPE_PRESSURE;
  }
  
  public String getTYPE_PROXIMITY()
  {
    return this.TYPE_PROXIMITY;
  }
  
  public String getTYPE_STEP_COUNTER()
  {
    return this.TYPE_STEP_COUNTER;
  }
  
  public String getTYPE_STEP_DETECTOR()
  {
    return this.TYPE_STEP_DETECTOR;
  }
  
  public String getTYPE_TEMPERATURE()
  {
    return this.TYPE_TEMPERATURE;
  }
  
  public void setCollectionTime(String paramString)
  {
    this.collectionTime = paramString;
  }
  
  public void setData(String paramString)
  {
    this.data = paramString;
  }
  
  public void setDeviceModel(String paramString)
  {
    this.deviceModel = paramString;
  }
  
  public void setMacAddress(String paramString)
  {
    this.macAddress = paramString;
  }
  
  public void setOperator(String paramString)
  {
    this.operator = paramString;
  }
  
  public void setPhoneStatus(String paramString)
  {
    this.phoneStatus = paramString;
  }
  
  public void setSensorName(String paramString)
  {
    this.sensorName = paramString;
  }
  
  public void setSituation(String paramString)
  {
    this.situation = paramString;
  }
  
  public void setSystemVersion(String paramString)
  {
    this.systemVersion = paramString;
  }
  
  public void setTYPE_ACCELEROMETER(String paramString)
  {
    this.TYPE_ACCELEROMETER = paramString;
  }
  
  public void setTYPE_GRAVITY(String paramString)
  {
    this.TYPE_GRAVITY = paramString;
  }
  
  public void setTYPE_GYROSCOPE(String paramString)
  {
    this.TYPE_GYROSCOPE = paramString;
  }
  
  public void setTYPE_LIGHT(String paramString)
  {
    this.TYPE_LIGHT = paramString;
  }
  
  public void setTYPE_LINEAR_ACCELERATION(String paramString)
  {
    this.TYPE_LINEAR_ACCELERATION = paramString;
  }
  
  public void setTYPE_MAGNETIC_FIELD(String paramString)
  {
    this.TYPE_MAGNETIC_FIELD = paramString;
  }
  
  public void setTYPE_ORIENTATION(String paramString)
  {
    this.TYPE_ORIENTATION = paramString;
  }
  
  public void setTYPE_PRESSURE(String paramString)
  {
    this.TYPE_PRESSURE = paramString;
  }
  
  public void setTYPE_PROXIMITY(String paramString)
  {
    this.TYPE_PROXIMITY = paramString;
  }
  
  public void setTYPE_STEP_COUNTER(String paramString)
  {
    this.TYPE_STEP_COUNTER = paramString;
  }
  
  public void setTYPE_STEP_DETECTOR(String paramString)
  {
    this.TYPE_STEP_DETECTOR = paramString;
  }
  
  public void setTYPE_TEMPERATURE(String paramString)
  {
    this.TYPE_TEMPERATURE = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("加速度传感器:\n");
    localStringBuilder.append(this.TYPE_ACCELEROMETER);
    localStringBuilder.append("\n");
    localStringBuilder.append("磁场传感器:");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.TYPE_MAGNETIC_FIELD);
    localStringBuilder.append("\n");
    localStringBuilder.append("方向传感器:");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.TYPE_ORIENTATION);
    localStringBuilder.append("\n");
    localStringBuilder.append("陀螺仪传感器:");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.TYPE_GYROSCOPE);
    localStringBuilder.append("\n");
    localStringBuilder.append("重力传感器:");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.TYPE_GRAVITY);
    localStringBuilder.append("\n");
    localStringBuilder.append("线性加速度传感器:'");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.TYPE_LINEAR_ACCELERATION);
    localStringBuilder.append("\n");
    localStringBuilder.append("温度传感器:");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.TYPE_TEMPERATURE);
    localStringBuilder.append("\n");
    localStringBuilder.append("距离传感器:");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.TYPE_LIGHT);
    localStringBuilder.append("\n");
    localStringBuilder.append("光感传感器:");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.TYPE_PROXIMITY);
    localStringBuilder.append("\n");
    localStringBuilder.append("温度传感器:");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.TYPE_PRESSURE);
    localStringBuilder.append("\n");
    localStringBuilder.append("计步传感器:");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.TYPE_STEP_COUNTER);
    localStringBuilder.append("\n");
    localStringBuilder.append("单次计步传感器:");
    localStringBuilder.append("\n");
    localStringBuilder.append(this.TYPE_STEP_DETECTOR);
    return localStringBuilder.toString();
  }
  
  public String toString1()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataListModel{collectionTime='");
    localStringBuilder.append(this.collectionTime);
    localStringBuilder.append('\'');
    localStringBuilder.append(", data='");
    localStringBuilder.append(this.data);
    localStringBuilder.append('\'');
    localStringBuilder.append(", deviceModel='");
    localStringBuilder.append(this.deviceModel);
    localStringBuilder.append('\'');
    localStringBuilder.append(", macAddress='");
    localStringBuilder.append(this.macAddress);
    localStringBuilder.append('\'');
    localStringBuilder.append(", operator='");
    localStringBuilder.append(this.operator);
    localStringBuilder.append('\'');
    localStringBuilder.append(", phoneStatus='");
    localStringBuilder.append(this.phoneStatus);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sensorName='");
    localStringBuilder.append(this.sensorName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", situation='");
    localStringBuilder.append(this.situation);
    localStringBuilder.append('\'');
    localStringBuilder.append(", systemVersion='");
    localStringBuilder.append(this.systemVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\DataListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */