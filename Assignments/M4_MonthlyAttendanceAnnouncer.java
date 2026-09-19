public class M4_MonthlyAttendanceAnnouncer {

    static class GymMember {
        int sessionsAttended;

        void attendSession() {
            sessionsAttended++;
        }

        int getSessionsAttended() {
            return sessionsAttended;
        }

        void displayInfo(StringBuilder result) {
            result.append(
                "Standard | Sessions: "
            ).append(sessionsAttended).append(" | ");
        }
    }

    static class PremiumMember extends GymMember {

        String trainerName;

        PremiumMember(String trainerName) {
            this.trainerName = trainerName;
        }

        @Override
        void displayInfo(StringBuilder result) {
            result.append(
                "Premium | Trainer: "
            ).append(trainerName)
             .append(" | Sessions: ")
             .append(sessionsAttended)
             .append(" | ");
        }
    }

    static String batchPrint(GymMember[] members) {

        StringBuilder result = new StringBuilder();

        for (GymMember member : members) {

            member.displayInfo(result);

            if (member instanceof PremiumMember) {

                PremiumMember premium =
                    (PremiumMember) member;

                result.append(
                    "[Trainer via downcast: "
                ).append(premium.trainerName)
                 .append("] | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        GymMember standard = new GymMember();

        PremiumMember premium =
            new PremiumMember("Coach Riya");

        premium.attendSession();

        GymMember[] members = {
            standard,
            premium
        };

        System.out.println(batchPrint(members));
    }
}