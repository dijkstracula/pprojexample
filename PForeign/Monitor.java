package PForeign;

import prt.exceptions.*;
import PGenerated.*;
import PGenerated.PMachines.Monitor.PrtStates;

public class Monitor {
    public static boolean foo(
        PMachines.Monitor machine,
        long i)
    throws /*RaiseEventException,*/ TransitionException  {
        machine.gotoState(PrtStates.S);
        return false; // TODO
    }

}

