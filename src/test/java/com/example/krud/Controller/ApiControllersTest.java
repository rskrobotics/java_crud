package com.example.krud.Controller;
import com.example.krud.Models.User;
import com.example.krud.Repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class ApiControllersTest {

    @Mock
    private UserRepo userRepo;

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private ApiControllers apiControllers;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPage() {
        String result = apiControllers.getPage();
        assertThat(result).isEqualTo("WELCOME");
    }



    @Test
    public void createUser() {
        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setAge(30);
        user1.setOccupation("Engineer");
        ResponseEntity<?> responseEntity = apiControllers.createUser(user1, bindingResult);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo("User created successfully");
    }

//    @Test
//    public void testCreateUser() {
//        User user1 = new User();
//        user1.setFirstName("John");
//        user1.setLastName("Doe");
//        user1.setAge(30);
//        user1.setOccupation("Engineer");
//
//        User user2 = new User();
//        user2.setFirstName("Johnny");
//        user2.setLastName("Cage");
//        user2.setAge(35);
//        user2.setOccupation("Actor");
//
//        User user3 = new User();
//        user3.setFirstName("Sonya");
//        user3.setLastName("Cage");
//        user3.setAge(34);
//        user3.setOccupation("Actress");
//
//        User user4 = new User();
//        user4.setFirstName("Shao");
//        user4.setLastName("Kahn");
//        user4.setAge(99);
//        user4.setOccupation("Warlord");
//
//
//        List<User> userList = new ArrayList<>();
//        userList.add(user1);
//        userList.add(user2);
//        userList.add(user3);
//
//        userList.forEach(user ->{
//            apiControllers.createUser(user, bindingResult);
//        });
//
//        List<User> users = apiControllers.getUsers();
//        assertThat(users).hasSize(3);
//        assertThat(users).contains(user1);
//        assertThat(users).doesNotContain(user4);
//    }

}
