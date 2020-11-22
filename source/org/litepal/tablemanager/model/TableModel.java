package org.litepal.tablemanager.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TableModel
{
  private String className;
  private List<ColumnModel> columnModels = new ArrayList();
  private String tableName;
  
  public void addColumnModel(ColumnModel paramColumnModel)
  {
    this.columnModels.add(paramColumnModel);
  }
  
  public boolean containsColumn(String paramString)
  {
    int i = 0;
    while (i < this.columnModels.size())
    {
      if (paramString.equalsIgnoreCase(((ColumnModel)this.columnModels.get(i)).getColumnName())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public String getClassName()
  {
    return this.className;
  }
  
  public ColumnModel getColumnModelByName(String paramString)
  {
    Iterator localIterator = this.columnModels.iterator();
    while (localIterator.hasNext())
    {
      ColumnModel localColumnModel = (ColumnModel)localIterator.next();
      if (localColumnModel.getColumnName().equalsIgnoreCase(paramString)) {
        return localColumnModel;
      }
    }
    return null;
  }
  
  public List<ColumnModel> getColumnModels()
  {
    return this.columnModels;
  }
  
  public String getTableName()
  {
    return this.tableName;
  }
  
  public void removeColumnModelByName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = 0;
    while (i < this.columnModels.size())
    {
      if (paramString.equalsIgnoreCase(((ColumnModel)this.columnModels.get(i)).getColumnName())) {
        break label58;
      }
      i += 1;
    }
    i = -1;
    label58:
    if (i != -1) {
      this.columnModels.remove(i);
    }
  }
  
  public void setClassName(String paramString)
  {
    this.className = paramString;
  }
  
  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\model\TableModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */