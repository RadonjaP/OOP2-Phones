package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PHONE database table.
 * 
 */
@Entity
@NamedQuery(name="Phone.findAll", query="SELECT p FROM Phone p")
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="BATTERY_CAPACITY")
	private int batteryCapacity;

	@Column(name="CPU_SPEED")
	private double cpuSpeed;

	private double height;

	private int memory;

	private String model;

	@Column(name="OPERATING_SYSTEM")
	private String operatingSystem;

	@Column(name="PICTURE_ADDRESS")
	private String pictureAddress;

	private int price;

	private String producer;

	@Column(name="RESOLUTION_X")
	private int resolutionX;

	@Column(name="RESOLUTION_Y")
	private int resolutionY;

	private double weight;

	private double width;

	public Phone() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBatteryCapacity() {
		return this.batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public double getCpuSpeed() {
		return this.cpuSpeed;
	}

	public void setCpuSpeed(double cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getMemory() {
		return this.memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOperatingSystem() {
		return this.operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getPictureAddress() {
		return this.pictureAddress;
	}

	public void setPictureAddress(String pictureAddress) {
		this.pictureAddress = pictureAddress;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProducer() {
		return this.producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getResolutionX() {
		return this.resolutionX;
	}

	public void setResolutionX(int resolutionX) {
		this.resolutionX = resolutionX;
	}

	public int getResolutionY() {
		return this.resolutionY;
	}

	public void setResolutionY(int resolutionY) {
		this.resolutionY = resolutionY;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWidth() {
		return this.width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

}