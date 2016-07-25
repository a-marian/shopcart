package shopcart.form;

import org.apache.struts.action.ActionForm;

public class AjaxForm extends ActionForm {
    private static final long serialVersionUID = 7403728678369985647L;

    private String name = null;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

