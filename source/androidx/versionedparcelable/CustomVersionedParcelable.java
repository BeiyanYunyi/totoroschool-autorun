package androidx.versionedparcelable;

import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract class CustomVersionedParcelable
  implements c
{
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void onPostParceling() {}
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void onPreParceling(boolean paramBoolean) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\androidx\versionedparcelable\CustomVersionedParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */