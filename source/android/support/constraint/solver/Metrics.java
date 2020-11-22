package android.support.constraint.solver;

import java.util.ArrayList;

public class Metrics
{
  public long additionalMeasures;
  public long barrierConnectionResolved;
  public long bfs;
  public long centerConnectionResolved;
  public long chainConnectionResolved;
  public long constraints;
  public long errors;
  public long extravariables;
  public long fullySolved;
  public long graphOptimizer;
  public long iterations;
  public long lastTableSize;
  public long matchConnectionResolved;
  public long maxRows;
  public long maxTableSize;
  public long maxVariables;
  public long measures;
  public long minimize;
  public long minimizeGoal;
  public long nonresolvedWidgets;
  public long oldresolvedWidgets;
  public long optimize;
  public long pivots;
  public ArrayList<String> problematicLayouts = new ArrayList();
  public long resolutions;
  public long resolvedWidgets;
  public long simpleconstraints;
  public long slackvariables;
  public long tableSizeIncrease;
  public long variables;
  
  public void reset()
  {
    this.measures = 0L;
    this.additionalMeasures = 0L;
    this.resolutions = 0L;
    this.tableSizeIncrease = 0L;
    this.maxTableSize = 0L;
    this.lastTableSize = 0L;
    this.maxVariables = 0L;
    this.maxRows = 0L;
    this.minimize = 0L;
    this.minimizeGoal = 0L;
    this.constraints = 0L;
    this.simpleconstraints = 0L;
    this.optimize = 0L;
    this.iterations = 0L;
    this.pivots = 0L;
    this.bfs = 0L;
    this.variables = 0L;
    this.errors = 0L;
    this.slackvariables = 0L;
    this.extravariables = 0L;
    this.fullySolved = 0L;
    this.graphOptimizer = 0L;
    this.resolvedWidgets = 0L;
    this.oldresolvedWidgets = 0L;
    this.nonresolvedWidgets = 0L;
    this.centerConnectionResolved = 0L;
    this.matchConnectionResolved = 0L;
    this.chainConnectionResolved = 0L;
    this.barrierConnectionResolved = 0L;
    this.problematicLayouts.clear();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n*** Metrics ***\nmeasures: ");
    localStringBuilder.append(this.measures);
    localStringBuilder.append("\nadditionalMeasures: ");
    localStringBuilder.append(this.additionalMeasures);
    localStringBuilder.append("\nresolutions passes: ");
    localStringBuilder.append(this.resolutions);
    localStringBuilder.append("\ntable increases: ");
    localStringBuilder.append(this.tableSizeIncrease);
    localStringBuilder.append("\nmaxTableSize: ");
    localStringBuilder.append(this.maxTableSize);
    localStringBuilder.append("\nmaxVariables: ");
    localStringBuilder.append(this.maxVariables);
    localStringBuilder.append("\nmaxRows: ");
    localStringBuilder.append(this.maxRows);
    localStringBuilder.append("\n\nminimize: ");
    localStringBuilder.append(this.minimize);
    localStringBuilder.append("\nminimizeGoal: ");
    localStringBuilder.append(this.minimizeGoal);
    localStringBuilder.append("\nconstraints: ");
    localStringBuilder.append(this.constraints);
    localStringBuilder.append("\nsimpleconstraints: ");
    localStringBuilder.append(this.simpleconstraints);
    localStringBuilder.append("\noptimize: ");
    localStringBuilder.append(this.optimize);
    localStringBuilder.append("\niterations: ");
    localStringBuilder.append(this.iterations);
    localStringBuilder.append("\npivots: ");
    localStringBuilder.append(this.pivots);
    localStringBuilder.append("\nbfs: ");
    localStringBuilder.append(this.bfs);
    localStringBuilder.append("\nvariables: ");
    localStringBuilder.append(this.variables);
    localStringBuilder.append("\nerrors: ");
    localStringBuilder.append(this.errors);
    localStringBuilder.append("\nslackvariables: ");
    localStringBuilder.append(this.slackvariables);
    localStringBuilder.append("\nextravariables: ");
    localStringBuilder.append(this.extravariables);
    localStringBuilder.append("\nfullySolved: ");
    localStringBuilder.append(this.fullySolved);
    localStringBuilder.append("\ngraphOptimizer: ");
    localStringBuilder.append(this.graphOptimizer);
    localStringBuilder.append("\nresolvedWidgets: ");
    localStringBuilder.append(this.resolvedWidgets);
    localStringBuilder.append("\noldresolvedWidgets: ");
    localStringBuilder.append(this.oldresolvedWidgets);
    localStringBuilder.append("\nnonresolvedWidgets: ");
    localStringBuilder.append(this.nonresolvedWidgets);
    localStringBuilder.append("\ncenterConnectionResolved: ");
    localStringBuilder.append(this.centerConnectionResolved);
    localStringBuilder.append("\nmatchConnectionResolved: ");
    localStringBuilder.append(this.matchConnectionResolved);
    localStringBuilder.append("\nchainConnectionResolved: ");
    localStringBuilder.append(this.chainConnectionResolved);
    localStringBuilder.append("\nbarrierConnectionResolved: ");
    localStringBuilder.append(this.barrierConnectionResolved);
    localStringBuilder.append("\nproblematicsLayouts: ");
    localStringBuilder.append(this.problematicLayouts);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\solver\Metrics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */