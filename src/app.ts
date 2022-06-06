/* eslint-disable no-console */
import cors from "cors";
import express from "express";
import totoroMitmRouter from "./controllers/totoroMitmRouter";

require("express-async-errors");

const app = express();

app.use(cors());
app.use("/certs", express.static("./src/data/certs"));
app.use("/app", totoroMitmRouter);
app.get("/", async (req, res) => {
  res.send(
    "<h1>欢迎使用艹猫校园</h1><a href='/certs/pub.crt'>点击下载证书</a>"
  );
});

export default app;
