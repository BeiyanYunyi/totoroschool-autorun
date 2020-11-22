package org.litepal.tablemanager.typechange;

public class NumericOrm
  extends OrmChange
{
  public String object2Relation(String paramString)
  {
    if (paramString != null) {
      if ((!paramString.equals("int")) && (!paramString.equals("java.lang.Integer")))
      {
        if ((!paramString.equals("long")) && (!paramString.equals("java.lang.Long")))
        {
          if ((paramString.equals("short")) || (paramString.equals("java.lang.Short"))) {
            return "integer";
          }
        }
        else {
          return "integer";
        }
      }
      else {
        return "integer";
      }
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\typechange\NumericOrm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */