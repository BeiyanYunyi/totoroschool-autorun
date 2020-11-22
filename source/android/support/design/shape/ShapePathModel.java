package android.support.design.shape;

import android.support.design.internal.Experimental;

@Experimental("The shapes API is currently experimental and subject to change")
public class ShapePathModel
{
  private static final CornerTreatment DEFAULT_CORNER_TREATMENT = new CornerTreatment();
  private static final EdgeTreatment DEFAULT_EDGE_TREATMENT = new EdgeTreatment();
  private EdgeTreatment bottomEdge = DEFAULT_EDGE_TREATMENT;
  private CornerTreatment bottomLeftCorner = DEFAULT_CORNER_TREATMENT;
  private CornerTreatment bottomRightCorner = DEFAULT_CORNER_TREATMENT;
  private EdgeTreatment leftEdge = DEFAULT_EDGE_TREATMENT;
  private EdgeTreatment rightEdge = DEFAULT_EDGE_TREATMENT;
  private EdgeTreatment topEdge = DEFAULT_EDGE_TREATMENT;
  private CornerTreatment topLeftCorner = DEFAULT_CORNER_TREATMENT;
  private CornerTreatment topRightCorner = DEFAULT_CORNER_TREATMENT;
  
  public EdgeTreatment getBottomEdge()
  {
    return this.bottomEdge;
  }
  
  public CornerTreatment getBottomLeftCorner()
  {
    return this.bottomLeftCorner;
  }
  
  public CornerTreatment getBottomRightCorner()
  {
    return this.bottomRightCorner;
  }
  
  public EdgeTreatment getLeftEdge()
  {
    return this.leftEdge;
  }
  
  public EdgeTreatment getRightEdge()
  {
    return this.rightEdge;
  }
  
  public EdgeTreatment getTopEdge()
  {
    return this.topEdge;
  }
  
  public CornerTreatment getTopLeftCorner()
  {
    return this.topLeftCorner;
  }
  
  public CornerTreatment getTopRightCorner()
  {
    return this.topRightCorner;
  }
  
  public void setAllCorners(CornerTreatment paramCornerTreatment)
  {
    this.topLeftCorner = paramCornerTreatment;
    this.topRightCorner = paramCornerTreatment;
    this.bottomRightCorner = paramCornerTreatment;
    this.bottomLeftCorner = paramCornerTreatment;
  }
  
  public void setAllEdges(EdgeTreatment paramEdgeTreatment)
  {
    this.leftEdge = paramEdgeTreatment;
    this.topEdge = paramEdgeTreatment;
    this.rightEdge = paramEdgeTreatment;
    this.bottomEdge = paramEdgeTreatment;
  }
  
  public void setBottomEdge(EdgeTreatment paramEdgeTreatment)
  {
    this.bottomEdge = paramEdgeTreatment;
  }
  
  public void setBottomLeftCorner(CornerTreatment paramCornerTreatment)
  {
    this.bottomLeftCorner = paramCornerTreatment;
  }
  
  public void setBottomRightCorner(CornerTreatment paramCornerTreatment)
  {
    this.bottomRightCorner = paramCornerTreatment;
  }
  
  public void setCornerTreatments(CornerTreatment paramCornerTreatment1, CornerTreatment paramCornerTreatment2, CornerTreatment paramCornerTreatment3, CornerTreatment paramCornerTreatment4)
  {
    this.topLeftCorner = paramCornerTreatment1;
    this.topRightCorner = paramCornerTreatment2;
    this.bottomRightCorner = paramCornerTreatment3;
    this.bottomLeftCorner = paramCornerTreatment4;
  }
  
  public void setEdgeTreatments(EdgeTreatment paramEdgeTreatment1, EdgeTreatment paramEdgeTreatment2, EdgeTreatment paramEdgeTreatment3, EdgeTreatment paramEdgeTreatment4)
  {
    this.leftEdge = paramEdgeTreatment1;
    this.topEdge = paramEdgeTreatment2;
    this.rightEdge = paramEdgeTreatment3;
    this.bottomEdge = paramEdgeTreatment4;
  }
  
  public void setLeftEdge(EdgeTreatment paramEdgeTreatment)
  {
    this.leftEdge = paramEdgeTreatment;
  }
  
  public void setRightEdge(EdgeTreatment paramEdgeTreatment)
  {
    this.rightEdge = paramEdgeTreatment;
  }
  
  public void setTopEdge(EdgeTreatment paramEdgeTreatment)
  {
    this.topEdge = paramEdgeTreatment;
  }
  
  public void setTopLeftCorner(CornerTreatment paramCornerTreatment)
  {
    this.topLeftCorner = paramCornerTreatment;
  }
  
  public void setTopRightCorner(CornerTreatment paramCornerTreatment)
  {
    this.topRightCorner = paramCornerTreatment;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\shape\ShapePathModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */