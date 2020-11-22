package android.support.v4.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.v4.text.PrecomputedTextCompat;
import android.support.v4.text.PrecomputedTextCompat.Params;
import android.support.v4.text.PrecomputedTextCompat.Params.Builder;
import android.support.v4.util.Preconditions;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class TextViewCompat
{
  public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
  public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
  private static final int LINES = 1;
  private static final String LOG_TAG = "TextViewCompat";
  private static Field sMaxModeField;
  private static boolean sMaxModeFieldFetched;
  private static Field sMaximumField;
  private static boolean sMaximumFieldFetched;
  private static Field sMinModeField;
  private static boolean sMinModeFieldFetched;
  private static Field sMinimumField;
  private static boolean sMinimumFieldFetched;
  
  public static int getAutoSizeMaxTextSize(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeMaxTextSize();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeMaxTextSize();
    }
    return -1;
  }
  
  public static int getAutoSizeMinTextSize(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeMinTextSize();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeMinTextSize();
    }
    return -1;
  }
  
  public static int getAutoSizeStepGranularity(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeStepGranularity();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeStepGranularity();
    }
    return -1;
  }
  
  @NonNull
  public static int[] getAutoSizeTextAvailableSizes(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeTextAvailableSizes();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeTextAvailableSizes();
    }
    return new int[0];
  }
  
  public static int getAutoSizeTextType(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeTextType();
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      return ((AutoSizeableTextView)paramTextView).getAutoSizeTextType();
    }
    return 0;
  }
  
  @NonNull
  public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramTextView.getCompoundDrawablesRelative();
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int j = paramTextView.getLayoutDirection();
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      paramTextView = paramTextView.getCompoundDrawables();
      if (i != 0)
      {
        Object localObject1 = paramTextView[2];
        Object localObject2 = paramTextView[0];
        paramTextView[0] = localObject1;
        paramTextView[2] = localObject2;
      }
      return paramTextView;
    }
    return paramTextView.getCompoundDrawables();
  }
  
  public static int getFirstBaselineToTopHeight(@NonNull TextView paramTextView)
  {
    return paramTextView.getPaddingTop() - paramTextView.getPaint().getFontMetricsInt().top;
  }
  
  public static int getLastBaselineToBottomHeight(@NonNull TextView paramTextView)
  {
    return paramTextView.getPaddingBottom() + paramTextView.getPaint().getFontMetricsInt().bottom;
  }
  
  public static int getMaxLines(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramTextView.getMaxLines();
    }
    if (!sMaxModeFieldFetched)
    {
      sMaxModeField = retrieveField("mMaxMode");
      sMaxModeFieldFetched = true;
    }
    if ((sMaxModeField != null) && (retrieveIntFromField(sMaxModeField, paramTextView) == 1))
    {
      if (!sMaximumFieldFetched)
      {
        sMaximumField = retrieveField("mMaximum");
        sMaximumFieldFetched = true;
      }
      if (sMaximumField != null) {
        return retrieveIntFromField(sMaximumField, paramTextView);
      }
    }
    return -1;
  }
  
  public static int getMinLines(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramTextView.getMinLines();
    }
    if (!sMinModeFieldFetched)
    {
      sMinModeField = retrieveField("mMinMode");
      sMinModeFieldFetched = true;
    }
    if ((sMinModeField != null) && (retrieveIntFromField(sMinModeField, paramTextView) == 1))
    {
      if (!sMinimumFieldFetched)
      {
        sMinimumField = retrieveField("mMinimum");
        sMinimumFieldFetched = true;
      }
      if (sMinimumField != null) {
        return retrieveIntFromField(sMinimumField, paramTextView);
      }
    }
    return -1;
  }
  
  @RequiresApi(18)
  private static int getTextDirection(@NonNull TextDirectionHeuristic paramTextDirectionHeuristic)
  {
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
      return 1;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
      return 1;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
      return 2;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.LTR) {
      return 3;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.RTL) {
      return 4;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
      return 5;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
      return 6;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
      return 7;
    }
    return 1;
  }
  
  @RequiresApi(18)
  private static TextDirectionHeuristic getTextDirectionHeuristic(@NonNull TextView paramTextView)
  {
    if ((paramTextView.getTransformationMethod() instanceof PasswordTransformationMethod)) {
      return TextDirectionHeuristics.LTR;
    }
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if ((j >= 28) && ((paramTextView.getInputType() & 0xF) == 3))
    {
      i = Character.getDirectionality(android.icu.text.DecimalFormatSymbols.getInstance(paramTextView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
      if ((i != 1) && (i != 2)) {
        return TextDirectionHeuristics.LTR;
      }
      return TextDirectionHeuristics.RTL;
    }
    if (paramTextView.getLayoutDirection() == 1) {
      i = 1;
    }
    switch (paramTextView.getTextDirection())
    {
    default: 
      if (i != 0) {
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
      }
      break;
    case 7: 
      return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    case 6: 
      return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    case 5: 
      return TextDirectionHeuristics.LOCALE;
    case 4: 
      return TextDirectionHeuristics.RTL;
    case 3: 
      return TextDirectionHeuristics.LTR;
    case 2: 
      return TextDirectionHeuristics.ANYRTL_LTR;
    }
    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
  }
  
  @NonNull
  public static PrecomputedTextCompat.Params getTextMetricsParams(@NonNull TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return new PrecomputedTextCompat.Params(paramTextView.getTextMetricsParams());
    }
    PrecomputedTextCompat.Params.Builder localBuilder = new PrecomputedTextCompat.Params.Builder(new TextPaint(paramTextView.getPaint()));
    if (Build.VERSION.SDK_INT >= 23)
    {
      localBuilder.setBreakStrategy(paramTextView.getBreakStrategy());
      localBuilder.setHyphenationFrequency(paramTextView.getHyphenationFrequency());
    }
    if (Build.VERSION.SDK_INT >= 18) {
      localBuilder.setTextDirection(getTextDirectionHeuristic(paramTextView));
    }
    return localBuilder.build();
  }
  
  private static Field retrieveField(String paramString)
  {
    try
    {
      localField = TextView.class.getDeclaredField(paramString);
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      Field localField;
      label16:
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    try
    {
      localField.setAccessible(true);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      break label16;
    }
    localField = null;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Could not retrieve ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" field.");
    Log.e("TextViewCompat", localStringBuilder.toString());
    return localField;
  }
  
  private static int retrieveIntFromField(Field paramField, TextView paramTextView)
  {
    try
    {
      int i = paramField.getInt(paramTextView);
      return i;
    }
    catch (IllegalAccessException paramTextView)
    {
      for (;;) {}
    }
    paramTextView = new StringBuilder();
    paramTextView.append("Could not retrieve value of ");
    paramTextView.append(paramField.getName());
    paramTextView.append(" field.");
    Log.d("TextViewCompat", paramTextView.toString());
    return -1;
  }
  
  public static void setAutoSizeTextTypeUniformWithConfiguration(@NonNull TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (Build.VERSION.SDK_INT >= 27)
    {
      paramTextView.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public static void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull TextView paramTextView, @NonNull int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    if (Build.VERSION.SDK_INT >= 27)
    {
      paramTextView.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      return;
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
  }
  
  public static void setAutoSizeTextTypeWithDefaults(@NonNull TextView paramTextView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 27)
    {
      paramTextView.setAutoSizeTextTypeWithDefaults(paramInt);
      return;
    }
    if ((paramTextView instanceof AutoSizeableTextView)) {
      ((AutoSizeableTextView)paramTextView).setAutoSizeTextTypeWithDefaults(paramInt);
    }
  }
  
  public static void setCompoundDrawablesRelative(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int j = paramTextView.getLayoutDirection();
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      Drawable localDrawable;
      if (i != 0) {
        localDrawable = paramDrawable3;
      } else {
        localDrawable = paramDrawable1;
      }
      if (i == 0) {
        paramDrawable1 = paramDrawable3;
      }
      paramTextView.setCompoundDrawables(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
      return;
    }
    paramTextView.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int j = paramTextView.getLayoutDirection();
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      if (i != 0) {
        j = paramInt3;
      } else {
        j = paramInt1;
      }
      if (i == 0) {
        paramInt1 = paramInt3;
      }
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(j, paramInt2, paramInt1, paramInt4);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      int j = paramTextView.getLayoutDirection();
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      Drawable localDrawable;
      if (i != 0) {
        localDrawable = paramDrawable3;
      } else {
        localDrawable = paramDrawable1;
      }
      if (i == 0) {
        paramDrawable1 = paramDrawable3;
      }
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void setCustomSelectionActionModeCallback(@NonNull TextView paramTextView, @NonNull ActionMode.Callback paramCallback)
  {
    paramTextView.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(paramTextView, paramCallback));
  }
  
  public static void setFirstBaselineToTopHeight(@NonNull TextView paramTextView, @IntRange(from=0L) @Px int paramInt)
  {
    Preconditions.checkArgumentNonnegative(paramInt);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramTextView.setFirstBaselineToTopHeight(paramInt);
      return;
    }
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    int i;
    if ((Build.VERSION.SDK_INT >= 16) && (!paramTextView.getIncludeFontPadding())) {
      i = localFontMetricsInt.ascent;
    } else {
      i = localFontMetricsInt.top;
    }
    if (paramInt > Math.abs(i))
    {
      i = -i;
      paramTextView.setPadding(paramTextView.getPaddingLeft(), paramInt - i, paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
    }
  }
  
  public static void setLastBaselineToBottomHeight(@NonNull TextView paramTextView, @IntRange(from=0L) @Px int paramInt)
  {
    Preconditions.checkArgumentNonnegative(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    int i;
    if ((Build.VERSION.SDK_INT >= 16) && (!paramTextView.getIncludeFontPadding())) {
      i = localFontMetricsInt.descent;
    } else {
      i = localFontMetricsInt.bottom;
    }
    if (paramInt > Math.abs(i)) {
      paramTextView.setPadding(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramInt - i);
    }
  }
  
  public static void setLineHeight(@NonNull TextView paramTextView, @IntRange(from=0L) @Px int paramInt)
  {
    Preconditions.checkArgumentNonnegative(paramInt);
    int i = paramTextView.getPaint().getFontMetricsInt(null);
    if (paramInt != i) {
      paramTextView.setLineSpacing(paramInt - i, 1.0F);
    }
  }
  
  public static void setPrecomputedText(@NonNull TextView paramTextView, @NonNull PrecomputedTextCompat paramPrecomputedTextCompat)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramTextView.setText(paramPrecomputedTextCompat.getPrecomputedText());
      return;
    }
    if (getTextMetricsParams(paramTextView).equals(paramPrecomputedTextCompat.getParams()))
    {
      paramTextView.setText(paramPrecomputedTextCompat);
      return;
    }
    throw new IllegalArgumentException("Given text can not be applied to TextView.");
  }
  
  public static void setTextAppearance(@NonNull TextView paramTextView, @StyleRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramTextView.setTextAppearance(paramInt);
      return;
    }
    paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
  }
  
  public static void setTextMetricsParams(@NonNull TextView paramTextView, @NonNull PrecomputedTextCompat.Params paramParams)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      paramTextView.setTextDirection(getTextDirection(paramParams.getTextDirection()));
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      float f = paramParams.getTextPaint().getTextScaleX();
      paramTextView.getPaint().set(paramParams.getTextPaint());
      if (f == paramTextView.getTextScaleX()) {
        paramTextView.setTextScaleX(f / 2.0F + 1.0F);
      }
      paramTextView.setTextScaleX(f);
      return;
    }
    paramTextView.getPaint().set(paramParams.getTextPaint());
    paramTextView.setBreakStrategy(paramParams.getBreakStrategy());
    paramTextView.setHyphenationFrequency(paramParams.getHyphenationFrequency());
  }
  
  @NonNull
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static ActionMode.Callback wrapCustomSelectionActionModeCallback(@NonNull TextView paramTextView, @NonNull ActionMode.Callback paramCallback)
  {
    if ((Build.VERSION.SDK_INT >= 26) && (Build.VERSION.SDK_INT <= 27))
    {
      if ((paramCallback instanceof OreoCallback)) {
        return paramCallback;
      }
      return new OreoCallback(paramCallback, paramTextView);
    }
    return paramCallback;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface AutoSizeTextType {}
  
  @RequiresApi(26)
  private static class OreoCallback
    implements ActionMode.Callback
  {
    private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
    private final ActionMode.Callback mCallback;
    private boolean mCanUseMenuBuilderReferences;
    private boolean mInitializedMenuBuilderReferences;
    private Class mMenuBuilderClass;
    private Method mMenuBuilderRemoveItemAtMethod;
    private final TextView mTextView;
    
    OreoCallback(ActionMode.Callback paramCallback, TextView paramTextView)
    {
      this.mCallback = paramCallback;
      this.mTextView = paramTextView;
      this.mInitializedMenuBuilderReferences = false;
    }
    
    private Intent createProcessTextIntent()
    {
      return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
    }
    
    private Intent createProcessTextIntentForResolveInfo(ResolveInfo paramResolveInfo, TextView paramTextView)
    {
      return createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", isEditable(paramTextView) ^ true).setClassName(paramResolveInfo.activityInfo.packageName, paramResolveInfo.activityInfo.name);
    }
    
    private List<ResolveInfo> getSupportedActivities(Context paramContext, PackageManager paramPackageManager)
    {
      ArrayList localArrayList = new ArrayList();
      if (!(paramContext instanceof Activity)) {
        return localArrayList;
      }
      paramPackageManager = paramPackageManager.queryIntentActivities(createProcessTextIntent(), 0).iterator();
      while (paramPackageManager.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)paramPackageManager.next();
        if (isSupportedActivity(localResolveInfo, paramContext)) {
          localArrayList.add(localResolveInfo);
        }
      }
      return localArrayList;
    }
    
    private boolean isEditable(TextView paramTextView)
    {
      return ((paramTextView instanceof Editable)) && (paramTextView.onCheckIsTextEditor()) && (paramTextView.isEnabled());
    }
    
    private boolean isSupportedActivity(ResolveInfo paramResolveInfo, Context paramContext)
    {
      boolean bool2 = paramContext.getPackageName().equals(paramResolveInfo.activityInfo.packageName);
      boolean bool1 = true;
      if (bool2) {
        return true;
      }
      if (!paramResolveInfo.activityInfo.exported) {
        return false;
      }
      if (paramResolveInfo.activityInfo.permission != null)
      {
        if (paramContext.checkSelfPermission(paramResolveInfo.activityInfo.permission) == 0) {
          return true;
        }
        bool1 = false;
      }
      return bool1;
    }
    
    private void recomputeProcessTextMenuItems(Menu paramMenu)
    {
      Object localObject2 = this.mTextView.getContext();
      PackageManager localPackageManager = ((Context)localObject2).getPackageManager();
      if (!this.mInitializedMenuBuilderReferences) {
        this.mInitializedMenuBuilderReferences = true;
      }
      try
      {
        this.mMenuBuilderClass = Class.forName("com.android.internal.view.menu.MenuBuilder");
        this.mMenuBuilderRemoveItemAtMethod = this.mMenuBuilderClass.getDeclaredMethod("removeItemAt", new Class[] { Integer.TYPE });
        this.mCanUseMenuBuilderReferences = true;
      }
      catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException)
      {
        for (;;)
        {
          try
          {
            if ((this.mCanUseMenuBuilderReferences) && (this.mMenuBuilderClass.isInstance(paramMenu))) {
              localObject1 = this.mMenuBuilderRemoveItemAtMethod;
            } else {
              localObject1 = paramMenu.getClass().getDeclaredMethod("removeItemAt", new Class[] { Integer.TYPE });
            }
            int i = paramMenu.size() - 1;
            if (i >= 0)
            {
              MenuItem localMenuItem = paramMenu.getItem(i);
              if ((localMenuItem.getIntent() != null) && ("android.intent.action.PROCESS_TEXT".equals(localMenuItem.getIntent().getAction()))) {
                ((Method)localObject1).invoke(paramMenu, new Object[] { Integer.valueOf(i) });
              }
              i -= 1;
              continue;
            }
            Object localObject1 = getSupportedActivities((Context)localObject2, localPackageManager);
            i = 0;
            if (i < ((List)localObject1).size())
            {
              localObject2 = (ResolveInfo)((List)localObject1).get(i);
              paramMenu.add(0, 0, i + 100, ((ResolveInfo)localObject2).loadLabel(localPackageManager)).setIntent(createProcessTextIntentForResolveInfo((ResolveInfo)localObject2, this.mTextView)).setShowAsAction(1);
              i += 1;
              continue;
            }
            return;
          }
          catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException paramMenu) {}
          localClassNotFoundException = localClassNotFoundException;
        }
      }
      this.mMenuBuilderClass = null;
      this.mMenuBuilderRemoveItemAtMethod = null;
      this.mCanUseMenuBuilderReferences = false;
    }
    
    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return this.mCallback.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return this.mCallback.onCreateActionMode(paramActionMode, paramMenu);
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      this.mCallback.onDestroyActionMode(paramActionMode);
    }
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      recomputeProcessTextMenuItems(paramMenu);
      return this.mCallback.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\widget\TextViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */