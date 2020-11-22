package org.litepal.exceptions;

public class InvalidAttributesException
  extends RuntimeException
{
  public static final String CASES_VALUE_IS_INVALID = " is an invalid value for <cases></cases>";
  public static final String DBNAME_IS_EMPTY_OR_NOT_DEFINED = "dbname is empty or not defined in litepal.xml file, or your litepal.xml file is missing.";
  public static final String VERSION_IS_EARLIER_THAN_CURRENT = "the version in litepal.xml is earlier than the current version";
  public static final String VERSION_OF_DATABASE_LESS_THAN_ONE = "the version of database can not be less than 1";
  private static final long serialVersionUID = 1L;
  
  public InvalidAttributesException(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\exceptions\InvalidAttributesException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */