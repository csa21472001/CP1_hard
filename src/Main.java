public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        // hard_level
        employeeBook.printItAllByUnit();
        employeeBook.removeContact("Ильин Илья Ильич", 5);
        employeeBook.addContact("Пригожин Евгений Викторович", 3, 10000000);
        employeeBook.removeContact("Пригожин Иосиф Игоревич", 4);
        int indexForSalaryChanges = 6;
        employeeBook.getEmployee()[employeeBook.checkForNull(indexForSalaryChanges)].setSalary(99999.0);
        int indexForUnitChanges = 5;
        employeeBook.getEmployee()[employeeBook.checkForNull(indexForUnitChanges)].setUnit(20);
        employeeBook.printItAllByUnit();
        //easy_level
        employeeBook.printItAll();
        int totalSalary = employeeBook.countItAll();
        System.out.println("Сумма всех зарплат за месяц " + totalSalary);
        Employee minSalaryEmployee = employeeBook.findMinSalary();
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee.toString());
        Employee maxSalaryEmployee = employeeBook.findMaxSalary();
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee.toString());
        double mediumSalary = employeeBook.countMedium();
        System.out.println("Средняя зарплата составляет: " + mediumSalary);
        employeeBook.toStringFio(employeeBook.getEmployee());
        //medium_level
        double factorForAll = 1.05;
        employeeBook.indexItUp(factorForAll, employeeBook.getEmployee());
        employeeBook.printItAll();
        int unitForMin = 4;
        String inUnitMinSalaryFio = employeeBook.findInUnitMinSalary(unitForMin);
        System.out.println("Минимальная ЗП отдела " + unitForMin + " у след. сотрудника: " + inUnitMinSalaryFio);
        int unitForMax = 1;
        Employee inUnitMaxSalaryFio = employeeBook.findInUnitMaxSalary(unitForMax);
        System.out.println("Максимальная ЗП отдела " + unitForMax + " у след. сотрудника: " + inUnitMaxSalaryFio);
        int unitForTotal = 2;
        double inUnitTotalSalaryFio = employeeBook.findInUnitTotalSalary(unitForTotal);
        System.out.println("Общая ЗП отдела " + unitForTotal + " составляет: " + inUnitTotalSalaryFio);
        int unitForMedium = 3;
        double inUnitMediumSalaryFio = employeeBook.findInUnitMediumSalary(unitForMedium);
        System.out.println("Средняя ЗП отдела " + unitForMedium + " составляет: " + inUnitMediumSalaryFio);
        double factor = 1.07;
        int unitWithIndexation = 4;
        employeeBook.indexItInUnit(factor, unitWithIndexation);
        int unitForPrint = 4;
        employeeBook.printUnitInfo(unitForPrint);
        double salaryLessThan = 17000.0;
        employeeBook.printEmployeesWithSalaryLowerThan(salaryLessThan);
        double salaryNoLessThan = 34000.0;
        employeeBook.printEmployeesWithSalaryNoLessThan(salaryNoLessThan);

    }


}

