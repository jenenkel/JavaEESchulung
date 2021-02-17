package jsf;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.time.LocalDateTime;

@Named
@ApplicationScoped
public class FredsBeanAppScope {

    LocalDateTime now = LocalDateTime.now();

    public LocalDateTime getJetzt() {
        return now;
    }
}
