package com.totoro.school.entity.score.test;

public class ScoreTestModel
{
  private String score;
  private String tc_item;
  
  public ScoreTestModel(String paramString1, String paramString2)
  {
    this.tc_item = paramString1;
    this.score = paramString2;
  }
  
  public String getScore()
  {
    return this.score;
  }
  
  public String getTc_item()
  {
    return this.tc_item;
  }
  
  public void setScore(String paramString)
  {
    this.score = paramString;
  }
  
  public void setTc_item(String paramString)
  {
    this.tc_item = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\score\test\ScoreTestModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */