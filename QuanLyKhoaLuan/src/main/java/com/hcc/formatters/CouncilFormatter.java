/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.formatters;

import com.hcc.pojo.Council;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ACER
 */
public class CouncilFormatter implements  Formatter<Council>{

    @Override
    public String print(Council council, Locale locale) {
        return String.valueOf(council.getId());
    }

    @Override
    public Council parse(String id, Locale locale) throws ParseException {
        Council c = new Council();
        c.setId(Integer.parseInt(id));
        return c;
    }
    
}
