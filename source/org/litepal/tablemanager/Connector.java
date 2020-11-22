package org.litepal.tablemanager;

import android.content.Context;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import java.io.File;
import net.sqlcipher.database.SQLiteDatabase;
import org.litepal.LitePalApplication;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.parser.LitePalAttr;
import org.litepal.util.BaseUtility;

public class Connector
{
  private static LitePalOpenHelper mLitePalHelper;
  private static final String psw_key = "e8fhdsfbusdffe";
  
  private static LitePalOpenHelper buildConnection()
  {
    LitePalAttr localLitePalAttr = LitePalAttr.getInstance();
    localLitePalAttr.checkSelfValid();
    if (mLitePalHelper == null)
    {
      String str = localLitePalAttr.getDbName();
      Object localObject1;
      if ("external".equalsIgnoreCase(localLitePalAttr.getStorage()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(LitePalApplication.getContext().getExternalFilesDir(""));
        ((StringBuilder)localObject1).append("/databases/");
        ((StringBuilder)localObject1).append(str);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = str;
        if (!"internal".equalsIgnoreCase(localLitePalAttr.getStorage()))
        {
          localObject1 = str;
          if (!TextUtils.isEmpty(localLitePalAttr.getStorage()))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getPath());
            ((StringBuilder)localObject1).append("/");
            ((StringBuilder)localObject1).append(localLitePalAttr.getStorage());
            localObject1 = ((StringBuilder)localObject1).toString().replace("//", "/");
            if ((BaseUtility.isClassAndMethodExist("android.support.v4.content.ContextCompat", "checkSelfPermission")) && (ContextCompat.checkSelfPermission(LitePalApplication.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0)) {
              throw new DatabaseGenerateException(String.format("You don't have permission to access database at %1$s. Make sure you handled WRITE_EXTERNAL_STORAGE runtime permission correctly.", new Object[] { localObject1 }));
            }
            Object localObject2 = new File((String)localObject1);
            if (!((File)localObject2).exists()) {
              ((File)localObject2).mkdirs();
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("/");
            ((StringBuilder)localObject2).append(str);
            localObject1 = ((StringBuilder)localObject2).toString();
          }
        }
      }
      mLitePalHelper = new LitePalOpenHelper((String)localObject1, localLitePalAttr.getVersion());
    }
    return mLitePalHelper;
  }
  
  public static void clearLitePalOpenHelperInstance()
  {
    if (mLitePalHelper != null)
    {
      mLitePalHelper.getWritableDatabase("e8fhdsfbusdffe").close();
      mLitePalHelper = null;
    }
  }
  
  public static SQLiteDatabase getDatabase()
  {
    return getWritableDatabase();
  }
  
  public static SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = buildConnection().getWritableDatabase("e8fhdsfbusdffe");
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\Connector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */