package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SupportMenuInflater
  extends MenuInflater
{
  static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
  static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = { Context.class };
  static final String LOG_TAG = "SupportMenuInflater";
  static final int NO_ID = 0;
  private static final String XML_GROUP = "group";
  private static final String XML_ITEM = "item";
  private static final String XML_MENU = "menu";
  final Object[] mActionProviderConstructorArguments;
  final Object[] mActionViewConstructorArguments;
  Context mContext;
  private Object mRealOwner;
  
  public SupportMenuInflater(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mActionViewConstructorArguments = new Object[] { paramContext };
    this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
  }
  
  private Object findRealOwner(Object paramObject)
  {
    if ((paramObject instanceof Activity)) {
      return paramObject;
    }
    if ((paramObject instanceof ContextWrapper)) {
      return findRealOwner(((ContextWrapper)paramObject).getBaseContext());
    }
    return paramObject;
  }
  
  private void parseMenu(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
    throws XmlPullParserException, IOException
  {
    MenuState localMenuState = new MenuState(paramMenu);
    int i = paramXmlPullParser.getEventType();
    do
    {
      if (i == 2)
      {
        paramMenu = paramXmlPullParser.getName();
        if (paramMenu.equals("menu"))
        {
          i = paramXmlPullParser.next();
          break;
        }
        paramXmlPullParser = new StringBuilder();
        paramXmlPullParser.append("Expecting menu, got ");
        paramXmlPullParser.append(paramMenu);
        throw new RuntimeException(paramXmlPullParser.toString());
      }
      j = paramXmlPullParser.next();
      i = j;
    } while (j != 1);
    i = j;
    Object localObject = null;
    int j = 0;
    int k = 0;
    int n = i;
    while (j == 0)
    {
      int m;
      switch (n)
      {
      default: 
        i = k;
        paramMenu = (Menu)localObject;
        m = j;
        break;
      case 3: 
        String str = paramXmlPullParser.getName();
        if ((k != 0) && (str.equals(localObject)))
        {
          paramMenu = null;
          i = 0;
          m = j;
        }
        else if (str.equals("group"))
        {
          localMenuState.resetGroup();
          i = k;
          paramMenu = (Menu)localObject;
          m = j;
        }
        else if (str.equals("item"))
        {
          i = k;
          paramMenu = (Menu)localObject;
          m = j;
          if (!localMenuState.hasAddedItem()) {
            if ((localMenuState.itemActionProvider != null) && (localMenuState.itemActionProvider.hasSubMenu()))
            {
              localMenuState.addSubMenuItem();
              i = k;
              paramMenu = (Menu)localObject;
              m = j;
            }
            else
            {
              localMenuState.addItem();
              i = k;
              paramMenu = (Menu)localObject;
              m = j;
            }
          }
        }
        else
        {
          i = k;
          paramMenu = (Menu)localObject;
          m = j;
          if (str.equals("menu"))
          {
            m = 1;
            i = k;
            paramMenu = (Menu)localObject;
          }
        }
        break;
      case 2: 
        if (k != 0)
        {
          i = k;
          paramMenu = (Menu)localObject;
          m = j;
        }
        else
        {
          paramMenu = paramXmlPullParser.getName();
          if (paramMenu.equals("group"))
          {
            localMenuState.readGroup(paramAttributeSet);
            i = k;
            paramMenu = (Menu)localObject;
            m = j;
          }
          else if (paramMenu.equals("item"))
          {
            localMenuState.readItem(paramAttributeSet);
            i = k;
            paramMenu = (Menu)localObject;
            m = j;
          }
          else if (paramMenu.equals("menu"))
          {
            parseMenu(paramXmlPullParser, paramAttributeSet, localMenuState.addSubMenuItem());
            i = k;
            paramMenu = (Menu)localObject;
            m = j;
          }
          else
          {
            i = 1;
            m = j;
          }
        }
        break;
      case 1: 
        throw new RuntimeException("Unexpected end of document");
      }
      n = paramXmlPullParser.next();
      k = i;
      localObject = paramMenu;
      j = m;
    }
  }
  
  Object getRealOwner()
  {
    if (this.mRealOwner == null) {
      this.mRealOwner = findRealOwner(this.mContext);
    }
    return this.mRealOwner;
  }
  
  /* Error */
  public void inflate(@android.support.annotation.LayoutRes int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 166
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 168	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 6
    //   20: aconst_null
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 58	android/support/v7/view/SupportMenuInflater:mContext	Landroid/content/Context;
    //   26: invokevirtual 172	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   29: iload_1
    //   30: invokevirtual 178	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   33: astore 4
    //   35: aload_0
    //   36: aload 4
    //   38: aload 4
    //   40: invokestatic 184	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   43: aload_2
    //   44: invokespecial 154	android/support/v7/view/SupportMenuInflater:parseMenu	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   47: aload 4
    //   49: ifnull +10 -> 59
    //   52: aload 4
    //   54: invokeinterface 189 1 0
    //   59: return
    //   60: astore_2
    //   61: aload 4
    //   63: astore_3
    //   64: goto +47 -> 111
    //   67: astore_2
    //   68: aload 4
    //   70: astore_3
    //   71: goto +18 -> 89
    //   74: astore_2
    //   75: aload 4
    //   77: astore_3
    //   78: goto +22 -> 100
    //   81: astore_2
    //   82: goto +29 -> 111
    //   85: astore_2
    //   86: aload 5
    //   88: astore_3
    //   89: new 191	android/view/InflateException
    //   92: dup
    //   93: ldc -63
    //   95: aload_2
    //   96: invokespecial 196	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: athrow
    //   100: new 191	android/view/InflateException
    //   103: dup
    //   104: ldc -63
    //   106: aload_2
    //   107: invokespecial 196	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: athrow
    //   111: aload_3
    //   112: ifnull +9 -> 121
    //   115: aload_3
    //   116: invokeinterface 189 1 0
    //   121: aload_2
    //   122: athrow
    //   123: astore_2
    //   124: aload 6
    //   126: astore_3
    //   127: goto -27 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	SupportMenuInflater
    //   0	130	1	paramInt	int
    //   0	130	2	paramMenu	Menu
    //   21	106	3	localObject1	Object
    //   33	43	4	localXmlResourceParser	android.content.res.XmlResourceParser
    //   15	72	5	localObject2	Object
    //   18	107	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	47	60	finally
    //   35	47	67	java/io/IOException
    //   35	47	74	org/xmlpull/v1/XmlPullParserException
    //   22	35	81	finally
    //   89	100	81	finally
    //   100	111	81	finally
    //   22	35	85	java/io/IOException
    //   22	35	123	org/xmlpull/v1/XmlPullParserException
  }
  
  private static class InflatedOnMenuItemClickListener
    implements MenuItem.OnMenuItemClickListener
  {
    private static final Class<?>[] PARAM_TYPES = { MenuItem.class };
    private Method mMethod;
    private Object mRealOwner;
    
    public InflatedOnMenuItemClickListener(Object paramObject, String paramString)
    {
      this.mRealOwner = paramObject;
      Class localClass = paramObject.getClass();
      try
      {
        this.mMethod = localClass.getMethod(paramString, PARAM_TYPES);
        return;
      }
      catch (Exception paramObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Couldn't resolve menu item onClick handler ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" in class ");
        localStringBuilder.append(localClass.getName());
        paramString = new InflateException(localStringBuilder.toString());
        paramString.initCause((Throwable)paramObject);
        throw paramString;
      }
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      try
      {
        if (this.mMethod.getReturnType() == Boolean.TYPE) {
          return ((Boolean)this.mMethod.invoke(this.mRealOwner, new Object[] { paramMenuItem })).booleanValue();
        }
        this.mMethod.invoke(this.mRealOwner, new Object[] { paramMenuItem });
        return true;
      }
      catch (Exception paramMenuItem)
      {
        throw new RuntimeException(paramMenuItem);
      }
    }
  }
  
  private class MenuState
  {
    private static final int defaultGroupId = 0;
    private static final int defaultItemCategory = 0;
    private static final int defaultItemCheckable = 0;
    private static final boolean defaultItemChecked = false;
    private static final boolean defaultItemEnabled = true;
    private static final int defaultItemId = 0;
    private static final int defaultItemOrder = 0;
    private static final boolean defaultItemVisible = true;
    private int groupCategory;
    private int groupCheckable;
    private boolean groupEnabled;
    private int groupId;
    private int groupOrder;
    private boolean groupVisible;
    ActionProvider itemActionProvider;
    private String itemActionProviderClassName;
    private String itemActionViewClassName;
    private int itemActionViewLayout;
    private boolean itemAdded;
    private int itemAlphabeticModifiers;
    private char itemAlphabeticShortcut;
    private int itemCategoryOrder;
    private int itemCheckable;
    private boolean itemChecked;
    private CharSequence itemContentDescription;
    private boolean itemEnabled;
    private int itemIconResId;
    private ColorStateList itemIconTintList = null;
    private PorterDuff.Mode itemIconTintMode = null;
    private int itemId;
    private String itemListenerMethodName;
    private int itemNumericModifiers;
    private char itemNumericShortcut;
    private int itemShowAsAction;
    private CharSequence itemTitle;
    private CharSequence itemTitleCondensed;
    private CharSequence itemTooltipText;
    private boolean itemVisible;
    private Menu menu;
    
    public MenuState(Menu paramMenu)
    {
      this.menu = paramMenu;
      resetGroup();
    }
    
    private char getShortcut(String paramString)
    {
      if (paramString == null) {
        return '\000';
      }
      return paramString.charAt(0);
    }
    
    private <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        paramArrayOfClass = SupportMenuInflater.this.mContext.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass);
        paramArrayOfClass.setAccessible(true);
        paramArrayOfClass = paramArrayOfClass.newInstance(paramArrayOfObject);
        return paramArrayOfClass;
      }
      catch (Exception paramArrayOfClass)
      {
        paramArrayOfObject = new StringBuilder();
        paramArrayOfObject.append("Cannot instantiate class: ");
        paramArrayOfObject.append(paramString);
        Log.w("SupportMenuInflater", paramArrayOfObject.toString(), paramArrayOfClass);
      }
      return null;
    }
    
    private void setItem(MenuItem paramMenuItem)
    {
      Object localObject = paramMenuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
      int j = this.itemCheckable;
      int i = 0;
      if (j >= 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
      if (this.itemShowAsAction >= 0) {
        paramMenuItem.setShowAsAction(this.itemShowAsAction);
      }
      if (this.itemListenerMethodName != null) {
        if (!SupportMenuInflater.this.mContext.isRestricted()) {
          paramMenuItem.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(SupportMenuInflater.this.getRealOwner(), this.itemListenerMethodName));
        } else {
          throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        }
      }
      boolean bool = paramMenuItem instanceof MenuItemImpl;
      if (bool) {
        localObject = (MenuItemImpl)paramMenuItem;
      }
      if (this.itemCheckable >= 2) {
        if (bool) {
          ((MenuItemImpl)paramMenuItem).setExclusiveCheckable(true);
        } else if ((paramMenuItem instanceof MenuItemWrapperICS)) {
          ((MenuItemWrapperICS)paramMenuItem).setExclusiveCheckable(true);
        }
      }
      if (this.itemActionViewClassName != null)
      {
        paramMenuItem.setActionView((View)newInstance(this.itemActionViewClassName, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionViewConstructorArguments));
        i = 1;
      }
      if (this.itemActionViewLayout > 0) {
        if (i == 0) {
          paramMenuItem.setActionView(this.itemActionViewLayout);
        } else {
          Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        }
      }
      if (this.itemActionProvider != null) {
        MenuItemCompat.setActionProvider(paramMenuItem, this.itemActionProvider);
      }
      MenuItemCompat.setContentDescription(paramMenuItem, this.itemContentDescription);
      MenuItemCompat.setTooltipText(paramMenuItem, this.itemTooltipText);
      MenuItemCompat.setAlphabeticShortcut(paramMenuItem, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
      MenuItemCompat.setNumericShortcut(paramMenuItem, this.itemNumericShortcut, this.itemNumericModifiers);
      if (this.itemIconTintMode != null) {
        MenuItemCompat.setIconTintMode(paramMenuItem, this.itemIconTintMode);
      }
      if (this.itemIconTintList != null) {
        MenuItemCompat.setIconTintList(paramMenuItem, this.itemIconTintList);
      }
    }
    
    public void addItem()
    {
      this.itemAdded = true;
      setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
    }
    
    public SubMenu addSubMenuItem()
    {
      this.itemAdded = true;
      SubMenu localSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
      setItem(localSubMenu.getItem());
      return localSubMenu;
    }
    
    public boolean hasAddedItem()
    {
      return this.itemAdded;
    }
    
    public void readGroup(AttributeSet paramAttributeSet)
    {
      paramAttributeSet = SupportMenuInflater.this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MenuGroup);
      this.groupId = paramAttributeSet.getResourceId(R.styleable.MenuGroup_android_id, 0);
      this.groupCategory = paramAttributeSet.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
      this.groupOrder = paramAttributeSet.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
      this.groupCheckable = paramAttributeSet.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
      this.groupVisible = paramAttributeSet.getBoolean(R.styleable.MenuGroup_android_visible, true);
      this.groupEnabled = paramAttributeSet.getBoolean(R.styleable.MenuGroup_android_enabled, true);
      paramAttributeSet.recycle();
    }
    
    public void readItem(AttributeSet paramAttributeSet)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public void resetGroup()
    {
      this.groupId = 0;
      this.groupCategory = 0;
      this.groupOrder = 0;
      this.groupCheckable = 0;
      this.groupVisible = true;
      this.groupEnabled = true;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\view\SupportMenuInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */