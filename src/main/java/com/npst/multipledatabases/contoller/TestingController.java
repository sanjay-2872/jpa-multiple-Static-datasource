package com.npst.multipledatabases.contoller;

import com.npst.multipledatabases.constants.ResponseConstants;
import com.npst.multipledatabases.dto.ResponseMessage;
import com.npst.multipledatabases.model.db1.Booking;
import com.npst.multipledatabases.service.BookingSevice;
import com.npst.multipledatabases.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/books")
public class TestingController {

    @Autowired
    private BookingSevice BookingSevice;

    @GetMapping("/fetch")
    public ResponseEntity<ResponseMessage> fetchData(){
        List<Object> respData = BookingSevice.getBookingDetails();
        log.info("Fetch API Response :: {}",respData);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseUtils.successResponseMsg(ResponseConstants.SUCCESS_OK,respData));

    }
}
