package by.epam.task.model.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalDateTime;

public class CustomTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
       getJspContext().getOut().print("qeqeq");
    }
}

