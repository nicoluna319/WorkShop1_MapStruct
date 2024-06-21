package com.biblio.biblio.Domain.Repository;

import com.biblio.biblio.Domain.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
