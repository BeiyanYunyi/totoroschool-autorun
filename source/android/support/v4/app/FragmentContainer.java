package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;

public abstract class FragmentContainer
{
  public Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle)
  {
    return Fragment.instantiate(paramContext, paramString, paramBundle);
  }
  
  @Nullable
  public abstract View onFindViewById(@IdRes int paramInt);
  
  public abstract boolean onHasView();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\app\FragmentContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */