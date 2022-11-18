package com.taghandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.DynamicAttributes;
import jakarta.servlet.jsp.tagext.TagSupport;

public class ClassicTagHandlerSelect extends TagSupport implements DynamicAttributes {

    private static final String ATTR_TEMPLATE = "%s='%s'";
    private static final String OPTION_TEMPLATE = "<option value='%1$s'>%1$s</option>";
    private String name;
    private List<String> optionsList = new ArrayList<>();
    private Map<String, Object> tagAttrs = new HashMap<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setOptionsList(List<String> optionsList) {
        this.optionsList = optionsList;
    }

    public void setTagAttrs(Map<String, Object> tagAttrs) {
        this.tagAttrs = tagAttrs;
    }

    @Override
    public int doEndTag() throws JspException {

        return EVAL_PAGE;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            // start the html <select> tag
            out.print("<select ");
            // add mandatory attribute
            out.print(String.format(ATTR_TEMPLATE, "name", this.name));
            // add dynamic attributes
            for (String attrName : tagAttrs.keySet()) {
                String attrDefinition = String.format(ATTR_TEMPLATE, attrName, tagAttrs.get(attrName));
                out.print(attrDefinition);
            }
            out.print(">");
            // generate the option tag from optionList
            for (String option : optionsList) {
                String optionTag = String.format(OPTION_TEMPLATE, option);
                out.println(optionTag);
            }

            // end of html select tag
            out.println("</select>");

        } catch (IOException e) {
            throw new JspException("IOException - " + e.toString());
        }

        return SKIP_BODY;
    }

    @Override
    public void setDynamicAttribute(String uri, String name, Object value) throws JspException {
        tagAttrs.put(name, value);

    }

}
