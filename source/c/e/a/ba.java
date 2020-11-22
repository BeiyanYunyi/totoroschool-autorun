package c.e.a;

import c.a;
import c.a.ag;
import c.a.an;
import c.a.aq;
import c.i;
import java.util.ArrayList;

public class ba
  extends aq
{
  private ArrayList a;
  
  protected ba(ArrayList paramArrayList)
  {
    super(an.aG);
    this.a = paramArrayList;
  }
  
  public byte[] a()
  {
    int i = this.a.size();
    int j = 2;
    byte[] arrayOfByte = new byte[i * 8 + 2];
    int k = this.a.size();
    i = 0;
    ag.a(k, arrayOfByte, 0);
    while (i < this.a.size())
    {
      Object localObject = (i)this.a.get(i);
      a locala = ((i)localObject).a();
      localObject = ((i)localObject).b();
      ag.a(locala.j_(), arrayOfByte, j);
      ag.a(((a)localObject).j_(), arrayOfByte, j + 2);
      ag.a(locala.b(), arrayOfByte, j + 4);
      ag.a(((a)localObject).b(), arrayOfByte, j + 6);
      j += 8;
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */