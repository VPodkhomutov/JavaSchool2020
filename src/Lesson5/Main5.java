package Lesson5;

import java.util.ArrayList;
import java.util.List;

public class Main5 {
    public static void main(String[] args) {
        ClientShopper cs1 = new ClientShopper("Ivan", 1);
        Client c1 = new Client(); c1.setName("Petr");
        ClientIdentifiable ci1 = new ClientIdentifiable("Vasiliy", 2);


        List<Client> fullClient = new ArrayList<>();
        fullClient.add(c1);
        fullClient.add(cs1);
        fullClient.add(ci1);
        /*--3---*/
        Person p1 = new Person();
        p1.setName("Ivan");
        Person p3 = new Person();
        p3.setName("Slava");
        Person p2 = new Person();
        p2.setName("Maksim");
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(p1);
        listPerson.add(p2);
        listPerson.add(p3);
        GenInterfImpl person = new GenInterfImpl();
        System.out.println(person.maxximum(listPerson).getName());
        /*
        List<KooTeam> listKoo = new ArrayList<>();
        listKoo.add(new KooTeam("Artem","Vologda"));
        listKoo.add(new KooTeam("Andrey","Moscow"));
        listKoo.add(new KooTeam("Valya","Peterburg"));
        GenInterfImpl koo = new GenInterfImpl();
        System.out.println(koo.maxximum(listKoo).getName());*/
    }



    public static void fullClientShow(List<? extends Client> fcl){
        System.out.println(fcl);
    }

    public static void twoClientShow(List<? super ClientIdentifiable> tcl){
        System.out.println(tcl);
    }
}
