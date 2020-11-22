package org.litepal.crud;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.util.DBUtility;

abstract class AssociationsAnalyzer
  extends DataHandler
{
  private String getForeignKeyName(AssociationsInfo paramAssociationsInfo)
  {
    return getForeignKeyColumnName(DBUtility.getTableNameByClassName(paramAssociationsInfo.getAssociatedClassName()));
  }
  
  protected void buildBidirectionalAssociations(LitePalSupport paramLitePalSupport1, LitePalSupport paramLitePalSupport2, AssociationsInfo paramAssociationsInfo)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    setFieldValue(paramLitePalSupport2, paramAssociationsInfo.getAssociateSelfFromOtherModel(), paramLitePalSupport1);
  }
  
  protected Collection<LitePalSupport> checkAssociatedModelCollection(Collection<LitePalSupport> paramCollection, Field paramField)
  {
    if (isList(paramField.getType()))
    {
      paramField = new ArrayList();
    }
    else
    {
      if (!isSet(paramField.getType())) {
        break label55;
      }
      paramField = new HashSet();
    }
    if (paramCollection != null) {
      paramField.addAll(paramCollection);
    }
    return paramField;
    label55:
    throw new LitePalSupportException("The field to declare many2one or many2many associations should be List or Set.");
  }
  
  protected void dealsAssociationsOnTheSideWithoutFK(LitePalSupport paramLitePalSupport1, LitePalSupport paramLitePalSupport2)
  {
    if (paramLitePalSupport2 != null)
    {
      if (paramLitePalSupport2.isSaved())
      {
        paramLitePalSupport1.addAssociatedModelWithFK(paramLitePalSupport2.getTableName(), paramLitePalSupport2.getBaseObjId());
        return;
      }
      if (paramLitePalSupport1.isSaved()) {
        paramLitePalSupport2.addAssociatedModelWithoutFK(paramLitePalSupport1.getTableName(), paramLitePalSupport1.getBaseObjId());
      }
    }
  }
  
  protected Collection<LitePalSupport> getReverseAssociatedModels(LitePalSupport paramLitePalSupport, AssociationsInfo paramAssociationsInfo)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    return (Collection)getFieldValue(paramLitePalSupport, paramAssociationsInfo.getAssociateSelfFromOtherModel());
  }
  
  protected void mightClearFKValue(LitePalSupport paramLitePalSupport, AssociationsInfo paramAssociationsInfo)
  {
    paramLitePalSupport.addFKNameToClearSelf(getForeignKeyName(paramAssociationsInfo));
  }
  
  protected void setReverseAssociatedModels(LitePalSupport paramLitePalSupport, AssociationsInfo paramAssociationsInfo, Collection<LitePalSupport> paramCollection)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    setFieldValue(paramLitePalSupport, paramAssociationsInfo.getAssociateSelfFromOtherModel(), paramCollection);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\AssociationsAnalyzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */