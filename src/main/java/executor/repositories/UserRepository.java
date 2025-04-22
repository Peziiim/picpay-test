package executor.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import executor.domain.user.User;

public interface UserRepository  extends JpaRepository<User, Long>{
   Optional<User> findUserByCPF(String CPF);

   Optional<User> findUserById(Long id);
}
