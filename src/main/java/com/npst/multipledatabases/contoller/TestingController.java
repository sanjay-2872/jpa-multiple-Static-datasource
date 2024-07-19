package com.npst.multipledatabases.contoller;

import com.npst.multipledatabases.constants.ResponseConstants;
import com.npst.multipledatabases.dto.BookingDto;
import com.npst.multipledatabases.dto.ResponseMessage;
import com.npst.multipledatabases.service.BookingSevice;
import com.npst.multipledatabases.utils.ResponseUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/books")
public class TestingController {

    private final BookingSevice bookingSevice;

    @Autowired
    private TestingController(BookingSevice bookingSevice){
        this.bookingSevice=bookingSevice;
    }

    @GetMapping("/fetch")
    public ResponseEntity<ResponseMessage> fetchData(){
        List<Object> respData = bookingSevice.getBookingDetails();
        log.info("Fetch API Response :: {}",respData);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseUtils.successResponseMsg(ResponseConstants.SUCCESS_OK,respData));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addData(@Valid @RequestBody BookingDto bookingDto){
        log.info("Add Book :: {}",bookingDto);
        boolean status = bookingSevice.addBookDetails(bookingDto);
        log.info("Add Booking Response status:: {}",status);
        if(status){
            return ResponseEntity.status(HttpStatus.CREATED).body(ResponseUtils.successResponseMsg(ResponseConstants.SUCCESS_OK,"Success Created"));
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ResponseUtils.successResponseMsg(ResponseConstants.SUCCESS_OK,"Data Creation Failed"));
    }


}
