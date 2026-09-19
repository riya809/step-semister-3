import java.util.Arrays;

public class M3_PremiumLoyaltyDiscount {

    static class GymMember {

        private int[] lateFeeHistory = new int[10];
        private int feeCount = 0;
        private int totalLateFees = 0;

        protected void chargeLateFee(int amount) {

            totalLateFees += amount;
            lateFeeHistory[feeCount] = amount;
            feeCount++;
        }

        int[] getLateFeeHistory() {
            return Arrays.copyOf(lateFeeHistory, feeCount);
        }

        int getTotalLateFees() {
            return totalLateFees;
        }
    }

    static class PremiumMember extends GymMember {

        @Override
        protected void chargeLateFee(int amount) {
            super.chargeLateFee(amount / 2);
        }
    }

    public static void main(String[] args) {

        PremiumMember p = new PremiumMember();

        p.chargeLateFee(200);

        System.out.println(
            "Total Late Fees: " + p.getTotalLateFees()
        );

        int[] history = p.getLateFeeHistory();

        history[0] = 999;

        System.out.println(
            "Actual History: " +
            Arrays.toString(p.getLateFeeHistory())
        );
    }
}