package org.litepal.tablemanager.model;

public class GenericModel
{
  private String getMethodName;
  private String tableName;
  private String valueColumnName;
  private String valueColumnType;
  private String valueIdColumnName;
  
  public String getGetMethodName()
  {
    return this.getMethodName;
  }
  
  public String getTableName()
  {
    return this.tableName;
  }
  
  public String getValueColumnName()
  {
    return this.valueColumnName;
  }
  
  public String getValueColumnType()
  {
    return this.valueColumnType;
  }
  
  public String getValueIdColumnName()
  {
    return this.valueIdColumnName;
  }
  
  public void setGetMethodName(String paramString)
  {
    this.getMethodName = paramString;
  }
  
  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }
  
  public void setValueColumnName(String paramString)
  {
    this.valueColumnName = paramString;
  }
  
  public void setValueColumnType(String paramString)
  {
    this.valueColumnType = paramString;
  }
  
  public void setValueIdColumnName(String paramString)
  {
    this.valueIdColumnName = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\model\GenericModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */