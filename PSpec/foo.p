type UnboundedInt;

event ev: int;


spec Monitor observes ev {
  var n : UnboundedInt;

  fun NewUnboundedInt(): UnboundedInt;
  fun BigIntAdd(n: UnboundedInt, i: int);

  start state S {
    entry {
      n = NewUnboundedInt();
    }

    on ev do (i: int) {
      BigIntAdd(n, i);
    }
  }
}
