package org.litepal.tablemanager.typechange;

public class BlobOrm
  extends OrmChange
{
  public String object2Relation(String paramString)
  {
    if ((paramString != null) && (paramString.equals("[B"))) {
      return "blob";
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\typechange\BlobOrm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */