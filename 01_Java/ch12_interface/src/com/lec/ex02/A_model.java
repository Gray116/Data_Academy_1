package com.lec.ex02;

public class A_model implements IAcor {
	private String model = "A 모델";

	@Override
	public void dmbReceive() {
		System.out.println(model + "은 DMB 송수신 가능합니다.");
	}

	@Override
	public void lte() {
		System.out.println(model + "은 5G입니다.");
	}

	@Override
	public void tvremotecontrol() {
		System.out.println(model + "은 TV 리모콘이 탑재 되어있습니다.");
		System.out.println();
	}
}