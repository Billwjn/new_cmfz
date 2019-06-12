package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private AlbumDao albumDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> queryAll(Integer page, Integer rows , String albumId) {
        Integer begin = (page - 1)*rows;
        Integer records = chapterDao.selectRecords(albumId);
        Integer total = records % rows == 0 ? records / rows : records / rows + 1;
        List<Chapter> chapters = chapterDao.selectAll(begin, rows , albumId);
        Map<String , Object> map = new HashMap<>();
        map.put("page",page);
        map.put("rows",chapters);
        map.put("records",records);
        map.put("total",total);
        return map;
    }

    @Override
    public String addChapter(Chapter chapter) {
        String s = UUID.randomUUID().toString();
        chapter.setId(s);
        chapterDao.insert(chapter);
        albumDao.updateCount(chapter.getAlbumId());
        return s;
    }

    @Override
    public void modifyChapter(Chapter chapter) {
        chapterDao.update(chapter);
    }

    @Override
    public void modifyDownPath(Chapter chapter) {
        chapterDao.updateDownPath(chapter);
    }

    @Override
    public void removeChapter(String id) {
        chapterDao.delete(id);
    }
}
