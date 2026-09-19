public class M3_StudentDiscountFineLedger {

    static class Student {
        String name;
        double fine;

        Student(String name, double fine) {
            this.name = name;
            this.fine = fine;
        }

        final double calculateDiscount() {
            return fine * 0.10;
        }

        void display() {
            double discount = calculateDiscount();
            System.out.println("Student: " + name);
            System.out.println("Fine: " + fine);
            System.out.println("Discount: " + discount);
            System.out.println("Final Fine: " + (fine - discount));
        }
    }

    public static void main(String[] args) {
        Student s = new Student("Riya", 500);
        s.display();
    }
}