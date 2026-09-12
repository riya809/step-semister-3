public class M5_CanteenPaymentDispatch {

    static double totalCollected = 0;

    // Parent class
    static class Payment {

        public void pay(double amount) {
            System.out.println(
                "Paid (cash): Rs " + amount
            );
        }
    }

    // Child class
    static class CardPayment extends Payment {

        public void payWithProcessingFee(double amount) {

            double total = amount + (amount * 0.02);

            System.out.println(
                "Charged (card, incl. fee): Rs " + total
            );

            totalCollected = totalCollected + total;
        }
    }

    // Process transaction
    public static void processTransaction(
        Payment payment,
        double amount
    ) {

        if (payment instanceof CardPayment) {

            CardPayment cardPayment =
                (CardPayment) payment;

            cardPayment.payWithProcessingFee(amount);

        } else {

            payment.pay(amount);

            totalCollected = totalCollected + amount;
        }
    }

    public static void main(String[] args) {

        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {
            100,
            50,
            200,
            75,
            120
        };

        // Process all transactions
        for (int i = 0; i < payments.length; i++) {

            processTransaction(
                payments[i],
                amounts[i]
            );
        }

        System.out.println(
            "Total Collected: Rs " + totalCollected
        );
    }
}
