package org.litepal.crud.model;

import java.lang.reflect.Field;

public class AssociationsInfo
{
  private Field associateOtherModelFromSelf;
  private Field associateSelfFromOtherModel;
  private String associatedClassName;
  private int associationType;
  private String classHoldsForeignKey;
  private String selfClassName;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof AssociationsInfo))
    {
      AssociationsInfo localAssociationsInfo = (AssociationsInfo)paramObject;
      if ((paramObject != null) && (localAssociationsInfo != null) && (localAssociationsInfo.getAssociationType() == this.associationType) && (localAssociationsInfo.getClassHoldsForeignKey().equals(this.classHoldsForeignKey)))
      {
        if ((localAssociationsInfo.getSelfClassName().equals(this.selfClassName)) && (localAssociationsInfo.getAssociatedClassName().equals(this.associatedClassName))) {
          return true;
        }
        if ((localAssociationsInfo.getSelfClassName().equals(this.associatedClassName)) && (localAssociationsInfo.getAssociatedClassName().equals(this.selfClassName))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Field getAssociateOtherModelFromSelf()
  {
    return this.associateOtherModelFromSelf;
  }
  
  public Field getAssociateSelfFromOtherModel()
  {
    return this.associateSelfFromOtherModel;
  }
  
  public String getAssociatedClassName()
  {
    return this.associatedClassName;
  }
  
  public int getAssociationType()
  {
    return this.associationType;
  }
  
  public String getClassHoldsForeignKey()
  {
    return this.classHoldsForeignKey;
  }
  
  public String getSelfClassName()
  {
    return this.selfClassName;
  }
  
  public void setAssociateOtherModelFromSelf(Field paramField)
  {
    this.associateOtherModelFromSelf = paramField;
  }
  
  public void setAssociateSelfFromOtherModel(Field paramField)
  {
    this.associateSelfFromOtherModel = paramField;
  }
  
  public void setAssociatedClassName(String paramString)
  {
    this.associatedClassName = paramString;
  }
  
  public void setAssociationType(int paramInt)
  {
    this.associationType = paramInt;
  }
  
  public void setClassHoldsForeignKey(String paramString)
  {
    this.classHoldsForeignKey = paramString;
  }
  
  public void setSelfClassName(String paramString)
  {
    this.selfClassName = paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\model\AssociationsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */