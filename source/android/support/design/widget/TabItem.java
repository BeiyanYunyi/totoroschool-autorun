package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.R.styleable;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;

public class TabItem
  extends View
{
  public final int customLayout;
  public final Drawable icon;
  public final CharSequence text;
  
  public TabItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.TabItem);
    this.text = paramContext.getText(R.styleable.TabItem_android_text);
    this.icon = paramContext.getDrawable(R.styleable.TabItem_android_icon);
    this.customLayout = paramContext.getResourceId(R.styleable.TabItem_android_layout, 0);
    paramContext.recycle();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\TabItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */