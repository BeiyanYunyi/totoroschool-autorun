package com.totoro.school.entity;

public class BaseResultEntity<T>
{
  private T body;
  private HeaderModel header;
  
  public T getBody()
  {
    return (T)this.body;
  }
  
  public HeaderModel getHeader()
  {
    return this.header;
  }
  
  public void setBody(T paramT)
  {
    this.body = paramT;
  }
  
  public void setHeader(HeaderModel paramHeaderModel)
  {
    this.header = paramHeaderModel;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\BaseResultEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */