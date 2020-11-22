package android.support.v4.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.graphics.drawable.IconCompat;
import android.text.TextUtils;
import java.util.Arrays;

public class ShortcutInfoCompat
{
  ComponentName mActivity;
  Context mContext;
  CharSequence mDisabledMessage;
  IconCompat mIcon;
  String mId;
  Intent[] mIntents;
  boolean mIsAlwaysBadged;
  CharSequence mLabel;
  CharSequence mLongLabel;
  
  Intent addToIntent(Intent paramIntent)
  {
    paramIntent.putExtra("android.intent.extra.shortcut.INTENT", this.mIntents[(this.mIntents.length - 1)]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
    Object localObject3;
    Object localObject4;
    PackageManager localPackageManager;
    Object localObject1;
    if (this.mIcon != null)
    {
      localObject3 = null;
      localObject4 = null;
      if (this.mIsAlwaysBadged)
      {
        localPackageManager = this.mContext.getPackageManager();
        localObject1 = localObject4;
        if (this.mActivity == null) {}
      }
    }
    try
    {
      localObject1 = localPackageManager.getActivityIcon(this.mActivity);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = this.mContext.getApplicationInfo().loadIcon(localPackageManager);
      }
      this.mIcon.addToShortcutIntent(paramIntent, (Drawable)localObject3, this.mContext);
      return paramIntent;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = localObject4;
      }
    }
  }
  
  @Nullable
  public ComponentName getActivity()
  {
    return this.mActivity;
  }
  
  @Nullable
  public CharSequence getDisabledMessage()
  {
    return this.mDisabledMessage;
  }
  
  @NonNull
  public String getId()
  {
    return this.mId;
  }
  
  @NonNull
  public Intent getIntent()
  {
    return this.mIntents[(this.mIntents.length - 1)];
  }
  
  @NonNull
  public Intent[] getIntents()
  {
    return (Intent[])Arrays.copyOf(this.mIntents, this.mIntents.length);
  }
  
  @Nullable
  public CharSequence getLongLabel()
  {
    return this.mLongLabel;
  }
  
  @NonNull
  public CharSequence getShortLabel()
  {
    return this.mLabel;
  }
  
  @RequiresApi(25)
  public ShortcutInfo toShortcutInfo()
  {
    ShortcutInfo.Builder localBuilder = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
    if (this.mIcon != null) {
      localBuilder.setIcon(this.mIcon.toIcon());
    }
    if (!TextUtils.isEmpty(this.mLongLabel)) {
      localBuilder.setLongLabel(this.mLongLabel);
    }
    if (!TextUtils.isEmpty(this.mDisabledMessage)) {
      localBuilder.setDisabledMessage(this.mDisabledMessage);
    }
    if (this.mActivity != null) {
      localBuilder.setActivity(this.mActivity);
    }
    return localBuilder.build();
  }
  
  public static class Builder
  {
    private final ShortcutInfoCompat mInfo = new ShortcutInfoCompat();
    
    public Builder(@NonNull Context paramContext, @NonNull String paramString)
    {
      this.mInfo.mContext = paramContext;
      this.mInfo.mId = paramString;
    }
    
    @NonNull
    public ShortcutInfoCompat build()
    {
      if (!TextUtils.isEmpty(this.mInfo.mLabel))
      {
        if ((this.mInfo.mIntents != null) && (this.mInfo.mIntents.length != 0)) {
          return this.mInfo;
        }
        throw new IllegalArgumentException("Shortcut must have an intent");
      }
      throw new IllegalArgumentException("Shortcut must have a non-empty label");
    }
    
    @NonNull
    public Builder setActivity(@NonNull ComponentName paramComponentName)
    {
      this.mInfo.mActivity = paramComponentName;
      return this;
    }
    
    public Builder setAlwaysBadged()
    {
      this.mInfo.mIsAlwaysBadged = true;
      return this;
    }
    
    @NonNull
    public Builder setDisabledMessage(@NonNull CharSequence paramCharSequence)
    {
      this.mInfo.mDisabledMessage = paramCharSequence;
      return this;
    }
    
    @NonNull
    public Builder setIcon(IconCompat paramIconCompat)
    {
      this.mInfo.mIcon = paramIconCompat;
      return this;
    }
    
    @NonNull
    public Builder setIntent(@NonNull Intent paramIntent)
    {
      return setIntents(new Intent[] { paramIntent });
    }
    
    @NonNull
    public Builder setIntents(@NonNull Intent[] paramArrayOfIntent)
    {
      this.mInfo.mIntents = paramArrayOfIntent;
      return this;
    }
    
    @NonNull
    public Builder setLongLabel(@NonNull CharSequence paramCharSequence)
    {
      this.mInfo.mLongLabel = paramCharSequence;
      return this;
    }
    
    @NonNull
    public Builder setShortLabel(@NonNull CharSequence paramCharSequence)
    {
      this.mInfo.mLabel = paramCharSequence;
      return this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\content\pm\ShortcutInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */