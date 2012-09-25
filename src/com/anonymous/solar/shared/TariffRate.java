package com.anonymous.solar.shared;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
/**
 * <p>Java class for tariffRate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tariffRate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tariff11Cost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tariff11Fee" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tariff33Cost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tariff33Fee" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tariffFeedIn" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tariffProvider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tariffState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tariffRate", propOrder = {
	"key",
    "tariff11Cost",
    "tariff11Fee",
    "tariff33Cost",
    "tariff33Fee",
    "tariffFeedIn",
    "tariffProvider",
    "tariffState"
})
@PersistenceCapable
public class TariffRate {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;
	
	@Persistent
	String tariffProvider;
	
	@Persistent
	String tariffState;
	
	@Persistent
	Double tariffFeedIn;
	
	@Persistent
	Double tariff11Cost;

	@Persistent
	Double tariff33Cost;
	
	@Persistent
	Double tariff11Fee;
	
	@Persistent
	Double tariff33Fee;
	
	public static final String TARIFF_11_COST = "tariff11Cost";
	public static final String TARIFF_33_COST = "tariff33Cost";
	public static final String TARIFF_11_FEE = "tariff11Fee";
	public static final String TARIFF_33_FEE = "tariff33Fee";
	public static final String TARIFF_FEE_IN = "tariffFeedIn";
	public static final String TARIFF_STATE = "tariffState";
	public static final String TARIFF_PROVIDER = "tariffProvider";
			
	
	public TariffRate(){
		this.tariffProvider = new String();
		this.tariffState = new String();
		this.tariffFeedIn = 0.0;
		this.tariff11Cost = 0.0;
		this.tariff11Fee = 0.0;
		this.tariff33Cost = 0.0;
		this.tariff33Fee = 0.0;
	}
	
	public TariffRate(String provider, String state, Double feedIn, Double t11C, Double t11F, Double t33C,
			Double t33F){
		this.tariffProvider = provider;
		this.tariffState = state;
		this.tariffFeedIn = feedIn;
		this.tariff11Cost = t11C;
		this.tariff11Fee = t11F;
		this.tariff33Cost = t33C;
		this.tariff33Fee = t33C;
	}
	
	/****************************
	 * Getters
	 ****************************/
	
	public Long getKey() {
		return key;
	}
	
	/**
	 * Get the provider of the tariff
	 * @return tariff provider
	 */
	public String getTariffProvider(){
		return tariffProvider;
	}
	
	/**
	 * Get the state of the tariff data
	 * @return tarif State
	 */
	public String getTariffState(){
		return tariffState;
	}
	
	/**
	 * Get the cost of the fee in fee in cents
	 * @return feed in fee
	 */
	public Double getTariffFeedInFee(){
		return tariffFeedIn;
	}
	
	/**
	 * get the cost of tariff 11
	 * @return tariff 11 cost in cents
	 */
	public Double getTariff11Cost(){
		return tariff11Cost;
	}
	
	/**
	 * Get the tariff 11 fee in cents
	 * @return tariff 11 fee in cents
	 */
	public Double getTariff11Fee(){
		return tariff11Fee;
	}
	
	/**
	 * get the cost of tariff 33
	 * @return tariff 33 cost in cents
	 */
	public Double getTariff33Cost(){
		return tariff33Cost;
	}
	
	/**
	 * Get the tariff 33 fee in cents
	 * @return tariff 33 fee in cents
	 */
	public Double getTariff33Fee(){
		return tariff33Fee;
	}
	
	/****************************
	 * Setters
	 ****************************/
	
	/**
	 * Set the provider of the tariff rate
	 * @param provider - company that provides the electricity
	 * @throws TariffRateException
	 */
	public void setTariffProvider(String provider) throws TariffRateException{
		if(provider == null || provider.compareTo("") == 0){
			throw new TariffRateException();
		}
		this.tariffProvider = provider;
	}
	
	/**
	 * Set the state the tariff is for
	 * @param state - location of the tariff (NSW, QLD, VIC...)
	 * @throws TariffRateException
	 */
	public void setTariffState(String state) throws TariffRateException{
		if(state == null || state.compareTo("") == 0){
			throw new TariffRateException();
		}
		
		
		this.tariffState = state;
	}
	
	/**
	 * Set the rate/kwh for feeding in power
	 * @param feedInFee - c/kWh for feeding in power
	 * @throws TariffRateException
	 */
	public void setTariffFeedInFee(Double feedInFee) throws TariffRateException{
		
		if(feedInFee == null || feedInFee < 0){
			throw new TariffRateException();
		}
		this.tariffFeedIn = feedInFee;
	}
	
	/**
	 * Set the cost per kwh for tariff 11
	 * @param t11C - cost of kwh in cents
	 * @throws TariffRateException
	 */
	public void setTariff11Cost(Double t11C) throws TariffRateException{
		if(t11C == null || t11C < 0){
			throw new TariffRateException();
		}
		this.tariff11Cost = t11C;
	}
	
	/**
	 * Fee per day in cents for tariff 11
	 * @param t11F - fee of day in cents
	 * @throws TariffRateException
	 */
	public void setTariff11Fee(Double t11F) throws TariffRateException{
		if(t11F == null || t11F < 0){
			throw new TariffRateException();
		}
		this.tariff11Fee = t11F;
	}
	
	/**
	 * Set the cost per kwh for tariff 33
	 * @param t13C - cost of kwh in cents
	 * @throws TariffRateException
	 */
	public void setTariff33Cost(Double t33C) throws TariffRateException{
		if(t33C == null || t33C < 0){
			throw new TariffRateException();
		}
		this.tariff33Cost = t33C;
	}
	
	/**
	 * Fee per day in cents for tariff 33
	 * @param t33F - fee of day in cents
	 * @throws TariffRateException
	 */
	public void setTariff33Fee(Double t33F) throws TariffRateException{
		if(t33F == null || t33F < 0){
			throw new TariffRateException();
		}
		this.tariff33Fee = t33F;
	}
}
