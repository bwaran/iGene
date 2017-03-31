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
public class SystemDetails
{
    private PriceDetails priceDetails;
    
    private boolean privateNetworking;
    private boolean backupRequired;
    private boolean tOUseIPV6;
    private boolean userData;
    private boolean toMonitor;
    
    private boolean personalSSHKey;

    private String operatingSystem;
    private String hostName;
    private String region;

    /**
     * @return the priceDetails
     */
    public PriceDetails getPriceDetails()
    {
        return priceDetails;
    }

    /**
     * @param priceDetails the priceDetails to set
     */
    public void setPriceDetails(PriceDetails priceDetails)
    {
        this.priceDetails = priceDetails;
    }

    /**
     * @return the privateNetworking
     */
    public boolean isPrivateNetworking()
    {
        return privateNetworking;
    }

    /**
     * @param privateNetworking the privateNetworking to set
     */
    public void setPrivateNetworking(boolean privateNetworking)
    {
        this.privateNetworking = privateNetworking;
    }

    /**
     * @return the backupRequired
     */
    public boolean isBackupRequired()
    {
        return backupRequired;
    }

    /**
     * @param backupRequired the backupRequired to set
     */
    public void setBackupRequired(boolean backupRequired)
    {
        this.backupRequired = backupRequired;
    }

    /**
     * @return the tOUseIPV6
     */
    public boolean istOUseIPV6()
    {
        return tOUseIPV6;
    }

    /**
     * @param tOUseIPV6 the tOUseIPV6 to set
     */
    public void settOUseIPV6(boolean tOUseIPV6)
    {
        this.tOUseIPV6 = tOUseIPV6;
    }

    /**
     * @return the userData
     */
    public boolean isUserData()
    {
        return userData;
    }

    /**
     * @param userData the userData to set
     */
    public void setUserData(boolean userData)
    {
        this.userData = userData;
    }

    /**
     * @return the toMonitor
     */
    public boolean isToMonitor()
    {
        return toMonitor;
    }

    /**
     * @param toMonitor the toMonitor to set
     */
    public void setToMonitor(boolean toMonitor)
    {
        this.toMonitor = toMonitor;
    }

    /**
     * @return the personalSSHKey
     */
    public boolean isPersonalSSHKey()
    {
        return personalSSHKey;
    }

    /**
     * @param personalSSHKey the personalSSHKey to set
     */
    public void setPersonalSSHKey(boolean personalSSHKey)
    {
        this.personalSSHKey = personalSSHKey;
    }

    /**
     * @return the hostName
     */
    public String getHostName()
    {
        return hostName;
    }

    /**
     * @param hostName the hostName to set
     */
    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }

    /**
     * @return the region
     */
    public String getRegion()
    {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region)
    {
        this.region = region;
    }

    /**
     * @return the operatingSystem
     */
    public String getOperatingSystem()
    {
        return operatingSystem;
    }

    /**
     * @param operatingSystem the operatingSystem to set
     */
    public void setOperatingSystem(String operatingSystem)
    {
        this.operatingSystem = operatingSystem;
    }
}
