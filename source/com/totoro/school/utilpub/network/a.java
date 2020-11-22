package com.totoro.school.utilpub.network;

import android.util.Log;
import b.a.b.b;
import b.a.s;

public class a
  implements s
{
  private static final String a = "a";
  private String b;
  private c c;
  private String d;
  
  public a(c paramc, String paramString1, String paramString2)
  {
    this.c = paramc;
    this.b = paramString1;
    this.d = paramString2;
  }
  
  public void onComplete() {}
  
  public void onError(Throwable paramThrowable)
  {
    if (d.a().a)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onError path:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" e.getMessage():");
      localStringBuilder.append(paramThrowable.getMessage());
      Log.e(str, localStringBuilder.toString());
    }
    if (this.c != null)
    {
      this.c.d_();
      this.c.a(this.b, paramThrowable);
    }
  }
  
  public void onNext(Object paramObject)
  {
    if (d.a().a)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNext path:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" o:");
      localStringBuilder.append(paramObject);
      Log.i(str, localStringBuilder.toString());
    }
    if (this.c != null)
    {
      this.c.d_();
      this.c.a(this.b, paramObject);
    }
  }
  
  public void onSubscribe(b paramb)
  {
    if (this.c != null) {
      this.c.a_(this.d);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utilpub\network\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */