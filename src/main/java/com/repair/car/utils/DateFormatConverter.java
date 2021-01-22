package com.repair.car.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatConverter {

    public static String  convert(String sourceDate){

        DateTimeFormatter SourceDf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        DateTimeFormatter TargetDf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String targetDate = LocalDate.parse(sourceDate,SourceDf).format(TargetDf).toString();

        return targetDate;

    }





}
