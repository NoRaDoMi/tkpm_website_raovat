package vn.hcmus.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.hcmus.fit.entity.Role;
import vn.hcmus.fit.entity.User;
import vn.hcmus.fit.repository.RoleRepository;
import vn.hcmus.fit.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    RoleRepository roleRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    public void run(String... args) throws Exception {
//        userRepository.deleteAllInBatch();
//        roleRepository.deleteAllInBatch();
//
//        Role role_admin = new Role();
//        role_admin.setRolename("ROLE_ADMIN");
//        roleRepository.save(role_admin);
//
//        Role role_mem = new Role();
//        role_mem.setRolename("ROLE_MEMBER");
//        roleRepository.save(role_mem);
//
//        // Admin account
//        Set<Role> roles = new HashSet<>();
//        roles.add(role_mem);
//        roles.add(role_admin);
//        User admin = new User();
//        admin.setEmail("admin@gmail.com");
//        admin.setPassword(passwordEncoder.encode("123456"));
//        admin.setRoles(roles);
//        userRepository.save(admin);
//
//
//        User user = new User();
//        user.setEmail("member@gmail.com");
//        user.setPassword(passwordEncoder.encode("123456"));
////        role_mem = roleRepository.findByRolename("ROLE_MEMBER");
//        user.getRoles().add(role_mem);
//        userRepository.save(user);
//
//    }
}
