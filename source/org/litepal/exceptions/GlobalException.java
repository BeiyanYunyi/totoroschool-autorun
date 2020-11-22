package org.litepal.exceptions;

public class GlobalException
  extends RuntimeException
{
  public static final String APPLICATION_CONTEXT_IS_NULL = "Application context is null. Maybe you neither configured your application name with \"org.litepal.LitePalApplication\" in your AndroidManifest.xml, nor called LitePal.initialize(Context) method.";
  private static final long serialVersionUID = 1L;
  
  public GlobalException(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\exceptions\GlobalException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */