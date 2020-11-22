package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Action.Builder;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.DecoratedCustomViewStyle;
import android.app.Notification.InboxStyle;
import android.app.Notification.MessagingStyle;
import android.app.Notification.MessagingStyle.Message;
import android.app.PendingIntent;
import android.app.RemoteInput.Builder;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.compat.R.color;
import android.support.compat.R.dimen;
import android.support.compat.R.drawable;
import android.support.compat.R.id;
import android.support.compat.R.integer;
import android.support.compat.R.layout;
import android.support.compat.R.string;
import android.support.v4.text.BidiFormatter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NotificationCompat
{
  public static final int BADGE_ICON_LARGE = 2;
  public static final int BADGE_ICON_NONE = 0;
  public static final int BADGE_ICON_SMALL = 1;
  public static final String CATEGORY_ALARM = "alarm";
  public static final String CATEGORY_CALL = "call";
  public static final String CATEGORY_EMAIL = "email";
  public static final String CATEGORY_ERROR = "err";
  public static final String CATEGORY_EVENT = "event";
  public static final String CATEGORY_MESSAGE = "msg";
  public static final String CATEGORY_PROGRESS = "progress";
  public static final String CATEGORY_PROMO = "promo";
  public static final String CATEGORY_RECOMMENDATION = "recommendation";
  public static final String CATEGORY_REMINDER = "reminder";
  public static final String CATEGORY_SERVICE = "service";
  public static final String CATEGORY_SOCIAL = "social";
  public static final String CATEGORY_STATUS = "status";
  public static final String CATEGORY_SYSTEM = "sys";
  public static final String CATEGORY_TRANSPORT = "transport";
  @ColorInt
  public static final int COLOR_DEFAULT = 0;
  public static final int DEFAULT_ALL = -1;
  public static final int DEFAULT_LIGHTS = 4;
  public static final int DEFAULT_SOUND = 1;
  public static final int DEFAULT_VIBRATE = 2;
  public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
  public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
  public static final String EXTRA_BIG_TEXT = "android.bigText";
  public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
  public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
  public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
  public static final String EXTRA_INFO_TEXT = "android.infoText";
  public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
  public static final String EXTRA_LARGE_ICON = "android.largeIcon";
  public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
  public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
  public static final String EXTRA_MESSAGES = "android.messages";
  public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
  public static final String EXTRA_PEOPLE = "android.people";
  public static final String EXTRA_PICTURE = "android.picture";
  public static final String EXTRA_PROGRESS = "android.progress";
  public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
  public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
  public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
  public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
  public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
  public static final String EXTRA_SHOW_WHEN = "android.showWhen";
  public static final String EXTRA_SMALL_ICON = "android.icon";
  public static final String EXTRA_SUB_TEXT = "android.subText";
  public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
  public static final String EXTRA_TEMPLATE = "android.template";
  public static final String EXTRA_TEXT = "android.text";
  public static final String EXTRA_TEXT_LINES = "android.textLines";
  public static final String EXTRA_TITLE = "android.title";
  public static final String EXTRA_TITLE_BIG = "android.title.big";
  public static final int FLAG_AUTO_CANCEL = 16;
  public static final int FLAG_FOREGROUND_SERVICE = 64;
  public static final int FLAG_GROUP_SUMMARY = 512;
  @Deprecated
  public static final int FLAG_HIGH_PRIORITY = 128;
  public static final int FLAG_INSISTENT = 4;
  public static final int FLAG_LOCAL_ONLY = 256;
  public static final int FLAG_NO_CLEAR = 32;
  public static final int FLAG_ONGOING_EVENT = 2;
  public static final int FLAG_ONLY_ALERT_ONCE = 8;
  public static final int FLAG_SHOW_LIGHTS = 1;
  public static final int GROUP_ALERT_ALL = 0;
  public static final int GROUP_ALERT_CHILDREN = 2;
  public static final int GROUP_ALERT_SUMMARY = 1;
  public static final int PRIORITY_DEFAULT = 0;
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_LOW = -1;
  public static final int PRIORITY_MAX = 2;
  public static final int PRIORITY_MIN = -2;
  public static final int STREAM_DEFAULT = -1;
  public static final int VISIBILITY_PRIVATE = 0;
  public static final int VISIBILITY_PUBLIC = 1;
  public static final int VISIBILITY_SECRET = -1;
  
  public static Action getAction(Notification paramNotification, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return getActionCompatFromAction(paramNotification.actions[paramInt]);
    }
    int i = Build.VERSION.SDK_INT;
    Object localObject = null;
    if (i >= 19)
    {
      Notification.Action localAction = paramNotification.actions[paramInt];
      SparseArray localSparseArray = paramNotification.extras.getSparseParcelableArray("android.support.actionExtras");
      paramNotification = (Notification)localObject;
      if (localSparseArray != null) {
        paramNotification = (Bundle)localSparseArray.get(paramInt);
      }
      return NotificationCompatJellybean.readAction(localAction.icon, localAction.title, localAction.actionIntent, paramNotification);
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getAction(paramNotification, paramInt);
    }
    return null;
  }
  
  @RequiresApi(20)
  static Action getActionCompatFromAction(Notification.Action paramAction)
  {
    android.app.RemoteInput[] arrayOfRemoteInput1 = paramAction.getRemoteInputs();
    RemoteInput[] arrayOfRemoteInput;
    if (arrayOfRemoteInput1 == null)
    {
      arrayOfRemoteInput = null;
    }
    else
    {
      arrayOfRemoteInput = new RemoteInput[arrayOfRemoteInput1.length];
      i = 0;
      while (i < arrayOfRemoteInput1.length)
      {
        android.app.RemoteInput localRemoteInput = arrayOfRemoteInput1[i];
        arrayOfRemoteInput[i] = new RemoteInput(localRemoteInput.getResultKey(), localRemoteInput.getLabel(), localRemoteInput.getChoices(), localRemoteInput.getAllowFreeFormInput(), localRemoteInput.getExtras(), null);
        i += 1;
      }
    }
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 24)
    {
      if ((!paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies")) && (!paramAction.getAllowGeneratedReplies())) {
        bool1 = false;
      } else {
        bool1 = true;
      }
    }
    else {
      bool1 = paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies");
    }
    boolean bool2 = paramAction.getExtras().getBoolean("android.support.action.showsUserInterface", true);
    if (Build.VERSION.SDK_INT >= 28) {}
    for (int i = paramAction.getSemanticAction();; i = paramAction.getExtras().getInt("android.support.action.semanticAction", 0)) {
      break;
    }
    return new Action(paramAction.icon, paramAction.title, paramAction.actionIntent, paramAction.getExtras(), arrayOfRemoteInput, null, bool1, i, bool2);
  }
  
  public static int getActionCount(Notification paramNotification)
  {
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if (j >= 19)
    {
      if (paramNotification.actions != null) {
        i = paramNotification.actions.length;
      }
      return i;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getActionCount(paramNotification);
    }
    return 0;
  }
  
  public static int getBadgeIconType(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getBadgeIconType();
    }
    return 0;
  }
  
  public static String getCategory(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramNotification.category;
    }
    return null;
  }
  
  public static String getChannelId(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getChannelId();
    }
    return null;
  }
  
  @RequiresApi(19)
  public static CharSequence getContentTitle(Notification paramNotification)
  {
    return paramNotification.extras.getCharSequence("android.title");
  }
  
  @Nullable
  public static Bundle getExtras(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getExtras(paramNotification);
    }
    return null;
  }
  
  public static String getGroup(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return paramNotification.getGroup();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras.getString("android.support.groupKey");
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getExtras(paramNotification).getString("android.support.groupKey");
    }
    return null;
  }
  
  public static int getGroupAlertBehavior(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getGroupAlertBehavior();
    }
    return 0;
  }
  
  @RequiresApi(21)
  public static List<Action> getInvisibleActions(Notification paramNotification)
  {
    ArrayList localArrayList = new ArrayList();
    paramNotification = paramNotification.extras.getBundle("android.car.EXTENSIONS");
    if (paramNotification == null) {
      return localArrayList;
    }
    paramNotification = paramNotification.getBundle("invisible_actions");
    if (paramNotification != null)
    {
      int i = 0;
      while (i < paramNotification.size())
      {
        localArrayList.add(NotificationCompatJellybean.getActionFromBundle(paramNotification.getBundle(Integer.toString(i))));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static boolean getLocalOnly(Notification paramNotification)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 20)
    {
      if ((paramNotification.flags & 0x100) != 0) {
        bool = true;
      }
      return bool;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras.getBoolean("android.support.localOnly");
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getExtras(paramNotification).getBoolean("android.support.localOnly");
    }
    return false;
  }
  
  static Notification[] getNotificationArrayFromBundle(Bundle paramBundle, String paramString)
  {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    if ((!(arrayOfParcelable instanceof Notification[])) && (arrayOfParcelable != null))
    {
      Notification[] arrayOfNotification = new Notification[arrayOfParcelable.length];
      int i = 0;
      while (i < arrayOfParcelable.length)
      {
        arrayOfNotification[i] = ((Notification)arrayOfParcelable[i]);
        i += 1;
      }
      paramBundle.putParcelableArray(paramString, arrayOfNotification);
      return arrayOfNotification;
    }
    return (Notification[])arrayOfParcelable;
  }
  
  public static String getShortcutId(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getShortcutId();
    }
    return null;
  }
  
  public static String getSortKey(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return paramNotification.getSortKey();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras.getString("android.support.sortKey");
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getExtras(paramNotification).getString("android.support.sortKey");
    }
    return null;
  }
  
  public static long getTimeoutAfter(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getTimeoutAfter();
    }
    return 0L;
  }
  
  public static boolean isGroupSummary(Notification paramNotification)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 20)
    {
      if ((paramNotification.flags & 0x200) != 0) {
        bool = true;
      }
      return bool;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras.getBoolean("android.support.isGroupSummary");
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getExtras(paramNotification).getBoolean("android.support.isGroupSummary");
    }
    return false;
  }
  
  public static class Action
  {
    static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
    static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
    public static final int SEMANTIC_ACTION_ARCHIVE = 5;
    public static final int SEMANTIC_ACTION_CALL = 10;
    public static final int SEMANTIC_ACTION_DELETE = 4;
    public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
    public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
    public static final int SEMANTIC_ACTION_MUTE = 6;
    public static final int SEMANTIC_ACTION_NONE = 0;
    public static final int SEMANTIC_ACTION_REPLY = 1;
    public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
    public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
    public static final int SEMANTIC_ACTION_UNMUTE = 7;
    public PendingIntent actionIntent;
    public int icon;
    private boolean mAllowGeneratedReplies;
    private final RemoteInput[] mDataOnlyRemoteInputs;
    final Bundle mExtras;
    private final RemoteInput[] mRemoteInputs;
    private final int mSemanticAction;
    boolean mShowsUserInterface = true;
    public CharSequence title;
    
    public Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this(paramInt, paramCharSequence, paramPendingIntent, new Bundle(), null, null, true, 0, true);
    }
    
    Action(int paramInt1, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput1, RemoteInput[] paramArrayOfRemoteInput2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
    {
      this.icon = paramInt1;
      this.title = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      this.actionIntent = paramPendingIntent;
      if (paramBundle == null) {
        paramBundle = new Bundle();
      }
      this.mExtras = paramBundle;
      this.mRemoteInputs = paramArrayOfRemoteInput1;
      this.mDataOnlyRemoteInputs = paramArrayOfRemoteInput2;
      this.mAllowGeneratedReplies = paramBoolean1;
      this.mSemanticAction = paramInt2;
      this.mShowsUserInterface = paramBoolean2;
    }
    
    public PendingIntent getActionIntent()
    {
      return this.actionIntent;
    }
    
    public boolean getAllowGeneratedReplies()
    {
      return this.mAllowGeneratedReplies;
    }
    
    public RemoteInput[] getDataOnlyRemoteInputs()
    {
      return this.mDataOnlyRemoteInputs;
    }
    
    public Bundle getExtras()
    {
      return this.mExtras;
    }
    
    public int getIcon()
    {
      return this.icon;
    }
    
    public RemoteInput[] getRemoteInputs()
    {
      return this.mRemoteInputs;
    }
    
    public int getSemanticAction()
    {
      return this.mSemanticAction;
    }
    
    public boolean getShowsUserInterface()
    {
      return this.mShowsUserInterface;
    }
    
    public CharSequence getTitle()
    {
      return this.title;
    }
    
    public static final class Builder
    {
      private boolean mAllowGeneratedReplies = true;
      private final Bundle mExtras;
      private final int mIcon;
      private final PendingIntent mIntent;
      private ArrayList<RemoteInput> mRemoteInputs;
      private int mSemanticAction;
      private boolean mShowsUserInterface = true;
      private final CharSequence mTitle;
      
      public Builder(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
      {
        this(paramInt, paramCharSequence, paramPendingIntent, new Bundle(), null, true, 0, true);
      }
      
      private Builder(int paramInt1, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
      {
        this.mIcon = paramInt1;
        this.mTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
        this.mIntent = paramPendingIntent;
        this.mExtras = paramBundle;
        if (paramArrayOfRemoteInput == null) {
          paramCharSequence = null;
        } else {
          paramCharSequence = new ArrayList(Arrays.asList(paramArrayOfRemoteInput));
        }
        this.mRemoteInputs = paramCharSequence;
        this.mAllowGeneratedReplies = paramBoolean1;
        this.mSemanticAction = paramInt2;
        this.mShowsUserInterface = paramBoolean2;
      }
      
      public Builder(NotificationCompat.Action paramAction)
      {
        this(paramAction.icon, paramAction.title, paramAction.actionIntent, new Bundle(paramAction.mExtras), paramAction.getRemoteInputs(), paramAction.getAllowGeneratedReplies(), paramAction.getSemanticAction(), paramAction.mShowsUserInterface);
      }
      
      public Builder addExtras(Bundle paramBundle)
      {
        if (paramBundle != null) {
          this.mExtras.putAll(paramBundle);
        }
        return this;
      }
      
      public Builder addRemoteInput(RemoteInput paramRemoteInput)
      {
        if (this.mRemoteInputs == null) {
          this.mRemoteInputs = new ArrayList();
        }
        this.mRemoteInputs.add(paramRemoteInput);
        return this;
      }
      
      public NotificationCompat.Action build()
      {
        Object localObject1 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        if (this.mRemoteInputs != null)
        {
          localObject2 = this.mRemoteInputs.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            RemoteInput localRemoteInput = (RemoteInput)((Iterator)localObject2).next();
            if (localRemoteInput.isDataOnly()) {
              ((List)localObject1).add(localRemoteInput);
            } else {
              localArrayList.add(localRemoteInput);
            }
          }
        }
        boolean bool = ((List)localObject1).isEmpty();
        Object localObject2 = null;
        if (bool) {
          localObject1 = null;
        } else {
          localObject1 = (RemoteInput[])((List)localObject1).toArray(new RemoteInput[((List)localObject1).size()]);
        }
        if (!localArrayList.isEmpty()) {
          for (;;)
          {
            localObject2 = (RemoteInput[])localArrayList.toArray(new RemoteInput[localArrayList.size()]);
          }
        }
        return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, (RemoteInput[])localObject2, (RemoteInput[])localObject1, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface);
      }
      
      public Builder extend(NotificationCompat.Action.Extender paramExtender)
      {
        paramExtender.extend(this);
        return this;
      }
      
      public Bundle getExtras()
      {
        return this.mExtras;
      }
      
      public Builder setAllowGeneratedReplies(boolean paramBoolean)
      {
        this.mAllowGeneratedReplies = paramBoolean;
        return this;
      }
      
      public Builder setSemanticAction(int paramInt)
      {
        this.mSemanticAction = paramInt;
        return this;
      }
      
      public Builder setShowsUserInterface(boolean paramBoolean)
      {
        this.mShowsUserInterface = paramBoolean;
        return this;
      }
    }
    
    public static abstract interface Extender
    {
      public abstract NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder paramBuilder);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface SemanticAction {}
    
    public static final class WearableExtender
      implements NotificationCompat.Action.Extender
    {
      private static final int DEFAULT_FLAGS = 1;
      private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
      private static final int FLAG_AVAILABLE_OFFLINE = 1;
      private static final int FLAG_HINT_DISPLAY_INLINE = 4;
      private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
      private static final String KEY_CANCEL_LABEL = "cancelLabel";
      private static final String KEY_CONFIRM_LABEL = "confirmLabel";
      private static final String KEY_FLAGS = "flags";
      private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
      private CharSequence mCancelLabel;
      private CharSequence mConfirmLabel;
      private int mFlags = 1;
      private CharSequence mInProgressLabel;
      
      public WearableExtender() {}
      
      public WearableExtender(NotificationCompat.Action paramAction)
      {
        paramAction = paramAction.getExtras().getBundle("android.wearable.EXTENSIONS");
        if (paramAction != null)
        {
          this.mFlags = paramAction.getInt("flags", 1);
          this.mInProgressLabel = paramAction.getCharSequence("inProgressLabel");
          this.mConfirmLabel = paramAction.getCharSequence("confirmLabel");
          this.mCancelLabel = paramAction.getCharSequence("cancelLabel");
        }
      }
      
      private void setFlag(int paramInt, boolean paramBoolean)
      {
        if (paramBoolean)
        {
          this.mFlags = (paramInt | this.mFlags);
          return;
        }
        this.mFlags = ((paramInt ^ 0xFFFFFFFF) & this.mFlags);
      }
      
      public WearableExtender clone()
      {
        WearableExtender localWearableExtender = new WearableExtender();
        localWearableExtender.mFlags = this.mFlags;
        localWearableExtender.mInProgressLabel = this.mInProgressLabel;
        localWearableExtender.mConfirmLabel = this.mConfirmLabel;
        localWearableExtender.mCancelLabel = this.mCancelLabel;
        return localWearableExtender;
      }
      
      public NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder paramBuilder)
      {
        Bundle localBundle = new Bundle();
        if (this.mFlags != 1) {
          localBundle.putInt("flags", this.mFlags);
        }
        if (this.mInProgressLabel != null) {
          localBundle.putCharSequence("inProgressLabel", this.mInProgressLabel);
        }
        if (this.mConfirmLabel != null) {
          localBundle.putCharSequence("confirmLabel", this.mConfirmLabel);
        }
        if (this.mCancelLabel != null) {
          localBundle.putCharSequence("cancelLabel", this.mCancelLabel);
        }
        paramBuilder.getExtras().putBundle("android.wearable.EXTENSIONS", localBundle);
        return paramBuilder;
      }
      
      @Deprecated
      public CharSequence getCancelLabel()
      {
        return this.mCancelLabel;
      }
      
      @Deprecated
      public CharSequence getConfirmLabel()
      {
        return this.mConfirmLabel;
      }
      
      public boolean getHintDisplayActionInline()
      {
        return (this.mFlags & 0x4) != 0;
      }
      
      public boolean getHintLaunchesActivity()
      {
        return (this.mFlags & 0x2) != 0;
      }
      
      @Deprecated
      public CharSequence getInProgressLabel()
      {
        return this.mInProgressLabel;
      }
      
      public boolean isAvailableOffline()
      {
        return (this.mFlags & 0x1) != 0;
      }
      
      public WearableExtender setAvailableOffline(boolean paramBoolean)
      {
        setFlag(1, paramBoolean);
        return this;
      }
      
      @Deprecated
      public WearableExtender setCancelLabel(CharSequence paramCharSequence)
      {
        this.mCancelLabel = paramCharSequence;
        return this;
      }
      
      @Deprecated
      public WearableExtender setConfirmLabel(CharSequence paramCharSequence)
      {
        this.mConfirmLabel = paramCharSequence;
        return this;
      }
      
      public WearableExtender setHintDisplayActionInline(boolean paramBoolean)
      {
        setFlag(4, paramBoolean);
        return this;
      }
      
      public WearableExtender setHintLaunchesActivity(boolean paramBoolean)
      {
        setFlag(2, paramBoolean);
        return this;
      }
      
      @Deprecated
      public WearableExtender setInProgressLabel(CharSequence paramCharSequence)
      {
        this.mInProgressLabel = paramCharSequence;
        return this;
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface BadgeIconType {}
  
  public static class BigPictureStyle
    extends NotificationCompat.Style
  {
    private Bitmap mBigLargeIcon;
    private boolean mBigLargeIconSet;
    private Bitmap mPicture;
    
    public BigPictureStyle() {}
    
    public BigPictureStyle(NotificationCompat.Builder paramBuilder)
    {
      setBuilder(paramBuilder);
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramNotificationBuilderWithBuilderAccessor = new Notification.BigPictureStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigPicture(this.mPicture);
        if (this.mBigLargeIconSet) {
          paramNotificationBuilderWithBuilderAccessor.bigLargeIcon(this.mBigLargeIcon);
        }
        if (this.mSummaryTextSet) {
          paramNotificationBuilderWithBuilderAccessor.setSummaryText(this.mSummaryText);
        }
      }
    }
    
    public BigPictureStyle bigLargeIcon(Bitmap paramBitmap)
    {
      this.mBigLargeIcon = paramBitmap;
      this.mBigLargeIconSet = true;
      return this;
    }
    
    public BigPictureStyle bigPicture(Bitmap paramBitmap)
    {
      this.mPicture = paramBitmap;
      return this;
    }
    
    public BigPictureStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public BigPictureStyle setSummaryText(CharSequence paramCharSequence)
    {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  public static class BigTextStyle
    extends NotificationCompat.Style
  {
    private CharSequence mBigText;
    
    public BigTextStyle() {}
    
    public BigTextStyle(NotificationCompat.Builder paramBuilder)
    {
      setBuilder(paramBuilder);
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramNotificationBuilderWithBuilderAccessor = new Notification.BigTextStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
        if (this.mSummaryTextSet) {
          paramNotificationBuilderWithBuilderAccessor.setSummaryText(this.mSummaryText);
        }
      }
    }
    
    public BigTextStyle bigText(CharSequence paramCharSequence)
    {
      this.mBigText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public BigTextStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public BigTextStyle setSummaryText(CharSequence paramCharSequence)
    {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  public static class Builder
  {
    private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public ArrayList<NotificationCompat.Action> mActions = new ArrayList();
    int mBadgeIcon = 0;
    RemoteViews mBigContentView;
    String mCategory;
    String mChannelId;
    int mColor = 0;
    boolean mColorized;
    boolean mColorizedSet;
    CharSequence mContentInfo;
    PendingIntent mContentIntent;
    CharSequence mContentText;
    CharSequence mContentTitle;
    RemoteViews mContentView;
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public Context mContext;
    Bundle mExtras;
    PendingIntent mFullScreenIntent;
    int mGroupAlertBehavior = 0;
    String mGroupKey;
    boolean mGroupSummary;
    RemoteViews mHeadsUpContentView;
    ArrayList<NotificationCompat.Action> mInvisibleActions = new ArrayList();
    Bitmap mLargeIcon;
    boolean mLocalOnly = false;
    Notification mNotification = new Notification();
    int mNumber;
    @Deprecated
    public ArrayList<String> mPeople;
    int mPriority;
    int mProgress;
    boolean mProgressIndeterminate;
    int mProgressMax;
    Notification mPublicVersion;
    CharSequence[] mRemoteInputHistory;
    String mShortcutId;
    boolean mShowWhen = true;
    String mSortKey;
    NotificationCompat.Style mStyle;
    CharSequence mSubText;
    RemoteViews mTickerView;
    long mTimeout;
    boolean mUseChronometer;
    int mVisibility = 0;
    
    @Deprecated
    public Builder(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public Builder(@NonNull Context paramContext, @NonNull String paramString)
    {
      this.mContext = paramContext;
      this.mChannelId = paramString;
      this.mNotification.when = System.currentTimeMillis();
      this.mNotification.audioStreamType = -1;
      this.mPriority = 0;
      this.mPeople = new ArrayList();
    }
    
    protected static CharSequence limitCharSequenceLength(CharSequence paramCharSequence)
    {
      if (paramCharSequence == null) {
        return paramCharSequence;
      }
      CharSequence localCharSequence = paramCharSequence;
      if (paramCharSequence.length() > 5120) {
        localCharSequence = paramCharSequence.subSequence(0, 5120);
      }
      return localCharSequence;
    }
    
    private Bitmap reduceLargeIconSize(Bitmap paramBitmap)
    {
      if (paramBitmap != null)
      {
        if (Build.VERSION.SDK_INT >= 27) {
          return paramBitmap;
        }
        Resources localResources = this.mContext.getResources();
        int i = localResources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
        int j = localResources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
        if ((paramBitmap.getWidth() <= i) && (paramBitmap.getHeight() <= j)) {
          return paramBitmap;
        }
        double d1 = i;
        double d2 = Math.max(1, paramBitmap.getWidth());
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = j;
        double d3 = Math.max(1, paramBitmap.getHeight());
        Double.isNaN(d2);
        Double.isNaN(d3);
        d1 = Math.min(d1, d2 / d3);
        d2 = paramBitmap.getWidth();
        Double.isNaN(d2);
        i = (int)Math.ceil(d2 * d1);
        d2 = paramBitmap.getHeight();
        Double.isNaN(d2);
        return Bitmap.createScaledBitmap(paramBitmap, i, (int)Math.ceil(d2 * d1), true);
      }
      return paramBitmap;
    }
    
    private void setFlag(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localNotification = this.mNotification;
        localNotification.flags = (paramInt | localNotification.flags);
        return;
      }
      Notification localNotification = this.mNotification;
      localNotification.flags = ((paramInt ^ 0xFFFFFFFF) & localNotification.flags);
    }
    
    public Builder addAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this.mActions.add(new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent));
      return this;
    }
    
    public Builder addAction(NotificationCompat.Action paramAction)
    {
      this.mActions.add(paramAction);
      return this;
    }
    
    public Builder addExtras(Bundle paramBundle)
    {
      if (paramBundle != null)
      {
        if (this.mExtras == null)
        {
          this.mExtras = new Bundle(paramBundle);
          return this;
        }
        this.mExtras.putAll(paramBundle);
      }
      return this;
    }
    
    @RequiresApi(21)
    public Builder addInvisibleAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      return addInvisibleAction(new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent));
    }
    
    @RequiresApi(21)
    public Builder addInvisibleAction(NotificationCompat.Action paramAction)
    {
      this.mInvisibleActions.add(paramAction);
      return this;
    }
    
    public Builder addPerson(String paramString)
    {
      this.mPeople.add(paramString);
      return this;
    }
    
    public Notification build()
    {
      return new NotificationCompatBuilder(this).build();
    }
    
    public Builder extend(NotificationCompat.Extender paramExtender)
    {
      paramExtender.extend(this);
      return this;
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews getBigContentView()
    {
      return this.mBigContentView;
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public int getColor()
    {
      return this.mColor;
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews getContentView()
    {
      return this.mContentView;
    }
    
    public Bundle getExtras()
    {
      if (this.mExtras == null) {
        this.mExtras = new Bundle();
      }
      return this.mExtras;
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews getHeadsUpContentView()
    {
      return this.mHeadsUpContentView;
    }
    
    @Deprecated
    public Notification getNotification()
    {
      return build();
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public int getPriority()
    {
      return this.mPriority;
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public long getWhenIfShowing()
    {
      if (this.mShowWhen) {
        return this.mNotification.when;
      }
      return 0L;
    }
    
    public Builder setAutoCancel(boolean paramBoolean)
    {
      setFlag(16, paramBoolean);
      return this;
    }
    
    public Builder setBadgeIconType(int paramInt)
    {
      this.mBadgeIcon = paramInt;
      return this;
    }
    
    public Builder setCategory(String paramString)
    {
      this.mCategory = paramString;
      return this;
    }
    
    public Builder setChannelId(@NonNull String paramString)
    {
      this.mChannelId = paramString;
      return this;
    }
    
    public Builder setColor(@ColorInt int paramInt)
    {
      this.mColor = paramInt;
      return this;
    }
    
    public Builder setColorized(boolean paramBoolean)
    {
      this.mColorized = paramBoolean;
      this.mColorizedSet = true;
      return this;
    }
    
    public Builder setContent(RemoteViews paramRemoteViews)
    {
      this.mNotification.contentView = paramRemoteViews;
      return this;
    }
    
    public Builder setContentInfo(CharSequence paramCharSequence)
    {
      this.mContentInfo = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setContentIntent(PendingIntent paramPendingIntent)
    {
      this.mContentIntent = paramPendingIntent;
      return this;
    }
    
    public Builder setContentText(CharSequence paramCharSequence)
    {
      this.mContentText = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setContentTitle(CharSequence paramCharSequence)
    {
      this.mContentTitle = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setCustomBigContentView(RemoteViews paramRemoteViews)
    {
      this.mBigContentView = paramRemoteViews;
      return this;
    }
    
    public Builder setCustomContentView(RemoteViews paramRemoteViews)
    {
      this.mContentView = paramRemoteViews;
      return this;
    }
    
    public Builder setCustomHeadsUpContentView(RemoteViews paramRemoteViews)
    {
      this.mHeadsUpContentView = paramRemoteViews;
      return this;
    }
    
    public Builder setDefaults(int paramInt)
    {
      this.mNotification.defaults = paramInt;
      if ((paramInt & 0x4) != 0)
      {
        Notification localNotification = this.mNotification;
        localNotification.flags |= 0x1;
      }
      return this;
    }
    
    public Builder setDeleteIntent(PendingIntent paramPendingIntent)
    {
      this.mNotification.deleteIntent = paramPendingIntent;
      return this;
    }
    
    public Builder setExtras(Bundle paramBundle)
    {
      this.mExtras = paramBundle;
      return this;
    }
    
    public Builder setFullScreenIntent(PendingIntent paramPendingIntent, boolean paramBoolean)
    {
      this.mFullScreenIntent = paramPendingIntent;
      setFlag(128, paramBoolean);
      return this;
    }
    
    public Builder setGroup(String paramString)
    {
      this.mGroupKey = paramString;
      return this;
    }
    
    public Builder setGroupAlertBehavior(int paramInt)
    {
      this.mGroupAlertBehavior = paramInt;
      return this;
    }
    
    public Builder setGroupSummary(boolean paramBoolean)
    {
      this.mGroupSummary = paramBoolean;
      return this;
    }
    
    public Builder setLargeIcon(Bitmap paramBitmap)
    {
      this.mLargeIcon = reduceLargeIconSize(paramBitmap);
      return this;
    }
    
    public Builder setLights(@ColorInt int paramInt1, int paramInt2, int paramInt3)
    {
      this.mNotification.ledARGB = paramInt1;
      this.mNotification.ledOnMS = paramInt2;
      this.mNotification.ledOffMS = paramInt3;
      if ((this.mNotification.ledOnMS != 0) && (this.mNotification.ledOffMS != 0)) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      this.mNotification.flags = (paramInt1 | this.mNotification.flags & 0xFFFFFFFE);
      return this;
    }
    
    public Builder setLocalOnly(boolean paramBoolean)
    {
      this.mLocalOnly = paramBoolean;
      return this;
    }
    
    public Builder setNumber(int paramInt)
    {
      this.mNumber = paramInt;
      return this;
    }
    
    public Builder setOngoing(boolean paramBoolean)
    {
      setFlag(2, paramBoolean);
      return this;
    }
    
    public Builder setOnlyAlertOnce(boolean paramBoolean)
    {
      setFlag(8, paramBoolean);
      return this;
    }
    
    public Builder setPriority(int paramInt)
    {
      this.mPriority = paramInt;
      return this;
    }
    
    public Builder setProgress(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.mProgressMax = paramInt1;
      this.mProgress = paramInt2;
      this.mProgressIndeterminate = paramBoolean;
      return this;
    }
    
    public Builder setPublicVersion(Notification paramNotification)
    {
      this.mPublicVersion = paramNotification;
      return this;
    }
    
    public Builder setRemoteInputHistory(CharSequence[] paramArrayOfCharSequence)
    {
      this.mRemoteInputHistory = paramArrayOfCharSequence;
      return this;
    }
    
    public Builder setShortcutId(String paramString)
    {
      this.mShortcutId = paramString;
      return this;
    }
    
    public Builder setShowWhen(boolean paramBoolean)
    {
      this.mShowWhen = paramBoolean;
      return this;
    }
    
    public Builder setSmallIcon(int paramInt)
    {
      this.mNotification.icon = paramInt;
      return this;
    }
    
    public Builder setSmallIcon(int paramInt1, int paramInt2)
    {
      this.mNotification.icon = paramInt1;
      this.mNotification.iconLevel = paramInt2;
      return this;
    }
    
    public Builder setSortKey(String paramString)
    {
      this.mSortKey = paramString;
      return this;
    }
    
    public Builder setSound(Uri paramUri)
    {
      this.mNotification.sound = paramUri;
      this.mNotification.audioStreamType = -1;
      if (Build.VERSION.SDK_INT >= 21) {
        this.mNotification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
      }
      return this;
    }
    
    public Builder setSound(Uri paramUri, int paramInt)
    {
      this.mNotification.sound = paramUri;
      this.mNotification.audioStreamType = paramInt;
      if (Build.VERSION.SDK_INT >= 21) {
        this.mNotification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(paramInt).build();
      }
      return this;
    }
    
    public Builder setStyle(NotificationCompat.Style paramStyle)
    {
      if (this.mStyle != paramStyle)
      {
        this.mStyle = paramStyle;
        if (this.mStyle != null) {
          this.mStyle.setBuilder(this);
        }
      }
      return this;
    }
    
    public Builder setSubText(CharSequence paramCharSequence)
    {
      this.mSubText = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setTicker(CharSequence paramCharSequence)
    {
      this.mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setTicker(CharSequence paramCharSequence, RemoteViews paramRemoteViews)
    {
      this.mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
      this.mTickerView = paramRemoteViews;
      return this;
    }
    
    public Builder setTimeoutAfter(long paramLong)
    {
      this.mTimeout = paramLong;
      return this;
    }
    
    public Builder setUsesChronometer(boolean paramBoolean)
    {
      this.mUseChronometer = paramBoolean;
      return this;
    }
    
    public Builder setVibrate(long[] paramArrayOfLong)
    {
      this.mNotification.vibrate = paramArrayOfLong;
      return this;
    }
    
    public Builder setVisibility(int paramInt)
    {
      this.mVisibility = paramInt;
      return this;
    }
    
    public Builder setWhen(long paramLong)
    {
      this.mNotification.when = paramLong;
      return this;
    }
  }
  
  public static final class CarExtender
    implements NotificationCompat.Extender
  {
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
    private static final String EXTRA_COLOR = "app_color";
    private static final String EXTRA_CONVERSATION = "car_conversation";
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
    private static final String EXTRA_LARGE_ICON = "large_icon";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_MESSAGES = "messages";
    private static final String KEY_ON_READ = "on_read";
    private static final String KEY_ON_REPLY = "on_reply";
    private static final String KEY_PARTICIPANTS = "participants";
    private static final String KEY_REMOTE_INPUT = "remote_input";
    private static final String KEY_TEXT = "text";
    private static final String KEY_TIMESTAMP = "timestamp";
    private int mColor = 0;
    private Bitmap mLargeIcon;
    private UnreadConversation mUnreadConversation;
    
    public CarExtender() {}
    
    public CarExtender(Notification paramNotification)
    {
      if (Build.VERSION.SDK_INT < 21) {
        return;
      }
      if (NotificationCompat.getExtras(paramNotification) == null) {
        paramNotification = null;
      } else {
        paramNotification = NotificationCompat.getExtras(paramNotification).getBundle("android.car.EXTENSIONS");
      }
      if (paramNotification != null)
      {
        this.mLargeIcon = ((Bitmap)paramNotification.getParcelable("large_icon"));
        this.mColor = paramNotification.getInt("app_color", 0);
        this.mUnreadConversation = getUnreadConversationFromBundle(paramNotification.getBundle("car_conversation"));
      }
    }
    
    @RequiresApi(21)
    private static Bundle getBundleForUnreadConversation(@NonNull UnreadConversation paramUnreadConversation)
    {
      Bundle localBundle1 = new Bundle();
      Object localObject = paramUnreadConversation.getParticipants();
      int i = 0;
      if ((localObject != null) && (paramUnreadConversation.getParticipants().length > 1)) {
        localObject = paramUnreadConversation.getParticipants()[0];
      } else {
        localObject = null;
      }
      Parcelable[] arrayOfParcelable = new Parcelable[paramUnreadConversation.getMessages().length];
      while (i < arrayOfParcelable.length)
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("text", paramUnreadConversation.getMessages()[i]);
        localBundle2.putString("author", (String)localObject);
        arrayOfParcelable[i] = localBundle2;
        i += 1;
      }
      localBundle1.putParcelableArray("messages", arrayOfParcelable);
      localObject = paramUnreadConversation.getRemoteInput();
      if (localObject != null) {
        localBundle1.putParcelable("remote_input", new RemoteInput.Builder(((RemoteInput)localObject).getResultKey()).setLabel(((RemoteInput)localObject).getLabel()).setChoices(((RemoteInput)localObject).getChoices()).setAllowFreeFormInput(((RemoteInput)localObject).getAllowFreeFormInput()).addExtras(((RemoteInput)localObject).getExtras()).build());
      }
      localBundle1.putParcelable("on_reply", paramUnreadConversation.getReplyPendingIntent());
      localBundle1.putParcelable("on_read", paramUnreadConversation.getReadPendingIntent());
      localBundle1.putStringArray("participants", paramUnreadConversation.getParticipants());
      localBundle1.putLong("timestamp", paramUnreadConversation.getLatestTimestamp());
      return localBundle1;
    }
    
    @RequiresApi(21)
    private static UnreadConversation getUnreadConversationFromBundle(@Nullable Bundle paramBundle)
    {
      RemoteInput localRemoteInput = null;
      if (paramBundle == null) {
        return null;
      }
      Object localObject = paramBundle.getParcelableArray("messages");
      String[] arrayOfString1;
      if (localObject != null)
      {
        arrayOfString1 = new String[localObject.length];
        int j = 0;
        int i = 0;
        while (i < arrayOfString1.length)
        {
          if (!(localObject[i] instanceof Bundle))
          {
            i = j;
            break label89;
          }
          arrayOfString1[i] = ((Bundle)localObject[i]).getString("text");
          if (arrayOfString1[i] == null)
          {
            i = j;
            break label89;
          }
          i += 1;
        }
        i = 1;
        label89:
        if (i == 0) {
          return null;
        }
      }
      else
      {
        arrayOfString1 = null;
      }
      localObject = (PendingIntent)paramBundle.getParcelable("on_read");
      PendingIntent localPendingIntent = (PendingIntent)paramBundle.getParcelable("on_reply");
      android.app.RemoteInput localRemoteInput1 = (android.app.RemoteInput)paramBundle.getParcelable("remote_input");
      String[] arrayOfString2 = paramBundle.getStringArray("participants");
      if (arrayOfString2 != null)
      {
        if (arrayOfString2.length != 1) {
          return null;
        }
        if (localRemoteInput1 != null) {
          localRemoteInput = new RemoteInput(localRemoteInput1.getResultKey(), localRemoteInput1.getLabel(), localRemoteInput1.getChoices(), localRemoteInput1.getAllowFreeFormInput(), localRemoteInput1.getExtras(), null);
        }
        return new UnreadConversation(arrayOfString1, localRemoteInput, localPendingIntent, (PendingIntent)localObject, arrayOfString2, paramBundle.getLong("timestamp"));
      }
      return null;
    }
    
    public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
    {
      if (Build.VERSION.SDK_INT < 21) {
        return paramBuilder;
      }
      Bundle localBundle = new Bundle();
      if (this.mLargeIcon != null) {
        localBundle.putParcelable("large_icon", this.mLargeIcon);
      }
      if (this.mColor != 0) {
        localBundle.putInt("app_color", this.mColor);
      }
      if (this.mUnreadConversation != null) {
        localBundle.putBundle("car_conversation", getBundleForUnreadConversation(this.mUnreadConversation));
      }
      paramBuilder.getExtras().putBundle("android.car.EXTENSIONS", localBundle);
      return paramBuilder;
    }
    
    @ColorInt
    public int getColor()
    {
      return this.mColor;
    }
    
    public Bitmap getLargeIcon()
    {
      return this.mLargeIcon;
    }
    
    public UnreadConversation getUnreadConversation()
    {
      return this.mUnreadConversation;
    }
    
    public CarExtender setColor(@ColorInt int paramInt)
    {
      this.mColor = paramInt;
      return this;
    }
    
    public CarExtender setLargeIcon(Bitmap paramBitmap)
    {
      this.mLargeIcon = paramBitmap;
      return this;
    }
    
    public CarExtender setUnreadConversation(UnreadConversation paramUnreadConversation)
    {
      this.mUnreadConversation = paramUnreadConversation;
      return this;
    }
    
    public static class UnreadConversation
    {
      private final long mLatestTimestamp;
      private final String[] mMessages;
      private final String[] mParticipants;
      private final PendingIntent mReadPendingIntent;
      private final RemoteInput mRemoteInput;
      private final PendingIntent mReplyPendingIntent;
      
      UnreadConversation(String[] paramArrayOfString1, RemoteInput paramRemoteInput, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong)
      {
        this.mMessages = paramArrayOfString1;
        this.mRemoteInput = paramRemoteInput;
        this.mReadPendingIntent = paramPendingIntent2;
        this.mReplyPendingIntent = paramPendingIntent1;
        this.mParticipants = paramArrayOfString2;
        this.mLatestTimestamp = paramLong;
      }
      
      public long getLatestTimestamp()
      {
        return this.mLatestTimestamp;
      }
      
      public String[] getMessages()
      {
        return this.mMessages;
      }
      
      public String getParticipant()
      {
        if (this.mParticipants.length > 0) {
          return this.mParticipants[0];
        }
        return null;
      }
      
      public String[] getParticipants()
      {
        return this.mParticipants;
      }
      
      public PendingIntent getReadPendingIntent()
      {
        return this.mReadPendingIntent;
      }
      
      public RemoteInput getRemoteInput()
      {
        return this.mRemoteInput;
      }
      
      public PendingIntent getReplyPendingIntent()
      {
        return this.mReplyPendingIntent;
      }
      
      public static class Builder
      {
        private long mLatestTimestamp;
        private final List<String> mMessages = new ArrayList();
        private final String mParticipant;
        private PendingIntent mReadPendingIntent;
        private RemoteInput mRemoteInput;
        private PendingIntent mReplyPendingIntent;
        
        public Builder(String paramString)
        {
          this.mParticipant = paramString;
        }
        
        public Builder addMessage(String paramString)
        {
          this.mMessages.add(paramString);
          return this;
        }
        
        public NotificationCompat.CarExtender.UnreadConversation build()
        {
          String[] arrayOfString = (String[])this.mMessages.toArray(new String[this.mMessages.size()]);
          String str = this.mParticipant;
          RemoteInput localRemoteInput = this.mRemoteInput;
          PendingIntent localPendingIntent1 = this.mReplyPendingIntent;
          PendingIntent localPendingIntent2 = this.mReadPendingIntent;
          long l = this.mLatestTimestamp;
          return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, localRemoteInput, localPendingIntent1, localPendingIntent2, new String[] { str }, l);
        }
        
        public Builder setLatestTimestamp(long paramLong)
        {
          this.mLatestTimestamp = paramLong;
          return this;
        }
        
        public Builder setReadPendingIntent(PendingIntent paramPendingIntent)
        {
          this.mReadPendingIntent = paramPendingIntent;
          return this;
        }
        
        public Builder setReplyAction(PendingIntent paramPendingIntent, RemoteInput paramRemoteInput)
        {
          this.mRemoteInput = paramRemoteInput;
          this.mReplyPendingIntent = paramPendingIntent;
          return this;
        }
      }
    }
  }
  
  public static class DecoratedCustomViewStyle
    extends NotificationCompat.Style
  {
    private static final int MAX_ACTION_BUTTONS = 3;
    
    private RemoteViews createRemoteViews(RemoteViews paramRemoteViews, boolean paramBoolean)
    {
      int i = R.layout.notification_template_custom_big;
      int m = 1;
      int k = 0;
      RemoteViews localRemoteViews1 = applyStandardTemplate(true, i, false);
      localRemoteViews1.removeAllViews(R.id.actions);
      if ((paramBoolean) && (this.mBuilder.mActions != null))
      {
        int n = Math.min(this.mBuilder.mActions.size(), 3);
        if (n > 0)
        {
          i = 0;
          for (;;)
          {
            j = m;
            if (i >= n) {
              break;
            }
            RemoteViews localRemoteViews2 = generateActionButton((NotificationCompat.Action)this.mBuilder.mActions.get(i));
            localRemoteViews1.addView(R.id.actions, localRemoteViews2);
            i += 1;
          }
        }
      }
      int j = 0;
      if (j != 0) {
        i = k;
      } else {
        i = 8;
      }
      localRemoteViews1.setViewVisibility(R.id.actions, i);
      localRemoteViews1.setViewVisibility(R.id.action_divider, i);
      buildIntoRemoteViews(localRemoteViews1, paramRemoteViews);
      return localRemoteViews1;
    }
    
    private RemoteViews generateActionButton(NotificationCompat.Action paramAction)
    {
      int i;
      if (paramAction.actionIntent == null) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject = this.mBuilder.mContext.getPackageName();
      int j;
      if (i != 0) {
        j = R.layout.notification_action_tombstone;
      } else {
        j = R.layout.notification_action;
      }
      localObject = new RemoteViews((String)localObject, j);
      ((RemoteViews)localObject).setImageViewBitmap(R.id.action_image, createColoredBitmap(paramAction.getIcon(), this.mBuilder.mContext.getResources().getColor(R.color.notification_action_color_filter)));
      ((RemoteViews)localObject).setTextViewText(R.id.action_text, paramAction.title);
      if (i == 0) {
        ((RemoteViews)localObject).setOnClickPendingIntent(R.id.action_container, paramAction.actionIntent);
      }
      if (Build.VERSION.SDK_INT >= 15) {
        ((RemoteViews)localObject).setContentDescription(R.id.action_container, paramAction.title);
      }
      return (RemoteViews)localObject;
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24) {
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
      }
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return null;
      }
      paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getBigContentView();
      if (paramNotificationBuilderWithBuilderAccessor == null) {
        paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getContentView();
      }
      if (paramNotificationBuilderWithBuilderAccessor == null) {
        return null;
      }
      return createRemoteViews(paramNotificationBuilderWithBuilderAccessor, true);
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return null;
      }
      if (this.mBuilder.getContentView() == null) {
        return null;
      }
      return createRemoteViews(this.mBuilder.getContentView(), false);
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return null;
      }
      RemoteViews localRemoteViews = this.mBuilder.getHeadsUpContentView();
      if (localRemoteViews != null) {
        paramNotificationBuilderWithBuilderAccessor = localRemoteViews;
      } else {
        paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getContentView();
      }
      if (localRemoteViews == null) {
        return null;
      }
      return createRemoteViews(paramNotificationBuilderWithBuilderAccessor, true);
    }
  }
  
  public static abstract interface Extender
  {
    public abstract NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface GroupAlertBehavior {}
  
  public static class InboxStyle
    extends NotificationCompat.Style
  {
    private ArrayList<CharSequence> mTexts = new ArrayList();
    
    public InboxStyle() {}
    
    public InboxStyle(NotificationCompat.Builder paramBuilder)
    {
      setBuilder(paramBuilder);
    }
    
    public InboxStyle addLine(CharSequence paramCharSequence)
    {
      this.mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence));
      return this;
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramNotificationBuilderWithBuilderAccessor = new Notification.InboxStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle);
        if (this.mSummaryTextSet) {
          paramNotificationBuilderWithBuilderAccessor.setSummaryText(this.mSummaryText);
        }
        Iterator localIterator = this.mTexts.iterator();
        while (localIterator.hasNext()) {
          paramNotificationBuilderWithBuilderAccessor.addLine((CharSequence)localIterator.next());
        }
      }
    }
    
    public InboxStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public InboxStyle setSummaryText(CharSequence paramCharSequence)
    {
      this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  public static class MessagingStyle
    extends NotificationCompat.Style
  {
    public static final int MAXIMUM_RETAINED_MESSAGES = 25;
    @Nullable
    private CharSequence mConversationTitle;
    @Nullable
    private Boolean mIsGroupConversation;
    private final List<Message> mMessages = new ArrayList();
    private Person mUser;
    
    private MessagingStyle() {}
    
    public MessagingStyle(@NonNull Person paramPerson)
    {
      if (!TextUtils.isEmpty(paramPerson.getName()))
      {
        this.mUser = paramPerson;
        return;
      }
      throw new IllegalArgumentException("User's name must not be empty.");
    }
    
    @Deprecated
    public MessagingStyle(@NonNull CharSequence paramCharSequence)
    {
      this.mUser = new Person.Builder().setName(paramCharSequence).build();
    }
    
    @Nullable
    public static MessagingStyle extractMessagingStyleFromNotification(Notification paramNotification)
    {
      paramNotification = NotificationCompat.getExtras(paramNotification);
      if ((paramNotification != null) && (!paramNotification.containsKey("android.selfDisplayName")) && (!paramNotification.containsKey("android.messagingStyleUser"))) {
        return null;
      }
      try
      {
        MessagingStyle localMessagingStyle = new MessagingStyle();
        localMessagingStyle.restoreFromCompatExtras(paramNotification);
        return localMessagingStyle;
      }
      catch (ClassCastException paramNotification) {}
      return null;
    }
    
    @Nullable
    private Message findLatestIncomingMessage()
    {
      int i = this.mMessages.size() - 1;
      while (i >= 0)
      {
        Message localMessage = (Message)this.mMessages.get(i);
        if ((localMessage.getPerson() != null) && (!TextUtils.isEmpty(localMessage.getPerson().getName()))) {
          return localMessage;
        }
        i -= 1;
      }
      if (!this.mMessages.isEmpty()) {
        return (Message)this.mMessages.get(this.mMessages.size() - 1);
      }
      return null;
    }
    
    private boolean hasMessagesWithoutSender()
    {
      int i = this.mMessages.size() - 1;
      while (i >= 0)
      {
        Message localMessage = (Message)this.mMessages.get(i);
        if ((localMessage.getPerson() != null) && (localMessage.getPerson().getName() == null)) {
          return true;
        }
        i -= 1;
      }
      return false;
    }
    
    @NonNull
    private TextAppearanceSpan makeFontColorSpan(int paramInt)
    {
      return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(paramInt), null);
    }
    
    private CharSequence makeMessageLine(Message paramMessage)
    {
      BidiFormatter localBidiFormatter = BidiFormatter.getInstance();
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      int j;
      if (Build.VERSION.SDK_INT >= 21) {
        j = 1;
      } else {
        j = 0;
      }
      int i;
      if (j != 0) {
        i = -16777216;
      } else {
        i = -1;
      }
      if (paramMessage.getPerson() == null) {
        localObject1 = "";
      } else {
        localObject1 = paramMessage.getPerson().getName();
      }
      int k = i;
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = this.mUser.getName();
        k = i;
        localObject2 = localObject1;
        if (j != 0)
        {
          k = i;
          localObject2 = localObject1;
          if (this.mBuilder.getColor() != 0)
          {
            k = this.mBuilder.getColor();
            localObject2 = localObject1;
          }
        }
      }
      Object localObject1 = localBidiFormatter.unicodeWrap((CharSequence)localObject2);
      localSpannableStringBuilder.append((CharSequence)localObject1);
      localSpannableStringBuilder.setSpan(makeFontColorSpan(k), localSpannableStringBuilder.length() - ((CharSequence)localObject1).length(), localSpannableStringBuilder.length(), 33);
      if (paramMessage.getText() == null) {
        paramMessage = "";
      } else {
        paramMessage = paramMessage.getText();
      }
      localSpannableStringBuilder.append("  ").append(localBidiFormatter.unicodeWrap(paramMessage));
      return localSpannableStringBuilder;
    }
    
    public void addCompatExtras(Bundle paramBundle)
    {
      super.addCompatExtras(paramBundle);
      paramBundle.putCharSequence("android.selfDisplayName", this.mUser.getName());
      paramBundle.putBundle("android.messagingStyleUser", this.mUser.toBundle());
      paramBundle.putCharSequence("android.hiddenConversationTitle", this.mConversationTitle);
      if ((this.mConversationTitle != null) && (this.mIsGroupConversation.booleanValue())) {
        paramBundle.putCharSequence("android.conversationTitle", this.mConversationTitle);
      }
      if (!this.mMessages.isEmpty()) {
        paramBundle.putParcelableArray("android.messages", Message.getBundleArrayForMessages(this.mMessages));
      }
      if (this.mIsGroupConversation != null) {
        paramBundle.putBoolean("android.isGroupConversation", this.mIsGroupConversation.booleanValue());
      }
    }
    
    public MessagingStyle addMessage(Message paramMessage)
    {
      this.mMessages.add(paramMessage);
      if (this.mMessages.size() > 25) {
        this.mMessages.remove(0);
      }
      return this;
    }
    
    public MessagingStyle addMessage(CharSequence paramCharSequence, long paramLong, Person paramPerson)
    {
      addMessage(new Message(paramCharSequence, paramLong, paramPerson));
      return this;
    }
    
    @Deprecated
    public MessagingStyle addMessage(CharSequence paramCharSequence1, long paramLong, CharSequence paramCharSequence2)
    {
      this.mMessages.add(new Message(paramCharSequence1, paramLong, new Person.Builder().setName(paramCharSequence2).build()));
      if (this.mMessages.size() > 25) {
        this.mMessages.remove(0);
      }
      return this;
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      setGroupConversation(isGroupConversation());
      Object localObject2;
      if (Build.VERSION.SDK_INT >= 24)
      {
        if (Build.VERSION.SDK_INT >= 28) {
          localObject1 = new Notification.MessagingStyle(this.mUser.toAndroidPerson());
        } else {
          localObject1 = new Notification.MessagingStyle(this.mUser.getName());
        }
        if ((this.mIsGroupConversation.booleanValue()) || (Build.VERSION.SDK_INT >= 28)) {
          ((Notification.MessagingStyle)localObject1).setConversationTitle(this.mConversationTitle);
        }
        if (Build.VERSION.SDK_INT >= 28) {
          ((Notification.MessagingStyle)localObject1).setGroupConversation(this.mIsGroupConversation.booleanValue());
        }
        Iterator localIterator = this.mMessages.iterator();
        while (localIterator.hasNext())
        {
          Message localMessage = (Message)localIterator.next();
          if (Build.VERSION.SDK_INT >= 28)
          {
            localObject2 = localMessage.getPerson();
            CharSequence localCharSequence = localMessage.getText();
            long l = localMessage.getTimestamp();
            if (localObject2 == null) {
              localObject2 = null;
            } else {
              localObject2 = ((Person)localObject2).toAndroidPerson();
            }
            localObject2 = new Notification.MessagingStyle.Message(localCharSequence, l, (android.app.Person)localObject2);
          }
          else
          {
            if (localMessage.getPerson() != null) {
              localObject2 = localMessage.getPerson().getName();
            } else {
              localObject2 = null;
            }
            localObject2 = new Notification.MessagingStyle.Message(localMessage.getText(), localMessage.getTimestamp(), (CharSequence)localObject2);
          }
          if (localMessage.getDataMimeType() != null) {
            ((Notification.MessagingStyle.Message)localObject2).setData(localMessage.getDataMimeType(), localMessage.getDataUri());
          }
          ((Notification.MessagingStyle)localObject1).addMessage((Notification.MessagingStyle.Message)localObject2);
        }
        ((Notification.MessagingStyle)localObject1).setBuilder(paramNotificationBuilderWithBuilderAccessor.getBuilder());
        return;
      }
      Object localObject1 = findLatestIncomingMessage();
      if ((this.mConversationTitle != null) && (this.mIsGroupConversation.booleanValue()))
      {
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.mConversationTitle);
      }
      else if (localObject1 != null)
      {
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
        if (((Message)localObject1).getPerson() != null) {
          paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(((Message)localObject1).getPerson().getName());
        }
      }
      if (localObject1 != null)
      {
        localObject2 = paramNotificationBuilderWithBuilderAccessor.getBuilder();
        if (this.mConversationTitle != null) {
          localObject1 = makeMessageLine((Message)localObject1);
        } else {
          localObject1 = ((Message)localObject1).getText();
        }
        ((Notification.Builder)localObject2).setContentText((CharSequence)localObject1);
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        localObject2 = new SpannableStringBuilder();
        int i;
        if ((this.mConversationTitle == null) && (!hasMessagesWithoutSender())) {
          i = 0;
        } else {
          i = 1;
        }
        int j = this.mMessages.size() - 1;
        while (j >= 0)
        {
          localObject1 = (Message)this.mMessages.get(j);
          if (i != 0) {
            localObject1 = makeMessageLine((Message)localObject1);
          } else {
            localObject1 = ((Message)localObject1).getText();
          }
          if (j != this.mMessages.size() - 1) {
            ((SpannableStringBuilder)localObject2).insert(0, "\n");
          }
          ((SpannableStringBuilder)localObject2).insert(0, (CharSequence)localObject1);
          j -= 1;
        }
        new Notification.BigTextStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText((CharSequence)localObject2);
      }
    }
    
    @Nullable
    public CharSequence getConversationTitle()
    {
      return this.mConversationTitle;
    }
    
    public List<Message> getMessages()
    {
      return this.mMessages;
    }
    
    public Person getUser()
    {
      return this.mUser;
    }
    
    @Deprecated
    public CharSequence getUserDisplayName()
    {
      return this.mUser.getName();
    }
    
    public boolean isGroupConversation()
    {
      NotificationCompat.Builder localBuilder = this.mBuilder;
      boolean bool2 = false;
      boolean bool1 = false;
      if ((localBuilder != null) && (this.mBuilder.mContext.getApplicationInfo().targetSdkVersion < 28) && (this.mIsGroupConversation == null))
      {
        if (this.mConversationTitle != null) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool2;
      if (this.mIsGroupConversation != null) {
        bool1 = this.mIsGroupConversation.booleanValue();
      }
      return bool1;
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected void restoreFromCompatExtras(Bundle paramBundle)
    {
      this.mMessages.clear();
      if (paramBundle.containsKey("android.messagingStyleUser")) {
        this.mUser = Person.fromBundle(paramBundle.getBundle("android.messagingStyleUser"));
      } else {
        this.mUser = new Person.Builder().setName(paramBundle.getString("android.selfDisplayName")).build();
      }
      this.mConversationTitle = paramBundle.getCharSequence("android.conversationTitle");
      if (this.mConversationTitle == null) {
        this.mConversationTitle = paramBundle.getCharSequence("android.hiddenConversationTitle");
      }
      Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("android.messages");
      if (arrayOfParcelable != null) {
        this.mMessages.addAll(Message.getMessagesFromBundleArray(arrayOfParcelable));
      }
      if (paramBundle.containsKey("android.isGroupConversation")) {
        this.mIsGroupConversation = Boolean.valueOf(paramBundle.getBoolean("android.isGroupConversation"));
      }
    }
    
    public MessagingStyle setConversationTitle(@Nullable CharSequence paramCharSequence)
    {
      this.mConversationTitle = paramCharSequence;
      return this;
    }
    
    public MessagingStyle setGroupConversation(boolean paramBoolean)
    {
      this.mIsGroupConversation = Boolean.valueOf(paramBoolean);
      return this;
    }
    
    public static final class Message
    {
      static final String KEY_DATA_MIME_TYPE = "type";
      static final String KEY_DATA_URI = "uri";
      static final String KEY_EXTRAS_BUNDLE = "extras";
      static final String KEY_NOTIFICATION_PERSON = "sender_person";
      static final String KEY_PERSON = "person";
      static final String KEY_SENDER = "sender";
      static final String KEY_TEXT = "text";
      static final String KEY_TIMESTAMP = "time";
      @Nullable
      private String mDataMimeType;
      @Nullable
      private Uri mDataUri;
      private Bundle mExtras = new Bundle();
      @Nullable
      private final Person mPerson;
      private final CharSequence mText;
      private final long mTimestamp;
      
      public Message(CharSequence paramCharSequence, long paramLong, @Nullable Person paramPerson)
      {
        this.mText = paramCharSequence;
        this.mTimestamp = paramLong;
        this.mPerson = paramPerson;
      }
      
      @Deprecated
      public Message(CharSequence paramCharSequence1, long paramLong, CharSequence paramCharSequence2)
      {
        this(paramCharSequence1, paramLong, new Person.Builder().setName(paramCharSequence2).build());
      }
      
      @NonNull
      static Bundle[] getBundleArrayForMessages(List<Message> paramList)
      {
        Bundle[] arrayOfBundle = new Bundle[paramList.size()];
        int j = paramList.size();
        int i = 0;
        while (i < j)
        {
          arrayOfBundle[i] = ((Message)paramList.get(i)).toBundle();
          i += 1;
        }
        return arrayOfBundle;
      }
      
      @Nullable
      static Message getMessageFromBundle(Bundle paramBundle)
      {
        for (;;)
        {
          try
          {
            if (paramBundle.containsKey("text"))
            {
              if (!paramBundle.containsKey("time")) {
                return null;
              }
              if (paramBundle.containsKey("person"))
              {
                localObject = Person.fromBundle(paramBundle.getBundle("person"));
              }
              else if ((paramBundle.containsKey("sender_person")) && (Build.VERSION.SDK_INT >= 28))
              {
                localObject = Person.fromAndroidPerson((android.app.Person)paramBundle.getParcelable("sender_person"));
              }
              else
              {
                if (!paramBundle.containsKey("sender")) {
                  break label195;
                }
                localObject = new Person.Builder().setName(paramBundle.getCharSequence("sender")).build();
              }
              localObject = new Message(paramBundle.getCharSequence("text"), paramBundle.getLong("time"), (Person)localObject);
              if ((paramBundle.containsKey("type")) && (paramBundle.containsKey("uri"))) {
                ((Message)localObject).setData(paramBundle.getString("type"), (Uri)paramBundle.getParcelable("uri"));
              }
              if (paramBundle.containsKey("extras")) {
                ((Message)localObject).getExtras().putAll(paramBundle.getBundle("extras"));
              }
              return (Message)localObject;
            }
            else
            {
              return null;
            }
          }
          catch (ClassCastException paramBundle)
          {
            return null;
          }
          label195:
          Object localObject = null;
        }
      }
      
      @NonNull
      static List<Message> getMessagesFromBundleArray(Parcelable[] paramArrayOfParcelable)
      {
        ArrayList localArrayList = new ArrayList(paramArrayOfParcelable.length);
        int i = 0;
        while (i < paramArrayOfParcelable.length)
        {
          if ((paramArrayOfParcelable[i] instanceof Bundle))
          {
            Message localMessage = getMessageFromBundle((Bundle)paramArrayOfParcelable[i]);
            if (localMessage != null) {
              localArrayList.add(localMessage);
            }
          }
          i += 1;
        }
        return localArrayList;
      }
      
      private Bundle toBundle()
      {
        Bundle localBundle = new Bundle();
        if (this.mText != null) {
          localBundle.putCharSequence("text", this.mText);
        }
        localBundle.putLong("time", this.mTimestamp);
        if (this.mPerson != null)
        {
          localBundle.putCharSequence("sender", this.mPerson.getName());
          if (Build.VERSION.SDK_INT >= 28) {
            localBundle.putParcelable("sender_person", this.mPerson.toAndroidPerson());
          } else {
            localBundle.putBundle("person", this.mPerson.toBundle());
          }
        }
        if (this.mDataMimeType != null) {
          localBundle.putString("type", this.mDataMimeType);
        }
        if (this.mDataUri != null) {
          localBundle.putParcelable("uri", this.mDataUri);
        }
        if (this.mExtras != null) {
          localBundle.putBundle("extras", this.mExtras);
        }
        return localBundle;
      }
      
      @Nullable
      public String getDataMimeType()
      {
        return this.mDataMimeType;
      }
      
      @Nullable
      public Uri getDataUri()
      {
        return this.mDataUri;
      }
      
      @NonNull
      public Bundle getExtras()
      {
        return this.mExtras;
      }
      
      @Nullable
      public Person getPerson()
      {
        return this.mPerson;
      }
      
      @Deprecated
      @Nullable
      public CharSequence getSender()
      {
        if (this.mPerson == null) {
          return null;
        }
        return this.mPerson.getName();
      }
      
      @NonNull
      public CharSequence getText()
      {
        return this.mText;
      }
      
      public long getTimestamp()
      {
        return this.mTimestamp;
      }
      
      public Message setData(String paramString, Uri paramUri)
      {
        this.mDataMimeType = paramString;
        this.mDataUri = paramUri;
        return this;
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface NotificationVisibility {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface StreamType {}
  
  public static abstract class Style
  {
    CharSequence mBigContentTitle;
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected NotificationCompat.Builder mBuilder;
    CharSequence mSummaryText;
    boolean mSummaryTextSet = false;
    
    private int calculateTopPadding()
    {
      Resources localResources = this.mBuilder.mContext.getResources();
      int i = localResources.getDimensionPixelSize(R.dimen.notification_top_pad);
      int j = localResources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
      float f = (constrain(localResources.getConfiguration().fontScale, 1.0F, 1.3F) - 1.0F) / 0.29999995F;
      return Math.round((1.0F - f) * i + f * j);
    }
    
    private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      if (paramFloat1 < paramFloat2) {
        return paramFloat2;
      }
      paramFloat2 = paramFloat1;
      if (paramFloat1 > paramFloat3) {
        paramFloat2 = paramFloat3;
      }
      return paramFloat2;
    }
    
    private Bitmap createColoredBitmap(int paramInt1, int paramInt2, int paramInt3)
    {
      Drawable localDrawable = this.mBuilder.mContext.getResources().getDrawable(paramInt1);
      if (paramInt3 == 0) {
        paramInt1 = localDrawable.getIntrinsicWidth();
      } else {
        paramInt1 = paramInt3;
      }
      int i = paramInt3;
      if (paramInt3 == 0) {
        i = localDrawable.getIntrinsicHeight();
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, i, Bitmap.Config.ARGB_8888);
      localDrawable.setBounds(0, 0, paramInt1, i);
      if (paramInt2 != 0) {
        localDrawable.mutate().setColorFilter(new PorterDuffColorFilter(paramInt2, PorterDuff.Mode.SRC_IN));
      }
      localDrawable.draw(new Canvas(localBitmap));
      return localBitmap;
    }
    
    private Bitmap createIconWithBackground(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int j = R.drawable.notification_icon_background;
      int i = paramInt4;
      if (paramInt4 == 0) {
        i = 0;
      }
      Bitmap localBitmap = createColoredBitmap(j, i, paramInt2);
      Canvas localCanvas = new Canvas(localBitmap);
      Drawable localDrawable = this.mBuilder.mContext.getResources().getDrawable(paramInt1).mutate();
      localDrawable.setFilterBitmap(true);
      paramInt1 = (paramInt2 - paramInt3) / 2;
      paramInt2 = paramInt3 + paramInt1;
      localDrawable.setBounds(paramInt1, paramInt1, paramInt2, paramInt2);
      localDrawable.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      localDrawable.draw(localCanvas);
      return localBitmap;
    }
    
    private void hideNormalContent(RemoteViews paramRemoteViews)
    {
      paramRemoteViews.setViewVisibility(R.id.title, 8);
      paramRemoteViews.setViewVisibility(R.id.text2, 8);
      paramRemoteViews.setViewVisibility(R.id.text, 8);
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void addCompatExtras(Bundle paramBundle) {}
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {}
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews applyStandardTemplate(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      Resources localResources = this.mBuilder.mContext.getResources();
      RemoteViews localRemoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), paramInt);
      paramInt = this.mBuilder.getPriority();
      int k = 0;
      if (paramInt < -1) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 21)) {
        if (paramInt != 0)
        {
          localRemoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg_low);
          localRemoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_low_bg);
        }
        else
        {
          localRemoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg);
          localRemoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_bg);
        }
      }
      int i;
      Object localObject;
      if (this.mBuilder.mLargeIcon != null)
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          localRemoteViews.setViewVisibility(R.id.icon, 0);
          localRemoteViews.setImageViewBitmap(R.id.icon, this.mBuilder.mLargeIcon);
        }
        else
        {
          localRemoteViews.setViewVisibility(R.id.icon, 8);
        }
        if ((paramBoolean1) && (this.mBuilder.mNotification.icon != 0))
        {
          paramInt = localResources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
          i = localResources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding);
          if (Build.VERSION.SDK_INT >= 21)
          {
            localObject = createIconWithBackground(this.mBuilder.mNotification.icon, paramInt, paramInt - i * 2, this.mBuilder.getColor());
            localRemoteViews.setImageViewBitmap(R.id.right_icon, (Bitmap)localObject);
          }
          else
          {
            localRemoteViews.setImageViewBitmap(R.id.right_icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
          }
          localRemoteViews.setViewVisibility(R.id.right_icon, 0);
        }
      }
      else if ((paramBoolean1) && (this.mBuilder.mNotification.icon != 0))
      {
        localRemoteViews.setViewVisibility(R.id.icon, 0);
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramInt = localResources.getDimensionPixelSize(R.dimen.notification_large_icon_width);
          i = localResources.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
          j = localResources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
          localObject = createIconWithBackground(this.mBuilder.mNotification.icon, paramInt - i, j, this.mBuilder.getColor());
          localRemoteViews.setImageViewBitmap(R.id.icon, (Bitmap)localObject);
        }
        else
        {
          localRemoteViews.setImageViewBitmap(R.id.icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
        }
      }
      if (this.mBuilder.mContentTitle != null) {
        localRemoteViews.setTextViewText(R.id.title, this.mBuilder.mContentTitle);
      }
      if (this.mBuilder.mContentText != null)
      {
        localRemoteViews.setTextViewText(R.id.text, this.mBuilder.mContentText);
        i = 1;
      }
      else
      {
        i = 0;
      }
      if ((Build.VERSION.SDK_INT < 21) && (this.mBuilder.mLargeIcon != null)) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (this.mBuilder.mContentInfo != null)
      {
        localRemoteViews.setTextViewText(R.id.info, this.mBuilder.mContentInfo);
        localRemoteViews.setViewVisibility(R.id.info, 0);
      }
      for (;;)
      {
        i = 1;
        paramInt = 1;
        break label658;
        if (this.mBuilder.mNumber <= 0) {
          break;
        }
        paramInt = localResources.getInteger(R.integer.status_bar_notification_info_maxnum);
        if (this.mBuilder.mNumber > paramInt)
        {
          localRemoteViews.setTextViewText(R.id.info, localResources.getString(R.string.status_bar_notification_info_overflow));
        }
        else
        {
          localObject = NumberFormat.getIntegerInstance();
          localRemoteViews.setTextViewText(R.id.info, ((NumberFormat)localObject).format(this.mBuilder.mNumber));
        }
        localRemoteViews.setViewVisibility(R.id.info, 0);
      }
      localRemoteViews.setViewVisibility(R.id.info, 8);
      label658:
      if ((this.mBuilder.mSubText != null) && (Build.VERSION.SDK_INT >= 16))
      {
        localRemoteViews.setTextViewText(R.id.text, this.mBuilder.mSubText);
        if (this.mBuilder.mContentText != null)
        {
          localRemoteViews.setTextViewText(R.id.text2, this.mBuilder.mContentText);
          localRemoteViews.setViewVisibility(R.id.text2, 0);
          j = 1;
        }
        else
        {
          localRemoteViews.setViewVisibility(R.id.text2, 8);
        }
      }
      else
      {
        j = 0;
      }
      if ((j != 0) && (Build.VERSION.SDK_INT >= 16))
      {
        if (paramBoolean2)
        {
          float f = localResources.getDimensionPixelSize(R.dimen.notification_subtext_size);
          localRemoteViews.setTextViewTextSize(R.id.text, 0, f);
        }
        localRemoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
      }
      if (this.mBuilder.getWhenIfShowing() != 0L)
      {
        if ((this.mBuilder.mUseChronometer) && (Build.VERSION.SDK_INT >= 16))
        {
          localRemoteViews.setViewVisibility(R.id.chronometer, 0);
          localRemoteViews.setLong(R.id.chronometer, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
          localRemoteViews.setBoolean(R.id.chronometer, "setStarted", true);
        }
        else
        {
          localRemoteViews.setViewVisibility(R.id.time, 0);
          localRemoteViews.setLong(R.id.time, "setTime", this.mBuilder.getWhenIfShowing());
        }
        paramInt = 1;
      }
      int j = R.id.right_side;
      if (paramInt != 0) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      localRemoteViews.setViewVisibility(j, paramInt);
      j = R.id.line3;
      if (i != 0) {
        paramInt = k;
      } else {
        paramInt = 8;
      }
      localRemoteViews.setViewVisibility(j, paramInt);
      return localRemoteViews;
    }
    
    public Notification build()
    {
      if (this.mBuilder != null) {
        return this.mBuilder.build();
      }
      return null;
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void buildIntoRemoteViews(RemoteViews paramRemoteViews1, RemoteViews paramRemoteViews2)
    {
      hideNormalContent(paramRemoteViews1);
      paramRemoteViews1.removeAllViews(R.id.notification_main_column);
      paramRemoteViews1.addView(R.id.notification_main_column, paramRemoteViews2.clone());
      paramRemoteViews1.setViewVisibility(R.id.notification_main_column, 0);
      if (Build.VERSION.SDK_INT >= 21) {
        paramRemoteViews1.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
      }
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public Bitmap createColoredBitmap(int paramInt1, int paramInt2)
    {
      return createColoredBitmap(paramInt1, paramInt2, 0);
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      return null;
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      return null;
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      return null;
    }
    
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected void restoreFromCompatExtras(Bundle paramBundle) {}
    
    public void setBuilder(NotificationCompat.Builder paramBuilder)
    {
      if (this.mBuilder != paramBuilder)
      {
        this.mBuilder = paramBuilder;
        if (this.mBuilder != null) {
          this.mBuilder.setStyle(this);
        }
      }
    }
  }
  
  public static final class WearableExtender
    implements NotificationCompat.Extender
  {
    private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
    private static final int DEFAULT_FLAGS = 1;
    private static final int DEFAULT_GRAVITY = 80;
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
    private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
    private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
    private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
    private static final int FLAG_HINT_HIDE_ICON = 2;
    private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
    private static final int FLAG_START_SCROLL_BOTTOM = 8;
    private static final String KEY_ACTIONS = "actions";
    private static final String KEY_BACKGROUND = "background";
    private static final String KEY_BRIDGE_TAG = "bridgeTag";
    private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
    private static final String KEY_CONTENT_ICON = "contentIcon";
    private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
    private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
    private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
    private static final String KEY_DISMISSAL_ID = "dismissalId";
    private static final String KEY_DISPLAY_INTENT = "displayIntent";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_GRAVITY = "gravity";
    private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
    private static final String KEY_PAGES = "pages";
    public static final int SCREEN_TIMEOUT_LONG = -1;
    public static final int SCREEN_TIMEOUT_SHORT = 0;
    public static final int SIZE_DEFAULT = 0;
    public static final int SIZE_FULL_SCREEN = 5;
    public static final int SIZE_LARGE = 4;
    public static final int SIZE_MEDIUM = 3;
    public static final int SIZE_SMALL = 2;
    public static final int SIZE_XSMALL = 1;
    public static final int UNSET_ACTION_INDEX = -1;
    private ArrayList<NotificationCompat.Action> mActions = new ArrayList();
    private Bitmap mBackground;
    private String mBridgeTag;
    private int mContentActionIndex = -1;
    private int mContentIcon;
    private int mContentIconGravity = 8388613;
    private int mCustomContentHeight;
    private int mCustomSizePreset = 0;
    private String mDismissalId;
    private PendingIntent mDisplayIntent;
    private int mFlags = 1;
    private int mGravity = 80;
    private int mHintScreenTimeout;
    private ArrayList<Notification> mPages = new ArrayList();
    
    public WearableExtender() {}
    
    public WearableExtender(Notification paramNotification)
    {
      paramNotification = NotificationCompat.getExtras(paramNotification);
      if (paramNotification != null) {
        paramNotification = paramNotification.getBundle("android.wearable.EXTENSIONS");
      } else {
        paramNotification = null;
      }
      if (paramNotification != null)
      {
        Object localObject = paramNotification.getParcelableArrayList("actions");
        if ((Build.VERSION.SDK_INT >= 16) && (localObject != null))
        {
          NotificationCompat.Action[] arrayOfAction = new NotificationCompat.Action[((ArrayList)localObject).size()];
          int i = 0;
          while (i < arrayOfAction.length)
          {
            if (Build.VERSION.SDK_INT >= 20) {
              arrayOfAction[i] = NotificationCompat.getActionCompatFromAction((Notification.Action)((ArrayList)localObject).get(i));
            } else if (Build.VERSION.SDK_INT >= 16) {
              arrayOfAction[i] = NotificationCompatJellybean.getActionFromBundle((Bundle)((ArrayList)localObject).get(i));
            }
            i += 1;
          }
          Collections.addAll(this.mActions, (NotificationCompat.Action[])arrayOfAction);
        }
        this.mFlags = paramNotification.getInt("flags", 1);
        this.mDisplayIntent = ((PendingIntent)paramNotification.getParcelable("displayIntent"));
        localObject = NotificationCompat.getNotificationArrayFromBundle(paramNotification, "pages");
        if (localObject != null) {
          Collections.addAll(this.mPages, (Object[])localObject);
        }
        this.mBackground = ((Bitmap)paramNotification.getParcelable("background"));
        this.mContentIcon = paramNotification.getInt("contentIcon");
        this.mContentIconGravity = paramNotification.getInt("contentIconGravity", 8388613);
        this.mContentActionIndex = paramNotification.getInt("contentActionIndex", -1);
        this.mCustomSizePreset = paramNotification.getInt("customSizePreset", 0);
        this.mCustomContentHeight = paramNotification.getInt("customContentHeight");
        this.mGravity = paramNotification.getInt("gravity", 80);
        this.mHintScreenTimeout = paramNotification.getInt("hintScreenTimeout");
        this.mDismissalId = paramNotification.getString("dismissalId");
        this.mBridgeTag = paramNotification.getString("bridgeTag");
      }
    }
    
    @RequiresApi(20)
    private static Notification.Action getActionFromActionCompat(NotificationCompat.Action paramAction)
    {
      Notification.Action.Builder localBuilder = new Notification.Action.Builder(paramAction.getIcon(), paramAction.getTitle(), paramAction.getActionIntent());
      Bundle localBundle;
      if (paramAction.getExtras() != null) {
        localBundle = new Bundle(paramAction.getExtras());
      } else {
        localBundle = new Bundle();
      }
      localBundle.putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
      if (Build.VERSION.SDK_INT >= 24) {
        localBuilder.setAllowGeneratedReplies(paramAction.getAllowGeneratedReplies());
      }
      localBuilder.addExtras(localBundle);
      paramAction = paramAction.getRemoteInputs();
      if (paramAction != null)
      {
        paramAction = RemoteInput.fromCompat(paramAction);
        int j = paramAction.length;
        int i = 0;
        while (i < j)
        {
          localBuilder.addRemoteInput(paramAction[i]);
          i += 1;
        }
      }
      return localBuilder.build();
    }
    
    private void setFlag(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.mFlags = (paramInt | this.mFlags);
        return;
      }
      this.mFlags = ((paramInt ^ 0xFFFFFFFF) & this.mFlags);
    }
    
    public WearableExtender addAction(NotificationCompat.Action paramAction)
    {
      this.mActions.add(paramAction);
      return this;
    }
    
    public WearableExtender addActions(List<NotificationCompat.Action> paramList)
    {
      this.mActions.addAll(paramList);
      return this;
    }
    
    public WearableExtender addPage(Notification paramNotification)
    {
      this.mPages.add(paramNotification);
      return this;
    }
    
    public WearableExtender addPages(List<Notification> paramList)
    {
      this.mPages.addAll(paramList);
      return this;
    }
    
    public WearableExtender clearActions()
    {
      this.mActions.clear();
      return this;
    }
    
    public WearableExtender clearPages()
    {
      this.mPages.clear();
      return this;
    }
    
    public WearableExtender clone()
    {
      WearableExtender localWearableExtender = new WearableExtender();
      localWearableExtender.mActions = new ArrayList(this.mActions);
      localWearableExtender.mFlags = this.mFlags;
      localWearableExtender.mDisplayIntent = this.mDisplayIntent;
      localWearableExtender.mPages = new ArrayList(this.mPages);
      localWearableExtender.mBackground = this.mBackground;
      localWearableExtender.mContentIcon = this.mContentIcon;
      localWearableExtender.mContentIconGravity = this.mContentIconGravity;
      localWearableExtender.mContentActionIndex = this.mContentActionIndex;
      localWearableExtender.mCustomSizePreset = this.mCustomSizePreset;
      localWearableExtender.mCustomContentHeight = this.mCustomContentHeight;
      localWearableExtender.mGravity = this.mGravity;
      localWearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
      localWearableExtender.mDismissalId = this.mDismissalId;
      localWearableExtender.mBridgeTag = this.mBridgeTag;
      return localWearableExtender;
    }
    
    public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
    {
      Bundle localBundle = new Bundle();
      if (!this.mActions.isEmpty()) {
        if (Build.VERSION.SDK_INT >= 16)
        {
          ArrayList localArrayList = new ArrayList(this.mActions.size());
          Iterator localIterator = this.mActions.iterator();
          while (localIterator.hasNext())
          {
            NotificationCompat.Action localAction = (NotificationCompat.Action)localIterator.next();
            if (Build.VERSION.SDK_INT >= 20) {
              localArrayList.add(getActionFromActionCompat(localAction));
            } else if (Build.VERSION.SDK_INT >= 16) {
              localArrayList.add(NotificationCompatJellybean.getBundleForAction(localAction));
            }
          }
          localBundle.putParcelableArrayList("actions", localArrayList);
        }
        else
        {
          localBundle.putParcelableArrayList("actions", null);
        }
      }
      if (this.mFlags != 1) {
        localBundle.putInt("flags", this.mFlags);
      }
      if (this.mDisplayIntent != null) {
        localBundle.putParcelable("displayIntent", this.mDisplayIntent);
      }
      if (!this.mPages.isEmpty()) {
        localBundle.putParcelableArray("pages", (Parcelable[])this.mPages.toArray(new Notification[this.mPages.size()]));
      }
      if (this.mBackground != null) {
        localBundle.putParcelable("background", this.mBackground);
      }
      if (this.mContentIcon != 0) {
        localBundle.putInt("contentIcon", this.mContentIcon);
      }
      if (this.mContentIconGravity != 8388613) {
        localBundle.putInt("contentIconGravity", this.mContentIconGravity);
      }
      if (this.mContentActionIndex != -1) {
        localBundle.putInt("contentActionIndex", this.mContentActionIndex);
      }
      if (this.mCustomSizePreset != 0) {
        localBundle.putInt("customSizePreset", this.mCustomSizePreset);
      }
      if (this.mCustomContentHeight != 0) {
        localBundle.putInt("customContentHeight", this.mCustomContentHeight);
      }
      if (this.mGravity != 80) {
        localBundle.putInt("gravity", this.mGravity);
      }
      if (this.mHintScreenTimeout != 0) {
        localBundle.putInt("hintScreenTimeout", this.mHintScreenTimeout);
      }
      if (this.mDismissalId != null) {
        localBundle.putString("dismissalId", this.mDismissalId);
      }
      if (this.mBridgeTag != null) {
        localBundle.putString("bridgeTag", this.mBridgeTag);
      }
      paramBuilder.getExtras().putBundle("android.wearable.EXTENSIONS", localBundle);
      return paramBuilder;
    }
    
    public List<NotificationCompat.Action> getActions()
    {
      return this.mActions;
    }
    
    public Bitmap getBackground()
    {
      return this.mBackground;
    }
    
    public String getBridgeTag()
    {
      return this.mBridgeTag;
    }
    
    public int getContentAction()
    {
      return this.mContentActionIndex;
    }
    
    @Deprecated
    public int getContentIcon()
    {
      return this.mContentIcon;
    }
    
    @Deprecated
    public int getContentIconGravity()
    {
      return this.mContentIconGravity;
    }
    
    public boolean getContentIntentAvailableOffline()
    {
      return (this.mFlags & 0x1) != 0;
    }
    
    @Deprecated
    public int getCustomContentHeight()
    {
      return this.mCustomContentHeight;
    }
    
    @Deprecated
    public int getCustomSizePreset()
    {
      return this.mCustomSizePreset;
    }
    
    public String getDismissalId()
    {
      return this.mDismissalId;
    }
    
    public PendingIntent getDisplayIntent()
    {
      return this.mDisplayIntent;
    }
    
    @Deprecated
    public int getGravity()
    {
      return this.mGravity;
    }
    
    public boolean getHintAmbientBigPicture()
    {
      return (this.mFlags & 0x20) != 0;
    }
    
    @Deprecated
    public boolean getHintAvoidBackgroundClipping()
    {
      return (this.mFlags & 0x10) != 0;
    }
    
    public boolean getHintContentIntentLaunchesActivity()
    {
      return (this.mFlags & 0x40) != 0;
    }
    
    @Deprecated
    public boolean getHintHideIcon()
    {
      return (this.mFlags & 0x2) != 0;
    }
    
    @Deprecated
    public int getHintScreenTimeout()
    {
      return this.mHintScreenTimeout;
    }
    
    @Deprecated
    public boolean getHintShowBackgroundOnly()
    {
      return (this.mFlags & 0x4) != 0;
    }
    
    public List<Notification> getPages()
    {
      return this.mPages;
    }
    
    public boolean getStartScrollBottom()
    {
      return (this.mFlags & 0x8) != 0;
    }
    
    public WearableExtender setBackground(Bitmap paramBitmap)
    {
      this.mBackground = paramBitmap;
      return this;
    }
    
    public WearableExtender setBridgeTag(String paramString)
    {
      this.mBridgeTag = paramString;
      return this;
    }
    
    public WearableExtender setContentAction(int paramInt)
    {
      this.mContentActionIndex = paramInt;
      return this;
    }
    
    @Deprecated
    public WearableExtender setContentIcon(int paramInt)
    {
      this.mContentIcon = paramInt;
      return this;
    }
    
    @Deprecated
    public WearableExtender setContentIconGravity(int paramInt)
    {
      this.mContentIconGravity = paramInt;
      return this;
    }
    
    public WearableExtender setContentIntentAvailableOffline(boolean paramBoolean)
    {
      setFlag(1, paramBoolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setCustomContentHeight(int paramInt)
    {
      this.mCustomContentHeight = paramInt;
      return this;
    }
    
    @Deprecated
    public WearableExtender setCustomSizePreset(int paramInt)
    {
      this.mCustomSizePreset = paramInt;
      return this;
    }
    
    public WearableExtender setDismissalId(String paramString)
    {
      this.mDismissalId = paramString;
      return this;
    }
    
    public WearableExtender setDisplayIntent(PendingIntent paramPendingIntent)
    {
      this.mDisplayIntent = paramPendingIntent;
      return this;
    }
    
    @Deprecated
    public WearableExtender setGravity(int paramInt)
    {
      this.mGravity = paramInt;
      return this;
    }
    
    public WearableExtender setHintAmbientBigPicture(boolean paramBoolean)
    {
      setFlag(32, paramBoolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setHintAvoidBackgroundClipping(boolean paramBoolean)
    {
      setFlag(16, paramBoolean);
      return this;
    }
    
    public WearableExtender setHintContentIntentLaunchesActivity(boolean paramBoolean)
    {
      setFlag(64, paramBoolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setHintHideIcon(boolean paramBoolean)
    {
      setFlag(2, paramBoolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setHintScreenTimeout(int paramInt)
    {
      this.mHintScreenTimeout = paramInt;
      return this;
    }
    
    @Deprecated
    public WearableExtender setHintShowBackgroundOnly(boolean paramBoolean)
    {
      setFlag(4, paramBoolean);
      return this;
    }
    
    public WearableExtender setStartScrollBottom(boolean paramBoolean)
    {
      setFlag(8, paramBoolean);
      return this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\app\NotificationCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */