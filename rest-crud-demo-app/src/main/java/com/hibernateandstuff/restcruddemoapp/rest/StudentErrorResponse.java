package com.hibernateandstuff.restcruddemoapp.rest;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

// burda sadece fieldsları belirteceğiz
public class StudentErrorResponse<T> {

    private int  status;
    private String messages;
    private long timeStamp;

}
