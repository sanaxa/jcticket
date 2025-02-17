package com.jcticket.admin.service;

import com.jcticket.admin.dto.*;
import com.jcticket.agency.dto.AgencyDto;
import com.jcticket.user.dto.UserDto;
import com.jcticket.viewdetail.dto.ShowingDto;
import com.jcticket.admin.dto.PlayDto;
import com.jcticket.viewdetail.dto.ShowingDto;

import java.util.List;
import java.util.Map;

/**
 * packageName :  com.jcticket.admin.service
 * fileName : AdminService
 * author :  jisoo Son
 * date : 2024-02-05
 * description : 관리자 Service
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
public interface AdminService {
    AdminDto adminLogin(Map<String, Object> map) throws Exception;
    List<UserDto> userstatics() throws Exception;
    // 총 회원수 조회
    int usercnt(String option, String keyword) throws Exception;
    // 회원 페이징 리스트 조회
    List<UserDto> userPaingList(int page, String option, String keyword) throws Exception;
    // 현재페이지, 전체, 시작, 끝, 검색값 전달 PageDto 전달
    PageDto userPagingParam(int page, String option, String keyword) throws Exception;
    // 유저 회원가입
    int userInsert(UserDto userDto) throws Exception;
    // 회원 탈퇴
    int userDelete(String user_id) throws Exception;
    // 기획사 등록
    int insertAgency(AgencyDto agencyDto) throws Exception;
    // 기획사 테이블 총 개수 조회
    int agencyCnt(String option, String keyword) throws Exception;
    // 기획사 페이징 리스트 조회
    List<AgencyDto> agencyPaingList(int page, String option, String keyword) throws Exception;
    // 현재페이지, 전체, 시작, 끝, 검색값 전달 PageDto 전달
    PageDto agencyPagingParam(int page, String option, String keyword) throws Exception;
    // 공지사항 삭제
    int noticeDelete(int notice_seq) throws Exception;
    // 관리자 전체 삭제
    void adminAllDelete() throws Exception;
    // 관리자 수정폼 중복 아이디 체크
    int dupleAdminId(String admin_id) throws Exception;
    // 관리자 정보 수정
    int updateAdminInfo(AdminDto adminDto) throws Exception;
    // 관리자 정보 리스트 조회
    AdminDto showAdminInfo(String admin_id) throws Exception;
    // 관리자 쿠폰 등록
    int insertCoupon(CouponDto couponDto) throws Exception;
    // 관리자 전체 쿠폰 리스트 조회
    List<CouponDto> selectAllCoupon() throws Exception;
    // 관리자 쿠폰 전체 카운트
    int countAllCoupon() throws Exception;
    // 관리자 쿠폰 옵션,keyword 카운트 조회
    int countOptionCoupon(Map<String, Object> map) throws Exception;
    // 관리자 쿠폰 옵션,keyword,date 리스트 조회
    List<CouponDto> selectAllOptionCoupon(int page, String option, String keyword, String start_at, String end_at) throws Exception;
    // 현재페이지, 전체, 시작, 끝, 검색값 전달 PageDto 전달
    PageDto couponPagingParam(int page, String option, String keyword, String start_at, String end_at) throws Exception;
    // 관리자 쿠폰 삭제
    void deleteCoupon(String coupon_id) throws Exception;
    // 상품 관리 팝업창 공연장명 검색 조회
    List<StageDto> selectKeywordStage(String keyword) throws Exception;
    // 상품 관리 팝업창 공연명 검색 조회
    List<PlayDto> selectKeywordPlay(String keyword) throws Exception;
    // 관리자 상품 관리 회차 등록
    int insertShowing(ShowingDto showingDto) throws Exception;
    // 관리자 상품 관리 회차 전체 삭제
    void deleteAllShoiwing() throws Exception;
    // 관리자 상품 관리 공연 좌석 등록
    int insertShowSeat(ShowSeatDto showSeatDto) throws Exception;
    // 관리자 상품 관리 공연, 공연 이미지 등록
    void insertPlay(PlayDto playDto) throws Exception;
}