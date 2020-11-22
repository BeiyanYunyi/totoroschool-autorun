package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform
  extends Transition
{
  private static final Property<PathAnimatorMatrix, float[]> NON_TRANSLATIONS_PROPERTY;
  private static final String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
  private static final String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
  private static final String PROPNAME_MATRIX = "android:changeTransform:matrix";
  private static final String PROPNAME_PARENT = "android:changeTransform:parent";
  private static final String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
  private static final String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
  private static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION;
  private static final Property<PathAnimatorMatrix, PointF> TRANSLATIONS_PROPERTY;
  private static final String[] sTransitionProperties = { "android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix" };
  private boolean mReparent = true;
  private Matrix mTempMatrix = new Matrix();
  boolean mUseOverlay = true;
  
  static
  {
    NON_TRANSLATIONS_PROPERTY = new Property(float[].class, "nonTranslations")
    {
      public float[] get(ChangeTransform.PathAnimatorMatrix paramAnonymousPathAnimatorMatrix)
      {
        return null;
      }
      
      public void set(ChangeTransform.PathAnimatorMatrix paramAnonymousPathAnimatorMatrix, float[] paramAnonymousArrayOfFloat)
      {
        paramAnonymousPathAnimatorMatrix.setValues(paramAnonymousArrayOfFloat);
      }
    };
    TRANSLATIONS_PROPERTY = new Property(PointF.class, "translations")
    {
      public PointF get(ChangeTransform.PathAnimatorMatrix paramAnonymousPathAnimatorMatrix)
      {
        return null;
      }
      
      public void set(ChangeTransform.PathAnimatorMatrix paramAnonymousPathAnimatorMatrix, PointF paramAnonymousPointF)
      {
        paramAnonymousPathAnimatorMatrix.setTranslation(paramAnonymousPointF);
      }
    };
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    SUPPORTS_VIEW_REMOVAL_SUPPRESSION = bool;
  }
  
  public ChangeTransform() {}
  
  public ChangeTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.CHANGE_TRANSFORM);
    paramAttributeSet = (XmlPullParser)paramAttributeSet;
    this.mUseOverlay = TypedArrayUtils.getNamedBoolean(paramContext, paramAttributeSet, "reparentWithOverlay", 1, true);
    this.mReparent = TypedArrayUtils.getNamedBoolean(paramContext, paramAttributeSet, "reparent", 0, true);
    paramContext.recycle();
  }
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    View localView = paramTransitionValues.view;
    if (localView.getVisibility() == 8) {
      return;
    }
    paramTransitionValues.values.put("android:changeTransform:parent", localView.getParent());
    Object localObject = new Transforms(localView);
    paramTransitionValues.values.put("android:changeTransform:transforms", localObject);
    localObject = localView.getMatrix();
    if ((localObject != null) && (!((Matrix)localObject).isIdentity())) {
      localObject = new Matrix((Matrix)localObject);
    } else {
      localObject = null;
    }
    paramTransitionValues.values.put("android:changeTransform:matrix", localObject);
    if (this.mReparent)
    {
      localObject = new Matrix();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      ViewUtils.transformMatrixToGlobal(localViewGroup, (Matrix)localObject);
      ((Matrix)localObject).preTranslate(-localViewGroup.getScrollX(), -localViewGroup.getScrollY());
      paramTransitionValues.values.put("android:changeTransform:parentMatrix", localObject);
      paramTransitionValues.values.put("android:changeTransform:intermediateMatrix", localView.getTag(R.id.transition_transform));
      paramTransitionValues.values.put("android:changeTransform:intermediateParentMatrix", localView.getTag(R.id.parent_matrix));
    }
  }
  
  private void createGhostView(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    View localView = paramTransitionValues2.view;
    Object localObject = new Matrix((Matrix)paramTransitionValues2.values.get("android:changeTransform:parentMatrix"));
    ViewUtils.transformMatrixToLocal(paramViewGroup, (Matrix)localObject);
    localObject = GhostViewUtils.addGhost(localView, paramViewGroup, (Matrix)localObject);
    if (localObject == null) {
      return;
    }
    ((GhostViewImpl)localObject).reserveEndViewTransition((ViewGroup)paramTransitionValues1.values.get("android:changeTransform:parent"), paramTransitionValues1.view);
    for (paramViewGroup = this; paramViewGroup.mParent != null; paramViewGroup = paramViewGroup.mParent) {}
    paramViewGroup.addListener(new GhostListener(localView, (GhostViewImpl)localObject));
    if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION)
    {
      if (paramTransitionValues1.view != paramTransitionValues2.view) {
        ViewUtils.setTransitionAlpha(paramTransitionValues1.view, 0.0F);
      }
      ViewUtils.setTransitionAlpha(localView, 1.0F);
    }
  }
  
  private ObjectAnimator createTransformAnimator(final TransitionValues paramTransitionValues1, final TransitionValues paramTransitionValues2, final boolean paramBoolean)
  {
    paramTransitionValues1 = (Matrix)paramTransitionValues1.values.get("android:changeTransform:matrix");
    final Object localObject2 = (Matrix)paramTransitionValues2.values.get("android:changeTransform:matrix");
    final Object localObject1 = paramTransitionValues1;
    if (paramTransitionValues1 == null) {
      localObject1 = MatrixUtils.IDENTITY_MATRIX;
    }
    paramTransitionValues1 = (TransitionValues)localObject2;
    if (localObject2 == null) {
      paramTransitionValues1 = MatrixUtils.IDENTITY_MATRIX;
    }
    if (((Matrix)localObject1).equals(paramTransitionValues1)) {
      return null;
    }
    localObject2 = (Transforms)paramTransitionValues2.values.get("android:changeTransform:transforms");
    paramTransitionValues2 = paramTransitionValues2.view;
    setIdentityTransforms(paramTransitionValues2);
    Object localObject3 = new float[9];
    ((Matrix)localObject1).getValues((float[])localObject3);
    float[] arrayOfFloat = new float[9];
    paramTransitionValues1.getValues(arrayOfFloat);
    localObject1 = new PathAnimatorMatrix(paramTransitionValues2, (float[])localObject3);
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, new FloatArrayEvaluator(new float[9]), new float[][] { localObject3, arrayOfFloat });
    localObject3 = getPathMotion().getPath(localObject3[2], localObject3[5], arrayOfFloat[2], arrayOfFloat[5]);
    localObject3 = ObjectAnimator.ofPropertyValuesHolder(localObject1, new PropertyValuesHolder[] { localPropertyValuesHolder, PropertyValuesHolderUtils.ofPointF(TRANSLATIONS_PROPERTY, (Path)localObject3) });
    paramTransitionValues1 = new AnimatorListenerAdapter()
    {
      private boolean mIsCanceled;
      private Matrix mTempMatrix = new Matrix();
      
      private void setCurrentMatrix(Matrix paramAnonymousMatrix)
      {
        this.mTempMatrix.set(paramAnonymousMatrix);
        paramTransitionValues2.setTag(R.id.transition_transform, this.mTempMatrix);
        localObject2.restore(paramTransitionValues2);
      }
      
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        this.mIsCanceled = true;
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (!this.mIsCanceled) {
          if ((paramBoolean) && (ChangeTransform.this.mUseOverlay))
          {
            setCurrentMatrix(paramTransitionValues1);
          }
          else
          {
            paramTransitionValues2.setTag(R.id.transition_transform, null);
            paramTransitionValues2.setTag(R.id.parent_matrix, null);
          }
        }
        ViewUtils.setAnimationMatrix(paramTransitionValues2, null);
        localObject2.restore(paramTransitionValues2);
      }
      
      public void onAnimationPause(Animator paramAnonymousAnimator)
      {
        setCurrentMatrix(localObject1.getMatrix());
      }
      
      public void onAnimationResume(Animator paramAnonymousAnimator)
      {
        ChangeTransform.setIdentityTransforms(paramTransitionValues2);
      }
    };
    ((ObjectAnimator)localObject3).addListener(paramTransitionValues1);
    AnimatorUtils.addPauseListener((Animator)localObject3, paramTransitionValues1);
    return (ObjectAnimator)localObject3;
  }
  
  private boolean parentsMatch(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    if ((isValidTarget(paramViewGroup1)) && (isValidTarget(paramViewGroup2)))
    {
      paramViewGroup1 = getMatchedTransitionValues(paramViewGroup1, true);
      if ((paramViewGroup1 == null) || (paramViewGroup2 != paramViewGroup1.view)) {}
    }
    else
    {
      while (paramViewGroup1 == paramViewGroup2) {
        return true;
      }
    }
    return false;
  }
  
  static void setIdentityTransforms(View paramView)
  {
    setTransforms(paramView, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
  }
  
  private void setMatricesForParent(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    Matrix localMatrix1 = (Matrix)paramTransitionValues2.values.get("android:changeTransform:parentMatrix");
    paramTransitionValues2.view.setTag(R.id.parent_matrix, localMatrix1);
    Matrix localMatrix2 = this.mTempMatrix;
    localMatrix2.reset();
    localMatrix1.invert(localMatrix2);
    localMatrix1 = (Matrix)paramTransitionValues1.values.get("android:changeTransform:matrix");
    paramTransitionValues2 = localMatrix1;
    if (localMatrix1 == null)
    {
      paramTransitionValues2 = new Matrix();
      paramTransitionValues1.values.put("android:changeTransform:matrix", paramTransitionValues2);
    }
    paramTransitionValues2.postConcat((Matrix)paramTransitionValues1.values.get("android:changeTransform:parentMatrix"));
    paramTransitionValues2.postConcat(localMatrix2);
  }
  
  static void setTransforms(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    ViewCompat.setTranslationZ(paramView, paramFloat3);
    paramView.setScaleX(paramFloat4);
    paramView.setScaleY(paramFloat5);
    paramView.setRotationX(paramFloat6);
    paramView.setRotationY(paramFloat7);
    paramView.setRotation(paramFloat8);
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
    if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
      ((ViewGroup)paramTransitionValues.view.getParent()).startViewTransition(paramTransitionValues.view);
    }
  }
  
  public Animator createAnimator(@NonNull ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if ((paramTransitionValues1 != null) && (paramTransitionValues2 != null) && (paramTransitionValues1.values.containsKey("android:changeTransform:parent")) && (paramTransitionValues2.values.containsKey("android:changeTransform:parent")))
    {
      ViewGroup localViewGroup = (ViewGroup)paramTransitionValues1.values.get("android:changeTransform:parent");
      Object localObject = (ViewGroup)paramTransitionValues2.values.get("android:changeTransform:parent");
      boolean bool;
      if ((this.mReparent) && (!parentsMatch(localViewGroup, (ViewGroup)localObject))) {
        bool = true;
      } else {
        bool = false;
      }
      localObject = (Matrix)paramTransitionValues1.values.get("android:changeTransform:intermediateMatrix");
      if (localObject != null) {
        paramTransitionValues1.values.put("android:changeTransform:matrix", localObject);
      }
      localObject = (Matrix)paramTransitionValues1.values.get("android:changeTransform:intermediateParentMatrix");
      if (localObject != null) {
        paramTransitionValues1.values.put("android:changeTransform:parentMatrix", localObject);
      }
      if (bool) {
        setMatricesForParent(paramTransitionValues1, paramTransitionValues2);
      }
      localObject = createTransformAnimator(paramTransitionValues1, paramTransitionValues2, bool);
      if ((bool) && (localObject != null) && (this.mUseOverlay))
      {
        createGhostView(paramViewGroup, paramTransitionValues1, paramTransitionValues2);
        return (Animator)localObject;
      }
      if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
        localViewGroup.endViewTransition(paramTransitionValues1.view);
      }
      return (Animator)localObject;
    }
    return null;
  }
  
  public boolean getReparent()
  {
    return this.mReparent;
  }
  
  public boolean getReparentWithOverlay()
  {
    return this.mUseOverlay;
  }
  
  public String[] getTransitionProperties()
  {
    return sTransitionProperties;
  }
  
  public void setReparent(boolean paramBoolean)
  {
    this.mReparent = paramBoolean;
  }
  
  public void setReparentWithOverlay(boolean paramBoolean)
  {
    this.mUseOverlay = paramBoolean;
  }
  
  private static class GhostListener
    extends TransitionListenerAdapter
  {
    private GhostViewImpl mGhostView;
    private View mView;
    
    GhostListener(View paramView, GhostViewImpl paramGhostViewImpl)
    {
      this.mView = paramView;
      this.mGhostView = paramGhostViewImpl;
    }
    
    public void onTransitionEnd(@NonNull Transition paramTransition)
    {
      paramTransition.removeListener(this);
      GhostViewUtils.removeGhost(this.mView);
      this.mView.setTag(R.id.transition_transform, null);
      this.mView.setTag(R.id.parent_matrix, null);
    }
    
    public void onTransitionPause(@NonNull Transition paramTransition)
    {
      this.mGhostView.setVisibility(4);
    }
    
    public void onTransitionResume(@NonNull Transition paramTransition)
    {
      this.mGhostView.setVisibility(0);
    }
  }
  
  private static class PathAnimatorMatrix
  {
    private final Matrix mMatrix = new Matrix();
    private float mTranslationX;
    private float mTranslationY;
    private final float[] mValues;
    private final View mView;
    
    PathAnimatorMatrix(View paramView, float[] paramArrayOfFloat)
    {
      this.mView = paramView;
      this.mValues = ((float[])paramArrayOfFloat.clone());
      this.mTranslationX = this.mValues[2];
      this.mTranslationY = this.mValues[5];
      setAnimationMatrix();
    }
    
    private void setAnimationMatrix()
    {
      this.mValues[2] = this.mTranslationX;
      this.mValues[5] = this.mTranslationY;
      this.mMatrix.setValues(this.mValues);
      ViewUtils.setAnimationMatrix(this.mView, this.mMatrix);
    }
    
    Matrix getMatrix()
    {
      return this.mMatrix;
    }
    
    void setTranslation(PointF paramPointF)
    {
      this.mTranslationX = paramPointF.x;
      this.mTranslationY = paramPointF.y;
      setAnimationMatrix();
    }
    
    void setValues(float[] paramArrayOfFloat)
    {
      System.arraycopy(paramArrayOfFloat, 0, this.mValues, 0, paramArrayOfFloat.length);
      setAnimationMatrix();
    }
  }
  
  private static class Transforms
  {
    final float mRotationX;
    final float mRotationY;
    final float mRotationZ;
    final float mScaleX;
    final float mScaleY;
    final float mTranslationX;
    final float mTranslationY;
    final float mTranslationZ;
    
    Transforms(View paramView)
    {
      this.mTranslationX = paramView.getTranslationX();
      this.mTranslationY = paramView.getTranslationY();
      this.mTranslationZ = ViewCompat.getTranslationZ(paramView);
      this.mScaleX = paramView.getScaleX();
      this.mScaleY = paramView.getScaleY();
      this.mRotationX = paramView.getRotationX();
      this.mRotationY = paramView.getRotationY();
      this.mRotationZ = paramView.getRotation();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof Transforms;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      paramObject = (Transforms)paramObject;
      bool1 = bool2;
      if (((Transforms)paramObject).mTranslationX == this.mTranslationX)
      {
        bool1 = bool2;
        if (((Transforms)paramObject).mTranslationY == this.mTranslationY)
        {
          bool1 = bool2;
          if (((Transforms)paramObject).mTranslationZ == this.mTranslationZ)
          {
            bool1 = bool2;
            if (((Transforms)paramObject).mScaleX == this.mScaleX)
            {
              bool1 = bool2;
              if (((Transforms)paramObject).mScaleY == this.mScaleY)
              {
                bool1 = bool2;
                if (((Transforms)paramObject).mRotationX == this.mRotationX)
                {
                  bool1 = bool2;
                  if (((Transforms)paramObject).mRotationY == this.mRotationY)
                  {
                    bool1 = bool2;
                    if (((Transforms)paramObject).mRotationZ == this.mRotationZ) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      float f = this.mTranslationX;
      int i3 = 0;
      int i;
      if (f != 0.0F) {
        i = Float.floatToIntBits(this.mTranslationX);
      } else {
        i = 0;
      }
      int j;
      if (this.mTranslationY != 0.0F) {
        j = Float.floatToIntBits(this.mTranslationY);
      } else {
        j = 0;
      }
      int k;
      if (this.mTranslationZ != 0.0F) {
        k = Float.floatToIntBits(this.mTranslationZ);
      } else {
        k = 0;
      }
      int m;
      if (this.mScaleX != 0.0F) {
        m = Float.floatToIntBits(this.mScaleX);
      } else {
        m = 0;
      }
      int n;
      if (this.mScaleY != 0.0F) {
        n = Float.floatToIntBits(this.mScaleY);
      } else {
        n = 0;
      }
      int i1;
      if (this.mRotationX != 0.0F) {
        i1 = Float.floatToIntBits(this.mRotationX);
      } else {
        i1 = 0;
      }
      int i2;
      if (this.mRotationY != 0.0F) {
        i2 = Float.floatToIntBits(this.mRotationY);
      } else {
        i2 = 0;
      }
      if (this.mRotationZ != 0.0F) {
        i3 = Float.floatToIntBits(this.mRotationZ);
      }
      return ((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3;
    }
    
    public void restore(View paramView)
    {
      ChangeTransform.setTransforms(paramView, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\ChangeTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */