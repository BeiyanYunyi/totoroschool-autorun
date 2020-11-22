package org.litepal.exceptions;

public class DataSupportException
  extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  
  public DataSupportException(String paramString)
  {
    super(paramString);
  }
  
  public DataSupportException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\exceptions\DataSupportException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */