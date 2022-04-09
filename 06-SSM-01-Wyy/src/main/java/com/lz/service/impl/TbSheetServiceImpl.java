package com.lz.service.impl;

import com.lz.dao.TbSheetMapper;
import com.lz.entity.TbMusic;
import com.lz.entity.TbSheet;
import com.lz.entity.TbSheetExample;
import com.lz.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbSheetServiceImpl implements TbSheetService {
    @Autowired
    private TbSheetMapper tbSheetMapper;
    @Override
    public List<TbSheet> findAll() {
        //无条件查询全部
        return tbSheetMapper.selectByExample(null);
    }

    @Override
    public List<TbMusic> findSongsBySheet(String sheetName) {

        return tbSheetMapper.findSongsBySheet(sheetName);
    }

    @Override
    public Map<String, Object> insertSheet(TbSheet sheetName) {
        int affectedRows = tbSheetMapper.insertSelective(sheetName);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",-1);
        map.put("message","失败了");
        map.put("success",false);
        if (affectedRows>0){
            map.put("code",200);
            map.put("message","成功了");
            map.put("success",true);
        }
        return map;
    }

}
