package org.litepal.exceptions;

public class LitePalSupportException
  extends DataSupportException
{
  public static final String ID_TYPE_INVALID_EXCEPTION = "id type is not supported. Only int or long is acceptable for id";
  public static final String INSTANTIATION_EXCEPTION = " needs a default constructor.";
  public static final String MODEL_IS_NOT_AN_INSTANCE_OF_LITE_PAL_SUPPORT = " should be inherited from LitePalSupport";
  public static final String SAVE_FAILED = "Save current model failed.";
  public static final String UPDATE_CONDITIONS_EXCEPTION = "The parameters in conditions are incorrect.";
  public static final String WRONG_FIELD_TYPE_FOR_ASSOCIATIONS = "The field to declare many2one or many2many associations should be List or Set.";
  private static final long serialVersionUID = 1L;
  
  public LitePalSupportException(String paramString)
  {
    super(paramString);
  }
  
  public LitePalSupportException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public static String noSuchFieldExceptioin(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" field in ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" class is necessary which does not exist.");
    return localStringBuilder.toString();
  }
  
  public static String noSuchMethodException(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" method in ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" class is necessary which does not exist.");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\exceptions\LitePalSupportException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */