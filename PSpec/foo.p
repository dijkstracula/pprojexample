type UnboundedInt;

event ev: int;

fun NewUnboundedInt(): UnboundedInt;
fun BigIntAdd(n: UnboundedInt, i: int);

spec Monitor observes ev {
  var n : UnboundedInt;

  fun foo(i: int): bool;

  start state S {
    entry {
      n = NewUnboundedInt();
    }

    on ev do (i: int) {
      BigIntAdd(n, i);
    }
  }
}
