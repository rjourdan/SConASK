package com.riverbed.sconask.beans;

public class SconApp extends SconObject {

	private String desc;
	private String dgrp;
	


	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}



	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}



	/**
	 * @return the dgrp
	 */
	public String getDgrp() {
		return dgrp;
	}



	/**
	 * @param dgrp the dgrp to set
	 */
	public void setDgrp(String dgrp) {
		this.dgrp = dgrp;
	}



	public SconApp() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param desc
	 * @param dgrp
	 */
	public SconApp(String desc, String dgrp) {
		super();
		this.desc = desc;
		this.dgrp = dgrp;
	}

	/**
	 * 
	 * @param id
	 * @param desc
	 * @param dgrp
	 */
	public SconApp(String id,String desc, String dgrp) {
		super();
		this.setId(id);
		this.desc = desc;
		this.dgrp = dgrp;
	}

	/**
	 * 
	 * @param id
	 * @param desc
	 * @param dgrp
	 * @param name
	 */
	public SconApp(String id,String desc, String dgrp,String name) {
		super();
		this.setId(id);
		this.desc = desc;
		this.dgrp = dgrp;
		this.setName(name);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SconApp [desc=" + desc + ", dgrp=" + dgrp + "name="+this.getName()+"]";
	}

	
	
}
