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
class DeveloperCornerApplicationTests2 {

    @Autowired
    UserService userService;

    @Autowired
    TechStackService techStackService;

    @Autowired
    RoleService roleService;

    @Autowired
    QuestionService questionService;

    @Autowired
    MessageService messageService;

    @Autowired
    BlogService blogService;

    @Autowired
    UserRepository userRepository;

    @Test
    void testApplication() {
        //============================================================================================================
        //                                      USER TESTS
        //============================================================================================================

        // AddUser
        Role role = new Role(1L, "ADMIN");
        roleService.addRole(role);
        User user = new User("msmith", "msmith@gmail.com", "123", role, "evening");
        userService.addUser(user);
        user = userService.loadUserByUsername("msmith");
        Assertions.assertEquals(1L, user.getUserId());

        // UpdateUser
        User newUser = new User ("jsmith", "jsmith@gmail.com", "456", role, "morning");
        userService.updateUser(1L, newUser);
        User userDB = userService.getById(1L);
        Assertions.assertEquals("jsmith", userDB.getUsername());
        Assertions.assertEquals("jsmith@gmail.com", userDB.getEMail());
        Assertions.assertEquals("ADMIN", userDB.getRole().getRole_name());

        // DeleteUser
        userService.deleteUser(1L);
        User user2 = null;

        try{
            user2 = userService.getById(1L);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Assertions.assertNull(user2);

        // GetAllUsers
        User user3 = new User("jsmith", "jsmith@gmail.com", "123", role, "morning");
        User user4 = new User("troberts", "troberts@gmail.com", "123", role, "evening");
        List<User> users = new ArrayList<>();
        users.add(user3);
        users.add(user4);

        userService.addUser(user3);
        userService.addUser(user4);

        List<User> dbUsers = userService.getAllUsers();
        System.out.println(dbUsers);

        Assertions.assertEquals(users, dbUsers);

        //============================================================================================================
        //                                      TECHSTACK TESTS
        //============================================================================================================

        // AddTechStack
        TechStack techStack = new TechStack(0L,2L, "Java");
        techStackService.addTechStack(techStack);

        TechStack techStackDB = techStackService.getTechStackById(1L);

        Assertions.assertEquals(1L, techStackDB.getId());

        // UpdateTechStack
        TechStack techStack2 = new TechStack(0L,2L, "Spring");
        techStackService.updateTechStack(techStack2, 1L);

        TechStack techStackDB2 = techStackService.getTechStackById(1L);

        Assertions.assertEquals("Spring", techStackDB2.getStack());

        // DeleteTechStack
        techStackService.deleteTechStack(1L);

        TechStack techStackDB3 = null;

        try{
            techStackDB3 = techStackService.getTechStackById(1L);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Assertions.assertNull(techStackDB3);

        // GetAllTechStacks
        TechStack techStack3 = new TechStack(0L, 1L, "Java");
        TechStack techStack4 = new TechStack(0L, 1L, "Angular");
        List<TechStack> stacks = new ArrayList<>();

        stacks.add(techStack3);
        stacks.add(techStack4);

        techStackService.addTechStack(techStack3);
        techStackService.addTechStack(techStack4);

        List<TechStack> dbStacks = techStackService.getAllTechStacks();

        Assertions.assertEquals(2, dbStacks.size());

        //============================================================================================================
        //                                      ROLE TESTS
        //============================================================================================================

        // No test for add--already been done earlier.

        // UpdateRole
        Role role2 = new Role(2L, "MENTORE");
        roleService.addRole(role2);

        Role role3 = new Role(2L, "MENTOR");
        roleService.updateRole(2L, role3);

        Role dbRole = roleService.getRoleById(2L);

        Assertions.assertEquals("MENTOR", dbRole.getRole_name());

        // DeleteRole
        roleService.deleteRole(2L);

        Role dbRole2 = null;

        try {
            dbRole2 = roleService.getRoleById(2L);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Assertions.assertNull(dbRole2);

        // GetAllRoles
        List<Role> dbRoles = roleService.getAllRoles();

        Assertions.assertEquals(1, dbRoles.size());

        //============================================================================================================
        //                                      QUESTION TESTS
        //============================================================================================================

        // AddQuestion
        Question question = new Question(1L, 1L, "Java", "Does anyone know why this isn't working?", "", null, null);
        questionService.addQuestion(question);

        Question dbQuestion = questionService.getQuestionById(1L);

        Assertions.assertEquals("Java", dbQuestion.getLanguage());

        // UpdateQuestion
        Question question2 = new Question(1L, 1L, "Java", "I figured it out. Now I have another problem...?", "", null, null);
        questionService.updateQuestion(question2, 1L);

        Question dbQuestion2 = questionService.getQuestionById(1L);

        Assertions.assertTrue(dbQuestion2.toString().contains("figured it out"));

        // DeleteQuestion
        Question question3 = new Question(2L, 1L, "Java", "I figured it out. Now I have another problem...?", "", null, null);
        questionService.addQuestion(question3);

        questionService.deleteQuestion(2L);

        Question dbQuestion3 = null;

        try{
            dbQuestion3 = questionService.getQuestionById(2L);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        Assertions.assertNull(dbQuestion3);

        // GetAllQuestions
        List<Question> questions = questionService.getAllQuestions();

        Assertions.assertEquals(1, questions.size());

        //============================================================================================================
        //                                      MESSAGE TESTS
        //============================================================================================================

        // AddMessage
        Message message = new Message(1L, "Hello. How are you?", 2L, 3L);
        messageService.addMessage(message);

        Message dbMessage = messageService.getMessageById(1L);

        Assertions.assertTrue(dbMessage.toString().contains("How"));

        // UpdateMessage
        Message message2 = new Message(1L, "I am fine. How are you?", 3L, 2L);
        messageService.updateMessage(message2, 1L);

        Message dbMessage2 = messageService.getMessageById(1L);

        Assertions.assertTrue(dbMessage2.toString().contains("fine. How"));

        // DeleteMessage
        Message message3 = new Message (2L, "Hi", 2L, 3L);
        messageService.addMessage(message3);

        messageService.deleteMessage(2L);

        Message dbMessage3 = null;

        try{
            dbMessage3 = messageService.getMessageById(2L);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        Assertions.assertNull(dbMessage3);

        // GetAllMessages
        List<Message> messages = messageService.getAllMessages();

        Assertions.assertEquals(1, messages.size());

        //============================================================================================================
        //                                      BLOG TESTS
        //============================================================================================================

        // AddBlog
        Blog blog = new Blog(1L, 2L, "A New Day", "I am so happy today!", 0, 0, null, null);
        blogService.addPost(blog);

        Blog dbBlog = blogService.getPostById(1L);

        Assertions.assertTrue(dbBlog.toString().contains(("o happy t")));

        // UpdateBlog
        Blog blog2 = new Blog(1L, 2L, "A New Day", "I'm actually sad.", 0, 0, null, null);

        blogService.updatePost(blog2, 1L);

        Blog dbBlog2 = blogService.getPostById(1L);

        Assertions.assertTrue(dbBlog2.toString().contains(("ly sa")));

        // DeleteBlog
        Blog blog3 = new Blog(2L, 3L, "Tip Of The Day", "Use a fork!", 0, 0, null, null);
        blogService.addPost(blog3);

        blogService.deletePost(2L);

        Blog dbBlog3 = null;

        try {
            dbBlog3 = blogService.getPostById(2L);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Assertions.assertNull(dbBlog3);

        // GetAllBlogs
        List<Blog> blogs = blogService.getAllPosts();

        Assertions.assertEquals(1, blogs.size());

    }
}

