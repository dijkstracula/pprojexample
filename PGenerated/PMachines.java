package PGenerated;

/***************************************************************************
 * This file was auto-generated on Thursday, 28 July 2022 at 12:45:24.  
 * Please do not edit manually!
 **************************************************************************/

import java.util.*;

import PForeign.types.UnboundedInt;

public class PMachines {
    public static class Monitor extends prt.Monitor {
        
        public static class Supplier implements java.util.function.Supplier<Monitor> {
            public Monitor get() {
                Monitor ret = new Monitor();
                ret.ready();
                return ret;
            }
        }
        
        private UnboundedInt n = null;
        public UnboundedInt get_n() { return this.n; };
        
        
        public enum PrtStates {
            S
        }
        
        public Monitor() {
            super();
            addState(prt.State.keyedOn(PrtStates.S)
                .isInitialState(true)
                .withEntry(this::Anon)
                .withEvent(PEvents.ev.class, this::Anon_1)
                .build());
        } // constructor
        
        public java.util.List<Class<? extends prt.events.PEvent<?>>> getEventTypes() {
            return java.util.Arrays.asList(PEvents.ev.class);
        }
        
        private void Anon() {
            UnboundedInt TMP_tmp0 = null;
            
            TMP_tmp0 = PForeign.P_TopScope.NewUnboundedInt(this);
            n = TMP_tmp0;
        }
        private void Anon_1(long i) {
            UnboundedInt TMP_tmp0_1 = null;
            long TMP_tmp1 = 0L;
            
            TMP_tmp0_1 = (UnboundedInt)prt.values.Clone.deepClone(n);
            TMP_tmp1 = i;
            PForeign.P_TopScope.BigIntAdd(this, TMP_tmp0_1, TMP_tmp1);
        }
        
    } // Monitor monitor definition
}
