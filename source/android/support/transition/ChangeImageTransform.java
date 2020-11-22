package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;

public class ChangeImageTransform
  extends Transition
{
  private static final Property<ImageView, Matrix> ANIMATED_TRANSFORM_PROPERTY = new Property(Matrix.class, "animatedTransform")
  {
    public Matrix get(ImageView paramAnonymousImageView)
    {
      return null;
    }
    
    public void set(ImageView paramAnonymousImageView, Matrix paramAnonymousMatrix)
    {
      ImageViewUtils.animateTransform(paramAnonymousImageView, paramAnonymousMatrix);
    }
  };
  private static final TypeEvaluator<Matrix> NULL_MATRIX_EVALUATOR;
  private static final String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
  private static final String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
  private static final String[] sTransitionProperties = { "android:changeImageTransform:matrix", "android:changeImageTransform:bounds" };
  
  static
  {
    NULL_MATRIX_EVALUATOR = new TypeEvaluator()
    {
      public Matrix evaluate(float paramAnonymousFloat, Matrix paramAnonymousMatrix1, Matrix paramAnonymousMatrix2)
      {
        return null;
      }
    };
  }
  
  public ChangeImageTransform() {}
  
  public ChangeImageTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    View localView = paramTransitionValues.view;
    if ((localView instanceof ImageView))
    {
      if (localView.getVisibility() != 0) {
        return;
      }
      ImageView localImageView = (ImageView)localView;
      if (localImageView.getDrawable() == null) {
        return;
      }
      paramTransitionValues = paramTransitionValues.values;
      paramTransitionValues.put("android:changeImageTransform:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramTransitionValues.put("android:changeImageTransform:matrix", copyImageMatrix(localImageView));
      return;
    }
  }
  
  private static Matrix centerCropMatrix(ImageView paramImageView)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    int i = localDrawable.getIntrinsicWidth();
    float f1 = paramImageView.getWidth();
    float f2 = i;
    float f5 = f1 / f2;
    i = localDrawable.getIntrinsicHeight();
    float f3 = paramImageView.getHeight();
    float f4 = i;
    f5 = Math.max(f5, f3 / f4);
    i = Math.round((f1 - f2 * f5) / 2.0F);
    int j = Math.round((f3 - f4 * f5) / 2.0F);
    paramImageView = new Matrix();
    paramImageView.postScale(f5, f5);
    paramImageView.postTranslate(i, j);
    return paramImageView;
  }
  
  private static Matrix copyImageMatrix(ImageView paramImageView)
  {
    switch (paramImageView.getScaleType())
    {
    default: 
      return new Matrix(paramImageView.getImageMatrix());
    case ???: 
      return centerCropMatrix(paramImageView);
    }
    return fitXYMatrix(paramImageView);
  }
  
  private ObjectAnimator createMatrixAnimator(ImageView paramImageView, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    return ObjectAnimator.ofObject(paramImageView, ANIMATED_TRANSFORM_PROPERTY, new TransitionUtils.MatrixEvaluator(), new Matrix[] { paramMatrix1, paramMatrix2 });
  }
  
  private ObjectAnimator createNullAnimator(ImageView paramImageView)
  {
    return ObjectAnimator.ofObject(paramImageView, ANIMATED_TRANSFORM_PROPERTY, NULL_MATRIX_EVALUATOR, new Matrix[] { null, null });
  }
  
  private static Matrix fitXYMatrix(ImageView paramImageView)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramImageView.getWidth() / localDrawable.getIntrinsicWidth(), paramImageView.getHeight() / localDrawable.getIntrinsicHeight());
    return localMatrix;
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public Animator createAnimator(@NonNull ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if (paramTransitionValues1 != null)
    {
      if (paramTransitionValues2 == null) {
        return null;
      }
      paramViewGroup = (Rect)paramTransitionValues1.values.get("android:changeImageTransform:bounds");
      Rect localRect = (Rect)paramTransitionValues2.values.get("android:changeImageTransform:bounds");
      if (paramViewGroup != null)
      {
        if (localRect == null) {
          return null;
        }
        paramTransitionValues1 = (Matrix)paramTransitionValues1.values.get("android:changeImageTransform:matrix");
        Matrix localMatrix = (Matrix)paramTransitionValues2.values.get("android:changeImageTransform:matrix");
        if (((paramTransitionValues1 == null) && (localMatrix == null)) || ((paramTransitionValues1 != null) && (paramTransitionValues1.equals(localMatrix)))) {
          i = 1;
        } else {
          i = 0;
        }
        if ((paramViewGroup.equals(localRect)) && (i != 0)) {
          return null;
        }
        paramTransitionValues2 = (ImageView)paramTransitionValues2.view;
        paramViewGroup = paramTransitionValues2.getDrawable();
        int i = paramViewGroup.getIntrinsicWidth();
        int j = paramViewGroup.getIntrinsicHeight();
        ImageViewUtils.startAnimateTransform(paramTransitionValues2);
        if ((i != 0) && (j != 0))
        {
          paramViewGroup = paramTransitionValues1;
          if (paramTransitionValues1 == null) {
            paramViewGroup = MatrixUtils.IDENTITY_MATRIX;
          }
          paramTransitionValues1 = localMatrix;
          if (localMatrix == null) {
            paramTransitionValues1 = MatrixUtils.IDENTITY_MATRIX;
          }
          ANIMATED_TRANSFORM_PROPERTY.set(paramTransitionValues2, paramViewGroup);
          paramViewGroup = createMatrixAnimator(paramTransitionValues2, paramViewGroup, paramTransitionValues1);
        }
        else
        {
          paramViewGroup = createNullAnimator(paramTransitionValues2);
        }
        ImageViewUtils.reserveEndAnimateTransform(paramTransitionValues2, paramViewGroup);
        return paramViewGroup;
      }
      return null;
    }
    return null;
  }
  
  public String[] getTransitionProperties()
  {
    return sTransitionProperties;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\ChangeImageTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */