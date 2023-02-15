/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adarsh K
 */
import java.util.Arrays;

public class VendingMachine {

    public static int[] getChange(int amount, int[] denominations, int[] availableCoins) {
        int[] result = new int[denominations.length];
        int remainingAmount = amount;

        for (int i = denominations.length - 1; i >= 0; i--) {
            int denomination = denominations[i];
            int maxCoins = Math.min(availableCoins[i], remainingAmount / denomination);
            result[i] = maxCoins;
            remainingAmount -= maxCoins * denomination;
        }

        if (remainingAmount > 0) {
            throw new IllegalArgumentException("Cannot make change for the given amount with the available coins.");
        }

        return result;
    }

    public static void main(String[] args) {
        int[] britishPoundDenominations = {1, 2, 5, 10, 20, 50};
        int[] usDollarDenominations = {1, 5, 10, 25};
        int[] norwegianKroneDenominations = {1, 5, 10, 20};

        int[] denominations = britishPoundDenominations;
        int[] availableCoins = {100, 100, 100, 100, 100, 100}; // Assuming 100 coins of each denomination are available

        int amount = 43;
        int[] change = getChange(amount, denominations, availableCoins);

        System.out.println("Change for " + amount + " using " + Arrays.toString(denominations) + ": " + Arrays.toString(change));
    }
}

