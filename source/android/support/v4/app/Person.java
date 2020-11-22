package android.support.v4.app;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.IconCompat;

public class Person
{
  private static final String ICON_KEY = "icon";
  private static final String IS_BOT_KEY = "isBot";
  private static final String IS_IMPORTANT_KEY = "isImportant";
  private static final String KEY_KEY = "key";
  private static final String NAME_KEY = "name";
  private static final String URI_KEY = "uri";
  @Nullable
  IconCompat mIcon;
  boolean mIsBot;
  boolean mIsImportant;
  @Nullable
  String mKey;
  @Nullable
  CharSequence mName;
  @Nullable
  String mUri;
  
  Person(Builder paramBuilder)
  {
    this.mName = paramBuilder.mName;
    this.mIcon = paramBuilder.mIcon;
    this.mUri = paramBuilder.mUri;
    this.mKey = paramBuilder.mKey;
    this.mIsBot = paramBuilder.mIsBot;
    this.mIsImportant = paramBuilder.mIsImportant;
  }
  
  @NonNull
  @RequiresApi(28)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static Person fromAndroidPerson(@NonNull android.app.Person paramPerson)
  {
    Builder localBuilder = new Builder().setName(paramPerson.getName());
    IconCompat localIconCompat;
    if (paramPerson.getIcon() != null) {
      localIconCompat = IconCompat.createFromIcon(paramPerson.getIcon());
    } else {
      localIconCompat = null;
    }
    return localBuilder.setIcon(localIconCompat).setUri(paramPerson.getUri()).setKey(paramPerson.getKey()).setBot(paramPerson.isBot()).setImportant(paramPerson.isImportant()).build();
  }
  
  @NonNull
  public static Person fromBundle(@NonNull Bundle paramBundle)
  {
    Object localObject = paramBundle.getBundle("icon");
    Builder localBuilder = new Builder().setName(paramBundle.getCharSequence("name"));
    if (localObject != null) {
      localObject = IconCompat.createFromBundle((Bundle)localObject);
    } else {
      localObject = null;
    }
    return localBuilder.setIcon((IconCompat)localObject).setUri(paramBundle.getString("uri")).setKey(paramBundle.getString("key")).setBot(paramBundle.getBoolean("isBot")).setImportant(paramBundle.getBoolean("isImportant")).build();
  }
  
  @Nullable
  public IconCompat getIcon()
  {
    return this.mIcon;
  }
  
  @Nullable
  public String getKey()
  {
    return this.mKey;
  }
  
  @Nullable
  public CharSequence getName()
  {
    return this.mName;
  }
  
  @Nullable
  public String getUri()
  {
    return this.mUri;
  }
  
  public boolean isBot()
  {
    return this.mIsBot;
  }
  
  public boolean isImportant()
  {
    return this.mIsImportant;
  }
  
  @NonNull
  @RequiresApi(28)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public android.app.Person toAndroidPerson()
  {
    android.app.Person.Builder localBuilder = new android.app.Person.Builder().setName(getName());
    Icon localIcon;
    if (getIcon() != null) {
      localIcon = getIcon().toIcon();
    } else {
      localIcon = null;
    }
    return localBuilder.setIcon(localIcon).setUri(getUri()).setKey(getKey()).setBot(isBot()).setImportant(isImportant()).build();
  }
  
  @NonNull
  public Builder toBuilder()
  {
    return new Builder(this);
  }
  
  @NonNull
  public Bundle toBundle()
  {
    Bundle localBundle2 = new Bundle();
    localBundle2.putCharSequence("name", this.mName);
    Bundle localBundle1;
    if (this.mIcon != null) {
      localBundle1 = this.mIcon.toBundle();
    } else {
      localBundle1 = null;
    }
    localBundle2.putBundle("icon", localBundle1);
    localBundle2.putString("uri", this.mUri);
    localBundle2.putString("key", this.mKey);
    localBundle2.putBoolean("isBot", this.mIsBot);
    localBundle2.putBoolean("isImportant", this.mIsImportant);
    return localBundle2;
  }
  
  public static class Builder
  {
    @Nullable
    IconCompat mIcon;
    boolean mIsBot;
    boolean mIsImportant;
    @Nullable
    String mKey;
    @Nullable
    CharSequence mName;
    @Nullable
    String mUri;
    
    public Builder() {}
    
    Builder(Person paramPerson)
    {
      this.mName = paramPerson.mName;
      this.mIcon = paramPerson.mIcon;
      this.mUri = paramPerson.mUri;
      this.mKey = paramPerson.mKey;
      this.mIsBot = paramPerson.mIsBot;
      this.mIsImportant = paramPerson.mIsImportant;
    }
    
    @NonNull
    public Person build()
    {
      return new Person(this);
    }
    
    @NonNull
    public Builder setBot(boolean paramBoolean)
    {
      this.mIsBot = paramBoolean;
      return this;
    }
    
    @NonNull
    public Builder setIcon(@Nullable IconCompat paramIconCompat)
    {
      this.mIcon = paramIconCompat;
      return this;
    }
    
    @NonNull
    public Builder setImportant(boolean paramBoolean)
    {
      this.mIsImportant = paramBoolean;
      return this;
    }
    
    @NonNull
    public Builder setKey(@Nullable String paramString)
    {
      this.mKey = paramString;
      return this;
    }
    
    @NonNull
    public Builder setName(@Nullable CharSequence paramCharSequence)
    {
      this.mName = paramCharSequence;
      return this;
    }
    
    @NonNull
    public Builder setUri(@Nullable String paramString)
    {
      this.mUri = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\app\Person.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */