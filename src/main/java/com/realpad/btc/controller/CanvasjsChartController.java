package com.realpad.btc.controller;

import java.util.List;
import java.util.Map;

import com.realpad.btc.service.AnalyzeDate;
import com.realpad.btc.service.CanvasjsChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/canvasjschart")
public class CanvasjsChartController {

    @Autowired
    private CanvasjsChartService canvasjsChartService;

    @Autowired
    private AnalyzeDate analyzeDate;

    @RequestMapping(method = RequestMethod.GET)
    public String springMVC(ModelMap modelMap) {
        List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
        modelMap.addAttribute("dataPointsList", canvasjsDataList);
        modelMap.addAttribute("prediction", analyzeDate.getMessage());
        return "chart";
    }

}