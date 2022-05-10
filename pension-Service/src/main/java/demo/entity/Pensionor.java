package demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Pensionor_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class  Pensionor{
    @Id
    private int aadhaarNumber;
    private String name;
    private double pensionAmount;
    
	public int getAadhaarNumber() {
		return aadhaarNumber;
	}
	public void setAadhaarNumber(int aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPensionAmount() {
		return pensionAmount;
	}
	public void setPensionAmount(double pensionAmount) {
		this.pensionAmount = pensionAmount;
	}
	

}
