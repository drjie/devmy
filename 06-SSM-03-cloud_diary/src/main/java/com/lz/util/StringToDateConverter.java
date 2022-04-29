package com.lz.util;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
      String format="yyyy/mm/dd";
        // 如果日期格式中间包含- 则替换格式
        if (source.contains("-")) {
            format = "yyyy-MM-dd";
        }
        DateFormat simpleDateFormat = new SimpleDateFormat(format);

        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
