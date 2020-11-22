package com.tencent.smtt.export.external.interfaces;

public abstract interface IX5WebBackForwardList
{
  public abstract int getCurrentIndex();
  
  public abstract IX5WebHistoryItem getCurrentItem();
  
  public abstract IX5WebHistoryItem getItemAtIndex(int paramInt);
  
  public abstract int getSize();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\export\external\interfaces\IX5WebBackForwardList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */