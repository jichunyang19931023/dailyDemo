package api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import api.entity.CreateTicketAPI;
import api.service.APIService;
import cn.hutool.json.JSONObject;

@RestController
public class APIController {
	
	@Autowired
	private APIService apiService;

	@GetMapping(value = "/getApi")
    public JSONObject getApi(String userName, String password, Long currentTime) {
		CreateTicketAPI ticketAPI = new CreateTicketAPI();
		ticketAPI.setUserName(userName);
		ticketAPI.setPassword(password);
		ticketAPI.setCurrentTime(currentTime);
		return apiService.apiCreate(ticketAPI);
    }
}
