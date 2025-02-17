package com.jcticket.viewdetail.service;

import com.jcticket.viewdetail.dto.JoinDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName    : com.jcticket.viewdetail.service
 * fileName       : ViewDetailService
 * author         : sungjun
 * date           : 2024-02-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-06        kyd54       최초 생성
 */

public interface ViewDetailService {
    List<ShowingDto> getShowingInfo(String dateText) throws Exception;

    int getRemainSeat(String showing_seq) throws Exception;

    List<JoinDto> getViewDetail(String play_id) throws Exception;

    List<ShowingDto> getViewDetailTime(String play_id) throws Exception;
}
