package com.totoro.school.entity.run.reg;

import java.io.Serializable;
import org.litepal.crud.LitePalSupport;

public class RunRegRequestModel
  extends LitePalSupport
  implements Serializable
{
  private boolean alreadyAppeal;
  private String baseStation;
  private String begdate;
  private boolean canAppeal;
  private String currentTime;
  private String enddate;
  private String flag;
  private String gsensorx = "0.01";
  private String gsensory = "0.33";
  private String gsensorz = "0.12";
  private String gvsensor = "0.12";
  private String gysensorx = "0.01";
  private String gysensory = "0.33";
  private String gysensorz = "0.12";
  private boolean isTask;
  private String lasensor = "0.12";
  private String lpasensor = "0.12";
  private String luxsensor = "0.12";
  private String mac;
  private String msensorx = "0.01";
  private String msensory = "0.33";
  private String msensorz = "0.12";
  private String nsensor = "0.12";
  private String osensorx = "0.01";
  private String osensory = "0.33";
  private String osensorz = "0.12";
  private String phoneInfo;
  private String phoneNumber;
  private boolean qualified;
  private String route;
  private String routeid;
  private String rvsensor = "0.12";
  private String schoolName;
  private String snCode;
  private String taskid;
  private String tsensor = "0.12";
  private String userbegtime;
  private String userendkm;
  private String userendstep;
  private String userendtime;
  private String userfit;
  private String userkm;
  private String useroffset = "0.15";
  private String userspeed;
  private String userstartkm;
  private String userstartstep;
  private String userstep;
  private String usertime;
  private String uuid;
  private String version;
  private String warnflag;
  private String warntype;
  
  public String getBaseStation()
  {
    return this.baseStation;
  }
  
  public String getBegdate()
  {
    return this.begdate;
  }
  
  public String getCurrentTime()
  {
    return this.currentTime;
  }
  
  public String getEnddate()
  {
    return this.enddate;
  }
  
  public String getFlag()
  {
    return this.flag;
  }
  
  public String getGsensorx()
  {
    return this.gsensorx;
  }
  
  public String getGsensory()
  {
    return this.gsensory;
  }
  
  public String getGsensorz()
  {
    return this.gsensorz;
  }
  
  public String getGysensorx()
  {
    return this.gysensorx;
  }
  
  public String getGysensory()
  {
    return this.gysensory;
  }
  
  public String getGysensorz()
  {
    return this.gysensorz;
  }
  
  public String getLuxsensor()
  {
    return this.luxsensor;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public String getPhoneInfo()
  {
    return this.phoneInfo;
  }
  
  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }
  
  public String getRoute()
  {
    return this.route;
  }
  
  public String getRouteid()
  {
    return this.routeid;
  }
  
  public String getSchoolName()
  {
    return this.schoolName;
  }
  
  public String getSnCode()
  {
    return this.snCode;
  }
  
  public String getTaskid()
  {
    return this.taskid;
  }
  
  public String getUserbegtime()
  {
    return this.userbegtime;
  }
  
  public String getUserendkm()
  {
    return this.userendkm;
  }
  
  public String getUserendstep()
  {
    return this.userendstep;
  }
  
  public String getUserendtime()
  {
    return this.userendtime;
  }
  
  public String getUserfit()
  {
    return this.userfit;
  }
  
  public String getUserkm()
  {
    return this.userkm;
  }
  
  public String getUseroffset()
  {
    return this.useroffset;
  }
  
  public String getUserspeed()
  {
    return this.userspeed;
  }
  
  public String getUserstartkm()
  {
    return this.userstartkm;
  }
  
  public String getUserstartstep()
  {
    return this.userstartstep;
  }
  
  public String getUserstep()
  {
    return this.userstep;
  }
  
  public String getUsertime()
  {
    return this.usertime;
  }
  
  public String getUuid()
  {
    return this.uuid;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public String getWarnflag()
  {
    return this.warnflag;
  }
  
  public String getWarntype()
  {
    return this.warntype;
  }
  
  public boolean isAlreadyAppeal()
  {
    return this.alreadyAppeal;
  }
  
  public boolean isCanAppeal()
  {
    return this.canAppeal;
  }
  
  public boolean isQualified()
  {
    return this.qualified;
  }
  
  public boolean isTask()
  {
    return this.isTask;
  }
  
  public void setAlreadyAppeal(boolean paramBoolean)
  {
    this.alreadyAppeal = paramBoolean;
  }
  
  public void setBaseStation(String paramString)
  {
    this.baseStation = paramString;
  }
  
  public void setBegdate(String paramString)
  {
    this.begdate = paramString;
  }
  
  public void setCanAppeal(boolean paramBoolean)
  {
    this.canAppeal = paramBoolean;
  }
  
  public void setCurrentTime(String paramString)
  {
    this.currentTime = paramString;
  }
  
  public void setEnddate(String paramString)
  {
    this.enddate = paramString;
  }
  
  public void setFlag(String paramString)
  {
    this.flag = paramString;
  }
  
  public void setGsensorx(String paramString)
  {
    this.gsensorx = paramString;
  }
  
  public void setGsensory(String paramString)
  {
    this.gsensory = paramString;
  }
  
  public void setGsensorz(String paramString)
  {
    this.gsensorz = paramString;
  }
  
  public void setGysensorx(String paramString)
  {
    this.gysensorx = paramString;
  }
  
  public void setGysensory(String paramString)
  {
    this.gysensory = paramString;
  }
  
  public void setGysensorz(String paramString)
  {
    this.gysensorz = paramString;
  }
  
  public void setLuxsensor(String paramString)
  {
    this.luxsensor = paramString;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setPhoneInfo(String paramString)
  {
    this.phoneInfo = paramString;
  }
  
  public void setPhoneNumber(String paramString)
  {
    this.phoneNumber = paramString;
  }
  
  public void setQualified(boolean paramBoolean)
  {
    this.qualified = paramBoolean;
  }
  
  public void setRoute(String paramString)
  {
    this.route = paramString;
  }
  
  public void setRouteid(String paramString)
  {
    this.routeid = paramString;
  }
  
  public void setSchoolName(String paramString)
  {
    this.schoolName = paramString;
  }
  
  public void setSnCode(String paramString)
  {
    this.snCode = paramString;
  }
  
  public void setTask(boolean paramBoolean)
  {
    this.isTask = paramBoolean;
  }
  
  public void setTaskid(String paramString)
  {
    this.taskid = paramString;
  }
  
  public void setUserbegtime(String paramString)
  {
    this.userbegtime = paramString;
  }
  
  public void setUserendkm(String paramString)
  {
    this.userendkm = paramString;
  }
  
  public void setUserendstep(String paramString)
  {
    this.userendstep = paramString;
  }
  
  public void setUserendtime(String paramString)
  {
    this.userendtime = paramString;
  }
  
  public void setUserfit(String paramString)
  {
    this.userfit = paramString;
  }
  
  public void setUserkm(String paramString)
  {
    this.userkm = paramString;
  }
  
  public void setUseroffset(String paramString)
  {
    this.useroffset = paramString;
  }
  
  public void setUserspeed(String paramString)
  {
    this.userspeed = paramString;
  }
  
  public void setUserstartkm(String paramString)
  {
    this.userstartkm = paramString;
  }
  
  public void setUserstartstep(String paramString)
  {
    this.userstartstep = paramString;
  }
  
  public void setUserstep(String paramString)
  {
    this.userstep = paramString;
  }
  
  public void setUsertime(String paramString)
  {
    this.usertime = paramString;
  }
  
  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public void setWarnflag(String paramString)
  {
    this.warnflag = paramString;
  }
  
  public void setWarntype(String paramString)
  {
    this.warntype = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\run\reg\RunRegRequestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */