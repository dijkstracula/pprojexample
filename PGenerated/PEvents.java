package PGenerated;

/***************************************************************************
 * This file was auto-generated on Tuesday, 26 July 2022 at 09:30:30.  
 * Please do not edit manually!
 **************************************************************************/

import java.util.*;

public class PEvents {
    public static class ev extends prt.events.PEvent<Long> {
        public ev(long p) { this.payload = p; }
        private long payload; 
        public Long getPayload() { return payload; }
        
        @Override
        public String toString() { return "ev[" + payload + "]"; }
    } // ev
    
}
