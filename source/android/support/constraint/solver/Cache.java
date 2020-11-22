package android.support.constraint.solver;

public class Cache
{
  Pools.Pool<ArrayRow> arrayRowPool = new Pools.SimplePool(256);
  SolverVariable[] mIndexedVariables = new SolverVariable[32];
  Pools.Pool<SolverVariable> solverVariablePool = new Pools.SimplePool(256);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\solver\Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */