package com.lz.service.impl;

import com.lz.dao.TbMusicMapper;
import com.lz.entity.TbMusic;
import com.lz.entity.TbMusicExample;
import com.lz.service.TbMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbMusicServiceImpl implements TbMusicService {
    @Autowired
    private TbMusicMapper tbMusicMapper;
    @Override
    public List<TbMusic> findAll() {
        //无条件查询全部
        return tbMusicMapper.selectByExample(null);
    }

    @Override
    public TbMusic findById(Integer musicId) {
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic nextSong(Integer musicId) {
        Integer maxId=tbMusicMapper.findMaxId();
        if (musicId==maxId){
            musicId=1;
        }else {
            musicId++;
        }
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic prevSong(Integer musicId) {
        Integer minId=tbMusicMapper.findMinId();
        if (!musicId.equals(minId)){
            musicId--;
        }else {
            musicId=tbMusicMapper.findMaxId();
        }
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public List<TbMusic> search(String keyword) {
        TbMusicExample musicExample = new TbMusicExample();

        TbMusicExample.Criteria criteria = musicExample.createCriteria();

        criteria.andMusicNameLike("%" + keyword + "%");

        return tbMusicMapper.selectByExample(musicExample);
    }

}
