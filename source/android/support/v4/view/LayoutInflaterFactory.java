package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
public abstract interface LayoutInflaterFactory
{
  public abstract View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\view\LayoutInflaterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */