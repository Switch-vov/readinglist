package com.switchvov.springboot.repository;

import com.switchvov.springboot.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 阅读列表仓库
 * Created by Switch on 2017/6/4.
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
