package com.kiri.calculatormm;

import java.util.HashMap;
import java.util.LinkedList;

import com.kiri.calculatormm.core.CalculatorCore;
import com.kiri.calculatormm.core.CalculatorInitializer;
import com.kiri.calculatormm.structure.BasicObject;

public class HowToUse {
	
	public static void main(String[] args) {
		System.out.println("How to use?");
		System.out.println("Use CalculatorMM to get a simple shell!");

		System.out.println("Basic calculation like input :");
		String basicExp = "(+ 5 (- 6 8) (* 5 2 (/ 7 3) (- 3)))";
		System.out.println(basicExp);
		LinkedList<HashMap<String, BasicObject>> envStack = CalculatorInitializer.initEnv();
		System.out.println("Exp is: 5 + (6-8) + 5*2*(7/3)*(-3)");
		System.out.println("Result: " + CalculatorCore.eval(basicExp, envStack));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("Define function input:");
		String funcTest1 = "(define test1 (lambda (x y) (+ (pow x 2) (pow y 3))))";
		System.out.println(funcTest1);
		CalculatorCore.eval(funcTest1,envStack); 
		System.out.println("Use function input:");
		String execTest1 = "(test1 5 3)";
		System.out.println(execTest1);
		System.out.println("This means define test1(x,y)=x^2+y^3 and use it to eval test1(5, 3)");
		System.out.println("Result: " +  CalculatorCore.eval(execTest1, envStack));
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("Use integral and derivative :");
		String execTest2 = "(integral test1 0 3 (lambda (x) 0) (lambda (x) (pow x 2)))";
		System.out.println("integral : \n" + execTest2);
		System.out.println("This means integral test1 from x:(0,3) y:(0, x^2)....(this takes a bit time!)");
		System.out.println("Result: " + CalculatorCore.eval(execTest2, envStack));
		String execTest3 = "(derivative test1 3 4 1 1)";
		System.out.println("Use derivative input:\n" + execTest3);
		System.out.println("This means eval directional derivative at (3,4) with direction (1, 1)");
		System.out.println("Result: " + CalculatorCore.eval(execTest3, envStack));
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("U can also use some special functions ^_^~");
		System.out.println("hint: use ' \\' and the end to input a next line");
		String execTest4 = "( define fib-iter (lambda (p q n)" + 
								" (if (= n 0) " + 
									"p " + 
									" (if (= n 1) q (fib-iter q (+ p q) (- n 1))))))";
		CalculatorCore.eval(execTest4, envStack);
		String execTest5 = "(define fib (lambda (n) (fib-iter 0 1 n)))";
		CalculatorCore.eval(execTest5, envStack);
		String execTest6 = "(fib 8)";
		System.out.println("Input : " + execTest4 + "\n" + execTest5);
		System.out.println("Now eval fib(8):\n" + execTest6);
		System.out.println("Result :" + CalculatorCore.eval(execTest6, envStack));
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Use a data structure!");
		String execTest7 = "(define l (list 1 test1 3 4))";
		System.out.println(execTest7);
		CalculatorCore.eval(execTest7, envStack);
		System.out.println("now l is : " + CalculatorCore.eval("l", envStack));
		String execTest8 = " (car (cdr l))";
		System.out.println("Get the second node from the linear table");
		System.out.println(execTest8);
		System.out.println("Result : " + CalculatorCore.eval(execTest8, envStack));
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("At last ->_<-");
		String execTest9 = "(define stringFunc \"(test1 2 5)\" )";
		System.out.println("Use a string data and eval it:");
		System.out.println(execTest9);
		CalculatorCore.eval(execTest9, envStack);
		System.out.println("now stringFunc is:\n" + CalculatorCore.eval("stringFunc", envStack));
		String execTest10 = "(eval stringFunc)";
		System.out.println(execTest10);
		System.out.println("Result : " + CalculatorCore.eval(execTest10, envStack));
		
		String execTest11 = "(apply test1 (cdr (cdr l)))";
		System.out.println("Apply the function with a list args:");
		System.out.println(execTest11);
		System.out.println("Result : " + CalculatorCore.eval(execTest11, envStack));
		System.out.println("Other basic functions can be found at initializer source!");
		System.out.println("GoodBye!");
		
	}

}
