package android.support.v4.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

public final class SQLiteCursorCompat
{
  public static void setFillWindowForwardOnly(@NonNull SQLiteCursor paramSQLiteCursor, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      paramSQLiteCursor.setFillWindowForwardOnly(paramBoolean);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\database\sqlite\SQLiteCursorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */