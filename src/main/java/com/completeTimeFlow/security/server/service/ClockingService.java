package com.completeTimeFlow.security.server.service;

import com.completeTimeFlow.security.repository.ClockingRepository;
import com.completeTimeFlow.security.server.domain.Clocking;
import com.completeTimeFlow.security.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClockingService {

    @Autowired
    ClockingRepository clockingRepository;

    public static final String DD_MM_YYYY_HH_MM = "yyyy-MM-dd HH:mm:ss";
    public static final String timezone = "America/Sao_Paulo";


    public void saveDateFormatted(Clocking clocking) {
        Date date = clocking.getClockingStartDate();

        clocking.setClockingStartDate(TimeUtil.getConvertedDate(date));

        clockingRepository.save(clocking);
    }
}
