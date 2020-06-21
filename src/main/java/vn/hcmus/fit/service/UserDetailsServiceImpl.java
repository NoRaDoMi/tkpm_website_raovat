package vn.hcmus.fit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.hcmus.fit.entity.Role;
import vn.hcmus.fit.entity.User;
import vn.hcmus.fit.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Asus on 6/21/2020.
 * Class này giúp Sping Security xác thực người dùng bằng username và sẽ trả về 1 User (UserDetails)
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);

//        if (user == null) {
//            System.out.println("Bad Credentional");
//            throw new UsernameNotFoundException(email);
//        }
//        System.out.println("Toi day 1, "+user.getEmail());
//
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        Set<Role> roles = user.getRoles();
//        for (Role role : roles) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRolename())); // phải đặt tên là ROLE_***
//        }
////        Trả về 1 đối tượng User là 1 implementation của UserDetails tương tự như 1 session
//        System.out.println("Toi day 2,");
//        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),grantedAuthorities);
        if (user == null) {
            System.out.println("Bad Credentionals");
            throw new UsernameNotFoundException("Khong tim thay");
        }
        System.out.println(user.getEmail());
        return new MyUserDetails(user);
    }
}
