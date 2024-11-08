package com.vazquez.capstone.userservice.model;

import jakarta.persistence.*; 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Table(name = "users") 
public class User {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 

    @Column(nullable = false, unique = true) 
    private String username;

    @Column(nullable = false) 
    private String password;

    @Column 
    private String bio;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at") 
    private LocalDateTime updatedAt;


    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }





    public void updateUser(String password, String bio) {
        if (password != null) {
            this.password = password;
        }
        if (bio != null) {
            this.bio = bio;
        }
        this.updatedAt = LocalDateTime.now(); 
    }

   
    // encryption pending 
    public void encryptPassword() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", bio='" + bio + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
