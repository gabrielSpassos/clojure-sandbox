# N Queen Problem

> The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.

Expected output

```
. Q . .
. . . Q 
Q . . .
. . Q . 
```

## Project Structure
```
queens-poc            # Our project folder
├─ src                # The CLJS source code for our project
│  └─ core.cljs       # Our main file
├─ test               # The CLJS test source code for our project
│  └─ core_test.cljs  # Our test main file
└─ deps.edn           # (macOS/Linux only) A file for listing our dependencies
```

## Usage

- Execute code
```shell
clj -M -m core
```

- Run tests
```shell
clj -X:test
```

- Run tests continuously whenever when we save the source code file. 
```shell
clj -X:test:watch
```

## References

- https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
