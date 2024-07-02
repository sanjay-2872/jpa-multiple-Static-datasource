package com.npst.multipledatabases.contoller;

import com.npst.multipledatabases.service.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Slf4j
@RestController
public class CheckContoller {

    @Autowired
    private Util util;


    @GetMapping("/check/{id}")
    public ResponseEntity<Map<String,Object>> check(@PathVariable("id") String id){
        log.info("ID : {}", id);
        Map<String, Boolean> result;
        result = Util.checkServerstatus(id);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("responseMessage",result));
    }
}
