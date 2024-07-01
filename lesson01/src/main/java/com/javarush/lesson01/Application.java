package com.javarush.lesson01;
import com.javarush.lesson01.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
//        После добавления в pom dependency spring-core, -context закоменнтированное больше не требуется spring все создает автоматом
//        работает реализация интерфейса ApplicationContext (ClassPathXmlApplicationContext)
//        Config config = new Config();
//        UserRepo userRepo = new UserRepo(config);
//        UserService userService = new UserService(userRepo);
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService);
    }
}
