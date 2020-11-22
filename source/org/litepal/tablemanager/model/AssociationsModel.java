package org.litepal.tablemanager.model;

public class AssociationsModel
{
  private String associatedTableName;
  private int associationType;
  private String tableHoldsForeignKey;
  private String tableName;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof AssociationsModel))
    {
      paramObject = (AssociationsModel)paramObject;
      if ((((AssociationsModel)paramObject).getTableName() != null) && (((AssociationsModel)paramObject).getAssociatedTableName() != null) && (((AssociationsModel)paramObject).getAssociationType() == this.associationType) && (((AssociationsModel)paramObject).getTableHoldsForeignKey().equals(this.tableHoldsForeignKey)))
      {
        if ((((AssociationsModel)paramObject).getTableName().equals(this.tableName)) && (((AssociationsModel)paramObject).getAssociatedTableName().equals(this.associatedTableName)) && (((AssociationsModel)paramObject).getTableHoldsForeignKey().equals(this.tableHoldsForeignKey))) {
          return true;
        }
        if ((((AssociationsModel)paramObject).getTableName().equals(this.associatedTableName)) && (((AssociationsModel)paramObject).getAssociatedTableName().equals(this.tableName)) && (((AssociationsModel)paramObject).getTableHoldsForeignKey().equals(this.tableHoldsForeignKey))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public String getAssociatedTableName()
  {
    return this.associatedTableName;
  }
  
  public int getAssociationType()
  {
    return this.associationType;
  }
  
  public String getTableHoldsForeignKey()
  {
    return this.tableHoldsForeignKey;
  }
  
  public String getTableName()
  {
    return this.tableName;
  }
  
  public void setAssociatedTableName(String paramString)
  {
    this.associatedTableName = paramString;
  }
  
  public void setAssociationType(int paramInt)
  {
    this.associationType = paramInt;
  }
  
  public void setTableHoldsForeignKey(String paramString)
  {
    this.tableHoldsForeignKey = paramString;
  }
  
  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\model\AssociationsModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */