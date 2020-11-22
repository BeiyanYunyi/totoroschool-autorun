package android.support.v4.os;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.Locale;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
abstract interface LocaleListInterface
{
  public abstract boolean equals(Object paramObject);
  
  public abstract Locale get(int paramInt);
  
  @Nullable
  public abstract Locale getFirstMatch(String[] paramArrayOfString);
  
  public abstract Object getLocaleList();
  
  public abstract int hashCode();
  
  @IntRange(from=-1L)
  public abstract int indexOf(Locale paramLocale);
  
  public abstract boolean isEmpty();
  
  public abstract void setLocaleList(@NonNull Locale... paramVarArgs);
  
  @IntRange(from=0L)
  public abstract int size();
  
  public abstract String toLanguageTags();
  
  public abstract String toString();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\os\LocaleListInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */