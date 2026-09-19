public class M5_MembershipAudit {

    static class Member {
        String name;
        boolean active;

        Member(String name, boolean active) {
            this.name = name;
            this.active = active;
        }

        final void audit() {
            if (active)
                System.out.println(name + " - Active Membership");
            else
                System.out.println(name + " - Inactive Membership");
        }
    }

    public static void main(String[] args) {
        Member m1 = new Member("Riya", true);
        Member m2 = new Member("Anu", false);

        m1.audit();
        m2.audit();
    }
}