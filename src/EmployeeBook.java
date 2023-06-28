public class EmployeeBook {
    public static Employee[] employees = {
            new Employee("Иванов Иван Иванович", 5, 64665),
            new Employee("Николаев Николай Николаевич", 3, 30000.0),
            new Employee("Григорьев Григорий Григорьевич", 4, 39000.0),
            new Employee("Давыдов Давид Давидович", 5, 50000.0),
            new Employee("Ильин Илья Ильич", 4, 40000.0),
            null,
            new Employee("Коновалова Алефтина Патриковна", 1, 50000.0),
            new Employee("Заболотная Таисия Моисеевна", 5, 55000.0),
            new Employee("Молодцов Вячеслав Иннокетьевич", 2, 55000.0),
            new Employee("Федоров Федор Федорович", 2, 55000.0),
    };

    // hard_difficulty
    public static int checkForNull(int newUnitOrSalary) {

        if (employees[newUnitOrSalary] == null) {
            throw new IllegalArgumentException("Пустое поле! Изменить данные невозможно!");
        }
        return newUnitOrSalary;
    }

    public static Employee[] getEmployee() {
        Employee[] workers = new Employee[employees.length];
        for (int i = 0; i < employees.length; i++) {
            workers[i] = employees[i];
        }
        return workers;
    }

    public static void printItAllByUnit() {
        for (int i = 1; i <= 5; i++) {
            System.out.printf("Сотрудники отдела №%d:\n", i);
            for (int x = 0; x < employees.length; x++) {
                if (employees[x] == null) {
                    continue;
                } else if (employees[x].getUnit() == i) {
                    System.out.println(employees[x]);
                }
            }
        }
        System.out.println();
    }

    public static void addContact(String fio, int unit, double salary) {
        int counter = 0;
        Employee addEmployee;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                addEmployee = new Employee(fio, unit, salary);
                employees[i] = addEmployee;
                System.out.println("Добавлен новый сотрудник: " + employees[i]);
                break;
            }
            if (employees[i] != null) {
                counter++;
                if (counter >= 10) {
                    System.out.println("Нельзя добавить сотрудника, закончилось место");
                    break;
                }
            }
        }

    }

    public static void removeContact(String fio, int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && fio != null) {
                if (employees[i].getFio().equals(fio) && employees[i].getId() == id) {
                    System.out.println(employees[i].getFio() + " сотрудник удален");
                    employees[i] = null;
                    return;
                }
            }
        }
        System.out.println("Нет сотрудника c таким именем и id: " + fio + " " + id);
    }

    // easy_difficulty
    public static void printItAll() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }

    public static int countItAll() {
        int totalSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                totalSalary += employees[i].getSalary();
            }
        }
        return totalSalary;
    }

    public static Employee findMinSalary() {

        Employee minSalaryMan = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (minSalaryMan.getSalary() > employees[i].getSalary()) {
                    minSalaryMan = employees[i];
                }
            }
        }
        return minSalaryMan;
    }

    public static Employee findMaxSalary() {
        Employee maxSalaryMan = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (maxSalaryMan.getSalary() < employees[i].getSalary()) {
                    maxSalaryMan = employees[i];
                }
            }
        }
        return maxSalaryMan;
    }

    public static double countMedium() {
//      //  int totalSalary = countItAll();
        return countItAll() / employees.length;
    }

    // medium_difficulty
    public static void indexItUp(double factor, Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() * factor);
            }
        }

    }

    public static String findInUnitMinSalary(int unit) {
//      int unit = ThreadLocalRandom.current().nextInt(0, 150 + 1)

        int count = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getUnit() == unit) {
                    count++;
                }
            }
        }
        Employee[] workers = new Employee[count];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getUnit() == unit) {
                    workers[count - 1] = employees[i];
                    count--;
                }
            }
        }
        Employee minSalaryMan = workers[0];
        for (int i = 0; i < workers.length; i++) {
            if (employees[i] != null) {
                if (minSalaryMan.getSalary() > workers[i].getSalary()) {
                    minSalaryMan = workers[i];
                }
            }
        }
        return minSalaryMan.getFio();

    }

    public static Employee findInUnitMaxSalary(int unit) {
        Employee maxSalaryMan = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getUnit() == unit) {
                    if (maxSalaryMan.getSalary() < employees[i].getSalary()) {
                        maxSalaryMan = employees[i];
                    }
                }
            }
        }
        return maxSalaryMan;
    }

    public static double findInUnitTotalSalary(int unit) {

        double totalForUnitSalary = 0.0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getUnit() == unit) {
                    totalForUnitSalary += employees[i].getSalary();
                }
            }
        }
        return totalForUnitSalary;
    }

    public static double findInUnitMediumSalary(int unit) {

        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getUnit() == unit) {
                    count++;
                }
            }
        }
        return findInUnitTotalSalary(unit) / count;
    }

    public static void indexItInUnit(double factor, int unit) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getUnit() == unit) {
                    employees[i].setSalary(employees[i].getSalary() * factor);
                }
            }
        }
    }

    public static void printUnitInfo(int unit) {
        Employee workers = null;
        System.out.printf("Сотрудники отдела: %d\n", unit);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getUnit() == unit) {
                    workers = employees[i];
                    toStringForUnit(workers);
                }
            }
        }
    }

    public static void printEmployeesWithSalaryLowerThan(double wagePoint) {

        System.out.println("Сотрудники с ЗП менее: " + wagePoint);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < wagePoint) {
                    toStringForUnit(employees[i]);
                }
            }
        }
    }

    public static void printEmployeesWithSalaryNoLessThan(double wagePoint) {

        System.out.println("Сотрудники с ЗП не менее: " + wagePoint);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() >= wagePoint) {
                    toStringForUnit(employees[i]);
                }
            }
        }
    }

    public static void toStringForUnit(Employee employees) {
        System.out.println("Id сотрудника - " + employees.getId() + ". ФИО сотрудника - " + employees.getFio() + ". Зарплата - " + employees.getSalary() + ".");
    }

    public static void toStringFio(Employee[] employees) {
        System.out.println("Список работников: ");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFio());
            }
        }
    }
}
