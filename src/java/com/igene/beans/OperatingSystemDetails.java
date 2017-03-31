/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igene.beans;

/**
 *
 * @author Bhuvan
 */
public class OperatingSystemDetails
{
    private String operatingSystemName;
    private String osImagePath;
    private boolean selected;

    /**
     * @return the operatingSystemName
     */
    public String getOperatingSystemName()
    {
        return operatingSystemName;
    }

    /**
     * @param operatingSystemName the operatingSystemName to set
     */
    public void setOperatingSystemName(String operatingSystemName)
    {
        this.operatingSystemName = operatingSystemName;
    }

    /**
     * @return the osImagePath
     */
    public String getOsImagePath()
    {
        return osImagePath;
    }

    /**
     * @param osImagePath the osImagePath to set
     */
    public void setOsImagePath(String osImagePath)
    {
        this.osImagePath = osImagePath;
    }

    /**
     * @return the selected
     */
    public boolean isSelected()
    {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected)
    {
        this.selected = selected;
    }
}
