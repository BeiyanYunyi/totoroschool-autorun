package com.totoro.school.utils;

import com.totoro.school.entity.login.login.LoginReturnModel;
import org.litepal.LitePal;

public class i
{
  public static LoginReturnModel a()
  {
    return (LoginReturnModel)LitePal.findLast(LoginReturnModel.class);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */