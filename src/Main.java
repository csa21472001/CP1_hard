import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        // hard_level
        EmployeeBook.printItAllByUnit();
        EmployeeBook.removeContact("Ильин Илья Ильич", 5);
        EmployeeBook.addContact("Пригожин Евгений Викторович", 3, 10000000);
//        EmployeeBook.addContact("Пригожин Иосиф Игоревич", 3, 50000000);
        EmployeeBook.removeContact("Пригожин Иосиф Игоревич", 4);
        int indexForSalaryChanges = 5;
        EmployeeBook.getEmployee()[EmployeeBook.checkForNull(indexForSalaryChanges)].setSalary(99999.0);
        int indexForUnitChanges = 6;
        EmployeeBook.getEmployee()[EmployeeBook.checkForNull(indexForUnitChanges)].setUnit(20);
        EmployeeBook.printItAllByUnit();
        //easy_level
        EmployeeBook.printItAll();
        int totalSalary = EmployeeBook.countItAll();
        System.out.println("Сумма всех зарплат за месяц " + totalSalary);
        Employee minSalaryEmployee = EmployeeBook.findMinSalary();
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee.toString());
        Employee maxSalaryEmployee = EmployeeBook.findMaxSalary();
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee.toString());
        double mediumSalary = EmployeeBook.countMedium();
        System.out.println("Средняя зарплата составляет: " + mediumSalary);
        EmployeeBook.toStringFio(EmployeeBook.employees);
        //medium_level
        double factorForAll = 1.05;
        EmployeeBook.indexItUp(factorForAll, EmployeeBook.employees);
        EmployeeBook.printItAll();
        int unitForMin = 4;
        String inUnitMinSalaryFio = EmployeeBook.findInUnitMinSalary(unitForMin);
        System.out.println("Минимальная ЗП отдела " + unitForMin + " у след. сотрудника: " + inUnitMinSalaryFio);
        int unitForMax = 1;
        Employee inUnitMaxSalaryFio = EmployeeBook.findInUnitMaxSalary(unitForMax);
        System.out.println("Максимальная ЗП отдела " + unitForMax + " у след. сотрудника: " + inUnitMaxSalaryFio);
        int unitForTotal = 2;
        double inUnitTotalSalaryFio = EmployeeBook.findInUnitTotalSalary(unitForTotal);
        System.out.println("Общая ЗП отдела " + unitForTotal + " составляет: " + inUnitTotalSalaryFio);
        int unitForMedium = 3;
        double inUnitMediumSalaryFio = EmployeeBook.findInUnitMediumSalary(unitForMedium);
        System.out.println("Средняя ЗП отдела " + unitForMedium + " составляет: " + inUnitMediumSalaryFio);
        double factor = 1.07;
        int unitWithIndexation = 4;
        EmployeeBook.indexItInUnit(factor, unitWithIndexation);
        int unitForPrint = 4;
        EmployeeBook.printUnitInfo(unitForPrint);
        double salaryLessThan = 17000.0;
        EmployeeBook.printEmployeesWithSalaryLowerThan(salaryLessThan);
        double salaryNoLessThan = 34000.0;
        EmployeeBook.printEmployeesWithSalaryNoLessThan(salaryNoLessThan);


    }


}

