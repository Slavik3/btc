package com.realpad.btc.dao;

import com.realpad.btc.service.GetData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {
    @Override
    public List<List<Map<Object, Object>>> getCanvasjsChartData() {
        return GetData.getCanvasjsDataList();
    }
}
