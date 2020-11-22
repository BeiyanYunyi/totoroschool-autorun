package org.litepal.parser;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.litepal.exceptions.InvalidAttributesException;
import org.litepal.util.BaseUtility;
import org.litepal.util.SharedUtil;

public final class LitePalAttr
{
  private static LitePalAttr litePalAttr;
  private String cases;
  private List<String> classNames;
  private String dbName;
  private String extraKeyName;
  private String storage;
  private int version;
  
  public static void clearInstance()
  {
    litePalAttr = null;
  }
  
  public static LitePalAttr getInstance()
  {
    if (litePalAttr == null) {
      try
      {
        if (litePalAttr == null)
        {
          litePalAttr = new LitePalAttr();
          loadLitePalXMLConfiguration();
        }
      }
      finally {}
    }
    return litePalAttr;
  }
  
  private static void loadLitePalXMLConfiguration()
  {
    if (BaseUtility.isLitePalXMLExists())
    {
      LitePalConfig localLitePalConfig = LitePalParser.parseLitePalConfiguration();
      litePalAttr.setDbName(localLitePalConfig.getDbName());
      litePalAttr.setVersion(localLitePalConfig.getVersion());
      litePalAttr.setClassNames(localLitePalConfig.getClassNames());
      litePalAttr.setCases(localLitePalConfig.getCases());
      litePalAttr.setStorage(localLitePalConfig.getStorage());
    }
  }
  
  public void addClassName(String paramString)
  {
    getClassNames().add(paramString);
  }
  
  public void checkSelfValid()
  {
    if (TextUtils.isEmpty(this.dbName))
    {
      loadLitePalXMLConfiguration();
      if (TextUtils.isEmpty(this.dbName)) {
        throw new InvalidAttributesException("dbname is empty or not defined in litepal.xml file, or your litepal.xml file is missing.");
      }
    }
    StringBuilder localStringBuilder;
    if (!this.dbName.endsWith(".db"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.dbName);
      localStringBuilder.append(".db");
      this.dbName = localStringBuilder.toString();
    }
    if (this.version >= 1)
    {
      if (this.version >= SharedUtil.getLastVersion(this.extraKeyName))
      {
        if (TextUtils.isEmpty(this.cases))
        {
          this.cases = "lower";
          return;
        }
        if ((!this.cases.equals("upper")) && (!this.cases.equals("lower")))
        {
          if (this.cases.equals("keep")) {
            return;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.cases);
          localStringBuilder.append(" is an invalid value for <cases></cases>");
          throw new InvalidAttributesException(localStringBuilder.toString());
        }
        return;
      }
      throw new InvalidAttributesException("the version in litepal.xml is earlier than the current version");
    }
    throw new InvalidAttributesException("the version of database can not be less than 1");
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
  
  public String getExtraKeyName()
  {
    return this.extraKeyName;
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
  
  public void setExtraKeyName(String paramString)
  {
    this.extraKeyName = paramString;
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\parser\LitePalAttr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */