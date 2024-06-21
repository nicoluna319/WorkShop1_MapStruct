package riwi.Biblioteca.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import riwi.Biblioteca.Domain.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
