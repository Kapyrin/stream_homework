package kapyrin.logic;

import kapyrin.entity.Trader;
import kapyrin.entity.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class StreamLogic {

    public void allTransactionsFromYearSortedBySum(List<Transaction> transactions, int year) {
        List<Transaction> trForYear = transactions.stream()
                .filter(t -> t.getYear() == year)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(trForYear);
    }

    public void listOfUniqueCitiesWhereTradersWorks(List<Transaction> transactions) {
        List<String> uniqueCities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueCities);
    }

    public List<Trader> findAllTradersFromCambridgeSorted(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().contains("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());
    }

    public String sortedTradersNames(List<Transaction> transactions) {
        String sortedTradersName = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining("\n"));
        return sortedTradersName;
    }

    public void existOrNotTraderFromCity(List<Transaction> transactions, String city) {
        String existTraderFromMilan = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().contains(city)) ? "yes" : "no";
        System.out.println(existTraderFromMilan);
    }

    public void sumOfAllTradersTransactions(List<Transaction> transactions) {
        int sumOfAllTransactions = transactions.stream()
                .filter(t -> t.getTrader().getCity().contains("Cambridge"))
                .mapToInt(Transaction::getValue)
                .sum();
        System.out.println(sumOfAllTransactions);
    }

    public void maximumTransaction(List<Transaction> transactions) {
        OptionalInt maxSumFromAllTransactions = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();
        System.out.println(maxSumFromAllTransactions.getAsInt());
    }

    public void minimumTransaction(List<Transaction> transactions) {
        OptionalInt minimumSum = transactions.stream()
                .mapToInt(Transaction::getValue)
                .min();
        System.out.println(minimumSum.getAsInt());
    }


}
