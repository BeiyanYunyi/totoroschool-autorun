/* eslint-disable no-console */
import express from "express";
import argv from "../utils/argv";
import getDecryptedData from "../middlewares/getDecryptedData";
import setHeader from "../middlewares/setHeader";
import BasicRequest from "../types/requestTypes/BasicRequest";
import GetLesseeServerRequest from "../types/requestTypes/GetLesseeServerRequest";
import GetSchoolMonthByTermRequest from "../types/requestTypes/GetSchoolMonthByTermRequest";
import GetSchoolTermRequest from "../types/requestTypes/GetSchoolTermRequest";
import GetSunRunArchDetailRequest from "../types/requestTypes/GetSunRunArchDetailRequest";
import GetSunRunArchRequest from "../types/requestTypes/GetSunRunArchRequest";
import LoginRequest from "../types/requestTypes/LoginRequest";
import UpdateAppVersionRequest from "../types/requestTypes/UpdateAppVersionRequest";
import GetAppNoticeResponse from "../types/responseTypes/GetAppNoticeResponse";
import GetSunRunPaperResponse from "../types/responseTypes/GetSunRunPaperResponse";
import LoginResponse from "../types/responseTypes/LoginResponse";
import userConfig from "../utils/userConfig";
import TotoroApiWrapper from "../wrappers/TotoroApiWrapper";
import runController from "./runController";
import sessionController from "./sessionController";
import getAppNoticeVoList from "../data/appNoticeVoList";

require("express-async-errors");

const totoroMitmRouter = express.Router();

totoroMitmRouter.use(setHeader);

totoroMitmRouter.post("/platform/serverlist/getRegisterUrl", (req, res) => {
  res.send({
    status: "00",
    msg: null,
    data: null,
    obj: null,
    body: null,
    obj1: null,
    resultMap: null,
    total: 0,
    wxLoginStatus: 0,
    msgList: [],
    message: null,
    code: "0",
    token: null,
    registerUrl: "https://admin.xtotoro.com/regH5",
  });
});

totoroMitmRouter.use(getDecryptedData);

totoroMitmRouter.post(
  "/platform/serverlist/getLesseeServer",
  async (req, res) => {
    const { code } = req.body as GetLesseeServerRequest;
    const data = await TotoroApiWrapper.getLesseeServer(code);
    res.send(data);
  }
);

totoroMitmRouter.post("/platform/serverlist/getAppAd", async (req, res) => {
  // 以防上一条被龙猫 app 耍异步
  const { code } = req.body as GetLesseeServerRequest;
  const data = await TotoroApiWrapper.getAppAd(code);
  res.send(data);
});

totoroMitmRouter.post("/platform/login/login", async (req, res) => {
  const { token } = req.body as LoginRequest;
  const data = await TotoroApiWrapper.login(token);
  if (!argv.server || userConfig.getUsersWhiteList().includes(data.stuName)) {
    const sessionExist = sessionController.detectSessionExist(data.phoneNumber);
    console.log(
      sessionExist
        ? `${data.stuNumber} ${data.stuName} 二次登录`
        : `${data.stuNumber} ${data.stuName} 登录成功`
    );
    const dataToSend: LoginResponse = {
      ...data,
      code: sessionExist ? "1" : data.code,
      message: sessionExist ? "十分钟内\n不要重复登录" : data.message,
      schoolName: "点击“阳光跑”开始艹猫",
      headPortrait:
        "https://cdn.jsdelivr.net/gh/lixiang810/fk-gfw/fkTotoro.png",
    };
    res.send(dataToSend);
  } else {
    console.log(`${data.stuName} 试图进行无授权跑步`);
    const dataToSend: LoginResponse = {
      ...data,
      code: "1",
      message: `${data.stuName} 没有艹猫权限`,
    };
    res.send(dataToSend);
  }
});

totoroMitmRouter.post("/platform/login/getAppFrontPage", async (req, res) => {
  const { token } = req.body as BasicRequest;
  const data = await TotoroApiWrapper.getAppFrontPage(token);
  res.send({ ...data, mornsignInfoVo: { completedTimes: "114514" } });
});

totoroMitmRouter.post("/platform/serverlist/getAppSlogan", async (req, res) => {
  const { token } = req.body as BasicRequest;
  const data = await TotoroApiWrapper.getAppSlogan(token);
  res.send({ ...data, content: "破解成功" });
});

totoroMitmRouter.post(
  "/platform/serverlist/updateAppVersion",
  async (req, res) => {
    const { token } = req.body as UpdateAppVersionRequest;
    const data = await TotoroApiWrapper.updateAppVersion(token);
    res.send(data);
  }
);

totoroMitmRouter.post("/platform/serverlist/getAppNotice", async (req, res) => {
  const { token } = req.body as BasicRequest;
  const data = await TotoroApiWrapper.getAppNotice(token);
  const dataToSend: GetAppNoticeResponse = {
    ...data,
    appNoticeVoList: getAppNoticeVoList(),
  };
  res.send(dataToSend);
});

totoroMitmRouter.post("/sunrun/getSunrunPaper", async (req, res) => {
  const { token } = req.body as BasicRequest;
  const data = await TotoroApiWrapper.getSunRunPaper(token);
  if (data.ifHasRun === "0") {
    const dataToSend: GetSunRunPaperResponse = {
      ...data,
      message: "艹猫已开始\n请退出并等 10 分钟\n期间尽量不要再登录",
      code: "1",
    };
    res.send(dataToSend);
    runController(token, data);
  } else {
    res.send(data);
  }
});

totoroMitmRouter.post("/platform/course/getSchoolTerm", async (req, res) => {
  const { token } = req.body as GetSchoolTermRequest;
  const data = await TotoroApiWrapper.getSchoolTerm(token);
  res.send(data);
});

totoroMitmRouter.post(
  "/platform/course/getSchoolMonthByTerm",
  async (req, res) => {
    const { termId, token } = req.body as GetSchoolMonthByTermRequest;
    const data = await TotoroApiWrapper.getSchoolMonthByTerm(termId, token);
    res.send(data);
  }
);

totoroMitmRouter.post("/sunrun/getSunrunArch", async (req, res) => {
  const { monthId, termId, token } = req.body as GetSunRunArchRequest;
  const data = await TotoroApiWrapper.getSunRunArch(monthId, termId, token);
  res.send(data);
});

totoroMitmRouter.post("/sunrun/getSunrunArchDetail", async (req, res) => {
  const { scoreId, token } = req.body as GetSunRunArchDetailRequest;
  const data = await TotoroApiWrapper.getSunRunArchDetail(scoreId, token);
  res.send(data);
});

export default totoroMitmRouter;
