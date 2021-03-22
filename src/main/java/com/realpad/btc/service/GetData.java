package com.realpad.btc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetData {
    static Logger log = Logger.getLogger(GetData.class.getName());

    private static Map<Object, Object> map = null;
    private static List<List<Map<Object, Object>>> list = new ArrayList<List<Map<Object, Object>>>();
    private static List<Map<Object, Object>> dataPoints1 = new ArrayList<Map<Object, Object>>();
    static List<Double> values = new ArrayList<Double>();

    private static final String startData = "2021-03-11";
    private static final String endData = "2021-03-17";
    private static final String url = "https://api.coindesk.com/v1/bpi/historical/close.json?start=" + startData + "&end=" + endData;

    static {
        JSONObject json = readJsonFromUrl(url);
        Map<String, String> resultFromJson = getMapFromJson(json);

        for (Map.Entry<String, String> entry : resultFromJson.entrySet()) {
            map = new HashMap<Object, Object>();
            map.put("x", entry.getKey().substring(8));
            map.put("y", entry.getValue());
            dataPoints1.add(map);
            values.add(Double.parseDouble(String.valueOf(entry.getValue())));
        }
        list.add(dataPoints1);
    }

    private static Map<String, String> getMapFromJson(JSONObject json) {
        Map<String, String> resultFromJson = null;
        try {
            resultFromJson = new ObjectMapper().readValue(json.get("bpi").toString(), HashMap.class);
        } catch (JsonProcessingException e) {
            log.error(e);
        }
        return resultFromJson;
    }

    public static List<List<Map<Object, Object>>> getCanvasjsDataList() {
        return list;
    }

    private static JSONObject readJsonFromUrl(String url) {
        JSONObject json = null;
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            json = new JSONObject(jsonText);
        } catch (JSONException | IOException e) {
            log.error(e);
        }
        return json;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

}
