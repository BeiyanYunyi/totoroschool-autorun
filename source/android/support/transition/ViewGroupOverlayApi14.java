package android.support.transition;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupOverlayApi14
  extends ViewOverlayApi14
  implements ViewGroupOverlayImpl
{
  ViewGroupOverlayApi14(Context paramContext, ViewGroup paramViewGroup, View paramView)
  {
    super(paramContext, paramViewGroup, paramView);
  }
  
  static ViewGroupOverlayApi14 createFrom(ViewGroup paramViewGroup)
  {
    return (ViewGroupOverlayApi14)ViewOverlayApi14.createFrom(paramViewGroup);
  }
  
  public void add(@NonNull View paramView)
  {
    this.mOverlayViewGroup.add(paramView);
  }
  
  public void remove(@NonNull View paramView)
  {
    this.mOverlayViewGroup.remove(paramView);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\ViewGroupOverlayApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */