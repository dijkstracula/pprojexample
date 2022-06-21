package PGenerated;

/***************************************************************************
 * This file was auto-generated on Tuesday, 21 June 2022 at 11:39:40.  
 * Please do not edit manually!
 **************************************************************************/

import events.PObserveEvent;
import prt.Monitor;
import prt.State;
import prt.Values;

import PForeign.globals.Counter;

// Ensure that Counter.class is on your classpath

public class pprojtest {
    /* Events */
    public static class DefaultEvent extends PObserveEvent.PEvent<Void> {
        public DefaultEvent() { }
        private Void payload; 
        public Void getPayload() { return payload; }
        
        @Override
        public String toString() {
            return "DefaultEvent";
        } // toString()
        
    } // PEvent definition for DefaultEvent
    public static class PHalt extends PObserveEvent.PEvent<Void> {
        public PHalt() { }
        private Void payload; 
        public Void getPayload() { return payload; }
        
        @Override
        public String toString() {
            return "PHalt";
        } // toString()
        
    } // PEvent definition for PHalt
    public static class eIncr extends PObserveEvent.PEvent<Void> {
        public eIncr() { }
        private Void payload; 
        public Void getPayload() { return payload; }
        
        @Override
        public String toString() {
            return "eIncr";
        } // toString()
        
    } // PEvent definition for eIncr
    
    public static class myMonitor extends Monitor {
        private int i = 0;
        public int get_i() { return this.i; };
        
        private Counter c = null;
        public Counter get_c() { return this.c; };
        
        
        public String INIT_STATE = "Init";
        
        // Ensure foreign function NewCounter is on the classpath
        // Ensure foreign function GetNextCount is on the classpath
        private void Anon() {
            Counter TMP_tmp0 = null;
            
            i = 0;
            TMP_tmp0 = PForeign.myMonitor.NewCounter();
            c = TMP_tmp0;
        }
        private void Anon_1() {
            int TMP_tmp0_1 = 0;
            Counter TMP_tmp1 = null;
            int TMP_tmp2 = 0;
            boolean TMP_tmp3 = false;
            String TMP_tmp4 = "";
            
            TMP_tmp0_1 = i + 1;
            i = TMP_tmp0_1;
            TMP_tmp1 = (Counter)Values.deepClone(c);
            TMP_tmp2 = PForeign.myMonitor.GetNextCount(TMP_tmp1);
            TMP_tmp3 = i == TMP_tmp2;
            TMP_tmp4 = "uh oh";
            tryAssert(TMP_tmp3, TMP_tmp4);
        }
        
        public myMonitor() {
            super();
            addState(new State.Builder(INIT_STATE)
                .isInitialState(true)
                .withEntry(this::Anon)
                .withEvent(eIncr.class, __ -> Anon_1())
                .build());
        } // constructor
    } // myMonitor monitor definition
} // pprojtest.java class definition
