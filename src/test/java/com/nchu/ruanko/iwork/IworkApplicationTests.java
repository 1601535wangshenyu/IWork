package com.nchu.ruanko.iwork;

import com.nchu.ruanko.iwork.dao.PositionDao;
import com.nchu.ruanko.iwork.dao.UserDao;
import com.nchu.ruanko.iwork.utils.string.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IworkApplicationTests {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PositionDao positionDao;



    @Test
    void contextLoads() {

        System.out.println(positionDao.getPositionByPositionUid("29"));
    }

}
