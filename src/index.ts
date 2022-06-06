/* eslint-disable no-console */
import fs from "fs";
import https from "https";
import http from "http";
import app from "./app";
import argv from "./utils/argv";

let server: http.Server | https.Server;
if (argv.server) {
  server = http.createServer(app);
} else {
  const key = fs.readFileSync("./src/data/certs/priv.key");
  const cert = fs.readFileSync("./src/data/certs/pub.crt");
  server = https.createServer({ key, cert }, app);
}
server.listen(
  argv.server ? 11451 : 443,
  argv.server ? "127.0.0.1" : "0.0.0.0",
  undefined,
  () => {
    if (argv.mac) {
      console.log(`使用 MAC 地址 ${argv.mac}`);
    } else {
      console.log(`将由学号生成 MAC 地址`);
    }
    console.log("请在 iOS 设备上完成登录流程");
  }
);
