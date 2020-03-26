package codes.recursive;

import codes.recursive.model.User;
import codes.recursive.repository.UserRepository;
import io.micronaut.discovery.event.ServiceStartedEvent;
import io.micronaut.runtime.event.annotation.EventListener;

import javax.inject.Singleton;

@Singleton
public class Bootstrap {

    private final UserRepository userRepository;

    public Bootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener
    public void onServiceStartup(ServiceStartedEvent event) {
        System.out.println("service started!");
    }
}
