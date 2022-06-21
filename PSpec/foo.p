event eIncr;

// A global foreign type
type Counter;

spec myMonitor observes eIncr {

  // Machine-local foreign functions that operate on a foreign type
  fun NewCounter(): Counter;
  fun GetNextCount(counter: Counter): int;

  var i : int;
  var c : Counter;

  start state Init {
    entry {
      i = 0;
      c = NewCounter();
    }

    on eIncr do {
      i = i + 1;
      assert i == GetNextCount(c), "uh oh";
    }
  }
}
