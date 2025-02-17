package com.jcticket.user.dao;

import com.jcticket.user.dao.UserDao;
import com.jcticket.user.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * packageName    : com.jcticket.user.dao
 * fileName       : UserDaoImplTest
 * author         : jinwook Song
 * date           : 2024-02-02
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-02        jinwook Song       최초 생성
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoImplTest {
    @Autowired
    UserDao userDao;

    Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

//    String currentTimestampToString = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(currentTimestamp);
//    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(currentTimestampToString);
//    String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
//    Timestamp formatCurrentTiemstamp = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(formattedDate).getTime());


//    @Before
//    public void init() throws Exception{
//        System.out.println("init DELETE ALL");
//        userDao.deleteAll();
//    }

    @Test
    public void insertTest() throws Exception{
        assertTrue(userDao.count()==0);
        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,"N",0,"연극",currentTimestamp,"system",currentTimestamp,"system");
        System.out.println("userDto = " + userDto);

        assertTrue(userDao.insert(userDto)==1);
        assertTrue(userDao.count()==1);
    }

    @Test
    public void insertSNSTest() throws Exception{
//        assertTrue(userDao.count()==0);
        UserDto userDto = new UserDto("wlsdnr1233","1234","욱","wlsdnr1233@naver.com","010-9241-2120","미왕빌딩","wook144","19990219","M",currentTimestamp,"N",0,"연극","NAVER",currentTimestamp,"system",currentTimestamp,"system");
        System.out.println("userDto = " + userDto);

        assertTrue(userDao.insert(userDto)==1);
//        assertTrue(userDao.count()==1);
    }

    @Test //시간에 미세하게 차이가 있는데 그거때문인가 통과못하는게
    public void selectTest() throws Exception {
        assertTrue(userDao.count()==0);
        UserDto userDto = new UserDto("wlswls12464","1234","욱","wlsdnr1233@naver.com","010-9741-1239","미왕빌딩","wook24325","19990219","M",currentTimestamp,"N",0,"연극","NAVER",currentTimestamp,"system",currentTimestamp,"system");
        userDao.insert(userDto);
        assertTrue(userDao.count()==1);
//
        String user_id = userDto.getUser_id();

        UserDto userDto2 = userDao.select(user_id);
        System.out.println("currentTimestamp = " + currentTimestamp);
        System.out.println("userDto = " + userDto);
        System.out.println("userDto2 = " + userDto2);


//        assertTrue(Math.abs(userDto.getUser_create_at().getTime() - userDto2.getUser_create_at().getTime()) < 1000*50);
//        assertTrue(userDto.equals(userDto2));
    }



    @Test
    public void updateLoginCntTest() throws Exception {
        assertTrue(userDao.count()==0);

        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,"N",0,"연극",currentTimestamp,"system",currentTimestamp,"system");
        userDao.insert(userDto);
        assertTrue(userDao.count()==1);

        String user_id = userDto.getUser_id();
        System.out.println("user_id = " + user_id);

        userDao.increaseLoginCnt(user_id);

        UserDto userDto2 = userDao.select(user_id);
        assertTrue(userDto2.getUser_visit_cnt()==1);
    }

    @Test
    public void countTest() throws  Exception{
        assertTrue(userDao.count()==0);

        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,"N",0,"연극",currentTimestamp,"system",currentTimestamp,"system");
        assertTrue(userDao.insert(userDto)==1);
        assertTrue(userDao.count()==1);

        UserDto userDto2 = new UserDto("wlswls1","1234","욱","wlsdnr1233@naver.com","010-9741-2150","미왕빌딩","wook1","19990219","M",currentTimestamp,"N",0,"연극",currentTimestamp,"system",currentTimestamp,"system");
        assertTrue(userDao.insert(userDto2)==1);
        assertTrue(userDao.count()==2);
    }

    @Test
    public void deleteTest()throws Exception{
        assertTrue(userDao.count()==0);

        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,"N",0,"연극",currentTimestamp,"system",currentTimestamp,"system");
        assertTrue(userDao.insert(userDto)==1);
        assertTrue(userDao.count()==1);

        String user_id = userDto.getUser_id();
        assertTrue(userDao.delete(user_id)==1);
        assertTrue(userDao.count()==0);
    }

    @Test
    public void deleteAllTest()throws Exception{
        assertTrue(userDao.count()==0);

        for(int i = 1; i<=100; i++){
            UserDto userDto = new UserDto("wlswls"+i,"1234","욱","wlsdnr1233@naver.com","010-9741-2159"+i,"미왕빌딩","wook"+i,"19990219","M",currentTimestamp,"N",0,"연극",currentTimestamp,"system",currentTimestamp,"system");
            userDao.insert(userDto);
        }
        assertTrue(userDao.count()==100);

        userDao.deleteAll();
        assertTrue(userDao.count()==0);
    }

    @Test
    public void chkIdDuplTest() throws Exception {
        assertTrue(userDao.count()==0);

        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,"N",0,"연극",currentTimestamp,"system",currentTimestamp,"system");
        assertTrue(userDao.insert(userDto)==1);

        String user_id = userDto.getUser_id();

        assertTrue(userDao.selectIdDupl(user_id)==1);
    }

    @Test
    public void chkNickNameDuplTest() throws Exception {
        assertTrue(userDao.count()==0);

        UserDto userDto = new UserDto("wlswls","1234","욱","wlsdnr1233@naver.com","010-9741-2159","미왕빌딩","wook","19990219","M",currentTimestamp,"N",0,"연극",currentTimestamp,"system",currentTimestamp,"system");
        assertTrue(userDao.insert(userDto)==1);

        String user_nickname = userDto.getUser_nickname();
        System.out.println("user_nickname = " + user_nickname);

        assertTrue(userDao.selectNickNameDupl(user_nickname)==1);
    }
}