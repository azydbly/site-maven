package com.xst.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ClassName: Dictitem
 * @类描述: Dictitem  字典详情实体类
 * @Author: xiaoshitou
 * @Eamil: 15324399524@163.com
 * @CreateDate: 2018/9/21 10:05
 */
public class Dictitem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //名称
    private String name;

    //描述
    private String description;

    //字典id
    private int dictionary;

    //删除标识
    private int flag;

    //字典实体类
    private Dictionary dictionar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDictionary() {
        return dictionary;
    }

    public void setDictionary(int dictionary) {
        this.dictionary = dictionary;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Dictionary getDictionar() {
        return dictionar;
    }

    public void setDictionar(Dictionary dictionar) {
        this.dictionar = dictionar;
    }
}
