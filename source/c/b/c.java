package c.b;

import c.b.a.a;
import c.b.a.b;
import java.security.AccessControlException;

public abstract class c
{
  private static c a;
  
  public static final c a(Class paramClass)
  {
    if (a == null) {
      a();
    }
    return a.b(paramClass);
  }
  
  private static void a()
  {
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      label93:
      label147:
      label200:
      label253:
      label303:
      try
      {
        localObject1 = a;
        if (localObject1 != null) {
          return;
        }
        localObject1 = a.a;
        localObject3 = localObject1;
        localObject4 = localObject1;
        localObject5 = localObject1;
        localObject6 = localObject1;
      }
      finally {}
      try
      {
        localObject1 = System.getProperty("logger");
        if (localObject1 != null) {}
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        continue;
      }
      catch (InstantiationException localInstantiationException1)
      {
        continue;
      }
      catch (AccessControlException localAccessControlException1)
      {
        continue;
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        continue;
      }
      try
      {
        localObject3 = a.a;
        localObject1 = localObject3;
      }
      catch (IllegalAccessException localIllegalAccessException2) {}catch (InstantiationException localInstantiationException2) {}catch (AccessControlException localAccessControlException2) {}catch (ClassNotFoundException localClassNotFoundException2) {}
    }
    localObject6 = localObject1;
    break label93;
    localObject5 = localObject1;
    break label147;
    localObject4 = localObject1;
    break label200;
    localObject3 = localObject1;
    break label253;
    localObject3 = localObject1;
    localObject4 = localObject1;
    localObject5 = localObject1;
    localObject6 = localObject1;
    a = (c)Class.forName((String)localObject1).newInstance();
    break label303;
    a = new b();
    localObject1 = a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("Could not instantiate logger ");
    ((StringBuilder)localObject3).append((String)localObject6);
    ((StringBuilder)localObject3).append(" using default");
    ((c)localObject1).b(((StringBuilder)localObject3).toString());
    break label303;
    a = new b();
    localObject1 = a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("Could not instantiate logger ");
    ((StringBuilder)localObject3).append((String)localObject5);
    ((StringBuilder)localObject3).append(" using default");
    ((c)localObject1).b(((StringBuilder)localObject3).toString());
    break label303;
    a = new b();
    localObject1 = a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("Could not instantiate logger ");
    ((StringBuilder)localObject3).append((String)localObject4);
    ((StringBuilder)localObject3).append(" using default");
    ((c)localObject1).b(((StringBuilder)localObject3).toString());
    break label303;
    a = new b();
    localObject1 = a;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("Could not instantiate logger ");
    ((StringBuilder)localObject4).append((String)localObject3);
    ((StringBuilder)localObject4).append(" using default");
    ((c)localObject1).b(((StringBuilder)localObject4).toString());
  }
  
  public abstract void a(Object paramObject);
  
  public abstract void a(Object paramObject, Throwable paramThrowable);
  
  public void a(boolean paramBoolean) {}
  
  protected abstract c b(Class paramClass);
  
  public abstract void b(Object paramObject);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */