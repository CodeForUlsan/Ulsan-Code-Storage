package com.vending.display;

/*
버전관리 로그
!!!변경후에는 반드시 로그를 수정해주십시오!!!
로그 규칙 - 앞에는 수정한 날자가 들어갑니다. 날자뒤에 붙는 Revision은 해당일 첫번째 판올림의 경우 숫자 1을 두번째일 경우엔 숫자 2를 붙여주시면 됩니다.
ex)2018년 12월 21일 첫번째 개정판 - 2018.12.21.Revision1, 2018년 12월 21일 두번째 개정판 - 2018.12.21.Revision2
2018.12.21.Revision1
*/

public class VendingDisplayProc {
	// 자판기에서 판매하는 상품이 어떤종류가 있는지와 현재 자판기에 투입된 잔액이 얼마인지 화면에 표시해주는 메소드
	public void menuDisplay(String[] drink, int[] drinkStock, int[] drinkPrice, int payStock)
	{
		lineDisplay();
		for(int i = 0; i < drink.length; i++)
		{
			System.out.print(drink[i]);
			if(drink[i].length() < 5)
			{
				System.out.print("\t\t가격 : ");
			}
			else
			{
				System.out.print("\t가격 : ");
			}
			System.out.print(drinkPrice[i] + "원\t");
			if(drinkStock[i]==0)
			{
				System.out.println("품절");
			}
			else
			{
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("\t\t현재의 금액 : " + payStock);
		lineDisplay();
	}
	
	// 사용자가 구매하는 음료의 종류를 앞에 각 상품별로 번호를 붙여 출력하는 메소드	
	public void purchaseMenuDisplay(String[] drink, int[] drinkPrice, int[] drinkStock, int payStock)
	{
		for(int i = 0; i < 51; i++)
		{
			System.out.print("-");
		}
		System.out.println();
		for(int i = 0; i < drink.length; i++)
		{
			System.out.print((i+1) + ". " + drink[i] + "       \t가격 : " + drinkPrice[i] + "원\t");
			if(drinkStock[i]==0)
			{
				System.out.println("품절");
			}
			else
			{
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("\t\t현재의 금액 : " + payStock);				
		for(int i = 0; i < 51; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
	
	// 화면을 깔끔하게 보이기 위한 메소드
	public void clearScreen()
	{
		for(int i = 0; i < 70; i++)
		{
			System.out.println("");
		}
	}
	
	// 화면에 점선을 표시할 메소드
	public void lineDisplay()
	{
		for(int i = 0; i < 51; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
}