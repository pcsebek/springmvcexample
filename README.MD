Steps for converting a Struts 1.x.x application to Spring MVC
1) Replace references to Struts with Spring in POM
    -- spring-core
    -- spring-context       : may already be in use by project
    -- spring-beans         : may already be in use by project
    -- spring-webmvc
    -- hibernate-validator  : needed for annotations.  may already be in use
2) Add Apache tiles to POM.  Not 100% sure which ones are truely needed.
    -- tiles-core
    -- tiles-jsp
    -- tiles-servlet
    -- tiles-template
    -- tiles-el
    -- tiles-extras
    -- tiles-compat
3) Modify web.xml to look for the servlet.xml configuration file
    -- servlet name in the servlet tag points to the servlet name in 
       the servlet mapping which points to a file prefixed with the
       the servlet name "-servlet.xml"
        -- example
            <servlet>
                <servlet-name>foo</servlet-name>
                <servlet-class>some class</servlet-class>
                <load-on-startup>1</load-on-startup>
            </servlet>
            <servlet-mapping>
                <servlet-name>foo</servlet-name>
                <url-pattern>/*</url-pattern>
            </servlet-mapping>
            Under folder WEB-INF there needs to be a file foo-servlet.xml
4) Convert ActionForm classes to POJOs.   
    -- Remove references to Struts ActionForm.
    -- POJOs are passed around as Model Atrtibutes between JSPs and 
    Controller classes.
    -- Commons Validator is not JSR-303/JSR349 compliant so replace with Hibernate Validator
    which is the default implementation Spring looks for.  The only other option is Apache Bean Validator
    (bval.apache.org).  Since Hibernate is used for data persistence it makes sense to use 
    Hibernate Validator.
5) Convert Action classes to Controller classes
    -- Remove refrences to Struts Action
    -- Add @Controller annotation to the class.
    -- Add @RequestMapping to class and/or public methods.
    -- Remove references to ActionForward, ActionMapping, ActionForm,etc
    -- Modify method signature based on Spring documentation.  This can
    be different for each method based on what the method is doing.
    -- input submit passes 'name' attribute as 'params' in the @RequestMapping so each button can be mapped
    to different public functions within one Controller class.


Known Issues
-- Using validation annotations like @NotNull allow you to override the default message however you cannot
pass a parameter into the message like Commons Validator allowed.  Also Hibernate Validator does not have
the ability to configure validation rules like Common Validator so custome validation routines will need
to be written if MessageInterpolation can be understood and modified so that a key passed in as messageParameter gets translated before being added as constraint violation... see CustomNotBlank in the sample application.  The other option is to have unique error message for each attribute on the form that is being validated.  There are few ways to override the default messages by placing enteries in the project's version of ValidationMessages.properties
    1) override default message with an entry like this: javax.validation.constraints.NotNull.message    This entry will override the message associated to @NotNull constraint. 
    2) Add entry for contraint, form and attribute or constraint and attribute like this:
        -- NotNull.employeeForm.lastName=Last Name required.
        -- NotNull.lastName=Last Name required.
    3) Pass in key to error message on the constraint itself
        -- @NotNull(message="{is.required}") or @NotNull(message="{label.last.name} {is.required}")
        and have entries in ValidationMessages.properties for label.last.name and is.required








