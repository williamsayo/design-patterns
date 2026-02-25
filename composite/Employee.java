public class Employee extends OrganizationComponent {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot add to an employee.");
    }

    @Override
    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot remove from an employee.");
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toXml(int indentLevel) {
        StringBuilder indent = new StringBuilder();
        indent.append("\n");
        for (int i = 0; i < indentLevel; i++) {
            indent.append("    ");
        }
        return indent.toString() + "<employee name=\"" + this.name + "\" salary=\"" + this.salary + "\"/>";
    }
}
