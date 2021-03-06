package codes.recursive;

import io.micronaut.context.ApplicationContext;
import io.micronaut.discovery.ServiceInstance;
import io.micronaut.discovery.event.ServiceStartedEvent;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.runtime.event.annotation.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.stream.Collectors;

@Controller("/hello")
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    private final ApplicationContext applicationContext;
    private ServiceInstance serviceInstance;

    public HelloController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @EventListener
    void onServiceStarted(ServiceStartedEvent event) {
        this.serviceInstance = event.getSource();
    }

    @Get("/")
    public HttpResponse index() {
        LOG.info("/hello invoked");
        return HttpResponse.ok(
                Map.of(
                        "foo", "bar",
                        "appEnv", applicationContext.getEnvironment().getActiveNames(),
                        "id", serviceInstance.getId(),
                        "region", serviceInstance.getRegion(),
                        "instanceId", serviceInstance.getInstanceId(),
                        "host", serviceInstance.getHost(),
                        "metadata", serviceInstance.getMetadata()
                                .asMap()
                                .entrySet()
                                .stream()
                                .filter( it -> !it.getKey().equals("ssh_authorized_keys"))
                                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                )
        );
    }
}