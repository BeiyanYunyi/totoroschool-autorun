package android.support.v7.view.menu;

class BaseWrapper<T>
{
  final T mWrappedObject;
  
  BaseWrapper(T paramT)
  {
    if (paramT != null)
    {
      this.mWrappedObject = paramT;
      return;
    }
    throw new IllegalArgumentException("Wrapped Object can not be null.");
  }
  
  public T getWrappedObject()
  {
    return (T)this.mWrappedObject;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\view\menu\BaseWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */