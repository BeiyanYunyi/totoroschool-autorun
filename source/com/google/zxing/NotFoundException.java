package com.google.zxing;

public final class NotFoundException
  extends ReaderException
{
  private static final NotFoundException INSTANCE = new NotFoundException();
  
  static
  {
    INSTANCE.setStackTrace(NO_TRACE);
  }
  
  public static NotFoundException getNotFoundInstance()
  {
    return INSTANCE;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\NotFoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */