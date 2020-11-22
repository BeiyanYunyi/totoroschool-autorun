package com.tencent.smtt.utils;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

public class j
  implements Closeable
{
  static final char[] a = { 127, 69, 76, 70, 0 };
  final char[] b = new char[16];
  boolean c;
  j[] d;
  l[] e;
  byte[] f;
  private final c g;
  private final a h;
  private final k[] i;
  private byte[] j;
  
  public j(File paramFile)
  {
    Object localObject1 = new c(paramFile);
    this.g = ((c)localObject1);
    ((c)localObject1).a(this.b);
    if (a())
    {
      ((c)localObject1).a(e());
      boolean bool = d();
      if (bool)
      {
        paramFile = new f();
        paramFile.a = ((c)localObject1).a();
        paramFile.b = ((c)localObject1).a();
        paramFile.c = ((c)localObject1).b();
        paramFile.k = ((c)localObject1).c();
        paramFile.l = ((c)localObject1).c();
        paramFile.m = ((c)localObject1).c();
      }
      for (;;)
      {
        this.h = paramFile;
        break;
        paramFile = new b();
        paramFile.a = ((c)localObject1).a();
        paramFile.b = ((c)localObject1).a();
        paramFile.c = ((c)localObject1).b();
        paramFile.k = ((c)localObject1).b();
        paramFile.l = ((c)localObject1).b();
        paramFile.m = ((c)localObject1).b();
      }
      paramFile = this.h;
      paramFile.d = ((c)localObject1).b();
      paramFile.e = ((c)localObject1).a();
      paramFile.f = ((c)localObject1).a();
      paramFile.g = ((c)localObject1).a();
      paramFile.h = ((c)localObject1).a();
      paramFile.i = ((c)localObject1).a();
      paramFile.j = ((c)localObject1).a();
      this.i = new k[paramFile.i];
      int k = 0;
      Object localObject2;
      while (k < paramFile.i)
      {
        ((c)localObject1).a(paramFile.a() + paramFile.h * k);
        if (bool)
        {
          localObject2 = new h();
          ((h)localObject2).g = ((c)localObject1).b();
          ((h)localObject2).h = ((c)localObject1).b();
          ((h)localObject2).a = ((c)localObject1).c();
          ((h)localObject2).b = ((c)localObject1).c();
          ((h)localObject2).c = ((c)localObject1).c();
          ((h)localObject2).d = ((c)localObject1).c();
          ((h)localObject2).i = ((c)localObject1).b();
          ((h)localObject2).j = ((c)localObject1).b();
          ((h)localObject2).e = ((c)localObject1).c();
          ((h)localObject2).f = ((c)localObject1).c();
          this.i[k] = localObject2;
        }
        else
        {
          localObject2 = new d();
          ((d)localObject2).g = ((c)localObject1).b();
          ((d)localObject2).h = ((c)localObject1).b();
          ((d)localObject2).a = ((c)localObject1).b();
          ((d)localObject2).b = ((c)localObject1).b();
          ((d)localObject2).c = ((c)localObject1).b();
          ((d)localObject2).d = ((c)localObject1).b();
          ((d)localObject2).i = ((c)localObject1).b();
          ((d)localObject2).j = ((c)localObject1).b();
          ((d)localObject2).e = ((c)localObject1).b();
          ((d)localObject2).f = ((c)localObject1).b();
          this.i[k] = localObject2;
        }
        k += 1;
      }
      if ((paramFile.j > -1) && (paramFile.j < this.i.length))
      {
        localObject2 = this.i[paramFile.j];
        if (((k)localObject2).h == 3)
        {
          this.j = new byte[((k)localObject2).a()];
          ((c)localObject1).a(((k)localObject2).b());
          ((c)localObject1).a(this.j);
          if (this.c) {
            f();
          }
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Wrong string section e_shstrndx=");
        ((StringBuilder)localObject1).append(paramFile.j);
        throw new UnknownFormatConversionException(((StringBuilder)localObject1).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Invalid e_shstrndx=");
      ((StringBuilder)localObject1).append(paramFile.j);
      throw new UnknownFormatConversionException(((StringBuilder)localObject1).toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Invalid elf magic: ");
    ((StringBuilder)localObject1).append(paramFile);
    throw new UnknownFormatConversionException(((StringBuilder)localObject1).toString());
  }
  
  public static boolean a(File paramFile)
  {
    boolean bool = false;
    try
    {
      paramFile = new RandomAccessFile(paramFile, "r");
      long l = paramFile.readInt();
      paramFile.close();
      if (l == 2135247942L) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramFile)
    {
      paramFile.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(File paramFile)
  {
    if ((g()) && (a(paramFile))) {
      try
      {
        try
        {
          new j(paramFile);
        }
        catch (Throwable localThrowable)
        {
          paramFile = new StringBuilder();
          localObject = "checkElfFile Throwable: ";
        }
        catch (UnknownFormatConversionException localUnknownFormatConversionException)
        {
          paramFile = new StringBuilder();
          localObject = "checkElfFile UnknownFormatConversionException: ";
        }
        paramFile.append((String)localObject);
        paramFile.append(localUnknownFormatConversionException);
        Log.e("ELF", paramFile.toString());
      }
      catch (IOException paramFile)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkElfFile IOException: ");
        ((StringBuilder)localObject).append(paramFile);
        Log.e("ELF", ((StringBuilder)localObject).toString());
        return false;
      }
    }
    return true;
  }
  
  private void f()
  {
    a locala = this.h;
    c localc = this.g;
    boolean bool = d();
    Object localObject1 = a(".dynsym");
    int m = 0;
    if (localObject1 != null)
    {
      localc.a(((k)localObject1).b());
      int n = ((k)localObject1).a();
      if (bool) {
        k = 24;
      } else {
        k = 16;
      }
      n /= k;
      this.e = new l[n];
      char[] arrayOfChar = new char[1];
      k = 0;
      while (k < n)
      {
        Object localObject2;
        if (bool)
        {
          localObject2 = new i();
          ((i)localObject2).c = localc.b();
          localc.a(arrayOfChar);
          ((i)localObject2).d = arrayOfChar[0];
          localc.a(arrayOfChar);
          ((i)localObject2).e = arrayOfChar[0];
          ((i)localObject2).a = localc.c();
          ((i)localObject2).b = localc.c();
          ((i)localObject2).f = localc.a();
          this.e[k] = localObject2;
        }
        else
        {
          localObject2 = new e();
          ((e)localObject2).c = localc.b();
          ((e)localObject2).a = localc.b();
          ((e)localObject2).b = localc.b();
          localc.a(arrayOfChar);
          ((e)localObject2).d = arrayOfChar[0];
          localc.a(arrayOfChar);
          ((e)localObject2).e = arrayOfChar[0];
          ((e)localObject2).f = localc.a();
          this.e[k] = localObject2;
        }
        k += 1;
      }
      localObject1 = this.i[localObject1.i];
      localc.a(((k)localObject1).b());
      this.f = new byte[((k)localObject1).a()];
      localc.a(this.f);
    }
    this.d = new j[locala.g];
    int k = m;
    while (k < locala.g)
    {
      localc.a(locala.b() + locala.f * k);
      if (bool)
      {
        localObject1 = new g();
        ((g)localObject1).g = localc.b();
        ((g)localObject1).h = localc.b();
        ((g)localObject1).a = localc.c();
        ((g)localObject1).b = localc.c();
        ((g)localObject1).c = localc.c();
        ((g)localObject1).d = localc.c();
        ((g)localObject1).e = localc.c();
        ((g)localObject1).f = localc.c();
        this.d[k] = localObject1;
      }
      else
      {
        localObject1 = new c();
        ((c)localObject1).g = localc.b();
        ((c)localObject1).h = localc.b();
        ((c)localObject1).a = localc.b();
        ((c)localObject1).b = localc.b();
        ((c)localObject1).c = localc.b();
        ((c)localObject1).d = localc.b();
        ((c)localObject1).e = localc.b();
        ((c)localObject1).f = localc.b();
        this.d[k] = localObject1;
      }
      k += 1;
    }
  }
  
  private static boolean g()
  {
    String str = System.getProperty("java.vm.version");
    return (str != null) && (str.startsWith("2"));
  }
  
  public final k a(String paramString)
  {
    k[] arrayOfk = this.i;
    int m = arrayOfk.length;
    int k = 0;
    while (k < m)
    {
      k localk = arrayOfk[k];
      if (paramString.equals(a(localk.g))) {
        return localk;
      }
      k += 1;
    }
    return null;
  }
  
  public final String a(int paramInt)
  {
    if (paramInt == 0) {
      return "SHN_UNDEF";
    }
    int k = paramInt;
    while (this.j[k] != 0) {
      k += 1;
    }
    return new String(this.j, paramInt, k - paramInt);
  }
  
  final boolean a()
  {
    char[] arrayOfChar = this.b;
    boolean bool = false;
    if (arrayOfChar[0] == a[0]) {
      bool = true;
    }
    return bool;
  }
  
  final char b()
  {
    return this.b[4];
  }
  
  final char c()
  {
    return this.b[5];
  }
  
  public void close()
  {
    this.g.close();
  }
  
  public final boolean d()
  {
    return b() == '\002';
  }
  
  public final boolean e()
  {
    return c() == '\001';
  }
  
  public static abstract class a
  {
    short a;
    short b;
    int c;
    int d;
    short e;
    short f;
    short g;
    short h;
    short i;
    short j;
    
    abstract long a();
    
    abstract long b();
  }
  
  static class b
    extends j.a
  {
    int k;
    int l;
    int m;
    
    long a()
    {
      return this.m;
    }
    
    long b()
    {
      return this.l;
    }
  }
  
  static class c
    extends j.j
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
  }
  
  static class d
    extends j.k
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    
    public int a()
    {
      return this.d;
    }
    
    public long b()
    {
      return this.c;
    }
  }
  
  static class e
    extends j.l
  {
    int a;
    int b;
  }
  
  static class f
    extends j.a
  {
    long k;
    long l;
    long m;
    
    long a()
    {
      return this.m;
    }
    
    long b()
    {
      return this.l;
    }
  }
  
  static class g
    extends j.j
  {
    long a;
    long b;
    long c;
    long d;
    long e;
    long f;
  }
  
  static class h
    extends j.k
  {
    long a;
    long b;
    long c;
    long d;
    long e;
    long f;
    
    public int a()
    {
      return (int)this.d;
    }
    
    public long b()
    {
      return this.c;
    }
  }
  
  static class i
    extends j.l
  {
    long a;
    long b;
  }
  
  static abstract class j
  {
    int g;
    int h;
  }
  
  public static abstract class k
  {
    int g;
    int h;
    int i;
    int j;
    
    public abstract int a();
    
    public abstract long b();
  }
  
  static abstract class l
  {
    int c;
    char d;
    char e;
    short f;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */