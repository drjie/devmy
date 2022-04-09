package com.lz.service;

import com.lz.entity.TbMusic;
import com.lz.entity.TbSheet;

import java.util.List;
import java.util.Map;

public interface TbSheetService {
    List<TbSheet> findAll();

    List<TbMusic> findSongsBySheet(String sheetNam);

    Map<String, Object> insertSheet(TbSheet sheetName);
}
