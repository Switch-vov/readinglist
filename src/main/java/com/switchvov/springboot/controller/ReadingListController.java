package com.switchvov.springboot.controller;

import com.switchvov.springboot.pojo.Book;
import com.switchvov.springboot.repository.ReaderRepository;
import com.switchvov.springboot.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ReadingListRepository readingListRepository;

    @Autowired
    private ReaderRepository readerRepositoty;

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
        return "redirect:/readinglist/{reader}";
    }
}
