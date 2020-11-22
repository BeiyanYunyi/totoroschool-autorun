package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityWindowInfo;

public class AccessibilityWindowInfoCompat
{
  public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
  public static final int TYPE_APPLICATION = 1;
  public static final int TYPE_INPUT_METHOD = 2;
  public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
  public static final int TYPE_SYSTEM = 3;
  private static final int UNDEFINED = -1;
  private Object mInfo;
  
  private AccessibilityWindowInfoCompat(Object paramObject)
  {
    this.mInfo = paramObject;
  }
  
  public static AccessibilityWindowInfoCompat obtain()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return wrapNonNullInstance(AccessibilityWindowInfo.obtain());
    }
    return null;
  }
  
  public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat paramAccessibilityWindowInfoCompat)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramAccessibilityWindowInfoCompat == null) {
        return null;
      }
      return wrapNonNullInstance(AccessibilityWindowInfo.obtain((AccessibilityWindowInfo)paramAccessibilityWindowInfoCompat.mInfo));
    }
    return null;
  }
  
  private static String typeToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "<UNKNOWN>";
    case 4: 
      return "TYPE_ACCESSIBILITY_OVERLAY";
    case 3: 
      return "TYPE_SYSTEM";
    case 2: 
      return "TYPE_INPUT_METHOD";
    }
    return "TYPE_APPLICATION";
  }
  
  static AccessibilityWindowInfoCompat wrapNonNullInstance(Object paramObject)
  {
    if (paramObject != null) {
      return new AccessibilityWindowInfoCompat(paramObject);
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (AccessibilityWindowInfoCompat)paramObject;
    if (this.mInfo == null)
    {
      if (((AccessibilityWindowInfoCompat)paramObject).mInfo != null) {
        return false;
      }
    }
    else if (!this.mInfo.equals(((AccessibilityWindowInfoCompat)paramObject).mInfo)) {
      return false;
    }
    return true;
  }
  
  public AccessibilityNodeInfoCompat getAnchor()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo)this.mInfo).getAnchor());
    }
    return null;
  }
  
  public void getBoundsInScreen(Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ((AccessibilityWindowInfo)this.mInfo).getBoundsInScreen(paramRect);
    }
  }
  
  public AccessibilityWindowInfoCompat getChild(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return wrapNonNullInstance(((AccessibilityWindowInfo)this.mInfo).getChild(paramInt));
    }
    return null;
  }
  
  public int getChildCount()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((AccessibilityWindowInfo)this.mInfo).getChildCount();
    }
    return 0;
  }
  
  public int getId()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((AccessibilityWindowInfo)this.mInfo).getId();
    }
    return -1;
  }
  
  public int getLayer()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((AccessibilityWindowInfo)this.mInfo).getLayer();
    }
    return -1;
  }
  
  public AccessibilityWindowInfoCompat getParent()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return wrapNonNullInstance(((AccessibilityWindowInfo)this.mInfo).getParent());
    }
    return null;
  }
  
  public AccessibilityNodeInfoCompat getRoot()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo)this.mInfo).getRoot());
    }
    return null;
  }
  
  public CharSequence getTitle()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return ((AccessibilityWindowInfo)this.mInfo).getTitle();
    }
    return null;
  }
  
  public int getType()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((AccessibilityWindowInfo)this.mInfo).getType();
    }
    return -1;
  }
  
  public int hashCode()
  {
    if (this.mInfo == null) {
      return 0;
    }
    return this.mInfo.hashCode();
  }
  
  public boolean isAccessibilityFocused()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((AccessibilityWindowInfo)this.mInfo).isAccessibilityFocused();
    }
    return true;
  }
  
  public boolean isActive()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((AccessibilityWindowInfo)this.mInfo).isActive();
    }
    return true;
  }
  
  public boolean isFocused()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((AccessibilityWindowInfo)this.mInfo).isFocused();
    }
    return true;
  }
  
  public void recycle()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ((AccessibilityWindowInfo)this.mInfo).recycle();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new Rect();
    getBoundsInScreen((Rect)localObject);
    localStringBuilder.append("AccessibilityWindowInfo[");
    localStringBuilder.append("id=");
    localStringBuilder.append(getId());
    localStringBuilder.append(", type=");
    localStringBuilder.append(typeToString(getType()));
    localStringBuilder.append(", layer=");
    localStringBuilder.append(getLayer());
    localStringBuilder.append(", bounds=");
    localStringBuilder.append(localObject);
    localStringBuilder.append(", focused=");
    localStringBuilder.append(isFocused());
    localStringBuilder.append(", active=");
    localStringBuilder.append(isActive());
    localStringBuilder.append(", hasParent=");
    localObject = getParent();
    boolean bool2 = false;
    if (localObject != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localStringBuilder.append(bool1);
    localStringBuilder.append(", hasChildren=");
    boolean bool1 = bool2;
    if (getChildCount() > 0) {
      bool1 = true;
    }
    localStringBuilder.append(bool1);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityWindowInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */