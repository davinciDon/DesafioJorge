package com.davi.Support;

import lombok.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class Register {
    String type;
    double value;
    String time;
    public Register(String type, double value){
        this.setType(type);
        this.setValue(value);
        SimpleDateFormat sdf = new SimpleDateFormat("[dd/MM/yyyy HH:mm:ss]");
        String dateAndTime = sdf.format(new Date(System.currentTimeMillis()));
        setTime(dateAndTime);
    }
    @Override
    public String toString() {
        return getTime() +" "+ getType() + ": R$ " + getValue();
    }
}
