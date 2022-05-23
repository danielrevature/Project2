package com.revature.developercorner.service;

import com.revature.developercorner.data.BlogRepository;
import com.revature.developercorner.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public Blog add_Post(Blog blog){
        blogRepository.save(blog);
        return blog;
    }

    public List<Blog> get_All_Posts(){
        return blogRepository.findAll();
    }


    public List<Blog> get_Post_custom(String flag) {
        switch(flag){
            case "new":
                return blogRepository.findByDate();
            case "old":
                return blogRepository.findByDate();
            default:
                return get_All_Posts();
        }
    }


    public Blog get_Post_by_id(Long id) {
        return blogRepository.findById(id).get();
    }

    public Blog update_Post(Blog blog, Long id) {
        Blog blogDB = blogRepository.findById(id).get();
        blogDB.setPost(blog.getPost());
        blogDB.setTime(blog.getTime());
        blogDB.setAuthor(blog.getAuthor());
        blogRepository.save(blogDB);
        return blogDB;
    }

    public void delete_post(Long id){ blogRepository.deleteById(id);
    }
}


