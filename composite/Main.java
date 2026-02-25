class Main {
public static void main(String[] args) {
    OrganizationComponent emp1 = new Employee("John", 500);
    OrganizationComponent emp2 = new Employee("Jane", 500);
    OrganizationComponent emp3 = new Employee("Bob", 600);

    OrganizationComponent dept1 = new Department("IT");
    dept1.add(emp1);
    dept1.add(emp2);

    OrganizationComponent dept2 = new Department("HR");
    dept2.add(emp3);

    Organization company = new Organization("Tech Company");
    company.add(new Employee("Alice", 700));
    company.add(dept1);
    company.add(dept2);

    System.out.println(company.getSalary());
    company.printXml();
}
}