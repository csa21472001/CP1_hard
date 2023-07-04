import java.util.Arrays;

public class EmployeeBook {
    private static int firstUnit = 1;
    private static int lastUnit = 5;
    private Employee[] employees;

    public EmployeeBook() {
        employees = new Employee[10];
        employees[0] = new Employee("Иванов Иван Иванович", 5, 64665);
        employees[1] = new Employee("Николаев Николай Николаевич", 3, 30000.0);
        employees[2] = new Employee("Григорьев Григорий Григорьевич", 4, 39000.0);
        employees[3] = new Employee("Давыдов Давид Давидович", 5, 50000.0);
        employees[4] = new Employee("Ильин Илья Ильич", 4, 40000.0);
        employees[5] = null;
        employees[6] = new Employee("Коновалова Алефтина Патриковна", 1, 50000.0);
        employees[7] = new Employee("Заболотная Таисия Моисеевна", 5, 55000.0);
        employees[8] = new Employee("Молодцов Вячеслав Иннокетьевич", 2, 55000.0);
        employees[9] = new Employee("Федоров Федор Федорович", 2, 55000.0);
    }

    // hard_difficulty
    public int checkForNull(int newUnitOrSalary) {

        if (newUnitOrSalary >= 10 || newUnitOrSalary < 0) {
            throw new IllegalArgumentException("В массиве нет указанного индекса!");
        } else if (employees[newUnitOrSalary] == null) {
            throw new IllegalArgumentException("Пустое поле! Изменить данные невозможно!");
        }
        return newUnitOrSalary;
    }

    public Employee[] getEmployee() {
        return employees;
    }

    public void printItAllByUnit() {
        for (int i = firstUnit; i <= lastUnit; i++) {
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

    public void addContact(String fio, int unit, double salary) {
        int counter = 0;
        Employee addEmployee = new Employee(fio, unit, salary);
        ;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = addEmployee;
                System.out.println("Добавлен новый сотрудник: " + employees[i]);
                break;
            }
            if (employees[i] != null) {
                counter++;
                if (counter >= employees.length) {
                    System.out.println("Нельзя добавить сотрудника, закончилось место");
                }
            }
        }

    }

    public void removeContact(String fio, int id) {
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
    public void printItAll() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }

    public int countItAll() {
        int totalSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                totalSalary += employees[i].getSalary();
            }
        }
        return totalSalary;
    }

    public Employee findMinSalary() {

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

    public Employee findMaxSalary() {
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

    public double countMedium() {
//      //  int totalSalary = countItAll();
        return countItAll() / employees.length;
    }

    // medium_difficulty
    public void indexItUp(double factor, Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() * factor);
            }
        }

    }

    public String findInUnitMinSalary(int unit) {
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

    public Employee findInUnitMaxSalary(int unit) {
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

    public double findInUnitTotalSalary(int unit) {

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

    public double findInUnitMediumSalary(int unit) {

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

    public void indexItInUnit(double factor, int unit) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getUnit() == unit) {
                    employees[i].setSalary(employees[i].getSalary() * factor);
                }
            }
        }
    }

    public void printUnitInfo(int unit) {
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

    public void printEmployeesWithSalaryLowerThan(double wagePoint) {

        System.out.println("Сотрудники с ЗП менее: " + wagePoint);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < wagePoint) {
                    toStringForUnit(employees[i]);
                }
            }
        }
    }

    public void printEmployeesWithSalaryNoLessThan(double wagePoint) {

        System.out.println("Сотрудники с ЗП не менее: " + wagePoint);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() >= wagePoint) {
                    toStringForUnit(employees[i]);
                }
            }
        }
    }

    public void toStringForUnit(Employee employees) {
        System.out.println("Id сотрудника - " + employees.getId() + ". ФИО сотрудника - " + employees.getFio() + ". Зарплата - " + employees.getSalary() + ".");
    }

    public void toStringFio(Employee[] employees) {
        System.out.println("Список работников: ");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFio());
            }
        }
    }

}

