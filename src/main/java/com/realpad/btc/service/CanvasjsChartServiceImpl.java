package com.realpad.btc.service;

import java.util.List;
import java.util.Map;

import com.realpad.btc.dao.CanvasjsChartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CanvasjsChartServiceImpl implements CanvasjsChartService {

    @Autowired
    private CanvasjsChartDao canvasjsChartDao;

    @Override
    public List<List<Map<Object, Object>>> getCanvasjsChartData() {
        return canvasjsChartDao.getCanvasjsChartData();
    }
}
