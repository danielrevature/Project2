package com.revature.developercorner;

import com.revature.developercorner.data.*;
import com.revature.developercorner.entity.*;
import com.revature.developercorner.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class DeveloperCornerApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    TechStackRepository techStackRepository;

    @Autowired
    BlogService blogService;

    @Autowired
    TechStackService techStackService;

    @Autowired
    RoleService roleService;

    @Autowired
    QuestionService questionService;

    @Autowired
    MessageService messageService;


    /*================================================================================================================
                                                      CREATE TESTS
     ================================================================================================================*/


    @Test
    void testAddUser() {
        Role role = new Role(1L, "ADMIN");
        roleService.addRole(role);
        User user = new User("msmith", "msmith@gmail.com", "123", role, "evening");
        userService.addUser(user);
        user = userService.loadUserByUsername("msmith");
        Assertions.assertEquals(1L, user.getUserId());


    }

    @Test
    void testAddQuestion(){

        Question question = new Question(2L, "Java", "How do I use Collections?",null, null, null);
        questionService.addQuestion(question);

        question = questionService.getQuestionById(1L);
        Assertions.assertEquals("How do I use Collections?", question.getQuestion());
    }

    @Test
    void testAddTechStack(){

        TechStack techStack = new TechStack(2L, "Java");
        techStackService.addTechStack(techStack);

        techStack = techStackService.getTechStackById(1L);
        Assertions.assertEquals("Java", techStack.getStack());
    }

    @Test
    void testAddMessage(){
        Message message = new Message("Please help me", 1L, 1L);
        messageService.addMessage(message);

        message = messageService.getMessageById(1L);
        Assertions.assertEquals("Please help me", message.getMessage());
    }

    @Test
    void testAddBlog(){
        Blog blog = new Blog("Test blog", "Programming is kinda cool!", 7, 5, null, null, 1L);
        blogService.addPost(blog);

        blog = blogService.getPostById(1L);
        Assertions.assertEquals("Test blog", blog.getTitle());
    }

    @Test
    void testAddRole(){
        Role role = new Role("Mentor");
        roleService.addRole(role);

        role = roleService.getRoleById(1L);
        Assertions.assertEquals("Mentor", role.getRole_name());
    }

    /*================================================================================================================
                                                      READ TESTS
     ================================================================================================================*/

    @Test
    void testGetUserById(){
        // have to create a new user since we don't have an initTable method
        Role role = new Role(1L, "Mentor");
        roleService.addRole(role);
        User user = new User("example", "example@ymail.com", "example123", role, "morning");
        userService.addUser(user);
        System.out.println(user.getUsername());

        Assertions.assertEquals(1L, user.getUserId());

    }

    @Test
    void testGetQuestionById(){
        Question question = new Question(2L, "Java", "How do I use String Literals?", null,null, null);
        questionService.addQuestion(question);
        System.out.println(question.getQuestion());

        Assertions.assertEquals(1L, question.getId());
    }

    @Test
    void testGetTechStackById(){
        TechStack techStack = new TechStack(1L, "Java");
        techStackService.addTechStack(techStack);
        System.out.println(techStack.getStack());

        Assertions.assertEquals(1L, techStack.getId());
    }

    @Test
    void testRoleById(){
        Role role = new Role("Learner");
        roleService.addRole(role);
        System.out.println(role.getRole_name());

        Assertions.assertEquals(1L, role.getId());
    }

    @Test
    void testGetBlogById(){
        Blog blog = new Blog("Also Test blog", "Some concepts are hard to understand.", 28, 1, null, null, 1L);
        blogService.addPost(blog);
        System.out.println(blog.getContent());

        Assertions.assertEquals(1L, blog.getId());
    }

    @Test
    void testGetMessageById(){
        Message message = new Message("Could you please help me?", 1L, 1L);
        messageService.addMessage(message);
        System.out.println(message.getMessage());


        Assertions.assertEquals(1L, message.getId());
    }

    /*================================================================================================================
                                                      UPDATE TESTS
     ================================================================================================================*/

    @Test
    void testUserUpdate(){
        // have to create a new user since we don't have an initTable method
        Role role = new Role(1L, "Mentor");
        roleService.addRole(role);
        User user = new User("example", "example@ymail.com", "example123", role, "morning");
        userService.addUser(user);
        System.out.println(user.toString());

        User userdb = user;
        userdb.setUsername("MyExample");
        System.out.println(user.toString());


        Assertions.assertEquals("MyExample", user.getUsername());

    }

    @Test
    void testUpdateQuestion(){

        Question question = new Question(2L, "Java", "How do I use Collections?", null, null, null);
        questionService.addQuestion(question);
        System.out.println(question.toString());

        Question question1 = question;
        question1.setQuestion("Could you help me with Collections?");
        System.out.println(question.toString());

        Assertions.assertEquals("Could you help me with Collections?", question.getQuestion());
    }

    @Test
    void testUpdateMessage(){
        Message message = new Message("Please help me", 1L, 1L);
        messageService.addMessage(message);
        System.out.println(message.toString());

        Message message1 = message;
        message1.setMessage("I need help with my program!");
        System.out.println(message.toString());

        Assertions.assertEquals("I need help with my program!", message.getMessage());
    }

    @Test
    void testUpdateRole(){
        Role role = new Role("Mentor");
        roleService.addRole(role);
        System.out.println(role.toString());

        Role role1 = role;
        role1.setRole_name("Admin");
        System.out.println(role.toString());

        Assertions.assertEquals("Admin", role.getRole_name());
    }

    @Test
    void testUpdateTechStack(){

        TechStack techStack = new TechStack(2L, "Java");
        techStackService.addTechStack(techStack);
        System.out.println(techStack.toString());

        TechStack techStack1 = techStack;
        techStack1.setStack("Angular");
        System.out.println(techStack.toString());

        Assertions.assertEquals("Angular", techStack.getStack());
    }

    @Test
    void testUpdateBlog(){
        Blog blog = new Blog("Test blog", "Programming is kinda cool!", 7, 5, null, null, 1L);
        blogService.addPost(blog);
        System.out.println(blog.toString());

        Blog blog1 = blog;
        blog1.setContent("Correction: programming is stressful!!");
        System.out.println(blog.toString());

        Assertions.assertEquals("Correction: programming is stressful!!", blog.getContent());
    }

    /*================================================================================================================
                                                      DELETE TESTS
     ================================================================================================================*/

    @Test
    void testDeleteUser(){
        // have to create a new user since we don't have an initTable method
        Role role = new Role(1L, "Mentor");
        roleService.addRole(role);
        User user = new User("example", "example@ymail.com", "example123", role, "morning");
        userService.addUser(user);
        System.out.println(user.toString());


        userService.deleteUser(user.getUserId());
        User user1 =null;
        try {
            user1 = userService.getById(1L);
        }catch(Exception e){
            System.out.println("No user for this id!");
        }

        //System.out.println(user.toString());


        Assertions.assertNull(user1);

    }

    @Test
    void testDeleteQuestion(){

        Question question = new Question(2L, "Java", "How do I use Collections?", null, null, null);
        questionService.addQuestion(question);

        questionService.deleteQuestion(question.getId());
        Question question1 = null;

        try{
            question1 = questionService.getQuestionById(1L);
        }catch(Exception e){
            System.out.println("No question exists!");
        }

        Assertions.assertNull(question1);
    }

    @Test
    void testDeleteMessage(){

        Message message = new Message("This is kinda hard.", 1L, 1L);
        messageService.addMessage(message);

        messageService.deleteMessage(message.getId());
        Message message1 = null;

        try{
            message1 = messageService.getMessageById(1L);
        }catch(Exception e){
            System.out.println("No messages here!");
        }

        Assertions.assertNull(message1);
    }

    @Test
    void testDeleteBlog(){

        Blog blog = new Blog("Test blog the II", "I should have started coding way sooner!!", 18, 5, null, null, 1L);
        blogService.addPost(blog);

        blogService.deletePost(blog.getId());
        Blog blog1 = null;

        try{
            blog1 = blogService.getPostById(1L);
        }catch(Exception e){
            System.out.println("Nothing exists!");
        }

        Assertions.assertNull(blog1);
    }

    @Test
    void testDeleteRole(){

        Role role = new Role("Learner");
        roleService.addRole(role);

        roleService.deleteRole(role.getId());
        Role role1 = null;

        try{
            role1 = roleService.getRoleById(1L);
        }catch(Exception e){
            System.out.println("No role exists!");
        }

        Assertions.assertNull(role1);
    }

    @Test
    void testDeleteTechStack(){

        TechStack techStack = new TechStack(2L,"Angular");
        techStackService.addTechStack(techStack);

        techStackService.deleteTechStack(techStack.getId());
        TechStack techStack1 = null;

        try{
            techStack1 = techStackService.getTechStackById(1L);
        }catch(Exception e){
            System.out.println("No such TechStack exists here!");
        }

        Assertions.assertNull(techStack1);
    }




     /*================================================================================================================
                                                      REPOSITORY TESTS
     ================================================================================================================*/


    @Test
    void testBlogRepo(){
        Blog blog = new Blog("Test blog", "Programming is kinda cool!", 17, 5, null, null, 1L);
        blogRepository.save(blog);

        List<Blog> allUserPosts = new ArrayList<>();
        allUserPosts.add(blog);

        Blog blog1 = new Blog("Test blog", "Programming can be cool!", 17, 6, null, null, 1L);
        blogRepository.save(blog1);
        allUserPosts.add(blog1);

        Blog blog2 = new Blog("Test blog", "I'm having fun learning!", 15, 3, null, null, 1L);
        blogRepository.save(blog2);
        allUserPosts.add(blog2);

        Assertions.assertEquals(allUserPosts, blogRepository.findAll());
    }

    @Test
    void testMessageRepository(){
        Message message = new Message("Please help me", 1L, 1L);
        messageRepository.save(message);

        List<Message> allMessages = new ArrayList<>();
        allMessages.add(message);

        Message message1 = new Message("How can I create a new class?", 1L, 1L);
        messageRepository.save(message1);
        allMessages.add(message1);

        Message message2 = new Message("How do I approach creating my own linked list?", 1L, 1L);
        messageRepository.save(message2);
        allMessages.add(message2);

        Assertions.assertEquals(allMessages, messageRepository.findAll());
    }

    @Test
    void testQuestionRepository(){
        Question question = new Question(2L, "Java", "How do I use Collections?", null, null, null);
        questionRepository.save(question);

        List<Question> allQuestions = new ArrayList<>();
        allQuestions.add(question);

        Question question1 = new Question(2L, "Java", "How do linked lists work?", null, null, null);
        questionRepository.save(question1);
        allQuestions.add(question1);


        Assertions.assertEquals(allQuestions, questionRepository.findAll());
    }

    @Test
    void testRoleRepository(){
        Role role = new Role("Mentor");
        roleRepository.save(role);

        List<Role> allRoles = new ArrayList<>();
        allRoles.add(role);

        Role role1 = new Role("Learner");
        roleRepository.save(role1);
        allRoles.add(role1);


        Assertions.assertEquals(allRoles, roleRepository.findAll());
    }

    @Test
    void testTechStackRepository(){
        TechStack techStack = new TechStack(2L, "Java Script");
        techStackRepository.save(techStack);

        List<TechStack> allTechStacks = new ArrayList<>();
        allTechStacks.add(techStack);

        TechStack techStack1 = new TechStack(2L, "Spring");
        techStackRepository.save(techStack1);
        allTechStacks.add(techStack1);


        Assertions.assertEquals(allTechStacks, techStackRepository.findAll());
    }

    @Test
    void testUserRepository() {
        Role role = new Role(1L, "ADMIN");
        roleService.addRole(role);
        User user = new User("msmith", "msmith@gmail.com", "123", role, "evening");
        userRepository.save(user);

        List<User> allUsers = new ArrayList<>();
        allUsers.add(user);

        User user1 = new User("theBoogieMan", "BoogieMan@gmail.com", "U3", role, "evening");
        userRepository.save(user1);
        allUsers.add(user1);

        Assertions.assertEquals(allUsers, userRepository.findAll());


    }

}