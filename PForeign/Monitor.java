package PForeign;

import PForeign.globals.UnboundedInt;

public class Monitor {
    public static UnboundedInt NewUnboundedInt() {
        return new UnboundedInt();
    }

    public static void BigIntAdd(
            UnboundedInt n,
            long i
    ) {
        n.add(i);
    }

}
