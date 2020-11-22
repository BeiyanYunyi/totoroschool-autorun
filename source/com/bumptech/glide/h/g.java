package com.bumptech.glide.h;

public class g
{
  private Class<?> a;
  private Class<?> b;
  
  public g() {}
  
  public g(Class<?> paramClass1, Class<?> paramClass2)
  {
    a(paramClass1, paramClass2);
  }
  
  public void a(Class<?> paramClass1, Class<?> paramClass2)
  {
    this.a = paramClass1;
    this.b = paramClass2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (g)paramObject;
      if (!this.a.equals(((g)paramObject).a)) {
        return false;
      }
      return this.b.equals(((g)paramObject).b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() * 31 + this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiClassKey{first=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", second=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\h\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */