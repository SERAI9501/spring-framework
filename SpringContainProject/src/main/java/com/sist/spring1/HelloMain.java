package com.sist.spring1;
/*
 *  HelloMain�� Hello�� �����Ѵ� => ���ռ��� ���� ���α׷� = �����ÿ� �ٸ� Ŭ������ ������ ���� ���
 *                               ----------------
 *                               =���������� ��ƴ�
 *  �������̸�  => new�� ������� �ʾƾ� �Ѵ�.
 *              ---- ����Ѵٸ�? ���ռ��� ��������.                             
 *  
 *  => ���ռ��� ���� ���α׷� ����
 *  => ---------------- ���̳� => ��ǥ�� (�ε�����)
 *                                    ------- Open Source �� ����
 *                                            -----------
 *                                            spring.io ���� �޾��ش�
 *                                            ---------
 *                                             2.5�������� �����ߴ�
 *   ������ / ������� => ����� <= ������ ����� �ٽδ�.
 *                                  ---------- ������ ���� (����)
 *  
 */
public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello hello=new Hello();
		String msg=hello.seyHello("ȫ�浿");
		System.out.println(msg);
	}

}
