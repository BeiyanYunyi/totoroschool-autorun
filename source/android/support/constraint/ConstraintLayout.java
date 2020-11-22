package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.widgets.Analyzer;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.support.constraint.solver.widgets.ResolutionAnchor;
import android.support.constraint.solver.widgets.ResolutionDimension;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout
  extends ViewGroup
{
  static final boolean ALLOWS_EMBEDDED = false;
  private static final boolean CACHE_MEASURED_DIMENSION = false;
  private static final boolean DEBUG = false;
  public static final int DESIGN_INFO_ID = 0;
  private static final String TAG = "ConstraintLayout";
  private static final boolean USE_CONSTRAINTS_HELPER = true;
  public static final String VERSION = "ConstraintLayout-1.1.3";
  SparseArray<View> mChildrenByIds = new SparseArray();
  private ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList(4);
  private ConstraintSet mConstraintSet = null;
  private int mConstraintSetId = -1;
  private HashMap<String, Integer> mDesignIds = new HashMap();
  private boolean mDirtyHierarchy = true;
  private int mLastMeasureHeight = -1;
  int mLastMeasureHeightMode = 0;
  int mLastMeasureHeightSize = -1;
  private int mLastMeasureWidth = -1;
  int mLastMeasureWidthMode = 0;
  int mLastMeasureWidthSize = -1;
  ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
  private int mMaxHeight = Integer.MAX_VALUE;
  private int mMaxWidth = Integer.MAX_VALUE;
  private Metrics mMetrics;
  private int mMinHeight = 0;
  private int mMinWidth = 0;
  private int mOptimizationLevel = 7;
  private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList(100);
  
  public ConstraintLayout(Context paramContext)
  {
    super(paramContext);
    init(null);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private final ConstraintWidget getTargetWidget(int paramInt)
  {
    if (paramInt == 0) {
      return this.mLayoutWidget;
    }
    View localView2 = (View)this.mChildrenByIds.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView2 = findViewById(paramInt);
      localView1 = localView2;
      if (localView2 != null)
      {
        localView1 = localView2;
        if (localView2 != this)
        {
          localView1 = localView2;
          if (localView2.getParent() == this)
          {
            onViewAdded(localView2);
            localView1 = localView2;
          }
        }
      }
    }
    if (localView1 == this) {
      return this.mLayoutWidget;
    }
    if (localView1 == null) {
      return null;
    }
    return ((LayoutParams)localView1.getLayoutParams()).widget;
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    this.mLayoutWidget.setCompanionWidget(this);
    this.mChildrenByIds.put(getId(), this);
    this.mConstraintSet = null;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_Layout_android_minWidth) {
          this.mMinWidth = paramAttributeSet.getDimensionPixelOffset(k, this.mMinWidth);
        } else if (k == R.styleable.ConstraintLayout_Layout_android_minHeight) {
          this.mMinHeight = paramAttributeSet.getDimensionPixelOffset(k, this.mMinHeight);
        } else if (k == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
          this.mMaxWidth = paramAttributeSet.getDimensionPixelOffset(k, this.mMaxWidth);
        } else if (k == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
          this.mMaxHeight = paramAttributeSet.getDimensionPixelOffset(k, this.mMaxHeight);
        } else if (k == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
          this.mOptimizationLevel = paramAttributeSet.getInt(k, this.mOptimizationLevel);
        } else if (k == R.styleable.ConstraintLayout_Layout_constraintSet) {
          k = paramAttributeSet.getResourceId(k, 0);
        }
        try
        {
          this.mConstraintSet = new ConstraintSet();
          this.mConstraintSet.load(getContext(), k);
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;) {}
        }
        this.mConstraintSet = null;
        this.mConstraintSetId = k;
        i += 1;
      }
      paramAttributeSet.recycle();
    }
    this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
  }
  
  private void internalMeasureChildren(int paramInt1, int paramInt2)
  {
    int i3 = getPaddingTop() + getPaddingBottom();
    int i4 = getPaddingLeft() + getPaddingRight();
    int i5 = getChildCount();
    int n = 0;
    while (n < i5)
    {
      View localView = getChildAt(n);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        ConstraintWidget localConstraintWidget = localLayoutParams.widget;
        if ((!localLayoutParams.isGuideline) && (!localLayoutParams.isHelper))
        {
          localConstraintWidget.setVisibility(localView.getVisibility());
          int i1 = localLayoutParams.width;
          int i2 = localLayoutParams.height;
          int i;
          if ((!localLayoutParams.horizontalDimensionFixed) && (!localLayoutParams.verticalDimensionFixed) && ((localLayoutParams.horizontalDimensionFixed) || (localLayoutParams.matchConstraintDefaultWidth != 1)) && (localLayoutParams.width != -1) && ((localLayoutParams.verticalDimensionFixed) || ((localLayoutParams.matchConstraintDefaultHeight != 1) && (localLayoutParams.height != -1)))) {
            i = 0;
          } else {
            i = 1;
          }
          int k;
          int m;
          int j;
          if (i != 0)
          {
            if (i1 == 0)
            {
              k = getChildMeasureSpec(paramInt1, i4, -2);
              i = 1;
            }
            else if (i1 == -1)
            {
              k = getChildMeasureSpec(paramInt1, i4, -1);
              i = 0;
            }
            else
            {
              if (i1 == -2) {
                i = 1;
              } else {
                i = 0;
              }
              k = getChildMeasureSpec(paramInt1, i4, i1);
            }
            if (i2 == 0)
            {
              m = getChildMeasureSpec(paramInt2, i3, -2);
              j = 1;
            }
            else if (i2 == -1)
            {
              m = getChildMeasureSpec(paramInt2, i3, -1);
              j = 0;
            }
            else
            {
              if (i2 == -2) {
                j = 1;
              } else {
                j = 0;
              }
              m = getChildMeasureSpec(paramInt2, i3, i2);
            }
            localView.measure(k, m);
            if (this.mMetrics != null)
            {
              Metrics localMetrics = this.mMetrics;
              localMetrics.measures += 1L;
            }
            boolean bool;
            if (i1 == -2) {
              bool = true;
            } else {
              bool = false;
            }
            localConstraintWidget.setWidthWrapContent(bool);
            if (i2 == -2) {
              bool = true;
            } else {
              bool = false;
            }
            localConstraintWidget.setHeightWrapContent(bool);
            k = localView.getMeasuredWidth();
            m = localView.getMeasuredHeight();
          }
          else
          {
            i = 0;
            j = 0;
            m = i2;
            k = i1;
          }
          localConstraintWidget.setWidth(k);
          localConstraintWidget.setHeight(m);
          if (i != 0) {
            localConstraintWidget.setWrapWidth(k);
          }
          if (j != 0) {
            localConstraintWidget.setWrapHeight(m);
          }
          if (localLayoutParams.needsBaseline)
          {
            i = localView.getBaseline();
            if (i != -1) {
              localConstraintWidget.setBaselineDistance(i);
            }
          }
        }
      }
      n += 1;
    }
  }
  
  private void internalMeasureDimensions(int paramInt1, int paramInt2)
  {
    int i = getPaddingTop() + getPaddingBottom();
    int i8 = getPaddingLeft() + getPaddingRight();
    int i3 = getChildCount();
    int j = 0;
    long l1;
    View localView;
    LayoutParams localLayoutParams;
    ConstraintWidget localConstraintWidget;
    int n;
    int i1;
    int k;
    int i2;
    int m;
    Object localObject;
    boolean bool;
    for (;;)
    {
      l1 = 1L;
      if (j >= i3) {
        break;
      }
      localView = getChildAt(j);
      if (localView.getVisibility() != 8)
      {
        do
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          localConstraintWidget = localLayoutParams.widget;
        } while ((localLayoutParams.isGuideline) || (localLayoutParams.isHelper));
        localConstraintWidget.setVisibility(localView.getVisibility());
        n = localLayoutParams.width;
        i1 = localLayoutParams.height;
        if ((n != 0) && (i1 != 0))
        {
          if (n == -2) {
            k = 1;
          } else {
            k = 0;
          }
          i2 = getChildMeasureSpec(paramInt1, i8, n);
          if (i1 == -2) {
            m = 1;
          } else {
            m = 0;
          }
          localView.measure(i2, getChildMeasureSpec(paramInt2, i, i1));
          if (this.mMetrics != null)
          {
            localObject = this.mMetrics;
            ((Metrics)localObject).measures += 1L;
          }
          if (n == -2) {
            bool = true;
          } else {
            bool = false;
          }
          localConstraintWidget.setWidthWrapContent(bool);
          if (i1 == -2) {
            bool = true;
          } else {
            bool = false;
          }
          localConstraintWidget.setHeightWrapContent(bool);
          n = localView.getMeasuredWidth();
          i1 = localView.getMeasuredHeight();
          localConstraintWidget.setWidth(n);
          localConstraintWidget.setHeight(i1);
          if (k != 0) {
            localConstraintWidget.setWrapWidth(n);
          }
          if (m != 0) {
            localConstraintWidget.setWrapHeight(i1);
          }
          if (localLayoutParams.needsBaseline)
          {
            k = localView.getBaseline();
            if (k != -1) {
              localConstraintWidget.setBaselineDistance(k);
            }
          }
          if ((localLayoutParams.horizontalDimensionFixed) && (localLayoutParams.verticalDimensionFixed))
          {
            localConstraintWidget.getResolutionWidth().resolve(n);
            localConstraintWidget.getResolutionHeight().resolve(i1);
          }
        }
        else
        {
          localConstraintWidget.getResolutionWidth().invalidate();
          localConstraintWidget.getResolutionHeight().invalidate();
        }
      }
      j += 1;
    }
    this.mLayoutWidget.solveGraph();
    int i4 = 0;
    while (i4 < i3)
    {
      localView = getChildAt(i4);
      if (localView.getVisibility() != 8)
      {
        do
        {
          do
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            localConstraintWidget = localLayoutParams.widget;
          } while ((localLayoutParams.isGuideline) || (localLayoutParams.isHelper));
          localConstraintWidget.setVisibility(localView.getVisibility());
          i1 = localLayoutParams.width;
          i2 = localLayoutParams.height;
        } while ((i1 != 0) && (i2 != 0));
        localObject = localConstraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor localResolutionAnchor1 = localConstraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getResolutionNode();
        if ((localConstraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).getTarget() != null) && (localConstraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget() != null)) {
          k = 1;
        } else {
          k = 0;
        }
        ResolutionAnchor localResolutionAnchor2 = localConstraintWidget.getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        ResolutionAnchor localResolutionAnchor3 = localConstraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getResolutionNode();
        int i7;
        if ((localConstraintWidget.getAnchor(ConstraintAnchor.Type.TOP).getTarget() != null) && (localConstraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget() != null)) {
          i7 = 1;
        } else {
          i7 = 0;
        }
        if ((i1 == 0) && (i2 == 0) && (k != 0) && (i7 != 0))
        {
          l1 = 1L;
        }
        else
        {
          if (this.mLayoutWidget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            n = 1;
          } else {
            n = 0;
          }
          if (this.mLayoutWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            j = 1;
          } else {
            j = 0;
          }
          if (n == 0) {
            localConstraintWidget.getResolutionWidth().invalidate();
          }
          if (j == 0) {
            localConstraintWidget.getResolutionHeight().invalidate();
          }
          if (i1 == 0)
          {
            if ((n != 0) && (localConstraintWidget.isSpreadWidth()) && (k != 0) && (((ResolutionAnchor)localObject).isResolved()) && (localResolutionAnchor1.isResolved()))
            {
              i1 = (int)(localResolutionAnchor1.getResolvedValue() - ((ResolutionAnchor)localObject).getResolvedValue());
              localConstraintWidget.getResolutionWidth().resolve(i1);
              m = getChildMeasureSpec(paramInt1, i8, i1);
            }
            else
            {
              m = getChildMeasureSpec(paramInt1, i8, -2);
              i5 = 0;
              k = 1;
              i6 = i1;
              break label903;
            }
          }
          else
          {
            if (i1 != -1) {
              break label869;
            }
            m = getChildMeasureSpec(paramInt1, i8, -1);
          }
          k = 0;
          int i5 = n;
          int i6 = i1;
          break label903;
          label869:
          if (i1 == -2) {
            k = 1;
          } else {
            k = 0;
          }
          m = getChildMeasureSpec(paramInt1, i8, i1);
          i6 = i1;
          i5 = n;
          label903:
          if (i2 == 0)
          {
            if ((j != 0) && (localConstraintWidget.isSpreadHeight()) && (i7 != 0) && (localResolutionAnchor2.isResolved()) && (localResolutionAnchor3.isResolved()))
            {
              i2 = (int)(localResolutionAnchor3.getResolvedValue() - localResolutionAnchor2.getResolvedValue());
              localConstraintWidget.getResolutionHeight().resolve(i2);
              i1 = getChildMeasureSpec(paramInt2, i, i2);
            }
            else
            {
              i1 = getChildMeasureSpec(paramInt2, i, -2);
              j = 0;
              n = 1;
              break label1046;
            }
          }
          else
          {
            i1 = i;
            if (i2 != -1) {
              break label1020;
            }
            i1 = getChildMeasureSpec(paramInt2, i1, -1);
          }
          n = 0;
          break label1046;
          label1020:
          if (i2 == -2) {
            n = 1;
          } else {
            n = 0;
          }
          i1 = getChildMeasureSpec(paramInt2, i1, i2);
          label1046:
          localView.measure(m, i1);
          if (this.mMetrics != null)
          {
            localObject = this.mMetrics;
            ((Metrics)localObject).measures += 1L;
          }
          long l2 = 1L;
          if (i6 == -2) {
            bool = true;
          } else {
            bool = false;
          }
          localConstraintWidget.setWidthWrapContent(bool);
          if (i2 == -2) {
            bool = true;
          } else {
            bool = false;
          }
          localConstraintWidget.setHeightWrapContent(bool);
          m = localView.getMeasuredWidth();
          i1 = localView.getMeasuredHeight();
          localConstraintWidget.setWidth(m);
          localConstraintWidget.setHeight(i1);
          if (k != 0) {
            localConstraintWidget.setWrapWidth(m);
          }
          if (n != 0) {
            localConstraintWidget.setWrapHeight(i1);
          }
          if (i5 != 0) {
            localConstraintWidget.getResolutionWidth().resolve(m);
          } else {
            localConstraintWidget.getResolutionWidth().remove();
          }
          if (j != 0) {
            localConstraintWidget.getResolutionHeight().resolve(i1);
          }
          for (;;)
          {
            break;
            localConstraintWidget.getResolutionHeight().remove();
          }
          if (localLayoutParams.needsBaseline)
          {
            j = localView.getBaseline();
            l1 = l2;
            if (j != -1)
            {
              localConstraintWidget.setBaselineDistance(j);
              l1 = l2;
            }
          }
          else
          {
            l1 = l2;
          }
        }
      }
      i4 += 1;
    }
  }
  
  private void setChildrenConstraints()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void setSelfDimensionBehaviour(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int j = getPaddingTop();
    int k = getPaddingBottom();
    int n = getPaddingLeft();
    int i1 = getPaddingRight();
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.FIXED;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
    getLayoutParams();
    if (m != Integer.MIN_VALUE)
    {
      if (m != 0) {
        if (m == 1073741824) {}
      }
      for (;;)
      {
        paramInt1 = 0;
        break;
        paramInt1 = Math.min(this.mMaxWidth, paramInt1) - (n + i1);
        break;
        localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      }
    }
    localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    if (i != Integer.MIN_VALUE)
    {
      if (i != 0) {
        if (i == 1073741824) {}
      }
      for (;;)
      {
        paramInt2 = 0;
        break;
        paramInt2 = Math.min(this.mMaxHeight, paramInt2) - (j + k);
        break;
        localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      }
    }
    localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    this.mLayoutWidget.setMinWidth(0);
    this.mLayoutWidget.setMinHeight(0);
    this.mLayoutWidget.setHorizontalDimensionBehaviour(localDimensionBehaviour1);
    this.mLayoutWidget.setWidth(paramInt1);
    this.mLayoutWidget.setVerticalDimensionBehaviour(localDimensionBehaviour2);
    this.mLayoutWidget.setHeight(paramInt2);
    this.mLayoutWidget.setMinWidth(this.mMinWidth - getPaddingLeft() - getPaddingRight());
    this.mLayoutWidget.setMinHeight(this.mMinHeight - getPaddingTop() - getPaddingBottom());
  }
  
  private void updateHierarchy()
  {
    int m = getChildCount();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      if (getChildAt(i).isLayoutRequested())
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if (j != 0)
    {
      this.mVariableDimensionsWidgets.clear();
      setChildrenConstraints();
    }
  }
  
  private void updatePostMeasures()
  {
    int k = getChildCount();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      View localView = getChildAt(i);
      if ((localView instanceof Placeholder)) {
        ((Placeholder)localView).updatePostMeasure(this);
      }
      i += 1;
    }
    k = this.mConstraintHelpers.size();
    if (k > 0)
    {
      i = j;
      while (i < k)
      {
        ((ConstraintHelper)this.mConstraintHelpers.get(i)).updatePostMeasure(this);
        i += 1;
      }
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14) {
      onViewAdded(paramView);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (isInEditMode())
    {
      int j = getChildCount();
      float f1 = getWidth();
      float f2 = getHeight();
      int i = 0;
      while (i < j)
      {
        Object localObject = getChildAt(i);
        if (((View)localObject).getVisibility() != 8)
        {
          localObject = ((View)localObject).getTag();
          if ((localObject != null) && ((localObject instanceof String)))
          {
            localObject = ((String)localObject).split(",");
            if (localObject.length == 4)
            {
              int m = Integer.parseInt(localObject[0]);
              int i1 = Integer.parseInt(localObject[1]);
              int n = Integer.parseInt(localObject[2]);
              int k = Integer.parseInt(localObject[3]);
              m = (int)(m / 1080.0F * f1);
              i1 = (int)(i1 / 1920.0F * f2);
              n = (int)(n / 1080.0F * f1);
              k = (int)(k / 1920.0F * f2);
              localObject = new Paint();
              ((Paint)localObject).setColor(-65536);
              float f3 = m;
              float f4 = i1;
              float f5 = m + n;
              paramCanvas.drawLine(f3, f4, f5, f4, (Paint)localObject);
              float f6 = i1 + k;
              paramCanvas.drawLine(f5, f4, f5, f6, (Paint)localObject);
              paramCanvas.drawLine(f5, f6, f3, f6, (Paint)localObject);
              paramCanvas.drawLine(f3, f6, f3, f4, (Paint)localObject);
              ((Paint)localObject).setColor(-16711936);
              paramCanvas.drawLine(f3, f4, f5, f6, (Paint)localObject);
              paramCanvas.drawLine(f3, f6, f5, f4, (Paint)localObject);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void fillMetrics(Metrics paramMetrics)
  {
    this.mMetrics = paramMetrics;
    this.mLayoutWidget.fillMetrics(paramMetrics);
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
    return new LayoutParams(paramLayoutParams);
  }
  
  public Object getDesignInformation(int paramInt, Object paramObject)
  {
    if ((paramInt == 0) && ((paramObject instanceof String)))
    {
      paramObject = (String)paramObject;
      if ((this.mDesignIds != null) && (this.mDesignIds.containsKey(paramObject))) {
        return this.mDesignIds.get(paramObject);
      }
    }
    return null;
  }
  
  public int getMaxHeight()
  {
    return this.mMaxHeight;
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public int getMinHeight()
  {
    return this.mMinHeight;
  }
  
  public int getMinWidth()
  {
    return this.mMinWidth;
  }
  
  public int getOptimizationLevel()
  {
    return this.mLayoutWidget.getOptimizationLevel();
  }
  
  public View getViewById(int paramInt)
  {
    return (View)this.mChildrenByIds.get(paramInt);
  }
  
  public final ConstraintWidget getViewWidget(View paramView)
  {
    if (paramView == this) {
      return this.mLayoutWidget;
    }
    if (paramView == null) {
      return null;
    }
    return ((LayoutParams)paramView.getLayoutParams()).widget;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = getChildAt(paramInt1);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      ConstraintWidget localConstraintWidget = localLayoutParams.widget;
      if (((localView.getVisibility() != 8) || (localLayoutParams.isGuideline) || (localLayoutParams.isHelper) || (paramBoolean)) && (!localLayoutParams.isInPlaceholder))
      {
        paramInt4 = localConstraintWidget.getDrawX();
        int i = localConstraintWidget.getDrawY();
        int j = localConstraintWidget.getWidth() + paramInt4;
        int k = localConstraintWidget.getHeight() + i;
        localView.layout(paramInt4, i, j, k);
        if ((localView instanceof Placeholder))
        {
          localView = ((Placeholder)localView).getContent();
          if (localView != null)
          {
            localView.setVisibility(0);
            localView.layout(paramInt4, i, j, k);
          }
        }
      }
      paramInt1 += 1;
    }
    paramInt3 = this.mConstraintHelpers.size();
    if (paramInt3 > 0)
    {
      paramInt1 = paramInt2;
      while (paramInt1 < paramInt3)
      {
        ((ConstraintHelper)this.mConstraintHelpers.get(paramInt1)).updatePostLayout(this);
        paramInt1 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    System.currentTimeMillis();
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    int j = getPaddingLeft();
    int k = getPaddingTop();
    this.mLayoutWidget.setX(j);
    this.mLayoutWidget.setY(k);
    this.mLayoutWidget.setMaxWidth(this.mMaxWidth);
    this.mLayoutWidget.setMaxHeight(this.mMaxHeight);
    Object localObject;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject = this.mLayoutWidget;
      boolean bool;
      if (getLayoutDirection() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((ConstraintWidgetContainer)localObject).setRtl(bool);
    }
    setSelfDimensionBehaviour(paramInt1, paramInt2);
    int i6 = this.mLayoutWidget.getWidth();
    int i5 = this.mLayoutWidget.getHeight();
    if (this.mDirtyHierarchy)
    {
      this.mDirtyHierarchy = false;
      updateHierarchy();
      i = 1;
    }
    else
    {
      i = 0;
    }
    int i1;
    if ((this.mOptimizationLevel & 0x8) == 8) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      this.mLayoutWidget.preOptimize();
      this.mLayoutWidget.optimizeForDimensions(i6, i5);
      internalMeasureDimensions(paramInt1, paramInt2);
    }
    else
    {
      internalMeasureChildren(paramInt1, paramInt2);
    }
    updatePostMeasures();
    if ((getChildCount() > 0) && (i != 0)) {
      Analyzer.determineGroups(this.mLayoutWidget);
    }
    if (this.mLayoutWidget.mGroupsWrapOptimized)
    {
      if ((this.mLayoutWidget.mHorizontalWrapOptimized) && (m == Integer.MIN_VALUE))
      {
        if (this.mLayoutWidget.mWrapFixedWidth < n) {
          this.mLayoutWidget.setWidth(this.mLayoutWidget.mWrapFixedWidth);
        }
        this.mLayoutWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      }
      if ((this.mLayoutWidget.mVerticalWrapOptimized) && (i2 == Integer.MIN_VALUE))
      {
        if (this.mLayoutWidget.mWrapFixedHeight < i3) {
          this.mLayoutWidget.setHeight(this.mLayoutWidget.mWrapFixedHeight);
        }
        this.mLayoutWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      }
    }
    if ((this.mOptimizationLevel & 0x20) == 32)
    {
      i = this.mLayoutWidget.getWidth();
      i4 = this.mLayoutWidget.getHeight();
      if ((this.mLastMeasureWidth != i) && (m == 1073741824)) {
        Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 0, i);
      }
      if ((this.mLastMeasureHeight != i4) && (i2 == 1073741824)) {
        Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 1, i4);
      }
      if ((this.mLayoutWidget.mHorizontalWrapOptimized) && (this.mLayoutWidget.mWrapFixedWidth > n)) {
        Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 0, n);
      }
      if ((this.mLayoutWidget.mVerticalWrapOptimized) && (this.mLayoutWidget.mWrapFixedHeight > i3)) {
        Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 1, i3);
      }
    }
    if (getChildCount() > 0) {
      solveLinearSystem("First pass");
    }
    int i4 = this.mVariableDimensionsWidgets.size();
    int i9 = k + getPaddingBottom();
    int i10 = j + getPaddingRight();
    if (i4 > 0)
    {
      if (this.mLayoutWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (this.mLayoutWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      k = Math.max(this.mLayoutWidget.getWidth(), this.mMinWidth);
      j = Math.max(this.mLayoutWidget.getHeight(), this.mMinHeight);
      int i7 = 0;
      m = 0;
      i = 0;
      View localView;
      while (i7 < i4)
      {
        localObject = (ConstraintWidget)this.mVariableDimensionsWidgets.get(i7);
        localView = (View)((ConstraintWidget)localObject).getCompanionWidget();
        if (localView != null) {
          for (;;)
          {
            LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if ((!localLayoutParams.isHelper) && (!localLayoutParams.isGuideline))
            {
              int i8 = localView.getVisibility();
              n = m;
              if (i8 != 8)
              {
                while ((i1 != 0) && (((ConstraintWidget)localObject).getResolutionWidth().isResolved()) && (((ConstraintWidget)localObject).getResolutionHeight().isResolved())) {}
                if ((localLayoutParams.width == -2) && (localLayoutParams.horizontalDimensionFixed)) {
                  m = getChildMeasureSpec(paramInt1, i10, localLayoutParams.width);
                } else {
                  m = View.MeasureSpec.makeMeasureSpec(((ConstraintWidget)localObject).getWidth(), 1073741824);
                }
                if ((localLayoutParams.height == -2) && (localLayoutParams.verticalDimensionFixed)) {
                  i8 = getChildMeasureSpec(paramInt2, i9, localLayoutParams.height);
                } else {
                  i8 = View.MeasureSpec.makeMeasureSpec(((ConstraintWidget)localObject).getHeight(), 1073741824);
                }
                localView.measure(m, i8);
                if (this.mMetrics != null)
                {
                  Metrics localMetrics = this.mMetrics;
                  localMetrics.additionalMeasures += 1L;
                }
                int i11 = localView.getMeasuredWidth();
                i8 = localView.getMeasuredHeight();
                m = k;
                if (i11 != ((ConstraintWidget)localObject).getWidth())
                {
                  ((ConstraintWidget)localObject).setWidth(i11);
                  if (i1 != 0) {
                    ((ConstraintWidget)localObject).getResolutionWidth().resolve(i11);
                  }
                  m = k;
                  if (i2 != 0)
                  {
                    m = k;
                    if (((ConstraintWidget)localObject).getRight() > k) {
                      m = Math.max(k, ((ConstraintWidget)localObject).getRight() + ((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                    }
                  }
                  n = 1;
                }
                k = j;
                if (i8 != ((ConstraintWidget)localObject).getHeight())
                {
                  ((ConstraintWidget)localObject).setHeight(i8);
                  if (i1 != 0) {
                    ((ConstraintWidget)localObject).getResolutionHeight().resolve(i8);
                  }
                  k = j;
                  if (i3 != 0)
                  {
                    k = j;
                    if (((ConstraintWidget)localObject).getBottom() > j) {
                      k = Math.max(j, ((ConstraintWidget)localObject).getBottom() + ((ConstraintWidget)localObject).getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                    }
                  }
                  n = 1;
                }
                j = n;
                if (localLayoutParams.needsBaseline)
                {
                  i8 = localView.getBaseline();
                  j = n;
                  if (i8 != -1)
                  {
                    j = n;
                    if (i8 != ((ConstraintWidget)localObject).getBaselineDistance())
                    {
                      ((ConstraintWidget)localObject).setBaselineDistance(i8);
                      j = 1;
                    }
                  }
                }
                if (Build.VERSION.SDK_INT >= 11)
                {
                  i = combineMeasuredStates(i, localView.getMeasuredState());
                  n = k;
                  k = m;
                  m = j;
                  break;
                }
                n = k;
                k = m;
                m = j;
                break;
              }
            }
          }
        }
        n = j;
        i7 += 1;
        j = n;
      }
      n = i;
      if (m != 0)
      {
        this.mLayoutWidget.setWidth(i6);
        this.mLayoutWidget.setHeight(i5);
        if (i1 != 0) {
          this.mLayoutWidget.solveGraph();
        }
        solveLinearSystem("2nd pass");
        if (this.mLayoutWidget.getWidth() < k)
        {
          this.mLayoutWidget.setWidth(k);
          i = 1;
        }
        else
        {
          i = 0;
        }
        if (this.mLayoutWidget.getHeight() < j)
        {
          this.mLayoutWidget.setHeight(j);
          i = 1;
        }
        if (i != 0) {
          solveLinearSystem("3rd pass");
        }
      }
      j = 0;
      for (;;)
      {
        i = n;
        if (j >= i4) {
          break;
        }
        localObject = (ConstraintWidget)this.mVariableDimensionsWidgets.get(j);
        localView = (View)((ConstraintWidget)localObject).getCompanionWidget();
        if (localView != null)
        {
          while (((localView.getMeasuredWidth() == ((ConstraintWidget)localObject).getWidth()) && (localView.getMeasuredHeight() == ((ConstraintWidget)localObject).getHeight())) || (((ConstraintWidget)localObject).getVisibility() == 8)) {}
          localView.measure(View.MeasureSpec.makeMeasureSpec(((ConstraintWidget)localObject).getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(((ConstraintWidget)localObject).getHeight(), 1073741824));
          if (this.mMetrics != null)
          {
            localObject = this.mMetrics;
            ((Metrics)localObject).additionalMeasures += 1L;
          }
        }
        j += 1;
      }
    }
    int i = 0;
    j = this.mLayoutWidget.getWidth() + i10;
    k = this.mLayoutWidget.getHeight() + i9;
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramInt1 = resolveSizeAndState(j, paramInt1, i);
      i = resolveSizeAndState(k, paramInt2, i << 16);
      paramInt2 = Math.min(this.mMaxWidth, paramInt1 & 0xFFFFFF);
      i = Math.min(this.mMaxHeight, i & 0xFFFFFF);
      paramInt1 = paramInt2;
      if (this.mLayoutWidget.isWidthMeasuredTooSmall()) {
        paramInt1 = paramInt2 | 0x1000000;
      }
      paramInt2 = i;
      if (this.mLayoutWidget.isHeightMeasuredTooSmall()) {
        paramInt2 = i | 0x1000000;
      }
      setMeasuredDimension(paramInt1, paramInt2);
      this.mLastMeasureWidth = paramInt1;
      this.mLastMeasureHeight = paramInt2;
      return;
    }
    setMeasuredDimension(j, k);
    this.mLastMeasureWidth = j;
    this.mLastMeasureHeight = k;
  }
  
  public void onViewAdded(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewAdded(paramView);
    }
    Object localObject = getViewWidget(paramView);
    if (((paramView instanceof Guideline)) && (!(localObject instanceof android.support.constraint.solver.widgets.Guideline)))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      ((LayoutParams)localObject).widget = new android.support.constraint.solver.widgets.Guideline();
      ((LayoutParams)localObject).isGuideline = true;
      ((android.support.constraint.solver.widgets.Guideline)((LayoutParams)localObject).widget).setOrientation(((LayoutParams)localObject).orientation);
    }
    if ((paramView instanceof ConstraintHelper))
    {
      localObject = (ConstraintHelper)paramView;
      ((ConstraintHelper)localObject).validateParams();
      ((LayoutParams)paramView.getLayoutParams()).isHelper = true;
      if (!this.mConstraintHelpers.contains(localObject)) {
        this.mConstraintHelpers.add(localObject);
      }
    }
    this.mChildrenByIds.put(paramView.getId(), paramView);
    this.mDirtyHierarchy = true;
  }
  
  public void onViewRemoved(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewRemoved(paramView);
    }
    this.mChildrenByIds.remove(paramView.getId());
    ConstraintWidget localConstraintWidget = getViewWidget(paramView);
    this.mLayoutWidget.remove(localConstraintWidget);
    this.mConstraintHelpers.remove(paramView);
    this.mVariableDimensionsWidgets.remove(localConstraintWidget);
    this.mDirtyHierarchy = true;
  }
  
  public void removeView(View paramView)
  {
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14) {
      onViewRemoved(paramView);
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    this.mDirtyHierarchy = true;
    this.mLastMeasureWidth = -1;
    this.mLastMeasureHeight = -1;
    this.mLastMeasureWidthSize = -1;
    this.mLastMeasureHeightSize = -1;
    this.mLastMeasureWidthMode = 0;
    this.mLastMeasureHeightMode = 0;
  }
  
  public void setConstraintSet(ConstraintSet paramConstraintSet)
  {
    this.mConstraintSet = paramConstraintSet;
  }
  
  public void setDesignInformation(int paramInt, Object paramObject1, Object paramObject2)
  {
    if ((paramInt == 0) && ((paramObject1 instanceof String)) && ((paramObject2 instanceof Integer)))
    {
      if (this.mDesignIds == null) {
        this.mDesignIds = new HashMap();
      }
      String str = (String)paramObject1;
      paramInt = str.indexOf("/");
      paramObject1 = str;
      if (paramInt != -1) {
        paramObject1 = str.substring(paramInt + 1);
      }
      paramInt = ((Integer)paramObject2).intValue();
      this.mDesignIds.put(paramObject1, Integer.valueOf(paramInt));
    }
  }
  
  public void setId(int paramInt)
  {
    this.mChildrenByIds.remove(getId());
    super.setId(paramInt);
    this.mChildrenByIds.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (paramInt == this.mMaxHeight) {
      return;
    }
    this.mMaxHeight = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt)
  {
    if (paramInt == this.mMaxWidth) {
      return;
    }
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt == this.mMinHeight) {
      return;
    }
    this.mMinHeight = paramInt;
    requestLayout();
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt == this.mMinWidth) {
      return;
    }
    this.mMinWidth = paramInt;
    requestLayout();
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    this.mLayoutWidget.setOptimizationLevel(paramInt);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  protected void solveLinearSystem(String paramString)
  {
    this.mLayoutWidget.layout();
    if (this.mMetrics != null)
    {
      paramString = this.mMetrics;
      paramString.resolutions += 1L;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int END = 7;
    public static final int HORIZONTAL = 0;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int VERTICAL = 1;
    public int baselineToBaseline = -1;
    public int bottomToBottom = -1;
    public int bottomToTop = -1;
    public float circleAngle = 0.0F;
    public int circleConstraint = -1;
    public int circleRadius = 0;
    public boolean constrainedHeight = false;
    public boolean constrainedWidth = false;
    public String dimensionRatio = null;
    int dimensionRatioSide = 1;
    float dimensionRatioValue = 0.0F;
    public int editorAbsoluteX = -1;
    public int editorAbsoluteY = -1;
    public int endToEnd = -1;
    public int endToStart = -1;
    public int goneBottomMargin = -1;
    public int goneEndMargin = -1;
    public int goneLeftMargin = -1;
    public int goneRightMargin = -1;
    public int goneStartMargin = -1;
    public int goneTopMargin = -1;
    public int guideBegin = -1;
    public int guideEnd = -1;
    public float guidePercent = -1.0F;
    public boolean helped = false;
    public float horizontalBias = 0.5F;
    public int horizontalChainStyle = 0;
    boolean horizontalDimensionFixed = true;
    public float horizontalWeight = -1.0F;
    boolean isGuideline = false;
    boolean isHelper = false;
    boolean isInPlaceholder = false;
    public int leftToLeft = -1;
    public int leftToRight = -1;
    public int matchConstraintDefaultHeight = 0;
    public int matchConstraintDefaultWidth = 0;
    public int matchConstraintMaxHeight = 0;
    public int matchConstraintMaxWidth = 0;
    public int matchConstraintMinHeight = 0;
    public int matchConstraintMinWidth = 0;
    public float matchConstraintPercentHeight = 1.0F;
    public float matchConstraintPercentWidth = 1.0F;
    boolean needsBaseline = false;
    public int orientation = -1;
    int resolveGoneLeftMargin = -1;
    int resolveGoneRightMargin = -1;
    int resolvedGuideBegin;
    int resolvedGuideEnd;
    float resolvedGuidePercent;
    float resolvedHorizontalBias = 0.5F;
    int resolvedLeftToLeft = -1;
    int resolvedLeftToRight = -1;
    int resolvedRightToLeft = -1;
    int resolvedRightToRight = -1;
    public int rightToLeft = -1;
    public int rightToRight = -1;
    public int startToEnd = -1;
    public int startToStart = -1;
    public int topToBottom = -1;
    public int topToTop = -1;
    public float verticalBias = 0.5F;
    public int verticalChainStyle = 0;
    boolean verticalDimensionFixed = true;
    public float verticalWeight = -1.0F;
    ConstraintWidget widget = new ConstraintWidget();
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int k = paramContext.getIndexCount();
      int i = 0;
      while (i < k)
      {
        int j = paramContext.getIndex(i);
        String str;
        switch (Table.map.get(j))
        {
        case 43: 
        default: 
          break;
        case 50: 
          this.editorAbsoluteY = paramContext.getDimensionPixelOffset(j, this.editorAbsoluteY);
          break;
        case 49: 
          this.editorAbsoluteX = paramContext.getDimensionPixelOffset(j, this.editorAbsoluteX);
          break;
        case 48: 
          this.verticalChainStyle = paramContext.getInt(j, 0);
          break;
        case 47: 
          this.horizontalChainStyle = paramContext.getInt(j, 0);
          break;
        case 46: 
          this.verticalWeight = paramContext.getFloat(j, this.verticalWeight);
          break;
        case 45: 
          this.horizontalWeight = paramContext.getFloat(j, this.horizontalWeight);
          break;
        case 44: 
          this.dimensionRatio = paramContext.getString(j);
          this.dimensionRatioValue = NaN.0F;
          this.dimensionRatioSide = -1;
          if (this.dimensionRatio != null)
          {
            int m = this.dimensionRatio.length();
            j = this.dimensionRatio.indexOf(',');
            if ((j > 0) && (j < m - 1))
            {
              paramAttributeSet = this.dimensionRatio.substring(0, j);
              if (paramAttributeSet.equalsIgnoreCase("W")) {
                this.dimensionRatioSide = 0;
              } else if (paramAttributeSet.equalsIgnoreCase("H")) {
                this.dimensionRatioSide = 1;
              }
              j += 1;
            }
            else
            {
              j = 0;
            }
            int n = this.dimensionRatio.indexOf(':');
            if ((n >= 0) && (n < m - 1))
            {
              paramAttributeSet = this.dimensionRatio.substring(j, n);
              str = this.dimensionRatio.substring(n + 1);
              if ((paramAttributeSet.length() <= 0) || (str.length() <= 0)) {
                break label2032;
              }
            }
          }
          break;
        }
        try
        {
          float f1 = Float.parseFloat(paramAttributeSet);
          float f2 = Float.parseFloat(str);
          if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
            break label2032;
          }
          if (this.dimensionRatioSide == 1) {
            this.dimensionRatioValue = Math.abs(f2 / f1);
          } else {
            this.dimensionRatioValue = Math.abs(f1 / f2);
          }
        }
        catch (NumberFormatException paramAttributeSet)
        {
          for (;;) {}
        }
        paramAttributeSet = this.dimensionRatio.substring(j);
        if (paramAttributeSet.length() > 0)
        {
          this.dimensionRatioValue = Float.parseFloat(paramAttributeSet);
          break label2032;
          this.matchConstraintPercentHeight = Math.max(0.0F, paramContext.getFloat(j, this.matchConstraintPercentHeight));
        }
        try
        {
          this.matchConstraintMaxHeight = paramContext.getDimensionPixelSize(j, this.matchConstraintMaxHeight);
        }
        catch (Exception paramAttributeSet)
        {
          for (;;) {}
        }
        if (paramContext.getInt(j, this.matchConstraintMaxHeight) == -2) {
          this.matchConstraintMaxHeight = -2;
        }
        try
        {
          this.matchConstraintMinHeight = paramContext.getDimensionPixelSize(j, this.matchConstraintMinHeight);
        }
        catch (Exception paramAttributeSet)
        {
          for (;;) {}
        }
        if (paramContext.getInt(j, this.matchConstraintMinHeight) == -2)
        {
          this.matchConstraintMinHeight = -2;
          break label2032;
          this.matchConstraintPercentWidth = Math.max(0.0F, paramContext.getFloat(j, this.matchConstraintPercentWidth));
        }
        try
        {
          this.matchConstraintMaxWidth = paramContext.getDimensionPixelSize(j, this.matchConstraintMaxWidth);
        }
        catch (Exception paramAttributeSet)
        {
          for (;;) {}
        }
        if (paramContext.getInt(j, this.matchConstraintMaxWidth) == -2) {
          this.matchConstraintMaxWidth = -2;
        }
        try
        {
          this.matchConstraintMinWidth = paramContext.getDimensionPixelSize(j, this.matchConstraintMinWidth);
        }
        catch (Exception paramAttributeSet)
        {
          for (;;) {}
        }
        if (paramContext.getInt(j, this.matchConstraintMinWidth) == -2)
        {
          this.matchConstraintMinWidth = -2;
          break label2032;
          this.matchConstraintDefaultHeight = paramContext.getInt(j, 0);
          if (this.matchConstraintDefaultHeight == 1)
          {
            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
            break label2032;
            this.matchConstraintDefaultWidth = paramContext.getInt(j, 0);
            if (this.matchConstraintDefaultWidth == 1)
            {
              Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
              break label2032;
              this.verticalBias = paramContext.getFloat(j, this.verticalBias);
              break label2032;
              this.horizontalBias = paramContext.getFloat(j, this.horizontalBias);
              break label2032;
              this.constrainedHeight = paramContext.getBoolean(j, this.constrainedHeight);
              break label2032;
              this.constrainedWidth = paramContext.getBoolean(j, this.constrainedWidth);
              break label2032;
              this.goneEndMargin = paramContext.getDimensionPixelSize(j, this.goneEndMargin);
              break label2032;
              this.goneStartMargin = paramContext.getDimensionPixelSize(j, this.goneStartMargin);
              break label2032;
              this.goneBottomMargin = paramContext.getDimensionPixelSize(j, this.goneBottomMargin);
              break label2032;
              this.goneRightMargin = paramContext.getDimensionPixelSize(j, this.goneRightMargin);
              break label2032;
              this.goneTopMargin = paramContext.getDimensionPixelSize(j, this.goneTopMargin);
              break label2032;
              this.goneLeftMargin = paramContext.getDimensionPixelSize(j, this.goneLeftMargin);
              break label2032;
              this.endToEnd = paramContext.getResourceId(j, this.endToEnd);
              if (this.endToEnd == -1)
              {
                this.endToEnd = paramContext.getInt(j, -1);
                break label2032;
                this.endToStart = paramContext.getResourceId(j, this.endToStart);
                if (this.endToStart == -1)
                {
                  this.endToStart = paramContext.getInt(j, -1);
                  break label2032;
                  this.startToStart = paramContext.getResourceId(j, this.startToStart);
                  if (this.startToStart == -1)
                  {
                    this.startToStart = paramContext.getInt(j, -1);
                    break label2032;
                    this.startToEnd = paramContext.getResourceId(j, this.startToEnd);
                    if (this.startToEnd == -1)
                    {
                      this.startToEnd = paramContext.getInt(j, -1);
                      break label2032;
                      this.baselineToBaseline = paramContext.getResourceId(j, this.baselineToBaseline);
                      if (this.baselineToBaseline == -1)
                      {
                        this.baselineToBaseline = paramContext.getInt(j, -1);
                        break label2032;
                        this.bottomToBottom = paramContext.getResourceId(j, this.bottomToBottom);
                        if (this.bottomToBottom == -1)
                        {
                          this.bottomToBottom = paramContext.getInt(j, -1);
                          break label2032;
                          this.bottomToTop = paramContext.getResourceId(j, this.bottomToTop);
                          if (this.bottomToTop == -1)
                          {
                            this.bottomToTop = paramContext.getInt(j, -1);
                            break label2032;
                            this.topToBottom = paramContext.getResourceId(j, this.topToBottom);
                            if (this.topToBottom == -1)
                            {
                              this.topToBottom = paramContext.getInt(j, -1);
                              break label2032;
                              this.topToTop = paramContext.getResourceId(j, this.topToTop);
                              if (this.topToTop == -1)
                              {
                                this.topToTop = paramContext.getInt(j, -1);
                                break label2032;
                                this.rightToRight = paramContext.getResourceId(j, this.rightToRight);
                                if (this.rightToRight == -1)
                                {
                                  this.rightToRight = paramContext.getInt(j, -1);
                                  break label2032;
                                  this.rightToLeft = paramContext.getResourceId(j, this.rightToLeft);
                                  if (this.rightToLeft == -1)
                                  {
                                    this.rightToLeft = paramContext.getInt(j, -1);
                                    break label2032;
                                    this.leftToRight = paramContext.getResourceId(j, this.leftToRight);
                                    if (this.leftToRight == -1)
                                    {
                                      this.leftToRight = paramContext.getInt(j, -1);
                                      break label2032;
                                      this.leftToLeft = paramContext.getResourceId(j, this.leftToLeft);
                                      if (this.leftToLeft == -1)
                                      {
                                        this.leftToLeft = paramContext.getInt(j, -1);
                                        break label2032;
                                        this.guidePercent = paramContext.getFloat(j, this.guidePercent);
                                        break label2032;
                                        this.guideEnd = paramContext.getDimensionPixelOffset(j, this.guideEnd);
                                        break label2032;
                                        this.guideBegin = paramContext.getDimensionPixelOffset(j, this.guideBegin);
                                        break label2032;
                                        this.circleAngle = (paramContext.getFloat(j, this.circleAngle) % 360.0F);
                                        if (this.circleAngle < 0.0F)
                                        {
                                          this.circleAngle = ((360.0F - this.circleAngle) % 360.0F);
                                          break label2032;
                                          this.circleRadius = paramContext.getDimensionPixelSize(j, this.circleRadius);
                                          break label2032;
                                          this.circleConstraint = paramContext.getResourceId(j, this.circleConstraint);
                                          if (this.circleConstraint == -1)
                                          {
                                            this.circleConstraint = paramContext.getInt(j, -1);
                                            break label2032;
                                            this.orientation = paramContext.getInt(j, this.orientation);
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label2032:
        i += 1;
      }
      paramContext.recycle();
      validate();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.guideBegin = paramLayoutParams.guideBegin;
      this.guideEnd = paramLayoutParams.guideEnd;
      this.guidePercent = paramLayoutParams.guidePercent;
      this.leftToLeft = paramLayoutParams.leftToLeft;
      this.leftToRight = paramLayoutParams.leftToRight;
      this.rightToLeft = paramLayoutParams.rightToLeft;
      this.rightToRight = paramLayoutParams.rightToRight;
      this.topToTop = paramLayoutParams.topToTop;
      this.topToBottom = paramLayoutParams.topToBottom;
      this.bottomToTop = paramLayoutParams.bottomToTop;
      this.bottomToBottom = paramLayoutParams.bottomToBottom;
      this.baselineToBaseline = paramLayoutParams.baselineToBaseline;
      this.circleConstraint = paramLayoutParams.circleConstraint;
      this.circleRadius = paramLayoutParams.circleRadius;
      this.circleAngle = paramLayoutParams.circleAngle;
      this.startToEnd = paramLayoutParams.startToEnd;
      this.startToStart = paramLayoutParams.startToStart;
      this.endToStart = paramLayoutParams.endToStart;
      this.endToEnd = paramLayoutParams.endToEnd;
      this.goneLeftMargin = paramLayoutParams.goneLeftMargin;
      this.goneTopMargin = paramLayoutParams.goneTopMargin;
      this.goneRightMargin = paramLayoutParams.goneRightMargin;
      this.goneBottomMargin = paramLayoutParams.goneBottomMargin;
      this.goneStartMargin = paramLayoutParams.goneStartMargin;
      this.goneEndMargin = paramLayoutParams.goneEndMargin;
      this.horizontalBias = paramLayoutParams.horizontalBias;
      this.verticalBias = paramLayoutParams.verticalBias;
      this.dimensionRatio = paramLayoutParams.dimensionRatio;
      this.dimensionRatioValue = paramLayoutParams.dimensionRatioValue;
      this.dimensionRatioSide = paramLayoutParams.dimensionRatioSide;
      this.horizontalWeight = paramLayoutParams.horizontalWeight;
      this.verticalWeight = paramLayoutParams.verticalWeight;
      this.horizontalChainStyle = paramLayoutParams.horizontalChainStyle;
      this.verticalChainStyle = paramLayoutParams.verticalChainStyle;
      this.constrainedWidth = paramLayoutParams.constrainedWidth;
      this.constrainedHeight = paramLayoutParams.constrainedHeight;
      this.matchConstraintDefaultWidth = paramLayoutParams.matchConstraintDefaultWidth;
      this.matchConstraintDefaultHeight = paramLayoutParams.matchConstraintDefaultHeight;
      this.matchConstraintMinWidth = paramLayoutParams.matchConstraintMinWidth;
      this.matchConstraintMaxWidth = paramLayoutParams.matchConstraintMaxWidth;
      this.matchConstraintMinHeight = paramLayoutParams.matchConstraintMinHeight;
      this.matchConstraintMaxHeight = paramLayoutParams.matchConstraintMaxHeight;
      this.matchConstraintPercentWidth = paramLayoutParams.matchConstraintPercentWidth;
      this.matchConstraintPercentHeight = paramLayoutParams.matchConstraintPercentHeight;
      this.editorAbsoluteX = paramLayoutParams.editorAbsoluteX;
      this.editorAbsoluteY = paramLayoutParams.editorAbsoluteY;
      this.orientation = paramLayoutParams.orientation;
      this.horizontalDimensionFixed = paramLayoutParams.horizontalDimensionFixed;
      this.verticalDimensionFixed = paramLayoutParams.verticalDimensionFixed;
      this.needsBaseline = paramLayoutParams.needsBaseline;
      this.isGuideline = paramLayoutParams.isGuideline;
      this.resolvedLeftToLeft = paramLayoutParams.resolvedLeftToLeft;
      this.resolvedLeftToRight = paramLayoutParams.resolvedLeftToRight;
      this.resolvedRightToLeft = paramLayoutParams.resolvedRightToLeft;
      this.resolvedRightToRight = paramLayoutParams.resolvedRightToRight;
      this.resolveGoneLeftMargin = paramLayoutParams.resolveGoneLeftMargin;
      this.resolveGoneRightMargin = paramLayoutParams.resolveGoneRightMargin;
      this.resolvedHorizontalBias = paramLayoutParams.resolvedHorizontalBias;
      this.widget = paramLayoutParams.widget;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public void reset()
    {
      if (this.widget != null) {
        this.widget.reset();
      }
    }
    
    @TargetApi(17)
    public void resolveLayoutDirection(int paramInt)
    {
      int j = this.leftMargin;
      int k = this.rightMargin;
      super.resolveLayoutDirection(paramInt);
      this.resolvedRightToLeft = -1;
      this.resolvedRightToRight = -1;
      this.resolvedLeftToLeft = -1;
      this.resolvedLeftToRight = -1;
      this.resolveGoneLeftMargin = -1;
      this.resolveGoneRightMargin = -1;
      this.resolveGoneLeftMargin = this.goneLeftMargin;
      this.resolveGoneRightMargin = this.goneRightMargin;
      this.resolvedHorizontalBias = this.horizontalBias;
      this.resolvedGuideBegin = this.guideBegin;
      this.resolvedGuideEnd = this.guideEnd;
      this.resolvedGuidePercent = this.guidePercent;
      paramInt = getLayoutDirection();
      int i = 0;
      if (1 == paramInt) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0)
      {
        if (this.startToEnd != -1) {
          this.resolvedRightToLeft = this.startToEnd;
        }
        for (;;)
        {
          paramInt = 1;
          break;
          paramInt = i;
          if (this.startToStart == -1) {
            break;
          }
          this.resolvedRightToRight = this.startToStart;
        }
        if (this.endToStart != -1)
        {
          this.resolvedLeftToRight = this.endToStart;
          paramInt = 1;
        }
        if (this.endToEnd != -1)
        {
          this.resolvedLeftToLeft = this.endToEnd;
          paramInt = 1;
        }
        if (this.goneStartMargin != -1) {
          this.resolveGoneRightMargin = this.goneStartMargin;
        }
        if (this.goneEndMargin != -1) {
          this.resolveGoneLeftMargin = this.goneEndMargin;
        }
        if (paramInt != 0) {
          this.resolvedHorizontalBias = (1.0F - this.horizontalBias);
        }
        if ((this.isGuideline) && (this.orientation == 1)) {
          if (this.guidePercent != -1.0F)
          {
            this.resolvedGuidePercent = (1.0F - this.guidePercent);
            this.resolvedGuideBegin = -1;
            this.resolvedGuideEnd = -1;
          }
          else if (this.guideBegin != -1)
          {
            this.resolvedGuideEnd = this.guideBegin;
            this.resolvedGuideBegin = -1;
            this.resolvedGuidePercent = -1.0F;
          }
          else if (this.guideEnd != -1)
          {
            this.resolvedGuideBegin = this.guideEnd;
            this.resolvedGuideEnd = -1;
            this.resolvedGuidePercent = -1.0F;
          }
        }
      }
      else
      {
        if (this.startToEnd != -1) {
          this.resolvedLeftToRight = this.startToEnd;
        }
        if (this.startToStart != -1) {
          this.resolvedLeftToLeft = this.startToStart;
        }
        if (this.endToStart != -1) {
          this.resolvedRightToLeft = this.endToStart;
        }
        if (this.endToEnd != -1) {
          this.resolvedRightToRight = this.endToEnd;
        }
        if (this.goneStartMargin != -1) {
          this.resolveGoneLeftMargin = this.goneStartMargin;
        }
        if (this.goneEndMargin != -1) {
          this.resolveGoneRightMargin = this.goneEndMargin;
        }
      }
      if ((this.endToStart == -1) && (this.endToEnd == -1) && (this.startToStart == -1) && (this.startToEnd == -1))
      {
        if (this.rightToLeft != -1)
        {
          this.resolvedRightToLeft = this.rightToLeft;
          if ((this.rightMargin <= 0) && (k > 0)) {
            this.rightMargin = k;
          }
        }
        else if (this.rightToRight != -1)
        {
          this.resolvedRightToRight = this.rightToRight;
          if ((this.rightMargin <= 0) && (k > 0)) {
            this.rightMargin = k;
          }
        }
        if (this.leftToLeft != -1)
        {
          this.resolvedLeftToLeft = this.leftToLeft;
          if ((this.leftMargin <= 0) && (j > 0)) {
            this.leftMargin = j;
          }
        }
        else if (this.leftToRight != -1)
        {
          this.resolvedLeftToRight = this.leftToRight;
          if ((this.leftMargin <= 0) && (j > 0)) {
            this.leftMargin = j;
          }
        }
      }
    }
    
    public void validate()
    {
      this.isGuideline = false;
      this.horizontalDimensionFixed = true;
      this.verticalDimensionFixed = true;
      if ((this.width == -2) && (this.constrainedWidth))
      {
        this.horizontalDimensionFixed = false;
        this.matchConstraintDefaultWidth = 1;
      }
      if ((this.height == -2) && (this.constrainedHeight))
      {
        this.verticalDimensionFixed = false;
        this.matchConstraintDefaultHeight = 1;
      }
      if ((this.width == 0) || (this.width == -1))
      {
        this.horizontalDimensionFixed = false;
        if ((this.width == 0) && (this.matchConstraintDefaultWidth == 1))
        {
          this.width = -2;
          this.constrainedWidth = true;
        }
      }
      if ((this.height == 0) || (this.height == -1))
      {
        this.verticalDimensionFixed = false;
        if ((this.height == 0) && (this.matchConstraintDefaultHeight == 1))
        {
          this.height = -2;
          this.constrainedHeight = true;
        }
      }
      if ((this.guidePercent != -1.0F) || (this.guideBegin != -1) || (this.guideEnd != -1))
      {
        this.isGuideline = true;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        if (!(this.widget instanceof android.support.constraint.solver.widgets.Guideline)) {
          this.widget = new android.support.constraint.solver.widgets.Guideline();
        }
        ((android.support.constraint.solver.widgets.Guideline)this.widget).setOrientation(this.orientation);
      }
    }
    
    private static class Table
    {
      public static final int ANDROID_ORIENTATION = 1;
      public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
      public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
      public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
      public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
      public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
      public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
      public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
      public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
      public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
      public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
      public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
      public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
      public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
      public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
      public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
      public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
      public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
      public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
      public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
      public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
      public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
      public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
      public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
      public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
      public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
      public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
      public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
      public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
      public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
      public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
      public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
      public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
      public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
      public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
      public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
      public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
      public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
      public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
      public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
      public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
      public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
      public static final int LAYOUT_GONE_MARGIN_END = 26;
      public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
      public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
      public static final int LAYOUT_GONE_MARGIN_START = 25;
      public static final int LAYOUT_GONE_MARGIN_TOP = 22;
      public static final int UNUSED = 0;
      public static final SparseIntArray map = new SparseIntArray();
      
      static
      {
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
        map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
        map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
        map.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\ConstraintLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */