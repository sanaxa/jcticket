package com.jcticket.ticketing.service;

import com.jcticket.ticketing.dto.TicketingDto;
import com.jcticket.viewdetail.dto.ShowingDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.ticketing.service
 * fileName       : TicketService
 * author         : 조영상
 * date           : 1/31/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 1/31/24         조영상        최초 생성
 */
public interface TicketingService {

    // 서비스에서 어떤 (DAO처럼 단순 쿼리와는 다른) 작업을 구현하고 데이터 가공을 어떻게 할지에 대한 고민이 생각보단 복잡함..
    // Step1. 일정선택

    // 공연명, 공연포스터, 공연일자, 공연장명을 공연아이디를 가지고 받아온다.
    Map<String,Object> getPlayInfo(String play_id) throws Exception;

    // 공연아이디와 공연일자를 가지고 회차 정보 & 회차 시퀀스를 가져온다.
    List<String> getRoundList(String play_id, String date_text) throws Exception;
    // next step
    // 좌석선택하는 로직
}
