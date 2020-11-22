package com.totoro.school.a;

import b.a.l;
import com.totoro.school.entity.common.campus.GetCampusListRequestModel;
import com.totoro.school.entity.common.campus.GetCampusListReturnModel;
import com.totoro.school.entity.common.school.GetSchoolListReturnModel;
import com.totoro.school.entity.common.verificationcode.VerificationCodeRequestModel;
import com.totoro.school.entity.common.verificationcode.VerificationCodeReturnModel;
import com.totoro.school.entity.find.MainHomePageReturnModel;
import com.totoro.school.entity.update.UpdateAppReturnModel;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public abstract interface b
{
  @POST("/ydapi/CGTService.svc/getSchool")
  public abstract l<GetSchoolListReturnModel> a();
  
  @POST("/ydapi/CGTService.svc/getSchool_Campus")
  public abstract l<GetCampusListReturnModel> a(@Body GetCampusListRequestModel paramGetCampusListRequestModel);
  
  @POST("/ydapi/CGTService.svc/get_verificationCode")
  public abstract l<VerificationCodeReturnModel> a(@Body VerificationCodeRequestModel paramVerificationCodeRequestModel);
  
  @GET("http://news.xtotoro.com:50001/school/filter/version")
  public abstract l<UpdateAppReturnModel> a(@Query("type") String paramString)
    throws RuntimeException;
  
  @GET("http://news.xtotoro.com:50001/school/homePage/homePageAppList")
  public abstract l<MainHomePageReturnModel> a(@Query("rowNumber") String paramString1, @Query("pageNumber") String paramString2, @Query("schoolId") String paramString3, @Query("schoolFlag") String paramString4)
    throws RuntimeException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */