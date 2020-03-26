package codes.recursive.repository;

import codes.recursive.model.User;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@JdbcRepository(dialect = Dialect.ORACLE)
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByFirstName(String firstName);
}
