package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import java.io.File;

public class az
  extends OfflineMapCity
  implements am, be
{
  public static final Parcelable.Creator<az> o = new Parcelable.Creator()
  {
    public az a(Parcel paramAnonymousParcel)
    {
      return new az(paramAnonymousParcel);
    }
    
    public az[] a(int paramAnonymousInt)
    {
      return new az[paramAnonymousInt];
    }
  };
  public final bj a = new bl(6, this);
  public final bj b = new bs(2, this);
  public final bj c = new bo(0, this);
  public final bj d = new bq(3, this);
  public final bj e = new br(1, this);
  public final bj f = new bk(4, this);
  public final bj g = new bp(7, this);
  public final bj h = new bm(-1, this);
  public final bj i = new bm(101, this);
  public final bj j = new bm(102, this);
  public final bj k = new bm(103, this);
  bj l;
  Context m;
  boolean n = false;
  private String p = null;
  private String q = "";
  private long r = 0L;
  
  public az(Context paramContext, int paramInt)
  {
    this.m = paramContext;
    a(paramInt);
  }
  
  public az(Context paramContext, OfflineMapCity paramOfflineMapCity)
  {
    this(paramContext, paramOfflineMapCity.getState());
    setCity(paramOfflineMapCity.getCity());
    setUrl(paramOfflineMapCity.getUrl());
    setState(paramOfflineMapCity.getState());
    setCompleteCode(paramOfflineMapCity.getcompleteCode());
    setAdcode(paramOfflineMapCity.getAdcode());
    setVersion(paramOfflineMapCity.getVersion());
    setSize(paramOfflineMapCity.getSize());
    setCode(paramOfflineMapCity.getCode());
    setJianpin(paramOfflineMapCity.getJianpin());
    setPinyin(paramOfflineMapCity.getPinyin());
    t();
  }
  
  public az(Parcel paramParcel)
  {
    super(paramParcel);
    this.q = paramParcel.readString();
  }
  
  private void a(final File paramFile1, File paramFile2, final String paramString)
  {
    new av().a(paramFile1, paramFile2, -1L, bc.a(paramFile1), new av.a()
    {
      public void a(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public void a(String paramAnonymousString1, String paramAnonymousString2, float paramAnonymousFloat)
      {
        int i = az.this.getcompleteCode();
        double d = paramAnonymousFloat;
        Double.isNaN(d);
        int j = (int)(d * 0.39D + 60.0D);
        if ((j - i > 0) && (System.currentTimeMillis() - az.a(az.this) > 1000L))
        {
          az.this.setCompleteCode(j);
          az.a(az.this, System.currentTimeMillis());
        }
      }
      
      public void a(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt)
      {
        az.this.l.a(az.this.k.b());
      }
      
      public void b(String paramAnonymousString1, String paramAnonymousString2)
      {
        try
        {
          if (!new File(paramString).delete()) {
            return;
          }
          bc.b(paramFile1);
          az.this.setCompleteCode(100);
          az.this.l.g();
          return;
        }
        catch (Exception paramAnonymousString1)
        {
          for (;;) {}
        }
        az.this.l.a(az.this.k.b());
      }
    });
  }
  
  public String A()
  {
    return getAdcode();
  }
  
  public String B()
  {
    return u();
  }
  
  public String C()
  {
    return v();
  }
  
  public String a()
  {
    return this.q;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          if (paramInt < 0) {
            this.l = this.h;
          }
          break;
        case 103: 
          this.l = this.k;
          break;
        case 102: 
          this.l = this.j;
          break;
        case 101: 
          this.l = this.i;
        }
        break;
      case 7: 
        this.l = this.g;
        break;
      case 6: 
        this.l = this.a;
      }
      break;
    case 4: 
      this.l = this.f;
      break;
    case 3: 
      this.l = this.d;
      break;
    case 2: 
      this.l = this.b;
      break;
    case 1: 
      this.l = this.e;
      break;
    case 0: 
      this.l = this.c;
      break;
    case -1: 
      this.l = this.h;
    }
    setState(paramInt);
  }
  
  public void a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.r > 500L)
    {
      int i1 = (int)paramLong;
      if (i1 > getcompleteCode())
      {
        setCompleteCode(i1);
        d();
      }
      this.r = l1;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    int i1 = (int)(paramLong2 * 100L / paramLong1);
    if (i1 != getcompleteCode())
    {
      setCompleteCode(i1);
      d();
    }
  }
  
  public void a(bg.a parama)
  {
    int i1;
    switch (3.a[parama.ordinal()])
    {
    default: 
      i1 = 6;
      break;
    case 3: 
      i1 = this.i.b();
      break;
    case 2: 
      i1 = this.k.b();
      break;
    case 1: 
      i1 = this.j.b();
    }
    if ((!this.l.equals(this.c)) && (!this.l.equals(this.b))) {
      return;
    }
    this.l.a(i1);
  }
  
  public void a(bj parambj)
  {
    this.l = parambj;
    setState(parambj.b());
  }
  
  public void a(String paramString)
  {
    this.q = paramString;
  }
  
  public bj b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.h;
    case 103: 
      return this.k;
    case 102: 
      return this.j;
    }
    return this.i;
  }
  
  public String b()
  {
    return getUrl();
  }
  
  public void b(String paramString)
  {
    this.l.equals(this.e);
    this.q = paramString;
    paramString = u();
    Object localObject1 = v();
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("/");
      localObject1 = new File(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(dx.a(this.m));
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("map/");
      localObject2 = new File(((StringBuilder)localObject2).toString());
      File localFile = new File(dx.a(this.m));
      if ((!localFile.exists()) && (!localFile.mkdir())) {
        return;
      }
      if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdir())) {
        return;
      }
      a((File)localObject1, (File)localObject2, paramString);
      return;
    }
    r();
  }
  
  public bj c()
  {
    return this.l;
  }
  
  public void d()
  {
    ae localae = ae.a(this.m);
    if (localae != null) {
      localae.c(this);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e()
  {
    ae localae = ae.a(this.m);
    if (localae != null)
    {
      localae.e(this);
      d();
    }
  }
  
  public void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CityOperation current State==>");
    localStringBuilder.append(c().b());
    bc.a(localStringBuilder.toString());
    if (this.l.equals(this.d))
    {
      this.l.d();
      return;
    }
    if (this.l.equals(this.c))
    {
      this.l.e();
      return;
    }
    if ((!this.l.equals(this.g)) && (!this.l.equals(this.h)))
    {
      if ((!this.l.equals(this.j)) && (!this.l.equals(this.i)) && (!this.l.a(this.k)))
      {
        c().h();
        return;
      }
      this.l.c();
      return;
    }
    k();
    this.n = true;
  }
  
  public void g()
  {
    this.l.e();
  }
  
  public void h()
  {
    this.l.a(this.k.b());
  }
  
  public void i()
  {
    this.l.a();
    if (this.n) {
      this.l.h();
    }
    this.n = false;
  }
  
  public void j()
  {
    this.l.equals(this.f);
    this.l.f();
  }
  
  public void k()
  {
    ae localae = ae.a(this.m);
    if (localae != null) {
      localae.a(this);
    }
  }
  
  public void l()
  {
    ae localae = ae.a(this.m);
    if (localae != null) {
      localae.b(this);
    }
  }
  
  public void m()
  {
    ae localae = ae.a(this.m);
    if (localae != null) {
      localae.d(this);
    }
  }
  
  public void n()
  {
    this.r = 0L;
    if (!this.l.equals(this.b)) {
      bc.a("state must be waiting when download onStart");
    }
    this.l.c();
  }
  
  public void o()
  {
    if (!this.l.equals(this.c)) {
      bc.a("state must be Loading when download onFinish");
    }
    this.l.g();
  }
  
  public void p()
  {
    e();
  }
  
  public void q()
  {
    this.r = 0L;
    setCompleteCode(0);
    this.l.equals(this.e);
    this.l.c();
  }
  
  public void r()
  {
    this.l.equals(this.e);
    this.l.a(this.h.b());
  }
  
  public void s()
  {
    e();
  }
  
  protected void t()
  {
    String str = ae.a;
    Object localObject = bc.c(getUrl());
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(".zip.tmp");
      this.p = localStringBuilder.toString();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(getPinyin());
    ((StringBuilder)localObject).append(".zip.tmp");
    this.p = ((StringBuilder)localObject).toString();
  }
  
  public String u()
  {
    if (TextUtils.isEmpty(this.p)) {
      return null;
    }
    return this.p.substring(0, this.p.lastIndexOf("."));
  }
  
  public String v()
  {
    if (TextUtils.isEmpty(this.p)) {
      return null;
    }
    String str = u();
    return str.substring(0, str.lastIndexOf('.'));
  }
  
  public boolean w()
  {
    double d1 = bc.a();
    double d2 = getSize();
    Double.isNaN(d2);
    double d3 = getcompleteCode() * getSize();
    Double.isNaN(d3);
    return d1 >= d2 * 2.5D - d3;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.q);
  }
  
  public ao x()
  {
    setState(this.l.b());
    ao localao = new ao(this, this.m);
    localao.a(a());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vMapFileNames: ");
    localStringBuilder.append(a());
    bc.a(localStringBuilder.toString());
    return localao;
  }
  
  public boolean y()
  {
    return w();
  }
  
  public String z()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = bc.c(getUrl());
    if (str != null) {
      localStringBuffer.append(str);
    } else {
      localStringBuffer.append(getPinyin());
    }
    localStringBuffer.append(".zip");
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */