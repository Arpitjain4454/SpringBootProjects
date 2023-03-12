package com.arpit.messengerApp.controller;

import com.arpit.messengerApp.model.Status;
import com.arpit.messengerApp.service.IStatusService;
import com.arpit.messengerApp.service.StatusService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/status")
public class StatusController {

    @Autowired
    StatusService statusService;

    @PostMapping("/create-status")
    public ResponseEntity<String> createStatus(@RequestBody String statusData){
        Status status = setStatus(statusData);
        long statusId = statusService.saveStatus(status);
        return new ResponseEntity<>("Status saved with id - " + statusId, HttpStatus.CREATED);
    }

    private Status setStatus(String statusData) {
        Status status = new Status();

        JSONObject json = new JSONObject(statusData);
        String statusName = json.getString("statusName");
        String statusDescription = json.getString("statusDescription");

        status.setStatusName(statusName);
        status.setStatusDescription(statusDescription);

        return status;


    }

}
