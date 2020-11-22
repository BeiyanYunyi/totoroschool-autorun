package c.a.b;

import c.b.c;
import c.m;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

class ba
  implements at
{
  private static c a = c.a(ba.class);
  private String b;
  private String c;
  private as d;
  private Stack e;
  private m f;
  private t g;
  private c.a.ao h;
  private ar i;
  
  public ba(String paramString, t paramt, c.a.ao paramao, m paramm, ar paramar)
  {
    this.b = paramString;
    this.f = paramm;
    this.g = paramt;
    this.h = paramao;
    this.i = paramar;
  }
  
  private as a(Iterator paramIterator)
    throws v
  {
    Stack localStack1 = new Stack();
    Stack localStack2 = new Stack();
    Object localObject4 = null;
    int j = 0;
    Object localObject1 = null;
    Object localObject3 = localObject1;
    Object localObject2;
    while ((paramIterator.hasNext()) && (j == 0))
    {
      as localas = (as)paramIterator.next();
      localas.a(this.i);
      if ((localas instanceof ao))
      {
        a((ao)localas, localStack1);
        localObject2 = localObject1;
      }
      else if ((localas instanceof bb))
      {
        a((bb)localas, paramIterator, localStack1);
        localObject2 = localObject1;
      }
      else if ((localas instanceof ap))
      {
        ap localap = (ap)localas;
        localObject2 = localap;
        if ((localap instanceof bc))
        {
          localObject2 = (bc)localap;
          if ((!localStack1.isEmpty()) && (!(localObject3 instanceof ap))) {
            localObject2 = ((bc)localObject2).a();
          } else {
            localObject2 = ((bc)localObject2).b();
          }
        }
        if (localStack2.empty())
        {
          localStack2.push(localObject2);
          localObject2 = localObject1;
        }
        else
        {
          localObject3 = (ap)localStack2.peek();
          if (((ap)localObject2).i_() < ((ap)localObject3).i_())
          {
            localStack2.push(localObject2);
            localObject2 = localObject1;
          }
          else if ((((ap)localObject2).i_() == ((ap)localObject3).i_()) && ((localObject2 instanceof bk)))
          {
            localStack2.push(localObject2);
            localObject2 = localObject1;
          }
          else
          {
            localStack2.pop();
            ((ap)localObject3).a(localStack1);
            localStack1.push(localObject3);
            localStack2.push(localObject2);
            localObject2 = localObject1;
          }
        }
      }
      else if ((localas instanceof d))
      {
        while (!localStack2.isEmpty())
        {
          localObject2 = (ap)localStack2.pop();
          ((ap)localObject2).a(localStack1);
          localStack1.push(localObject2);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Stack();
        }
        ((Stack)localObject2).push(localStack1.pop());
        localStack1.clear();
      }
      else if ((localas instanceof an))
      {
        localObject2 = a(paramIterator);
        localObject3 = new aq();
        ((as)localObject2).b((as)localObject3);
        ((aq)localObject3).a((as)localObject2);
        localStack1.push(localObject3);
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = localObject1;
        if ((localas instanceof l))
        {
          j = 1;
          localObject2 = localObject1;
        }
      }
      localObject3 = localas;
      localObject1 = localObject2;
    }
    while (!localStack2.isEmpty())
    {
      paramIterator = (ap)localStack2.pop();
      paramIterator.a(localStack1);
      localStack1.push(paramIterator);
    }
    paramIterator = (Iterator)localObject4;
    if (!localStack1.empty()) {
      paramIterator = (as)localStack1.pop();
    }
    if ((localObject1 != null) && (paramIterator != null)) {
      ((Stack)localObject1).push(paramIterator);
    }
    this.e = ((Stack)localObject1);
    if ((!localStack1.empty()) || (!localStack2.empty()))
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Formula ");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(" has a non-empty parse stack");
      ((c)localObject1).b(((StringBuilder)localObject2).toString());
    }
    return paramIterator;
  }
  
  private void a(ao paramao, Stack paramStack)
  {
    boolean bool = paramao instanceof ab;
    if (!bool)
    {
      paramStack.push(paramao);
      return;
    }
    if (bool)
    {
      paramao = (ab)paramao;
      if (!paramao.b())
      {
        paramStack.push(paramao);
        return;
      }
      paramStack.push(new q(paramao.a()));
    }
  }
  
  private void a(bb parambb, Iterator paramIterator, Stack paramStack)
    throws v
  {
    paramIterator = a(paramIterator);
    if (parambb.a(this.f) != x.dz)
    {
      if ((parambb.a(this.f) == x.e) && (this.e == null))
      {
        parambb = new e(parambb, this.f);
        parambb.a(paramIterator);
        paramStack.push(parambb);
        return;
      }
      Object localObject = parambb.a(this.f);
      x localx = x.dy;
      int n = 0;
      int m = 0;
      int k = 0;
      int j = 0;
      if (localObject == localx)
      {
        parambb = new e(parambb, this.f);
        paramIterator = new bm(this.f);
        k = this.e.size();
        while (j < k)
        {
          paramIterator.a((as)this.e.get(j));
          j += 1;
        }
        parambb.a(paramIterator);
        paramStack.push(parambb);
        return;
      }
      if (parambb.a(this.f).c() == 255)
      {
        if (this.e == null)
        {
          j = n;
          if (paramIterator != null) {
            j = 1;
          }
          parambb = new bm(parambb.a(this.f), j, this.f);
          if (paramIterator != null) {
            parambb.a(paramIterator);
          }
          paramStack.push(parambb);
          return;
        }
        n = this.e.size();
        parambb = new bm(parambb.a(this.f), n, this.f);
        paramIterator = new as[n];
        j = 0;
        for (;;)
        {
          k = m;
          if (j >= n) {
            break;
          }
          paramIterator[(n - j - 1)] = ((as)this.e.pop());
          j += 1;
        }
        while (k < paramIterator.length)
        {
          parambb.a(paramIterator[k]);
          k += 1;
        }
        paramStack.push(parambb);
        this.e.clear();
        this.e = null;
        return;
      }
      localObject = new h(parambb.a(this.f), this.f);
      m = parambb.a(this.f).c();
      if (m == 1)
      {
        ((h)localObject).a(paramIterator);
      }
      else
      {
        if ((this.e != null) || (m == 0))
        {
          j = k;
          if (this.e == null) {
            break label475;
          }
          if (m == this.e.size())
          {
            j = k;
            break label475;
          }
        }
        throw new v(v.INCORRECT_ARGUMENTS);
        label475:
        while (j < m)
        {
          ((h)localObject).a((as)this.e.get(j));
          j += 1;
        }
      }
      paramStack.push(localObject);
      return;
    }
    throw new v(v.UNRECOGNIZED_FUNCTION);
  }
  
  private ArrayList d()
    throws v
  {
    localObject2 = new ArrayList();
    bn localbn = new bn(new StringReader(this.b));
    localbn.a(this.g);
    localbn.a(this.h);
    try
    {
      for (localObject1 = localbn.c(); localObject1 != null; localObject1 = localbn.c()) {
        ((ArrayList)localObject2).add(localObject1);
      }
    }
    catch (IOException localIOException)
    {
      Object localObject1;
      a.b(localIOException.toString());
      return (ArrayList)localObject2;
    }
    catch (Error localError)
    {
      for (;;) {}
    }
    localObject1 = v.LEXICAL_ERROR;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append(" at char  ");
    ((StringBuilder)localObject2).append(localbn.a());
    throw new v((v.a)localObject1, ((StringBuilder)localObject2).toString());
  }
  
  public void a()
    throws v
  {
    this.d = a(d().iterator());
  }
  
  public String b()
  {
    if (this.c == null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      this.d.a(localStringBuffer);
      this.c = localStringBuffer.toString();
    }
    return this.c;
  }
  
  public byte[] c()
  {
    byte[] arrayOfByte2 = this.d.c();
    byte[] arrayOfByte1 = arrayOfByte2;
    if (this.d.h())
    {
      arrayOfByte1 = new byte[arrayOfByte2.length + 4];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 4, arrayOfByte2.length);
      arrayOfByte1[0] = bh.L.a();
      arrayOfByte1[1] = 1;
    }
    return arrayOfByte1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */