public class M4_WeeklyCirculationReport {

    static class Report {
        String week;
        int issued;
        int returned;

        Report(String week, int issued, int returned) {
            this.week = week;
            this.issued = issued;
            this.returned = returned;
        }

        void display() {
            System.out.println("Week: " + week);
            System.out.println("Books Issued: " + issued);
            System.out.println("Books Returned: " + returned);
            System.out.println("Pending: " + (issued - returned));
        }
    }

    public static void main(String[] args) {
        Report r = new Report("Week 1", 120, 100);
        r.display();
    }
}