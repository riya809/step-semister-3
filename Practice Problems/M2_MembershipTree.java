public class M2_MembershipTree {

    static class Member {
        String name;
        Member left, right;

        Member(String name) {
            this.name = name;
        }
    }

    static void display(Member root) {
        if (root == null) return;

        display(root.left);
        System.out.println(root.name);
        display(root.right);
    }

    public static void main(String[] args) {
        Member root = new Member("Riya");
        root.left = new Member("Anu");
        root.right = new Member("Neha");

        System.out.println("Members:");
        display(root);
    }
}