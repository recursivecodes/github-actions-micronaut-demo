package codes.recursive

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class HelloControllerSpec extends AbstractSpec {

    @Inject
    @Client("/")
    RxHttpClient client

    void "hello controller works"() {
        when: "connecting to /hello"
        Map response = client.toBlocking().retrieve(HttpRequest.GET("/hello"), Map.class);
        then: "foo == bar"
        response.get("foo") == "bar"
    }
}