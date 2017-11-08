public class Driver {
    public static void main(String[] args) {
        Member tom = new Member("Tom");
        Member jill = new Member("Jill");
        Member sue = new Member("Sue");
        Leader pres = new Leader("President");
        Leader gov = new Leader("Governor");

        Org usac = new Org("USAC",pres,new Member[]{tom,jill});
        Org test = new Org("Test", gov, new Member[]{tom,sue, jill});

        System.out.print("Members:\n" +tom + "\n\n" + jill +
                "\n\n" + sue );

        System.out.print("\nLeaders:\n" + pres +
                "\n" + gov);

        System.out.print("\nOrg1:\n" + usac +
                "\n\nOrg2:\n" + test);

        usac.addMember(new Member("Ted"));

        System.out.print("\n\nAll of the members in USAC now:\n");
        for(Object member : usac.getMembers()){
            System.out.println(member);
        }
    }
} // Close class