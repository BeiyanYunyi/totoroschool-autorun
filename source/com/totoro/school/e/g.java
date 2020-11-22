package com.totoro.school.e;

import b.a.l;
import com.totoro.school.entity.score.morning.ScoreMorningRequestModel;
import com.totoro.school.entity.score.run.ScoreRunRequestModel;
import com.totoro.school.entity.score.term.SchoolTermRequestModel;
import com.totoro.school.entity.score.test.ScoreTestRequestModel;
import com.totoro.school.entity.score.year.SchoolYearRequestModel;
import com.totoro.school.utilpub.network.a;
import com.totoro.school.utilpub.network.b;
import com.totoro.school.utilpub.network.c;
import retrofit2.Retrofit;

public class g
  extends b
{
  private com.totoro.school.a.g a = (com.totoro.school.a.g)c().create(com.totoro.school.a.g.class);
  
  public g(c paramc)
  {
    super(paramc);
  }
  
  public void a(ScoreMorningRequestModel paramScoreMorningRequestModel)
  {
    a("query_morning_score", l.just("").concatMap(new -..Lambda.g.l1r5x_QPKXPGI_cWnPSEzwJirVg(this, paramScoreMorningRequestModel)), new a(d(), "query_morning_score", "网络请求中"));
  }
  
  public void a(ScoreRunRequestModel paramScoreRunRequestModel)
  {
    a("query_run_score", l.just("").concatMap(new -..Lambda.g.YvI9nRXPcHyhiA-6VHSf5xc19Hs(this, paramScoreRunRequestModel)), new a(d(), "query_run_score", "网络请求中"));
  }
  
  public void a(SchoolTermRequestModel paramSchoolTermRequestModel)
  {
    a("query_school_term", l.just("").concatMap(new -..Lambda.g.D9wOO90ekO-94ngeh7o2vWREXNU(this, paramSchoolTermRequestModel)), new a(d(), "query_school_term", "网络请求中"));
  }
  
  public void a(ScoreTestRequestModel paramScoreTestRequestModel)
  {
    a("query_test_score", l.just("").concatMap(new -..Lambda.g.l59bSljLM61NwsjzG2CEZ7XX2Dw(this, paramScoreTestRequestModel)), new a(d(), "query_test_score", "网络请求中"));
  }
  
  public void a(SchoolYearRequestModel paramSchoolYearRequestModel)
  {
    a("query_school_year", l.just("").concatMap(new -..Lambda.g.p6of27BWFSpJ65CGs92JbAY_tXc(this, paramSchoolYearRequestModel)), new a(d(), "query_school_year", "网络请求中"));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */