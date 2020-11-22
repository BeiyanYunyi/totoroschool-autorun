package org.litepal.tablemanager.typechange;

public class TextOrm
  extends OrmChange
{
  public String object2Relation(String paramString)
  {
    if (paramString != null) {
      if ((!paramString.equals("char")) && (!paramString.equals("java.lang.Character")))
      {
        if (paramString.equals("java.lang.String")) {
          return "text";
        }
      }
      else {
        return "text";
      }
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\typechange\TextOrm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */