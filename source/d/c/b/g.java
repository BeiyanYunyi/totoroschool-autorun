package d.c.b;

import d.e.b;
import d.e.e;

public class g
  extends a
  implements f, e
{
  private final int arity;
  
  public g(int paramInt)
  {
    this.arity = paramInt;
  }
  
  public g(int paramInt, Object paramObject)
  {
    super(paramObject);
    this.arity = paramInt;
  }
  
  protected b computeReflected()
  {
    return j.a(this);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof g))
    {
      paramObject = (g)paramObject;
      return (getOwner() == null ? ((g)paramObject).getOwner() == null : getOwner().equals(((g)paramObject).getOwner())) && (getName().equals(((g)paramObject).getName())) && (getSignature().equals(((g)paramObject).getSignature())) && (h.a(getBoundReceiver(), ((g)paramObject).getBoundReceiver()));
    }
    if ((paramObject instanceof e)) {
      return paramObject.equals(compute());
    }
    return false;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  protected e getReflected()
  {
    return (e)super.getReflected();
  }
  
  public int hashCode()
  {
    int i;
    if (getOwner() == null) {
      i = 0;
    } else {
      i = getOwner().hashCode() * 31;
    }
    return (i + getName().hashCode()) * 31 + getSignature().hashCode();
  }
  
  public boolean isExternal()
  {
    return getReflected().isExternal();
  }
  
  public boolean isInfix()
  {
    return getReflected().isInfix();
  }
  
  public boolean isInline()
  {
    return getReflected().isInline();
  }
  
  public boolean isOperator()
  {
    return getReflected().isOperator();
  }
  
  public boolean isSuspend()
  {
    return getReflected().isSuspend();
  }
  
  public String toString()
  {
    Object localObject = compute();
    if (localObject != this) {
      return localObject.toString();
    }
    if ("<init>".equals(getName())) {
      return "constructor (Kotlin reflection is not available)";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("function ");
    ((StringBuilder)localObject).append(getName());
    ((StringBuilder)localObject).append(" (Kotlin reflection is not available)");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\c\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */