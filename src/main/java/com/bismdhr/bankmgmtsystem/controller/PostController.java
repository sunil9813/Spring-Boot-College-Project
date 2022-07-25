package com.bismdhr.bankmgmtsystem.controller;

import com.bismdhr.bankmgmtsystem.dto.PostUpdateDTO;
import com.bismdhr.bankmgmtsystem.model.Post;
import com.bismdhr.bankmgmtsystem.repository.PostRepository;
import com.bismdhr.bankmgmtsystem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
//
//@RestController
//@RequestMapping("/post")
//public class PostController {
//
//    @Autowired
//    private PostService postService;
//
//    @GetMapping
//    public List<Post> getAll(){
//        return postService.getAllPost();
//    }
//
//    @GetMapping("/{id}")
//    public Post findById(@PathVariable int id){
//        return postService.findById(id);
//    }
//
//    @PostMapping
//    public Post addPost( @RequestBody @Valid Post post){
//        return postService.addPost(post);
//    }
//
//    @PutMapping
//    public ResponseEntity<Post> updatePost (@RequestBody @Valid PostUpdateDTO post){
//        Post updatedPost = postService.updatePost(post);
//        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deletePost(@PathVariable int id){
//        return postService.deletePost(id);
//    }
//}
//
//
@Controller
public class PostController  {
    @Autowired
    private PostService postService;

    @RequestMapping("/post")
    @ResponseBody
    @GetMapping
    public List<Post> getAll(){
         return postService.getAllPost();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable int id){
        return postService.findById(id);
    }

    @RequestMapping("home")
    public String homeFun(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.setAttribute("totalPost", repo.count());
        return "homePage";
    }
    @PostMapping
    public Post addPost( @RequestBody @Valid Post post){
        return postService.addPost(post);
    }

    @Autowired
    PostRepository repo;

    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/imagedata";

    @RequestMapping("addStudent")
    @ResponseBody
    public String addPost(Post stu,@RequestParam("img") MultipartFile file) {

        StringBuilder fileNames = new StringBuilder();
        String filename=stu.getId() + file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
        Path fileNameAndPath = Paths.get(uploadDirectory,filename);
        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stu.setSphoto(filename);
        repo.save(stu);
        return "Save Data Successfully ! ";
    }

    @PutMapping
    public ResponseEntity<Post> updatePost (@RequestBody @Valid PostUpdateDTO post){
        Post updatedPost = postService.updatePost(post);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable int id){
        return postService.deletePost(id);
    }

//    @RequestMapping("delStudent")
//    public String delStudent(int sid) {
//        repo.deleteById(sid);
//        return "homePage";
//    }
}