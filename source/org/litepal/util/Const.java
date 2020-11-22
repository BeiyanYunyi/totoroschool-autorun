package org.litepal.util;

public abstract interface Const
{
  public static abstract interface Config
  {
    public static final String CASES_KEEP = "keep";
    public static final String CASES_LOWER = "lower";
    public static final String CASES_UPPER = "upper";
    public static final String CONFIGURATION_FILE_NAME = "litepal.xml";
    public static final String DB_NAME_SUFFIX = ".db";
  }
  
  public static abstract interface Model
  {
    public static final int MANY_TO_MANY = 3;
    public static final int MANY_TO_ONE = 2;
    public static final int ONE_TO_ONE = 1;
  }
  
  public static abstract interface TableSchema
  {
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TYPE = "type";
    public static final int GENERIC_TABLE = 2;
    public static final int INTERMEDIATE_JOIN_TABLE = 1;
    public static final int NORMAL_TABLE = 0;
    public static final String TABLE_NAME = "table_schema";
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\util\Const.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */