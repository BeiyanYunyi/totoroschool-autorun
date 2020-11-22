package com.totoro.school.entity.score.run;

public class ScoreRunModel
{
  private String NmonthSuccess;
  private String monthSuccess;
  private String monthid;
  
  public ScoreRunModel(String paramString1, String paramString2)
  {
    this.monthid = paramString1;
    this.monthSuccess = paramString2;
  }
  
  public String getMonthSuccess()
  {
    return this.monthSuccess;
  }
  
  public String getMonthid()
  {
    return this.monthid;
  }
  
  public String getNmonthSuccess()
  {
    return this.NmonthSuccess;
  }
  
  public void setMonthSuccess(String paramString)
  {
    this.monthSuccess = paramString;
  }
  
  public void setMonthid(String paramString)
  {
    this.monthid = paramString;
  }
  
  public void setNmonthSuccess(String paramString)
  {
    this.NmonthSuccess = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\score\run\ScoreRunModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */