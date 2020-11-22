package android.support.v4.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class MediaBrowserServiceCompat
  extends Service
{
  static final boolean DEBUG = Log.isLoggable("MBServiceCompat", 3);
  private static final float EPSILON = 1.0E-5F;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public static final String KEY_MEDIA_ITEM = "media_item";
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public static final String KEY_SEARCH_RESULTS = "search_results";
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public static final int RESULT_ERROR = -1;
  static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
  static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
  static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public static final int RESULT_OK = 0;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public static final int RESULT_PROGRESS_UPDATE = 1;
  public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
  static final String TAG = "MBServiceCompat";
  final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap();
  ConnectionRecord mCurConnection;
  final ServiceHandler mHandler = new ServiceHandler();
  private MediaBrowserServiceImpl mImpl;
  MediaSessionCompat.Token mSession;
  
  void addSubscription(String paramString, ConnectionRecord paramConnectionRecord, IBinder paramIBinder, Bundle paramBundle)
  {
    Object localObject2 = (List)paramConnectionRecord.subscriptions.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject2).next();
      if ((paramIBinder == localPair.first) && (MediaBrowserCompatUtils.areSameOptions(paramBundle, (Bundle)localPair.second))) {
        return;
      }
    }
    ((List)localObject1).add(new Pair(paramIBinder, paramBundle));
    paramConnectionRecord.subscriptions.put(paramString, localObject1);
    performLoadChildren(paramString, paramConnectionRecord, paramBundle, null);
    this.mCurConnection = paramConnectionRecord;
    onSubscribe(paramString, paramBundle);
    this.mCurConnection = null;
  }
  
  List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
  {
    if (paramList == null) {
      return null;
    }
    int i = paramBundle.getInt("android.media.browse.extra.PAGE", -1);
    int m = paramBundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    if ((i == -1) && (m == -1)) {
      return paramList;
    }
    int k = m * i;
    int j = k + m;
    if ((i >= 0) && (m >= 1) && (k < paramList.size()))
    {
      i = j;
      if (j > paramList.size()) {
        i = paramList.size();
      }
      return paramList.subList(k, i);
    }
    return Collections.emptyList();
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public void attachToBaseContext(Context paramContext)
  {
    attachBaseContext(paramContext);
  }
  
  public void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final Bundle getBrowserRootHints()
  {
    return this.mImpl.getBrowserRootHints();
  }
  
  @NonNull
  public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo()
  {
    return this.mImpl.getCurrentBrowserInfo();
  }
  
  @Nullable
  public MediaSessionCompat.Token getSessionToken()
  {
    return this.mSession;
  }
  
  boolean isValidPackage(String paramString, int paramInt)
  {
    if (paramString == null) {
      return false;
    }
    String[] arrayOfString = getPackageManager().getPackagesForUid(paramInt);
    int i = arrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (arrayOfString[paramInt].equals(paramString)) {
        return true;
      }
      paramInt += 1;
    }
    return false;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void notifyChildrenChanged(@NonNull MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, @NonNull String paramString, @NonNull Bundle paramBundle)
  {
    if (paramRemoteUserInfo != null)
    {
      if (paramString != null)
      {
        if (paramBundle != null)
        {
          this.mImpl.notifyChildrenChanged(paramRemoteUserInfo, paramString, paramBundle);
          return;
        }
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
      }
      throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }
    throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
  }
  
  public void notifyChildrenChanged(@NonNull String paramString)
  {
    if (paramString != null)
    {
      this.mImpl.notifyChildrenChanged(paramString, null);
      return;
    }
    throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
  }
  
  public void notifyChildrenChanged(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    if (paramString != null)
    {
      if (paramBundle != null)
      {
        this.mImpl.notifyChildrenChanged(paramString, paramBundle);
        return;
      }
      throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    }
    throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.mImpl.onBind(paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 28) {
      this.mImpl = new MediaBrowserServiceImplApi28();
    } else if (Build.VERSION.SDK_INT >= 26) {
      this.mImpl = new MediaBrowserServiceImplApi26();
    } else if (Build.VERSION.SDK_INT >= 23) {
      this.mImpl = new MediaBrowserServiceImplApi23();
    } else if (Build.VERSION.SDK_INT >= 21) {
      this.mImpl = new MediaBrowserServiceImplApi21();
    } else {
      this.mImpl = new MediaBrowserServiceImplBase();
    }
    this.mImpl.onCreate();
  }
  
  public void onCustomAction(@NonNull String paramString, Bundle paramBundle, @NonNull Result<Bundle> paramResult)
  {
    paramResult.sendError(null);
  }
  
  @Nullable
  public abstract BrowserRoot onGetRoot(@NonNull String paramString, int paramInt, @Nullable Bundle paramBundle);
  
  public abstract void onLoadChildren(@NonNull String paramString, @NonNull Result<List<MediaBrowserCompat.MediaItem>> paramResult);
  
  public void onLoadChildren(@NonNull String paramString, @NonNull Result<List<MediaBrowserCompat.MediaItem>> paramResult, @NonNull Bundle paramBundle)
  {
    paramResult.setFlags(1);
    onLoadChildren(paramString, paramResult);
  }
  
  public void onLoadItem(String paramString, @NonNull Result<MediaBrowserCompat.MediaItem> paramResult)
  {
    paramResult.setFlags(2);
    paramResult.sendResult(null);
  }
  
  public void onSearch(@NonNull String paramString, Bundle paramBundle, @NonNull Result<List<MediaBrowserCompat.MediaItem>> paramResult)
  {
    paramResult.setFlags(4);
    paramResult.sendResult(null);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void onSubscribe(String paramString, Bundle paramBundle) {}
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void onUnsubscribe(String paramString) {}
  
  void performCustomAction(String paramString, Bundle paramBundle, ConnectionRecord paramConnectionRecord, final ResultReceiver paramResultReceiver)
  {
    paramResultReceiver = new Result(paramString)
    {
      void onErrorSent(Bundle paramAnonymousBundle)
      {
        paramResultReceiver.send(-1, paramAnonymousBundle);
      }
      
      void onProgressUpdateSent(Bundle paramAnonymousBundle)
      {
        paramResultReceiver.send(1, paramAnonymousBundle);
      }
      
      void onResultSent(Bundle paramAnonymousBundle)
      {
        paramResultReceiver.send(0, paramAnonymousBundle);
      }
    };
    this.mCurConnection = paramConnectionRecord;
    onCustomAction(paramString, paramBundle, paramResultReceiver);
    this.mCurConnection = null;
    if (paramResultReceiver.isDone()) {
      return;
    }
    paramConnectionRecord = new StringBuilder();
    paramConnectionRecord.append("onCustomAction must call detach() or sendResult() or sendError() before returning for action=");
    paramConnectionRecord.append(paramString);
    paramConnectionRecord.append(" extras=");
    paramConnectionRecord.append(paramBundle);
    throw new IllegalStateException(paramConnectionRecord.toString());
  }
  
  void performLoadChildren(final String paramString, final ConnectionRecord paramConnectionRecord, final Bundle paramBundle1, final Bundle paramBundle2)
  {
    paramBundle2 = new Result(paramString)
    {
      void onResultSent(List<MediaBrowserCompat.MediaItem> paramAnonymousList)
      {
        if (MediaBrowserServiceCompat.this.mConnections.get(paramConnectionRecord.callbacks.asBinder()) != paramConnectionRecord)
        {
          if (MediaBrowserServiceCompat.DEBUG)
          {
            paramAnonymousList = new StringBuilder();
            paramAnonymousList.append("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
            paramAnonymousList.append(paramConnectionRecord.pkg);
            paramAnonymousList.append(" id=");
            paramAnonymousList.append(paramString);
            Log.d("MBServiceCompat", paramAnonymousList.toString());
          }
          return;
        }
        Object localObject = paramAnonymousList;
        if ((getFlags() & 0x1) != 0) {
          localObject = MediaBrowserServiceCompat.this.applyOptions(paramAnonymousList, paramBundle1);
        }
        try
        {
          paramConnectionRecord.callbacks.onLoadChildren(paramString, (List)localObject, paramBundle1, paramBundle2);
          return;
        }
        catch (RemoteException paramAnonymousList)
        {
          for (;;) {}
        }
        paramAnonymousList = new StringBuilder();
        paramAnonymousList.append("Calling onLoadChildren() failed for id=");
        paramAnonymousList.append(paramString);
        paramAnonymousList.append(" package=");
        paramAnonymousList.append(paramConnectionRecord.pkg);
        Log.w("MBServiceCompat", paramAnonymousList.toString());
      }
    };
    this.mCurConnection = paramConnectionRecord;
    if (paramBundle1 == null) {
      onLoadChildren(paramString, paramBundle2);
    } else {
      onLoadChildren(paramString, paramBundle2, paramBundle1);
    }
    this.mCurConnection = null;
    if (paramBundle2.isDone()) {
      return;
    }
    paramBundle1 = new StringBuilder();
    paramBundle1.append("onLoadChildren must call detach() or sendResult() before returning for package=");
    paramBundle1.append(paramConnectionRecord.pkg);
    paramBundle1.append(" id=");
    paramBundle1.append(paramString);
    throw new IllegalStateException(paramBundle1.toString());
  }
  
  void performLoadItem(String paramString, ConnectionRecord paramConnectionRecord, final ResultReceiver paramResultReceiver)
  {
    paramResultReceiver = new Result(paramString)
    {
      void onResultSent(MediaBrowserCompat.MediaItem paramAnonymousMediaItem)
      {
        if ((getFlags() & 0x2) != 0)
        {
          paramResultReceiver.send(-1, null);
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("media_item", paramAnonymousMediaItem);
        paramResultReceiver.send(0, localBundle);
      }
    };
    this.mCurConnection = paramConnectionRecord;
    onLoadItem(paramString, paramResultReceiver);
    this.mCurConnection = null;
    if (paramResultReceiver.isDone()) {
      return;
    }
    paramConnectionRecord = new StringBuilder();
    paramConnectionRecord.append("onLoadItem must call detach() or sendResult() before returning for id=");
    paramConnectionRecord.append(paramString);
    throw new IllegalStateException(paramConnectionRecord.toString());
  }
  
  void performSearch(String paramString, Bundle paramBundle, ConnectionRecord paramConnectionRecord, final ResultReceiver paramResultReceiver)
  {
    paramResultReceiver = new Result(paramString)
    {
      void onResultSent(List<MediaBrowserCompat.MediaItem> paramAnonymousList)
      {
        if (((getFlags() & 0x4) == 0) && (paramAnonymousList != null))
        {
          Bundle localBundle = new Bundle();
          localBundle.putParcelableArray("search_results", (Parcelable[])paramAnonymousList.toArray(new MediaBrowserCompat.MediaItem[0]));
          paramResultReceiver.send(0, localBundle);
          return;
        }
        paramResultReceiver.send(-1, null);
      }
    };
    this.mCurConnection = paramConnectionRecord;
    onSearch(paramString, paramBundle, paramResultReceiver);
    this.mCurConnection = null;
    if (paramResultReceiver.isDone()) {
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("onSearch must call detach() or sendResult() before returning for query=");
    paramBundle.append(paramString);
    throw new IllegalStateException(paramBundle.toString());
  }
  
  boolean removeSubscription(String paramString, ConnectionRecord paramConnectionRecord, IBinder paramIBinder)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = false;
    if (paramIBinder == null) {
      try
      {
        paramIBinder = paramConnectionRecord.subscriptions.remove(paramString);
        if (paramIBinder != null) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        this.mCurConnection = paramConnectionRecord;
        onUnsubscribe(paramString);
        this.mCurConnection = null;
        return bool1;
      }
      finally
      {
        break label174;
      }
    }
    List localList = (List)paramConnectionRecord.subscriptions.get(paramString);
    bool2 = bool3;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        if (paramIBinder == ((Pair)localIterator.next()).first)
        {
          localIterator.remove();
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (localList.size() == 0)
      {
        paramConnectionRecord.subscriptions.remove(paramString);
        bool2 = bool1;
      }
    }
    this.mCurConnection = paramConnectionRecord;
    onUnsubscribe(paramString);
    this.mCurConnection = null;
    return bool2;
    label174:
    this.mCurConnection = paramConnectionRecord;
    onUnsubscribe(paramString);
    this.mCurConnection = null;
    throw paramIBinder;
  }
  
  public void setSessionToken(MediaSessionCompat.Token paramToken)
  {
    if (paramToken != null)
    {
      if (this.mSession == null)
      {
        this.mSession = paramToken;
        this.mImpl.setSessionToken(paramToken);
        return;
      }
      throw new IllegalStateException("The session token has already been set.");
    }
    throw new IllegalArgumentException("Session token may not be null.");
  }
  
  public static final class BrowserRoot
  {
    public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
    public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
    public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
    @Deprecated
    public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
    private final Bundle mExtras;
    private final String mRootId;
    
    public BrowserRoot(@NonNull String paramString, @Nullable Bundle paramBundle)
    {
      if (paramString != null)
      {
        this.mRootId = paramString;
        this.mExtras = paramBundle;
        return;
      }
      throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
    }
    
    public Bundle getExtras()
    {
      return this.mExtras;
    }
    
    public String getRootId()
    {
      return this.mRootId;
    }
  }
  
  private class ConnectionRecord
    implements IBinder.DeathRecipient
  {
    public final MediaSessionManager.RemoteUserInfo browserInfo;
    public final MediaBrowserServiceCompat.ServiceCallbacks callbacks;
    public final int pid;
    public final String pkg;
    public MediaBrowserServiceCompat.BrowserRoot root;
    public final Bundle rootHints;
    public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap();
    public final int uid;
    
    ConnectionRecord(String paramString, int paramInt1, int paramInt2, Bundle paramBundle, MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      this.pkg = paramString;
      this.pid = paramInt1;
      this.uid = paramInt2;
      this.browserInfo = new MediaSessionManager.RemoteUserInfo(paramString, paramInt1, paramInt2);
      this.rootHints = paramBundle;
      this.callbacks = paramServiceCallbacks;
    }
    
    public void binderDied()
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          MediaBrowserServiceCompat.this.mConnections.remove(MediaBrowserServiceCompat.ConnectionRecord.this.callbacks.asBinder());
        }
      });
    }
  }
  
  static abstract interface MediaBrowserServiceImpl
  {
    public abstract Bundle getBrowserRootHints();
    
    public abstract MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();
    
    public abstract void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, String paramString, Bundle paramBundle);
    
    public abstract void notifyChildrenChanged(String paramString, Bundle paramBundle);
    
    public abstract IBinder onBind(Intent paramIntent);
    
    public abstract void onCreate();
    
    public abstract void setSessionToken(MediaSessionCompat.Token paramToken);
  }
  
  @RequiresApi(21)
  class MediaBrowserServiceImplApi21
    implements MediaBrowserServiceCompat.MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy
  {
    Messenger mMessenger;
    final List<Bundle> mRootExtrasList = new ArrayList();
    Object mServiceObj;
    
    MediaBrowserServiceImplApi21() {}
    
    public Bundle getBrowserRootHints()
    {
      if (this.mMessenger == null) {
        return null;
      }
      if (MediaBrowserServiceCompat.this.mCurConnection != null)
      {
        if (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
          return null;
        }
        return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
      }
      throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo()
    {
      if (MediaBrowserServiceCompat.this.mCurConnection != null) {
        return MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
      }
      throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, String paramString, Bundle paramBundle)
    {
      notifyChildrenChangedForCompat(paramRemoteUserInfo, paramString, paramBundle);
    }
    
    public void notifyChildrenChanged(String paramString, Bundle paramBundle)
    {
      notifyChildrenChangedForFramework(paramString, paramBundle);
      notifyChildrenChangedForCompat(paramString, paramBundle);
    }
    
    void notifyChildrenChangedForCompat(final MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, final String paramString, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          int i = 0;
          while (i < MediaBrowserServiceCompat.this.mConnections.size())
          {
            MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.valueAt(i);
            if (localConnectionRecord.browserInfo.equals(paramRemoteUserInfo)) {
              MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler(localConnectionRecord, paramString, paramBundle);
            }
            i += 1;
          }
        }
      });
    }
    
    void notifyChildrenChangedForCompat(final String paramString, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (IBinder)localIterator.next();
            localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
            MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler((MediaBrowserServiceCompat.ConnectionRecord)localObject, paramString, paramBundle);
          }
        }
      });
    }
    
    void notifyChildrenChangedForCompatOnHandler(MediaBrowserServiceCompat.ConnectionRecord paramConnectionRecord, String paramString, Bundle paramBundle)
    {
      Object localObject = (List)paramConnectionRecord.subscriptions.get(paramString);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Pair localPair = (Pair)((Iterator)localObject).next();
          if (MediaBrowserCompatUtils.hasDuplicatedItems(paramBundle, (Bundle)localPair.second)) {
            MediaBrowserServiceCompat.this.performLoadChildren(paramString, paramConnectionRecord, (Bundle)localPair.second, paramBundle);
          }
        }
      }
    }
    
    void notifyChildrenChangedForFramework(String paramString, Bundle paramBundle)
    {
      MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, paramString);
    }
    
    public IBinder onBind(Intent paramIntent)
    {
      return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, paramIntent);
    }
    
    public void onCreate()
    {
      this.mServiceObj = MediaBrowserServiceCompatApi21.createService(MediaBrowserServiceCompat.this, this);
      MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
    }
    
    public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String paramString, int paramInt, Bundle paramBundle)
    {
      Object localObject;
      if ((paramBundle != null) && (paramBundle.getInt("extra_client_version", 0) != 0))
      {
        paramBundle.remove("extra_client_version");
        this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
        Bundle localBundle = new Bundle();
        localBundle.putInt("extra_service_version", 2);
        BundleCompat.putBinder(localBundle, "extra_messenger", this.mMessenger.getBinder());
        if (MediaBrowserServiceCompat.this.mSession != null)
        {
          localObject = MediaBrowserServiceCompat.this.mSession.getExtraBinder();
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = ((IMediaSession)localObject).asBinder();
          }
          BundleCompat.putBinder(localBundle, "extra_session_binder", (IBinder)localObject);
          localObject = localBundle;
        }
        else
        {
          this.mRootExtrasList.add(localBundle);
          localObject = localBundle;
        }
      }
      else
      {
        localObject = null;
      }
      MediaBrowserServiceCompat.this.mCurConnection = new MediaBrowserServiceCompat.ConnectionRecord(MediaBrowserServiceCompat.this, paramString, -1, paramInt, paramBundle, null);
      paramBundle = MediaBrowserServiceCompat.this.onGetRoot(paramString, paramInt, paramBundle);
      MediaBrowserServiceCompat.this.mCurConnection = null;
      if (paramBundle == null) {
        return null;
      }
      if (localObject == null)
      {
        paramString = paramBundle.getExtras();
      }
      else
      {
        paramString = (String)localObject;
        if (paramBundle.getExtras() != null)
        {
          ((Bundle)localObject).putAll(paramBundle.getExtras());
          paramString = (String)localObject;
        }
      }
      return new MediaBrowserServiceCompatApi21.BrowserRoot(paramBundle.getRootId(), paramString);
    }
    
    public void onLoadChildren(String paramString, final MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> paramResultWrapper)
    {
      paramResultWrapper = new MediaBrowserServiceCompat.Result(paramString)
      {
        public void detach()
        {
          paramResultWrapper.detach();
        }
        
        void onResultSent(List<MediaBrowserCompat.MediaItem> paramAnonymousList)
        {
          if (paramAnonymousList != null)
          {
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = paramAnonymousList.iterator();
            for (;;)
            {
              paramAnonymousList = localArrayList;
              if (!localIterator.hasNext()) {
                break;
              }
              paramAnonymousList = (MediaBrowserCompat.MediaItem)localIterator.next();
              Parcel localParcel = Parcel.obtain();
              paramAnonymousList.writeToParcel(localParcel, 0);
              localArrayList.add(localParcel);
            }
          }
          paramAnonymousList = null;
          paramResultWrapper.sendResult(paramAnonymousList);
        }
      };
      MediaBrowserServiceCompat.this.onLoadChildren(paramString, paramResultWrapper);
    }
    
    public void setSessionToken(final MediaSessionCompat.Token paramToken)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          if (!MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.isEmpty())
          {
            IMediaSession localIMediaSession = paramToken.getExtraBinder();
            if (localIMediaSession != null)
            {
              Iterator localIterator = MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.iterator();
              while (localIterator.hasNext()) {
                BundleCompat.putBinder((Bundle)localIterator.next(), "extra_session_binder", localIMediaSession.asBinder());
              }
            }
            MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.clear();
          }
          MediaBrowserServiceCompatApi21.setSessionToken(MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mServiceObj, paramToken.getToken());
        }
      });
    }
  }
  
  @RequiresApi(23)
  class MediaBrowserServiceImplApi23
    extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
    implements MediaBrowserServiceCompatApi23.ServiceCompatProxy
  {
    MediaBrowserServiceImplApi23()
    {
      super();
    }
    
    public void onCreate()
    {
      this.mServiceObj = MediaBrowserServiceCompatApi23.createService(MediaBrowserServiceCompat.this, this);
      MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
    }
    
    public void onLoadItem(String paramString, final MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> paramResultWrapper)
    {
      paramResultWrapper = new MediaBrowserServiceCompat.Result(paramString)
      {
        public void detach()
        {
          paramResultWrapper.detach();
        }
        
        void onResultSent(MediaBrowserCompat.MediaItem paramAnonymousMediaItem)
        {
          if (paramAnonymousMediaItem == null)
          {
            paramResultWrapper.sendResult(null);
            return;
          }
          Parcel localParcel = Parcel.obtain();
          paramAnonymousMediaItem.writeToParcel(localParcel, 0);
          paramResultWrapper.sendResult(localParcel);
        }
      };
      MediaBrowserServiceCompat.this.onLoadItem(paramString, paramResultWrapper);
    }
  }
  
  @RequiresApi(26)
  class MediaBrowserServiceImplApi26
    extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi23
    implements MediaBrowserServiceCompatApi26.ServiceCompatProxy
  {
    MediaBrowserServiceImplApi26()
    {
      super();
    }
    
    public Bundle getBrowserRootHints()
    {
      if (MediaBrowserServiceCompat.this.mCurConnection != null)
      {
        if (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
          return null;
        }
        return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
      }
      return MediaBrowserServiceCompatApi26.getBrowserRootHints(this.mServiceObj);
    }
    
    void notifyChildrenChangedForFramework(String paramString, Bundle paramBundle)
    {
      if (paramBundle != null)
      {
        MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.mServiceObj, paramString, paramBundle);
        return;
      }
      super.notifyChildrenChangedForFramework(paramString, paramBundle);
    }
    
    public void onCreate()
    {
      this.mServiceObj = MediaBrowserServiceCompatApi26.createService(MediaBrowserServiceCompat.this, this);
      MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
    }
    
    public void onLoadChildren(String paramString, final MediaBrowserServiceCompatApi26.ResultWrapper paramResultWrapper, Bundle paramBundle)
    {
      paramResultWrapper = new MediaBrowserServiceCompat.Result(paramString)
      {
        public void detach()
        {
          paramResultWrapper.detach();
        }
        
        void onResultSent(List<MediaBrowserCompat.MediaItem> paramAnonymousList)
        {
          if (paramAnonymousList != null)
          {
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = paramAnonymousList.iterator();
            for (;;)
            {
              paramAnonymousList = localArrayList;
              if (!localIterator.hasNext()) {
                break;
              }
              paramAnonymousList = (MediaBrowserCompat.MediaItem)localIterator.next();
              Parcel localParcel = Parcel.obtain();
              paramAnonymousList.writeToParcel(localParcel, 0);
              localArrayList.add(localParcel);
            }
          }
          paramAnonymousList = null;
          paramResultWrapper.sendResult(paramAnonymousList, getFlags());
        }
      };
      MediaBrowserServiceCompat.this.onLoadChildren(paramString, paramResultWrapper, paramBundle);
    }
  }
  
  @RequiresApi(28)
  class MediaBrowserServiceImplApi28
    extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi26
  {
    MediaBrowserServiceImplApi28()
    {
      super();
    }
    
    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo()
    {
      if (MediaBrowserServiceCompat.this.mCurConnection != null) {
        return MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
      }
      return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService)this.mServiceObj).getCurrentBrowserInfo());
    }
  }
  
  class MediaBrowserServiceImplBase
    implements MediaBrowserServiceCompat.MediaBrowserServiceImpl
  {
    private Messenger mMessenger;
    
    MediaBrowserServiceImplBase() {}
    
    public Bundle getBrowserRootHints()
    {
      if (MediaBrowserServiceCompat.this.mCurConnection != null)
      {
        if (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
          return null;
        }
        return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
      }
      throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo()
    {
      if (MediaBrowserServiceCompat.this.mCurConnection != null) {
        return MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
      }
      throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
    
    public void notifyChildrenChanged(@NonNull final MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, @NonNull final String paramString, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          int i = 0;
          while (i < MediaBrowserServiceCompat.this.mConnections.size())
          {
            MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.valueAt(i);
            if (localConnectionRecord.browserInfo.equals(paramRemoteUserInfo))
            {
              MediaBrowserServiceCompat.MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler(localConnectionRecord, paramString, paramBundle);
              return;
            }
            i += 1;
          }
        }
      });
    }
    
    public void notifyChildrenChanged(@NonNull final String paramString, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (IBinder)localIterator.next();
            localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
            MediaBrowserServiceCompat.MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler((MediaBrowserServiceCompat.ConnectionRecord)localObject, paramString, paramBundle);
          }
        }
      });
    }
    
    void notifyChildrenChangedOnHandler(MediaBrowserServiceCompat.ConnectionRecord paramConnectionRecord, String paramString, Bundle paramBundle)
    {
      Object localObject = (List)paramConnectionRecord.subscriptions.get(paramString);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Pair localPair = (Pair)((Iterator)localObject).next();
          if (MediaBrowserCompatUtils.hasDuplicatedItems(paramBundle, (Bundle)localPair.second)) {
            MediaBrowserServiceCompat.this.performLoadChildren(paramString, paramConnectionRecord, (Bundle)localPair.second, paramBundle);
          }
        }
      }
    }
    
    public IBinder onBind(Intent paramIntent)
    {
      if ("android.media.browse.MediaBrowserService".equals(paramIntent.getAction())) {
        return this.mMessenger.getBinder();
      }
      return null;
    }
    
    public void onCreate()
    {
      this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
    }
    
    public void setSessionToken(final MediaSessionCompat.Token paramToken)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = MediaBrowserServiceCompat.this.mConnections.values().iterator();
          while (localIterator.hasNext())
          {
            MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)localIterator.next();
            try
            {
              localConnectionRecord.callbacks.onConnect(localConnectionRecord.root.getRootId(), paramToken, localConnectionRecord.root.getExtras());
            }
            catch (RemoteException localRemoteException)
            {
              StringBuilder localStringBuilder;
              for (;;) {}
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Connection for ");
            localStringBuilder.append(localConnectionRecord.pkg);
            localStringBuilder.append(" is no longer valid.");
            Log.w("MBServiceCompat", localStringBuilder.toString());
            localIterator.remove();
          }
        }
      });
    }
  }
  
  public static class Result<T>
  {
    private final Object mDebug;
    private boolean mDetachCalled;
    private int mFlags;
    private boolean mSendErrorCalled;
    private boolean mSendProgressUpdateCalled;
    private boolean mSendResultCalled;
    
    Result(Object paramObject)
    {
      this.mDebug = paramObject;
    }
    
    private void checkExtraFields(Bundle paramBundle)
    {
      if (paramBundle == null) {
        return;
      }
      if (paramBundle.containsKey("android.media.browse.extra.DOWNLOAD_PROGRESS"))
      {
        float f = paramBundle.getFloat("android.media.browse.extra.DOWNLOAD_PROGRESS");
        if ((f >= -1.0E-5F) && (f <= 1.00001F)) {
          return;
        }
        throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
      }
    }
    
    public void detach()
    {
      if (!this.mDetachCalled)
      {
        if (!this.mSendResultCalled)
        {
          if (!this.mSendErrorCalled)
          {
            this.mDetachCalled = true;
            return;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("detach() called when sendError() had already been called for: ");
          localStringBuilder.append(this.mDebug);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("detach() called when sendResult() had already been called for: ");
        localStringBuilder.append(this.mDebug);
        throw new IllegalStateException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detach() called when detach() had already been called for: ");
      localStringBuilder.append(this.mDebug);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    int getFlags()
    {
      return this.mFlags;
    }
    
    boolean isDone()
    {
      return (this.mDetachCalled) || (this.mSendResultCalled) || (this.mSendErrorCalled);
    }
    
    void onErrorSent(Bundle paramBundle)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("It is not supported to send an error for ");
      paramBundle.append(this.mDebug);
      throw new UnsupportedOperationException(paramBundle.toString());
    }
    
    void onProgressUpdateSent(Bundle paramBundle)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("It is not supported to send an interim update for ");
      paramBundle.append(this.mDebug);
      throw new UnsupportedOperationException(paramBundle.toString());
    }
    
    void onResultSent(T paramT) {}
    
    public void sendError(Bundle paramBundle)
    {
      if ((!this.mSendResultCalled) && (!this.mSendErrorCalled))
      {
        this.mSendErrorCalled = true;
        onErrorSent(paramBundle);
        return;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("sendError() called when either sendResult() or sendError() had already been called for: ");
      paramBundle.append(this.mDebug);
      throw new IllegalStateException(paramBundle.toString());
    }
    
    public void sendProgressUpdate(Bundle paramBundle)
    {
      if ((!this.mSendResultCalled) && (!this.mSendErrorCalled))
      {
        checkExtraFields(paramBundle);
        this.mSendProgressUpdateCalled = true;
        onProgressUpdateSent(paramBundle);
        return;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: ");
      paramBundle.append(this.mDebug);
      throw new IllegalStateException(paramBundle.toString());
    }
    
    public void sendResult(T paramT)
    {
      if ((!this.mSendResultCalled) && (!this.mSendErrorCalled))
      {
        this.mSendResultCalled = true;
        onResultSent(paramT);
        return;
      }
      paramT = new StringBuilder();
      paramT.append("sendResult() called when either sendResult() or sendError() had already been called for: ");
      paramT.append(this.mDebug);
      throw new IllegalStateException(paramT.toString());
    }
    
    void setFlags(int paramInt)
    {
      this.mFlags = paramInt;
    }
  }
  
  private class ServiceBinderImpl
  {
    ServiceBinderImpl() {}
    
    public void addSubscription(final String paramString, final IBinder paramIBinder, final Bundle paramBundle, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          Object localObject = paramServiceCallbacks.asBinder();
          localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
          if (localObject == null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("addSubscription for callback that isn't registered id=");
            ((StringBuilder)localObject).append(paramString);
            Log.w("MBServiceCompat", ((StringBuilder)localObject).toString());
            return;
          }
          MediaBrowserServiceCompat.this.addSubscription(paramString, (MediaBrowserServiceCompat.ConnectionRecord)localObject, paramIBinder, paramBundle);
        }
      });
    }
    
    public void connect(final String paramString, final int paramInt1, final int paramInt2, final Bundle paramBundle, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if (MediaBrowserServiceCompat.this.isValidPackage(paramString, paramInt2))
      {
        MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
        {
          public void run()
          {
            Object localObject1 = paramServiceCallbacks.asBinder();
            MediaBrowserServiceCompat.this.mConnections.remove(localObject1);
            Object localObject2 = new MediaBrowserServiceCompat.ConnectionRecord(MediaBrowserServiceCompat.this, paramString, paramInt1, paramInt2, paramBundle, paramServiceCallbacks);
            MediaBrowserServiceCompat.this.mCurConnection = ((MediaBrowserServiceCompat.ConnectionRecord)localObject2);
            ((MediaBrowserServiceCompat.ConnectionRecord)localObject2).root = MediaBrowserServiceCompat.this.onGetRoot(paramString, paramInt2, paramBundle);
            MediaBrowserServiceCompat.this.mCurConnection = null;
            if (((MediaBrowserServiceCompat.ConnectionRecord)localObject2).root == null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("No root for client ");
              ((StringBuilder)localObject1).append(paramString);
              ((StringBuilder)localObject1).append(" from service ");
              ((StringBuilder)localObject1).append(getClass().getName());
              Log.i("MBServiceCompat", ((StringBuilder)localObject1).toString());
            }
            try
            {
              paramServiceCallbacks.onConnectFailed();
              return;
            }
            catch (RemoteException localRemoteException1)
            {
              for (;;) {}
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Calling onConnectFailed() failed. Ignoring. pkg=");
            ((StringBuilder)localObject1).append(paramString);
            Log.w("MBServiceCompat", ((StringBuilder)localObject1).toString());
            return;
            try
            {
              MediaBrowserServiceCompat.this.mConnections.put(localObject1, localObject2);
              ((IBinder)localObject1).linkToDeath((IBinder.DeathRecipient)localObject2, 0);
              if (MediaBrowserServiceCompat.this.mSession == null) {
                break label333;
              }
              paramServiceCallbacks.onConnect(((MediaBrowserServiceCompat.ConnectionRecord)localObject2).root.getRootId(), MediaBrowserServiceCompat.this.mSession, ((MediaBrowserServiceCompat.ConnectionRecord)localObject2).root.getExtras());
              return;
            }
            catch (RemoteException localRemoteException2)
            {
              for (;;) {}
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Calling onConnect() failed. Dropping client. pkg=");
            ((StringBuilder)localObject2).append(paramString);
            Log.w("MBServiceCompat", ((StringBuilder)localObject2).toString());
            MediaBrowserServiceCompat.this.mConnections.remove(localObject1);
            label333:
          }
        });
        return;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("Package/uid mismatch: uid=");
      paramBundle.append(paramInt2);
      paramBundle.append(" package=");
      paramBundle.append(paramString);
      throw new IllegalArgumentException(paramBundle.toString());
    }
    
    public void disconnect(final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          Object localObject = paramServiceCallbacks.asBinder();
          localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.remove(localObject);
          if (localObject != null) {
            ((MediaBrowserServiceCompat.ConnectionRecord)localObject).callbacks.asBinder().unlinkToDeath((IBinder.DeathRecipient)localObject, 0);
          }
        }
      });
    }
    
    public void getMediaItem(final String paramString, final ResultReceiver paramResultReceiver, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramResultReceiver == null) {
          return;
        }
        MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
        {
          public void run()
          {
            Object localObject = paramServiceCallbacks.asBinder();
            localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
            if (localObject == null)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("getMediaItem for callback that isn't registered id=");
              ((StringBuilder)localObject).append(paramString);
              Log.w("MBServiceCompat", ((StringBuilder)localObject).toString());
              return;
            }
            MediaBrowserServiceCompat.this.performLoadItem(paramString, (MediaBrowserServiceCompat.ConnectionRecord)localObject, paramResultReceiver);
          }
        });
        return;
      }
    }
    
    public void registerCallbacks(final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks, final String paramString, final int paramInt1, final int paramInt2, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          IBinder localIBinder = paramServiceCallbacks.asBinder();
          MediaBrowserServiceCompat.this.mConnections.remove(localIBinder);
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = new MediaBrowserServiceCompat.ConnectionRecord(MediaBrowserServiceCompat.this, paramString, paramInt1, paramInt2, paramBundle, paramServiceCallbacks);
          MediaBrowserServiceCompat.this.mConnections.put(localIBinder, localConnectionRecord);
          try
          {
            localIBinder.linkToDeath(localConnectionRecord, 0);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            for (;;) {}
          }
          Log.w("MBServiceCompat", "IBinder is already dead.");
        }
      });
    }
    
    public void removeSubscription(final String paramString, final IBinder paramIBinder, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          Object localObject = paramServiceCallbacks.asBinder();
          localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
          if (localObject == null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("removeSubscription for callback that isn't registered id=");
            ((StringBuilder)localObject).append(paramString);
            Log.w("MBServiceCompat", ((StringBuilder)localObject).toString());
            return;
          }
          if (!MediaBrowserServiceCompat.this.removeSubscription(paramString, (MediaBrowserServiceCompat.ConnectionRecord)localObject, paramIBinder))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("removeSubscription called for ");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(" which is not subscribed");
            Log.w("MBServiceCompat", ((StringBuilder)localObject).toString());
          }
        }
      });
    }
    
    public void search(final String paramString, final Bundle paramBundle, final ResultReceiver paramResultReceiver, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramResultReceiver == null) {
          return;
        }
        MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
        {
          public void run()
          {
            Object localObject = paramServiceCallbacks.asBinder();
            localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
            if (localObject == null)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("search for callback that isn't registered query=");
              ((StringBuilder)localObject).append(paramString);
              Log.w("MBServiceCompat", ((StringBuilder)localObject).toString());
              return;
            }
            MediaBrowserServiceCompat.this.performSearch(paramString, paramBundle, (MediaBrowserServiceCompat.ConnectionRecord)localObject, paramResultReceiver);
          }
        });
        return;
      }
    }
    
    public void sendCustomAction(final String paramString, final Bundle paramBundle, final ResultReceiver paramResultReceiver, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramResultReceiver == null) {
          return;
        }
        MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
        {
          public void run()
          {
            Object localObject = paramServiceCallbacks.asBinder();
            localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localObject);
            if (localObject == null)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("sendCustomAction for callback that isn't registered action=");
              ((StringBuilder)localObject).append(paramString);
              ((StringBuilder)localObject).append(", extras=");
              ((StringBuilder)localObject).append(paramBundle);
              Log.w("MBServiceCompat", ((StringBuilder)localObject).toString());
              return;
            }
            MediaBrowserServiceCompat.this.performCustomAction(paramString, paramBundle, (MediaBrowserServiceCompat.ConnectionRecord)localObject, paramResultReceiver);
          }
        });
        return;
      }
    }
    
    public void unregisterCallbacks(final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          IBinder localIBinder = paramServiceCallbacks.asBinder();
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.remove(localIBinder);
          if (localConnectionRecord != null) {
            localIBinder.unlinkToDeath(localConnectionRecord, 0);
          }
        }
      });
    }
  }
  
  private static abstract interface ServiceCallbacks
  {
    public abstract IBinder asBinder();
    
    public abstract void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
      throws RemoteException;
    
    public abstract void onConnectFailed()
      throws RemoteException;
    
    public abstract void onLoadChildren(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2)
      throws RemoteException;
  }
  
  private static class ServiceCallbacksCompat
    implements MediaBrowserServiceCompat.ServiceCallbacks
  {
    final Messenger mCallbacks;
    
    ServiceCallbacksCompat(Messenger paramMessenger)
    {
      this.mCallbacks = paramMessenger;
    }
    
    private void sendRequest(int paramInt, Bundle paramBundle)
      throws RemoteException
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 2;
      localMessage.setData(paramBundle);
      this.mCallbacks.send(localMessage);
    }
    
    public IBinder asBinder()
    {
      return this.mCallbacks.getBinder();
    }
    
    public void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
      throws RemoteException
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putInt("extra_service_version", 2);
      paramBundle = new Bundle();
      paramBundle.putString("data_media_item_id", paramString);
      paramBundle.putParcelable("data_media_session_token", paramToken);
      paramBundle.putBundle("data_root_hints", localBundle);
      sendRequest(1, paramBundle);
    }
    
    public void onConnectFailed()
      throws RemoteException
    {
      sendRequest(2, null);
    }
    
    public void onLoadChildren(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      localBundle.putBundle("data_options", paramBundle1);
      localBundle.putBundle("data_notify_children_changed_options", paramBundle2);
      if (paramList != null)
      {
        if ((paramList instanceof ArrayList)) {
          paramString = (ArrayList)paramList;
        } else {
          paramString = new ArrayList(paramList);
        }
        localBundle.putParcelableArrayList("data_media_item_list", paramString);
      }
      sendRequest(3, localBundle);
    }
  }
  
  private final class ServiceHandler
    extends Handler
  {
    private final MediaBrowserServiceCompat.ServiceBinderImpl mServiceBinderImpl = new MediaBrowserServiceCompat.ServiceBinderImpl(MediaBrowserServiceCompat.this);
    
    ServiceHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      Object localObject = paramMessage.getData();
      switch (paramMessage.what)
      {
      default: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unhandled message: ");
        ((StringBuilder)localObject).append(paramMessage);
        ((StringBuilder)localObject).append("\n  Service version: ");
        ((StringBuilder)localObject).append(2);
        ((StringBuilder)localObject).append("\n  Client version: ");
        ((StringBuilder)localObject).append(paramMessage.arg1);
        Log.w("MBServiceCompat", ((StringBuilder)localObject).toString());
        return;
      case 9: 
        localBundle = ((Bundle)localObject).getBundle("data_custom_action_extras");
        MediaSessionCompat.ensureClassLoader(localBundle);
        this.mServiceBinderImpl.sendCustomAction(((Bundle)localObject).getString("data_custom_action"), localBundle, (ResultReceiver)((Bundle)localObject).getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        return;
      case 8: 
        localBundle = ((Bundle)localObject).getBundle("data_search_extras");
        MediaSessionCompat.ensureClassLoader(localBundle);
        this.mServiceBinderImpl.search(((Bundle)localObject).getString("data_search_query"), localBundle, (ResultReceiver)((Bundle)localObject).getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        return;
      case 7: 
        this.mServiceBinderImpl.unregisterCallbacks(new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        return;
      case 6: 
        localBundle = ((Bundle)localObject).getBundle("data_root_hints");
        MediaSessionCompat.ensureClassLoader(localBundle);
        this.mServiceBinderImpl.registerCallbacks(new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo), ((Bundle)localObject).getString("data_package_name"), ((Bundle)localObject).getInt("data_calling_pid"), ((Bundle)localObject).getInt("data_calling_uid"), localBundle);
        return;
      case 5: 
        this.mServiceBinderImpl.getMediaItem(((Bundle)localObject).getString("data_media_item_id"), (ResultReceiver)((Bundle)localObject).getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        return;
      case 4: 
        this.mServiceBinderImpl.removeSubscription(((Bundle)localObject).getString("data_media_item_id"), BundleCompat.getBinder((Bundle)localObject, "data_callback_token"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        return;
      case 3: 
        localBundle = ((Bundle)localObject).getBundle("data_options");
        MediaSessionCompat.ensureClassLoader(localBundle);
        this.mServiceBinderImpl.addSubscription(((Bundle)localObject).getString("data_media_item_id"), BundleCompat.getBinder((Bundle)localObject, "data_callback_token"), localBundle, new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        return;
      case 2: 
        this.mServiceBinderImpl.disconnect(new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        return;
      }
      Bundle localBundle = ((Bundle)localObject).getBundle("data_root_hints");
      MediaSessionCompat.ensureClassLoader(localBundle);
      this.mServiceBinderImpl.connect(((Bundle)localObject).getString("data_package_name"), ((Bundle)localObject).getInt("data_calling_pid"), ((Bundle)localObject).getInt("data_calling_uid"), localBundle, new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
    }
    
    public void postOrRun(Runnable paramRunnable)
    {
      if (Thread.currentThread() == getLooper().getThread())
      {
        paramRunnable.run();
        return;
      }
      post(paramRunnable);
    }
    
    public boolean sendMessageAtTime(Message paramMessage, long paramLong)
    {
      Bundle localBundle = paramMessage.getData();
      localBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      localBundle.putInt("data_calling_uid", Binder.getCallingUid());
      localBundle.putInt("data_calling_pid", Binder.getCallingPid());
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserServiceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */