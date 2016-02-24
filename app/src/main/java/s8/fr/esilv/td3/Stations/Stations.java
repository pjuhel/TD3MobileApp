package s8.fr.esilv.td3.Stations;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by juhel on 05/02/2016.
 */
public class Stations extends ArrayList<Station> {
    public Stations(int capacity) {
        super(capacity);
    }

    public Stations() {
    }

    public Stations(Collection<? extends Station> collection) {
        super(collection);
    }
}
