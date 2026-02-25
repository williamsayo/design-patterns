public abstract class OrganizationComponent {
    protected String name;
    
    public OrganizationComponent(String name) {
        this.name = name;
    }

    public abstract String getName();
    public abstract void add(OrganizationComponent component);
    public abstract void remove(OrganizationComponent component);
    public abstract double getSalary();
    public abstract String toXml(int indentLevel);
}
