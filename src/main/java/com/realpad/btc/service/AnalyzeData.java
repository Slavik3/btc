package com.realpad.btc.service;

import org.springframework.stereotype.Service;

@Service
public class AnalyzeData implements AnalyzeDate {
    private static Boolean isBtcGrowth() {
        return GetData.values.get(GetData.values.size() - 1) > GetData.values.get(0);
    }

    @Override
    public String getMessage() {
        if(true) {
            return "Btc will grow";
        } else return "Btc will not grow";
    }
}
