# 使用官方 Node.js 16 轻量级镜像.
# https://hub.docker.com/_/node
FROM node:16-alpine
# 定义工作目录
WORKDIR /usr/src/app
# 将依赖定义文件拷贝到工作目录下
COPY ["package.json", "yarn.lock", "./"]
# 以 production 形式安装依赖
RUN corepack enable && yarn && mkdir certs
# 将本地代码复制到工作目录内
COPY ["src", "tsconfig.json", "./"]
RUN yarn build && rm -rf ~/.yarn ./src
COPY ["src/data/certs", "./certs"]
ENV CONTAINER=true
EXPOSE 443
# 启动服务
CMD [ "yarn", "start", "-s" ]