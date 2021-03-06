package kr.or.ddit.basic;

import java.io.Serializable;
import java.util.*;

public class Phone implements Serializable{
	  
	   /**
	 * 
	 */
	private static final long serialVersionUID = 5553955173299437584L;
	String name;
	   String add;
	   String tel;
	   public Phone() {

	   }

	   public Phone(String name, String tel, String add) {
	      super();
	      this.name = name;
	      this.add = add;
	      this.tel = tel;
	   }

	   @Override
	   public String toString() {
	      return " [이름=" + name + ", 주소=" + add + ", 전화번호=" + tel + "]";
	   }

	   

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public String getAdd() {
	      return add;
	   }

	   public void setAdd(String add) {
	      this.add = add;
	   }

	   public String getTel() {
	      return tel;
	   }

	   public void setTel(String tel) {
	      this.tel = tel;
	   }
	}
