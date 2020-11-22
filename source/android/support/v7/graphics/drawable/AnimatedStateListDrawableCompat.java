package android.support.v7.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedStateListDrawableCompat
  extends StateListDrawable
{
  private static final String ELEMENT_ITEM = "item";
  private static final String ELEMENT_TRANSITION = "transition";
  private static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
  private static final String LOGTAG = "AnimatedStateListDrawableCompat";
  private static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
  private static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires 'fromId' & 'toId' attributes";
  private boolean mMutated;
  private AnimatedStateListState mState;
  private Transition mTransition;
  private int mTransitionFromIndex = -1;
  private int mTransitionToIndex = -1;
  
  public AnimatedStateListDrawableCompat()
  {
    this(null, null);
  }
  
  AnimatedStateListDrawableCompat(@Nullable AnimatedStateListState paramAnimatedStateListState, @Nullable Resources paramResources)
  {
    super(null);
    setConstantState(new AnimatedStateListState(paramAnimatedStateListState, this, paramResources));
    onStateChange(getState());
    jumpToCurrentState();
  }
  
  @Nullable
  public static AnimatedStateListDrawableCompat create(@NonNull Context paramContext, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    try
    {
      Resources localResources = paramContext.getResources();
      XmlResourceParser localXmlResourceParser = localResources.getXml(paramInt);
      AttributeSet localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
      do
      {
        paramInt = localXmlResourceParser.next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt == 2) {
        return createFromXmlInner(paramContext, localResources, localXmlResourceParser, localAttributeSet, paramTheme);
      }
      throw new XmlPullParserException("No start tag found");
    }
    catch (IOException paramContext)
    {
      Log.e(LOGTAG, "parser error", paramContext);
    }
    catch (XmlPullParserException paramContext)
    {
      Log.e(LOGTAG, "parser error", paramContext);
    }
    return null;
  }
  
  public static AnimatedStateListDrawableCompat createFromXmlInner(@NonNull Context paramContext, @NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    throws IOException, XmlPullParserException
  {
    Object localObject = paramXmlPullParser.getName();
    if (((String)localObject).equals("animated-selector"))
    {
      localObject = new AnimatedStateListDrawableCompat();
      ((AnimatedStateListDrawableCompat)localObject).inflate(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return (AnimatedStateListDrawableCompat)localObject;
    }
    paramContext = new StringBuilder();
    paramContext.append(paramXmlPullParser.getPositionDescription());
    paramContext.append(": invalid animated-selector tag ");
    paramContext.append((String)localObject);
    throw new XmlPullParserException(paramContext.toString());
  }
  
  private void inflateChildElements(@NonNull Context paramContext, @NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getDepth() + 1;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (j == 1) {
        break;
      }
      int k = paramXmlPullParser.getDepth();
      if ((k < i) && (j == 3)) {
        break;
      }
      if ((j == 2) && (k <= i)) {
        if (paramXmlPullParser.getName().equals("item")) {
          parseItem(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        } else if (paramXmlPullParser.getName().equals("transition")) {
          parseTransition(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        }
      }
    }
  }
  
  private void init()
  {
    onStateChange(getState());
  }
  
  private int parseItem(@NonNull Context paramContext, @NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    Object localObject = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableItem);
    int i = ((TypedArray)localObject).getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
    int j = ((TypedArray)localObject).getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
    Drawable localDrawable;
    if (j > 0) {
      localDrawable = AppCompatResources.getDrawable(paramContext, j);
    } else {
      localDrawable = null;
    }
    ((TypedArray)localObject).recycle();
    localObject = extractStateSet(paramAttributeSet);
    paramContext = localDrawable;
    if (localDrawable == null)
    {
      do
      {
        j = paramXmlPullParser.next();
      } while (j == 4);
      if (j == 2)
      {
        if (paramXmlPullParser.getName().equals("vector")) {
          paramContext = VectorDrawableCompat.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        } else if (Build.VERSION.SDK_INT >= 21) {
          paramContext = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        } else {
          paramContext = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
        }
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append(paramXmlPullParser.getPositionDescription());
        paramContext.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(paramContext.toString());
      }
    }
    if (paramContext != null) {
      return this.mState.addStateSet((int[])localObject, paramContext, i);
    }
    paramContext = new StringBuilder();
    paramContext.append(paramXmlPullParser.getPositionDescription());
    paramContext.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    throw new XmlPullParserException(paramContext.toString());
  }
  
  private int parseTransition(@NonNull Context paramContext, @NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    Object localObject = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableTransition);
    int i = ((TypedArray)localObject).getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
    int j = ((TypedArray)localObject).getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
    int k = ((TypedArray)localObject).getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
    Drawable localDrawable;
    if (k > 0) {
      localDrawable = AppCompatResources.getDrawable(paramContext, k);
    } else {
      localDrawable = null;
    }
    boolean bool = ((TypedArray)localObject).getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
    ((TypedArray)localObject).recycle();
    localObject = localDrawable;
    if (localDrawable == null)
    {
      do
      {
        k = paramXmlPullParser.next();
      } while (k == 4);
      if (k == 2)
      {
        if (paramXmlPullParser.getName().equals("animated-vector")) {
          localObject = AnimatedVectorDrawableCompat.createFromXmlInner(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        } else if (Build.VERSION.SDK_INT >= 21) {
          localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
        } else {
          localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
        }
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append(paramXmlPullParser.getPositionDescription());
        paramContext.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(paramContext.toString());
      }
    }
    if (localObject != null)
    {
      if ((i != -1) && (j != -1)) {
        return this.mState.addTransition(i, j, (Drawable)localObject, bool);
      }
      paramContext = new StringBuilder();
      paramContext.append(paramXmlPullParser.getPositionDescription());
      paramContext.append(": <transition> tag requires 'fromId' & 'toId' attributes");
      throw new XmlPullParserException(paramContext.toString());
    }
    paramContext = new StringBuilder();
    paramContext.append(paramXmlPullParser.getPositionDescription());
    paramContext.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
    throw new XmlPullParserException(paramContext.toString());
  }
  
  private boolean selectTransition(int paramInt)
  {
    Object localObject = this.mTransition;
    int i;
    if (localObject != null)
    {
      if (paramInt == this.mTransitionToIndex) {
        return true;
      }
      if ((paramInt == this.mTransitionFromIndex) && (((Transition)localObject).canReverse()))
      {
        ((Transition)localObject).reverse();
        this.mTransitionToIndex = this.mTransitionFromIndex;
        this.mTransitionFromIndex = paramInt;
        return true;
      }
      i = this.mTransitionToIndex;
      ((Transition)localObject).stop();
    }
    else
    {
      i = getCurrentIndex();
    }
    this.mTransition = null;
    this.mTransitionFromIndex = -1;
    this.mTransitionToIndex = -1;
    localObject = this.mState;
    int j = ((AnimatedStateListState)localObject).getKeyframeIdAt(i);
    int k = ((AnimatedStateListState)localObject).getKeyframeIdAt(paramInt);
    if (k != 0)
    {
      if (j == 0) {
        return false;
      }
      int m = ((AnimatedStateListState)localObject).indexOfTransition(j, k);
      if (m < 0) {
        return false;
      }
      boolean bool1 = ((AnimatedStateListState)localObject).transitionHasReversibleFlag(j, k);
      selectDrawable(m);
      Drawable localDrawable = getCurrent();
      if ((localDrawable instanceof AnimationDrawable))
      {
        boolean bool2 = ((AnimatedStateListState)localObject).isTransitionReversed(j, k);
        localObject = new AnimationDrawableTransition((AnimationDrawable)localDrawable, bool2, bool1);
      }
      else if ((localDrawable instanceof AnimatedVectorDrawableCompat))
      {
        localObject = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat)localDrawable);
      }
      else
      {
        if (!(localDrawable instanceof Animatable)) {
          break label271;
        }
        localObject = new AnimatableTransition((Animatable)localDrawable);
      }
      ((Transition)localObject).start();
      this.mTransition = ((Transition)localObject);
      this.mTransitionFromIndex = i;
      this.mTransitionToIndex = paramInt;
      return true;
      label271:
      return false;
    }
    return false;
  }
  
  private void updateStateFromTypedArray(TypedArray paramTypedArray)
  {
    AnimatedStateListState localAnimatedStateListState = this.mState;
    if (Build.VERSION.SDK_INT >= 21) {
      localAnimatedStateListState.mChangingConfigurations |= paramTypedArray.getChangingConfigurations();
    }
    localAnimatedStateListState.setVariablePadding(paramTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, localAnimatedStateListState.mVariablePadding));
    localAnimatedStateListState.setConstantSize(paramTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, localAnimatedStateListState.mConstantSize));
    localAnimatedStateListState.setEnterFadeDuration(paramTypedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, localAnimatedStateListState.mEnterFadeDuration));
    localAnimatedStateListState.setExitFadeDuration(paramTypedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, localAnimatedStateListState.mExitFadeDuration));
    setDither(paramTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, localAnimatedStateListState.mDither));
  }
  
  public void addState(@NonNull int[] paramArrayOfInt, @NonNull Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable != null)
    {
      this.mState.addStateSet(paramArrayOfInt, paramDrawable, paramInt);
      onStateChange(getState());
      return;
    }
    throw new IllegalArgumentException("Drawable must not be null");
  }
  
  public <T extends Drawable,  extends Animatable> void addTransition(int paramInt1, int paramInt2, @NonNull T paramT, boolean paramBoolean)
  {
    if (paramT != null)
    {
      this.mState.addTransition(paramInt1, paramInt2, paramT, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Transition drawable must not be null");
  }
  
  void clearMutated()
  {
    super.clearMutated();
    this.mMutated = false;
  }
  
  AnimatedStateListState cloneConstantState()
  {
    return new AnimatedStateListState(this.mState, this, null);
  }
  
  public void inflate(@NonNull Context paramContext, @NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.AnimatedStateListDrawableCompat);
    setVisible(localTypedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
    updateStateFromTypedArray(localTypedArray);
    updateDensity(paramResources);
    localTypedArray.recycle();
    inflateChildElements(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    init();
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public void jumpToCurrentState()
  {
    super.jumpToCurrentState();
    if (this.mTransition != null)
    {
      this.mTransition.stop();
      this.mTransition = null;
      selectDrawable(this.mTransitionToIndex);
      this.mTransitionToIndex = -1;
      this.mTransitionFromIndex = -1;
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      this.mState.mutate();
      this.mMutated = true;
    }
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.mState.indexOfKeyframe(paramArrayOfInt);
    boolean bool1;
    if ((i != getCurrentIndex()) && ((selectTransition(i)) || (selectDrawable(i)))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Drawable localDrawable = getCurrent();
    boolean bool2 = bool1;
    if (localDrawable != null) {
      bool2 = bool1 | localDrawable.setState(paramArrayOfInt);
    }
    return bool2;
  }
  
  protected void setConstantState(@NonNull DrawableContainer.DrawableContainerState paramDrawableContainerState)
  {
    super.setConstantState(paramDrawableContainerState);
    if ((paramDrawableContainerState instanceof AnimatedStateListState)) {
      this.mState = ((AnimatedStateListState)paramDrawableContainerState);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if ((this.mTransition != null) && ((bool) || (paramBoolean2)))
    {
      if (paramBoolean1)
      {
        this.mTransition.start();
        return bool;
      }
      jumpToCurrentState();
    }
    return bool;
  }
  
  private static class AnimatableTransition
    extends AnimatedStateListDrawableCompat.Transition
  {
    private final Animatable mA;
    
    AnimatableTransition(Animatable paramAnimatable)
    {
      super();
      this.mA = paramAnimatable;
    }
    
    public void start()
    {
      this.mA.start();
    }
    
    public void stop()
    {
      this.mA.stop();
    }
  }
  
  static class AnimatedStateListState
    extends StateListDrawable.StateListState
  {
    private static final long REVERSED_BIT = 4294967296L;
    private static final long REVERSIBLE_FLAG_BIT = 8589934592L;
    SparseArrayCompat<Integer> mStateIds;
    LongSparseArray<Long> mTransitions;
    
    AnimatedStateListState(@Nullable AnimatedStateListState paramAnimatedStateListState, @NonNull AnimatedStateListDrawableCompat paramAnimatedStateListDrawableCompat, @Nullable Resources paramResources)
    {
      super(paramAnimatedStateListDrawableCompat, paramResources);
      if (paramAnimatedStateListState != null)
      {
        this.mTransitions = paramAnimatedStateListState.mTransitions;
        this.mStateIds = paramAnimatedStateListState.mStateIds;
        return;
      }
      this.mTransitions = new LongSparseArray();
      this.mStateIds = new SparseArrayCompat();
    }
    
    private static long generateTransitionKey(int paramInt1, int paramInt2)
    {
      long l = paramInt1;
      return paramInt2 | l << 32;
    }
    
    int addStateSet(@NonNull int[] paramArrayOfInt, @NonNull Drawable paramDrawable, int paramInt)
    {
      int i = super.addStateSet(paramArrayOfInt, paramDrawable);
      this.mStateIds.put(i, Integer.valueOf(paramInt));
      return i;
    }
    
    int addTransition(int paramInt1, int paramInt2, @NonNull Drawable paramDrawable, boolean paramBoolean)
    {
      int i = super.addChild(paramDrawable);
      long l2 = generateTransitionKey(paramInt1, paramInt2);
      long l1;
      if (paramBoolean) {
        l1 = 8589934592L;
      } else {
        l1 = 0L;
      }
      paramDrawable = this.mTransitions;
      long l3 = i;
      paramDrawable.append(l2, Long.valueOf(l3 | l1));
      if (paramBoolean)
      {
        l2 = generateTransitionKey(paramInt2, paramInt1);
        this.mTransitions.append(l2, Long.valueOf(0x100000000 | l3 | l1));
      }
      return i;
    }
    
    int getKeyframeIdAt(int paramInt)
    {
      if (paramInt < 0) {
        return 0;
      }
      return ((Integer)this.mStateIds.get(paramInt, Integer.valueOf(0))).intValue();
    }
    
    int indexOfKeyframe(@NonNull int[] paramArrayOfInt)
    {
      int i = super.indexOfStateSet(paramArrayOfInt);
      if (i >= 0) {
        return i;
      }
      return super.indexOfStateSet(StateSet.WILD_CARD);
    }
    
    int indexOfTransition(int paramInt1, int paramInt2)
    {
      long l = generateTransitionKey(paramInt1, paramInt2);
      return (int)((Long)this.mTransitions.get(l, Long.valueOf(-1L))).longValue();
    }
    
    boolean isTransitionReversed(int paramInt1, int paramInt2)
    {
      long l = generateTransitionKey(paramInt1, paramInt2);
      return (((Long)this.mTransitions.get(l, Long.valueOf(-1L))).longValue() & 0x100000000) != 0L;
    }
    
    void mutate()
    {
      this.mTransitions = this.mTransitions.clone();
      this.mStateIds = this.mStateIds.clone();
    }
    
    @NonNull
    public Drawable newDrawable()
    {
      return new AnimatedStateListDrawableCompat(this, null);
    }
    
    @NonNull
    public Drawable newDrawable(Resources paramResources)
    {
      return new AnimatedStateListDrawableCompat(this, paramResources);
    }
    
    boolean transitionHasReversibleFlag(int paramInt1, int paramInt2)
    {
      long l = generateTransitionKey(paramInt1, paramInt2);
      return (((Long)this.mTransitions.get(l, Long.valueOf(-1L))).longValue() & 0x200000000) != 0L;
    }
  }
  
  private static class AnimatedVectorDrawableTransition
    extends AnimatedStateListDrawableCompat.Transition
  {
    private final AnimatedVectorDrawableCompat mAvd;
    
    AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat paramAnimatedVectorDrawableCompat)
    {
      super();
      this.mAvd = paramAnimatedVectorDrawableCompat;
    }
    
    public void start()
    {
      this.mAvd.start();
    }
    
    public void stop()
    {
      this.mAvd.stop();
    }
  }
  
  private static class AnimationDrawableTransition
    extends AnimatedStateListDrawableCompat.Transition
  {
    private final ObjectAnimator mAnim;
    private final boolean mHasReversibleFlag;
    
    AnimationDrawableTransition(AnimationDrawable paramAnimationDrawable, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
      int j = paramAnimationDrawable.getNumberOfFrames();
      int i;
      if (paramBoolean1) {
        i = j - 1;
      } else {
        i = 0;
      }
      if (paramBoolean1) {
        j = 0;
      } else {
        j -= 1;
      }
      AnimatedStateListDrawableCompat.FrameInterpolator localFrameInterpolator = new AnimatedStateListDrawableCompat.FrameInterpolator(paramAnimationDrawable, paramBoolean1);
      paramAnimationDrawable = ObjectAnimator.ofInt(paramAnimationDrawable, "currentIndex", new int[] { i, j });
      if (Build.VERSION.SDK_INT >= 18) {
        paramAnimationDrawable.setAutoCancel(true);
      }
      paramAnimationDrawable.setDuration(localFrameInterpolator.getTotalDuration());
      paramAnimationDrawable.setInterpolator(localFrameInterpolator);
      this.mHasReversibleFlag = paramBoolean2;
      this.mAnim = paramAnimationDrawable;
    }
    
    public boolean canReverse()
    {
      return this.mHasReversibleFlag;
    }
    
    public void reverse()
    {
      this.mAnim.reverse();
    }
    
    public void start()
    {
      this.mAnim.start();
    }
    
    public void stop()
    {
      this.mAnim.cancel();
    }
  }
  
  private static class FrameInterpolator
    implements TimeInterpolator
  {
    private int[] mFrameTimes;
    private int mFrames;
    private int mTotalDuration;
    
    FrameInterpolator(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
    {
      updateFrames(paramAnimationDrawable, paramBoolean);
    }
    
    public float getInterpolation(float paramFloat)
    {
      int j = (int)(paramFloat * this.mTotalDuration + 0.5F);
      int k = this.mFrames;
      int[] arrayOfInt = this.mFrameTimes;
      int i = 0;
      while ((i < k) && (j >= arrayOfInt[i]))
      {
        j -= arrayOfInt[i];
        i += 1;
      }
      if (i < k) {
        paramFloat = j / this.mTotalDuration;
      } else {
        paramFloat = 0.0F;
      }
      return i / k + paramFloat;
    }
    
    int getTotalDuration()
    {
      return this.mTotalDuration;
    }
    
    int updateFrames(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
    {
      int m = paramAnimationDrawable.getNumberOfFrames();
      this.mFrames = m;
      if ((this.mFrameTimes == null) || (this.mFrameTimes.length < m)) {
        this.mFrameTimes = new int[m];
      }
      int[] arrayOfInt = this.mFrameTimes;
      int i = 0;
      int j = 0;
      while (i < m)
      {
        if (paramBoolean) {
          k = m - i - 1;
        } else {
          k = i;
        }
        int k = paramAnimationDrawable.getDuration(k);
        arrayOfInt[i] = k;
        j += k;
        i += 1;
      }
      this.mTotalDuration = j;
      return j;
    }
  }
  
  private static abstract class Transition
  {
    public boolean canReverse()
    {
      return false;
    }
    
    public void reverse() {}
    
    public abstract void start();
    
    public abstract void stop();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\graphics\drawable\AnimatedStateListDrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */