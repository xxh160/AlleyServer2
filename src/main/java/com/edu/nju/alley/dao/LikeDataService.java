package com.edu.nju.alley.dao;

public interface LikeDataService {

    boolean isExist(Integer userId, Integer commentId);

    void deleteLike(Integer userId,Integer commentId);

    void insertLike(Integer userId,Integer commentId);
}
