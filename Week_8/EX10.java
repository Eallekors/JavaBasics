package Week_8;

public class EX10 {

    public static void main(String[] args) {

        NationalService civilService = new CivilService();
        System.out.println("Civil Service days left: " + civilService.getDaysLeft());
        civilService.work();
        System.out.println("Civil Service days left after work: " + civilService.getDaysLeft());


        NationalService militaryService = new MilitaryService(500);
        System.out.println("Military Service days left: " + militaryService.getDaysLeft());
        militaryService.work();
        System.out.println("Military Service days left after work: " + militaryService.getDaysLeft());
    }
}

