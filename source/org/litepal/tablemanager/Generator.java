package org.litepal.tablemanager;

import android.database.SQLException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.LitePalBase;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.parser.LitePalAttr;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.BaseUtility;

public abstract class Generator
  extends LitePalBase
{
  public static final String TAG = "Generator";
  private Collection<AssociationsModel> mAllRelationModels;
  private Collection<TableModel> mTableModels;
  
  private static void addAssociation(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    new Creator().addOrUpdateAssociation(paramSQLiteDatabase, paramBoolean);
  }
  
  private boolean canUseCache()
  {
    Collection localCollection = this.mTableModels;
    boolean bool = false;
    if (localCollection == null) {
      return false;
    }
    if (this.mTableModels.size() == LitePalAttr.getInstance().getClassNames().size()) {
      bool = true;
    }
    return bool;
  }
  
  static void create(SQLiteDatabase paramSQLiteDatabase)
  {
    create(paramSQLiteDatabase, true);
    addAssociation(paramSQLiteDatabase, true);
  }
  
  private static void create(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    new Creator().createOrUpgradeTable(paramSQLiteDatabase, paramBoolean);
  }
  
  private static void drop(SQLiteDatabase paramSQLiteDatabase)
  {
    new Dropper().createOrUpgradeTable(paramSQLiteDatabase, false);
  }
  
  private static void updateAssociations(SQLiteDatabase paramSQLiteDatabase)
  {
    new Upgrader().addOrUpdateAssociation(paramSQLiteDatabase, false);
  }
  
  static void upgrade(SQLiteDatabase paramSQLiteDatabase)
  {
    drop(paramSQLiteDatabase);
    create(paramSQLiteDatabase, false);
    updateAssociations(paramSQLiteDatabase);
    upgradeTables(paramSQLiteDatabase);
    addAssociation(paramSQLiteDatabase, false);
  }
  
  private static void upgradeTables(SQLiteDatabase paramSQLiteDatabase)
  {
    new Upgrader().createOrUpgradeTable(paramSQLiteDatabase, false);
  }
  
  protected abstract void addOrUpdateAssociation(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean);
  
  protected abstract void createOrUpgradeTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean);
  
  protected void execute(List<String> paramList, SQLiteDatabase paramSQLiteDatabase)
  {
    String str = "";
    if (paramList != null) {
      localObject = str;
    }
    for (;;)
    {
      try
      {
        if (!paramList.isEmpty())
        {
          localObject = str;
          Iterator localIterator = paramList.iterator();
          paramList = str;
          localObject = paramList;
          if (localIterator.hasNext())
          {
            localObject = paramList;
            str = (String)localIterator.next();
            localObject = paramList;
            if (TextUtils.isEmpty(str)) {
              continue;
            }
            localObject = paramList;
            paramList = BaseUtility.changeCase(str);
          }
        }
      }
      catch (SQLException paramList)
      {
        continue;
      }
      try
      {
        paramSQLiteDatabase.execSQL(paramList);
      }
      catch (SQLException paramSQLiteDatabase) {}
    }
    Object localObject = paramList;
    paramList = new StringBuilder();
    paramList.append("An exception that indicates there was an error with SQL parsing or execution. ");
    paramList.append((String)localObject);
    throw new DatabaseGenerateException(paramList.toString());
  }
  
  protected Collection<AssociationsModel> getAllAssociations()
  {
    if ((this.mAllRelationModels == null) || (this.mAllRelationModels.isEmpty())) {
      this.mAllRelationModels = getAssociations(LitePalAttr.getInstance().getClassNames());
    }
    return this.mAllRelationModels;
  }
  
  protected Collection<TableModel> getAllTableModels()
  {
    if (this.mTableModels == null) {
      this.mTableModels = new ArrayList();
    }
    if (!canUseCache())
    {
      this.mTableModels.clear();
      Iterator localIterator = LitePalAttr.getInstance().getClassNames().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.mTableModels.add(getTableModel(str));
      }
    }
    return this.mTableModels;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\Generator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */