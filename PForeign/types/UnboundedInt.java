package PForeign.types;

public class UnboundedInt implements prt.values.PValue<UnboundedInt> {
    public UnboundedInt() { }
    
    @Override
    public UnboundedInt deepClone() {
        throw new RuntimeException("UnboundedInt#deepClone() not implemented yet!"); // TODO
    }
    
    @Override
    public boolean deepEquals(UnboundedInt other) {
        throw new RuntimeException("UnboundedInt#deepEquals() not implemented yet!"); // TODO
    }
    
    @Override
    public int hashCode() {
        throw new RuntimeException("UnboundedInt#hashCode() not implemented yet!"); // TODO
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnboundedInt that = (UnboundedInt) o;
        return deepEquals(that);
    }
}

