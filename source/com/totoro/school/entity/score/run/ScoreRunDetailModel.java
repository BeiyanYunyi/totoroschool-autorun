package com.totoro.school.entity.score.run;

import java.io.Serializable;

public class ScoreRunDetailModel
  implements Serializable
{
  private String begdate;
  private String durationTime;
  private String enddate;
  private String flag;
  private String motionRoute;
  private int routeid;
  private String routename;
  private String termname;
  private double totalKm;
  private String userbegtime;
  private String userendtime;
  
  public String getBegdate()
  {
    return this.begdate;
  }
  
  public String getDurationTime()
  {
    return this.durationTime;
  }
  
  public String getEnddate()
  {
    return this.enddate;
  }
  
  public String getFlag()
  {
    return this.flag;
  }
  
  public String getMotionRoute()
  {
    return this.motionRoute;
  }
  
  public int getRouteid()
  {
    return this.routeid;
  }
  
  public String getRoutename()
  {
    return this.routename;
  }
  
  public String getTermname()
  {
    return this.termname;
  }
  
  public double getTotalKm()
  {
    return this.totalKm;
  }
  
  public String getUserbegtime()
  {
    return this.userbegtime;
  }
  
  public String getUserendtime()
  {
    return this.userendtime;
  }
  
  public void setBegdate(String paramString)
  {
    this.begdate = paramString;
  }
  
  public void setDurationTime(String paramString)
  {
    this.durationTime = paramString;
  }
  
  public void setEnddate(String paramString)
  {
    this.enddate = paramString;
  }
  
  public void setFlag(String paramString)
  {
    this.flag = paramString;
  }
  
  public void setMotionRoute(String paramString)
  {
    this.motionRoute = paramString;
  }
  
  public void setRouteid(int paramInt)
  {
    this.routeid = paramInt;
  }
  
  public void setRoutename(String paramString)
  {
    this.routename = paramString;
  }
  
  public void setTermname(String paramString)
  {
    this.termname = paramString;
  }
  
  public void setTotalKm(double paramDouble)
  {
    this.totalKm = paramDouble;
  }
  
  public void setUserbegtime(String paramString)
  {
    this.userbegtime = paramString;
  }
  
  public void setUserendtime(String paramString)
  {
    this.userendtime = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\score\run\ScoreRunDetailModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */