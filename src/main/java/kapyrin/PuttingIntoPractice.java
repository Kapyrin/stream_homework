package kapyrin;

import kapyrin.entity.Trader;
import kapyrin.entity.Transaction;
import kapyrin.logic.StreamLogic;

import java.util.*;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        StreamLogic logic = new StreamLogic();

        //1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        logic.allTransactionsFromYearSortedBySum(transactions, 2011);


        //2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        logic.listOfUniqueCitiesWhereTradersWorks(transactions);

        //3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<Trader> allTradersFromCambridgeSorted = logic.findAllTradersFromCambridgeSorted(transactions);
        System.out.println(allTradersFromCambridgeSorted);


        //4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        String sortedByNames = logic.sortedTradersNames(transactions);
        System.out.println(sortedByNames);

        //5.Выяснить, существует ли хоть один трейдер из Милана.
       logic.existOrNotTraderFromCity(transactions, "Milan");

        //6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        logic.sumOfAllTradersTransactions(transactions);

        //7. Какова максимальная сумма среди всех транзакций?
       logic.maximumTransaction(transactions);


        //8. Найти транзакцию с минимальной суммой.
        logic.minimumTransaction(transactions);
    }


}