package androidx.versionedparcelable;

import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract class a
{
  protected static <T extends c> T a(String paramString, a parama)
  {
    try
    {
      paramString = (c)Class.forName(paramString, true, a.class.getClassLoader()).getDeclaredMethod("read", new Class[] { a.class }).invoke(null, new Object[] { parama });
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", paramString);
    }
    catch (NoSuchMethodException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", paramString);
    }
    catch (InvocationTargetException paramString)
    {
      if ((paramString.getCause() instanceof RuntimeException)) {
        throw ((RuntimeException)paramString.getCause());
      }
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", paramString);
    }
  }
  
  private static Class a(Class<? extends c> paramClass)
    throws ClassNotFoundException
  {
    return Class.forName(String.format("%s.%sParcelizer", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() }), false, paramClass.getClassLoader());
  }
  
  protected static <T extends c> void a(T paramT, a parama)
  {
    try
    {
      c(paramT).getDeclaredMethod("write", new Class[] { paramT.getClass(), a.class }).invoke(null, new Object[] { paramT, parama });
      return;
    }
    catch (ClassNotFoundException paramT)
    {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", paramT);
    }
    catch (NoSuchMethodException paramT)
    {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", paramT);
    }
    catch (InvocationTargetException paramT)
    {
      if ((paramT.getCause() instanceof RuntimeException)) {
        throw ((RuntimeException)paramT.getCause());
      }
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", paramT);
    }
    catch (IllegalAccessException paramT)
    {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", paramT);
    }
  }
  
  private void b(c paramc)
  {
    try
    {
      Class localClass = a(paramc.getClass());
      a(localClass.getName());
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramc.getClass().getSimpleName());
      localStringBuilder.append(" does not have a Parcelizer");
      throw new RuntimeException(localStringBuilder.toString(), localClassNotFoundException);
    }
  }
  
  private static <T extends c> Class c(T paramT)
    throws ClassNotFoundException
  {
    return a(paramT.getClass());
  }
  
  protected abstract void a(int paramInt);
  
  public void a(int paramInt1, int paramInt2)
  {
    c(paramInt2);
    a(paramInt1);
  }
  
  protected abstract void a(Parcelable paramParcelable);
  
  public void a(Parcelable paramParcelable, int paramInt)
  {
    c(paramInt);
    a(paramParcelable);
  }
  
  protected void a(c paramc)
  {
    if (paramc == null)
    {
      a(null);
      return;
    }
    b(paramc);
    a locala = c();
    a(paramc, locala);
    locala.b();
  }
  
  public void a(c paramc, int paramInt)
  {
    c(paramInt);
    a(paramc);
  }
  
  protected abstract void a(String paramString);
  
  public void a(String paramString, int paramInt)
  {
    c(paramInt);
    a(paramString);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected abstract void a(byte[] paramArrayOfByte);
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    c(paramInt);
    a(paramArrayOfByte);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    if (!b(paramInt2)) {
      return paramInt1;
    }
    return d();
  }
  
  public <T extends Parcelable> T b(T paramT, int paramInt)
  {
    if (!b(paramInt)) {
      return paramT;
    }
    return g();
  }
  
  public <T extends c> T b(T paramT, int paramInt)
  {
    if (!b(paramInt)) {
      return paramT;
    }
    return h();
  }
  
  public String b(String paramString, int paramInt)
  {
    if (!b(paramInt)) {
      return paramString;
    }
    return e();
  }
  
  protected abstract void b();
  
  protected abstract boolean b(int paramInt);
  
  public byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if (!b(paramInt)) {
      return paramArrayOfByte;
    }
    return f();
  }
  
  protected abstract a c();
  
  protected abstract void c(int paramInt);
  
  protected abstract int d();
  
  protected abstract String e();
  
  protected abstract byte[] f();
  
  protected abstract <T extends Parcelable> T g();
  
  protected <T extends c> T h()
  {
    String str = e();
    if (str == null) {
      return null;
    }
    return a(str, c());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\androidx\versionedparcelable\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */