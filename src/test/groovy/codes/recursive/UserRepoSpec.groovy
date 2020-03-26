package codes.recursive

import codes.recursive.model.User
import codes.recursive.repository.UserRepository
import io.micronaut.test.annotation.MicronautTest
import org.testcontainers.spock.Testcontainers

@MicronautTest
@Testcontainers
class UserRepoSpec extends AbstractSpec {

    def "Can create a user"() {

        when:
        UserRepository userRepository = context.getBean(UserRepository)
        def user = new User("Ribs", "Ribby", 14, "ribby@pattypan.com")
        userRepository.save(user)

        then:
        userRepository.findByFirstName("Ribs").size() > 0

    }

}