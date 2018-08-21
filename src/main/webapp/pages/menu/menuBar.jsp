<%--
    Menu bar
--%>
<%@ taglib uri="http://struts-menu.sf.net/tag" prefix="menu" %>
<%@ taglib uri="http://struts-menu.sf.net/tag-el" prefix="menu-el" %>
<a name="menu"></a>
<div id="menudiv" >
    <menu:useMenuDisplayer name="ListMenu" id="nav">
        <menu:displayMenu name="web"></menu:displayMenu>
        <menu:displayMenu name="stuff"></menu:displayMenu>
    </menu:useMenuDisplayer>
</div>