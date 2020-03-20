# github-actions-micronaut-demo

## Create App

```bash
mn create-app codes.recursive.github-actions-micronaut-demo
```

## Create Controller 

```bash
mn create-controller HelloController 
```

## Create Test

```java
package codes.recursive;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.net.InetAddress;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class HelloControllerTest {

    @Inject
    EmbeddedServer embeddedServer;

    @Test
    public void testIndex() throws Exception {
        InetAddress host = InetAddress.getLocalHost();

        try(RxHttpClient client = embeddedServer.getApplicationContext().createBean(RxHttpClient.class, embeddedServer.getURL())) {
            Map response = client.toBlocking().retrieve(HttpRequest.GET("/hello"), Map.class);
            assertEquals(response.get("foo"), "bar");
        }
    }

}

```

![micronaut-ci-demo](https://github.com/recursivecodes/github-actions-micronaut-demo/workflows/micronaut-ci-demo/badge.svg)
