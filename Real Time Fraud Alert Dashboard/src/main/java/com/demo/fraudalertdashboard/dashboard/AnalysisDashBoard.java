package com.demo.fraudalertdashboard.dashboard;

import com.demo.fraudalertdashboard.dao.FraudAlertDataRepository;
import com.demo.fraudalertdashboard.dao.entity.FraudAlertData;
import com.demo.fraudalertdashboard.vo.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class AnalysisDashBoard {
    private static final Logger logger = Logger.getLogger(AnalysisDashBoard.class);


    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private FraudAlertDataRepository fraudAlertRepository;

    private long previous_timestamp=0L;

    private static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    //Method sends fraud transaction message in every 5 seconds.
    @Scheduled(fixedRate = 5000)
    public void trigger() {

        List<FraudAlertData> recentFraudList = new ArrayList<FraudAlertData>();
        //Call dao methods
        if(previous_timestamp==0) {
            fraudAlertRepository.findFraudDataByTimestamp(new Date().getTime() - 10000).forEach(e -> {
                recentFraudList.add(e);
            });
        }
           /* Collections.sort(recentFraudList, new FraudAlertService.CustomComparator());
            previous_timestamp = recentFraudList.get(0).getTrans_time().getTime();
        }
        else {
            fraudAlertRepository.findFraudDataByTimestamp(previous_timestamp).forEach(e -> {
                recentFraudList.add(e);
            });
            Collections.sort(recentFraudList, new FraudAlertService.CustomComparator());
            previous_timestamp = recentFraudList.get(0).getTrans_time().getTime();
        }*/
        logger.info("analysis Dashboard: " + previous_timestamp);


        //prepare response
        Response response = new Response();
        response.setFraudAlert(recentFraudList);
        logger.info("Sending to UI "+response);
        //send to ui
        this.template.convertAndSend("/topic/noOfFrauds", response);
    }

}
