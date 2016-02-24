package s8.fr.esilv.td3.Contracts;

import java.util.ArrayList;

/**
 * Created by juhel on 29/01/2016.
 */
public class Contract {

    private String name;
    private String commercial_name;


    public Contract(String _name, String _commercial_name){
        this.name = _name;
        this.commercial_name = _commercial_name;
    }

    public String getName() {
        return name;
    }

    public String getCommercial_name() {
        return commercial_name;
    }
}
