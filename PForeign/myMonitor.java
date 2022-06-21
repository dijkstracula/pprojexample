package PForeign;

import PForeign.globals.Counter;

public class myMonitor {
    public static Counter NewCounter() {
        return new Counter();
    }

    public static int GetNextCount(Counter c) {
        c.i += 1;
        return c.i;
    }
}
