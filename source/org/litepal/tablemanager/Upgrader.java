package org.litepal.tablemanager;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.DBUtility;
import org.litepal.util.LitePalLog;

public class Upgrader
  extends AssociationUpdater
{
  private boolean hasConstraintChanged;
  protected TableModel mTableModel;
  protected TableModel mTableModelDB;
  
  private void addColumns(List<ColumnModel> paramList)
  {
    LitePalLog.d("AssociationUpdater", "do addColumn");
    execute(getAddColumnSQLs(paramList), this.mDb);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ColumnModel localColumnModel = (ColumnModel)paramList.next();
      this.mTableModelDB.addColumnModel(localColumnModel);
    }
  }
  
  private void changeColumnsConstraints()
  {
    if (this.hasConstraintChanged)
    {
      LitePalLog.d("AssociationUpdater", "do changeColumnsConstraints");
      execute(getChangeColumnsConstraintsSQL(), this.mDb);
    }
  }
  
  private void changeColumnsType(List<ColumnModel> paramList)
  {
    LitePalLog.d("AssociationUpdater", "do changeColumnsType");
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((ColumnModel)localIterator.next()).getColumnName());
      }
    }
    removeColumns(localArrayList);
    addColumns(paramList);
  }
  
  private List<ColumnModel> findColumnTypesToChange()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.mTableModelDB.getColumnModels().iterator();
    while (localIterator1.hasNext())
    {
      ColumnModel localColumnModel1 = (ColumnModel)localIterator1.next();
      Iterator localIterator2 = this.mTableModel.getColumnModels().iterator();
      while (localIterator2.hasNext())
      {
        ColumnModel localColumnModel2 = (ColumnModel)localIterator2.next();
        if (localColumnModel1.getColumnName().equalsIgnoreCase(localColumnModel2.getColumnName()))
        {
          if ((!localColumnModel1.getColumnType().equalsIgnoreCase(localColumnModel2.getColumnType())) && ((!localColumnModel2.getColumnType().equalsIgnoreCase("blob")) || (!TextUtils.isEmpty(localColumnModel1.getColumnType())))) {
            localArrayList.add(localColumnModel2);
          }
          if (!this.hasConstraintChanged)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("default value db is:");
            localStringBuilder.append(localColumnModel1.getDefaultValue());
            localStringBuilder.append(", default value is:");
            localStringBuilder.append(localColumnModel2.getDefaultValue());
            LitePalLog.d("AssociationUpdater", localStringBuilder.toString());
            if ((localColumnModel1.isNullable() != localColumnModel2.isNullable()) || (!localColumnModel1.getDefaultValue().equalsIgnoreCase(localColumnModel2.getDefaultValue())) || ((localColumnModel1.isUnique()) && (!localColumnModel2.isUnique()))) {
              this.hasConstraintChanged = true;
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private List<ColumnModel> findColumnsToAdd()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mTableModel.getColumnModels().iterator();
    while (localIterator.hasNext())
    {
      ColumnModel localColumnModel = (ColumnModel)localIterator.next();
      String str = localColumnModel.getColumnName();
      if (!this.mTableModelDB.containsColumn(str)) {
        localArrayList.add(localColumnModel);
      }
    }
    return localArrayList;
  }
  
  private List<String> findColumnsToRemove()
  {
    String str1 = this.mTableModel.getTableName();
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.mTableModelDB.getColumnModels().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str2 = ((ColumnModel)((Iterator)localObject).next()).getColumnName();
      if (isNeedToRemove(str2)) {
        localArrayList.add(str2);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("remove columns from ");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(" >> ");
    ((StringBuilder)localObject).append(localArrayList);
    LitePalLog.d("AssociationUpdater", ((StringBuilder)localObject).toString());
    return localArrayList;
  }
  
  private String generateAddColumnSQL(ColumnModel paramColumnModel)
  {
    return generateAddColumnSQL(this.mTableModel.getTableName(), paramColumnModel);
  }
  
  private List<String> generateAddForeignKeySQL()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getForeignKeyColumns(this.mTableModel).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!this.mTableModel.containsColumn(str))
      {
        ColumnModel localColumnModel = new ColumnModel();
        localColumnModel.setColumnName(str);
        localColumnModel.setColumnType("integer");
        localArrayList.add(generateAddColumnSQL(this.mTableModel.getTableName(), localColumnModel));
      }
    }
    return localArrayList;
  }
  
  private List<String> getAddColumnSQLs(List<ColumnModel> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(generateAddColumnSQL((ColumnModel)paramList.next()));
    }
    return localArrayList;
  }
  
  private List<String> getChangeColumnsConstraintsSQL()
  {
    Object localObject = generateAlterToTempTableSQL(this.mTableModel.getTableName());
    String str1 = generateCreateTableSQL(this.mTableModel);
    List localList = generateAddForeignKeySQL();
    String str2 = generateDataMigrationSQL(this.mTableModelDB);
    String str3 = generateDropTempTableSQL(this.mTableModel.getTableName());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localArrayList.add(str1);
    localArrayList.addAll(localList);
    localArrayList.add(str2);
    localArrayList.add(str3);
    LitePalLog.d("AssociationUpdater", "generateChangeConstraintSQL >> ");
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      LitePalLog.d("AssociationUpdater", (String)((Iterator)localObject).next());
    }
    LitePalLog.d("AssociationUpdater", "<< generateChangeConstraintSQL");
    return localArrayList;
  }
  
  private boolean hasNewUniqueOrNotNullColumn()
  {
    Iterator localIterator = this.mTableModel.getColumnModels().iterator();
    while (localIterator.hasNext())
    {
      ColumnModel localColumnModel1 = (ColumnModel)localIterator.next();
      ColumnModel localColumnModel2 = this.mTableModelDB.getColumnModelByName(localColumnModel1.getColumnName());
      if ((localColumnModel1.isUnique()) && ((localColumnModel2 == null) || (!localColumnModel2.isUnique()))) {
        return true;
      }
      if ((localColumnModel2 != null) && (!localColumnModel1.isNullable()) && (localColumnModel2.isNullable())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isNeedToRemove(String paramString)
  {
    return (isRemovedFromClass(paramString)) && (!isIdColumn(paramString)) && (!isForeignKeyColumn(this.mTableModel, paramString));
  }
  
  private boolean isRemovedFromClass(String paramString)
  {
    return this.mTableModel.containsColumn(paramString) ^ true;
  }
  
  private void removeColumns(List<String> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("do removeColumns ");
    ((StringBuilder)localObject).append(paramList);
    LitePalLog.d("AssociationUpdater", ((StringBuilder)localObject).toString());
    removeColumns(paramList, this.mTableModel.getTableName());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      this.mTableModelDB.removeColumnModelByName((String)localObject);
    }
  }
  
  private void upgradeTable()
  {
    if (hasNewUniqueOrNotNullColumn())
    {
      createOrUpgradeTable(this.mTableModel, this.mDb, true);
      Iterator localIterator = getAssociationInfo(this.mTableModel.getClassName()).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (AssociationsInfo)localIterator.next();
        if (((((AssociationsInfo)localObject).getAssociationType() == 2) || (((AssociationsInfo)localObject).getAssociationType() == 1)) && (((AssociationsInfo)localObject).getClassHoldsForeignKey().equalsIgnoreCase(this.mTableModel.getClassName())))
        {
          localObject = DBUtility.getTableNameByClassName(((AssociationsInfo)localObject).getAssociatedClassName());
          addForeignKeyColumn(this.mTableModel.getTableName(), (String)localObject, this.mTableModel.getTableName(), this.mDb);
        }
      }
    }
    this.hasConstraintChanged = false;
    removeColumns(findColumnsToRemove());
    addColumns(findColumnsToAdd());
    changeColumnsType(findColumnTypesToChange());
    changeColumnsConstraints();
  }
  
  protected void createOrUpgradeTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    this.mDb = paramSQLiteDatabase;
    paramSQLiteDatabase = getAllTableModels().iterator();
    while (paramSQLiteDatabase.hasNext())
    {
      Object localObject = (TableModel)paramSQLiteDatabase.next();
      this.mTableModel = ((TableModel)localObject);
      this.mTableModelDB = getTableModelFromDB(((TableModel)localObject).getTableName());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createOrUpgradeTable: model is ");
      ((StringBuilder)localObject).append(this.mTableModel.getTableName());
      LitePalLog.d("AssociationUpdater", ((StringBuilder)localObject).toString());
      upgradeTable();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\Upgrader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */