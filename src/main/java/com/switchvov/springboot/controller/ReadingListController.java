package com.switchvov.springboot.controller;

import com.switchvov.springboot.pojo.Book;
import com.switchvov.springboot.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 阅读列表Controller
 * Created by Switch on 2017/6/4.
 */
@Controller
@RequestMapping("/readinglist")
public class ReadingListController {
    private ReadingListRepository readingListRepository;

    // 度量服务
    private CounterService counterService;
    private GaugeService gaugeService;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository, CounterService counterService, GaugeService gaugeService) {
        this.readingListRepository = readingListRepository;
        this.counterService = counterService;
        this.gaugeService = gaugeService;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);

        // 增加度量值
        counterService.increment("books.saved");
        gaugeService.submit("book.last.saved", System.currentTimeMillis());

        return "redirect:/readinglist/{reader}";
    }
}
