package com.totoro.school.utilpub.network;

import e.b.a.a;
import e.u;
import e.x.a;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class d
{
  private static volatile d b;
  public boolean a = false;
  private Retrofit c;
  
  public static d a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new d();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void b()
  {
    Object localObject = new com.totoro.school.utilpub.network.b.a();
    localObject = new x.a().a((u)localObject).a(Proxy.NO_PROXY).a(60L, TimeUnit.SECONDS).b(60L, TimeUnit.SECONDS).c(60L, TimeUnit.SECONDS).a(true);
    if (this.a)
    {
      e.b.a locala = new e.b.a();
      locala.a(a.a.BODY);
      ((x.a)localObject).b(locala);
    }
    this.c = new Retrofit.Builder().client(((x.a)localObject).a()).baseUrl("http://md.hulaq.com:8088").addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
  }
  
  public Retrofit c()
  {
    return this.c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utilpub\network\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */