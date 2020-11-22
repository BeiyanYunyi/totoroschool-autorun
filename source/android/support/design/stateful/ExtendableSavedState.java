package android.support.design.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.AbsSavedState;

public class ExtendableSavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new Parcelable.ClassLoaderCreator()
  {
    public ExtendableSavedState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ExtendableSavedState(paramAnonymousParcel, null, null);
    }
    
    public ExtendableSavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
    {
      return new ExtendableSavedState(paramAnonymousParcel, paramAnonymousClassLoader, null);
    }
    
    public ExtendableSavedState[] newArray(int paramAnonymousInt)
    {
      return new ExtendableSavedState[paramAnonymousInt];
    }
  };
  public final SimpleArrayMap<String, Bundle> extendableStates;
  
  private ExtendableSavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    int j = paramParcel.readInt();
    paramClassLoader = new String[j];
    paramParcel.readStringArray(paramClassLoader);
    Bundle[] arrayOfBundle = new Bundle[j];
    paramParcel.readTypedArray(arrayOfBundle, Bundle.CREATOR);
    this.extendableStates = new SimpleArrayMap(j);
    int i = 0;
    while (i < j)
    {
      this.extendableStates.put(paramClassLoader[i], arrayOfBundle[i]);
      i += 1;
    }
  }
  
  public ExtendableSavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
    this.extendableStates = new SimpleArrayMap();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtendableSavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" states=");
    localStringBuilder.append(this.extendableStates);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    int i = this.extendableStates.size();
    paramParcel.writeInt(i);
    String[] arrayOfString = new String[i];
    Bundle[] arrayOfBundle = new Bundle[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfString[paramInt] = ((String)this.extendableStates.keyAt(paramInt));
      arrayOfBundle[paramInt] = ((Bundle)this.extendableStates.valueAt(paramInt));
      paramInt += 1;
    }
    paramParcel.writeStringArray(arrayOfString);
    paramParcel.writeTypedArray(arrayOfBundle, 0);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\stateful\ExtendableSavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */