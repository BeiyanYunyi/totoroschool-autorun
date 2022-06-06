/* eslint-disable no-console */
import { format, intervalToDuration } from "date-fns";
import { v4 as uuidv4 } from "uuid";
import SunRunExercisesRequest from "../types/requestTypes/SunRunExercisesRequest";
import argv from "../utils/argv";
import calCalculator from "../utils/calCalculator";
import generateMac from "../utils/generateMac";
import normalRandom from "../utils/normalRandom";
import printWaitProgress from "../utils/printWaitProgress";
import timeUtil from "../utils/timeUtil";

const generateRunReq = async ({
  distance,
  routeId,
  taskId,
  token,
  schoolId,
  stuNumber,
  phoneNumber,
}: {
  distance: string;
  routeId: string;
  taskId: string;
  token: string;
  schoolId: string;
  stuNumber: string;
  phoneNumber: string;
}): Promise<SunRunExercisesRequest & Record<string, unknown>> => {
  const waitSecond = Math.floor(normalRandom(450, 40));
  const startTime = new Date();
  const endTime = new Date(Number(startTime) + waitSecond * 1000);
  const distanceNum = Number(distance);
  const avgSpeed = (distanceNum / (waitSecond / 3600)).toFixed(2);
  const duration = intervalToDuration({ start: startTime, end: endTime });
  const mac = argv.mac || generateMac(stuNumber);
  if (!argv.mac) console.log(`使用从学号生成的 MAC：${mac}`);
  const req = {
    LocalSubmitReason: "",
    avgSpeed,
    baseStation: "mcc:0 mnc:0 lac:false ci:false strength:0",
    consume: calCalculator(distance),
    endTime: format(endTime, "HH:mm:ss"),
    evaluateDate: "",
    fitDegree: "1",
    flag: "1",
    headImage: "",
    ifLocalSubmit: "0",
    km: distance,
    mac,
    phoneInfo: "CN001/null/unknown/unknown/10",
    phoneNumber,
    pointList: [],
    routeId,
    runType: "0",
    schoolId,
    sensorString: "",
    startTime: format(startTime, "HH:mm:ss"),
    steps: `${1000 + Math.floor(Math.random() * 1000)}`,
    stuNumber,
    submitDate: format(endTime, "yyyy-MM-dd"),
    taskId,
    token,
    usedTime: timeUtil.getHHmmss(duration),
    uuid: uuidv4(),
    version: "2.0.3",
    warnFlag: "0",
    warnType: "",
  };
  if (!argv.server) console.log(req);
  await printWaitProgress(endTime, "在跑了");
  return req;
};

export default generateRunReq;
