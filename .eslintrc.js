module.exports = {
  extends: [
    "airbnb-base",
    "airbnb-typescript",
    "prettier",
    "plugin:react/jsx-runtime",
  ],
  plugins: ["prettier"],
  env: {
    // 你的环境变量（包含多个预定义的全局变量）
    //
    // browser: true,
    // node: true,
    // mocha: true,
    // jest: true,
    // jquery: true
  },
  globals: {
    // 你的全局变量（设置为 false 表示它不允许被重新赋值）
    //
    // myGlobal: false
  },
  rules: {
    "prettier/prettier": "error",
    "react/jsx-one-expression-per-line": 0,
    "react/jsx-props-no-spreading": 0,
    "react/function-component-definition": 0,
    "react/require-default-props": 0,
  },
  parserOptions: {
    project: "./tsconfig.json",
  },
};
