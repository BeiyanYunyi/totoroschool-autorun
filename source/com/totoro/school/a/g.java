package com.totoro.school.a;

import b.a.l;
import com.totoro.school.entity.score.morning.ScoreMorningRequestModel;
import com.totoro.school.entity.score.morning.ScoreMorningReturnModel;
import com.totoro.school.entity.score.run.ScoreRunRequestModel;
import com.totoro.school.entity.score.run.ScoreRunReturnModel;
import com.totoro.school.entity.score.term.SchoolTermRequestModel;
import com.totoro.school.entity.score.term.SchoolTermReturnModel;
import com.totoro.school.entity.score.test.ScoreTestRequestModel;
import com.totoro.school.entity.score.test.ScoreTestReturnModel;
import com.totoro.school.entity.score.year.SchoolYearRequestModel;
import com.totoro.school.entity.score.year.SchoolYearReturnModel;
import retrofit2.http.Body;
import retrofit2.http.POST;

public abstract interface g
{
  @POST("/ydapi/CGTService.svc/morning_query")
  public abstract l<ScoreMorningReturnModel> a(@Body ScoreMorningRequestModel paramScoreMorningRequestModel);
  
  @POST("/ydapi/CGTService.svc/run_query")
  public abstract l<ScoreRunReturnModel> a(@Body ScoreRunRequestModel paramScoreRunRequestModel);
  
  @POST("/ydapi/CGTService.svc/querySchoolterm")
  public abstract l<SchoolTermReturnModel> a(@Body SchoolTermRequestModel paramSchoolTermRequestModel);
  
  @POST("/ydapi/CGTService.svc/tcscore_query")
  public abstract l<ScoreTestReturnModel> a(@Body ScoreTestRequestModel paramScoreTestRequestModel);
  
  @POST("/ydapi/CGTService.svc/querySchoolyear")
  public abstract l<SchoolYearReturnModel> a(@Body SchoolYearRequestModel paramSchoolYearRequestModel);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */