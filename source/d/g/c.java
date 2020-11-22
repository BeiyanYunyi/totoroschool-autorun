package d.g;

class c
  extends b
{
  public static final boolean a(char paramChar1, char paramChar2, boolean paramBoolean)
  {
    if (paramChar1 == paramChar2) {
      return true;
    }
    if (!paramBoolean) {
      return false;
    }
    if (Character.toUpperCase(paramChar1) == Character.toUpperCase(paramChar2)) {
      return true;
    }
    return Character.toLowerCase(paramChar1) == Character.toLowerCase(paramChar2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */