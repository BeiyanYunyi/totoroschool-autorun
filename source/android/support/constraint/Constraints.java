package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class Constraints
  extends ViewGroup
{
  public static final String TAG = "Constraints";
  ConstraintSet myConstraintSet;
  
  public Constraints(Context paramContext)
  {
    super(paramContext);
    super.setVisibility(8);
  }
  
  public Constraints(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
    super.setVisibility(8);
  }
  
  public Constraints(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
    super.setVisibility(8);
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    Log.v("Constraints", " ################# init");
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ConstraintLayout.LayoutParams(paramLayoutParams);
  }
  
  public ConstraintSet getConstraintSet()
  {
    if (this.myConstraintSet == null) {
      this.myConstraintSet = new ConstraintSet();
    }
    this.myConstraintSet.clone(this);
    return this.myConstraintSet;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public static class LayoutParams
    extends ConstraintLayout.LayoutParams
  {
    public float alpha = 1.0F;
    public boolean applyElevation;
    public float elevation;
    public float rotation;
    public float rotationX;
    public float rotationY;
    public float scaleX;
    public float scaleY;
    public float transformPivotX;
    public float transformPivotY;
    public float translationX;
    public float translationY;
    public float translationZ;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.applyElevation = false;
      this.elevation = 0.0F;
      this.rotation = 0.0F;
      this.rotationX = 0.0F;
      this.rotationY = 0.0F;
      this.scaleX = 1.0F;
      this.scaleY = 1.0F;
      this.transformPivotX = 0.0F;
      this.transformPivotY = 0.0F;
      this.translationX = 0.0F;
      this.translationY = 0.0F;
      this.translationZ = 0.0F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      int i = 0;
      this.applyElevation = false;
      this.elevation = 0.0F;
      this.rotation = 0.0F;
      this.rotationX = 0.0F;
      this.rotationY = 0.0F;
      this.scaleX = 1.0F;
      this.scaleY = 1.0F;
      this.transformPivotX = 0.0F;
      this.transformPivotY = 0.0F;
      this.translationX = 0.0F;
      this.translationY = 0.0F;
      this.translationZ = 0.0F;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
      int j = paramContext.getIndexCount();
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == R.styleable.ConstraintSet_android_alpha)
        {
          this.alpha = paramContext.getFloat(k, this.alpha);
        }
        else if (k == R.styleable.ConstraintSet_android_elevation)
        {
          this.elevation = paramContext.getFloat(k, this.elevation);
          this.applyElevation = true;
        }
        else if (k == R.styleable.ConstraintSet_android_rotationX)
        {
          this.rotationX = paramContext.getFloat(k, this.rotationX);
        }
        else if (k == R.styleable.ConstraintSet_android_rotationY)
        {
          this.rotationY = paramContext.getFloat(k, this.rotationY);
        }
        else if (k == R.styleable.ConstraintSet_android_rotation)
        {
          this.rotation = paramContext.getFloat(k, this.rotation);
        }
        else if (k == R.styleable.ConstraintSet_android_scaleX)
        {
          this.scaleX = paramContext.getFloat(k, this.scaleX);
        }
        else if (k == R.styleable.ConstraintSet_android_scaleY)
        {
          this.scaleY = paramContext.getFloat(k, this.scaleY);
        }
        else if (k == R.styleable.ConstraintSet_android_transformPivotX)
        {
          this.transformPivotX = paramContext.getFloat(k, this.transformPivotX);
        }
        else if (k == R.styleable.ConstraintSet_android_transformPivotY)
        {
          this.transformPivotY = paramContext.getFloat(k, this.transformPivotY);
        }
        else if (k == R.styleable.ConstraintSet_android_translationX)
        {
          this.translationX = paramContext.getFloat(k, this.translationX);
        }
        else if (k == R.styleable.ConstraintSet_android_translationY)
        {
          this.translationY = paramContext.getFloat(k, this.translationY);
        }
        else if (k == R.styleable.ConstraintSet_android_translationZ)
        {
          this.translationX = paramContext.getFloat(k, this.translationZ);
        }
        i += 1;
      }
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.applyElevation = false;
      this.elevation = 0.0F;
      this.rotation = 0.0F;
      this.rotationX = 0.0F;
      this.rotationY = 0.0F;
      this.scaleX = 1.0F;
      this.scaleY = 1.0F;
      this.transformPivotX = 0.0F;
      this.transformPivotY = 0.0F;
      this.translationX = 0.0F;
      this.translationY = 0.0F;
      this.translationZ = 0.0F;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\Constraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */