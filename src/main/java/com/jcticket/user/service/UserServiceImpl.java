package com.jcticket.user.service;

import com.jcticket.user.dao.UserDao;
import com.jcticket.user.dto.UserDto;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * packageName    : com.jcticket.login.service
 * fileName       : LoginServiceImpl
 * author         : jinwook Song
 * date           : 2024-02-01
 * description    : LoginService 구현클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-01        jinwook Song       최초 생성
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    //user_id에 맞는 유저 정보 가져옴
    @Override
    public UserDto getUser(String user_id)throws Exception{
        return userDao.select(user_id);
    }

    @Override
    public int increaseLoginCnt(String user_id) throws Exception {
        // user가 로그인 할때마다 1씩 증가. 방문횟수
        return userDao.increaseLoginCnt(user_id);
    }

    @Override
    public int signup(UserDto userDto) throws Exception {
        return userDao.insert(userDto);
    }

    @Override
    public int chkIdDupl(String user_id) throws Exception {
        return userDao.selectIdDupl(user_id);
    }

    @Override
    public int chkNickNameDupl(String user_nickname) throws Exception {
        return userDao.selectNickNameDupl(user_nickname);
    }

    @Override
    public boolean loginCheck(String user_id, String user_password) throws Exception {
        UserDto userDto = userDao.select(user_id);
        System.out.println(userDto);
        System.out.println("userDto.getUser_password() = " + userDto.getUser_password());
        System.out.println("user_password = " + user_password);


        if(BCrypt.checkpw(user_password,userDto.getUser_password())) {
            System.out.println("비밀번호가 일치합니다");
            return true;
        }
        System.out.println("비밀번호가 일치하지 않습니다.");
        return false;
    }

    @Override
    public boolean isUserRetired(String user_id) throws Exception {
        UserDto userDto = userDao.select(user_id);
        String retireYN = userDto.getUser_retire_yn();
        if (retireYN.equals("Y")){
            return true;
        }
        return false;
    }

    @Override
    public int deleteAll() throws Exception {
        return userDao.deleteAll();
    }

    @Override
    public int count() throws Exception {
        return userDao.count();
    }
}
