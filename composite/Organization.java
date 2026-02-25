public class Organization extends OrganizationComponent {
    private Department organization;

    public Organization(String name) {
        super(name);
        this.organization = new Department(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void add(OrganizationComponent component) {
        this.organization.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        this.organization.remove(component);
    }

    @Override
    public double getSalary() {
        return this.organization.getSalary();
    }

    @Override
    public String toXml(int indentLevel) {
        return this.organization.toXml(indentLevel);
    }

    public void printXml() {
        System.out.println(this.toXml(0));
    }
}