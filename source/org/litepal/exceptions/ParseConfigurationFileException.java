package org.litepal.exceptions;

public class ParseConfigurationFileException
  extends RuntimeException
{
  public static final String CAN_NOT_FIND_LITEPAL_FILE = "litepal.xml file is missing. Please ensure it under assets folder.";
  public static final String FILE_FORMAT_IS_NOT_CORRECT = "can not parse the litepal.xml, check if it's in correct format";
  public static final String IO_EXCEPTION = "IO exception happened";
  public static final String PARSE_CONFIG_FAILED = "parse configuration is failed";
  private static final long serialVersionUID = 1L;
  
  public ParseConfigurationFileException(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\exceptions\ParseConfigurationFileException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */