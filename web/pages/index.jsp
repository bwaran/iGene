<%-- 
    Document   : index
    Created on : Mar 30, 2017, 9:21:23 PM
    Author     : Bhuvan
--%>

<%@taglib prefix="p" uri="http://richfaces.org/rich" %>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<f:view>
    <f:verbatim>
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Home</title>
                <style>
                    .centerClass{text-align:center;}
                </style>
            </head>
            <body>
            </f:verbatim>
            <h:form binding="#{StartUP.initForm}">
                <p:panel id="mainPanelId">
                    <f:verbatim><center></f:verbatim> 
                    <h:panelGrid columns="1">
                        <h:outputLabel value="Choose a datacenter region"/>
                        <p:dataGrid value="#{StartUP.countryList}" var="country" columns="4" rowKeyVar="index">
                            <h:panelGrid columns="1" rowClasses=",centerClass" style="#{country.selected ? 'border:2px solid blue;' :''}">
                                <a4j:commandLink  action="#{StartUP.selectedRegionButtonAction(index)}" reRender="mainPanelId">
                                    <h:graphicImage url="#{country.flagPath}" style="height:70px;width:100px;" />
                                </a4j:commandLink>
                                <h:outputLabel value="#{country.countryName}"/>
                            </h:panelGrid>
                        </p:dataGrid>

                        <p:spacer height="20"/>

                        <h:outputLabel value="Select additional option"/>
                        <h:panelGrid columns="10">
                            <h:selectBooleanCheckbox value="#{StartUP.privateNetworking}" label="Private Networking">
                                <a4j:support reRender="mainPanelId" event="onchange"/>
                            </h:selectBooleanCheckbox>
                            <h:outputLabel value="Private Networking"/>

                            <h:selectBooleanCheckbox value="#{StartUP.backupRequired}" label="Backup">
                                <a4j:support reRender="mainPanelId" event="onchange"/>
                            </h:selectBooleanCheckbox>
                            <h:outputLabel value="Backup"/>

                            <h:selectBooleanCheckbox value="#{StartUP.userData}"  label="User Data">
                                <a4j:support reRender="mainPanelId" event="onchange"/>
                            </h:selectBooleanCheckbox>
                            <h:outputLabel value="User Data"/>

                            <h:selectBooleanCheckbox value="#{StartUP.toMonitor}" label="Monitoring">
                                <a4j:support reRender="mainPanelId" event="onchange"/>
                            </h:selectBooleanCheckbox>
                            <h:outputLabel value="Monitoring"/>
                        </h:panelGrid>

                        <p:spacer height="20"/>

                        <h:outputLabel value="Choose a hostname"/>
                        <h:inputText value="#{StartUP.hostName}"/>

                        <p:spacer height="20"/>

                        <h:outputLabel value="Choose an image"/>
                        <p:dataGrid value="#{StartUP.operatingSystemList}" var="image" columns="3" rowKeyVar="index">
                            <h:panelGrid columns="1" rowClasses=",centerClass" style="#{image.selected ? 'border:2px solid blue;' :''}">
                                <a4j:commandButton image="#{image.osImagePath}" style="height:70px;width:100px;" 
                                                   action="#{StartUP.selectedImageButtonAction(index)}" reRender="mainPanelId">
                                    <a4j:actionparam value="#{index}" assignTo="#{StartUP.selectedImageIndex}"/>
                                </a4j:commandButton>
                                <h:outputLabel value="#{image.operatingSystemName}"/>
                            </h:panelGrid>
                        </p:dataGrid>

                        <p:spacer height="20"/>

                        <h:outputLabel value="Choose a size"/>
                        <p:dataGrid id="priceListDataGridId" value="#{StartUP.priceList}" var="size" columns="3" rowKeyVar="index" cellpadding="3" cellspacing="3">
                            <h:panelGrid columns="1" rowClasses="centerClass,centerClass" onclick="selectSystem#{index}()" border="1" 
                                         style="#{size.selected ? 'border:2px solid blue;' :''}">
                                <h:outputLabel value="#{size.cost}"/>
                                <h:panelGrid columns="1" rowClasses=",centerClass">
                                    <h:outputLabel value="#{size.cpu}"/>
                                    <h:outputLabel value="#{size.ramSpeed} RAM"/>
                                    <h:outputLabel value="#{size.diskStorage} SSD"/>
                                    <h:outputLabel value="#{size.transferMemory} TRANSFER"/>
                                </h:panelGrid>
                            </h:panelGrid>
                            <a4j:jsFunction name="selectSystem#{index}" action="#{StartUP.selectOperatingSystemAction(index)}" reRender="mainPanelId">
                            </a4j:jsFunction>
                        </p:dataGrid>

                        <p:spacer height="20"/>

                        <a4j:commandButton value="Create"
                                           action="#{StartUP.createButtonAction}" reRender="mainPanelId">
                        </a4j:commandButton>

                        <p:spacer height="20"/>
                        <h:outputLabel value="Droplets"/>
                        <p:dataTable var="detail" value="#{StartUP.systemDetailsList}" rowKeyVar="index">
                            <f:facet name="header">
                                <p:columnGroup>
                                    <p:column>
                                        <h:outputText value="Host Name" />
                                    </p:column>
                                    <p:column>
                                        <h:outputText value="Data Center" />
                                    </p:column>
                                    <p:column>
                                        <h:outputText value="Operating System" />
                                    </p:column>
                                    <p:column>
                                        <h:outputText value="System Detail" />
                                    </p:column>
                                </p:columnGroup>
                            </f:facet>
                            <p:column>
                                <h:outputText value="#{detail.hostName}" />
                            </p:column>
                            <p:column>
                                <h:outputText value="#{detail.region}" />
                            </p:column>
                            <p:column>
                                <h:outputText value="#{detail.operatingSystem}" />
                            </p:column>
                            <p:column>
                                <a4j:commandLink value="Click to see system details" action="#{StartUP.viewSystemDetailsAction(index)}"
                                                 reRender="mainPanelId,viewDetailsmdlod" oncomplete="Richfaces.showModalPanel('viewDetailsmdlod');"/>
                            </p:column>
                        </p:dataTable>
                    </h:panelGrid>
                    <f:verbatim></center></f:verbatim> 
                </p:panel>


            <p:modalPanel id="viewDetailsmdlod">
                <f:facet name="header">
                    <h:outputLabel value="Detail"/>
                </f:facet>
                <h:panelGrid columns="1">
                    <h:outputLabel value="Cost : #{StartUP.priceDetails.cost}"/>
                    <h:outputLabel value="CPU : #{StartUP.priceDetails.cpu}"/>
                    <h:outputLabel value="RAM : #{StartUP.priceDetails.ramSpeed}"/>
                    <h:outputLabel value="SSD : #{StartUP.priceDetails.diskStorage}"/>
                    <h:outputLabel value="TRANSFER : #{StartUP.priceDetails.transferMemory}"/>
                </h:panelGrid>

                <a4j:commandButton onclick="Richfaces.hideModalPanel('viewDetailsmdlod');" value="close"  reRender="viewDetailsmdlod">
                </a4j:commandButton>
            </p:modalPanel>
        </h:form>
        <f:verbatim>
        </body>
    </html></f:verbatim>
</f:view>