package jsf;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;

@Named
@SessionScoped
public class FredsBeanSession implements Serializable {
    LocalDateTime now = LocalDateTime.now();

    public LocalDateTime getJetzt() {
        return now;
    }
}
