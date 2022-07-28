package PForeign;

import PForeign.types.UnboundedInt;

public class P_TopScope {

    public static UnboundedInt NewUnboundedInt(
        prt.Monitor<? extends Enum<?>> machine) {
        return null; // TODO
    }
    
    public static void BigIntAdd(
        prt.Monitor machine,
        UnboundedInt n,
        long i
    ) {
        machine.tryAssert(1 == 2, "uh oh");
    }
    
}
