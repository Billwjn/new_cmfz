package com.baizhi.service;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;

import java.util.Map;

public interface ChapterService {
    Map<String, Object> queryAll(Integer page , Integer rows , String albumId);
    String addChapter(Chapter chapter);
    void modifyChapter(Chapter chapter);
    void modifyDownPath(Chapter chapter);
    void removeChapter(String id);
}
