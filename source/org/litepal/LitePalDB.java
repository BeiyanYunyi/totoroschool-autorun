package org.litepal;

import java.util.ArrayList;
import java.util.List;
import org.litepal.parser.LitePalConfig;
import org.litepal.parser.LitePalParser;

public class LitePalDB
{
  private List<String> classNames;
  private String dbName;
  private boolean isExternalStorage = false;
  private String storage;
  private int version;
  
  public LitePalDB(String paramString, int paramInt)
  {
    this.dbName = paramString;
    this.version = paramInt;
  }
  
  public static LitePalDB fromDefault(String paramString)
  {
    LitePalConfig localLitePalConfig = LitePalParser.parseLitePalConfiguration();
    paramString = new LitePalDB(paramString, localLitePalConfig.getVersion());
    paramString.setStorage(localLitePalConfig.getStorage());
    paramString.setClassNames(localLitePalConfig.getClassNames());
    return paramString;
  }
  
  public void addClassName(String paramString)
  {
    getClassNames().add(paramString);
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
  
  public boolean isExternalStorage()
  {
    return this.isExternalStorage;
  }
  
  void setClassNames(List<String> paramList)
  {
    this.classNames = paramList;
  }
  
  public void setExternalStorage(boolean paramBoolean)
  {
    this.isExternalStorage = paramBoolean;
  }
  
  public void setStorage(String paramString)
  {
    this.storage = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\LitePalDB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */