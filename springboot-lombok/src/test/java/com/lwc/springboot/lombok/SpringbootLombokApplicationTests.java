package com.lwc.springboot.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringbootLombokApplicationTests {

    /**
     * User
     */
    @Test
    void testAnnoData(){
        User user = new User();
        user.setId("1");
        user.setName("lwc");
        Assertions.assertEquals("User(id=1, name=lwc)", user.toString());
        User user2 = new User();
        user2.setId("111111");
        user2.setName("lwc");

        User user3 = new User();
        user3.setId("1");
        user3.setName("lwc");

        Assertions.assertFalse(user.equals(user2));
        Assertions.assertTrue(user.equals(user3));
        Assertions.assertFalse(user2.equals(user3));
    }

    /**
     * UserExtend1
     */
    @Test
    void testExtend1(){
        UserExtend1 userExtend = new UserExtend1();
        userExtend.setId("1");
        userExtend.setName("lwc");
        userExtend.setOther("other");
        System.out.println(userExtend.toString());
        UserExtend1 userExtend1 = new UserExtend1();
        userExtend1.setId("1");
        userExtend1.setName("lwc");
        userExtend1.setOther("other1");
        Assertions.assertFalse(userExtend.equals(userExtend1));

        UserExtend1 userExtend2 = new UserExtend1();
        userExtend2.setId("1");
        userExtend2.setName("lc");
        userExtend2.setOther("other");

        Assertions.assertTrue(userExtend.equals(userExtend2));

    }

    /**
     * UserExtend2
     */
    @Test
    void testExtend(){
        UserExtend userExtend = new UserExtend();
        userExtend.setId("1");
        userExtend.setName("lwc");
        userExtend.setOther("other");

        UserExtend userExtend1 = new UserExtend();
        userExtend1.setId("1");
        userExtend1.setName("lwc");
        userExtend1.setOther("other1");
        Assertions.assertFalse(userExtend.equals(userExtend1));


        UserExtend userExtend2 = new UserExtend();
        userExtend2.setId("1");
        userExtend2.setName("lc");
        userExtend2.setOther("other");

        Assertions.assertFalse(userExtend.equals(userExtend2));

    }

    /**
     * UserExtend2
     */
    @Test
    void testExtend2(){
        UserExtend2 userExtend2 = new UserExtend2();
        userExtend2.setId("1");
        userExtend2.setName("lwc");
        userExtend2.setOther("other");
        Assertions.assertNotEquals("User(id=1, name=lwc, other=other)", userExtend2.toString());
        Assertions.assertEquals("User(id=1, name=lwc)", userExtend2.toString());

        UserExtend2 userExtend2_2 = new UserExtend2();
        userExtend2_2.setId("1");
        userExtend2_2.setName("lwc");
        userExtend2_2.setOther("other2");

        Assertions.assertTrue(userExtend2.equals(userExtend2_2));

    }





}
