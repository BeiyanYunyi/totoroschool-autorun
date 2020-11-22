package com.totoro.school.a;

import b.a.l;
import com.totoro.school.entity.login.login.LoginRequestModel;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.entity.login.password.change.ChangePasswordRequestModel;
import com.totoro.school.entity.login.password.change.ChangePasswordReturnModel;
import com.totoro.school.entity.login.password.forget.ForgetPasswordRequestModel;
import com.totoro.school.entity.login.password.forget.ForgetPasswordReturnModel;
import com.totoro.school.entity.login.register.RegisterRequestModel;
import com.totoro.school.entity.login.register.RegisterReturnModel;
import com.totoro.school.entity.mine.changephone.ChangePhoneRequestModel;
import com.totoro.school.entity.mine.changephone.ChangePhoneReturnModel;
import com.totoro.school.entity.mine.personal.PersonalDataRequestModel;
import com.totoro.school.entity.mine.personal.PersonalDataReturnModel;
import retrofit2.http.Body;
import retrofit2.http.POST;

public abstract interface c
{
  @POST("/ydapi/CGTService.svc/login")
  public abstract l<LoginReturnModel> a(@Body LoginRequestModel paramLoginRequestModel);
  
  @POST("/ydapi/CGTService.svc/changePassword")
  public abstract l<ChangePasswordReturnModel> a(@Body ChangePasswordRequestModel paramChangePasswordRequestModel);
  
  @POST("/ydapi/CGTService.svc/forgetPassword")
  public abstract l<ForgetPasswordReturnModel> a(@Body ForgetPasswordRequestModel paramForgetPasswordRequestModel);
  
  @POST("/ydapi/CGTService.svc/register")
  public abstract l<RegisterReturnModel> a(@Body RegisterRequestModel paramRegisterRequestModel);
  
  @POST("/ydapi/CGTService.svc/phoneChange")
  public abstract l<ChangePhoneReturnModel> a(@Body ChangePhoneRequestModel paramChangePhoneRequestModel);
  
  @POST("/ydapi/CGTService.svc/GetStudentInfo")
  public abstract l<PersonalDataReturnModel> a(@Body PersonalDataRequestModel paramPersonalDataRequestModel);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */