package d.e;

import java.util.List;
import java.util.Map;

public abstract interface b<R>
  extends a
{
  public abstract R call(Object... paramVarArgs);
  
  public abstract R callBy(Map<Object, ? extends Object> paramMap);
  
  public abstract List<Object> getParameters();
  
  public abstract f getReturnType();
  
  public abstract List<Object> getTypeParameters();
  
  public abstract g getVisibility();
  
  public abstract boolean isAbstract();
  
  public abstract boolean isFinal();
  
  public abstract boolean isOpen();
  
  public abstract boolean isSuspend();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */