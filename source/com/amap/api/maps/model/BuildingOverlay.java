package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class BuildingOverlay
  extends BaseOverlay
{
  private BuildingOverlayTotalOptions buildingOverlayTotalOptions = new BuildingOverlayTotalOptions();
  private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
  private BuildingOverlayOptions mDefaultOptions;
  private IBuildingDelegate mDelegate;
  private List<BuildingOverlayOptions> optionList;
  
  public BuildingOverlay(IGlOverlayLayer paramIGlOverlayLayer)
  {
    this.glOverlayLayerRef = new WeakReference(paramIGlOverlayLayer);
    this.buildingOverlayTotalOptions.allOptionList = new ArrayList();
    try
    {
      if (this.mDefaultOptions == null)
      {
        this.mDefaultOptions = new BuildingOverlayOptions();
        this.mDefaultOptions.setVisible(true);
        paramIGlOverlayLayer = new ArrayList();
        paramIGlOverlayLayer.add(new LatLng(84.9D, -179.9D));
        paramIGlOverlayLayer.add(new LatLng(84.9D, 179.9D));
        paramIGlOverlayLayer.add(new LatLng(-84.9D, 179.9D));
        paramIGlOverlayLayer.add(new LatLng(-84.9D, -179.9D));
        this.mDefaultOptions.setBuildingLatlngs(paramIGlOverlayLayer);
        this.mDefaultOptions.setBuildingTopColor(-65536);
        this.mDefaultOptions.setBuildingSideColor(-12303292);
        this.mDefaultOptions.setVisible(true);
        this.mDefaultOptions.setZIndex(1.0F);
        this.buildingOverlayTotalOptions.allOptionList.add(this.mDefaultOptions);
        a(true);
      }
      return;
    }
    catch (Throwable paramIGlOverlayLayer) {}
  }
  
  public BuildingOverlay(IBuildingDelegate paramIBuildingDelegate)
  {
    this.mDelegate = paramIBuildingDelegate;
  }
  
  private void a()
  {
    try
    {
      IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
      if ((!TextUtils.isEmpty(this.overlayName)) && (localIGlOverlayLayer != null)) {
        localIGlOverlayLayer.updateOption(this.overlayName, this.buildingOverlayTotalOptions);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (!paramBoolean) {}
      }
      catch (Exception localException)
      {
        IGlOverlayLayer localIGlOverlayLayer;
        localException.printStackTrace();
        return;
      }
      try
      {
        this.buildingOverlayTotalOptions.allOptionList.set(0, this.mDefaultOptions);
        continue;
        this.buildingOverlayTotalOptions.allOptionList.removeAll(this.optionList);
        this.buildingOverlayTotalOptions.allOptionList.set(0, this.mDefaultOptions);
        this.buildingOverlayTotalOptions.allOptionList.addAll(this.optionList);
        localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
        if (localIGlOverlayLayer != null) {
          localIGlOverlayLayer.updateOption(this.overlayName, this.buildingOverlayTotalOptions);
        }
        return;
      }
      finally {}
    }
    throw localIGlOverlayLayer;
  }
  
  public void destroy()
  {
    try
    {
      if (this.mDelegate != null)
      {
        this.mDelegate.destroy();
        return;
      }
      IGlOverlayLayer localIGlOverlayLayer = (IGlOverlayLayer)this.glOverlayLayerRef.get();
      if (localIGlOverlayLayer != null) {
        localIGlOverlayLayer.removeOverlay(this.overlayName);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public List<BuildingOverlayOptions> getCustomOptions()
  {
    if (this.mDelegate != null) {
      return this.mDelegate.getCustomOptions();
    }
    return this.optionList;
  }
  
  public BuildingOverlayOptions getDefaultOptions()
  {
    if (this.mDelegate != null) {
      return this.mDelegate.getDefaultOptions();
    }
    return this.mDefaultOptions;
  }
  
  public String getId()
  {
    if (this.mDelegate != null) {
      return this.mDelegate.getId();
    }
    return this.overlayName;
  }
  
  public float getZIndex()
  {
    if (this.mDelegate != null) {
      return this.mDelegate.getZIndex();
    }
    if (this.buildingOverlayTotalOptions != null) {
      return BuildingOverlayTotalOptions.a(this.buildingOverlayTotalOptions);
    }
    return 0.0F;
  }
  
  public boolean isVisible()
  {
    if (this.mDelegate != null) {
      return this.mDelegate.isVisible();
    }
    if (this.buildingOverlayTotalOptions != null) {
      return this.buildingOverlayTotalOptions.isVisible;
    }
    return false;
  }
  
  public void setCustomOptions(List<BuildingOverlayOptions> paramList)
  {
    if (this.mDelegate != null)
    {
      this.mDelegate.setCustomOptions(paramList);
      return;
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        this.optionList = paramList;
        a(false);
        return;
      }
      finally {}
    }
  }
  
  public void setDefaultOptions(BuildingOverlayOptions paramBuildingOverlayOptions)
  {
    if (this.mDelegate != null)
    {
      this.mDelegate.setDefaultOptions(paramBuildingOverlayOptions);
      return;
    }
    if (paramBuildingOverlayOptions != null) {
      try
      {
        this.mDefaultOptions = paramBuildingOverlayOptions;
        a(true);
        return;
      }
      finally {}
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (this.mDelegate != null)
    {
      this.mDelegate.setVisible(paramBoolean);
      return;
    }
    if (this.buildingOverlayTotalOptions != null)
    {
      this.buildingOverlayTotalOptions.isVisible = paramBoolean;
      a();
    }
  }
  
  public void setZIndex(float paramFloat)
  {
    if (this.mDelegate != null)
    {
      this.mDelegate.setZIndex(paramFloat);
      return;
    }
    if (this.mDefaultOptions != null) {
      this.mDefaultOptions.setZIndex(paramFloat);
    }
    if (this.buildingOverlayTotalOptions != null)
    {
      BuildingOverlayTotalOptions.a(this.buildingOverlayTotalOptions, paramFloat);
      a();
    }
  }
  
  protected class BuildingOverlayTotalOptions
    extends BaseOptions
  {
    public List<BuildingOverlayOptions> allOptionList;
    public boolean isVisible = true;
    private final String type = "BuildingOptions";
    private float zIndex = 0.0F;
    
    protected BuildingOverlayTotalOptions() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\BuildingOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */