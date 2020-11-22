package org.litepal.tablemanager.model;

import android.text.TextUtils;

public class ColumnModel
{
  private String columnName;
  private String columnType;
  private String defaultValue = "";
  private boolean isNullable = true;
  private boolean isUnique = false;
  
  public String getColumnName()
  {
    return this.columnName;
  }
  
  public String getColumnType()
  {
    return this.columnType;
  }
  
  public String getDefaultValue()
  {
    return this.defaultValue;
  }
  
  public boolean isIdColumn()
  {
    return ("_id".equalsIgnoreCase(this.columnName)) || ("id".equalsIgnoreCase(this.columnName));
  }
  
  public boolean isNullable()
  {
    return this.isNullable;
  }
  
  public boolean isUnique()
  {
    return this.isUnique;
  }
  
  public void setColumnName(String paramString)
  {
    this.columnName = paramString;
  }
  
  public void setColumnType(String paramString)
  {
    this.columnType = paramString;
  }
  
  public void setDefaultValue(String paramString)
  {
    if ("text".equalsIgnoreCase(this.columnType))
    {
      if (!TextUtils.isEmpty(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("'");
        localStringBuilder.append(paramString);
        localStringBuilder.append("'");
        this.defaultValue = localStringBuilder.toString();
      }
    }
    else {
      this.defaultValue = paramString;
    }
  }
  
  public void setNullable(boolean paramBoolean)
  {
    this.isNullable = paramBoolean;
  }
  
  public void setUnique(boolean paramBoolean)
  {
    this.isUnique = paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\model\ColumnModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */