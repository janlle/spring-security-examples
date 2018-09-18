package com.andy.test.properties;

import lombok.Data;

/**
 * @author Leone
 * @since 2018-04-07 07:58
 **/
@Data
public class ImageCodeProperties extends SmsCodeProperties {

    public ImageCodeProperties(){
        setLength(4);
    }

    private int width = 67;

    private int height = 23;

}
