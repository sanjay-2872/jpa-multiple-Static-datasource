package com.npst.multipledatabases.utils;

import com.npst.multipledatabases.constants.ResponseConstants;
import com.npst.multipledatabases.dto.ResponseMessage;

public class ResponseUtils {

    public static ResponseMessage successResponseMsg(ResponseConstants responseConstants, Object respMsg){
        return ResponseMessage.builder()
                .respCode(responseConstants.getRespCode())
                .respMsg(responseConstants.getRespMsg())
                .respData(respMsg)
                .build();
    }
}
