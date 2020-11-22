package com.totoro.school.a;

import b.a.l;
import com.totoro.school.entity.run.reg.RunRegRequestModel;
import com.totoro.school.entity.run.reg.RunRegReturnModel;
import com.totoro.school.entity.run.routePoint.RoutePointRequestModel;
import com.totoro.school.entity.run.routePoint.RoutePointReturnModel;
import retrofit2.http.Body;
import retrofit2.http.POST;

public abstract interface f
{
  @POST("/ydapi/CGTService.svc/runRegExercises")
  public abstract l<RunRegReturnModel> a(@Body RunRegRequestModel paramRunRegRequestModel);
  
  @POST("/ydapi/CGTService.svc/queryRunRoutePointList")
  public abstract l<RoutePointReturnModel> a(@Body RoutePointRequestModel paramRoutePointRequestModel);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */