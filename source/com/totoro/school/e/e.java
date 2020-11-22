package com.totoro.school.e;

import android.content.Context;
import b.a.l;
import com.totoro.school.entity.morning.exercise.MorningExerciseRequestModel;
import com.totoro.school.entity.morning.helpCode.HelpCodeRequestModel;
import com.totoro.school.entity.morning.helpSign.HelpSignRequestModel;
import com.totoro.school.entity.morning.qrCode.QrCodeRequestModel;
import com.totoro.school.entity.morning.taskPoint.TaskPointRequestModel;
import com.totoro.school.utilpub.network.a;
import com.totoro.school.utilpub.network.b;
import com.totoro.school.utilpub.network.c;
import retrofit2.Retrofit;

public class e
  extends b
{
  private com.totoro.school.a.e a = (com.totoro.school.a.e)c().create(com.totoro.school.a.e.class);
  
  public e(c paramc)
  {
    super(paramc);
  }
  
  public void a(MorningExerciseRequestModel paramMorningExerciseRequestModel, Context paramContext)
  {
    a("morning_exercise", l.just("").concatMap(new -..Lambda.e.p3VDIzQVGYRh-539QNwSpQVTuI8(this, paramMorningExerciseRequestModel, paramContext)), new a(d(), "morning_exercise", "网络请求中"));
  }
  
  public void a(HelpCodeRequestModel paramHelpCodeRequestModel)
  {
    a("help_qr_code", l.just("").concatMap(new -..Lambda.e.9frTGvLLa8YVhQJGJFaunhjleJ0(this, paramHelpCodeRequestModel)), new a(d(), "help_qr_code", "网络请求中"));
  }
  
  public void a(HelpSignRequestModel paramHelpSignRequestModel)
  {
    a("help_sign", l.just("").concatMap(new -..Lambda.e.hsfBkaUc4mYBQF9v_dybUG1UMrI(this, paramHelpSignRequestModel)), new a(d(), "help_sign", "网络请求中"));
  }
  
  public void a(QrCodeRequestModel paramQrCodeRequestModel)
  {
    a("qr_code", l.just("").concatMap(new -..Lambda.e.3wj5X0uQ2G81RLqcxWQaNzTslZQ(this, paramQrCodeRequestModel)), new a(d(), "qr_code", "网络请求中"));
  }
  
  public void a(TaskPointRequestModel paramTaskPointRequestModel)
  {
    a("task_point_list", l.just("").concatMap(new -..Lambda.e.kMfebfnMYQssZfkyghQmeK67RGs(this, paramTaskPointRequestModel)), new a(d(), "task_point_list", "网络请求中"));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */