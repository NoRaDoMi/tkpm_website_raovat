package vn.hcmus.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hcmus.fit.entity.Role;

/**
 * Created by Asus on 6/21/2020.
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByRolename(String rolename);
}
