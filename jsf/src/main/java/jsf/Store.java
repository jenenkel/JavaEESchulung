package jsf;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class Store implements Serializable {

    private Map<String, List<Clothing>> clothing;
    private double sum;

    public Store() {
        clothing = new TreeMap<>();
        clothing.put("Fußbedeckung", Arrays.asList(new Clothing("Sandalen"), new Clothing("Socken"), new Clothing("FlipFlops")));
        clothing.put("Hose", Arrays.asList(new Clothing("Shorts"), new Clothing("Bermudas") ));
        clothing.put("Oberteil", Arrays.asList(new Clothing("Sakko"), new Clothing("Hemd"), new Clothing("Polo")));
        clothing.put("Kopfbedeckung", Arrays.asList(new Clothing("Mütze"), new Clothing("Cap")));
    }

    public Map<String, List<Clothing>> getClothing() {
        return clothing;
    }

    public List<Clothing> getSelectedItems() {
        List<Clothing> result = new ArrayList<>();
        for (Map.Entry<String, List<Clothing>> entry : clothing.entrySet()) {
            List<Clothing> selectedItems = entry.getValue().stream()
                    .filter(Clothing::getSelected)
                    .collect(Collectors.toList());
            result.addAll(selectedItems);
        }
        sum = result.stream().mapToDouble(Clothing::getPrice).sum();
        return result;
    }

    public double getSum() {
        return sum;
    }
}
