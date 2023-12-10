public class Employee {
    static private int counter = 1;
    private double salary;
    private String fio;
    private int unit;
    private int id;

    public Employee(String fio, int unit, double salary) {
        this.fio = fio;
        this.unit = unit;
        this.salary = salary;
        this.id = counter;
        counter++;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public String getFio() {
        return fio;
    }

    public int getUnit() {
        return unit;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("Ошибка!!! ЗП не может быть отрицательной!");
            return;
        }
        this.salary = salary;
    }

    public void setUnit(int unit) {
        if (unit > 5 || unit < 1) {
            System.out.println("Ошибка!!! Номер отдела от 1 до 5!");
            return;
        }
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Id сотрудника - " + this.id + ". ФИО сотрудника - " + this.fio + ". Номер отдела - " + this.unit + ". Зарплата - " + this.salary + ".";
    }

}

