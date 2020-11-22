package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public abstract class Transition
  implements Cloneable
{
  static final boolean DBG = false;
  private static final int[] DEFAULT_MATCH_ORDER = { 2, 1, 3, 4 };
  private static final String LOG_TAG = "Transition";
  private static final int MATCH_FIRST = 1;
  public static final int MATCH_ID = 3;
  private static final String MATCH_ID_STR = "id";
  public static final int MATCH_INSTANCE = 1;
  private static final String MATCH_INSTANCE_STR = "instance";
  public static final int MATCH_ITEM_ID = 4;
  private static final String MATCH_ITEM_ID_STR = "itemId";
  private static final int MATCH_LAST = 4;
  public static final int MATCH_NAME = 2;
  private static final String MATCH_NAME_STR = "name";
  private static final PathMotion STRAIGHT_PATH_MOTION = new PathMotion()
  {
    public Path getPath(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      Path localPath = new Path();
      localPath.moveTo(paramAnonymousFloat1, paramAnonymousFloat2);
      localPath.lineTo(paramAnonymousFloat3, paramAnonymousFloat4);
      return localPath;
    }
  };
  private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal();
  private ArrayList<Animator> mAnimators = new ArrayList();
  boolean mCanRemoveViews = false;
  ArrayList<Animator> mCurrentAnimators = new ArrayList();
  long mDuration = -1L;
  private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
  private ArrayList<TransitionValues> mEndValuesList;
  private boolean mEnded = false;
  private EpicenterCallback mEpicenterCallback;
  private TimeInterpolator mInterpolator = null;
  private ArrayList<TransitionListener> mListeners = null;
  private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
  private String mName = getClass().getName();
  private ArrayMap<String, String> mNameOverrides;
  private int mNumInstances = 0;
  TransitionSet mParent = null;
  private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;
  private boolean mPaused = false;
  TransitionPropagation mPropagation;
  private ViewGroup mSceneRoot = null;
  private long mStartDelay = -1L;
  private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
  private ArrayList<TransitionValues> mStartValuesList;
  private ArrayList<View> mTargetChildExcludes = null;
  private ArrayList<View> mTargetExcludes = null;
  private ArrayList<Integer> mTargetIdChildExcludes = null;
  private ArrayList<Integer> mTargetIdExcludes = null;
  ArrayList<Integer> mTargetIds = new ArrayList();
  private ArrayList<String> mTargetNameExcludes = null;
  private ArrayList<String> mTargetNames = null;
  private ArrayList<Class> mTargetTypeChildExcludes = null;
  private ArrayList<Class> mTargetTypeExcludes = null;
  private ArrayList<Class> mTargetTypes = null;
  ArrayList<View> mTargets = new ArrayList();
  
  public Transition() {}
  
  public Transition(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.TRANSITION);
    paramAttributeSet = (XmlResourceParser)paramAttributeSet;
    long l = TypedArrayUtils.getNamedInt(localTypedArray, paramAttributeSet, "duration", 1, -1);
    if (l >= 0L) {
      setDuration(l);
    }
    l = TypedArrayUtils.getNamedInt(localTypedArray, paramAttributeSet, "startDelay", 2, -1);
    if (l > 0L) {
      setStartDelay(l);
    }
    int i = TypedArrayUtils.getNamedResourceId(localTypedArray, paramAttributeSet, "interpolator", 0, 0);
    if (i > 0) {
      setInterpolator(AnimationUtils.loadInterpolator(paramContext, i));
    }
    paramContext = TypedArrayUtils.getNamedString(localTypedArray, paramAttributeSet, "matchOrder", 3);
    if (paramContext != null) {
      setMatchOrder(parseMatchOrder(paramContext));
    }
    localTypedArray.recycle();
  }
  
  private void addUnmatched(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramArrayMap1.size()) {
        break;
      }
      TransitionValues localTransitionValues = (TransitionValues)paramArrayMap1.valueAt(i);
      if (isValidTarget(localTransitionValues.view))
      {
        this.mStartValuesList.add(localTransitionValues);
        this.mEndValuesList.add(null);
      }
      i += 1;
    }
    while (j < paramArrayMap2.size())
    {
      paramArrayMap1 = (TransitionValues)paramArrayMap2.valueAt(j);
      if (isValidTarget(paramArrayMap1.view))
      {
        this.mEndValuesList.add(paramArrayMap1);
        this.mStartValuesList.add(null);
      }
      j += 1;
    }
  }
  
  private static void addViewValues(TransitionValuesMaps paramTransitionValuesMaps, View paramView, TransitionValues paramTransitionValues)
  {
    paramTransitionValuesMaps.mViewValues.put(paramView, paramTransitionValues);
    int i = paramView.getId();
    if (i >= 0) {
      if (paramTransitionValuesMaps.mIdValues.indexOfKey(i) >= 0) {
        paramTransitionValuesMaps.mIdValues.put(i, null);
      } else {
        paramTransitionValuesMaps.mIdValues.put(i, paramView);
      }
    }
    paramTransitionValues = ViewCompat.getTransitionName(paramView);
    if (paramTransitionValues != null) {
      if (paramTransitionValuesMaps.mNameValues.containsKey(paramTransitionValues)) {
        paramTransitionValuesMaps.mNameValues.put(paramTransitionValues, null);
      } else {
        paramTransitionValuesMaps.mNameValues.put(paramTransitionValues, paramView);
      }
    }
    if ((paramView.getParent() instanceof ListView))
    {
      paramTransitionValues = (ListView)paramView.getParent();
      if (paramTransitionValues.getAdapter().hasStableIds())
      {
        long l = paramTransitionValues.getItemIdAtPosition(paramTransitionValues.getPositionForView(paramView));
        if (paramTransitionValuesMaps.mItemIdValues.indexOfKey(l) >= 0)
        {
          paramView = (View)paramTransitionValuesMaps.mItemIdValues.get(l);
          if (paramView != null)
          {
            ViewCompat.setHasTransientState(paramView, false);
            paramTransitionValuesMaps.mItemIdValues.put(l, null);
          }
        }
        else
        {
          ViewCompat.setHasTransientState(paramView, true);
          paramTransitionValuesMaps.mItemIdValues.put(l, paramView);
        }
      }
    }
  }
  
  private static boolean alreadyContains(int[] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt[i] == j) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void captureHierarchy(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    int k = paramView.getId();
    if ((this.mTargetIdExcludes != null) && (this.mTargetIdExcludes.contains(Integer.valueOf(k)))) {
      return;
    }
    if ((this.mTargetExcludes != null) && (this.mTargetExcludes.contains(paramView))) {
      return;
    }
    Object localObject = this.mTargetTypeExcludes;
    int j = 0;
    int i;
    if (localObject != null)
    {
      int m = this.mTargetTypeExcludes.size();
      i = 0;
      while (i < m)
      {
        if (((Class)this.mTargetTypeExcludes.get(i)).isInstance(paramView)) {
          return;
        }
        i += 1;
      }
    }
    if ((paramView.getParent() instanceof ViewGroup))
    {
      localObject = new TransitionValues();
      ((TransitionValues)localObject).view = paramView;
      if (paramBoolean) {
        captureStartValues((TransitionValues)localObject);
      } else {
        captureEndValues((TransitionValues)localObject);
      }
      ((TransitionValues)localObject).mTargetedTransitions.add(this);
      capturePropagationValues((TransitionValues)localObject);
      if (paramBoolean) {
        addViewValues(this.mStartValues, paramView, (TransitionValues)localObject);
      } else {
        addViewValues(this.mEndValues, paramView, (TransitionValues)localObject);
      }
    }
    if ((paramView instanceof ViewGroup))
    {
      if ((this.mTargetIdChildExcludes != null) && (this.mTargetIdChildExcludes.contains(Integer.valueOf(k)))) {
        return;
      }
      if ((this.mTargetChildExcludes != null) && (this.mTargetChildExcludes.contains(paramView))) {
        return;
      }
      if (this.mTargetTypeChildExcludes != null)
      {
        k = this.mTargetTypeChildExcludes.size();
        i = 0;
        while (i < k)
        {
          if (((Class)this.mTargetTypeChildExcludes.get(i)).isInstance(paramView)) {
            return;
          }
          i += 1;
        }
      }
      paramView = (ViewGroup)paramView;
      i = j;
      while (i < paramView.getChildCount())
      {
        captureHierarchy(paramView.getChildAt(i), paramBoolean);
        i += 1;
      }
    }
  }
  
  private ArrayList<Integer> excludeId(ArrayList<Integer> paramArrayList, int paramInt, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramInt > 0)
    {
      if (paramBoolean) {
        return ArrayListManager.add(paramArrayList, Integer.valueOf(paramInt));
      }
      localObject = ArrayListManager.remove(paramArrayList, Integer.valueOf(paramInt));
    }
    return (ArrayList<Integer>)localObject;
  }
  
  private static <T> ArrayList<T> excludeObject(ArrayList<T> paramArrayList, T paramT, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramT != null)
    {
      if (paramBoolean) {
        return ArrayListManager.add(paramArrayList, paramT);
      }
      localObject = ArrayListManager.remove(paramArrayList, paramT);
    }
    return (ArrayList<T>)localObject;
  }
  
  private ArrayList<Class> excludeType(ArrayList<Class> paramArrayList, Class paramClass, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramClass != null)
    {
      if (paramBoolean) {
        return ArrayListManager.add(paramArrayList, paramClass);
      }
      localObject = ArrayListManager.remove(paramArrayList, paramClass);
    }
    return (ArrayList<Class>)localObject;
  }
  
  private ArrayList<View> excludeView(ArrayList<View> paramArrayList, View paramView, boolean paramBoolean)
  {
    Object localObject = paramArrayList;
    if (paramView != null)
    {
      if (paramBoolean) {
        return ArrayListManager.add(paramArrayList, paramView);
      }
      localObject = ArrayListManager.remove(paramArrayList, paramView);
    }
    return (ArrayList<View>)localObject;
  }
  
  private static ArrayMap<Animator, AnimationInfo> getRunningAnimators()
  {
    ArrayMap localArrayMap2 = (ArrayMap)sRunningAnimators.get();
    ArrayMap localArrayMap1 = localArrayMap2;
    if (localArrayMap2 == null)
    {
      localArrayMap1 = new ArrayMap();
      sRunningAnimators.set(localArrayMap1);
    }
    return localArrayMap1;
  }
  
  private static boolean isValidMatch(int paramInt)
  {
    return (paramInt >= 1) && (paramInt <= 4);
  }
  
  private static boolean isValueChanged(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2, String paramString)
  {
    paramTransitionValues1 = paramTransitionValues1.values.get(paramString);
    paramTransitionValues2 = paramTransitionValues2.values.get(paramString);
    boolean bool = true;
    if ((paramTransitionValues1 == null) && (paramTransitionValues2 == null)) {
      return false;
    }
    if (paramTransitionValues1 != null)
    {
      if (paramTransitionValues2 == null) {
        return true;
      }
      bool = true ^ paramTransitionValues1.equals(paramTransitionValues2);
    }
    return bool;
  }
  
  private void matchIds(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2, SparseArray<View> paramSparseArray1, SparseArray<View> paramSparseArray2)
  {
    int j = paramSparseArray1.size();
    int i = 0;
    while (i < j)
    {
      View localView1 = (View)paramSparseArray1.valueAt(i);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramSparseArray2.get(paramSparseArray1.keyAt(i));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          TransitionValues localTransitionValues1 = (TransitionValues)paramArrayMap1.get(localView1);
          TransitionValues localTransitionValues2 = (TransitionValues)paramArrayMap2.get(localView2);
          if ((localTransitionValues1 != null) && (localTransitionValues2 != null))
          {
            this.mStartValuesList.add(localTransitionValues1);
            this.mEndValuesList.add(localTransitionValues2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i += 1;
    }
  }
  
  private void matchInstances(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2)
  {
    int i = paramArrayMap1.size() - 1;
    while (i >= 0)
    {
      Object localObject = (View)paramArrayMap1.keyAt(i);
      if ((localObject != null) && (isValidTarget((View)localObject)))
      {
        localObject = (TransitionValues)paramArrayMap2.remove(localObject);
        if ((localObject != null) && (((TransitionValues)localObject).view != null) && (isValidTarget(((TransitionValues)localObject).view)))
        {
          TransitionValues localTransitionValues = (TransitionValues)paramArrayMap1.removeAt(i);
          this.mStartValuesList.add(localTransitionValues);
          this.mEndValuesList.add(localObject);
        }
      }
      i -= 1;
    }
  }
  
  private void matchItemIds(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2, LongSparseArray<View> paramLongSparseArray1, LongSparseArray<View> paramLongSparseArray2)
  {
    int j = paramLongSparseArray1.size();
    int i = 0;
    while (i < j)
    {
      View localView1 = (View)paramLongSparseArray1.valueAt(i);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramLongSparseArray2.get(paramLongSparseArray1.keyAt(i));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          TransitionValues localTransitionValues1 = (TransitionValues)paramArrayMap1.get(localView1);
          TransitionValues localTransitionValues2 = (TransitionValues)paramArrayMap2.get(localView2);
          if ((localTransitionValues1 != null) && (localTransitionValues2 != null))
          {
            this.mStartValuesList.add(localTransitionValues1);
            this.mEndValuesList.add(localTransitionValues2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i += 1;
    }
  }
  
  private void matchNames(ArrayMap<View, TransitionValues> paramArrayMap1, ArrayMap<View, TransitionValues> paramArrayMap2, ArrayMap<String, View> paramArrayMap3, ArrayMap<String, View> paramArrayMap4)
  {
    int j = paramArrayMap3.size();
    int i = 0;
    while (i < j)
    {
      View localView1 = (View)paramArrayMap3.valueAt(i);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramArrayMap4.get(paramArrayMap3.keyAt(i));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          TransitionValues localTransitionValues1 = (TransitionValues)paramArrayMap1.get(localView1);
          TransitionValues localTransitionValues2 = (TransitionValues)paramArrayMap2.get(localView2);
          if ((localTransitionValues1 != null) && (localTransitionValues2 != null))
          {
            this.mStartValuesList.add(localTransitionValues1);
            this.mEndValuesList.add(localTransitionValues2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i += 1;
    }
  }
  
  private void matchStartAndEnd(TransitionValuesMaps paramTransitionValuesMaps1, TransitionValuesMaps paramTransitionValuesMaps2)
  {
    ArrayMap localArrayMap1 = new ArrayMap(paramTransitionValuesMaps1.mViewValues);
    ArrayMap localArrayMap2 = new ArrayMap(paramTransitionValuesMaps2.mViewValues);
    int i = 0;
    while (i < this.mMatchOrder.length)
    {
      switch (this.mMatchOrder[i])
      {
      default: 
        break;
      case 4: 
        matchItemIds(localArrayMap1, localArrayMap2, paramTransitionValuesMaps1.mItemIdValues, paramTransitionValuesMaps2.mItemIdValues);
        break;
      case 3: 
        matchIds(localArrayMap1, localArrayMap2, paramTransitionValuesMaps1.mIdValues, paramTransitionValuesMaps2.mIdValues);
        break;
      case 2: 
        matchNames(localArrayMap1, localArrayMap2, paramTransitionValuesMaps1.mNameValues, paramTransitionValuesMaps2.mNameValues);
        break;
      case 1: 
        matchInstances(localArrayMap1, localArrayMap2);
      }
      i += 1;
    }
    addUnmatched(localArrayMap1, localArrayMap2);
  }
  
  private static int[] parseMatchOrder(String paramString)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
    paramString = new int[localStringTokenizer.countTokens()];
    int i = 0;
    while (localStringTokenizer.hasMoreTokens())
    {
      Object localObject = localStringTokenizer.nextToken().trim();
      if ("id".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 3;
      }
      else if ("instance".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 1;
      }
      else if ("name".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 2;
      }
      else if ("itemId".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 4;
      }
      else
      {
        if (!((String)localObject).isEmpty()) {
          break label135;
        }
        localObject = new int[paramString.length - 1];
        System.arraycopy(paramString, 0, localObject, 0, i);
        i -= 1;
        paramString = (String)localObject;
      }
      i += 1;
      continue;
      label135:
      paramString = new StringBuilder();
      paramString.append("Unknown match type in matchOrder: '");
      paramString.append((String)localObject);
      paramString.append("'");
      throw new InflateException(paramString.toString());
    }
    return paramString;
  }
  
  private void runAnimator(Animator paramAnimator, final ArrayMap<Animator, AnimationInfo> paramArrayMap)
  {
    if (paramAnimator != null)
    {
      paramAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramArrayMap.remove(paramAnonymousAnimator);
          Transition.this.mCurrentAnimators.remove(paramAnonymousAnimator);
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          Transition.this.mCurrentAnimators.add(paramAnonymousAnimator);
        }
      });
      animate(paramAnimator);
    }
  }
  
  @NonNull
  public Transition addListener(@NonNull TransitionListener paramTransitionListener)
  {
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramTransitionListener);
    return this;
  }
  
  @NonNull
  public Transition addTarget(@IdRes int paramInt)
  {
    if (paramInt != 0) {
      this.mTargetIds.add(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  @NonNull
  public Transition addTarget(@NonNull View paramView)
  {
    this.mTargets.add(paramView);
    return this;
  }
  
  @NonNull
  public Transition addTarget(@NonNull Class paramClass)
  {
    if (this.mTargetTypes == null) {
      this.mTargetTypes = new ArrayList();
    }
    this.mTargetTypes.add(paramClass);
    return this;
  }
  
  @NonNull
  public Transition addTarget(@NonNull String paramString)
  {
    if (this.mTargetNames == null) {
      this.mTargetNames = new ArrayList();
    }
    this.mTargetNames.add(paramString);
    return this;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void animate(Animator paramAnimator)
  {
    if (paramAnimator == null)
    {
      end();
      return;
    }
    if (getDuration() >= 0L) {
      paramAnimator.setDuration(getDuration());
    }
    if (getStartDelay() >= 0L) {
      paramAnimator.setStartDelay(getStartDelay());
    }
    if (getInterpolator() != null) {
      paramAnimator.setInterpolator(getInterpolator());
    }
    paramAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        Transition.this.end();
        paramAnonymousAnimator.removeListener(this);
      }
    });
    paramAnimator.start();
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void cancel()
  {
    int i = this.mCurrentAnimators.size() - 1;
    while (i >= 0)
    {
      ((Animator)this.mCurrentAnimators.get(i)).cancel();
      i -= 1;
    }
    if ((this.mListeners != null) && (this.mListeners.size() > 0))
    {
      ArrayList localArrayList = (ArrayList)this.mListeners.clone();
      int j = localArrayList.size();
      i = 0;
      while (i < j)
      {
        ((TransitionListener)localArrayList.get(i)).onTransitionCancel(this);
        i += 1;
      }
    }
  }
  
  public abstract void captureEndValues(@NonNull TransitionValues paramTransitionValues);
  
  void capturePropagationValues(TransitionValues paramTransitionValues)
  {
    if ((this.mPropagation != null) && (!paramTransitionValues.values.isEmpty()))
    {
      String[] arrayOfString = this.mPropagation.getPropagationProperties();
      if (arrayOfString == null) {
        return;
      }
      int j = 0;
      int i = 0;
      while (i < arrayOfString.length)
      {
        if (!paramTransitionValues.values.containsKey(arrayOfString[i]))
        {
          i = j;
          break label75;
        }
        i += 1;
      }
      i = 1;
      label75:
      if (i == 0) {
        this.mPropagation.captureValues(paramTransitionValues);
      }
    }
  }
  
  public abstract void captureStartValues(@NonNull TransitionValues paramTransitionValues);
  
  void captureValues(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    clearValues(paramBoolean);
    int i = this.mTargetIds.size();
    int k = 0;
    Object localObject1;
    Object localObject2;
    if (((i <= 0) && (this.mTargets.size() <= 0)) || ((this.mTargetNames != null) && (!this.mTargetNames.isEmpty())) || ((this.mTargetTypes != null) && (!this.mTargetTypes.isEmpty())))
    {
      captureHierarchy(paramViewGroup, paramBoolean);
    }
    else
    {
      i = 0;
      while (i < this.mTargetIds.size())
      {
        localObject1 = paramViewGroup.findViewById(((Integer)this.mTargetIds.get(i)).intValue());
        if (localObject1 != null)
        {
          localObject2 = new TransitionValues();
          ((TransitionValues)localObject2).view = ((View)localObject1);
          if (paramBoolean) {
            captureStartValues((TransitionValues)localObject2);
          } else {
            captureEndValues((TransitionValues)localObject2);
          }
          ((TransitionValues)localObject2).mTargetedTransitions.add(this);
          capturePropagationValues((TransitionValues)localObject2);
          if (paramBoolean) {
            addViewValues(this.mStartValues, (View)localObject1, (TransitionValues)localObject2);
          } else {
            addViewValues(this.mEndValues, (View)localObject1, (TransitionValues)localObject2);
          }
        }
        i += 1;
      }
      i = 0;
      while (i < this.mTargets.size())
      {
        paramViewGroup = (View)this.mTargets.get(i);
        localObject1 = new TransitionValues();
        ((TransitionValues)localObject1).view = paramViewGroup;
        if (paramBoolean) {
          captureStartValues((TransitionValues)localObject1);
        } else {
          captureEndValues((TransitionValues)localObject1);
        }
        ((TransitionValues)localObject1).mTargetedTransitions.add(this);
        capturePropagationValues((TransitionValues)localObject1);
        if (paramBoolean) {
          addViewValues(this.mStartValues, paramViewGroup, (TransitionValues)localObject1);
        } else {
          addViewValues(this.mEndValues, paramViewGroup, (TransitionValues)localObject1);
        }
        i += 1;
      }
    }
    if ((!paramBoolean) && (this.mNameOverrides != null))
    {
      int m = this.mNameOverrides.size();
      paramViewGroup = new ArrayList(m);
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        localObject1 = (String)this.mNameOverrides.keyAt(i);
        paramViewGroup.add(this.mStartValues.mNameValues.remove(localObject1));
        i += 1;
      }
      while (j < m)
      {
        localObject1 = (View)paramViewGroup.get(j);
        if (localObject1 != null)
        {
          localObject2 = (String)this.mNameOverrides.valueAt(j);
          this.mStartValues.mNameValues.put(localObject2, localObject1);
        }
        j += 1;
      }
    }
  }
  
  void clearValues(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mStartValues.mViewValues.clear();
      this.mStartValues.mIdValues.clear();
      this.mStartValues.mItemIdValues.clear();
      return;
    }
    this.mEndValues.mViewValues.clear();
    this.mEndValues.mIdValues.clear();
    this.mEndValues.mItemIdValues.clear();
  }
  
  public Transition clone()
  {
    try
    {
      Transition localTransition = (Transition)super.clone();
      localTransition.mAnimators = new ArrayList();
      localTransition.mStartValues = new TransitionValuesMaps();
      localTransition.mEndValues = new TransitionValuesMaps();
      localTransition.mStartValuesList = null;
      localTransition.mEndValuesList = null;
      return localTransition;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  @Nullable
  public Animator createAnimator(@NonNull ViewGroup paramViewGroup, @Nullable TransitionValues paramTransitionValues1, @Nullable TransitionValues paramTransitionValues2)
  {
    return null;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void createAnimators(ViewGroup paramViewGroup, TransitionValuesMaps paramTransitionValuesMaps1, TransitionValuesMaps paramTransitionValuesMaps2, ArrayList<TransitionValues> paramArrayList1, ArrayList<TransitionValues> paramArrayList2)
  {
    ArrayMap localArrayMap = getRunningAnimators();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int k = paramArrayList1.size();
    long l1 = Long.MAX_VALUE;
    int i = 0;
    int j;
    while (i < k)
    {
      Object localObject1 = (TransitionValues)paramArrayList1.get(i);
      paramTransitionValuesMaps1 = (TransitionValues)paramArrayList2.get(i);
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (!((TransitionValues)localObject1).mTargetedTransitions.contains(this)) {
          localObject2 = null;
        }
      }
      TransitionValuesMaps localTransitionValuesMaps = paramTransitionValuesMaps1;
      if (paramTransitionValuesMaps1 != null)
      {
        localTransitionValuesMaps = paramTransitionValuesMaps1;
        if (!paramTransitionValuesMaps1.mTargetedTransitions.contains(this)) {
          localTransitionValuesMaps = null;
        }
      }
      if ((localObject2 == null) && (localTransitionValuesMaps == null)) {}
      do
      {
        do
        {
          l2 = l1;
          j = i;
          break;
          if ((localObject2 != null) && (localTransitionValuesMaps != null) && (!isTransitionRequired((TransitionValues)localObject2, localTransitionValuesMaps))) {
            j = 0;
          } else {
            j = 1;
          }
        } while (j == 0);
        paramTransitionValuesMaps1 = createAnimator(paramViewGroup, (TransitionValues)localObject2, localTransitionValuesMaps);
      } while (paramTransitionValuesMaps1 == null);
      View localView;
      if (localTransitionValuesMaps != null)
      {
        localView = localTransitionValuesMaps.view;
        String[] arrayOfString = getTransitionProperties();
        if ((localView != null) && (arrayOfString != null) && (arrayOfString.length > 0))
        {
          TransitionValues localTransitionValues = new TransitionValues();
          localTransitionValues.view = localView;
          localObject1 = (TransitionValues)paramTransitionValuesMaps2.mViewValues.get(localView);
          j = i;
          if (localObject1 != null)
          {
            m = 0;
            for (;;)
            {
              j = i;
              if (m >= arrayOfString.length) {
                break;
              }
              localTransitionValues.values.put(arrayOfString[m], ((TransitionValues)localObject1).values.get(arrayOfString[m]));
              m += 1;
            }
          }
          i = j;
          int m = localArrayMap.size();
          j = 0;
          while (j < m)
          {
            localObject1 = (AnimationInfo)localArrayMap.get((Animator)localArrayMap.keyAt(j));
            if ((((AnimationInfo)localObject1).mValues != null) && (((AnimationInfo)localObject1).mView == localView) && (((AnimationInfo)localObject1).mName.equals(getName())) && (((AnimationInfo)localObject1).mValues.equals(localTransitionValues)))
            {
              paramTransitionValuesMaps1 = null;
              localObject1 = localTransitionValues;
              break label427;
            }
            j += 1;
          }
          localObject1 = localTransitionValues;
        }
        else
        {
          localObject1 = null;
        }
      }
      else
      {
        label427:
        localView = ((TransitionValues)localObject2).view;
        localObject1 = null;
      }
      long l2 = l1;
      j = i;
      if (paramTransitionValuesMaps1 != null)
      {
        l2 = l1;
        if (this.mPropagation != null)
        {
          l2 = this.mPropagation.getStartDelay(paramViewGroup, this, (TransitionValues)localObject2, localTransitionValuesMaps);
          localSparseIntArray.put(this.mAnimators.size(), (int)l2);
          l2 = Math.min(l2, l1);
        }
        localArrayMap.put(paramTransitionValuesMaps1, new AnimationInfo(localView, getName(), this, ViewUtils.getWindowId(paramViewGroup), (TransitionValues)localObject1));
        this.mAnimators.add(paramTransitionValuesMaps1);
        j = i;
      }
      i = j + 1;
      l1 = l2;
    }
    if (l1 != 0L)
    {
      i = 0;
      while (i < localSparseIntArray.size())
      {
        j = localSparseIntArray.keyAt(i);
        paramViewGroup = (Animator)this.mAnimators.get(j);
        paramViewGroup.setStartDelay(localSparseIntArray.valueAt(i) - l1 + paramViewGroup.getStartDelay());
        i += 1;
      }
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void end()
  {
    this.mNumInstances -= 1;
    if (this.mNumInstances == 0)
    {
      Object localObject;
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        localObject = (ArrayList)this.mListeners.clone();
        int j = ((ArrayList)localObject).size();
        i = 0;
        while (i < j)
        {
          ((TransitionListener)((ArrayList)localObject).get(i)).onTransitionEnd(this);
          i += 1;
        }
      }
      int i = 0;
      while (i < this.mStartValues.mItemIdValues.size())
      {
        localObject = (View)this.mStartValues.mItemIdValues.valueAt(i);
        if (localObject != null) {
          ViewCompat.setHasTransientState((View)localObject, false);
        }
        i += 1;
      }
      i = 0;
      while (i < this.mEndValues.mItemIdValues.size())
      {
        localObject = (View)this.mEndValues.mItemIdValues.valueAt(i);
        if (localObject != null) {
          ViewCompat.setHasTransientState((View)localObject, false);
        }
        i += 1;
      }
      this.mEnded = true;
    }
  }
  
  @NonNull
  public Transition excludeChildren(@IdRes int paramInt, boolean paramBoolean)
  {
    this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, paramInt, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeChildren(@NonNull View paramView, boolean paramBoolean)
  {
    this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, paramView, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeChildren(@NonNull Class paramClass, boolean paramBoolean)
  {
    this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, paramClass, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@IdRes int paramInt, boolean paramBoolean)
  {
    this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, paramInt, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull View paramView, boolean paramBoolean)
  {
    this.mTargetExcludes = excludeView(this.mTargetExcludes, paramView, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull Class paramClass, boolean paramBoolean)
  {
    this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, paramClass, paramBoolean);
    return this;
  }
  
  @NonNull
  public Transition excludeTarget(@NonNull String paramString, boolean paramBoolean)
  {
    this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, paramString, paramBoolean);
    return this;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  void forceToEnd(ViewGroup paramViewGroup)
  {
    ArrayMap localArrayMap = getRunningAnimators();
    int i = localArrayMap.size();
    if (paramViewGroup != null)
    {
      paramViewGroup = ViewUtils.getWindowId(paramViewGroup);
      i -= 1;
      while (i >= 0)
      {
        AnimationInfo localAnimationInfo = (AnimationInfo)localArrayMap.valueAt(i);
        if ((localAnimationInfo.mView != null) && (paramViewGroup != null) && (paramViewGroup.equals(localAnimationInfo.mWindowId))) {
          ((Animator)localArrayMap.keyAt(i)).end();
        }
        i -= 1;
      }
    }
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  @Nullable
  public Rect getEpicenter()
  {
    if (this.mEpicenterCallback == null) {
      return null;
    }
    return this.mEpicenterCallback.onGetEpicenter(this);
  }
  
  @Nullable
  public EpicenterCallback getEpicenterCallback()
  {
    return this.mEpicenterCallback;
  }
  
  @Nullable
  public TimeInterpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  TransitionValues getMatchedTransitionValues(View paramView, boolean paramBoolean)
  {
    if (this.mParent != null) {
      return this.mParent.getMatchedTransitionValues(paramView, paramBoolean);
    }
    ArrayList localArrayList;
    if (paramBoolean) {
      localArrayList = this.mStartValuesList;
    } else {
      localArrayList = this.mEndValuesList;
    }
    Object localObject = null;
    if (localArrayList == null) {
      return null;
    }
    int m = localArrayList.size();
    int k = -1;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      TransitionValues localTransitionValues = (TransitionValues)localArrayList.get(i);
      if (localTransitionValues == null) {
        return null;
      }
      if (localTransitionValues.view == paramView)
      {
        j = i;
        break;
      }
      i += 1;
    }
    paramView = (View)localObject;
    if (j >= 0)
    {
      if (paramBoolean) {
        paramView = this.mEndValuesList;
      } else {
        paramView = this.mStartValuesList;
      }
      paramView = (TransitionValues)paramView.get(j);
    }
    return paramView;
  }
  
  @NonNull
  public String getName()
  {
    return this.mName;
  }
  
  @NonNull
  public PathMotion getPathMotion()
  {
    return this.mPathMotion;
  }
  
  @Nullable
  public TransitionPropagation getPropagation()
  {
    return this.mPropagation;
  }
  
  public long getStartDelay()
  {
    return this.mStartDelay;
  }
  
  @NonNull
  public List<Integer> getTargetIds()
  {
    return this.mTargetIds;
  }
  
  @Nullable
  public List<String> getTargetNames()
  {
    return this.mTargetNames;
  }
  
  @Nullable
  public List<Class> getTargetTypes()
  {
    return this.mTargetTypes;
  }
  
  @NonNull
  public List<View> getTargets()
  {
    return this.mTargets;
  }
  
  @Nullable
  public String[] getTransitionProperties()
  {
    return null;
  }
  
  @Nullable
  public TransitionValues getTransitionValues(@NonNull View paramView, boolean paramBoolean)
  {
    if (this.mParent != null) {
      return this.mParent.getTransitionValues(paramView, paramBoolean);
    }
    TransitionValuesMaps localTransitionValuesMaps;
    if (paramBoolean) {
      localTransitionValuesMaps = this.mStartValues;
    } else {
      localTransitionValuesMaps = this.mEndValues;
    }
    return (TransitionValues)localTransitionValuesMaps.mViewValues.get(paramView);
  }
  
  public boolean isTransitionRequired(@Nullable TransitionValues paramTransitionValues1, @Nullable TransitionValues paramTransitionValues2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramTransitionValues1 != null)
    {
      bool1 = bool2;
      if (paramTransitionValues2 != null)
      {
        Object localObject = getTransitionProperties();
        if (localObject != null)
        {
          int j = localObject.length;
          int i = 0;
          for (;;)
          {
            bool1 = bool2;
            if (i >= j) {
              break label120;
            }
            if (isValueChanged(paramTransitionValues1, paramTransitionValues2, localObject[i])) {
              break;
            }
            i += 1;
          }
        }
        localObject = paramTransitionValues1.values.keySet().iterator();
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!isValueChanged(paramTransitionValues1, paramTransitionValues2, (String)((Iterator)localObject).next()));
        bool1 = true;
      }
    }
    label120:
    return bool1;
  }
  
  boolean isValidTarget(View paramView)
  {
    int j = paramView.getId();
    if ((this.mTargetIdExcludes != null) && (this.mTargetIdExcludes.contains(Integer.valueOf(j)))) {
      return false;
    }
    if ((this.mTargetExcludes != null) && (this.mTargetExcludes.contains(paramView))) {
      return false;
    }
    int i;
    if (this.mTargetTypeExcludes != null)
    {
      int k = this.mTargetTypeExcludes.size();
      i = 0;
      while (i < k)
      {
        if (((Class)this.mTargetTypeExcludes.get(i)).isInstance(paramView)) {
          return false;
        }
        i += 1;
      }
    }
    if ((this.mTargetNameExcludes != null) && (ViewCompat.getTransitionName(paramView) != null) && (this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(paramView)))) {
      return false;
    }
    if ((this.mTargetIds.size() == 0) && (this.mTargets.size() == 0) && ((this.mTargetTypes == null) || (this.mTargetTypes.isEmpty())) && ((this.mTargetNames == null) || (this.mTargetNames.isEmpty()))) {
      return true;
    }
    if (!this.mTargetIds.contains(Integer.valueOf(j)))
    {
      if (this.mTargets.contains(paramView)) {
        return true;
      }
      if ((this.mTargetNames != null) && (this.mTargetNames.contains(ViewCompat.getTransitionName(paramView)))) {
        return true;
      }
      if (this.mTargetTypes != null)
      {
        i = 0;
        while (i < this.mTargetTypes.size())
        {
          if (((Class)this.mTargetTypes.get(i)).isInstance(paramView)) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    return true;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void pause(View paramView)
  {
    if (!this.mEnded)
    {
      ArrayMap localArrayMap = getRunningAnimators();
      int i = localArrayMap.size();
      paramView = ViewUtils.getWindowId(paramView);
      i -= 1;
      while (i >= 0)
      {
        AnimationInfo localAnimationInfo = (AnimationInfo)localArrayMap.valueAt(i);
        if ((localAnimationInfo.mView != null) && (paramView.equals(localAnimationInfo.mWindowId))) {
          AnimatorUtils.pause((Animator)localArrayMap.keyAt(i));
        }
        i -= 1;
      }
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        paramView = (ArrayList)this.mListeners.clone();
        int j = paramView.size();
        i = 0;
        while (i < j)
        {
          ((TransitionListener)paramView.get(i)).onTransitionPause(this);
          i += 1;
        }
      }
      this.mPaused = true;
    }
  }
  
  void playTransition(ViewGroup paramViewGroup)
  {
    this.mStartValuesList = new ArrayList();
    this.mEndValuesList = new ArrayList();
    matchStartAndEnd(this.mStartValues, this.mEndValues);
    ArrayMap localArrayMap = getRunningAnimators();
    int i = localArrayMap.size();
    WindowIdImpl localWindowIdImpl = ViewUtils.getWindowId(paramViewGroup);
    i -= 1;
    while (i >= 0)
    {
      Animator localAnimator = (Animator)localArrayMap.keyAt(i);
      if (localAnimator != null)
      {
        AnimationInfo localAnimationInfo = (AnimationInfo)localArrayMap.get(localAnimator);
        if ((localAnimationInfo != null) && (localAnimationInfo.mView != null) && (localWindowIdImpl.equals(localAnimationInfo.mWindowId)))
        {
          TransitionValues localTransitionValues1 = localAnimationInfo.mValues;
          Object localObject = localAnimationInfo.mView;
          TransitionValues localTransitionValues2 = getTransitionValues((View)localObject, true);
          localObject = getMatchedTransitionValues((View)localObject, true);
          int j;
          if (((localTransitionValues2 != null) || (localObject != null)) && (localAnimationInfo.mTransition.isTransitionRequired(localTransitionValues1, (TransitionValues)localObject))) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0) {
            if ((!localAnimator.isRunning()) && (!localAnimator.isStarted())) {
              localArrayMap.remove(localAnimator);
            } else {
              localAnimator.cancel();
            }
          }
        }
      }
      i -= 1;
    }
    createAnimators(paramViewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
    runAnimators();
  }
  
  @NonNull
  public Transition removeListener(@NonNull TransitionListener paramTransitionListener)
  {
    if (this.mListeners == null) {
      return this;
    }
    this.mListeners.remove(paramTransitionListener);
    if (this.mListeners.size() == 0) {
      this.mListeners = null;
    }
    return this;
  }
  
  @NonNull
  public Transition removeTarget(@IdRes int paramInt)
  {
    if (paramInt != 0) {
      this.mTargetIds.remove(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  @NonNull
  public Transition removeTarget(@NonNull View paramView)
  {
    this.mTargets.remove(paramView);
    return this;
  }
  
  @NonNull
  public Transition removeTarget(@NonNull Class paramClass)
  {
    if (this.mTargetTypes != null) {
      this.mTargetTypes.remove(paramClass);
    }
    return this;
  }
  
  @NonNull
  public Transition removeTarget(@NonNull String paramString)
  {
    if (this.mTargetNames != null) {
      this.mTargetNames.remove(paramString);
    }
    return this;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void resume(View paramView)
  {
    if (this.mPaused)
    {
      if (!this.mEnded)
      {
        ArrayMap localArrayMap = getRunningAnimators();
        int i = localArrayMap.size();
        paramView = ViewUtils.getWindowId(paramView);
        i -= 1;
        while (i >= 0)
        {
          AnimationInfo localAnimationInfo = (AnimationInfo)localArrayMap.valueAt(i);
          if ((localAnimationInfo.mView != null) && (paramView.equals(localAnimationInfo.mWindowId))) {
            AnimatorUtils.resume((Animator)localArrayMap.keyAt(i));
          }
          i -= 1;
        }
        if ((this.mListeners != null) && (this.mListeners.size() > 0))
        {
          paramView = (ArrayList)this.mListeners.clone();
          int j = paramView.size();
          i = 0;
          while (i < j)
          {
            ((TransitionListener)paramView.get(i)).onTransitionResume(this);
            i += 1;
          }
        }
      }
      this.mPaused = false;
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void runAnimators()
  {
    start();
    ArrayMap localArrayMap = getRunningAnimators();
    Iterator localIterator = this.mAnimators.iterator();
    while (localIterator.hasNext())
    {
      Animator localAnimator = (Animator)localIterator.next();
      if (localArrayMap.containsKey(localAnimator))
      {
        start();
        runAnimator(localAnimator, localArrayMap);
      }
    }
    this.mAnimators.clear();
    end();
  }
  
  void setCanRemoveViews(boolean paramBoolean)
  {
    this.mCanRemoveViews = paramBoolean;
  }
  
  @NonNull
  public Transition setDuration(long paramLong)
  {
    this.mDuration = paramLong;
    return this;
  }
  
  public void setEpicenterCallback(@Nullable EpicenterCallback paramEpicenterCallback)
  {
    this.mEpicenterCallback = paramEpicenterCallback;
  }
  
  @NonNull
  public Transition setInterpolator(@Nullable TimeInterpolator paramTimeInterpolator)
  {
    this.mInterpolator = paramTimeInterpolator;
    return this;
  }
  
  public void setMatchOrder(int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      int i = 0;
      while (i < paramVarArgs.length) {
        if (isValidMatch(paramVarArgs[i]))
        {
          if (!alreadyContains(paramVarArgs, i)) {
            i += 1;
          } else {
            throw new IllegalArgumentException("matches contains a duplicate value");
          }
        }
        else {
          throw new IllegalArgumentException("matches contains invalid value");
        }
      }
      this.mMatchOrder = ((int[])paramVarArgs.clone());
      return;
    }
    this.mMatchOrder = DEFAULT_MATCH_ORDER;
  }
  
  public void setPathMotion(@Nullable PathMotion paramPathMotion)
  {
    if (paramPathMotion == null)
    {
      this.mPathMotion = STRAIGHT_PATH_MOTION;
      return;
    }
    this.mPathMotion = paramPathMotion;
  }
  
  public void setPropagation(@Nullable TransitionPropagation paramTransitionPropagation)
  {
    this.mPropagation = paramTransitionPropagation;
  }
  
  Transition setSceneRoot(ViewGroup paramViewGroup)
  {
    this.mSceneRoot = paramViewGroup;
    return this;
  }
  
  @NonNull
  public Transition setStartDelay(long paramLong)
  {
    this.mStartDelay = paramLong;
    return this;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void start()
  {
    if (this.mNumInstances == 0)
    {
      if ((this.mListeners != null) && (this.mListeners.size() > 0))
      {
        ArrayList localArrayList = (ArrayList)this.mListeners.clone();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((TransitionListener)localArrayList.get(i)).onTransitionStart(this);
          i += 1;
        }
      }
      this.mEnded = false;
    }
    this.mNumInstances += 1;
  }
  
  public String toString()
  {
    return toString("");
  }
  
  String toString(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append("@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    ((StringBuilder)localObject).append(": ");
    localObject = ((StringBuilder)localObject).toString();
    paramString = (String)localObject;
    if (this.mDuration != -1L)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("dur(");
      paramString.append(this.mDuration);
      paramString.append(") ");
      paramString = paramString.toString();
    }
    localObject = paramString;
    if (this.mStartDelay != -1L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("dly(");
      ((StringBuilder)localObject).append(this.mStartDelay);
      ((StringBuilder)localObject).append(") ");
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = (String)localObject;
    if (this.mInterpolator != null)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("interp(");
      paramString.append(this.mInterpolator);
      paramString.append(") ");
      paramString = paramString.toString();
    }
    if (this.mTargetIds.size() <= 0)
    {
      localObject = paramString;
      if (this.mTargets.size() <= 0) {}
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("tgts(");
      localObject = ((StringBuilder)localObject).toString();
      int i = this.mTargetIds.size();
      int j = 0;
      paramString = (String)localObject;
      if (i > 0)
      {
        paramString = (String)localObject;
        i = 0;
        while (i < this.mTargetIds.size())
        {
          localObject = paramString;
          if (i > 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(", ");
            localObject = ((StringBuilder)localObject).toString();
          }
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append(this.mTargetIds.get(i));
          paramString = paramString.toString();
          i += 1;
        }
      }
      localObject = paramString;
      if (this.mTargets.size() > 0)
      {
        i = j;
        for (;;)
        {
          localObject = paramString;
          if (i >= this.mTargets.size()) {
            break;
          }
          localObject = paramString;
          if (i > 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(", ");
            localObject = ((StringBuilder)localObject).toString();
          }
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append(this.mTargets.get(i));
          paramString = paramString.toString();
          i += 1;
        }
      }
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append(")");
      localObject = paramString.toString();
    }
    return (String)localObject;
  }
  
  private static class AnimationInfo
  {
    String mName;
    Transition mTransition;
    TransitionValues mValues;
    View mView;
    WindowIdImpl mWindowId;
    
    AnimationInfo(View paramView, String paramString, Transition paramTransition, WindowIdImpl paramWindowIdImpl, TransitionValues paramTransitionValues)
    {
      this.mView = paramView;
      this.mName = paramString;
      this.mValues = paramTransitionValues;
      this.mWindowId = paramWindowIdImpl;
      this.mTransition = paramTransition;
    }
  }
  
  private static class ArrayListManager
  {
    static <T> ArrayList<T> add(ArrayList<T> paramArrayList, T paramT)
    {
      Object localObject = paramArrayList;
      if (paramArrayList == null) {
        localObject = new ArrayList();
      }
      if (!((ArrayList)localObject).contains(paramT)) {
        ((ArrayList)localObject).add(paramT);
      }
      return (ArrayList<T>)localObject;
    }
    
    static <T> ArrayList<T> remove(ArrayList<T> paramArrayList, T paramT)
    {
      ArrayList<T> localArrayList = paramArrayList;
      if (paramArrayList != null)
      {
        paramArrayList.remove(paramT);
        localArrayList = paramArrayList;
        if (paramArrayList.isEmpty()) {
          localArrayList = null;
        }
      }
      return localArrayList;
    }
  }
  
  public static abstract class EpicenterCallback
  {
    public abstract Rect onGetEpicenter(@NonNull Transition paramTransition);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface MatchOrder {}
  
  public static abstract interface TransitionListener
  {
    public abstract void onTransitionCancel(@NonNull Transition paramTransition);
    
    public abstract void onTransitionEnd(@NonNull Transition paramTransition);
    
    public abstract void onTransitionPause(@NonNull Transition paramTransition);
    
    public abstract void onTransitionResume(@NonNull Transition paramTransition);
    
    public abstract void onTransitionStart(@NonNull Transition paramTransition);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\Transition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */