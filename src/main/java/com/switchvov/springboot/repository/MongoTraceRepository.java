package com.switchvov.springboot.repository;

import org.springframework.boot.actuate.trace.Trace;
import org.springframework.boot.actuate.trace.TraceRepository;

import java.util.List;
import java.util.Map;

/**
 * MongoDB Trace端点持久化 Demo,需要配置MongoDB依赖
 * Created by Switch on 2017/6/11.
 */
// @Service
public class MongoTraceRepository implements TraceRepository {
//    @Autowired
//    private MongoOperations mongoOps;

    @Override
    public List<Trace> findAll() {
//        return mongoOps.findAll(Trace.class);
        return null;
    }

    @Override
    public void add(Map<String, Object> traceInfo) {
//        mongoOps.save(new Trace(new Date(), traceInfo));
    }
}
