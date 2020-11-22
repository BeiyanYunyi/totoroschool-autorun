package com.totoro.school.utilpub.network;

import b.a.l;
import b.a.s;
import com.totoro.school.MyApplication;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import retrofit2.Retrofit;

public class b
{
  private final long a = 500L;
  private HashMap<String, Long> b = new HashMap();
  private WeakReference<c> c;
  
  public b(c paramc)
  {
    this.c = new WeakReference(paramc);
  }
  
  public void a(String paramString, l paraml, s params)
  {
    if (com.totoro.school.utilpub.network.a.c.a(MyApplication.a()) == 0)
    {
      d().d_();
      d().a(paramString, new Exception("网络未连接"));
    }
    long l = System.currentTimeMillis();
    if ((b()) && (this.b.containsKey(paramString)) && (this.b.get(paramString) != null) && (l - ((Long)this.b.get(paramString)).longValue() <= 500L)) {
      return;
    }
    this.b.put(paramString, Long.valueOf(l));
    paraml.subscribeOn(b.a.i.a.b()).observeOn(b.a.a.b.a.a()).subscribe(params);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public Retrofit c()
  {
    return d.a().c();
  }
  
  public c d()
  {
    return (c)this.c.get();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utilpub\network\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */