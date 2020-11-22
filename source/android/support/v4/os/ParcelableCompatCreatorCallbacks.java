package android.support.v4.os;

import android.os.Parcel;

@Deprecated
public abstract interface ParcelableCompatCreatorCallbacks<T>
{
  public abstract T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader);
  
  public abstract T[] newArray(int paramInt);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\os\ParcelableCompatCreatorCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */