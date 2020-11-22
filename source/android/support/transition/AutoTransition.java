package android.support.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition
  extends TransitionSet
{
  public AutoTransition()
  {
    init();
  }
  
  public AutoTransition(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    setOrdering(1);
    addTransition(new Fade(2)).addTransition(new ChangeBounds()).addTransition(new Fade(1));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\AutoTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */