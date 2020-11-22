package org.litepal.tablemanager;

import android.content.Context;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabase.CursorFactory;
import net.sqlcipher.database.SQLiteOpenHelper;
import org.litepal.LitePalApplication;
import org.litepal.Operator;
import org.litepal.parser.LitePalAttr;
import org.litepal.tablemanager.callback.DatabaseListener;
import org.litepal.util.SharedUtil;

class LitePalOpenHelper
  extends SQLiteOpenHelper
{
  public static final String TAG = "LitePalHelper";
  
  LitePalOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  LitePalOpenHelper(String paramString, int paramInt)
  {
    this(LitePalApplication.getContext(), paramString, null, paramInt);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Generator.create(paramSQLiteDatabase);
    paramSQLiteDatabase = Operator.getDBListener();
    if (paramSQLiteDatabase != null) {
      paramSQLiteDatabase.onCreate();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Generator.upgrade(paramSQLiteDatabase);
    SharedUtil.updateVersion(LitePalAttr.getInstance().getExtraKeyName(), paramInt2);
    paramSQLiteDatabase = Operator.getDBListener();
    if (paramSQLiteDatabase != null) {
      paramSQLiteDatabase.onUpgrade(paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\LitePalOpenHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */