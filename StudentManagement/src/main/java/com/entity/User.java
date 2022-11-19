package com.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

   @Id
   @Column(name = "user_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   /*@Column(name="rolls")
   private String rolls;*/
   @Column(name="username")
   private String username;
   @Column(name="password")
   private String password;
   
   /*public String getRoles() {
	   return rolls;
   }
      
   public void setRoles(String rolls) {
	   this.rolls = rolls;
   }
   */
   
   public String getUsername() {
   	return username;
   }
   
   public void setUsername(String username) {
   	this.username = username;
   }
   
   public String getPassword() {
   	return password;
   }
   
   public void setPassword(String password) {
   	this.password = password;
   }
   
   @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinTable(
           name = "users_roles",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id")
           )
   @Column(name="roles") /*Lines added by me */
   private List<Role> roles = new ArrayList<>();
   
   public List getRoles() {
	   return roles;
   }
   
   public void setRoles(List roles) {
	   this.roles = roles;
   }

   


}
