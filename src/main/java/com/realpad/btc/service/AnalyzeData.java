package com.realpad.btc.service;

import org.springframework.stereotype.Service;

@Service
public class AnalyzeData implements AnalyzeDate {
    private static Boolean isBtcGrowth() {
        if(GetData.values.get(GetData.values.size()-1)>GetData.values.get(0)) {
            return true;
        }
        else return false;
    }

    @Override
    public String getMessage() {
        if(isBtcGrowth().equals(true)) {
            return "Btc will grow";
        } else{
            return "Btc will not grow";
        }
    }
}
