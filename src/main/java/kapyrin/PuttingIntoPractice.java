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
        System.out.print("Все транзакции за 2011 год и отсортированные по сумме:");
        logic.allTransactionsFromYearSortedBySum(transactions, 2011);



        //2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        System.out.print("Cписок неповторяющихся городов, в которых работают трейдеры:");
        logic.listOfUniqueCitiesWhereTradersWorks(transactions);

        //3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        System.out.print("Все трейдеры из Кембриджа, отсортированные по именам: ");
        List<Trader> allTradersFromCambridgeSorted = logic.findAllTradersFromCitySorted(transactions, "Cambridge");
        System.out.println(allTradersFromCambridgeSorted);


        //4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        System.out.print("Имена трейдеров, отсортированные в алфавитном порядке ");
        String sortedByNames = logic.sortedTradersNames(transactions);
        System.out.println(sortedByNames);

        //5.Выяснить, существует ли хоть один трейдер из Милана.
        System.out.print("Есть ли трейдеры из Милана?: ");
        logic.existOrNotTraderFromCity(transactions, "Milan");

        //6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        System.out.print("Суммы всех транзакций от трейдеров из Кембриджа: ");
        logic.sumOfAllTradersTransactionsFromCity(transactions, "Cambridge");

        //7. Какова максимальная сумма среди всех транзакций?
        System.out.print("Максимальная сумма среди всех транзакций: ");
        logic.maximumTransaction(transactions);


        //8. Найти транзакцию с минимальной суммой.
        System.out.print("Минимальная сумма среди всех транзакций: ");
        logic.minimumTransaction(transactions);
    }


}