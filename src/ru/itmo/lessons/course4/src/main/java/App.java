import Entity.Climber;
import Entity.Group;
import Entity.Mountain;
import Entity.MountainPK;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        Climber andrey = new Climber();
        andrey.setName("Andrey");
        andrey.setAddress("SPB");

        Climber valera = new Climber();
        valera.setName("Valera");
        valera.setAddress("SPB");

        Climber ivan = new Climber();
        ivan.setName("Ivan");
        ivan.setAddress("SPB");

        Climber nastia = new Climber();
        nastia.setName("Nastia");
        nastia.setAddress("SPB");

        Group group1 = new Group();

        group1.addClimber(andrey, valera);

        Group group2 = new Group();

        group2.addClimber(nastia, ivan);

        Mountain monBlanch = new Mountain();

        monBlanch.setHeight(100);

        monBlanch.setMountainPK("Mon Blanch", "France");

        group1.chooseMountain(monBlanch);

        group2.chooseMountain(monBlanch);

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("Course 4");

        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(andrey);
        manager.persist(valera);
        manager.persist(ivan);
        manager.persist(nastia);
        manager.persist(group1);
        manager.persist(group2);
        manager.persist(monBlanch);
        manager.getTransaction().commit();



/*        System.out.println(andrey);
        System.out.println(monBlanch);
        System.out.println(group1);*/

        manager.getTransaction().begin();
        System.out.println(manager.find(Climber.class, 1));
        System.out.println(manager.find(Group.class,1));
        System.out.println(manager.find(Mountain.class, new MountainPK("Mon Blanch", "France")));
        manager.getTransaction().commit();


        factory.close();

    }
}
