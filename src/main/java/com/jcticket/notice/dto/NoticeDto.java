package com.jcticket.notice.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName :  com.jcticket.notice.dto
 * fileName : NoticeDto
 * author :  jisoo Son
 * date : 2024-01-31
 * description : 공지사항 Dto
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-31             jisoo Son             최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class NoticeDto {
    /*    CREATE TABLE `notice` (
        `notice_seq` int NOT NULL AUTO_INCREMENT,
        `notice_title` varchar(50) NOT NULL,
        `notice_content` varchar(500) NOT NULL,
        `notice_view_cnt` int DEFAULT '0',
        `notice_reg_at` timestamp NOT NULL,
        `notice_use_yn` char(1) NOT NULL DEFAULT 'Y' COMMENT '초기상태 Y, 비활성화 N',
        `notice_pin_yn` char(1) DEFAULT 'N' COMMENT '초기상태 N',
        `admin_id` varchar(20) NOT NULL,
        `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
        `created_id` varchar(36) NOT NULL,
        `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
        `updated_id` varchar(36) NOT NULL,
        PRIMARY KEY (`notice_seq`)
    ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;*/

    private int notice_seq;
    private String notice_title;
    private String notice_content;
    private int notice_view_cnt;
    private Timestamp notice_reg_at;
    private String notice_use_yn;
    private String notice_pin_yn;
    private String admin_id;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String update_id;

    public NoticeDto(int notice_seq) {
        this.notice_seq = notice_seq;
    }

    public NoticeDto(String notice_title, String notice_content, int notice_view_cnt, Timestamp notice_reg_at, String notice_use_yn, String notice_pin_yn, String admin_id, Timestamp created_at, String created_id, Timestamp updated_at, String update_id) {
        this.notice_title = notice_title;
        this.notice_content = notice_content;
        this.notice_view_cnt = notice_view_cnt;
        this.notice_reg_at = notice_reg_at;
        this.notice_use_yn = notice_use_yn;
        this.notice_pin_yn = notice_pin_yn;
        this.admin_id = admin_id;
        this.created_at = created_at;
        this.created_id = created_id;
        this.updated_at = updated_at;
        this.update_id = update_id;
    }
}