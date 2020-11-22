package d.c;

import d.c.b.h;
import d.e.c;

public final class a
{
  public static final <T> Class<T> a(c<T> paramc)
  {
    h.b(paramc, "$this$javaObjectType");
    paramc = ((d.c.b.b)paramc).a();
    if (!paramc.isPrimitive())
    {
      if (paramc != null) {
        return paramc;
      }
      throw new d.b("null cannot be cast to non-null type java.lang.Class<T>");
    }
    String str = paramc.getName();
    if (str != null) {
      switch (str.hashCode())
      {
      default: 
        break;
      case 109413500: 
        if (str.equals("short")) {
          paramc = Short.class;
        }
        break;
      case 97526364: 
        if (str.equals("float")) {
          paramc = Float.class;
        }
        break;
      case 64711720: 
        if (str.equals("boolean")) {
          paramc = Boolean.class;
        }
        break;
      case 3625364: 
        if (str.equals("void")) {
          paramc = Void.class;
        }
        break;
      case 3327612: 
        if (str.equals("long")) {
          paramc = Long.class;
        }
        break;
      case 3052374: 
        if (str.equals("char")) {
          paramc = Character.class;
        }
        break;
      case 3039496: 
        if (str.equals("byte")) {
          paramc = Byte.class;
        }
        break;
      case 104431: 
        if (str.equals("int")) {
          paramc = Integer.class;
        }
        break;
      case -1325958191: 
        if (str.equals("double")) {
          paramc = Double.class;
        }
        break;
      }
    }
    if (paramc != null) {
      return paramc;
    }
    throw new d.b("null cannot be cast to non-null type java.lang.Class<T>");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */