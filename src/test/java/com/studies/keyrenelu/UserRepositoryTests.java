package com.studies.keyrenelu;

import com.studies.keyrenelu.bean.User;
import com.studies.keyrenelu.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void test()throws Exception{
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("刘强大", "ppm123456", "ppm@126.com", "LQD" ,formattedDate));

//        User user = userRepository.findUserByUserName("刘强大");
//        System.out.printf(user.toString());
    }
}
