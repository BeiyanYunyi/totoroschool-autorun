package com.totoro.school.entity.run.routePoint;

import java.io.Serializable;
import org.litepal.crud.LitePalSupport;

public class RoutePointModel
  extends LitePalSupport
  implements Serializable
{
  private String dispno;
  private String route;
  private String routeid;
  private String routename;
  private String taskid;
  private String uuid;
  private String x;
  private String y;
  
  public String getDispno()
  {
    return this.dispno;
  }
  
  public String getRoute()
  {
    return this.route;
  }
  
  public String getRouteid()
  {
    return this.routeid;
  }
  
  public String getRoutename()
  {
    return this.routename;
  }
  
  public String getTaskid()
  {
    return this.taskid;
  }
  
  public String getUuid()
  {
    return this.uuid;
  }
  
  public String getX()
  {
    return this.x;
  }
  
  public String getY()
  {
    return this.y;
  }
  
  public void setDispno(String paramString)
  {
    this.dispno = paramString;
  }
  
  public void setRoute(String paramString)
  {
    this.route = paramString;
  }
  
  public void setRouteid(String paramString)
  {
    this.routeid = paramString;
  }
  
  public void setRoutename(String paramString)
  {
    this.routename = paramString;
  }
  
  public void setTaskid(String paramString)
  {
    this.taskid = paramString;
  }
  
  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
  
  public void setX(String paramString)
  {
    this.x = paramString;
  }
  
  public void setY(String paramString)
  {
    this.y = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\entity\run\routePoint\RoutePointModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */