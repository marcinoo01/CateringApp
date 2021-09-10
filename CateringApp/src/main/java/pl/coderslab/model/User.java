package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@ToString
@Setter
@Table(name = "users")
public class User implements UserDetails {
    public User(Long id, String username, String password, String email, LocalDate createdOn, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdOn = createdOn;
        this.role = role;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 60, message = "Username must be between 3 and 60 chars")
    private String username;

    @Size(min = 4, max = 60, message = "Password must be between 4 and 60 chars.")
    private String password;

    @NotBlank
    @Size(min = 5, max = 150)
    private String email;

    @Column(name = "created_on")
    private LocalDate createdOn;

    private String role;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDate.now();
    }

    public static class Builder {
        private String username;
        private String password;
        private String email;
        private String role;

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder role(String val) {
            role = val;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    private User(Builder builder) {
        username = builder.username;
        password = builder.password;
        email = builder.email;
        role = builder.role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
