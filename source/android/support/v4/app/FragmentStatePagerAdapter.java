package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FragmentStatePagerAdapter
  extends PagerAdapter
{
  private static final boolean DEBUG = false;
  private static final String TAG = "FragmentStatePagerAdapt";
  private FragmentTransaction mCurTransaction = null;
  private Fragment mCurrentPrimaryItem = null;
  private final FragmentManager mFragmentManager;
  private ArrayList<Fragment> mFragments = new ArrayList();
  private ArrayList<Fragment.SavedState> mSavedState = new ArrayList();
  
  public FragmentStatePagerAdapter(FragmentManager paramFragmentManager)
  {
    this.mFragmentManager = paramFragmentManager;
  }
  
  public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramObject = (Fragment)paramObject;
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    while (this.mSavedState.size() <= paramInt) {
      this.mSavedState.add(null);
    }
    ArrayList localArrayList = this.mSavedState;
    if (((Fragment)paramObject).isAdded()) {
      paramViewGroup = this.mFragmentManager.saveFragmentInstanceState((Fragment)paramObject);
    } else {
      paramViewGroup = null;
    }
    localArrayList.set(paramInt, paramViewGroup);
    this.mFragments.set(paramInt, null);
    this.mCurTransaction.remove((Fragment)paramObject);
  }
  
  public void finishUpdate(@NonNull ViewGroup paramViewGroup)
  {
    if (this.mCurTransaction != null)
    {
      this.mCurTransaction.commitNowAllowingStateLoss();
      this.mCurTransaction = null;
    }
  }
  
  public abstract Fragment getItem(int paramInt);
  
  @NonNull
  public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mFragments.size() > paramInt)
    {
      localFragment = (Fragment)this.mFragments.get(paramInt);
      if (localFragment != null) {
        return localFragment;
      }
    }
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    Fragment localFragment = getItem(paramInt);
    if (this.mSavedState.size() > paramInt)
    {
      Fragment.SavedState localSavedState = (Fragment.SavedState)this.mSavedState.get(paramInt);
      if (localSavedState != null) {
        localFragment.setInitialSavedState(localSavedState);
      }
    }
    while (this.mFragments.size() <= paramInt) {
      this.mFragments.add(null);
    }
    localFragment.setMenuVisibility(false);
    localFragment.setUserVisibleHint(false);
    this.mFragments.set(paramInt, localFragment);
    this.mCurTransaction.add(paramViewGroup.getId(), localFragment);
    return localFragment;
  }
  
  public boolean isViewFromObject(@NonNull View paramView, @NonNull Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      paramClassLoader = paramParcelable.getParcelableArray("states");
      this.mSavedState.clear();
      this.mFragments.clear();
      int i;
      if (paramClassLoader != null)
      {
        i = 0;
        while (i < paramClassLoader.length)
        {
          this.mSavedState.add((Fragment.SavedState)paramClassLoader[i]);
          i += 1;
        }
      }
      paramClassLoader = paramParcelable.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        String str = (String)paramClassLoader.next();
        if (str.startsWith("f"))
        {
          i = Integer.parseInt(str.substring(1));
          Object localObject = this.mFragmentManager.getFragment(paramParcelable, str);
          if (localObject != null)
          {
            while (this.mFragments.size() <= i) {
              this.mFragments.add(null);
            }
            ((Fragment)localObject).setMenuVisibility(false);
            this.mFragments.set(i, localObject);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Bad fragment at key ");
            ((StringBuilder)localObject).append(str);
            Log.w("FragmentStatePagerAdapt", ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  public Parcelable saveState()
  {
    Object localObject2;
    Object localObject1;
    if (this.mSavedState.size() > 0)
    {
      localObject2 = new Bundle();
      localObject1 = new Fragment.SavedState[this.mSavedState.size()];
      this.mSavedState.toArray((Object[])localObject1);
      ((Bundle)localObject2).putParcelableArray("states", (Parcelable[])localObject1);
    }
    else
    {
      localObject2 = null;
    }
    int i = 0;
    while (i < this.mFragments.size())
    {
      Fragment localFragment = (Fragment)this.mFragments.get(i);
      localObject1 = localObject2;
      if (localFragment != null)
      {
        localObject1 = localObject2;
        if (localFragment.isAdded())
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("f");
          ((StringBuilder)localObject2).append(i);
          localObject2 = ((StringBuilder)localObject2).toString();
          this.mFragmentManager.putFragment((Bundle)localObject1, (String)localObject2, localFragment);
        }
      }
      i += 1;
      localObject2 = localObject1;
    }
    return (Parcelable)localObject2;
  }
  
  public void setPrimaryItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (paramViewGroup != this.mCurrentPrimaryItem)
    {
      if (this.mCurrentPrimaryItem != null)
      {
        this.mCurrentPrimaryItem.setMenuVisibility(false);
        this.mCurrentPrimaryItem.setUserVisibleHint(false);
      }
      paramViewGroup.setMenuVisibility(true);
      paramViewGroup.setUserVisibleHint(true);
      this.mCurrentPrimaryItem = paramViewGroup;
    }
  }
  
  public void startUpdate(@NonNull ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() != -1) {
      return;
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("ViewPager with adapter ");
    paramViewGroup.append(this);
    paramViewGroup.append(" requires a view id");
    throw new IllegalStateException(paramViewGroup.toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\app\FragmentStatePagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */