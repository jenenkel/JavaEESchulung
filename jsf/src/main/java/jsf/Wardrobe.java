package jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.*;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class Wardrobe {

    private Map<String, List<Clothing>> clothing;

    public Wardrobe() {
        clothing = new TreeMap<>();
        clothing.put("Fußbedeckung", Arrays.asList(new Clothing("Sandalen"), new Clothing("Socken"), new Clothing("FlipFlops")));
        clothing.put("Hose", Arrays.asList(new Clothing("Shorts"), new Clothing("Bermudas") ));
        clothing.put("Oberteil", Arrays.asList(new Clothing("Sakko"), new Clothing("Hemd"), new Clothing("Polo")));
        clothing.put("Kopfbedeckung", Arrays.asList(new Clothing("Mütze"), new Clothing("Cap")));
    }

    public Map<String, List<Clothing>> getClothing() {
        return clothing;
    }

    public List<String> getSelectedItems() {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<Clothing>> entry : clothing.entrySet()) {
            List<String> selectedItems = entry.getValue().stream()
                    .filter(Clothing::getSelected)
                    .map(Clothing::getName)
                    .collect(Collectors.toList());
            result.addAll(selectedItems);
        }

        return result;
    }

}
