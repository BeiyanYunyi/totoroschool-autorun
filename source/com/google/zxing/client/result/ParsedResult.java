package com.google.zxing.client.result;

public abstract class ParsedResult
{
  private final ParsedResultType type;
  
  protected ParsedResult(ParsedResultType paramParsedResultType)
  {
    this.type = paramParsedResultType;
  }
  
  public static void maybeAppend(String paramString, StringBuilder paramStringBuilder)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if (paramStringBuilder.length() > 0) {
        paramStringBuilder.append('\n');
      }
      paramStringBuilder.append(paramString);
    }
  }
  
  public static void maybeAppend(String[] paramArrayOfString, StringBuilder paramStringBuilder)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        maybeAppend(paramArrayOfString[i], paramStringBuilder);
        i += 1;
      }
    }
  }
  
  public abstract String getDisplayResult();
  
  public final ParsedResultType getType()
  {
    return this.type;
  }
  
  public final String toString()
  {
    return getDisplayResult();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\ParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */