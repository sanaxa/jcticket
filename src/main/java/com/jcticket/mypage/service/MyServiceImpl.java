package com.jcticket.mypage.service;

import com.jcticket.mypage.dao.mypageDAO;
import com.jcticket.ticketing.dto.TicketingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.mypage.service
 * fileName       : MyServiceImpl
 * author         : JJS
 * date           : 2024-02-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-10        JJS       최초 생성
 */



@Service
public class MyServiceImpl implements mypageService {

    @Autowired
    mypageDAO mypageDAO;

    @Override
    public Integer count(Map map) throws Exception {
        return mypageDAO.count(map);
    }

    @Override
    public Integer view_count(Map map) throws Exception {
        return mypageDAO.view_count(map);
    }

    @Override
    public List<TicketingDto> selectAll(Map map) throws Exception {
        return mypageDAO.selectAll(map);
    }

    @Override
    public List<TicketingDto> select_list() throws Exception {
        return mypageDAO.select_list();
    }

    @Override
    public List<TicketingDto> selectLimit(Map map) throws Exception {
        return mypageDAO.selectLimit(map);
    }
    @Override
    public List<TicketingDto> select_view(Map map) throws Exception {
        return mypageDAO.select_view(map);
    }



}
