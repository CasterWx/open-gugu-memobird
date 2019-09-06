package dao;

import domain.Content;

import java.util.ArrayList;

/**
 *  Student对象的CRUD操作
 * */
public interface IContentDAO {
    // ----------------------------------增--------------------------------------------

    /**
     * 保存学生对象
     * @param student
     * */
    void save(Content student);


    /**
     *  查询所有学生对象
     *  @return 所有学生对象
     * */
    ArrayList<Content> list() ;
}
