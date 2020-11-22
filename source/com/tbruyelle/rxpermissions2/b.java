package com.tbruyelle.rxpermissions2;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import b.a.d.h;
import b.a.l;
import b.a.q;
import b.a.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  static final String a = "b";
  static final Object b = new Object();
  @VisibleForTesting
  a<RxPermissionsFragment> c = a(paramFragmentActivity.getSupportFragmentManager());
  
  public b(@NonNull FragmentActivity paramFragmentActivity) {}
  
  private l<?> a(l<?> paraml1, l<?> paraml2)
  {
    if (paraml1 == null) {
      return l.just(b);
    }
    return l.merge(paraml1, paraml2);
  }
  
  private l<a> a(l<?> paraml, final String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
      a(paraml, d(paramVarArgs)).flatMap(new h()
      {
        public l<a> a(Object paramAnonymousObject)
        {
          return b.a(b.this, paramVarArgs);
        }
      });
    }
    throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
  }
  
  @NonNull
  private a<RxPermissionsFragment> a(@NonNull final FragmentManager paramFragmentManager)
  {
    new a()
    {
      private RxPermissionsFragment c;
      
      public RxPermissionsFragment a()
      {
        try
        {
          if (this.c == null) {
            this.c = b.a(b.this, paramFragmentManager);
          }
          RxPermissionsFragment localRxPermissionsFragment = this.c;
          return localRxPermissionsFragment;
        }
        finally {}
      }
    };
  }
  
  private RxPermissionsFragment b(@NonNull FragmentManager paramFragmentManager)
  {
    RxPermissionsFragment localRxPermissionsFragment = c(paramFragmentManager);
    int i;
    if (localRxPermissionsFragment == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localRxPermissionsFragment = new RxPermissionsFragment();
      paramFragmentManager.beginTransaction().add(localRxPermissionsFragment, a).commitNow();
    }
    return localRxPermissionsFragment;
  }
  
  private RxPermissionsFragment c(@NonNull FragmentManager paramFragmentManager)
  {
    return (RxPermissionsFragment)paramFragmentManager.findFragmentByTag(a);
  }
  
  private l<?> d(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (!((RxPermissionsFragment)this.c.b()).d(str)) {
        return l.empty();
      }
      i += 1;
    }
    return l.just(b);
  }
  
  @TargetApi(23)
  private l<a> e(String... paramVarArgs)
  {
    ArrayList localArrayList1 = new ArrayList(paramVarArgs.length);
    ArrayList localArrayList2 = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      Object localObject1 = (RxPermissionsFragment)this.c.b();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Requesting permission ");
      ((StringBuilder)localObject2).append(str);
      ((RxPermissionsFragment)localObject1).e(((StringBuilder)localObject2).toString());
      if (a(str))
      {
        localArrayList1.add(l.just(new a(str, true, false)));
      }
      else if (b(str))
      {
        localArrayList1.add(l.just(new a(str, false, false)));
      }
      else
      {
        localObject2 = ((RxPermissionsFragment)this.c.b()).c(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localArrayList2.add(str);
          localObject1 = b.a.j.a.a();
          ((RxPermissionsFragment)this.c.b()).a(str, (b.a.j.a)localObject1);
        }
        localArrayList1.add(localObject1);
      }
      i += 1;
    }
    if (!localArrayList2.isEmpty()) {
      c((String[])localArrayList2.toArray(new String[localArrayList2.size()]));
    }
    return l.concat(l.fromIterable(localArrayList1));
  }
  
  public <T> r<T, Boolean> a(final String... paramVarArgs)
  {
    new r()
    {
      public q<Boolean> a(l<T> paramAnonymousl)
      {
        b.a(b.this, paramAnonymousl, paramVarArgs).buffer(paramVarArgs.length).flatMap(new h()
        {
          public q<Boolean> a(List<a> paramAnonymous2List)
          {
            if (paramAnonymous2List.isEmpty()) {
              return l.empty();
            }
            paramAnonymous2List = paramAnonymous2List.iterator();
            while (paramAnonymous2List.hasNext()) {
              if (!((a)paramAnonymous2List.next()).b) {
                return l.just(Boolean.valueOf(false));
              }
            }
            return l.just(Boolean.valueOf(true));
          }
        });
      }
    };
  }
  
  boolean a()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public boolean a(String paramString)
  {
    return (!a()) || (((RxPermissionsFragment)this.c.b()).a(paramString));
  }
  
  public l<Boolean> b(String... paramVarArgs)
  {
    return l.just(b).compose(a(paramVarArgs));
  }
  
  public boolean b(String paramString)
  {
    return (a()) && (((RxPermissionsFragment)this.c.b()).b(paramString));
  }
  
  @TargetApi(23)
  void c(String[] paramArrayOfString)
  {
    RxPermissionsFragment localRxPermissionsFragment = (RxPermissionsFragment)this.c.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestPermissionsFromFragment ");
    localStringBuilder.append(TextUtils.join(", ", paramArrayOfString));
    localRxPermissionsFragment.e(localStringBuilder.toString());
    ((RxPermissionsFragment)this.c.b()).a(paramArrayOfString);
  }
  
  @FunctionalInterface
  public static abstract interface a<V>
  {
    public abstract V b();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tbruyelle\rxpermissions2\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */