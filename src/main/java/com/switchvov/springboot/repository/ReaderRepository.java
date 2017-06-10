package com.switchvov.springboot.repository;

import com.switchvov.springboot.pojo.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Reader仓库
 * Created by Switch on 2017/6/4.
 */
public interface ReaderRepository extends JpaRepository<Reader, String> {
    
}
