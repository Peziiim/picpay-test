package repositories;

import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository  extends JpaRepository<User, Long>{
   Optional<User> finduserByDocument(String CPF);

   Optional<User> finduserById(Long id);
}
