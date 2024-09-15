package com.city.mode;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public class Annotations {



    //This annotation is used to make the class as Sping boot main application

   // @SpringBootApplication
    //It combines 3 annotations inside

// @SpringBootApplication=@Configuration+@EnableCOnfiguration+@ComponentScan

    //@Configuration-->It indicates that the class contains spring bean efinations
    //@EnableCOnfiguration-->Automatic   configuration based on project dependencies
    //@ComponentScan-->Scans the specified package for spring components

    //-------------------------------------

    //@RestController=@Controller+@ResponseBody
    //Use to make a class as controller

    //---------------------------------------
    //@RequestMapping
    //Maps HHTP request to the handler methods controller or restcontroller classes


    //@AutoWired
    //Autowires beans by type in spring boot application
    //User to inject dependecnies into spring managed beans

    //@Service
   //Idicates class is a servcei bean in service layer of the applcation
    //Typically used to define bussiness logic

    //@Repository
    //make a class as a repositoy i the persistance layer
    //handles databse operations suhc as crud operation

    //@Component
    //USed when specific steroitype  annotation like @servcei and @repository is not approprite


    //@Configuration
        //Service request to the bean classes at runtime









}
