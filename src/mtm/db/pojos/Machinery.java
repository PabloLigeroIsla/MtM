package mtm.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class Machinery implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5250802350308545128L;
	private String machineryType;
	private String stateofMachinery;
	private Date dateofInstallation;
	private int sizeofMachinery;

	private List<Instrument> instrumentList;

	public String getMachineryType() {
		return machineryType;
	}

	public void setMachineryType(String machineryType) {
		this.machineryType = machineryType;
	}

	public String getStateofMachinery() {
		return stateofMachinery;
	}

	public void setStateofMachinery(String stateofMachinery) {
		this.stateofMachinery = stateofMachinery;
	}

	public Date getDateofInstallation() {
		return dateofInstallation;
	}

	public void setDateofInstallation(Date dateofInstallation) {
		this.dateofInstallation = dateofInstallation;
	}

	public int getSizeofMachinery() {
		return sizeofMachinery;
	}

	public void setSizeofMachinery(int sizeofMachinery) {
		this.sizeofMachinery = sizeofMachinery;
	}

	public List<Instrument> getInstrumentList() {
		return instrumentList;
	}

	public void setInstrumentList(List<Instrument> instrumentList) {
		this.instrumentList = instrumentList;
	}

	public Machinery() {
		super();
		this.instrumentList = new ArrayList<Instrument>();
	}

	public Machinery(String machineryType, String stateofMachinery, Date dateofInstallation, int sizeofMachinery) {
		super();
		this.machineryType = machineryType;
		this.stateofMachinery = stateofMachinery;
		this.dateofInstallation = dateofInstallation;
		this.sizeofMachinery = sizeofMachinery;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((machineryType == null) ? 0 : machineryType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Machinery other = (Machinery) obj;
		if (machineryType == null) {
			if (other.machineryType != null)
				return false;
		} else if (!machineryType.equals(other.machineryType))
			return false;
		return true;
	}

}
