package com.totoro.school.a;

import b.a.l;
import com.totoro.school.entity.login.authentication.AuthRequestModel;
import com.totoro.school.entity.login.authentication.AuthReturnModel;
import retrofit2.http.Body;
import retrofit2.http.POST;

public abstract interface a
{
  @POST("/ydapi/CGTService.svc/authentication")
  public abstract l<AuthReturnModel> a(@Body AuthRequestModel paramAuthRequestModel);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */