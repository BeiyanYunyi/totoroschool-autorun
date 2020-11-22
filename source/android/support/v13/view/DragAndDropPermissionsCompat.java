package android.support.v13.view;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

public final class DragAndDropPermissionsCompat
{
  private Object mDragAndDropPermissions;
  
  private DragAndDropPermissionsCompat(Object paramObject)
  {
    this.mDragAndDropPermissions = paramObject;
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static DragAndDropPermissionsCompat request(Activity paramActivity, DragEvent paramDragEvent)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramActivity = paramActivity.requestDragAndDropPermissions(paramDragEvent);
      if (paramActivity != null) {
        return new DragAndDropPermissionsCompat(paramActivity);
      }
    }
    return null;
  }
  
  public void release()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      ((DragAndDropPermissions)this.mDragAndDropPermissions).release();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v13\view\DragAndDropPermissionsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */