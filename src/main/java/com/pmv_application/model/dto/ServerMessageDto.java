package com.pmv_application.model.dto;

import lombok.Data;

@Data
public class ServerMessageDto {

        private Integer successFlag;
        private String Message;
        private Integer masterID;
        private Object data;


}
