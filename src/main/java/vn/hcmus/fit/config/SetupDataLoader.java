package vn.hcmus.fit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import vn.hcmus.fit.entity.Role;
import vn.hcmus.fit.entity.User;
import vn.hcmus.fit.repository.RoleRepository;
import vn.hcmus.fit.repository.UserRepository;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Asus on 6/21/2020.
 */
@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        System.out.println("Buoc 1");
//        if (alreadySetup)
//            return;

        userRepository.deleteAllInBatch();
        roleRepository.deleteAllInBatch();

        Role adminRole =  createRoleIfNotFound("ROLE_ADMIN");
        Role userRole = createRoleIfNotFound("ROLE_USER");

        createUserIfNotFound("loda","admin","loda",new HashSet<>(Arrays.asList(adminRole,userRole)));
        createUserIfNotFound("user","user","user",new HashSet<>(Collections.singleton(userRole)));


//        alreadySetup = true;
//        System.out.println("Buoc 3");
    }

    @Transactional
    protected Role createRoleIfNotFound(
            String name) {

        Role role = roleRepository.findByRolename(name);
        if (role == null) {

            role = new Role();
            role.setRolename(name);
            roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    protected User createUserIfNotFound(final String email, final String name, final String password, final Set<Role> roles) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            
            user = new User();
            user.setFullname(name);
            user.setPassword(passwordEncoder.encode(password));
            user.setEmail(email);
            user.setRoles(roles);
            user = userRepository.save(user);
            return user;
        }
        return null;
    }
}
