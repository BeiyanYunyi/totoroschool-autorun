package org.litepal.crud;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.util.DBUtility;

class Many2OneAnalyzer
  extends AssociationsAnalyzer
{
  private void analyzeManySide(LitePalSupport paramLitePalSupport, AssociationsInfo paramAssociationsInfo)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    LitePalSupport localLitePalSupport = getAssociatedModel(paramLitePalSupport, paramAssociationsInfo);
    if (localLitePalSupport != null)
    {
      Collection localCollection = checkAssociatedModelCollection(getReverseAssociatedModels(localLitePalSupport, paramAssociationsInfo), paramAssociationsInfo.getAssociateSelfFromOtherModel());
      setReverseAssociatedModels(localLitePalSupport, paramAssociationsInfo, localCollection);
      dealAssociatedModelOnManySide(localCollection, paramLitePalSupport, localLitePalSupport);
      return;
    }
    mightClearFKValue(paramLitePalSupport, paramAssociationsInfo);
  }
  
  private void analyzeOneSide(LitePalSupport paramLitePalSupport, AssociationsInfo paramAssociationsInfo)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    Object localObject = getAssociatedModels(paramLitePalSupport, paramAssociationsInfo);
    if ((localObject != null) && (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LitePalSupport localLitePalSupport = (LitePalSupport)((Iterator)localObject).next();
        buildBidirectionalAssociations(paramLitePalSupport, localLitePalSupport, paramAssociationsInfo);
        dealAssociatedModelOnOneSide(paramLitePalSupport, localLitePalSupport);
      }
      return;
    }
    paramLitePalSupport.addAssociatedTableNameToClearFK(DBUtility.getTableNameByClassName(paramAssociationsInfo.getAssociatedClassName()));
  }
  
  private void dealAssociatedModelOnManySide(Collection<LitePalSupport> paramCollection, LitePalSupport paramLitePalSupport1, LitePalSupport paramLitePalSupport2)
  {
    if (!paramCollection.contains(paramLitePalSupport1)) {
      paramCollection.add(paramLitePalSupport1);
    }
    if (paramLitePalSupport2.isSaved()) {
      paramLitePalSupport1.addAssociatedModelWithoutFK(paramLitePalSupport2.getTableName(), paramLitePalSupport2.getBaseObjId());
    }
  }
  
  private void dealAssociatedModelOnOneSide(LitePalSupport paramLitePalSupport1, LitePalSupport paramLitePalSupport2)
  {
    dealsAssociationsOnTheSideWithoutFK(paramLitePalSupport1, paramLitePalSupport2);
  }
  
  void analyze(LitePalSupport paramLitePalSupport, AssociationsInfo paramAssociationsInfo)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    if (paramLitePalSupport.getClassName().equals(paramAssociationsInfo.getClassHoldsForeignKey()))
    {
      analyzeManySide(paramLitePalSupport, paramAssociationsInfo);
      return;
    }
    analyzeOneSide(paramLitePalSupport, paramAssociationsInfo);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\Many2OneAnalyzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */