package com.jcticket.viewdetail.dao;


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
    List<ShowingDto> test(String dateText) throws Exception;
}
