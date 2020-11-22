package org.litepal.tablemanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.BaseUtility;

public class Dropper
  extends AssociationUpdater
{
  private Collection<TableModel> mTableModels;
  
  private void dropTables()
  {
    List localList = findTablesToDrop();
    dropTables(localList, this.mDb);
    clearCopyInTableSchema(localList);
  }
  
  /* Error */
  private List<String> findTablesToDrop()
  {
    // Byte code:
    //   0: new 32	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 33	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 21	org/litepal/tablemanager/Dropper:mDb	Lnet/sqlcipher/database/SQLiteDatabase;
    //   13: ldc 35
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 41	net/sqlcipher/database/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   24: astore_2
    //   25: aload_2
    //   26: astore_3
    //   27: aload_2
    //   28: invokeinterface 47 1 0
    //   33: ifeq +114 -> 147
    //   36: aload_2
    //   37: astore_3
    //   38: aload_2
    //   39: aload_2
    //   40: ldc 49
    //   42: invokeinterface 53 2 0
    //   47: invokeinterface 57 2 0
    //   52: astore 4
    //   54: aload_2
    //   55: astore_3
    //   56: aload_0
    //   57: aload 4
    //   59: aload_2
    //   60: aload_2
    //   61: ldc 59
    //   63: invokeinterface 53 2 0
    //   68: invokeinterface 63 2 0
    //   73: invokespecial 67	org/litepal/tablemanager/Dropper:shouldDropThisTable	(Ljava/lang/String;I)Z
    //   76: ifeq +58 -> 134
    //   79: aload_2
    //   80: astore_3
    //   81: new 69	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   88: astore 6
    //   90: aload_2
    //   91: astore_3
    //   92: aload 6
    //   94: ldc 72
    //   96: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_2
    //   101: astore_3
    //   102: aload 6
    //   104: aload 4
    //   106: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_2
    //   111: astore_3
    //   112: ldc 78
    //   114: aload 6
    //   116: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 88	org/litepal/util/LitePalLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_2
    //   123: astore_3
    //   124: aload 5
    //   126: aload 4
    //   128: invokeinterface 94 2 0
    //   133: pop
    //   134: aload_2
    //   135: astore_3
    //   136: aload_2
    //   137: invokeinterface 97 1 0
    //   142: istore_1
    //   143: iload_1
    //   144: ifne -108 -> 36
    //   147: aload_2
    //   148: ifnull +38 -> 186
    //   151: goto +29 -> 180
    //   154: astore 4
    //   156: goto +13 -> 169
    //   159: astore_2
    //   160: aconst_null
    //   161: astore_3
    //   162: goto +28 -> 190
    //   165: astore 4
    //   167: aconst_null
    //   168: astore_2
    //   169: aload_2
    //   170: astore_3
    //   171: aload 4
    //   173: invokevirtual 100	java/lang/Exception:printStackTrace	()V
    //   176: aload_2
    //   177: ifnull +9 -> 186
    //   180: aload_2
    //   181: invokeinterface 103 1 0
    //   186: aload 5
    //   188: areturn
    //   189: astore_2
    //   190: aload_3
    //   191: ifnull +9 -> 200
    //   194: aload_3
    //   195: invokeinterface 103 1 0
    //   200: aload_2
    //   201: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	Dropper
    //   142	2	1	bool	boolean
    //   24	124	2	localCursor	net.sqlcipher.Cursor
    //   159	1	2	localObject1	Object
    //   168	13	2	localObject2	Object
    //   189	12	2	localObject3	Object
    //   26	169	3	localObject4	Object
    //   52	75	4	str	String
    //   154	1	4	localException1	Exception
    //   165	7	4	localException2	Exception
    //   7	180	5	localArrayList	ArrayList
    //   88	27	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   27	36	154	java/lang/Exception
    //   38	54	154	java/lang/Exception
    //   56	79	154	java/lang/Exception
    //   81	90	154	java/lang/Exception
    //   92	100	154	java/lang/Exception
    //   102	110	154	java/lang/Exception
    //   112	122	154	java/lang/Exception
    //   124	134	154	java/lang/Exception
    //   136	143	154	java/lang/Exception
    //   9	25	159	finally
    //   9	25	165	java/lang/Exception
    //   27	36	189	finally
    //   38	54	189	finally
    //   56	79	189	finally
    //   81	90	189	finally
    //   92	100	189	finally
    //   102	110	189	finally
    //   112	122	189	finally
    //   124	134	189	finally
    //   136	143	189	finally
    //   171	176	189	finally
  }
  
  private List<String> pickTableNamesFromTableModels()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mTableModels.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((TableModel)localIterator.next()).getTableName());
    }
    return localArrayList;
  }
  
  private boolean shouldDropThisTable(String paramString, int paramInt)
  {
    return (!BaseUtility.containsIgnoreCases(pickTableNamesFromTableModels(), paramString)) && (paramInt == 0);
  }
  
  protected void createOrUpgradeTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    this.mTableModels = getAllTableModels();
    this.mDb = paramSQLiteDatabase;
    dropTables();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\Dropper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */