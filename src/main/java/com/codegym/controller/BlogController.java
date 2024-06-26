package com.codegym.controller;


import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;


    @GetMapping
    public ResponseEntity<Iterable<Blog>> show(){
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showDetail(@PathVariable Long id){
        Optional<Blog> blogOptional = blogService.findById(id);
        return blogOptional.map(blog ->
                new ResponseEntity<>(blog, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/search")
    public ResponseEntity<List<Blog>> showAllInCategory(@RequestParam("search") String name){
        List<Blog> blogs = blogService.findAllByCategory(name);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
}
