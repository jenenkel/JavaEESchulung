package jsf;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@ApplicationScoped
public class Warehouse {

    private Map<String, List<Clothing>> clothing;

    public Warehouse() {
        clothing = new TreeMap<>();
        clothing.put("Fußbedeckung", Arrays.asList(new Clothing("Sandalen"), new Clothing("Socken"), new Clothing("FlipFlops")));
        clothing.put("Hose", Arrays.asList(new Clothing("Shorts"), new Clothing("Bermudas") ));
        clothing.put("Oberteil", Arrays.asList(new Clothing("Sakko"), new Clothing("Hemd"), new Clothing("Polo")));
        clothing.put("Kopfbedeckung", Arrays.asList(new Clothing("Mütze"), new Clothing("Cap")));
    }

    public Map<String, List<Clothing>> getClothing() {
        return clothing;
    }

    public void setClothing(Map<String, List<Clothing>> clothing) {
        this.clothing = clothing;
    }
}
