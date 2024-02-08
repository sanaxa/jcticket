package com.jcticket.agency.service;

import com.jcticket.agency.dao.AgencyDao;
import com.jcticket.agency.dto.AgencyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.jcticket.agency.service
 * fileName       : AgencyServiceImpl
 * author         : {sana}
 * date           : 2024-02-07
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-07        {sana}       최초 생성
 */

//6. AgencyServiceImpl 생성 : Dao,DaoImpl과 마찬가지로 AgencyService interface를 implements한 AgencyServiceImpl.
@Service
public class AgencyServiceImpl implements AgencyService{

    @Autowired//AgencyDao 빈을 주입받음
    private AgencyDao agencyDao;

    @Override//selectAgency 메서드를 오버라이드.
    public AgencyDto selectAgency(String agency_id) throws Exception {//또외처리
        return agencyDao.selectAgency(agency_id); //AgencyDao를 사용하여 agency_id정보를 가져오고 반환?
    }
}
