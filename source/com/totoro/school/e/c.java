package com.totoro.school.e;

import android.content.Context;
import b.a.l;
import com.totoro.school.entity.login.password.change.ChangePasswordRequestModel;
import com.totoro.school.entity.mine.changephone.ChangePhoneRequestModel;
import com.totoro.school.entity.mine.personal.PersonalDataRequestModel;
import com.totoro.school.utilpub.network.a;
import com.totoro.school.utilpub.network.b;
import retrofit2.Retrofit;

public class c
  extends b
{
  private com.totoro.school.a.c a = (com.totoro.school.a.c)c().create(com.totoro.school.a.c.class);
  
  public c(com.totoro.school.utilpub.network.c paramc)
  {
    super(paramc);
  }
  
  public void a(ChangePasswordRequestModel paramChangePasswordRequestModel)
  {
    a("changePassword", l.just("").concatMap(new -..Lambda.c.02yESvgAojUbzRbkjeY6uADM6Ic(this, paramChangePasswordRequestModel)), new a(d(), "changePassword", "网络请求中"));
  }
  
  public void a(ChangePhoneRequestModel paramChangePhoneRequestModel)
  {
    a("change_phone", l.just("").concatMap(new -..Lambda.c.WuRQm8ZdsDVymd7sIYTiGq-Vs7Y(this, paramChangePhoneRequestModel)), new a(d(), "change_phone", "网络请求中"));
  }
  
  public void a(PersonalDataRequestModel paramPersonalDataRequestModel)
  {
    a("get_stu_info", l.just("").concatMap(new -..Lambda.c.bwf3ZENyvOosUisoQcrWs40GLqk(this, paramPersonalDataRequestModel)), new a(d(), "get_stu_info", "网络请求中"));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    a("login_request", l.just("").concatMap(new -..Lambda.c.rRrTluzJiZBvUrAXARlynCKDNCI(this, paramString1, paramString2, paramString3, paramContext)), new a(d(), "login_request", "网络请求中"));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a("forgetPassword", l.just("").concatMap(new -..Lambda.c.mYLNpxn-ShcgWmetlup8GS_uHSY(this, paramString1, paramString2, paramString3, paramString4)), new a(d(), "forgetPassword", "网络请求中"));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, Context paramContext)
  {
    a("register", l.just("").concatMap(new -..Lambda.c.DCPnAdRkL13OqbnLxVbcQ9xxQ84(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramContext)), new a(d(), "register", "网络请求中"));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */