package codes.recursive;

import io.micronaut.context.ApplicationContext;
import io.micronaut.discovery.ServiceInstance;
import io.micronaut.discovery.event.ServiceStartedEvent;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.runtime.event.annotation.EventListener;

import java.util.Map;

@Controller("/hello")
public class HelloController {

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
        return HttpResponse.ok(
                Map.of(

                            "todd", "sharp",
                        "foo", "bar",
                        "appEnv", applicationContext.getEnvironment().getActiveNames(),
                        "id", serviceInstance.getId(),
                        "region", serviceInstance.getRegion(),
                        "instanceId", serviceInstance.getInstanceId(),
                        "host", serviceInstance.getHost()
                )
        );
    }
}