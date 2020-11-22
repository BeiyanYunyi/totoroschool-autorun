package com.totoro.school.e;

import android.content.Context;
import b.a.l;
import com.totoro.school.entity.run.reg.RunRegRequestModel;
import com.totoro.school.utilpub.network.a;
import com.totoro.school.utilpub.network.b;
import com.totoro.school.utilpub.network.c;
import retrofit2.Retrofit;

public class f
  extends b
{
  private com.totoro.school.a.f a = (com.totoro.school.a.f)c().create(com.totoro.school.a.f.class);
  
  public f(c paramc)
  {
    super(paramc);
  }
  
  public void a(RunRegRequestModel paramRunRegRequestModel, Context paramContext)
  {
    a("run_reg", l.just("").concatMap(new -..Lambda.f.kQ8HPu4tYqA9OaCJHkkZa_6TX9A(this, paramRunRegRequestModel, paramContext)), new a(d(), "run_reg", "网络请求中"));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a("route_point_list", l.just("").concatMap(new -..Lambda.f.hmsyffBPQULcjShetkArUtQHLgA(this, paramString1, paramString2, paramString3, paramString4)), new a(d(), "route_point_list", "网络请求中"));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */