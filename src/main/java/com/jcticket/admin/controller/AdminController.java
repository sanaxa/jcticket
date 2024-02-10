package com.jcticket.admin.controller;

import com.jcticket.admin.dto.AdminDto;
import com.jcticket.admin.dto.UserPageDto;
import com.jcticket.admin.service.AdminService;
import com.jcticket.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * packageName :  com.jcticket.admin.controller
 * fileName : AdminController
 * author :  jisoo Son
 * date : 2024-02-05
 * description : 관리자 Controller
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    // /admin url 입력시 loginform 이동
    @GetMapping("/admin")
    public String admin() throws Exception{
        return "admin/adminloginform";
    }


    // 관리자 로그아웃
    @GetMapping("/admin/logout")
    public String adminlogout(HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        System.out.println("logout session => " + session);

        // 로그아웃 후 세션 삭제
        session.invalidate();

        return "redirect:/admin";
    }

    // 관리자 로그인시 대시보드 이동
    @GetMapping("/admin/dashboard")
    public String admindashboard(Model model) throws Exception{

        try {
            List<UserDto> userLists = adminService.userstatics();

            model.addAttribute("userLists", userLists);
        } catch (Exception e){
            e.printStackTrace();
        }

        return "admin/admindashboard";
    }

    // 관리자 로그인
    @PostMapping("/admin")
    @ResponseBody
    private String login(@RequestBody AdminDto adminDto, HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();
        String msg = null;

        try {
            AdminDto rslt = adminService.login(adminDto);
            System.out.println("rslt => " + rslt);

            // DB에 있는 관리자 사용 여부
            String adminUseYn = rslt.getAdmin_use_yn();

            if (rslt != null && adminUseYn.equals("Y")) {

                session.setAttribute("adminId", rslt.getAdmin_id());
                // 관리자 헤더 nickname 보여주기 (json 방식이라 model 전달은 안되나 임시방편 session 전달)
                session.setAttribute("adminNickName", rslt.getAdmin_nickname());

                msg = "ok";
            }else{
                session.invalidate();

                msg = "fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;

    }
    // 회원 관리
    @GetMapping("/admin/user")
    public String adminuser(Model model,
                            @RequestParam(value = "option", required = false) String option,
                            @RequestParam(value = "keyword", required = false) String keyword,
                            @RequestParam(value = "page", defaultValue = "1") int page) throws Exception{

        System.out.println("option => " + option);
        System.out.println("keyword => " + keyword);
        System.out.println("page => " + page);

        try {

            List<UserDto> pagingList = null;

            pagingList = adminService.userPaingList(page, option, keyword);
            UserPageDto userPageDto = adminService.pagingParam(page, option, keyword);
            int userTotalCnt = adminService.usercnt(option, keyword);

            System.out.println("pagingList => " + pagingList);
            System.out.println("userPageDto => " + userPageDto);

            model.addAttribute("list", pagingList);
            model.addAttribute("paging", userPageDto);
            model.addAttribute("userListCnt", userTotalCnt);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "admin/adminuser";
    }
    @GetMapping("/admin/register")
    public String adminuserregister() throws Exception{
        return "admin/adminuserregister";
    }
    @GetMapping("/admin/delete")
    public String adminuserdelete() throws Exception{
        return "admin/adminuserdelete";
    }
    @GetMapping("/admin/agency")
    public String adminagency() throws Exception{
        return "admin/adminagency";
    }
    @GetMapping("/admin/product")
    public String adminproduct() throws Exception{
        return "admin/adminproduct";
    }
    @GetMapping("/admin/notice")
    public String adminnotice() throws Exception{
        return "admin/adminnotice";
    }
    @GetMapping("/admin/inquiry")
    public String admininquiry() throws Exception{
        return "admin/admininquiry";
    }
    @GetMapping("/admin/coupon")
    public String admincoupon() throws Exception{
        return "admin/admincoupon";
    }
    @GetMapping("/admin/stactics")
    public String adminstactics() throws Exception{
        return "admin/adminstactics";
    }
    @GetMapping("/admin/setting")
    public String adminsetting() throws Exception{
        return "admin/adminsetting";
    }
}