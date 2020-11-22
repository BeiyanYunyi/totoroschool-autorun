package com.amap.api.maps.model;

public class AMapCameraInfo
{
  private float aspectRatio = 1.0F;
  private float fov = 0.0F;
  private float positionX = 0.0F;
  private float positionY = 0.0F;
  private float positionZ = 0.0F;
  private float rotate = 0.0F;
  
  public AMapCameraInfo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.fov = paramFloat1;
    this.aspectRatio = paramFloat2;
    this.rotate = paramFloat3;
    this.positionX = paramFloat4;
    this.positionY = paramFloat5;
    this.positionZ = paramFloat6;
  }
  
  public float getAspectRatio()
  {
    return this.aspectRatio;
  }
  
  public float getFov()
  {
    return this.fov;
  }
  
  public float getRotate()
  {
    return this.rotate;
  }
  
  public float getX()
  {
    return this.positionX;
  }
  
  public float getY()
  {
    return this.positionY;
  }
  
  public float getZ()
  {
    return this.positionZ;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("fov:");
    localStringBuilder.append(this.fov);
    localStringBuilder.append(" ");
    localStringBuilder.append("aspectRatio:");
    localStringBuilder.append(this.aspectRatio);
    localStringBuilder.append(" ");
    localStringBuilder.append("rotate:");
    localStringBuilder.append(this.rotate);
    localStringBuilder.append(" ");
    localStringBuilder.append("pos_x:");
    localStringBuilder.append(this.positionX);
    localStringBuilder.append(" ");
    localStringBuilder.append("pos_y:");
    localStringBuilder.append(this.positionY);
    localStringBuilder.append(" ");
    localStringBuilder.append("pos_z:");
    localStringBuilder.append(this.positionZ);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\AMapCameraInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */