export default interface SunRunExercisesRequest {
  avgSpeed: string;
  baseStation: string;
  consume: string;
  endTime: string;
  fitDegree: string;
  flag: string;
  headImage: string | "";
  km: string;
  mac: string;
  phoneInfo: string;
  phoneNumber: string;
  pointList: {
    latitude: string;
    longitude: string;
  }[];
  routeId: string;
  runType: string;
  schoolId: string;
  sensorString: string;
  startTime: string;
  steps: string;
  stuNumber: string;
  submitDate: string;
  taskId: string;
  token: string;
  usedTime: string;
  uuid: string;
  version: string;
  warnFlag: string;
  warnType: string | "";
}
