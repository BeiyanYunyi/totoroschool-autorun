package android.support.v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.c;
import android.arch.lifecycle.c.a;
import android.arch.lifecycle.e;
import android.arch.lifecycle.f;
import android.arch.lifecycle.j;
import android.arch.lifecycle.p;
import android.arch.lifecycle.q;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.CallSuper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StringRes;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Fragment
  implements e, q, ComponentCallbacks, View.OnCreateContextMenuListener
{
  static final int ACTIVITY_CREATED = 2;
  static final int CREATED = 1;
  static final int INITIALIZING = 0;
  static final int RESUMED = 4;
  static final int STARTED = 3;
  static final Object USE_DEFAULT_TRANSITION = new Object();
  private static final SimpleArrayMap<String, Class<?>> sClassMap = new SimpleArrayMap();
  boolean mAdded;
  AnimationInfo mAnimationInfo;
  Bundle mArguments;
  int mBackStackNesting;
  boolean mCalled;
  FragmentManagerImpl mChildFragmentManager;
  FragmentManagerNonConfig mChildNonConfig;
  ViewGroup mContainer;
  int mContainerId;
  boolean mDeferStart;
  boolean mDetached;
  int mFragmentId;
  FragmentManagerImpl mFragmentManager;
  boolean mFromLayout;
  boolean mHasMenu;
  boolean mHidden;
  boolean mHiddenChanged;
  FragmentHostCallback mHost;
  boolean mInLayout;
  int mIndex = -1;
  View mInnerView;
  boolean mIsCreated;
  boolean mIsNewlyAdded;
  LayoutInflater mLayoutInflater;
  f mLifecycleRegistry = new f(this);
  boolean mMenuVisible = true;
  Fragment mParentFragment;
  boolean mPerformedCreateView;
  float mPostponedAlpha;
  boolean mRemoving;
  boolean mRestored;
  boolean mRetainInstance;
  boolean mRetaining;
  Bundle mSavedFragmentState;
  @Nullable
  Boolean mSavedUserVisibleHint;
  SparseArray<Parcelable> mSavedViewState;
  int mState = 0;
  String mTag;
  Fragment mTarget;
  int mTargetIndex = -1;
  int mTargetRequestCode;
  boolean mUserVisibleHint = true;
  View mView;
  e mViewLifecycleOwner;
  j<e> mViewLifecycleOwnerLiveData = new j();
  f mViewLifecycleRegistry;
  p mViewModelStore;
  String mWho;
  
  private AnimationInfo ensureAnimationInfo()
  {
    if (this.mAnimationInfo == null) {
      this.mAnimationInfo = new AnimationInfo();
    }
    return this.mAnimationInfo;
  }
  
  public static Fragment instantiate(Context paramContext, String paramString)
  {
    return instantiate(paramContext, paramString, null);
  }
  
  public static Fragment instantiate(Context paramContext, String paramString, @Nullable Bundle paramBundle)
  {
    try
    {
      Class localClass2 = (Class)sClassMap.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        sClassMap.put(paramString, localClass1);
      }
      paramContext = (Fragment)localClass1.getConstructor(new Class[0]).newInstance(new Object[0]);
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
        paramContext.setArguments(paramBundle);
      }
      return paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": calling Fragment constructor caused an exception");
      throw new InstantiationException(paramBundle.toString(), paramContext);
    }
    catch (NoSuchMethodException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": could not find Fragment constructor");
      throw new InstantiationException(paramBundle.toString(), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": make sure class name exists, is public, and has an");
      paramBundle.append(" empty constructor that is public");
      throw new InstantiationException(paramBundle.toString(), paramContext);
    }
    catch (InstantiationException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": make sure class name exists, is public, and has an");
      paramBundle.append(" empty constructor that is public");
      throw new InstantiationException(paramBundle.toString(), paramContext);
    }
    catch (ClassNotFoundException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": make sure class name exists, is public, and has an");
      paramBundle.append(" empty constructor that is public");
      throw new InstantiationException(paramBundle.toString(), paramContext);
    }
  }
  
  static boolean isSupportFragmentClass(Context paramContext, String paramString)
  {
    try
    {
      Class localClass2 = (Class)sClassMap.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        sClassMap.put(paramString, localClass1);
      }
      boolean bool = Fragment.class.isAssignableFrom(localClass1);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;) {}
    }
    return false;
  }
  
  void callStartTransitionListener()
  {
    OnStartEnterTransitionListener localOnStartEnterTransitionListener;
    if (this.mAnimationInfo == null)
    {
      localOnStartEnterTransitionListener = null;
    }
    else
    {
      this.mAnimationInfo.mEnterTransitionPostponed = false;
      localOnStartEnterTransitionListener = this.mAnimationInfo.mStartEnterTransitionListener;
      this.mAnimationInfo.mStartEnterTransitionListener = null;
    }
    if (localOnStartEnterTransitionListener != null) {
      localOnStartEnterTransitionListener.onStartEnterTransition();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.mFragmentId));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.mContainerId));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.mTag);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.mState);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.mIndex);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.mWho);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.mBackStackNesting);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.mAdded);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.mRemoving);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.mFromLayout);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.mInLayout);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.mHidden);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.mDetached);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.mMenuVisible);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.mHasMenu);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.mRetainInstance);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.mRetaining);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.mUserVisibleHint);
    if (this.mFragmentManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.mFragmentManager);
    }
    if (this.mHost != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(this.mHost);
    }
    if (this.mParentFragment != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.mParentFragment);
    }
    if (this.mArguments != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.mArguments);
    }
    if (this.mSavedFragmentState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.mSavedFragmentState);
    }
    if (this.mSavedViewState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.mSavedViewState);
    }
    if (this.mTarget != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.mTarget);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.mTargetRequestCode);
    }
    if (getNextAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(getNextAnim());
    }
    if (this.mContainer != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.mContainer);
    }
    if (this.mView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.mView);
    }
    if (this.mInnerView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.mView);
    }
    if (getAnimatingAway() != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(getAnimatingAway());
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(getStateAfterAnimating());
    }
    if (getContext() != null) {
      LoaderManager.getInstance(this).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if (this.mChildFragmentManager != null)
    {
      paramPrintWriter.print(paramString);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Child ");
      ((StringBuilder)localObject).append(this.mChildFragmentManager);
      ((StringBuilder)localObject).append(":");
      paramPrintWriter.println(((StringBuilder)localObject).toString());
      localObject = this.mChildFragmentManager;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("  ");
      ((FragmentManagerImpl)localObject).dump(localStringBuilder.toString(), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  Fragment findFragmentByWho(String paramString)
  {
    if (paramString.equals(this.mWho)) {
      return this;
    }
    if (this.mChildFragmentManager != null) {
      return this.mChildFragmentManager.findFragmentByWho(paramString);
    }
    return null;
  }
  
  @Nullable
  public final FragmentActivity getActivity()
  {
    if (this.mHost == null) {
      return null;
    }
    return (FragmentActivity)this.mHost.getActivity();
  }
  
  public boolean getAllowEnterTransitionOverlap()
  {
    if ((this.mAnimationInfo != null) && (this.mAnimationInfo.mAllowEnterTransitionOverlap != null)) {
      return this.mAnimationInfo.mAllowEnterTransitionOverlap.booleanValue();
    }
    return true;
  }
  
  public boolean getAllowReturnTransitionOverlap()
  {
    if ((this.mAnimationInfo != null) && (this.mAnimationInfo.mAllowReturnTransitionOverlap != null)) {
      return this.mAnimationInfo.mAllowReturnTransitionOverlap.booleanValue();
    }
    return true;
  }
  
  View getAnimatingAway()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.mAnimatingAway;
  }
  
  Animator getAnimator()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.mAnimator;
  }
  
  @Nullable
  public final Bundle getArguments()
  {
    return this.mArguments;
  }
  
  @NonNull
  public final FragmentManager getChildFragmentManager()
  {
    if (this.mChildFragmentManager == null)
    {
      instantiateChildFragmentManager();
      if (this.mState >= 4) {
        this.mChildFragmentManager.dispatchResume();
      } else if (this.mState >= 3) {
        this.mChildFragmentManager.dispatchStart();
      } else if (this.mState >= 2) {
        this.mChildFragmentManager.dispatchActivityCreated();
      } else if (this.mState >= 1) {
        this.mChildFragmentManager.dispatchCreate();
      }
    }
    return this.mChildFragmentManager;
  }
  
  @Nullable
  public Context getContext()
  {
    if (this.mHost == null) {
      return null;
    }
    return this.mHost.getContext();
  }
  
  @Nullable
  public Object getEnterTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.mEnterTransition;
  }
  
  SharedElementCallback getEnterTransitionCallback()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.mEnterTransitionCallback;
  }
  
  @Nullable
  public Object getExitTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.mExitTransition;
  }
  
  SharedElementCallback getExitTransitionCallback()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.mExitTransitionCallback;
  }
  
  @Nullable
  public final FragmentManager getFragmentManager()
  {
    return this.mFragmentManager;
  }
  
  @Nullable
  public final Object getHost()
  {
    if (this.mHost == null) {
      return null;
    }
    return this.mHost.onGetHost();
  }
  
  public final int getId()
  {
    return this.mFragmentId;
  }
  
  public final LayoutInflater getLayoutInflater()
  {
    if (this.mLayoutInflater == null) {
      return performGetLayoutInflater(null);
    }
    return this.mLayoutInflater;
  }
  
  @Deprecated
  @NonNull
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public LayoutInflater getLayoutInflater(@Nullable Bundle paramBundle)
  {
    if (this.mHost != null)
    {
      paramBundle = this.mHost.onGetLayoutInflater();
      getChildFragmentManager();
      LayoutInflaterCompat.setFactory2(paramBundle, this.mChildFragmentManager.getLayoutInflaterFactory());
      return paramBundle;
    }
    throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
  }
  
  public c getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  @Deprecated
  public LoaderManager getLoaderManager()
  {
    return LoaderManager.getInstance(this);
  }
  
  int getNextAnim()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.mNextAnim;
  }
  
  int getNextTransition()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.mNextTransition;
  }
  
  int getNextTransitionStyle()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.mNextTransitionStyle;
  }
  
  @Nullable
  public final Fragment getParentFragment()
  {
    return this.mParentFragment;
  }
  
  public Object getReenterTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    if (this.mAnimationInfo.mReenterTransition == USE_DEFAULT_TRANSITION) {
      return getExitTransition();
    }
    return this.mAnimationInfo.mReenterTransition;
  }
  
  @NonNull
  public final Resources getResources()
  {
    return requireContext().getResources();
  }
  
  public final boolean getRetainInstance()
  {
    return this.mRetainInstance;
  }
  
  @Nullable
  public Object getReturnTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    if (this.mAnimationInfo.mReturnTransition == USE_DEFAULT_TRANSITION) {
      return getEnterTransition();
    }
    return this.mAnimationInfo.mReturnTransition;
  }
  
  @Nullable
  public Object getSharedElementEnterTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.mSharedElementEnterTransition;
  }
  
  @Nullable
  public Object getSharedElementReturnTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    if (this.mAnimationInfo.mSharedElementReturnTransition == USE_DEFAULT_TRANSITION) {
      return getSharedElementEnterTransition();
    }
    return this.mAnimationInfo.mSharedElementReturnTransition;
  }
  
  int getStateAfterAnimating()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.mStateAfterAnimating;
  }
  
  @NonNull
  public final String getString(@StringRes int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  @NonNull
  public final String getString(@StringRes int paramInt, Object... paramVarArgs)
  {
    return getResources().getString(paramInt, paramVarArgs);
  }
  
  @Nullable
  public final String getTag()
  {
    return this.mTag;
  }
  
  @Nullable
  public final Fragment getTargetFragment()
  {
    return this.mTarget;
  }
  
  public final int getTargetRequestCode()
  {
    return this.mTargetRequestCode;
  }
  
  @NonNull
  public final CharSequence getText(@StringRes int paramInt)
  {
    return getResources().getText(paramInt);
  }
  
  public boolean getUserVisibleHint()
  {
    return this.mUserVisibleHint;
  }
  
  @Nullable
  public View getView()
  {
    return this.mView;
  }
  
  @MainThread
  @NonNull
  public e getViewLifecycleOwner()
  {
    if (this.mViewLifecycleOwner != null) {
      return this.mViewLifecycleOwner;
    }
    throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
  }
  
  @NonNull
  public LiveData<e> getViewLifecycleOwnerLiveData()
  {
    return this.mViewLifecycleOwnerLiveData;
  }
  
  @NonNull
  public p getViewModelStore()
  {
    if (getContext() != null)
    {
      if (this.mViewModelStore == null) {
        this.mViewModelStore = new p();
      }
      return this.mViewModelStore;
    }
    throw new IllegalStateException("Can't access ViewModels from detached fragment");
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public final boolean hasOptionsMenu()
  {
    return this.mHasMenu;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  void initState()
  {
    this.mIndex = -1;
    this.mWho = null;
    this.mAdded = false;
    this.mRemoving = false;
    this.mFromLayout = false;
    this.mInLayout = false;
    this.mRestored = false;
    this.mBackStackNesting = 0;
    this.mFragmentManager = null;
    this.mChildFragmentManager = null;
    this.mHost = null;
    this.mFragmentId = 0;
    this.mContainerId = 0;
    this.mTag = null;
    this.mHidden = false;
    this.mDetached = false;
    this.mRetaining = false;
  }
  
  void instantiateChildFragmentManager()
  {
    if (this.mHost != null)
    {
      this.mChildFragmentManager = new FragmentManagerImpl();
      this.mChildFragmentManager.attachController(this.mHost, new FragmentContainer()
      {
        public Fragment instantiate(Context paramAnonymousContext, String paramAnonymousString, Bundle paramAnonymousBundle)
        {
          return Fragment.this.mHost.instantiate(paramAnonymousContext, paramAnonymousString, paramAnonymousBundle);
        }
        
        @Nullable
        public View onFindViewById(int paramAnonymousInt)
        {
          if (Fragment.this.mView != null) {
            return Fragment.this.mView.findViewById(paramAnonymousInt);
          }
          throw new IllegalStateException("Fragment does not have a view");
        }
        
        public boolean onHasView()
        {
          return Fragment.this.mView != null;
        }
      }, this);
      return;
    }
    throw new IllegalStateException("Fragment has not been attached yet.");
  }
  
  public final boolean isAdded()
  {
    return (this.mHost != null) && (this.mAdded);
  }
  
  public final boolean isDetached()
  {
    return this.mDetached;
  }
  
  public final boolean isHidden()
  {
    return this.mHidden;
  }
  
  boolean isHideReplaced()
  {
    if (this.mAnimationInfo == null) {
      return false;
    }
    return this.mAnimationInfo.mIsHideReplaced;
  }
  
  final boolean isInBackStack()
  {
    return this.mBackStackNesting > 0;
  }
  
  public final boolean isInLayout()
  {
    return this.mInLayout;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public final boolean isMenuVisible()
  {
    return this.mMenuVisible;
  }
  
  boolean isPostponed()
  {
    if (this.mAnimationInfo == null) {
      return false;
    }
    return this.mAnimationInfo.mEnterTransitionPostponed;
  }
  
  public final boolean isRemoving()
  {
    return this.mRemoving;
  }
  
  public final boolean isResumed()
  {
    return this.mState >= 4;
  }
  
  public final boolean isStateSaved()
  {
    if (this.mFragmentManager == null) {
      return false;
    }
    return this.mFragmentManager.isStateSaved();
  }
  
  public final boolean isVisible()
  {
    return (isAdded()) && (!isHidden()) && (this.mView != null) && (this.mView.getWindowToken() != null) && (this.mView.getVisibility() == 0);
  }
  
  void noteStateNotSaved()
  {
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.noteStateNotSaved();
    }
  }
  
  @CallSuper
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  @Deprecated
  @CallSuper
  public void onAttach(Activity paramActivity)
  {
    this.mCalled = true;
  }
  
  @CallSuper
  public void onAttach(Context paramContext)
  {
    this.mCalled = true;
    if (this.mHost == null) {
      paramContext = null;
    } else {
      paramContext = this.mHost.getActivity();
    }
    if (paramContext != null)
    {
      this.mCalled = false;
      onAttach(paramContext);
    }
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  @CallSuper
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mCalled = true;
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  @CallSuper
  public void onCreate(@Nullable Bundle paramBundle)
  {
    this.mCalled = true;
    restoreChildFragmentState(paramBundle);
    if ((this.mChildFragmentManager != null) && (!this.mChildFragmentManager.isStateAtLeast(1))) {
      this.mChildFragmentManager.dispatchCreate();
    }
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    getActivity().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {}
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    return null;
  }
  
  @CallSuper
  public void onDestroy()
  {
    int i = 1;
    this.mCalled = true;
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (!localFragmentActivity.isChangingConfigurations())) {
      i = 0;
    }
    if ((this.mViewModelStore != null) && (i == 0)) {
      this.mViewModelStore.a();
    }
  }
  
  public void onDestroyOptionsMenu() {}
  
  @CallSuper
  public void onDestroyView()
  {
    this.mCalled = true;
  }
  
  @CallSuper
  public void onDetach()
  {
    this.mCalled = true;
  }
  
  @NonNull
  public LayoutInflater onGetLayoutInflater(@Nullable Bundle paramBundle)
  {
    return getLayoutInflater(paramBundle);
  }
  
  public void onHiddenChanged(boolean paramBoolean) {}
  
  @Deprecated
  @CallSuper
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  @CallSuper
  public void onInflate(Context paramContext, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.mCalled = true;
    if (this.mHost == null) {
      paramContext = null;
    } else {
      paramContext = this.mHost.getActivity();
    }
    if (paramContext != null)
    {
      this.mCalled = false;
      onInflate(paramContext, paramAttributeSet, paramBundle);
    }
  }
  
  @CallSuper
  public void onLowMemory()
  {
    this.mCalled = true;
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onOptionsMenuClosed(Menu paramMenu) {}
  
  @CallSuper
  public void onPause()
  {
    this.mCalled = true;
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean) {}
  
  public void onPrepareOptionsMenu(Menu paramMenu) {}
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt) {}
  
  @CallSuper
  public void onResume()
  {
    this.mCalled = true;
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle) {}
  
  @CallSuper
  public void onStart()
  {
    this.mCalled = true;
  }
  
  @CallSuper
  public void onStop()
  {
    this.mCalled = true;
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle) {}
  
  @CallSuper
  public void onViewStateRestored(@Nullable Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  @Nullable
  FragmentManager peekChildFragmentManager()
  {
    return this.mChildFragmentManager;
  }
  
  void performActivityCreated(Bundle paramBundle)
  {
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.noteStateNotSaved();
    }
    this.mState = 2;
    this.mCalled = false;
    onActivityCreated(paramBundle);
    if (this.mCalled)
    {
      if (this.mChildFragmentManager != null) {
        this.mChildFragmentManager.dispatchActivityCreated();
      }
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("Fragment ");
    paramBundle.append(this);
    paramBundle.append(" did not call through to super.onActivityCreated()");
    throw new SuperNotCalledException(paramBundle.toString());
  }
  
  void performConfigurationChanged(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchConfigurationChanged(paramConfiguration);
    }
  }
  
  boolean performContextItemSelected(MenuItem paramMenuItem)
  {
    if (!this.mHidden)
    {
      if (onContextItemSelected(paramMenuItem)) {
        return true;
      }
      if ((this.mChildFragmentManager != null) && (this.mChildFragmentManager.dispatchContextItemSelected(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  void performCreate(Bundle paramBundle)
  {
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.noteStateNotSaved();
    }
    this.mState = 1;
    this.mCalled = false;
    onCreate(paramBundle);
    this.mIsCreated = true;
    if (this.mCalled)
    {
      this.mLifecycleRegistry.a(c.a.ON_CREATE);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("Fragment ");
    paramBundle.append(this);
    paramBundle.append(" did not call through to super.onCreate()");
    throw new SuperNotCalledException(paramBundle.toString());
  }
  
  boolean performCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool2 = this.mHidden;
    boolean bool1 = false;
    boolean bool3 = false;
    if (!bool2)
    {
      bool2 = bool3;
      if (this.mHasMenu)
      {
        bool2 = bool3;
        if (this.mMenuVisible)
        {
          bool2 = true;
          onCreateOptionsMenu(paramMenu, paramMenuInflater);
        }
      }
      bool1 = bool2;
      if (this.mChildFragmentManager != null) {
        bool1 = bool2 | this.mChildFragmentManager.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);
      }
    }
    return bool1;
  }
  
  void performCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.noteStateNotSaved();
    }
    this.mPerformedCreateView = true;
    this.mViewLifecycleOwner = new e()
    {
      public c getLifecycle()
      {
        if (Fragment.this.mViewLifecycleRegistry == null) {
          Fragment.this.mViewLifecycleRegistry = new f(Fragment.this.mViewLifecycleOwner);
        }
        return Fragment.this.mViewLifecycleRegistry;
      }
    };
    this.mViewLifecycleRegistry = null;
    this.mView = onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.mView != null)
    {
      this.mViewLifecycleOwner.getLifecycle();
      this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
      return;
    }
    if (this.mViewLifecycleRegistry == null)
    {
      this.mViewLifecycleOwner = null;
      return;
    }
    throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
  }
  
  void performDestroy()
  {
    this.mLifecycleRegistry.a(c.a.ON_DESTROY);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchDestroy();
    }
    this.mState = 0;
    this.mCalled = false;
    this.mIsCreated = false;
    onDestroy();
    if (this.mCalled)
    {
      this.mChildFragmentManager = null;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onDestroy()");
    throw new SuperNotCalledException(localStringBuilder.toString());
  }
  
  void performDestroyView()
  {
    if (this.mView != null) {
      this.mViewLifecycleRegistry.a(c.a.ON_DESTROY);
    }
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchDestroyView();
    }
    this.mState = 1;
    this.mCalled = false;
    onDestroyView();
    if (this.mCalled)
    {
      LoaderManager.getInstance(this).markForRedelivery();
      this.mPerformedCreateView = false;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onDestroyView()");
    throw new SuperNotCalledException(localStringBuilder.toString());
  }
  
  void performDetach()
  {
    this.mCalled = false;
    onDetach();
    this.mLayoutInflater = null;
    if (this.mCalled)
    {
      if (this.mChildFragmentManager != null)
      {
        if (this.mRetaining)
        {
          this.mChildFragmentManager.dispatchDestroy();
          this.mChildFragmentManager = null;
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Child FragmentManager of ");
        localStringBuilder.append(this);
        localStringBuilder.append(" was not ");
        localStringBuilder.append(" destroyed and this fragment is not retaining instance");
        throw new IllegalStateException(localStringBuilder.toString());
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onDetach()");
    throw new SuperNotCalledException(localStringBuilder.toString());
  }
  
  @NonNull
  LayoutInflater performGetLayoutInflater(@Nullable Bundle paramBundle)
  {
    this.mLayoutInflater = onGetLayoutInflater(paramBundle);
    return this.mLayoutInflater;
  }
  
  void performLowMemory()
  {
    onLowMemory();
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchLowMemory();
    }
  }
  
  void performMultiWindowModeChanged(boolean paramBoolean)
  {
    onMultiWindowModeChanged(paramBoolean);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchMultiWindowModeChanged(paramBoolean);
    }
  }
  
  boolean performOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible) && (onOptionsItemSelected(paramMenuItem))) {
        return true;
      }
      if ((this.mChildFragmentManager != null) && (this.mChildFragmentManager.dispatchOptionsItemSelected(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  void performOptionsMenuClosed(Menu paramMenu)
  {
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible)) {
        onOptionsMenuClosed(paramMenu);
      }
      if (this.mChildFragmentManager != null) {
        this.mChildFragmentManager.dispatchOptionsMenuClosed(paramMenu);
      }
    }
  }
  
  void performPause()
  {
    if (this.mView != null) {
      this.mViewLifecycleRegistry.a(c.a.ON_PAUSE);
    }
    this.mLifecycleRegistry.a(c.a.ON_PAUSE);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchPause();
    }
    this.mState = 3;
    this.mCalled = false;
    onPause();
    if (this.mCalled) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onPause()");
    throw new SuperNotCalledException(localStringBuilder.toString());
  }
  
  void performPictureInPictureModeChanged(boolean paramBoolean)
  {
    onPictureInPictureModeChanged(paramBoolean);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchPictureInPictureModeChanged(paramBoolean);
    }
  }
  
  boolean performPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool2 = this.mHidden;
    boolean bool1 = false;
    boolean bool3 = false;
    if (!bool2)
    {
      bool2 = bool3;
      if (this.mHasMenu)
      {
        bool2 = bool3;
        if (this.mMenuVisible)
        {
          bool2 = true;
          onPrepareOptionsMenu(paramMenu);
        }
      }
      bool1 = bool2;
      if (this.mChildFragmentManager != null) {
        bool1 = bool2 | this.mChildFragmentManager.dispatchPrepareOptionsMenu(paramMenu);
      }
    }
    return bool1;
  }
  
  void performResume()
  {
    if (this.mChildFragmentManager != null)
    {
      this.mChildFragmentManager.noteStateNotSaved();
      this.mChildFragmentManager.execPendingActions();
    }
    this.mState = 4;
    this.mCalled = false;
    onResume();
    if (this.mCalled)
    {
      if (this.mChildFragmentManager != null)
      {
        this.mChildFragmentManager.dispatchResume();
        this.mChildFragmentManager.execPendingActions();
      }
      this.mLifecycleRegistry.a(c.a.ON_RESUME);
      if (this.mView != null) {
        this.mViewLifecycleRegistry.a(c.a.ON_RESUME);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onResume()");
    throw new SuperNotCalledException(localStringBuilder.toString());
  }
  
  void performSaveInstanceState(Bundle paramBundle)
  {
    onSaveInstanceState(paramBundle);
    if (this.mChildFragmentManager != null)
    {
      Parcelable localParcelable = this.mChildFragmentManager.saveAllState();
      if (localParcelable != null) {
        paramBundle.putParcelable("android:support:fragments", localParcelable);
      }
    }
  }
  
  void performStart()
  {
    if (this.mChildFragmentManager != null)
    {
      this.mChildFragmentManager.noteStateNotSaved();
      this.mChildFragmentManager.execPendingActions();
    }
    this.mState = 3;
    this.mCalled = false;
    onStart();
    if (this.mCalled)
    {
      if (this.mChildFragmentManager != null) {
        this.mChildFragmentManager.dispatchStart();
      }
      this.mLifecycleRegistry.a(c.a.ON_START);
      if (this.mView != null) {
        this.mViewLifecycleRegistry.a(c.a.ON_START);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onStart()");
    throw new SuperNotCalledException(localStringBuilder.toString());
  }
  
  void performStop()
  {
    if (this.mView != null) {
      this.mViewLifecycleRegistry.a(c.a.ON_STOP);
    }
    this.mLifecycleRegistry.a(c.a.ON_STOP);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchStop();
    }
    this.mState = 2;
    this.mCalled = false;
    onStop();
    if (this.mCalled) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Fragment ");
    localStringBuilder.append(this);
    localStringBuilder.append(" did not call through to super.onStop()");
    throw new SuperNotCalledException(localStringBuilder.toString());
  }
  
  public void postponeEnterTransition()
  {
    ensureAnimationInfo().mEnterTransitionPostponed = true;
  }
  
  public void registerForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(this);
  }
  
  public final void requestPermissions(@NonNull String[] paramArrayOfString, int paramInt)
  {
    if (this.mHost != null)
    {
      this.mHost.onRequestPermissionsFromFragment(this, paramArrayOfString, paramInt);
      return;
    }
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("Fragment ");
    paramArrayOfString.append(this);
    paramArrayOfString.append(" not attached to Activity");
    throw new IllegalStateException(paramArrayOfString.toString());
  }
  
  @NonNull
  public final FragmentActivity requireActivity()
  {
    Object localObject = getActivity();
    if (localObject != null) {
      return (FragmentActivity)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" not attached to an activity.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  @NonNull
  public final Context requireContext()
  {
    Object localObject = getContext();
    if (localObject != null) {
      return (Context)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" not attached to a context.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  @NonNull
  public final FragmentManager requireFragmentManager()
  {
    Object localObject = getFragmentManager();
    if (localObject != null) {
      return (FragmentManager)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" not associated with a fragment manager.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  @NonNull
  public final Object requireHost()
  {
    Object localObject = getHost();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" not attached to a host.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  void restoreChildFragmentState(@Nullable Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        if (this.mChildFragmentManager == null) {
          instantiateChildFragmentManager();
        }
        this.mChildFragmentManager.restoreAllState(paramBundle, this.mChildNonConfig);
        this.mChildNonConfig = null;
        this.mChildFragmentManager.dispatchCreate();
      }
    }
  }
  
  final void restoreViewState(Bundle paramBundle)
  {
    if (this.mSavedViewState != null)
    {
      this.mInnerView.restoreHierarchyState(this.mSavedViewState);
      this.mSavedViewState = null;
    }
    this.mCalled = false;
    onViewStateRestored(paramBundle);
    if (this.mCalled)
    {
      if (this.mView != null) {
        this.mViewLifecycleRegistry.a(c.a.ON_CREATE);
      }
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("Fragment ");
    paramBundle.append(this);
    paramBundle.append(" did not call through to super.onViewStateRestored()");
    throw new SuperNotCalledException(paramBundle.toString());
  }
  
  public void setAllowEnterTransitionOverlap(boolean paramBoolean)
  {
    ensureAnimationInfo().mAllowEnterTransitionOverlap = Boolean.valueOf(paramBoolean);
  }
  
  public void setAllowReturnTransitionOverlap(boolean paramBoolean)
  {
    ensureAnimationInfo().mAllowReturnTransitionOverlap = Boolean.valueOf(paramBoolean);
  }
  
  void setAnimatingAway(View paramView)
  {
    ensureAnimationInfo().mAnimatingAway = paramView;
  }
  
  void setAnimator(Animator paramAnimator)
  {
    ensureAnimationInfo().mAnimator = paramAnimator;
  }
  
  public void setArguments(@Nullable Bundle paramBundle)
  {
    if ((this.mIndex >= 0) && (isStateSaved())) {
      throw new IllegalStateException("Fragment already active and state has been saved");
    }
    this.mArguments = paramBundle;
  }
  
  public void setEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    ensureAnimationInfo().mEnterTransitionCallback = paramSharedElementCallback;
  }
  
  public void setEnterTransition(@Nullable Object paramObject)
  {
    ensureAnimationInfo().mEnterTransition = paramObject;
  }
  
  public void setExitSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    ensureAnimationInfo().mExitTransitionCallback = paramSharedElementCallback;
  }
  
  public void setExitTransition(@Nullable Object paramObject)
  {
    ensureAnimationInfo().mExitTransition = paramObject;
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    if (this.mHasMenu != paramBoolean)
    {
      this.mHasMenu = paramBoolean;
      if ((isAdded()) && (!isHidden())) {
        this.mHost.onSupportInvalidateOptionsMenu();
      }
    }
  }
  
  void setHideReplaced(boolean paramBoolean)
  {
    ensureAnimationInfo().mIsHideReplaced = paramBoolean;
  }
  
  final void setIndex(int paramInt, Fragment paramFragment)
  {
    this.mIndex = paramInt;
    if (paramFragment != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFragment.mWho);
      localStringBuilder.append(":");
      localStringBuilder.append(this.mIndex);
      this.mWho = localStringBuilder.toString();
      return;
    }
    paramFragment = new StringBuilder();
    paramFragment.append("android:fragment:");
    paramFragment.append(this.mIndex);
    this.mWho = paramFragment.toString();
  }
  
  public void setInitialSavedState(@Nullable SavedState paramSavedState)
  {
    if (this.mIndex < 0)
    {
      if ((paramSavedState != null) && (paramSavedState.mState != null)) {
        paramSavedState = paramSavedState.mState;
      } else {
        paramSavedState = null;
      }
      this.mSavedFragmentState = paramSavedState;
      return;
    }
    throw new IllegalStateException("Fragment already active");
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    if (this.mMenuVisible != paramBoolean)
    {
      this.mMenuVisible = paramBoolean;
      if ((this.mHasMenu) && (isAdded()) && (!isHidden())) {
        this.mHost.onSupportInvalidateOptionsMenu();
      }
    }
  }
  
  void setNextAnim(int paramInt)
  {
    if ((this.mAnimationInfo == null) && (paramInt == 0)) {
      return;
    }
    ensureAnimationInfo().mNextAnim = paramInt;
  }
  
  void setNextTransition(int paramInt1, int paramInt2)
  {
    if ((this.mAnimationInfo == null) && (paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    ensureAnimationInfo();
    this.mAnimationInfo.mNextTransition = paramInt1;
    this.mAnimationInfo.mNextTransitionStyle = paramInt2;
  }
  
  void setOnStartEnterTransitionListener(OnStartEnterTransitionListener paramOnStartEnterTransitionListener)
  {
    ensureAnimationInfo();
    if (paramOnStartEnterTransitionListener == this.mAnimationInfo.mStartEnterTransitionListener) {
      return;
    }
    if ((paramOnStartEnterTransitionListener != null) && (this.mAnimationInfo.mStartEnterTransitionListener != null))
    {
      paramOnStartEnterTransitionListener = new StringBuilder();
      paramOnStartEnterTransitionListener.append("Trying to set a replacement startPostponedEnterTransition on ");
      paramOnStartEnterTransitionListener.append(this);
      throw new IllegalStateException(paramOnStartEnterTransitionListener.toString());
    }
    if (this.mAnimationInfo.mEnterTransitionPostponed) {
      this.mAnimationInfo.mStartEnterTransitionListener = paramOnStartEnterTransitionListener;
    }
    if (paramOnStartEnterTransitionListener != null) {
      paramOnStartEnterTransitionListener.startListening();
    }
  }
  
  public void setReenterTransition(@Nullable Object paramObject)
  {
    ensureAnimationInfo().mReenterTransition = paramObject;
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.mRetainInstance = paramBoolean;
  }
  
  public void setReturnTransition(@Nullable Object paramObject)
  {
    ensureAnimationInfo().mReturnTransition = paramObject;
  }
  
  public void setSharedElementEnterTransition(@Nullable Object paramObject)
  {
    ensureAnimationInfo().mSharedElementEnterTransition = paramObject;
  }
  
  public void setSharedElementReturnTransition(@Nullable Object paramObject)
  {
    ensureAnimationInfo().mSharedElementReturnTransition = paramObject;
  }
  
  void setStateAfterAnimating(int paramInt)
  {
    ensureAnimationInfo().mStateAfterAnimating = paramInt;
  }
  
  public void setTargetFragment(@Nullable Fragment paramFragment, int paramInt)
  {
    FragmentManager localFragmentManager = getFragmentManager();
    if (paramFragment != null) {
      localObject = paramFragment.getFragmentManager();
    } else {
      localObject = null;
    }
    if ((localFragmentManager != null) && (localObject != null) && (localFragmentManager != localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Fragment ");
      ((StringBuilder)localObject).append(paramFragment);
      ((StringBuilder)localObject).append(" must share the same FragmentManager to be set as a target fragment");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = paramFragment;
    while (localObject != null) {
      if (localObject != this)
      {
        localObject = ((Fragment)localObject).getTargetFragment();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Setting ");
        ((StringBuilder)localObject).append(paramFragment);
        ((StringBuilder)localObject).append(" as the target of ");
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append(" would create a target cycle");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    this.mTarget = paramFragment;
    this.mTargetRequestCode = paramInt;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if ((!this.mUserVisibleHint) && (paramBoolean) && (this.mState < 3) && (this.mFragmentManager != null) && (isAdded()) && (this.mIsCreated)) {
      this.mFragmentManager.performPendingDeferredStart(this);
    }
    this.mUserVisibleHint = paramBoolean;
    boolean bool;
    if ((this.mState < 3) && (!paramBoolean)) {
      bool = true;
    } else {
      bool = false;
    }
    this.mDeferStart = bool;
    if (this.mSavedFragmentState != null) {
      this.mSavedUserVisibleHint = Boolean.valueOf(paramBoolean);
    }
  }
  
  public boolean shouldShowRequestPermissionRationale(@NonNull String paramString)
  {
    if (this.mHost != null) {
      return this.mHost.onShouldShowRequestPermissionRationale(paramString);
    }
    return false;
  }
  
  public void startActivity(Intent paramIntent)
  {
    startActivity(paramIntent, null);
  }
  
  public void startActivity(Intent paramIntent, @Nullable Bundle paramBundle)
  {
    if (this.mHost != null)
    {
      this.mHost.onStartActivityFromFragment(this, paramIntent, -1, paramBundle);
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("Fragment ");
    paramIntent.append(this);
    paramIntent.append(" not attached to Activity");
    throw new IllegalStateException(paramIntent.toString());
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    startActivityForResult(paramIntent, paramInt, null);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    if (this.mHost != null)
    {
      this.mHost.onStartActivityFromFragment(this, paramIntent, paramInt, paramBundle);
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("Fragment ");
    paramIntent.append(this);
    paramIntent.append(" not attached to Activity");
    throw new IllegalStateException(paramIntent.toString());
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    if (this.mHost != null)
    {
      this.mHost.onStartIntentSenderFromFragment(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    paramIntentSender = new StringBuilder();
    paramIntentSender.append("Fragment ");
    paramIntentSender.append(this);
    paramIntentSender.append(" not attached to Activity");
    throw new IllegalStateException(paramIntentSender.toString());
  }
  
  public void startPostponedEnterTransition()
  {
    if ((this.mFragmentManager != null) && (this.mFragmentManager.mHost != null))
    {
      if (Looper.myLooper() != this.mFragmentManager.mHost.getHandler().getLooper())
      {
        this.mFragmentManager.mHost.getHandler().postAtFrontOfQueue(new Runnable()
        {
          public void run()
          {
            Fragment.this.callStartTransitionListener();
          }
        });
        return;
      }
      callStartTransitionListener();
      return;
    }
    ensureAnimationInfo().mEnterTransitionPostponed = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    DebugUtils.buildShortClassTag(this, localStringBuilder);
    if (this.mIndex >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mIndex);
    }
    if (this.mFragmentId != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.mFragmentId));
    }
    if (this.mTag != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mTag);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void unregisterForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(null);
  }
  
  static class AnimationInfo
  {
    Boolean mAllowEnterTransitionOverlap;
    Boolean mAllowReturnTransitionOverlap;
    View mAnimatingAway;
    Animator mAnimator;
    Object mEnterTransition = null;
    SharedElementCallback mEnterTransitionCallback = null;
    boolean mEnterTransitionPostponed;
    Object mExitTransition = null;
    SharedElementCallback mExitTransitionCallback = null;
    boolean mIsHideReplaced;
    int mNextAnim;
    int mNextTransition;
    int mNextTransitionStyle;
    Object mReenterTransition = Fragment.USE_DEFAULT_TRANSITION;
    Object mReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
    Object mSharedElementEnterTransition = null;
    Object mSharedElementReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
    Fragment.OnStartEnterTransitionListener mStartEnterTransitionListener;
    int mStateAfterAnimating;
  }
  
  public static class InstantiationException
    extends RuntimeException
  {
    public InstantiationException(String paramString, Exception paramException)
    {
      super(paramException);
    }
  }
  
  static abstract interface OnStartEnterTransitionListener
  {
    public abstract void onStartEnterTransition();
    
    public abstract void startListening();
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public Fragment.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new Fragment.SavedState(paramAnonymousParcel, null);
      }
      
      public Fragment.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new Fragment.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public Fragment.SavedState[] newArray(int paramAnonymousInt)
      {
        return new Fragment.SavedState[paramAnonymousInt];
      }
    };
    final Bundle mState;
    
    SavedState(Bundle paramBundle)
    {
      this.mState = paramBundle;
    }
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      this.mState = paramParcel.readBundle();
      if ((paramClassLoader != null) && (this.mState != null)) {
        this.mState.setClassLoader(paramClassLoader);
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeBundle(this.mState);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\app\Fragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */