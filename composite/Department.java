import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {
    private List<OrganizationComponent> component = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void add(OrganizationComponent component) {
        this.component.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        this.component.remove(component);
    }

    @Override
    public double getSalary() {
        double totalSalary = 0;
        for (OrganizationComponent comp : component) {
            totalSalary += comp.getSalary();
        }
        return totalSalary;
    }

    @Override
    public String toXml(int indentLevel) {
        StringBuilder xml = new StringBuilder();
        if (indentLevel > 0) {
            xml.append("\n");
            for (int i = 0; i < indentLevel; i++) {
                xml.append("    ");
            }
        }
        xml.append("<department name=\"").append(this.name).append("\">");
        for (OrganizationComponent comp : component) {
            xml.append(comp.toXml(indentLevel + 1));
        }
        xml.append("\n");
        for (int i = 0; i < indentLevel; i++) {
            xml.append("    ");
        }
        xml.append("</department>");
        return xml.toString();
    }
}
