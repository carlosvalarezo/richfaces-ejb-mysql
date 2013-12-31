package demo;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Size;

@ManagedBean
public class UserBean {

    public List<String> autocomplete(String prefix) {

        ArrayList<String> result = new ArrayList<String>();
        result.add("England");
        result.add("France");
        result.add("Germany");
        result.add("Italy");
        result.add("Spain");

        return result;
    }

    @Size(min=3, max=12,message="Must be between 3 and 12 chars")
    private String name;

    private String state;

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }

	public void setName(String name) {
		this.name = name;
	}

	public void setState(String state) {
		this.state = state;
	}

}
