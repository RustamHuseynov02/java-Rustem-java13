package az.developia.springjava13.component;

import org.springframework.stereotype.Component;

@Component
public class Ram {
	private Integer memory;
	private String mhz;

	public Ram() {
		this.memory = 8;
		this.mhz = "5000mhz";
	}

	public Integer getMemory() {
		return memory;
	}

	public void setMemory(Integer memory) {
		this.memory = memory;
	}

	public String getMhz() {
		return mhz;
	}

	public void setMhz(String mhz) {
		this.mhz = mhz;
	}

}
