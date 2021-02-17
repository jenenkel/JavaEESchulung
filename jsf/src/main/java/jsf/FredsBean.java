package jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.time.LocalDateTime;

@Named
@RequestScoped
public class FredsBean {
    public LocalDateTime getJetzt() {
        return LocalDateTime.now();
    }
}
