package android.support.v4.app;

import android.app.Notification.Builder;
import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract interface NotificationBuilderWithBuilderAccessor
{
  public abstract Notification.Builder getBuilder();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\app\NotificationBuilderWithBuilderAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */