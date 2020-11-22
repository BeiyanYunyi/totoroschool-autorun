package org.litepal.tablemanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.parser.LitePalAttr;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.GenericModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;
import org.litepal.util.LitePalLog;

public abstract class AssociationUpdater
  extends Creator
{
  public static final String TAG = "AssociationUpdater";
  private Collection<AssociationsModel> mAssociationModels;
  protected SQLiteDatabase mDb;
  
  private List<String> findForeignKeyToRemove(TableModel paramTableModel)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = getForeignKeyColumns(paramTableModel);
    Object localObject1 = paramTableModel.getTableName();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if (shouldDropForeignKey((String)localObject1, DBUtility.getTableNameByForeignColumn(str))) {
        localArrayList.add(str);
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("findForeignKeyToRemove >> ");
    ((StringBuilder)localObject1).append(paramTableModel.getTableName());
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(localArrayList);
    LitePalLog.d("AssociationUpdater", ((StringBuilder)localObject1).toString());
    return localArrayList;
  }
  
  private List<String> findGenericTablesToDrop()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = DBUtility.findAllTableNames(this.mDb).iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      if (DBUtility.isGenericTable(str, this.mDb))
      {
        int i = 1;
        Iterator localIterator2 = getGenericModels().iterator();
        while (localIterator2.hasNext()) {
          if (str.equalsIgnoreCase(((GenericModel)localIterator2.next()).getTableName())) {
            i = 0;
          }
        }
        if (i != 0) {
          localArrayList.add(str);
        }
      }
    }
    return localArrayList;
  }
  
  private List<String> findIntermediateTablesToDrop()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = DBUtility.findAllTableNames(this.mDb).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (DBUtility.isIntermediateTable(str, this.mDb))
      {
        int i = 1;
        Iterator localIterator = this.mAssociationModels.iterator();
        while (localIterator.hasNext())
        {
          AssociationsModel localAssociationsModel = (AssociationsModel)localIterator.next();
          if ((localAssociationsModel.getAssociationType() == 3) && (str.equalsIgnoreCase(DBUtility.getIntermediateTableName(localAssociationsModel.getTableName(), localAssociationsModel.getAssociatedTableName())))) {
            i = 0;
          }
        }
        if (i != 0) {
          localArrayList.add(str);
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("findIntermediateTablesToDrop >> ");
    ((StringBuilder)localObject).append(localArrayList);
    LitePalLog.d("AssociationUpdater", ((StringBuilder)localObject).toString());
    return localArrayList;
  }
  
  private String generateCreateNewTableSQL(Collection<String> paramCollection, TableModel paramTableModel)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      paramTableModel.removeColumnModelByName((String)paramCollection.next());
    }
    return generateCreateTableSQL(paramTableModel);
  }
  
  private List<String> getRemoveColumnSQLs(Collection<String> paramCollection, String paramString)
  {
    Object localObject1 = getTableModelFromDB(paramString);
    String str = generateAlterToTempTableSQL(paramString);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("generateRemoveColumnSQL >> ");
    ((StringBuilder)localObject2).append(str);
    LitePalLog.d("AssociationUpdater", ((StringBuilder)localObject2).toString());
    paramCollection = generateCreateNewTableSQL(paramCollection, (TableModel)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("generateRemoveColumnSQL >> ");
    ((StringBuilder)localObject2).append(paramCollection);
    LitePalLog.d("AssociationUpdater", ((StringBuilder)localObject2).toString());
    localObject1 = generateDataMigrationSQL((TableModel)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("generateRemoveColumnSQL >> ");
    ((StringBuilder)localObject2).append((String)localObject1);
    LitePalLog.d("AssociationUpdater", ((StringBuilder)localObject2).toString());
    paramString = generateDropTempTableSQL(paramString);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("generateRemoveColumnSQL >> ");
    ((StringBuilder)localObject2).append(paramString);
    LitePalLog.d("AssociationUpdater", ((StringBuilder)localObject2).toString());
    localObject2 = new ArrayList();
    ((List)localObject2).add(str);
    ((List)localObject2).add(paramCollection);
    ((List)localObject2).add(localObject1);
    ((List)localObject2).add(paramString);
    return (List<String>)localObject2;
  }
  
  private boolean isRelationCorrect(AssociationsModel paramAssociationsModel, String paramString1, String paramString2)
  {
    return (paramAssociationsModel.getTableName().equalsIgnoreCase(paramString1)) && (paramAssociationsModel.getAssociatedTableName().equalsIgnoreCase(paramString2));
  }
  
  private void removeAssociations()
  {
    removeForeignKeyColumns();
    removeIntermediateTables();
    removeGenericTables();
  }
  
  private void removeForeignKeyColumns()
  {
    Iterator localIterator = LitePalAttr.getInstance().getClassNames().iterator();
    while (localIterator.hasNext())
    {
      TableModel localTableModel = getTableModel((String)localIterator.next());
      removeColumns(findForeignKeyToRemove(localTableModel), localTableModel.getTableName());
    }
  }
  
  private void removeGenericTables()
  {
    List localList = findGenericTablesToDrop();
    dropTables(localList, this.mDb);
    clearCopyInTableSchema(localList);
  }
  
  private void removeIntermediateTables()
  {
    List localList = findIntermediateTablesToDrop();
    dropTables(localList, this.mDb);
    clearCopyInTableSchema(localList);
  }
  
  private boolean shouldDropForeignKey(String paramString1, String paramString2)
  {
    Iterator localIterator = this.mAssociationModels.iterator();
    while (localIterator.hasNext())
    {
      AssociationsModel localAssociationsModel = (AssociationsModel)localIterator.next();
      if (localAssociationsModel.getAssociationType() == 1)
      {
        if (paramString1.equalsIgnoreCase(localAssociationsModel.getTableHoldsForeignKey())) {
          if (localAssociationsModel.getTableName().equalsIgnoreCase(paramString1))
          {
            if (isRelationCorrect(localAssociationsModel, paramString1, paramString2)) {
              return false;
            }
          }
          else if ((localAssociationsModel.getAssociatedTableName().equalsIgnoreCase(paramString1)) && (isRelationCorrect(localAssociationsModel, paramString2, paramString1))) {
            return false;
          }
        }
      }
      else if ((localAssociationsModel.getAssociationType() == 2) && (isRelationCorrect(localAssociationsModel, paramString2, paramString1))) {
        return false;
      }
    }
    return true;
  }
  
  protected void addOrUpdateAssociation(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    this.mAssociationModels = getAllAssociations();
    this.mDb = paramSQLiteDatabase;
    removeAssociations();
  }
  
  protected void clearCopyInTableSchema(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder("delete from ");
      localStringBuilder.append("table_schema");
      localStringBuilder.append(" where");
      int i = 0;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (i != 0) {
          localStringBuilder.append(" or ");
        }
        i = 1;
        localStringBuilder.append(" lower(");
        localStringBuilder.append("name");
        localStringBuilder.append(") ");
        localStringBuilder.append("=");
        localStringBuilder.append(" lower('");
        localStringBuilder.append(str);
        localStringBuilder.append("')");
      }
      paramList = new StringBuilder();
      paramList.append("clear table schema value sql is ");
      paramList.append(localStringBuilder);
      LitePalLog.d("AssociationUpdater", paramList.toString());
      paramList = new ArrayList();
      paramList.add(localStringBuilder.toString());
      execute(paramList, this.mDb);
    }
  }
  
  protected abstract void createOrUpgradeTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean);
  
  protected void dropTables(List<String> paramList, SQLiteDatabase paramSQLiteDatabase)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        localArrayList.add(generateDropTableSQL((String)paramList.get(i)));
        i += 1;
      }
      execute(localArrayList, paramSQLiteDatabase);
    }
  }
  
  protected String generateAlterToTempTableSQL(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("alter table ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" rename to ");
    localStringBuilder.append(getTempTableName(paramString));
    return localStringBuilder.toString();
  }
  
  protected String generateDataMigrationSQL(TableModel paramTableModel)
  {
    String str = paramTableModel.getTableName();
    Object localObject1 = paramTableModel.getColumnModels();
    if (!((List)localObject1).isEmpty())
    {
      paramTableModel = new StringBuilder();
      paramTableModel.append("insert into ");
      paramTableModel.append(str);
      paramTableModel.append("(");
      Object localObject2 = ((List)localObject1).iterator();
      int j = 0;
      for (int i = 0; ((Iterator)localObject2).hasNext(); i = 1)
      {
        ColumnModel localColumnModel = (ColumnModel)((Iterator)localObject2).next();
        if (i != 0) {
          paramTableModel.append(", ");
        }
        paramTableModel.append(localColumnModel.getColumnName());
      }
      paramTableModel.append(") ");
      paramTableModel.append("select ");
      localObject1 = ((List)localObject1).iterator();
      for (i = j; ((Iterator)localObject1).hasNext(); i = 1)
      {
        localObject2 = (ColumnModel)((Iterator)localObject1).next();
        if (i != 0) {
          paramTableModel.append(", ");
        }
        paramTableModel.append(((ColumnModel)localObject2).getColumnName());
      }
      paramTableModel.append(" from ");
      paramTableModel.append(getTempTableName(str));
      return paramTableModel.toString();
    }
    return null;
  }
  
  protected String generateDropTempTableSQL(String paramString)
  {
    return generateDropTableSQL(getTempTableName(paramString));
  }
  
  protected List<String> getForeignKeyColumns(TableModel paramTableModel)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getTableModelFromDB(paramTableModel.getTableName()).getColumnModels().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ColumnModel)localIterator.next();
      String str = ((ColumnModel)localObject).getColumnName();
      if ((isForeignKeyColumnFormat(((ColumnModel)localObject).getColumnName())) && (!paramTableModel.containsColumn(str)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getForeignKeyColumnNames >> foreign key column is ");
        ((StringBuilder)localObject).append(str);
        LitePalLog.d("AssociationUpdater", ((StringBuilder)localObject).toString());
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  protected TableModel getTableModelFromDB(String paramString)
  {
    return DBUtility.findPragmaTableInfo(paramString, this.mDb);
  }
  
  protected String getTempTableName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_temp");
    return localStringBuilder.toString();
  }
  
  protected boolean isForeignKeyColumn(TableModel paramTableModel, String paramString)
  {
    return BaseUtility.containsIgnoreCases(getForeignKeyColumns(paramTableModel), paramString);
  }
  
  protected void removeColumns(Collection<String> paramCollection, String paramString)
  {
    if ((paramCollection != null) && (!paramCollection.isEmpty())) {
      execute(getRemoveColumnSQLs(paramCollection, paramString), this.mDb);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\AssociationUpdater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */