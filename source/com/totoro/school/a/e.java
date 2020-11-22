package com.totoro.school.a;

import b.a.l;
import com.totoro.school.entity.morning.exercise.MorningExerciseRequestModel;
import com.totoro.school.entity.morning.exercise.MorningExerciseReturnModel;
import com.totoro.school.entity.morning.helpCode.HelpCodeRequestModel;
import com.totoro.school.entity.morning.helpCode.HelpCodeReturnModel;
import com.totoro.school.entity.morning.helpSign.HelpSignRequestModel;
import com.totoro.school.entity.morning.helpSign.HelpSignReturnModel;
import com.totoro.school.entity.morning.qrCode.QrCodeRequestModel;
import com.totoro.school.entity.morning.qrCode.QrCodeReturnModel;
import com.totoro.school.entity.morning.taskPoint.TaskPointRequestModel;
import com.totoro.school.entity.morning.taskPoint.TaskPointReturnModel;
import retrofit2.http.Body;
import retrofit2.http.POST;

public abstract interface e
{
  @POST("/ydapi/CGTService.svc/morningExercises")
  public abstract l<MorningExerciseReturnModel> a(@Body MorningExerciseRequestModel paramMorningExerciseRequestModel);
  
  @POST("/ydapi/CGTService.svc/helpQrCode")
  public abstract l<HelpCodeReturnModel> a(@Body HelpCodeRequestModel paramHelpCodeRequestModel);
  
  @POST("/ydapi/CGTService.svc/helpmorningExercises")
  public abstract l<HelpSignReturnModel> a(@Body HelpSignRequestModel paramHelpSignRequestModel);
  
  @POST("/ydapi/CGTService.svc/getQrCode")
  public abstract l<QrCodeReturnModel> a(@Body QrCodeRequestModel paramQrCodeRequestModel);
  
  @POST("/ydapi/CGTService.svc/queryTaskPointList")
  public abstract l<TaskPointReturnModel> a(@Body TaskPointRequestModel paramTaskPointRequestModel);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */