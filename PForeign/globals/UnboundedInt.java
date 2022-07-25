package PForeign.globals;

import java.math.BigInteger;
import java.util.Objects;

// It would have been cool if we could have just used BigInteger directly
// except BigInteger doesn't implement PValue<BigInteger> so comparison
// stuff will go awry.
public class UnboundedInt implements prt.values.PValue<UnboundedInt> {
    private BigInteger n;

    public UnboundedInt() {
        n = BigInteger.ZERO;
    }

    public UnboundedInt deepClone() {
        UnboundedInt i = new UnboundedInt();
        i.n = n;
        return i;
    }

    public boolean deepEquals(UnboundedInt other) {
        return this.n.equals(other.n);
    }

    public void add(long i) {
        n = n.add(BigInteger.valueOf(i));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnboundedInt that = (UnboundedInt) o;
        return deepEquals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }
}

