package b.a.c;

import b.a.e.j.j;

public final class b
{
  public static RuntimeException a(Throwable paramThrowable)
  {
    throw j.a(paramThrowable);
  }
  
  public static void b(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof VirtualMachineError))
    {
      if (!(paramThrowable instanceof ThreadDeath))
      {
        if (!(paramThrowable instanceof LinkageError)) {
          return;
        }
        throw ((LinkageError)paramThrowable);
      }
      throw ((ThreadDeath)paramThrowable);
    }
    throw ((VirtualMachineError)paramThrowable);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */