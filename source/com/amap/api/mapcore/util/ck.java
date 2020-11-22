package com.amap.api.mapcore.util;

import android.opengl.GLES20;

public class ck
{
  private boolean a;
  public int d;
  public int e;
  public int f;
  
  public int a(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    return paramInt;
  }
  
  public void a()
  {
    GLES20.glUseProgram(this.d);
  }
  
  protected boolean a(String paramString)
  {
    this.d = d(paramString);
    return this.d != 0;
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    this.d = b(paramString1, paramString2);
    return this.d != 0;
  }
  
  protected int b(String paramString)
  {
    return GLES20.glGetAttribLocation(this.d, paramString);
  }
  
  public int b(String paramString1, String paramString2)
  {
    this.e = a(35633, paramString1);
    this.f = a(35632, paramString2);
    int i = GLES20.glCreateProgram();
    GLES20.glAttachShader(i, this.e);
    GLES20.glAttachShader(i, this.f);
    GLES20.glLinkProgram(i);
    return i;
  }
  
  public void b()
  {
    if (this.d >= 0) {
      GLES20.glDeleteProgram(this.d);
    }
    if (this.e >= 0) {
      GLES20.glDeleteShader(this.e);
    }
    if (this.f >= 0) {
      GLES20.glDeleteShader(this.f);
    }
    this.a = true;
  }
  
  protected int c(String paramString)
  {
    return GLES20.glGetUniformLocation(this.d, paramString);
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public int d(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("amap_sdk_shaders/");
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    localObject = cy.a(paramString);
    if (localObject != null)
    {
      int i = ((String)localObject).indexOf('$');
      if ((i >= 0) && (((String)localObject).charAt(i + 1) == '$'))
      {
        paramString = ((String)localObject).substring(i + 2);
        return b(((String)localObject).substring(0, i), paramString);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("not a shader file ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("shader file not found: ");
    ((StringBuilder)localObject).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */