package com.demo.fraudalertdashboard.vo;

import com.demo.fraudalertdashboard.dao.entity.FraudAlertData;

import java.io.Serializable;
import java.util.List;



/**
 * Response object containing creditcard fraud details that will be sent to dashboard.
 *
 *
 */
public class Response implements Serializable {
	private List<FraudAlertData> fraudAlert;
	private String noOfFrauds;
	
	public List<FraudAlertData> getFraudAlert() {
		return fraudAlert;
	}
	public void setFraudAlert(List<FraudAlertData> fraudAlert) {
		this.fraudAlert = fraudAlert;
	}

	public void setNoOfFrauds(String noOfFrauds)
	{
		this.noOfFrauds=noOfFrauds;
	}
}
