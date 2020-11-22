package android.support.constraint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet
{
  private static final int ALPHA = 43;
  private static final int BARRIER_ALLOWS_GONE_WIDGETS = 74;
  private static final int BARRIER_DIRECTION = 72;
  private static final int BARRIER_TYPE = 1;
  public static final int BASELINE = 5;
  private static final int BASELINE_TO_BASELINE = 1;
  public static final int BOTTOM = 4;
  private static final int BOTTOM_MARGIN = 2;
  private static final int BOTTOM_TO_BOTTOM = 3;
  private static final int BOTTOM_TO_TOP = 4;
  public static final int CHAIN_PACKED = 2;
  public static final int CHAIN_SPREAD = 0;
  public static final int CHAIN_SPREAD_INSIDE = 1;
  private static final int CHAIN_USE_RTL = 71;
  private static final int CIRCLE = 61;
  private static final int CIRCLE_ANGLE = 63;
  private static final int CIRCLE_RADIUS = 62;
  private static final int CONSTRAINT_REFERENCED_IDS = 73;
  private static final boolean DEBUG = false;
  private static final int DIMENSION_RATIO = 5;
  private static final int EDITOR_ABSOLUTE_X = 6;
  private static final int EDITOR_ABSOLUTE_Y = 7;
  private static final int ELEVATION = 44;
  public static final int END = 7;
  private static final int END_MARGIN = 8;
  private static final int END_TO_END = 9;
  private static final int END_TO_START = 10;
  public static final int GONE = 8;
  private static final int GONE_BOTTOM_MARGIN = 11;
  private static final int GONE_END_MARGIN = 12;
  private static final int GONE_LEFT_MARGIN = 13;
  private static final int GONE_RIGHT_MARGIN = 14;
  private static final int GONE_START_MARGIN = 15;
  private static final int GONE_TOP_MARGIN = 16;
  private static final int GUIDE_BEGIN = 17;
  private static final int GUIDE_END = 18;
  private static final int GUIDE_PERCENT = 19;
  private static final int HEIGHT_DEFAULT = 55;
  private static final int HEIGHT_MAX = 57;
  private static final int HEIGHT_MIN = 59;
  private static final int HEIGHT_PERCENT = 70;
  public static final int HORIZONTAL = 0;
  private static final int HORIZONTAL_BIAS = 20;
  public static final int HORIZONTAL_GUIDELINE = 0;
  private static final int HORIZONTAL_STYLE = 41;
  private static final int HORIZONTAL_WEIGHT = 39;
  public static final int INVISIBLE = 4;
  private static final int LAYOUT_HEIGHT = 21;
  private static final int LAYOUT_VISIBILITY = 22;
  private static final int LAYOUT_WIDTH = 23;
  public static final int LEFT = 1;
  private static final int LEFT_MARGIN = 24;
  private static final int LEFT_TO_LEFT = 25;
  private static final int LEFT_TO_RIGHT = 26;
  public static final int MATCH_CONSTRAINT = 0;
  public static final int MATCH_CONSTRAINT_SPREAD = 0;
  public static final int MATCH_CONSTRAINT_WRAP = 1;
  private static final int ORIENTATION = 27;
  public static final int PARENT_ID = 0;
  public static final int RIGHT = 2;
  private static final int RIGHT_MARGIN = 28;
  private static final int RIGHT_TO_LEFT = 29;
  private static final int RIGHT_TO_RIGHT = 30;
  private static final int ROTATION = 60;
  private static final int ROTATION_X = 45;
  private static final int ROTATION_Y = 46;
  private static final int SCALE_X = 47;
  private static final int SCALE_Y = 48;
  public static final int START = 6;
  private static final int START_MARGIN = 31;
  private static final int START_TO_END = 32;
  private static final int START_TO_START = 33;
  private static final String TAG = "ConstraintSet";
  public static final int TOP = 3;
  private static final int TOP_MARGIN = 34;
  private static final int TOP_TO_BOTTOM = 35;
  private static final int TOP_TO_TOP = 36;
  private static final int TRANSFORM_PIVOT_X = 49;
  private static final int TRANSFORM_PIVOT_Y = 50;
  private static final int TRANSLATION_X = 51;
  private static final int TRANSLATION_Y = 52;
  private static final int TRANSLATION_Z = 53;
  public static final int UNSET = -1;
  private static final int UNUSED = 75;
  public static final int VERTICAL = 1;
  private static final int VERTICAL_BIAS = 37;
  public static final int VERTICAL_GUIDELINE = 1;
  private static final int VERTICAL_STYLE = 42;
  private static final int VERTICAL_WEIGHT = 40;
  private static final int VIEW_ID = 38;
  private static final int[] VISIBILITY_FLAGS = { 0, 4, 8 };
  public static final int VISIBLE = 0;
  private static final int WIDTH_DEFAULT = 54;
  private static final int WIDTH_MAX = 56;
  private static final int WIDTH_MIN = 58;
  private static final int WIDTH_PERCENT = 69;
  public static final int WRAP_CONTENT = -2;
  private static SparseIntArray mapToConstant = new SparseIntArray();
  private HashMap<Integer, Constraint> mConstraints = new HashMap();
  
  static
  {
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
    mapToConstant.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
    mapToConstant.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
    mapToConstant.append(R.styleable.ConstraintSet_android_orientation, 27);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 75);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 75);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 75);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 75);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 75);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_width, 23);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_height, 21);
    mapToConstant.append(R.styleable.ConstraintSet_android_visibility, 22);
    mapToConstant.append(R.styleable.ConstraintSet_android_alpha, 43);
    mapToConstant.append(R.styleable.ConstraintSet_android_elevation, 44);
    mapToConstant.append(R.styleable.ConstraintSet_android_rotationX, 45);
    mapToConstant.append(R.styleable.ConstraintSet_android_rotationY, 46);
    mapToConstant.append(R.styleable.ConstraintSet_android_rotation, 60);
    mapToConstant.append(R.styleable.ConstraintSet_android_scaleX, 47);
    mapToConstant.append(R.styleable.ConstraintSet_android_scaleY, 48);
    mapToConstant.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
    mapToConstant.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
    mapToConstant.append(R.styleable.ConstraintSet_android_translationX, 51);
    mapToConstant.append(R.styleable.ConstraintSet_android_translationY, 52);
    mapToConstant.append(R.styleable.ConstraintSet_android_translationZ, 53);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintCircle, 61);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintCircleRadius, 62);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintCircleAngle, 63);
    mapToConstant.append(R.styleable.ConstraintSet_android_id, 38);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintWidth_percent, 69);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHeight_percent, 70);
    mapToConstant.append(R.styleable.ConstraintSet_chainUseRtl, 71);
    mapToConstant.append(R.styleable.ConstraintSet_barrierDirection, 72);
    mapToConstant.append(R.styleable.ConstraintSet_constraint_referenced_ids, 73);
    mapToConstant.append(R.styleable.ConstraintSet_barrierAllowsGoneWidgets, 74);
  }
  
  private int[] convertReferenceString(View paramView, String paramString)
  {
    String[] arrayOfString = paramString.split(",");
    Context localContext = paramView.getContext();
    paramString = new int[arrayOfString.length];
    int m = 0;
    int k = 0;
    while (m < arrayOfString.length)
    {
      Object localObject = arrayOfString[m].trim();
      try
      {
        j = R.id.class.getField((String)localObject).getInt(null);
      }
      catch (Exception localException)
      {
        int j;
        int i;
        for (;;) {}
      }
      j = 0;
      i = j;
      if (j == 0) {
        i = localContext.getResources().getIdentifier((String)localObject, "id", localContext.getPackageName());
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (paramView.isInEditMode())
        {
          j = i;
          if ((paramView.getParent() instanceof ConstraintLayout))
          {
            localObject = ((ConstraintLayout)paramView.getParent()).getDesignInformation(0, localObject);
            j = i;
            if (localObject != null)
            {
              j = i;
              if ((localObject instanceof Integer)) {
                j = ((Integer)localObject).intValue();
              }
            }
          }
        }
      }
      paramString[k] = j;
      m += 1;
      k += 1;
    }
    paramView = paramString;
    if (k != arrayOfString.length) {
      paramView = Arrays.copyOf(paramString, k);
    }
    return paramView;
  }
  
  private void createHorizontalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramArrayOfInt.length >= 2)
    {
      if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
      }
      if (paramArrayOfFloat != null) {
        get(paramArrayOfInt[0]).horizontalWeight = paramArrayOfFloat[0];
      }
      get(paramArrayOfInt[0]).horizontalChainStyle = paramInt5;
      connect(paramArrayOfInt[0], paramInt6, paramInt1, paramInt2, -1);
      paramInt1 = 1;
      while (paramInt1 < paramArrayOfInt.length)
      {
        paramInt2 = paramArrayOfInt[paramInt1];
        paramInt2 = paramArrayOfInt[paramInt1];
        paramInt5 = paramInt1 - 1;
        connect(paramInt2, paramInt6, paramArrayOfInt[paramInt5], paramInt7, -1);
        connect(paramArrayOfInt[paramInt5], paramInt7, paramArrayOfInt[paramInt1], paramInt6, -1);
        if (paramArrayOfFloat != null) {
          get(paramArrayOfInt[paramInt1]).horizontalWeight = paramArrayOfFloat[paramInt1];
        }
        paramInt1 += 1;
      }
      connect(paramArrayOfInt[(paramArrayOfInt.length - 1)], paramInt7, paramInt3, paramInt4, -1);
      return;
    }
    throw new IllegalArgumentException("must have 2 or more widgets in a chain");
  }
  
  private Constraint fillFromAttributeList(Context paramContext, AttributeSet paramAttributeSet)
  {
    Constraint localConstraint = new Constraint(null);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
    populateConstraint(localConstraint, paramContext);
    paramContext.recycle();
    return localConstraint;
  }
  
  private Constraint get(int paramInt)
  {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt))) {
      this.mConstraints.put(Integer.valueOf(paramInt), new Constraint(null));
    }
    return (Constraint)this.mConstraints.get(Integer.valueOf(paramInt));
  }
  
  private static int lookupID(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    int i = paramTypedArray.getResourceId(paramInt1, paramInt2);
    paramInt2 = i;
    if (i == -1) {
      paramInt2 = paramTypedArray.getInt(paramInt1, -1);
    }
    return paramInt2;
  }
  
  private void populateConstraint(Constraint paramConstraint, TypedArray paramTypedArray)
  {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      int m = mapToConstant.get(k);
      switch (m)
      {
      default: 
        switch (m)
        {
        default: 
          StringBuilder localStringBuilder;
          switch (m)
          {
          default: 
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unknown attribute 0x");
            localStringBuilder.append(Integer.toHexString(k));
            localStringBuilder.append("   ");
            localStringBuilder.append(mapToConstant.get(k));
            Log.w("ConstraintSet", localStringBuilder.toString());
            break;
          case 75: 
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("unused attribute 0x");
            localStringBuilder.append(Integer.toHexString(k));
            localStringBuilder.append("   ");
            localStringBuilder.append(mapToConstant.get(k));
            Log.w("ConstraintSet", localStringBuilder.toString());
            break;
          case 74: 
            paramConstraint.mBarrierAllowsGoneWidgets = paramTypedArray.getBoolean(k, paramConstraint.mBarrierAllowsGoneWidgets);
            break;
          case 73: 
            paramConstraint.mReferenceIdString = paramTypedArray.getString(k);
            break;
          case 72: 
            paramConstraint.mBarrierDirection = paramTypedArray.getInt(k, paramConstraint.mBarrierDirection);
            break;
          case 71: 
            Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
            break;
          case 70: 
            paramConstraint.heightPercent = paramTypedArray.getFloat(k, 1.0F);
            break;
          case 69: 
            paramConstraint.widthPercent = paramTypedArray.getFloat(k, 1.0F);
          }
          break;
        case 63: 
          paramConstraint.circleAngle = paramTypedArray.getFloat(k, paramConstraint.circleAngle);
          break;
        case 62: 
          paramConstraint.circleRadius = paramTypedArray.getDimensionPixelSize(k, paramConstraint.circleRadius);
          break;
        case 61: 
          paramConstraint.circleConstraint = lookupID(paramTypedArray, k, paramConstraint.circleConstraint);
          break;
        case 60: 
          paramConstraint.rotation = paramTypedArray.getFloat(k, paramConstraint.rotation);
        }
        break;
      case 53: 
        paramConstraint.translationZ = paramTypedArray.getDimension(k, paramConstraint.translationZ);
        break;
      case 52: 
        paramConstraint.translationY = paramTypedArray.getDimension(k, paramConstraint.translationY);
        break;
      case 51: 
        paramConstraint.translationX = paramTypedArray.getDimension(k, paramConstraint.translationX);
        break;
      case 50: 
        paramConstraint.transformPivotY = paramTypedArray.getFloat(k, paramConstraint.transformPivotY);
        break;
      case 49: 
        paramConstraint.transformPivotX = paramTypedArray.getFloat(k, paramConstraint.transformPivotX);
        break;
      case 48: 
        paramConstraint.scaleY = paramTypedArray.getFloat(k, paramConstraint.scaleY);
        break;
      case 47: 
        paramConstraint.scaleX = paramTypedArray.getFloat(k, paramConstraint.scaleX);
        break;
      case 46: 
        paramConstraint.rotationY = paramTypedArray.getFloat(k, paramConstraint.rotationY);
        break;
      case 45: 
        paramConstraint.rotationX = paramTypedArray.getFloat(k, paramConstraint.rotationX);
        break;
      case 44: 
        paramConstraint.applyElevation = true;
        paramConstraint.elevation = paramTypedArray.getDimension(k, paramConstraint.elevation);
        break;
      case 43: 
        paramConstraint.alpha = paramTypedArray.getFloat(k, paramConstraint.alpha);
        break;
      case 42: 
        paramConstraint.verticalChainStyle = paramTypedArray.getInt(k, paramConstraint.verticalChainStyle);
        break;
      case 41: 
        paramConstraint.horizontalChainStyle = paramTypedArray.getInt(k, paramConstraint.horizontalChainStyle);
        break;
      case 40: 
        paramConstraint.verticalWeight = paramTypedArray.getFloat(k, paramConstraint.verticalWeight);
        break;
      case 39: 
        paramConstraint.horizontalWeight = paramTypedArray.getFloat(k, paramConstraint.horizontalWeight);
        break;
      case 38: 
        paramConstraint.mViewId = paramTypedArray.getResourceId(k, paramConstraint.mViewId);
        break;
      case 37: 
        paramConstraint.verticalBias = paramTypedArray.getFloat(k, paramConstraint.verticalBias);
        break;
      case 36: 
        paramConstraint.topToTop = lookupID(paramTypedArray, k, paramConstraint.topToTop);
        break;
      case 35: 
        paramConstraint.topToBottom = lookupID(paramTypedArray, k, paramConstraint.topToBottom);
        break;
      case 34: 
        paramConstraint.topMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.topMargin);
        break;
      case 33: 
        paramConstraint.startToStart = lookupID(paramTypedArray, k, paramConstraint.startToStart);
        break;
      case 32: 
        paramConstraint.startToEnd = lookupID(paramTypedArray, k, paramConstraint.startToEnd);
        break;
      case 31: 
        paramConstraint.startMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.startMargin);
        break;
      case 30: 
        paramConstraint.rightToRight = lookupID(paramTypedArray, k, paramConstraint.rightToRight);
        break;
      case 29: 
        paramConstraint.rightToLeft = lookupID(paramTypedArray, k, paramConstraint.rightToLeft);
        break;
      case 28: 
        paramConstraint.rightMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.rightMargin);
        break;
      case 27: 
        paramConstraint.orientation = paramTypedArray.getInt(k, paramConstraint.orientation);
        break;
      case 26: 
        paramConstraint.leftToRight = lookupID(paramTypedArray, k, paramConstraint.leftToRight);
        break;
      case 25: 
        paramConstraint.leftToLeft = lookupID(paramTypedArray, k, paramConstraint.leftToLeft);
        break;
      case 24: 
        paramConstraint.leftMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.leftMargin);
        break;
      case 23: 
        paramConstraint.mWidth = paramTypedArray.getLayoutDimension(k, paramConstraint.mWidth);
        break;
      case 22: 
        paramConstraint.visibility = paramTypedArray.getInt(k, paramConstraint.visibility);
        paramConstraint.visibility = VISIBILITY_FLAGS[paramConstraint.visibility];
        break;
      case 21: 
        paramConstraint.mHeight = paramTypedArray.getLayoutDimension(k, paramConstraint.mHeight);
        break;
      case 20: 
        paramConstraint.horizontalBias = paramTypedArray.getFloat(k, paramConstraint.horizontalBias);
        break;
      case 19: 
        paramConstraint.guidePercent = paramTypedArray.getFloat(k, paramConstraint.guidePercent);
        break;
      case 18: 
        paramConstraint.guideEnd = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.guideEnd);
        break;
      case 17: 
        paramConstraint.guideBegin = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.guideBegin);
        break;
      case 16: 
        paramConstraint.goneTopMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneTopMargin);
        break;
      case 15: 
        paramConstraint.goneStartMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneStartMargin);
        break;
      case 14: 
        paramConstraint.goneRightMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneRightMargin);
        break;
      case 13: 
        paramConstraint.goneLeftMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneLeftMargin);
        break;
      case 12: 
        paramConstraint.goneEndMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneEndMargin);
        break;
      case 11: 
        paramConstraint.goneBottomMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.goneBottomMargin);
        break;
      case 10: 
        paramConstraint.endToStart = lookupID(paramTypedArray, k, paramConstraint.endToStart);
        break;
      case 9: 
        paramConstraint.endToEnd = lookupID(paramTypedArray, k, paramConstraint.endToEnd);
        break;
      case 8: 
        paramConstraint.endMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.endMargin);
        break;
      case 7: 
        paramConstraint.editorAbsoluteY = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.editorAbsoluteY);
        break;
      case 6: 
        paramConstraint.editorAbsoluteX = paramTypedArray.getDimensionPixelOffset(k, paramConstraint.editorAbsoluteX);
        break;
      case 5: 
        paramConstraint.dimensionRatio = paramTypedArray.getString(k);
        break;
      case 4: 
        paramConstraint.bottomToTop = lookupID(paramTypedArray, k, paramConstraint.bottomToTop);
        break;
      case 3: 
        paramConstraint.bottomToBottom = lookupID(paramTypedArray, k, paramConstraint.bottomToBottom);
        break;
      case 2: 
        paramConstraint.bottomMargin = paramTypedArray.getDimensionPixelSize(k, paramConstraint.bottomMargin);
        break;
      case 1: 
        paramConstraint.baselineToBaseline = lookupID(paramTypedArray, k, paramConstraint.baselineToBaseline);
      }
      i += 1;
    }
  }
  
  private String sideToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "undefined";
    case 7: 
      return "end";
    case 6: 
      return "start";
    case 5: 
      return "baseline";
    case 4: 
      return "bottom";
    case 3: 
      return "top";
    case 2: 
      return "right";
    }
    return "left";
  }
  
  public void addToHorizontalChain(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (paramInt2 == 0) {
      i = 1;
    } else {
      i = 2;
    }
    connect(paramInt1, 1, paramInt2, i, 0);
    if (paramInt3 == 0) {
      i = 2;
    } else {
      i = 1;
    }
    connect(paramInt1, 2, paramInt3, i, 0);
    if (paramInt2 != 0) {
      connect(paramInt2, 2, paramInt1, 1, 0);
    }
    if (paramInt3 != 0) {
      connect(paramInt3, 1, paramInt1, 2, 0);
    }
  }
  
  public void addToHorizontalChainRTL(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (paramInt2 == 0) {
      i = 6;
    } else {
      i = 7;
    }
    connect(paramInt1, 6, paramInt2, i, 0);
    if (paramInt3 == 0) {
      i = 7;
    } else {
      i = 6;
    }
    connect(paramInt1, 7, paramInt3, i, 0);
    if (paramInt2 != 0) {
      connect(paramInt2, 7, paramInt1, 6, 0);
    }
    if (paramInt3 != 0) {
      connect(paramInt3, 6, paramInt1, 7, 0);
    }
  }
  
  public void addToVerticalChain(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (paramInt2 == 0) {
      i = 3;
    } else {
      i = 4;
    }
    connect(paramInt1, 3, paramInt2, i, 0);
    if (paramInt3 == 0) {
      i = 4;
    } else {
      i = 3;
    }
    connect(paramInt1, 4, paramInt3, i, 0);
    if (paramInt2 != 0) {
      connect(paramInt2, 4, paramInt1, 3, 0);
    }
    if (paramInt2 != 0) {
      connect(paramInt3, 3, paramInt1, 4, 0);
    }
  }
  
  public void applyTo(ConstraintLayout paramConstraintLayout)
  {
    applyToInternal(paramConstraintLayout);
    paramConstraintLayout.setConstraintSet(null);
  }
  
  void applyToInternal(ConstraintLayout paramConstraintLayout)
  {
    int j = paramConstraintLayout.getChildCount();
    Object localObject1 = new HashSet(this.mConstraints.keySet());
    int i = 0;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    while (i < j)
    {
      localObject2 = paramConstraintLayout.getChildAt(i);
      int k = ((View)localObject2).getId();
      if (k != -1)
      {
        if (this.mConstraints.containsKey(Integer.valueOf(k)))
        {
          ((HashSet)localObject1).remove(Integer.valueOf(k));
          localObject3 = (Constraint)this.mConstraints.get(Integer.valueOf(k));
          if ((localObject2 instanceof Barrier)) {
            ((Constraint)localObject3).mHelperType = 1;
          }
          if ((((Constraint)localObject3).mHelperType != -1) && (((Constraint)localObject3).mHelperType == 1))
          {
            localObject4 = (Barrier)localObject2;
            ((Barrier)localObject4).setId(k);
            ((Barrier)localObject4).setType(((Constraint)localObject3).mBarrierDirection);
            ((Barrier)localObject4).setAllowsGoneWidget(((Constraint)localObject3).mBarrierAllowsGoneWidgets);
            if (((Constraint)localObject3).mReferenceIds != null)
            {
              ((Barrier)localObject4).setReferencedIds(((Constraint)localObject3).mReferenceIds);
            }
            else if (((Constraint)localObject3).mReferenceIdString != null)
            {
              ((Constraint)localObject3).mReferenceIds = convertReferenceString((View)localObject4, ((Constraint)localObject3).mReferenceIdString);
              ((Barrier)localObject4).setReferencedIds(((Constraint)localObject3).mReferenceIds);
            }
          }
          localObject4 = (ConstraintLayout.LayoutParams)((View)localObject2).getLayoutParams();
          ((Constraint)localObject3).applyTo((ConstraintLayout.LayoutParams)localObject4);
          ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          ((View)localObject2).setVisibility(((Constraint)localObject3).visibility);
          if (Build.VERSION.SDK_INT >= 17)
          {
            ((View)localObject2).setAlpha(((Constraint)localObject3).alpha);
            ((View)localObject2).setRotation(((Constraint)localObject3).rotation);
            ((View)localObject2).setRotationX(((Constraint)localObject3).rotationX);
            ((View)localObject2).setRotationY(((Constraint)localObject3).rotationY);
            ((View)localObject2).setScaleX(((Constraint)localObject3).scaleX);
            ((View)localObject2).setScaleY(((Constraint)localObject3).scaleY);
            if (!Float.isNaN(((Constraint)localObject3).transformPivotX)) {
              ((View)localObject2).setPivotX(((Constraint)localObject3).transformPivotX);
            }
            if (!Float.isNaN(((Constraint)localObject3).transformPivotY)) {
              ((View)localObject2).setPivotY(((Constraint)localObject3).transformPivotY);
            }
            ((View)localObject2).setTranslationX(((Constraint)localObject3).translationX);
            ((View)localObject2).setTranslationY(((Constraint)localObject3).translationY);
            if (Build.VERSION.SDK_INT >= 21)
            {
              ((View)localObject2).setTranslationZ(((Constraint)localObject3).translationZ);
              if (((Constraint)localObject3).applyElevation) {
                ((View)localObject2).setElevation(((Constraint)localObject3).elevation);
              }
            }
          }
        }
        i += 1;
      }
      else
      {
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      }
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject1).next();
      localObject2 = (Constraint)this.mConstraints.get(localObject3);
      if ((((Constraint)localObject2).mHelperType != -1) && (((Constraint)localObject2).mHelperType == 1))
      {
        localObject4 = new Barrier(paramConstraintLayout.getContext());
        ((Barrier)localObject4).setId(((Integer)localObject3).intValue());
        if (((Constraint)localObject2).mReferenceIds != null)
        {
          ((Barrier)localObject4).setReferencedIds(((Constraint)localObject2).mReferenceIds);
        }
        else if (((Constraint)localObject2).mReferenceIdString != null)
        {
          ((Constraint)localObject2).mReferenceIds = convertReferenceString((View)localObject4, ((Constraint)localObject2).mReferenceIdString);
          ((Barrier)localObject4).setReferencedIds(((Constraint)localObject2).mReferenceIds);
        }
        ((Barrier)localObject4).setType(((Constraint)localObject2).mBarrierDirection);
        ConstraintLayout.LayoutParams localLayoutParams = paramConstraintLayout.generateDefaultLayoutParams();
        ((Barrier)localObject4).validateParams();
        ((Constraint)localObject2).applyTo(localLayoutParams);
        paramConstraintLayout.addView((View)localObject4, localLayoutParams);
      }
      if (((Constraint)localObject2).mIsGuideline)
      {
        localObject4 = new Guideline(paramConstraintLayout.getContext());
        ((Guideline)localObject4).setId(((Integer)localObject3).intValue());
        localObject3 = paramConstraintLayout.generateDefaultLayoutParams();
        ((Constraint)localObject2).applyTo((ConstraintLayout.LayoutParams)localObject3);
        paramConstraintLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
      }
    }
  }
  
  public void center(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    if (paramInt4 >= 0)
    {
      if (paramInt7 >= 0)
      {
        if ((paramFloat > 0.0F) && (paramFloat <= 1.0F))
        {
          if ((paramInt3 != 1) && (paramInt3 != 2))
          {
            if ((paramInt3 != 6) && (paramInt3 != 7))
            {
              connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
              connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
              ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).verticalBias = paramFloat;
              return;
            }
            connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
            connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
            ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
            return;
          }
          connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
          connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
          ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
          return;
        }
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
      }
      throw new IllegalArgumentException("margin must be > 0");
    }
    throw new IllegalArgumentException("margin must be > 0");
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 1, 0, 0, 2, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 2, 0, paramInt2, 1, 0, 0.5F);
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
  }
  
  public void centerHorizontallyRtl(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 6, 0, 0, 7, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 7, 0, paramInt2, 6, 0, 0.5F);
  }
  
  public void centerHorizontallyRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 6, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 7, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
  }
  
  public void centerVertically(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      center(paramInt1, 0, 3, 0, 0, 4, 0, 0.5F);
      return;
    }
    center(paramInt1, paramInt2, 4, 0, paramInt2, 3, 0, 0.5F);
  }
  
  public void centerVertically(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
    ((Constraint)this.mConstraints.get(Integer.valueOf(paramInt1))).verticalBias = paramFloat;
  }
  
  public void clear(int paramInt)
  {
    this.mConstraints.remove(Integer.valueOf(paramInt));
  }
  
  public void clear(int paramInt1, int paramInt2)
  {
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt1)))
    {
      Constraint localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt1));
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("unknown constraint");
      case 7: 
        localConstraint.endToStart = -1;
        localConstraint.endToEnd = -1;
        localConstraint.endMargin = -1;
        localConstraint.goneEndMargin = -1;
        return;
      case 6: 
        localConstraint.startToEnd = -1;
        localConstraint.startToStart = -1;
        localConstraint.startMargin = -1;
        localConstraint.goneStartMargin = -1;
        return;
      case 5: 
        localConstraint.baselineToBaseline = -1;
        return;
      case 4: 
        localConstraint.bottomToTop = -1;
        localConstraint.bottomToBottom = -1;
        localConstraint.bottomMargin = -1;
        localConstraint.goneBottomMargin = -1;
        return;
      case 3: 
        localConstraint.topToBottom = -1;
        localConstraint.topToTop = -1;
        localConstraint.topMargin = -1;
        localConstraint.goneTopMargin = -1;
        return;
      case 2: 
        localConstraint.rightToRight = -1;
        localConstraint.rightToLeft = -1;
        localConstraint.rightMargin = -1;
        localConstraint.goneRightMargin = -1;
        return;
      }
      localConstraint.leftToRight = -1;
      localConstraint.leftToLeft = -1;
      localConstraint.leftMargin = -1;
      localConstraint.goneLeftMargin = -1;
    }
  }
  
  public void clone(Context paramContext, int paramInt)
  {
    clone((ConstraintLayout)LayoutInflater.from(paramContext).inflate(paramInt, null));
  }
  
  public void clone(ConstraintLayout paramConstraintLayout)
  {
    int j = paramConstraintLayout.getChildCount();
    this.mConstraints.clear();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramConstraintLayout.getChildAt(i);
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)((View)localObject).getLayoutParams();
      int k = ((View)localObject).getId();
      if (k != -1)
      {
        if (!this.mConstraints.containsKey(Integer.valueOf(k))) {
          this.mConstraints.put(Integer.valueOf(k), new Constraint(null));
        }
        Constraint localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(k));
        localConstraint.fillFrom(k, localLayoutParams);
        localConstraint.visibility = ((View)localObject).getVisibility();
        if (Build.VERSION.SDK_INT >= 17)
        {
          localConstraint.alpha = ((View)localObject).getAlpha();
          localConstraint.rotation = ((View)localObject).getRotation();
          localConstraint.rotationX = ((View)localObject).getRotationX();
          localConstraint.rotationY = ((View)localObject).getRotationY();
          localConstraint.scaleX = ((View)localObject).getScaleX();
          localConstraint.scaleY = ((View)localObject).getScaleY();
          float f1 = ((View)localObject).getPivotX();
          float f2 = ((View)localObject).getPivotY();
          if ((f1 != 0.0D) || (f2 != 0.0D))
          {
            localConstraint.transformPivotX = f1;
            localConstraint.transformPivotY = f2;
          }
          localConstraint.translationX = ((View)localObject).getTranslationX();
          localConstraint.translationY = ((View)localObject).getTranslationY();
          if (Build.VERSION.SDK_INT >= 21)
          {
            localConstraint.translationZ = ((View)localObject).getTranslationZ();
            if (localConstraint.applyElevation) {
              localConstraint.elevation = ((View)localObject).getElevation();
            }
          }
        }
        if ((localObject instanceof Barrier))
        {
          localObject = (Barrier)localObject;
          localConstraint.mBarrierAllowsGoneWidgets = ((Barrier)localObject).allowsGoneWidget();
          localConstraint.mReferenceIds = ((Barrier)localObject).getReferencedIds();
          localConstraint.mBarrierDirection = ((Barrier)localObject).getType();
        }
        i += 1;
      }
      else
      {
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      }
    }
  }
  
  public void clone(ConstraintSet paramConstraintSet)
  {
    this.mConstraints.clear();
    Iterator localIterator = paramConstraintSet.mConstraints.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      this.mConstraints.put(localInteger, ((Constraint)paramConstraintSet.mConstraints.get(localInteger)).clone());
    }
  }
  
  public void clone(Constraints paramConstraints)
  {
    int j = paramConstraints.getChildCount();
    this.mConstraints.clear();
    int i = 0;
    while (i < j)
    {
      View localView = paramConstraints.getChildAt(i);
      Constraints.LayoutParams localLayoutParams = (Constraints.LayoutParams)localView.getLayoutParams();
      int k = localView.getId();
      if (k != -1)
      {
        if (!this.mConstraints.containsKey(Integer.valueOf(k))) {
          this.mConstraints.put(Integer.valueOf(k), new Constraint(null));
        }
        Constraint localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(k));
        if ((localView instanceof ConstraintHelper)) {
          localConstraint.fillFromConstraints((ConstraintHelper)localView, k, localLayoutParams);
        }
        localConstraint.fillFromConstraints(k, localLayoutParams);
        i += 1;
      }
      else
      {
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      }
    }
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt1))) {
      this.mConstraints.put(Integer.valueOf(paramInt1), new Constraint(null));
    }
    Object localObject = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(sideToString(paramInt2));
      ((StringBuilder)localObject).append(" to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" unknown");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 7: 
      if (paramInt4 == 7)
      {
        ((Constraint)localObject).endToEnd = paramInt3;
        ((Constraint)localObject).endToStart = -1;
        return;
      }
      if (paramInt4 == 6)
      {
        ((Constraint)localObject).endToStart = paramInt3;
        ((Constraint)localObject).endToEnd = -1;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 6: 
      if (paramInt4 == 6)
      {
        ((Constraint)localObject).startToStart = paramInt3;
        ((Constraint)localObject).startToEnd = -1;
        return;
      }
      if (paramInt4 == 7)
      {
        ((Constraint)localObject).startToEnd = paramInt3;
        ((Constraint)localObject).startToStart = -1;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 5: 
      if (paramInt4 == 5)
      {
        ((Constraint)localObject).baselineToBaseline = paramInt3;
        ((Constraint)localObject).bottomToBottom = -1;
        ((Constraint)localObject).bottomToTop = -1;
        ((Constraint)localObject).topToTop = -1;
        ((Constraint)localObject).topToBottom = -1;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 4: 
      if (paramInt4 == 4)
      {
        ((Constraint)localObject).bottomToBottom = paramInt3;
        ((Constraint)localObject).bottomToTop = -1;
        ((Constraint)localObject).baselineToBaseline = -1;
        return;
      }
      if (paramInt4 == 3)
      {
        ((Constraint)localObject).bottomToTop = paramInt3;
        ((Constraint)localObject).bottomToBottom = -1;
        ((Constraint)localObject).baselineToBaseline = -1;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 3: 
      if (paramInt4 == 3)
      {
        ((Constraint)localObject).topToTop = paramInt3;
        ((Constraint)localObject).topToBottom = -1;
        ((Constraint)localObject).baselineToBaseline = -1;
        return;
      }
      if (paramInt4 == 4)
      {
        ((Constraint)localObject).topToBottom = paramInt3;
        ((Constraint)localObject).topToTop = -1;
        ((Constraint)localObject).baselineToBaseline = -1;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 2: 
      if (paramInt4 == 1)
      {
        ((Constraint)localObject).rightToLeft = paramInt3;
        ((Constraint)localObject).rightToRight = -1;
        return;
      }
      if (paramInt4 == 2)
      {
        ((Constraint)localObject).rightToRight = paramInt3;
        ((Constraint)localObject).rightToLeft = -1;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    if (paramInt4 == 1)
    {
      ((Constraint)localObject).leftToLeft = paramInt3;
      ((Constraint)localObject).leftToRight = -1;
      return;
    }
    if (paramInt4 == 2)
    {
      ((Constraint)localObject).leftToRight = paramInt3;
      ((Constraint)localObject).leftToLeft = -1;
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("left to ");
    ((StringBuilder)localObject).append(sideToString(paramInt4));
    ((StringBuilder)localObject).append(" undefined");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!this.mConstraints.containsKey(Integer.valueOf(paramInt1))) {
      this.mConstraints.put(Integer.valueOf(paramInt1), new Constraint(null));
    }
    Object localObject = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(sideToString(paramInt2));
      ((StringBuilder)localObject).append(" to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" unknown");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 7: 
      if (paramInt4 == 7)
      {
        ((Constraint)localObject).endToEnd = paramInt3;
        ((Constraint)localObject).endToStart = -1;
      }
      else
      {
        if (paramInt4 != 6) {
          break label204;
        }
        ((Constraint)localObject).endToStart = paramInt3;
        ((Constraint)localObject).endToEnd = -1;
      }
      ((Constraint)localObject).endMargin = paramInt5;
      return;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 6: 
      if (paramInt4 == 6)
      {
        ((Constraint)localObject).startToStart = paramInt3;
        ((Constraint)localObject).startToEnd = -1;
      }
      else
      {
        if (paramInt4 != 7) {
          break label305;
        }
        ((Constraint)localObject).startToEnd = paramInt3;
        ((Constraint)localObject).startToStart = -1;
      }
      ((Constraint)localObject).startMargin = paramInt5;
      return;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 5: 
      if (paramInt4 == 5)
      {
        ((Constraint)localObject).baselineToBaseline = paramInt3;
        ((Constraint)localObject).bottomToBottom = -1;
        ((Constraint)localObject).bottomToTop = -1;
        ((Constraint)localObject).topToTop = -1;
        ((Constraint)localObject).topToBottom = -1;
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 4: 
      if (paramInt4 == 4)
      {
        ((Constraint)localObject).bottomToBottom = paramInt3;
        ((Constraint)localObject).bottomToTop = -1;
        ((Constraint)localObject).baselineToBaseline = -1;
      }
      else
      {
        if (paramInt4 != 3) {
          break label505;
        }
        ((Constraint)localObject).bottomToTop = paramInt3;
        ((Constraint)localObject).bottomToBottom = -1;
        ((Constraint)localObject).baselineToBaseline = -1;
      }
      ((Constraint)localObject).bottomMargin = paramInt5;
      return;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 3: 
      if (paramInt4 == 3)
      {
        ((Constraint)localObject).topToTop = paramInt3;
        ((Constraint)localObject).topToBottom = -1;
        ((Constraint)localObject).baselineToBaseline = -1;
      }
      else
      {
        if (paramInt4 != 4) {
          break label616;
        }
        ((Constraint)localObject).topToBottom = paramInt3;
        ((Constraint)localObject).topToTop = -1;
        ((Constraint)localObject).baselineToBaseline = -1;
      }
      ((Constraint)localObject).topMargin = paramInt5;
      return;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 2: 
      label204:
      label305:
      label505:
      label616:
      if (paramInt4 == 1)
      {
        ((Constraint)localObject).rightToLeft = paramInt3;
        ((Constraint)localObject).rightToRight = -1;
      }
      else
      {
        if (paramInt4 != 2) {
          break label715;
        }
        ((Constraint)localObject).rightToRight = paramInt3;
        ((Constraint)localObject).rightToLeft = -1;
      }
      ((Constraint)localObject).rightMargin = paramInt5;
      return;
      label715:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("right to ");
      ((StringBuilder)localObject).append(sideToString(paramInt4));
      ((StringBuilder)localObject).append(" undefined");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    if (paramInt4 == 1)
    {
      ((Constraint)localObject).leftToLeft = paramInt3;
      ((Constraint)localObject).leftToRight = -1;
    }
    else
    {
      if (paramInt4 != 2) {
        break label814;
      }
      ((Constraint)localObject).leftToRight = paramInt3;
      ((Constraint)localObject).leftToLeft = -1;
    }
    ((Constraint)localObject).leftMargin = paramInt5;
    return;
    label814:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Left to ");
    ((StringBuilder)localObject).append(sideToString(paramInt4));
    ((StringBuilder)localObject).append(" undefined");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void constrainCircle(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    Constraint localConstraint = get(paramInt1);
    localConstraint.circleConstraint = paramInt2;
    localConstraint.circleRadius = paramInt3;
    localConstraint.circleAngle = paramFloat;
  }
  
  public void constrainDefaultHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).heightDefault = paramInt2;
  }
  
  public void constrainDefaultWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).widthDefault = paramInt2;
  }
  
  public void constrainHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).mHeight = paramInt2;
  }
  
  public void constrainMaxHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).heightMax = paramInt2;
  }
  
  public void constrainMaxWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).widthMax = paramInt2;
  }
  
  public void constrainMinHeight(int paramInt1, int paramInt2)
  {
    get(paramInt1).heightMin = paramInt2;
  }
  
  public void constrainMinWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).widthMin = paramInt2;
  }
  
  public void constrainPercentHeight(int paramInt, float paramFloat)
  {
    get(paramInt).heightPercent = paramFloat;
  }
  
  public void constrainPercentWidth(int paramInt, float paramFloat)
  {
    get(paramInt).widthPercent = paramFloat;
  }
  
  public void constrainWidth(int paramInt1, int paramInt2)
  {
    get(paramInt1).mWidth = paramInt2;
  }
  
  public void create(int paramInt1, int paramInt2)
  {
    Constraint localConstraint = get(paramInt1);
    localConstraint.mIsGuideline = true;
    localConstraint.orientation = paramInt2;
  }
  
  public void createBarrier(int paramInt1, int paramInt2, int... paramVarArgs)
  {
    Constraint localConstraint = get(paramInt1);
    localConstraint.mHelperType = 1;
    localConstraint.mBarrierDirection = paramInt2;
    localConstraint.mIsGuideline = false;
    localConstraint.mReferenceIds = paramVarArgs;
  }
  
  public void createHorizontalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    createHorizontalChain(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramArrayOfFloat, paramInt5, 1, 2);
  }
  
  public void createHorizontalChainRtl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    createHorizontalChain(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramArrayOfFloat, paramInt5, 6, 7);
  }
  
  public void createVerticalChain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    if (paramArrayOfInt.length >= 2)
    {
      if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
      }
      if (paramArrayOfFloat != null) {
        get(paramArrayOfInt[0]).verticalWeight = paramArrayOfFloat[0];
      }
      get(paramArrayOfInt[0]).verticalChainStyle = paramInt5;
      connect(paramArrayOfInt[0], 3, paramInt1, paramInt2, 0);
      paramInt1 = 1;
      while (paramInt1 < paramArrayOfInt.length)
      {
        paramInt2 = paramArrayOfInt[paramInt1];
        paramInt2 = paramArrayOfInt[paramInt1];
        paramInt5 = paramInt1 - 1;
        connect(paramInt2, 3, paramArrayOfInt[paramInt5], 4, 0);
        connect(paramArrayOfInt[paramInt5], 4, paramArrayOfInt[paramInt1], 3, 0);
        if (paramArrayOfFloat != null) {
          get(paramArrayOfInt[paramInt1]).verticalWeight = paramArrayOfFloat[paramInt1];
        }
        paramInt1 += 1;
      }
      connect(paramArrayOfInt[(paramArrayOfInt.length - 1)], 4, paramInt3, paramInt4, 0);
      return;
    }
    throw new IllegalArgumentException("must have 2 or more widgets in a chain");
  }
  
  public boolean getApplyElevation(int paramInt)
  {
    return get(paramInt).applyElevation;
  }
  
  public Constraint getParameters(int paramInt)
  {
    return get(paramInt);
  }
  
  public void load(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    try
    {
      paramInt = localXmlResourceParser.getEventType();
    }
    catch (IOException paramContext)
    {
      String str;
      Constraint localConstraint;
      paramContext.printStackTrace();
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
    }
    str = localXmlResourceParser.getName();
    localConstraint = fillFromAttributeList(paramContext, Xml.asAttributeSet(localXmlResourceParser));
    if (str.equalsIgnoreCase("Guideline")) {
      localConstraint.mIsGuideline = true;
    }
    this.mConstraints.put(Integer.valueOf(localConstraint.mViewId), localConstraint);
    break label83;
    localXmlResourceParser.getName();
    for (;;)
    {
      label83:
      paramInt = localXmlResourceParser.next();
      while (paramInt == 1) {
        return;
      }
      if (paramInt == 0) {
        break;
      }
      switch (paramInt)
      {
      }
    }
  }
  
  public void removeFromHorizontalChain(int paramInt)
  {
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt)))
    {
      Constraint localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt));
      int i = localConstraint.leftToRight;
      int j = localConstraint.rightToLeft;
      if ((i == -1) && (j == -1))
      {
        j = localConstraint.startToEnd;
        int k = localConstraint.endToStart;
        if ((j != -1) || (k != -1)) {
          if ((j != -1) && (k != -1))
          {
            connect(j, 7, k, 6, 0);
            connect(k, 6, i, 7, 0);
          }
          else if ((i != -1) || (k != -1))
          {
            if (localConstraint.rightToRight != -1) {
              connect(i, 7, localConstraint.rightToRight, 7, 0);
            } else if (localConstraint.leftToLeft != -1) {
              connect(k, 6, localConstraint.leftToLeft, 6, 0);
            }
          }
        }
        clear(paramInt, 6);
        clear(paramInt, 7);
        return;
      }
      if ((i != -1) && (j != -1))
      {
        connect(i, 2, j, 1, 0);
        connect(j, 1, i, 2, 0);
      }
      else if ((i != -1) || (j != -1))
      {
        if (localConstraint.rightToRight != -1) {
          connect(i, 2, localConstraint.rightToRight, 2, 0);
        } else if (localConstraint.leftToLeft != -1) {
          connect(j, 1, localConstraint.leftToLeft, 1, 0);
        }
      }
      clear(paramInt, 1);
      clear(paramInt, 2);
    }
  }
  
  public void removeFromVerticalChain(int paramInt)
  {
    if (this.mConstraints.containsKey(Integer.valueOf(paramInt)))
    {
      Constraint localConstraint = (Constraint)this.mConstraints.get(Integer.valueOf(paramInt));
      int i = localConstraint.topToBottom;
      int j = localConstraint.bottomToTop;
      if ((i != -1) || (j != -1)) {
        if ((i != -1) && (j != -1))
        {
          connect(i, 4, j, 3, 0);
          connect(j, 3, i, 4, 0);
        }
        else if ((i != -1) || (j != -1))
        {
          if (localConstraint.bottomToBottom != -1) {
            connect(i, 4, localConstraint.bottomToBottom, 4, 0);
          } else if (localConstraint.topToTop != -1) {
            connect(j, 3, localConstraint.topToTop, 3, 0);
          }
        }
      }
    }
    clear(paramInt, 3);
    clear(paramInt, 4);
  }
  
  public void setAlpha(int paramInt, float paramFloat)
  {
    get(paramInt).alpha = paramFloat;
  }
  
  public void setApplyElevation(int paramInt, boolean paramBoolean)
  {
    get(paramInt).applyElevation = paramBoolean;
  }
  
  public void setBarrierType(int paramInt1, int paramInt2) {}
  
  public void setDimensionRatio(int paramInt, String paramString)
  {
    get(paramInt).dimensionRatio = paramString;
  }
  
  public void setElevation(int paramInt, float paramFloat)
  {
    get(paramInt).elevation = paramFloat;
    get(paramInt).applyElevation = true;
  }
  
  public void setGoneMargin(int paramInt1, int paramInt2, int paramInt3)
  {
    Constraint localConstraint = get(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 7: 
      localConstraint.goneEndMargin = paramInt3;
      return;
    case 6: 
      localConstraint.goneStartMargin = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 4: 
      localConstraint.goneBottomMargin = paramInt3;
      return;
    case 3: 
      localConstraint.goneTopMargin = paramInt3;
      return;
    case 2: 
      localConstraint.goneRightMargin = paramInt3;
      return;
    }
    localConstraint.goneLeftMargin = paramInt3;
  }
  
  public void setGuidelineBegin(int paramInt1, int paramInt2)
  {
    get(paramInt1).guideBegin = paramInt2;
    get(paramInt1).guideEnd = -1;
    get(paramInt1).guidePercent = -1.0F;
  }
  
  public void setGuidelineEnd(int paramInt1, int paramInt2)
  {
    get(paramInt1).guideEnd = paramInt2;
    get(paramInt1).guideBegin = -1;
    get(paramInt1).guidePercent = -1.0F;
  }
  
  public void setGuidelinePercent(int paramInt, float paramFloat)
  {
    get(paramInt).guidePercent = paramFloat;
    get(paramInt).guideEnd = -1;
    get(paramInt).guideBegin = -1;
  }
  
  public void setHorizontalBias(int paramInt, float paramFloat)
  {
    get(paramInt).horizontalBias = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt1, int paramInt2)
  {
    get(paramInt1).horizontalChainStyle = paramInt2;
  }
  
  public void setHorizontalWeight(int paramInt, float paramFloat)
  {
    get(paramInt).horizontalWeight = paramFloat;
  }
  
  public void setMargin(int paramInt1, int paramInt2, int paramInt3)
  {
    Constraint localConstraint = get(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 7: 
      localConstraint.endMargin = paramInt3;
      return;
    case 6: 
      localConstraint.startMargin = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 4: 
      localConstraint.bottomMargin = paramInt3;
      return;
    case 3: 
      localConstraint.topMargin = paramInt3;
      return;
    case 2: 
      localConstraint.rightMargin = paramInt3;
      return;
    }
    localConstraint.leftMargin = paramInt3;
  }
  
  public void setRotation(int paramInt, float paramFloat)
  {
    get(paramInt).rotation = paramFloat;
  }
  
  public void setRotationX(int paramInt, float paramFloat)
  {
    get(paramInt).rotationX = paramFloat;
  }
  
  public void setRotationY(int paramInt, float paramFloat)
  {
    get(paramInt).rotationY = paramFloat;
  }
  
  public void setScaleX(int paramInt, float paramFloat)
  {
    get(paramInt).scaleX = paramFloat;
  }
  
  public void setScaleY(int paramInt, float paramFloat)
  {
    get(paramInt).scaleY = paramFloat;
  }
  
  public void setTransformPivot(int paramInt, float paramFloat1, float paramFloat2)
  {
    Constraint localConstraint = get(paramInt);
    localConstraint.transformPivotY = paramFloat2;
    localConstraint.transformPivotX = paramFloat1;
  }
  
  public void setTransformPivotX(int paramInt, float paramFloat)
  {
    get(paramInt).transformPivotX = paramFloat;
  }
  
  public void setTransformPivotY(int paramInt, float paramFloat)
  {
    get(paramInt).transformPivotY = paramFloat;
  }
  
  public void setTranslation(int paramInt, float paramFloat1, float paramFloat2)
  {
    Constraint localConstraint = get(paramInt);
    localConstraint.translationX = paramFloat1;
    localConstraint.translationY = paramFloat2;
  }
  
  public void setTranslationX(int paramInt, float paramFloat)
  {
    get(paramInt).translationX = paramFloat;
  }
  
  public void setTranslationY(int paramInt, float paramFloat)
  {
    get(paramInt).translationY = paramFloat;
  }
  
  public void setTranslationZ(int paramInt, float paramFloat)
  {
    get(paramInt).translationZ = paramFloat;
  }
  
  public void setVerticalBias(int paramInt, float paramFloat)
  {
    get(paramInt).verticalBias = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt1, int paramInt2)
  {
    get(paramInt1).verticalChainStyle = paramInt2;
  }
  
  public void setVerticalWeight(int paramInt, float paramFloat)
  {
    get(paramInt).verticalWeight = paramFloat;
  }
  
  public void setVisibility(int paramInt1, int paramInt2)
  {
    get(paramInt1).visibility = paramInt2;
  }
  
  private static class Constraint
  {
    static final int UNSET = -1;
    public float alpha = 1.0F;
    public boolean applyElevation = false;
    public int baselineToBaseline = -1;
    public int bottomMargin = -1;
    public int bottomToBottom = -1;
    public int bottomToTop = -1;
    public float circleAngle = 0.0F;
    public int circleConstraint = -1;
    public int circleRadius = 0;
    public boolean constrainedHeight = false;
    public boolean constrainedWidth = false;
    public String dimensionRatio = null;
    public int editorAbsoluteX = -1;
    public int editorAbsoluteY = -1;
    public float elevation = 0.0F;
    public int endMargin = -1;
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
    public int heightDefault = 0;
    public int heightMax = -1;
    public int heightMin = -1;
    public float heightPercent = 1.0F;
    public float horizontalBias = 0.5F;
    public int horizontalChainStyle = 0;
    public float horizontalWeight = 0.0F;
    public int leftMargin = -1;
    public int leftToLeft = -1;
    public int leftToRight = -1;
    public boolean mBarrierAllowsGoneWidgets = false;
    public int mBarrierDirection = -1;
    public int mHeight;
    public int mHelperType = -1;
    boolean mIsGuideline = false;
    public String mReferenceIdString;
    public int[] mReferenceIds;
    int mViewId;
    public int mWidth;
    public int orientation = -1;
    public int rightMargin = -1;
    public int rightToLeft = -1;
    public int rightToRight = -1;
    public float rotation = 0.0F;
    public float rotationX = 0.0F;
    public float rotationY = 0.0F;
    public float scaleX = 1.0F;
    public float scaleY = 1.0F;
    public int startMargin = -1;
    public int startToEnd = -1;
    public int startToStart = -1;
    public int topMargin = -1;
    public int topToBottom = -1;
    public int topToTop = -1;
    public float transformPivotX = NaN.0F;
    public float transformPivotY = NaN.0F;
    public float translationX = 0.0F;
    public float translationY = 0.0F;
    public float translationZ = 0.0F;
    public float verticalBias = 0.5F;
    public int verticalChainStyle = 0;
    public float verticalWeight = 0.0F;
    public int visibility = 0;
    public int widthDefault = 0;
    public int widthMax = -1;
    public int widthMin = -1;
    public float widthPercent = 1.0F;
    
    private void fillFrom(int paramInt, ConstraintLayout.LayoutParams paramLayoutParams)
    {
      this.mViewId = paramInt;
      this.leftToLeft = paramLayoutParams.leftToLeft;
      this.leftToRight = paramLayoutParams.leftToRight;
      this.rightToLeft = paramLayoutParams.rightToLeft;
      this.rightToRight = paramLayoutParams.rightToRight;
      this.topToTop = paramLayoutParams.topToTop;
      this.topToBottom = paramLayoutParams.topToBottom;
      this.bottomToTop = paramLayoutParams.bottomToTop;
      this.bottomToBottom = paramLayoutParams.bottomToBottom;
      this.baselineToBaseline = paramLayoutParams.baselineToBaseline;
      this.startToEnd = paramLayoutParams.startToEnd;
      this.startToStart = paramLayoutParams.startToStart;
      this.endToStart = paramLayoutParams.endToStart;
      this.endToEnd = paramLayoutParams.endToEnd;
      this.horizontalBias = paramLayoutParams.horizontalBias;
      this.verticalBias = paramLayoutParams.verticalBias;
      this.dimensionRatio = paramLayoutParams.dimensionRatio;
      this.circleConstraint = paramLayoutParams.circleConstraint;
      this.circleRadius = paramLayoutParams.circleRadius;
      this.circleAngle = paramLayoutParams.circleAngle;
      this.editorAbsoluteX = paramLayoutParams.editorAbsoluteX;
      this.editorAbsoluteY = paramLayoutParams.editorAbsoluteY;
      this.orientation = paramLayoutParams.orientation;
      this.guidePercent = paramLayoutParams.guidePercent;
      this.guideBegin = paramLayoutParams.guideBegin;
      this.guideEnd = paramLayoutParams.guideEnd;
      this.mWidth = paramLayoutParams.width;
      this.mHeight = paramLayoutParams.height;
      this.leftMargin = paramLayoutParams.leftMargin;
      this.rightMargin = paramLayoutParams.rightMargin;
      this.topMargin = paramLayoutParams.topMargin;
      this.bottomMargin = paramLayoutParams.bottomMargin;
      this.verticalWeight = paramLayoutParams.verticalWeight;
      this.horizontalWeight = paramLayoutParams.horizontalWeight;
      this.verticalChainStyle = paramLayoutParams.verticalChainStyle;
      this.horizontalChainStyle = paramLayoutParams.horizontalChainStyle;
      this.constrainedWidth = paramLayoutParams.constrainedWidth;
      this.constrainedHeight = paramLayoutParams.constrainedHeight;
      this.widthDefault = paramLayoutParams.matchConstraintDefaultWidth;
      this.heightDefault = paramLayoutParams.matchConstraintDefaultHeight;
      this.constrainedWidth = paramLayoutParams.constrainedWidth;
      this.widthMax = paramLayoutParams.matchConstraintMaxWidth;
      this.heightMax = paramLayoutParams.matchConstraintMaxHeight;
      this.widthMin = paramLayoutParams.matchConstraintMinWidth;
      this.heightMin = paramLayoutParams.matchConstraintMinHeight;
      this.widthPercent = paramLayoutParams.matchConstraintPercentWidth;
      this.heightPercent = paramLayoutParams.matchConstraintPercentHeight;
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.endMargin = paramLayoutParams.getMarginEnd();
        this.startMargin = paramLayoutParams.getMarginStart();
      }
    }
    
    private void fillFromConstraints(int paramInt, Constraints.LayoutParams paramLayoutParams)
    {
      fillFrom(paramInt, paramLayoutParams);
      this.alpha = paramLayoutParams.alpha;
      this.rotation = paramLayoutParams.rotation;
      this.rotationX = paramLayoutParams.rotationX;
      this.rotationY = paramLayoutParams.rotationY;
      this.scaleX = paramLayoutParams.scaleX;
      this.scaleY = paramLayoutParams.scaleY;
      this.transformPivotX = paramLayoutParams.transformPivotX;
      this.transformPivotY = paramLayoutParams.transformPivotY;
      this.translationX = paramLayoutParams.translationX;
      this.translationY = paramLayoutParams.translationY;
      this.translationZ = paramLayoutParams.translationZ;
      this.elevation = paramLayoutParams.elevation;
      this.applyElevation = paramLayoutParams.applyElevation;
    }
    
    private void fillFromConstraints(ConstraintHelper paramConstraintHelper, int paramInt, Constraints.LayoutParams paramLayoutParams)
    {
      fillFromConstraints(paramInt, paramLayoutParams);
      if ((paramConstraintHelper instanceof Barrier))
      {
        this.mHelperType = 1;
        paramConstraintHelper = (Barrier)paramConstraintHelper;
        this.mBarrierDirection = paramConstraintHelper.getType();
        this.mReferenceIds = paramConstraintHelper.getReferencedIds();
      }
    }
    
    public void applyTo(ConstraintLayout.LayoutParams paramLayoutParams)
    {
      paramLayoutParams.leftToLeft = this.leftToLeft;
      paramLayoutParams.leftToRight = this.leftToRight;
      paramLayoutParams.rightToLeft = this.rightToLeft;
      paramLayoutParams.rightToRight = this.rightToRight;
      paramLayoutParams.topToTop = this.topToTop;
      paramLayoutParams.topToBottom = this.topToBottom;
      paramLayoutParams.bottomToTop = this.bottomToTop;
      paramLayoutParams.bottomToBottom = this.bottomToBottom;
      paramLayoutParams.baselineToBaseline = this.baselineToBaseline;
      paramLayoutParams.startToEnd = this.startToEnd;
      paramLayoutParams.startToStart = this.startToStart;
      paramLayoutParams.endToStart = this.endToStart;
      paramLayoutParams.endToEnd = this.endToEnd;
      paramLayoutParams.leftMargin = this.leftMargin;
      paramLayoutParams.rightMargin = this.rightMargin;
      paramLayoutParams.topMargin = this.topMargin;
      paramLayoutParams.bottomMargin = this.bottomMargin;
      paramLayoutParams.goneStartMargin = this.goneStartMargin;
      paramLayoutParams.goneEndMargin = this.goneEndMargin;
      paramLayoutParams.horizontalBias = this.horizontalBias;
      paramLayoutParams.verticalBias = this.verticalBias;
      paramLayoutParams.circleConstraint = this.circleConstraint;
      paramLayoutParams.circleRadius = this.circleRadius;
      paramLayoutParams.circleAngle = this.circleAngle;
      paramLayoutParams.dimensionRatio = this.dimensionRatio;
      paramLayoutParams.editorAbsoluteX = this.editorAbsoluteX;
      paramLayoutParams.editorAbsoluteY = this.editorAbsoluteY;
      paramLayoutParams.verticalWeight = this.verticalWeight;
      paramLayoutParams.horizontalWeight = this.horizontalWeight;
      paramLayoutParams.verticalChainStyle = this.verticalChainStyle;
      paramLayoutParams.horizontalChainStyle = this.horizontalChainStyle;
      paramLayoutParams.constrainedWidth = this.constrainedWidth;
      paramLayoutParams.constrainedHeight = this.constrainedHeight;
      paramLayoutParams.matchConstraintDefaultWidth = this.widthDefault;
      paramLayoutParams.matchConstraintDefaultHeight = this.heightDefault;
      paramLayoutParams.matchConstraintMaxWidth = this.widthMax;
      paramLayoutParams.matchConstraintMaxHeight = this.heightMax;
      paramLayoutParams.matchConstraintMinWidth = this.widthMin;
      paramLayoutParams.matchConstraintMinHeight = this.heightMin;
      paramLayoutParams.matchConstraintPercentWidth = this.widthPercent;
      paramLayoutParams.matchConstraintPercentHeight = this.heightPercent;
      paramLayoutParams.orientation = this.orientation;
      paramLayoutParams.guidePercent = this.guidePercent;
      paramLayoutParams.guideBegin = this.guideBegin;
      paramLayoutParams.guideEnd = this.guideEnd;
      paramLayoutParams.width = this.mWidth;
      paramLayoutParams.height = this.mHeight;
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramLayoutParams.setMarginStart(this.startMargin);
        paramLayoutParams.setMarginEnd(this.endMargin);
      }
      paramLayoutParams.validate();
    }
    
    public Constraint clone()
    {
      Constraint localConstraint = new Constraint();
      localConstraint.mIsGuideline = this.mIsGuideline;
      localConstraint.mWidth = this.mWidth;
      localConstraint.mHeight = this.mHeight;
      localConstraint.guideBegin = this.guideBegin;
      localConstraint.guideEnd = this.guideEnd;
      localConstraint.guidePercent = this.guidePercent;
      localConstraint.leftToLeft = this.leftToLeft;
      localConstraint.leftToRight = this.leftToRight;
      localConstraint.rightToLeft = this.rightToLeft;
      localConstraint.rightToRight = this.rightToRight;
      localConstraint.topToTop = this.topToTop;
      localConstraint.topToBottom = this.topToBottom;
      localConstraint.bottomToTop = this.bottomToTop;
      localConstraint.bottomToBottom = this.bottomToBottom;
      localConstraint.baselineToBaseline = this.baselineToBaseline;
      localConstraint.startToEnd = this.startToEnd;
      localConstraint.startToStart = this.startToStart;
      localConstraint.endToStart = this.endToStart;
      localConstraint.endToEnd = this.endToEnd;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.verticalBias = this.verticalBias;
      localConstraint.dimensionRatio = this.dimensionRatio;
      localConstraint.editorAbsoluteX = this.editorAbsoluteX;
      localConstraint.editorAbsoluteY = this.editorAbsoluteY;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.horizontalBias = this.horizontalBias;
      localConstraint.orientation = this.orientation;
      localConstraint.leftMargin = this.leftMargin;
      localConstraint.rightMargin = this.rightMargin;
      localConstraint.topMargin = this.topMargin;
      localConstraint.bottomMargin = this.bottomMargin;
      localConstraint.endMargin = this.endMargin;
      localConstraint.startMargin = this.startMargin;
      localConstraint.visibility = this.visibility;
      localConstraint.goneLeftMargin = this.goneLeftMargin;
      localConstraint.goneTopMargin = this.goneTopMargin;
      localConstraint.goneRightMargin = this.goneRightMargin;
      localConstraint.goneBottomMargin = this.goneBottomMargin;
      localConstraint.goneEndMargin = this.goneEndMargin;
      localConstraint.goneStartMargin = this.goneStartMargin;
      localConstraint.verticalWeight = this.verticalWeight;
      localConstraint.horizontalWeight = this.horizontalWeight;
      localConstraint.horizontalChainStyle = this.horizontalChainStyle;
      localConstraint.verticalChainStyle = this.verticalChainStyle;
      localConstraint.alpha = this.alpha;
      localConstraint.applyElevation = this.applyElevation;
      localConstraint.elevation = this.elevation;
      localConstraint.rotation = this.rotation;
      localConstraint.rotationX = this.rotationX;
      localConstraint.rotationY = this.rotationY;
      localConstraint.scaleX = this.scaleX;
      localConstraint.scaleY = this.scaleY;
      localConstraint.transformPivotX = this.transformPivotX;
      localConstraint.transformPivotY = this.transformPivotY;
      localConstraint.translationX = this.translationX;
      localConstraint.translationY = this.translationY;
      localConstraint.translationZ = this.translationZ;
      localConstraint.constrainedWidth = this.constrainedWidth;
      localConstraint.constrainedHeight = this.constrainedHeight;
      localConstraint.widthDefault = this.widthDefault;
      localConstraint.heightDefault = this.heightDefault;
      localConstraint.widthMax = this.widthMax;
      localConstraint.heightMax = this.heightMax;
      localConstraint.widthMin = this.widthMin;
      localConstraint.heightMin = this.heightMin;
      localConstraint.widthPercent = this.widthPercent;
      localConstraint.heightPercent = this.heightPercent;
      localConstraint.mBarrierDirection = this.mBarrierDirection;
      localConstraint.mHelperType = this.mHelperType;
      if (this.mReferenceIds != null) {
        localConstraint.mReferenceIds = Arrays.copyOf(this.mReferenceIds, this.mReferenceIds.length);
      }
      localConstraint.circleConstraint = this.circleConstraint;
      localConstraint.circleRadius = this.circleRadius;
      localConstraint.circleAngle = this.circleAngle;
      localConstraint.mBarrierAllowsGoneWidgets = this.mBarrierAllowsGoneWidgets;
      return localConstraint;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\ConstraintSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */