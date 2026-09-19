public class M1_MovieTicketFieldVisibilityChecker {

    static class MovieTicket {
        private String seatNumber;
        String screenId;
        protected double ticketPrice;
        public String movieTitle;
    }

    static class AccessChecker {

        static String classifyAccess(String fieldModifier, String accessorContext) {

            if (accessorContext.equals("SAME_CLASS")) {
                return "ALLOWED";
            }

            if (accessorContext.equals("SAME_PACKAGE")) {
                if (fieldModifier.equals("private")) {
                    return "DENIED";
                } else {
                    return "ALLOWED";
                }
            }

            if (accessorContext.equals("DIFFERENT_PACKAGE")) {
                if (fieldModifier.equals("public")) {
                    return "ALLOWED";
                } else {
                    return "DENIED";
                }
            }

            return "DENIED";
        }

        static String summarizeBatch(String[][] attempts) {

            int allowed = 0;
            int denied = 0;

            for (String[] attempt : attempts) {

                String result = classifyAccess(
                        attempt[0],
                        attempt[1]
                );

                if (result.equals("ALLOWED")) {
                    allowed++;
                } else {
                    denied++;
                }
            }

            return "Allowed: " + allowed + " | Denied: " + denied;
        }
    }

    public static void main(String[] args) {

        System.out.println(
                AccessChecker.classifyAccess(
                        "private",
                        "SAME_CLASS"
                )
        );

        System.out.println(
                AccessChecker.classifyAccess(
                        "protected",
                        "DIFFERENT_PACKAGE"
                )
        );

        String[][] attempts = {
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(
                AccessChecker.summarizeBatch(attempts)
        );
    }
}
