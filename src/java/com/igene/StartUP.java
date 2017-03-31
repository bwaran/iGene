/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igene;

import com.igene.beans.CountryDetails;
import com.igene.beans.OperatingSystemDetails;
import com.igene.beans.PriceDetails;
import com.igene.beans.SystemDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bhuvan
 */
public class StartUP
{

    public StartUP()
    {
    }

    private HtmlForm initForm;

    private List<PriceDetails> priceList = null;
    private List<CountryDetails> countryList = null;
    private List<OperatingSystemDetails> operatingSystemList = null;
    private List<SystemDetails> systemDetailsList = null;

    private SystemDetails systemDetails = null;
    private PriceDetails priceDetails  = null;

    private boolean privateNetworking;
    private boolean backupRequired;
    private boolean userData;
    private boolean toMonitor;

    private boolean personalSSHKey;

    private boolean showSSHKeyMessageBox;

    private String sshKey;
    private String hostName;
    private String selectedCountryName;
    private String operatingSystemName;

    private int selectedRegionIndex;
    private int selectedImageIndex;
    private int selectedPriceIndex;

    private Logger log = Logger.getLogger(this.getClass().getPackage().getName());

    public String sshKeyButtonAction()
    {
        showSSHKeyMessageBox = true;
        return null;
    }

    public String sshKeyMessageBoxOkAction()
    {
        return null;
    }

    public String nextButtonAction()
    {

        return null;
    }

    public String createButtonAction()
    {
        systemDetails = new SystemDetails();
        systemDetails.setHostName(hostName);
        systemDetails.setRegion(selectedCountryName);
        systemDetails.setOperatingSystem(operatingSystemName);
        systemDetails.setBackupRequired(backupRequired);
        systemDetails.setPrivateNetworking(privateNetworking);
        systemDetails.setToMonitor(toMonitor);
        systemDetails.setUserData(userData);
        systemDetails.setPriceDetails(priceList.get(selectedPriceIndex));

        getSystemDetailsList().add(systemDetails);
        return null;
    }

    public String selectedRegionButtonAction(int index)
    {
        for (CountryDetails details : countryList)
        {
            details.setSelected(false);
        }
        selectedCountryName = countryList.get(index).getCountryName();
        countryList.get(index).setSelected(true);
        return null;
    }

    public String selectedImageButtonAction(int index)
    {
        for (OperatingSystemDetails details : operatingSystemList)
        {
            details.setSelected(false);
        }
        setOperatingSystemName(operatingSystemList.get(index).getOperatingSystemName());
        operatingSystemList.get(index).setSelected(true);
        System.out.println("selected Country Name :" + countryList.get(index).getCountryName());
        return null;
    }

    public String selectOperatingSystemAction(int index)
    {
        System.out.println("selected Country Name :" + priceList.get(index).getCost());

        for (PriceDetails details : priceList)
        {
            details.setSelected(false);
        }

        selectedPriceIndex = index;
        priceList.get(selectedPriceIndex).setSelected(true);
        return null;
    }
    
    public String viewSystemDetailsAction(int index)
    {
        System.out.println("selected Country Name :" + priceList.get(index).getCost());

         setPriceDetails(systemDetailsList.get(index).getPriceDetails());
        return null;
    }

    /**
     * @return the initForm
     */
    public HtmlForm getInitForm()
    {
        initPageValues();
        return initForm;
    }

    private void initPageValues()
    {
        populateCountryList();
        populateOperatingSystemList();
        populatePriceDetailsList();

        systemDetailsList = new ArrayList<>();

        systemDetails = null;

        privateNetworking = false;
        backupRequired = false;
        userData = false;
        toMonitor = false;
        personalSSHKey = false;
        showSSHKeyMessageBox = false;
    }

    private void populateCountryList()
    {
        countryList = new ArrayList<>();
        CountryDetails country = new CountryDetails();
        country.setCountryName("New york");
        country.setFlagPath("/faces/resources/images/newyork.png");
        getCountryList().add(country);

        country = new CountryDetails();
        country.setCountryName("San Francisco");
        country.setFlagPath("/faces/resources/images/newyork.png");
        getCountryList().add(country);

        country = new CountryDetails();
        country.setCountryName("Amsterdam");
        country.setFlagPath("/faces/resources/images/ams.png");
        getCountryList().add(country);

        country = new CountryDetails();
        country.setCountryName("Singapore");
        country.setFlagPath("/faces/resources/images/singapore.png");
        getCountryList().add(country);

        country = new CountryDetails();
        country.setCountryName("London");
        country.setFlagPath("/faces/resources/images/uk.png");
        getCountryList().add(country);

        country = new CountryDetails();
        country.setCountryName("Frankfrut");
        country.setFlagPath("/faces/resources/images/frank.png");
        getCountryList().add(country);

        country = new CountryDetails();
        country.setCountryName("Toronto");
        country.setFlagPath("/faces/resources/images/toronto.png");
        getCountryList().add(country);

        country = new CountryDetails();
        country.setCountryName("Bangalore");
        country.setFlagPath("/faces/resources/images/india.png");
        getCountryList().add(country);
    }

    private void populateOperatingSystemList()
    {
        operatingSystemList = new ArrayList<>();

        OperatingSystemDetails os = new OperatingSystemDetails();
        os.setOperatingSystemName("Ubuntu");
        os.setOsImagePath("/faces/resources/images/ubuntu.png");
        getOperatingSystemList().add(os);

        os = new OperatingSystemDetails();
        os.setOperatingSystemName("FreeBSD");
        os.setOsImagePath("/faces/resources/images/fbsd.png");
        getOperatingSystemList().add(os);

        os = new OperatingSystemDetails();
        os.setOperatingSystemName("Fedora");
        os.setOsImagePath("/faces/resources/images/fedora.png");
        getOperatingSystemList().add(os);

        os = new OperatingSystemDetails();
        os.setOperatingSystemName("Debian");
        os.setOsImagePath("/faces/resources/images/debian.png");
        getOperatingSystemList().add(os);

        os = new OperatingSystemDetails();
        os.setOperatingSystemName("CentOS");
        os.setOsImagePath("/faces/resources/images/centos.png");
        getOperatingSystemList().add(os);

        os = new OperatingSystemDetails();
        os.setOperatingSystemName("Windows Server");
        os.setOsImagePath("/faces/resources/images/windows.png");
        getOperatingSystemList().add(os);
    }

    private void populatePriceDetailsList()
    {
        priceList = new ArrayList<>();

        PriceDetails priceDetail = new PriceDetails();
        priceDetail.setCost("$5");
        priceDetail.setCpu("1 CPU");
        priceDetail.setRamSpeed("512 MB");
        priceDetail.setDiskStorage("20 GB");
        priceDetail.setTransferMemory("10 GB");

        getPriceList().add(priceDetail);

        priceDetail = new PriceDetails();
        priceDetail.setCost("$10");
        priceDetail.setCpu("2 CPU");
        priceDetail.setRamSpeed("1 GB");
        priceDetail.setDiskStorage("40 GB");
        priceDetail.setTransferMemory("20 GB");

        getPriceList().add(priceDetail);

        priceDetail = new PriceDetails();
        priceDetail.setCost("$20");
        priceDetail.setCpu("3 CPU");
        priceDetail.setRamSpeed("2 GB");
        priceDetail.setDiskStorage("60 GB");
        priceDetail.setTransferMemory("30 GB");

        getPriceList().add(priceDetail);

        priceDetail = new PriceDetails();
        priceDetail.setCost("$40");
        priceDetail.setCpu("4 CPU");
        priceDetail.setRamSpeed("3 GB");
        priceDetail.setDiskStorage("80 GB");
        priceDetail.setTransferMemory("40 GB");

        getPriceList().add(priceDetail);

        priceDetail = new PriceDetails();
        priceDetail.setCost("$60");
        priceDetail.setCpu("5 CPU");
        priceDetail.setRamSpeed("4 GB");
        priceDetail.setDiskStorage("100 GB");
        priceDetail.setTransferMemory("50 GB");

        getPriceList().add(priceDetail);

        priceDetail = new PriceDetails();
        priceDetail.setCost("$80");
        priceDetail.setCpu("6 CPU");
        priceDetail.setRamSpeed("5 GB");
        priceDetail.setDiskStorage("120 GB");
        priceDetail.setTransferMemory("60 GB");

        getPriceList().add(priceDetail);
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
     * @return the showSSHKeyMessageBox
     */
    public boolean isShowSSHKeyMessageBox()
    {
        return showSSHKeyMessageBox;
    }

    /**
     * @param showSSHKeyMessageBox the showSSHKeyMessageBox to set
     */
    public void setShowSSHKeyMessageBox(boolean showSSHKeyMessageBox)
    {
        this.showSSHKeyMessageBox = showSSHKeyMessageBox;
    }

    /**
     * @return the sshKey
     */
    public String getSshKey()
    {
        return sshKey;
    }

    /**
     * @param sshKey the sshKey to set
     */
    public void setSshKey(String sshKey)
    {
        this.sshKey = sshKey;
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
     * @return the priceList
     */
    public List<PriceDetails> getPriceList()
    {
        return priceList;
    }

    /**
     * @param priceList the priceList to set
     */
    public void setPriceList(List<PriceDetails> priceList)
    {
        this.priceList = priceList;
    }

    /**
     * @return the countryList
     */
    public List<CountryDetails> getCountryList()
    {
        return countryList;
    }

    /**
     * @param countryList the countryList to set
     */
    public void setCountryList(List<CountryDetails> countryList)
    {
        this.countryList = countryList;
    }

    /**
     * @param initForm the initForm to set
     */
    public void setInitForm(HtmlForm initForm)
    {
        this.initForm = initForm;
    }

    /**
     * @return the selectedRegionIndex
     */
    public int getSelectedRegionIndex()
    {
        return selectedRegionIndex;
    }

    /**
     * @param selectedRegionIndex the selectedRegionIndex to set
     */
    public void setSelectedRegionIndex(int selectedRegionIndex)
    {
        this.selectedRegionIndex = selectedRegionIndex;
    }

    /**
     * @return the operatingSystemList
     */
    public List<OperatingSystemDetails> getOperatingSystemList()
    {
        return operatingSystemList;
    }

    /**
     * @param operatingSystemList the operatingSystemList to set
     */
    public void setOperatingSystemList(List<OperatingSystemDetails> operatingSystemList)
    {
        this.operatingSystemList = operatingSystemList;
    }

    /**
     * @return the selectedImageIndex
     */
    public int getSelectedImageIndex()
    {
        return selectedImageIndex;
    }

    /**
     * @param selectedImageIndex the selectedImageIndex to set
     */
    public void setSelectedImageIndex(int selectedImageIndex)
    {
        this.selectedImageIndex = selectedImageIndex;
    }

    /**
     * @return the selectedPriceIndex
     */
    public int getSelectedPriceIndex()
    {
        return selectedPriceIndex;
    }

    /**
     * @param selectedPriceIndex the selectedPriceIndex to set
     */
    public void setSelectedPriceIndex(int selectedPriceIndex)
    {
        this.selectedPriceIndex = selectedPriceIndex;
    }

    /**
     * @return the selectedCountryName
     */
    public String getSelectedCountryName()
    {
        return selectedCountryName;
    }

    /**
     * @param selectedCountryName the selectedCountryName to set
     */
    public void setSelectedCountryName(String selectedCountryName)
    {
        this.selectedCountryName = selectedCountryName;
    }

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
     * @return the systemDetailsList
     */
    public List<SystemDetails> getSystemDetailsList()
    {
        return systemDetailsList;
    }

    /**
     * @param systemDetailsList the systemDetailsList to set
     */
    public void setSystemDetailsList(List<SystemDetails> systemDetailsList)
    {
        this.systemDetailsList = systemDetailsList;
    }

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
}
