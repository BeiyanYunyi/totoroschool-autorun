package com.github.barteksc.pdfviewer.exception;

public class PageRenderingException
  extends Exception
{
  private final int page;
  
  public PageRenderingException(int paramInt, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.page = paramInt;
  }
  
  public int getPage()
  {
    return this.page;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\exception\PageRenderingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */