public class M1_LibraryMembershipFoundation {

    static class Member {
        String name;
        int memberId;

        Member(String name, int memberId) {
            this.name = name;
            this.memberId = memberId;
        }

        void display() {
            System.out.println("Name: " + name);
            System.out.println("Member ID: " + memberId);
        }
    }

    public static void main(String[] args) {
        Member m = new Member("Riya", 101);
        m.display();
    }
}