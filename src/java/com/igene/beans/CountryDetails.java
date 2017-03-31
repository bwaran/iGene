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
public class CountryDetails
{
    private String countryName;
    private String flagPath;
    private boolean selected;

    /**
     * @return the countryName
     */
    public String getCountryName()
    {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }

    /**
     * @return the flagPath
     */
    public String getFlagPath()
    {
        return flagPath;
    }

    /**
     * @param flagPath the flagPath to set
     */
    public void setFlagPath(String flagPath)
    {
        this.flagPath = flagPath;
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
