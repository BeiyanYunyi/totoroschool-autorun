package com.totoro.school.e;

import b.a.l;
import com.totoro.school.utilpub.network.b;
import com.totoro.school.utilpub.network.c;
import retrofit2.Retrofit;

public class a
  extends b
{
  private com.totoro.school.a.a a = (com.totoro.school.a.a)c().create(com.totoro.school.a.a.class);
  
  public a(c paramc)
  {
    super(paramc);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a("auth_request_data", l.just("").concatMap(new -..Lambda.a.y5U3yC_ROQ3Xj3CDA_w_lValOIE(this, paramString1, paramString2, paramString3, paramString4, paramString5)), new com.totoro.school.utilpub.network.a(d(), "auth_request_data", "网络请求中"));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */