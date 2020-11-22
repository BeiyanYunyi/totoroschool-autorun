package b.a.e.e.d;

import b.a.d.g;
import b.a.e.b.b;
import b.a.e.d.h;
import b.a.e.d.o;
import b.a.e.j.e;
import b.a.e.j.f;
import b.a.e.j.j;
import b.a.e.j.n;
import b.a.q;
import b.a.s;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class k
{
  public static <T> void a(q<? extends T> paramq)
  {
    f localf = new f();
    o localo = new o(b.a.e.b.a.b(), localf, localf, b.a.e.b.a.b());
    paramq.subscribe(localo);
    e.a(localf, localo);
    paramq = localf.a;
    if (paramq == null) {
      return;
    }
    throw j.a(paramq);
  }
  
  public static <T> void a(q<? extends T> paramq, g<? super T> paramg, g<? super Throwable> paramg1, b.a.d.a parama)
  {
    b.a(paramg, "onNext is null");
    b.a(paramg1, "onError is null");
    b.a(parama, "onComplete is null");
    a(paramq, new o(paramg, paramg1, parama, b.a.e.b.a.b()));
  }
  
  public static <T> void a(q<? extends T> paramq, s<? super T> params)
  {
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
    h localh = new h(localLinkedBlockingQueue);
    params.onSubscribe(localh);
    paramq.subscribe(localh);
    Object localObject1;
    do
    {
      if (localh.isDisposed()) {
        return;
      }
      Object localObject2 = localLinkedBlockingQueue.poll();
      localObject1 = localObject2;
      if (localObject2 == null) {
        try
        {
          localObject1 = localLinkedBlockingQueue.take();
        }
        catch (InterruptedException paramq)
        {
          localh.dispose();
          params.onError(paramq);
          return;
        }
      }
    } while ((!localh.isDisposed()) && (paramq != h.TERMINATED) && (!n.acceptFull(localObject1, params)));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */