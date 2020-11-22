package com.totoro.school.e;

import b.a.l;
import com.totoro.school.utilpub.network.a;
import com.totoro.school.utilpub.network.c;
import retrofit2.Retrofit;

public class b
  extends com.totoro.school.utilpub.network.b
{
  private com.totoro.school.a.b a = (com.totoro.school.a.b)c().create(com.totoro.school.a.b.class);
  
  public b(c paramc)
  {
    super(paramc);
  }
  
  public void a()
  {
    a("update_app", l.just("").concatMap(new -..Lambda.b.u7NQbU7b0gh6ETWshvhSD8CXdHg(this)), new a(d(), "update_app", "网络请求中"));
  }
  
  public void a(String paramString)
  {
    a("get_verification_code", l.just("").concatMap(new -..Lambda.b.NBQhYlYa4IUOgFDi1Mkeg2gKNAg(this, paramString)), new a(d(), "get_verification_code", "网络请求中"));
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a("get_school_list", l.just("").concatMap(new -..Lambda.b.SE0teZqonbHmpA2i1t30xlKPM0o(this, paramString1, paramString2, paramString3)), new a(d(), "get_school_list", "网络请求中"));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a("get_home_page", l.just("").concatMap(new -..Lambda.b.iG4D_SMXGdZ2TQ5_KfViK71hjXo(this, paramString1, paramString2, paramString3, paramString4)), new a(d(), "get_home_page", "网络请求中"));
  }
  
  public void b(String paramString)
  {
    a("get_campus_list", l.just("").concatMap(new -..Lambda.b.Uiohq5aJ_o2pnYE5pHQp93S0roo(this, paramString)), new a(d(), "get_campus_list", "网络请求中"));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */