import minimist from "minimist";

type Args = {
  mac?: string;
  server?: boolean;
};

export default minimist(process.argv, {
  string: ["mac"],
  boolean: ["server"],
  alias: {
    m: "mac",
    s: "server",
  },
}) as Args;
