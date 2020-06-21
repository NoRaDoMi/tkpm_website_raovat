package vn.hcmus.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hcmus.fit.entity.User;

/**
 * Created by Asus on 6/21/2020.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
