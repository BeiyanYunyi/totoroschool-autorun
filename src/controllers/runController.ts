/* eslint-disable no-console */
import prompts from "prompts";
import RunPoint from "../types/RunPoint";
import argv from "../utils/argv";
import generateRoute from "../utils/generateRoute";
import normalRandom from "../utils/normalRandom";
import wait from "../utils/wait";
import TotoroApiWrapper from "../wrappers/TotoroApiWrapper";
import GetSunRunPaperResponse from "../types/responseTypes/GetSunRunPaperResponse";

const runController = async (
  token: string,
  sunRunPaperData: GetSunRunPaperResponse
) => {
  if (!argv.server) {
    const waitms = normalRandom(5000, 1000);
    console.log(`你有 ${Math.floor(waitms / 1000)} 秒时间核对有无异常`);
    await wait(waitms);
  }
  let taskToday: RunPoint;
  if (!argv.server) {
    const choices = sunRunPaperData.runPointList.map((point) => ({
      title: point.pointName,
      value: point.pointId,
    }));
    const { target }: { target: string } = await prompts({
      type: "select",
      name: "target",
      message: "请选择路线",
      choices,
    });
    // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
    taskToday = sunRunPaperData.runPointList.find(
      (point) => point.pointId === target
    )!;
  } else {
    taskToday =
      sunRunPaperData.runPointList[
        Math.floor(Math.random() * sunRunPaperData.runPointList.length)
      ];
  }
  await TotoroApiWrapper.getRunBegin(token);
  const route = generateRoute(sunRunPaperData.mileage, taskToday);
  const sunRunRes = await TotoroApiWrapper.sunRunExercises(
    {
      ...route,
      routeId: taskToday.pointId,
      taskId: taskToday.taskId,
    },
    token
  );
  if (!argv.server) console.log(sunRunRes);
  const sunRunDetailRes = await TotoroApiWrapper.sunRunExercisesDetail({
    pointList: route.mockRoute,
    scantronId: sunRunRes.scantronId,
    token,
  });
  if (!argv.server) console.log(sunRunDetailRes);
  await wait(Math.abs(normalRandom(0, 500)));
  const sunRunArchDetailRes = await TotoroApiWrapper.getSunRunArchDetail(
    sunRunRes.scantronId,
    token
  );
  if (sunRunArchDetailRes.flag === "1") {
    console.log("艹猫成功");
  } else {
    console.log("艹猫失败");
  }
};

export default runController;
