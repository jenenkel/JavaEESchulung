package jsf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class ShopService implements Serializable {

    private Warehouse warehouse;
    private ClothingRepo clothingRepo;
    private CustomerRepo customerRepo;
    private Customer customer;

    @SuppressWarnings("unused")
    public ShopService() { }

    @Inject
    public ShopService(Warehouse warehouse, ClothingRepo clothingRepo, CustomerRepo customerRepo, Customer customer) {
        this.warehouse = warehouse;
        this.clothingRepo = clothingRepo;
        this.customerRepo = customerRepo;
        this.customer = customer;
    }

    public Map<String, List<Clothing>> getClothing() {
        return warehouse.getClothing();
    }

    public String checkout() {
        List<Clothing> selectedItems = getSelectedItemsInternal();
        selectedItems.forEach(it -> clothingRepo.persist(it));
        customerRepo.persist(customer);
        return "result";
    }

    public Customer getCustomer() {
        return customer;
    }

    private List<Clothing> getSelectedItemsInternal() {
        List<Clothing> result = new ArrayList<>();
        for (Map.Entry<String, List<Clothing>> entry : warehouse.getClothing().entrySet()) {
            List<Clothing> selectedItems = entry.getValue().stream()
                    .filter(Clothing::isSelected)
                    .collect(Collectors.toList());
            result.addAll(selectedItems);
        }
        return result;
    }

    public List<Clothing> getSelectedItems() {
        return clothingRepo.getAllSelected();
    }

    public Customer getCustomerFromDB() {
        return customerRepo.findById(customer.getId());
    }

    public double getSum() {
        return getSelectedItems().stream().mapToDouble(Clothing::getPrice).sum();
    }
}
