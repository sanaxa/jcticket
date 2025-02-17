package com.jcticket.ticketing.service;

import com.jcticket.ticketing.dao.TicketingDao;
import com.jcticket.viewdetail.dto.ShowingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * packageName    : com.jcticket.ticketing.service
 * fileName       : TicketingServiceImpl
 * author         : 조영상
 * date           : 2/18/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/18/24         조영상        최초 생성
 */
@Service
@RequiredArgsConstructor
public class TicketingServiceImpl implements TicketingService{
    private final TicketingDao ticketingDao;

    //step1. 일정선택
    // 공연명, 공연포스터, 공연일자, 공연장명을 공연아이디를 가지고 받아온다.
    public Map<String,Object> getPlayInfo(String play_id) throws Exception{
        // 컨트롤러로 넘길 데이터 HashMap
        Map<String,Object> resultMap = new HashMap<>();
        // Map<String,ArrayList<String>> 의 형태로 변환하기 위한 key와 value 저장공간.
        // List<Map<k,v>> 의 key (모두 동일) 를 추출하여 저장할 문자열
        String dateKey = "";
        // List<Map<k,v>> 의 value 들의 값을 저장할 리스트
        List<String> dateList = new ArrayList<>();

        // Dao 를 통해 공연일정 List 를 받아온다.
        List<Map<String,String>> list = ticketingDao.selectDateByPlayId(play_id);
        // Dao 를 통해 공연명,공연포스터,공연장명 Map 을 받아온다
        Map<String,Object> map = ticketingDao.selectPlayStageName(play_id);

        // result map에 데이터 공연명,포스터,공연장명 Map 추가하기
        Set<String> keys = map.keySet();
        for(String key : keys){
            resultMap.put(key,map.get(key));
        }

        // resultMap 에 Map<String,ArrayList> 형태로 가공하여 공연일정 추가하기
        // 공연일정 리스트의 Map 에서 키는 dateKey 로 추출하여 resultMap 의 Key로 넣어주고,
        // 밸류(일정) 값들은 ArrayList<String>에 담아서 resultMap 의 Value로 넣어준다.
        Set<String> dateKeys = list.get(0).keySet();
        for(String key : dateKeys){
            dateKey = key;
        }
        for(Map<String,String> m : list){
            dateList.add(m.get(dateKey));
        }

        // 위에서 추출한 값들 resultMap 에 저장.
        resultMap.put(dateKey,dateList);

        return resultMap;
    }

    // 공연아이디와 공연일자를 가지고 회차정보를 가져온다.
    public List<String> getRoundList(String play_id, String date_text) throws Exception{
        // 컨트롤러에 반환할 resultMap
        //Map<String,Object> resultMap = new HashMap<>();
        // 컨트롤러로 반환할 ArrayList(회차정보) 만들기.
        List<String> infoList = new ArrayList<>();

        // Dao 의 메서드에 파라미터로 전달할 Map 만들기.
        Map<String,String> param = new HashMap<>();
        param.put("play_id", play_id);
        param.put("date_text", date_text);

        // Dao 메서드 호출하여 회차정보를 받아오기.
        List<Map<String,String>> list = ticketingDao.selectRound(param);


        // 첫 번째 Map에서 key 추출
        String infoKey = list.get(0).keySet().iterator().next();

        // 받아온 List<Map<String,Object>> 에서 showing_info(회차정보) 추출하기.
        for(Map<String,String> m : list){
            infoList.add(m.get(infoKey));
        }

        // resultMap 에 문자열 infoKey와 ArrayList를 넣어 컨트롤러로 반환한다.
        //resultMap.put(infoKey, infoList);

        return infoList;
    }
}
