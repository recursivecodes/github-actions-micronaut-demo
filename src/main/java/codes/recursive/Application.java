package codes.recursive;

import io.micronaut.core.annotation.TypeHint;
import io.micronaut.runtime.Micronaut;

@TypeHint(typeNames = {"oracle.jdbc.driver.OracleDriver"})
public class Application {
    public static void main(String[] args) {
        System.setProperty("oracle.jdbc.fanEnabled", "false");
        Micronaut
                .build(new String[]{})
                .mainClass(Application.class)
                .environmentPropertySource(false)
                .start();
    }
}