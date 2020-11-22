package com.bumptech.glide.load.b;

import com.bumptech.glide.load.b;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.g;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

class f
  implements com.bumptech.glide.load.c
{
  private final String a;
  private final int b;
  private final int c;
  private final e d;
  private final e e;
  private final g f;
  private final com.bumptech.glide.load.f g;
  private final com.bumptech.glide.load.resource.e.c h;
  private final b i;
  private final com.bumptech.glide.load.c j;
  private String k;
  private int l;
  private com.bumptech.glide.load.c m;
  
  public f(String paramString, com.bumptech.glide.load.c paramc, int paramInt1, int paramInt2, e parame1, e parame2, g paramg, com.bumptech.glide.load.f paramf, com.bumptech.glide.load.resource.e.c paramc1, b paramb)
  {
    this.a = paramString;
    this.j = paramc;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = parame1;
    this.e = parame2;
    this.f = paramg;
    this.g = paramf;
    this.h = paramc1;
    this.i = paramb;
  }
  
  public com.bumptech.glide.load.c a()
  {
    if (this.m == null) {
      this.m = new j(this.a, this.j);
    }
    return this.m;
  }
  
  public void a(MessageDigest paramMessageDigest)
    throws UnsupportedEncodingException
  {
    Object localObject = ByteBuffer.allocate(8).putInt(this.b).putInt(this.c).array();
    this.j.a(paramMessageDigest);
    paramMessageDigest.update(this.a.getBytes("UTF-8"));
    paramMessageDigest.update((byte[])localObject);
    if (this.d != null) {
      localObject = this.d.a();
    } else {
      localObject = "";
    }
    paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
    if (this.e != null) {
      localObject = this.e.a();
    } else {
      localObject = "";
    }
    paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
    if (this.f != null) {
      localObject = this.f.a();
    } else {
      localObject = "";
    }
    paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
    if (this.g != null) {
      localObject = this.g.a();
    } else {
      localObject = "";
    }
    paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
    if (this.i != null) {
      localObject = this.i.a();
    } else {
      localObject = "";
    }
    paramMessageDigest.update(((String)localObject).getBytes("UTF-8"));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (f)paramObject;
      if (!this.a.equals(((f)paramObject).a)) {
        return false;
      }
      if (!this.j.equals(((f)paramObject).j)) {
        return false;
      }
      if (this.c != ((f)paramObject).c) {
        return false;
      }
      if (this.b != ((f)paramObject).b) {
        return false;
      }
      int n;
      if (this.f == null) {
        n = 1;
      } else {
        n = 0;
      }
      int i1;
      if (((f)paramObject).f == null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((n ^ i1) != 0) {
        return false;
      }
      if ((this.f != null) && (!this.f.a().equals(((f)paramObject).f.a()))) {
        return false;
      }
      if (this.e == null) {
        n = 1;
      } else {
        n = 0;
      }
      if (((f)paramObject).e == null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((n ^ i1) != 0) {
        return false;
      }
      if ((this.e != null) && (!this.e.a().equals(((f)paramObject).e.a()))) {
        return false;
      }
      if (this.d == null) {
        n = 1;
      } else {
        n = 0;
      }
      if (((f)paramObject).d == null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((n ^ i1) != 0) {
        return false;
      }
      if ((this.d != null) && (!this.d.a().equals(((f)paramObject).d.a()))) {
        return false;
      }
      if (this.g == null) {
        n = 1;
      } else {
        n = 0;
      }
      if (((f)paramObject).g == null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((n ^ i1) != 0) {
        return false;
      }
      if ((this.g != null) && (!this.g.a().equals(((f)paramObject).g.a()))) {
        return false;
      }
      if (this.h == null) {
        n = 1;
      } else {
        n = 0;
      }
      if (((f)paramObject).h == null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((n ^ i1) != 0) {
        return false;
      }
      if ((this.h != null) && (!this.h.a().equals(((f)paramObject).h.a()))) {
        return false;
      }
      if (this.i == null) {
        n = 1;
      } else {
        n = 0;
      }
      if (((f)paramObject).i == null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((n ^ i1) != 0) {
        return false;
      }
      return (this.i == null) || (this.i.a().equals(((f)paramObject).i.a()));
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.l == 0)
    {
      this.l = this.a.hashCode();
      this.l = (this.l * 31 + this.j.hashCode());
      this.l = (this.l * 31 + this.b);
      this.l = (this.l * 31 + this.c);
      int i2 = this.l;
      e locale = this.d;
      int i1 = 0;
      if (locale != null) {
        n = this.d.a().hashCode();
      } else {
        n = 0;
      }
      this.l = (i2 * 31 + n);
      i2 = this.l;
      if (this.e != null) {
        n = this.e.a().hashCode();
      } else {
        n = 0;
      }
      this.l = (i2 * 31 + n);
      i2 = this.l;
      if (this.f != null) {
        n = this.f.a().hashCode();
      } else {
        n = 0;
      }
      this.l = (i2 * 31 + n);
      i2 = this.l;
      if (this.g != null) {
        n = this.g.a().hashCode();
      } else {
        n = 0;
      }
      this.l = (i2 * 31 + n);
      i2 = this.l;
      if (this.h != null) {
        n = this.h.a().hashCode();
      } else {
        n = 0;
      }
      this.l = (i2 * 31 + n);
      i2 = this.l;
      int n = i1;
      if (this.i != null) {
        n = this.i.a().hashCode();
      }
      this.l = (i2 * 31 + n);
    }
    return this.l;
  }
  
  public String toString()
  {
    if (this.k == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EngineKey{");
      localStringBuilder.append(this.a);
      localStringBuilder.append('+');
      localStringBuilder.append(this.j);
      localStringBuilder.append("+[");
      localStringBuilder.append(this.b);
      localStringBuilder.append('x');
      localStringBuilder.append(this.c);
      localStringBuilder.append("]+");
      localStringBuilder.append('\'');
      String str;
      if (this.d != null) {
        str = this.d.a();
      } else {
        str = "";
      }
      localStringBuilder.append(str);
      localStringBuilder.append('\'');
      localStringBuilder.append('+');
      localStringBuilder.append('\'');
      if (this.e != null) {
        str = this.e.a();
      } else {
        str = "";
      }
      localStringBuilder.append(str);
      localStringBuilder.append('\'');
      localStringBuilder.append('+');
      localStringBuilder.append('\'');
      if (this.f != null) {
        str = this.f.a();
      } else {
        str = "";
      }
      localStringBuilder.append(str);
      localStringBuilder.append('\'');
      localStringBuilder.append('+');
      localStringBuilder.append('\'');
      if (this.g != null) {
        str = this.g.a();
      } else {
        str = "";
      }
      localStringBuilder.append(str);
      localStringBuilder.append('\'');
      localStringBuilder.append('+');
      localStringBuilder.append('\'');
      if (this.h != null) {
        str = this.h.a();
      } else {
        str = "";
      }
      localStringBuilder.append(str);
      localStringBuilder.append('\'');
      localStringBuilder.append('+');
      localStringBuilder.append('\'');
      if (this.i != null) {
        str = this.i.a();
      } else {
        str = "";
      }
      localStringBuilder.append(str);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      this.k = localStringBuilder.toString();
    }
    return this.k;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */