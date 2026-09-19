public class M1_GymMembershipFoundation {

    static class GymMember {
        String memberId;
        int monthlyFee;
        int sessionsAttended;

        public GymMember(String memberId, int monthlyFee) {
            if (memberId == null || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("Invalid member ID");
            }

            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
        }

        void attendSession() {
            sessionsAttended++;
        }

        int getSessionsAttended() {
            return sessionsAttended;
        }

        void displayInfo() {
            System.out.println("Standard Member | Sessions: " + sessionsAttended);
        }

        static String signUpBatch(String[] memberIds, int monthlyFee) {
            int signedUp = 0;
            int rejected = 0;

            for (String id : memberIds) {
                try {
                    new GymMember(id, monthlyFee);
                    signedUp++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }

            return "Signed Up: " + signedUp + " | Rejected: " + rejected;
        }
    }

    static class PremiumMember extends GymMember {
        String trainerName;

        public PremiumMember(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }

        @Override
        void displayInfo() {
            System.out.println(
                "Premium Member | Trainer: " + trainerName +
                " | Sessions: " + sessionsAttended
            );
        }
    }

    public static void main(String[] args) {

        PremiumMember p =
            new PremiumMember("MEM01", 2000, "Coach Riya");

        p.attendSession();
        p.attendSession();

        p.displayInfo();

        String result = GymMember.signUpBatch(
            new String[]{"MEM1", "GM1", "MEM2", " ", "MEM3"},
            1000
        );

        System.out.println(result);
    }
}