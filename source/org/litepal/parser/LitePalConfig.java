package org.litepal.parser;

import java.util.ArrayList;
import java.util.List;

public class LitePalConfig
{
  private String cases;
  private List<String> classNames;
  private String dbName;
  private String storage;
  private int version;
  
  public void addClassName(String paramString)
  {
    getClassNames().add(paramString);
  }
  
  public String getCases()
  {
    return this.cases;
  }
  
  public List<String> getClassNames()
  {
    if (this.classNames == null)
    {
      this.classNames = new ArrayList();
      this.classNames.add("org.litepal.model.Table_Schema");
    }
    else if (this.classNames.isEmpty())
    {
      this.classNames.add("org.litepal.model.Table_Schema");
    }
    return this.classNames;
  }
  
  public String getDbName()
  {
    return this.dbName;
  }
  
  public String getStorage()
  {
    return this.storage;
  }
  
  public int getVersion()
  {
    return this.version;
  }
  
  public void setCases(String paramString)
  {
    this.cases = paramString;
  }
  
  public void setClassNames(List<String> paramList)
  {
    this.classNames = paramList;
  }
  
  public void setDbName(String paramString)
  {
    this.dbName = paramString;
  }
  
  public void setStorage(String paramString)
  {
    this.storage = paramString;
  }
  
  public void setVersion(int paramInt)
  {
    this.version = paramInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\parser\LitePalConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */