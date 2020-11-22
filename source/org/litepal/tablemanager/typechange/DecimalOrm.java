package org.litepal.tablemanager.typechange;

public class DecimalOrm
  extends OrmChange
{
  public String object2Relation(String paramString)
  {
    if (paramString != null) {
      if ((!paramString.equals("float")) && (!paramString.equals("java.lang.Float")))
      {
        if ((paramString.equals("double")) || (paramString.equals("java.lang.Double"))) {
          return "real";
        }
      }
      else {
        return "real";
      }
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\typechange\DecimalOrm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */