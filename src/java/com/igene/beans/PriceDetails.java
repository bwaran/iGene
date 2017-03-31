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
public class PriceDetails
{
    private String cost;
    private String cpu;
    private String ramSpeed;
    private String diskStorage;
    private String transferMemory;
    private boolean selected;

    /**
     * @return the cost
     */
    public String getCost()
    {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(String cost)
    {
        this.cost = cost;
    }

    /**
     * @return the cpu
     */
    public String getCpu()
    {
        return cpu;
    }

    /**
     * @param cpu the cpu to set
     */
    public void setCpu(String cpu)
    {
        this.cpu = cpu;
    }

    /**
     * @return the ramSpeed
     */
    public String getRamSpeed()
    {
        return ramSpeed;
    }

    /**
     * @param ramSpeed the ramSpeed to set
     */
    public void setRamSpeed(String ramSpeed)
    {
        this.ramSpeed = ramSpeed;
    }

    /**
     * @return the diskStorage
     */
    public String getDiskStorage()
    {
        return diskStorage;
    }

    /**
     * @param diskStorage the diskStorage to set
     */
    public void setDiskStorage(String diskStorage)
    {
        this.diskStorage = diskStorage;
    }

    /**
     * @return the transferMemory
     */
    public String getTransferMemory()
    {
        return transferMemory;
    }

    /**
     * @param transferMemory the transferMemory to set
     */
    public void setTransferMemory(String transferMemory)
    {
        this.transferMemory = transferMemory;
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
