### Hello World Sample

- Based on https://clojurescript.org/guides/quick-start

```
hello-world        # Our project folder
├─ src             # The CLJS source code for our project
│  └─ hello_world  # Our hello_world namespace folder
│     └─ core.cljs # Our main file
└─ deps.edn        # (macOS/Linux only) A file for listing our dependencies
```

## Usage

- Execute code
```shell
clj -M --main cljs.main --port 8080 --compile hello-world.core --repl
```

- Execute average funtion
```clj
cljs.user=> (hello-world.core/average 20 13)
```