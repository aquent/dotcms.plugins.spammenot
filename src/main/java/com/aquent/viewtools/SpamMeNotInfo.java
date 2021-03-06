package com.aquent.viewtools;

import org.apache.velocity.tools.view.context.ViewContext;
import org.apache.velocity.tools.view.servlet.ServletToolInfo;

/**
 * SpamMeNot Viewtool Info Class.
 * @author cfalzone
 */
public class SpamMeNotInfo extends ServletToolInfo {

    @Override
    public String getKey() {
        return "spammenot";
    }

    @Override
    public String getScope() {
        return ViewContext.APPLICATION;
    }

    @Override
    public String getClassname() {
        return SpamMeNot.class.getName();
    }

    @Override
    public Object getInstance(Object initData) {

        SpamMeNot viewTool = new SpamMeNot();
        viewTool.init(initData);

        setScope(ViewContext.APPLICATION);

        return viewTool;
    }

}
