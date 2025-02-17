package com.jcticket.viewdetail.dao;


import com.jcticket.admin.dto.PlayDto;
import com.jcticket.viewdetail.dto.JoinDto;
import com.jcticket.viewdetail.dto.SeatClassDto;
import com.jcticket.viewdetail.dto.ShowingDto;

import java.util.List;

/**
 * packageName    : com.jcticket.viewdetail.dao
 * fileName       : ViewDetailDao
 * author         : sungjun
 * date           : 2024-02-05
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-05        kyd54       최초 생성
 */
public interface ViewDetailDao {
    int play_insert(PlayDto playDto) throws Exception;

    int showing_insert(ShowingDto showingDto) throws Exception;

    int seat_class_insert(SeatClassDto seatClassDto) throws Exception;

    int play_delete_all() throws Exception;

    int showing_delete_all() throws Exception;

    int seat_class_delete_all() throws Exception;

//    테스트용 delete
    int test_delete_play() throws Exception;
    int test_delete_showing() throws Exception;
    int test_delete_seat_class() throws Exception;

    List<ShowingDto> select_showing_info(String dateText) throws Exception;

    int remain_seat(String showing_seq) throws Exception;

    List<JoinDto> viewDetail_view(String play_id) throws Exception;

    List<ShowingDto> viewDetail_view_time(String play_id) throws Exception;
}