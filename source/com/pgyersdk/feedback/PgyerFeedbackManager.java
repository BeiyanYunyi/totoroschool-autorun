package com.pgyersdk.feedback;

import com.pgyersdk.f.l;
import com.pgyersdk.feedback.a.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class PgyerFeedbackManager
{
  private static PgyerFeedbackManager a;
  private k b;
  
  private PgyerFeedbackManager(int paramInt, TYPE paramTYPE, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b = new k(paramInt, paramTYPE, new JSONObject(paramMap).toString());
      return;
    }
    this.b = new k(paramTYPE, new JSONObject(paramMap).toString());
  }
  
  public static PgyerFeedbackManager getInstance()
  {
    PgyerFeedbackManager localPgyerFeedbackManager = a;
    if (localPgyerFeedbackManager != null) {
      return localPgyerFeedbackManager;
    }
    throw new IllegalArgumentException("Please getInstance() of PgyerFeedbackManager before use this builder ");
  }
  
  k b()
  {
    return this.b;
  }
  
  public void invoke()
  {
    if (!l.a()) {
      return;
    }
    this.b.e();
  }
  
  public void register()
  {
    if (!l.a()) {
      return;
    }
    this.b.f();
  }
  
  public static class PgyerFeedbackBuilder
  {
    private PgyerFeedbackManager.TYPE displayType = PgyerFeedbackManager.TYPE.DIALOG_TYPE;
    private boolean isShakeInvoke = true;
    private HashMap<String, String> moreParam = new HashMap();
    private int shakingThreshold = 950;
    
    public PgyerFeedbackManager builder()
    {
      PgyerFeedbackManager.a(new PgyerFeedbackManager(this.shakingThreshold, this.displayType, this.moreParam, this.isShakeInvoke, null));
      return PgyerFeedbackManager.a();
    }
    
    public PgyerFeedbackBuilder setBarBackgroundColor(String paramString)
    {
      if (l.b(paramString)) {
        FeedbackActivity.setBarBackgroundColor(paramString);
      }
      return this;
    }
    
    public PgyerFeedbackBuilder setBarButtonPressedColor(String paramString)
    {
      if (l.b(paramString)) {
        FeedbackActivity.setBarButtonPressedColor(paramString);
      }
      return this;
    }
    
    public PgyerFeedbackBuilder setBarImmersive(boolean paramBoolean)
    {
      FeedbackActivity.setBarImmersive(Boolean.valueOf(true));
      return this;
    }
    
    public PgyerFeedbackBuilder setColorDialogTitle(String paramString)
    {
      if (l.b(paramString)) {
        m.a(paramString);
      }
      return this;
    }
    
    public PgyerFeedbackBuilder setColorPickerBackgroundColor(String paramString)
    {
      if (l.b(paramString)) {
        FeedbackActivity.setColorPickerBackgroundColor(paramString);
      }
      return this;
    }
    
    public PgyerFeedbackBuilder setColorTitleBg(String paramString)
    {
      if (l.b(paramString)) {
        m.b(paramString);
      }
      return this;
    }
    
    public PgyerFeedbackBuilder setDisplayType(PgyerFeedbackManager.TYPE paramTYPE)
    {
      this.displayType = paramTYPE;
      return this;
    }
    
    public PgyerFeedbackBuilder setMoreParam(String paramString1, String paramString2)
    {
      this.moreParam.put(paramString1, paramString2);
      return this;
    }
    
    public PgyerFeedbackBuilder setShakeInvoke(boolean paramBoolean)
    {
      this.isShakeInvoke = paramBoolean;
      return this;
    }
    
    public PgyerFeedbackBuilder setShakingThreshold(int paramInt)
    {
      this.shakingThreshold = paramInt;
      return this;
    }
  }
  
  public static enum TYPE
  {
    ACTIVITY_TYPE,  DIALOG_TYPE;
    
    private TYPE() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\PgyerFeedbackManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */