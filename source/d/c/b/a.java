package d.c.b;

import d.e.d;
import d.e.f;
import d.e.g;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public abstract class a
  implements d.e.b, Serializable
{
  public static final Object NO_RECEIVER = a.a;
  private transient d.e.b a;
  protected final Object receiver;
  
  public a()
  {
    this(NO_RECEIVER);
  }
  
  protected a(Object paramObject)
  {
    this.receiver = paramObject;
  }
  
  public Object call(Object... paramVarArgs)
  {
    return getReflected().call(paramVarArgs);
  }
  
  public Object callBy(Map paramMap)
  {
    return getReflected().callBy(paramMap);
  }
  
  public d.e.b compute()
  {
    d.e.b localb2 = this.a;
    d.e.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = computeReflected();
      this.a = localb1;
    }
    return localb1;
  }
  
  protected abstract d.e.b computeReflected();
  
  public List<Annotation> getAnnotations()
  {
    return getReflected().getAnnotations();
  }
  
  public Object getBoundReceiver()
  {
    return this.receiver;
  }
  
  public String getName()
  {
    throw new AbstractMethodError();
  }
  
  public d getOwner()
  {
    throw new AbstractMethodError();
  }
  
  public List<Object> getParameters()
  {
    return getReflected().getParameters();
  }
  
  protected d.e.b getReflected()
  {
    d.e.b localb = compute();
    if (localb != this) {
      return localb;
    }
    throw new d.c.b();
  }
  
  public f getReturnType()
  {
    return getReflected().getReturnType();
  }
  
  public String getSignature()
  {
    throw new AbstractMethodError();
  }
  
  public List<Object> getTypeParameters()
  {
    return getReflected().getTypeParameters();
  }
  
  public g getVisibility()
  {
    return getReflected().getVisibility();
  }
  
  public boolean isAbstract()
  {
    return getReflected().isAbstract();
  }
  
  public boolean isFinal()
  {
    return getReflected().isFinal();
  }
  
  public boolean isOpen()
  {
    return getReflected().isOpen();
  }
  
  public boolean isSuspend()
  {
    return getReflected().isSuspend();
  }
  
  private static class a
    implements Serializable
  {
    private static final a a = new a();
    
    private Object readResolve()
      throws ObjectStreamException
    {
      return a;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */