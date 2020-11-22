package org.litepal.crud;

import java.lang.reflect.InvocationTargetException;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.util.DBUtility;

public class One2OneAnalyzer
  extends AssociationsAnalyzer
{
  private void bidirectionalCondition(LitePalSupport paramLitePalSupport1, LitePalSupport paramLitePalSupport2)
  {
    if (paramLitePalSupport2.isSaved())
    {
      paramLitePalSupport1.addAssociatedModelWithFK(paramLitePalSupport2.getTableName(), paramLitePalSupport2.getBaseObjId());
      paramLitePalSupport1.addAssociatedModelWithoutFK(paramLitePalSupport2.getTableName(), paramLitePalSupport2.getBaseObjId());
    }
  }
  
  private void dealAssociatedModel(LitePalSupport paramLitePalSupport1, LitePalSupport paramLitePalSupport2, AssociationsInfo paramAssociationsInfo)
  {
    if (paramAssociationsInfo.getAssociateSelfFromOtherModel() != null)
    {
      bidirectionalCondition(paramLitePalSupport1, paramLitePalSupport2);
      return;
    }
    unidirectionalCondition(paramLitePalSupport1, paramLitePalSupport2);
  }
  
  private void unidirectionalCondition(LitePalSupport paramLitePalSupport1, LitePalSupport paramLitePalSupport2)
  {
    dealsAssociationsOnTheSideWithoutFK(paramLitePalSupport1, paramLitePalSupport2);
  }
  
  void analyze(LitePalSupport paramLitePalSupport, AssociationsInfo paramAssociationsInfo)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    LitePalSupport localLitePalSupport = getAssociatedModel(paramLitePalSupport, paramAssociationsInfo);
    if (localLitePalSupport != null)
    {
      buildBidirectionalAssociations(paramLitePalSupport, localLitePalSupport, paramAssociationsInfo);
      dealAssociatedModel(paramLitePalSupport, localLitePalSupport, paramAssociationsInfo);
      return;
    }
    paramLitePalSupport.addAssociatedTableNameToClearFK(DBUtility.getTableNameByClassName(paramAssociationsInfo.getAssociatedClassName()));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\One2OneAnalyzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */