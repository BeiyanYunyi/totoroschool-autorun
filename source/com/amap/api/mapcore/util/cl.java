package com.amap.api.mapcore.util;

import android.opengl.GLES20;
import com.autonavi.base.amap.mapcore.gles.AMapNativeGLShaderManager;

public class cl
{
  private d a;
  private f b;
  private c c;
  private e d;
  private a e;
  private b f;
  private long g = 0L;
  
  private ck c()
  {
    try
    {
      if (this.a == null) {
        this.a = new d("texture_normal.glsl");
      }
      d locald = this.a;
      return locald;
    }
    finally {}
  }
  
  private ck d()
  {
    try
    {
      if (this.b == null) {
        this.b = new f("texture.glsl");
      }
      f localf = this.b;
      return localf;
    }
    finally {}
  }
  
  private ck e()
  {
    try
    {
      if (this.c == null) {
        this.c = new c("texture_layer.glsl");
      }
      c localc = this.c;
      return localc;
    }
    finally {}
  }
  
  private ck f()
  {
    try
    {
      if (this.d == null) {
        this.d = new e("point.glsl");
      }
      e locale = this.d;
      return locale;
    }
    finally {}
  }
  
  private a g()
  {
    try
    {
      if (this.e == null) {
        this.e = new a();
      }
      a locala = this.e;
      return locala;
    }
    finally {}
  }
  
  private ck h()
  {
    try
    {
      if (this.f == null) {
        this.f = new b();
      }
      b localb = this.f;
      return localb;
    }
    finally {}
  }
  
  public long a()
  {
    return this.g;
  }
  
  public ck a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 5: 
      return h();
    case 4: 
      return g();
    case 3: 
      return f();
    case 2: 
      return e();
    case 1: 
      return c();
    }
    return d();
  }
  
  public void b()
  {
    try
    {
      if (this.a != null)
      {
        this.a.b();
        this.a = null;
      }
      if (this.b != null)
      {
        this.b.b();
        this.b = null;
      }
      if (this.c != null)
      {
        this.c.b();
        this.c = null;
      }
      if (this.d != null)
      {
        this.d.b();
        this.d = null;
      }
      if (this.g != 0L)
      {
        AMapNativeGLShaderManager.nativeDestroyGLShaderManager(this.g);
        this.g = 0L;
      }
      return;
    }
    finally {}
  }
  
  public static class a
    extends ck
  {
    String a;
    String b;
    public int c;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    
    public a()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("precision highp float;\n        attribute vec4 aVertex;\n        attribute vec2 aTexture;\n        uniform vec4 aMapAttribute;\n        uniform mat4 aMVPMatrix;\n        uniform mat4 aProjection;\n        uniform vec3 aInstanceOffset[");
      localStringBuilder.append(x.a);
      localStringBuilder.append("];\n        varying vec2 texture;\n        mat4 rotationMatrix(vec3 axis, float angle)\n        {\n           axis = normalize(axis);\n           float s = sin(angle);\n           float c = cos(angle);\n           float oc = 1.0 - c;\n           return mat4(oc * axis.x * axis.x + c,           oc * axis.x * axis.y - axis.z * s,  oc * axis.z * axis.x + axis.y * s,  0.0,\n                 oc * axis.x * axis.y + axis.z * s,  oc * axis.y * axis.y + c,           oc * axis.y * axis.z - axis.x * s,  0.0,\n                 oc * axis.z * axis.x - axis.y * s,  oc * axis.y * axis.z + axis.x * s,  oc * axis.z * axis.z + c,           0.0,\n                 0.0,                                0.0,                                0.0,                                1.0);\n        }\n        void main(){\n            int instance = int(aVertex.w);\n            vec3 offset_value = aInstanceOffset[instance];\n            mat4 marker_rotate_mat4 = rotationMatrix(vec3(0,0,1.0), offset_value.z * 0.01745);\n            float map_rotate = -aMapAttribute.z * 0.01745;\n            float map_tilt = aMapAttribute.w * 0.01745;\n            //tilt旋转矩阵\n            mat4 map_tilt_mat4 = rotationMatrix(vec3(1,0,0), map_tilt);\n            //bearing旋转矩阵\n            mat4 map_rotate_mat4 = rotationMatrix(vec3(0,0,1), map_rotate);\n                 \n            //旋转图片\n            vec4 pos_1 = marker_rotate_mat4 * vec4(aVertex.xy * aMapAttribute.xy, 0,1);\n                  \n            //让marker站立，tilt旋转之后z轴值有可能不是0\n            vec4 pos_2 =  map_tilt_mat4 * pos_1;\n                  \n            //旋转 bearing\n            vec4 pos_3 =  map_rotate_mat4 * pos_2;\n            gl_Position = aProjection * aMVPMatrix * vec4(pos_3.xy + offset_value.xy, pos_3.z, 1.0);\n            texture = aTexture;\n        }");
      this.a = localStringBuilder.toString();
      this.b = "        precision highp float;\n        varying vec2 texture;\n        uniform sampler2D aTextureUnit0;\n        void main(){\n            vec4 tempColor = texture2D(aTextureUnit0, texture);\n            gl_FragColor = tempColor;\n        }";
      if (!a(this.a, this.b)) {
        return;
      }
      this.g = c("aMVPMatrix");
      this.k = c("aProjection");
      this.i = c("aInstanceOffset");
      this.j = c("aMapAttribute");
      this.c = b("aVertex");
      this.h = b("aTexture");
    }
  }
  
  public static class b
    extends ck
  {
    String a = "precision highp float;\n        attribute vec3 aVertex;//顶点数组,三维坐标\n        attribute vec2 aTexture;\n        uniform mat4 aMVPMatrix;//mvp矩阵\n        varying vec2 texture;//\n        void main(){\n            gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n            texture = aTexture;\n        }";
    String b = "        precision highp float;\n        varying vec2 texture;//\n        uniform sampler2D aTextureUnit0;//纹理id\n        void main(){\n            gl_FragColor = texture2D(aTextureUnit0, texture);\n        }";
    public int c;
    public int g;
    public int h;
    
    public b()
    {
      if (!a(this.a, this.b)) {
        return;
      }
      this.c = GLES20.glGetAttribLocation(this.d, "aVertex");
      this.h = GLES20.glGetAttribLocation(this.d, "aTexture");
      this.g = GLES20.glGetUniformLocation(this.d, "aMVPMatrix");
    }
  }
  
  public static class c
    extends ck
  {
    public int a;
    public int b;
    public int c;
    public int g;
    public int h;
    
    c(String paramString)
    {
      if (!a(paramString)) {
        return;
      }
      this.a = c("aMVP");
      this.b = b("aVertex");
      this.c = b("aTextureCoord");
      this.g = c("aTransform");
      this.h = c("aColor");
    }
  }
  
  public static class d
    extends ck
  {
    public int a;
    public int b;
    public int c;
    public int g;
    public int h;
    
    d(String paramString)
    {
      if (!a(paramString)) {
        return;
      }
      this.a = c("aMVP");
      df.a("getUniform");
      this.h = c("aMapBearing");
      this.b = b("aVertex");
      this.c = b("aTextureCoord");
      this.g = b("aBearingTiltAlpha");
    }
  }
  
  public static class e
    extends ck
  {
    public int a;
    public int b;
    public int c;
    
    e(String paramString)
    {
      if (!a(paramString)) {
        return;
      }
      this.a = c("aMVPMatrix");
      this.c = c("aColor");
      this.b = b("aVertex");
    }
  }
  
  public static class f
    extends ck
  {
    public int a;
    public int b;
    public int c;
    
    f(String paramString)
    {
      if (!a(paramString)) {
        return;
      }
      this.a = c("aMVP");
      this.b = b("aVertex");
      this.c = b("aTextureCoord");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */