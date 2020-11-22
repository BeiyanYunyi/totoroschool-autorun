package org.litepal.tablemanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.DBUtility;

class Creator
  extends AssociationCreator
{
  public static final String TAG = "Creator";
  
  private String generateDropTableSQL(TableModel paramTableModel)
  {
    return generateDropTableSQL(paramTableModel.getTableName());
  }
  
  protected void createOrUpgradeTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    Iterator localIterator = getAllTableModels().iterator();
    while (localIterator.hasNext()) {
      createOrUpgradeTable((TableModel)localIterator.next(), paramSQLiteDatabase, paramBoolean);
    }
  }
  
  protected void createOrUpgradeTable(TableModel paramTableModel, SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    execute(getCreateTableSQLs(paramTableModel, paramSQLiteDatabase, paramBoolean), paramSQLiteDatabase);
    giveTableSchemaACopy(paramTableModel.getTableName(), 0, paramSQLiteDatabase);
  }
  
  String generateCreateTableSQL(TableModel paramTableModel)
  {
    return generateCreateTableSQL(paramTableModel.getTableName(), paramTableModel.getColumnModels(), true);
  }
  
  protected List<String> getCreateTableSQLs(TableModel paramTableModel, SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(generateDropTableSQL(paramTableModel));
      localArrayList.add(generateCreateTableSQL(paramTableModel));
      return localArrayList;
    }
    if (DBUtility.isTableExists(paramTableModel.getTableName(), paramSQLiteDatabase)) {
      return null;
    }
    localArrayList.add(generateCreateTableSQL(paramTableModel));
    return localArrayList;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\Creator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */