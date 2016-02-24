package s8.fr.esilv.td3.Contracts;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by juhel on 05/02/2016.
 */
public class Contracts extends ArrayList<Contract> {
    public Contracts(int capacity) {
        super(capacity);
    }

    public Contracts() {
    }

    public Contracts(Collection<? extends Contract> collection) {
        super(collection);
    }
}
