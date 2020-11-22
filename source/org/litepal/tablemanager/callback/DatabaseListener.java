package org.litepal.tablemanager.callback;

public abstract interface DatabaseListener
{
  public abstract void onCreate();
  
  public abstract void onUpgrade(int paramInt1, int paramInt2);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\tablemanager\callback\DatabaseListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */