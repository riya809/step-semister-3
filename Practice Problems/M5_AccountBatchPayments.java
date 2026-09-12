public class M5_AccountBatchPayments {

    static class FeeAccount {
        String accountType;

        public FeeAccount(String accountType) {
            this.accountType = accountType;
        }
    }

    static class HostelFeeAccount extends FeeAccount {

        public HostelFeeAccount(String accountType) {
            super(accountType);
        }
    }

    static int hostelCount = 0;
    static int dayScholarCount = 0;

    public static void processPayment(
        FeeAccount account,
        double amount
    ) {

        if (account instanceof HostelFeeAccount) {

            System.out.println(
                "Paid in two installments (hostel account)"
            );

            hostelCount++;

        } else {

            System.out.println(
                "Paid in one go (day-scholar account)"
            );

            dayScholarCount++;
        }
    }

    public static void main(String[] args) {

        FeeAccount[] accounts = {
            new HostelFeeAccount("Hostel"),
            new HostelFeeAccount("Hostel"),
            new FeeAccount("FeeAccount"),
            new FeeAccount("FeeAccount")
        };

        double amount = 60000;

        for (int i = 0; i < accounts.length; i++) {
            processPayment(accounts[i], amount);
        }

        System.out.println(
            "Hostel accounts processed: " + hostelCount
            + " | Day-scholar accounts processed: "
            + dayScholarCount
        );
    }
}
