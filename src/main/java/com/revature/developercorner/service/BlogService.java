package com.revature.developercorner.service;

import com.revature.developercorner.data.BlogRepository;
import com.revature.developercorner.entity.Blog;
import com.revature.developercorner.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService{
    // automatically connects the blogRepository
    @Autowired
    BlogRepository blogRepository;
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    public Blog getById(Blog blog, Long id){
        blogRepository.findById(id).get();
        return blog;

    }


    public Blog getByUserId(Blog blog, Long id){
        blogRepository.findById(id);
        return blog;
    }
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public void update_blog(Blog blog, Long id) {
        Blog blogDB = blogRepository.findById(id).get();
        blogDB.setTitle(blog.getTitle());
        blogDB.setContent(blog.getContent());
        blogDB.setUpVotes(blog.getUpVotes());
        blogDB.setDownVotes(blog.getDownVotes());
        blogDB.setCreated_at(blog.getCreated_at());
        blogDB.setUpdated_at(blog.getUpdated_at());
        blogDB.setUser_id(blog.getUser_id());
        blogRepository.save(blogDB);
    }

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

}
