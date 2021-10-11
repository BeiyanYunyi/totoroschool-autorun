export default interface UpdateAppVersionRequest {
  campusId: string;
  deviceType: "1";
  schoolId: string;
  stuNo: string;
  token: string;
  version: string;
}
