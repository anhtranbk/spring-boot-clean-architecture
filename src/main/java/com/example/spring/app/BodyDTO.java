package com.example.spring.app;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyDTO {

    private String error;
    private Object data;

    public static BodyDTO withError(String error) {
        BodyDTO bodyDTO = new BodyDTO();
        bodyDTO.setError(error);
        return bodyDTO;
    }

    public static BodyDTO withData(Object data) {
        BodyDTO bodyDTO = new BodyDTO();
        bodyDTO.setData(data);
        return bodyDTO;
    }
}
