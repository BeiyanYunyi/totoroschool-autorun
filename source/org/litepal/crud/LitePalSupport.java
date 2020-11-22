package org.litepal.crud;

import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.Operator;
import org.litepal.crud.async.SaveExecutor;
import org.litepal.crud.async.UpdateOrDeleteExecutor;
import org.litepal.crud.callback.SaveCallback;
import org.litepal.crud.callback.UpdateOrDeleteCallback;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

public class LitePalSupport
{
  protected static final String AES = "AES";
  protected static final String MD5 = "MD5";
  Map<String, List<Long>> associatedModelsMapForJoinTable;
  private Map<String, Set<Long>> associatedModelsMapWithFK;
  private Map<String, Long> associatedModelsMapWithoutFK;
  long baseObjId;
  private List<String> fieldsToSetToDefault;
  private List<String> listToClearAssociatedFK;
  private List<String> listToClearSelfFK;
  
  private void clearFKNameList()
  {
    getListToClearSelfFK().clear();
    getListToClearAssociatedFK().clear();
  }
  
  private void clearIdOfModelForJoinTable()
  {
    Iterator localIterator = getAssociatedModelsMapForJoinTable().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((List)this.associatedModelsMapForJoinTable.get(str)).clear();
    }
    this.associatedModelsMapForJoinTable.clear();
  }
  
  private void clearIdOfModelWithFK()
  {
    Iterator localIterator = getAssociatedModelsMapWithFK().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((Set)this.associatedModelsMapWithFK.get(str)).clear();
    }
    this.associatedModelsMapWithFK.clear();
  }
  
  private void clearIdOfModelWithoutFK()
  {
    getAssociatedModelsMapWithoutFK().clear();
  }
  
  void addAssociatedModelForJoinTable(String paramString, long paramLong)
  {
    Object localObject = (List)getAssociatedModelsMapForJoinTable().get(paramString);
    if (localObject == null)
    {
      localObject = new ArrayList();
      ((List)localObject).add(Long.valueOf(paramLong));
      this.associatedModelsMapForJoinTable.put(paramString, localObject);
      return;
    }
    ((List)localObject).add(Long.valueOf(paramLong));
  }
  
  void addAssociatedModelWithFK(String paramString, long paramLong)
  {
    Object localObject = (Set)getAssociatedModelsMapWithFK().get(paramString);
    if (localObject == null)
    {
      localObject = new HashSet();
      ((Set)localObject).add(Long.valueOf(paramLong));
      this.associatedModelsMapWithFK.put(paramString, localObject);
      return;
    }
    ((Set)localObject).add(Long.valueOf(paramLong));
  }
  
  void addAssociatedModelWithoutFK(String paramString, long paramLong)
  {
    getAssociatedModelsMapWithoutFK().put(paramString, Long.valueOf(paramLong));
  }
  
  void addAssociatedTableNameToClearFK(String paramString)
  {
    List localList = getListToClearAssociatedFK();
    if (!localList.contains(paramString)) {
      localList.add(paramString);
    }
  }
  
  void addEmptyModelForJoinTable(String paramString)
  {
    if ((List)getAssociatedModelsMapForJoinTable().get(paramString) == null)
    {
      ArrayList localArrayList = new ArrayList();
      this.associatedModelsMapForJoinTable.put(paramString, localArrayList);
    }
  }
  
  void addFKNameToClearSelf(String paramString)
  {
    List localList = getListToClearSelfFK();
    if (!localList.contains(paramString)) {
      localList.add(paramString);
    }
  }
  
  public void assignBaseObjId(int paramInt)
  {
    this.baseObjId = paramInt;
  }
  
  void clearAssociatedData()
  {
    clearIdOfModelWithFK();
    clearIdOfModelWithoutFK();
    clearIdOfModelForJoinTable();
    clearFKNameList();
  }
  
  public void clearSavedState()
  {
    this.baseObjId = 0L;
  }
  
  /* Error */
  public int delete()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 162	org/litepal/tablemanager/Connector:getDatabase	()Lnet/sqlcipher/database/SQLiteDatabase;
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 167	net/sqlcipher/database/SQLiteDatabase:beginTransaction	()V
    //   11: new 169	org/litepal/crud/DeleteHandler
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 172	org/litepal/crud/DeleteHandler:<init>	(Lnet/sqlcipher/database/SQLiteDatabase;)V
    //   19: aload_0
    //   20: invokevirtual 176	org/litepal/crud/DeleteHandler:onDelete	(Lorg/litepal/crud/LitePalSupport;)I
    //   23: istore_1
    //   24: aload_0
    //   25: lconst_0
    //   26: putfield 144	org/litepal/crud/LitePalSupport:baseObjId	J
    //   29: aload_2
    //   30: invokevirtual 179	net/sqlcipher/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   33: aload_2
    //   34: invokevirtual 182	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   37: ldc 2
    //   39: monitorexit
    //   40: iload_1
    //   41: ireturn
    //   42: astore_3
    //   43: aload_2
    //   44: invokevirtual 182	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   47: aload_3
    //   48: athrow
    //   49: astore_2
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	LitePalSupport
    //   23	18	1	i	int
    //   6	38	2	localSQLiteDatabase	net.sqlcipher.database.SQLiteDatabase
    //   49	5	2	localObject1	Object
    //   42	6	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	33	42	finally
    //   3	11	49	finally
    //   33	40	49	finally
    //   43	49	49	finally
    //   50	53	49	finally
  }
  
  public UpdateOrDeleteExecutor deleteAsync()
  {
    final UpdateOrDeleteExecutor localUpdateOrDeleteExecutor = new UpdateOrDeleteExecutor();
    localUpdateOrDeleteExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final int i = LitePalSupport.this.delete();
          if (localUpdateOrDeleteExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                LitePalSupport.1.this.val$executor.getListener().onFinish(i);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localUpdateOrDeleteExecutor;
  }
  
  Map<String, List<Long>> getAssociatedModelsMapForJoinTable()
  {
    if (this.associatedModelsMapForJoinTable == null) {
      this.associatedModelsMapForJoinTable = new HashMap();
    }
    return this.associatedModelsMapForJoinTable;
  }
  
  Map<String, Set<Long>> getAssociatedModelsMapWithFK()
  {
    if (this.associatedModelsMapWithFK == null) {
      this.associatedModelsMapWithFK = new HashMap();
    }
    return this.associatedModelsMapWithFK;
  }
  
  Map<String, Long> getAssociatedModelsMapWithoutFK()
  {
    if (this.associatedModelsMapWithoutFK == null) {
      this.associatedModelsMapWithoutFK = new HashMap();
    }
    return this.associatedModelsMapWithoutFK;
  }
  
  protected long getBaseObjId()
  {
    return this.baseObjId;
  }
  
  protected String getClassName()
  {
    return getClass().getName();
  }
  
  List<String> getFieldsToSetToDefault()
  {
    if (this.fieldsToSetToDefault == null) {
      this.fieldsToSetToDefault = new ArrayList();
    }
    return this.fieldsToSetToDefault;
  }
  
  List<String> getListToClearAssociatedFK()
  {
    if (this.listToClearAssociatedFK == null) {
      this.listToClearAssociatedFK = new ArrayList();
    }
    return this.listToClearAssociatedFK;
  }
  
  List<String> getListToClearSelfFK()
  {
    if (this.listToClearSelfFK == null) {
      this.listToClearSelfFK = new ArrayList();
    }
    return this.listToClearSelfFK;
  }
  
  protected String getTableName()
  {
    return BaseUtility.changeCase(DBUtility.getTableNameByClassName(getClassName()));
  }
  
  public boolean isSaved()
  {
    return this.baseObjId > 0L;
  }
  
  public boolean save()
  {
    try
    {
      saveThrows();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public SaveExecutor saveAsync()
  {
    final SaveExecutor localSaveExecutor = new SaveExecutor();
    localSaveExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final boolean bool = LitePalSupport.this.save();
          if (localSaveExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                LitePalSupport.4.this.val$executor.getListener().onFinish(bool);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localSaveExecutor;
  }
  
  @Deprecated
  public boolean saveIfNotExist(String... paramVarArgs)
  {
    if (!Operator.isExist(getClass(), paramVarArgs)) {
      return save();
    }
    return false;
  }
  
  /* Error */
  public boolean saveOrUpdate(String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnonnull +13 -> 17
    //   7: aload_0
    //   8: invokevirtual 268	org/litepal/crud/LitePalSupport:save	()Z
    //   11: istore_2
    //   12: ldc 2
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_1
    //   18: invokestatic 274	org/litepal/Operator:where	([Ljava/lang/String;)Lorg/litepal/FluentQuery;
    //   21: aload_0
    //   22: invokevirtual 211	java/lang/Object:getClass	()Ljava/lang/Class;
    //   25: invokevirtual 280	org/litepal/FluentQuery:find	(Ljava/lang/Class;)Ljava/util/List;
    //   28: astore_3
    //   29: aload_3
    //   30: invokeinterface 283 1 0
    //   35: ifeq +13 -> 48
    //   38: aload_0
    //   39: invokevirtual 268	org/litepal/crud/LitePalSupport:save	()Z
    //   42: istore_2
    //   43: ldc 2
    //   45: monitorexit
    //   46: iload_2
    //   47: ireturn
    //   48: invokestatic 162	org/litepal/tablemanager/Connector:getDatabase	()Lnet/sqlcipher/database/SQLiteDatabase;
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 167	net/sqlcipher/database/SQLiteDatabase:beginTransaction	()V
    //   56: aload_3
    //   57: invokeinterface 284 1 0
    //   62: astore_3
    //   63: aload_3
    //   64: invokeinterface 84 1 0
    //   69: ifeq +38 -> 107
    //   72: aload_0
    //   73: aload_3
    //   74: invokeinterface 88 1 0
    //   79: checkcast 2	org/litepal/crud/LitePalSupport
    //   82: invokevirtual 286	org/litepal/crud/LitePalSupport:getBaseObjId	()J
    //   85: putfield 144	org/litepal/crud/LitePalSupport:baseObjId	J
    //   88: new 288	org/litepal/crud/SaveHandler
    //   91: dup
    //   92: aload_1
    //   93: invokespecial 289	org/litepal/crud/SaveHandler:<init>	(Lnet/sqlcipher/database/SQLiteDatabase;)V
    //   96: aload_0
    //   97: invokevirtual 293	org/litepal/crud/SaveHandler:onSave	(Lorg/litepal/crud/LitePalSupport;)V
    //   100: aload_0
    //   101: invokevirtual 295	org/litepal/crud/LitePalSupport:clearAssociatedData	()V
    //   104: goto -41 -> 63
    //   107: aload_1
    //   108: invokevirtual 179	net/sqlcipher/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   111: aload_1
    //   112: invokevirtual 182	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   115: ldc 2
    //   117: monitorexit
    //   118: iconst_1
    //   119: ireturn
    //   120: astore_3
    //   121: goto +17 -> 138
    //   124: astore_3
    //   125: aload_3
    //   126: invokevirtual 248	java/lang/Exception:printStackTrace	()V
    //   129: aload_1
    //   130: invokevirtual 182	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   133: ldc 2
    //   135: monitorexit
    //   136: iconst_0
    //   137: ireturn
    //   138: aload_1
    //   139: invokevirtual 182	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   142: aload_3
    //   143: athrow
    //   144: ldc 2
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    //   149: astore_1
    //   150: goto -6 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	LitePalSupport
    //   0	153	1	paramVarArgs	String[]
    //   11	36	2	bool	boolean
    //   28	46	3	localObject1	Object
    //   120	1	3	localObject2	Object
    //   124	19	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   56	63	120	finally
    //   63	104	120	finally
    //   107	111	120	finally
    //   125	129	120	finally
    //   56	63	124	java/lang/Exception
    //   63	104	124	java/lang/Exception
    //   107	111	124	java/lang/Exception
    //   7	15	149	finally
    //   17	46	149	finally
    //   48	56	149	finally
    //   111	118	149	finally
    //   129	136	149	finally
    //   138	144	149	finally
    //   144	147	149	finally
  }
  
  public SaveExecutor saveOrUpdateAsync(final String... paramVarArgs)
  {
    final SaveExecutor localSaveExecutor = new SaveExecutor();
    localSaveExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final boolean bool = LitePalSupport.this.saveOrUpdate(paramVarArgs);
          if (localSaveExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                LitePalSupport.5.this.val$executor.getListener().onFinish(bool);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localSaveExecutor;
  }
  
  /* Error */
  public void saveThrows()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 162	org/litepal/tablemanager/Connector:getDatabase	()Lnet/sqlcipher/database/SQLiteDatabase;
    //   6: astore_1
    //   7: aload_1
    //   8: invokevirtual 167	net/sqlcipher/database/SQLiteDatabase:beginTransaction	()V
    //   11: new 288	org/litepal/crud/SaveHandler
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 289	org/litepal/crud/SaveHandler:<init>	(Lnet/sqlcipher/database/SQLiteDatabase;)V
    //   19: aload_0
    //   20: invokevirtual 293	org/litepal/crud/SaveHandler:onSave	(Lorg/litepal/crud/LitePalSupport;)V
    //   23: aload_0
    //   24: invokevirtual 295	org/litepal/crud/LitePalSupport:clearAssociatedData	()V
    //   27: aload_1
    //   28: invokevirtual 179	net/sqlcipher/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   31: aload_1
    //   32: invokevirtual 182	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   35: ldc 2
    //   37: monitorexit
    //   38: return
    //   39: astore_2
    //   40: goto +17 -> 57
    //   43: astore_2
    //   44: new 302	org/litepal/exceptions/LitePalSupportException
    //   47: dup
    //   48: aload_2
    //   49: invokevirtual 305	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   52: aload_2
    //   53: invokespecial 308	org/litepal/exceptions/LitePalSupportException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   56: athrow
    //   57: aload_1
    //   58: invokevirtual 182	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   61: aload_2
    //   62: athrow
    //   63: astore_1
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	LitePalSupport
    //   6	52	1	localSQLiteDatabase	net.sqlcipher.database.SQLiteDatabase
    //   63	5	1	localObject1	Object
    //   39	1	2	localObject2	Object
    //   43	19	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   11	31	39	finally
    //   44	57	39	finally
    //   11	31	43	java/lang/Exception
    //   3	11	63	finally
    //   31	38	63	finally
    //   57	63	63	finally
    //   64	67	63	finally
  }
  
  public void setToDefault(String paramString)
  {
    getFieldsToSetToDefault().add(paramString);
  }
  
  public int update(long paramLong)
  {
    try
    {
      int i = new UpdateHandler(Connector.getDatabase()).onUpdate(this, paramLong);
      getFieldsToSetToDefault().clear();
      return i;
    }
    catch (Exception localException)
    {
      throw new LitePalSupportException(localException.getMessage(), localException);
      throw localException;
    }
    finally
    {
      for (;;) {}
    }
  }
  
  public int updateAll(String... paramVarArgs)
  {
    try
    {
      int i = new UpdateHandler(Connector.getDatabase()).onUpdateAll(this, paramVarArgs);
      getFieldsToSetToDefault().clear();
      return i;
    }
    catch (Exception paramVarArgs)
    {
      throw new LitePalSupportException(paramVarArgs.getMessage(), paramVarArgs);
      throw paramVarArgs;
    }
    finally
    {
      for (;;) {}
    }
  }
  
  public UpdateOrDeleteExecutor updateAllAsync(final String... paramVarArgs)
  {
    final UpdateOrDeleteExecutor localUpdateOrDeleteExecutor = new UpdateOrDeleteExecutor();
    localUpdateOrDeleteExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final int i = LitePalSupport.this.updateAll(paramVarArgs);
          if (localUpdateOrDeleteExecutor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                LitePalSupport.3.this.val$executor.getListener().onFinish(i);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localUpdateOrDeleteExecutor;
  }
  
  public UpdateOrDeleteExecutor updateAsync(final long paramLong)
  {
    UpdateOrDeleteExecutor localUpdateOrDeleteExecutor = new UpdateOrDeleteExecutor();
    localUpdateOrDeleteExecutor.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          final int i = LitePalSupport.this.update(paramLong);
          if (this.val$executor.getListener() != null) {
            Operator.getHandler().post(new Runnable()
            {
              public void run()
              {
                LitePalSupport.2.this.val$executor.getListener().onFinish(i);
              }
            });
          }
          return;
        }
        finally {}
      }
    });
    return localUpdateOrDeleteExecutor;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\crud\LitePalSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */