package org.litepal.tablemanager.typechange;

public class DateOrm
  extends OrmChange
{
  public String object2Relation(String paramString)
  {
    if ((paramString != null) && (paramString.equals("java.util.Date"))) {
      return "integer";
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\typechange\DateOrm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */